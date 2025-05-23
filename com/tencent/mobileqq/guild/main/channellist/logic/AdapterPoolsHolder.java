package com.tencent.mobileqq.guild.main.channellist.logic;

import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.Pools;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00032\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002R4\u0010\f\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0014\u0012\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006j\u0002`\t0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/logic/AdapterPoolsHolder;", "", "Landroidx/lifecycle/LifecycleEventObserver;", "d", "Landroidx/collection/SimpleArrayMap;", "Ljava/lang/Class;", "Landroidx/collection/SparseArrayCompat;", "Landroidx/core/util/Pools$Pool;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/main/channellist/logic/AdapterPools;", "a", "Landroidx/collection/SimpleArrayMap;", "bagOfPools", "Landroidx/lifecycle/Lifecycle;", "b", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "c", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleObserver", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class AdapterPoolsHolder {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Lifecycle lifecycle;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleArrayMap<Class<?>, SparseArrayCompat<Pools.Pool<RecyclerView.ViewHolder>>> bagOfPools = new SimpleArrayMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LifecycleEventObserver lifecycleObserver = d();

    private final LifecycleEventObserver d() {
        return new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.main.channellist.logic.AdapterPoolsHolder$newLifecycleObserver$1

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes14.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f227118a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f227118a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                SimpleArrayMap simpleArrayMap;
                Lifecycle lifecycle;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Logger.f235387a.d().i("AdapterPoolsHolder", 1, "ConversationFragment onStateChanged " + source + ", " + event);
                if (a.f227118a[event.ordinal()] == 1) {
                    simpleArrayMap = AdapterPoolsHolder.this.bagOfPools;
                    simpleArrayMap.clear();
                    lifecycle = AdapterPoolsHolder.this.lifecycle;
                    if (lifecycle != null) {
                        lifecycle.removeObserver(this);
                    }
                    AdapterPoolsHolder.this.lifecycle = null;
                }
            }
        };
    }
}
