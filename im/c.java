package im;

import android.app.Activity;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.util.o;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import im.b;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJJ\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002Jh\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lim/c;", "", "", "openId", CommonConstant.KEY_ACCESS_TOKEN, "c", "psKey", "b", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "g", "spaceId", "serviceCode", "serviceName", "productId", "productType", "productNum", "f", "e", "Ljava/lang/String;", "PS_KEY_DOMAIN", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f407941a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String PS_KEY_DOMAIN = "vip.qq.com";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"im/c$a", "Lcom/tencent/midas/api/IAPMidasPayCallBack;", "", "MidasPayNeedLogin", "Lcom/tencent/midas/api/APMidasResponse;", "midasResponse", "MidasPayCallBack", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements IAPMidasPayCallBack {
        a() {
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayCallBack(APMidasResponse midasResponse) {
            RFWLog.d("QZonePayManager", RFWLog.USR, "MidasPayCallBack, " + midasResponse);
            o.f59556a.d("\u652f\u4ed8\u5b8c\u6210, code: " + (midasResponse != null ? Integer.valueOf(midasResponse.resultCode) : null) + ", msg: " + (midasResponse != null ? midasResponse.resultMsg : null), 1);
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public void MidasPayNeedLogin() {
            RFWLog.d("QZonePayManager", RFWLog.USR, "MidasPayNeedLogin");
            o.f59556a.d("\u9700\u8981\u767b\u5f55", 1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"im/c$b", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407943a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407944b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407945c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f407946d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f407947e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f407948f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f407949g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f407950h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f407951i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f407952j;

        b(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f407943a = objectRef;
            this.f407944b = objectRef2;
            this.f407945c = objectRef3;
            this.f407946d = activity;
            this.f407947e = str;
            this.f407948f = str2;
            this.f407949g = str3;
            this.f407950h = str4;
            this.f407951i = str5;
            this.f407952j = str6;
        }

        @Override // sd2.a
        public void onFail(String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            RFWLog.d("QZonePayManager", RFWLog.USR, "getPskey onFail, errMsg: " + errMsg);
        }

        /* JADX WARN: Type inference failed for: r13v1, types: [T, java.lang.Object] */
        @Override // sd2.a
        public void onSuccess(Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            this.f407943a.element = domainToKeyMap.get(c.PS_KEY_DOMAIN);
            boolean z16 = true;
            RFWLog.d("QZonePayManager", RFWLog.DEV, "getPskey onSuccess, pskeyStr: " + ((Object) this.f407943a.element));
            String str = this.f407944b.element;
            if (str == null || str.length() == 0) {
                return;
            }
            String str2 = this.f407945c.element;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            String str3 = this.f407943a.element;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            c.f407941a.e(this.f407946d, this.f407947e, this.f407944b.element, this.f407945c.element, this.f407943a.element, this.f407948f, this.f407949g, this.f407950h, this.f407951i, this.f407952j);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"im/c$d", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407963a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407964b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407965c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f407966d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f407967e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f407968f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f407969g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f407970h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f407971i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f407972j;

        d(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f407963a = objectRef;
            this.f407964b = objectRef2;
            this.f407965c = objectRef3;
            this.f407966d = activity;
            this.f407967e = str;
            this.f407968f = str2;
            this.f407969g = str3;
            this.f407970h = str4;
            this.f407971i = str5;
            this.f407972j = str6;
        }

        @Override // sd2.a
        public void onFail(String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            RFWLog.d("QZonePayManager", RFWLog.USR, "getPskey onFail, errMsg: " + errMsg);
        }

        /* JADX WARN: Type inference failed for: r13v1, types: [T, java.lang.Object] */
        @Override // sd2.a
        public void onSuccess(Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            this.f407963a.element = domainToKeyMap.get(c.PS_KEY_DOMAIN);
            boolean z16 = true;
            RFWLog.d("QZonePayManager", RFWLog.DEV, "getPskey onSuccess, pskeyStr: " + ((Object) this.f407963a.element));
            String str = this.f407964b.element;
            if (str == null || str.length() == 0) {
                return;
            }
            String str2 = this.f407965c.element;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            String str3 = this.f407963a.element;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            c.f407941a.e(this.f407966d, this.f407967e, this.f407964b.element, this.f407965c.element, this.f407963a.element, this.f407968f, this.f407969g, this.f407970h, this.f407971i, this.f407972j);
        }
    }

    c() {
    }

    private final String b(String psKey) {
        String str = "pskey=" + psKey + "&uid=" + LoginData.getInstance().getUid() + "&uin=" + LoginData.getInstance().getUinString();
        RFWLog.d("QZonePayManager", RFWLog.USR, "buildOpenKey: " + str);
        String encode = URLEncoder.encode(str);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(openKey)");
        return encode;
    }

    private final String c(String openId, String accessToken) {
        String str = "payId=" + openId + "&payAuthKey=" + accessToken + "&payLoginType=1";
        RFWLog.d("QZonePayManager", RFWLog.USR, "buildQQPayLoginKey: " + str);
        return str;
    }

    private final String d() {
        String encode = URLEncoder.encode("uin=" + LoginData.getInstance().getUinString());
        Intrinsics.checkNotNullExpressionValue(encode, "encode(\"uin=$uin\")");
        return encode;
    }

    public final void e(Activity activity, String spaceId, String openId, String accessToken, String psKey, String serviceCode, String serviceName, String productId, String productType, String productNum) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWLog.d("QZonePayManager", RFWLog.USR, "doPayRequest, product id is " + productId + ", product type is " + productType + ", product num is " + productNum + ", space id is " + spaceId);
        APMidasSubscribeRequest aPMidasSubscribeRequest = new APMidasSubscribeRequest();
        aPMidasSubscribeRequest.setOfferId("1450175318");
        aPMidasSubscribeRequest.setOpenId(spaceId);
        c cVar = f407941a;
        aPMidasSubscribeRequest.setOpenKey(cVar.b(psKey));
        aPMidasSubscribeRequest.setSessionId("hy_gameid");
        aPMidasSubscribeRequest.setSessionType("st_local_third_party");
        aPMidasSubscribeRequest.setPf("qq_m_qq-2001-android-qzone");
        aPMidasSubscribeRequest.setPfKey("pfKey");
        aPMidasSubscribeRequest.setZoneId("1");
        aPMidasSubscribeRequest.setResId(R.drawable.g5i);
        aPMidasSubscribeRequest.setRemark(cVar.d());
        aPMidasSubscribeRequest.setReserv(cVar.c(openId, accessToken));
        aPMidasSubscribeRequest.setIsCanChange(false);
        aPMidasSubscribeRequest.setProductId(productId);
        aPMidasSubscribeRequest.setSaveValue(productNum);
        aPMidasSubscribeRequest.setAutoPay(TextUtils.equals("2", productType));
        aPMidasSubscribeRequest.setServiceCode(serviceCode);
        aPMidasSubscribeRequest.setServiceName(serviceName);
        APMidasPayAPI.setEnv("test");
        APMidasPayAPI.setLogEnable(true);
        APMidasPayAPI.init(activity, aPMidasSubscribeRequest);
        APMidasPayAPI.setLogCallback(im.a.class);
        APMidasPayAPI.launchPay(activity, aPMidasSubscribeRequest, new a());
    }

    public final void f(Activity activity, String spaceId, String serviceCode, String serviceName, String productId, String productType, String productNum) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        im.b bVar = im.b.f407938a;
        bVar.b();
        bVar.a(activity, true, "102098661", 1, null, new C10540c(objectRef, objectRef2, objectRef3, activity, spaceId, serviceCode, serviceName, productId, productType, productNum));
        IRuntimeService runtimeService = BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getApplication().runtime\u2026ava, ProcessConstant.ALL)");
        ((IPskeyManager) runtimeService).getPskey(new String[]{PS_KEY_DOMAIN}, new b(objectRef3, objectRef, objectRef2, activity, spaceId, serviceCode, serviceName, productId, productType, productNum));
    }

    public final void g(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        im.b bVar = im.b.f407938a;
        bVar.b();
        bVar.a(activity, true, "102098661", 1, null, new e(objectRef, objectRef2, objectRef3, activity, "B_Uq2XGWmsgftYBU6AbkTHzw", "QMKJXZ", "\u661f\u94bb", "xingzuanceshi", "4", "1"));
        IRuntimeService runtimeService = BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPskeyManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getApplication().runtime\u2026ava, ProcessConstant.ALL)");
        ((IPskeyManager) runtimeService).getPskey(new String[]{PS_KEY_DOMAIN}, new d(objectRef3, objectRef, objectRef2, activity, "B_Uq2XGWmsgftYBU6AbkTHzw", "QMKJXZ", "\u661f\u94bb", "xingzuanceshi", "4", "1"));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"im/c$c", "Lim/b$a;", "", "openId", "uin", CommonConstant.KEY_ACCESS_TOKEN, "", "onSuccess", "", "retCode", "retMsg", "onFail", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: im.c$c, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10540c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407953a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407954b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407955c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f407956d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f407957e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f407958f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f407959g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f407960h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f407961i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f407962j;

        C10540c(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f407953a = objectRef;
            this.f407954b = objectRef2;
            this.f407955c = objectRef3;
            this.f407956d = activity;
            this.f407957e = str;
            this.f407958f = str2;
            this.f407959g = str3;
            this.f407960h = str4;
            this.f407961i = str5;
            this.f407962j = str6;
        }

        @Override // im.b.a
        public void onFail(int retCode, String retMsg) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            RFWLog.d("QZonePayManager", RFWLog.USR, "QZoneOpenLoginManager onFail, retCode: " + retCode + ", retMsg: " + retMsg);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // im.b.a
        public void onSuccess(String openId, String uin, String accessToken) {
            boolean z16 = true;
            RFWLog.d("QZonePayManager", RFWLog.DEV, "QZoneOpenLoginManager onSuccess, uin: " + uin + ", openId: " + openId + ", accessToken: " + accessToken);
            Ref.ObjectRef<String> objectRef = this.f407953a;
            objectRef.element = openId;
            this.f407954b.element = accessToken;
            String str = objectRef.element;
            if (str == null || str.length() == 0) {
                return;
            }
            String str2 = this.f407954b.element;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            String str3 = this.f407955c.element;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            c.f407941a.e(this.f407956d, this.f407957e, this.f407953a.element, this.f407954b.element, this.f407955c.element, this.f407958f, this.f407959g, this.f407960h, this.f407961i, this.f407962j);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"im/c$e", "Lim/b$a;", "", "openId", "uin", CommonConstant.KEY_ACCESS_TOKEN, "", "onSuccess", "", "retCode", "retMsg", "onFail", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407973a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407974b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f407975c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f407976d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f407977e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f407978f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f407979g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f407980h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f407981i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f407982j;

        e(Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f407973a = objectRef;
            this.f407974b = objectRef2;
            this.f407975c = objectRef3;
            this.f407976d = activity;
            this.f407977e = str;
            this.f407978f = str2;
            this.f407979g = str3;
            this.f407980h = str4;
            this.f407981i = str5;
            this.f407982j = str6;
        }

        @Override // im.b.a
        public void onFail(int retCode, String retMsg) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            RFWLog.d("QZonePayManager", RFWLog.USR, "QZoneOpenLoginManager onFail, retCode: " + retCode + ", retMsg: " + retMsg);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // im.b.a
        public void onSuccess(String openId, String uin, String accessToken) {
            boolean z16 = true;
            RFWLog.d("QZonePayManager", RFWLog.DEV, "QZoneOpenLoginManager onSuccess, uin: " + uin + ", openId: " + openId + ", accessToken: " + accessToken);
            Ref.ObjectRef<String> objectRef = this.f407973a;
            objectRef.element = openId;
            this.f407974b.element = accessToken;
            String str = objectRef.element;
            if (str == null || str.length() == 0) {
                return;
            }
            String str2 = this.f407974b.element;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            String str3 = this.f407975c.element;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            c.f407941a.e(this.f407976d, this.f407977e, this.f407973a.element, this.f407974b.element, this.f407975c.element, this.f407978f, this.f407979g, this.f407980h, this.f407981i, this.f407982j);
        }
    }
}
