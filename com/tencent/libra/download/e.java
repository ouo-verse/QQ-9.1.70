package com.tencent.libra.download;

import android.os.Handler;
import android.os.Message;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/libra/download/e;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "", "d", "Ljava/lang/String;", "TAG", "Landroid/os/Handler$Callback;", "e", "Landroid/os/Handler$Callback;", "callback", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "f", "Landroid/os/Handler;", "handler", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
final class e extends CoroutineDispatcher {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "WorkerDispatcher";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Handler.Callback callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/os/Message;", "handleMessage"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    static final class a implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        public static final a f118675d = new a();

        a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(@NotNull Message it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.getCallback().run();
            return true;
        }
    }

    public e() {
        a aVar = a.f118675d;
        this.callback = aVar;
        this.handler = RFWThreadManager.createNewThreadHandler("WorkerDispatcher", 0, aVar);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo2047dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        this.handler.post(block);
    }
}
