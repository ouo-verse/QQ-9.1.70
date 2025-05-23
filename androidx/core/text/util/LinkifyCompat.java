package androidx.core.text.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LinkifyCompat {
    private static final String[] EMPTY_STRING = new String[0];
    private static final Comparator<LinkSpec> COMPARATOR = new Comparator<LinkSpec>() { // from class: androidx.core.text.util.LinkifyCompat.1
        @Override // java.util.Comparator
        public int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
            int i3;
            int i16;
            int i17 = linkSpec.start;
            int i18 = linkSpec2.start;
            if (i17 < i18) {
                return -1;
            }
            if (i17 <= i18 && (i3 = linkSpec.end) >= (i16 = linkSpec2.end)) {
                return i3 > i16 ? -1 : 0;
            }
            return 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface LinkifyMask {
    }

    LinkifyCompat() {
    }

    private static void addLinkMovementMethod(@NonNull TextView textView) {
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, int i3) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, i3);
        }
        if (i3 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i3 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i3 & 1) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i3 & 2) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i3 & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            if (linkSpec.frameworkAddedSpan == null) {
                applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
            }
        }
        return true;
    }

    private static void applyLink(String str, int i3, int i16, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i3, i16, 33);
    }

    private static String findAddress(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            return WebView.findAddress(str);
        }
        return FindAddress.findAddress(str);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = start;
                linkSpec.end = end;
                arrayList.add(linkSpec);
            }
        }
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int indexOf;
        String obj = spannable.toString();
        int i3 = 0;
        while (true) {
            try {
                String findAddress = findAddress(obj);
                if (findAddress != null && (indexOf = obj.indexOf(findAddress)) >= 0) {
                    LinkSpec linkSpec = new LinkSpec();
                    int length = findAddress.length() + indexOf;
                    linkSpec.start = indexOf + i3;
                    i3 += length;
                    linkSpec.end = i3;
                    obj = obj.substring(length);
                    try {
                        linkSpec.url = com.tencent.smtt.sdk.WebView.SCHEME_GEO + URLEncoder.encode(findAddress, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static String makeUrl(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable Linkify.TransformFilter transformFilter) {
        boolean z16;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int i3 = 0;
        while (true) {
            if (i3 < strArr.length) {
                String str2 = strArr[i3];
                if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                    String str3 = strArr[i3];
                    z16 = true;
                    if (!str.regionMatches(false, 0, str3, 0, str3.length())) {
                        str = strArr[i3] + str.substring(strArr[i3].length());
                    }
                } else {
                    i3++;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16 && strArr.length > 0) {
            return strArr[0] + str;
        }
        return str;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i3;
        int i16;
        int i17 = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i18 = 0; i18 < uRLSpanArr.length; i18++) {
            LinkSpec linkSpec = new LinkSpec();
            URLSpan uRLSpan = uRLSpanArr[i18];
            linkSpec.frameworkAddedSpan = uRLSpan;
            linkSpec.start = spannable.getSpanStart(uRLSpan);
            linkSpec.end = spannable.getSpanEnd(uRLSpanArr[i18]);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i17 < size - 1) {
            LinkSpec linkSpec2 = arrayList.get(i17);
            int i19 = i17 + 1;
            LinkSpec linkSpec3 = arrayList.get(i19);
            int i26 = linkSpec2.start;
            int i27 = linkSpec3.start;
            if (i26 <= i27 && (i3 = linkSpec2.end) > i27) {
                int i28 = linkSpec3.end;
                if (i28 <= i3 || i3 - i26 > i28 - i27) {
                    i16 = i19;
                } else if (i3 - i26 < i28 - i27) {
                    i16 = i17;
                } else {
                    i16 = -1;
                }
                if (i16 != -1) {
                    Object obj = arrayList.get(i16).frameworkAddedSpan;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i16);
                    size--;
                }
            }
            i17 = i19;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    public static boolean addLinks(@NonNull TextView textView, int i3) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(textView, i3);
        }
        if (i3 == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (!addLinks((Spannable) text, i3)) {
                return false;
            }
            addLinkMovementMethod(textView);
            return true;
        }
        SpannableString valueOf = SpannableString.valueOf(text);
        if (!addLinks(valueOf, i3)) {
            return false;
        }
        addLinkMovementMethod(textView);
        textView.setText(valueOf);
        return true;
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    @SuppressLint({"NewApi"})
    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str);
        }
        return addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter);
        }
        return addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    @SuppressLint({"NewApi"})
    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        boolean addLinks;
        if (shouldAddLinksFallbackToFramework()) {
            addLinks = Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
            return addLinks;
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i3 = 0;
        while (i3 < strArr.length) {
            String str2 = strArr[i3];
            i3++;
            strArr2[i3] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z16 = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) {
                applyLink(makeUrl(matcher.group(0), strArr2, matcher, transformFilter), start, end, spannable);
                z16 = true;
            }
        }
        return z16;
    }
}
