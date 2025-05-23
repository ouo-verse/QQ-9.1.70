package com.tencent.biz.qui.toast;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ud0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qui/toast/ToastManager;", "", "", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c", "Lcom/tencent/biz/qui/toast/a;", "toast", "d", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "a", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "toastQueue", "", "<set-?>", "b", "Z", "isShowing", "()Z", "<init>", "()V", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class ToastManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentLinkedQueue<a> toastQueue = new ConcurrentLinkedQueue<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        if (!this.isShowing && (!this.toastQueue.isEmpty())) {
            this.isShowing = true;
            a poll = this.toastQueue.poll();
            if (poll != null) {
                poll.a(new Function0<Unit>() { // from class: com.tencent.biz.qui.toast.ToastManager$showNextToast$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.biz.qui.toast.ToastManager$showNextToast$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ToastManager.this.isShowing = false;
                                ToastManager.this.e();
                            }
                        }, 100L);
                    }
                });
            }
        }
    }

    public final void c(@Nullable Activity activity) {
        if (activity == null) {
            d.b("ToastManager", d.f438811e, "removeQueue activity is null");
            return;
        }
        Iterator<a> it = this.toastQueue.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (Intrinsics.areEqual(activity, next.getActivity())) {
                this.toastQueue.remove(next);
            }
        }
    }

    public final void d(@NotNull a toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.toastQueue.offer(toast);
        e();
    }
}
