package com.tencent.mobileqq.guild.channelcard.videoplay;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0002\u0018\u0000 \b2\u00020\u0001:\u0002\u0014\u0017B!\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u00a2\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000eR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001f` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/videoplay/c;", "", "com/tencent/mobileqq/guild/channelcard/videoplay/c$c", "f", "()Lcom/tencent/mobileqq/guild/channelcard/videoplay/c$c;", "", "reason", "", h.F, "Lkotlin/Pair;", "", "e", "g", "k", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/a;", "videoPlayable", "d", "viewHolder", "j", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "b", "I", "animationMaxCount", "", "c", "Ljava/util/Set;", "animatingSet", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/GuildVideoPlayController;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "viewHolderAndPlayControllerMap", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/c$b;", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/c$b;", "playControllerPool", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/c$c;", "onScrollListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "delayPlayAnimationRunnable", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "guildLivePlayerTag", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;Landroidx/recyclerview/widget/RecyclerView;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int animationMaxCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<a> animatingSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<a, GuildVideoPlayController> viewHolderAndPlayControllerMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b playControllerPool;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7687c onScrollListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable delayPlayAnimationRunnable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/videoplay/c$b;", "", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/GuildVideoPlayController;", "a", "b", "controller", "", "c", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "getGuildLivePlayerTag", "()Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "guildLivePlayerTag", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "controllers", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildLivePlayerTag guildLivePlayerTag;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LinkedList<GuildVideoPlayController> controllers;

        public b(@NotNull GuildLivePlayerTag guildLivePlayerTag) {
            Intrinsics.checkNotNullParameter(guildLivePlayerTag, "guildLivePlayerTag");
            this.guildLivePlayerTag = guildLivePlayerTag;
            this.controllers = new LinkedList<>();
        }

        private final GuildVideoPlayController a() {
            return new GuildVideoPlayController(this.guildLivePlayerTag);
        }

        @NotNull
        public final GuildVideoPlayController b() {
            GuildVideoPlayController pollFirst = this.controllers.pollFirst();
            if (pollFirst == null) {
                return a();
            }
            return pollFirst;
        }

        public final void c(@NotNull GuildVideoPlayController controller) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.controllers.addFirst(controller);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/channelcard/videoplay/c$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "", "d", "J", "lastOnScrolledCheckedTime", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channelcard.videoplay.c$c, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7687c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long lastOnScrolledCheckedTime = System.nanoTime();

        C7687c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                c.this.h("scroll idle");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            long nanoTime = System.nanoTime();
            if ((nanoTime - this.lastOnScrolledCheckedTime) / 1000000 >= 1000) {
                this.lastOnScrolledCheckedTime = nanoTime;
                c.this.h("scroll checked");
            }
        }
    }

    public c(@NotNull GuildLivePlayerTag guildLivePlayerTag, @NotNull RecyclerView recyclerView, int i3) {
        Intrinsics.checkNotNullParameter(guildLivePlayerTag, "guildLivePlayerTag");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.animationMaxCount = i3;
        this.animatingSet = new LinkedHashSet();
        this.viewHolderAndPlayControllerMap = new HashMap<>();
        this.playControllerPool = new b(guildLivePlayerTag);
        C7687c f16 = f();
        this.onScrollListener = f16;
        recyclerView.addOnScrollListener(f16);
    }

    private final Pair<Integer, Integer> e() {
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        return new Pair<>(Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()), Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()));
    }

    private final C7687c f() {
        return new C7687c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String reason) {
        Set minus;
        Set minus2;
        Logger.f235387a.d().i("Guild.userl.VisibleAreaVideoController", 1, "playAnimation(" + reason + ")");
        Runnable runnable = this.delayPlayAnimationRunnable;
        if (runnable != null) {
            this.recyclerView.removeCallbacks(runnable);
            this.delayPlayAnimationRunnable = null;
        }
        Pair<Integer, Integer> e16 = e();
        int intValue = e16.component1().intValue();
        int intValue2 = e16.component2().intValue();
        if (intValue != -1 && intValue2 != -1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (intValue <= intValue2) {
                while (true) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(intValue);
                    if ((findViewHolderForAdapterPosition instanceof a) && linkedHashSet.size() < this.animationMaxCount) {
                        linkedHashSet.add(findViewHolderForAdapterPosition);
                    }
                    if (intValue == intValue2) {
                        break;
                    } else {
                        intValue++;
                    }
                }
            }
            minus = SetsKt___SetsKt.minus((Set) linkedHashSet, (Iterable) this.animatingSet);
            minus2 = SetsKt___SetsKt.minus((Set) this.animatingSet, (Iterable) linkedHashSet);
            Iterator it = minus2.iterator();
            while (it.hasNext()) {
                j((a) it.next());
            }
            Iterator it5 = minus.iterator();
            while (it5.hasNext()) {
                d((a) it5.next());
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.userl.VisibleAreaVideoController", 2, "playAnimation(" + reason + "), new animation: " + minus.size() + ", animating set: " + this.animatingSet.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h("delay first play");
    }

    public final void d(@NotNull a videoPlayable) {
        Intrinsics.checkNotNullParameter(videoPlayable, "videoPlayable");
        this.animatingSet.add(videoPlayable);
        GuildVideoPlayController b16 = this.playControllerPool.b();
        videoPlayable.j(b16);
        this.viewHolderAndPlayControllerMap.put(videoPlayable, b16);
    }

    public final void g() {
        Pair<Integer, Integer> e16 = e();
        int intValue = e16.component1().intValue();
        int intValue2 = e16.component2().intValue();
        if (intValue != -1 && intValue2 != -1) {
            h("first play");
        } else {
            if (this.delayPlayAnimationRunnable != null) {
                return;
            }
            RecyclerView recyclerView = this.recyclerView;
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.channelcard.videoplay.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.i(c.this);
                }
            };
            this.delayPlayAnimationRunnable = runnable;
            recyclerView.post(runnable);
        }
    }

    public final void j(@NotNull a viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.animatingSet.remove(viewHolder);
        GuildVideoPlayController remove = this.viewHolderAndPlayControllerMap.remove(viewHolder);
        if (remove != null) {
            remove.d();
            this.playControllerPool.c(remove);
        }
    }

    public final void k() {
        Iterator<a> it = this.animatingSet.iterator();
        while (it.hasNext()) {
            a next = it.next();
            it.remove();
            this.animatingSet.remove(next);
            GuildVideoPlayController remove = this.viewHolderAndPlayControllerMap.remove(next);
            if (remove != null) {
                remove.d();
                this.playControllerPool.c(remove);
            }
        }
        Logger.f235387a.d().i("Guild.userl.VisibleAreaVideoController", 1, "stopAnimation");
    }

    public /* synthetic */ c(GuildLivePlayerTag guildLivePlayerTag, RecyclerView recyclerView, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildLivePlayerTag, recyclerView, (i16 & 4) != 0 ? Integer.MAX_VALUE : i3);
    }
}
