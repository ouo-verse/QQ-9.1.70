package com.tencent.mobileqq.guild.feed.nativedetail.bottom.framework;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/framework/LifecycleBoundRunnable;", "Ljava/lang/Runnable;", "Landroidx/lifecycle/LifecycleEventObserver;", "", "e", "", TencentLocation.RUN_MODE, "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "d", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "block", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;)V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LifecycleBoundRunnable implements Runnable, LifecycleEventObserver {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner owner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> block;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/framework/LifecycleBoundRunnable$a;", "", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lkotlin/Function0;", "", "block", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/framework/LifecycleBoundRunnable;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.framework.LifecycleBoundRunnable$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LifecycleBoundRunnable a(@NotNull LifecycleOwner owner, @NotNull Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(block, "block");
            LifecycleBoundRunnable lifecycleBoundRunnable = new LifecycleBoundRunnable(owner, block);
            owner.getLifecycle().addObserver(lifecycleBoundRunnable);
            return lifecycleBoundRunnable;
        }

        Companion() {
        }
    }

    public LifecycleBoundRunnable(@NotNull LifecycleOwner owner, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(block, "block");
        this.owner = owner;
        this.block = block;
    }

    private final boolean e() {
        return this.owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.owner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            this.owner.getLifecycle().removeObserver(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (e()) {
            this.block.invoke();
        } else {
            QLog.d("LifecycleBoundRunnable", 1, "inactive state now");
        }
    }
}
