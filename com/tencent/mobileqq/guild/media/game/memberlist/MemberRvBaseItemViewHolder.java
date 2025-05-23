package com.tencent.mobileqq.guild.media.game.memberlist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guildmedia.data.GuildMediaAIOLottieEvent;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.GuildMediaAIOExKt;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.q;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.m;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.gift.i;
import com.tencent.mobileqq.guild.media.widget.GuildMediaNetStatusView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaVoiceMicView;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\t*\u0002\u00b8\u0001\b\u0016\u0018\u0000 \u00be\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u00bf\u0001B\u0015\b\u0016\u0012\b\u0010\u00bb\u0001\u001a\u00030\u00b0\u0001\u00a2\u0006\u0006\b\u00bc\u0001\u0010\u00bd\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J1\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001b*\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'`(H\u0016J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0016J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0017J\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\nH\u0004J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0016J\u001c\u00106\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000604H\u0016R$\u00107\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010C\u001a\u0004\u0018\u00010\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR2\u0010K\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170Ij\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010S\"\u0004\bX\u0010UR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b\u0013\u0010^R\"\u0010`\u001a\u00020_8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010|\u001a\u00020{8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R&\u0010\u0082\u0001\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0082\u0001\u0010Q\u001a\u0005\b\u0083\u0001\u0010S\"\u0005\b\u0084\u0001\u0010UR&\u0010\u0085\u0001\u001a\u00020t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0085\u0001\u0010v\u001a\u0005\b\u0086\u0001\u0010x\"\u0005\b\u0087\u0001\u0010zR&\u0010\u0088\u0001\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0088\u0001\u0010Q\u001a\u0005\b\u0089\u0001\u0010S\"\u0005\b\u008a\u0001\u0010UR&\u0010\u008b\u0001\u001a\u00020m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008b\u0001\u0010o\u001a\u0005\b\u008c\u0001\u0010q\"\u0005\b\u008d\u0001\u0010sR&\u0010\u008e\u0001\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008e\u0001\u0010Q\u001a\u0005\b\u008f\u0001\u0010S\"\u0005\b\u0090\u0001\u0010UR&\u0010\u0091\u0001\u001a\u00020t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0091\u0001\u0010v\u001a\u0005\b\u0092\u0001\u0010x\"\u0005\b\u0093\u0001\u0010zR&\u0010\u0094\u0001\u001a\u00020m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0094\u0001\u0010o\u001a\u0005\b\u0095\u0001\u0010q\"\u0005\b\u0096\u0001\u0010sR&\u0010\u0097\u0001\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0097\u0001\u0010Q\u001a\u0005\b\u0098\u0001\u0010S\"\u0005\b\u0099\u0001\u0010UR&\u0010\u009a\u0001\u001a\u00020t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009a\u0001\u0010v\u001a\u0005\b\u009b\u0001\u0010x\"\u0005\b\u009c\u0001\u0010zR&\u0010\u009d\u0001\u001a\u00020m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009d\u0001\u0010o\u001a\u0005\b\u009e\u0001\u0010q\"\u0005\b\u009f\u0001\u0010sR&\u0010\u00a0\u0001\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a0\u0001\u0010Q\u001a\u0005\b\u00a1\u0001\u0010S\"\u0005\b\u00a2\u0001\u0010UR&\u0010\u00a3\u0001\u001a\u00020t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a3\u0001\u0010v\u001a\u0005\b\u00a4\u0001\u0010x\"\u0005\b\u00a5\u0001\u0010zR&\u0010\u00a6\u0001\u001a\u00020m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a6\u0001\u0010o\u001a\u0005\b\u00a7\u0001\u0010q\"\u0005\b\u00a8\u0001\u0010sR\u001d\u0010\u00aa\u0001\u001a\u00030\u00a9\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001\u001a\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u001a\u0010\u00ae\u0001\u001a\u00020O8\u0006\u00a2\u0006\u000e\n\u0005\b\u00ae\u0001\u0010Q\u001a\u0005\b\u00af\u0001\u0010SR\u001d\u0010\u00b1\u0001\u001a\u00030\u00b0\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001b\u0010\u00b5\u0001\u001a\u00020\u00178\u0006\u00a2\u0006\u000f\n\u0005\b\u00b5\u0001\u0010N\u001a\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u0018\u0010\u00b9\u0001\u001a\u00030\u00b8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00ba\u0001\u00a8\u0006\u00c0\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder;", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseTrtcLiveObserveMediaItemViewHolder;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/guildmedia/data/GuildMediaAIOLottieEvent;", "", "dealWithScreenSize", "Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "updateUserBaseInfo", "bindSmobaData", "", "guildId", "tinyId", "avatarMeta", "avatarPendant", "updateAvatarIcon", "info", "setOnVoiceAnim", "initNetStatusMap", "setNetWorkStatus", "updateVoiceAnim", "", "canPlayVolumeAnim", "", "getUserStatusPriority", "updateAdminRoleIcon", "updatePersonalMedal", "T", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "third", "select", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "selfUserInfo", "bindData", "column", "bindColumn", UserInfo.USERSTATE, "setDtElement", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "setNetworkStatus", "", "hasVolumeUserMap", "setVolume", "mLocalUser", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "getMLocalUser", "()Lcom/tencent/mobileqq/guild/media/core/data/f;", "setMLocalUser", "(Lcom/tencent/mobileqq/guild/media/core/data/f;)V", "mUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "getMUserInfo", "()Lcom/tencent/mobileqq/guild/media/core/data/p;", "setMUserInfo", "(Lcom/tencent/mobileqq/guild/media/core/data/p;)V", "mNickNameIconUrl", "Ljava/lang/String;", "getMNickNameIconUrl", "()Ljava/lang/String;", "setMNickNameIconUrl", "(Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "netStatusToBackgroundMap", "Ljava/util/HashMap;", "mColumn", "I", "Landroid/widget/ImageView;", "rootBgImageView", "Landroid/widget/ImageView;", "getRootBgImageView", "()Landroid/widget/ImageView;", "setRootBgImageView", "(Landroid/widget/ImageView;)V", "rootApngBgImageView", "getRootApngBgImageView", "setRootApngBgImageView", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaNetStatusView;", "netWorkStatus", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaNetStatusView;", "getNetWorkStatus", "()Lcom/tencent/mobileqq/guild/media/widget/GuildMediaNetStatusView;", "(Lcom/tencent/mobileqq/guild/media/widget/GuildMediaNetStatusView;)V", "Landroid/widget/FrameLayout;", "avatarFl", "Landroid/widget/FrameLayout;", "getAvatarFl", "()Landroid/widget/FrameLayout;", "setAvatarFl", "(Landroid/widget/FrameLayout;)V", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "avatarIv", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "getAvatarIv", "()Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "setAvatarIv", "(Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;)V", "Landroid/widget/LinearLayout;", "nameIconLl", "Landroid/widget/LinearLayout;", "getNameIconLl", "()Landroid/widget/LinearLayout;", "setNameIconLl", "(Landroid/widget/LinearLayout;)V", "Landroid/widget/TextView;", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "setNickNameTv", "(Landroid/widget/TextView;)V", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaVoiceMicView;", "micIv", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaVoiceMicView;", "getMicIv", "()Lcom/tencent/mobileqq/guild/media/widget/GuildMediaVoiceMicView;", "setMicIv", "(Lcom/tencent/mobileqq/guild/media/widget/GuildMediaVoiceMicView;)V", "muteIv", "getMuteIv", "setMuteIv", "adminRoleTv", "getAdminRoleTv", "setAdminRoleTv", "personalMedalIv", "getPersonalMedalIv", "setPersonalMedalIv", "localFirstHeroLl", "getLocalFirstHeroLl", "setLocalFirstHeroLl", "localFirstHeroImageView", "getLocalFirstHeroImageView", "setLocalFirstHeroImageView", "localFirstHeroTextView", "getLocalFirstHeroTextView", "setLocalFirstHeroTextView", "bottomBarLl", "getBottomBarLl", "setBottomBarLl", "bottomBarLevelImageView", "getBottomBarLevelImageView", "setBottomBarLevelImageView", "bottomBarLevelTextView", "getBottomBarLevelTextView", "setBottomBarLevelTextView", "gamingStatusLl", "getGamingStatusLl", "setGamingStatusLl", "gamingHeroIv", "getGamingHeroIv", "setGamingHeroIv", "gamingHeroRecordTv", "getGamingHeroRecordTv", "setGamingHeroRecordTv", "goodAtHeroLl", "getGoodAtHeroLl", "setGoodAtHeroLl", "Landroid/view/ViewGroup;", "aioLottieEmojiParent", "Landroid/view/ViewGroup;", "getAioLottieEmojiParent", "()Landroid/view/ViewGroup;", "giftAnimIv", "getGiftAnimIv", "Landroid/view/View;", "giftAnimBackground", "Landroid/view/View;", "getGiftAnimBackground", "()Landroid/view/View;", "textLineMinSize", "getTextLineMinSize", "()I", "com/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder$c", "giftAnimObserver", "Lcom/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder$c;", "view", "<init>", "(Landroid/view/View;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class MemberRvBaseItemViewHolder extends BaseTrtcLiveObserveMediaItemViewHolder implements SimpleEventReceiver<GuildMediaAIOLottieEvent> {

    @NotNull
    private static final String GUILD_ROLE_COLOR_ADMINISTRATOR = "#1FD6A4";

    @NotNull
    private static final String GUILD_ROLE_COLOR_CHANNEL_ADMINISTRATOR = "#4691FF";

    @NotNull
    private static final String GUILD_ROLE_COLOR_CHANNEL_VISITOR = "#79798C";

    @NotNull
    private static final String GUILD_ROLE_COLOR_CREATOR = "#FF6542";

    @NotNull
    public static final String TAG = "MemberRvBaseItemViewHolder";

    @NotNull
    private TextView adminRoleTv;

    @NotNull
    private final ViewGroup aioLottieEmojiParent;

    @NotNull
    private FrameLayout avatarFl;

    @NotNull
    private GuildWavAvatarImageView avatarIv;

    @NotNull
    private ImageView bottomBarLevelImageView;

    @NotNull
    private TextView bottomBarLevelTextView;

    @NotNull
    private LinearLayout bottomBarLl;

    @NotNull
    private ImageView gamingHeroIv;

    @NotNull
    private TextView gamingHeroRecordTv;

    @NotNull
    private LinearLayout gamingStatusLl;

    @NotNull
    private final View giftAnimBackground;

    @NotNull
    private final ImageView giftAnimIv;

    @NotNull
    private final c giftAnimObserver;

    @NotNull
    private LinearLayout goodAtHeroLl;

    @NotNull
    private ImageView localFirstHeroImageView;

    @NotNull
    private LinearLayout localFirstHeroLl;

    @NotNull
    private TextView localFirstHeroTextView;
    private int mColumn;

    @Nullable
    private f mLocalUser;

    @Nullable
    private String mNickNameIconUrl;

    @Nullable
    private p mUserInfo;

    @NotNull
    private GuildMediaVoiceMicView micIv;

    @NotNull
    private ImageView muteIv;

    @NotNull
    private LinearLayout nameIconLl;

    @NotNull
    private HashMap<Integer, Integer> netStatusToBackgroundMap;

    @NotNull
    private GuildMediaNetStatusView netWorkStatus;

    @NotNull
    private TextView nickNameTv;

    @NotNull
    private ImageView personalMedalIv;

    @NotNull
    private ImageView rootApngBgImageView;

    @NotNull
    private ImageView rootBgImageView;
    private final int textLineMinSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder$b", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements View.OnLayoutChangeListener {
        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(v3, "v");
            int lineWidth = (int) MemberRvBaseItemViewHolder.this.getNickNameTv().getLayout().getLineWidth(0);
            if (lineWidth <= MemberRvBaseItemViewHolder.this.getTextLineMinSize()) {
                lineWidth = MemberRvBaseItemViewHolder.this.getTextLineMinSize();
            }
            if (MemberRvBaseItemViewHolder.this.getNickNameTv().getWidth() != lineWidth) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lineWidth, -2);
                layoutParams.gravity = 16;
                MemberRvBaseItemViewHolder.this.getNickNameTv().setLayoutParams(layoutParams);
            }
            MemberRvBaseItemViewHolder.this.getNickNameTv().removeOnLayoutChangeListener(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/memberlist/MemberRvBaseItemViewHolder$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/m;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements o<m> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull m event) {
            String str;
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.d(MemberRvBaseItemViewHolder.TAG, 1, "giftAnimObserver " + event.getGiftData().f264920k + ", path:" + event.getPngFilePath());
            long j3 = event.getGiftData().f264920k;
            p mUserInfo = MemberRvBaseItemViewHolder.this.getMUserInfo();
            if (mUserInfo != null) {
                str = mUserInfo.f228093a;
            } else {
                str = null;
            }
            if (j3 == NumberUtil.stringToLong(str) && !StringUtil.isEmpty(event.getPngFilePath())) {
                int dpToPx = ViewUtils.dpToPx(100.0f);
                ImageView giftAnimIv = MemberRvBaseItemViewHolder.this.getGiftAnimIv();
                giftAnimIv.getLayoutParams().width = dpToPx;
                giftAnimIv.getLayoutParams().height = dpToPx;
                giftAnimIv.requestLayout();
                i.f228937a.b(MemberRvBaseItemViewHolder.this.getGiftAnimBackground(), MemberRvBaseItemViewHolder.this.getAvatarFl(), MemberRvBaseItemViewHolder.this.getGiftAnimIv(), event);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberRvBaseItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.netStatusToBackgroundMap = new HashMap<>();
        this.mColumn = -1;
        this.textLineMinSize = ViewUtils.dpToPx(40.0f);
        initNetStatusMap();
        this.rootBgImageView = (ImageView) getView(R.id.f783146q);
        this.rootApngBgImageView = (ImageView) getView(R.id.f783046p);
        this.netWorkStatus = (GuildMediaNetStatusView) getView(R.id.zph);
        this.avatarFl = (FrameLayout) getView(R.id.wh6);
        this.avatarIv = (GuildWavAvatarImageView) getView(R.id.f165434vz4);
        this.nameIconLl = (LinearLayout) getView(R.id.xwa);
        this.nickNameTv = (TextView) getView(R.id.xwb);
        this.micIv = (GuildMediaVoiceMicView) getView(R.id.vz5);
        this.muteIv = (ImageView) getView(R.id.vz6);
        this.adminRoleTv = (TextView) getView(R.id.vwy);
        this.personalMedalIv = (ImageView) getView(R.id.x4f);
        this.localFirstHeroLl = (LinearLayout) getView(R.id.f165865xw1);
        this.localFirstHeroImageView = (ImageView) getView(R.id.f165864xw0);
        this.localFirstHeroTextView = (TextView) getView(R.id.f165866xw2);
        this.bottomBarLl = (LinearLayout) getView(R.id.xso);
        this.bottomBarLevelImageView = (ImageView) getView(R.id.xxz);
        this.bottomBarLevelTextView = (TextView) getView(R.id.f165877xy0);
        this.gamingStatusLl = (LinearLayout) getView(R.id.xv8);
        this.gamingHeroIv = (ImageView) getView(R.id.xv6);
        this.gamingHeroRecordTv = (TextView) getView(R.id.xv7);
        this.goodAtHeroLl = (LinearLayout) getView(R.id.xva);
        this.giftAnimBackground = getView(R.id.f165323vj1);
        this.giftAnimIv = (ImageView) getView(R.id.wpy);
        this.aioLottieEmojiParent = (ViewGroup) getView(R.id.wpz);
        int random = (int) ((Math.random() * 2) + 1);
        if (GuildMediaUtils.f227771a.n()) {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_item_bg);
        } else if (random == 1) {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_small_item_bg1);
        } else {
            this.itemView.setBackgroundResource(R.drawable.guild_media_channel_user_small_item_bg2);
        }
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        if (MediaChannelUtils.B(context)) {
            this.localFirstHeroLl.setVisibility(8);
        }
        this.giftAnimObserver = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindSmobaData(p userInfo) {
        q userInfoInGame = userInfo.C.getUserInfoInGame();
        if (!TextUtils.isEmpty(userInfoInGame.getIdentityDesc())) {
            this.bottomBarLevelTextView.setVisibility(0);
            this.bottomBarLevelTextView.setText(userInfoInGame.getIdentityDesc());
        } else {
            this.bottomBarLevelTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(userInfoInGame.getGradeLevelUrl())) {
            this.bottomBarLevelImageView.setVisibility(0);
            if (!Intrinsics.areEqual(userInfoInGame.getGradeLevelUrl(), this.bottomBarLevelImageView.getTag())) {
                w.c("bindSmobaData_setImageDrawable");
                this.bottomBarLevelImageView.setImageDrawable(URLDrawable.getDrawable(userInfoInGame.getGradeLevelUrl(), URLDrawable.URLDrawableOptions.obtain()));
                this.bottomBarLevelImageView.setTag(userInfoInGame.getGradeLevelUrl());
                w.d();
            }
        } else {
            this.bottomBarLevelImageView.setVisibility(8);
        }
        if (TextUtils.isEmpty(userInfoInGame.getIdentityDesc()) && TextUtils.isEmpty(userInfoInGame.getGradeLevelUrl())) {
            this.bottomBarLl.setVisibility(4);
        } else {
            this.bottomBarLl.setVisibility(0);
        }
    }

    private final boolean canPlayVolumeAnim(p info) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "canPlayVolumeAnim id: " + info.f228093a + " , isMicOn: " + info.f228101i + ", muteToMe: " + info.f228112t + ", globalMute: " + info.f228113u + ", volumeToMe: " + info.f228110r + ", phoneBusy: " + info.B);
        }
        if (getUserStatusPriority(info) == 100) {
            return true;
        }
        return false;
    }

    private final void dealWithScreenSize() {
        int width = this.nameIconLl.getWidth();
        for (View view : ViewGroupKt.getChildren(this.nameIconLl)) {
            if (!Intrinsics.areEqual(view, this.nickNameTv)) {
                width = (width - view.getWidth()) - ViewUtils.dpToPx(2.0f);
            }
        }
        int i3 = this.textLineMinSize;
        if (width <= i3) {
            width = i3;
        }
        this.nickNameTv.setMaxWidth(width);
        this.nickNameTv.addOnLayoutChangeListener(new b());
    }

    private final int getUserStatusPriority(p info) {
        if (!j.a().isInChannel()) {
            return 0;
        }
        if (info.B) {
            return 5;
        }
        if (com.tencent.mobileqq.guild.media.core.m.a(j.c())) {
            return 110;
        }
        if (info.f228112t || info.f228110r == 0) {
            return 2;
        }
        if (info.f228113u || info.f228105m == 2 || !info.f228101i) {
            return 1;
        }
        return 100;
    }

    private final void initNetStatusMap() {
        HashMap<Integer, Integer> hashMapOf;
        Integer valueOf = Integer.valueOf(R.drawable.guild_audio_net_worst);
        Integer valueOf2 = Integer.valueOf(R.drawable.guild_audio_net_bad);
        Integer valueOf3 = Integer.valueOf(R.drawable.guild_audio_net_normal);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(6, valueOf), TuplesKt.to(5, valueOf), TuplesKt.to(4, valueOf2), TuplesKt.to(3, valueOf2), TuplesKt.to(2, valueOf3), TuplesKt.to(1, valueOf3), TuplesKt.to(0, valueOf3));
        this.netStatusToBackgroundMap = hashMapOf;
    }

    private final <T> T select(int i3, T t16, T t17, T t18) {
        if (i3 != 1) {
            if (i3 != 2) {
                return t18;
            }
            return t17;
        }
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOnVoiceAnim(p info) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setOnVoiceAnim id: " + info.f228093a + " , isMicOn: " + info.f228101i + ", muteToMe: " + info.f228112t + ", globalMute: " + info.f228113u + ", volumeToMe: " + info.f228110r + ", phoneBusy: " + info.B);
        }
        int userStatusPriority = getUserStatusPriority(info);
        if (userStatusPriority != 1) {
            if (userStatusPriority != 2) {
                this.muteIv.setVisibility(8);
                this.micIv.setVisibility(8);
                return;
            } else {
                this.muteIv.setVisibility(0);
                this.micIv.setVisibility(8);
                return;
            }
        }
        this.micIv.setVisibility(0);
        this.muteIv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAdminRoleIcon(p userInfo) {
        IGProRoleManagementTag iGProRoleManagementTag = userInfo.M;
        if (iGProRoleManagementTag != null && !TextUtils.isEmpty(iGProRoleManagementTag.getTagName())) {
            this.adminRoleTv.setVisibility(0);
            this.adminRoleTv.getBackground().setTint(GuildUIUtils.f235378a.g(userInfo.M.getColor()));
            this.adminRoleTv.setText(userInfo.M.getTagName());
            this.adminRoleTv.setMaxEms(5);
        } else {
            this.adminRoleTv.setVisibility(8);
        }
        if (userInfo.f228118z) {
            this.adminRoleTv.setVisibility(0);
            this.adminRoleTv.getBackground().setColorFilter(Color.parseColor(GUILD_ROLE_COLOR_CHANNEL_VISITOR), PorterDuff.Mode.SRC);
            this.adminRoleTv.setText(this.itemView.getContext().getString(R.string.f140130d5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAvatarIcon(String guildId, String tinyId, String avatarMeta, String avatarPendant) {
        String str;
        Object tag = this.avatarIv.getTag(R.id.f165434vz4);
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (TextUtils.equals(avatarMeta, str)) {
            return;
        }
        this.avatarIv.setTag(R.id.f165434vz4, avatarMeta);
        this.avatarIv.setAvatarTinyId(guildId, tinyId, avatarMeta, avatarPendant);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePersonalMedal(p userInfo) {
        String url = userInfo.L.getUrl();
        if (!StringUtil.isEmpty(url)) {
            u.q(url, this.personalMedalIv, true);
            this.personalMedalIv.setVisibility(0);
        } else {
            this.personalMedalIv.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserBaseInfo(p userInfo) {
        int i3 = userInfo.f228117y;
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 != 2) {
                QLog.i(TAG, 1, "user gender is other:" + userInfo);
                this.avatarIv.setIdentityView(-1);
            } else {
                this.avatarIv.setIdentityView(R.drawable.guild_game_member_gender_woman);
            }
        } else {
            this.avatarIv.setIdentityView(R.drawable.guild_game_member_gender_man);
        }
        CharSequence text = this.localFirstHeroTextView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "localFirstHeroTextView.text");
        if (text.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            this.localFirstHeroTextView.setText("");
        }
        this.localFirstHeroImageView.setVisibility(8);
        this.localFirstHeroTextView.setVisibility(8);
        this.rootApngBgImageView.setVisibility(4);
        this.rootBgImageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateVoiceAnim(p info) {
        if (info.f228117y == 2) {
            GuildWavAvatarImageView guildWavAvatarImageView = this.avatarIv;
            if (guildWavAvatarImageView != null) {
                guildWavAvatarImageView.setColor(Color.parseColor("#FF4FA7"));
                return;
            }
            return;
        }
        GuildWavAvatarImageView guildWavAvatarImageView2 = this.avatarIv;
        if (guildWavAvatarImageView2 != null) {
            guildWavAvatarImageView2.setColor(Color.parseColor("#00B3FF"));
        }
    }

    public final void bindColumn(int column) {
        if (this.mColumn == column) {
            return;
        }
        this.mColumn = column;
        this.nickNameTv.setTextSize(((Number) select(column, Float.valueOf(16.0f), Float.valueOf(16.0f), Float.valueOf(12.0f))).floatValue());
        this.avatarIv.setImageWidth(((Number) select(column, 65, 65, 44)).intValue());
    }

    public void bindData(@NotNull p userInfo, @NotNull f selfUserInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(selfUserInfo, "selfUserInfo");
        this.itemView.setTag(userInfo);
        this.mLocalUser = selfUserInfo;
        if (!Intrinsics.areEqual(this.nickNameTv.getText(), userInfo.f228094b)) {
            this.nickNameTv.setText(userInfo.f228094b);
        }
        updateUserBaseInfo(userInfo);
        Unit unit = Unit.INSTANCE;
        String str = selfUserInfo.P;
        Intrinsics.checkNotNullExpressionValue(str, "selfUserInfo.guildId");
        String str2 = userInfo.f228093a;
        Intrinsics.checkNotNullExpressionValue(str2, "userInfo.id");
        String str3 = userInfo.f228096d;
        Intrinsics.checkNotNullExpressionValue(str3, "userInfo.avatarMeta");
        String str4 = userInfo.J;
        Intrinsics.checkNotNullExpressionValue(str4, "userInfo.avatarPendant");
        updateAvatarIcon(str, str2, str3, str4);
        setOnVoiceAnim(userInfo);
        updateVoiceAnim(userInfo);
        setNetWorkStatus(userInfo);
        bindSmobaData(userInfo);
        updateAdminRoleIcon(userInfo);
        updatePersonalMedal(userInfo);
        p pVar = this.mUserInfo;
        if (pVar == null) {
            p j3 = p.j();
            j3.e(userInfo);
            this.mUserInfo = j3;
        } else if (pVar != null) {
            pVar.e(userInfo);
        }
        dealWithScreenSize();
    }

    @NotNull
    public final TextView getAdminRoleTv() {
        return this.adminRoleTv;
    }

    @NotNull
    public final ViewGroup getAioLottieEmojiParent() {
        return this.aioLottieEmojiParent;
    }

    @NotNull
    public final FrameLayout getAvatarFl() {
        return this.avatarFl;
    }

    @NotNull
    public final GuildWavAvatarImageView getAvatarIv() {
        return this.avatarIv;
    }

    @NotNull
    public final ImageView getBottomBarLevelImageView() {
        return this.bottomBarLevelImageView;
    }

    @NotNull
    public final TextView getBottomBarLevelTextView() {
        return this.bottomBarLevelTextView;
    }

    @NotNull
    public final LinearLayout getBottomBarLl() {
        return this.bottomBarLl;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildMediaAIOLottieEvent>> getEventClass() {
        ArrayList<Class<GuildMediaAIOLottieEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildMediaAIOLottieEvent.class);
        return arrayListOf;
    }

    @NotNull
    public final ImageView getGamingHeroIv() {
        return this.gamingHeroIv;
    }

    @NotNull
    public final TextView getGamingHeroRecordTv() {
        return this.gamingHeroRecordTv;
    }

    @NotNull
    public final LinearLayout getGamingStatusLl() {
        return this.gamingStatusLl;
    }

    @NotNull
    public final View getGiftAnimBackground() {
        return this.giftAnimBackground;
    }

    @NotNull
    public final ImageView getGiftAnimIv() {
        return this.giftAnimIv;
    }

    @NotNull
    public final LinearLayout getGoodAtHeroLl() {
        return this.goodAtHeroLl;
    }

    @NotNull
    public final ImageView getLocalFirstHeroImageView() {
        return this.localFirstHeroImageView;
    }

    @NotNull
    public final LinearLayout getLocalFirstHeroLl() {
        return this.localFirstHeroLl;
    }

    @NotNull
    public final TextView getLocalFirstHeroTextView() {
        return this.localFirstHeroTextView;
    }

    @Nullable
    protected final f getMLocalUser() {
        return this.mLocalUser;
    }

    @Nullable
    protected final String getMNickNameIconUrl() {
        return this.mNickNameIconUrl;
    }

    @Nullable
    protected final p getMUserInfo() {
        return this.mUserInfo;
    }

    @NotNull
    public final GuildMediaVoiceMicView getMicIv() {
        return this.micIv;
    }

    @NotNull
    public final ImageView getMuteIv() {
        return this.muteIv;
    }

    @NotNull
    public final LinearLayout getNameIconLl() {
        return this.nameIconLl;
    }

    @NotNull
    public final GuildMediaNetStatusView getNetWorkStatus() {
        return this.netWorkStatus;
    }

    @NotNull
    public final TextView getNickNameTv() {
        return this.nickNameTv;
    }

    @NotNull
    public final ImageView getPersonalMedalIv() {
        return this.personalMedalIv;
    }

    @NotNull
    public final ImageView getRootApngBgImageView() {
        return this.rootApngBgImageView;
    }

    @NotNull
    public final ImageView getRootBgImageView() {
        return this.rootBgImageView;
    }

    public final int getTextLineMinSize() {
        return this.textLineMinSize;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        int measuredWidth = (int) (this.avatarIv.getMeasuredWidth() * 1.5f);
        QLog.i(TAG, 1, "[onReceiveEvent] lottieEmojiWH:" + measuredWidth + ", event:" + event);
        GuildMediaAIOExKt.j(event, this.mUserInfo, this.aioLottieEmojiParent, measuredWidth);
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder
    public void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
        j.d().V(m.class, this.giftAnimObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        j.d().j(m.class, this.giftAnimObserver);
        i.f228937a.c(this.giftAnimBackground);
    }

    public final void setAdminRoleTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.adminRoleTv = textView;
    }

    public final void setAvatarFl(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.avatarFl = frameLayout;
    }

    public final void setAvatarIv(@NotNull GuildWavAvatarImageView guildWavAvatarImageView) {
        Intrinsics.checkNotNullParameter(guildWavAvatarImageView, "<set-?>");
        this.avatarIv = guildWavAvatarImageView;
    }

    public final void setBottomBarLevelImageView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.bottomBarLevelImageView = imageView;
    }

    public final void setBottomBarLevelTextView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.bottomBarLevelTextView = textView;
    }

    public final void setBottomBarLl(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.bottomBarLl = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setDtElement(@NotNull p userInfo, @NotNull String userState) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(userState, "userState");
        View view = this.itemView;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_user_segment", userInfo.C.getUserInfoInGame().getIdentityDesc()), TuplesKt.to("sgrp_user_state", userState), TuplesKt.to("sqrp_user_place", Integer.valueOf(getAdapterPosition())));
        ch.T0(view, "em_sgrp_honorofkings_user_card", clickPolicy, exposurePolicy, mapOf);
    }

    public final void setGamingHeroIv(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.gamingHeroIv = imageView;
    }

    public final void setGamingHeroRecordTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.gamingHeroRecordTv = textView;
    }

    public final void setGamingStatusLl(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.gamingStatusLl = linearLayout;
    }

    public final void setGoodAtHeroLl(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.goodAtHeroLl = linearLayout;
    }

    public final void setLocalFirstHeroImageView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.localFirstHeroImageView = imageView;
    }

    public final void setLocalFirstHeroLl(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.localFirstHeroLl = linearLayout;
    }

    public final void setLocalFirstHeroTextView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.localFirstHeroTextView = textView;
    }

    protected final void setMLocalUser(@Nullable f fVar) {
        this.mLocalUser = fVar;
    }

    protected final void setMNickNameIconUrl(@Nullable String str) {
        this.mNickNameIconUrl = str;
    }

    protected final void setMUserInfo(@Nullable p pVar) {
        this.mUserInfo = pVar;
    }

    public final void setMicIv(@NotNull GuildMediaVoiceMicView guildMediaVoiceMicView) {
        Intrinsics.checkNotNullParameter(guildMediaVoiceMicView, "<set-?>");
        this.micIv = guildMediaVoiceMicView;
    }

    public final void setMuteIv(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.muteIv = imageView;
    }

    public final void setNameIconLl(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.nameIconLl = linearLayout;
    }

    public final void setNetWorkStatus(@NotNull GuildMediaNetStatusView guildMediaNetStatusView) {
        Intrinsics.checkNotNullParameter(guildMediaNetStatusView, "<set-?>");
        this.netWorkStatus = guildMediaNetStatusView;
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder
    public void setNetworkStatus(@NotNull r userInfoList) {
        String str;
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        p pVar = this.mUserInfo;
        if (pVar != null) {
            str = pVar.f228093a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        p g16 = userInfoList.g(str);
        if (g16 != null) {
            setNetWorkStatus(g16);
        }
    }

    public final void setNickNameTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.nickNameTv = textView;
    }

    public final void setPersonalMedalIv(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.personalMedalIv = imageView;
    }

    public final void setRootApngBgImageView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.rootApngBgImageView = imageView;
    }

    public final void setRootBgImageView(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.rootBgImageView = imageView;
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.delegates.BaseTrtcLiveObserveMediaItemViewHolder
    public void setVolume(@NotNull Map<String, ? extends p> hasVolumeUserMap) {
        String str;
        Intrinsics.checkNotNullParameter(hasVolumeUserMap, "hasVolumeUserMap");
        p pVar = this.mUserInfo;
        if (pVar == null || (str = pVar.f228093a) == null) {
            str = "";
        }
        p pVar2 = hasVolumeUserMap.get(str);
        if (pVar2 != null && pVar2.f228109q > 5 && canPlayVolumeAnim(pVar2)) {
            this.avatarIv.setVolume(pVar2.f228109q);
        } else {
            this.avatarIv.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNetWorkStatus(p userInfo) {
        String str = userInfo.f228093a;
        f fVar = this.mLocalUser;
        Intrinsics.checkNotNull(fVar);
        if (!Intrinsics.areEqual(str, fVar.f228093a)) {
            if (userInfo.A >= 3) {
                this.netWorkStatus.setVisibility(0);
                GuildMediaNetStatusView guildMediaNetStatusView = this.netWorkStatus;
                Integer num = this.netStatusToBackgroundMap.get(Integer.valueOf(userInfo.A));
                if (num == null) {
                    num = Integer.valueOf(R.drawable.guild_audio_net_bad);
                }
                guildMediaNetStatusView.setImageResource(num.intValue());
                return;
            }
            this.netWorkStatus.setVisibility(8);
            return;
        }
        this.netWorkStatus.setVisibility(0);
        GuildMediaNetStatusView guildMediaNetStatusView2 = this.netWorkStatus;
        Integer num2 = this.netStatusToBackgroundMap.get(Integer.valueOf(userInfo.A));
        if (num2 == null) {
            num2 = Integer.valueOf(R.drawable.guild_audio_net_normal);
        }
        guildMediaNetStatusView2.setImageResource(num2.intValue());
    }
}
