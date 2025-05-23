package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadReq;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0014B\u0019\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/BdhUploadService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBdhUploadService;", "Lcom/tencent/qqnt/kernel/api/l;", "Lcom/tencent/qqnt/kernel/nativeinterface/BdhUploadReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBdhUploadCompleteCallback;", "cb", "", "uploadFile", "(Lcom/tencent/qqnt/kernel/nativeinterface/BdhUploadReq;Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBdhUploadCompleteCallback;)Ljava/lang/Long;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "cancelUpload", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBdhUploadService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class BdhUploadService extends BaseService<IKernelBdhUploadService, IKernelBdhUploadService> implements com.tencent.qqnt.kernel.api.l {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/BdhUploadService$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.BdhUploadService$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44298);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdhUploadService(@Nullable IKernelBdhUploadService iKernelBdhUploadService, @NotNull py content) {
        super("BdhUploadService", content, iKernelBdhUploadService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelBdhUploadService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.l
    public void cancelUpload(final long taskId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, taskId);
        } else {
            check("cancelUpload", new Function0<Unit>(taskId) { // from class: com.tencent.qqnt.kernel.api.impl.BdhUploadService$cancelUpload$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $taskId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$taskId = taskId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BdhUploadService.this, Long.valueOf(taskId));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelBdhUploadService service = BdhUploadService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.cancelUpload(this.$taskId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.l
    @Nullable
    public Long uploadFile(@NotNull final BdhUploadReq req, @Nullable IKernelBdhUploadCompleteCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) req, (Object) cb5);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        return (Long) check("uploadFile", cb5, new Function1<IKernelBdhUploadCompleteCallback, Long>(req) { // from class: com.tencent.qqnt.kernel.api.impl.BdhUploadService$uploadFile$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ BdhUploadReq $req;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$req = req;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BdhUploadService.this, (Object) req);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Long invoke(@Nullable IKernelBdhUploadCompleteCallback iKernelBdhUploadCompleteCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iKernelBdhUploadCompleteCallback);
                }
                IKernelBdhUploadService service = BdhUploadService.this.getService();
                if (service != null) {
                    return Long.valueOf(service.uploadFile(this.$req, iKernelBdhUploadCompleteCallback));
                }
                return null;
            }
        });
    }
}
