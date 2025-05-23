package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.utils.WebSSOUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.WebSsoBody$WebLoginSig;
import com.tencent.mobileqq.WebSsoBody$WebSsoRequestBody;
import com.tencent.mobileqq.WebSsoBody$WebSsoResponseBody;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.zplan.web.api.IZPlanWebDataHandler;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SSOWebviewPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    protected Activity f97423d;

    /* renamed from: e, reason: collision with root package name */
    NewIntent f97424e;

    /* renamed from: m, reason: collision with root package name */
    private CookieManager f97428m;

    /* renamed from: f, reason: collision with root package name */
    long f97425f = 0;

    /* renamed from: h, reason: collision with root package name */
    int f97426h = 0;

    /* renamed from: i, reason: collision with root package name */
    int f97427i = 204800;
    public HashMap<String, Long> C = new HashMap<>();
    public HashMap<String, Long> D = new HashMap<>();
    public HashMap<String, Long> E = new HashMap<>();
    HashMap<String, Pair<Long, Integer>> F = new HashMap<>();
    HashMap<String, Integer> G = new HashMap<>();
    private com.tencent.mobileqq.emosm.t H = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class RequestTask implements Runnable {
        String C;
        WeakReference<SSOWebviewPlugin> D;
        public final AtomicBoolean E = new AtomicBoolean(false);

        /* renamed from: d, reason: collision with root package name */
        String f97429d;

        /* renamed from: e, reason: collision with root package name */
        int f97430e;

        /* renamed from: f, reason: collision with root package name */
        String f97431f;

        /* renamed from: h, reason: collision with root package name */
        boolean f97432h;

        /* renamed from: i, reason: collision with root package name */
        String f97433i;

        /* renamed from: m, reason: collision with root package name */
        String f97434m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class a implements com.tencent.mobileqq.webview.swift.injector.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f97435a;

            a(String str) {
                this.f97435a = str;
            }

            @Override // com.tencent.mobileqq.webview.swift.injector.g
            public void onFail(@NotNull String str) {
                QLog.d("SSOWebviewPlugin", 1, "waitGetPskey fail:" + str);
                RequestTask.this.E.set(true);
                synchronized (RequestTask.this.E) {
                    RequestTask.this.E.notifyAll();
                }
            }

            @Override // com.tencent.mobileqq.webview.swift.injector.g
            public void onSuccess(@NotNull Map<String, String> map) {
                String e16;
                if (map != null) {
                    RequestTask.this.C = map.get(this.f97435a);
                }
                if (RequestTask.this.C == null) {
                    e16 = " null";
                } else {
                    e16 = com.tencent.biz.common.util.k.e(" p_skey=" + RequestTask.this.C, new String[0]);
                }
                QLog.d("SSOWebviewPlugin", 1, "waitGetPskey suc ", com.tencent.biz.common.util.k.f(this.f97435a, new String[0]), e16);
                RequestTask.this.E.set(true);
                synchronized (RequestTask.this.E) {
                    RequestTask.this.E.notifyAll();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class b implements BusinessObserver {
            b() {
            }

            private void a(FromServiceMsg fromServiceMsg, JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ret", fromServiceMsg.getTrpcRspRetCode());
                jSONObject2.put("funcRet", fromServiceMsg.getTrpcRspFuncRetCode());
                if (fromServiceMsg.getTrpcRspErrorMsg() != null && fromServiceMsg.getTrpcRspErrorMsg().length > 0) {
                    jSONObject2.put("errMsg", new String(fromServiceMsg.getTrpcRspErrorMsg()));
                }
                jSONObject.put("trpc", jSONObject2);
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                SSOWebviewPlugin sSOWebviewPlugin = RequestTask.this.D.get();
                if (sSOWebviewPlugin == null) {
                    return;
                }
                try {
                    FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("fromServiceMsg");
                    if (z16) {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            WebSsoBody$WebSsoResponseBody webSsoBody$WebSsoResponseBody = new WebSsoBody$WebSsoResponseBody();
                            webSsoBody$WebSsoResponseBody.mergeFrom(byteArray);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("data", webSsoBody$WebSsoResponseBody.data.get());
                            jSONObject.put("retcode", webSsoBody$WebSsoResponseBody.ret.get());
                            jSONObject.put("cret", 0);
                            a(fromServiceMsg, jSONObject);
                            sSOWebviewPlugin.callJs(RequestTask.this.f97434m, jSONObject.toString());
                            if (webSsoBody$WebSsoResponseBody.controlData.get().frequency.has()) {
                                sSOWebviewPlugin.f97426h = webSsoBody$WebSsoResponseBody.controlData.get().frequency.get();
                            }
                            if (webSsoBody$WebSsoResponseBody.controlData.get().packageSize.has()) {
                                sSOWebviewPlugin.f97427i = webSsoBody$WebSsoResponseBody.controlData.get().packageSize.get();
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("SSOWebviewPlugin", 1, String.format("onReceive suc cmd=%s hasFreq=%b freq=%d ", RequestTask.this.f97431f, Boolean.valueOf(webSsoBody$WebSsoResponseBody.controlData.get().frequency.has()), Integer.valueOf(sSOWebviewPlugin.f97426h)));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cret", 1);
                    jSONObject2.put("cret_msg", "\u8bf7\u6c42\u5931\u8d25");
                    a(fromServiceMsg, jSONObject2);
                    sSOWebviewPlugin.callJs(RequestTask.this.f97434m, jSONObject2.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d("SSOWebviewPlugin", 2, "onReceive fail result=", jSONObject2);
                    }
                } catch (Exception e16) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("cret", 2);
                        jSONObject3.put("cret_msg", "json \u89e3\u6790\u5931\u8d25\uff1a" + e16.getMessage());
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                    sSOWebviewPlugin.callJs(RequestTask.this.f97434m, jSONObject3.toString());
                }
            }
        }

        RequestTask(String str, int i3, String str2, boolean z16, String str3, String str4, SSOWebviewPlugin sSOWebviewPlugin) {
            this.f97429d = str;
            this.f97430e = i3;
            this.f97431f = str2;
            this.f97432h = z16;
            this.f97433i = str3;
            this.f97434m = str4;
            this.D = new WeakReference<>(sSOWebviewPlugin);
        }

        private void f(String str) {
            AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("SSOWebviewPlugin", 1, "waitGetPskey fail app==null");
                return;
            }
            QLog.d("SSOWebviewPlugin", 1, "waitGetPskey start ", com.tencent.biz.common.util.k.f(str, new String[0]));
            com.tencent.mobileqq.webview.swift.cookie.a.b(str, peekAppRuntime, new a(str));
            if (!this.E.get()) {
                synchronized (this.E) {
                    if (!this.E.get()) {
                        try {
                            this.E.wait(30000L);
                        } catch (InterruptedException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i("SSOWebviewPlugin", 2, e16.getMessage(), e16);
                            }
                        }
                    }
                }
            }
        }

        protected void e() {
            SSOWebviewPlugin sSOWebviewPlugin = this.D.get();
            if (sSOWebviewPlugin == null) {
                return;
            }
            NewIntent newIntent = new NewIntent(sSOWebviewPlugin.mRuntime.a().getApplicationContext(), com.tencent.biz.p.class);
            newIntent.putExtra("cmd", this.f97431f);
            newIntent.putExtra("bNTRequest", this.f97432h);
            String moduleId = sSOWebviewPlugin.mRuntime.c().getModuleId();
            if (!TextUtils.isEmpty(moduleId)) {
                newIntent.putExtra("moduleId", moduleId);
            }
            WebSsoBody$WebSsoRequestBody webSsoBody$WebSsoRequestBody = new WebSsoBody$WebSsoRequestBody();
            boolean z16 = false;
            webSsoBody$WebSsoRequestBody.type.set(0);
            webSsoBody$WebSsoRequestBody.data.set(this.f97433i);
            if (this.f97430e > 0) {
                WebSsoBody$WebLoginSig webSsoBody$WebLoginSig = new WebSsoBody$WebLoginSig();
                webSsoBody$WebLoginSig.uint32_type.set(27);
                String str = this.C;
                if (str != null) {
                    webSsoBody$WebLoginSig.bytes_sig.set(ByteStringMicro.copyFrom(str.getBytes()));
                }
                webSsoBody$WebLoginSig.uint32_appid.set(this.f97430e);
                webSsoBody$WebSsoRequestBody.login_sig.set(webSsoBody$WebLoginSig);
            }
            Object[] objArr = new Object[8];
            objArr[0] = "doSendRequest cmd: ";
            objArr[1] = this.f97431f;
            objArr[2] = " needPskey:";
            if (this.f97430e > 0) {
                z16 = true;
            }
            objArr[3] = Boolean.valueOf(z16);
            objArr[4] = " moduleId: ";
            objArr[5] = moduleId;
            objArr[6] = " isNT: ";
            objArr[7] = Boolean.valueOf(this.f97432h);
            QLog.d("SSOWebviewPlugin", 1, objArr);
            newIntent.putExtra("data", webSsoBody$WebSsoRequestBody.toByteArray());
            newIntent.setObserver(new b());
            newIntent.setWithouLogin(true);
            sSOWebviewPlugin.mRuntime.b().startServlet(newIntent);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f97430e > 0) {
                if (SSOWebviewPlugin.q()) {
                    ThreadManagerV2.excute(this, 128, null, false);
                    return;
                }
                f(this.f97429d);
            }
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f97439d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f97440e;

        b(long j3, String str) {
            this.f97439d = j3;
            this.f97440e = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x014b A[Catch: Exception -> 0x02c5, TryCatch #0 {Exception -> 0x02c5, blocks: (B:3:0x0008, B:7:0x0019, B:10:0x0030, B:12:0x0039, B:14:0x0049, B:16:0x0053, B:17:0x0068, B:19:0x006e, B:21:0x0078, B:23:0x008f, B:24:0x00aa, B:26:0x00b0, B:27:0x009e, B:28:0x00ce, B:30:0x00d8, B:32:0x00fa, B:33:0x010f, B:35:0x0119, B:37:0x0128, B:38:0x0140, B:40:0x014b, B:42:0x0159, B:43:0x015f, B:45:0x0168, B:46:0x0181, B:48:0x0189, B:50:0x0198, B:51:0x01b4, B:53:0x01bc, B:55:0x01ce, B:56:0x0268, B:58:0x026e, B:59:0x0287, B:61:0x02a9, B:64:0x02b7, B:67:0x01ae, B:68:0x017e, B:70:0x01e5, B:72:0x01eb, B:73:0x01f1, B:75:0x01fe, B:77:0x020e, B:80:0x0227, B:86:0x0243, B:87:0x0254), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0189 A[Catch: Exception -> 0x02c5, TryCatch #0 {Exception -> 0x02c5, blocks: (B:3:0x0008, B:7:0x0019, B:10:0x0030, B:12:0x0039, B:14:0x0049, B:16:0x0053, B:17:0x0068, B:19:0x006e, B:21:0x0078, B:23:0x008f, B:24:0x00aa, B:26:0x00b0, B:27:0x009e, B:28:0x00ce, B:30:0x00d8, B:32:0x00fa, B:33:0x010f, B:35:0x0119, B:37:0x0128, B:38:0x0140, B:40:0x014b, B:42:0x0159, B:43:0x015f, B:45:0x0168, B:46:0x0181, B:48:0x0189, B:50:0x0198, B:51:0x01b4, B:53:0x01bc, B:55:0x01ce, B:56:0x0268, B:58:0x026e, B:59:0x0287, B:61:0x02a9, B:64:0x02b7, B:67:0x01ae, B:68:0x017e, B:70:0x01e5, B:72:0x01eb, B:73:0x01f1, B:75:0x01fe, B:77:0x020e, B:80:0x0227, B:86:0x0243, B:87:0x0254), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x01bc A[Catch: Exception -> 0x02c5, TryCatch #0 {Exception -> 0x02c5, blocks: (B:3:0x0008, B:7:0x0019, B:10:0x0030, B:12:0x0039, B:14:0x0049, B:16:0x0053, B:17:0x0068, B:19:0x006e, B:21:0x0078, B:23:0x008f, B:24:0x00aa, B:26:0x00b0, B:27:0x009e, B:28:0x00ce, B:30:0x00d8, B:32:0x00fa, B:33:0x010f, B:35:0x0119, B:37:0x0128, B:38:0x0140, B:40:0x014b, B:42:0x0159, B:43:0x015f, B:45:0x0168, B:46:0x0181, B:48:0x0189, B:50:0x0198, B:51:0x01b4, B:53:0x01bc, B:55:0x01ce, B:56:0x0268, B:58:0x026e, B:59:0x0287, B:61:0x02a9, B:64:0x02b7, B:67:0x01ae, B:68:0x017e, B:70:0x01e5, B:72:0x01eb, B:73:0x01f1, B:75:0x01fe, B:77:0x020e, B:80:0x0227, B:86:0x0243, B:87:0x0254), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x026e A[Catch: Exception -> 0x02c5, TryCatch #0 {Exception -> 0x02c5, blocks: (B:3:0x0008, B:7:0x0019, B:10:0x0030, B:12:0x0039, B:14:0x0049, B:16:0x0053, B:17:0x0068, B:19:0x006e, B:21:0x0078, B:23:0x008f, B:24:0x00aa, B:26:0x00b0, B:27:0x009e, B:28:0x00ce, B:30:0x00d8, B:32:0x00fa, B:33:0x010f, B:35:0x0119, B:37:0x0128, B:38:0x0140, B:40:0x014b, B:42:0x0159, B:43:0x015f, B:45:0x0168, B:46:0x0181, B:48:0x0189, B:50:0x0198, B:51:0x01b4, B:53:0x01bc, B:55:0x01ce, B:56:0x0268, B:58:0x026e, B:59:0x0287, B:61:0x02a9, B:64:0x02b7, B:67:0x01ae, B:68:0x017e, B:70:0x01e5, B:72:0x01eb, B:73:0x01f1, B:75:0x01fe, B:77:0x020e, B:80:0x0227, B:86:0x0243, B:87:0x0254), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x02a9 A[Catch: Exception -> 0x02c5, TryCatch #0 {Exception -> 0x02c5, blocks: (B:3:0x0008, B:7:0x0019, B:10:0x0030, B:12:0x0039, B:14:0x0049, B:16:0x0053, B:17:0x0068, B:19:0x006e, B:21:0x0078, B:23:0x008f, B:24:0x00aa, B:26:0x00b0, B:27:0x009e, B:28:0x00ce, B:30:0x00d8, B:32:0x00fa, B:33:0x010f, B:35:0x0119, B:37:0x0128, B:38:0x0140, B:40:0x014b, B:42:0x0159, B:43:0x015f, B:45:0x0168, B:46:0x0181, B:48:0x0189, B:50:0x0198, B:51:0x01b4, B:53:0x01bc, B:55:0x01ce, B:56:0x0268, B:58:0x026e, B:59:0x0287, B:61:0x02a9, B:64:0x02b7, B:67:0x01ae, B:68:0x017e, B:70:0x01e5, B:72:0x01eb, B:73:0x01f1, B:75:0x01fe, B:77:0x020e, B:80:0x0227, B:86:0x0243, B:87:0x0254), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01ae A[Catch: Exception -> 0x02c5, TryCatch #0 {Exception -> 0x02c5, blocks: (B:3:0x0008, B:7:0x0019, B:10:0x0030, B:12:0x0039, B:14:0x0049, B:16:0x0053, B:17:0x0068, B:19:0x006e, B:21:0x0078, B:23:0x008f, B:24:0x00aa, B:26:0x00b0, B:27:0x009e, B:28:0x00ce, B:30:0x00d8, B:32:0x00fa, B:33:0x010f, B:35:0x0119, B:37:0x0128, B:38:0x0140, B:40:0x014b, B:42:0x0159, B:43:0x015f, B:45:0x0168, B:46:0x0181, B:48:0x0189, B:50:0x0198, B:51:0x01b4, B:53:0x01bc, B:55:0x01ce, B:56:0x0268, B:58:0x026e, B:59:0x0287, B:61:0x02a9, B:64:0x02b7, B:67:0x01ae, B:68:0x017e, B:70:0x01e5, B:72:0x01eb, B:73:0x01f1, B:75:0x01fe, B:77:0x020e, B:80:0x0227, B:86:0x0243, B:87:0x0254), top: B:2:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x017e A[Catch: Exception -> 0x02c5, TryCatch #0 {Exception -> 0x02c5, blocks: (B:3:0x0008, B:7:0x0019, B:10:0x0030, B:12:0x0039, B:14:0x0049, B:16:0x0053, B:17:0x0068, B:19:0x006e, B:21:0x0078, B:23:0x008f, B:24:0x00aa, B:26:0x00b0, B:27:0x009e, B:28:0x00ce, B:30:0x00d8, B:32:0x00fa, B:33:0x010f, B:35:0x0119, B:37:0x0128, B:38:0x0140, B:40:0x014b, B:42:0x0159, B:43:0x015f, B:45:0x0168, B:46:0x0181, B:48:0x0189, B:50:0x0198, B:51:0x01b4, B:53:0x01bc, B:55:0x01ce, B:56:0x0268, B:58:0x026e, B:59:0x0287, B:61:0x02a9, B:64:0x02b7, B:67:0x01ae, B:68:0x017e, B:70:0x01e5, B:72:0x01eb, B:73:0x01f1, B:75:0x01fe, B:77:0x020e, B:80:0x0227, B:86:0x0243, B:87:0x0254), top: B:2:0x0008 }] */
        @Override // mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            long j3;
            String str;
            try {
                System.currentTimeMillis();
                String string = bundle.getString("extra_callbackid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if (z16) {
                    byte[] byteArray = bundle.getByteArray("extra_data");
                    if (byteArray != null) {
                        WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                        webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                        if (webSSOAgent$UniSsoServerRsp.comm.has()) {
                            String string2 = bundle.getString(WadlProxyConsts.EXTRA_CMD);
                            if (QLog.isColorLevel()) {
                                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, cmd=" + string2);
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                if (webSSOAgent$UniSsoServerRsp.comm.delayms.has()) {
                                    long longValue = Long.valueOf(webSSOAgent$UniSsoServerRsp.comm.delayms.get()).longValue();
                                    if (longValue == 0) {
                                        SSOWebviewPlugin.this.G.put(string2, Integer.MAX_VALUE);
                                    } else {
                                        SSOWebviewPlugin.this.G.put(string2, Integer.valueOf((int) longValue));
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, delay=" + longValue + ", cmd:" + string2);
                                    }
                                }
                                if (webSSOAgent$UniSsoServerRsp.comm.packagesize.has()) {
                                    long longValue2 = Long.valueOf(webSSOAgent$UniSsoServerRsp.comm.packagesize.get()).longValue();
                                    SSOWebviewPlugin.this.D.put(string2, Long.valueOf(longValue2));
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, pkgSize=" + longValue2);
                                    }
                                }
                                if (webSSOAgent$UniSsoServerRsp.comm.proctime.has()) {
                                    j3 = webSSOAgent$UniSsoServerRsp.comm.proctime.get();
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, svrCostTime=" + j3);
                                    }
                                    jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 0);
                                    if (!webSSOAgent$UniSsoServerRsp.ret.has()) {
                                        long j16 = webSSOAgent$UniSsoServerRsp.ret.get();
                                        if (TextUtils.isEmpty(this.f97440e)) {
                                            QLog.e("SSOWebviewPlugin", 1, "uniAgent, reportSSOReqRespWatch, cmd is empty");
                                        }
                                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, j16);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, biz ret code=" + j16);
                                        }
                                    } else {
                                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                                    }
                                    if (!webSSOAgent$UniSsoServerRsp.errmsg.has()) {
                                        String str2 = webSSOAgent$UniSsoServerRsp.errmsg.get();
                                        jSONObject.put("msg", str2);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, errmsg=" + str2);
                                        }
                                    } else {
                                        jSONObject.put("msg", "SSO\u53d1\u9001\u6210\u529f");
                                    }
                                    if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
                                        String str3 = webSSOAgent$UniSsoServerRsp.rspdata.get();
                                        jSONObject.put("data", str3);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, rspData=" + str3);
                                        }
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d("SSOWebviewPlugin", 2, "uniAgent, callback Json string=" + jSONObject.toString());
                                    }
                                    JSONObject s16 = SSOWebviewPlugin.s(j3);
                                    jSONObject.put("speedPoint", s16);
                                    SSOWebviewPlugin.this.callJs(string, jSONObject.toString());
                                    str = "ssoWebView";
                                    if (!TextUtils.isEmpty(this.f97440e) && this.f97440e.startsWith("apollo")) {
                                        str = "apolloSSOWebView";
                                    }
                                    SSOWebviewPlugin.w(SSOWebviewPlugin.this.mRuntime.b(), this.f97440e, str, jSONObject, s16);
                                }
                            }
                        }
                        j3 = -1;
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 0);
                        if (!webSSOAgent$UniSsoServerRsp.ret.has()) {
                        }
                        if (!webSSOAgent$UniSsoServerRsp.errmsg.has()) {
                        }
                        if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        JSONObject s162 = SSOWebviewPlugin.s(j3);
                        jSONObject.put("speedPoint", s162);
                        SSOWebviewPlugin.this.callJs(string, jSONObject.toString());
                        str = "ssoWebView";
                        if (!TextUtils.isEmpty(this.f97440e)) {
                            str = "apolloSSOWebView";
                        }
                        SSOWebviewPlugin.w(SSOWebviewPlugin.this.mRuntime.b(), this.f97440e, str, jSONObject, s162);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.w("SSOWebviewPlugin", 2, "uniAgent, onReceive, ret success but no data");
                    }
                    jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 255);
                    jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                    jSONObject.put("msg", "SSO\u8fd4\u56de\u6570\u636e\u5305\u4e3a\u7a7a");
                } else {
                    bundle.getString(WadlProxyConsts.EXTRA_CMD);
                    int i16 = bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE);
                    if (QLog.isColorLevel()) {
                        QLog.d("SSOWebviewPlugin", 2, "uniAgent, msfResultCode=" + i16);
                    }
                    if (i16 == 1001) {
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 201);
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                        jSONObject.put("msg", HardCodeUtil.qqStr(R.string.toy));
                    } else {
                        if (i16 != 1002 && i16 != 1013) {
                            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 255);
                            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                            jSONObject.put("msg", HardCodeUtil.qqStr(R.string.f172733tp3));
                        }
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 202);
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                        jSONObject.put("msg", HardCodeUtil.qqStr(R.string.f172734tp4));
                    }
                }
                j3 = -1;
                if (QLog.isColorLevel()) {
                }
                JSONObject s1622 = SSOWebviewPlugin.s(j3);
                jSONObject.put("speedPoint", s1622);
                SSOWebviewPlugin.this.callJs(string, jSONObject.toString());
                str = "ssoWebView";
                if (!TextUtils.isEmpty(this.f97440e)) {
                }
                SSOWebviewPlugin.w(SSOWebviewPlugin.this.mRuntime.b(), this.f97440e, str, jSONObject, s1622);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SSOWebviewPlugin", 2, "uniAgent, onReceive, Exception: " + e16);
                }
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean q() {
        return u();
    }

    private boolean r(String str) {
        if (this.mRuntime.e() == null) {
            return false;
        }
        return ((IZPlanWebDataHandler) QRoute.api(IZPlanWebDataHandler.class)).doInterceptCmd(this.mRuntime.e().getUrl(), str, this.mRuntime.b(), this);
    }

    public static JSONObject s(long j3) {
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            am.f238850h = currentTimeMillis;
            long j16 = currentTimeMillis - am.f238847d;
            long j17 = am.f238848e - am.f238847d;
            long j18 = am.f238849f - am.f238848e;
            long j19 = am.f238850h - am.f238849f;
            if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, total=" + j16 + ",pre=" + j17 + ",msf=" + j18 + ",after=" + j19);
            }
            jSONObject.put("totalTime", j16);
            jSONObject.put("packTime", j17);
            jSONObject.put("SSONetworkTime", j18);
            jSONObject.put("unpackTime", j19);
            jSONObject.put("serverProcessTime", j3);
        } catch (Throwable th5) {
            QLog.e("SSOWebviewPlugin", 1, "generateAgentCostData e:" + th5);
        }
        return jSONObject;
    }

    public static JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fingerprint", Build.FINGERPRINT);
            jSONObject.put("model", DeviceInfoMonitor.getModel());
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put("product", Build.PRODUCT);
            jSONObject.put("id", Build.ID);
            jSONObject.put("level", Build.VERSION.SDK_INT);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("cpu_abi2", Build.CPU_ABI2);
        } catch (Throwable th5) {
            QLog.e("SSOWebviewPlugin", 1, "getRomData e:" + th5);
        }
        return jSONObject;
    }

    private static boolean u() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static void v(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.remove("callback");
        jSONObject.remove("cmd");
        jSONObject.remove("needCookie");
        jSONObject.remove("timeout");
    }

    public static void w(AppInterface appInterface, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        boolean z16;
        if (appInterface != null && jSONObject2 != null) {
            try {
                long optLong = jSONObject2.optLong("totalTime");
                long optLong2 = jSONObject2.optLong("packTime");
                long optLong3 = jSONObject2.optLong("SSONetworkTime");
                long optLong4 = jSONObject2.optLong("unpackTime");
                long optLong5 = jSONObject2.optLong("serverProcessTime");
                long optLong6 = jSONObject.optLong(WebSSOUtils.CALLBACK_COLUMN_SSORET, 0L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(optLong6));
                hashMap.put("totalTime", optLong + "");
                hashMap.put("packTime", optLong2 + "");
                hashMap.put("SSONetworkTime", optLong3 + "");
                hashMap.put("unpackTime", optLong4 + "");
                hashMap.put("serverProcessTime", optLong5 + "");
                hashMap.put("cmd", str);
                String currentAccountUin = appInterface.getCurrentAccountUin();
                StatisticCollector statisticCollector = StatisticCollector.getInstance(appInterface.getApplicationContext());
                if (0 == optLong6) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                statisticCollector.collectPerformance(currentAccountUin, str2, z16, optLong, 0L, hashMap, "", false);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("SSOWebviewPlugin", 2, "report ssoWebView:  " + th5);
                }
            }
        }
    }

    private void x(String str, String str2) {
        long j3;
        CustomWebView e16;
        if (TextUtils.isEmpty(str) || this.mRuntime == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, jsonStr=" + str + ", url=" + str2);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("cmd");
            String string2 = jSONObject.getString("callback");
            long j16 = jSONObject.has("timeout") ? jSONObject.getLong("timeout") : -1L;
            if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, cmd=" + string + ", callbackId=" + string2 + ",timeout = " + j16);
            }
            if (TextUtils.isEmpty(string2)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no callbackId");
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 255);
                jSONObject2.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                jSONObject2.put("msg", HardCodeUtil.qqStr(R.string.f172730tp0));
                super.callJs(string2, jSONObject2.toString());
                if (QLog.isColorLevel()) {
                    QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: no cmd");
                    return;
                }
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 103);
                jSONObject3.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                jSONObject3.put("msg", "MSF\u672a\u8fde\u63a5");
                super.callJs(string2, jSONObject3.toString());
                if (QLog.isColorLevel()) {
                    QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: network unavailable");
                    return;
                }
                return;
            }
            long longValue = this.D.containsKey(string) ? this.D.get(string).longValue() : 10240L;
            if (longValue > 0) {
                j3 = j16;
                long length = jSONObject.toString().getBytes().length;
                if (length > longValue) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 101);
                    jSONObject4.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                    jSONObject4.put("msg", HardCodeUtil.qqStr(R.string.tp8));
                    super.callJs(string2, jSONObject4.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: pkg size exceeded, dataLength=" + length + ", maxPkgSize=" + longValue);
                        return;
                    }
                    return;
                }
            } else {
                j3 = j16;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.F.containsKey(string)) {
                Pair<Long, Integer> pair = this.F.get(string);
                int intValue = this.G.containsKey(string) ? this.G.get(string).intValue() : 10;
                if (pair.first.longValue() != currentTimeMillis) {
                    this.F.put(string, new Pair<>(Long.valueOf(currentTimeMillis), 0));
                } else if (pair.second.intValue() + 1 <= intValue) {
                    this.F.put(string, new Pair<>(Long.valueOf(currentTimeMillis), Integer.valueOf(pair.second.intValue() + 1)));
                } else {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 102);
                    jSONObject5.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                    jSONObject5.put("msg", HardCodeUtil.qqStr(R.string.tox));
                    super.callJs(string2, jSONObject5.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d("SSOWebviewPlugin", 2, "uniAgent, req aborted, reason: requests too frequently, cmd: " + string + ", freq: " + intValue);
                        return;
                    }
                    return;
                }
            } else {
                this.F.put(string, new Pair<>(Long.valueOf(currentTimeMillis), 0));
            }
            if (jSONObject.has("needCookie")) {
                int i3 = jSONObject.getInt("needCookie");
                if (QLog.isColorLevel()) {
                    QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, needCookie=" + i3);
                }
                if (i3 == 1 && (e16 = this.mRuntime.e()) != null) {
                    String url = e16.getUrl();
                    if (!TextUtils.isEmpty(url)) {
                        if (this.f97428m == null) {
                            CookieManager cookieManager = CookieManager.getInstance();
                            this.f97428m = cookieManager;
                            cookieManager.setAcceptCookie(true);
                        }
                        String cookie = this.f97428m.getCookie(url);
                        if (!TextUtils.isEmpty(cookie)) {
                            if (cookie.indexOf(44) != -1) {
                                cookie.replace(',', ';');
                            }
                            jSONObject.put("Cookie", cookie);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SSOWebviewPlugin", 2, "Get cookie:" + com.tencent.biz.common.util.k.e(cookie, new String[0]) + " from " + com.tencent.biz.common.util.k.f(url, new String[0]));
                        }
                    }
                }
            }
            if (r(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SSOWebviewPlugin", 2, "apollo_client_ApolloWebDataHandler uniAgent, req, cmd=" + string + " doInterceptApolloCmd:true");
                    return;
                }
                return;
            }
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            v(jSONObject);
            jSONObject.put("option", t());
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
            NewIntent newIntent = new NewIntent(this.mRuntime.a().getApplicationContext(), am.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, string);
            newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtra("extra_callbackid", string2);
            newIntent.putExtra("extra_timeout", j3);
            if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, cmd=" + string + ", reqData=" + jSONObject.toString());
            }
            newIntent.setObserver(new b(System.currentTimeMillis(), string));
            if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, req, send request to msf");
            }
            this.mRuntime.b().startServlet(newIntent);
        } catch (NullPointerException | JSONException unused) {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return com.tencent.mobileqq.msf.core.x.q.f250387s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!com.tencent.mobileqq.msf.core.x.q.f250387s.equals(str2)) {
            return false;
        }
        boolean z16 = true;
        if ("sendRequest".equals(str3)) {
            if (strArr.length > 0) {
                y(strArr[0], this.mRuntime.e().getUrl());
                return true;
            }
        } else if ("uniAgent".equals(str3)) {
            if (strArr.length > 0) {
                am.f238847d = System.currentTimeMillis();
                x(strArr[0], str);
                return true;
            }
        } else if ("PublicFollow".equals(str3) && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                if (jSONObject.optInt("follow") != 1) {
                    z16 = false;
                }
                String optString = jSONObject.optString("uin");
                String string = jSONObject.getString("callback");
                if (QLog.isColorLevel()) {
                    QLog.d("SSOWebviewPlugin", 2, "sso.PublicFollow isFollow: " + z16 + "  uin: " + optString);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("isFollow", z16);
                bundle.putString("uin", optString);
                bundle.putString("callback", string);
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_certified_account_web_plugin_follow", null, this.H.key, bundle));
            } catch (Throwable th5) {
                QLog.e("SSOWebviewPlugin", 2, "sso.PublicFollow failed! " + QLog.getStackTraceString(th5));
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f97423d = this.mRuntime.a();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        NewIntent newIntent = this.f97424e;
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
        this.f97428m = null;
        HashMap<String, Long> hashMap = this.C;
        if (hashMap != null) {
            hashMap.clear();
            this.C = null;
        }
        HashMap<String, Long> hashMap2 = this.D;
        if (hashMap2 != null) {
            hashMap2.clear();
            this.D = null;
        }
        HashMap<String, Long> hashMap3 = this.E;
        if (hashMap3 != null) {
            hashMap3.clear();
            this.E = null;
        }
        HashMap<String, Pair<Long, Integer>> hashMap4 = this.F;
        if (hashMap4 != null) {
            hashMap4.clear();
        }
        HashMap<String, Integer> hashMap5 = this.G;
        if (hashMap5 != null) {
            hashMap5.clear();
        }
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.H);
    }

    protected void y(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String host = Uri.parse(str2).getHost();
                String[] split = host.split("\\.");
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("data");
                String string2 = jSONObject.getString("cmd");
                boolean optBoolean = jSONObject.optBoolean("isNT");
                int optInt = jSONObject.optInt("domainId", 0);
                String string3 = jSONObject.getString("callback");
                if (this.f97425f != 0) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f97425f;
                    if (currentTimeMillis >= 0 && currentTimeMillis < this.f97426h * 1000) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("cret", 1);
                        jSONObject2.put("cret_msg", "\u8bf7\u6c42\u9650\u9891");
                        callJs(string3, jSONObject2.toString());
                        QLog.d("SSOWebviewPlugin", 1, "limit frequency duration: ", Long.valueOf(currentTimeMillis), " minDuration:", Integer.valueOf(this.f97426h), " preTime:", Long.valueOf(this.f97425f));
                        return;
                    }
                    str3 = string3;
                    if (string.getBytes().length > this.f97427i) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("cret", 2);
                        jSONObject3.put("cret_msg", "\u6570\u636e\u8d85\u957f");
                        callJs(str3, jSONObject3.toString());
                        return;
                    }
                } else {
                    str3 = string3;
                    this.f97425f = System.currentTimeMillis();
                }
                String str4 = "";
                for (int length = split.length - 1; length >= 0; length--) {
                    str4 = str4 + split[length];
                    if (length != 0) {
                        str4 = str4 + "_";
                    }
                }
                new RequestTask(host, optInt, "MQUpdateSvc_" + str4 + ".web." + string2, optBoolean, string, str3, this).run();
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("SSOWebviewPlugin", 2, "send request error!");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    class a extends com.tencent.mobileqq.emosm.t {
        a() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            if (bundle != null && bundle.getInt("respkey", 0) == SSOWebviewPlugin.this.H.key) {
                int i3 = bundle.getInt("failcode");
                Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
                if (i3 != 1000) {
                    QLog.e("SSOWebviewPlugin", 2, "IPC failed ! failcode: " + i3 + "  reqParams: " + bundle2);
                    return;
                }
                String string = bundle.getString("cmd");
                Bundle bundle3 = bundle.getBundle("response");
                if ("ipc_cmd_certified_account_web_plugin_follow".equals(string) && bundle2 != null && bundle3 != null) {
                    String string2 = bundle2.getString("callback");
                    int i16 = bundle3.getInt("retCode");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("retCode", i16);
                        SSOWebviewPlugin.this.callJs(string2, jSONObject.toString());
                        if (QLog.isColorLevel()) {
                            QLog.d("SSOWebviewPlugin", 2, "IPC_CMD_CERTIFIED_ACCOUNT_WEB_PLUGIN_FOLLOW return! retCode: " + i16);
                        }
                    } catch (Throwable th5) {
                        QLog.e("SSOWebviewPlugin", 2, "sso.PublicFollow failed! " + QLog.getStackTraceString(th5));
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
        }
    }
}
