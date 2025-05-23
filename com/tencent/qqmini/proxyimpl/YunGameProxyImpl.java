package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.impl.YunGameManagerServiceImpl;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$GetUserKeyReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameCenterYunGameAuth$GetUserKeyRsp;
import com.tencent.mobileqq.minigame.dynamic.DynamicResShiplyFetcher;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes34.dex */
public class YunGameProxyImpl extends YunGameProxy {

    /* renamed from: f, reason: collision with root package name */
    private DynamicResShiplyFetcher f347704f;

    /* renamed from: a, reason: collision with root package name */
    private final String[] f347699a = {"jingle_peerconnection_so_tenc", "rawquic_jni"};

    /* renamed from: b, reason: collision with root package name */
    private List<AsyncResult> f347700b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Object f347701c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f347702d = false;

    /* renamed from: e, reason: collision with root package name */
    private String f347703e = "";

    /* renamed from: g, reason: collision with root package name */
    private final WadlTrpcListener f347705g = new WadlTrpcListener() { // from class: com.tencent.qqmini.proxyimpl.YunGameProxyImpl.9
        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return new HashSet<String>() { // from class: com.tencent.qqmini.proxyimpl.YunGameProxyImpl.9.1
                {
                    add(YunGameManagerServiceImpl.TRPC_AUTH_CMD);
                }
            };
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
            QLog.i("YunGameProxyImpl", 2, "[onTrpcRsp] onTrpcRsp ret:" + j3 + ", cmd:" + str);
            if (intent == null) {
                QLog.i("YunGameProxyImpl", 2, "[onTrpcRsp] onTrpcRsp request null.");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                QLog.i("YunGameProxyImpl", 2, "[onTrpcRsp] cmd is empty.");
                return;
            }
            if (YunGameManagerServiceImpl.TRPC_AUTH_CMD.equals(str)) {
                if (j3 == 0 && trpcInovkeRsp != null && trpcInovkeRsp.data.get() != null) {
                    try {
                        QLog.e("YunGameProxyImpl", 1, "[onTrpcRsp] TRPC_AUTH_CMD suc.");
                        GameCenterYunGameAuth$GetUserKeyRsp gameCenterYunGameAuth$GetUserKeyRsp = new GameCenterYunGameAuth$GetUserKeyRsp();
                        gameCenterYunGameAuth$GetUserKeyRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                        String str2 = gameCenterYunGameAuth$GetUserKeyRsp.user_key.get();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("userKey", str2);
                        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                        if (runtime != null) {
                            jSONObject.put("userId", runtime.getAccount());
                        }
                        YunGameProxyImpl.this.q(Boolean.TRUE, jSONObject);
                        return;
                    } catch (Exception e16) {
                        QLog.e("YunGameProxyImpl", 1, e16, new Object[0]);
                        YunGameProxyImpl.this.q(Boolean.FALSE, null);
                        return;
                    }
                }
                QLog.e("YunGameProxyImpl", 1, "[onTrpcRsp] TRPC_AUTH_CMD failed.");
                YunGameProxyImpl.this.q(Boolean.FALSE, null);
            }
        }
    };

    /* renamed from: com.tencent.qqmini.proxyimpl.YunGameProxyImpl$4, reason: invalid class name */
    /* loaded from: classes34.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ YunGameProxyImpl this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                String l3 = this.this$0.l();
                if (TextUtils.isEmpty(l3)) {
                    this.this$0.v(null);
                }
                DynamicResShiplyFetcher dynamicResShiplyFetcher = new DynamicResShiplyFetcher(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance(), "minigame_yungame_dynamic", true);
                long resVersion = dynamicResShiplyFetcher.getResVersion();
                String dexPagePath = dynamicResShiplyFetcher.getDexPagePath("yungame");
                if (resVersion == 0 || TextUtils.isEmpty(dexPagePath)) {
                    dynamicResShiplyFetcher.updateDexRes(true, null);
                }
                QLog.i("YunGameProxyImpl", 1, "checkYunGameAsync soPath:" + l3 + ",dexPath:" + dexPagePath);
            } catch (Exception e16) {
                QLog.e("YunGameProxyImpl", 1, e16, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a implements AsyncResult {
        a() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            YunGameProxyImpl.this.t(Boolean.valueOf(z16), jSONObject);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(YunGameProxyImpl.this.f347705g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f347710a;

        c(String str) {
            this.f347710a = str;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            QLog.i("YunGameProxyImpl", 1, "parallelRequest fastLogin isSuccess:" + z16);
            YunGameProxyImpl.this.u(this.f347710a, Boolean.valueOf(z16), jSONObject);
        }
    }

    /* loaded from: classes34.dex */
    class d implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347712a;

        d(AsyncResult asyncResult) {
            this.f347712a = asyncResult;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            AsyncResult asyncResult = this.f347712a;
            if (asyncResult != null) {
                asyncResult.onReceiveResult(z16, jSONObject);
            }
        }
    }

    /* loaded from: classes34.dex */
    class e implements Function2<Boolean, String, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347714d;

        e(AsyncResult asyncResult) {
            this.f347714d = asyncResult;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, String str) {
            QLog.i("YunGameProxyImpl", 1, "getDynamicPath updateDexRes isSuccess:" + bool + ", errMsg:" + str);
            if (bool.booleanValue()) {
                AsyncResult asyncResult = this.f347714d;
                YunGameProxyImpl yunGameProxyImpl = YunGameProxyImpl.this;
                asyncResult.onReceiveResult(true, yunGameProxyImpl.j(yunGameProxyImpl.f347704f.getDexPagePath("yungame")));
            } else {
                this.f347714d.onReceiveResult(false, null);
            }
            return null;
        }
    }

    /* loaded from: classes34.dex */
    class f implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347716a;

        f(AsyncResult asyncResult) {
            this.f347716a = asyncResult;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            this.f347716a.onReceiveResult(z16, jSONObject);
        }
    }

    private Boolean i(AsyncResult asyncResult) {
        synchronized (this.f347701c) {
            if (this.f347700b.size() > 0) {
                this.f347700b.add(asyncResult);
                return Boolean.FALSE;
            }
            this.f347700b.add(asyncResult);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", str);
            return jSONObject;
        } catch (JSONException e16) {
            throw new RuntimeException(e16);
        }
    }

    private JSONObject k(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isSystemLibrary", false);
            jSONObject.put("soFileDir", str);
        } catch (JSONException e16) {
            QLog.e("YunGameProxyImpl", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync("jingle_peerconnection_so_tenc", new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setCloseRetry(true).build());
        QLog.i("YunGameProxyImpl", 1, "checkSoReady loadResult isSuccess:" + loadSync.isSucc() + ",failInfo:" + loadSync.failInfo + ",extra:" + loadSync.getRelatedFilesFolder());
        if (!loadSync.isSucc()) {
            return null;
        }
        String relatedFilesFolder = loadSync.getRelatedFilesFolder();
        boolean z16 = true;
        for (String str : this.f347699a) {
            File file = new File(relatedFilesFolder + File.separator + RFixConstants.SO_PATH + str + ".so");
            if (!file.exists()) {
                QLog.e("YunGameProxyImpl", 1, "checkSoReady soFile:" + file + ",not exists");
                z16 = false;
            }
        }
        if (z16) {
            return relatedFilesFolder;
        }
        return null;
    }

    private void m() {
        synchronized (this.f347701c) {
            if (this.f347700b.size() > 0) {
                QLog.e("YunGameProxyImpl", 1, "cleanAuthCallback has size, then clean");
            }
            this.f347700b.clear();
        }
    }

    private JSONObject n() {
        try {
            if (TextUtils.isEmpty(this.f347703e)) {
                this.f347703e = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME).decodeString(MiniGameVAMMKVKEY.MINI_GAME_YUN_GAME_AUTH_INFO, "");
            }
            if (TextUtils.isEmpty(this.f347703e)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(this.f347703e);
            if ((TextUtils.isEmpty(jSONObject.optString("userId")) || TextUtils.isEmpty(jSONObject.optString("userKey"))) ? false : true) {
                return jSONObject;
            }
            QLog.i("YunGameProxyImpl", 1, "getCachedAuthInfo not valid and reset cache");
            this.f347703e = null;
            t(Boolean.FALSE, null);
            return null;
        } catch (JSONException e16) {
            QLog.e("YunGameProxyImpl", 1, e16, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(AsyncResult asyncResult, int i3, LoadExtResult loadExtResult) {
        QLog.i("YunGameProxyImpl", 1, "updateSo download resCode:" + i3 + ",loadExtResult:" + loadExtResult.isSucc());
        String l3 = l();
        if (TextUtils.isEmpty(l3)) {
            if (asyncResult != null) {
                asyncResult.onReceiveResult(false, null);
            }
        } else if (asyncResult != null) {
            asyncResult.onReceiveResult(true, k(l3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Boolean bool, JSONObject jSONObject) {
        if (bool.booleanValue() && jSONObject != null) {
            this.f347703e = jSONObject.toString();
        }
        synchronized (this.f347701c) {
            Iterator<AsyncResult> it = this.f347700b.iterator();
            while (it.hasNext()) {
                it.next().onReceiveResult(bool.booleanValue(), jSONObject);
            }
            this.f347700b.clear();
        }
    }

    private void s(AsyncResult asyncResult) {
        if (!i(asyncResult).booleanValue()) {
            QLog.i("YunGameProxyImpl", 2, "[getYunGameAuthInfo] start get Auth Key second and just wait");
            return;
        }
        QLog.i("YunGameProxyImpl", 2, "[getYunGameAuthInfo] start get Auth Key.....");
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(YunGameManagerServiceImpl.TRPC_AUTH_CMD, false, new GameCenterYunGameAuth$GetUserKeyReq().toByteArray());
        Bundle bundle = new Bundle();
        bundle.putString("key_cmd", YunGameManagerServiceImpl.TRPC_AUTH_CMD);
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Boolean bool, JSONObject jSONObject) {
        String str;
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        if (bool.booleanValue() && jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str = "";
        }
        this.f347703e = str;
        fromV2.encodeString(MiniGameVAMMKVKEY.MINI_GAME_YUN_GAME_AUTH_INFO, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final AsyncResult asyncResult) {
        SoLoadManager.getInstance().download("jingle_peerconnection_so_tenc", new OnLoadListener() { // from class: com.tencent.qqmini.proxyimpl.cq
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                YunGameProxyImpl.this.p(asyncResult, i3, loadExtResult);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy
    public Boolean canUsePag() {
        Boolean valueOf = Boolean.valueOf(((IVasTempApi) QRoute.api(IVasTempApi.class)).initPagSo());
        if (!valueOf.booleanValue()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.YunGameProxyImpl.8

                /* renamed from: com.tencent.qqmini.proxyimpl.YunGameProxyImpl$8$a */
                /* loaded from: classes34.dex */
                class a implements Function0<Unit> {
                    a() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Unit invoke() {
                        QLog.i("YunGameProxyImpl", 1, "canUsePag requestPagDownload finish");
                        return null;
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    ((IVasTempApi) QRoute.api(IVasTempApi.class)).requestPagDownload(new a());
                }
            }, 128, null, false);
        }
        return valueOf;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy
    public void fastLogin(MiniAppInfo miniAppInfo, AsyncResult asyncResult) {
        ((QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class)).fastLogin(miniAppInfo, new f(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy
    public void getDynamicPath(Context context, AsyncResult asyncResult) {
        if (this.f347704f == null) {
            this.f347704f = new DynamicResShiplyFetcher(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance(), "minigame_yungame_dynamic", true);
        }
        long resVersion = this.f347704f.getResVersion();
        String dexPagePath = this.f347704f.getDexPagePath("yungame");
        if (resVersion > 0 && !TextUtils.isEmpty(dexPagePath)) {
            asyncResult.onReceiveResult(true, j(dexPagePath));
            this.f347704f.updateDexRes(false, null);
        } else {
            this.f347704f.updateDexRes(true, new e(asyncResult));
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy
    public void getYunGameAuthInfo(AsyncResult asyncResult) {
        JSONObject n3 = n();
        if (n3 != null) {
            QLog.i("YunGameProxyImpl", 2, "[getYunGameAuthInfo] use cacheObj");
            asyncResult.onReceiveResult(true, n3);
        } else {
            s(asyncResult);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy
    public void init() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f347705g);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy
    public void loadYunGameSoPath(Context context, AsyncResult asyncResult) {
        String l3 = l();
        if (!TextUtils.isEmpty(l3)) {
            if (asyncResult != null) {
                asyncResult.onReceiveResult(true, k(l3));
            }
            v(null);
            return;
        }
        v(new d(asyncResult));
    }

    public JSONObject o(String str) {
        String decodeString = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME).decodeString(MiniGameVAMMKVKEY.MINI_GAME_YUN_GAME_LOGIN_INFO + str, "");
        if (TextUtils.isEmpty(decodeString)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(decodeString);
            if ((TextUtils.isEmpty(jSONObject.optString("openId")) || TextUtils.isEmpty(jSONObject.optString(CommonConstant.KEY_ACCESS_TOKEN))) ? false : true) {
                return jSONObject;
            }
            u(str, Boolean.FALSE, null);
            return null;
        } catch (JSONException e16) {
            QLog.e("YunGameProxyImpl", 1, e16, new Object[0]);
            return null;
        }
    }

    public void r(String str) {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        u(str, Boolean.FALSE, null);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.f347705g);
        s(new a());
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            qQCustomizedProxy.getOAID(true, new b());
            MiniAppInfo miniAppInfo = new MiniAppInfo();
            miniAppInfo.extInfo = String.format("{\"mapInfo\":[{\"key\":\"game_app_id\",\"value\":\"%s\"}]}", str);
            qQCustomizedProxy.fastLogin(miniAppInfo, new c(str));
        }
    }

    public void u(String str, Boolean bool, JSONObject jSONObject) {
        String str2;
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        if (bool.booleanValue() && jSONObject != null) {
            str2 = jSONObject.toString();
        } else {
            str2 = "";
        }
        this.f347703e = str2;
        fromV2.encodeString(MiniGameVAMMKVKEY.MINI_GAME_YUN_GAME_LOGIN_INFO + str, this.f347703e);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy
    public void unInit() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.f347705g);
        m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements AsyncResult {
        b() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
        }
    }
}
