package com.tencent.mobileqq.troop.aivoicechat.voicelist;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.config.TroopAIVoiceChatListConfig;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.event.TroopAIVoiceChatListRefreshSelectVoice;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.event.TroopAIVoiceChatListSelectVoice;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.TroopAIVoiceChatListViewModel;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.a;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import com.tencent.qqnt.kernel.nativeinterface.VoicePair;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0001\u0017\u0018\u0000 a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001bB\u0007\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020 H\u0014J\b\u0010#\u001a\u00020\"H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J$\u0010.\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-0\u000fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-`\u0011H\u0016J\b\u0010/\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0016R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010;\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u0010:R\u001b\u0010?\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u00104\u001a\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR$\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u000fj\b\u0012\u0004\u0012\u00020\u0013`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/TroopAIVoiceChatListBaseFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/event/TroopAIVoiceChatListSelectVoice;", "", "initData", "Eh", "initUI", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VoicePair;", "dataList", "Gh", "Fh", "", "tabName", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "Lkotlin/collections/ArrayList;", "voiceList", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/TroopAIVoiceChatListFragment;", "yh", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/TroopAIVoiceChatListViewModel;", "Bh", "com/tencent/mobileqq/troop/aivoicechat/voicelist/TroopAIVoiceChatListBaseFragment$b", "Dh", "()Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/TroopAIVoiceChatListBaseFragment$b;", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", OcrConfig.CHINESE, "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;", DownloadInfo.spKey_Config, "Kh", "Jh", "", "getContentLayoutId", "", "useQUISecNavBar", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Ah", "()J", "troopUin", "D", "getVoiceType", "()I", "voiceType", "E", "Ch", "()Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/TroopAIVoiceChatListViewModel;", "viewModel", "Landroid/widget/RelativeLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/RelativeLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "G", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabBar", "Landroidx/viewpager2/widget/ViewPager2;", "H", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "addButton", "J", "Ljava/util/ArrayList;", "fragments", "K", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/config/TroopAIVoiceChatListConfig;", "selectedConfig", "L", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "selectedVoice", "M", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "gestureLayout", "N", "Ljava/lang/String;", "curTabName", "<init>", "()V", "P", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatListBaseFragment extends QIphoneTitleBarFragment implements SimpleEventReceiver<TroopAIVoiceChatListSelectVoice> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy voiceType;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private RelativeLayout rootView;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIPageTabBar tabBar;

    /* renamed from: H, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: I, reason: from kotlin metadata */
    private QUIButton addButton;

    /* renamed from: J, reason: from kotlin metadata */
    private final ArrayList<TroopAIVoiceChatListFragment> fragments;

    /* renamed from: K, reason: from kotlin metadata */
    private TroopAIVoiceChatListConfig selectedConfig;

    /* renamed from: L, reason: from kotlin metadata */
    private VoiceItem selectedVoice;

    /* renamed from: M, reason: from kotlin metadata */
    private TopGestureLayout gestureLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private String curTabName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/aivoicechat/voicelist/TroopAIVoiceChatListBaseFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ViewModelProvider.Factory {
        b() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return modelClass.getConstructor(Long.TYPE, Integer.TYPE).newInstance(Long.valueOf(TroopAIVoiceChatListBaseFragment.this.Ah()), Integer.valueOf(TroopAIVoiceChatListBaseFragment.this.getVoiceType()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/aivoicechat/voicelist/TroopAIVoiceChatListBaseFragment$c", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends FragmentStateAdapter {
        c() {
            super(TroopAIVoiceChatListBaseFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            Object obj = TroopAIVoiceChatListBaseFragment.this.fragments.get(position);
            TroopAIVoiceChatListBaseFragment troopAIVoiceChatListBaseFragment = TroopAIVoiceChatListBaseFragment.this;
            Bundle arguments = ((TroopAIVoiceChatListFragment) obj).getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "it.arguments ?: Bundle()");
            arguments.putAll(troopAIVoiceChatListBaseFragment.getArguments());
            Intrinsics.checkNotNullExpressionValue(obj, "fragments[position].also\u2026uments)\n                }");
            return (Fragment) obj;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return TroopAIVoiceChatListBaseFragment.this.fragments.size();
        }
    }

    public TroopAIVoiceChatListBaseFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.TroopAIVoiceChatListBaseFragment$troopUin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Bundle arguments = TroopAIVoiceChatListBaseFragment.this.getArguments();
                return Long.valueOf(arguments != null ? arguments.getLong("troop_uin") : 0L);
            }
        });
        this.troopUin = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.TroopAIVoiceChatListBaseFragment$voiceType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Bundle arguments = TroopAIVoiceChatListBaseFragment.this.getArguments();
                return Integer.valueOf(arguments != null ? arguments.getInt(ITroopAIVoiceChatApi.AI_CHAT_TYPE) : AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal());
            }
        });
        this.voiceType = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<TroopAIVoiceChatListViewModel>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.TroopAIVoiceChatListBaseFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopAIVoiceChatListViewModel invoke() {
                TroopAIVoiceChatListViewModel Bh;
                Bh = TroopAIVoiceChatListBaseFragment.this.Bh();
                return Bh;
            }
        });
        this.viewModel = lazy3;
        this.fragments = new ArrayList<>();
        this.curTabName = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long Ah() {
        return ((Number) this.troopUin.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopAIVoiceChatListViewModel Bh() {
        ViewModel viewModel = new ViewModelProvider(this, Dh()).get(TroopAIVoiceChatListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026istViewModel::class.java)");
        return (TroopAIVoiceChatListViewModel) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopAIVoiceChatListViewModel Ch() {
        return (TroopAIVoiceChatListViewModel) this.viewModel.getValue();
    }

    private final b Dh() {
        return new b();
    }

    private final void Eh() {
        View build = new QUIEmptyState.Builder(requireContext()).setImageType(5).setTitle("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5").build();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 17;
        build.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = this.rootView;
        ViewPager2 viewPager2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            relativeLayout = null;
        }
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.f17285);
        linearLayout.addView(build);
        linearLayout.setVisibility(0);
        QUIButton qUIButton = this.addButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addButton");
            qUIButton = null;
        }
        qUIButton.setVisibility(8);
        QUIPageTabBar qUIPageTabBar = this.tabBar;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar = null;
        }
        qUIPageTabBar.setVisibility(8);
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager2 = viewPager22;
        }
        viewPager2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(List<VoicePair> dataList) {
        if (dataList.isEmpty()) {
            Eh();
            return;
        }
        ViewPager2 viewPager2 = null;
        if (getVoiceType() == AIVoiceChatType.KAIVOICECHATTYPESING.ordinal()) {
            Fh(dataList);
            QUIPageTabBar qUIPageTabBar = this.tabBar;
            if (qUIPageTabBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                qUIPageTabBar = null;
            }
            qUIPageTabBar.setTabData(new String[]{""});
        } else if (getVoiceType() == AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal()) {
            ArrayList arrayList = new ArrayList();
            for (VoicePair voicePair : dataList) {
                String str = voicePair.categoryName;
                Intrinsics.checkNotNullExpressionValue(str, "it.categoryName");
                arrayList.add(str);
                ArrayList<TroopAIVoiceChatListFragment> arrayList2 = this.fragments;
                String str2 = voicePair.categoryName;
                Intrinsics.checkNotNullExpressionValue(str2, "it.categoryName");
                ArrayList<VoiceItem> arrayList3 = voicePair.voiceList;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "it.voiceList");
                arrayList2.add(yh(str2, arrayList3));
            }
            QUIPageTabBar qUIPageTabBar2 = this.tabBar;
            if (qUIPageTabBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                qUIPageTabBar2 = null;
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            qUIPageTabBar2.setTabData((String[]) array);
        }
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager22 = null;
        }
        viewPager22.setAdapter(new c());
        QUIPageTabBar qUIPageTabBar3 = this.tabBar;
        if (qUIPageTabBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar3 = null;
        }
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager2 = viewPager23;
        }
        qUIPageTabBar3.bindViewPager2(viewPager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(TroopAIVoiceChatListBaseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIButton qUIButton = null;
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this$0.requireContext(), "\u5f53\u524d\u7f51\u7edc\u8fde\u63a5\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", 1, 0).show();
        } else {
            if (this$0.selectedVoice != null) {
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new TroopAIVoiceChatListBaseFragment$initUI$1$1(this$0, null), 3, null);
            }
            this$0.requireActivity().finish();
        }
        if (this$0.selectedVoice != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            VoiceItem voiceItem = this$0.selectedVoice;
            Intrinsics.checkNotNull(voiceItem);
            String str = voiceItem.voiceId;
            Intrinsics.checkNotNullExpressionValue(str, "selectedVoice!!.voiceId");
            linkedHashMap.put("timbre_id", str);
            if (!Intrinsics.areEqual(this$0.curTabName, "")) {
                linkedHashMap.put("tab_name", this$0.curTabName);
            }
            QUIButton qUIButton2 = this$0.addButton;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addButton");
                qUIButton2 = null;
            }
            VideoReport.setElementId(qUIButton2, "em_group_add_voice");
            QUIButton qUIButton3 = this$0.addButton;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addButton");
            } else {
                qUIButton = qUIButton3;
            }
            VideoReport.setElementParams(qUIButton, linkedHashMap);
            VideoReport.reportEvent("clck", linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Jh() {
        String str;
        int voiceType = getVoiceType();
        if (voiceType == AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal()) {
            str = "pg_group_word_to_chat";
        } else if (voiceType == AIVoiceChatType.KAIVOICECHATTYPESING.ordinal()) {
            str = "pg_group_word_to_song";
        } else {
            str = "";
        }
        RelativeLayout relativeLayout = this.rootView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            relativeLayout = null;
        }
        VideoReport.setPageId(relativeLayout, str);
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(Ah()));
        boolean z16 = false;
        int i3 = 1;
        if (!(troopInfoFromCache != null && troopInfoFromCache.isOwner())) {
            if (troopInfoFromCache != null && troopInfoFromCache.isAdmin()) {
                z16 = true;
            }
            i3 = z16 ? 2 : 3;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("group_user_type", String.valueOf(i3));
        linkedHashMap.put("group_id", String.valueOf(Ah()));
        RelativeLayout relativeLayout3 = this.rootView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            relativeLayout3 = null;
        }
        VideoReport.setPageParams(relativeLayout3, new PageParams(linkedHashMap));
        RelativeLayout relativeLayout4 = this.rootView;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            relativeLayout4 = null;
        }
        VideoReport.setPageReportPolicy(relativeLayout4, PageReportPolicy.REPORT_NONE);
        RelativeLayout relativeLayout5 = this.rootView;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            relativeLayout2 = relativeLayout5;
        }
        VideoReport.reportPgIn(relativeLayout2);
    }

    private final void Kh(TroopAIVoiceChatListConfig config) {
        config.O().e(null);
        config.O().f(false);
        config.e0();
        config.d0();
        SimpleEventBus.getInstance().dispatchEvent(new TroopAIVoiceChatListRefreshSelectVoice(config));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getVoiceType() {
        return ((Number) this.voiceType.getValue()).intValue();
    }

    private final void initData() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopAIVoiceChatListBaseFragment$initData$1(this, null), 3, null);
    }

    private final void initUI() {
        QUIButton qUIButton = null;
        if (getVoiceType() == AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal()) {
            this.quiSecNavBar.setCenterText("\u6587\u5b57\u8f6c\u58f0\u804a");
        } else if (getVoiceType() == AIVoiceChatType.KAIVOICECHATTYPESING.ordinal()) {
            this.quiSecNavBar.setCenterText("\u6587\u5b57\u8f6c\u5531\u804a");
            QUIPageTabBar qUIPageTabBar = this.tabBar;
            if (qUIPageTabBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                qUIPageTabBar = null;
            }
            qUIPageTabBar.setVisibility(8);
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            Eh();
            return;
        }
        QUIButton qUIButton2 = this.addButton;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addButton");
            qUIButton2 = null;
        }
        qUIButton2.setEnabled(false);
        QUIButton qUIButton3 = this.addButton;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addButton");
        } else {
            qUIButton = qUIButton3;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopAIVoiceChatListBaseFragment.Hh(TroopAIVoiceChatListBaseFragment.this, view);
            }
        });
    }

    private final TroopAIVoiceChatListFragment yh(String tabName, ArrayList<VoiceItem> voiceList) {
        Bundle bundle = new Bundle();
        bundle.putString("tabName", tabName);
        bundle.putSerializable("voiceList", voiceList);
        TroopAIVoiceChatListFragment troopAIVoiceChatListFragment = new TroopAIVoiceChatListFragment();
        troopAIVoiceChatListFragment.setArguments(bundle);
        return troopAIVoiceChatListFragment;
    }

    private final TopGestureLayout zh() {
        View decorView = getQBaseActivity().getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null && (childAt instanceof ViewGroup)) {
            viewGroup = (ViewGroup) childAt;
        }
        if (viewGroup instanceof TopGestureLayout) {
            return (TopGestureLayout) viewGroup;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127102;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        TroopAIVoiceChatListConfig troopAIVoiceChatListConfig = this.selectedConfig;
        if (troopAIVoiceChatListConfig != null) {
            troopAIVoiceChatListConfig.d0();
        }
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            relativeLayout = null;
        }
        VideoReport.reportPgOut(relativeLayout);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        TopGestureLayout zh5 = zh();
        this.gestureLayout = zh5;
        if (zh5 != null) {
            zh5.setInterceptTouchFlag(true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof TroopAIVoiceChatListSelectVoice) {
            TroopAIVoiceChatListSelectVoice troopAIVoiceChatListSelectVoice = (TroopAIVoiceChatListSelectVoice) event;
            this.selectedVoice = troopAIVoiceChatListSelectVoice.getSelectedVoice();
            QUIButton qUIButton = this.addButton;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addButton");
                qUIButton = null;
            }
            qUIButton.setEnabled(true);
            this.curTabName = troopAIVoiceChatListSelectVoice.getTabName();
            if (Intrinsics.areEqual(troopAIVoiceChatListSelectVoice.getSelectedConfig(), this.selectedConfig)) {
                return;
            }
            TroopAIVoiceChatListConfig troopAIVoiceChatListConfig = this.selectedConfig;
            if (troopAIVoiceChatListConfig != null) {
                Kh(troopAIVoiceChatListConfig);
            }
            this.selectedConfig = troopAIVoiceChatListSelectVoice.getSelectedConfig();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TopGestureLayout zh5 = zh();
        this.gestureLayout = zh5;
        if (zh5 != null) {
            zh5.setInterceptTouchFlag(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.f162726qg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.root)");
        this.rootView = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.f162730um);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.t\u2026op_ai_voice_chat_tab_bar)");
        this.tabBar = (QUIPageTabBar) findViewById2;
        View findViewById3 = view.findViewById(R.id.f162731un);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.t\u2026oice_chat_tab_view_pager)");
        this.viewPager = (ViewPager2) findViewById3;
        View findViewById4 = view.findViewById(R.id.f17230);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.add_voice_button)");
        this.addButton = (QUIButton) findViewById4;
        initUI();
        initData();
        MutableLiveData<com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.a> obtainUiState = Ch().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.a, Unit>() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.TroopAIVoiceChatListBaseFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.a aVar) {
                if (aVar instanceof a.NoticeListUpdate) {
                    TroopAIVoiceChatListBaseFragment.this.Gh(((a.NoticeListUpdate) aVar).a());
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.aivoicechat.voicelist.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopAIVoiceChatListBaseFragment.Ih(Function1.this, obj);
            }
        });
        Jh();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    private final void Fh(List<VoicePair> dataList) {
        if (!dataList.isEmpty()) {
            ArrayList<TroopAIVoiceChatListFragment> arrayList = this.fragments;
            ArrayList<VoiceItem> arrayList2 = dataList.get(0).voiceList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "dataList[0].voiceList");
            arrayList.add(yh("", arrayList2));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<TroopAIVoiceChatListSelectVoice>> getEventClass() {
        ArrayList<Class<TroopAIVoiceChatListSelectVoice>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopAIVoiceChatListSelectVoice.class);
        return arrayListOf;
    }
}
