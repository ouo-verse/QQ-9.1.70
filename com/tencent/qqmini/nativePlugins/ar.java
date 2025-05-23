package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.out.nativePlugins.WeiyunNativeBusiness;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ar {

    /* renamed from: b, reason: collision with root package name */
    public static String f347012b;

    /* renamed from: a, reason: collision with root package name */
    private a f347013a;

    public ar(IMiniAppContext iMiniAppContext) {
        f347012b = BaseApplicationImpl.getApplication().getQQProcessName();
        a b16 = a.b();
        this.f347013a = b16;
        if (b16 != null) {
            b16.c(iMiniAppContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, RequestEvent requestEvent) {
        this.f347013a.d(requestEvent);
        this.f347013a.unregisterModule(str);
        Bundle bundle = new Bundle();
        bundle.putString("downloadId", str);
        QIPCClientHelper.getInstance().callServer(IWeiyunUploadDownloadService.MODULE_NAME, "WeiyunDownloadServiceIPC_Action__Cancel", bundle, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(JSONObject jSONObject, String str, RequestEvent requestEvent) {
        this.f347013a.d(requestEvent);
        try {
            this.f347013a.registerModule(str);
            Bundle bundle = new Bundle();
            bundle.putString("downloadId", str);
            bundle.putString("process", f347012b);
            bundle.putString("file_id", (String) jSONObject.get("file_id"));
            bundle.putString("filename", (String) jSONObject.get("filename"));
            bundle.putString("pdir_key", (String) jSONObject.get("pdir_key"));
            QIPCClientHelper.getInstance().callServer(IWeiyunUploadDownloadService.MODULE_NAME, "WeiyunDownloadServiceIPC_Action__Download", bundle, null);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str, RequestEvent requestEvent) {
        this.f347013a.d(requestEvent);
        Bundle bundle = new Bundle();
        bundle.putString("downloadId", str);
        QIPCClientHelper.getInstance().callServer(IWeiyunUploadDownloadService.MODULE_NAME, "WeiyunDownloadServiceIPC_Action__Pause", bundle, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(jSONObject.getString("file_id")) || TextUtils.isEmpty(jSONObject.getString("filename"))) {
                return false;
            }
            return !TextUtils.isEmpty(jSONObject.getString("pdir_key"));
        } catch (JSONException unused) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class a extends QIPCModule {

        /* renamed from: d, reason: collision with root package name */
        private CopyOnWriteArraySet<String> f347014d;

        /* renamed from: e, reason: collision with root package name */
        private IMiniAppContext f347015e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<RequestEvent> f347016f;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.qqmini.nativePlugins.ar$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static class C9398a {

            /* renamed from: a, reason: collision with root package name */
            private static a f347017a = new a();
        }

        a() {
            super("Module_WeiyunDownloadClient");
            this.f347014d = new CopyOnWriteArraySet<>();
        }

        public static a b() {
            return C9398a.f347017a;
        }

        public void c(IMiniAppContext iMiniAppContext) {
            this.f347015e = iMiniAppContext;
        }

        public void d(RequestEvent requestEvent) {
            this.f347016f = new WeakReference<>(requestEvent);
        }

        public void registerModule(String str) {
            try {
                if (this.f347014d.size() == 0) {
                    QIPCClientHelper.getInstance().register(this);
                }
                this.f347014d.add(str);
            } catch (Exception e16) {
                QLog.e(WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.TAG, 1, "register ipc module error.", e16);
            }
        }

        public void unregisterModule(String str) {
            try {
                this.f347014d.remove(str);
                if (this.f347014d.size() == 0) {
                    QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                }
            } catch (Exception e16) {
                QLog.e(WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.TAG, 1, "register ipc module error.", e16);
            }
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            com.tencent.open.base.f.a(WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.TAG, "onCall action|" + str + " params|" + bundle + " callbackId|" + i3);
            if (bundle == null) {
                return null;
            }
            if (str.equals("WeiyunDownloadClientIPC_Action__Suc")) {
                try {
                    String string = bundle.getString("filePath");
                    JSONObject jSONObject = new JSONObject();
                    File file = new File(string);
                    jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, bundle.get(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                    jSONObject.put(AdMetricTag.EVENT_NAME, "onProgressUpdate");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("progress", 100);
                    jSONObject2.put("writtenBytes", file.length());
                    jSONObject2.put("totalBytes", file.length());
                    jSONObject.put("data", jSONObject2);
                    RequestEvent requestEvent = this.f347016f.get();
                    if (requestEvent != null) {
                        requestEvent.jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", jSONObject.toString(), 0);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, bundle.get(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                    jSONObject3.put(AdMetricTag.EVENT_NAME, "success");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, 200);
                    IMiniAppContext iMiniAppContext = this.f347015e;
                    if (iMiniAppContext != null) {
                        jSONObject4.put("tempFilePath", ((IMiniAppFileManager) iMiniAppContext.getManager(IMiniAppFileManager.class)).getWxFilePath(string));
                    }
                    jSONObject3.put("data", jSONObject4);
                    if (requestEvent == null) {
                        return null;
                    }
                    requestEvent.jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", jSONObject3.toString(), 0);
                    return null;
                } catch (JSONException unused) {
                    QLog.e(WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.TAG, 1, "WeiyunDownload--onDownloadSuc--onWeiyunDownLoadEvent fail---");
                    return null;
                }
            }
            if (str.equals("WeiyunDownloadClientIPC_Action__Fail")) {
                JSONObject jSONObject5 = new JSONObject();
                try {
                    String string2 = bundle.getString("errCode");
                    String string3 = bundle.getString("errMsg");
                    jSONObject5.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, bundle.get(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                    jSONObject5.put(AdMetricTag.EVENT_NAME, "fail");
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("errCode", string2);
                    jSONObject6.put("errMsg", string3);
                    jSONObject5.put("data", jSONObject6);
                    RequestEvent requestEvent2 = this.f347016f.get();
                    if (requestEvent2 == null) {
                        return null;
                    }
                    requestEvent2.jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", jSONObject5.toString(), 0);
                    return null;
                } catch (Exception unused2) {
                    QLog.e(WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.TAG, 1, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
                    return null;
                }
            }
            if (str.equals("WeiyunDownloadClientIPC_Action__Complete")) {
                JSONObject jSONObject7 = new JSONObject();
                try {
                    int i16 = bundle.getInt("retCode");
                    String string4 = bundle.getString("retMsg");
                    jSONObject7.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, bundle.get(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                    jSONObject7.put(AdMetricTag.EVENT_NAME, "complete");
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("retCode", i16);
                    jSONObject8.put("retMsg", string4);
                    jSONObject7.put("data", jSONObject8);
                    RequestEvent requestEvent3 = this.f347016f.get();
                    if (requestEvent3 != null) {
                        requestEvent3.jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", jSONObject7.toString(), 0);
                    }
                    unregisterModule(bundle.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                    return null;
                } catch (Exception unused3) {
                    QLog.e(WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.TAG, 1, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
                    return null;
                }
            }
            if (!str.equals("WeiyunDownloadClientIPC_Action__Progress")) {
                return null;
            }
            JSONObject jSONObject9 = new JSONObject();
            try {
                int i17 = bundle.getInt("progress");
                long j3 = bundle.getLong("currSize");
                long j16 = bundle.getLong("totalSize");
                jSONObject9.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, bundle.get(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                jSONObject9.put(AdMetricTag.EVENT_NAME, "onProgressUpdate");
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("progress", i17);
                jSONObject10.put("writtenBytes", j3);
                jSONObject10.put("totalBytes", j16);
                jSONObject9.put("data", jSONObject10);
                RequestEvent requestEvent4 = this.f347016f.get();
                if (requestEvent4 == null) {
                    return null;
                }
                requestEvent4.jsService.evaluateSubscribeJS("custom_event_onWeiyunDownLoadEvent", jSONObject9.toString(), 0);
                return null;
            } catch (Exception unused4) {
                QLog.e(WeiyunNativeBusiness.WeiyunDownloadBussiness.WeiyunDownloadClientQIPCModule.TAG, 1, "WeiyunDownload--onProgressUpdate--onWeiyunDownLoadEvent fail---");
                return null;
            }
        }
    }
}
