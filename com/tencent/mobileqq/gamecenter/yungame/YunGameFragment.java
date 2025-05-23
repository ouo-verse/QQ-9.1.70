package com.tencent.mobileqq.gamecenter.yungame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequestAck;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatus;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocateDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameLoginInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameShareInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameStreamQualityCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgSessionCfg;
import com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gamecenter.api.impl.YunGameChannelApiImpl;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.mobileqq.gamecenter.yungame.YunGameManager;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.inner.auth.QQAuth;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class YunGameFragment extends QPublicBaseFragment implements YunGameManager.d {
    private FrameLayout C;
    private GmCgPlaySession D;
    private GameInfo E;
    private List<GmCgGameStreamQualityCfg> F;
    private GmCgPlayStatusListener G;
    private GmCgPlayDcEventListener H;
    private GmCgGameConfigInfo I;
    private GmCgSessionCfg.Builder J;
    private long K;
    private String M;
    private String N;
    private View P;
    private me1.e Q;
    private le1.b R;
    private com.tencent.mobileqq.gamecenter.yungame.d S;
    private com.tencent.mobileqq.gamecenter.yungame.d T;
    private PopupWindow U;
    private String V;
    private Handler X;
    IYunGameChannelApi.AuthResult Y;
    IYunGameChannelApi.ResultHandler Z;
    private boolean L = true;
    private boolean W = false;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (QLog.isColorLevel()) {
                    QLog.i("YunGameActivity", 1, "[handleMessage] restart play");
                }
                if (YunGameFragment.this.D != null) {
                    YunGameFragment.this.D.restartPlayWithResolutionChange();
                    QLog.i("YunGameActivity", 1, "=====restartPlayWithResolutionChange=====");
                }
                YunGameFragment.this.Sh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements GmCgPlayStatusListener {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements GmCgDcEventRequest {
            a() {
            }

            @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
            public String generateDcEventDataToSend() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("cmd", provideDcEventCmd());
                    jSONObject.put("reqData", new JSONObject(YunGameFragment.this.E.getDcEventReqData()));
                } catch (Exception e16) {
                    QLog.e("YunGameActivity", 2, "[startGame][onGmCgPlayStatusUpdate] sendDcEventRequest:" + e16);
                }
                QLog.i("YunGameActivity", 2, "[startGame][onGmCgPlayStatusUpdate] data:" + jSONObject);
                return jSONObject.toString();
            }

            @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
            public String provideDcEventCmd() {
                return YunGameFragment.this.E.getDcEventReqCmd();
            }

            @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
            public /* synthetic */ int provideDcEventSeq() {
                return com.tencent.gamematrix.gmcg.api.a.a(this);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.gamecenter.yungame.YunGameFragment$b$b, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class DialogInterfaceOnClickListenerC7656b implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC7656b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                YunGameManager.F().Q();
                YunGameFragment.this.getQBaseActivity().finish();
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class c implements IYunGameChannelApi.PermissionHandler {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f213519a;

            c(boolean z16) {
                this.f213519a = z16;
            }

            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.PermissionHandler
            public void onAllGranted() {
                QLog.i("YunGameActivity", 1, "[onGmCgPlayEventVoiceSwitched] [requestPermissions] GRANTED===");
                if (YunGameFragment.this.D != null) {
                    YunGameFragment.this.D.switchOnVoice(this.f213519a);
                }
            }

            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.PermissionHandler
            public void onDenied(List<String> list, List<Integer> list2) {
                QLog.i("YunGameActivity", 1, "[onGmCgPlayEventVoiceSwitched] [requestPermissions] DENIED===");
            }

            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.PermissionHandler
            public void onDialogShow(Dialog dialog, List<String> list) {
                QLog.i("YunGameActivity", 1, "[onGmCgPlayEventVoiceSwitched] [requestPermissions] onDialogShow===");
                YunGameFragment.this.mi(false);
            }

            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.PermissionHandler
            public void onFailed(String str) {
                QLog.e("YunGameActivity", 1, "[onGmCgPlayEventVoiceSwitched] [requestPermissions] err:" + str);
            }

            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.PermissionHandler
            public void onViewShow(View view, List<String> list) {
                QLog.i("YunGameActivity", 1, "[onGmCgPlayEventVoiceSwitched] [requestPermissions] onViewShow===");
                YunGameFragment.this.mi(false);
            }
        }

        b() {
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public /* synthetic */ void onGmCgNetworkCarrierMismatch(String[] strArr, String str, String str2) {
            com.tencent.gamematrix.gmcg.api.h.a(this, strArr, str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public void onGmCgPlayError(GmCgError gmCgError) {
            QLog.e("YunGameActivity", 1, "[startGame][onGmCgPlayError] error:" + gmCgError);
            try {
                if (!YunGameFragment.this.getQBaseActivity().isFinishing()) {
                    com.tencent.mobileqq.gamecenter.yungame.a.k(new WeakReference(YunGameFragment.this.getQBaseActivity()), gmCgError.getErrorMsg(), "\u9000\u51fa\u6e38\u620f", new DialogInterfaceOnClickListenerC7656b());
                }
                if (YunGameFragment.this.R != null) {
                    YunGameFragment.this.R.g();
                }
                Bundle bundle = new Bundle();
                bundle.putInt(IYunGameConstant.KEY_PARAM_RET, gmCgError.getErrorCode());
                bundle.putString(IYunGameConstant.KEY_PARAM_MSG, gmCgError.getErrorMsg());
                YunGameManager.F().Z(IYunGameConstant.CMD_ERROR, -10, "game running err.", bundle);
            } catch (Throwable th5) {
                QLog.e("YunGameActivity", 1, th5, new Object[0]);
            }
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public /* synthetic */ void onGmCgPlayEventGalleryOpen() {
            com.tencent.gamematrix.gmcg.api.h.b(this);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public /* synthetic */ void onGmCgPlayEventGpsSwitched(boolean z16) {
            com.tencent.gamematrix.gmcg.api.h.c(this, z16);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public void onGmCgPlayEventVoiceSwitched(boolean z16) {
            com.tencent.gamematrix.gmcg.api.h.d(this, z16);
            QLog.i("YunGameActivity", 1, "[onGmCgPlayEventVoiceSwitched] enable:" + z16);
            ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).requestPermission(YunGameFragment.this.getQBaseActivity(), QQPermissionConstants.Permission.RECORD_AUDIO, new c(z16));
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public /* synthetic */ void onGmCgPlayLoadingProgressUpdate(GmCgPlayStatus gmCgPlayStatus, int i3, boolean z16) {
            com.tencent.gamematrix.gmcg.api.h.e(this, gmCgPlayStatus, i3, z16);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public /* synthetic */ void onGmCgPlaySoftKeyboardShow(boolean z16) {
            com.tencent.gamematrix.gmcg.api.h.f(this, z16);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public void onGmCgPlayStatusUpdate(GmCgPlayStatus gmCgPlayStatus, Object obj) {
            int i3;
            GmCgDeviceInfo gmCgDeviceInfo;
            if (gmCgPlayStatus != null) {
                if (gmCgPlayStatus.is(GmCgPlayStatus.StatusFirstFramedRendered)) {
                    if (YunGameFragment.this.D != null) {
                        YunGameFragment.this.D.sendAppMonitorReq(0);
                        if (YunGameFragment.this.E != null && !TextUtils.isEmpty(YunGameFragment.this.E.getDcEventReqCmd())) {
                            YunGameFragment.this.D.sendDcEventRequest(new a());
                        }
                    } else {
                        QLog.e("YunGameActivity", 2, "[startGame][onGmCgPlayStatusUpdate] session is null");
                    }
                    GmCgAllocateDeviceInfo Vh = YunGameFragment.this.Vh();
                    if (Vh != null && (gmCgDeviceInfo = Vh.mCgDeviceInfo) != null && gmCgDeviceInfo.hasSaveArchive()) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    YunGameFragment.this.hi("914483", "20", "", i3);
                }
                if (gmCgPlayStatus.is(GmCgPlayStatus.StatusStreamQualityConfigGot) && obj != null) {
                    YunGameFragment.this.F = (List) obj;
                    try {
                        if (YunGameFragment.this.F != null) {
                            JSONArray jSONArray = new JSONArray();
                            for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg : YunGameFragment.this.F) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("pId", gmCgGameStreamQualityCfg.pId);
                                jSONObject.put("pName", gmCgGameStreamQualityCfg.pName);
                                jSONArray.mo162put(jSONObject);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("YunGameActivity", 2, "[startGame][onGmCgPlayStatusUpdate]:" + jSONArray);
                            }
                            QMMKV.fromV2(YunGameFragment.this.getQBaseActivity(), "common_mmkv_configurations").putString(IYunGameConstant.KEY_QUALITY_CFG, jSONArray.toString());
                        }
                    } catch (Throwable th5) {
                        QLog.e("YunGameActivity", 1, th5, new Object[0]);
                    }
                }
                if (gmCgPlayStatus.is(GmCgPlayStatus.StatusGameConfigGot) && (obj instanceof GmCgGameConfigInfo)) {
                    YunGameFragment.this.I = (GmCgGameConfigInfo) obj;
                    if (YunGameFragment.this.E != null) {
                        try {
                            String str = YunGameFragment.this.E.getGameId() + "," + YunGameFragment.this.I.pScreenOrientation;
                            QMMKV.fromV2(YunGameFragment.this.getQBaseActivity(), "common_mmkv_configurations").putString(IYunGameConstant.KEY_SCREEN_CFG + YunGameFragment.this.E.getGameId(), str);
                        } catch (Throwable th6) {
                            QLog.e("YunGameActivity", 1, th6, new Object[0]);
                        }
                        YunGameManager.F().T(YunGameFragment.this.E.getGameId(), YunGameFragment.this.I);
                    }
                    if (YunGameFragment.this.I.pScreenOrientation != YunGameFragment.this.getQBaseActivity().getRequestedOrientation()) {
                        QLog.i("YunGameActivity", 2, "[startGame][onGmCgPlayStatusUpdate] setRequestedOrientation: " + YunGameFragment.this.I.pScreenOrientation);
                        YunGameFragment.this.getQBaseActivity().setRequestedOrientation(YunGameFragment.this.I.pScreenOrientation);
                    }
                }
                QBaseActivity qBaseActivity = YunGameFragment.this.getQBaseActivity();
                if (qBaseActivity == null) {
                    return;
                }
                if (!qBaseActivity.isFinishing() && YunGameFragment.this.R != null) {
                    YunGameFragment.this.R.o(gmCgPlayStatus.getStatusCode());
                }
                QLog.i("YunGameActivity", 1, "[startGame][onGmCgPlayStatusUpdate] status:" + gmCgPlayStatus.getStatusCode());
            }
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public /* synthetic */ void onGmCgPlaySuperResolutionTypeChanged(int i3) {
            com.tencent.gamematrix.gmcg.api.h.g(this, i3);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener
        public /* synthetic */ void onGmCgPlayWarning(GmCgError gmCgError) {
            com.tencent.gamematrix.gmcg.api.h.h(this, gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements GmCgPlayDcEventListener {

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements IYunGameChannelApi.OnGetLaunchKeyListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f213522a;

            a(int i3) {
                this.f213522a = i3;
            }

            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.OnGetLaunchKeyListener
            public void onResult(String str, String str2, String str3, String str4) {
                QLog.d("YunGameActivity", 2, "[onGmCgPlayDcEventLoginRequest] accessToken:" + str + ",openId:" + str3 + ",payToken:" + str2);
                if (YunGameFragment.this.D == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
                    YunGameFragment.this.ii("2");
                    YunGameFragment.this.li(this.f213522a);
                    return;
                }
                YunGameFragment.this.ii("1");
                GmCgGameLoginInfo gmCgGameLoginInfo = new GmCgGameLoginInfo();
                gmCgGameLoginInfo.pIdType = 7;
                gmCgGameLoginInfo.pQQUserToken = str;
                gmCgGameLoginInfo.pQQUserOpenId = str3;
                gmCgGameLoginInfo.pQQUserPayToken = str2;
                YunGameFragment.this.D.setCloudGameLoginParamV1(2, gmCgGameLoginInfo);
                YunGameFragment.this.D.restartPlay(true);
            }
        }

        c() {
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgDcEventDownloadGame(String str, String str2) {
            com.tencent.gamematrix.gmcg.api.d.a(this, str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgDcEventOpenAssistScreen(String str, String str2, String str3) {
            com.tencent.gamematrix.gmcg.api.d.b(this, str, str2, str3);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgDcEventOpenOuterScreen(String str, String str2) {
            com.tencent.gamematrix.gmcg.api.d.c(this, str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgDcEventPlayerConnect(int i3, int i16) {
            com.tencent.gamematrix.gmcg.api.d.d(this, i3, i16);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgDcEventPowerSaveModeStatusChange(boolean z16) {
            com.tencent.gamematrix.gmcg.api.d.e(this, z16);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgDcEventShopInject(String str) {
            com.tencent.gamematrix.gmcg.api.d.f(this, str);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcConnectionLost() {
            com.tencent.gamematrix.gmcg.api.d.g(this);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcConnectionReady() {
            com.tencent.gamematrix.gmcg.api.d.h(this);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventAck(GmCgDcEventRequestAck gmCgDcEventRequestAck) {
            com.tencent.gamematrix.gmcg.api.d.i(this, gmCgDcEventRequestAck);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventAllAndroidEvent(String str) {
            com.tencent.gamematrix.gmcg.api.d.j(this, str);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventAppLaunch() {
            com.tencent.gamematrix.gmcg.api.d.k(this);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventAppStatus(String str) {
            com.tencent.gamematrix.gmcg.api.d.l(this, str);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public void onGmCgPlayDcEventCommonNotify(String str, String str2) {
            com.tencent.gamematrix.gmcg.api.d.m(this, str, str2);
            QLog.i("YunGameActivity", 1, "[onGmCgPlayDcEventCommonNotify] type:" + str + ", msg:" + str2);
            if ("GAME_EVENT".equals(str) && !TextUtils.isEmpty(str2)) {
                String[] split = str2.split(":");
                if (split.length == 2 && "TRY_PLAY_END".equals(split[1])) {
                    Bundle bundle = new Bundle();
                    bundle.putString(IYunGameConstant.KEY_PARAM_APPID, YunGameFragment.this.E.getAppId());
                    YunGameManager.F().Z(IYunGameConstant.CMD_GET_GAME_TOGGLE, 0, "", bundle);
                }
            }
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public void onGmCgPlayDcEventLoginRequest(int i3) {
            com.tencent.gamematrix.gmcg.api.d.n(this, i3);
            QLog.i("YunGameActivity", 1, "[onGmCgPlayDcEventLoginRequest] channelType:" + i3);
            if (i3 != 2) {
                Toast.makeText(YunGameFragment.this.getQBaseActivity(), "\u5f53\u524d\u4ec5\u652f\u6301QQ\u767b\u5f55", 0).show();
            } else if (YunGameFragment.this.E.getCloudGameLoginParamV1Switch() != 1) {
                YunGameFragment.this.li(i3);
            } else {
                ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).startGetLaunchKeys(YunGameFragment.this.E.getAppId(), new a(i3));
            }
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public void onGmCgPlayDcEventLoginResult(String str, int i3, boolean z16) {
            QLog.i("YunGameActivity", 1, "[onGmCgPlayDcEventLoginResult], game:" + str + ",type:" + i3 + ",fLoginResult:" + z16);
            if (YunGameFragment.this.E.getCloudGameLoginParamV1Switch() != 1 && !YunGameFragment.this.ai()) {
                return;
            }
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("989597").setOperModule("9080").setOpertype("20").setGameAppId(YunGameFragment.this.E.getAppId()).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).report();
            QLog.i("YunGameActivity", 1, "report login-free++++++++++++");
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventQQIntentForward(Intent intent) {
            com.tencent.gamematrix.gmcg.api.d.p(this, intent);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventSceneCheck(boolean z16, int i3, long j3) {
            com.tencent.gamematrix.gmcg.api.d.q(this, z16, i3, j3);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventScreenRotate(int i3) {
            com.tencent.gamematrix.gmcg.api.d.r(this, i3);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventShareInfoEvent(int i3, GmCgGameShareInfo gmCgGameShareInfo) {
            com.tencent.gamematrix.gmcg.api.d.s(this, i3, gmCgGameShareInfo);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventTGPAAction(String str, String str2) {
            com.tencent.gamematrix.gmcg.api.d.t(this, str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventTGPAScene(String str, String str2) {
            com.tencent.gamematrix.gmcg.api.d.u(this, str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventUnknown(String str) {
            com.tencent.gamematrix.gmcg.api.d.v(this, str);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventUnknownAndroidEvent(String str) {
            com.tencent.gamematrix.gmcg.api.d.w(this, str);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayDcEventWXFaceIdentify(String str) {
            com.tencent.gamematrix.gmcg.api.d.x(this, str);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayEventGameChapter(Integer num) {
            com.tencent.gamematrix.gmcg.api.d.y(this, num);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayEventKingsHonorMidGameAbnormal(Integer num) {
            com.tencent.gamematrix.gmcg.api.d.z(this, num);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayEventKingsHonorMidGameBeginNormal() {
            com.tencent.gamematrix.gmcg.api.d.A(this);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgPlayEventKingsHonorMidGameEnd(boolean z16, Integer num, String str, List list, String str2, Integer num2) {
            com.tencent.gamematrix.gmcg.api.d.B(this, z16, num, str, list, str2, num2);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmCgSendTouchEvent(int i3) {
            com.tencent.gamematrix.gmcg.api.d.C(this, i3);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener
        public /* synthetic */ void onGmcgSDKScene(int i3, boolean z16) {
            com.tencent.gamematrix.gmcg.api.d.D(this, i3, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements IYunGameChannelApi.AuthResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f213524a;

        d(int i3) {
            this.f213524a = i3;
        }

        @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.AuthResult
        public void onCancel() {
            QLog.e("YunGameActivity", 1, "[openListener][onCancel] cancle:");
            if (YunGameFragment.this.E != null && YunGameFragment.this.E.getAutoLogin()) {
                YunGameFragment.this.getQBaseActivity().finish();
            }
            YunGameFragment.this.ki("914484", 2);
        }

        @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.AuthResult
        public void onComplete(Object obj) {
            if (obj == null) {
                QLog.e("YunGameActivity", 1, "[openListener][onComplete] response is null, return");
            }
            if (obj instanceof JSONObject) {
                String optString = ((JSONObject) obj).optString("proxy_code");
                if (QLog.isColorLevel()) {
                    QLog.i("YunGameActivity", 2, "[openListener][onComplete] authCode:" + optString);
                }
                if (!TextUtils.isEmpty(optString)) {
                    YunGameFragment.this.ki("914484", 1);
                    if (YunGameFragment.this.D != null) {
                        YunGameFragment.this.D.setCloudGameLoginParam(this.f213524a, optString);
                        return;
                    }
                    QLog.e("YunGameActivity", 1, "[openListener][onComplete] mSession is null");
                    if (YunGameFragment.this.E != null && YunGameFragment.this.E.getAutoLogin()) {
                        QLog.e("YunGameActivity", 1, "[openListener][onComplete] type:" + this.f213524a);
                        YunGameFragment.this.J.configAutoLoginForDelegateCode(this.f213524a, optString, YunGameFragment.this.N);
                        YunGameFragment.this.ni(false);
                        return;
                    }
                    return;
                }
                QLog.e("YunGameActivity", 1, "[openListener][onComplete] authCode is empty, return");
                YunGameFragment.this.ki("914484", 3);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.AuthResult
        public void onError(Object obj) {
            QLog.e("YunGameActivity", 1, "[openListener][onError] error:" + obj);
            YunGameFragment.this.ki("914484", 3);
        }

        @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.AuthResult
        public void onWarning(int i3) {
            QLog.e("YunGameActivity", 1, "[openListener][onWarning] error:" + i3);
        }
    }

    private boolean Qh() {
        return this.L;
    }

    private void Rh() {
        GmCgPlaySession gmCgPlaySession = this.D;
        if (gmCgPlaySession != null) {
            gmCgPlaySession.setPlayDcEventListener(this.H);
            this.D.setPlayStatusListener(this.G);
        } else {
            QLog.e("YunGameActivity", 1, "[startGame] session is null");
            Toast.makeText(getQBaseActivity(), "\u542f\u52a8\u6e38\u620f\u5931\u8d25,\u8bf7\u91cd\u8bd5", 0).show();
            YunGameManager.F().Q();
            getQBaseActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        try {
            if (((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).isFoldDevice()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        YunGameFragment.this.ci();
                    }
                });
            }
        } catch (Throwable th5) {
            QLog.e("YunGameActivity", 1, "[compactFoldDevice]", th5);
        }
    }

    private void Th() {
        com.tencent.mobileqq.gamecenter.yungame.d dVar = this.S;
        if (dVar != null && dVar.isShowing()) {
            this.S.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        if (com.tencent.mobileqq.gamecenter.yungame.a.f("floatMenu")) {
            return;
        }
        QLog.i("YunGameActivity", 1, "[onClick] mDragButton click. ");
        gi("914208", "20", "");
        mi(false);
        String b16 = com.tencent.mobileqq.gamecenter.yungame.a.b(this.E.getConfigUrl(), bi());
        if (TextUtils.isEmpty(b16)) {
            b16 = this.E.getConfigUrl();
        }
        Bundle bundle = new Bundle();
        bundle.putString(IYunGameConstant.KEY_PARAM_URL, b16);
        YunGameManager.F().Z(IYunGameConstant.CMD_OPEN_MENU, 0, "", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GmCgAllocateDeviceInfo Vh() {
        return YunGameManager.F().C();
    }

    private void Wh() {
        com.tencent.mobileqq.gamecenter.yungame.a.i("https://img.gamecenter.qq.com/xgame/gm/1686637908036_e4bd370d175f66ec01604f5da3f934fc.jpg", false, (ImageView) this.P.findViewById(R.id.y0r));
    }

    private void Xh() {
        me1.e eVar = new me1.e(getQBaseActivity());
        this.Q = eVar;
        eVar.q(new me1.b() { // from class: com.tencent.mobileqq.gamecenter.yungame.h
            @Override // me1.b
            public final void a() {
                YunGameFragment.this.Uh();
            }
        });
        this.Q.s(0, com.tencent.mobileqq.gamecenter.yungame.a.d(100.0f, getResources()));
    }

    private void Yh() {
        String str;
        String str2;
        this.R = new le1.b();
        GameInfo gameInfo = this.E;
        String str3 = "";
        if (gameInfo == null) {
            str = "";
        } else {
            str = gameInfo.getLoadingUrl();
        }
        GameInfo gameInfo2 = this.E;
        if (gameInfo2 == null) {
            str2 = "";
        } else {
            str2 = gameInfo2.getGameName();
        }
        GameInfo gameInfo3 = this.E;
        if (gameInfo3 != null) {
            str3 = gameInfo3.getIconUrl();
        }
        this.R.h((TextView) this.P.findViewById(R.id.f110126ho), (ProgressBar) this.P.findViewById(R.id.lz7), (ImageView) this.P.findViewById(R.id.y0r), (TextView) this.P.findViewById(R.id.k8b), (ImageView) this.P.findViewById(R.id.y3l), (ImageView) this.P.findViewById(R.id.y78), str, bi(), str2, str3);
    }

    @SuppressLint({"WrongConstant"})
    private void Zh(Activity activity) {
        try {
            int i3 = Build.VERSION.SDK_INT;
            activity.getWindow().setFlags(512, 512);
            activity.getWindow().setFlags(1024, 1024);
            activity.getWindow().addFlags(67108864);
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (i3 >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().setStatusBarColor(0);
        } catch (Throwable th5) {
            QLog.e("YunGameActivity", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ai() {
        String accessToken = this.E.getAccessToken();
        String payToken = this.E.getPayToken();
        String openId = this.E.getOpenId();
        if (this.E.getAutoLoginForType5Switch() == 1 && !TextUtils.isEmpty(openId) && !TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(payToken)) {
            return true;
        }
        return false;
    }

    private boolean bi() {
        GmCgGameConfigInfo gmCgGameConfigInfo = this.I;
        if (gmCgGameConfigInfo == null) {
            QLog.e("YunGameActivity", 1, "[isLandScapeConfig] mGmCgGameConfigInfo is null");
            return true;
        }
        if (gmCgGameConfigInfo.pScreenOrientation == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ci() {
        me1.e eVar = this.Q;
        if (eVar != null) {
            eVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void di(DialogInterface dialogInterface, int i3) {
        Th();
        ji("914481", "20", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ei(DialogInterface dialogInterface, int i3) {
        Th();
        ji("914481", "20", 2);
        getQBaseActivity().finish();
    }

    private void gi(String str, String str2, String str3) {
        hi(str, str2, str3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(String str, String str2, String str3, int i3) {
        GameInfo gameInfo = this.E;
        if (gameInfo == null) {
            return;
        }
        String reportChannelId = gameInfo.getReportChannelId();
        String gameId = this.E.getGameId();
        String reportActId = this.E.getReportActId();
        QLog.i("YunGameActivity", 1, "[YunGameActivity] report operId=" + str + ",operType=" + str2 + ",ext46=" + str3);
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(str).setOperModule("9080").setOpertype(str2).setGameAppId(this.E.getAppId()).setRetId(i3).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(46, str3).setExt(41, reportChannelId).setExt(42, gameId).setExt(43, reportActId).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(String str) {
        GameInfo gameInfo = this.E;
        if (gameInfo == null) {
            QLog.e("YunGameActivity", 1, "[reportAutoLogin] mCurrentGameInfo is null");
            return;
        }
        try {
            String reportChannelId = gameInfo.getReportChannelId();
            String gameId = this.E.getGameId();
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("915638").setOperModule("9080").setOpertype("20").setGameAppId(this.E.getAppId()).setExt(2, str).setExt(29, "2").setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId).setExt(42, gameId).setExt(43, this.E.getReportActId()).report();
        } catch (Throwable th5) {
            QLog.e("YunGameActivity", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki(String str, int i3) {
        GameInfo gameInfo = this.E;
        if (gameInfo == null) {
            QLog.e("YunGameActivity", 1, "[reportRequestLoginResult] mCurrentGameInfo is null");
            return;
        }
        String reportChannelId = gameInfo.getReportChannelId();
        String gameId = this.E.getGameId();
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(str).setOperModule("9080").setOpertype("20").setGameAppId(this.E.getAppId()).setRetId(i3).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId).setExt(42, gameId).setExt(43, this.E.getReportActId()).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li(int i3) {
        QLog.e("YunGameActivity", 1, "[requestLogin] request login.");
        ki("914490", 1);
        new QQAuth.AuthParams(this.E.getAppId(), YunGameChannelApiImpl.APPID, this.E.getGameName(), "all");
        this.Y = new d(i3);
        this.Z = ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).requesetLogin(getQBaseActivity(), this.E.getAppId(), YunGameChannelApiImpl.APPID, this.E.getGameName(), "all", this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(boolean z16) {
        this.L = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(boolean z16) {
        boolean z17;
        int i3;
        boolean z18;
        String gameData;
        GameInfo gameInfo;
        GmCgDeviceInfo gmCgDeviceInfo;
        GameInfo gameInfo2 = this.E;
        if (gameInfo2 == null) {
            return;
        }
        String accessToken = gameInfo2.getAccessToken();
        String payToken = this.E.getPayToken();
        String openId = this.E.getOpenId();
        int autoLoginForType5Switch = this.E.getAutoLoginForType5Switch();
        int cloudGameLoginParamV1Switch = this.E.getCloudGameLoginParamV1Switch();
        if (autoLoginForType5Switch == 1 && z16 && !TextUtils.isEmpty(openId) && !TextUtils.isEmpty(accessToken) && !TextUtils.isEmpty(payToken)) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.i("YunGameActivity", 2, "[startGame],accessToken:" + accessToken + ",payToken:" + payToken + ",openId:" + openId + ",autoLoginForType5Switch:" + autoLoginForType5Switch + ",cloudGameLoginParamV1Switch:" + cloudGameLoginParamV1Switch + ",canAutoLoginForType5:" + z16 + ",isAutoLoginForType5:" + z17);
        if (bi()) {
            getQBaseActivity().setRequestedOrientation(0);
        }
        GmCgAllocateDeviceInfo Vh = Vh();
        if (Vh != null && (gmCgDeviceInfo = Vh.mCgDeviceInfo) != null) {
            this.M = gmCgDeviceInfo.getDeviceID();
        } else {
            QLog.e("YunGameActivity", 1, "deviceInfo is null,just finish");
            getQBaseActivity().finish();
        }
        this.N = YunGameManager.F().G();
        this.I = YunGameManager.F().D(this.E.getGameId());
        if (bi()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        GameInfo gameInfo3 = this.E;
        if ((gameInfo3 != null && gameInfo3.getAutoLogin()) || z17) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z17 && (gameInfo = this.E) != null) {
            this.J.configAutoLoginForType5(openId, accessToken, payToken, gameInfo.getAppId(), accessToken);
        }
        GmCgSessionCfg.Builder configMidasPay = this.J.setGameScreenOrientation(i3).enableViewConfigCallback(false).enableAdaptiveStreamQuality(true).useV2CloudGameLogin(z18).configMidasPay(this.M, "1450023385", this.N, IYunGameConstant.MIDAS_PLATFORM_ID, IYunGameConstant.MIDAS_FLATFORM_TYPE);
        if (TextUtils.isEmpty(this.E.getGameData())) {
            gameData = "";
        } else {
            gameData = this.E.getGameData();
        }
        GmCgSessionCfg build = configMidasPay.setGameLoginPayLoad(gameData).build();
        if (z17) {
            build.pAutoLoginChannelParam6 = payToken;
            ii("3");
        }
        if (QLog.isColorLevel()) {
            QLog.i("YunGameActivity", 1, "[startGame] uin:" + this.N + ", offerId:1450023385, platformId:" + IYunGameConstant.MIDAS_PLATFORM_ID + ", platformType:" + IYunGameConstant.MIDAS_FLATFORM_TYPE + ", deviceId:" + this.M + " gameData:" + this.E.getGameData());
        }
        Xh();
        Yh();
        if (Vh != null) {
            this.D = GmCgSdk.createPlaySessionFromDevice(getQBaseActivity(), Vh.mCgDeviceInfo, build, this.C);
            this.G = new b();
            this.H = new c();
            Rh();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.yungame.YunGameManager.d
    public void P4(String str) {
        GmCgPlaySession gmCgPlaySession = this.D;
        if (gmCgPlaySession != null) {
            gmCgPlaySession.stopPlay();
            this.D.releasePlay();
        }
        YunGameManager.F().b0(null);
        getQBaseActivity().finish();
    }

    @Override // com.tencent.mobileqq.gamecenter.yungame.YunGameManager.d
    public void U2(int i3) {
        QLog.i("YunGameActivity", 1, "[onChangeClarity] index:" + i3);
        List<GmCgGameStreamQualityCfg> list = this.F;
        if (list != null && list.size() > i3) {
            QLog.i("YunGameActivity", 1, "[onChangeClarity] size:" + this.F.size() + ", pid:" + this.F.get(i3).pId);
            this.D.setPlayStreamQuality(this.F.get(i3).pId);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.yungame.YunGameManager.d
    public void ca(String str) {
        GmCgPlaySession gmCgPlaySession = this.D;
        if (gmCgPlaySession != null) {
            gmCgPlaySession.sendRestartGameReq();
        }
    }

    public void fi(String str) {
        String b16 = com.tencent.mobileqq.gamecenter.yungame.a.b(str, bi());
        if (TextUtils.isEmpty(b16)) {
            QLog.e("YunGameActivity", 1, "[openUrl] jump_url is empty.");
        } else {
            startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(b16)));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        activity.requestWindowFeature(1);
        Zh(activity);
    }

    public void ji(String str, String str2, int i3) {
        String str3;
        if (this.E == null) {
            QLog.e("YunGameActivity", 1, "[reportRequestLoginResult] mCurrentGameInfo is null");
            return;
        }
        View findViewById = this.P.findViewById(R.id.lz7);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            str3 = "3";
        } else {
            str3 = "4";
        }
        String reportChannelId = this.E.getReportChannelId();
        String gameId = this.E.getGameId();
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(str).setOperModule("9080").setOpertype(str2).setGameAppId(this.E.getAppId()).setRetId(i3).setExt(1, "908014").setExt(6, str3).setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId).setExt(42, gameId).setExt(43, this.E.getReportActId()).report();
    }

    @Override // com.tencent.mobileqq.gamecenter.yungame.YunGameManager.d
    public void m4(final YunGameManager.e eVar) {
        QLog.i("YunGameActivity", 1, "[onPushReceive] data:" + eVar);
        if (eVar == null) {
            return;
        }
        if (!getQBaseActivity().isDestroyed() && !getQBaseActivity().isFinishing()) {
            int i3 = eVar.f213556a;
            if (i3 == 1) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.YunGameFragment.5

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.gamecenter.yungame.YunGameFragment$5$a */
                    /* loaded from: classes12.dex */
                    class a implements View.OnClickListener {
                        a() {
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            QLog.i("YunGameActivity", 1, "[onClick] toast clicked");
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            YunGameFragment.this.fi(eVar.f213563h);
                            if (YunGameFragment.this.E != null) {
                                String reportChannelId = YunGameFragment.this.E.getReportChannelId();
                                String gameId = YunGameFragment.this.E.getGameId();
                                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914731").setOperModule("9080").setOpertype("20").setGameAppId(YunGameFragment.this.E.getAppId()).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId).setExt(42, gameId).setExt(43, YunGameFragment.this.E.getReportActId()).report();
                            }
                            if (YunGameFragment.this.U != null && YunGameFragment.this.U.isShowing()) {
                                YunGameFragment.this.U.dismiss();
                            }
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.gamecenter.yungame.YunGameFragment$5$b */
                    /* loaded from: classes12.dex */
                    class b implements DialogInterface.OnClickListener {
                        b() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (YunGameFragment.this.T != null && YunGameFragment.this.T.isShowing()) {
                                YunGameFragment.this.T.dismiss();
                            }
                            if (YunGameFragment.this.E != null) {
                                String reportChannelId = YunGameFragment.this.E.getReportChannelId();
                                String gameId = YunGameFragment.this.E.getGameId();
                                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914733").setOperModule("9080").setOpertype("20").setGameAppId(YunGameFragment.this.E.getAppId()).setExt(6, "1").setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId).setExt(42, gameId).setExt(43, YunGameFragment.this.E.getReportActId()).report();
                            }
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.gamecenter.yungame.YunGameFragment$5$c */
                    /* loaded from: classes12.dex */
                    class c implements DialogInterface.OnClickListener {
                        c() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            YunGameFragment.this.fi(eVar.f213563h);
                            YunGameFragment.this.mi(false);
                            if (YunGameFragment.this.T != null && YunGameFragment.this.T.isShowing()) {
                                YunGameFragment.this.T.dismiss();
                            }
                            if (YunGameFragment.this.E != null) {
                                String reportChannelId = YunGameFragment.this.E.getReportChannelId();
                                String gameId = YunGameFragment.this.E.getGameId();
                                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914733").setOperModule("9080").setOpertype("20").setGameAppId(YunGameFragment.this.E.getAppId()).setExt(6, "2").setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId).setExt(42, gameId).setExt(43, YunGameFragment.this.E.getReportActId()).report();
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        int i16;
                        if (!YunGameFragment.this.getQBaseActivity().isDestroyed() && !YunGameFragment.this.getQBaseActivity().isFinishing()) {
                            YunGameManager.e eVar2 = eVar;
                            int i17 = eVar2.f213557b;
                            if (i17 == 1) {
                                if (eVar2.f213558c == 2) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                YunGameFragment yunGameFragment = YunGameFragment.this;
                                QBaseActivity qBaseActivity = yunGameFragment.getQBaseActivity();
                                YunGameManager.e eVar3 = eVar;
                                yunGameFragment.U = com.tencent.mobileqq.gamecenter.yungame.a.c(qBaseActivity, eVar3.f213559d, z16, eVar3.f213562g, new a());
                                if (!YunGameFragment.this.getQBaseActivity().isFinishing() && !YunGameFragment.this.getQBaseActivity().isDestroyed()) {
                                    if (YunGameFragment.this.U != null) {
                                        try {
                                            YunGameFragment.this.U.showAtLocation(YunGameFragment.this.C, 49, 0, 0);
                                            if (YunGameFragment.this.E != null) {
                                                if (eVar.f213558c == 1) {
                                                    i16 = 1;
                                                } else {
                                                    i16 = 2;
                                                }
                                                String reportChannelId = YunGameFragment.this.E.getReportChannelId();
                                                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914730").setOperModule("9080").setOpertype("8").setGameAppId(YunGameFragment.this.E.getAppId()).setRetId(i16).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId).setExt(42, YunGameFragment.this.E.getGameId()).setExt(43, YunGameFragment.this.E.getReportActId()).report();
                                                return;
                                            }
                                            return;
                                        } catch (Exception e16) {
                                            QLog.e("YunGameActivity", 1, "showPopWin exception." + e16);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                QLog.i("YunGameActivity", 1, "[onClick] activity is finished, return.");
                                return;
                            }
                            if (i17 == 2) {
                                YunGameFragment yunGameFragment2 = YunGameFragment.this;
                                QBaseActivity qBaseActivity2 = yunGameFragment2.getQBaseActivity();
                                YunGameManager.e eVar4 = eVar;
                                yunGameFragment2.T = com.tencent.mobileqq.gamecenter.yungame.a.j(qBaseActivity2, eVar4.f213559d, eVar4.f213560e, eVar4.f213561f, new b(), eVar.f213562g, new c());
                                if (YunGameFragment.this.E != null) {
                                    String reportChannelId2 = YunGameFragment.this.E.getReportChannelId();
                                    new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId("914732").setOperModule("9080").setOpertype("8").setGameAppId(YunGameFragment.this.E.getAppId()).setExt(1, "908014").setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(41, reportChannelId2).setExt(42, YunGameFragment.this.E.getGameId()).setExt(43, YunGameFragment.this.E.getReportActId()).report();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        QLog.e("YunGameActivity", 1, "[onPushReceive] activity is destoryed or finishing, return.");
                    }
                });
                return;
            }
            if (i3 == 2) {
                fi(eVar.f213563h);
                mi(false);
                return;
            } else {
                if (i3 != 3 || ((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).checkIfOpenFloatInCurProcess(com.tencent.mobileqq.gamecenter.yungame.a.a(eVar.f213563h, bi()))) {
                    return;
                }
                startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(com.tencent.mobileqq.gamecenter.yungame.a.a(eVar.f213563h, bi()))));
                mi(false);
                return;
            }
        }
        QLog.e("YunGameActivity", 1, "[onPushReceive] activity is destoryed or finishing, return....");
    }

    @Override // com.tencent.mobileqq.gamecenter.yungame.YunGameManager.d
    public void n8(boolean z16, String str) {
        QLog.i("YunGameActivity", 1, "[onGetGameToggle] " + z16 + ", " + str);
        if (!z16) {
            fi(str);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.yungame.YunGameManager.d
    public void notifyUserFeedback() {
        QLog.i("YunGameActivity", 1, "[notifyUserFeedback]");
        GmCgPlaySession gmCgPlaySession = this.D;
        if (gmCgPlaySession != null) {
            gmCgPlaySession.fetchCloudGameLog();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        QLog.e("YunGameActivity", 1, "[onActivityResult] ret:" + i3);
        super.onActivityResult(i3, i16, intent);
        IYunGameChannelApi.ResultHandler resultHandler = this.Z;
        if (resultHandler != null) {
            resultHandler.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (!getQBaseActivity().isFinishing()) {
            ji("914491", "8", 1);
            this.S = com.tencent.mobileqq.gamecenter.yungame.a.j(getQBaseActivity(), getString(R.string.zr9), getString(R.string.zr8), getString(R.string.f170835zr1), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.yungame.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    YunGameFragment.this.di(dialogInterface, i3);
                }
            }, getString(R.string.f170837zr3), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.yungame.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    YunGameFragment.this.ei(dialogInterface, i3);
                }
            });
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.i("YunGameActivity", 1, "[onConfigurationChanged] onConfigurationChanged ,cfg:" + configuration);
        Handler handler = this.X;
        if (handler == null) {
            return;
        }
        handler.removeMessages(1);
        this.X.sendEmptyMessageDelayed(1, 500L);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.i8s, (ViewGroup) null);
        this.P = inflate;
        inflate.setBackgroundColor(-16777216);
        this.C = (FrameLayout) this.P.findViewById(R.id.v7z);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getQBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        QLog.d("YunGameActivity", 1, "[onCreate] width:" + displayMetrics.widthPixels + ", height:" + displayMetrics.heightPixels);
        GameInfo B = YunGameManager.F().B();
        this.E = B;
        if (B == null) {
            QLog.d("YunGameActivity", 1, "[onCreate] game info is null return.");
            getQBaseActivity().finish();
            view = this.P;
        } else {
            this.N = YunGameManager.F().G();
            this.V = this.E.getPskey();
            if (YunGameManager.F().C() != null && YunGameManager.F().C().mCgDeviceInfo != null) {
                this.M = YunGameManager.F().C().mCgDeviceInfo.getDeviceID();
            }
            this.I = YunGameManager.F().D(this.E.getGameId());
            setStatusBarImmersive();
            Wh();
            QLog.i("YunGameActivity", 1, "[onCreate] game: " + this.E);
            YunGameManager.F().b0(this);
            GmCgSessionCfg.Builder builder = new GmCgSessionCfg.Builder();
            this.J = builder;
            builder.setFeatSwitchForLocalImeInput(2);
            if (this.E.getAutoLogin() && this.E.getAutoLoginForType5Switch() != 1) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.yungame.YunGameFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YunGameFragment.this.li(2);
                    }
                }, 100L);
            } else {
                ni(true);
            }
            this.K = System.currentTimeMillis();
            gi("914485", "7", "");
            this.X = new a(ThreadManagerV2.getSubThreadLooper());
            view = this.P;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("YunGameActivity", 1, "[onDestroy] ======" + this.W);
        ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).releaseMidas(getQBaseActivity(), this.N, this.V);
        GmCgPlaySession gmCgPlaySession = this.D;
        if (gmCgPlaySession != null) {
            gmCgPlaySession.onPageDestroy();
        }
        me1.e eVar = this.Q;
        if (eVar != null) {
            eVar.n();
        }
        Handler handler = this.X;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Th();
        YunGameManager.F().Q();
        if (this.W) {
            return;
        }
        gi("914229", "20", String.valueOf((System.currentTimeMillis() - this.K) / 1000));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GmCgPlaySession gmCgPlaySession = this.D;
        if (gmCgPlaySession != null) {
            gmCgPlaySession.onPagePause();
            YunGameManager.F().Z(IYunGameConstant.CMD_GAMEACTIVITY_ONPAUSE, 0, "", null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("YunGameActivity", 1, "[YunGameActivity] onResume: " + this.D);
        if (this.D != null && Qh()) {
            this.D.startPlay();
            YunGameManager.F().Z(IYunGameConstant.CMD_GAMEACTIVITY_ONRESUME, 0, "", null);
        }
        gi("914207", "7", "");
        mi(true);
        Zh(getQBaseActivity());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        QLog.i("YunGameActivity", 1, "[onSaveInstanceState] onSaveInstanceState: " + bundle);
        this.W = true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        GmCgPlaySession gmCgPlaySession = this.D;
        if (gmCgPlaySession != null) {
            gmCgPlaySession.onPageStart();
            YunGameManager.F().Z(IYunGameConstant.CMD_GAMEACTIVITY_ONSTART, 0, "", null);
        }
        ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).initMidas(getQBaseActivity(), this.M, this.N, this.V);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GmCgPlaySession gmCgPlaySession = this.D;
        if (gmCgPlaySession != null) {
            gmCgPlaySession.stopPlay();
            mi(true);
            YunGameManager.F().Z(IYunGameConstant.CMD_GAMEACTIVITY_ONSTOP, 0, "", null);
        }
    }

    protected void setStatusBarImmersive() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
    }
}
