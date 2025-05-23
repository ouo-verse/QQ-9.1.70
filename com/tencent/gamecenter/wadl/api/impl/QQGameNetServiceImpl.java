package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameAutoDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerRsp;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreCircleRequest;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreCircleResponse;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreUpdateRequest;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreUpdateResponse;
import tencent.im.qqgame.QQGameIntercept$GetDownloadTipsRequest;
import tencent.im.qqgame.QQGameIntercept$GetDownloadTipsResponse;
import tencent.im.qqgame.QQGameIntercept$GetFloatingWindowRequest;
import tencent.im.qqgame.QQGameIntercept$GetFloatingWindowResponse;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameNetServiceImpl implements IQQGameNetService {
    private static final String TAG = "Wadl_QQGameNetServiceImpl";
    private CopyOnWriteArrayList<WeakReference<nl0.c>> webssoListeners = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f106629d;

        a(int i3) {
            this.f106629d = i3;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QQGameNetServiceImpl.this.onUpdateReceive(this.f106629d, i3, z16, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f106631d;

        b(int i3) {
            this.f106631d = i3;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QQGameNetServiceImpl.this.onPullReceive(this.f106631d, i3, z16, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f106633d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ nl0.f f106634e;

        c(String str, nl0.f fVar) {
            this.f106633d = str;
            this.f106634e = fVar;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QLog.i(QQGameNetServiceImpl.TAG, 2, "type: " + i3 + ", isSuccess: " + z16 + ", appid: " + this.f106633d);
            if (z16 && bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP) != null) {
                QQGameIntercept$GetDownloadTipsResponse qQGameIntercept$GetDownloadTipsResponse = new QQGameIntercept$GetDownloadTipsResponse();
                try {
                    qQGameIntercept$GetDownloadTipsResponse.mergeFrom(bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP));
                    nl0.f fVar = this.f106634e;
                    if (fVar != null) {
                        fVar.b(qQGameIntercept$GetDownloadTipsResponse);
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException unused) {
                    nl0.f fVar2 = this.f106634e;
                    if (fVar2 != null) {
                        fVar2.a();
                        return;
                    }
                    return;
                }
            }
            nl0.f fVar3 = this.f106634e;
            if (fVar3 != null) {
                fVar3.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f106636d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ nl0.e f106637e;

        d(String str, nl0.e eVar) {
            this.f106636d = str;
            this.f106637e = eVar;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            QLog.i(QQGameNetServiceImpl.TAG, 2, "type: " + i3 + ", isSuccess: " + z16 + ", appid: " + this.f106636d);
            if (z16 && bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP) != null) {
                QQGameIntercept$GetFloatingWindowResponse qQGameIntercept$GetFloatingWindowResponse = new QQGameIntercept$GetFloatingWindowResponse();
                try {
                    qQGameIntercept$GetFloatingWindowResponse.mergeFrom(bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP));
                    nl0.e eVar = this.f106637e;
                    if (eVar != null) {
                        eVar.b(qQGameIntercept$GetFloatingWindowResponse);
                        return;
                    }
                    return;
                } catch (InvalidProtocolBufferMicroException unused) {
                    nl0.e eVar2 = this.f106637e;
                    if (eVar2 != null) {
                        eVar2.a();
                        return;
                    }
                    return;
                }
            }
            nl0.e eVar3 = this.f106637e;
            if (eVar3 != null) {
                eVar3.a();
            }
        }
    }

    private void notifyListeners(Intent intent, String str, long j3, JSONObject jSONObject) {
        QLog.d(TAG, 1, "notifyListeners cmd=" + str + ",ret=" + j3 + ",listeners size=" + this.webssoListeners.size());
        Iterator<WeakReference<nl0.c>> it = this.webssoListeners.iterator();
        while (it.hasNext()) {
            WeakReference<nl0.c> next = it.next();
            nl0.c cVar = next.get();
            if (cVar != null) {
                HashSet<String> filterCmds = cVar.getFilterCmds();
                if (filterCmds == null || filterCmds.contains(str)) {
                    QLog.d(TAG, 1, "notifyListeners cmd=" + str + ",ret=" + j3 + ",listener=" + cVar);
                    cVar.onCmdRsp(intent, str, j3, jSONObject);
                }
            } else {
                QLog.i(TAG, 1, "listener is null.");
                this.webssoListeners.remove(next);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void addListener(nl0.c cVar) {
        QLog.d(TAG, 1, "addListener listener=" + cVar);
        if (cVar == null) {
            return;
        }
        Iterator<WeakReference<nl0.c>> it = this.webssoListeners.iterator();
        while (it.hasNext()) {
            nl0.c cVar2 = it.next().get();
            if (cVar2 != null && cVar2 == cVar) {
                return;
            }
        }
        QLog.d(TAG, 1, "addListener listener=" + cVar + " succ");
        this.webssoListeners.add(new WeakReference<>(cVar));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void destroy() {
        QLog.d(TAG, 1, "destroy webssoListeners size=" + this.webssoListeners.size());
        this.webssoListeners.clear();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void getApkDownloadInfo(String str, ArrayList<String> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
        }
        QLog.d(TAG, 1, "getApkDownloadInfo channelId=" + str + ",appIds=" + jSONArray);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("channel_id", str);
            jSONObject2.put("v_appid", jSONArray);
            jSONObject.put("req", jSONObject2);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("appids", arrayList);
            requestWebSso(WadlProxyConsts.CMD_GET_APK_DOWNLOAD_INFO, jSONObject, bundle);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getApkDownloadInfo exception=", e16);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void getAutoDownloadTask(int i3) {
        WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
        webSSOAgent$UniSsoServerReqComm.platform.set(109L);
        webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
        webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
        WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
        webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
        if (i3 == 0) {
            QQGameAutoDownloadTask$GetPreUpdateRequest qQGameAutoDownloadTask$GetPreUpdateRequest = new QQGameAutoDownloadTask$GetPreUpdateRequest();
            qQGameAutoDownloadTask$GetPreUpdateRequest.qq_version.set(AppSetting.n());
            webSSOAgent$UniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(qQGameAutoDownloadTask$GetPreUpdateRequest.toByteArray()));
            NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, WadlProxyConsts.CMD_TRPC_GET_PREUPDATE);
            newIntent.putExtra(WadlProxyConsts.PARAM_WEBSSO_REQ, webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtra(WadlProxyConsts.KEY_SSO_TYPE, 2);
            newIntent.setObserver(new a(i3));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e(TAG, 2, "[getAutoDownloadTask] appRuntime is null");
                return;
            } else {
                peekAppRuntime.startServlet(newIntent);
                return;
            }
        }
        if (i3 == 1) {
            QQGameAutoDownloadTask$GetPreCircleRequest qQGameAutoDownloadTask$GetPreCircleRequest = new QQGameAutoDownloadTask$GetPreCircleRequest();
            qQGameAutoDownloadTask$GetPreCircleRequest.qq_version.set(AppSetting.n());
            webSSOAgent$UniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(qQGameAutoDownloadTask$GetPreCircleRequest.toByteArray()));
            NewIntent newIntent2 = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
            newIntent2.putExtra(WadlProxyConsts.EXTRA_CMD, WadlProxyConsts.CMD_TRPC_GET_PREUPDATE_CIRCLE);
            newIntent2.putExtra(WadlProxyConsts.PARAM_WEBSSO_REQ, webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent2.putExtra(WadlProxyConsts.KEY_SSO_TYPE, 2);
            newIntent2.setObserver(new b(i3));
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 == null) {
                QLog.e(TAG, 2, "[getAutoDownloadTask] appRuntime is null");
            } else {
                peekAppRuntime2.startServlet(newIntent2);
            }
        }
    }

    public JSONObject getRspJson(WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp, String str) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = new JSONObject(webSSOAgent$UniSsoServerRsp.rspdata.get()).optJSONObject(str);
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("data")) != null) {
            return optJSONObject.optJSONObject("rsp");
        }
        return null;
    }

    public boolean isFilterCmdId(String str) {
        return WadlProxyConsts.CMD_REQUEST_RED_POINT.equals(str);
    }

    protected void onPullReceive(int i3, int i16, boolean z16, Bundle bundle) {
        QLog.i(TAG, 2, "type: " + i16 + ", isSuccess: " + z16 + ", trpcCmd: " + bundle.getString(WadlProxyConsts.EXTRA_CMD));
        IQQGameAutoDownloadService iQQGameAutoDownloadService = null;
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iQQGameAutoDownloadService = (IQQGameAutoDownloadService) peekAppRuntime.getRuntimeService(IQQGameAutoDownloadService.class, "");
            }
            if (iQQGameAutoDownloadService != null) {
                if (z16 && bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP) != null) {
                    QQGameAutoDownloadTask$GetPreCircleResponse qQGameAutoDownloadTask$GetPreCircleResponse = new QQGameAutoDownloadTask$GetPreCircleResponse();
                    qQGameAutoDownloadTask$GetPreCircleResponse.mergeFrom(bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP));
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "ret:" + qQGameAutoDownloadTask$GetPreCircleResponse.ret.get() + ", msg: " + qQGameAutoDownloadTask$GetPreCircleResponse.f436028msg.get());
                    }
                    if (qQGameAutoDownloadTask$GetPreCircleResponse.ret.get() == 0) {
                        iQQGameAutoDownloadService.handleCircleAutoDownloadSuccess(qQGameAutoDownloadTask$GetPreCircleResponse);
                        return;
                    } else {
                        iQQGameAutoDownloadService.handleAutoDownloadFail(i3);
                        return;
                    }
                }
                iQQGameAutoDownloadService.handleAutoDownloadFail(i3);
            }
        } catch (Throwable unused) {
            if (0 != 0) {
                iQQGameAutoDownloadService.handleAutoDownloadFail(i3);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void onRespWebSso(Intent intent, boolean z16, byte[] bArr) {
        JSONObject jSONObject;
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(WadlProxyConsts.PARAM_WEBSSO_CMD_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String str = stringExtra;
        JSONObject jSONObject2 = null;
        long j3 = -1;
        if (z16 && bArr != null) {
            try {
                WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                webSSOAgent$UniSsoServerRsp.mergeFrom(bArr);
                j3 = webSSOAgent$UniSsoServerRsp.ret.get();
                if (j3 == 0) {
                    jSONObject2 = getRspJson(webSSOAgent$UniSsoServerRsp, str);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onRespWebSso cmdId=" + str + ",err:" + e16.getMessage());
            }
        }
        JSONObject jSONObject3 = jSONObject2;
        long j16 = j3;
        QLog.d(TAG, 1, "onRespWebSso cmdId=" + str + ",isSucc=" + z16 + ",ret=" + j16 + ",rspJson=" + jSONObject3);
        if (isFilterCmdId(str)) {
            return;
        }
        if (jSONObject3 == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = jSONObject3;
        }
        notifyListeners(intent, str, j16, jSONObject);
    }

    protected void onUpdateReceive(int i3, int i16, boolean z16, Bundle bundle) {
        QLog.i(TAG, 2, "type: " + i16 + ", isSuccess: " + z16 + ", trpcCmd: " + bundle.getString(WadlProxyConsts.EXTRA_CMD));
        IQQGameAutoDownloadService iQQGameAutoDownloadService = null;
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iQQGameAutoDownloadService = (IQQGameAutoDownloadService) peekAppRuntime.getRuntimeService(IQQGameAutoDownloadService.class, "");
            }
            if (iQQGameAutoDownloadService != null) {
                if (z16 && bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP) != null) {
                    QQGameAutoDownloadTask$GetPreUpdateResponse qQGameAutoDownloadTask$GetPreUpdateResponse = new QQGameAutoDownloadTask$GetPreUpdateResponse();
                    qQGameAutoDownloadTask$GetPreUpdateResponse.mergeFrom(bundle.getByteArray(WadlProxyConsts.PARAM_WEBSSO_RSP));
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "ret:" + qQGameAutoDownloadTask$GetPreUpdateResponse.ret.get() + ", msg: " + qQGameAutoDownloadTask$GetPreUpdateResponse.f436029msg.get());
                    }
                    if (qQGameAutoDownloadTask$GetPreUpdateResponse.ret.get() == 0) {
                        iQQGameAutoDownloadService.handleUpdateAutoDownloadSuccess(qQGameAutoDownloadTask$GetPreUpdateResponse);
                        return;
                    } else {
                        iQQGameAutoDownloadService.handleAutoDownloadFail(i3);
                        return;
                    }
                }
                iQQGameAutoDownloadService.handleAutoDownloadFail(i3);
            }
        } catch (Throwable unused) {
            if (0 != 0) {
                iQQGameAutoDownloadService.handleAutoDownloadFail(i3);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void removeListener(nl0.c cVar) {
        QLog.d(TAG, 1, "addListener listener=" + cVar);
        if (cVar == null) {
            return;
        }
        Iterator<WeakReference<nl0.c>> it = this.webssoListeners.iterator();
        while (it.hasNext()) {
            nl0.c cVar2 = it.next().get();
            if (cVar2 != null && cVar2 == cVar) {
                return;
            }
        }
        QLog.d(TAG, 1, "addListener listener=" + cVar + " succ");
        this.webssoListeners.add(new WeakReference<>(cVar));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void requestFloatingWindow(String str, String str2, String str3, nl0.e eVar) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "appid: " + str + ", manufacturer: " + str2 + ",model: " + str3);
        }
        QQGameIntercept$GetFloatingWindowRequest qQGameIntercept$GetFloatingWindowRequest = new QQGameIntercept$GetFloatingWindowRequest();
        qQGameIntercept$GetFloatingWindowRequest.appid.set(str);
        qQGameIntercept$GetFloatingWindowRequest.manufacturer.set(str2);
        qQGameIntercept$GetFloatingWindowRequest.model.set(str3);
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, WadlProxyConsts.CMD_TRPC_GET_FLOAT_WINDOWS_INFO);
        newIntent.putExtra(WadlProxyConsts.PARAM_WEBSSO_REQ, qQGameIntercept$GetFloatingWindowRequest.toByteArray());
        newIntent.putExtra(WadlProxyConsts.KEY_SSO_TYPE, 2);
        newIntent.setObserver(new d(str, eVar));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 2, "[requestInterceptPageConfig] appRuntime is null");
        } else {
            peekAppRuntime.startServlet(newIntent);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void requestInterceptPageConfig(String str, nl0.f fVar) {
        QQGameIntercept$GetDownloadTipsRequest qQGameIntercept$GetDownloadTipsRequest = new QQGameIntercept$GetDownloadTipsRequest();
        qQGameIntercept$GetDownloadTipsRequest.appid.set(str);
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, WadlProxyConsts.CMD_TRPC_GET_DOWNLOAD_TIPS);
        newIntent.putExtra(WadlProxyConsts.PARAM_WEBSSO_REQ, qQGameIntercept$GetDownloadTipsRequest.toByteArray());
        newIntent.putExtra(WadlProxyConsts.KEY_SSO_TYPE, 2);
        newIntent.setObserver(new c(str, fVar));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 2, "[requestInterceptPageConfig] appRuntime is null");
        } else {
            peekAppRuntime.startServlet(newIntent);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void requestRedPoint(int i3) {
        QLog.d(TAG, 1, "requestRedPoint sceneId=" + i3);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("scene_id", i3);
            jSONObject2.put("uin", GameCenterUtil.getUin());
            jSONObject2.put(TtmlNode.TAG_TT, 1);
            jSONObject.put("req", jSONObject2);
            requestWebSso(WadlProxyConsts.CMD_REQUEST_RED_POINT, jSONObject, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "requestRedPoint exception=", e16);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameNetService
    public void requestWebSso(String str, JSONObject jSONObject, Bundle bundle) {
        AppRuntime peekAppRuntime;
        QLog.d(TAG, 1, "requestWebSso webssoCmd=" + str + ",reqData=" + jSONObject);
        if (jSONObject == null || TextUtils.isEmpty(str) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99554n);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, jSONObject);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject2.toString());
            NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(WadlProxyConsts.KEY_SSO_TYPE, 0);
            bundle.putString(WadlProxyConsts.PARAM_WEBSSO_CMD_ID, str);
            bundle.putByteArray(WadlProxyConsts.PARAM_WEBSSO_REQ, webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtras(bundle);
            peekAppRuntime.startServlet(newIntent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "requestWebSso exception=", e16);
        }
    }
}
