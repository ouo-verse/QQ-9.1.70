package com.tencent.mobileqq.ark.core;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.ark.util.j;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f199359a;

        /* renamed from: b, reason: collision with root package name */
        String f199360b;

        /* renamed from: c, reason: collision with root package name */
        WeakReference<BaseQQAppInterface> f199361c;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<IPreDownloadController> f199362d;

        public void a(String str, long j3) {
            IPreDownloadController iPreDownloadController;
            WeakReference<IPreDownloadController> weakReference = this.f199362d;
            if (weakReference == null || (iPreDownloadController = weakReference.get()) == null) {
                return;
            }
            iPreDownloadController.preDownloadSuccess(str, j3);
        }

        public void b(Runnable runnable) {
            BaseQQAppInterface baseQQAppInterface;
            WeakReference<IPreDownloadController> weakReference;
            WeakReference<BaseQQAppInterface> weakReference2 = this.f199361c;
            if (weakReference2 != null) {
                baseQQAppInterface = weakReference2.get();
            } else {
                baseQQAppInterface = null;
            }
            BaseQQAppInterface baseQQAppInterface2 = baseQQAppInterface;
            if (baseQQAppInterface2 != null && (weakReference = this.f199362d) != null) {
                IPreDownloadController iPreDownloadController = weakReference.get();
                if (iPreDownloadController == null) {
                    runnable.run();
                    return;
                } else {
                    iPreDownloadController.requestPreDownload(10022, PreDownloadConstants.DEPARTMENT_PRD, this.f199360b, 0, this.f199359a, "", 1, 0, false, new RunnableTask(baseQQAppInterface2, this.f199360b, runnable, 10000L));
                    return;
                }
            }
            runnable.run();
        }
    }

    public static a a(AppRuntime appRuntime, String str, String str2) {
        a aVar = new a();
        aVar.f199359a = str2;
        aVar.f199360b = str;
        if (j.a() && (appRuntime instanceof BaseQQAppInterface)) {
            IPreDownloadController iPreDownloadController = (IPreDownloadController) appRuntime.getRuntimeService(IPreDownloadController.class, "");
            if (!iPreDownloadController.isEnable()) {
                QLog.i("ArkApp.PredownloadImpl", 1, String.format("requestDownload, not use pre-download, name=%s, URL=%s.", str, str2));
            } else {
                aVar.f199361c = new WeakReference<>((BaseQQAppInterface) appRuntime);
                aVar.f199362d = new WeakReference<>(iPreDownloadController);
            }
        } else {
            QLog.i("ArkApp.PredownloadImpl", 1, "requestDownload, not in main process");
        }
        return aVar;
    }
}
