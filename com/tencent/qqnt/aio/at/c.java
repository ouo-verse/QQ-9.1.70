package com.tencent.qqnt.aio.at;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c extends DynamicDrawableSpan {
    static IPatchRedirector $redirector_;
    private String C;
    protected String D;
    protected String E;
    public int F;
    private String G;
    private String H;
    protected int I;
    protected WeakReference<Context> J;
    protected Drawable K;
    protected C9466c L;

    /* renamed from: d, reason: collision with root package name */
    private String f349473d;

    /* renamed from: e, reason: collision with root package name */
    private String f349474e;

    /* renamed from: f, reason: collision with root package name */
    protected String f349475f;

    /* renamed from: h, reason: collision with root package name */
    private String f349476h;

    /* renamed from: i, reason: collision with root package name */
    protected int f349477i;

    /* renamed from: m, reason: collision with root package name */
    protected int f349478m;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements Comparator<c> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Spannable f349479d;

        a(Spannable spannable) {
            this.f349479d = spannable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) spannable);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2)).intValue();
            }
            int spanStart = this.f349479d.getSpanStart(cVar);
            int spanStart2 = this.f349479d.getSpanStart(cVar2);
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
    /* loaded from: classes23.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f349480a;

        /* renamed from: b, reason: collision with root package name */
        public int f349481b;

        /* renamed from: c, reason: collision with root package name */
        public String f349482c;

        /* renamed from: d, reason: collision with root package name */
        public CharacterStyle f349483d;

        /* renamed from: e, reason: collision with root package name */
        public int f349484e;

        public b(int i3, int i16, int i17, String str, CharacterStyle characterStyle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, characterStyle);
                return;
            }
            this.f349484e = i3;
            this.f349480a = i16;
            this.f349481b = i17;
            this.f349482c = str;
            this.f349483d = characterStyle;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.aio.at.c$c, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static class C9466c implements Comparator<CharacterStyle> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Spanned f349485d;

        public C9466c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) characterStyle, (Object) characterStyle2)).intValue();
            }
            Spanned spanned = this.f349485d;
            if (spanned == null) {
                return 0;
            }
            int spanStart = spanned.getSpanStart(characterStyle);
            int spanStart2 = this.f349485d.getSpanStart(characterStyle2);
            if (spanStart == spanStart2) {
                int spanEnd = this.f349485d.getSpanEnd(characterStyle);
                int spanEnd2 = this.f349485d.getSpanEnd(characterStyle2);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) spanned);
            } else {
                this.f349485d = spanned;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, String str, String str2, String str3, int i3, Paint paint, String str4, int i16) {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, str, str2, str3, Integer.valueOf(i3), paint, str4, Integer.valueOf(i16));
            return;
        }
        this.f349473d = "";
        this.f349474e = "";
        this.f349475f = "";
        this.f349476h = "";
        this.f349477i = -1;
        this.f349478m = 0;
        this.D = "";
        this.E = "";
        this.F = 0;
        this.I = -4331268;
        this.L = new C9466c();
        this.f349473d = str;
        this.f349474e = str2;
        this.f349475f = String.format("%s%s", "@", str3);
        this.f349478m = i3;
        this.J = new WeakReference<>(context);
        this.I = i16;
        this.H = str3;
        this.G = str4;
        e(paint);
        this.C = String.format("%s%s", "@", str4);
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

    public static List<b> c(int i3, String str, Paint paint, C9466c c9466c) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        p(arrayList, c9466c, new SpannableString(str));
        Math.ceil(paint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX));
        Iterator it = arrayList.iterator();
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b bVar = (b) it.next();
            int i17 = bVar.f349484e;
            if (i17 != 1) {
                if (i17 == 3) {
                    arrayList2.add(bVar);
                }
            } else {
                String a16 = a(i3 - i16, bVar.f349482c, paint);
                if (a16.equals(bVar.f349482c)) {
                    i16 += (int) Math.ceil(paint.measureText(bVar.f349482c));
                    arrayList2.add(bVar);
                } else {
                    bVar.f349482c = a16;
                    arrayList2.add(bVar);
                    break;
                }
            }
        }
        return arrayList2;
    }

    public static Spannable d(Spannable spannable, ArrayList<com.tencent.qqnt.aio.at.b> arrayList) {
        String str;
        if (arrayList != null && spannable != null) {
            arrayList.clear();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable);
            c[] cVarArr = (c[]) spannable.getSpans(0, spannableStringBuilder.length() - 1, c.class);
            if (cVarArr.length == 0) {
                return spannableStringBuilder;
            }
            if (cVarArr.length > 1) {
                Arrays.sort(cVarArr, new a(spannable));
            }
            int i3 = 0;
            for (c cVar : cVarArr) {
                int spanStart = spannable.getSpanStart(cVar) + i3;
                int spanEnd = spannable.getSpanEnd(cVar) + i3;
                if (!TextUtils.isEmpty(cVar.E)) {
                    str = cVar.E;
                } else {
                    str = cVar.f349475f;
                    if (!TextUtils.isEmpty(cVar.C)) {
                        str = cVar.C;
                    }
                }
                try {
                    spannableStringBuilder.replace(spanStart, spanEnd, (CharSequence) str);
                    com.tencent.qqnt.aio.at.b bVar = new com.tencent.qqnt.aio.at.b();
                    if (!TextUtils.isEmpty(cVar.f349473d)) {
                        String str2 = cVar.f349473d;
                        bVar.f349468e = str2;
                        bVar.f349472i = cVar.f349475f;
                        if (str2.equalsIgnoreCase("0")) {
                            bVar.f349466c = (byte) 1;
                        }
                    } else if (!TextUtils.isEmpty(cVar.D)) {
                        bVar.f349472i = cVar.E;
                        bVar.f349466c = (byte) 2;
                        bVar.f349469f = Long.parseLong(cVar.D);
                    }
                    bVar.f349464a = (short) spanStart;
                    bVar.f349465b = (short) str.length();
                    arrayList.add(bVar);
                    i3 += bVar.f349465b - (spanEnd - spanStart);
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder();
    }

    public static int f(StringBuffer stringBuffer, int i3) {
        int i16;
        int doubleEmoji;
        int i17;
        int i18 = i3 + 1;
        if (stringBuffer.length() < i18) {
            return 0;
        }
        int codePointAt = stringBuffer.codePointAt(i3);
        int singleEmoji = EmotcationConstants.getSingleEmoji(codePointAt);
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
        if ((singleEmoji < 0 || EmotcationConstants.isSkinEmoji(i26)) && (doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt, i26)) >= 0) {
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

    public static int n(List<b> list, Paint paint, Rect rect) {
        Rect rect2 = new Rect();
        int i3 = 0;
        for (b bVar : list) {
            if (bVar.f349484e == 1) {
                i3 += (int) Math.ceil(paint.measureText(bVar.f349482c));
                String str = bVar.f349482c;
                paint.getTextBounds(str, 0, str.length(), rect2);
                rect.bottom = Math.max(rect.bottom, rect2.height());
            }
        }
        rect.left = 0;
        rect.right = i3;
        rect.top = 0;
        return i3;
    }

    public static String o(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i3 = 0;
        while (i3 < stringBuffer.length()) {
            if (stringBuffer.codePointAt(i3) == 20 && i3 < stringBuffer.length() - 1) {
                stringBuffer.replace(i3, i3 + 2, "##");
                i3++;
            } else {
                int f16 = f(stringBuffer, i3);
                if (f16 > 0) {
                    StringBuilder sb5 = new StringBuilder();
                    for (int i16 = 0; i16 < f16; i16++) {
                        sb5.append('#');
                    }
                    stringBuffer.replace(i3, i3 + f16, sb5.toString());
                    i3 += f16 - 1;
                }
            }
            i3++;
        }
        return stringBuffer.toString();
    }

    public static void p(List<b> list, C9466c c9466c, Spannable spannable) {
        list.clear();
        int i3 = 0;
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) spannable.getSpans(0, spannable.length(), CharacterStyle.class);
        if (characterStyleArr.length == 0) {
            list.add(new b(1, 0, spannable.length(), spannable.toString(), null));
            return;
        }
        c9466c.b(spannable);
        Arrays.sort(characterStyleArr, c9466c);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) paint);
        }
        List<b> c16 = c(this.f349478m - (((int) Math.ceil(paint.measureText(" "))) * 2), this.f349475f, paint, this.L);
        c16.add(new b(1, 0, 0, "  ", null));
        this.f349477i = n(c16, paint, new Rect());
        return c16;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            return;
        }
        if (i16 - i3 == 1 && this.f349476h.length() != 1 && i3 != 0) {
            return;
        }
        if (!TextUtils.isEmpty(this.C) && i3 < i16 && !"@".contentEquals(charSequence.subSequence(i3, i3 + 1))) {
            return;
        }
        try {
            super.draw(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint);
        } catch (Exception e16) {
            QLog.w("AtTroopMemberSpan", 2, "draw Exception", e16);
        }
    }

    protected void e(Paint paint) {
        Context context;
        float measureText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) paint);
            return;
        }
        WeakReference<Context> weakReference = this.J;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context == null) {
            context = BaseApplication.getContext();
        }
        if (this.K == null && context != null) {
            try {
                List<b> b16 = b(paint);
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                float f16 = -fontMetrics.top;
                int ceil = (int) Math.ceil(fontMetrics.bottom - r4);
                RectF rectF = new RectF(0.0f, fontMetrics.ascent - fontMetrics.top, this.f349477i - 2, fontMetrics.descent + f16);
                Bitmap createBitmap = Bitmap.createBitmap(this.f349477i, ceil, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                int color = paint.getColor();
                paint.setColor(this.I);
                canvas.drawRect(rectF, paint);
                paint.setColor(color);
                float f17 = 0.0f;
                for (b bVar : b16) {
                    int i3 = bVar.f349484e;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            measureText = com.tencent.qqnt.emoji.a.f356118a.a(bVar.f349483d, canvas, ceil, paint, f17);
                        }
                    } else {
                        canvas.drawText(bVar.f349482c, f17, f16, paint);
                        measureText = paint.measureText(bVar.f349482c);
                    }
                    f17 += measureText;
                }
                canvas.save();
                canvas.restore();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), createBitmap);
                this.K = bitmapDrawable;
                bitmapDrawable.setBounds(0, 0, this.f349477i, ceil);
            } catch (Exception e16) {
                QLog.w("AtTroopMemberSpan", 2, "createDrawable Exception", e16);
            }
        }
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f349475f;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Drawable) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.K;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        if (this.K == null || (i16 - i3 == 1 && this.f349476h.length() != 1 && i3 != 0)) {
            return 0;
        }
        if (!TextUtils.isEmpty(this.C) && i3 < i16 && !"@".contentEquals(charSequence.subSequence(i3, i3 + 1))) {
            return 0;
        }
        return this.K.getBounds().right;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f349473d;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.H;
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.G;
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f349474e;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f349473d) && this.f349473d.equalsIgnoreCase("0")) {
            return true;
        }
        return false;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f349473d) && !this.f349473d.equalsIgnoreCase("0")) {
            return true;
        }
        return false;
    }
}
