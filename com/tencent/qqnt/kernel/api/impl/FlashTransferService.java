package com.tencent.qqnt.kernel.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.File;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSendMsgReq;
import com.tencent.qqnt.kernel.nativeinterface.GetFileSetReq;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferResumePausedTasksAfterDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferSendMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceFileTransferCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetIdByCodeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLocalFileListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetShareLinkCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceUpdateFlashTransferCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ResumePausedTasksAfterDeviceStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.UpdateFlashTransferParam;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001IB\u0019\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010E\u001a\u00020D\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0010H\u0016J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u0012H\u0016J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u001a\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001cH\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020!H\u0016J\"\u0010&\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\b\u0010\u001a\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010)\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010(H\u0016J2\u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\u0010\u001a\u001a\u0004\u0018\u00010,H\u0016J4\u00102\u001a\u00020\u00062\u0006\u0010*\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\b\u0010\u001a\u001a\u0004\u0018\u000101H\u0016J\u0012\u00104\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u000103H\u0016J\u001c\u00107\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u0001052\b\u0010\u001a\u001a\u0004\u0018\u000106H\u0016J&\u0010:\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u00010\b2\b\u00109\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010%H\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J$\u0010?\u001a\u00020\u00062\u0006\u0010*\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u001a\u001a\u0004\u0018\u00010>H\u0016J\u001c\u0010B\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010@2\b\u0010\u001a\u001a\u0004\u0018\u00010AH\u0016\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/FlashTransferService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelFlashTransferService;", "Lcom/tencent/qqnt/kernel/api/q;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "listener", "", "addFileSetDownloadListener", "", "fileSetId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "files", "K", "H", WadlProxyConsts.SCENE_ID, "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetStatusListener;", "addFileSetSimpleStatusListener", "Lkotlin/collections/ArrayList;", "fileSetIds", "addFileSetSimpleStatusMonitoring", "removeFileSetSimpleStatusMonitoring", "removeFileSetSimpleStatusListener", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferSendMsgReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferSendMsgCallback;", "callback", "sendFlashTransferMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetShareLinkCallback;", "getShareLinkReq", "code", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetIdByCodeCallback;", "getFileSetIdByCode", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferTaskInfoListener;", "addFlashTransferTaskInfoListener", "", "currentStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "doAIOFlashTransferBubbleActionWithStatus", "file", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceFileTransferCallback;", "startFileTransferUrl", "seq", "fileIds", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetLocalFileListCallback;", "getLocalFileList", "", "isUseCache", "isNoReqSvr", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetCallback;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDeviceStatusListener;", "addDeviceStatusListener", "Lcom/tencent/qqnt/kernel/nativeinterface/ResumePausedTasksAfterDeviceStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferResumePausedTasksAfterDeviceStatusCallback;", "resumePausedTasksAfterDeviceStatus", "documentDir", "cacheDir", "p4", "resumeAllUnfinishedTasks", "Lcom/tencent/qqnt/kernel/nativeinterface/UpdateFlashTransferParam;", "updateParam", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceUpdateFlashTransferCallback;", "updateFlashTransfer", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCheckDeviceStatusCallback;", "checkDeviceStatus", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelFlashTransferService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class FlashTransferService extends BaseService<IKernelFlashTransferService, IKernelFlashTransferService> implements com.tencent.qqnt.kernel.api.q {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/FlashTransferService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.FlashTransferService$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashTransferService(@Nullable IKernelFlashTransferService iKernelFlashTransferService, @NotNull py content) {
        super("FlashTransferService", content, iKernelFlashTransferService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelFlashTransferService, (Object) content);
            return;
        }
        String h16 = com.tencent.qqnt.util.file.a.h();
        String g16 = com.tencent.qqnt.util.file.a.g();
        QLog.i("FlashTransferService", 1, "initFlashTransferService. setFlashTransferDir. saveDir: " + h16 + ", cacheDir: " + g16 + ".");
        p4(h16, g16, null);
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void H(@NotNull final String fileSetId, @NotNull final ArrayList<File> files) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) fileSetId, (Object) files);
            return;
        }
        Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
        Intrinsics.checkNotNullParameter(files, "files");
        check("stopFileListDownLoad", new Function0<Unit>(fileSetId, files) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$stopFileListDownLoad$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $fileSetId;
            final /* synthetic */ ArrayList<File> $files;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$fileSetId = fileSetId;
                this.$files = files;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, fileSetId, files);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFlashTransferService service = FlashTransferService.this.getService();
                if (service == null) {
                    return null;
                }
                service.stopFileListDownLoad(this.$fileSetId, this.$files, null);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void K(@NotNull final String fileSetId, @NotNull final ArrayList<File> files) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) fileSetId, (Object) files);
            return;
        }
        Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
        Intrinsics.checkNotNullParameter(files, "files");
        check("startFileListDownLoad", new Function0<Unit>(fileSetId, files) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$startFileListDownLoad$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $fileSetId;
            final /* synthetic */ ArrayList<File> $files;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$fileSetId = fileSetId;
                this.$files = files;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, fileSetId, files);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFlashTransferService service = FlashTransferService.this.getService();
                if (service == null) {
                    return null;
                }
                service.startFileListDownLoad(this.$fileSetId, this.$files, null);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void addDeviceStatusListener(@Nullable final IFlashTransferServiceDeviceStatusListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) listener);
        } else {
            check("addDeviceStatusListener", new Function0<Unit>(listener) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$addDeviceStatusListener$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferServiceDeviceStatusListener $listener;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$listener = listener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashTransferService.this, (Object) listener);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addDeviceStatusListener(this.$listener);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void addFileSetDownloadListener(@NotNull final IFlashTransferServiceDownloadListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            check("addFileSetDownloadListener", new Function0<Unit>(listener) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$addFileSetDownloadListener$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferServiceDownloadListener $listener;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$listener = listener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashTransferService.this, (Object) listener);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addFileSetDownloadListener(this.$listener);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void addFileSetSimpleStatusListener(@NotNull final String sceneId, @NotNull final IFlashTransferFileSetStatusListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) sceneId, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        check("addFileSetSimpleStatusListener", new Function0<Unit>(sceneId, listener) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$addFileSetSimpleStatusListener$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IFlashTransferFileSetStatusListener $listener;
            final /* synthetic */ String $sceneId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$sceneId = sceneId;
                this.$listener = listener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, sceneId, listener);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFlashTransferService service = FlashTransferService.this.getService();
                if (service == null) {
                    return null;
                }
                service.addFileSetSimpleStatusListener(this.$sceneId, this.$listener);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void addFileSetSimpleStatusMonitoring(@NotNull final String sceneId, @NotNull final ArrayList<String> fileSetIds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) sceneId, (Object) fileSetIds);
            return;
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(fileSetIds, "fileSetIds");
        check("addFileSetSimpleStatusMonitoring", new Function0<Unit>(sceneId, fileSetIds) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$addFileSetSimpleStatusMonitoring$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $fileSetIds;
            final /* synthetic */ String $sceneId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$sceneId = sceneId;
                this.$fileSetIds = fileSetIds;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, sceneId, fileSetIds);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFlashTransferService service = FlashTransferService.this.getService();
                if (service == null) {
                    return null;
                }
                service.addFileSetSimpleStatusMonitoring(this.$sceneId, this.$fileSetIds);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void addFlashTransferTaskInfoListener(@NotNull final IFlashTransferTaskInfoListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            check("addFlashTransferTaskInfoListener", new Function0<Unit>(listener) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$addFlashTransferTaskInfoListener$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferTaskInfoListener $listener;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$listener = listener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashTransferService.this, (Object) listener);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addFlashTransferTaskInfoListener(this.$listener);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void checkDeviceStatus(@Nullable final CheckDeviceStatusReq req, @Nullable final IFlashTransferCheckDeviceStatusCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) req, (Object) callback);
        } else {
            check("checkDeviceStatus", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$checkDeviceStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferCheckDeviceStatusCallback $callback;
                final /* synthetic */ CheckDeviceStatusReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.checkDeviceStatus(this.$req, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void doAIOFlashTransferBubbleActionWithStatus(@NotNull final String fileSetId, final int currentStatus, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, fileSetId, Integer.valueOf(currentStatus), callback);
        } else {
            Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
            check("doAIOFlashTransferBubbleActionWithStatus", new Function0<Unit>(fileSetId, currentStatus, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$doAIOFlashTransferBubbleActionWithStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ int $currentStatus;
                final /* synthetic */ String $fileSetId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$fileSetId = fileSetId;
                    this.$currentStatus = currentStatus;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, fileSetId, Integer.valueOf(currentStatus), callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.doAIOFlashTransferBubbleActionWithStatus(this.$fileSetId, this.$currentStatus, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void f(final int seq, @Nullable final String fileSetId, final boolean isUseCache, final boolean isNoReqSvr, @Nullable final IFlashTransferServiceGetFileSetCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(seq), fileSetId, Boolean.valueOf(isUseCache), Boolean.valueOf(isNoReqSvr), callback);
        } else {
            check("getFileSet", new Function0<Unit>(seq, fileSetId, isUseCache, isNoReqSvr, this, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$getFileSet$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferServiceGetFileSetCallback $callback;
                final /* synthetic */ String $fileSetId;
                final /* synthetic */ boolean $isNoReqSvr;
                final /* synthetic */ boolean $isUseCache;
                final /* synthetic */ int $seq;
                final /* synthetic */ FlashTransferService this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$seq = seq;
                    this.$fileSetId = fileSetId;
                    this.$isUseCache = isUseCache;
                    this.$isNoReqSvr = isNoReqSvr;
                    this.this$0 = this;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(seq), fileSetId, Boolean.valueOf(isUseCache), Boolean.valueOf(isNoReqSvr), this, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    GetFileSetReq getFileSetReq = new GetFileSetReq();
                    getFileSetReq.seq = this.$seq;
                    getFileSetReq.fileSetId = this.$fileSetId;
                    getFileSetReq.isUseCache = this.$isUseCache;
                    getFileSetReq.isNoReqSvr = this.$isNoReqSvr;
                    IKernelFlashTransferService service = this.this$0.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getFileSet(getFileSetReq, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void getFileSetIdByCode(@NotNull final String code, @NotNull final IFlashTransferServiceGetFileSetIdByCodeCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) code, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        check("getFileSetIdByCode", new Function0<Unit>(code, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$getFileSetIdByCode$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IFlashTransferServiceGetFileSetIdByCodeCallback $callback;
            final /* synthetic */ String $code;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$code = code;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, code, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFlashTransferService service = FlashTransferService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getFileSetIdByCode(this.$code, this.$callback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void getLocalFileList(final int seq, @Nullable final String fileSetId, @NotNull final ArrayList<String> fileIds, @Nullable final IFlashTransferServiceGetLocalFileListCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(seq), fileSetId, fileIds, callback);
        } else {
            Intrinsics.checkNotNullParameter(fileIds, "fileIds");
            check("getLocalFileList", new Function0<Unit>(seq, fileSetId, fileIds, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$getLocalFileList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferServiceGetLocalFileListCallback $callback;
                final /* synthetic */ ArrayList<String> $fileIds;
                final /* synthetic */ String $fileSetId;
                final /* synthetic */ int $seq;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$seq = seq;
                    this.$fileSetId = fileSetId;
                    this.$fileIds = fileIds;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, Integer.valueOf(seq), fileSetId, fileIds, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getLocalFileList(this.$seq, this.$fileSetId, this.$fileIds, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void getShareLinkReq(@NotNull final String fileSetId, @NotNull final IFlashTransferServiceGetShareLinkCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) fileSetId, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        check("getShareLinkReq", new Function0<Unit>(fileSetId, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$getShareLinkReq$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IFlashTransferServiceGetShareLinkCallback $callback;
            final /* synthetic */ String $fileSetId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$fileSetId = fileSetId;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, fileSetId, callback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFlashTransferService service = FlashTransferService.this.getService();
                if (service == null) {
                    return null;
                }
                service.getShareLinkReq(this.$fileSetId, this.$callback);
                return Unit.INSTANCE;
            }
        });
    }

    public void p4(@Nullable final String documentDir, @Nullable final String cacheDir, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, documentDir, cacheDir, callback);
        } else {
            check("setFlashTransferDir", new Function0<Unit>(documentDir, cacheDir, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$setFlashTransferDir$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $cacheDir;
                final /* synthetic */ IOperateCallback $callback;
                final /* synthetic */ String $documentDir;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$documentDir = documentDir;
                    this.$cacheDir = cacheDir;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, documentDir, cacheDir, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setFlashTransferDir(this.$documentDir, this.$cacheDir, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void removeFileSetSimpleStatusListener(@NotNull final String sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) sceneId);
        } else {
            Intrinsics.checkNotNullParameter(sceneId, "sceneId");
            check("removeFileSetSimpleStatusListener", new Function0<Unit>(sceneId) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$removeFileSetSimpleStatusListener$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $sceneId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$sceneId = sceneId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashTransferService.this, (Object) sceneId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.removeFileSetSimpleStatusListener(this.$sceneId);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void removeFileSetSimpleStatusMonitoring(@NotNull final String sceneId, @NotNull final ArrayList<String> fileSetIds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) sceneId, (Object) fileSetIds);
            return;
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(fileSetIds, "fileSetIds");
        check("removeFileSetSimpleStatusMonitoring", new Function0<Unit>(sceneId, fileSetIds) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$removeFileSetSimpleStatusMonitoring$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<String> $fileSetIds;
            final /* synthetic */ String $sceneId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$sceneId = sceneId;
                this.$fileSetIds = fileSetIds;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, sceneId, fileSetIds);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Unit invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                IKernelFlashTransferService service = FlashTransferService.this.getService();
                if (service == null) {
                    return null;
                }
                service.removeFileSetSimpleStatusMonitoring(this.$sceneId, this.$fileSetIds);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void resumeAllUnfinishedTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            check("resumeAllUnfinishedTasks", new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$resumeAllUnfinishedTasks$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashTransferService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.resumeAllUnfinishedTasks();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void resumePausedTasksAfterDeviceStatus(@Nullable final ResumePausedTasksAfterDeviceStatusReq req, @Nullable final IFlashTransferResumePausedTasksAfterDeviceStatusCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) req, (Object) callback);
        } else {
            check("resumePausedTasksAfterDeviceStatus", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$resumePausedTasksAfterDeviceStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferResumePausedTasksAfterDeviceStatusCallback $callback;
                final /* synthetic */ ResumePausedTasksAfterDeviceStatusReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.resumePausedTasksAfterDeviceStatus(this.$req, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void sendFlashTransferMsg(@NotNull final FlashTransferSendMsgReq req, @Nullable final IFlashTransferSendMsgCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) req, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("sendFlashTransferMsg", new Function0<Unit>(req, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$sendFlashTransferMsg$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferSendMsgCallback $callback;
                final /* synthetic */ FlashTransferSendMsgReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, req, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.sendFlashTransferMsg(this.$req, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void startFileTransferUrl(@Nullable final File file, @Nullable final IFlashTransferServiceFileTransferCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) file, (Object) callback);
        } else {
            check("startFileTransferUrl", new Function0<Unit>(file, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$startFileTransferUrl$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferServiceFileTransferCallback $callback;
                final /* synthetic */ File $file;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$file = file;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, file, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.startFileTransferUrl(this.$file, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.q
    public void updateFlashTransfer(final int seq, @Nullable final UpdateFlashTransferParam updateParam, @Nullable final IFlashTransferServiceUpdateFlashTransferCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Integer.valueOf(seq), updateParam, callback);
        } else {
            check("updateFlashTransfer", new Function0<Unit>(seq, updateParam, callback) { // from class: com.tencent.qqnt.kernel.api.impl.FlashTransferService$updateFlashTransfer$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IFlashTransferServiceUpdateFlashTransferCallback $callback;
                final /* synthetic */ int $seq;
                final /* synthetic */ UpdateFlashTransferParam $updateParam;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$seq = seq;
                    this.$updateParam = updateParam;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FlashTransferService.this, Integer.valueOf(seq), updateParam, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelFlashTransferService service = FlashTransferService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.updateFlashTransfer(this.$seq, this.$updateParam, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
