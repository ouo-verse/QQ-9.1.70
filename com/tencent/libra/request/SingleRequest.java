package com.tencent.libra.request;

import android.graphics.drawable.Animatable;
import com.tencent.libra.LibraPicLoader;
import com.tencent.libra.listener.IPicLoadStateListener;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0013\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u0017H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/libra/request/SingleRequest;", "Lcom/tencent/libra/request/Request;", "option", "Lcom/tencent/libra/request/Option;", "listenerWf", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "picLoader", "Lcom/tencent/libra/LibraPicLoader;", "(Lcom/tencent/libra/request/Option;Ljava/lang/ref/WeakReference;Lcom/tencent/libra/LibraPicLoader;)V", "isPauseAnimatable", "", "getOption", "()Lcom/tencent/libra/request/Option;", "requestManagerWrf", "Lcom/tencent/libra/request/RequestManager;", "getRequestManagerWrf", "()Ljava/lang/ref/WeakReference;", "setRequestManagerWrf", "(Ljava/lang/ref/WeakReference;)V", "status", "Lcom/tencent/libra/request/SingleRequest$Status;", "begin", "", QCircleLpReportDc05507.KEY_CLEAR, "equals", "other", "", "getHostRequestManager", "hashCode", "", "isCleared", "isRunning", "pause", "Status", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class SingleRequest implements Request {
    private boolean isPauseAnimatable;
    private final WeakReference<IPicLoadStateListener> listenerWf;

    @NotNull
    private final Option option;
    private final LibraPicLoader picLoader;

    @Nullable
    private WeakReference<RequestManager> requestManagerWrf;
    private Status status;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/libra/request/SingleRequest$Status;", "", "(Ljava/lang/String;I)V", "PENDING", DebugCoroutineInfoImplKt.RUNNING, "WAITING_FOR_SIZE", "COMPLETE", "FAILED", "CLEARED", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(@NotNull Option option, @NotNull WeakReference<IPicLoadStateListener> listenerWf, @NotNull LibraPicLoader picLoader) {
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(listenerWf, "listenerWf");
        Intrinsics.checkNotNullParameter(picLoader, "picLoader");
        this.option = option;
        this.listenerWf = listenerWf;
        this.picLoader = picLoader;
        this.status = Status.RUNNING;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // com.tencent.libra.request.Request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void begin() {
        boolean z16;
        if (this.option.getAnimatable() != null) {
            Animatable animatable = this.option.getAnimatable();
            Intrinsics.checkNotNullExpressionValue(animatable, "option.animatable");
            if (!animatable.isRunning() && this.isPauseAnimatable) {
                z16 = true;
                if (z16) {
                    this.option.getAnimatable().start();
                    this.isPauseAnimatable = false;
                }
                this.status = Status.RUNNING;
            }
        }
        z16 = false;
        if (z16) {
        }
        this.status = Status.RUNNING;
    }

    @Override // com.tencent.libra.request.Request
    public void clear() {
        Status status = this.status;
        Status status2 = Status.CLEARED;
        if (status == status2) {
            return;
        }
        this.option.clear();
        this.status = status2;
        this.picLoader.handleCancelDownload(this.option, this.listenerWf.get());
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(SingleRequest.class, cls)) {
            return false;
        }
        if (other != null) {
            SingleRequest singleRequest = (SingleRequest) other;
            if (true ^ Intrinsics.areEqual(this.option, singleRequest.option)) {
                return false;
            }
            return Intrinsics.areEqual(this.picLoader, singleRequest.picLoader);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.libra.request.SingleRequest");
    }

    @Nullable
    public final RequestManager getHostRequestManager() {
        WeakReference<RequestManager> weakReference = this.requestManagerWrf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final Option getOption() {
        return this.option;
    }

    @Nullable
    public final WeakReference<RequestManager> getRequestManagerWrf() {
        return this.requestManagerWrf;
    }

    public int hashCode() {
        return (this.option.hashCode() * 31) + this.picLoader.hashCode();
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ boolean isAnyResourceSet() {
        return d.b(this);
    }

    @Override // com.tencent.libra.request.Request
    public boolean isCleared() {
        if (this.status == Status.CLEARED) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ boolean isComplete() {
        return d.c(this);
    }

    @Override // com.tencent.libra.request.Request
    public /* synthetic */ boolean isEquivalentTo(Request request) {
        return d.d(this, request);
    }

    @Override // com.tencent.libra.request.Request
    public boolean isRunning() {
        if (this.status == Status.RUNNING) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    @Override // com.tencent.libra.request.Request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pause() {
        boolean z16;
        if (this.option.getAnimatable() != null) {
            Animatable animatable = this.option.getAnimatable();
            Intrinsics.checkNotNullExpressionValue(animatable, "option.animatable");
            if (animatable.isRunning()) {
                z16 = true;
                if (z16) {
                    this.option.getAnimatable().stop();
                    this.isPauseAnimatable = true;
                }
                this.status = Status.PENDING;
            }
        }
        z16 = false;
        if (z16) {
        }
        this.status = Status.PENDING;
    }

    public final void setRequestManagerWrf(@Nullable WeakReference<RequestManager> weakReference) {
        this.requestManagerWrf = weakReference;
    }
}
