package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetFileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetPageContentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetRootPageContentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelQueryUncompleteDownloadRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSendFileBridgeRequestCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PlatformType;
import com.tencent.qqnt.kernel.nativeinterface.ThumbConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001>B\u0019\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u001eH\u0016J.\u0010#\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\n\u001a\u0004\u0018\u00010\"H\u0016J$\u0010'\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020%2\b\u0010\n\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010)\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u001c\u0010-\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\n\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010.\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010/\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u00101\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u000100H\u0016J$\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u00103\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020%H\u0016J\b\u00106\u001a\u00020\u001bH\u0016J\b\u00107\u001a\u00020\u0015H\u0016\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/ha;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelFileBridgeClientListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelFileBridgeClientService;", "Lcom/tencent/qqnt/kernel/api/p;", "listener", "", "addKernelFileBridgeClientListener", "I0", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoPreCheckCallback;", "cb", "preCheck", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeClientState;", "getCurrentStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/PlatformType;", "getHostSystemType", "", "getDeviceName", "clientName", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSendFileBridgeRequestCallback;", "sendRequest", "", "getMaxAuthenticateWithoutPasswordValidDays", "error", "disconnect", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetRootPageContentCallback;", "getRootPageContent", "", "refresh", "fileId", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetPageContentCallback;", "getPageContent", "Lcom/tencent/qqnt/kernel/nativeinterface/ThumbConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "getThumbnail", "passwordMD5Twice", "", "autoAuthenticationDays", "authenticateWithPassword", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelQueryUncompleteDownloadRecordsCallback;", "queryUncompleteDownloadRecords", "", "context", "resumeUncompleteDownloadRecords", "clearUncompleteDownloadRecords", "getFile", "cancelGet", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetFileCallback;", "getFileLocalStoragePath", "sessionId", "keyWorld", "searchFolderForFiles", "cancelSearchFolderForFiles", "getHostIsSupportSearch", "getHostMaxSearchCount", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelFileBridgeClientService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ha extends BaseService<IKernelFileBridgeClientListener, IKernelFileBridgeClientService> implements com.tencent.qqnt.kernel.api.p {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/ha$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.ha$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46413);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha(@Nullable IKernelFileBridgeClientService iKernelFileBridgeClientService, @NotNull py content) {
        super("WifiPhotoHostService", content, iKernelFileBridgeClientService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelFileBridgeClientService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void I0(@Nullable IKernelFileBridgeClientListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.removeKernelFileBridgeClientListener(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void addKernelFileBridgeClientListener(@Nullable IKernelFileBridgeClientListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.addKernelFileBridgeClientListener(listener);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void authenticateWithPassword(@Nullable String passwordMD5Twice, long autoAuthenticationDays, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, passwordMD5Twice, Long.valueOf(autoAuthenticationDays), cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.authenticateWithPassword(passwordMD5Twice, autoAuthenticationDays, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void cancelGet(@Nullable String fileId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) fileId);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.cancelGet(fileId);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void cancelSearchFolderForFiles(long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, sessionId);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.cancelSearchFolderForFiles(sessionId);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void clearUncompleteDownloadRecords(@Nullable byte[] context, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.clearUncompleteDownloadRecords(context, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void disconnect(int error) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, error);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.disconnect(error);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    @Nullable
    public FileBridgeClientState getCurrentStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FileBridgeClientState) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            return service.getCurrentStatus();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.p
    @NotNull
    public String getDeviceName() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            str = service.getHostDeviceName();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void getFile(@Nullable String fileId, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) fileId, (Object) cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.getFile(fileId, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void getFileLocalStoragePath(@Nullable String fileId, @Nullable IKernelGetFileCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) fileId, (Object) cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.getFileLocalStoragePath(fileId, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public boolean getHostIsSupportSearch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            return service.getHostIsSupportSearch();
        }
        return false;
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public int getHostMaxSearchCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            return service.getHostMaxSearchCount();
        }
        return 500;
    }

    @Override // com.tencent.qqnt.kernel.api.p
    @Nullable
    public PlatformType getHostSystemType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PlatformType) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            return service.getHostSystemType();
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public int getMaxAuthenticateWithoutPasswordValidDays() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            return service.getMaxAuthenticateWithoutPasswordValidDays();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void getPageContent(boolean refresh, @Nullable String fileId, @Nullable IKernelGetPageContentCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(refresh), fileId, cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.getPageContent(refresh, fileId, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void getRootPageContent(@Nullable IKernelGetRootPageContentCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.getRootPageContent(cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void getThumbnail(boolean refresh, @Nullable String fileId, @Nullable ThumbConfig config, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(refresh), fileId, config, cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.getThumbnail(refresh, fileId, config, cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void preCheck(@Nullable IKernelWiFiPhotoPreCheckCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.preCheck(cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void queryUncompleteDownloadRecords(@Nullable IKernelQueryUncompleteDownloadRecordsCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) cb5);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.queryUncompleteDownloadRecords(cb5);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void resumeUncompleteDownloadRecords(@Nullable byte[] context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) context);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.resumeUncompleteDownloadRecords(context);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void searchFolderForFiles(long sessionId, @Nullable String fileId, @Nullable String keyWorld) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Long.valueOf(sessionId), fileId, keyWorld);
            return;
        }
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.searchFolderForFiles(sessionId, fileId, keyWorld);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.p
    public void sendRequest(@NotNull String clientName, @Nullable IKernelSendFileBridgeRequestCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) clientName, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(clientName, "clientName");
        IKernelFileBridgeClientService service = getService();
        if (service != null) {
            service.sendRequest(clientName, cb5);
        }
    }
}
