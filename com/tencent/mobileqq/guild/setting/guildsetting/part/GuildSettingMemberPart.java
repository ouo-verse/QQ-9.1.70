package com.tencent.mobileqq.guild.setting.guildsetting.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qzone.QzoneIPCModule;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.Cdo;
import wz1.GuildSettingMemberData;
import yz1.d;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0006J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0016\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00106R\"\u0010D\u001a\u00020=8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingMemberPart;", "Lcom/tencent/mobileqq/guild/setting/guildsetting/part/a;", "Ljava/util/ArrayList;", "Lwz1/a;", "Lkotlin/collections/ArrayList;", "list", "", "ua", "", "ea", "Lvz1/c;", "ca", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "pa", "Landroid/view/View;", "view", "", "elementId", "sa", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "D9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "initData", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "tinyId", "", "isRobot", "ra", "e", "Landroid/view/View;", "guildMemberRootView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "guildmember", "Lvz1/a;", "i", "Lvz1/a;", "adapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", BdhLogUtil.LogTag.Tag_Conn, "I", "mostCardCnt", "D", "Z", "canRemoveMember", "E", "totalMemberCnt", "Lcom/tencent/mobileqq/widget/listitem/u;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/u;", "da", "()Lcom/tencent/mobileqq/widget/listitem/u;", "ta", "(Lcom/tencent/mobileqq/widget/listitem/u;)V", DownloadInfo.spKey_Config, "<init>", "()V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingMemberPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    private int mostCardCnt;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean canRemoveMember;

    /* renamed from: E, reason: from kotlin metadata */
    private int totalMemberCnt;

    /* renamed from: F, reason: from kotlin metadata */
    public com.tencent.mobileqq.widget.listitem.u config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View guildMemberRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView guildmember;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private vz1.a adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IGProGuildInfo guildInfo;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingMemberPart$b", "Lvz1/c;", "", "tinyId", "", "isRobot", "Landroid/view/View;", "view", "", "b", "a", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements vz1.c {
        b() {
        }

        @Override // vz1.c
        public void a(@NotNull View view) {
            Activity activity;
            long j3;
            Intrinsics.checkNotNullParameter(view, "view");
            Context context = view.getContext();
            IGProGuildInfo iGProGuildInfo = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                activity = QBaseActivity.sTopActivity;
            }
            if (activity != null) {
                GuildSettingMemberPart guildSettingMemberPart = GuildSettingMemberPart.this;
                d.Companion companion = yz1.d.INSTANCE;
                IGProGuildInfo iGProGuildInfo2 = guildSettingMemberPart.guildInfo;
                if (iGProGuildInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
                } else {
                    iGProGuildInfo = iGProGuildInfo2;
                }
                String guildID = iGProGuildInfo.getGuildID();
                if (guildID != null) {
                    Intrinsics.checkNotNullExpressionValue(guildID, "guildID");
                    j3 = MiscKt.l(guildID);
                } else {
                    j3 = 0;
                }
                companion.a(activity, j3);
            }
            GuildSettingMemberPart.this.sa(view, "em_sgrp_member_list_invite_member");
        }

        @Override // vz1.c
        public void b(@NotNull String tinyId, boolean isRobot, @NotNull View view) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(view, "view");
            GuildSettingMemberPart.this.ra(tinyId, isRobot);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_touin", tinyId);
            VideoReport.setElementId(view, "em_sgrp_member_profile");
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("clck", view, hashMap);
        }

        @Override // vz1.c
        public void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            com.tencent.mobileqq.guild.performance.report.o.c();
            GuildMemberListFragment.Companion companion = GuildMemberListFragment.INSTANCE;
            Context context = GuildSettingMemberPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            IGProGuildInfo iGProGuildInfo = GuildSettingMemberPart.this.guildInfo;
            if (iGProGuildInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
                iGProGuildInfo = null;
            }
            companion.d(context, iGProGuildInfo, "", GuildSettingMemberPart.this.canRemoveMember);
            GuildSettingMemberPart.this.sa(view, "em_sgrp_remove");
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/part/GuildSettingMemberPart$c", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "view", "", "position", "", "", "payloads", "", UserInfo.SEX_FEMALE, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends com.tencent.mobileqq.widget.listitem.u {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        public void F(@NotNull View view, int position, @NotNull List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            super.F(view, position, payloads);
            GuildSettingMemberPart.this.initData();
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        protected View H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Cdo g16 = Cdo.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026  false\n                )");
            GuildSettingMemberPart guildSettingMemberPart = GuildSettingMemberPart.this;
            LinearLayout root = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            guildSettingMemberPart.guildMemberRootView = root;
            GuildSettingMemberPart guildSettingMemberPart2 = GuildSettingMemberPart.this;
            RecyclerView recyclerView = g16.f442961d;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.guildMemberRecycler");
            guildSettingMemberPart2.recyclerView = recyclerView;
            GuildSettingMemberPart guildSettingMemberPart3 = GuildSettingMemberPart.this;
            TextView textView = g16.f442959b;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildMember");
            guildSettingMemberPart3.guildmember = textView;
            LinearLayout root2 = g16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            return root2;
        }
    }

    private final vz1.c ca() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int ea() {
        int d16 = bi.d();
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        if (guildSplitViewUtils.n(getContext())) {
            int j3 = GuildSplitViewUtils.j(guildSplitViewUtils, false, null, 2, null);
            QLog.d("GuildSettingMemberPart", 4, "getScreenWidth SplitViewMode  screenWidth = " + j3);
            return j3;
        }
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(final GuildSettingMemberPart this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        yz1.q qVar;
        final int c16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i17 - i3;
        if (i29 == i27 - i19 || (c16 = (qVar = yz1.q.f451648a).c(i29)) == this$0.mostCardCnt) {
            return;
        }
        this$0.mostCardCnt = c16;
        this$0.B9().e2(qVar.a(c16));
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.aj
            @Override // java.lang.Runnable
            public final void run() {
                GuildSettingMemberPart.ha(GuildSettingMemberPart.this, c16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(GuildSettingMemberPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeGridLayoutManager(this$0.getContext(), i3, 1, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa(final IGProGuildInfo guildInfo) {
        View view = null;
        if (this.totalMemberCnt == 0) {
            String format = NumberFormat.getNumberInstance(Locale.getDefault()).format(Integer.valueOf(guildInfo.getUserNum()));
            TextView textView = this.guildmember;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildmember");
                textView = null;
            }
            textView.setText(format + "\u4eba");
        }
        View view2 = this.guildMemberRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildMemberRootView");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildSettingMemberPart.qa(GuildSettingMemberPart.this, guildInfo, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(GuildSettingMemberPart this$0, IGProGuildInfo guildInfo, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        com.tencent.mobileqq.guild.performance.report.o.c();
        GuildMemberListFragment.Companion companion = GuildMemberListFragment.INSTANCE;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.c(context, guildInfo, "");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.sa(it, "em_sgrp_cover_member_list");
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(View view, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(ArrayList<GuildSettingMemberData> list) {
        list.add(new GuildSettingMemberData("", "\u9080\u8bf7", null, 2));
        list.add(new GuildSettingMemberData("", "\u79fb\u9664", null, 3));
    }

    @Override // com.tencent.mobileqq.guild.setting.guildsetting.part.a
    @NotNull
    public Group[] D9() {
        return new Group[]{new Group(da())};
    }

    @NotNull
    public final com.tencent.mobileqq.widget.listitem.u da() {
        com.tencent.mobileqq.widget.listitem.u uVar = this.config;
        if (uVar != null) {
            return uVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        return null;
    }

    public final void initData() {
        this.mostCardCnt = yz1.q.f451648a.b(ea());
        this.adapter = new vz1.a(getGuildId(), ca());
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), this.mostCardCnt, 1, false);
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(safeGridLayoutManager);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        vz1.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        recyclerView3.setAdapter(aVar);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.ac
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildSettingMemberPart.ga(GuildSettingMemberPart.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        LiveData<List<IGProUserInfo>> n26 = B9().n2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends IGProUserInfo>, Unit> function1 = new Function1<List<? extends IGProUserInfo>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingMemberPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends IGProUserInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends IGProUserInfo> list) {
                int i3;
                vz1.a aVar2;
                int i16;
                ArrayList arrayList = new ArrayList();
                for (IGProUserInfo iGProUserInfo : list) {
                    String tinyId = iGProUserInfo.getTinyId();
                    Intrinsics.checkNotNullExpressionValue(tinyId, "userInfo.tinyId");
                    String name = iGProUserInfo.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "userInfo.displayName");
                    arrayList.add(new GuildSettingMemberData(tinyId, name, iGProUserInfo, 0, 8, null));
                }
                int size = arrayList.size();
                yz1.q qVar = yz1.q.f451648a;
                i3 = GuildSettingMemberPart.this.mostCardCnt;
                if (size == qVar.a(i3)) {
                    CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                }
                Boolean value = GuildSettingMemberPart.this.B9().h2().getValue();
                Boolean bool = Boolean.TRUE;
                vz1.a aVar3 = null;
                if (Intrinsics.areEqual(value, bool)) {
                    int size2 = arrayList.size() + 1;
                    i16 = GuildSettingMemberPart.this.mostCardCnt;
                    if (size2 == qVar.a(i16)) {
                        CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                    }
                    GuildSettingMemberPart.this.ua(arrayList);
                } else {
                    arrayList.add(new GuildSettingMemberData("", "\u9080\u8bf7", null, 2));
                }
                if (Intrinsics.areEqual(GuildSettingMemberPart.this.B9().h2().getValue(), bool)) {
                    GuildSettingMemberPart.this.canRemoveMember = true;
                }
                aVar2 = GuildSettingMemberPart.this.adapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    aVar3 = aVar2;
                }
                aVar3.submitList(arrayList);
            }
        };
        n26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingMemberPart.ia(Function1.this, obj);
            }
        });
        LiveData<IGProGuildInfo> j26 = B9().j2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function12 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingMemberPart$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                if (iGProGuildInfo != null) {
                    GuildSettingMemberPart.this.guildInfo = iGProGuildInfo;
                    GuildSettingMemberPart.this.pa(iGProGuildInfo);
                }
            }
        };
        j26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingMemberPart.ja(Function1.this, obj);
            }
        });
        LiveData<Boolean> g26 = B9().g2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingMemberPart$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                vz1.a aVar2;
                aVar2 = GuildSettingMemberPart.this.adapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    aVar2 = null;
                }
                aVar2.notifyDataSetChanged();
            }
        };
        g26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingMemberPart.la(Function1.this, obj);
            }
        });
        LiveData<Integer> o26 = B9().o2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingMemberPart$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer cnt) {
                TextView textView;
                GuildSettingMemberPart guildSettingMemberPart = GuildSettingMemberPart.this;
                Intrinsics.checkNotNullExpressionValue(cnt, "cnt");
                guildSettingMemberPart.totalMemberCnt = cnt.intValue();
                String format = NumberFormat.getNumberInstance(Locale.getDefault()).format(cnt);
                textView = GuildSettingMemberPart.this.guildmember;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildmember");
                    textView = null;
                }
                textView.setText(format + "\u4eba");
            }
        };
        o26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingMemberPart.ma(Function1.this, obj);
            }
        });
        LiveData<Boolean> R1 = B9().getGuildSettingPermissionViewModel().R1();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingMemberPart$initData$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (Intrinsics.areEqual(GuildSettingMemberPart.this.B9().h2().getValue(), bool)) {
                    return;
                }
                GuildSettingMemberPart.this.B9().t2();
                GuildSettingMemberPart.this.B9().w2();
            }
        };
        R1.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingMemberPart.na(Function1.this, obj);
            }
        });
        LiveData<String> r26 = B9().r2();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function16 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingMemberPart$initData$7
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
            public final void invoke2(String str) {
                int ea5;
                ea5 = GuildSettingMemberPart.this.ea();
                yz1.q qVar = yz1.q.f451648a;
                GuildSettingMemberPart.this.B9().e2(qVar.a(qVar.b(ea5)));
            }
        };
        r26.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.part.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingMemberPart.oa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildSettingMemberPart", 2, "onActivityResult " + requestCode + ", " + resultCode + ", " + data);
        }
        if (-1 == resultCode && requestCode == 6666) {
            IGProGuildInfo iGProGuildInfo = this.guildInfo;
            if (iGProGuildInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
                iGProGuildInfo = null;
            }
            yz1.g.d(iGProGuildInfo, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ta(new c());
    }

    public final void ra(@NotNull String tinyId, boolean isRobot) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        GuildMemberListFragment.PendingAction pendingAction = new GuildMemberListFragment.PendingAction(null, false, 3, 0 == true ? 1 : 0);
        pendingAction.setRobot(isRobot);
        pendingAction.setTinyId(tinyId);
        if (isRobot) {
            RobotInfoFragment.wh(x9(), "", getGuildId(), tinyId, "", "1", false, 14);
        } else {
            GuildProfileCard.Lh(x9(), new GuildProfileData(getGuildId(), "", tinyId, 0, 1));
        }
    }

    public final void ta(@NotNull com.tencent.mobileqq.widget.listitem.u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<set-?>");
        this.config = uVar;
    }
}
