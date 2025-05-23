package com.tencent.mobileqq.guild.feed.nativepublish.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.launcher.c;
import com.tencent.launcher.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.q;
import com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.feed.nativepublish.root.FeedEditorRootVB;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.report.f;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.feed.util.framework.emitter.BackEventEmitter;
import com.tencent.mobileqq.guild.feed.util.framework.emitter.ConfigurationChangedEmitter;
import com.tencent.mobileqq.guild.feed.util.framework.emitter.MultiWindowModeChangedEmitter;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.QzoneIPCModule;
import dm1.d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw1.b;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007\u00a2\u0006\u0004\bP\u0010QJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u0019\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0014\u0010\u001a\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\f\u0010\u001b\u001a\u00020\u0004*\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 0\u001fH\u0002J \u0010(\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\u0012\u0010+\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010/\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020,2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00100\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u00101\u001a\u00020\u0004H\u0014J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u000202H\u0016J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u000206H\u0016J\"\u0010>\u001a\u00020\u00042\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u0002092\b\u0010=\u001a\u0004\u0018\u00010<H\u0016J\b\u0010?\u001a\u000202H\u0016J\b\u0010@\u001a\u00020\u0004H\u0016R$\u0010D\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/fragment/ShortFeedEditorFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Eh", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Dh", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "xh", "Lcom/tencent/launcher/d;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Ldm1/d;", "blueprint", "wh", "Landroid/os/Bundle;", "args", "Lzl1/a;", "qh", "Lcom/tencent/mobileqq/guild/feed/nativepublish/FeedEditorConfiguration;", "Ah", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "sh", "th", "yh", "Ch", "", "pageId", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "uh", "dtReportView", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mvi/base/route/j;", "messenger", "Bh", "vh", "rh", "initWindowStyleAndAnimation", "Landroid/view/LayoutInflater;", "inflater", Constants.FILE_INSTANCE_STATE, "onCreateView", "onCreate", "onFragmentViewDestroyed", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "onBackEvent", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "needImmersive", "onFinish", "Lcom/tencent/mvi/mvvm/BaseVB;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/BaseVB;", "rootVB", "Lcom/tencent/launcher/a;", "D", "Lcom/tencent/launcher/a;", "vbAssembleApi", "E", "Lzl1/a;", "editorParams", "Lkm1/b;", UserInfo.SEX_FEMALE, "Lkm1/b;", "dtReportMediator", "<init>", "()V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ShortFeedEditorFragment extends QPublicBaseFragment {

    @NotNull
    private static final a G = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private BaseVB<?, ?, ?> rootVB;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.launcher.a vbAssembleApi;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private zl1.a editorParams;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private km1.b dtReportMediator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/fragment/ShortFeedEditorFragment$a;", "", "", "DT_REPORT_DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001Rb\u0010\u000b\u001aJ\u0012\u0004\u0012\u00020\u0003\u0012@\u0012>\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u00060\u0004j\u001e\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00060\u0006`\u00070\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/fragment/ShortFeedEditorFragment$b", "Lkm1/b;", "Lkotlin/Pair;", "", "Ljava/util/HashMap;", "kotlin.jvm.PlatformType", "", "Lkotlin/collections/HashMap;", "a", "Lkotlin/Pair;", "()Lkotlin/Pair;", "currentPageParamsEntry", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements km1.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Pair<String, HashMap<String, Object>> currentPageParamsEntry;

        b(Map<String, ? extends Object> map, String str) {
            HashMap hashMap = new HashMap(map);
            hashMap.put("pgid", str);
            Unit unit = Unit.INSTANCE;
            this.currentPageParamsEntry = TuplesKt.to("cur_pg", hashMap);
        }

        @Override // km1.b
        @NotNull
        public Pair<String, HashMap<String, Object>> a() {
            return this.currentPageParamsEntry;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/fragment/ShortFeedEditorFragment$c", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Ldm1/d;", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends IStrategyFetcher<d<?>> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d<?> f222062b;

        c(d<?> dVar) {
            this.f222062b = dVar;
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d<?> getF447332b() {
            return this.f222062b;
        }
    }

    private final FeedEditorConfiguration Ah(Bundle args) {
        FeedEditorConfiguration feedEditorConfiguration = (FeedEditorConfiguration) args.getParcelable("launch_config");
        if (feedEditorConfiguration == null) {
            return new FeedEditorConfiguration(false, false, false, false, false, false, false, false, 255, null);
        }
        return feedEditorConfiguration;
    }

    private final void Bh(View dtReportView, LifecycleOwner lifecycleOwner, j messenger) {
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new ShortFeedEditorFragment$setupContentExistenceStatusDtReport$$inlined$eventFlow$1(messenger, null)), new ShortFeedEditorFragment$setupContentExistenceStatusDtReport$1(new Ref.IntRef(), dtReportView, null)), LifecycleOwnerKt.getLifecycleScope(lifecycleOwner));
    }

    private final void Ch(ViewGroup container) {
        Serializable serializable;
        String str;
        Map<String, String> reportInfoMap;
        String str2;
        Bundle bundle;
        Bundle bundle2;
        GuildFeedBaseInitBean o16 = ax.o(this);
        if (o16 == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(requireActivity());
        HashMap hashMap = new HashMap();
        Bundle arguments = getArguments();
        Serializable serializable2 = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("dt_report_page_param");
        } else {
            serializable = null;
        }
        if (serializable instanceof Map) {
            serializable2 = serializable;
        }
        Map map = (Map) serializable2;
        if (map != null) {
            QLog.d("FeedEditor.Fragment", 4, "[setupDtReport]: dt_report_page_param=" + map);
            hashMap.putAll(map);
            hashMap.remove("pgid");
        }
        String str3 = "";
        if (o16.getBusinessType() == 7) {
            String troopUin = o16.getTroopUin();
            if (troopUin == null) {
                troopUin = "";
            }
            hashMap.put("group_id", troopUin);
            hashMap.put("group_uin_type", Integer.valueOf(o16.getTroopRole()));
            str = "pg_group_sgrp_froum_short_editor";
        } else {
            String j3 = f.j(o16.getGuildId());
            if (j3 == null) {
                j3 = "";
            }
            hashMap.put("sgrp_user_type", j3);
            str = "pg_sgrp_forum_short_editor";
        }
        String guildId = o16.getGuildId();
        if (guildId == null) {
            guildId = "";
        }
        hashMap.put("sgrp_channel_id", guildId);
        String channelId = o16.getChannelId();
        if (channelId != null) {
            str3 = channelId;
        }
        hashMap.put("sgrp_sub_channel_id", str3);
        hashMap.put("sgrp_is_edit_status", 0);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (bundle2 = arguments2.getBundle("launch_dlc_bundle")) != null) {
            String it = bundle2.getString("sgrp_stream_pgin_source_name");
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                hashMap.put("sgrp_stream_pgin_source_name", it);
            }
            String it5 = bundle2.getString("sgrp_visit_from");
            if (it5 != null) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                hashMap.put("sgrp_visit_from", it5);
            }
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (bundle = arguments3.getBundle("topic_element_append")) != null) {
            hashMap.put("sgrp_topic_id", Long.valueOf(bundle.getLong("topic_id")));
        }
        GuildFeedReportSourceInfo feedReportSourceInfo = o16.getFeedReportSourceInfo();
        if (feedReportSourceInfo != null && (reportInfoMap = feedReportSourceInfo.getReportInfoMap()) != null && (str2 = reportInfoMap.get("extra_feeds_from_activity_id")) != null) {
            hashMap.put("sgrp_activity_id", str2);
        }
        VideoReport.setPageId(container, str);
        VideoReport.setPageParams(container, new PageParams(hashMap));
        uh(container, str, hashMap);
    }

    private final void Dh(ViewGroup container) {
        j jVar;
        com.tencent.mvi.api.runtime.b context;
        com.tencent.launcher.a aVar = this.vbAssembleApi;
        if (aVar != null && (context = aVar.getContext()) != null) {
            jVar = context.e();
        } else {
            jVar = null;
        }
        if (jVar != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            Bh(container, viewLifecycleOwner, jVar);
        }
    }

    private final void Eh(Activity activity) {
        Window window;
        int i3;
        if (activity != null && (window = activity.getWindow()) != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                i3 = 48;
            } else {
                i3 = 16;
            }
            window.setSoftInputMode(i3);
        }
    }

    private final zl1.a qh(Bundle args) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        GuildFeedBaseInitBean bean = ax.o(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        String str2 = "";
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        }
        if (str == null) {
            str = "";
        }
        zl1.a aVar = new zl1.a(str, Ah(args));
        th(aVar, args);
        q contact = aVar.getContact();
        String guildId = bean.getGuildId();
        if (guildId == null) {
            guildId = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(guildId, "bean.guildId ?: \"\"");
        }
        contact.setGuildId(guildId);
        String channelId = bean.getChannelId();
        if (channelId == null) {
            channelId = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(channelId, "bean.channelId ?: \"\"");
        }
        contact.setChannelId(channelId);
        String channelName = bean.getChannelName();
        if (channelName != null) {
            Intrinsics.checkNotNullExpressionValue(channelName, "bean.channelName ?: \"\"");
            str2 = channelName;
        }
        contact.setChannelName(str2);
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        sh(aVar, args, bean);
        aVar.F(bean);
        yh(aVar);
        return aVar;
    }

    private final void rh() {
        int i3;
        com.tencent.mobileqq.guild.feed.nativepublish.root.f q16;
        bl c16 = bl.c();
        zl1.a aVar = this.editorParams;
        boolean z16 = false;
        if (aVar != null) {
            i3 = zl1.b.d(aVar);
        } else {
            i3 = 0;
        }
        zl1.a aVar2 = this.editorParams;
        if (aVar2 != null && (q16 = aVar2.q()) != null && q16.getIsTriggerPost()) {
            z16 = true;
        }
        c16.a(new FeedEditorEvent.OnFeedEditorClosedEvent(i3, z16));
    }

    private final void sh(zl1.a aVar, Bundle bundle, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        aVar.getExtra().putInt("launch_request_id", bundle.getInt("launch_request_id", 0));
        aVar.getExtra().putInt("feed_card_page_source", guildFeedBaseInitBean.getBusinessType());
        aVar.getExtra().putBundle("topic_element_append", bundle.getBundle("topic_element_append"));
        aVar.getExtra().putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM));
        Bundle bundle2 = bundle.getBundle("launch_dlc_bundle");
        if (bundle2 != null) {
            aVar.getExtra().putAll(bundle2);
        }
        qw1.b.u(aVar.getExtra(), qw1.b.g(bundle, null, 1, null), null, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        if (r4 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void th(zl1.a aVar, Bundle bundle) {
        boolean z16;
        String string;
        Object obj;
        aVar.L(bundle.getInt("launch_scene_type"));
        String string2 = bundle.getString("launch_main_task_id", "");
        Intrinsics.checkNotNullExpressionValue(string2, "args.getString(GuildFeed\u2026.LAUNCH_MAIN_TASK_ID, \"\")");
        aVar.I(string2);
        String it = bundle.getString("launch_json_feed_store_id", "");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Object obj2 = null;
        if (z16) {
            it = null;
        }
        if (it != null) {
            jj1.b c16 = jj1.b.c();
            Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
            GuildFeedTempDataStore.b bVar = (GuildFeedTempDataStore.b) c16.getData("GuildFeedTempDataStore", it);
            if (bVar != null) {
                obj = bVar.getValue();
            } else {
                obj = null;
            }
            if (obj != null) {
                c16.removeDataByKey("GuildFeedTempDataStore", it);
            }
            if (obj instanceof String) {
                obj2 = obj;
            }
            string = (String) obj2;
        }
        string = bundle.getString("launch_json_feed", "");
        Intrinsics.checkNotNullExpressionValue(string, "args.getString(GuildFeed\u2026nts.LAUNCH_JSON_FEED, \"\")");
        aVar.G(string);
        String string3 = bundle.getString("launch_feed_id", "");
        Intrinsics.checkNotNullExpressionValue(string3, "args.getString(GuildFeed\u2026tants.LAUNCH_FEED_ID, \"\")");
        aVar.C(string3);
        String string4 = bundle.getString("launch_draft_key", "");
        Intrinsics.checkNotNullExpressionValue(string4, "args.getString(GuildFeed\u2026nts.LAUNCH_DRAFT_KEY, \"\")");
        aVar.y(string4);
        aVar.A(bundle.getBoolean("launch_edit_flag", false));
        aVar.B(bundle.getBoolean("launch_published_flag", false));
        aVar.H(bundle.getBoolean("launch_preset_content_flag", false));
        aVar.J(bundle.getInt("launch_media_lock_size", 0));
        aVar.K(bundle.getInt("launch_redirect_action"));
        CharSequence charSequence = bundle.getCharSequence("launch_hint_text", "");
        Intrinsics.checkNotNullExpressionValue(charSequence, "args.getCharSequence(Gui\u2026nts.LAUNCH_HINT_TEXT, \"\")");
        aVar.E(charSequence);
    }

    private final void uh(ViewGroup container, String pageId, Map<String, ? extends Object> pageParams) {
        b bVar = new b(pageParams, pageId);
        this.dtReportMediator = bVar;
        Intrinsics.checkNotNull(bVar);
        n.y(container, km1.b.class, bVar);
    }

    private final void vh(com.tencent.launcher.d launchParam) {
        com.tencent.mobileqq.guild.feed.util.framework.emitter.c cVar = new com.tencent.mobileqq.guild.feed.util.framework.emitter.c();
        cVar.c(jx.a.class, new MultiWindowModeChangedEmitter());
        cVar.c(com.tencent.input.base.tool.emitter.a.class, new ConfigurationChangedEmitter());
        cVar.c(com.tencent.mobileqq.guild.feed.util.framework.emitter.b.class, new BackEventEmitter());
        launchParam.k(cVar);
    }

    private final void wh(com.tencent.launcher.d launchParam, d<?> blueprint) {
        c.a aVar = new c.a();
        aVar.c(d.class, new c(blueprint));
        launchParam.p(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View xh(ViewGroup parent) {
        Class cls;
        Bundle arguments = getArguments();
        Object obj = null;
        if (arguments == null) {
            QLog.e("FeedEditor.Fragment", 1, "launcherVB|args is null, is it really what you want?");
            return null;
        }
        Serializable serializable = requireArguments().getSerializable("launch_blueprint_class");
        if (serializable instanceof Class) {
            cls = (Class) serializable;
        } else {
            cls = null;
        }
        if (cls != null) {
            obj = cls.newInstance();
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.factory.IFeedEditorBlueprint<*>");
        this.editorParams = qh(arguments);
        this.rootVB = new FeedEditorRootVB();
        d.a c16 = new d.a().c(this);
        BaseVB<?, ?, ?> baseVB = this.rootVB;
        Intrinsics.checkNotNull(baseVB);
        d.a e16 = c16.f(baseVB).e(parent);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        d.a d16 = e16.d(viewLifecycleOwner);
        zl1.a aVar = this.editorParams;
        Intrinsics.checkNotNull(aVar);
        com.tencent.launcher.d b16 = d16.a(aVar).b();
        b16.i(false);
        wh(b16, (dm1.d) obj);
        vh(b16);
        this.vbAssembleApi = new com.tencent.launcher.c().a(b16);
        BaseVB<?, ?, ?> baseVB2 = this.rootVB;
        Intrinsics.checkNotNull(baseVB2);
        return baseVB2.getHostView();
    }

    private final void yh(final zl1.a aVar) {
        MutableLiveData<String> t16 = aVar.t();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.fragment.ShortFeedEditorFragment$observeMainTaskIdToBindReportTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String taskId) {
                Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                if (taskId.length() > 0) {
                    GuildTaskQueueManager.m().i(taskId, b.g(zl1.a.this.getExtra(), null, 1, null));
                }
            }
        };
        t16.observeForever(new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ShortFeedEditorFragment.zh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        Eh(activity);
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = Bundle.EMPTY;
        }
        int i3 = arguments.getInt("launch_enter_anim_res", 0);
        int i16 = arguments.getInt("launch_exit_anim_res", 0);
        if (activity != null) {
            activity.overridePendingTransition(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        com.tencent.launcher.a aVar = this.vbAssembleApi;
        if (aVar != null) {
            aVar.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        com.tencent.mvi.api.runtime.b context;
        ml3.b b16;
        com.tencent.mobileqq.guild.feed.util.framework.emitter.b bVar;
        com.tencent.launcher.a aVar = this.vbAssembleApi;
        if (aVar != null && (context = aVar.getContext()) != null && (b16 = context.b()) != null && (bVar = (com.tencent.mobileqq.guild.feed.util.framework.emitter.b) b16.b(com.tencent.mobileqq.guild.feed.util.framework.emitter.b.class)) != null) {
            return bVar.onBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        com.tencent.mvi.api.runtime.b context;
        ml3.b b16;
        com.tencent.input.base.tool.emitter.a aVar;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        com.tencent.launcher.a aVar2 = this.vbAssembleApi;
        if (aVar2 != null && (context = aVar2.getContext()) != null && (b16 = context.b()) != null && (aVar = (com.tencent.input.base.tool.emitter.a) b16.b(com.tencent.input.base.tool.emitter.a.class)) != null) {
            aVar.onConfigurationChanged(newConfig);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GuildTaskQueueManager.m().C();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View xh5;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (container == null) {
            xh5 = super.onCreateView(inflater, container, savedInstanceState);
        } else {
            xh5 = xh(container);
            Ch(container);
            Dh(container);
            km1.a aVar = km1.a.f412694a;
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = Bundle.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: Bundle.EMPTY");
            aVar.e(container, arguments);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, xh5);
        return xh5;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        super.onFragmentViewDestroyed();
        BaseVB<?, ?, ?> baseVB = this.rootVB;
        if (baseVB != null) {
            baseVB.destroy();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        com.tencent.launcher.a aVar = this.vbAssembleApi;
        if (aVar != null) {
            aVar.onMultiWindowModeChanged(isInMultiWindowMode);
        }
    }
}
