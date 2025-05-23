package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.discoveryv2.util.ExtKt;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event.FeedContentScrollEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0002R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR<\u0010!\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001d0\u001cj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001d`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R-\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001d0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010%R&\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001d0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010(R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedVideoPlayManager;", "", "", "j", "", "delayMillis", "k", "", "index", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "playable", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", NodeProps.VISIBLE, "i", h.F, "", "a", "Ljava/lang/String;", "TAG", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "c", "Ljava/lang/Integer;", "state", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Lkotlin/Comparator;", "d", "Ljava/util/Comparator;", "mTaskComparator", "Ljava/util/PriorityQueue;", "Lkotlin/Lazy;", "f", "()Ljava/util/PriorityQueue;", "_tempPriorityQueue", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", HippyControllerProps.ARRAY, "g", "Z", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedVideoPlayManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Comparator<Pair<Integer, LongFeedVideoView>> mTaskComparator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy _tempPriorityQueue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<Pair<Integer, LongFeedVideoView>> array;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/event/FeedContentScrollEvent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedVideoPlayManager$1", f = "LongFeedVideoPlayManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedVideoPlayManager$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FeedContentScrollEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull FeedContentScrollEvent feedContentScrollEvent, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(feedContentScrollEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FeedContentScrollEvent feedContentScrollEvent = (FeedContentScrollEvent) this.L$0;
                LongFeedVideoPlayManager.this.state = Boxing.boxInt(feedContentScrollEvent.getNewState());
                LongFeedVideoPlayManager.l(LongFeedVideoPlayManager.this, 0L, 1, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LongFeedVideoPlayManager(@NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.TAG = "LongFeedVideoPlayManage";
        this.handler = new Handler(Looper.getMainLooper());
        this.state = 0;
        this.mTaskComparator = new Comparator() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int g16;
                g16 = LongFeedVideoPlayManager.g((Pair) obj, (Pair) obj2);
                return g16;
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PriorityQueue<Pair<? extends Integer, ? extends LongFeedVideoView>>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedVideoPlayManager$_tempPriorityQueue$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PriorityQueue<Pair<? extends Integer, ? extends LongFeedVideoView>> invoke() {
                Comparator comparator;
                comparator = LongFeedVideoPlayManager.this.mTaskComparator;
                return new PriorityQueue<>(5, comparator);
            }
        });
        this._tempPriorityQueue = lazy;
        this.array = new LinkedList<>();
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new LongFeedVideoPlayManager$special$$inlined$eventFlow$1(simpleEventBus, null)), new AnonymousClass1(null)), LifecycleOwnerKt.getLifecycleScope(lifecycleOwner));
    }

    private final PriorityQueue<Pair<Integer, LongFeedVideoView>> f() {
        return (PriorityQueue) this._tempPriorityQueue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(Pair pair, Pair pair2) {
        return ((Number) pair.getFirst()).intValue() - ((Number) pair2.getFirst()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        LongFeedVideoView longFeedVideoView;
        Integer num = this.state;
        if (num == null || num.intValue() != 0 || !this.visible) {
            return;
        }
        PriorityQueue<Pair<Integer, LongFeedVideoView>> f16 = f();
        f16.addAll(this.array);
        Pair<Integer, LongFeedVideoView> poll = f16.poll();
        LongFeedVideoView longFeedVideoView2 = null;
        if (poll != null) {
            longFeedVideoView = poll.getSecond();
        } else {
            longFeedVideoView = null;
        }
        Pair<Integer, LongFeedVideoView> poll2 = f16.poll();
        if (poll2 != null) {
            longFeedVideoView2 = poll2.getSecond();
        }
        if ((longFeedVideoView == null || ExtKt.c(longFeedVideoView) < 1.0d) && ((longFeedVideoView2 != null && ExtKt.c(longFeedVideoView2) >= 1.0d) || (longFeedVideoView2 != null && longFeedVideoView != null && ExtKt.c(longFeedVideoView2) > ExtKt.c(longFeedVideoView)))) {
            longFeedVideoView = longFeedVideoView2;
        }
        Iterator<T> it = this.array.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!Intrinsics.areEqual(pair.getSecond(), longFeedVideoView)) {
                ((LongFeedVideoView) pair.getSecond()).pause();
            } else {
                QLog.i(this.TAG, 1, "playFirstVideoIfIdle " + pair.getFirst());
                ((LongFeedVideoView) pair.getSecond()).play();
            }
        }
        f().clear();
    }

    private final void k(long delayMillis) {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.e
            @Override // java.lang.Runnable
            public final void run() {
                LongFeedVideoPlayManager.this.j();
            }
        }, delayMillis);
    }

    static /* synthetic */ void l(LongFeedVideoPlayManager longFeedVideoPlayManager, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 50;
        }
        longFeedVideoPlayManager.k(j3);
    }

    public final void e(int index, @NotNull LongFeedVideoView playable) {
        Intrinsics.checkNotNullParameter(playable, "playable");
        QLog.i(this.TAG, 1, "add: " + index + " " + playable.hashCode());
        this.array.add(new Pair<>(Integer.valueOf(index), playable));
        l(this, 0L, 1, null);
    }

    public final void h() {
        QLog.i(this.TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.handler.removeCallbacksAndMessages(null);
        Iterator<T> it = this.array.iterator();
        while (it.hasNext()) {
            ((LongFeedVideoView) ((Pair) it.next()).getSecond()).a();
        }
        this.array.clear();
    }

    public final void i(boolean visible) {
        QLog.i(this.TAG, 1, "onVisibleChanged " + visible);
        this.visible = visible;
        if (visible) {
            l(this, 0L, 1, null);
            return;
        }
        this.handler.removeCallbacksAndMessages(null);
        Iterator<T> it = this.array.iterator();
        while (it.hasNext()) {
            ((LongFeedVideoView) ((Pair) it.next()).getSecond()).pause();
        }
    }

    public final void m(int index, @NotNull LongFeedVideoView playable) {
        Intrinsics.checkNotNullParameter(playable, "playable");
        QLog.i(this.TAG, 1, "remove: " + index + " " + playable.hashCode());
        this.array.remove(new Pair(Integer.valueOf(index), playable));
        playable.pause();
        l(this, 0L, 1, null);
    }
}
