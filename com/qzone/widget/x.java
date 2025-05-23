package com.qzone.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.qzone.feed.ui.comment.UserNameSapn;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.text.ComboNetImageCell;
import com.qzone.proxy.feedcomponent.text.NetImageCell;
import com.qzone.util.am;
import com.qzone.util.ar;
import com.qzonex.utils.richtext.element.ColorElement;
import com.qzonex.utils.richtext.element.CustomUrlElement;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import common.config.service.QzoneConfig;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w6.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public static int f61171a = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_NEED_DECODE, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f61172b = Pattern.compile("<uin:.*?,nickname:.*?>");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f61173c = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f61174d = Pattern.compile("\\{url:(.*?),text:(.*?),color:(.*?)\\}");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f61175e = Pattern.compile("\\{url:.*?,text:.*?\\}");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f61176f = Pattern.compile("\\<uin:.*?,nick(name)?:.*?\\>");

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f61177g = Pattern.compile("\\<itemid:.*?,from:.*?,needColon:.*?,level:.*?,jumpUrl:.*?,uin:.*?,nick(name)?:.*?\\>");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f61178h = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f61179i = Pattern.compile("\\{img:.*?,w:\\d+,h:\\d+\\}");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f61180j = Pattern.compile("\\{img:.*?,w:\\d+,h:.+?\\}");

    public static StringBuilder b(StringBuilder sb5) {
        Matcher matcher = f61173c.matcher(sb5);
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                User i16 = i(group, ",nick:");
                if (i16.from != 2) {
                    String.valueOf(i16.uin);
                }
                String str = "@" + i16.nickName;
                sb5.replace(start, end, str);
                i3 += group.length() - str.length();
            } catch (Exception unused) {
            }
        }
        return sb5;
    }

    private static String c(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static ColorElement e(String str) {
        int indexOf = str.indexOf("text:") + 5;
        int indexOf2 = str.indexOf(",color:");
        if (indexOf != -1 && indexOf2 != -1) {
            ColorElement colorElement = new ColorElement();
            colorElement.text = str.substring(indexOf, indexOf2);
            int indexOf3 = str.indexOf(",useDefaultFont:");
            int indexOf4 = str.indexOf(",useSuperFont:");
            int length = str.length() - 1;
            if (indexOf3 != -1) {
                try {
                    if (str.charAt(indexOf3 + 16) == '1') {
                        colorElement.useDefaultFont = true;
                    }
                } catch (Exception unused) {
                }
                length = indexOf3;
            }
            if (indexOf4 != -1) {
                if (indexOf3 == -1) {
                    indexOf3 = indexOf4;
                }
                try {
                    if (str.charAt(indexOf4 + 14) == '0') {
                        colorElement.useSuperFont = false;
                    }
                    length = indexOf3;
                } catch (Exception unused2) {
                }
            }
            indexOf3 = length;
            try {
                int indexOf5 = str.indexOf(",useLinkTextColor:");
                if (indexOf5 >= 0) {
                    indexOf3 = Math.min(indexOf5, indexOf3);
                }
                if (str.charAt(indexOf5 + 18) == '1') {
                    colorElement.useLinkTextColor = true;
                }
            } catch (Exception unused3) {
            }
            try {
                int indexOf6 = str.indexOf(",bold:");
                if (indexOf6 >= 0) {
                    indexOf3 = Math.min(indexOf6, indexOf3);
                }
                if (str.charAt(indexOf6 + 6) == '1') {
                    colorElement.isBold = true;
                }
            } catch (Exception unused4) {
            }
            try {
                String substring = str.substring(indexOf2 + 7, indexOf3);
                if (!TextUtils.isEmpty(substring) && !substring.startsWith("#")) {
                    substring = "#" + substring;
                }
                colorElement.color = Color.parseColor(substring);
            } catch (Exception unused5) {
            }
            return colorElement;
        }
        return new ColorElement();
    }

    public static CustomUrlElement f(String str) {
        String trim = str.trim();
        if (trim.startsWith("{") && trim.endsWith("}")) {
            String[] split = trim.substring(1, trim.length() - 1).split(",");
            CustomUrlElement customUrlElement = new CustomUrlElement();
            for (String str2 : split) {
                String[] split2 = str2.split(":", 2);
                if (split2.length < 2) {
                    if (!TextUtils.isEmpty(customUrlElement.text)) {
                        customUrlElement.text += "," + c(str2);
                    }
                } else {
                    String str3 = split2[0];
                    String str4 = split2[1];
                    if ("url".equals(str3)) {
                        if (f61171a == 0) {
                            customUrlElement.url = d(str4);
                        } else {
                            customUrlElement.url = c(str4);
                        }
                    } else if ("text".equals(str3)) {
                        customUrlElement.text = d(str4);
                    } else if (Method.POST.equals(str3)) {
                        customUrlElement.post = c(str4);
                    }
                }
            }
            if (TextUtils.isEmpty(customUrlElement.text)) {
                customUrlElement.text = customUrlElement.url;
            }
            return customUrlElement;
        }
        CustomUrlElement customUrlElement2 = new CustomUrlElement();
        customUrlElement2.post = "";
        customUrlElement2.text = "";
        customUrlElement2.url = "";
        return customUrlElement2;
    }

    private static int g(float f16) {
        Paint paint = new Paint();
        paint.setTextSize(f16);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
    }

    private static HashMap<String, ImageSpan> h(TextView textView) {
        CharSequence text = textView.getText();
        if (text == null || !(text instanceof Spannable)) {
            return null;
        }
        Spannable spannable = (Spannable) text;
        ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
        if (imageSpanArr == null) {
            return null;
        }
        HashMap<String, ImageSpan> hashMap = new HashMap<>();
        for (ImageSpan imageSpan : imageSpanArr) {
            hashMap.put(imageSpan.getSource(), imageSpan);
        }
        return hashMap;
    }

    public static User i(String str, String str2) {
        String str3;
        int indexOf = str.indexOf("uin:") + 4;
        int indexOf2 = str.indexOf(str2);
        String str4 = "";
        if (indexOf2 == -1) {
            User user = new User();
            user.nickName = "";
            user.uin = 0L;
            return user;
        }
        String substring = str.substring(indexOf, indexOf2);
        int indexOf3 = str.indexOf(",who:", indexOf2);
        if (indexOf3 == -1) {
            indexOf3 = str.length() - 1;
        }
        int indexOf4 = str.indexOf(",superLike:");
        if (indexOf4 != -1) {
            indexOf3 = indexOf4;
        }
        if (indexOf3 == -1) {
            indexOf3 = str.length() - 1;
        }
        String substring2 = str.substring(indexOf2 + str2.length(), indexOf3);
        int indexOf5 = str.indexOf(",seperate:");
        int length = indexOf5 == -1 ? str.length() - 1 : indexOf5;
        if (indexOf4 != -1) {
            str3 = str.substring(indexOf4 + 11, length);
        } else {
            str3 = "0";
        }
        if (indexOf5 != -1) {
            str4 = str.substring(indexOf5 + 10, str.length() - 1);
        }
        int indexOf6 = str.indexOf(",who:");
        int i3 = 0;
        if (indexOf6 != -1) {
            int i16 = indexOf6 + 5;
            int i17 = i16 + 1;
            if (i17 >= str.length()) {
                i17 = str.length() - 1;
            }
            try {
                i3 = Integer.parseInt(str.substring(i16, i17));
            } catch (Exception unused) {
            }
        }
        try {
            substring2 = URLDecoder.decode(substring2, "UTF-8");
        } catch (Exception unused2) {
        }
        User user2 = new User();
        user2.nickName = substring2;
        user2.superLike = Integer.parseInt(str3);
        user2.nameSeperate = str4;
        if (i3 != 2 && i3 != 3) {
            try {
                user2.uin = Long.valueOf(substring).longValue();
                if (TextUtils.isEmpty(substring2) || (substring.equals(substring2) && !s8.f.h())) {
                    String g16 = s8.f.f().g(substring);
                    if (!TextUtils.isEmpty(g16)) {
                        if (substring2 != null && substring2.endsWith("\u3001")) {
                            g16 = g16 + "\u3001";
                        }
                        user2.nickName = g16;
                    }
                }
            } catch (NumberFormatException unused3) {
                user2.uin = 0L;
            }
        } else {
            user2.uinKey = substring;
            user2.from = i3;
        }
        return user2;
    }

    public static void k(SpannableStringBuilder spannableStringBuilder, int i3, a.InterfaceC11463a interfaceC11463a) {
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return;
        }
        Matcher matcher = f61175e.matcher(spannableStringBuilder);
        int i16 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i16;
                int end = matcher.end() - i16;
                String group = matcher.group();
                CustomUrlElement f16 = f(group);
                String str = f16.url;
                String str2 = f16.text;
                spannableStringBuilder.replace(start, end, (CharSequence) str2);
                i16 += group.length() - str2.length();
                int length = str2.length() + start;
                w6.a aVar = new w6.a(str, str2, interfaceC11463a);
                if (i3 != Integer.MIN_VALUE) {
                    aVar.a(i3);
                }
                spannableStringBuilder.setSpan(aVar, start, length, 33);
            } catch (Exception unused) {
                return;
            }
        }
    }

    public static NetImageCell l(String str) {
        int indexOf;
        String substring;
        NetImageCell netImageCell;
        int indexOf2;
        String substring2;
        if (!TextUtils.isEmpty(str) && str.startsWith("{img:")) {
            int indexOf3 = str.indexOf(",combo:");
            if (indexOf3 == -1) {
                netImageCell = new NetImageCell(str);
                indexOf = str.indexOf(",w:");
                substring = str.substring(5, indexOf);
            } else {
                indexOf = str.indexOf(",w:", indexOf3);
                ComboNetImageCell comboNetImageCell = new ComboNetImageCell(str, Integer.parseInt(str.substring(indexOf3 + 7, indexOf)));
                substring = str.substring(5, indexOf3);
                netImageCell = comboNetImageCell;
            }
            if (indexOf == -1 || (indexOf2 = str.indexOf(",h:", indexOf)) == -1) {
                return netImageCell;
            }
            int indexOf4 = str.indexOf(",id:", indexOf);
            if (indexOf4 == -1) {
                indexOf4 = str.length() - 1;
            } else {
                netImageCell.setClickable(true);
                int indexOf5 = str.indexOf(",uin:", indexOf4);
                if (indexOf5 == -1) {
                    try {
                        netImageCell.setCustomId(Integer.valueOf(str.substring(indexOf4 + 4, str.length() - 1)).intValue());
                    } catch (Exception unused) {
                        netImageCell.setCustomId(0);
                    }
                } else {
                    try {
                        netImageCell.setCustomId(Integer.valueOf(str.substring(indexOf4 + 4, indexOf5)).intValue());
                    } catch (Exception unused2) {
                        netImageCell.setCustomId(0);
                    }
                    try {
                        netImageCell.setCustomUin(Long.parseLong(str.substring(indexOf5 + 5, str.length() - 1)));
                    } catch (Exception unused3) {
                        netImageCell.setCustomUin(0L);
                    }
                }
            }
            int indexOf6 = str.indexOf(",pLeft:", 0);
            int indexOf7 = str.indexOf(",pRight:", indexOf6);
            try {
                netImageCell.emoUrl = URLDecoder.decode(substring, "UTF-8");
                netImageCell.mWidth = Integer.valueOf(str.substring(indexOf + 3, indexOf2)).intValue();
                netImageCell.mHeight = Integer.valueOf(str.substring(indexOf2 + 3, indexOf6 < 0 ? indexOf4 : indexOf6)).intValue();
                String str2 = "0";
                if (indexOf6 == -1) {
                    substring2 = "0";
                } else {
                    substring2 = str.substring(indexOf6 + 7, indexOf7);
                }
                if (indexOf4 < 0) {
                    indexOf4 = str.length() - 1;
                }
                if (indexOf7 != -1) {
                    str2 = str.substring(indexOf7 + 8, indexOf4);
                }
                netImageCell.mLeftPadding = p(substring2);
                netImageCell.mRightPadding = p(str2);
            } catch (Exception unused4) {
                netImageCell.mWidth = 0;
                netImageCell.mHeight = 0;
            }
            return netImageCell;
        }
        return new NetImageCell(str);
    }

    public static void m(SpannableStringBuilder spannableStringBuilder, int i3, a.InterfaceC11463a interfaceC11463a) {
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class)) {
            w6.a aVar = new w6.a(uRLSpan.getURL(), uRLSpan.getURL(), interfaceC11463a);
            int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
            spannableStringBuilder.removeSpan(uRLSpan);
            if (i3 != Integer.MIN_VALUE) {
                aVar.a(i3);
            }
            spannableStringBuilder.setSpan(aVar, spanStart, spanEnd, 33);
        }
    }

    public static ArrayList<User> n(Context context, SpannableStringBuilder spannableStringBuilder, int i3, UserNameSapn.OnUserNameClickListener onUserNameClickListener) {
        String str;
        ArrayList<User> arrayList = null;
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return null;
        }
        Matcher matcher = f61173c.matcher(spannableStringBuilder);
        int i16 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i16;
                int end = matcher.end() - i16;
                String group = matcher.group();
                User i17 = i(group, ",nick:");
                if (i17.from != 2) {
                    str = String.valueOf(i17.uin);
                } else {
                    str = i17.uinKey;
                }
                String str2 = "@" + i17.nickName;
                spannableStringBuilder.replace(start, end, (CharSequence) str2);
                i16 += group.length() - str2.length();
                int length = str2.length() + start;
                if (i17.from != 2) {
                    if (i3 != Integer.MIN_VALUE) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), start, length, 33);
                    }
                    spannableStringBuilder.setSpan(new UserNameSapn(str, i3, onUserNameClickListener), start, length, 33);
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(i17);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static void o(Context context, SpannableStringBuilder spannableStringBuilder, int i3, UserNameSapn.OnUserNameClickListener onUserNameClickListener) {
        String str;
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return;
        }
        Matcher matcher = f61172b.matcher(spannableStringBuilder);
        int i16 = 0;
        while (matcher.find()) {
            int start = matcher.start() - i16;
            int end = matcher.end() - i16;
            String group = matcher.group();
            User i17 = i(group, ",nickname:");
            if (i17.from != 2) {
                str = String.valueOf(i17.uin);
            } else {
                str = i17.uinKey;
            }
            String a16 = to.h.a(i17.nickName);
            spannableStringBuilder.replace(start, end, (CharSequence) a16);
            i16 += group.length() - a16.length();
            int length = a16.length() + start;
            if (i17.from != 2) {
                if (i3 != Integer.MIN_VALUE) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), start, length, 33);
                }
                spannableStringBuilder.setSpan(new UserNameSapn(str, i3, onUserNameClickListener), start, length, 33);
            }
        }
    }

    private static int p(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (str.endsWith("dp")) {
                return ar.e(Float.valueOf(str.substring(0, str.length() - 2)).floatValue());
            }
            if (str.endsWith("px")) {
                return Integer.valueOf(str.substring(0, str.length() - 2)).intValue();
            }
            return ar.e(Integer.valueOf(str).intValue());
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String d(String str) {
        if (str == null) {
            return "";
        }
        try {
            return str.replaceAll("%7B", "{").replaceAll("%7D", "}").replaceAll("%3A", ":").replaceAll("%2C", ",").replaceAll("%25", "%");
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0017 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(TextView textView, CharSequence charSequence, HashMap<String, ImageSpan> hashMap, Spannable spannable, Context context, ImageLoader.ImageLoadListener imageLoadListener, Drawable.Callback callback) {
        boolean z16;
        String str;
        ImageSpan imageSpan;
        if (spannable == null) {
            return;
        }
        Matcher matcher = am.f59788c.matcher(spannable);
        int max = Math.max(g(textView.getTextSize()), 20);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String charSequence2 = spannable.subSequence(start, end).toString();
            Drawable drawable = QzoneEmotionUtils.getDrawable(charSequence2);
            if (drawable == null) {
                if (hashMap != null && (imageSpan = hashMap.get(charSequence2)) != null) {
                    spannable.setSpan(new ImageSpan(imageSpan.getDrawable(), charSequence2, 1), start, end, 33);
                } else {
                    int indexOf = charSequence2.indexOf(QzoneEmotionUtils.EMO_PREFIX) + 4;
                    int indexOf2 = charSequence2.indexOf(QzoneEmotionUtils.EMO_TAIL);
                    if (indexOf != -1 && indexOf2 != -1) {
                        String str2 = (String) charSequence2.subSequence(indexOf, indexOf2);
                        try {
                            str = QzoneEmotionUtils.getEmoUrlFromConfig(str2);
                        } catch (Exception unused) {
                            str = QzoneEmotionUtils.SIGN_ICON_URL_PREFIX + str2 + QzoneEmotionUtils.SIGN_ICON_URL_END;
                        }
                        ImageLoader.Options obtain = ImageLoader.Options.obtain();
                        obtain.obj = charSequence;
                        obtain.type = "qzEmod";
                        drawable = ImageLoader.getInstance().loadImage(str, imageLoadListener, obtain);
                        z16 = false;
                        if (drawable != null) {
                            drawable.setBounds(0, 0, max, max);
                        } else {
                            drawable = context.getResources().getDrawable(R.drawable.f162386o04);
                            if (drawable != null) {
                                int i3 = max - 3;
                                drawable.setBounds(3, 3, i3, i3);
                            }
                            if (drawable != null) {
                                if (!z16) {
                                    charSequence2 = "NotYet...";
                                }
                                spannable.setSpan(new ImageSpan(drawable, charSequence2, 1), start, end, 33);
                            }
                        }
                    }
                }
            }
            z16 = true;
            if (drawable != null) {
            }
        }
    }

    public static void j(TextView textView, Context context, CharSequence charSequence, int i3, int i16, int i17, UserNameSapn.OnUserNameClickListener onUserNameClickListener, a.InterfaceC11463a interfaceC11463a, ImageLoader.ImageLoadListener imageLoadListener, Drawable.Callback callback, boolean z16) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        o(context, spannableStringBuilder, i3, onUserNameClickListener);
        n(context, spannableStringBuilder, i16, onUserNameClickListener);
        a(textView, charSequence, h(textView), spannableStringBuilder, context, imageLoadListener, callback);
        if (z16) {
            m(spannableStringBuilder, i17, interfaceC11463a);
            k(spannableStringBuilder, i17, interfaceC11463a);
        }
        textView.setText(spannableStringBuilder);
    }
}
