package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.api.IYellowFaceForManagerService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelYellowFaceDownloadCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelYellowFaceForManagerService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/YellowFaceForManagerServiceImpl;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/api/IYellowFaceForManagerService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelYellowFaceForManagerService;", "", "resourceConfigJson", "resourceDir", "cacheDir", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelYellowFaceDownloadCallback;", "callback", "", "download", "fullMd5", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "setHistory", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelYellowFaceForManagerService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public final class YellowFaceForManagerServiceImpl extends BaseService<IYellowFaceForManagerService, IKernelYellowFaceForManagerService> implements IYellowFaceForManagerService {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YellowFaceForManagerServiceImpl(@Nullable IKernelYellowFaceForManagerService iKernelYellowFaceForManagerService, @NotNull py content) {
        super("yellow_face", content, iKernelYellowFaceForManagerService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelYellowFaceForManagerService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IYellowFaceForManagerService
    public void download(@NotNull String resourceConfigJson, @NotNull String resourceDir, @NotNull String cacheDir, boolean force, @NotNull IKernelYellowFaceDownloadCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, resourceConfigJson, resourceDir, cacheDir, Boolean.valueOf(force), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(resourceConfigJson, "resourceConfigJson");
        Intrinsics.checkNotNullParameter(resourceDir, "resourceDir");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IKernelYellowFaceForManagerService service = getService();
        if (service != null) {
            service.download(resourceConfigJson, resourceDir, cacheDir, force, callback);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IYellowFaceForManagerService
    public void setHistory(@NotNull String fullMd5, @NotNull IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fullMd5, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(fullMd5, "fullMd5");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IKernelYellowFaceForManagerService service = getService();
        if (service != null) {
            service.setHistory(fullMd5, callback);
        }
    }
}
