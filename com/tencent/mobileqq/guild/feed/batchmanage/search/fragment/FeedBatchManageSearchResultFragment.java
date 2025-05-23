package com.tencent.mobileqq.guild.feed.batchmanage.search.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import co1.g;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.biz.richframework.part.PartLifecycleCallbacks;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart;
import com.tencent.mobileqq.guild.feed.batchmanage.search.event.FeedBatchManageSearchResultFragmentEvent;
import com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchResultListPart;
import com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchResultTitlePart;
import com.tencent.mobileqq.guild.feed.batchmanage.search.part.m;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchViewModel;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vi1.f;
import xj1.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/fragment/FeedBatchManageSearchResultFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "yh", "vh", "wh", "uh", "com/tencent/mobileqq/guild/feed/batchmanage/search/fragment/FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1", "th", "()Lcom/tencent/mobileqq/guild/feed/batchmanage/search/fragment/FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1;", "Landroid/view/View;", "contentView", "rh", "xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "", "getContentLayoutId", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Ljava/util/LinkedList;", "Lcom/tencent/biz/richframework/part/Part;", "sh", "onViewCreatedAfterPartInit", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFinish", "Lxi1/b;", BdhLogUtil.LogTag.Tag_Conn, "Lxi1/b;", "batchManager", "Lvi1/b;", "D", "Lvi1/b;", "fragmentArgsIoc", "Lxj1/c;", "E", "Lxj1/c;", "dtReportIoc", "", UserInfo.SEX_FEMALE, "Z", "hasDispatchResult", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchResultFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private xi1.b batchManager;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private vi1.b fragmentArgsIoc;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private c dtReportIoc;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasDispatchResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/fragment/FeedBatchManageSearchResultFragment$a", "Lvi1/b;", "Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "a", "Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "()Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "contact", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "arguments", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements vi1.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IGuildParcelizeSimpleContact contact;

        a() {
            Bundle bundle;
            FeedBatchManageSearchArgs feedBatchManageSearchArgs;
            IGuildParcelizeSimpleContact contact;
            Bundle arguments = getArguments();
            this.contact = (arguments == null || (bundle = arguments.getBundle("search_request")) == null || (feedBatchManageSearchArgs = (FeedBatchManageSearchArgs) bundle.getParcelable("search_args")) == null || (contact = feedBatchManageSearchArgs.getContact()) == null) ? GuildSimpleContact.INSTANCE.a() : contact;
        }

        @Override // vi1.b
        @NotNull
        /* renamed from: a, reason: from getter */
        public IGuildParcelizeSimpleContact getContact() {
            return this.contact;
        }

        @Override // vi1.b
        @Nullable
        public Bundle getArguments() {
            return FeedBatchManageSearchResultFragment.this.getArguments();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/search/fragment/FeedBatchManageSearchResultFragment$b", "Lxj1/c;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "b", "", "getGuildId", "", "getBusinessType", "a", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "c", "getChannelName", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedBaseInitBean f218233a;

        b(GuildFeedBaseInitBean guildFeedBaseInitBean) {
            this.f218233a = guildFeedBaseInitBean;
        }

        @Override // xj1.c
        public int a() {
            return this.f218233a.getImmersiveSource();
        }

        @Override // xj1.c
        @NotNull
        public JumpGuildParam.JoinInfoParam b() {
            return new JumpGuildParam.JoinInfoParam();
        }

        @Override // xj1.c
        @NotNull
        /* renamed from: c, reason: from getter */
        public GuildFeedBaseInitBean getInitBean() {
            return this.f218233a;
        }

        @Override // xj1.c
        public int getBusinessType() {
            return this.f218233a.getBusinessType();
        }

        @Override // xj1.c
        @NotNull
        public String getChannelName() {
            String channelName = this.f218233a.getChannelName();
            if (channelName == null) {
                return "";
            }
            return channelName;
        }

        @Override // xj1.c
        @NotNull
        public String getGuildId() {
            String guildId = this.f218233a.getGuildId();
            if (guildId == null) {
                return "";
            }
            return guildId;
        }
    }

    private final void rh(View contentView) {
        g gVar;
        View O0;
        PartManager partManager = getPartManager();
        String b16 = com.tencent.mvi.base.route.c.b(FeedBatchManageSearchResultListPart.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        PartLifecycleCallbacks part = partManager.getPart(b16);
        if (part instanceof g) {
            gVar = (g) part;
        } else {
            gVar = null;
        }
        if (gVar != null && (O0 = gVar.O0()) != null) {
            LinearLayout linearLayout = (LinearLayout) contentView.findViewById(R.id.f166090ed2);
            int childCount = linearLayout.getChildCount() - 1;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(O0, childCount, layoutParams);
        }
        getPartManager().broadcastMessage("message_search_mode_change", Boolean.TRUE);
    }

    private final FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1 th() {
        return new FeedBatchManageSearchResultFragment$createBottomOperationPartDependency$1(this);
    }

    private final void uh() {
        xi1.b bVar = new xi1.b();
        PartFragmentIOCKt.registerIoc(this, bVar, f.class);
        this.batchManager = bVar;
    }

    private final void vh() {
        a aVar = new a();
        this.fragmentArgsIoc = aVar;
        Intrinsics.checkNotNull(aVar);
        PartFragmentIOCKt.registerIoc(this, aVar, vi1.b.class);
    }

    private final void wh() {
        long j3;
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            j3 = arguments.getLong("selected_channel_id");
        } else {
            j3 = 0;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("selected_channel_name")) == null) {
            str = "";
        }
        f fVar = (f) PartFragmentIOCKt.getIocInterface(this, f.class);
        if (fVar != null) {
            fVar.h(j3);
        }
        f fVar2 = (f) PartFragmentIOCKt.getIocInterface(this, f.class);
        if (fVar2 != null) {
            fVar2.a(str);
        }
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        guildFeedBaseInitBean.setBusinessType(18);
        vi1.b bVar = this.fragmentArgsIoc;
        Intrinsics.checkNotNull(bVar);
        guildFeedBaseInitBean.setGuildId(bVar.getContact().getGuildId());
        vi1.b bVar2 = this.fragmentArgsIoc;
        Intrinsics.checkNotNull(bVar2);
        guildFeedBaseInitBean.setChannelId(bVar2.getContact().getChannelId());
        b bVar3 = new b(guildFeedBaseInitBean);
        PartFragmentIOCKt.registerIoc(this, bVar3, c.class);
        this.dtReportIoc = bVar3;
    }

    private final void xh() {
        LinkedHashMap linkedMapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        VideoReport.setPageId(requireView, "pg_sgrp_forum_batch_search_result");
        VideoReport.setPageReportPolicy(requireView, PageReportPolicy.REPORT_ALL);
        vi1.b bVar = this.fragmentArgsIoc;
        Intrinsics.checkNotNull(bVar);
        String guildId = bVar.getContact().getGuildId();
        vi1.b bVar2 = this.fragmentArgsIoc;
        Intrinsics.checkNotNull(bVar2);
        linkedMapOf = MapsKt__MapsKt.linkedMapOf(TuplesKt.to("sgrp_channel_id", guildId), TuplesKt.to("sgrp_user_type", com.tencent.mobileqq.guild.feed.report.f.o(guildId)), TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, vi1.c.b(bVar2)));
        VideoReport.setPageParams(requireView, new PageParams(linkedMapOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh() {
        String str;
        long j3;
        boolean z16;
        vi1.b bVar = this.fragmentArgsIoc;
        FeedBatchManageSearchArgs feedBatchManageSearchArgs = null;
        if (bVar != null) {
            str = vi1.c.b(bVar);
        } else {
            str = null;
        }
        vi1.b bVar2 = this.fragmentArgsIoc;
        if (bVar2 != null) {
            feedBatchManageSearchArgs = vi1.c.d(bVar2);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            j3 = arguments.getLong("selected_channel_id");
        } else {
            j3 = 0;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && feedBatchManageSearchArgs != null) {
            ((FeedBatchManageSearchViewModel) getViewModel(FeedBatchManageSearchViewModel.class)).h2(str, feedBatchManageSearchArgs, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.emp;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PartFragmentIOCKt.unregisterIoc(this, f.class);
        PartFragmentIOCKt.unregisterIoc(this, c.class);
        PartFragmentIOCKt.unregisterIoc(this, vi1.b.class);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        int i3;
        if (this.hasDispatchResult) {
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("source_page_hashcode");
        } else {
            i3 = 0;
        }
        simpleEventBus.dispatchEvent(new FeedBatchManageSearchResultFragmentEvent(i3, 0, 0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFitsSystemWindows(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        xi1.b bVar;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        xh();
        vi1.a aVar = (vi1.a) PartFragmentIOCKt.getIocInterface(this, vi1.a.class);
        if (aVar != null && (bVar = this.batchManager) != null) {
            bVar.k(aVar);
        }
        rh(contentView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        vh();
        uh();
        wh();
        yh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    /* renamed from: sh, reason: merged with bridge method [inline-methods] */
    public LinkedList<Part> assembleParts() {
        LinkedList<Part> linkedList = new LinkedList<>();
        linkedList.add(new FeedBatchManageSearchResultTitlePart());
        linkedList.add(new FeedBatchManageSearchResultListPart());
        linkedList.add(new GuildFeedBatchManageBottomOperationPart(th()));
        linkedList.add(new m());
        return linkedList;
    }
}
