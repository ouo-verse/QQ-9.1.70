package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imsdk.BaseConstants;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.api.IAddTroopAccountIdentityApi;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.troop.selecttroopmember.ISelectTroopMemberStarter;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ad extends WebViewPlugin {
    String C;
    String D;
    String E;
    VideoUploadTask F;
    ImageView G;
    com.tencent.biz.troop.b H;

    /* renamed from: f, reason: collision with root package name */
    String f238812f;

    /* renamed from: h, reason: collision with root package name */
    String f238813h;

    /* renamed from: i, reason: collision with root package name */
    int f238814i;

    /* renamed from: m, reason: collision with root package name */
    int f238815m;

    /* renamed from: d, reason: collision with root package name */
    AtomicBoolean f238810d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    com.tencent.biz.troop.b f238811e = null;
    com.tencent.mobileqq.troop.api.observer.b I = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f238816d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f238817e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f238818f;

        a(long j3, long j16, String str) {
            this.f238816d = j3;
            this.f238817e = j16;
            this.f238818f = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0058 A[Catch: Exception -> 0x008f, TRY_ENTER, TryCatch #0 {Exception -> 0x008f, blocks: (B:12:0x004b, B:15:0x0058, B:16:0x007f, B:20:0x0071), top: B:11:0x004b }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[Catch: Exception -> 0x008f, TryCatch #0 {Exception -> 0x008f, blocks: (B:12:0x004b, B:15:0x0058, B:16:0x007f, B:20:0x0071), top: B:11:0x004b }] */
        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void callback(Bundle bundle) {
            boolean z16;
            String string = bundle.getString("videoPath");
            try {
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    if (file.exists() && file.isFile()) {
                        z16 = true;
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopApiPlugin", 2, "previewRewardVideo: videoPath=" + string + ", " + z16);
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (!z16) {
                            MediaApiPlugin.R(ad.this.mRuntime.a(), string, this.f238816d, this.f238817e);
                            jSONObject.put("ret", 0);
                            jSONObject.put("errMsg", "");
                        } else {
                            jSONObject.put("ret", -2);
                            jSONObject.put("errMsg", HardCodeUtil.qqStr(R.string.uav));
                        }
                        ad.this.callJs(this.f238818f, jSONObject.toString());
                        return;
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                if (!z16) {
                }
                ad.this.callJs(this.f238818f, jSONObject2.toString());
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", e16);
                    return;
                }
                return;
            }
            z16 = false;
            if (QLog.isColorLevel()) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b extends com.tencent.mobileqq.troop.api.observer.b {

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class a implements IAddAcceptBlockStrategy.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TroopInfo f238820a;

            a(TroopInfo troopInfo) {
                this.f238820a = troopInfo;
            }

            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public void onSuccess() {
                ad.this.G(this.f238820a);
            }
        }

        b() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void i(boolean z16, long j3, TroopInfo troopInfo) {
            if (ad.this.f238815m == 0) {
                return;
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopApiPlugin", 2, "AddTroop onSend0x88d_1_forJoinTroop_Ret success.");
                }
                if (!((IAddTroopAccountIdentityApi) QRoute.api(IAddTroopAccountIdentityApi.class)).isNeedAccountIdentity(ad.this.f238815m)) {
                    ad.this.G(troopInfo);
                } else {
                    ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(ad.this.mRuntime.c(), 10002, ad.this.getCurrentContext(), new a(troopInfo));
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopApiPlugin", 2, "AddTroop onSend0x88d_1_forJoinTroop_Ret failed.");
                }
                ad adVar = ad.this;
                adVar.callJs(adVar.f238812f, "{\"result\":-1,\"message\":\"request fail\"}");
                ad.this.U(R.string.h1y);
            }
            ad.this.f238815m = 0;
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void k(int i3, int i16) {
            ad adVar = ad.this;
            if (adVar.f238814i == -1) {
                return;
            }
            if (1 == i3) {
                adVar.U(R.string.f171048c00);
            }
            ad.this.f238814i = -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            ad adVar = ad.this;
            int i17 = adVar.f238814i;
            if (i17 == -1) {
                return;
            }
            if (1 == i3) {
                if (i16 == -2) {
                    adVar.callJs(adVar.f238812f, "{\"result\":1,\"message\":\"ok\"}");
                } else if (i16 == 0 || i16 == 1) {
                    if (i17 != 2 && i17 != 5) {
                        adVar.V(R.string.f171049c01, 2);
                        ad adVar2 = ad.this;
                        adVar2.callJs(adVar2.f238812f, "{\"result\":0,\"message\":\"ok\"}");
                    } else {
                        adVar.callJs(adVar.f238812f, "{\"result\":1,\"message\":\"ok\"}");
                    }
                } else if (i16 != 2) {
                    adVar.U(R.string.f171048c00);
                } else {
                    adVar.U(R.string.i7i);
                }
            }
            ad.this.f238814i = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238822a;

        c(String str) {
            this.f238822a = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.i("WebViewPlugin", 4, "onAllGranted");
            ad.this.J(this.f238822a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.i("WebViewPlugin", 4, "onDenied");
            ad.this.callJs(this.f238822a, "-3", "{}");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238824a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2) {
            super(str);
            this.f238824a = str2;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            if (QLog.isColorLevel()) {
                QLog.e("WebViewPlugin", 2, "onLocationFinish errCode = " + i3);
            }
            ad.this.A(sosoLbsInfo, this.f238824a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(SosoLbsInfo sosoLbsInfo, String str) {
        if (sosoLbsInfo != null && sosoLbsInfo.mLocation != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(QCircleSchemeAttr.Polymerize.LAT, sosoLbsInfo.mLocation.mLat02);
                jSONObject.put("lon", sosoLbsInfo.mLocation.mLon02);
                jSONObject.put("nation", B(sosoLbsInfo.mLocation.nation));
                jSONObject.put("province", B(sosoLbsInfo.mLocation.province));
                jSONObject.put("city", B(sosoLbsInfo.mLocation.city));
                jSONObject.put("district", B(sosoLbsInfo.mLocation.district));
                callJs(str, "0", jSONObject.toString());
                return;
            } catch (Exception e16) {
                QLog.e("WebViewPlugin", 1, "onLocationFinish Failed!", e16);
                callJs(str, "-5", "{}");
                return;
            }
        }
        callJs(str, "-4", "{}");
    }

    private void C(String[] strArr) {
        try {
            String optString = new JSONObject(strArr[0]).optString("callback");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", 1);
            callJs(optString, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void E(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString("callback");
            String optString2 = jSONObject.optString("troopUin");
            String optString3 = jSONObject.optString("memberUin");
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.H = A;
            A.K(optString2, optString3, new e(optString));
        } catch (JSONException e16) {
            QLog.i("TroopApiPlugin", 1, "[getUserTitleAndLevel] exception = " + e16);
        }
    }

    private void F(TroopInfo troopInfo) {
        if (troopInfo.cGroupOption != 3) {
            Intent n3 = AddFriendLogicActivity.n3(getCurrentContext(), troopInfo.troopuin, troopInfo.getTroopDisplayName(), troopInfo.cGroupOption, this.f238815m, troopInfo.joinTroopQuestion, troopInfo.joinTroopAnswer, null, this.C, this.D);
            this.f238814i = troopInfo.cGroupOption;
            startActivityForResult(n3, (byte) 3);
        } else {
            this.f238814i = -1;
            U(R.string.i7i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(TroopInfo troopInfo) {
        long j3 = troopInfo.troopPrivilegeFlag;
        boolean z16 = (128 & j3) != 0;
        boolean z17 = (j3 & 512) != 0;
        Context currentContext = getCurrentContext();
        if (z16 && z17 && currentContext != null) {
            com.tencent.mobileqq.troop.troopnotification.utils.h.d(currentContext, troopInfo.troopuin, "");
            return;
        }
        short s16 = troopInfo.cGroupOption;
        if (s16 == 1) {
            this.f238814i = s16;
            H(troopInfo);
        } else {
            F(troopInfo);
        }
    }

    private void H(TroopInfo troopInfo) {
        this.f238811e.R(troopInfo.troopuin, this.f238815m, this.E, this.D);
    }

    private void I(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("eviluin");
            int optInt = jSONObject.optInt("eviluin_type");
            String optString3 = jSONObject.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(optString2);
            if (!TextUtils.isEmpty(uidFromUin) && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "WebViewPlugin")) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            int optInt2 = jSONObject.optInt("is_anonymous");
            String optString4 = jSONObject.optString(TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID);
            if (QLog.isColorLevel()) {
                QLog.i("WebViewPlugin", 1, "appId=" + optString + ",evilUinType=" + optInt + ",buddyFlag=" + str2 + ",isAnonymous=" + optInt2 + ",contentId=" + optString4);
            }
            com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
            bVar.i(optString);
            bVar.n(optString2);
            bVar.o(optInt);
            bVar.r(optString3);
            bVar.j(str2);
            bVar.s(optInt2);
            bVar.m(optString4);
            ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(getCurrentContext(), bVar);
        } catch (JSONException e16) {
            QLog.e("WebViewPlugin", 1, "jsApi juBao data is error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str) {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new d("webview", str));
        if (QLog.isColorLevel()) {
            QLog.d("WebViewPlugin", 2, "SosoInterface.startLocation");
        }
    }

    private void K(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            this.f238813h = jSONObject.getString("callback");
            if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "openEditUniqTitle:" + jSONObject);
            }
            startActivityForResult(EditUniqueTitleActivity.J2(this.mRuntime.a(), 1, jSONObject.optString("troopUin"), jSONObject.optString("memberUin"), jSONObject.optInt("memberRole"), jSONObject.optString("uniqueTitle")), (byte) 4);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopRankConfig", 2, "openEditUniqTitle exp", e16);
            }
        }
    }

    private void L(String str) {
        QLog.i("WebViewPlugin", 1, "openSelectTroopMember, jsonData: " + str);
        try {
            String string = new JSONObject(str).getString("troopUin");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            ((ISelectTroopMemberStarter) QRoute.api(ISelectTroopMemberStarter.class)).start(this.mRuntime.a(), false, 2, string);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("WebViewPlugin", 1, "JASPI openSelectTroopMember", e16);
        }
    }

    private void M(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TroopApiPlugin", 2, "open troop profile " + strArr[0]);
                    }
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    Bundle d16 = aq.d(jSONObject.optString("troopUin"), "", jSONObject.optInt("from"));
                    d16.putString("authSig", jSONObject.optString("authSig"));
                    d16.putString("join_troop_verify_message", jSONObject.optString("verify_message"));
                    TroopUtils.I(this.mRuntime.a(), d16, 2);
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("TroopApiPlugin", 2, "open troop profile Exception:" + e16);
                }
            }
        }
    }

    private void N(String[] strArr) {
        QLog.i("WebViewPlugin", 1, "openTroopQRPage, args: " + Arrays.toString(strArr) + ", activity = " + this.mRuntime.a());
        if (strArr == null || strArr.length == 0) {
            return;
        }
        try {
            this.f238811e.f0(new JSONObject(strArr[0]));
        } catch (Exception e16) {
            QLog.d("WebViewPlugin", 1, "gotoTroopQRCodeActivity NullPointerException ", e16);
        }
    }

    private void O(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (QLog.isColorLevel()) {
                QLog.d("TroopApiPlugin", 2, "previewRewardVideo:" + jSONObject);
            }
            this.f238811e.C(jSONObject.optString("troopUin"), jSONObject.optString("rewardId"), new a(jSONObject.optLong(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE), jSONObject.optLong("videoDuration"), jSONObject.optString("callback")));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", e16);
            }
        }
    }

    private void Q(String[] strArr) {
        try {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.H = A;
            A.p();
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "saveTroopMemberTitle:" + jSONObject);
            }
            this.H.s0(jSONObject.optString("troopUin"), jSONObject.optString("memberUin"), jSONObject.optInt("titleId"));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopRankConfig", 2, "saveTroopMemberTitle exp:", e16);
            }
        }
    }

    private void S(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    Activity a16 = this.mRuntime.a();
                    Intent intent = new Intent();
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    String optString = jSONObject.optString("callback");
                    if (jSONObject.length() > 0) {
                        callJs(optString, a16.getString(R.string.f196644hv));
                    } else {
                        callJs(optString, a16.getString(R.string.f196634hu));
                    }
                    intent.putExtra("SchoolJsonObject", jSONObject.getString("data"));
                    intent.putExtra("groupCode", jSONObject.getString("groupCode"));
                    a16.setResult(-1, intent);
                    a16.finish();
                }
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("WebViewPlugin", 4, "openRewardDetail, exception:", e16);
                }
            }
        }
    }

    private void T(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "setRedPoint:" + jSONObject);
            }
            if (com.tencent.mobileqq.troop.data.aa.a().d(jSONObject.optString("troopUin"), jSONObject.optString("memberUin"))) {
                Activity a16 = this.mRuntime.a();
                WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
                if (a16 != null && (a16 instanceof AbsBaseWebViewActivity)) {
                    AbsBaseWebViewActivity absBaseWebViewActivity = (AbsBaseWebViewActivity) a16;
                    absBaseWebViewActivity.rightViewImg.setVisibility(0);
                    this.G = new ImageView(absBaseWebViewActivity);
                    RelativeLayout relativeLayout = (RelativeLayout) absBaseWebViewActivity.findViewById(R.id.f166811ie3);
                    if (relativeLayout != null) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(7, R.id.ivTitleBtnRightText);
                        layoutParams.setMargins(0, BaseAIOUtils.f(5.0f, absBaseWebViewActivity.getResources()), BaseAIOUtils.f(5.0f, absBaseWebViewActivity.getResources()), 0);
                        this.G.setLayoutParams(layoutParams);
                        this.G.setVisibility(0);
                        this.G.setImageResource(R.drawable.skin_tips_dot_small);
                        relativeLayout.addView(this.G);
                        return;
                    }
                    return;
                }
                if (webViewFragment != null) {
                    webViewFragment.getSwiftTitleUI().E.setVisibility(0);
                    this.G = new ImageView(webViewFragment.getQBaseActivity());
                    RelativeLayout relativeLayout2 = (RelativeLayout) webViewFragment.getUIStyleHandler().V.findViewById(R.id.f166811ie3);
                    if (relativeLayout2 != null) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams2.addRule(7, R.id.ivTitleBtnRightText);
                        layoutParams2.setMargins(0, BaseAIOUtils.f(5.0f, webViewFragment.getResources()), BaseAIOUtils.f(5.0f, webViewFragment.getResources()), 0);
                        this.G.setLayoutParams(layoutParams2);
                        this.G.setVisibility(0);
                        this.G.setImageResource(R.drawable.skin_tips_dot_small);
                        relativeLayout2.addView(this.G);
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopRankConfig", 2, "setRedPoint exp", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i3, int i16) {
        if (this.mRuntime.a() != null) {
            QQToast.makeText(this.mRuntime.a(), i16, this.mRuntime.a().getString(i3), 0).show(this.mRuntime.a().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    private void X(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (jSONObject.has("switchState")) {
                int optInt = jSONObject.optInt("switchState", 0);
                com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
                this.H = A;
                A.R0(optInt == 0 || optInt == 1);
            }
        } catch (Exception e16) {
            QLog.i("TroopApiPlugin", 1, "[updateTroopIdentityGlobalSwitch] exception = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getCurrentContext() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private void v(String[] strArr) {
        try {
            boolean z16 = false;
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (QLog.isColorLevel()) {
                QLog.d("TroopApiPlugin", 2, "AddTroop:" + jSONObject);
            }
            String optString = jSONObject.optString("troopUin");
            this.f238815m = Integer.parseInt(jSONObject.optString("sourceid"));
            String optString2 = jSONObject.optString("isexactsearch");
            String optString3 = jSONObject.optString("sourceext");
            if (optString3 != null && optString2 != null && !optString3.isEmpty() && !optString2.isEmpty()) {
                try {
                    int parseInt = Integer.parseInt(optString3);
                    boolean z17 = Integer.parseInt(optString2) == 1;
                    int i3 = 30003;
                    if (parseInt == 1) {
                        if (!z17) {
                            i3 = 30005;
                        }
                        this.f238815m = i3;
                    } else if (parseInt == 2) {
                        if (!z17) {
                            i3 = 30007;
                        }
                        this.f238815m = i3;
                    } else if (parseInt == 3) {
                        this.f238815m = z17 ? BaseConstants.ERR_SVR_FRIENDSHIP_ADD_FRIEND_DENY : BaseConstants.ERR_SVR_FRIENDSHIP_GROUP_COUNT_LIMIT;
                    } else if (parseInt == 4) {
                        this.f238815m = z17 ? BaseConstants.ERR_SVR_FRIENDSHIP_BLACKLIST_LIMIT : 30015;
                    } else if (parseInt == 5) {
                        this.f238815m = z17 ? 30017 : 30019;
                    }
                } catch (NumberFormatException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WebViewPlugin", 2, "cast sourceext from web error, sourceExt = " + optString3);
                    }
                }
            }
            this.C = jSONObject.optString("sourcename");
            this.D = jSONObject.optString("authSig");
            this.E = jSONObject.optString("authKey");
            this.f238812f = jSONObject.optString("callback");
            TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(optString);
            if (troopInfoFromCache != null && troopInfoFromCache.isMember()) {
                z16 = true;
            }
            if (z16) {
                U(R.string.f170329mi);
            } else {
                this.f238811e.t0(optString, true);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopApiPlugin", 2, "AddTroop JSONException:" + e16);
            }
            callJs(this.f238812f, "{\"result\":-1,\"message\":\"request fail\"}");
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopApiPlugin", 2, "AddTroop Exception:" + e17);
            }
            callJs(this.f238812f, "{\"result\":-10,\"message\":\"request fail\"}");
        }
    }

    private void w(Activity activity, String str) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP, QQPermissionConstants.Business.SCENE.QQ_TROOP_INFO));
        if (qQPermission != null) {
            if (qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                x(qQPermission, str);
            } else {
                J(str);
            }
        }
    }

    private void x(QQPermission qQPermission, String str) {
        qQPermission.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2, new c(str));
    }

    private void y(String[] strArr) {
        if (this.mRuntime.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int optInt = jSONObject.optInt("type", -1);
            int optInt2 = jSONObject.optInt("value", 0);
            boolean z16 = optInt2 == 1;
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "updateSmartManagerSettingStatus, id: " + optInt + ", value: " + optInt2);
            }
            Intent intent = new Intent("action_update_smart_manager_setting_status");
            intent.setPackage(BaseApplicationImpl.getApplication().getPackageName());
            intent.putExtra("id", optInt);
            intent.putExtra("isSet", z16);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.d("WebViewPlugin", 1, "updateSmartManagerSettingStatus", e16);
        }
    }

    private void z(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "clickMineButton:" + jSONObject);
            }
            String optString = jSONObject.optString("troopUin");
            String optString2 = jSONObject.optString("memberUin");
            if (com.tencent.mobileqq.troop.data.aa.a().d(optString, optString2)) {
                this.G.setVisibility(8);
                com.tencent.mobileqq.troop.data.aa.a().h(optString, optString2, false);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopRankConfig", 2, "clickMineButton exp", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "troopApi";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"troopApi".equals(str2)) {
            return false;
        }
        if ("previewRewardVideo".equals(str3)) {
            O(strArr);
        } else if ("setRedPoint".equals(str3)) {
            T(strArr);
        } else if ("openEditUniqTitle".equals(str3)) {
            K(strArr);
        } else if ("saveTroopMemberTitle".equals(str3)) {
            Q(strArr);
        } else if ("clickMineButton".equals(str3)) {
            z(strArr);
        } else if ("addTroop".equals(str3)) {
            v(strArr);
        } else if ("thirdAppCreateGroupCallback".equals(str3)) {
            if (W(strArr)) {
                return false;
            }
        } else if ("openTroopProfile".equals(str3)) {
            M(strArr);
        } else if ("setGroupMarkSwitch".equals(str3)) {
            R(strArr);
        } else if ("setGroupSchoolInfo".equals(str3)) {
            S(strArr);
        } else if ("getLocationWithPoi".equals(str3)) {
            D(strArr);
        } else if ("changeGroupHousekeeperSetting".equals(str3) && strArr.length == 1) {
            y(strArr);
        } else if ("getGlobalOpenGroupDigestOnSummary".equals(str3)) {
            C(strArr);
        } else if ("openSelectTroopMember".equals(str3) && strArr.length == 1) {
            L(strArr[0]);
        } else if ("gotoTroopQRCodePage".equals(str3)) {
            N(strArr);
        } else if ("refreshTroopSourceQRCodeList".equals(str3)) {
            P();
        } else if ("jubao".equals(str3) && strArr.length > 0) {
            I(strArr[0]);
        } else if ("getUserTitleAndLevel".equals(str3)) {
            E(strArr);
        } else if ("updateTroopIdentityGlobalSwitch".equals(str3)) {
            X(strArr);
        }
        return true;
    }

    void init() {
        if (this.f238810d.compareAndSet(false, true)) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.f238811e = A;
            A.p();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String stringExtra;
        super.onActivityResult(intent, b16, i3);
        if (b16 == 4) {
            if (i3 == -1) {
                if (intent == null) {
                    stringExtra = "";
                } else {
                    stringExtra = intent.getStringExtra("newUniqueTitle");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", 0);
                    jSONObject.put("uniqueTitle", stringExtra);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                callJs(this.f238813h, jSONObject.toString());
                return;
            }
            callJs(this.f238813h, "{\"code\":-1}");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        AppInterface b16 = this.mRuntime.b();
        Activity a16 = this.mRuntime.a();
        if (b16 == null || a16 == null) {
            return;
        }
        init();
        com.tencent.biz.troop.b bVar = this.f238811e;
        if (bVar != null) {
            bVar.f(this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        if (this.f238810d.get()) {
            this.f238811e.n0(this.I);
            this.f238811e.q();
        }
        VideoUploadTask videoUploadTask = this.F;
        if (videoUploadTask != null && !videoUploadTask.e()) {
            this.F.stop();
        }
        com.tencent.biz.troop.b bVar = this.H;
        if (bVar != null) {
            bVar.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238826d;

        e(String str) {
            this.f238826d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (bundle != null) {
                ad.this.callJs(this.f238826d, bundle.getString("rankTitle"));
            }
        }
    }

    private void P() {
        QLog.i("WebViewPlugin", 1, "[refreshTroopSourceQRList] invoke");
        this.f238811e.i0();
    }

    private void R(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int i3 = jSONObject.getInt("isOn");
            String string = jSONObject.getString("groupCode");
            if (QLog.isColorLevel()) {
                QLog.d("TroopHonor.jsapi", 2, String.format("troop honor aio switch, troopUin: %s, switch: %s", string, Integer.valueOf(i3)));
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f238811e.Q0(string, i3 == 1);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("WebViewPlugin", 1, "JASPI setGroupMarkSwitch", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i3) {
        V(i3, 0);
    }

    public void D(String[] strArr) {
        SosoLocation sosoLocation;
        List<TencentPoi> list;
        String str = strArr[0];
        if (QLog.isColorLevel()) {
            QLog.d("WebViewPlugin", 2, "getPois:" + str);
        }
        if (this.mRuntime.e() == null) {
            if (QLog.isColorLevel()) {
                QLog.w("WebViewPlugin", 2, "getWebView()==null, return");
                return;
            }
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            if (str.charAt(0) == '{') {
                try {
                    str = new JSONObject(str).getString("callback");
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("WebViewPlugin", 2, "getLocation exception:", e16);
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (a16 instanceof AppActivity) {
                SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview");
                if (cachedLbsInfo != null && (sosoLocation = cachedLbsInfo.mLocation) != null && (list = sosoLocation.poi) != null && list.size() > 0) {
                    A(cachedLbsInfo, str);
                    return;
                } else {
                    w(a16, str);
                    return;
                }
            }
            callJs(str, "-4", "{}");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("WebViewPlugin", 2, "context==null || isFinishing, return");
        }
    }

    private String B(String str) {
        return (str == null || "Unknown".equals(str)) ? "" : str;
    }

    private boolean W(String[] strArr) {
        try {
            String str = strArr[0];
            QLog.i("TroopAbility.Jsapi", 1, "create troop callback content: " + str);
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("retCode");
            jSONObject.optString("error");
            String optString = jSONObject.optString("troopUin");
            if (optInt == 0) {
                QBaseActivity qBaseActivity = (QBaseActivity) this.mRuntime.a();
                if (qBaseActivity == null) {
                    return true;
                }
                Intent intent = new Intent();
                intent.addFlags(603979776);
                intent.putExtra("action", 2);
                intent.putExtra("troop_uin", optString);
                PublicFragmentActivity.b.a(qBaseActivity, intent, PublicFragmentActivity.class, BindGroupFragment.class);
                qBaseActivity.overridePendingTransition(0, 0);
            }
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
            return true;
        }
    }
}
