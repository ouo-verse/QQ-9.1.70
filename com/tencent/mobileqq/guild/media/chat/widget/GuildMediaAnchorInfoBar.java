package com.tencent.mobileqq.guild.media.chat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.data.GuildAudioChannelData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.bd;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002DH\u0018\u0000 R2\u00020\u0001:\u0001SB\u001d\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J1\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00020\u0012J1\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00020\u0012J1\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00020\u0012J\b\u0010\u001b\u001a\u00020\u0002H\u0014J\b\u0010\u001c\u001a\u00020\u0002H\u0014R\u0014\u0010\u001f\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0014\u0010(\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010.R\u0014\u00101\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0014\u00103\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0014\u00105\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0014\u00107\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0014\u00109\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010.R\u0014\u0010;\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010+R\u0014\u0010=\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010+R\u0014\u0010?\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010.R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "info", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "k", "", "isVisible", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "action", "setOrientationButton", "setToGridButton", "setToFullViewButton", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "e", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "mAvatarIv", "f", "mAvatarWaveView", tl.h.F, "Landroid/widget/FrameLayout;", "mPhoneLayout", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mAnchorName", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mMuteView", BdhLogUtil.LogTag.Tag_Conn, "mMicOffView", "D", "mNetworkView", "E", "mOrientationBtn", UserInfo.SEX_FEMALE, "mToGridBtn", "G", "mToFullViewBtn", "H", "mAudioQueueNumber", "I", "mAdminRoleIconTv", "J", "mPersonalMedal", "", "K", "Ljava/lang/String;", "mAnchorTinyId", "com/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar$b", "L", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar$b;", "mAudioRoomObserver", "com/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar$c", "M", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar$c;", "micSequenceListObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaAnchorInfoBar extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ImageView mMicOffView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ImageView mNetworkView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView mOrientationBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView mToGridBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView mToFullViewBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView mAudioQueueNumber;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView mAdminRoleIconTv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ImageView mPersonalMedal;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String mAnchorTinyId;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final b mAudioRoomObserver;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final c micSequenceListObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildUserAvatarView mAvatarIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAvatarWaveView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout mPhoneLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mAnchorName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mMuteView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "from", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "", HippyTKDListViewAdapter.X, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(@Nullable String from, @Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo) {
            p g16 = j.c().getUserInfoList().g(GuildMediaAnchorInfoBar.this.mAnchorTinyId);
            if (g16 != null) {
                GuildMediaAnchorInfoBar.this.t(g16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bd;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<bd> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull bd event) {
            Intrinsics.checkNotNullParameter(event, "event");
            p h16 = j.c().getUserInfoList().h();
            if (GuildMediaAnchorInfoBar.this.mAudioQueueNumber.getVisibility() == 0 && h16 != null) {
                GuildMediaAnchorInfoBar.this.x(h16);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaAnchorInfoBar(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l() {
        boolean z16 = j.c().getSelfUserInfo().f228103k;
        HashMap hashMap = new HashMap();
        int i3 = 1;
        if (!z16) {
            if (!z16) {
                i3 = 2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        hashMap.put("sgrp_user_screenshare_owner", Integer.valueOf(i3));
        ImageView imageView = this.mOrientationBtn;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.T0(imageView, "em_sgrp_avchannel_switchpicture", clickPolicy, exposurePolicy, hashMap);
        ch.T0(this.mToGridBtn, "em_sgrp_avchannel_transfer_gridpage", clickPolicy, exposurePolicy, hashMap);
    }

    private final void m() {
        this.mAnchorName.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAnchorInfoBar.n(GuildMediaAnchorInfoBar.this, view);
            }
        });
        this.mAvatarIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAnchorInfoBar.o(GuildMediaAnchorInfoBar.this, view);
            }
        });
        this.mAvatarIv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.widget.f
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean p16;
                p16 = GuildMediaAnchorInfoBar.p(GuildMediaAnchorInfoBar.this, view);
                return p16;
            }
        });
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GuildMediaAnchorInfoBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GuildMediaAnchorInfoBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(GuildMediaAnchorInfoBar this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return false;
    }

    private final void q() {
        boolean z16;
        Configuration configuration;
        if (com.tencent.mobileqq.guild.util.o.a(this.mAvatarIv)) {
            return;
        }
        Resources resources = getResources();
        if (resources != null && (configuration = resources.getConfiguration()) != null && configuration.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("QGMC.GuildMediaAnchorInfoBar", 1, "[openAnchorProfileCard] cancel. land orientation");
            return;
        }
        QLog.i("QGMC.GuildMediaAnchorInfoBar", 1, "[openAnchorProfileCard]");
        p g16 = j.c().getUserInfoList().g(this.mAnchorTinyId);
        if (g16 == null) {
            String string = getRootView().getContext().getString(R.string.f140210dc);
            Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getStri\u2026ild_audio_operate_failed)");
            QQToast.makeText(getRootView().getContext(), string, 0).show();
            return;
        }
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = j.c().getSelfUserInfo();
        IGProChannelInfo channelInfo = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(j.a().E());
        if (channelInfo == null) {
            QLog.e("QGMC.GuildMediaAnchorInfoBar", 1, "[openAnchorProfileCard] failed. channelInfo is null");
            return;
        }
        GuildProfileData guildProfileData = new GuildProfileData(channelInfo.getGuildId(), channelInfo.getChannelUin(), g16.f228093a, 1, MediaChannelUtils.f228046a.l());
        guildProfileData.getExtras().putParcelable(GuildProfileData.KEY_CHANNEL_DATA, new GuildAudioChannelData(channelInfo.getChannelUin(), channelInfo.getType(), selfUserInfo.f228093a, selfUserInfo.f228097e, g16.f228093a, g16.f228097e, g16.f228112t, g16.f228113u, g16.f228105m));
        guildProfileData.getGuildBaseProfileData().r(channelInfo.getChannelUin());
        GuildProfileCard.Mh(QBaseActivity.sTopActivity, guildProfileData, null);
    }

    private final void r(p userInfo) {
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = j.c().getSelfUserInfo();
        if (!Intrinsics.areEqual(this.mAnchorTinyId, userInfo.f228093a) && (selfUserInfo.A > 2 || userInfo.A <= 2)) {
            this.mNetworkView.setVisibility(8);
            return;
        }
        int i3 = userInfo.A;
        if (i3 >= 5) {
            this.mNetworkView.setVisibility(0);
            this.mNetworkView.setImageResource(R.drawable.guild_audio_net_worst);
        } else if (i3 >= 3) {
            this.mNetworkView.setVisibility(0);
            this.mNetworkView.setImageResource(R.drawable.guild_audio_net_bad);
        } else {
            this.mNetworkView.setVisibility(8);
        }
    }

    private final void s(p info) {
        int i3;
        this.mAvatarIv.setAvatarMeta(j.a().getGuildID(), info.f228093a, info.f228096d);
        if (!info.f228113u && !info.f228112t && info.f228110r != 0 && info.f228101i) {
            this.mAvatarWaveView.setVisibility(0);
            if (info.f228117y == 2) {
                i3 = R.drawable.guild_media_anchor_wav_female;
            } else {
                i3 = R.drawable.guild_media_anchor_wav_male;
            }
            this.mAvatarWaveView.setBackground(ContextCompat.getDrawable(getContext(), i3));
            return;
        }
        this.mAvatarWaveView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(p userInfo) {
        s(userInfo);
        this.mAnchorName.setText(userInfo.f228094b);
        z(userInfo);
        y(userInfo);
        int i3 = 0;
        if (!userInfo.f228112t && userInfo.f228110r != 0) {
            this.mMuteView.setVisibility(8);
            if (j.a().X().Q(userInfo)) {
                this.mMicOffView.setVisibility(8);
            } else {
                this.mMicOffView.setVisibility(0);
            }
        } else {
            this.mMuteView.setVisibility(0);
            this.mMicOffView.setVisibility(8);
        }
        r(userInfo);
        FrameLayout frameLayout = this.mPhoneLayout;
        if (!userInfo.B) {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        if (MediaChannelUtils.f228046a.u(j.a().E())) {
            x(userInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(p userInfo) {
        Object obj;
        if (!MediaChannelUtils.f228046a.u(j.a().E())) {
            this.mAudioQueueNumber.setVisibility(8);
            return;
        }
        List<IGProUserInfo> d16 = j.a().N().d1();
        Iterator<T> it = d16.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), userInfo.f228093a)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IGProUserInfo iGProUserInfo = (IGProUserInfo) obj;
        if (iGProUserInfo != null) {
            this.mAudioQueueNumber.setVisibility(0);
            this.mAudioQueueNumber.setText(String.valueOf(d16.indexOf(iGProUserInfo) + 1));
        } else {
            this.mAudioQueueNumber.setVisibility(8);
        }
    }

    private final void y(p userInfo) {
        String url = userInfo.L.getUrl();
        if (!StringUtil.isEmpty(url)) {
            u.q(url, this.mPersonalMedal, true);
            this.mPersonalMedal.setVisibility(0);
        } else {
            this.mPersonalMedal.setVisibility(8);
        }
    }

    private final void z(p userInfo) {
        IGProRoleManagementTag iGProRoleManagementTag = userInfo.M;
        if (iGProRoleManagementTag != null && !TextUtils.isEmpty(iGProRoleManagementTag.getTagName())) {
            this.mAdminRoleIconTv.setVisibility(0);
            Drawable background = this.mAdminRoleIconTv.getBackground();
            background.setTint(GuildUIUtils.f235378a.g(iGProRoleManagementTag.getColor()));
            this.mAdminRoleIconTv.setBackground(background);
            this.mAdminRoleIconTv.setText(iGProRoleManagementTag.getTagName());
            return;
        }
        this.mAdminRoleIconTv.setVisibility(8);
    }

    public final void k(@NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        QLog.i("QGMC.GuildMediaAnchorInfoBar", 1, "[bindUserInfo] " + userInfo);
        String str = userInfo.f228093a;
        Intrinsics.checkNotNullExpressionValue(str, "userInfo.id");
        this.mAnchorTinyId = str;
        m();
        t(userInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        QLog.i("QGMC.GuildMediaAnchorInfoBar", 1, "[onAttachedToWindow] ");
        j.a().l0().b(this.mAudioRoomObserver);
        j.d().V(bd.class, this.micSequenceListObserver);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        QLog.i("QGMC.GuildMediaAnchorInfoBar", 1, "[onDetachedFromWindow] ");
        j.a().l0().B(this.mAudioRoomObserver);
        j.d().j(bd.class, this.micSequenceListObserver);
        super.onDetachedFromWindow();
    }

    public final void setOrientationButton(boolean isVisible, @NotNull final Function1<? super View, Unit> action) {
        int i3;
        Intrinsics.checkNotNullParameter(action, "action");
        QLog.i("QGMC.GuildMediaAnchorInfoBar", 1, "[setOrientationButton] " + isVisible);
        ImageView imageView = this.mOrientationBtn;
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        this.mOrientationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAnchorInfoBar.u(Function1.this, view);
            }
        });
        if (MediaChannelCore.INSTANCE.a().o0().getStartParams().getFromPreView() == 100) {
            this.mOrientationBtn.setVisibility(8);
        }
    }

    public final void setToFullViewButton(boolean isVisible, @NotNull final Function1<? super View, Unit> action) {
        int i3;
        Intrinsics.checkNotNullParameter(action, "action");
        QLog.i("QGMC.GuildMediaAnchorInfoBar", 1, "[setToFullViewButton] " + isVisible);
        ImageView imageView = this.mToFullViewBtn;
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        this.mToFullViewBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAnchorInfoBar.v(Function1.this, view);
            }
        });
        if (MediaChannelCore.INSTANCE.a().o0().getStartParams().getFromPreView() == 100) {
            this.mToFullViewBtn.setVisibility(8);
        }
    }

    public final void setToGridButton(boolean isVisible, @NotNull final Function1<? super View, Unit> action) {
        int i3;
        Intrinsics.checkNotNullParameter(action, "action");
        QLog.i("QGMC.GuildMediaAnchorInfoBar", 1, "[setToGridButton] " + isVisible);
        ImageView imageView = this.mToGridBtn;
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        this.mToGridBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAnchorInfoBar.w(Function1.this, view);
            }
        });
        if (MediaChannelCore.INSTANCE.a().o0().getStartParams().getFromPreView() == 100) {
            this.mToGridBtn.setVisibility(8);
        }
    }

    public /* synthetic */ GuildMediaAnchorInfoBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaAnchorInfoBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.f168124ey1, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026d_media_anchor_bar, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.f165434vz4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026dio_heads_view_item_head)");
        this.mAvatarIv = (GuildUserAvatarView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.vz9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026dio_heads_view_item_wave)");
        this.mAvatarWaveView = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.vyz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026udio_anchor_phone_layout)");
        this.mPhoneLayout = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.spe);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.anchor_user_name_tv)");
        this.mAnchorName = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.yzl);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.media_anchor_mute_iv)");
        this.mMuteView = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.yzk);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.media_anchor_mic_iv)");
        this.mMicOffView = (ImageView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.yzm);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R\u2026ia_anchor_network_status)");
        this.mNetworkView = (ImageView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.f913154u);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R\u2026d.switch_orientation_btn)");
        this.mOrientationBtn = (ImageView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.f99135oz);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.to_grid_btn)");
        this.mToGridBtn = (ImageView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.vgv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R.id.full_view_btn)");
        this.mToFullViewBtn = (ImageView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.x0m);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R\u2026guild_share_queue_number)");
        this.mAudioQueueNumber = (TextView) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.vwy);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R\u2026guild_admin_role_icon_tv)");
        this.mAdminRoleIconTv = (TextView) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.f242308k);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R.id.personal_medal)");
        this.mPersonalMedal = (ImageView) findViewById13;
        this.mAnchorTinyId = "";
        this.mAudioRoomObserver = new b();
        this.micSequenceListObserver = new c();
    }
}
