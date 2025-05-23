package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.nativePlugins.ac;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class ac extends BaseJsPlugin {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346982a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f346983b;

        a(RequestEvent requestEvent, JSONObject jSONObject) {
            this.f346982a = requestEvent;
            this.f346983b = jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            QQToast.makeText(((BaseJsPlugin) ac.this).mContext, R.string.xzk, 0).show();
        }

        @Override // hx3.c
        public void onUpdateResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> eVar) {
            this.f346982a.ok(this.f346983b);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.nativePlugins.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ac.a.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void k(RequestEvent requestEvent, MiniAppInterface miniAppInterface, String str, String str2, String str3, boolean z16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isSuccess", z16);
        } catch (JSONException unused) {
            QLog.e("OnlineStatusTencentVideoPlugin", 1, "resultJson: false");
        }
        if (!z16) {
            requestEvent.fail(jSONObject.toString());
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(miniAppInterface.getCurrentUin());
        IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = iOnlineStatusInfoService.getOnlineStatusSimpleInfoWithUid(uidFromUin, "OnlineStatusTencentVideoPlugin");
        if (onlineStatusSimpleInfoWithUid == null) {
            QLog.w("OnlineStatusTencentVideoPlugin", 1, "doCreateSyncPopWindow simpleInfo is null");
            return;
        }
        onlineStatusSimpleInfoWithUid.e1(str2);
        onlineStatusSimpleInfoWithUid.f1(str3);
        onlineStatusSimpleInfoWithUid.d1(str);
        iOnlineStatusInfoService.updateOnlineStatusSimpleInfo(onlineStatusSimpleInfoWithUid, "OnlineStatusTencentVideoPlugin", new a(requestEvent, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(final MiniAppInterface miniAppInterface, QBaseActivity qBaseActivity, final String str, final String str2, final String str3, JSONObject jSONObject, final RequestEvent requestEvent) {
        ((IOnlineStatusMiniService) miniAppInterface.getRuntimeService(IOnlineStatusMiniService.class, "mini")).doShowTencentVideoStatusPopWindow(qBaseActivity, str, str2, str3, 2, jSONObject, new IOnlineStatusMiniService.c() { // from class: com.tencent.qqmini.nativePlugins.z
            @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService.c
            public final void a(boolean z16) {
                ac.this.k(requestEvent, miniAppInterface, str2, str, str3, z16);
            }
        }, new IOnlineStatusMiniService.a() { // from class: com.tencent.qqmini.nativePlugins.aa
            @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService.a
            public final void a(boolean z16) {
                ac.l(RequestEvent.this, z16);
            }
        });
    }

    @JsEvent({"setOnlineStatus"})
    public void setOnlineStatus(final RequestEvent requestEvent) {
        QLog.d("OnlineStatusTencentVideoPlugin", 1, "setOnlineStatus");
        try {
            final QBaseActivity qBaseActivity = (QBaseActivity) this.mMiniAppContext.getAttachActivity();
            if (qBaseActivity == null) {
                QLog.d("OnlineStatusTencentVideoPlugin", 1, "setOnlineStatus: activity == null");
                requestEvent.fail();
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.d("OnlineStatusTencentVideoPlugin", 1, "setOnlineStatus: appRuntime == null");
                requestEvent.fail();
                return;
            }
            if (!(peekAppRuntime instanceof MiniAppInterface)) {
                QLog.d("OnlineStatusTencentVideoPlugin", 1, "setOnlineStatus: !appRuntime instanceof MiniAppInterface");
                requestEvent.fail();
                return;
            }
            final MiniAppInterface miniAppInterface = (MiniAppInterface) peekAppRuntime;
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            if (optJSONObject == null) {
                QLog.d("OnlineStatusTencentVideoPlugin", 1, "setOnlineStatus: req.jsonParams.optJSONObject(\"data\") == null");
                requestEvent.fail();
                return;
            }
            final JSONObject jSONObject = new JSONObject(optJSONObject.optString("params"));
            final String optString = jSONObject.optString("cid");
            Bundle bundle = new Bundle();
            bundle.putString("cid", optString);
            QIPCClientHelper.getInstance().callServer("TencentVideoStatusQIPCModule", "ACTION_SHOW_ONLINE_STATUS_POPUPWINDOW", bundle, new EIPCResultCallback() { // from class: com.tencent.qqmini.nativePlugins.x
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    ac.this.o(requestEvent, qBaseActivity, miniAppInterface, jSONObject, optString, eIPCResult);
                }
            });
        } catch (Exception e16) {
            requestEvent.fail(e16.getMessage());
            QLog.e("OnlineStatusTencentVideoPlugin", 1, "setOnlineStatus: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void n(RequestEvent requestEvent, EIPCResult eIPCResult) {
        if (eIPCResult == null) {
            requestEvent.fail();
            QLog.e("OnlineStatusTencentVideoPlugin", 1, "ACTION_GET_ONLINE_STATUS_MAIN error, result is null");
            return;
        }
        if (eIPCResult.code != 0) {
            requestEvent.fail();
            QLog.e("OnlineStatusTencentVideoPlugin", 1, "ACTION_GET_ONLINE_STATUS_MAIN: result.code: " + eIPCResult.code);
            return;
        }
        long j3 = eIPCResult.data.getLong(IOnlineStatusMiniService.ONLINE_STATE);
        String string = eIPCResult.data.getString("cid");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IOnlineStatusMiniService.ONLINE_STATE, j3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cid", string);
            jSONObject.put("params", jSONObject2);
            requestEvent.ok(jSONObject);
        } catch (Exception e16) {
            QLog.d("OnlineStatusTencentVideoPlugin", 1, "getOnlineMsg: " + e16);
            requestEvent.fail(e16.getMessage());
        }
    }

    @JsEvent({"getOnlineMsg"})
    public void getOnlineStatusMsg(final RequestEvent requestEvent) {
        QLog.d("OnlineStatusTencentVideoPlugin", 1, "getOnlineStatusMsg");
        QIPCClientHelper.getInstance().callServer("TencentVideoStatusQIPCModule", "ACTION_GET_ONLINE_STATUS_MAIN", null, new EIPCResultCallback() { // from class: com.tencent.qqmini.nativePlugins.w
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                ac.this.n(requestEvent, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void o(final RequestEvent requestEvent, final QBaseActivity qBaseActivity, final MiniAppInterface miniAppInterface, final JSONObject jSONObject, final String str, EIPCResult eIPCResult) {
        QLog.d("OnlineStatusTencentVideoPlugin", 1, "ACTION_SHOW_ONLINE_STATUS_POPUPWINDOW onCallback");
        if (eIPCResult == null) {
            QLog.e("OnlineStatusTencentVideoPlugin", 1, "ACTION_SHOW_ONLINE_STATUS_POPUPWINDOW error, result is null");
            return;
        }
        try {
            if (eIPCResult.code != 0) {
                requestEvent.fail();
                QLog.e("OnlineStatusTencentVideoPlugin", 1, "ACTION_SHOW_ONLINE_STATUS_POPUPWINDOW: result.code: " + eIPCResult.code);
                return;
            }
            final String string = eIPCResult.data.getString(IOnlineStatusMiniService.VIDEO_NAME);
            final String optString = jSONObject.optString("url");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.nativePlugins.y
                @Override // java.lang.Runnable
                public final void run() {
                    ac.this.m(miniAppInterface, qBaseActivity, string, str, optString, jSONObject, requestEvent);
                }
            });
        } catch (Exception e16) {
            QLog.e("OnlineStatusTencentVideoPlugin", 1, "ACTION_SHOW_ONLINE_STATUS_POPUPWINDOW: " + e16);
            requestEvent.fail(e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(RequestEvent requestEvent, boolean z16) {
        if (z16) {
            requestEvent.fail();
            QLog.e("OnlineStatusTencentVideoPlugin", 1, "ACTION_SHOW_ONLINE_STATUS_POPUPWINDOW: isActivelyClose true");
        }
    }
}
