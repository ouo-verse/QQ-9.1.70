package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import cf0.c;
import com.tencent.biz.subscribe.comment.o;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class RichTextParser {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f96581a = Pattern.compile("\\{img:(.*?),w:(\\d+),h:(\\d+)\\}");

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Integer> f96582b = new HashMap<String, Integer>() { // from class: com.tencent.biz.subscribe.widget.textview.RichTextParser.1
        {
            put(ICustomDataEditor.STRING_ARRAY_PARAM_2, Integer.valueOf(R.color.ald));
            put(ICustomDataEditor.STRING_ARRAY_PARAM_3, Integer.valueOf(R.color.alb));
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Drawable> f96583c = new HashMap<>();

    /* loaded from: classes5.dex */
    public static class a extends SpannableStringBuilder {

        /* renamed from: d, reason: collision with root package name */
        public boolean f96584d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f96585e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f96586f;

        public a(CharSequence charSequence) {
            super(charSequence);
            this.f96584d = false;
            this.f96585e = false;
            this.f96586f = false;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public float f96587a;

        /* renamed from: b, reason: collision with root package name */
        public int f96588b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f96589c;
    }

    public static void a(b bVar, CharSequence charSequence, HashMap<String, ImageSpan> hashMap, a aVar, URLDrawable.URLDrawableListener uRLDrawableListener) {
        b(bVar, charSequence, hashMap, aVar, uRLDrawableListener, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.tencent.image.URLDrawable] */
    /* JADX WARN: Type inference failed for: r2v17, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r2v19, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r2v25 */
    public static void b(b bVar, CharSequence charSequence, HashMap<String, ImageSpan> hashMap, a aVar, URLDrawable.URLDrawableListener uRLDrawableListener, boolean z16) {
        ?? r26;
        String str;
        if (aVar == null) {
            return;
        }
        Matcher matcher = o.f96044o.matcher(aVar);
        while (matcher.find()) {
            aVar.f96586f = true;
            int start = matcher.start();
            int end = matcher.end();
            String charSequence2 = aVar.subSequence(start, end).toString();
            if (z16 && f96583c.containsKey(charSequence2)) {
                r26 = f96583c.get(charSequence2);
            } else {
                r26 = 0;
            }
            if (r26 == 0) {
                if (QQSysFaceUtil.getLocalIdFromEMCode(charSequence2) != -1) {
                    r26 = QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.getLocalIdFromEMCode(charSequence2));
                } else if (QQEmojiUtil.getLocalIdFromEMCode(charSequence2) != -1) {
                    r26 = QQEmojiUtil.getEmojiDrawable(QQEmojiUtil.getLocalIdFromEMCode(charSequence2));
                } else {
                    int indexOf = charSequence2.indexOf(QzoneEmotionUtils.EMO_PREFIX) + 4;
                    int indexOf2 = charSequence2.indexOf(QzoneEmotionUtils.EMO_TAIL);
                    if (indexOf != -1 && indexOf2 != -1) {
                        String substring = charSequence2.substring(indexOf, indexOf2);
                        try {
                            str = QzoneEmotionUtils.getEmoUrlFromConfig(substring);
                        } catch (Exception unused) {
                            str = QzoneEmotionUtils.SIGN_ICON_URL_PREFIX + substring + QzoneEmotionUtils.SIGN_ICON_URL_END;
                        }
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f162386o04);
                        r26 = URLDrawable.getDrawable(str, obtain);
                        if (r26 != 0 && uRLDrawableListener != null) {
                            r26.setURLDrawableListener(uRLDrawableListener);
                        }
                    } else {
                        return;
                    }
                }
            }
            if (r26 != 0) {
                if (z16) {
                    f96583c.put(charSequence2, r26);
                }
                VerticalCenterImageSpan c16 = c(bVar, r26);
                if (c16 != null) {
                    aVar.setSpan(c16, start, end, 33);
                }
            }
        }
    }

    private static VerticalCenterImageSpan c(b bVar, Drawable drawable) {
        int i3 = (int) bVar.f96587a;
        Rect rect = new Rect(0, 0, i3, i3);
        if (drawable != null) {
            drawable.setBounds(rect);
            return new VerticalCenterImageSpan(drawable, bVar.f96588b);
        }
        return null;
    }

    private static HashMap<String, ImageSpan> d(b bVar) {
        CharSequence charSequence = bVar.f96589c;
        if (charSequence != null && (charSequence instanceof Spannable)) {
            Spannable spannable = (Spannable) charSequence;
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null) {
                HashMap<String, ImageSpan> hashMap = new HashMap<>();
                for (ImageSpan imageSpan : imageSpanArr) {
                    hashMap.put(imageSpan.getSource(), imageSpan);
                }
                return hashMap;
            }
            return null;
        }
        return null;
    }

    public static CertifiedAccountMeta$StUser e(String str, String str2) {
        int indexOf = str.indexOf("uin:") + 4;
        int indexOf2 = str.indexOf(str2);
        if (indexOf2 == -1) {
            return new CertifiedAccountMeta$StUser();
        }
        String substring = str.substring(indexOf, indexOf2);
        String substring2 = str.substring(indexOf2 + str2.length(), str.length() - 1);
        try {
            substring2 = URLDecoder.decode(substring2, "UTF-8");
        } catch (Exception unused) {
        }
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = new CertifiedAccountMeta$StUser();
        certifiedAccountMeta$StUser.nick.set(substring2);
        certifiedAccountMeta$StUser.f24929id.set(substring);
        return certifiedAccountMeta$StUser;
    }

    public static a f(b bVar, Context context, CharSequence charSequence, ColorStateList colorStateList, int i3, int i16, int i17, c.a aVar, cf0.b bVar2, cf0.a aVar2, URLDrawable.URLDrawableListener uRLDrawableListener, boolean z16, boolean z17) {
        try {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            a aVar3 = new a(charSequence);
            if (z16) {
                i(context, aVar3);
            }
            if (!z17) {
                j(context, aVar3, colorStateList, aVar);
                h(context, aVar3, i3, aVar);
            }
            a(bVar, charSequence, d(bVar), aVar3, uRLDrawableListener);
            bVar.f96587a += ViewUtils.dpToPx(4.0f);
            g(bVar, charSequence, d(bVar), aVar3, uRLDrawableListener);
            return aVar3;
        } catch (Exception e16) {
            QLog.e("RichTextParser", 2, e16.getStackTrace());
            return new a("");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v9, types: [android.graphics.drawable.Drawable] */
    private static void g(b bVar, CharSequence charSequence, HashMap<String, ImageSpan> hashMap, a aVar, URLDrawable.URLDrawableListener uRLDrawableListener) {
        URLDrawable uRLDrawable;
        if (TextUtils.isEmpty(aVar)) {
            return;
        }
        Matcher matcher = f96581a.matcher(aVar);
        while (matcher.find()) {
            try {
                String group = matcher.group(1);
                if (group.startsWith("https://qzonestyle.gtimg.cn/")) {
                    String group2 = matcher.group(2);
                    String group3 = matcher.group(3);
                    int start = matcher.start();
                    int end = matcher.end();
                    String charSequence2 = aVar.subSequence(start, end).toString();
                    if (f96583c.containsKey(charSequence2)) {
                        uRLDrawable = f96583c.get(charSequence2);
                    } else {
                        uRLDrawable = null;
                    }
                    if (uRLDrawable == null) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        try {
                            int parseInt = Integer.parseInt(group3);
                            int parseInt2 = Integer.parseInt(group2);
                            if (parseInt > 0 && parseInt2 > 0) {
                                obtain.mRequestHeight = parseInt;
                                obtain.mRequestWidth = parseInt2;
                            }
                        } catch (Exception e16) {
                            QLog.e("RichTextParser", 1, e16, new Object[0]);
                        }
                        obtain.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.f162386o04);
                        uRLDrawable = URLDrawable.getDrawable(group, obtain);
                        if (uRLDrawable != null && uRLDrawableListener != null) {
                            uRLDrawable.setURLDrawableListener(uRLDrawableListener);
                        }
                    }
                    if (uRLDrawable != null) {
                        f96583c.put(charSequence2, uRLDrawable);
                        VerticalCenterImageSpan c16 = c(bVar, uRLDrawable);
                        if (c16 != null) {
                            aVar.setSpan(c16, start, end, 33);
                        }
                    }
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                return;
            }
        }
    }

    public static ArrayList<CertifiedAccountMeta$StUser> h(Context context, a aVar, int i3, c.a aVar2) {
        ArrayList<CertifiedAccountMeta$StUser> arrayList = null;
        if (TextUtils.isEmpty(aVar)) {
            return null;
        }
        Matcher matcher = o.f96040k.matcher(aVar);
        int i16 = 0;
        while (matcher.find()) {
            try {
                aVar.f96584d = true;
                int start = matcher.start() - i16;
                int end = matcher.end() - i16;
                String group = matcher.group();
                CertifiedAccountMeta$StUser e16 = e(group, ",nickname:");
                String str = e16.f24929id.get();
                String str2 = "@" + e16.nick + " ";
                aVar.replace(start, end, (CharSequence) str2);
                i16 += group.length() - str2.length();
                int length = str2.length() + start;
                if (i3 != Integer.MIN_VALUE) {
                    aVar.setSpan(new ForegroundColorSpan(i3), start, length, 33);
                }
                aVar.setSpan(new c(str, i3, aVar2), start, length, 33);
                aVar.setSpan(new StyleSpan(1), start, length, 33);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(e16);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private static void i(Context context, SpannableStringBuilder spannableStringBuilder) {
        String str;
        if (!TextUtils.isEmpty(spannableStringBuilder) && context != null) {
            Matcher matcher = o.f96046q.matcher(spannableStringBuilder);
            int i3 = 0;
            while (matcher.find()) {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                int indexOf = group.indexOf(",color:") + 7;
                int indexOf2 = group.indexOf(",useDefaultFont:");
                int indexOf3 = group.indexOf("text:");
                ColorStateList colorStateList = null;
                if (indexOf3 != -1) {
                    String substring = group.substring(indexOf, indexOf2);
                    str = group.substring(indexOf3 + 5, group.indexOf(",color:"));
                    Integer num = f96582b.get(substring);
                    if (num != null) {
                        colorStateList = context.getResources().getColorStateList(num.intValue());
                    }
                } else {
                    str = "";
                }
                spannableStringBuilder.replace(start, end, (CharSequence) str);
                i3 += group.length() - str.length();
                int length = str.length() + start;
                if (colorStateList != null) {
                    spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 1, (int) (context.getResources().getDisplayMetrics().density * 14.0f), colorStateList, null), start, length, 33);
                }
            }
        }
    }

    public static void j(Context context, a aVar, ColorStateList colorStateList, c.a aVar2) {
        if (!TextUtils.isEmpty(aVar) && context != null) {
            Matcher matcher = o.f96030a.matcher(aVar);
            int i3 = 0;
            while (matcher.find()) {
                aVar.f96584d = true;
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                CertifiedAccountMeta$StUser e16 = e(group, ",nickname:");
                String str = e16.f24929id.get();
                String str2 = e16.nick.get();
                aVar.replace(start, end, (CharSequence) str2);
                int length = i3 + (group.length() - str2.length());
                int length2 = start + str2.length();
                if (colorStateList != null) {
                    aVar.setSpan(new TextAppearanceSpan(null, 1, (int) (context.getResources().getDisplayMetrics().density * 14.0f), colorStateList, null), start, length2, 33);
                }
                aVar.setSpan(new c(str, colorStateList, aVar2), start, length2, 33);
                i3 = length;
            }
        }
    }
}
