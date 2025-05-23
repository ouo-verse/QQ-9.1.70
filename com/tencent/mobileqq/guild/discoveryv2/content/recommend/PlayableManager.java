package com.tencent.mobileqq.guild.discoveryv2.content.recommend;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$lifecycleObserver$2;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$scrollerListener$2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fR$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0012j\b\u0012\u0004\u0012\u00020\u0002`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010'R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/PlayableManager;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/c;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/b;", "playable", "", "a", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "p", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "j", "", "delayMillis", DomainData.DOMAIN_NAME, "Ljava/util/Comparator;", "Lkotlin/Comparator;", "Ljava/util/Comparator;", "mTaskComparator", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", HippyControllerProps.ARRAY, "Ljava/util/PriorityQueue;", "c", "Lkotlin/Lazy;", "i", "()Ljava/util/PriorityQueue;", "_tempPriorityQueue", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "d", h.F, "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "scrollerListener", "Landroidx/lifecycle/LifecycleEventObserver;", "e", "g", "()Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleObserver", "f", "Landroidx/lifecycle/Lifecycle;", "", "I", HippyTKDListViewAdapter.SCROLL_STATE, "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PlayableManager implements com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Comparator<com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b> mTaskComparator = new Comparator() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int k3;
            k3 = PlayableManager.k((com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b) obj, (com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b) obj2);
            return k3;
        }
    };

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b> array = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy _tempPriorityQueue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scrollerListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy lifecycleObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Lifecycle lifecycle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int scrollState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    public PlayableManager() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PriorityQueue<com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b>>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$_tempPriorityQueue$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PriorityQueue<com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b> invoke() {
                Comparator comparator;
                comparator = PlayableManager.this.mTaskComparator;
                return new PriorityQueue<>(5, comparator);
            }
        });
        this._tempPriorityQueue = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PlayableManager$scrollerListener$2.a>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$scrollerListener$2

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/PlayableManager$scrollerListener$2$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends RecyclerView.OnScrollListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ PlayableManager f217095d;

                a(PlayableManager playableManager) {
                    this.f217095d = playableManager;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    this.f217095d.scrollState = newState;
                    if (newState == 0) {
                        PlayableManager.o(this.f217095d, 0L, 1, null);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(PlayableManager.this);
            }
        });
        this.scrollerListener = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<PlayableManager$lifecycleObserver$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$lifecycleObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$lifecycleObserver$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final PlayableManager playableManager = PlayableManager.this;
                return new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$lifecycleObserver$2.1

                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.PlayableManager$lifecycleObserver$2$1$a */
                    /* loaded from: classes13.dex */
                    public /* synthetic */ class a {

                        /* renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f217094a;

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
                            f217094a = iArr;
                        }
                    }

                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                        Intrinsics.checkNotNullParameter(source, "source");
                        Intrinsics.checkNotNullParameter(event, "event");
                        int i3 = a.f217094a[event.ordinal()];
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    PlayableManager.this.p();
                                    return;
                                }
                                return;
                            }
                            PlayableManager.this.l();
                            return;
                        }
                        PlayableManager.o(PlayableManager.this, 0L, 1, null);
                    }
                };
            }
        });
        this.lifecycleObserver = lazy3;
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final PriorityQueue<com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b> i() {
        return (PriorityQueue) this._tempPriorityQueue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b bVar, com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b bVar2) {
        return bVar.i() - bVar2.i();
    }

    public static /* synthetic */ void o(PlayableManager playableManager, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        playableManager.n(j3);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.c
    public void a(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b playable) {
        Intrinsics.checkNotNullParameter(playable, "playable");
        if (this.array.contains(playable)) {
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("PlayableManager", 1, "add playable already exist " + playable);
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger2.d().d("PlayableManager", 1, "add playable " + playable);
        }
        this.array.add(playable);
        n(100L);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.c
    public void b(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b playable) {
        Intrinsics.checkNotNullParameter(playable, "playable");
        playable.a();
        this.array.remove(playable);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("PlayableManager", 1, "remove playable " + playable);
        }
    }

    @NotNull
    public final LifecycleEventObserver g() {
        return (LifecycleEventObserver) this.lifecycleObserver.getValue();
    }

    @NotNull
    public final RecyclerView.OnScrollListener h() {
        return (RecyclerView.OnScrollListener) this.scrollerListener.getValue();
    }

    public final void j(@NotNull Lifecycle lifecycle, @NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.lifecycle = lifecycle;
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getMain(), null, new PlayableManager$install$1(lifecycle, this, recyclerView, null), 2, null);
    }

    public final void l() {
        Iterator<T> it = this.array.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b) it.next()).a();
        }
    }

    public final void m() {
        Lifecycle.State state;
        Map mutableMap;
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b poll;
        int i3;
        String str;
        if (!VasUtil.getService().getKingCardManager().isKingCard() && !AppNetConnInfo.isWifiConn()) {
            Logger.f235387a.d().i("PlayableManager", 1, "skip play not wifi and not kingCard");
            return;
        }
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            state = lifecycle.getCurrentState();
        } else {
            state = null;
        }
        if (state != null && state.isAtLeast(Lifecycle.State.RESUMED)) {
            if (this.scrollState != 0) {
                Logger.f235387a.d().i("PlayableManager", 1, "skip play scrollState " + this.scrollState);
                return;
            }
            a aVar = a.f217096d;
            int b16 = aVar.b();
            mutableMap = MapsKt__MapsKt.toMutableMap(aVar.a());
            Logger.f235387a.d().i("PlayableManager", 1, "play totalCount:" + b16 + " typeCount:" + mutableMap);
            PriorityQueue<com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b> i16 = i();
            i16.addAll(this.array);
            while (!i16.isEmpty() && (poll = i16.poll()) != null) {
                poll.l();
                if (b16 <= 0) {
                    Logger.f235387a.d().i("PlayableManager", 1, "skip play TotalCount Limit type:" + poll.getType() + " priority:" + poll.i());
                    poll.a();
                } else {
                    Integer num = (Integer) mutableMap.get(poll.getType());
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        i3 = 0;
                    }
                    if (i3 <= 0) {
                        Logger.f235387a.d().i("PlayableManager", 1, "skip play TypeCount Limit type:" + poll.getType() + " priority:" + poll.i());
                        poll.a();
                    } else {
                        boolean n3 = poll.n();
                        if (n3) {
                            b16--;
                            String type = poll.getType();
                            Object obj = mutableMap.get(poll.getType());
                            Intrinsics.checkNotNull(obj);
                            mutableMap.put(type, Integer.valueOf(((Number) obj).intValue() - 1));
                        } else {
                            poll.a();
                        }
                        Logger.a d16 = Logger.f235387a.d();
                        if (n3) {
                            str = "Success";
                        } else {
                            str = "Failure";
                        }
                        d16.i("PlayableManager", 1, "tryPlay " + str + " type:" + poll.getType() + " priority:" + poll.i() + " totalCount:" + b16 + " typeCount:" + mutableMap);
                    }
                }
            }
            i16.clear();
            return;
        }
        Logger.f235387a.d().i("PlayableManager", 1, "skip play lifecycle " + state);
    }

    public final void n(long delayMillis) {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.c
            @Override // java.lang.Runnable
            public final void run() {
                PlayableManager.this.m();
            }
        }, delayMillis);
    }

    public final void p() {
        Iterator<T> it = this.array.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b) it.next()).a();
        }
        this.array.clear();
    }
}
