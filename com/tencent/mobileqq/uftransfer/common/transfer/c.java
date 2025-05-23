package com.tencent.mobileqq.uftransfer.common.transfer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnFileUploader;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static a a(AppRuntime appRuntime, d dVar) {
        return com.tencent.mobileqq.uftransfer.common.transfer.upload.c.x(appRuntime, dVar);
    }

    public static a b(AppRuntime appRuntime, h hVar) {
        return UFTFtnFileUploader.D(appRuntime, hVar);
    }

    public static a c(AppRuntime appRuntime, i iVar) {
        return UFTFtnFileUploader.E(appRuntime, iVar);
    }
}
