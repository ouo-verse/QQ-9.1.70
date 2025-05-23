package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parse.JumpParseConstants;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ax {
    public static int K;
    public static String L;
    public static String M;
    public static String N;
    public static String O;
    private static ArrayList P;
    public BusinessInfoCheckUpdate.AppInfo A;

    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_QQReport.yml", version = 1)
    com.tencent.mobileqq.inject.q D;
    protected Handler E;
    protected boolean F;
    protected boolean G;
    protected AppInterface H;

    /* renamed from: a, reason: collision with root package name */
    public final BaseQQAppInterface f307436a;

    /* renamed from: b, reason: collision with root package name */
    public Context f307437b;

    /* renamed from: c, reason: collision with root package name */
    public String f307438c;

    /* renamed from: d, reason: collision with root package name */
    public String f307439d;

    /* renamed from: e, reason: collision with root package name */
    public String f307440e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f307442g;

    /* renamed from: h, reason: collision with root package name */
    public String f307443h;

    /* renamed from: i, reason: collision with root package name */
    public String f307444i;

    /* renamed from: j, reason: collision with root package name */
    public String f307445j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f307446k;

    /* renamed from: l, reason: collision with root package name */
    public String f307447l;

    /* renamed from: n, reason: collision with root package name */
    public String f307449n;

    /* renamed from: v, reason: collision with root package name */
    public String f307457v;

    /* renamed from: m, reason: collision with root package name */
    public boolean f307448m = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f307450o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f307451p = false;

    /* renamed from: q, reason: collision with root package name */
    public String f307452q = "";

    /* renamed from: r, reason: collision with root package name */
    public String f307453r = "";

    /* renamed from: s, reason: collision with root package name */
    public String f307454s = "";

    /* renamed from: t, reason: collision with root package name */
    public boolean f307455t = false;

    /* renamed from: u, reason: collision with root package name */
    public Hashtable<String, Long> f307456u = new Hashtable<>();

    /* renamed from: w, reason: collision with root package name */
    public boolean f307458w = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f307459x = false;

    /* renamed from: y, reason: collision with root package name */
    public boolean f307460y = false;

    /* renamed from: z, reason: collision with root package name */
    public boolean f307461z = true;
    private boolean B = false;
    private Map<String, Object> C = new HashMap();
    public boolean I = false;
    public boolean J = true;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, String> f307441f = new HashMap<>();

    static {
        ArrayList arrayList = new ArrayList();
        P = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.ab.class);
        K = 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ax(BaseQQAppInterface baseQQAppInterface, Context context) {
        this.f307437b = context;
        this.f307436a = baseQQAppInterface;
        d();
    }

    public static String E(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        if (str.length() != 0) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return new String(PluginBaseInfoHelper.Base64Helper.decode(str, 0));
    }

    private void c(String str) {
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put(JumpParseConstants.KEY_JUMP_PARSER_UTIL_URL_ERROR_KEY, str);
        hashMap.put(JumpParseConstants.KEY_JUMP_PARSER_UTIL_SCENE_ERROR_KEY, "2");
        com.tencent.mobileqq.inject.q qVar = this.D;
        if (qVar != null) {
            qVar.c(hashMap);
        }
    }

    private void d() {
        boolean z16;
        if (this.D == null) {
            j();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[AutoInject] inject:");
            if (this.D != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("JumpAction", 2, sb5.toString());
        }
    }

    public void A(boolean z16) {
        this.f307448m = z16;
        if (QLog.isColorLevel()) {
            QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.f307448m);
        }
    }

    public void B(String str) {
        this.f307444i = str;
    }

    public void C(String str) {
        this.f307445j = str;
    }

    public void D(String str) {
        this.f307449n = str;
    }

    public boolean b() {
        return false;
    }

    public BaseQQAppInterface e() {
        return this.f307436a;
    }

    public String f(String str) {
        return this.f307441f.get(str);
    }

    public Object g(String str) {
        return this.C.get(str);
    }

    public String h() {
        return this.f307439d;
    }

    public void i(String str) {
        HashMap<String, String> hashMap = new HashMap<>(1);
        if (str == null) {
            str = "";
        }
        if (this.f307438c == null) {
            this.f307438c = "";
        }
        if (this.f307439d == null) {
            this.f307439d = "";
        }
        if (this.f307440e == null) {
            this.f307440e = "";
        }
        hashMap.put(JumpParseConstants.KEY_JUMP_PARSER_DOACTION_ERROR_INFO, str + "source:" + this.f307438c + "server_name:" + this.f307439d + "action_name:" + this.f307440e);
        com.tencent.mobileqq.inject.q qVar = this.D;
        if (qVar != null) {
            qVar.b(hashMap);
        }
    }

    @QAutoInitMethod
    void j() {
        this.D = (com.tencent.mobileqq.inject.q) com.tencent.mobileqq.qroute.utils.b.a(P);
    }

    public boolean k() {
        return this.B;
    }

    public boolean l() {
        c(this.f307438c);
        return false;
    }

    public boolean m() {
        if (this.f307439d.equals("share") && this.f307440e.equals("to_fri")) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if (this.f307439d.equals("im") && this.f307440e.equals("aioorprofile")) {
            return true;
        }
        if (this.f307439d.equals(VipFunCallConstants.KEY_GROUP) && this.f307440e.equals("creategroup")) {
            return true;
        }
        if (this.f307439d.equals("qstory") && this.f307440e.equals("publish")) {
            return true;
        }
        return false;
    }

    public boolean o() {
        c(this.f307438c);
        return false;
    }

    public boolean p() {
        c(this.f307438c);
        return false;
    }

    public boolean q() {
        c(this.f307438c);
        return false;
    }

    public void r(String str, String str2) {
        this.f307441f.put(str, str2);
    }

    public void s(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            this.f307441f.putAll(hashMap);
        }
    }

    public void t(BusinessInfoCheckUpdate.AppInfo appInfo) {
        this.A = appInfo;
    }

    public String toString() {
        return "JumpAction{app=" + this.f307436a + ", context=" + this.f307437b + ", source='" + this.f307438c + "', server_name='" + this.f307439d + "', action_name='" + this.f307440e + "', isFromJumpActivity=" + this.f307442g + ", from='" + this.f307443h + "', pkgName='" + this.f307444i + "', pkgSig='" + this.f307445j + "', isFromQrForFriendCard=" + this.f307446k + ", mCustomUrlParam='" + this.f307447l + "', mNewFlag=" + this.f307448m + ", redTouchInfo='" + this.f307449n + "', mHasRedDot=" + this.f307450o + ", qzoneFeedsKey='" + this.f307452q + "', feedTime='" + this.f307453r + "', feedIndex='" + this.f307454s + "', mHasDigitalRedDot=" + this.f307455t + ", qqHeadList=" + this.f307456u + ", sourceId='" + this.f307457v + "', finishImmediately=" + this.f307458w + ", finishGesturePWDUnlockActivity=" + this.f307459x + ", appInfo=" + this.A + ", mIsInternalAction=" + this.B + ", mObjectAttrs=" + this.C + ", mQQReport=" + this.D + ", mAppConnectCheckTimeoutHandler=" + this.E + ", mGetAppConnectCheckResultTimeout=" + this.F + ", mGetAppConnectCheckResultAnimation=" + this.G + ", mAppInterface=" + this.H + ", needCloseWebView=" + this.I + ", needLogin=" + this.J + '}';
    }

    public void u(AppInterface appInterface) {
        this.H = appInterface;
    }

    public void v(String str) {
        this.f307443h = str;
    }

    public void w() {
        this.f307446k = true;
    }

    public void x(boolean z16) {
        this.f307450o = z16;
    }

    public void y(boolean z16) {
        this.f307451p = z16;
    }

    public void z() {
        this.B = true;
    }
}
