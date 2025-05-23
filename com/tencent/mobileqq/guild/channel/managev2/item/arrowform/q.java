package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMsgIntent;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.b;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dg;
import com.tencent.mobileqq.qqguildsdk.data.dh;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\f2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0018H\u0016R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/q;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", "", "t", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/dg;", "Lkotlin/collections/ArrayList;", "infoList", "", "channelId", "", "p", "Landroid/view/View;", "view", "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "l", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/channel/managev2/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "I", "subAdminMaxNum", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class q extends ChannelSettingBaseVM {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int subAdminMaxNum;

    private final int p(ArrayList<dg> infoList, String channelId) {
        Iterator<T> it = infoList.iterator();
        while (it.hasNext()) {
            ArrayList<dh> a16 = ((dg) it.next()).a();
            Intrinsics.checkNotNullExpressionValue(a16, "categoryAdminInfo.channelAdminList");
            for (dh dhVar : a16) {
                if (Intrinsics.areEqual(dhVar.getChannelId(), channelId)) {
                    return dhVar.a();
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(View view) {
        List emptyList;
        Boolean bool;
        Pair pair;
        String string = ch.i().getString(R.string.f14905119);
        Intrinsics.checkNotNullExpressionValue(string, "appContext().getString(R\u2026manage_sub_channel_admin)");
        int type = ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getType();
        if (type != 1) {
            if (type != 2) {
                if (type == 5) {
                    string = ch.i().getString(R.string.f141510gv);
                    Intrinsics.checkNotNullExpressionValue(string, "appContext().getString(R\u2026guild_channel_live_admin)");
                }
            } else {
                string = ch.i().getString(R.string.f142070id);
                Intrinsics.checkNotNullExpressionValue(string, "appContext().getString(R\u2026uild_channel_voice_admin)");
            }
        } else {
            string = ch.i().getString(R.string.f1488610q);
            Intrinsics.checkNotNullExpressionValue(string, "appContext().getString(R\u2026_manage_chat_group_admin)");
        }
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getType() == 7) {
            String guildId = ((ChannelSettingMviContext) getMContext()).getParams().getGuildId();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean contains = emptyList.contains(guildId);
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            String str = "";
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
            if (guildInfo != null) {
                bool = Boolean.valueOf(guildInfo.isMovePostSection());
            } else {
                bool = null;
            }
            if (contains) {
                pair = TuplesKt.to(Boolean.TRUE, "HardCode");
            } else if (bool == null) {
                pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
            } else {
                pair = TuplesKt.to(bool, "GuildInfo");
            }
            GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
            String str2 = guildDebugUtils.e().get(guildId);
            if (str2 != null) {
                str = str2;
            }
            Intrinsics.checkNotNullExpressionValue(str, "newFeedSquareResults.get(guildId) ?: \"\"");
            String pair2 = pair.toString();
            if (!Intrinsics.areEqual(str, pair2)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + guildId + MsgSummary.STR_COLON + pair2);
                }
                guildDebugUtils.e().put(guildId, pair2);
            }
            if (((Boolean) pair.getFirst()).booleanValue()) {
                ChannelSettingUtils.j(view, "em_sgrp_section_admin_set", null, 4, null);
                string = ch.i().getString(R.string.f141140fv);
                Intrinsics.checkNotNullExpressionValue(string, "appContext().getString(R\u2026uild_channel_board_admin)");
                GuildCommonViewMemberFragment.ki(((ChannelSettingMviContext) getMContext()).c().getActivity(), new GuildRoleMemberParamData(((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), string, 2, 3).setSubChannelId(((ChannelSettingMviContext) getMContext()).getParams().getChannelId()).setRoleGroupId("5").setMaxCountCanSelect(this.subAdminMaxNum).setSubTitleStr(((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getChannelName()).setActivityRequestCode(2001).setOpenPageSlideType(2).setNextAddPageTitle(ch.i().getString(R.string.f1488410o)));
            }
        }
        s(view);
        GuildCommonViewMemberFragment.ki(((ChannelSettingMviContext) getMContext()).c().getActivity(), new GuildRoleMemberParamData(((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), string, 2, 3).setSubChannelId(((ChannelSettingMviContext) getMContext()).getParams().getChannelId()).setRoleGroupId("5").setMaxCountCanSelect(this.subAdminMaxNum).setSubTitleStr(((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getChannelName()).setActivityRequestCode(2001).setOpenPageSlideType(2).setNextAddPageTitle(ch.i().getString(R.string.f1488410o)));
    }

    private final void s(View view) {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        ChannelSettingUtils.i(view, "em_sgrp_sub_channel_set_submanager", emptyMap);
    }

    private final void t(final ChannelSettingMviContext context) {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchChannelAdminInfoList(context.getParams().getGuildId(), context.getParams().getChannelId(), new vh2.e() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.arrowform.p
            @Override // vh2.e
            public final void onResult(int i3, String str, ArrayList arrayList, int i16, boolean z16) {
                q.u(q.this, context, i3, str, arrayList, i16, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(q this$0, ChannelSettingMviContext context, int i3, String str, ArrayList infoList, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchChannelAdminInfoList code=" + i3 + " msg=" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(FrameworkVM.TAG, 1, (String) it.next(), null);
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger2.d().d(FrameworkVM.TAG, 1, "fetchChannelAdminInfoList code=0 msg=" + str + " adminMaxNum:" + i16 + " infoList:" + infoList);
        }
        this$0.subAdminMaxNum = i16;
        this$0.updateUI(new ChannelSettingUIState.SettingItemEnableUIState(z16));
        Intrinsics.checkNotNullExpressionValue(infoList, "infoList");
        this$0.updateUI(new ChannelSettingUIState.SettingItemDescUIState(this$0.p(infoList, context.getParams().getChannelId()) + "\u540d\u6210\u5458"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM
    public void l(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof ChannelSettingMsgIntent.ChannelInfoChange) {
            t((ChannelSettingMviContext) getMContext());
        } else if (intent instanceof ChannelSettingMsgIntent.PermissionChange) {
            t((ChannelSettingMviContext) getMContext());
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m */
    public void onCreate(@NotNull ChannelSettingMviContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        t(context);
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(ChannelSettingMsgIntent.ChannelInfoChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(ChannelSettingMsgIntent.PermissionChange.class).getQualifiedName()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.guild.channel.managev2.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C7685b) {
            r(((b.C7685b) intent).getView());
        }
    }
}
