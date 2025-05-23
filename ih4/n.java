package ih4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.impl.ExpandHallFragment;
import com.tencent.timi.game.expand.hall.impl.floating.ExpandHallFloatingView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\fH\u0016J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\"\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0#0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lih4/n;", "Lgh4/f;", "Landroid/content/Context;", "context", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "param", "", "openExpandHall", "Lgh4/a;", "lifeCycleListener", "V", "init", "Lgh4/e;", "I0", "hall", "K2", "d2", "", "roomId", "Luh4/d;", "p", "z0", "", "errorCode", "", "errorMsg", "P2", "o2", "S3", "p1", "Lgh4/d;", "V0", "a", "Ljava/lang/String;", "TAG", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "Ljava/util/LinkedList;", "c", "Ljava/util/LinkedList;", "listenerPool", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class n implements gh4.f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<gh4.e> hall;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "ExpandHallImpl_";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<WeakReference<gh4.a>> listenerPool = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T3(n this$0, gh4.e hall) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hall, "$hall");
        Iterator<WeakReference<gh4.a>> it = this$0.listenerPool.iterator();
        while (it.hasNext()) {
            gh4.a aVar = it.next().get();
            if (aVar != null) {
                aVar.d(hall);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U3(n this$0, gh4.e hall) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hall, "$hall");
        Iterator<WeakReference<gh4.a>> it = this$0.listenerPool.iterator();
        while (it.hasNext()) {
            gh4.a aVar = it.next().get();
            if (aVar != null) {
                aVar.a(hall);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V3(n this$0, int i3, String errorMsg, gh4.e hall) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        Intrinsics.checkNotNullParameter(hall, "$hall");
        Iterator<WeakReference<gh4.a>> it = this$0.listenerPool.iterator();
        while (it.hasNext()) {
            gh4.a aVar = it.next().get();
            if (aVar != null) {
                aVar.c(i3, errorMsg, hall);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W3(n this$0, long j3, gh4.e hall) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hall, "$hall");
        Iterator<WeakReference<gh4.a>> it = this$0.listenerPool.iterator();
        while (it.hasNext()) {
            gh4.a aVar = it.next().get();
            if (aVar != null) {
                aVar.b(j3, hall);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X3(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ExpandHallFragment.class);
    }

    @Override // gh4.f
    @Nullable
    public gh4.e I0() {
        WeakReference<gh4.e> weakReference = this.hall;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // gh4.f
    public void K2(@NotNull final gh4.e hall) {
        Intrinsics.checkNotNullParameter(hall, "hall");
        this.hall = new WeakReference<>(hall);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ih4.k
            @Override // java.lang.Runnable
            public final void run() {
                n.U3(n.this, hall);
            }
        });
    }

    @Override // gh4.f
    public void P2(final int errorCode, @NotNull final String errorMsg, @NotNull final gh4.e hall) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(hall, "hall");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ih4.m
            @Override // java.lang.Runnable
            public final void run() {
                n.V3(n.this, errorCode, errorMsg, hall);
            }
        });
    }

    public void S3(@NotNull gh4.e hall) {
        Intrinsics.checkNotNullParameter(hall, "hall");
        com.tencent.timi.game.utils.l.i(this.TAG, "destroyHall hall:" + hall);
        hall.D4();
    }

    @Override // gh4.f
    @MainThread
    public void V(@NotNull gh4.a lifeCycleListener) {
        Intrinsics.checkNotNullParameter(lifeCycleListener, "lifeCycleListener");
        Iterator<WeakReference<gh4.a>> it = this.listenerPool.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().get(), lifeCycleListener)) {
                return;
            }
        }
        this.listenerPool.add(new WeakReference<>(lifeCycleListener));
        Iterator<WeakReference<gh4.a>> it5 = this.listenerPool.iterator();
        Intrinsics.checkNotNullExpressionValue(it5, "listenerPool.iterator()");
        while (it5.hasNext()) {
            WeakReference<gh4.a> next = it5.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            if (next.get() == null) {
                it5.remove();
            }
        }
    }

    @Override // gh4.f
    @Nullable
    public gh4.d V0(long roomId) {
        return ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomId).P();
    }

    @Override // gh4.f
    public void d2(@NotNull final gh4.e hall) {
        gh4.e eVar;
        Intrinsics.checkNotNullParameter(hall, "hall");
        WeakReference<gh4.e> weakReference = this.hall;
        if (weakReference != null) {
            eVar = weakReference.get();
        } else {
            eVar = null;
        }
        if (Intrinsics.areEqual(hall, eVar)) {
            this.hall = null;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ih4.j
            @Override // java.lang.Runnable
            public final void run() {
                n.T3(n.this, hall);
            }
        });
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
        com.tencent.timi.game.utils.l.i(this.TAG, "init context:" + context);
    }

    @Override // gh4.f
    public void openExpandHall(@NotNull final Context context, @NotNull ExpandHallLaunchParam param) {
        boolean z16;
        gh4.e eVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.timi.game.utils.l.h(this.TAG, 1, "openExpandHall param=" + param + ", context=" + context);
        WeakReference<gh4.e> weakReference = this.hall;
        if (weakReference != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (weakReference != null && (eVar = weakReference.get()) != null) {
            S3(eVar);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_expand_hall_launch_param", param);
        final Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("public_fragment_window_feature", 1);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: ih4.i
                @Override // java.lang.Runnable
                public final void run() {
                    n.X3(context, intent);
                }
            }, 500L);
        } else {
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ExpandHallFragment.class);
        }
        com.tencent.timi.game.utils.l.h(this.TAG, 1, "openExpandHall QPublicFragmentActivity.start finish");
    }

    @Override // gh4.f
    @Nullable
    public uh4.d p(long roomId) {
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ExpandHallFloatingView expandHallFloatingView = new ExpandHallFloatingView(context, null, 2, 0 == true ? 1 : 0);
        expandHallFloatingView.v(roomId);
        return expandHallFloatingView;
    }

    @Override // gh4.f
    public void p1() {
        gh4.e eVar;
        WeakReference<gh4.e> weakReference = this.hall;
        if (weakReference != null && (eVar = weakReference.get()) != null) {
            S3(eVar);
        }
    }

    @Override // gh4.f
    public void z0(final long roomId, @NotNull final gh4.e hall) {
        Intrinsics.checkNotNullParameter(hall, "hall");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ih4.l
            @Override // java.lang.Runnable
            public final void run() {
                n.W3(n.this, roomId, hall);
            }
        });
    }

    @Override // mm4.a
    public void o2() {
    }
}
