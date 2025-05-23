package com.tencent.mobileqq.guild.aisearch.parts;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.AIChatListViewModel;
import com.tencent.mobileqq.guild.aisearch.models.AISearchRecommendRepository;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.i;
import com.tencent.mobileqq.guild.aisearch.z;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.base.extension.t;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.util.InputMethodUtil;
import ef1.c;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/parts/EmptyPagePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/aisearch/models/AISearchRecommendRepository$RecommendItem$RecommendWord;", "recommendWord", "", "H9", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/aisearch/parts/a;", "e", "Lcom/tencent/mobileqq/guild/aisearch/parts/a;", "adapter", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "f", "Lkotlin/Lazy;", "D9", "()Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "aiChatListViewModel", "<init>", "()V", h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class EmptyPagePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiChatListViewModel;

    public EmptyPagePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIChatListViewModel>() { // from class: com.tencent.mobileqq.guild.aisearch.parts.EmptyPagePart$aiChatListViewModel$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes12.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f214208a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f214208a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new AIChatListViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIChatListViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                Fragment hostFragment = EmptyPagePart.this.getHostFragment();
                Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                ViewModel viewModel = new ViewModelProvider(hostFragment, new a(hostFragment)).get(AIChatListViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (AIChatListViewModel) viewModel;
            }
        });
        this.aiChatListViewModel = lazy;
    }

    private final AIChatListViewModel D9() {
        return (AIChatListViewModel) this.aiChatListViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9() {
        Logger.f235387a.d().d("EmptyPagePart", 1, "[loadRecommendWords] load recommend words");
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenStarted(new EmptyPagePart$loadRecommendWords$2(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(View rootView, z zVar) {
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        View findViewById = rootView.findViewById(R.id.bwb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<View>(R.id.empty_container)");
        findViewById.setVisibility(8);
        zVar.f8("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G9(View v3, MotionEvent motionEvent) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        boolean d16 = t.d(v3);
        Logger.a d17 = Logger.f235387a.d();
        String a16 = m.a(v3);
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(v3.getResources().getResourceEntryName(v3.getId()));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = "unknown(" + v3.getId() + ')';
        }
        d17.d("EmptyPagePart", 1, "[onTouch] imeVisible(" + d16 + ") " + a16 + " " + ((String) m476constructorimpl) + " event: " + motionEvent);
        if (d16) {
            InputMethodUtil.hide(v3);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(AISearchRecommendRepository.RecommendItem.RecommendWord recommendWord) {
        Logger.f235387a.d().d("EmptyPagePart", 1, "[onRecommendClick] recommendWord: " + recommendWord);
        AiChatSession value = D9().Q1().getValue();
        if (value != null && !(value.getSessionState() instanceof i.c)) {
            Logger.b bVar = new Logger.b();
            String str = "[onRecommendClick] sessionState: " + value.getSessionState() + " ignore";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("EmptyPagePart", 1, (String) it.next(), null);
            }
            return;
        }
        AISearchRecommendRepository.f214105d.e(recommendWord);
        broadcastMessage("input_part_send_message", recommendWord.getContent());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull final View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f165093uv1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.empty_view_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        a aVar = new a(new EmptyPagePart$onInitView$2(this));
        this.adapter = aVar;
        recyclerView3.setAdapter(aVar);
        a aVar2 = this.adapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar2 = null;
        }
        aVar2.setItems(RecommendsSnapShot.f214217a.b());
        IocPromise ioc = RFWIocAbilityProvider.g().getIoc(z.class);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        ioc.originView(recyclerView4).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.aisearch.parts.b
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                EmptyPagePart.F9(rootView, (z) obj);
            }
        }).run();
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        recyclerView5.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.aisearch.parts.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean G9;
                G9 = EmptyPagePart.G9(view, motionEvent);
                return G9;
            }
        });
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView6 = null;
        }
        recyclerView6.addOnItemTouchListener(new b());
        Flow onEach = FlowKt.onEach(FlowKt.filterNotNull(D9().Q1()), new EmptyPagePart$onInitView$7(this, null));
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(hostFragment));
        E9();
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/aisearch/parts/EmptyPagePart$b", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "v", "Landroid/view/MotionEvent;", "event", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "p0", "p1", "", "onTouchEvent", "onRequestDisallowInterceptTouchEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements RecyclerView.OnItemTouchListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NotNull RecyclerView v3, @NotNull MotionEvent event) {
            Object m476constructorimpl;
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            boolean d16 = t.d(v3);
            Logger.a d17 = Logger.f235387a.d();
            String a16 = m.a(v3);
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(v3.getResources().getResourceEntryName(v3.getId()));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                m476constructorimpl = "unknown(" + v3.getId() + ')';
            }
            d17.d("EmptyPagePart", 1, "[onInterceptTouchEvent] imeVisible(" + d16 + ") " + a16 + " " + ((String) m476constructorimpl) + " event: " + event);
            if (d16) {
                InputMethodUtil.hide(v3);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NotNull RecyclerView p06, @NotNull MotionEvent p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean p06) {
        }
    }
}
