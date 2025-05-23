package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile i f209386d;

    public i(String str) {
        super(str);
    }

    public static i b() {
        if (f209386d == null) {
            synchronized (com.tencent.mobileqq.app.as.class) {
                if (f209386d == null) {
                    f209386d = new i("FileDownIPCModule");
                }
            }
        }
        return f209386d;
    }

    private EIPCResult c(QQAppInterface qQAppInterface, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        FileManagerEngine.c cVar = new FileManagerEngine.c();
        cVar.f206929d = bundle.getString(WadlProxyConsts.PARAM_FILENAME);
        cVar.f206926a = bundle.getString("fileUrl");
        cVar.f206928c = bundle.getString("fileUid");
        cVar.f206927b = bundle.getLong("fileSize");
        FileManagerEngine fileManagerEngine = qQAppInterface.getFileManagerEngine();
        fileManagerEngine.c(fileManagerEngine.b(cVar), qQAppInterface.getApp());
        return null;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        if (!"ACTION_DOWNLOAD_FILE".equals(str)) {
            return null;
        }
        return c(qQAppInterface, bundle);
    }
}
