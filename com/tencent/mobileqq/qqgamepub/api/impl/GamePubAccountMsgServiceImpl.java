package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameAdService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameKuiklyApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class GamePubAccountMsgServiceImpl extends Observable implements IGamePubAccountMsgService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QQGamePub_GamePubAccountMsgServiceImpl";
    private AppRuntime mApp;
    private BusinessObserver mObserver;
    private WeakReference<b> msgListenerRef;

    /* loaded from: classes16.dex */
    class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GamePubAccountMsgServiceImpl.this);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            long j3;
            long j16;
            String str;
            String str2;
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            JSONObject optJSONObject2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            QLog.i(GamePubAccountMsgServiceImpl.TAG, 1, "[getSimpleTopicCollection] onReceive:" + z16);
            if (!z16) {
                return;
            }
            try {
                byte[] byteArray = bundle.getByteArray("extra_data");
                if (byteArray == null) {
                    QLog.e(GamePubAccountMsgServiceImpl.TAG, 1, "[getSimpleTopicCollection] onReceive: data is null.");
                    return;
                }
                WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                if (webSSOAgent$UniSsoServerRsp.comm.has() && webSSOAgent$UniSsoServerRsp.comm.proctime.has()) {
                    j3 = webSSOAgent$UniSsoServerRsp.comm.proctime.get();
                } else {
                    j3 = -1;
                }
                if (webSSOAgent$UniSsoServerRsp.ret.has()) {
                    j16 = webSSOAgent$UniSsoServerRsp.ret.get();
                } else {
                    j16 = 0;
                }
                if (webSSOAgent$UniSsoServerRsp.errmsg.has()) {
                    str = webSSOAgent$UniSsoServerRsp.errmsg.get();
                } else {
                    str = "SSO\u53d1\u9001\u6210\u529f";
                }
                if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
                    str2 = webSSOAgent$UniSsoServerRsp.rspdata.get();
                } else {
                    str2 = "";
                }
                if (QLog.isColorLevel()) {
                    QLog.d(GamePubAccountMsgServiceImpl.TAG, 2, "[getSimpleTopicCollection] onReceive svrCostTime :" + j3 + ", Json: " + str2 + ", bizRet: " + j16 + ", msg: " + str);
                }
                if (j16 == 0 && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has("list") && (optJSONArray = optJSONObject.optJSONArray("list")) != null && optJSONArray.length() > 0 && (optJSONObject2 = optJSONArray.optJSONObject(0)) != null && optJSONObject2.has("rawData")) {
                        String optString = optJSONObject2.optString("rawData");
                        if (QLog.isColorLevel()) {
                            QLog.d(GamePubAccountMsgServiceImpl.TAG, 2, "[getSimpleTopicCollection] onReceive rawData:" + optString);
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(GamePubAccountMsgServiceImpl.this.mApp.getApplicationContext(), "common_mmkv_configurations");
                            fromV2.putString("key_simple_topic_data", optString.toString());
                            fromV2.putLong("key_simple_topic_data_time", System.currentTimeMillis());
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.e(GamePubAccountMsgServiceImpl.TAG, 1, "[getSimpleTopicCollection] onReceive, Exception:" + th5);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static class b extends com.tencent.qqnt.msg.i {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<GamePubAccountMsgServiceImpl> f264398e;

        public b(GamePubAccountMsgServiceImpl gamePubAccountMsgServiceImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gamePubAccountMsgServiceImpl);
            } else {
                this.f264398e = new WeakReference<>(gamePubAccountMsgServiceImpl);
            }
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRecvMsg(@NonNull ArrayList<MsgRecord> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                return;
            }
            GamePubAccountMsgServiceImpl gamePubAccountMsgServiceImpl = this.f264398e.get();
            if (gamePubAccountMsgServiceImpl == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if ("2747277822".equals(arrayList.get(i3).getPeerUin() + "")) {
                    arrayList2.add(arrayList.get(i3));
                }
            }
            if (arrayList2.size() > 0) {
                gamePubAccountMsgServiceImpl.onGameNewMsg(arrayList);
            }
        }
    }

    /* loaded from: classes16.dex */
    public static class c implements TianShuGetAdvCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<GamePubAccountMsgServiceImpl> f264399d;

        /* loaded from: classes16.dex */
        class a implements com.tencent.mobileqq.qqgamepub.utils.c {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.mobileqq.qqgamepub.utils.c
            public void a(JSONObject jSONObject) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
                    return;
                }
                GamePubAccountMsgServiceImpl gamePubAccountMsgServiceImpl = (GamePubAccountMsgServiceImpl) c.this.f264399d.get();
                if (gamePubAccountMsgServiceImpl != null) {
                    gamePubAccountMsgServiceImpl.startShowGamePaNoticeMsgByTianShu(jSONObject);
                }
            }

            @Override // com.tencent.mobileqq.qqgamepub.utils.c
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                GamePubAccountMsgServiceImpl gamePubAccountMsgServiceImpl = (GamePubAccountMsgServiceImpl) c.this.f264399d.get();
                if (gamePubAccountMsgServiceImpl != null) {
                    gamePubAccountMsgServiceImpl.removeDescAndNoticeCache();
                }
            }
        }

        public c(GamePubAccountMsgServiceImpl gamePubAccountMsgServiceImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gamePubAccountMsgServiceImpl);
            } else {
                this.f264399d = new WeakReference<>(gamePubAccountMsgServiceImpl);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), getAdsRsp);
            } else {
                com.tencent.mobileqq.qqgamepub.utils.a.a(z16, getAdsRsp, new a());
            }
        }
    }

    public GamePubAccountMsgServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.msgListenerRef = new WeakReference<>(null);
            this.mObserver = new a();
        }
    }

    private void addListeners() {
        b bVar = new b(this);
        this.msgListenerRef = new WeakReference<>(bVar);
        ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).addMsgListener(bVar);
    }

    private void getSimpleTopicCollection() {
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", 0);
            jSONObject.put("need_new", true);
            String i3 = ih2.e.i("/v1/1799", jSONObject.toString());
            if (TextUtils.isEmpty(i3)) {
                return;
            }
            webSSOAgent$UniSsoServerReq.reqdata.set(i3);
            NewIntent newIntent = new NewIntent(this.mApp.getApp(), am.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "GDCTrpcProxy.down");
            newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtra("extra_callbackid", "0");
            newIntent.putExtra("extra_timeout", 2000);
            newIntent.setObserver(this.mObserver);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[getSimpleTopicCollection] reqData=" + i3);
            }
            this.mApp.startServlet(newIntent);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "[getSimpleTopicCollection] e:" + e16);
            }
        }
    }

    private boolean isSameNotice(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!StringUtil.isEmpty(jSONObject.optString("attach"))) {
                    JSONObject q16 = GamePubAccountHelper.q();
                    if (!StringUtil.isEmpty(jSONObject.optString("attach")) && (q16 == null || StringUtil.isEmpty(q16.optString("attach")))) {
                        return false;
                    }
                    if (q16 == null) {
                        return true;
                    }
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("attach"));
                    JSONObject jSONObject3 = new JSONObject(q16.optString("attach"));
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "attachJson: " + jSONObject2 + "--->cacheAttachJson: " + jSONObject3);
                    }
                    return jSONObject3.optString("seq").equals(jSONObject2.optString("seq"));
                }
            } catch (Exception unused) {
            }
        }
        QLog.i(TAG, 1, "[isSameNotice] message exception!!!");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onGameNewMsg$0() {
        ((IQQGameKuiklyApi) QRoute.api(IQQGameKuiklyApi.class)).updateGamePubAccountKuikly(((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getGamePubPreloadKuilyBundleList());
    }

    private ArrayList<QQGameMsgInfo> parseMsgInfoList(List<MsgRecord> list) {
        ArrayList<QQGameMsgInfo> arrayList = new ArrayList<>();
        for (MsgRecord msgRecord : list) {
            if ("2747277822".equals(msgRecord.getPeerUin() + "")) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "enter qqgame message handle");
                }
                QQGameMsgInfo g16 = com.tencent.mobileqq.qqgamepub.nt.c.g(msgRecord);
                if (g16 != null) {
                    if (!((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isInterceptMsg(g16.advId)) {
                        arrayList.add(g16);
                        QLog.i(TAG, 1, "[onGameNewMsg] " + g16.triggerInfo);
                    } else {
                        QLog.d(TAG, 1, "delete qqgame message adid=" + g16.advId);
                        ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).deleteMsg(g16.msgId);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onGameNewMsg qqGameMsgInfoList=" + arrayList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDescAndNoticeCache() {
        GamePubAccountHelper.d();
    }

    private void removeListeners() {
        b bVar = this.msgListenerRef.get();
        if (bVar != null) {
            ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).removeMsgListener(bVar);
        }
    }

    protected boolean canReqTianshu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (!((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isPushMsgSwitchOn()) {
            QLog.i(TAG, 1, "<<<[isCanReqTianshu] isPushMsgSwitchOn: switch off<<<");
            return false;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long A = GamePubAccountHelper.A();
        long pushMsgInterval = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getPushMsgInterval() * 1000;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "currentTs: " + serverTimeMillis + " lastTs: " + A + " tsInterval: " + pushMsgInterval);
        }
        if (serverTimeMillis - A < pushMsgInterval) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService
    public void onAccountChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
            addListeners();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            removeListeners();
            deleteObservers();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService
    public void onGameNewMsg(List<MsgRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onGameNewMsg mrList=" + list);
        }
        if (list != null) {
            try {
                if (list.size() > 0) {
                    ArrayList<QQGameMsgInfo> parseMsgInfoList = parseMsgInfoList(list);
                    getSimpleTopicCollection();
                    if (parseMsgInfoList.size() > 0) {
                        setChanged();
                        notifyObservers(new com.tencent.mobileqq.qqgamepub.data.c("action_qgame_tool_messgae", parseMsgInfoList));
                        Intent intent = new Intent("action_qgame_tool_messgae");
                        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key_get_msg", parseMsgInfoList);
                        intent.putExtras(bundle);
                        MobileQQ.sMobileQQ.sendBroadcast(intent);
                        QQGameMsgInfo qQGameMsgInfo = parseMsgInfoList.get(0);
                        if (qQGameMsgInfo.isAdMsg && qQGameMsgInfo.adJson != null) {
                            ((IQQGameAdService) QRoute.api(IQQGameAdService.class)).reportGdt(qQGameMsgInfo, 1);
                        }
                        ((IQQGamePreDownloadService) QRoute.api(IQQGamePreDownloadService.class)).preDownloadPubPushRes(parseMsgInfoList);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                GamePubAccountMsgServiceImpl.lambda$onGameNewMsg$0();
                            }
                        }, 16, null, false);
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "send qqgame message fail by:" + th5.getMessage());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService
    public void reqGamePaNoticeByTianShu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (!canReqTianshu()) {
            QLog.i(TAG, 2, "<<<[reqGamePaNoticeByTianShu] isOverTimeReqInterval<<<");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.GamePubAccountMsgServiceImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GamePubAccountMsgServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QLog.i(GamePubAccountMsgServiceImpl.TAG, 2, "<<<[reqGamePaNoticeByTianShu] start req tianshu<<<");
                        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(com.tencent.mobileqq.qqgamepub.utils.a.g(902), new c(GamePubAccountMsgServiceImpl.this));
                    }
                }
            }, 128, null, true);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService
    public void saveGalleryDataToMsg(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).saveGalleryDataToMsg(this.mApp, bundle);
        }
    }

    public void startShowGamePaNoticeMsgByTianShu(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject);
            return;
        }
        QLog.i(TAG, 1, "startShowGamePaNoticeMsgByTianShu --> msg\uff1a " + jSONObject);
        if (jSONObject == null) {
            QLog.i(TAG, 1, "startShowGamePaNoticeMsgByPush --> param notice is empty!!!");
            return;
        }
        boolean isPubAccountReceiveMsg = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).isPubAccountReceiveMsg((AppInterface) this.mApp);
        QLog.i(TAG, 1, "startShowGamePaNoticeMsgByPush --> isFlowPa: " + isPubAccountReceiveMsg);
        if (isPubAccountReceiveMsg && !isSameNotice(jSONObject)) {
            GamePubAccountHelper.O(jSONObject);
        }
    }
}
