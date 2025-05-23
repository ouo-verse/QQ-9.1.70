package com.tencent.mobileqq.activity.home.chats.biz.guild;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mobileqq.guild.widget.adapterdelegates.Debug;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002I&B\t\b\u0002\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0016\u0010\u001a\u001a\u00020\u0004*\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002J/\u0010\u001f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u001b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00018\u0000H\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020$H\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001d0\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d0\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00108\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010;\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R\u001b\u0010?\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010'R\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010E\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildSlideCoordinator;", "", "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/b;", "viewModel", "", HippyTKDListViewAdapter.X, "Laf1/a;", "event", "", "y", "r", ReportConstant.COSTREPORT_PREFIX, "", "o", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "progressAware", "k", "v", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$e;", "visibleAware", "l", "Landroid/animation/ValueAnimator;", "", "initialDuration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "T", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "ref", "w", "(Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/lang/Object;)V", NodeProps.VISIBLE, "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildSlideCoordinator$b;", "u", "Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildSlideCoordinator$a;", "t", "b", "Lmqq/util/WeakReference;", "c", UserInfo.SEX_FEMALE, "progress", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "progressAwares", "e", "visibleAwares", "Lhe0/a;", "f", "Lhe0/a;", "slideShowInterpolator", "g", "Lkotlin/Lazy;", "getVisibleNotifier", "()Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildSlideCoordinator$b;", "visibleNotifier", h.F, "p", "invisibleNotifier", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildSlideCoordinator$a;", "progressNotifier", "j", "Landroid/animation/ValueAnimator;", "animation", "showGuildAnimator", "", "I", "deviceLevel", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GuildSlideCoordinator {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static float progress;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy visibleNotifier;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy invisibleNotifier;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy progressNotifier;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ValueAnimator animation;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static WeakReference<ValueAnimator> showGuildAnimator;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static int deviceLevel;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildSlideCoordinator f182927a = new GuildSlideCoordinator();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static WeakReference<com.tencent.mobileqq.activity.home.chats.biz.guild.b> viewModel = new WeakReference<>(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<WeakReference<IGuildLayoutApi.d>> progressAwares = new CopyOnWriteArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<WeakReference<IGuildLayoutApi.e>> visibleAwares = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static he0.a slideShowInterpolator = new he0.a(0.25f, 0.47f, 0.55f, 0.99f);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildSlideCoordinator$a;", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "Landroid/animation/ValueAnimator;", "onAnimationUpdate", "onAnimationEnd", "onAnimationCancel", "", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "d", "Ljava/util/List;", "awares", "e", "updatenotifiables", "<init>", "(Ljava/util/List;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<WeakReference<IGuildLayoutApi.d>> awares;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<? extends IGuildLayoutApi.d> updatenotifiables;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull List<? extends WeakReference<IGuildLayoutApi.d>> awares) {
            List<? extends IGuildLayoutApi.d> emptyList;
            Intrinsics.checkNotNullParameter(awares, "awares");
            this.awares = awares;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.updatenotifiables = emptyList;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            List<? extends IGuildLayoutApi.d> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.updatenotifiables = emptyList;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            List<? extends IGuildLayoutApi.d> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.updatenotifiables = emptyList;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            List<WeakReference<IGuildLayoutApi.d>> list = this.awares;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                IGuildLayoutApi.d dVar = (IGuildLayoutApi.d) ((WeakReference) it.next()).get();
                if (dVar != null) {
                    arrayList.add(dVar);
                }
            }
            this.updatenotifiables = arrayList;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            GuildSlideCoordinator guildSlideCoordinator = GuildSlideCoordinator.f182927a;
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            GuildSlideCoordinator.progress = ((Float) animatedValue).floatValue();
            for (IGuildLayoutApi.d dVar : this.updatenotifiables) {
                long nanoTime = System.nanoTime();
                dVar.J(GuildSlideCoordinator.progress);
                long nanoTime2 = System.nanoTime() - nanoTime;
                if (Debug.ENABLE_DEBUG) {
                    Debug.c(Debug.Type.GUILD_SLIDE_ANIMATION_DISPATCH, dVar, nanoTime2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/guild/GuildSlideCoordinator$b;", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "", "d", "Z", NodeProps.VISIBLE, "", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$e;", "e", "Ljava/util/List;", "awares", "<init>", "(ZLjava/util/List;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean visible;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<WeakReference<IGuildLayoutApi.e>> awares;

        /* JADX WARN: Multi-variable type inference failed */
        public b(boolean z16, @NotNull List<? extends WeakReference<IGuildLayoutApi.e>> awares) {
            Intrinsics.checkNotNullParameter(awares, "awares");
            this.visible = z16;
            this.awares = awares;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            TraceUtils traceUtils = TraceUtils.f235403a;
            String str = "Guild.MainUi.Conversation.GuildFrameAnimShowEnd.visible=" + this.visible;
            if (!TraceUtils.m()) {
                traceUtils.l();
                List list = this.awares;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    IGuildLayoutApi.e eVar = (IGuildLayoutApi.e) ((WeakReference) it.next()).get();
                    if (eVar != null) {
                        arrayList.add(eVar);
                    }
                }
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    ((IGuildLayoutApi.e) it5.next()).onVisibleChanged(this.visible);
                }
                com.tencent.mobileqq.activity.home.chats.biz.guild.b bVar = (com.tencent.mobileqq.activity.home.chats.biz.guild.b) GuildSlideCoordinator.viewModel.get();
                if (bVar != null) {
                    bVar.O1(this.visible);
                    return;
                }
                return;
            }
            try {
                cy.c(str);
                List list2 = this.awares;
                ArrayList arrayList2 = new ArrayList();
                Iterator it6 = list2.iterator();
                while (it6.hasNext()) {
                    IGuildLayoutApi.e eVar2 = (IGuildLayoutApi.e) ((WeakReference) it6.next()).get();
                    if (eVar2 != null) {
                        arrayList2.add(eVar2);
                    }
                }
                Iterator it7 = arrayList2.iterator();
                while (it7.hasNext()) {
                    ((IGuildLayoutApi.e) it7.next()).onVisibleChanged(this.visible);
                }
                com.tencent.mobileqq.activity.home.chats.biz.guild.b bVar2 = (com.tencent.mobileqq.activity.home.chats.biz.guild.b) GuildSlideCoordinator.viewModel.get();
                if (bVar2 != null) {
                    bVar2.O1(this.visible);
                    Unit unit = Unit.INSTANCE;
                }
            } finally {
                cy.d();
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<b>() { // from class: com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator$visibleNotifier$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSlideCoordinator.b invoke() {
                GuildSlideCoordinator.b u16;
                u16 = GuildSlideCoordinator.f182927a.u(true);
                return u16;
            }
        });
        visibleNotifier = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<b>() { // from class: com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator$invisibleNotifier$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSlideCoordinator.b invoke() {
                GuildSlideCoordinator.b u16;
                u16 = GuildSlideCoordinator.f182927a.u(false);
                return u16;
            }
        });
        invisibleNotifier = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<a>() { // from class: com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator$progressNotifier$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSlideCoordinator.a invoke() {
                GuildSlideCoordinator.a t16;
                t16 = GuildSlideCoordinator.f182927a.t();
                return t16;
            }
        });
        progressNotifier = lazy3;
        showGuildAnimator = new WeakReference<>(null);
        deviceLevel = 3;
    }

    GuildSlideCoordinator() {
    }

    @JvmStatic
    public static final void k(@NotNull IGuildLayoutApi.d progressAware) {
        Intrinsics.checkNotNullParameter(progressAware, "progressAware");
        progressAwares.addIfAbsent(new WeakReference<>(progressAware));
        f182927a.w(progressAwares, null);
    }

    @JvmStatic
    public static final void l(@NotNull IGuildLayoutApi.e visibleAware) {
        Intrinsics.checkNotNullParameter(visibleAware, "visibleAware");
        visibleAwares.addIfAbsent(new WeakReference<>(visibleAware));
        f182927a.w(visibleAwares, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(ValueAnimator valueAnimator, long j3) {
        valueAnimator.setDuration(Math.max(j3, 100L));
        valueAnimator.addUpdateListener(q());
        valueAnimator.addListener(q());
    }

    @JvmStatic
    public static final float n() {
        return progress;
    }

    @JvmStatic
    @NotNull
    public static final String o() {
        LiveData<ef1.a<String>> L1;
        ef1.a<String> value;
        String a16;
        com.tencent.mobileqq.activity.home.chats.biz.guild.b bVar = viewModel.get();
        if (bVar == null || (L1 = bVar.L1()) == null || (value = L1.getValue()) == null || (a16 = value.a()) == null) {
            return "";
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b p() {
        return (b) invisibleNotifier.getValue();
    }

    private final a q() {
        return (a) progressNotifier.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void r() {
        Logger.f235387a.d().i("GuildSlideCoordinator", 1, "hideGuildFrameLayout currentGuild=" + o());
        TraceUtils traceUtils = TraceUtils.f235403a;
        if (!TraceUtils.m()) {
            traceUtils.l();
            ValueAnimator valueAnimator = animation;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator hideGuildFrameLayout$lambda$10$lambda$8 = ValueAnimator.ofFloat(progress, 0.0f);
            GuildSlideCoordinator guildSlideCoordinator = f182927a;
            Intrinsics.checkNotNullExpressionValue(hideGuildFrameLayout$lambda$10$lambda$8, "hideGuildFrameLayout$lambda$10$lambda$8");
            guildSlideCoordinator.m(hideGuildFrameLayout$lambda$10$lambda$8, Math.abs((progress - 0.0f) / 100.0f) * ((float) 300));
            hideGuildFrameLayout$lambda$10$lambda$8.addListener(guildSlideCoordinator.p());
            hideGuildFrameLayout$lambda$10$lambda$8.setInterpolator(slideShowInterpolator);
            animation = hideGuildFrameLayout$lambda$10$lambda$8;
            hideGuildFrameLayout$lambda$10$lambda$8.start();
            com.tencent.mobileqq.activity.home.chats.biz.guild.b bVar = (com.tencent.mobileqq.activity.home.chats.biz.guild.b) viewModel.get();
            if (bVar != null) {
                bVar.P1(false);
                bVar.Q1("");
                bVar.R1(IGuildLayoutApi.GuildState.INSTANCE.a());
                return;
            }
            return;
        }
        try {
            cy.c("Guild.MainUi.Conversation.GuildFrameAnimShowStart.hide");
            ValueAnimator valueAnimator2 = animation;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            ValueAnimator hideGuildFrameLayout$lambda$10$lambda$82 = ValueAnimator.ofFloat(progress, 0.0f);
            GuildSlideCoordinator guildSlideCoordinator2 = f182927a;
            Intrinsics.checkNotNullExpressionValue(hideGuildFrameLayout$lambda$10$lambda$82, "hideGuildFrameLayout$lambda$10$lambda$8");
            guildSlideCoordinator2.m(hideGuildFrameLayout$lambda$10$lambda$82, Math.abs((progress - 0.0f) / 100.0f) * ((float) 300));
            hideGuildFrameLayout$lambda$10$lambda$82.addListener(guildSlideCoordinator2.p());
            hideGuildFrameLayout$lambda$10$lambda$82.setInterpolator(slideShowInterpolator);
            animation = hideGuildFrameLayout$lambda$10$lambda$82;
            hideGuildFrameLayout$lambda$10$lambda$82.start();
            com.tencent.mobileqq.activity.home.chats.biz.guild.b bVar2 = (com.tencent.mobileqq.activity.home.chats.biz.guild.b) viewModel.get();
            if (bVar2 != null) {
                bVar2.P1(false);
                bVar2.Q1("");
                bVar2.R1(IGuildLayoutApi.GuildState.INSTANCE.a());
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            cy.d();
        }
    }

    @JvmStatic
    public static final boolean s() {
        LiveData<ef1.a<Boolean>> N1;
        ef1.a<Boolean> value;
        com.tencent.mobileqq.activity.home.chats.biz.guild.b bVar = viewModel.get();
        if (bVar != null && (N1 = bVar.N1()) != null && (value = N1.getValue()) != null) {
            return value.a().booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a t() {
        return new a(progressAwares);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b u(boolean visible) {
        return new b(visible, visibleAwares);
    }

    @JvmStatic
    public static final void v(@NotNull IGuildLayoutApi.d progressAware) {
        Intrinsics.checkNotNullParameter(progressAware, "progressAware");
        f182927a.w(progressAwares, progressAware);
    }

    private final <T> void w(CopyOnWriteArrayList<WeakReference<T>> copyOnWriteArrayList, T t16) {
        boolean z16 = false;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(((WeakReference) it.next()).get(), t16)) {
                        z16 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z16) {
            HashSet hashSet = new HashSet();
            for (T t17 : copyOnWriteArrayList) {
                if (Intrinsics.areEqual(((WeakReference) t17).get(), t16)) {
                    hashSet.add(t17);
                }
            }
            copyOnWriteArrayList.removeAll(hashSet);
        }
    }

    @JvmStatic
    public static final void x(@NotNull com.tencent.mobileqq.activity.home.chats.biz.guild.b viewModel2) {
        Intrinsics.checkNotNullParameter(viewModel2, "viewModel");
        viewModel = new WeakReference<>(viewModel2);
    }

    @JvmStatic
    public static final boolean y(@NotNull af1.a event) {
        Unit unit;
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.mobileqq.activity.home.chats.biz.guild.b bVar = viewModel.get();
        if (bVar != null) {
            bVar.S1(event);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit != null) {
            return true;
        }
        return false;
    }
}
