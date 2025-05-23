package com.tencent.mobileqq.guild.setting.guildmanage.speak.rule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0014J$\u0010\"\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\u001a\u0010#\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\u0002H\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\"\u00104\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b=\u0010/R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010F\u001a\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildSpeakRuleManageFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "initView", "", "left", "Landroid/view/View$OnClickListener;", "listener", "", "elementId", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Zh", "Landroid/view/View;", "view", "Qh", "Rh", "Ph", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Jh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Vh", "initViewModel", "Sh", "Wh", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "T", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildRolePartUnlimitedView;", "U", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildRolePartUnlimitedView;", "mRolePartVew", "V", "Ljava/lang/String;", "Nh", "()Ljava/lang/String;", "Xh", "(Ljava/lang/String;)V", "mGuildId", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;", "W", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;", "Oh", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;", "Yh", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/ad;)V", "mViewModel", "X", "M_GUILD_INFO_IS_NULL", "Lcom/tencent/mobileqq/guild/api/IQQGuildRouterApi;", "Y", "Lcom/tencent/mobileqq/guild/api/IQQGuildRouterApi;", "mRouteApi", "Ljava/util/HashMap;", "Z", "Ljava/util/HashMap;", "mReportParams", "<init>", "()V", "a0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSpeakRuleManageFragment extends QQGuildTitleBarFragment {

    /* renamed from: T, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: U, reason: from kotlin metadata */
    private GuildRolePartUnlimitedView mRolePartVew;

    /* renamed from: V, reason: from kotlin metadata */
    public String mGuildId;

    /* renamed from: W, reason: from kotlin metadata */
    public ad mViewModel;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final String M_GUILD_INFO_IS_NULL = "mGuildInfo is null.";

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final IQQGuildRouterApi mRouteApi;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, ?> mReportParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/speak/rule/GuildSpeakRuleManageFragment$b", "Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/rule/BaseGuildRolePartUnlimitedView$b;", "Landroid/view/View;", "v", "", "elementId", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements BaseGuildRolePartUnlimitedView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.BaseGuildRolePartUnlimitedView.b
        public void a(@NotNull View v3, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(v3, elementId, null);
        }
    }

    public GuildSpeakRuleManageFragment() {
        QRouteApi api = QRoute.api(IQQGuildRouterApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n        IQQGuildRouterApi::class.java\n    )");
        this.mRouteApi = (IQQGuildRouterApi) api;
        this.mReportParams = new HashMap<>();
    }

    private final Group[] Jh() {
        Group[] groupArr = new Group[2];
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[2];
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Zh = Zh(R.string.f157261mf, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSpeakRuleManageFragment.Kh(GuildSpeakRuleManageFragment.this, view);
            }
        }, "em_sgrp_channel_set_speak_threshold");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        QUIListItemAdapter qUIListItemAdapter2 = null;
        if (qUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qUIListItemAdapter = null;
        }
        aVarArr[0] = Zh.l(viewLifecycleOwner, qUIListItemAdapter).d();
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Zh2 = Zh(R.string.f157141m4, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSpeakRuleManageFragment.Lh(GuildSpeakRuleManageFragment.this, view);
            }
        }, "em_sgrp_channel_set_speak_rule");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        QUIListItemAdapter qUIListItemAdapter3 = this.adapter;
        if (qUIListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qUIListItemAdapter3 = null;
        }
        aVarArr[1] = Zh2.l(viewLifecycleOwner2, qUIListItemAdapter3).d();
        groupArr[0] = new Group(aVarArr);
        com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = new com.tencent.mobileqq.widget.listitem.a[1];
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Zh3 = Zh(R.string.f157001lq, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSpeakRuleManageFragment.Mh(GuildSpeakRuleManageFragment.this, view);
            }
        }, "em_sgrp_channel_set_speak_private");
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        QUIListItemAdapter qUIListItemAdapter4 = this.adapter;
        if (qUIListItemAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            qUIListItemAdapter2 = qUIListItemAdapter4;
        }
        aVarArr2[0] = Zh3.l(viewLifecycleOwner3, qUIListItemAdapter2).d();
        groupArr[1] = new Group(aVarArr2);
        return groupArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(GuildSpeakRuleManageFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Rh(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(GuildSpeakRuleManageFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Qh(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(GuildSpeakRuleManageFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Ph(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void Ph(View view) {
        if (QQGuildUIUtil.v()) {
            return;
        }
        this.mRouteApi.openPrivateLetterThresholdManageFragment(getContext(), Nh());
        VideoReport.reportEvent("clck", view, this.mReportParams);
    }

    private final void Qh(View view) {
        if (QQGuildUIUtil.v()) {
            return;
        }
        this.mRouteApi.openSpeakRuleSetting(getContext(), Nh());
        VideoReport.reportEvent("clck", view, this.mReportParams);
    }

    private final void Rh(View view) {
        if (QQGuildUIUtil.v()) {
            return;
        }
        this.mRouteApi.openSpeakingThresholdManageFragment(getContext(), Nh());
        VideoReport.reportEvent("clck", view, this.mReportParams);
    }

    private final void Sh() {
        Oh().T1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSpeakRuleManageFragment.Th(GuildSpeakRuleManageFragment.this, (cf1.b) obj);
            }
        });
        Oh().R1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSpeakRuleManageFragment.Uh(GuildSpeakRuleManageFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(GuildSpeakRuleManageFragment this$0, cf1.b bVar) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bVar != null) {
            if (bVar.f30775b != 0 || !ch.p(bVar.f30776c)) {
                if (TextUtils.isEmpty(bVar.f30774a)) {
                    str = HardCodeUtil.qqStr(R.string.f155831ik);
                } else {
                    str = bVar.f30774a;
                }
                SecurityTipHelperKt.N(bVar.f30776c, this$0.getContext(), bVar.f30775b, str, false, null, 48, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(GuildSpeakRuleManageFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            HashMap hashMap = new HashMap();
            Boolean value = this$0.Oh().c2().getValue();
            Boolean bool = Boolean.TRUE;
            hashMap.put("sgrp_no_redpacket_switch_type", Integer.valueOf(Intrinsics.areEqual(value, bool) ? 1 : 0));
            hashMap.put("sgrp_no_link_switch_type", Integer.valueOf(Intrinsics.areEqual(this$0.Oh().a2().getValue(), bool) ? 1 : 0));
            hashMap.put("sgrp_no_qr_switch_type", Integer.valueOf(Intrinsics.areEqual(this$0.Oh().b2().getValue(), bool) ? 1 : 0));
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this$0.P, this$0.Nh(), hashMap);
        }
    }

    private final void Vh() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            String stringExtra = intent.getStringExtra("extra_guild_id");
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(QQGuildCo\u2026EXTRA_KEY_GUILD_ID) ?: \"\"");
            }
            Xh(stringExtra);
            if (QLog.isColorLevel()) {
                QLog.d("QQGuildCustomTitleBarFragment", 1, "resolveIntent guildId = " + Nh());
            }
        }
    }

    private final void Wh() {
        Map mutableMapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_speak_manage");
        View view = this.P;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_channel_id", Nh()), TuplesKt.to("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(Nh()))));
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) mutableMapOf));
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> Zh(@StringRes int left, View.OnClickListener listener, final String elementId) {
        x.Companion companion = com.tencent.mobileqq.widget.listitem.x.INSTANCE;
        String string = getString(left);
        Intrinsics.checkNotNullExpressionValue(string, "getString(left)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> b16 = x.Companion.b(companion, string, null, 2, null);
        b16.x(listener);
        b16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.n
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildSpeakRuleManageFragment.ai(elementId, view);
            }
        });
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(String elementId, View view) {
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        VideoReport.setElementReuseIdentifier(view, elementId);
        ch.Y0(view, elementId, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL);
    }

    private final void initView() {
        this.E.setText(getString(R.string.f156991lp));
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) this.P.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.adapter = qUIListItemAdapter;
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        QUIListItemAdapter qUIListItemAdapter2 = this.adapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qUIListItemAdapter2 = null;
        }
        Group[] Jh = Jh();
        qUIListItemAdapter2.t0((Group[]) Arrays.copyOf(Jh, Jh.length));
        Context context = this.P.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mContentView.context");
        GuildRolePartUnlimitedView guildRolePartUnlimitedView = new GuildRolePartUnlimitedView(context);
        this.mRolePartVew = guildRolePartUnlimitedView;
        guildRolePartUnlimitedView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private final void initViewModel() {
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(this, ad.INSTANCE.a()).get(ad.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026ingViewModel::class.java)");
        Yh((ad) viewModel);
        Oh().W1(Nh());
        Sh();
    }

    @NotNull
    public final String Nh() {
        String str = this.mGuildId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildId");
        return null;
    }

    @NotNull
    public final ad Oh() {
        ad adVar = this.mViewModel;
        if (adVar != null) {
            return adVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        return null;
    }

    public final void Xh(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGuildId = str;
    }

    public final void Yh(@NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "<set-?>");
        this.mViewModel = adVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        Vh();
        initViewModel();
        initView();
        Wh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168155f35;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Oh().removeObserver();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Oh().addObserver();
        GuildRolePartUnlimitedView guildRolePartUnlimitedView = this.mRolePartVew;
        GuildRolePartUnlimitedView guildRolePartUnlimitedView2 = null;
        if (guildRolePartUnlimitedView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
            guildRolePartUnlimitedView = null;
        }
        guildRolePartUnlimitedView.Y();
        GuildRolePartUnlimitedView guildRolePartUnlimitedView3 = this.mRolePartVew;
        if (guildRolePartUnlimitedView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
        } else {
            guildRolePartUnlimitedView2 = guildRolePartUnlimitedView3;
        }
        guildRolePartUnlimitedView2.a0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        GuildRolePartUnlimitedView guildRolePartUnlimitedView = this.mRolePartVew;
        if (guildRolePartUnlimitedView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRolePartVew");
            guildRolePartUnlimitedView = null;
        }
        guildRolePartUnlimitedView.setParams(this, Nh(), "", new b());
    }
}
