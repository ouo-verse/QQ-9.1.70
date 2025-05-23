package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ7\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001H$\u00a2\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00018\u0001H\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "", "Request", "Response", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "task", "req", "", "d", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;Ljava/lang/Object;)Z", "", "e", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;Ljava/lang/Object;)V", "", "tag", "errorMsg", "a", "", "result", "errMsg", "rsp", "b", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "success", "c", "(ZILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "g", "(Ljava/lang/Object;Ljava/lang/Object;)V", "f", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "Z", "needDispatchToMainThread", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class RequestSenderCallback<Request, Response> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean needDispatchToMainThread;

    public RequestSenderCallback() {
        this(false, 1, null);
    }

    public final void a(@NotNull String tag, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        QLog.e(tag, 1, errorMsg);
    }

    public void b(@NotNull ICommentTask task, int result, @NotNull String errMsg, @NotNull Request req, @NotNull Response rsp) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        c(true, result, errMsg, req, rsp);
    }

    public final void c(boolean success, final int result, @NotNull final String errMsg, @NotNull final Request req, @Nullable final Response rsp) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(req, "req");
        if (success && result == 0 && rsp != null) {
            if (this.needDispatchToMainThread) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback$handleResponseOutcomeCaseByCase$$inlined$dispatch$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        RequestSenderCallback.this.g(req, rsp);
                    }
                });
                return;
            } else {
                g(req, rsp);
                return;
            }
        }
        if (this.needDispatchToMainThread) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback$handleResponseOutcomeCaseByCase$$inlined$dispatch$1
                @Override // java.lang.Runnable
                public final void run() {
                    RequestSenderCallback.this.f(result, errMsg, req, rsp);
                }
            });
        } else {
            f(result, errMsg, req, rsp);
        }
    }

    public boolean d(@NotNull ICommentTask task, @NotNull Request req) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(req, "req");
        return true;
    }

    public void e(@NotNull ICommentTask task, @NotNull Request req) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(req, "req");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int result, @NotNull String errMsg, @NotNull Request req, @Nullable Response rsp) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(req, "req");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void g(@NotNull Request req, @NotNull Response rsp);

    public RequestSenderCallback(boolean z16) {
        this.needDispatchToMainThread = z16;
    }

    public /* synthetic */ RequestSenderCallback(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
