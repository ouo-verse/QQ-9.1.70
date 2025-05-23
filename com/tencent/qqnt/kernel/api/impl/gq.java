package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchUploadConfig;
import com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager;
import com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManagerDelegate;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBatchUploadService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0015B\u0019\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001e\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/gq;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBatchUploadService;", "Lcom/tencent/qqnt/kernel/api/k;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchUploadConfig;", "createBatchUploadConfig", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManagerDelegate;", "delegate", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchUploadManager;", "getBatchUploadManager", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "seqCount", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBatchUploadService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "e", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class gq extends BaseService<IKernelBatchUploadService, IKernelBatchUploadService> implements com.tencent.qqnt.kernel.api.k {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger seqCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/gq$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.gq$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43820);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gq(@Nullable IKernelBatchUploadService iKernelBatchUploadService, @NotNull py content) {
        super("BatchUploadService", content, iKernelBatchUploadService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelBatchUploadService, (Object) content);
        } else {
            this.seqCount = new AtomicInteger(0);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.k
    @Nullable
    public BatchUploadConfig createBatchUploadConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BatchUploadConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        IKernelBatchUploadService service = getService();
        if (service != null) {
            return service.createBatchUploadConfig();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.k
    @Nullable
    public IBatchUploadManager getBatchUploadManager(@Nullable BatchUploadConfig config, @Nullable IBatchUploadManagerDelegate delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBatchUploadManager) iPatchRedirector.redirect((short) 3, (Object) this, (Object) config, (Object) delegate);
        }
        IKernelBatchUploadService service = getService();
        if (service != null) {
            return service.getBatchUploadManager(config, delegate);
        }
        return null;
    }
}
