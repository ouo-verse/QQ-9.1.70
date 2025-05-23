package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.dynamic.DynamicResShiplyFetcher;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebRtcProxy;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes34.dex */
public class WebRTCProxyImpl extends WebRtcProxy {

    /* renamed from: c, reason: collision with root package name */
    private DynamicResShiplyFetcher f347660c;

    /* renamed from: a, reason: collision with root package name */
    private final String[] f347658a = {"gmcg_webrtc"};

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f347659b = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f347661d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f347662e = false;

    /* loaded from: classes34.dex */
    class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347666a;

        a(AsyncResult asyncResult) {
            this.f347666a = asyncResult;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            AsyncResult asyncResult = this.f347666a;
            if (asyncResult != null) {
                asyncResult.onReceiveResult(z16, jSONObject);
            }
        }
    }

    /* loaded from: classes34.dex */
    class b implements Function2<Boolean, String, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347668d;

        b(AsyncResult asyncResult) {
            this.f347668d = asyncResult;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, String str) {
            QLog.i("YunGame_WebRtcProxy", 1, "getDynamicPath updateDexRes isSuccess:" + bool + ", errMsg:" + str);
            if (bool.booleanValue()) {
                AsyncResult asyncResult = this.f347668d;
                WebRTCProxyImpl webRTCProxyImpl = WebRTCProxyImpl.this;
                asyncResult.onReceiveResult(true, webRTCProxyImpl.g(webRTCProxyImpl.f347660c.getDexPagePath("miniwebrtc")));
            } else {
                this.f347668d.onReceiveResult(false, null);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject g(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", str);
            return jSONObject;
        } catch (JSONException e16) {
            throw new RuntimeException(e16);
        }
    }

    private JSONObject h(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isSystemLibrary", false);
            jSONObject.put("soFileDir", str);
        } catch (JSONException e16) {
            QLog.e("YunGame_WebRtcProxy", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync("gmcg_webrtc", new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setCloseRetry(true).build());
        QLog.i("YunGame_WebRtcProxy", 1, "checkSoReady loadResult isSuccess:" + loadSync.isSucc() + ",failInfo:" + loadSync.failInfo + ",path:" + loadSync.getRelatedFilesFolder());
        if (!loadSync.isSucc()) {
            return null;
        }
        String relatedFilesFolder = loadSync.getRelatedFilesFolder();
        boolean z16 = true;
        for (String str : this.f347658a) {
            File file = new File(relatedFilesFolder + File.separator + RFixConstants.SO_PATH + str + ".so");
            if (!file.exists()) {
                QLog.e("YunGame_WebRtcProxy", 1, "checkSoReady soFile:" + file + ",not exists");
                z16 = false;
            }
        }
        if (z16) {
            return relatedFilesFolder;
        }
        return null;
    }

    private boolean k(String str) {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME).decodeBool(MiniGameVAMMKVKEY.MINI_GAME_YUN_USE_PRELOAD + str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(AsyncResult asyncResult, int i3, LoadExtResult loadExtResult) {
        QLog.i("YunGame_WebRtcProxy", 1, "updateSo download resCode:" + i3 + ",loadExtResult:" + loadExtResult.isSucc());
        String i16 = i();
        if (TextUtils.isEmpty(i16)) {
            if (asyncResult != null) {
                asyncResult.onReceiveResult(false, null);
            }
        } else if (asyncResult != null) {
            asyncResult.onReceiveResult(true, h(i16));
        }
    }

    private void m(boolean z16, boolean z17, boolean z18, boolean z19) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = "2";
        if (z16 && z18) {
            z17 = z17 || z19;
            str = "4";
        } else if (z18) {
            str = "3";
            z17 = z19;
        } else if (z16) {
            str = "2";
        } else {
            str = "1";
            z17 = false;
        }
        hashMap.put("ext7", str);
        if (z17) {
            str2 = "1";
        }
        hashMap.put("ext8", str2);
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989726", "18", "", hashMap);
        n(ResInfo.RES_TYPE_SO, false);
        n("dex", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, boolean z16) {
        QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME).encodeBool(MiniGameVAMMKVKEY.MINI_GAME_YUN_USE_PRELOAD + str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final AsyncResult asyncResult) {
        SoLoadManager.getInstance().download("gmcg_webrtc", new OnLoadListener() { // from class: com.tencent.qqmini.proxyimpl.cg
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                WebRTCProxyImpl.this.l(asyncResult, i3, loadExtResult);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebRtcProxy
    public void getWebRTCDynamicPath(Context context, AsyncResult asyncResult) {
        if (this.f347660c == null) {
            this.f347660c = new DynamicResShiplyFetcher(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance(), "minigame_webrtc_dynamic", true);
        }
        long resVersion = this.f347660c.getResVersion();
        String dexPagePath = this.f347660c.getDexPagePath("miniwebrtc");
        if (resVersion > 0 && !TextUtils.isEmpty(dexPagePath)) {
            this.f347661d = true;
            this.f347662e = k("dex");
            asyncResult.onReceiveResult(true, g(dexPagePath));
            this.f347660c.updateDexRes(false, null);
            return;
        }
        this.f347661d = false;
        this.f347660c.updateDexRes(true, new b(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebRtcProxy
    public boolean isSupportAARSo() {
        return false;
    }

    public void j(final Boolean bool) {
        if (this.f347659b) {
            return;
        }
        this.f347659b = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.WebRTCProxyImpl.1

            /* renamed from: com.tencent.qqmini.proxyimpl.WebRTCProxyImpl$1$a */
            /* loaded from: classes34.dex */
            class a implements AsyncResult {
                a() {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    WebRTCProxyImpl.this.n(ResInfo.RES_TYPE_SO, true);
                }
            }

            /* renamed from: com.tencent.qqmini.proxyimpl.WebRTCProxyImpl$1$b */
            /* loaded from: classes34.dex */
            class b implements Function2<Boolean, String, Unit> {
                b() {
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unit invoke(Boolean bool, String str) {
                    WebRTCProxyImpl.this.n("dex", true);
                    return null;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(WebRTCProxyImpl.this.i())) {
                        WebRTCProxyImpl.this.o(new a());
                    }
                    DynamicResShiplyFetcher dynamicResShiplyFetcher = new DynamicResShiplyFetcher(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance(), "minigame_webrtc_dynamic", true);
                    long resVersion = dynamicResShiplyFetcher.getResVersion();
                    String dexPagePath = dynamicResShiplyFetcher.getDexPagePath("miniwebrtc");
                    if (resVersion != 0 && !TextUtils.isEmpty(dexPagePath)) {
                        if (bool.booleanValue()) {
                            dynamicResShiplyFetcher.updateDexRes(true, null);
                        }
                        QLog.i("YunGame_WebRtcProxy", 1, "checkWebRTCAsync dexPath:" + dexPagePath + ",forceUpdate:" + bool);
                    }
                    dynamicResShiplyFetcher.updateDexRes(true, new b());
                    QLog.i("YunGame_WebRtcProxy", 1, "checkWebRTCAsync dexPath:" + dexPagePath + ",forceUpdate:" + bool);
                } catch (Exception e16) {
                    QLog.e("YunGame_WebRtcProxy", 1, e16, new Object[0]);
                }
            }
        }, 128, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebRtcProxy
    public void loadWebRTCSo(Context context, AsyncResult asyncResult) {
        String i3 = i();
        if (!TextUtils.isEmpty(i3)) {
            if (asyncResult != null) {
                asyncResult.onReceiveResult(true, h(i3));
            }
            m(true, k(ResInfo.RES_TYPE_SO), this.f347661d, this.f347662e);
            o(null);
            return;
        }
        m(false, false, this.f347661d, this.f347662e);
        o(new a(asyncResult));
    }
}
