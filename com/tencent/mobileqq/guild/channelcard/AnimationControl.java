package com.tencent.mobileqq.guild.channelcard;

import android.view.View;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.main.GuildPageStateManager;
import com.tencent.mobileqq.guild.main.a;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0002\u0005\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/AnimationControl;", "", "", "d", "i", "com/tencent/mobileqq/guild/channelcard/AnimationControl$c", h.F, "()Lcom/tencent/mobileqq/guild/channelcard/AnimationControl$c;", "com/tencent/mobileqq/guild/channelcard/AnimationControl$b", "g", "()Lcom/tencent/mobileqq/guild/channelcard/AnimationControl$b;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "e", "", "f", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/main/GuildPageStateManager;", "b", "Lcom/tencent/mobileqq/guild/main/GuildPageStateManager;", "pageStateManager", "c", "Lcom/tencent/mobileqq/guild/channelcard/AnimationControl$c;", "scrollListener", "Lcom/tencent/mobileqq/guild/channelcard/AnimationControl$b;", "animateEnableListener", "Z", "addedListeners", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AnimationControl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildPageStateManager pageStateManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c scrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b animateEnableListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean addedListeners;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/channelcard/AnimationControl$b", "Lcom/tencent/mobileqq/guild/main/a;", "", "enableAnimate", "", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.main.a
        public void d(boolean enableAnimate) {
            LinearLayoutManager linearLayoutManager;
            Logger.f235387a.d().d("Guild.userl.AnimationControl", 1, "onAnimateEnableChanged: " + enableAnimate);
            RecyclerView.LayoutManager layoutManager = AnimationControl.this.recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager == null) {
                return;
            }
            int childCount = linearLayoutManager.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = linearLayoutManager.getChildAt(i3);
                if (childAt != null) {
                    Object childViewHolder = AnimationControl.this.recyclerView.getChildViewHolder(childAt);
                    if (childViewHolder instanceof a) {
                        ((a) childViewHolder).d(enableAnimate);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/channelcard/AnimationControl$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            boolean z16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            GuildPageStateManager guildPageStateManager = AnimationControl.this.pageStateManager;
            if (newState != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            guildPageStateManager.f(z16);
        }
    }

    public AnimationControl(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.pageStateManager = new GuildPageStateManager();
        this.scrollListener = h();
        this.animateEnableListener = g();
    }

    @UiThread
    private final void d() {
        if (this.addedListeners) {
            return;
        }
        this.recyclerView.addOnScrollListener(this.scrollListener);
        this.pageStateManager.i(this.animateEnableListener);
        this.addedListeners = true;
    }

    private final b g() {
        return new b();
    }

    private final c h() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void i() {
        this.recyclerView.removeOnScrollListener(this.scrollListener);
        this.pageStateManager.j(this.animateEnableListener);
        this.addedListeners = false;
    }

    public final void e(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        owner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.channelcard.AnimationControl$attachToLifecycleOwner$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes12.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f215204a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f215204a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Logger.f235387a.d().d("Guild.userl.AnimationControl", 1, "onStateChanged " + source + ", " + event);
                int i3 = a.f215204a[event.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            AnimationControl.this.i();
                            source.getLifecycle().removeObserver(this);
                            return;
                        }
                        return;
                    }
                    AnimationControl.this.pageStateManager.g(false);
                    return;
                }
                AnimationControl.this.pageStateManager.g(true);
            }
        });
        if (owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            d();
        }
    }

    public boolean f() {
        return this.pageStateManager.b();
    }
}
