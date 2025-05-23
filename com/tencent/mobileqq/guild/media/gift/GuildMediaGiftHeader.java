package com.tencent.mobileqq.guild.media.gift;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001H\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001_B\u0011\b\u0016\u0012\u0006\u0010S\u001a\u00020R\u00a2\u0006\u0004\bT\u0010UB\u001b\b\u0016\u0012\u0006\u0010S\u001a\u00020R\u0012\b\u0010W\u001a\u0004\u0018\u00010V\u00a2\u0006\u0004\bT\u0010XB#\b\u0016\u0012\u0006\u0010S\u001a\u00020R\u0012\b\u0010W\u001a\u0004\u0018\u00010V\u0012\u0006\u0010Z\u001a\u00020Y\u00a2\u0006\u0004\bT\u0010[B/\b\u0016\u0012\u0006\u0010S\u001a\u00020R\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\\\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\bT\u0010]BA\b\u0016\u0012\u0006\u0010S\u001a\u00020R\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\\\u001a\u0004\u0018\u00010\"\u0012\b\u0010W\u001a\u0004\u0018\u00010V\u0012\u0006\u0010Z\u001a\u00020Y\u00a2\u0006\u0004\bT\u0010^J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0019\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\f\u0010\bJ\u0019\u0010\r\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000eH\u0002J\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0002\u00a2\u0006\u0004\b\u0012\u0010\bJ\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0019\u0010\u001a\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u001a\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u0003H\u0014J\b\u0010!\u001a\u00020\u0003H\u0014R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u001c\u00107\u001a\n 4*\u0004\u0018\u000103038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010;\u001a\n 4*\u0004\u0018\u000108088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010=\u001a\n 4*\u0004\u0018\u00010-0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010/R\u0018\u0010?\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010$R\u0018\u0010B\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR$\u0010G\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010D\u0012\u0004\u0012\u00020\u00030C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001b\u0010Q\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/guild/media/gift/GuildMediaGiftHeader;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/mobileqq/guild/gift/module/j;", "", "M0", "", "defaultReceiverId", "N0", "(Ljava/lang/Long;)V", "K0", "()Ljava/lang/Long;", "tinyId", "R0", "U0", "", "nickName", "V0", "L0", "T0", "Q0", "P0", "", "show", "S0", "str", "O0", "setReceiver", "Lcom/tencent/mobileqq/guild/gift/module/i;", "callback", "setSelectCallback", "tabId", "setSelectedTab", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "e", "J", "mUserTinyId", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "f", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mAvatar", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mUserNameTv", "i", "mSelectPromptTv", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "mSelectContainer", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mMoreStarIcon", "D", "mGetStarPromptTv", "E", "mLogicParentView", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/gift/module/i;", "mSelectCallback", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;", "G", "Lkotlin/jvm/functions/Function1;", "mGiftUserReceiveCallback", "com/tencent/mobileqq/guild/media/gift/GuildMediaGiftHeader$b", "H", "Lcom/tencent/mobileqq/guild/media/gift/GuildMediaGiftHeader$b;", "mGProObserver", "Ljava/lang/Runnable;", "I", "Lkotlin/Lazy;", "J0", "()Ljava/lang/Runnable;", "adjustUserNameRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "logicParentView", "(Landroid/content/Context;Ljava/lang/Long;Lcom/tencent/mobileqq/guild/gift/module/i;Landroid/view/View;)V", "(Landroid/content/Context;Ljava/lang/Long;Lcom/tencent/mobileqq/guild/gift/module/i;Landroid/view/View;Landroid/util/AttributeSet;I)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaGiftHeader extends ConstraintLayout implements com.tencent.mobileqq.guild.gift.module.j {

    /* renamed from: C, reason: from kotlin metadata */
    private final ImageView mMoreStarIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView mGetStarPromptTv;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mLogicParentView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.gift.module.i mSelectCallback;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Function1<? super RoleGroupUserUIData, Unit> mGiftUserReceiveCallback;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b mGProObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy adjustUserNameRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mUserTinyId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildUserAvatarView mAvatar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mUserNameTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mSelectPromptTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mSelectContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J^\u0010\u000f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/media/gift/GuildMediaGiftHeader$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onGuildUserAvatarUrlUpdate", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lkotlin/collections/ArrayList;", "playerList", "viewerList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelUserNumInfo", "onAVUserInfoChangeNotifyForAll", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAVUserInfoChangeNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> playerList, @Nullable ArrayList<IGProUserInfo> viewerList, @Nullable IGProChannelUserNum channelUserNumInfo) {
            ArrayList<IGProUserInfo> arrayList = new ArrayList();
            if (playerList != null) {
                arrayList.addAll(playerList);
            }
            if (viewerList != null) {
                arrayList.addAll(viewerList);
            }
            GuildMediaGiftHeader guildMediaGiftHeader = GuildMediaGiftHeader.this;
            for (IGProUserInfo iGProUserInfo : arrayList) {
                if (Intrinsics.areEqual(iGProUserInfo.getTinyId(), String.valueOf(guildMediaGiftHeader.mUserTinyId))) {
                    QLog.i("QGMC.Core.GuildMediaGiftHeader", 1, "[onGuildUserAvatarUrlUpdate] tinyId: matched. " + iGProUserInfo.getTinyId());
                    String d06 = ch.d0(iGProUserInfo);
                    Intrinsics.checkNotNullExpressionValue(d06, "getUserShowName(it)");
                    guildMediaGiftHeader.V0(d06);
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(@Nullable String guildId, @Nullable String tinyId) {
            if (Intrinsics.areEqual(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), guildId) && Intrinsics.areEqual(String.valueOf(GuildMediaGiftHeader.this.mUserTinyId), tinyId)) {
                QLog.i("QGMC.Core.GuildMediaGiftHeader", 1, "[onGuildUserAvatarUrlUpdate] ");
                GuildMediaGiftHeader guildMediaGiftHeader = GuildMediaGiftHeader.this;
                guildMediaGiftHeader.T0(Long.valueOf(guildMediaGiftHeader.mUserTinyId));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildMediaGiftHeader(@NotNull Context context) {
        this(context, null, null, null, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(GuildMediaGiftHeader this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(GuildMediaGiftHeader this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Runnable J0() {
        return (Runnable) this.adjustUserNameRunnable.getValue();
    }

    private final Long K0() {
        ConcurrentHashMap<String, p> K = com.tencent.mobileqq.guild.media.core.j.c().K();
        Long l3 = null;
        if (!K.isEmpty()) {
            for (Map.Entry<String, p> entry : K.entrySet()) {
                if (O0(entry.getKey())) {
                    l3 = Long.valueOf(Long.parseLong(entry.getKey()));
                }
            }
        }
        return l3;
    }

    private final String L0(String tinyId) {
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        String guildMemberName = iGPSService.getGuildMemberName(guildID, tinyId);
        Intrinsics.checkNotNullExpressionValue(guildMemberName, "service.getGuildMemberName(guildId, tinyId)");
        if (!TextUtils.isEmpty(guildMemberName)) {
            return guildMemberName;
        }
        String guildUserNick = iGPSService.getGuildUserNick(guildID, tinyId);
        Intrinsics.checkNotNullExpressionValue(guildUserNick, "service.getGuildUserNick(guildId, tinyId)");
        return guildUserNick;
    }

    private final void M0() {
        VideoReport.setLogicParent(this.mGetStarPromptTv, this.mLogicParentView);
        VideoReport.setElementId(this.mGetStarPromptTv, "em_sgrp_get_free_gift_task_entry");
        VideoReport.setElementClickPolicy(this.mGetStarPromptTv, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.mGetStarPromptTv, ExposurePolicy.REPORT_ALL);
    }

    private final void N0(Long defaultReceiverId) {
        if (defaultReceiverId != null) {
            R0(defaultReceiverId);
            com.tencent.mobileqq.guild.gift.module.i iVar = this.mSelectCallback;
            if (iVar != null) {
                iVar.a(defaultReceiverId);
                return;
            }
            return;
        }
        Long K0 = K0();
        if (K0 != null) {
            long longValue = K0.longValue();
            Logger.f235387a.d().i("QGMC.Core.GuildMediaGiftHeader", 1, "[initReceiverUI] select from receiver cache");
            R0(Long.valueOf(longValue));
            com.tencent.mobileqq.guild.gift.module.i iVar2 = this.mSelectCallback;
            if (iVar2 != null) {
                iVar2.a(Long.valueOf(longValue));
                return;
            }
            return;
        }
        List<p> list = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "getDataHub().userInfoList.anchors");
        for (p pVar : list) {
            Logger.f235387a.d().i("QGMC.Core.GuildMediaGiftHeader", 1, "[initReceiverUI] select from room user");
            String str = pVar.f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "userInfo.id");
            if (O0(str) && pVar.f228098f != 1) {
                String str2 = pVar.f228093a;
                Intrinsics.checkNotNullExpressionValue(str2, "userInfo.id");
                R0(Long.valueOf(Long.parseLong(str2)));
                com.tencent.mobileqq.guild.gift.module.i iVar3 = this.mSelectCallback;
                if (iVar3 != null) {
                    String str3 = pVar.f228093a;
                    Intrinsics.checkNotNullExpressionValue(str3, "userInfo.id");
                    iVar3.a(Long.valueOf(Long.parseLong(str3)));
                    return;
                }
                return;
            }
        }
    }

    private final boolean O0(String str) {
        return new Regex("^-?[0-9]+$").matches(str);
    }

    private final void P0() {
        if (o.a(this.mGetStarPromptTv)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.GuildMediaGiftHeader", 1, "[launchGetStarH5] start");
        QRouteApi api = QRoute.api(IGuildMediaChannelApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMediaChannelApi::class.java)");
        IGuildMediaChannelApi.a.j((IGuildMediaChannelApi) api, null, com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), 0, null, 25, null);
    }

    private final void Q0() {
        if (o.a(this.mSelectContainer)) {
            return;
        }
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.Core.GuildMediaGiftHeader", 1, "[launchSelectPanel] start");
        Activity currentTopActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
        if (currentTopActivity != null && !currentTopActivity.isDestroyed() && !currentTopActivity.isFinishing()) {
            com.tencent.mobileqq.guild.media.core.j.a().F0().H(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), this.mGiftUserReceiveCallback);
            return;
        }
        logger.d().w("QGMC.Core.GuildMediaGiftHeader", 1, "[launchSelectPanel] invalid context: " + currentTopActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(Long tinyId) {
        int i3;
        int i16;
        boolean z16 = true;
        Logger.f235387a.d().i("QGMC.Core.GuildMediaGiftHeader", 1, "[setReceiverUser] tinyId: " + tinyId);
        long j3 = 0;
        int i17 = 0;
        if (tinyId == null || tinyId.longValue() <= 0) {
            z16 = false;
        }
        GuildUserAvatarView guildUserAvatarView = this.mAvatar;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        guildUserAvatarView.setVisibility(i3);
        TextView textView = this.mUserNameTv;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        textView.setVisibility(i16);
        TextView textView2 = this.mSelectPromptTv;
        if (!(!z16)) {
            i17 = 8;
        }
        textView2.setVisibility(i17);
        if (z16) {
            if (tinyId != null) {
                j3 = tinyId.longValue();
            }
            this.mUserTinyId = j3;
            T0(tinyId);
            U0(tinyId);
        }
    }

    private final void S0(boolean show) {
        int i3;
        String str;
        ImageView mMoreStarIcon = this.mMoreStarIcon;
        Intrinsics.checkNotNullExpressionValue(mMoreStarIcon, "mMoreStarIcon");
        int i16 = 0;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        mMoreStarIcon.setVisibility(i3);
        TextView mGetStarPromptTv = this.mGetStarPromptTv;
        Intrinsics.checkNotNullExpressionValue(mGetStarPromptTv, "mGetStarPromptTv");
        if (!show) {
            i16 = 8;
        }
        mGetStarPromptTv.setVisibility(i16);
        if (show) {
            str = "imp";
        } else {
            str = "imp_end";
        }
        VideoReport.reportEvent(str, this.mGetStarPromptTv, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(Long tinyId) {
        this.mAvatar.setAvatarTinyId(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), String.valueOf(tinyId));
    }

    private final void U0(Long tinyId) {
        V0(L0(String.valueOf(tinyId)));
        ThreadManagerV2.getUIHandlerV2().post(J0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(String nickName) {
        this.mUserNameTv.setText(nickName);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.mGProObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.mGProObserver);
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.mobileqq.guild.gift.module.j
    public void setReceiver(@Nullable Long tinyId) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QGMC.Core.GuildMediaGiftHeader", 2, "[setReceiver] " + tinyId);
        }
        R0(tinyId);
    }

    public void setSelectCallback(@NotNull com.tencent.mobileqq.guild.gift.module.i callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mSelectCallback = callback;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.j
    public void setSelectedTab(@NotNull String tabId) {
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        S0(Intrinsics.areEqual(tabId, "PACKAGE_TAB_ID"));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildMediaGiftHeader(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, null, null, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildMediaGiftHeader(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, null, null, null, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildMediaGiftHeader(@NotNull Context context, @Nullable Long l3, @Nullable com.tencent.mobileqq.guild.gift.module.i iVar, @Nullable View view) {
        this(context, l3, iVar, view, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaGiftHeader(@NotNull Context context, @Nullable Long l3, @Nullable com.tencent.mobileqq.guild.gift.module.i iVar, @Nullable View view, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(getContext(), R.layout.eyl, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026anel_header_layout, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.wqi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026ild_media_send_to_avatar)");
        this.mAvatar = (GuildUserAvatarView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.wqj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026ild_media_send_user_name)");
        this.mUserNameTv = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.wqh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026uild_media_select_prompt)");
        this.mSelectPromptTv = (TextView) findViewById3;
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.f165574wq4);
        this.mSelectContainer = viewGroup;
        this.mMoreStarIcon = (ImageView) inflate.findViewById(R.id.f165572wq2);
        TextView textView = (TextView) inflate.findViewById(R.id.f165573wq3);
        this.mGetStarPromptTv = textView;
        this.mGiftUserReceiveCallback = new Function1<RoleGroupUserUIData, Unit>() { // from class: com.tencent.mobileqq.guild.media.gift.GuildMediaGiftHeader$mGiftUserReceiveCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoleGroupUserUIData roleGroupUserUIData) {
                invoke2(roleGroupUserUIData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable RoleGroupUserUIData roleGroupUserUIData) {
                com.tencent.mobileqq.guild.gift.module.i iVar2;
                String mTinyId;
                Logger.f235387a.d().i("QGMC.Core.GuildMediaGiftHeader", 1, "[launchSelectPanel] select data callback: " + roleGroupUserUIData);
                Long valueOf = (roleGroupUserUIData == null || (mTinyId = roleGroupUserUIData.getMTinyId()) == null) ? null : Long.valueOf(Long.parseLong(mTinyId));
                GuildMediaGiftHeader.this.R0(valueOf);
                iVar2 = GuildMediaGiftHeader.this.mSelectCallback;
                if (iVar2 != null) {
                    iVar2.a(valueOf);
                }
            }
        };
        this.mGProObserver = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new GuildMediaGiftHeader$adjustUserNameRunnable$2(this));
        this.adjustUserNameRunnable = lazy;
        this.mSelectCallback = iVar;
        this.mLogicParentView = view;
        N0(l3);
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.gift.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildMediaGiftHeader.B0(GuildMediaGiftHeader.this, view2);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.gift.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildMediaGiftHeader.C0(GuildMediaGiftHeader.this, view2);
            }
        });
        M0();
    }
}
