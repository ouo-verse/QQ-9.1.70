package com.tencent.mobileqq.guild.feed.batchmanage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Supplier;
import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.feed.batchmanage.delegate.FeedBatchManageBottomOperationPartDependencyDefaultImpl;
import com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerPart;
import com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageInteractStateViewControllerViewDependenciesImpl;
import com.tencent.mobileqq.guild.feed.batchmanage.part.FeedBatchManageManualReportPart;
import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart;
import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageCooperatePart;
import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageFeedListPart;
import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageTitlePart;
import com.tencent.mobileqq.guild.feed.batchmanage.part.u;
import com.tencent.mobileqq.guild.feed.batchmanage.search.part.FeedBatchManageSearchLayerPart;
import com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.widget.immersive.ImmersiveUtils;
import ij1.g;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vi1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0002\f'\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J2\u0010\r\u001a\u00020\f2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "uh", "th", "vh", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "batchOperationType", "onBatchOperationFinished", "com/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment$b", "rh", "(Lkotlin/jvm/functions/Function1;)Lcom/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment$b;", "wh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedBeforePartInit", "Ljava/util/LinkedList;", "Lcom/tencent/biz/richframework/part/Part;", "qh", "onViewCreatedAfterPartInit", "getContentLayoutId", "", "needImmersive", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lxi1/b;", BdhLogUtil.LogTag.Tag_Conn, "Lxi1/b;", "batchManager", "Lxj1/c;", "D", "Lxj1/c;", "dtReportIoc", "com/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment$fragmentArgsIoc$1", "E", "Lcom/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment$fragmentArgsIoc$1;", "fragmentArgsIoc", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedBatchManageFragment extends QPublicBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private xi1.b batchManager;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private xj1.c dtReportIoc;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedBatchManageFragment$fragmentArgsIoc$1 fragmentArgsIoc = new GuildFeedBatchManageFragment$fragmentArgsIoc$1(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment$a;", "", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "a", "", "mGuildId", "Landroid/content/Intent;", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.batchmanage.GuildFeedBatchManageFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildFeedMainInitBean a(@NotNull GuildFeedBaseInitBean bean) {
            String str;
            Intrinsics.checkNotNullParameter(bean, "bean");
            GuildFeedMainInitBean guildFeedMainInitBean = new GuildFeedMainInitBean();
            guildFeedMainInitBean.setBusinessType(18);
            if (bean.getBusinessType() != 16 && bean.getBusinessType() != 14) {
                str = bean.getChannelId();
            } else {
                str = "0";
            }
            guildFeedMainInitBean.setChannelId(str);
            guildFeedMainInitBean.setGuildId(bean.getGuildId());
            guildFeedMainInitBean.setChannelName(bean.getChannelName());
            HashMap<String, Serializable> attrs = guildFeedMainInitBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
            attrs.put("attr_src_business_type", Integer.valueOf(bean.getBusinessType()));
            HashMap<String, Serializable> attrs2 = guildFeedMainInitBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs2, "attrs");
            attrs2.put("key_channel_id", bean.getChannelId());
            return guildFeedMainInitBean;
        }

        @NotNull
        public final Intent b(@NotNull String mGuildId) {
            Intrinsics.checkNotNullParameter(mGuildId, "mGuildId");
            Intent intent = new Intent();
            GuildFeedMainInitBean guildFeedMainInitBean = new GuildFeedMainInitBean();
            guildFeedMainInitBean.setBusinessType(18);
            guildFeedMainInitBean.setGuildId(mGuildId);
            guildFeedMainInitBean.setChannelId("0");
            guildFeedMainInitBean.setChannelName("");
            HashMap<String, Serializable> attrs = guildFeedMainInitBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
            attrs.put("attr_src_business_type", Integer.valueOf(guildFeedMainInitBean.getBusinessType()));
            HashMap<String, Serializable> attrs2 = guildFeedMainInitBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs2, "attrs");
            attrs2.put("key_channel_id", guildFeedMainInitBean.getChannelId());
            intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedMainInitBean);
            intent.putExtra("source", "source_from_guild_setting");
            return intent;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment$b", "Lcom/tencent/mobileqq/guild/feed/batchmanage/delegate/FeedBatchManageBottomOperationPartDependencyDefaultImpl;", "", "operationType", "", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends FeedBatchManageBottomOperationPartDependencyDefaultImpl {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f218141f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Integer, Unit> function1, IGuildParcelizeSimpleContact iGuildParcelizeSimpleContact, Supplier<LiveData<UIStateData<List<g>>>> supplier) {
            super(iGuildParcelizeSimpleContact, supplier);
            this.f218141f = function1;
        }

        @Override // com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart.a
        public void d(int operationType) {
            this.f218141f.invoke(Integer.valueOf(operationType));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/GuildFeedBatchManageFragment$c", "Lxj1/c;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "b", "", "getGuildId", "", "getBusinessType", "a", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "d", "getChannelName", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements xj1.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedMainInitBean f218142a;

        c(GuildFeedMainInitBean guildFeedMainInitBean) {
            this.f218142a = guildFeedMainInitBean;
        }

        @Override // xj1.c
        public int a() {
            return this.f218142a.getImmersiveSource();
        }

        @Override // xj1.c
        @NotNull
        public JumpGuildParam.JoinInfoParam b() {
            return new JumpGuildParam.JoinInfoParam();
        }

        @Override // xj1.c
        @NotNull
        /* renamed from: d, reason: from getter and merged with bridge method [inline-methods] */
        public GuildFeedMainInitBean getInitBean() {
            return this.f218142a;
        }

        @Override // xj1.c
        public int getBusinessType() {
            return this.f218142a.getBusinessType();
        }

        @Override // xj1.c
        @NotNull
        public String getChannelName() {
            String channelName = this.f218142a.getChannelName();
            if (channelName == null) {
                return "";
            }
            return channelName;
        }

        @Override // xj1.c
        @NotNull
        public String getGuildId() {
            String guildId = this.f218142a.getGuildId();
            if (guildId == null) {
                return "";
            }
            return guildId;
        }
    }

    private final b rh(Function1<? super Integer, Unit> onBatchOperationFinished) {
        return new b(onBatchOperationFinished, this.fragmentArgsIoc.getContact(), new Supplier() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.a
            @Override // androidx.core.util.Supplier
            public final Object get() {
                LiveData sh5;
                sh5 = GuildFeedBatchManageFragment.sh(GuildFeedBatchManageFragment.this);
                return sh5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData sh(GuildFeedBatchManageFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        e eVar = (e) this$0.getViewModel(e.class);
        if (eVar != null) {
            return eVar.b2();
        }
        return null;
    }

    private final void th() {
        xi1.b bVar = new xi1.b();
        PartFragmentIOCKt.registerIoc(this, bVar, f.class);
        this.batchManager = bVar;
    }

    private final void uh() {
        String str;
        String str2;
        List<g> list;
        UIStateData<List<g>> value;
        co1.f fVar;
        Bundle arguments = getArguments();
        Map<String, Object> map = null;
        if (arguments != null) {
            str = arguments.getString("data_surface_key_feed_list_data");
        } else {
            str = null;
        }
        boolean z16 = true;
        QLog.d("GuildFeedBatchManageViewModel", 1, "init dataSurfaceKey   == " + str);
        e eVar = (e) getViewModel(e.class);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("data_surface_key_data_type");
        } else {
            str2 = null;
        }
        eVar.r2(str2);
        if (TextUtils.isEmpty(str)) {
            eVar.X1(this.fragmentArgsIoc.getContact().getGuildId(), false);
        } else {
            eVar.q2(jj1.b.c().getDisplaySurface(g.class, str));
            LiveData<UIStateData<List<g>>> a26 = eVar.a2();
            if (a26 != null && (value = a26.getValue()) != null) {
                list = value.getData();
            } else {
                list = null;
            }
            if (list != null && list.size() < 10) {
                QLog.d(QPublicBaseFragment.TAG, 1, " dataSize < 10 ");
                eVar.q2(null);
                String channelId = this.fragmentArgsIoc.getContact().getChannelId();
                if (channelId.length() != 0) {
                    z16 = false;
                }
                if (!z16 && !Intrinsics.areEqual(channelId, "0")) {
                    eVar.U1(this.fragmentArgsIoc.getContact().getGuildId(), channelId, false);
                } else {
                    eVar.X1(this.fragmentArgsIoc.getContact().getGuildId(), false);
                }
            }
        }
        IDataDisplaySurface<g> Z1 = eVar.Z1();
        if (Z1 instanceof co1.f) {
            fVar = (co1.f) Z1;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            map = fVar.getExtra();
        }
        eVar.g2(this.fragmentArgsIoc.getContact().getGuildId(), this.fragmentArgsIoc.getContact().getChannelId(), map);
    }

    private final void vh() {
        Serializable serializable;
        Bundle arguments = getArguments();
        GuildFeedMainInitBean guildFeedMainInitBean = null;
        if (arguments != null) {
            serializable = arguments.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a);
        } else {
            serializable = null;
        }
        if (serializable instanceof GuildFeedMainInitBean) {
            guildFeedMainInitBean = (GuildFeedMainInitBean) serializable;
        }
        if (guildFeedMainInitBean != null) {
            this.dtReportIoc = new c(guildFeedMainInitBean);
            RFWIocAbilityProvider.g().registerIoc(getView(), this.dtReportIoc, xj1.c.class);
        }
    }

    private final void wh() {
        String str;
        LinkedHashMap linkedMapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        View findViewById = requireView().findViewById(R.id.f166090ed2);
        VideoReport.setPageId(findViewById, "pg_sgrp_forum_batch_manage");
        VideoReport.setPageReportPolicy(findViewById, PageReportPolicy.REPORT_NONE);
        xj1.c cVar = this.dtReportIoc;
        if (cVar != null) {
            str = cVar.getGuildId();
        } else {
            str = null;
        }
        linkedMapOf = MapsKt__MapsKt.linkedMapOf(TuplesKt.to("sgrp_user_type", com.tencent.mobileqq.guild.feed.report.f.o(str)), TuplesKt.to("sgrp_channel_id", str));
        VideoReport.setPageParams(findViewById, new PageParams(linkedMapOf));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.emp;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PartFragmentIOCKt.unregisterIoc(this, f.class);
        PartFragmentIOCKt.unregisterIoc(this, xj1.c.class);
        PartFragmentIOCKt.unregisterIoc(this, vi1.b.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPadding(view.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(getContext()), view.getPaddingRight(), view.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        xi1.b bVar;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        wh();
        vi1.e eVar = (vi1.e) PartFragmentIOCKt.getIocInterface(this, vi1.e.class);
        if (eVar != null && (bVar = this.batchManager) != null) {
            bVar.k(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        uh();
        PartFragmentIOCKt.registerIoc(this, this.fragmentArgsIoc, vi1.b.class);
        th();
        vh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    /* renamed from: qh, reason: merged with bridge method [inline-methods] */
    public LinkedList<Part> assembleParts() {
        LinkedList<Part> linkedList = new LinkedList<>();
        GuildFeedBatchManageCooperatePart guildFeedBatchManageCooperatePart = new GuildFeedBatchManageCooperatePart();
        linkedList.add(guildFeedBatchManageCooperatePart);
        linkedList.add(new GuildFeedBatchManageTitlePart());
        linkedList.add(new GuildFeedBatchManageFeedListPart());
        linkedList.add(new GuildFeedBatchManageBottomOperationPart(rh(new GuildFeedBatchManageFragment$assembleParts$1$1(guildFeedBatchManageCooperatePart))));
        linkedList.add(new FeedBatchManageSearchLayerPart());
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        PartManager partManager = getPartManager();
        Intrinsics.checkNotNullExpressionValue(partManager, "partManager");
        FeedBatchManageInteractStateViewControllerViewDependenciesImpl feedBatchManageInteractStateViewControllerViewDependenciesImpl = new FeedBatchManageInteractStateViewControllerViewDependenciesImpl(requireView, partManager);
        linkedList.add(new u(this.fragmentArgsIoc.getContact().getGuildId()));
        linkedList.add(new FeedBatchManageInteractStateViewControllerPart(feedBatchManageInteractStateViewControllerViewDependenciesImpl));
        linkedList.add(new FeedBatchManageManualReportPart(feedBatchManageInteractStateViewControllerViewDependenciesImpl));
        return linkedList;
    }
}
