package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.weiyun.TransmissionHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.open.base.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadFile;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import y43.b;
import y43.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeiyunUploadDownloadServiceImpl implements IWeiyunUploadDownloadService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WeiyunDownloadServiceIPC";
    private static String WEIYUN_MINIAPP_PROCESS_NAME;
    private ConcurrentHashMap<String, Long> mDownloadTaskMap;
    private QIPCModule module;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class a extends QIPCModule {
        static IPatchRedirector $redirector_;

        public a(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeiyunUploadDownloadServiceImpl.this, (Object) str);
            }
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
            }
            f.a(WeiyunUploadDownloadServiceImpl.TAG, "onCall action|" + str + " params|" + bundle + " callbackId|" + i3);
            if (bundle == null) {
                string = null;
            } else {
                string = bundle.getString("process");
            }
            if (!TextUtils.isEmpty(string)) {
                String unused = WeiyunUploadDownloadServiceImpl.WEIYUN_MINIAPP_PROCESS_NAME = string;
            }
            if (!TextUtils.isEmpty(str)) {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                if (waitAppRuntime == null) {
                    f.a(WeiyunUploadDownloadServiceImpl.TAG, "onCall action but appInterface is null");
                    return null;
                }
                if (("WeiyunDownloadServiceIPC_Action__Download".equals(str) || "WeiyunDownloadServiceIPC_Action__Resume".equals(str)) && bundle != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(WeiyunUploadDownloadServiceImpl.TAG, 2, "AIDL : start weiyunDownload");
                    }
                    String str2 = (String) bundle.get("file_id");
                    if (TextUtils.isEmpty(str2)) {
                        f.a(WeiyunUploadDownloadServiceImpl.TAG, "onCall action but file_id is null");
                        return null;
                    }
                    FileManagerEntity queryByFileIdForMemory = ((IQQFileDataCenter) waitAppRuntime.getRuntimeService(IQQFileDataCenter.class, "")).queryByFileIdForMemory(str2);
                    if (queryByFileIdForMemory == null) {
                        if ("WeiyunDownloadServiceIPC_Action__Resume".equals(str)) {
                            return null;
                        }
                        queryByFileIdForMemory = ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).newEntityByWeiYunMiniAppParams(bundle);
                        ((IQQFileEngine) waitAppRuntime.getRuntimeService(IQQFileEngine.class, "")).reciveFile(queryByFileIdForMemory);
                    }
                    String str3 = (String) bundle.get("downloadId");
                    queryByFileIdForMemory.nOpType = 50;
                    queryByFileIdForMemory.cloudType = 2;
                    queryByFileIdForMemory.miniAppDownloadId = str3;
                    WeiyunUploadDownloadServiceImpl.this.mDownloadTaskMap.put(str3, Long.valueOf(queryByFileIdForMemory.nSessionId));
                    if (FileUtils.fileExists(queryByFileIdForMemory.getFilePath())) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(MiniAppGetGameTaskTicketServlet.KEY_TASKID, queryByFileIdForMemory.miniAppDownloadId);
                        bundle2.putString("filePath", queryByFileIdForMemory.getFilePath());
                        QIPCServerHelper.getInstance().callClient(WeiyunUploadDownloadServiceImpl.WEIYUN_MINIAPP_PROCESS_NAME, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", bundle2, null);
                        Bundle bundle3 = new Bundle();
                        bundle3.putString(MiniAppGetGameTaskTicketServlet.KEY_TASKID, queryByFileIdForMemory.miniAppDownloadId);
                        bundle3.putInt("retCode", 1);
                        bundle3.putString("retMsg", "");
                        QIPCServerHelper.getInstance().callClient(WeiyunUploadDownloadServiceImpl.WEIYUN_MINIAPP_PROCESS_NAME, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Complete", bundle3, null);
                    } else {
                        ((IQQFileDataCenter) waitAppRuntime.getRuntimeService(IQQFileDataCenter.class, "")).insertToMemMap(queryByFileIdForMemory);
                        ((IQQFileEngine) waitAppRuntime.getRuntimeService(IQQFileEngine.class, "")).resume(queryByFileIdForMemory.nSessionId);
                    }
                } else if (("WeiyunDownloadServiceIPC_Action__Cancel".equals(str) || "WeiyunDownloadServiceIPC_Action__Pause".equals(str)) && bundle != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(WeiyunUploadDownloadServiceImpl.TAG, 2, "AIDL : end weiyunDownload");
                    }
                    ((IQQFileEngine) waitAppRuntime.getRuntimeService(IQQFileEngine.class, "all")).pause(((Long) WeiyunUploadDownloadServiceImpl.this.mDownloadTaskMap.get(bundle.getString("downloadId"))).longValue());
                }
            }
            return null;
        }
    }

    public WeiyunUploadDownloadServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDownloadTaskMap = new ConcurrentHashMap<>();
            this.module = new a(IWeiyunUploadDownloadService.MODULE_NAME);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public com.tencent.mobileqq.weiyun.model.a createDownloadFile(String str, String str2, String str3, long j3, int i3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.weiyun.model.a) iPatchRedirector.redirect((short) 6, this, str, str2, str3, Long.valueOf(j3), Integer.valueOf(i3), str4, str5);
        }
        return TransmissionHelper.a(str, str2, str3, j3, i3, str4, str5);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public UploadFile createUploadFile(String str, UploadFile.UploadBatch uploadBatch, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (UploadFile) iPatchRedirector.redirect((short) 10, this, str, uploadBatch, Integer.valueOf(i3));
        }
        return TransmissionHelper.b(str, uploadBatch, i3);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public UploadFile createUploadFile4Backup(String str, UploadFile.UploadBatch uploadBatch, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (UploadFile) iPatchRedirector.redirect((short) 11, this, str, uploadBatch, Integer.valueOf(i3));
        }
        return TransmissionHelper.c(str, uploadBatch, i3);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public String download(com.tencent.mobileqq.weiyun.model.a aVar, String str, boolean z16, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, aVar, str, Boolean.valueOf(z16), cVar);
        }
        return com.tencent.mobileqq.weiyun.sdk.download.c.u().o(aVar, str, z16, cVar);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public void downloadImage(String str, String str2, String str3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, bVar);
        } else {
            com.tencent.mobileqq.weiyun.sdk.download.c.u().q(str, str2, str3, bVar);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public String downloadShare(String str, String str2, String str3, String str4, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4, cVar);
        }
        return com.tencent.mobileqq.weiyun.sdk.download.c.u().s(str, str2, str3, str4, cVar);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public QIPCModule getIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.module;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public String getWeiyunMiniappProcessName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return WEIYUN_MINIAPP_PROCESS_NAME;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public void initTransmission(Application application, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, application, Boolean.valueOf(z16));
        } else {
            TransmissionHelper.e(application, z16);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public void onLoginOrLogout(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3));
        } else {
            TransmissionHelper.f(z16, j3);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService
    public boolean removeJob(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).booleanValue();
        }
        return com.tencent.mobileqq.weiyun.sdk.download.c.u().D(str);
    }
}
