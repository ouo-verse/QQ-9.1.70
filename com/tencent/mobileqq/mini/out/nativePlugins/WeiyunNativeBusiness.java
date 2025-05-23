package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.open.base.f;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WeiyunNativeBusiness {
    private static final String P_TAG = "WeiyunNativeBusiness";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class WeiyunDownloadBussiness {
        private static final String TAG = "WeiyunNativeBusiness$WeiyunDownloadBussiness";
        public static String WEIYUN_PROCESS_NAME;
        private WeiyunDownloadClientQIPCModule mClientQIPCModule;

        public WeiyunDownloadBussiness() {
            WEIYUN_PROCESS_NAME = BaseApplicationImpl.getApplication().getQQProcessName();
            this.mClientQIPCModule = WeiyunDownloadClientQIPCModule.getInstance();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void cancel(String str, JSContext jSContext) {
            this.mClientQIPCModule.setWeiyunDownloadFileJsContext(jSContext);
            this.mClientQIPCModule.unregisterModule(str);
            Bundle bundle = new Bundle();
            bundle.putString("downloadId", str);
            QIPCClientHelper.getInstance().callServer(IWeiyunUploadDownloadService.MODULE_NAME, "WeiyunDownloadServiceIPC_Action__Cancel", bundle, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void doDownloadWeiyun(JSONObject jSONObject, String str, JSContext jSContext) {
            this.mClientQIPCModule.setWeiyunDownloadFileJsContext(jSContext);
            try {
                this.mClientQIPCModule.registerModule(str);
                Bundle bundle = new Bundle();
                bundle.putString("downloadId", str);
                bundle.putString("process", WEIYUN_PROCESS_NAME);
                bundle.putString("file_id", (String) jSONObject.get("file_id"));
                bundle.putString("filename", (String) jSONObject.get("filename"));
                bundle.putString("pdir_key", (String) jSONObject.get("pdir_key"));
                QIPCClientHelper.getInstance().callServer(IWeiyunUploadDownloadService.MODULE_NAME, "WeiyunDownloadServiceIPC_Action__Download", bundle, null);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }

        protected String getFileId(JSONObject jSONObject) {
            try {
                return new JSONObject((String) jSONObject.get("param")).getString("file_id");
            } catch (JSONException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void pause(String str, JSContext jSContext) {
            this.mClientQIPCModule.setWeiyunDownloadFileJsContext(jSContext);
            Bundle bundle = new Bundle();
            bundle.putString("downloadId", str);
            QIPCClientHelper.getInstance().callServer(IWeiyunUploadDownloadService.MODULE_NAME, "WeiyunDownloadServiceIPC_Action__Pause", bundle, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean isLegal(JSONObject jSONObject) {
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
        /* loaded from: classes33.dex */
        public static class WeiyunDownloadClientQIPCModule extends QIPCModule {
            public static final String ACTION_COMPLETE = "WeiyunDownloadClientIPC_Action__Complete";
            public static final String ACTION_FAIL = "WeiyunDownloadClientIPC_Action__Fail";
            public static final String ACTION_PROGRESS = "WeiyunDownloadClientIPC_Action__Progress";
            public static final String ACTION_SUC = "WeiyunDownloadClientIPC_Action__Suc";
            public static final String MODULE_NAME = "Module_WeiyunDownloadClient";
            public static final String TAG = "WeiyunDownloadClientIPC";
            private CopyOnWriteArraySet<String> downloadIdList;
            private WeakReference<JSContext> weiyunDownloadFileJsContextWeakReference;

            /* JADX INFO: Access modifiers changed from: private */
            /* compiled from: P */
            /* loaded from: classes33.dex */
            public static class WeiyunDownloadClient {
                private static WeiyunDownloadClientQIPCModule instance = new WeiyunDownloadClientQIPCModule();

                WeiyunDownloadClient() {
                }
            }

            WeiyunDownloadClientQIPCModule() {
                super("Module_WeiyunDownloadClient");
                this.downloadIdList = new CopyOnWriteArraySet<>();
            }

            public static WeiyunDownloadClientQIPCModule getInstance() {
                return WeiyunDownloadClient.instance;
            }

            public void registerModule(String str) {
                try {
                    if (this.downloadIdList.size() == 0) {
                        QIPCClientHelper.getInstance().register(this);
                    }
                    this.downloadIdList.add(str);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "register ipc module error.", e16);
                }
            }

            public void setWeiyunDownloadFileJsContext(JSContext jSContext) {
                this.weiyunDownloadFileJsContextWeakReference = new WeakReference<>(jSContext);
            }

            public void unregisterModule(String str) {
                try {
                    this.downloadIdList.remove(str);
                    if (this.downloadIdList.size() == 0) {
                        QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "register ipc module error.", e16);
                }
            }

            public void unregisterModule() {
                try {
                    QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "register ipc module error.", e16);
                }
            }

            @Override // eipc.EIPCModule
            public EIPCResult onCall(String str, Bundle bundle, int i3) {
                f.a(TAG, "onCall action|" + str + " params|" + bundle + " callbackId|" + i3);
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
                        JSContext jSContext = this.weiyunDownloadFileJsContextWeakReference.get();
                        if (jSContext != null) {
                            jSContext.callJs("onWeiyunDownLoadEvent", jSONObject);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, bundle.get(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                        jSONObject3.put(AdMetricTag.EVENT_NAME, "success");
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, 200);
                        jSONObject4.put("tempFilePath", MiniAppFileManager.getInstance().getWxFilePath(string));
                        jSONObject3.put("data", jSONObject4);
                        if (jSContext == null) {
                            return null;
                        }
                        jSContext.callJs("onWeiyunDownLoadEvent", jSONObject3);
                        return null;
                    } catch (JSONException unused) {
                        QLog.e(TAG, 2, "WeiyunDownload--onDownloadSuc--onWeiyunDownLoadEvent fail---");
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
                        JSContext jSContext2 = this.weiyunDownloadFileJsContextWeakReference.get();
                        if (jSContext2 == null) {
                            return null;
                        }
                        jSContext2.callJs("onWeiyunDownLoadEvent", jSONObject5);
                        return null;
                    } catch (Exception unused2) {
                        QLog.e(TAG, 2, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
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
                        JSContext jSContext3 = this.weiyunDownloadFileJsContextWeakReference.get();
                        if (jSContext3 != null) {
                            jSContext3.callJs("onWeiyunDownLoadEvent", jSONObject7);
                        }
                        unregisterModule(bundle.getString(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
                        return null;
                    } catch (Exception unused3) {
                        QLog.e(TAG, 2, "WeiyunDownload--onDownloadFail--onWeiyunDownLoadEvent fail---");
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
                    JSContext jSContext4 = this.weiyunDownloadFileJsContextWeakReference.get();
                    if (jSContext4 == null) {
                        return null;
                    }
                    jSContext4.callJs("onWeiyunDownLoadEvent", jSONObject9);
                    return null;
                } catch (Exception unused4) {
                    QLog.e(TAG, 2, "WeiyunDownload--onProgressUpdate--onWeiyunDownLoadEvent fail---");
                    return null;
                }
            }
        }
    }
}
