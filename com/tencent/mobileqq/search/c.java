package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ChnToSpell;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends j {

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.qqnt.ntrelation.friendsinfo.bean.c f283090f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f283091g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f283092h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f283093i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f283094j0;

    /* renamed from: k0, reason: collision with root package name */
    public String f283095k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f283096l0;

    /* renamed from: m0, reason: collision with root package name */
    private String f283097m0;

    /* renamed from: n0, reason: collision with root package name */
    private QQAppInterface f283098n0;

    @SuppressLint({"DefaultLocale"})
    public c(Context context, QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar, String str, long j3, long j16) {
        this.f283090f0 = cVar;
        this.f283442d = j16;
        this.f283091g0 = str;
        this.f283098n0 = qQAppInterface;
        if (cVar.r() != null && this.f283090f0.r().length() != 0) {
            this.f283092h0 = ChnToSpell.d(this.f283090f0.r(), 1).toLowerCase();
            this.f283093i0 = ChnToSpell.d(this.f283090f0.r(), 2).toLowerCase();
        }
        if (this.f283090f0.p() != null && this.f283090f0.p().length() != 0) {
            this.f283094j0 = ChnToSpell.d(this.f283090f0.p(), 1).toLowerCase();
            this.f283095k0 = ChnToSpell.d(this.f283090f0.p(), 2).toLowerCase();
        }
        i();
    }

    private String n() {
        if (!TextUtils.isEmpty(this.f283090f0.c())) {
            return this.f283090f0.c();
        }
        return this.f283090f0.x();
    }

    @Override // com.tencent.mobileqq.search.j
    public String d() {
        return this.f283090f0.x();
    }

    @Override // com.tencent.mobileqq.search.j
    public String f() {
        String r16 = this.f283090f0.r();
        String p16 = this.f283090f0.p();
        String c16 = this.f283090f0.c();
        String x16 = this.f283090f0.x();
        int i3 = this.f283096l0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    if ((p16 != null && p16.length() != 0) || (r16 != null && r16.length() != 0)) {
                        String format = String.format("%s", l());
                        this.f283097m0 = c16;
                        return format;
                    }
                    return c16;
                }
                if (p16 != null && p16.length() != 0) {
                    String format2 = String.format("%s", r16);
                    this.f283097m0 = p16;
                    return format2;
                }
                return r16;
            }
            if (r16 != null && r16.length() != 0) {
                String format3 = String.format("%s", r16);
                this.f283097m0 = p16;
                return format3;
            }
            String format4 = String.format("%s", p16);
            this.f283097m0 = n();
            return format4;
        }
        if ((p16 != null && p16.length() != 0) || (r16 != null && r16.length() != 0)) {
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(r16)) {
                r16 = p16;
            }
            objArr[0] = r16;
            String format5 = String.format("%s", objArr);
            this.f283097m0 = n();
            return format5;
        }
        return x16;
    }

    @Override // com.tencent.mobileqq.search.j
    public String g() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.j
    public Object h() {
        return this.f283090f0;
    }

    @Override // com.tencent.mobileqq.search.j
    protected long j() {
        Message lastMessage = this.f283098n0.getMessageFacade().getLastMessage(this.f283090f0.x(), 0);
        if (lastMessage != null) {
            return lastMessage.time;
        }
        return 0L;
    }

    public String l() {
        if (!TextUtils.isEmpty(this.f283090f0.r())) {
            return this.f283090f0.r();
        }
        if (!TextUtils.isEmpty(this.f283090f0.p())) {
            return this.f283090f0.p();
        }
        if (!TextUtils.isEmpty(this.f283090f0.c())) {
            return this.f283090f0.c();
        }
        return this.f283090f0.x();
    }

    public int m() {
        return this.f283096l0;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b7  */
    @Override // com.tencent.mobileqq.search.l
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void match(String str) {
        String str2;
        String str3;
        String str4;
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        long j26;
        int i3;
        long j27;
        long j28;
        long j29;
        long j36;
        int i16;
        int i17;
        long j37;
        long j38;
        String str5 = null;
        if (this.f283090f0.r() != null) {
            str2 = this.f283090f0.r().toLowerCase();
        } else {
            str2 = null;
        }
        if (this.f283090f0.p() != null) {
            str3 = this.f283090f0.p().toLowerCase();
        } else {
            str3 = null;
        }
        if (this.f283090f0.x() != null) {
            str4 = this.f283090f0.x();
        } else {
            str4 = null;
        }
        if (this.f283090f0.c() != null) {
            str5 = this.f283090f0.c();
        }
        String str6 = this.f283092h0;
        String str7 = this.f283093i0;
        String str8 = this.f283094j0;
        String str9 = this.f283095k0;
        String lowerCase = str.toLowerCase();
        this.f283441c = Long.MIN_VALUE;
        int i18 = -1;
        if (str2 != null && str2.length() != 0) {
            if (!str2.equals(lowerCase) && ((str6 == null || !str6.equals(lowerCase)) && (str7 == null || !str7.equals(lowerCase)))) {
                int indexOf = str2.indexOf(lowerCase);
                if (str6 != null) {
                    i16 = str6.indexOf(lowerCase);
                } else {
                    i16 = -1;
                }
                if (str7 != null) {
                    i17 = str7.indexOf(lowerCase);
                } else {
                    i17 = -1;
                }
                if (indexOf < 0 && i16 < 0 && i17 < 0) {
                    j3 = Long.MIN_VALUE;
                    if (this.f283441c < j3) {
                        this.f283441c = j3;
                        this.f283096l0 = 2;
                    }
                } else {
                    if (indexOf != 0 && i16 != 0 && i17 != 0) {
                        j37 = j.E;
                    } else {
                        j37 = j.C;
                    }
                    if (indexOf < 0 && !str2.equals(str6)) {
                        j38 = j.f283436x;
                    } else {
                        j38 = j.f283435w;
                    }
                    j36 = j37 + j38 + 0;
                }
            } else {
                long j39 = j.f283438z;
                if (!str2.equals(lowerCase) && !str2.equals(str6)) {
                    j29 = j.f283436x;
                } else {
                    j29 = j.f283435w;
                }
                j36 = j39 + j29 + 0;
            }
            j3 = j36;
            if (this.f283441c < j3) {
            }
        } else {
            j3 = Long.MIN_VALUE;
        }
        if (str3 != null && str3.length() != 0) {
            if (!str3.equals(lowerCase) && ((str8 == null || !str8.equals(lowerCase)) && (str9 == null || !str9.equals(lowerCase)))) {
                int indexOf2 = str3.indexOf(lowerCase);
                if (str8 != null) {
                    i3 = str8.indexOf(lowerCase);
                } else {
                    i3 = -1;
                }
                if (str9 != null) {
                    i18 = str9.indexOf(lowerCase);
                }
                if (indexOf2 >= 0 || i3 >= 0 || i18 >= 0) {
                    if (indexOf2 != 0 && i3 != 0 && i18 != 0) {
                        j27 = j.E;
                    } else {
                        j27 = j.C;
                    }
                    if (indexOf2 < 0 && !str3.equals(str8)) {
                        j28 = j.f283436x;
                    } else {
                        j28 = j.f283435w;
                    }
                    j26 = j27 + j28;
                    TextUtils.isEmpty(this.f283090f0.r());
                }
                if (this.f283441c < j3) {
                    this.f283441c = j3;
                    this.f283096l0 = 1;
                }
            } else {
                long j46 = j.f283438z;
                if (!str3.equals(lowerCase) && !str3.equals(str8)) {
                    j19 = j.f283436x;
                } else {
                    j19 = j.f283435w;
                }
                j26 = j46 + j19;
                TextUtils.isEmpty(this.f283090f0.r());
            }
            j3 = j26 + 0;
            if (this.f283441c < j3) {
            }
        }
        if (str5 != null && str5.length() != 0) {
            if (str5.equals(lowerCase)) {
                j18 = j.f283438z + j.f283435w;
                if (TextUtils.isEmpty(this.f283090f0.r())) {
                    TextUtils.isEmpty(this.f283090f0.p());
                }
            } else {
                if (str5.indexOf(lowerCase) >= 0) {
                    j18 = j.E + j.f283435w;
                    if (TextUtils.isEmpty(this.f283090f0.r())) {
                        TextUtils.isEmpty(this.f283090f0.p());
                    }
                }
                if (this.f283441c < j3) {
                    this.f283441c = j3;
                    this.f283096l0 = 3;
                }
            }
            j3 = j18 + 0;
            if (this.f283441c < j3) {
            }
        }
        if (1 != this.f283090f0.e().byteValue()) {
            if (str4 != null) {
                if (str4.equals(lowerCase)) {
                    j17 = j.f283438z + j.f283435w;
                    if (TextUtils.isEmpty(this.f283090f0.r())) {
                        TextUtils.isEmpty(this.f283090f0.p());
                    }
                } else {
                    int indexOf3 = str4.indexOf(lowerCase);
                    if (indexOf3 >= 0) {
                        if (indexOf3 == 0) {
                            j16 = j.C;
                        } else {
                            j16 = j.E;
                        }
                        j17 = j16 + j.f283435w;
                        if (TextUtils.isEmpty(this.f283090f0.r())) {
                            TextUtils.isEmpty(this.f283090f0.p());
                        }
                    }
                }
                j3 = j17 + 0;
            }
            if (this.f283441c < j3) {
                this.f283441c = j3;
                this.f283096l0 = 0;
            }
        }
        long j47 = this.f283441c;
        if (j47 != Long.MIN_VALUE) {
            this.f283441c = j47 + this.f283442d;
        }
    }
}
