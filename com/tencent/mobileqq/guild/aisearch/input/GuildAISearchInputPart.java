package com.tencent.mobileqq.guild.aisearch.input;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.AIChatListViewModel;
import com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputView;
import com.tencent.mobileqq.guild.aisearch.input.f;
import com.tencent.mobileqq.guild.aisearch.x;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.config.GuildAISearchModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015`\u0016H\u0016J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputPart;", "Lcom/tencent/mobileqq/guild/aisearch/x;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "onBackEvent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView;", "d", "Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView;", "searchInputView", "Lcom/tencent/mobileqq/guild/aisearch/input/f;", "e", "Lcom/tencent/mobileqq/guild/aisearch/input/f;", "keyboardHelper", "f", "Z", "isClosed", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", tl.h.F, "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "aiChatListViewModel", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildAISearchInputPart extends x implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildAISearchInputView searchInputView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f keyboardHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isClosed;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy aiChatListViewModel;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputPart$b", "Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputView$b;", "", "searchText", "modelType", "modelTitle", "modelDesc", "shareInfo", "", "showSpeed", "", "a", "Landroid/view/KeyEvent;", "event", "", "onKeyEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements GuildAISearchInputView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputView.b
        public void a(@NotNull String searchText, @NotNull String modelType, @NotNull String modelTitle, @NotNull String modelDesc, @NotNull String shareInfo, int showSpeed) {
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            Intrinsics.checkNotNullParameter(modelType, "modelType");
            Intrinsics.checkNotNullParameter(modelTitle, "modelTitle");
            Intrinsics.checkNotNullParameter(modelDesc, "modelDesc");
            Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
            GuildAISearchInputView guildAISearchInputView = GuildAISearchInputPart.this.searchInputView;
            GuildAISearchInputView guildAISearchInputView2 = null;
            if (guildAISearchInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
                guildAISearchInputView = null;
            }
            guildAISearchInputView.p();
            GuildAISearchInputView guildAISearchInputView3 = GuildAISearchInputPart.this.searchInputView;
            if (guildAISearchInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
            } else {
                guildAISearchInputView2 = guildAISearchInputView3;
            }
            guildAISearchInputView2.setVisibility(8);
            SimpleEventBus.getInstance().dispatchEvent(new GuildAISearchInputSendEvent(searchText, new GuildAISearchModel(modelType, modelTitle, modelDesc, shareInfo, showSpeed, null, 32, null)));
        }

        @Override // com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputView.b
        public boolean onKeyEvent(@NotNull KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getKeyCode() == 4) {
                GuildAISearchInputView guildAISearchInputView = GuildAISearchInputPart.this.searchInputView;
                if (guildAISearchInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
                    guildAISearchInputView = null;
                }
                guildAISearchInputView.p();
                GuildAISearchInputPart.this.getActivity().finish();
                GuildAISearchInputPart.this.getActivity().overridePendingTransition(0, R.anim.f154576nj);
                return true;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputPart$c", "Lcom/tencent/mobileqq/guild/aisearch/input/f$b;", "", "keyboardHeight", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements f.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.aisearch.input.f.b
        public void a(int keyboardHeight) {
            if (!GuildAISearchInputPart.this.isClosed) {
                GuildAISearchInputView guildAISearchInputView = GuildAISearchInputPart.this.searchInputView;
                if (guildAISearchInputView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
                    guildAISearchInputView = null;
                }
                guildAISearchInputView.E(keyboardHeight);
            }
        }
    }

    public GuildAISearchInputPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIChatListViewModel>() { // from class: com.tencent.mobileqq.guild.aisearch.input.GuildAISearchInputPart$aiChatListViewModel$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes12.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f214026a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f214026a = viewModelStoreOwner;
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
                Fragment hostFragment = GuildAISearchInputPart.this.getHostFragment();
                Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                ViewModel viewModel = new ViewModelProvider(hostFragment, new a(hostFragment)).get(AIChatListViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (AIChatListViewModel) viewModel;
            }
        });
        this.aiChatListViewModel = lazy;
    }

    private final AIChatListViewModel A9() {
        return (AIChatListViewModel) this.aiChatListViewModel.getValue();
    }

    private final void B9() {
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        f fVar = new f(rootView, new c());
        this.keyboardHelper = fVar;
        fVar.j();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildAISearchInputCloseEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@NotNull String action, @Nullable Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, "input_part_send_message") && (args instanceof String)) {
            GuildAISearchInputView guildAISearchInputView = this.searchInputView;
            if (guildAISearchInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
                guildAISearchInputView = null;
            }
            guildAISearchInputView.B((String) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        GuildAISearchInputView guildAISearchInputView = this.searchInputView;
        if (guildAISearchInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
            guildAISearchInputView = null;
        }
        guildAISearchInputView.p();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f165420vx0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ild_ai_search_input_view)");
        GuildAISearchInputView guildAISearchInputView = (GuildAISearchInputView) findViewById;
        this.searchInputView = guildAISearchInputView;
        if (guildAISearchInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
            guildAISearchInputView = null;
        }
        guildAISearchInputView.setInputViewListener(new b());
        B9();
        Flow onEach = FlowKt.onEach(A9().Q1(), new GuildAISearchInputPart$onInitView$2(this, null));
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(hostFragment));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        GuildAISearchInputView guildAISearchInputView = this.searchInputView;
        f fVar = null;
        if (guildAISearchInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
            guildAISearchInputView = null;
        }
        guildAISearchInputView.z();
        f fVar2 = this.keyboardHelper;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyboardHelper");
        } else {
            fVar = fVar2;
        }
        fVar.g();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        Boolean bool;
        boolean z16;
        super.onPartResume(activity);
        GuildAISearchInputView guildAISearchInputView = null;
        Object broadcastGetMessage = broadcastGetMessage("broadcast_get_drawer_opened", null);
        if (broadcastGetMessage instanceof Boolean) {
            bool = (Boolean) broadcastGetMessage;
        } else {
            bool = null;
        }
        boolean z17 = false;
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        GuildAISearchInputView guildAISearchInputView2 = this.searchInputView;
        if (guildAISearchInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
            guildAISearchInputView2 = null;
        }
        if (guildAISearchInputView2.getVisibility() == 0) {
            z17 = true;
        }
        if (z17 && !z16) {
            GuildAISearchInputView guildAISearchInputView3 = this.searchInputView;
            if (guildAISearchInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
            } else {
                guildAISearchInputView = guildAISearchInputView3;
            }
            guildAISearchInputView.C();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildAISearchInputCloseEvent) {
            this.isClosed = ((GuildAISearchInputCloseEvent) event).isCloseActivity();
            GuildAISearchInputView guildAISearchInputView = this.searchInputView;
            if (guildAISearchInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchInputView");
                guildAISearchInputView = null;
            }
            guildAISearchInputView.p();
        }
    }
}
