package com.tencent.mobileqq.weiyun.api;

import android.app.Application;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.weiyun.model.a;
import com.tencent.weiyun.transmission.upload.UploadFile;
import y43.b;
import y43.c;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeiyunUploadDownloadService extends QRouteApi {
    public static final String MODULE_NAME = "Module_WeiyunDownloadService";

    a createDownloadFile(String str, String str2, String str3, long j3, int i3, String str4, String str5);

    UploadFile createUploadFile(String str, UploadFile.UploadBatch uploadBatch, int i3);

    UploadFile createUploadFile4Backup(String str, UploadFile.UploadBatch uploadBatch, int i3);

    String download(a aVar, String str, boolean z16, c cVar);

    void downloadImage(String str, String str2, String str3, b bVar);

    String downloadShare(String str, String str2, String str3, String str4, c cVar);

    QIPCModule getIPCModule();

    String getWeiyunMiniappProcessName();

    void initTransmission(Application application, boolean z16);

    void onLoginOrLogout(boolean z16, long j3);

    boolean removeJob(String str);
}
