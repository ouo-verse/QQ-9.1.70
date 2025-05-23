package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import eipc.EIPCModule;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/ipc/b;", "", "", "message", "Lcom/tencent/mobileqq/qqexpand/ipc/b$a;", "syncHandler", "", "b", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "a", "Leipc/EIPCModule;", "Leipc/EIPCModule;", "mIpcModule", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "mDispatchMap", "c", "Lcom/tencent/mobileqq/qqexpand/ipc/b$a;", "mDefaultSyncHandler", "defaultSyncHandler", "<init>", "(Leipc/EIPCModule;Lcom/tencent/mobileqq/qqexpand/ipc/b$a;)V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final EIPCModule mIpcModule;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final QQConcurrentHashMap<String, a> mDispatchMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final a mDefaultSyncHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/ipc/b$a;", "", "", "message", "Landroid/os/Bundle;", "params", "", "callbackId", "a", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface a {
        Bundle a(String message, Bundle params, int callbackId);
    }

    public b(EIPCModule mIpcModule, a aVar) {
        Intrinsics.checkNotNullParameter(mIpcModule, "mIpcModule");
        this.mIpcModule = mIpcModule;
        this.mDispatchMap = new QQConcurrentHashMap<>(Business.Conversation, "ExpandIpcServerDispatch", 10);
        this.mDefaultSyncHandler = aVar;
    }

    public final EIPCResult a(String message, Bundle params, int callbackId) {
        Bundle a16;
        Intrinsics.checkNotNullParameter(message, "message");
        a aVar = this.mDispatchMap.get(message);
        if (aVar != null) {
            try {
                a16 = aVar.a(message, params, callbackId);
            } catch (Exception e16) {
                return EIPCResult.createExceptionResult(e16);
            }
        } else {
            a16 = null;
        }
        if (a16 == null) {
            a aVar2 = this.mDefaultSyncHandler;
            a16 = aVar2 != null ? aVar2.a(message, params, callbackId) : null;
        }
        if (a16 == null) {
            return null;
        }
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(a16);
        this.mIpcModule.callbackResult(callbackId, createSuccessResult);
        return createSuccessResult;
    }

    public final void b(String message, a syncHandler) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(syncHandler, "syncHandler");
        this.mDispatchMap.put(message, syncHandler);
    }
}
