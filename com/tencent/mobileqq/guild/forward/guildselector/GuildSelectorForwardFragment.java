package com.tencent.mobileqq.guild.forward.guildselector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.al;
import com.tencent.mobileqq.forward.k;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.g;
import com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorForwardFragment;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0003\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0002PQB\u0007\u00a2\u0006\u0004\bM\u0010NJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J&\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u001fH\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "com/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$c", "xh", "()Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$c;", "", "yh", "Landroid/view/View;", "view", "initView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "vh", "uh", "initViewModel", "Lcom/tencent/mobileqq/guild/forward/guildselector/c;", "guildData", OcrConfig.CHINESE, "initDtReport", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "", "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onFinish", "isWrapContent", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "D", "titleContainer", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "backText", "Lcom/tencent/mobileqq/selectmember/SelectedAndSearchBar;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/selectmember/SelectedAndSearchBar;", "selectedAndSearchBar", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView;", "G", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView;", "guildListView", "H", "Z", "isOnlySingle", "I", "sharePanelPageSource", "Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "J", "Lcom/tencent/mobileqq/forward/ForwardBaseOption;", "forwardOption", "Lcom/tencent/mobileqq/guild/forward/guildselector/b;", "K", "Lcom/tencent/mobileqq/guild/forward/guildselector/b;", "guildAdapter", "Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorViewModel;", "L", "Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/feed/api/g;", "M", "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/guild/feed/api/g;", "shareResultListener", "<init>", "()V", "N", "a", "b", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildSelectorForwardFragment extends QPublicBaseFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private View titleContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView backText;

    /* renamed from: F, reason: from kotlin metadata */
    private SelectedAndSearchBar selectedAndSearchBar;

    /* renamed from: G, reason: from kotlin metadata */
    private OverScrollRecyclerView guildListView;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isOnlySingle;

    /* renamed from: I, reason: from kotlin metadata */
    private int sharePanelPageSource = GuildSharePageSource.UNKNOWN.ordinal();

    /* renamed from: J, reason: from kotlin metadata */
    private ForwardBaseOption forwardOption;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.forward.guildselector.b guildAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private GuildSelectorViewModel viewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy shareResultListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B?\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fRG\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$b;", "", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/forward/guildselector/c;", "Lkotlin/ParameterName;", "name", "guildData", "Landroid/view/View;", "view", "", "a", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "shareToGuild", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Function2<GuildData, View, Unit> shareToGuild;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function2<? super GuildData, ? super View, Unit> shareToGuild) {
            Intrinsics.checkNotNullParameter(shareToGuild, "shareToGuild");
            this.shareToGuild = shareToGuild;
        }

        public final Function2<GuildData, View, Unit> a() {
            return this.shareToGuild;
        }
    }

    public GuildSelectorForwardFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorForwardFragment$shareResultListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildSelectorForwardFragment.c invoke() {
                GuildSelectorForwardFragment.c xh5;
                xh5 = GuildSelectorForwardFragment.this.xh();
                return xh5;
            }
        });
        this.shareResultListener = lazy;
    }

    private final void initDtReport() {
        Map mapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_choose_channel_shareview");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(this.sharePanelPageSource)), TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE"));
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        VideoReport.setPageParams(view2, new PageParams((Map<String, ?>) mapOf));
    }

    private final void initViewModel() {
        ViewModel viewModel = h.a(com.tencent.mobileqq.guild.base.fragments.f.b(this)).get(GuildSelectorViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(shar\u2026del::class.java\n        )");
        GuildSelectorViewModel guildSelectorViewModel = (GuildSelectorViewModel) viewModel;
        this.viewModel = guildSelectorViewModel;
        GuildSelectorViewModel guildSelectorViewModel2 = null;
        if (guildSelectorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSelectorViewModel = null;
        }
        LiveData<List<a>> O1 = guildSelectorViewModel.O1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends a>, Unit> function1 = new Function1<List<? extends a>, Unit>() { // from class: com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorForwardFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends a> list) {
                b bVar;
                bVar = GuildSelectorForwardFragment.this.guildAdapter;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildAdapter");
                    bVar = null;
                }
                bVar.setItems(list);
            }
        };
        O1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.forward.guildselector.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSelectorForwardFragment.wh(Function1.this, obj);
            }
        });
        GuildSelectorViewModel guildSelectorViewModel3 = this.viewModel;
        if (guildSelectorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildSelectorViewModel2 = guildSelectorViewModel3;
        }
        guildSelectorViewModel2.P1();
    }

    private final g th() {
        return (g) this.shareResultListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c xh() {
        return new c();
    }

    private final void yh() {
        Intent intent = requireActivity().getIntent();
        this.isOnlySingle = intent.getBooleanExtra("only_single_selection", false);
        this.sharePanelPageSource = intent.getIntExtra(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.UNKNOWN.ordinal());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            this.forwardOption = k.d(intent, qQAppInterface, requireActivity());
        }
        boolean z16 = this.isOnlySingle;
        int i3 = this.sharePanelPageSource;
        ForwardBaseOption forwardBaseOption = this.forwardOption;
        QLog.iAsync("GuildSelectorForwardFragment", 1, "resolveIntent isOnlySingle=" + z16 + ", sharePanelPageSource=" + i3 + ", forwardOption=" + (forwardBaseOption != null ? forwardBaseOption.getClass().getSimpleName() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(GuildData guildData, View view) {
        Map mapOf;
        QLog.i("GuildSelectorForwardFragment", 1, "shareToGuild: " + guildData.getGuildId());
        VideoReport.setElementId(view, "em_sgrp_channel_list");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_node_type", Integer.valueOf(guildData.getNodeType())));
        VideoReport.reportEvent("clck", view, mapOf);
        com.tencent.mobileqq.forward.e eVar = this.forwardOption;
        if (eVar instanceof al) {
            Intrinsics.checkNotNull(eVar, "null cannot be cast to non-null type com.tencent.mobileqq.forward.IForwardPublishGuildFeed");
            if (((al) eVar).b()) {
                com.tencent.mobileqq.forward.e eVar2 = this.forwardOption;
                Intrinsics.checkNotNull(eVar2, "null cannot be cast to non-null type com.tencent.mobileqq.forward.IForwardPublishGuildFeed");
                ((al) eVar2).a(requireActivity(), guildData.getGuildId(), this.sharePanelPageSource, th());
                return;
            }
        }
        QQToastUtil.showQQToast(0, ForwardRecentActivity.NOT_SUPPORT_SHARE_TO_GUILD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f8b;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154740cc);
        Window window = activity.getWindow();
        if (window != null) {
            window.setSoftInputMode(48);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        TextView textView = this.backText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backText");
            textView = null;
        }
        if (Intrinsics.areEqual(v3, textView)) {
            onBackEvent();
        } else if (v3.getId() == R.id.ijw || v3.getId() == R.id.ik5) {
            QQToastUtil.showQQToast(1, "\u6682\u65f6\u4e0d\u53ef\u641c\u7d22\u9891\u9053\u5217\u8868");
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        yh();
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initViewModel();
        initDtReport();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$c", "Lcom/tencent/mobileqq/guild/feed/api/g;", "", "success", "", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements g {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.api.g
        public void a(boolean success) {
            FragmentActivity activity;
            if (success && (activity = GuildSelectorForwardFragment.this.getActivity()) != null) {
                Intent intent = new Intent();
                intent.putExtras(new Bundle());
                intent.putExtra("uintype", 10027);
                activity.setResult(-1, intent);
                activity.finish();
            }
        }
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.if5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(com.te\u2026.mobileqq.R.id.root_view)");
        this.rootView = findViewById;
        vh(view);
        uh(view);
        View findViewById2 = view.findViewById(R.id.wlx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.guild_list)");
        this.guildListView = (OverScrollRecyclerView) findViewById2;
        this.guildAdapter = new com.tencent.mobileqq.guild.forward.guildselector.b(new b(new GuildSelectorForwardFragment$initView$1(this)));
        OverScrollRecyclerView overScrollRecyclerView = this.guildListView;
        com.tencent.mobileqq.guild.forward.guildselector.b bVar = null;
        if (overScrollRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildListView");
            overScrollRecyclerView = null;
        }
        overScrollRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        com.tencent.mobileqq.guild.forward.guildselector.b bVar2 = this.guildAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAdapter");
        } else {
            bVar = bVar2;
        }
        overScrollRecyclerView.setAdapter(bVar);
    }

    private final void uh(View rootView) {
        View findViewById = rootView.findViewById(R.id.imi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026.selected_and_search_bar)");
        SelectedAndSearchBar selectedAndSearchBar = (SelectedAndSearchBar) findViewById;
        this.selectedAndSearchBar = selectedAndSearchBar;
        SelectedAndSearchBar selectedAndSearchBar2 = null;
        if (selectedAndSearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedAndSearchBar");
            selectedAndSearchBar = null;
        }
        View findViewById2 = selectedAndSearchBar.findViewById(R.id.ijw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "selectedAndSearchBar.fin\u2026ber.api.R.id.search_icon)");
        ImageView imageView = (ImageView) findViewById2;
        SelectedAndSearchBar selectedAndSearchBar3 = this.selectedAndSearchBar;
        if (selectedAndSearchBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedAndSearchBar");
        } else {
            selectedAndSearchBar2 = selectedAndSearchBar3;
        }
        View findViewById3 = selectedAndSearchBar2.findViewById(R.id.ik5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "selectedAndSearchBar.fin\u2026.R.id.search_keyword_btn)");
        EditText editText = (EditText) findViewById3;
        imageView.setOnClickListener(this);
        editText.setOnClickListener(this);
        editText.setFocusable(false);
        editText.setCursorVisible(false);
    }

    private final void vh(View rootView) {
        String str;
        View findViewById = rootView.findViewById(R.id.title_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026qui.R.id.title_container)");
        this.titleContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.a4e);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(co\u2026.mobileqq.R.id.back_text)");
        this.backText = (TextView) findViewById2;
        TextView textView = null;
        boolean z16 = true;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            View view = this.titleContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                view = null;
            }
            view.setFitsSystemWindows(true);
            View view2 = this.titleContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                view2 = null;
            }
            view2.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
            Window window = requireActivity().getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.qui_common_bg_bottom_light));
            window.setNavigationBarColor(getResources().getColor(R.color.qui_common_bg_bottom_light));
            if (ImmersiveUtils.couldSetStatusTextColor()) {
                if (!QQTheme.isNowThemeIsNight() && !QQTheme.isNowThemeSimpleNight()) {
                    z16 = false;
                }
                ImmersiveUtils.setStatusTextColorNew(z16, requireActivity().getWindow());
            }
        }
        TextView textView2 = this.backText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backText");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.backText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backText");
        } else {
            textView = textView3;
        }
        if (this.isOnlySingle) {
            str = "\u53d6\u6d88";
        } else {
            str = "\u8fd4\u56de";
        }
        textView.setText(str);
    }
}
