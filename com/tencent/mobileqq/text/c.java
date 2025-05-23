package com.tencent.mobileqq.text;

import android.os.Build;
import android.text.GetChars;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements Spannable, CharSequence, GetChars, Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f292668d;

    /* renamed from: e, reason: collision with root package name */
    private String f292669e;

    /* renamed from: f, reason: collision with root package name */
    public String f292670f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Object> f292671h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<a> f292672i;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f292673a;

        /* renamed from: b, reason: collision with root package name */
        public int f292674b;

        /* renamed from: c, reason: collision with root package name */
        public int f292675c;

        public a(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.f292673a = i3;
            this.f292674b = i16;
            this.f292675c = i17;
        }
    }

    public c(CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) charSequence, i3);
            return;
        }
        this.f292671h = new ArrayList<>();
        this.f292672i = new ArrayList<>();
        this.f292668d = i3;
        if (charSequence == null) {
            this.f292669e = "";
            this.f292670f = "";
            return;
        }
        String charSequence2 = charSequence.toString();
        this.f292670f = charSequence2;
        this.f292669e = charSequence2;
        int i16 = (int) ((i3 * BaseApplication.getContext().getResources().getDisplayMetrics().density) + 0.5f);
        StringBuilder sb5 = new StringBuilder(charSequence);
        c(0, sb5.length(), i16, sb5);
        String sb6 = sb5.toString();
        this.f292669e = sb6;
        if (!QQText.IS_FXXKED_MTK) {
            this.f292670f = sb6;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            int length = charSequence.length();
            Object[] spans = spanned.getSpans(0, charSequence.length(), Object.class);
            for (int i17 = 0; i17 < spans.length; i17++) {
                int spanStart = spanned.getSpanStart(spans[i17]);
                int spanEnd = spanned.getSpanEnd(spans[i17]);
                int spanFlags = spanned.getSpanFlags(spans[i17]);
                spanStart = spanStart < 0 ? 0 : spanStart;
                if (spanEnd > length) {
                    spanEnd = length;
                }
                setSpan(spans[i17], spanStart - 0, spanEnd - 0, spanFlags);
            }
        }
    }

    private void a(Object obj, int i3, int i16, int i17) {
        this.f292671h.add(obj);
        this.f292672i.add(new a(i3, i16, i17));
    }

    private void b(String str, int i3, int i16) {
        if (i16 >= i3) {
            int length = length();
            if (i3 <= length && i16 <= length) {
                if (i3 >= 0 && i16 >= 0) {
                    return;
                }
                throw new IndexOutOfBoundsException(str + " " + e(i3, i16) + " starts before 0");
            }
            throw new IndexOutOfBoundsException(str + " " + e(i3, i16) + " ends beyond length " + length);
        }
        throw new IndexOutOfBoundsException(str + " " + e(i3, i16) + " has end before start");
    }

    private void c(int i3, int i16, int i17, StringBuilder sb5) {
        int i18;
        int i19;
        int i26;
        boolean z16;
        int i27;
        int length = sb5.length();
        int i28 = i3;
        while (i28 < i16) {
            if (sb5.charAt(i28) == '<' && i28 < length - 2) {
                int i29 = i28 + 1;
                char charAt = sb5.charAt(i29);
                if (charAt == '$' && i28 < length - 3) {
                    int i36 = i28 + 2;
                    char charAt2 = sb5.charAt(i36);
                    boolean z17 = QQText.IS_FXXKED_MTK;
                    if (z17) {
                        sb5.replace(i29, i28 + 3, "##");
                    } else if (charAt2 == '\n') {
                        sb5.setCharAt(i36, AbsQQText.RF);
                    }
                    if (charAt2 != '\u00ff' && charAt2 != '\u01ff' && charAt2 != '\u00fa') {
                        if (sb5.charAt(i28 + 3) == '>') {
                            int convertToLocal = QQSysFaceUtil.convertToLocal(charAt2 & '\u00ff');
                            if (convertToLocal == 250) {
                                i27 = 10;
                            } else {
                                i27 = convertToLocal;
                            }
                            if (QQSysFaceUtil.isValidFaceId(i27)) {
                                i19 = i28 + 4;
                                a(new EmoticonSpan(i27, i17, 1), i28, i19, 33);
                                i28 = i19;
                            }
                        }
                    } else if (charAt2 >= '\u00ff' && (i26 = i28 + 6) < length) {
                        if (sb5.charAt(i26) == '>') {
                            char[] cArr = new char[3];
                            cArr[0] = sb5.charAt(i28 + 3);
                            cArr[1] = sb5.charAt(i28 + 4);
                            cArr[2] = (char) (sb5.charAt(i28 + 5) & '\u00ff');
                            for (int i37 = 0; i37 < 3; i37++) {
                                char c16 = cArr[i37];
                                if (c16 == '\u00fa') {
                                    cArr[i37] = '\n';
                                } else if (c16 == '\u00fe') {
                                    cArr[i37] = '\r';
                                }
                            }
                            ISmallEmojiSpanService iSmallEmojiSpanService = (ISmallEmojiSpanService) QRoute.api(ISmallEmojiSpanService.class);
                            if (charAt2 == '\u01ff') {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            ISmallEmojiSpan createSmallEmojiSpan = iSmallEmojiSpanService.createSmallEmojiSpan(cArr, i17, true, z16);
                            i19 = i28 + 7;
                            a(createSmallEmojiSpan, i28, i19, 33);
                            for (int i38 = 2; i38 < 5; i38++) {
                                int i39 = i28 + i38;
                                if (sb5.charAt(i39) == '\n') {
                                    sb5.setCharAt(i39, AbsQQText.RF);
                                } else if (sb5.charAt(i39) == '\r') {
                                    sb5.setCharAt(i39, AbsQQText.ENTER_REPLACE);
                                }
                            }
                            i28 = i19;
                        }
                    } else if (charAt2 == '\u00fa') {
                        if (z17) {
                            sb5.replace(i29, i28 + 3, "##");
                        }
                        i19 = i28 + 4;
                        a(new EmoticonSpan(10, i17, 1), i28, i19, 33);
                        i28 = i19;
                    }
                } else if ((charAt == '%' || charAt == '&') && i28 < length - 6) {
                    int charAt3 = (sb5.charAt(i28 + 2) << 24) + 0 + ((sb5.charAt(i28 + 3) << 16) & ITVKAsset.VOD_ASSET_MASK_BIT) + ((sb5.charAt(i28 + 4) << '\b') & 65280) + (sb5.charAt(i28 + 5) & '\u00ff');
                    if (charAt == '&') {
                        i18 = 2;
                    } else {
                        i18 = 3;
                    }
                    com.tencent.mobileqq.vas.i iVar = new com.tencent.mobileqq.vas.i(i18, charAt3);
                    int i46 = i28 + 7;
                    a(iVar, i28, i46, 33);
                    i28 = i46;
                }
            }
            i28++;
        }
    }

    private static String e(int i3, int i16) {
        return "(" + i3 + " ... " + i16 + ")";
    }

    private void f(Object obj, int i3, int i16) {
        for (SpanWatcher spanWatcher : (SpanWatcher[]) getSpans(i3, i16, SpanWatcher.class)) {
            spanWatcher.onSpanAdded(this, obj, i3, i16);
        }
    }

    private void h(Object obj, int i3, int i16, int i17, int i18) {
        for (SpanWatcher spanWatcher : (SpanWatcher[]) getSpans(Math.min(i3, i17), Math.max(i16, i18), SpanWatcher.class)) {
            spanWatcher.onSpanChanged(this, obj, i3, i16, i17, i18);
        }
    }

    private void i(Object obj, int i3, int i16) {
        for (SpanWatcher spanWatcher : (SpanWatcher[]) getSpans(i3, i16, SpanWatcher.class)) {
            spanWatcher.onSpanRemoved(this, obj, i3, i16);
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Character) iPatchRedirector.redirect((short) 12, (Object) this, i3)).charValue();
        }
        if (i3 >= 0 && i3 <= length()) {
            return this.f292669e.charAt(i3);
        }
        return (char) 0;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f292669e;
    }

    @Override // android.text.GetChars
    public void getChars(int i3, int i16, char[] cArr, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), cArr, Integer.valueOf(i17));
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int length = length();
        if (i16 > length) {
            i16 = length;
        }
        this.f292669e.getChars(i3, i16, cArr, i17);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, obj)).intValue();
        }
        int indexOf = this.f292671h.indexOf(obj);
        if (this.f292672i.size() < indexOf || indexOf < 0) {
            return -1;
        }
        return this.f292672i.get(indexOf).f292674b;
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, obj)).intValue();
        }
        int indexOf = this.f292671h.indexOf(obj);
        if (this.f292672i.size() < indexOf || indexOf < 0) {
            return 0;
        }
        return this.f292672i.get(indexOf).f292675c;
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, obj)).intValue();
        }
        int indexOf = this.f292671h.indexOf(obj);
        if (this.f292672i.size() < indexOf || indexOf < 0) {
            return -1;
        }
        return this.f292672i.get(indexOf).f292673a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.Spanned
    public <T> T[] getSpans(int i3, int i16, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T[]) ((Object[]) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), cls));
        }
        ArrayList arrayList = new ArrayList();
        for (int i17 = 0; i17 < this.f292671h.size(); i17++) {
            Object obj = this.f292671h.get(i17);
            if (cls.isInstance(obj)) {
                a aVar = this.f292672i.get(i17);
                if (aVar.f292673a >= i3 && aVar.f292674b <= i16) {
                    arrayList.add(obj);
                }
            }
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, arrayList.size()));
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            tArr[i18] = arrayList.get(i18);
        }
        return tArr;
    }

    public SpannableString j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SpannableString) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        SpannableString spannableString = new SpannableString(this.f292669e);
        android.text.TextUtils.copySpansFrom(this, 0, length(), Object.class, spannableString, 0);
        return spannableString;
    }

    @Override // java.lang.CharSequence
    public int length() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f292669e.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i3, int i16, Class cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), cls)).intValue();
        }
        if (cls == null) {
            cls = Object.class;
        }
        for (int i17 = 0; i17 < this.f292671h.size(); i17++) {
            Object obj = this.f292671h.get(i17);
            a aVar = this.f292672i.get(i17);
            if (cls.isInstance(obj)) {
                int i18 = aVar.f292673a;
                if (i18 > i3 && i18 < i16) {
                    i16 = i18;
                }
                int i19 = aVar.f292674b;
                if (i19 > i3 && i19 < i16) {
                    i16 = i19;
                }
            }
        }
        return i16;
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
            return;
        }
        int indexOf = this.f292671h.indexOf(obj);
        if (indexOf >= 0) {
            this.f292671h.remove(indexOf);
            a remove = this.f292672i.remove(indexOf);
            i(obj, remove.f292673a, remove.f292674b);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i3, int i16, int i17) {
        char charAt;
        char charAt2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        b("setSpan", i3, i16);
        if ((i17 & 51) == 51) {
            if (i3 != 0 && i3 != length() && (charAt2 = charAt(i3 - 1)) != '\n') {
                throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + i3 + " follows " + charAt2 + ")");
            }
            if (i16 != 0 && i16 != length() && (charAt = charAt(i16 - 1)) != '\n') {
                throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + i16 + " follows " + charAt + ")");
            }
        }
        int indexOf = this.f292671h.indexOf(obj);
        if (indexOf > 0 && this.f292672i.size() > indexOf) {
            a aVar = this.f292672i.get(indexOf);
            int i18 = aVar.f292673a;
            int i19 = aVar.f292674b;
            aVar.f292673a = i3;
            aVar.f292674b = i16;
            aVar.f292675c = i17;
            h(obj, i18, i19, i3, i16);
        }
        if (indexOf < 0) {
            this.f292671h.add(obj);
            this.f292672i.add(new a(i3, i16, i17));
            f(obj, i3, i16);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (CharSequence) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int length = length();
        if (i16 > length) {
            i16 = length;
        }
        if (Build.VERSION.SDK_INT >= 26 && i3 == 0 && i16 == length()) {
            return this;
        }
        return this.f292669e.substring(i3, i16);
    }
}
