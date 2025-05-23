package com.tencent.guild.aio.input.at.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.DynamicDrawableSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class AtTroopMemberSpan extends DynamicDrawableSpan {
    private String C;
    private String D;
    protected String E;
    protected String F;
    protected int G;
    protected int H;
    protected Drawable I;
    private int J;
    private AtRoleInfo K;
    protected c L;

    /* renamed from: d, reason: collision with root package name */
    private String f111085d;

    /* renamed from: e, reason: collision with root package name */
    protected String f111086e;

    /* renamed from: f, reason: collision with root package name */
    protected String f111087f;

    /* renamed from: h, reason: collision with root package name */
    protected int f111088h;

    /* renamed from: i, reason: collision with root package name */
    protected int f111089i;

    /* renamed from: m, reason: collision with root package name */
    private int f111090m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface AtSpanType {
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Comparator<AtTroopMemberSpan> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Spannable f111091d;

        a(Spannable spannable) {
            this.f111091d = spannable;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AtTroopMemberSpan atTroopMemberSpan, AtTroopMemberSpan atTroopMemberSpan2) {
            int spanStart = this.f111091d.getSpanStart(atTroopMemberSpan);
            int spanStart2 = this.f111091d.getSpanStart(atTroopMemberSpan2);
            if (spanStart < spanStart2) {
                return -1;
            }
            if (spanStart > spanStart2) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f111092a;

        /* renamed from: b, reason: collision with root package name */
        public int f111093b;

        /* renamed from: c, reason: collision with root package name */
        public String f111094c;

        /* renamed from: d, reason: collision with root package name */
        public CharacterStyle f111095d;

        /* renamed from: e, reason: collision with root package name */
        public int f111096e;

        public b(int i3, int i16, int i17, String str, CharacterStyle characterStyle) {
            this.f111096e = i3;
            this.f111092a = i16;
            this.f111093b = i17;
            this.f111094c = str;
            this.f111095d = characterStyle;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c implements Comparator<CharacterStyle> {

        /* renamed from: d, reason: collision with root package name */
        Spanned f111097d;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
            Spanned spanned = this.f111097d;
            if (spanned == null) {
                return 0;
            }
            int spanStart = spanned.getSpanStart(characterStyle);
            int spanStart2 = this.f111097d.getSpanStart(characterStyle2);
            if (spanStart == spanStart2) {
                int spanEnd = this.f111097d.getSpanEnd(characterStyle);
                int spanEnd2 = this.f111097d.getSpanEnd(characterStyle2);
                if (spanEnd == spanEnd2) {
                    return 0;
                }
                if (spanEnd > spanEnd2) {
                    return 1;
                }
                return -1;
            }
            if (spanStart > spanStart2) {
                return 1;
            }
            return -1;
        }

        public void b(Spanned spanned) {
            this.f111097d = spanned;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AtTroopMemberSpan(Context context, String str, String str2, int i3, Paint paint, String str3, int i16, int i17, AtRoleInfo atRoleInfo) {
        super(0);
        this.f111085d = "";
        this.f111086e = "";
        this.f111087f = "";
        this.f111088h = -1;
        this.f111089i = 0;
        this.f111090m = 0;
        this.C = "#";
        this.E = "";
        this.F = "";
        this.H = -4331268;
        this.L = new c();
        this.f111085d = str;
        this.f111086e = String.format("%s%s", "@", str2);
        this.f111089i = i3;
        this.H = i16;
        e(context, paint);
        String format = String.format("%s%s", "@", str3);
        this.D = format;
        this.J = i17;
        this.K = atRoleInfo;
        this.f111087f = format;
    }

    public static String a(int i3, String str, Paint paint) {
        if (i3 <= 0) {
            return str;
        }
        float measureText = paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        if (((int) Math.ceil(paint.measureText(str))) <= i3) {
            return str;
        }
        for (int length = str.length() - 1; length > 0; length--) {
            if (((int) Math.ceil(paint.measureText(str, 0, length) + measureText)) <= i3) {
                return str.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
        }
        return "";
    }

    public static List<b> c(int i3, String str, Paint paint, c cVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        n(arrayList, cVar, new SpannableString(str));
        Math.ceil(paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX));
        Iterator it = arrayList.iterator();
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b bVar = (b) it.next();
            int i17 = bVar.f111096e;
            if (i17 != 1) {
                if (i17 == 3) {
                    arrayList2.add(bVar);
                }
            } else {
                String a16 = a(i3 - i16, bVar.f111094c, paint);
                if (a16.equals(bVar.f111094c)) {
                    i16 += (int) Math.ceil(paint.measureText(bVar.f111094c));
                    arrayList2.add(bVar);
                } else {
                    bVar.f111094c = a16;
                    arrayList2.add(bVar);
                    break;
                }
            }
        }
        return arrayList2;
    }

    public static Spannable d(Spannable spannable, ArrayList<kp0.a> arrayList) {
        String str;
        long parseLong;
        if (arrayList != null && spannable != null) {
            arrayList.clear();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable);
            AtTroopMemberSpan[] atTroopMemberSpanArr = (AtTroopMemberSpan[]) spannable.getSpans(0, spannableStringBuilder.length() - 1, AtTroopMemberSpan.class);
            if (atTroopMemberSpanArr.length == 0) {
                return spannableStringBuilder;
            }
            if (atTroopMemberSpanArr.length > 1) {
                Arrays.sort(atTroopMemberSpanArr, new a(spannable));
            }
            int i3 = 0;
            for (AtTroopMemberSpan atTroopMemberSpan : atTroopMemberSpanArr) {
                int spanStart = spannable.getSpanStart(atTroopMemberSpan) + i3;
                int spanEnd = spannable.getSpanEnd(atTroopMemberSpan) + i3;
                if (!TextUtils.isEmpty(atTroopMemberSpan.F)) {
                    str = atTroopMemberSpan.F;
                } else {
                    str = atTroopMemberSpan.f111086e;
                    if (!TextUtils.isEmpty(atTroopMemberSpan.D)) {
                        str = atTroopMemberSpan.D;
                    }
                }
                try {
                    spannableStringBuilder.replace(spanStart, spanEnd, (CharSequence) str);
                    kp0.a aVar = new kp0.a();
                    if (!TextUtils.isEmpty(atTroopMemberSpan.f111085d)) {
                        aVar.f412787d = Long.parseLong(atTroopMemberSpan.f111085d);
                        aVar.f412791h = atTroopMemberSpan.f111086e;
                        int i16 = atTroopMemberSpan.J;
                        if (i16 == 1) {
                            aVar.f412786c = (byte) 1;
                        } else if (i16 == 64) {
                            aVar.f412786c = (byte) 3;
                        } else if (i16 == 8) {
                            aVar.f412786c = (byte) 4;
                            aVar.f412792i = atTroopMemberSpan.f();
                        }
                    } else if (!TextUtils.isEmpty(atTroopMemberSpan.F)) {
                        aVar.f412791h = atTroopMemberSpan.F;
                        int i17 = atTroopMemberSpan.J;
                        if (i17 == 16) {
                            aVar.f412786c = (byte) 2;
                        } else if (i17 == 512) {
                            aVar.f412786c = (byte) 5;
                        }
                        if (TextUtils.isEmpty(atTroopMemberSpan.E)) {
                            parseLong = 0;
                        } else {
                            parseLong = Long.parseLong(atTroopMemberSpan.E);
                        }
                        aVar.f412788e = parseLong;
                    }
                    aVar.f412784a = (short) spanStart;
                    aVar.f412785b = (short) str.length();
                    arrayList.add(aVar);
                    i3 += aVar.f412785b - (spanEnd - spanStart);
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder();
    }

    public static int h(StringBuffer stringBuffer, int i3) {
        int i16;
        int doubleEmoji;
        int i17;
        int i18 = i3 + 1;
        if (stringBuffer.length() < i18) {
            return 0;
        }
        int codePointAt = stringBuffer.codePointAt(i3);
        int singleEmoji = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getSingleEmoji(codePointAt);
        int i19 = 2;
        int i26 = -1;
        if (codePointAt > 65535) {
            int i27 = i3 + 2;
            if (stringBuffer.length() > i27) {
                i26 = stringBuffer.codePointAt(i27);
            }
            i16 = 2;
        } else {
            i16 = 1;
            if (stringBuffer.length() > i18) {
                i26 = stringBuffer.codePointAt(i18);
            }
        }
        if (codePointAt <= 65535 && i26 == 65039 && stringBuffer.length() > (i17 = i3 + 2)) {
            i26 = stringBuffer.codePointAt(i17);
        } else {
            i19 = i16;
        }
        if ((singleEmoji < 0 || ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).isSkinEmoji(i26)) && (doubleEmoji = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getDoubleEmoji(codePointAt, i26)) >= 0) {
            if (i26 > 65535) {
                i19 += 2;
            } else {
                i19++;
            }
            singleEmoji = doubleEmoji;
        }
        if (singleEmoji <= 0) {
            return 0;
        }
        return i19;
    }

    private String k() {
        return this.C;
    }

    public static int l(List<b> list, Paint paint, Rect rect) {
        Rect rect2 = new Rect();
        int i3 = 0;
        for (b bVar : list) {
            if (bVar.f111096e == 1) {
                i3 += (int) Math.ceil(paint.measureText(bVar.f111094c));
                String str = bVar.f111094c;
                paint.getTextBounds(str, 0, str.length(), rect2);
                rect.bottom = Math.max(rect.bottom, rect2.height());
            }
        }
        rect.left = 0;
        rect.right = i3;
        rect.top = 0;
        return i3;
    }

    public static String m(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i3 = 0;
        while (i3 < stringBuffer.length()) {
            if (stringBuffer.codePointAt(i3) == 20 && i3 < stringBuffer.length() - 1) {
                stringBuffer.replace(i3, i3 + 2, "##");
                i3++;
            } else {
                int h16 = h(stringBuffer, i3);
                if (h16 > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    for (int i16 = 0; i16 < h16; i16++) {
                        sb5.append('#');
                    }
                    stringBuffer.replace(i3, i3 + h16, sb5.toString());
                    i3 += h16 - 1;
                }
            }
            i3++;
        }
        return stringBuffer.toString();
    }

    public static void n(List<b> list, c cVar, Spannable spannable) {
        list.clear();
        int i3 = 0;
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) spannable.getSpans(0, spannable.length(), CharacterStyle.class);
        if (characterStyleArr.length == 0) {
            list.add(new b(1, 0, spannable.length(), spannable.toString(), null));
            return;
        }
        cVar.b(spannable);
        Arrays.sort(characterStyleArr, cVar);
        int i16 = 0;
        while (i3 < characterStyleArr.length) {
            int spanStart = spannable.getSpanStart(characterStyleArr[i3]);
            int spanEnd = spannable.getSpanEnd(characterStyleArr[i3]);
            if (spanStart > i16) {
                list.add(new b(1, i16, spanStart, spannable.subSequence(i16, spanStart).toString(), null));
            }
            list.add(new b(3, spanStart, spanEnd, spannable.subSequence(spanStart, spanEnd).toString(), characterStyleArr[i3]));
            if (i3 == characterStyleArr.length - 1 && spanEnd < spannable.length()) {
                list.add(new b(1, spanEnd, spannable.length(), spannable.subSequence(spanEnd, spannable.length()).toString(), null));
            }
            i3++;
            i16 = spanEnd;
        }
    }

    protected List<b> b(Paint paint) {
        List<b> c16 = c(this.f111089i - (((int) Math.ceil(paint.measureText(" "))) * 2), this.f111086e, paint, this.L);
        c16.add(new b(1, 0, 0, "  ", null));
        this.f111088h = l(c16, paint, new Rect());
        return c16;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        if (i16 - i3 == 1 && this.f111087f.length() != 1 && i3 != 0) {
            return;
        }
        if (!TextUtils.isEmpty(this.D) && i3 < i16) {
            int i26 = i3 + 1;
            if (!"@".contentEquals(charSequence.subSequence(i3, i26))) {
                QLog.d("AtTroopMemberSpan", 1, "repeat draw text=" + ((Object) charSequence) + " start=" + i3 + " end=" + i16 + " substart=" + ((Object) charSequence.subSequence(i3, i26)));
                return;
            }
        }
        if (!TextUtils.isEmpty(this.F) && i3 < i16 && !k().isEmpty() && !k().contentEquals(charSequence.subSequence(i3, i3 + 1))) {
            return;
        }
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate(f16, (i18 + paint.getFontMetricsInt().bottom) - drawable.getBounds().bottom);
        drawable.draw(canvas);
        canvas.restore();
    }

    protected void e(Context context, Paint paint) {
        int i3;
        float measureText;
        if (this.I != null) {
            return;
        }
        List<b> b16 = b(paint);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f16 = -fontMetrics.top;
        int ceil = (int) Math.ceil(fontMetrics.bottom - r3);
        float f17 = 0.0f;
        RectF rectF = new RectF(0.0f, fontMetrics.ascent - fontMetrics.top, this.f111088h - 2, fontMetrics.descent + f16);
        int i16 = this.f111088h;
        if (i16 <= 0) {
            i16 = 1;
        }
        if (ceil <= 0) {
            i3 = 1;
        } else {
            i3 = ceil;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int color = paint.getColor();
        paint.setColor(this.H);
        canvas.drawRect(rectF, paint);
        paint.setColor(color);
        for (b bVar : b16) {
            int i17 = bVar.f111096e;
            if (i17 != 1) {
                if (i17 == 2) {
                    measureText = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmoticonSpanDrawableWidth(bVar.f111095d, canvas, i3, paint, f17);
                }
            } else {
                canvas.drawText(bVar.f111094c, f17, f16, paint);
                measureText = paint.measureText(bVar.f111094c);
            }
            f17 += measureText;
        }
        canvas.save();
        canvas.restore();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), createBitmap);
        this.I = bitmapDrawable;
        bitmapDrawable.setBounds(0, 0, this.f111088h, i3);
    }

    public AtRoleInfo f() {
        return this.K;
    }

    public int g() {
        return this.J;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        return this.I;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (this.I == null || (i16 - i3 == 1 && this.f111087f.length() != 1 && i3 != 0)) {
            return 0;
        }
        if (!TextUtils.isEmpty(this.D) && i3 < i16 && !"@".contentEquals(charSequence.subSequence(i3, i3 + 1))) {
            return 0;
        }
        if (!TextUtils.isEmpty(this.F) && i3 < i16 && !k().isEmpty() && !k().contentEquals(charSequence.subSequence(i3, i3 + 1))) {
            return 0;
        }
        return this.I.getBounds().right + this.f111090m;
    }

    public String i() {
        return this.f111086e;
    }

    public String j() {
        return this.f111085d;
    }

    public AtTroopMemberSpan(Context context, String str, String str2, int i3, Paint paint, int i16, int i17, int i18, String str3) {
        super(0);
        this.f111085d = "";
        this.f111086e = "";
        this.f111087f = "";
        this.f111088h = -1;
        this.f111089i = 0;
        this.f111090m = 0;
        this.C = "#";
        this.E = "";
        this.F = "";
        this.H = -4331268;
        this.L = new c();
        this.E = str;
        this.C = str3;
        String format = String.format("%s%s", str3, str2);
        this.F = format;
        this.f111090m = i18;
        this.f111089i = i3 - i18;
        this.H = i16;
        this.J = i17;
        this.f111087f = i18 <= 0 ? format : str2;
        e(context, paint);
    }
}
