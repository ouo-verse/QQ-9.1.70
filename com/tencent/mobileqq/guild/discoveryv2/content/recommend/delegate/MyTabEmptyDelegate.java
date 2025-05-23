package com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate;
import com.tencent.mobileqq.guild.discoveryv2.content.util.ContentMessage;
import com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildFragment;
import com.tencent.mobileqq.guild.discoveryv2.myguild.an;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.widget.GuildSmartRefreshLayout;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import java.util.List;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ca;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006H\u0014J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/MyTabEmptyDelegate;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/n;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/MyTabEmptyDelegate$ViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "holder", "", "payloads", "", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "d", "<init>", "()V", "ViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyTabEmptyDelegate extends AbsListItemAdapterDelegate<com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.n, com.tencent.mobileqq.guild.discoveryv2.content.base.h, ViewHolder> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/MyTabEmptyDelegate$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "E", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "l", "()Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "fragment", "Landroid/view/ViewGroup;", "v", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroid/view/ViewGroup;Landroidx/fragment/app/FragmentManager;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final MyGuildFragment fragment;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate$ViewHolder$1", f = "MyTabEmptyDelegate.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate$ViewHolder$1, reason: invalid class name */
        /* loaded from: classes13.dex */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/util/ContentMessage$ScrollToPositionMessage;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate$ViewHolder$1$1", f = "MyTabEmptyDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate$ViewHolder$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes13.dex */
            public static final class C77211 extends SuspendLambda implements Function2<ContentMessage.ScrollToPositionMessage, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ ViewHolder this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C77211(ViewHolder viewHolder, Continuation<? super C77211> continuation) {
                    super(2, continuation);
                    this.this$0 = viewHolder;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(ViewHolder viewHolder) {
                    RecyclerView recyclerView;
                    ca binding = viewHolder.getFragment().getBinding();
                    if (binding != null && (recyclerView = binding.f442664b) != null) {
                        recyclerView.scrollToPosition(0);
                    }
                    viewHolder.getFragment().di(0);
                    viewHolder.getFragment().Sh(new an(viewHolder.getFragment()));
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C77211(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull ContentMessage.ScrollToPositionMessage scrollToPositionMessage, @Nullable Continuation<? super Unit> continuation) {
                    return ((C77211) create(scrollToPositionMessage, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    RecyclerView recyclerView;
                    GuildSmartRefreshLayout guildSmartRefreshLayout;
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        ca binding = this.this$0.getFragment().getBinding();
                        if (binding != null && (guildSmartRefreshLayout = binding.f442666d) != null) {
                            guildSmartRefreshLayout.closeHeaderOrFooter();
                        }
                        ca binding2 = this.this$0.getFragment().getBinding();
                        if (binding2 != null && (recyclerView = binding2.f442664b) != null) {
                            final ViewHolder viewHolder = this.this$0;
                            Boxing.boxBoolean(recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.c
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MyTabEmptyDelegate.ViewHolder.AnonymousClass1.C77211.b(MyTabEmptyDelegate.ViewHolder.this);
                                }
                            }));
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
                    Flow onEach = FlowKt.onEach(FlowKt.callbackFlow(new MyTabEmptyDelegate$ViewHolder$1$invokeSuspend$$inlined$eventFlow$1(simpleEventBus, null)), new C77211(ViewHolder.this, null));
                    this.label = 1;
                    if (FlowKt.collect(onEach, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate$ViewHolder$2", f = "MyTabEmptyDelegate.kt", i = {0}, l = {128}, m = "invokeSuspend", n = {"cb"}, s = {"L$0"})
        /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate$ViewHolder$2, reason: invalid class name */
        /* loaded from: classes13.dex */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            int label;

            AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass2(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended;
                Function0<Unit> function0;
                Throwable th5;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function0 = (Function0) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th6) {
                        th5 = th6;
                        GuildThemeManager.j(new a(function0));
                        throw th5;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    final ViewHolder viewHolder = ViewHolder.this;
                    Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate$ViewHolder$2$cb$1
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
                            com.tencent.mobileqq.guild.theme.c.a(MyTabEmptyDelegate.ViewHolder.this.itemView);
                        }
                    };
                    try {
                        GuildThemeManager.g(new a(function02));
                        this.L$0 = function02;
                        this.label = 1;
                        if (DelayKt.awaitCancellation(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function0 = function02;
                    } catch (Throwable th7) {
                        function0 = function02;
                        th5 = th7;
                        GuildThemeManager.j(new a(function0));
                        throw th5;
                    }
                }
                throw new KotlinNothingValueException();
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ViewGroup v3, @NotNull FragmentManager fm5) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(fm5, "fm");
            MyGuildFragment myGuildFragment = new MyGuildFragment();
            Boolean bool = Boolean.TRUE;
            myGuildFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(IPCConst.KEY_HIDE_TITLE, bool), TuplesKt.to("inGuildTab", bool)));
            this.fragment = myGuildFragment;
            LifecycleOwnerKt.getLifecycleScope(myGuildFragment).launchWhenCreated(new AnonymousClass1(null));
            LifecycleOwnerKt.getLifecycleScope(myGuildFragment).launchWhenCreated(new AnonymousClass2(null));
            FragmentContainerView fragmentContainerView = new FragmentContainerView(v3.getContext());
            fragmentContainerView.setId(R.id.cks);
            fragmentContainerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            v3.addView(fragmentContainerView);
            fm5.beginTransaction().add(R.id.cks, myGuildFragment, "MyTabEmptyDelegate").commit();
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final MyGuildFragment getFragment() {
            return this.fragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a implements com.tencent.mobileqq.guild.theme.d, FunctionAdapter {

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ Function0 f217147d;

        a(Function0 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f217147d = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof com.tencent.mobileqq.guild.theme.d) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f217147d;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.tencent.mobileqq.guild.theme.d
        public final /* synthetic */ void onThemeChanged() {
            this.f217147d.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h item, @NotNull List<? extends com.tencent.mobileqq.guild.discoveryv2.content.base.h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.n item, @NotNull ViewHolder holder, int position, @NotNull List<? extends Object> payloads) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ViewGroup.LayoutParams layoutParams2 = holder.itemView.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NotNull final ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        final Context context = parent.getContext();
        FrameLayout frameLayout = new FrameLayout(parent, context) { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.MyTabEmptyDelegate$onCreateViewHolder$1

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private float initialY;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private float initialX;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata */
            private VelocityTracker mVelocityTracker;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata */
            private boolean horizontalScroll;

            /* renamed from: i, reason: collision with root package name and from kotlin metadata */
            private final int touchSlop;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ ViewGroup f217153m;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                this.f217153m = parent;
                StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(parent.getWidth(), parent.getHeight());
                layoutParams.setFullSpan(true);
                setLayoutParams(layoutParams);
                this.mVelocityTracker = VelocityTracker.obtain();
                this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 3;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
            
                if (r0 != 3) goto L25;
             */
            @Override // android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
                Intrinsics.checkNotNullParameter(ev5, "ev");
                int action = ev5.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            this.mVelocityTracker.addMovement(ev5);
                            this.mVelocityTracker.computeCurrentVelocity(1000);
                            float abs = Math.abs(ev5.getY() - this.initialY);
                            float abs2 = Math.abs(ev5.getX() - this.initialX);
                            float abs3 = Math.abs(this.mVelocityTracker.getXVelocity());
                            float abs4 = Math.abs(this.mVelocityTracker.getYVelocity());
                            int i3 = this.touchSlop;
                            if (abs < i3 && abs2 < i3) {
                                return super.dispatchTouchEvent(ev5);
                            }
                            if (abs >= abs2) {
                                this.horizontalScroll = true;
                            }
                            if (abs4 >= abs3) {
                                this.horizontalScroll = true;
                            }
                            this.f217153m.requestDisallowInterceptTouchEvent(this.horizontalScroll);
                        }
                    }
                    this.mVelocityTracker.recycle();
                    this.horizontalScroll = false;
                } else {
                    VelocityTracker obtain = VelocityTracker.obtain();
                    this.mVelocityTracker = obtain;
                    obtain.addMovement(ev5);
                    this.initialY = ev5.getY();
                    this.initialX = ev5.getX();
                    this.horizontalScroll = false;
                    this.f217153m.requestDisallowInterceptTouchEvent(true);
                }
                return super.dispatchTouchEvent(ev5);
            }
        };
        FragmentManager childFragmentManager = FragmentManager.findFragment(parent).getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "findFragment<Fragment>(p\u2026ent).childFragmentManager");
        return new ViewHolder(frameLayout, childFragmentManager);
    }
}
