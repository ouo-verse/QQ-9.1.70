package com.tencent.qqnt.kernel.api.impl;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.CacheFileType;
import com.tencent.qqnt.kernel.nativeinterface.CacheOrderType;
import com.tencent.qqnt.kernel.nativeinterface.ChatCacheDeleteInfo;
import com.tencent.qqnt.kernel.nativeinterface.CleanFileDetail;
import com.tencent.qqnt.kernel.nativeinterface.FileCacheInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetChatCacheInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetFileCacheInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelScanEndCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0019\u0012\b\u00100\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J4\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0018H\u0016J@\u0010!\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010 H\u0016J2\u0010&\u001a\u00020\t2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000b2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010)\u001a\u00020\t2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060'H\u0016J\b\u0010*\u001a\u00020\tH\u0016J\b\u0010+\u001a\u00020\tH\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020%H\u0016J\u0010\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0016\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/StorageCleanService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelStorageCleanService;", "Lcom/tencent/qqnt/kernel/api/af;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelStorageCleanListener;", "listener", "", "B0", "listenerId", "", "t", "Ljava/util/ArrayList;", "", "paths", "G0", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelScanEndCallback;", "result", "Z", "", "chatType", "pageSize", "Lcom/tencent/qqnt/kernel/nativeinterface/CacheOrderType;", "order", "pageIndex", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetChatCacheInfoCallback;", "getChatCacheInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CacheFileType;", TagName.FILE_TYPE, "", "restart", "Lcom/tencent/qqnt/kernel/nativeinterface/FileCacheInfo;", "lastRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetFileCacheInfoCallback;", "getFileCacheInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/ChatCacheDeleteInfo;", "chats", "fileKeys", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "clearChatCacheInfo", "Ljava/util/HashMap;", "data", "addReportData", "reportData", "closeCleanWindow", "clearAllChatCacheInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CleanFileDetail;", "fileInfo", "addNewDownloadOrUploadFile", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelStorageCleanService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class StorageCleanService extends BaseService<IKernelStorageCleanService, IKernelStorageCleanService> implements com.tencent.qqnt.kernel.api.af {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorageCleanService(@Nullable IKernelStorageCleanService iKernelStorageCleanService, @NotNull py content) {
        super("storage_clean", content, iKernelStorageCleanService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelStorageCleanService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public long B0(@Nullable final IKernelStorageCleanListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener)).longValue();
        }
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = -1L;
        check("addKernelStorageCleanListener", new Function0<Unit>(this, listener) { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$addStorageScanCleanListener$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IKernelStorageCleanListener $listener;
            final /* synthetic */ StorageCleanService this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                this.$listener = listener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Ref.LongRef.this, this, listener);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Ref.LongRef longRef2 = Ref.LongRef.this;
                IKernelStorageCleanService service = this.this$0.getService();
                Long valueOf = service != null ? Long.valueOf(service.addKernelStorageCleanListener(this.$listener)) : null;
                Intrinsics.checkNotNull(valueOf);
                longRef2.element = valueOf.longValue();
            }
        });
        return longRef.element;
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void G0(@NotNull final ArrayList<String> paths) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) paths);
        } else {
            Intrinsics.checkNotNullParameter(paths, "paths");
            check("addFilesScanedPaths", new Function0<Unit>(paths) { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$addFilesScanPaths$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<String> $paths;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$paths = paths;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StorageCleanService.this, (Object) paths);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addFilesScanedPaths(this.$paths);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void Z(@Nullable IKernelScanEndCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) result);
        } else {
            check("scanCache", result, new Function1<IKernelScanEndCallback, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$startScan$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StorageCleanService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IKernelScanEndCallback iKernelScanEndCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iKernelScanEndCallback);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.scanCache(iKernelScanEndCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void addNewDownloadOrUploadFile(@NotNull final CleanFileDetail fileInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fileInfo);
        } else {
            Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
            check("addNewDownloadOrUploadFile", new Function0<Unit>(fileInfo) { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$addNewDownloadOrUploadFile$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CleanFileDetail $fileInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$fileInfo = fileInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StorageCleanService.this, (Object) fileInfo);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addNewDownloadOrUploadFile(this.$fileInfo);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void addReportData(@NotNull final HashMap<String, Long> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            check("addReportData", new Function0<Unit>(data) { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$addReportData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ HashMap<String, Long> $data;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$data = data;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StorageCleanService.this, (Object) data);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addReportData(this.$data);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void clearAllChatCacheInfo(@NotNull IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(result, "result");
            check("clearAllChatCacheInfo", result, new Function1<IOperateCallback, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$clearAllChatCacheInfo$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StorageCleanService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.clearAllChatCacheInfo(iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void clearChatCacheInfo(@Nullable final ArrayList<ChatCacheDeleteInfo> chats, @Nullable final ArrayList<Long> fileKeys, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, chats, fileKeys, result);
        } else {
            check("clearChatCacheInfo", result, new Function1<IOperateCallback, Unit>(chats, fileKeys) { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$clearChatCacheInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<ChatCacheDeleteInfo> $chats;
                final /* synthetic */ ArrayList<Long> $fileKeys;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$chats = chats;
                    this.$fileKeys = fileKeys;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, StorageCleanService.this, chats, fileKeys);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.clearChatCacheInfo(this.$chats, this.$fileKeys, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void closeCleanWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            check("closeCleanWindow", new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$closeCleanWindow$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StorageCleanService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.closeCleanWindow();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void getChatCacheInfo(final int chatType, final int pageSize, @Nullable final CacheOrderType order, final int pageIndex, @Nullable final IKernelGetChatCacheInfoCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(chatType), Integer.valueOf(pageSize), order, Integer.valueOf(pageIndex), result);
        } else {
            check("getChatCacheInfo", new Function0<Unit>(chatType, pageSize, order, pageIndex, result) { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$getChatCacheInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $chatType;
                final /* synthetic */ CacheOrderType $order;
                final /* synthetic */ int $pageIndex;
                final /* synthetic */ int $pageSize;
                final /* synthetic */ IKernelGetChatCacheInfoCallback $result;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$chatType = chatType;
                    this.$pageSize = pageSize;
                    this.$order = order;
                    this.$pageIndex = pageIndex;
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, StorageCleanService.this, Integer.valueOf(chatType), Integer.valueOf(pageSize), order, Integer.valueOf(pageIndex), result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getChatCacheInfo(this.$chatType, this.$pageSize, this.$order, this.$pageIndex, this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void getFileCacheInfo(@Nullable final CacheFileType fileType, final boolean restart, final int pageSize, @Nullable final CacheOrderType order, @Nullable final FileCacheInfo lastRecord, @Nullable final IKernelGetFileCacheInfoCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, fileType, Boolean.valueOf(restart), Integer.valueOf(pageSize), order, lastRecord, result);
        } else {
            check("getFileCacheInfo", new Function0<Unit>(fileType, restart, pageSize, order, lastRecord, result) { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$getFileCacheInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CacheFileType $fileType;
                final /* synthetic */ FileCacheInfo $lastRecord;
                final /* synthetic */ CacheOrderType $order;
                final /* synthetic */ int $pageSize;
                final /* synthetic */ boolean $restart;
                final /* synthetic */ IKernelGetFileCacheInfoCallback $result;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$fileType = fileType;
                    this.$restart = restart;
                    this.$pageSize = pageSize;
                    this.$order = order;
                    this.$lastRecord = lastRecord;
                    this.$result = result;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, StorageCleanService.this, fileType, Boolean.valueOf(restart), Integer.valueOf(pageSize), order, lastRecord, result);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getFileCacheInfo(this.$fileType, this.$restart, this.$pageSize, this.$order, this.$lastRecord, this.$result);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void reportData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            check("reportData", new Function0<Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$reportData$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StorageCleanService.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.reportData();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.af
    public void t(final long listenerId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, listenerId);
        } else {
            check("removeKernelStorageCleanListener", new Function0<Unit>(listenerId) { // from class: com.tencent.qqnt.kernel.api.impl.StorageCleanService$removeStorageScanCleanListener$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $listenerId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$listenerId = listenerId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, StorageCleanService.this, Long.valueOf(listenerId));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelStorageCleanService service = StorageCleanService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.removeKernelStorageCleanListener(this.$listenerId);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
