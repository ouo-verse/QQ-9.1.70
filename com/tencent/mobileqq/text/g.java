package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f292681a;

    /* renamed from: b, reason: collision with root package name */
    private List<l> f292682b;

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f292681a = "";
            this.f292682b = new ArrayList();
        }
    }

    private g a(l lVar) {
        if (lVar != null) {
            this.f292682b.add(lVar);
        }
        this.f292681a = j();
        return this;
    }

    private static boolean d(int i3) {
        if ((i3 < 9728 || i3 > 10175) && i3 != 12349 && i3 != 8265 && i3 != 8252 && ((i3 < 8192 || i3 > 8207) && ((i3 < 8232 || i3 > 8239) && i3 != 8287 && ((i3 < 8293 || i3 > 8303) && ((i3 < 8448 || i3 > 8527) && ((i3 < 8960 || i3 > 9215) && ((i3 < 11008 || i3 > 11263) && ((i3 < 10496 || i3 > 10623) && ((i3 < 12800 || i3 > 13055) && ((i3 < 55296 || i3 > 57343) && ((i3 < 57344 || i3 > 63743) && ((i3 < 65024 || i3 > 65039) && i3 < 65536)))))))))))) {
            return false;
        }
        return true;
    }

    private void g(StringBuilder sb5, int i3) {
        int i16;
        int i17;
        int i18;
        int length = this.f292681a.length();
        int length2 = this.f292681a.length();
        int i19 = (int) ((i3 * BaseApplication.getContext().getResources().getDisplayMetrics().density) + 0.5f);
        int i26 = 0;
        while (i26 < length2) {
            if (sb5.charAt(i26) == '<' && i26 < length - 2) {
                int i27 = i26 + 1;
                char charAt = sb5.charAt(i27);
                if (charAt == '$' && i26 < length - 3) {
                    int i28 = i26 + 2;
                    char charAt2 = sb5.charAt(i28);
                    boolean z16 = QQText.IS_FXXKED_MTK;
                    if (z16) {
                        sb5.replace(i27, i26 + 3, "##");
                    } else if (charAt2 == '\n') {
                        sb5.setCharAt(i28, AbsQQText.RF);
                    }
                    if (charAt2 < QQSysFaceUtil.maxServerId()) {
                        int i29 = i26 + 3;
                        if (sb5.charAt(i29) == '>') {
                            int convertToLocal = QQSysFaceUtil.convertToLocal(charAt2);
                            if (convertToLocal == 250) {
                                i18 = 10;
                            } else {
                                i18 = convertToLocal;
                            }
                            if (i18 < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) {
                                i16 = i26 + 4;
                                a(new j(sb5.substring(i26, i16), i18, i19));
                                i26 = i16;
                            } else {
                                i26++;
                            }
                        } else if (sb5.charAt(i26 + 6) == '>') {
                            char[] cArr = new char[3];
                            cArr[0] = sb5.charAt(i29);
                            cArr[1] = sb5.charAt(i26 + 4);
                            cArr[2] = (char) (sb5.charAt(i26 + 5) & '\u00ff');
                            for (int i36 = 0; i36 < 3; i36++) {
                                char c16 = cArr[i36];
                                if (c16 == '\u00fa') {
                                    cArr[i36] = '\n';
                                } else if (c16 == '\u00fe') {
                                    cArr[i36] = '\r';
                                }
                            }
                            i16 = i26 + 7;
                            a(new k(sb5.substring(i26, i16), charAt2, i19));
                            for (int i37 = 2; i37 < 5; i37++) {
                                int i38 = i26 + i37;
                                if (sb5.charAt(i38) == '\n') {
                                    sb5.setCharAt(i38, AbsQQText.RF);
                                } else if (sb5.charAt(i38) == '\r') {
                                    sb5.setCharAt(i38, AbsQQText.ENTER_REPLACE);
                                }
                            }
                            i26 = i16;
                        } else {
                            i26++;
                        }
                    } else if (charAt2 >= '\u00ff' && (i17 = i26 + 6) < length) {
                        if (sb5.charAt(i17) == '>') {
                            char[] cArr2 = new char[3];
                            cArr2[0] = sb5.charAt(i26 + 3);
                            cArr2[1] = sb5.charAt(i26 + 4);
                            cArr2[2] = (char) (sb5.charAt(i26 + 5) & '\u00ff');
                            for (int i39 = 0; i39 < 3; i39++) {
                                char c17 = cArr2[i39];
                                if (c17 == '\u00fa') {
                                    cArr2[i39] = '\n';
                                } else if (c17 == '\u00fe') {
                                    cArr2[i39] = '\r';
                                }
                            }
                            i16 = i26 + 7;
                            a(new k(sb5.substring(i26, i16), charAt2, i19));
                            for (int i46 = 2; i46 < 5; i46++) {
                                int i47 = i26 + i46;
                                if (sb5.charAt(i47) == '\n') {
                                    sb5.setCharAt(i47, AbsQQText.RF);
                                } else if (sb5.charAt(i47) == '\r') {
                                    sb5.setCharAt(i47, AbsQQText.ENTER_REPLACE);
                                }
                            }
                            i26 = i16;
                        } else {
                            i26++;
                        }
                    } else if (charAt2 == '\u00fa') {
                        if (z16) {
                            sb5.replace(i27, i26 + 3, "##");
                        }
                        i16 = i26 + 4;
                        a(new j(sb5.substring(i26, i16), 10, i19));
                        i26 = i16;
                    } else {
                        i26++;
                    }
                } else {
                    if ((charAt == '%' || charAt == '&') && i26 < length - 6) {
                        i16 = i26 + 7;
                        a(new i(sb5.substring(i26, i16)));
                        i26 = i16;
                    }
                    i26++;
                }
            } else if (Character.isHighSurrogate(sb5.charAt(i26)) && i26 <= length - 2 && Character.isSurrogatePair(sb5.charAt(i26), sb5.charAt(i26 + 1)) && d(sb5.toString().codePointAt(i26))) {
                i16 = i26 + 2;
                a(new f(sb5.substring(i26, i16)));
                i26 = i16;
            } else {
                a(new h(String.valueOf(sb5.charAt(i26))));
                i26++;
            }
        }
    }

    public g b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (g) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        g gVar = new g();
        for (l lVar : this.f292682b) {
            if (lVar.b() != i3) {
                gVar.a(lVar);
            }
        }
        return gVar;
    }

    public g c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (g) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        g gVar = new g();
        for (l lVar : this.f292682b) {
            if (lVar.b() == i3) {
                gVar.a(lVar);
            }
        }
        return gVar;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f292682b.size();
    }

    public float f(Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, (Object) this, (Object) paint)).floatValue();
        }
        float f16 = 0.0f;
        for (int i3 = 0; i3 < e(); i3++) {
            f16 += h(i3).c(paint);
        }
        return f16;
    }

    @NonNull
    public l h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (l) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.f292682b.size()) {
            return this.f292682b.get(i3);
        }
        throw new IndexOutOfBoundsException("NickString index error");
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        for (l lVar : this.f292682b) {
            if (lVar.b() == 0 || lVar.b() == 1) {
                sb5.append(lVar.a());
            }
        }
        return sb5.toString();
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<l> it = this.f292682b.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().a());
        }
        return sb5.toString();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return i();
    }

    public g(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            return;
        }
        this.f292681a = str == null ? "" : str;
        this.f292682b = new ArrayList();
        g(new StringBuilder(this.f292681a), i3);
    }
}
