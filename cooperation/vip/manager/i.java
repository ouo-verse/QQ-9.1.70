package cooperation.vip.manager;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class i {

    /* renamed from: f, reason: collision with root package name */
    private static i f391300f;

    /* renamed from: g, reason: collision with root package name */
    private static Object f391301g = new Object();

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f391302a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f391303b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f391304c = -1;

    /* renamed from: d, reason: collision with root package name */
    private String f391305d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f391306e = null;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements SharedPreferences.OnSharedPreferenceChangeListener {
        a() {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + str);
                }
                if (!i.this.f391303b && i.this.f391302a != null) {
                    if (i.this.l(runtime.getAccount()).equals(str)) {
                        i iVar = i.this;
                        iVar.f391304c = iVar.f391302a.getInt(str, 0);
                    }
                    if (i.this.n(runtime.getAccount()).equals(str)) {
                        i iVar2 = i.this;
                        iVar2.f391305d = iVar2.f391302a.getString(str, null);
                    }
                    if (i.this.m(runtime.getAccount()).equals(str)) {
                        i iVar3 = i.this;
                        iVar3.f391306e = iVar3.f391302a.getString(str, null);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + i.this.f391304c + " personlizedYellowVipUrl = " + i.this.f391305d);
                    }
                }
                i.this.f391303b = false;
            }
        }
    }

    i() {
        SharedPreferences vipInfo = VasMMKV.getVipInfo(BaseApplicationImpl.getApplication(), "QZONE_VIP_INFO");
        this.f391302a = vipInfo;
        if (vipInfo != null) {
            vipInfo.registerOnSharedPreferenceChangeListener(new a());
        }
    }

    public static int A(int i3) {
        return w(i3, 0, 1);
    }

    public static boolean B(int i3) {
        if (w(i3, 6, 6) != 0) {
            return true;
        }
        return false;
    }

    public static boolean C(int i3) {
        if (w(i3, 22, 22) != 0) {
            return true;
        }
        return false;
    }

    public static boolean D(int i3) {
        if (w(i3, 21, 21) != 0) {
            return true;
        }
        return false;
    }

    public static boolean E(int i3) {
        if (w(i3, 24, 24) != 0) {
            return true;
        }
        return false;
    }

    public static boolean F(int i3) {
        if (w(i3, 23, 23) != 0) {
            return true;
        }
        return false;
    }

    public static boolean H(int i3) {
        if (w(i3, 13, 13) != 0) {
            return true;
        }
        return false;
    }

    public static boolean I(int i3) {
        if (w(i3, 25, 25) != 0) {
            return true;
        }
        return false;
    }

    private void J() {
        K(false);
    }

    private void K(boolean z16) {
        AppRuntime runtime;
        if ((this.f391304c < 0 || z16) && this.f391302a != null && (runtime = BaseApplicationImpl.getApplication().getRuntime()) != null) {
            this.f391304c = this.f391302a.getInt(l(runtime.getAccount()), 0);
            this.f391305d = this.f391302a.getString(n(runtime.getAccount()), null);
            this.f391306e = this.f391302a.getString(m(runtime.getAccount()), null);
        }
    }

    private void L() {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f391302a;
        if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            this.f391303b = true;
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                edit.putInt(l(runtime.getAccount()), this.f391304c);
                edit.putString(n(runtime.getAccount()), this.f391305d);
                edit.putString(m(runtime.getAccount()), this.f391306e);
                edit.commit();
            }
        }
    }

    public static int M(int i3, int i16) {
        if (i16 >= 0 && i16 <= 9) {
            return Z(i3, i16, 17, 20);
        }
        return i3;
    }

    public static int N(int i3, int i16) {
        if (i16 >= 0 && i16 <= 6) {
            return Z(i3, i16, 14, 16);
        }
        return i3;
    }

    public static int O(int i3, boolean z16) {
        return Z(i3, z16 ? 1 : 0, 6, 6);
    }

    public static int P(int i3, boolean z16) {
        return Z(i3, z16 ? 1 : 0, 22, 22);
    }

    public static int Q(int i3, boolean z16) {
        return Z(i3, z16 ? 1 : 0, 21, 21);
    }

    public static int R(int i3, boolean z16) {
        return Z(i3, z16 ? 1 : 0, 24, 24);
    }

    public static int S(int i3, boolean z16) {
        return Z(i3, z16 ? 1 : 0, 23, 23);
    }

    public static int T(int i3, boolean z16) {
        return Z(i3, z16 ? 1 : 0, 13, 13);
    }

    public static int U(int i3, boolean z16) {
        return Z(i3, z16 ? 1 : 0, 25, 25);
    }

    public static int V(int i3, int i16) {
        if (i16 >= 0 && i16 <= 9) {
            return Z(i3, i16, 30, 30);
        }
        return i3;
    }

    public static int W(int i3, int i16) {
        if (i16 >= 0 && i16 <= 8) {
            return Z(i3, i16, 9, 12);
        }
        return i3;
    }

    public static int X(int i3, int i16) {
        if (i16 >= 0 && i16 <= 2) {
            return Z(i3, i16, 7, 8);
        }
        return i3;
    }

    public static int Y(int i3, int i16) {
        if (i16 >= 0 && i16 <= 9) {
            return Z(i3, i16, 26, 29);
        }
        return i3;
    }

    private static int Z(int i3, int i16, int i17, int i18) {
        return (i3 & ((1 << i17) - 1)) | (i16 << i17) | (((-1) << (i18 + 1)) & i3);
    }

    public static int a0(int i3, int i16) {
        if (i16 >= 0 && i16 <= 10) {
            return Z(i3, i16, 2, 5);
        }
        return i3;
    }

    public static int b0(int i3, int i16) {
        if (i16 >= 0 && i16 <= 2) {
            return Z(i3, i16, 0, 1);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l(String str) {
        return "key_vip_info_bitmap_pre" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(String str) {
        return "key_vip_info_custom_diamond_url_pre" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n(String str) {
        return "key_vip_info_personalized_vip_pre" + str;
    }

    public static int o(int i3) {
        return w(i3, 17, 20);
    }

    public static int p(int i3) {
        return w(i3, 14, 16);
    }

    public static i r() {
        if (f391300f == null) {
            synchronized (f391301g) {
                if (f391300f == null) {
                    f391300f = new i();
                }
            }
        }
        return f391300f;
    }

    public static int s(int i3) {
        return w(i3, 30, 30);
    }

    public static int t(int i3) {
        return w(i3, 9, 12);
    }

    public static int u(int i3) {
        return w(i3, 7, 8);
    }

    public static int v(int i3) {
        return w(i3, 26, 29);
    }

    private static int w(int i3, int i16, int i17) {
        int i18 = 1;
        int i19 = (i17 - i16) + 1;
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 != 3) {
                    if (i19 != 4) {
                        i18 = 0;
                    } else {
                        i18 = 15;
                    }
                } else {
                    i18 = 7;
                }
            } else {
                i18 = 3;
            }
        }
        if (i18 == 0) {
            return 0;
        }
        return (i3 >> i16) & i18;
    }

    public static int y(int i3) {
        return w(i3, 2, 5);
    }

    public boolean G() {
        J();
        return I(this.f391304c);
    }

    public void c0(int i3) {
        if (i3 >= 0 && i3 <= 2) {
            J();
            this.f391304c = b0(this.f391304c, i3);
            L();
        }
    }

    public void d0(int i3, int i16, int i17, star_info star_infoVar, combine_diamond_info combine_diamond_infoVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        VasLogReporter.getQzoneVip().reportLow("updateVipInfo iYellowType|iYellowLevel|isAnnualVip| " + i3 + "|" + i16 + "|" + i17 + "|");
        boolean z26 = true;
        K(true);
        int b06 = b0(this.f391304c, i3);
        this.f391304c = b06;
        int a06 = a0(b06, i16);
        this.f391304c = a06;
        if (i17 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int O = O(a06, z16);
        this.f391304c = O;
        if (star_infoVar != null) {
            int X = X(O, star_infoVar.iStarStatus);
            this.f391304c = X;
            int W = W(X, star_infoVar.iStarLevel);
            this.f391304c = W;
            if (star_infoVar.isAnnualVip != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            int T = T(W, z18);
            this.f391304c = T;
            if (star_infoVar.isHighStarVip != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            this.f391304c = S(T, z19);
        }
        if (combine_diamond_infoVar != null) {
            int N = N(this.f391304c, combine_diamond_infoVar.iShowType);
            this.f391304c = N;
            int M = M(N, combine_diamond_infoVar.iVipLevel);
            this.f391304c = M;
            if (combine_diamond_infoVar.isAnnualVip != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            int Q = Q(M, z17);
            this.f391304c = Q;
            if (combine_diamond_infoVar.isAnnualVipEver == 0) {
                z26 = false;
            }
            this.f391304c = P(Q, z26);
        }
        Intent intent = new Intent("com.tencent.qq.syncQzoneVipInfoAction");
        Bundle bundle = new Bundle();
        bundle.putInt("com.tencent.qq.syncQzoneVipInfoStr", this.f391304c);
        bundle.putString("com.tencent.qq.syncQzoneVipInfoPersonalized", this.f391305d);
        bundle.putString("com.tencent.qq.syncQzoneVipInfoCustomDiamondUrl", this.f391306e);
        intent.putExtras(bundle);
        BaseApplication.getContext().sendBroadcast(intent);
        L();
    }

    public String q() {
        J();
        return this.f391306e;
    }

    public int x() {
        J();
        return y(this.f391304c);
    }

    public int z() {
        J();
        return A(this.f391304c);
    }
}
