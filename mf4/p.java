package mf4;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.impl.ExpandHallFragment;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u0015"}, d2 = {"Lmf4/p;", "", "Landroid/content/Context;", "context", "Lmf4/p$a;", "task", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "expandHallOpenParam", "", "k", "Landroid/content/DialogInterface;", "dialog", tl.h.F, "j", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "listener", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "g", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f416710a = new p();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lmf4/p$a;", "", "Ljava/util/concurrent/CountDownLatch;", "locker", "Lcom/tencent/timi/game/ui/widget/i;", "dialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timeOutFlag", "alreadyStart", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(@NotNull CountDownLatch locker, @Nullable com.tencent.timi.game.ui.widget.i dialog, @NotNull AtomicBoolean timeOutFlag, @NotNull AtomicBoolean alreadyStart);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"mf4/p$b", "Lmf4/p$a;", "Ljava/util/concurrent/CountDownLatch;", "locker", "Lcom/tencent/timi/game/ui/widget/i;", "dialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timeOutFlag", "alreadyStart", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f416711a;

        b(long j3) {
            this.f416711a = j3;
        }

        @Override // mf4.p.a
        public void a(@NotNull CountDownLatch locker, @Nullable com.tencent.timi.game.ui.widget.i dialog, @NotNull AtomicBoolean timeOutFlag, @NotNull AtomicBoolean alreadyStart) {
            Intrinsics.checkNotNullParameter(locker, "locker");
            Intrinsics.checkNotNullParameter(timeOutFlag, "timeOutFlag");
            Intrinsics.checkNotNullParameter(alreadyStart, "alreadyStart");
            alreadyStart.set(true);
            com.tencent.timi.game.utils.l.i("TimiGameApp_", "createExpandHallFragment " + (System.currentTimeMillis() - this.f416711a) + "ms");
            locker.countDown();
            if (dialog != null) {
                p.f416710a.h(dialog);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"mf4/p$c", "Lmf4/p$a;", "Ljava/util/concurrent/CountDownLatch;", "locker", "Lcom/tencent/timi/game/ui/widget/i;", "dialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timeOutFlag", "alreadyStart", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f416712a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExpandHallLaunchParam f416713b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f416714c;

        c(Context context, ExpandHallLaunchParam expandHallLaunchParam, long j3) {
            this.f416712a = context;
            this.f416713b = expandHallLaunchParam;
            this.f416714c = j3;
        }

        @Override // mf4.p.a
        public void a(@NotNull CountDownLatch locker, @Nullable com.tencent.timi.game.ui.widget.i dialog, @NotNull AtomicBoolean timeOutFlag, @NotNull AtomicBoolean alreadyStart) {
            Intrinsics.checkNotNullParameter(locker, "locker");
            Intrinsics.checkNotNullParameter(timeOutFlag, "timeOutFlag");
            Intrinsics.checkNotNullParameter(alreadyStart, "alreadyStart");
            if (!timeOutFlag.get()) {
                ((gh4.f) mm4.b.b(gh4.f.class)).openExpandHall(this.f416712a, this.f416713b);
            }
            alreadyStart.set(true);
            com.tencent.timi.game.utils.l.i("TimiGameApp_", "openExpandHall " + (System.currentTimeMillis() - this.f416714c) + "ms");
            locker.countDown();
            if (dialog != null) {
                p.f416710a.h(dialog);
            }
        }
    }

    p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final DialogInterface dialog) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: mf4.o
            @Override // java.lang.Runnable
            public final void run() {
                p.i(dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        try {
            wf4.a.f445618a.b(dialog);
            dialog.dismiss();
            com.tencent.timi.game.utils.l.i("TimiGameApp_", "hideWaitDialog succeed!");
        } catch (Exception e16) {
            com.tencent.timi.game.utils.l.f("TimiGameApp_", "dialog.dismiss error:", e16);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.timi.game.ui.widget.i, T] */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.tencent.timi.game.ui.widget.i, T] */
    private final void k(Context context, final a task, final ExpandHallLaunchParam expandHallOpenParam) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (context instanceof Activity) {
            objectRef.element = new com.tencent.timi.game.ui.widget.i(context);
        } else if (QBaseActivity.sTopActivity != null) {
            QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
            objectRef.element = new com.tencent.timi.game.ui.widget.i(sTopActivity);
        } else {
            com.tencent.timi.game.utils.l.e("TimiGameApp_", "openExpandHall need activity context\uff01");
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: mf4.k
            @Override // java.lang.Runnable
            public final void run() {
                p.l(currentTimeMillis, objectRef, expandHallOpenParam, task);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.concurrent.atomic.AtomicBoolean] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.util.concurrent.atomic.AtomicBoolean] */
    public static final void l(final long j3, final Ref.ObjectRef dialog, final ExpandHallLaunchParam expandHallOpenParam, final a task) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(expandHallOpenParam, "$expandHallOpenParam");
        Intrinsics.checkNotNullParameter(task, "$task");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new AtomicBoolean(false);
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = new AtomicBoolean(false);
        ThreadManagerV2.excute(new Runnable() { // from class: mf4.l
            @Override // java.lang.Runnable
            public final void run() {
                p.m(ExpandHallLaunchParam.this, j3, task, countDownLatch, dialog, objectRef, objectRef2);
            }
        }, 16, null, false);
        try {
            countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            com.tencent.timi.game.utils.l.f("TimiGameApp_", "SHOW_LOADING_DURATION Time Out", e16);
        }
        com.tencent.timi.game.utils.l.i("TimiGameApp_", "sub thread activityAlreadyStart:" + ((AtomicBoolean) objectRef2.element).get());
        if (!((AtomicBoolean) objectRef2.element).get()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: mf4.m
                @Override // java.lang.Runnable
                public final void run() {
                    p.o(Ref.ObjectRef.this, dialog);
                }
            });
        }
        try {
            countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e17) {
            com.tencent.timi.game.utils.l.f("TimiGameApp_", "MAX_WAIT_DURATION Time Out", e17);
        }
        ((AtomicBoolean) objectRef.element).set(true);
        com.tencent.timi.game.utils.l.i("TimiGameApp_", "init task finished " + (System.currentTimeMillis() - j3) + "ms");
        com.tencent.timi.game.ui.widget.i iVar = (com.tencent.timi.game.ui.widget.i) dialog.element;
        if (iVar != null) {
            f416710a.h(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final ExpandHallLaunchParam expandHallOpenParam, final long j3, final a task, final CountDownLatch timeOutLocker, final Ref.ObjectRef dialog, final Ref.ObjectRef timeOutFlag, final Ref.ObjectRef alreadyStart) {
        Intrinsics.checkNotNullParameter(expandHallOpenParam, "$expandHallOpenParam");
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(timeOutLocker, "$timeOutLocker");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(timeOutFlag, "$timeOutFlag");
        Intrinsics.checkNotNullParameter(alreadyStart, "$alreadyStart");
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: mf4.n
            @Override // hi4.a
            public final void a(boolean z16) {
                p.n(ExpandHallLaunchParam.this, j3, task, timeOutLocker, dialog, timeOutFlag, alreadyStart, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void n(ExpandHallLaunchParam expandHallOpenParam, long j3, a task, CountDownLatch timeOutLocker, Ref.ObjectRef dialog, Ref.ObjectRef timeOutFlag, Ref.ObjectRef alreadyStart, boolean z16) {
        Intrinsics.checkNotNullParameter(expandHallOpenParam, "$expandHallOpenParam");
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(timeOutLocker, "$timeOutLocker");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(timeOutFlag, "$timeOutFlag");
        Intrinsics.checkNotNullParameter(alreadyStart, "$alreadyStart");
        ((ug4.b) mm4.b.b(ug4.b.class)).P1(expandHallOpenParam.f376301d);
        com.tencent.timi.game.utils.l.i("TimiGameApp_", "ensureInitWithCallback " + (System.currentTimeMillis() - j3) + "ms");
        ((hi4.b) mm4.b.b(hi4.b.class)).c0(1);
        com.tencent.timi.game.utils.l.i("TimiGameApp_", "doWhenLaunchYesScenes " + (System.currentTimeMillis() - j3) + "ms");
        ((kn4.b) mm4.b.b(kn4.b.class)).T1(null);
        com.tencent.timi.game.utils.l.i("TimiGameApp_", "login " + (System.currentTimeMillis() - j3) + "ms");
        task.a(timeOutLocker, (com.tencent.timi.game.ui.widget.i) dialog.element, (AtomicBoolean) timeOutFlag.element, (AtomicBoolean) alreadyStart.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(Ref.ObjectRef alreadyStart, Ref.ObjectRef dialog) {
        com.tencent.timi.game.ui.widget.i iVar;
        Intrinsics.checkNotNullParameter(alreadyStart, "$alreadyStart");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (!((AtomicBoolean) alreadyStart.element).get() && (iVar = (com.tencent.timi.game.ui.widget.i) dialog.element) != null) {
            iVar.show();
            wf4.a.f445618a.e(iVar);
        }
    }

    @NotNull
    public final QPublicBaseFragment g(@NotNull Context context, @NotNull ExpandHallLaunchParam expandHallOpenParam, @Nullable ExpandHallListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(expandHallOpenParam, "expandHallOpenParam");
        k(context, new b(System.currentTimeMillis()), expandHallOpenParam);
        ExpandHallFragment expandHallFragment = new ExpandHallFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_expand_hall_launch_param", expandHallOpenParam);
        expandHallFragment.setArguments(bundle);
        if (listener == null) {
            expandHallFragment.ci(th4.n.f436362a.b(expandHallOpenParam));
        } else {
            expandHallFragment.ci(listener);
        }
        th4.f.f436343a.i(1);
        return expandHallFragment;
    }

    public final void j(@NotNull Context context, @NotNull ExpandHallLaunchParam expandHallOpenParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(expandHallOpenParam, "expandHallOpenParam");
        k(context, new c(context, expandHallOpenParam, System.currentTimeMillis()), expandHallOpenParam);
    }
}
