package com.tencent.mobileqq.guild.media.widget.audiofaceview;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.m;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.widget.GuildMediaNetStatusView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaVoiceMicView;
import com.tencent.mobileqq.guild.media.widget.GuildWavAvatarImageView;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.util.UiThreadUtil;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00c0\u00012\u00020\u0001:\u0002\u00c1\u0001B#\b\u0007\u0012\b\u0010\u00bb\u0001\u001a\u00030\u00ba\u0001\u0012\f\b\u0002\u0010\u00bd\u0001\u001a\u0005\u0018\u00010\u00bc\u0001\u00a2\u0006\u0006\b\u00be\u0001\u0010\u00bf\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J1\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0013*\u00020\b2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001a\u00020\b*\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0014\u0010\u001e\u001a\u00020\u001d*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0002J$\u0010%\u001a\u00020\u00022\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00060\"2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006J&\u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0006J\u0010\u00100\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010#J\u000e\u00101\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\bJ\u000e\u00104\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\bJ\u0006\u00108\u001a\u000207J\u000e\u0010:\u001a\u00020\u00022\u0006\u00109\u001a\u00020\bR$\u0010B\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010H\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010O\u001a\u00020I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010R\u001a\u00020I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\"\u0010Z\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010b\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010cR\u0016\u0010e\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010]R\u0016\u0010f\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010]R\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020\b0g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010hRR\u0010o\u001a>\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020kj\u0002`l0jj\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020kj\u0002`l`m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010nR\u0016\u0010p\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\rR\"\u0010s\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010]\u001a\u0004\bq\u0010_\"\u0004\br\u0010aR\"\u0010v\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010]\u001a\u0004\bt\u0010_\"\u0004\bu\u0010aR\"\u0010{\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010c\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR%\u0010\u0082\u0001\u001a\u00020|8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b}\u0010~\u001a\u0004\b\\\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R&\u0010\u0086\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0083\u0001\u0010c\u001a\u0005\b\u0084\u0001\u0010x\"\u0005\b\u0085\u0001\u0010zR&\u0010\u008a\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0087\u0001\u0010c\u001a\u0005\b\u0088\u0001\u0010x\"\u0005\b\u0089\u0001\u0010zR&\u0010\u008e\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008b\u0001\u0010c\u001a\u0005\b\u008c\u0001\u0010x\"\u0005\b\u008d\u0001\u0010zR&\u0010\u0092\u0001\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008f\u0001\u0010U\u001a\u0005\b\u0090\u0001\u0010W\"\u0005\b\u0091\u0001\u0010YR&\u0010\u0096\u0001\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0093\u0001\u0010c\u001a\u0005\b\u0094\u0001\u0010x\"\u0005\b\u0095\u0001\u0010zR&\u0010\u009a\u0001\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0097\u0001\u0010U\u001a\u0005\b\u0098\u0001\u0010W\"\u0005\b\u0099\u0001\u0010YR%\u0010\u009d\u0001\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u0013\u0010U\u001a\u0005\b\u009b\u0001\u0010W\"\u0005\b\u009c\u0001\u0010YR&\u0010\u00a1\u0001\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009e\u0001\u0010]\u001a\u0005\b\u009f\u0001\u0010_\"\u0005\b\u00a0\u0001\u0010aR'\u0010\u00a5\u0001\u001a\u00020|8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u00a2\u0001\u0010~\u001a\u0005\b\u00a3\u0001\u0010\u007f\"\u0006\b\u00a4\u0001\u0010\u0081\u0001R\u0019\u0010\u00a7\u0001\u001a\u00020[8\u0006\u00a2\u0006\r\n\u0005\b\u00a6\u0001\u0010]\u001a\u0004\bT\u0010_R'\u0010\u00ab\u0001\u001a\u00020|8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u00a8\u0001\u0010~\u001a\u0005\b\u00a9\u0001\u0010\u007f\"\u0006\b\u00aa\u0001\u0010\u0081\u0001R&\u0010\u00af\u0001\u001a\u00020S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00ac\u0001\u0010U\u001a\u0005\b\u00ad\u0001\u0010W\"\u0005\b\u00ae\u0001\u0010YR\u0018\u0010\u00b1\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b0\u0001\u0010\rR4\u0010\u00b3\u0001\u001a\u001e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\b0jj\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\b`m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b2\u0001\u0010nR!\u0010\u00b9\u0001\u001a\u00030\u00b4\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001\u00a8\u0006\u00c2\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/ColumnLayout;", "Landroid/widget/RelativeLayout;", "", "v", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/media/core/data/p;", "info", "", DomainData.DOMAIN_NAME, "priority", "e", "r", "I", "", "g", NodeProps.VISIBLE, BdhLogUtil.LogTag.Tag_Conn, "E", "T", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "third", "t", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "u", "Landroid/widget/LinearLayout;", "Landroid/view/ViewGroup$LayoutParams;", "lp", "Landroid/widget/LinearLayout$LayoutParams;", h.F, ITVKPlayerEventListener.KEY_USER_INFO, "D", ReportConstant.COSTREPORT_PREFIX, "", "", "hasVolumeUserMap", "K", "guildId", "tinyId", "avatarMeta", "avatarPendant", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setNetWorkStatus", "J", "cardUserInfo", "H", "audioQueueNumber", "y", HippyTKDListViewAdapter.X, "countDownTime", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "G", UserInfo.SEX_FEMALE, "l", "Landroid/view/ViewGroup;", "k", "column", "f", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "d", "Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "getMAvatarIv", "()Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;", "setMAvatarIv", "(Lcom/tencent/mobileqq/guild/media/widget/GuildWavAvatarImageView;)V", "mAvatarIv", "Landroid/widget/RelativeLayout;", "getRootView", "()Landroid/widget/RelativeLayout;", "setRootView", "(Landroid/widget/RelativeLayout;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "Landroid/view/View;", "getMThirdAppInRoomBorder", "()Landroid/view/View;", "setMThirdAppInRoomBorder", "(Landroid/view/View;)V", "mThirdAppInRoomBorder", "j", "setGiftAnimShowBg", "giftAnimShowBg", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "getMNickNameTv", "()Landroid/widget/TextView;", "setMNickNameTv", "(Landroid/widget/TextView;)V", "mNickNameTv", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "getMNickNameIconIv", "()Landroid/widget/ImageView;", "setMNickNameIconIv", "(Landroid/widget/ImageView;)V", "mNickNameIconIv", "Landroid/widget/LinearLayout;", "mStatusLayout", "mNetWorkStatus", "mGameStatus", "Ljava/util/PriorityQueue;", "Ljava/util/PriorityQueue;", "statusPriorityQueue", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/StatusHandler;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "statusPriorityMap", "mLastSetNetWorkDrawableId", "getMMicIv", "setMMicIv", "mMicIv", "getMMuteTv", "setMMuteTv", "mMuteTv", "getMCenterContainer", "()Landroid/widget/LinearLayout;", "setMCenterContainer", "(Landroid/widget/LinearLayout;)V", "mCenterContainer", "Landroid/widget/FrameLayout;", "L", "Landroid/widget/FrameLayout;", "()Landroid/widget/FrameLayout;", "setMAvatarArea", "(Landroid/widget/FrameLayout;)V", "mAvatarArea", "M", "getMIconArea", "setMIconArea", "mIconArea", "N", "getMStatusArea", "setMStatusArea", "mStatusArea", "P", "getCountDownTimerContainer", "setCountDownTimerContainer", "countDownTimerContainer", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getCountDownTimerTv", "setCountDownTimerTv", "countDownTimerTv", BdhLogUtil.LogTag.Tag_Req, "getAudioQueueNumberContainer", "setAudioQueueNumberContainer", "audioQueueNumberContainer", ExifInterface.LATITUDE_SOUTH, "getAudioQueueNumberTv", "setAudioQueueNumberTv", "audioQueueNumberTv", "getAdminRoleTv", "setAdminRoleTv", "adminRoleTv", "U", "getPersonalMedalIv", "setPersonalMedalIv", "personalMedalIv", "V", "getAioLottieEmojiGroup", "setAioLottieEmojiGroup", "aioLottieEmojiGroup", "W", "giftAnimIv", "a0", "getMOnThePhoneIconLayout", "setMOnThePhoneIconLayout", "mOnThePhoneIconLayout", "b0", "getMOnThePhoneTv", "setMOnThePhoneTv", "mOnThePhoneTv", "c0", "mColumnsFlag", "d0", "priorityViewMap", "Lvp1/n;", "e0", "Lkotlin/Lazy;", "o", "()Lvp1/n;", "viewBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ColumnLayout extends RelativeLayout {

    /* renamed from: g0, reason: collision with root package name */
    private static final int f229843g0 = Color.parseColor("#00B3FF");

    /* renamed from: h0, reason: collision with root package name */
    private static final int f229844h0 = Color.parseColor("#FF4FA7");

    /* renamed from: i0, reason: collision with root package name */
    @NotNull
    private static HashMap<Integer, Integer> f229845i0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private LinearLayout mStatusLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ImageView mNetWorkStatus;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ImageView mGameStatus;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private PriorityQueue<Integer> statusPriorityQueue;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private HashMap<Integer, Function1<Boolean, Unit>> statusPriorityMap;

    /* renamed from: H, reason: from kotlin metadata */
    private int mLastSetNetWorkDrawableId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private ImageView mMicIv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ImageView mMuteTv;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private LinearLayout mCenterContainer;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private FrameLayout mAvatarArea;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private LinearLayout mIconArea;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private LinearLayout mStatusArea;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private LinearLayout countDownTimerContainer;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private TextView countDownTimerTv;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private LinearLayout audioQueueNumberContainer;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private TextView audioQueueNumberTv;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private TextView adminRoleTv;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private ImageView personalMedalIv;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private FrameLayout aioLottieEmojiGroup;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final ImageView giftAnimIv;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout mOnThePhoneIconLayout;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mOnThePhoneTv;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int mColumnsFlag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildWavAvatarImageView mAvatarIv;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<View, Integer> priorityViewMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RelativeLayout rootView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mThirdAppInRoomBorder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View giftAnimShowBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mNickNameTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mNickNameIconIv;

    static {
        HashMap<Integer, Integer> hashMapOf;
        Integer valueOf = Integer.valueOf(R.drawable.guild_audio_net_worst);
        Integer valueOf2 = Integer.valueOf(R.drawable.guild_audio_net_bad);
        Integer valueOf3 = Integer.valueOf(R.drawable.guild_audio_net_normal);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(6, valueOf), TuplesKt.to(5, valueOf), TuplesKt.to(4, valueOf2), TuplesKt.to(3, valueOf2), TuplesKt.to(2, valueOf3), TuplesKt.to(1, valueOf3), TuplesKt.to(0, valueOf3));
        f229845i0 = hashMapOf;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ColumnLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(int i3, ColumnLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.countDownTimerContainer.setVisibility(8);
        } else {
            this$0.countDownTimerContainer.setVisibility(0);
            this$0.countDownTimerTv.setText(MediaChannelUtils.f228046a.f(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(boolean visible) {
        int i3;
        ImageView imageView = this.mGameStatus;
        int i16 = 0;
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        View view = this.mThirdAppInRoomBorder;
        if (!visible) {
            i16 = 8;
        }
        view.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(boolean visible) {
        Integer peek = this.statusPriorityQueue.peek();
        if ((peek == null || peek.intValue() != 100) && (peek == null || peek.intValue() != 1)) {
            Logger.f235387a.d().d("ColumnLayout", 1, "hideNetworkStatus status " + peek);
            this.mNetWorkStatus.setVisibility(8);
        } else {
            Logger.f235387a.d().d("ColumnLayout", 1, "updateNetworkStatus status " + peek);
            this.mNetWorkStatus.setVisibility(0);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (MediaChannelUtils.B(context) && this.mGameStatus.getVisibility() == 0) {
            this.mNetWorkStatus.setVisibility(8);
        }
    }

    private final void I(int priority) {
        int i3;
        w.c("updateViewInVisibleFromPriority");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d(FaceViewHolder.TAG, "updateViewInVisibleFromPriority: " + priority);
        }
        for (Map.Entry<View, Integer> entry : this.priorityViewMap.entrySet()) {
            View key = entry.getKey();
            if (entry.getValue().intValue() == priority) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            key.setVisibility(i3);
        }
        w.d();
    }

    private final void e(int priority) {
        int intValue;
        if (this.statusPriorityQueue.contains(Integer.valueOf(priority))) {
            return;
        }
        Integer peek = this.statusPriorityQueue.peek();
        int i3 = 0;
        if (peek == null) {
            intValue = 0;
        } else {
            intValue = peek.intValue();
        }
        this.statusPriorityQueue.add(Integer.valueOf(priority));
        Integer peek2 = this.statusPriorityQueue.peek();
        if (peek2 != null) {
            i3 = peek2.intValue();
        }
        if (i3 == intValue) {
            return;
        }
        Logger.f235387a.d().d("ColumnLayout", 1, "addStatusPriority needUpdatePriority " + priority + ", newTopPriority " + i3);
        Function1<Boolean, Unit> function1 = this.statusPriorityMap.get(Integer.valueOf(intValue));
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        Function1<Boolean, Unit> function12 = this.statusPriorityMap.get(Integer.valueOf(i3));
        if (function12 != null) {
            function12.invoke(Boolean.TRUE);
        }
    }

    private final boolean g(p info) {
        if (QLog.isColorLevel()) {
            QLog.i(FaceViewHolder.TAG, 2, "canPlayVolumeAnim id: " + info.f228093a + " , isMicOn: " + info.f228101i + ", muteToMe: " + info.f228112t + ", globalMute: " + info.f228113u + ", volumeToMe: " + info.f228110r + ", phoneBusy: " + info.B);
        }
        if (n(info) == 100) {
            return true;
        }
        return false;
    }

    private final LinearLayout.LayoutParams h(LinearLayout linearLayout, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        return (LinearLayout.LayoutParams) layoutParams;
    }

    private final int n(p info) {
        if (!j.a().isInChannel()) {
            return 0;
        }
        if (info.B) {
            return 5;
        }
        if (m.a(j.c())) {
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

    private final n o() {
        return (n) this.viewBinding.getValue();
    }

    private final void p() {
        HashMap<View, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(this.mOnThePhoneIconLayout, 5), TuplesKt.to(this.mOnThePhoneTv, 5), TuplesKt.to(this.mMicIv, 1), TuplesKt.to(this.mMuteTv, 2));
        this.priorityViewMap = hashMapOf;
    }

    private final void q() {
        HashMap<Integer, Function1<Boolean, Unit>> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(100, new ColumnLayout$initStatusPriorityMap$1(this)), TuplesKt.to(50, new ColumnLayout$initStatusPriorityMap$2(this)), TuplesKt.to(1, new ColumnLayout$initStatusPriorityMap$3(this)));
        this.statusPriorityMap = hashMapOf;
    }

    private final void r(int priority) {
        int intValue;
        if (!this.statusPriorityQueue.contains(Integer.valueOf(priority))) {
            return;
        }
        Logger logger = Logger.f235387a;
        logger.d().d("ColumnLayout", 1, "removeStatusPriority priority " + priority);
        Integer peek = this.statusPriorityQueue.peek();
        int i3 = 0;
        if (peek == null) {
            intValue = 0;
        } else {
            intValue = peek.intValue();
        }
        this.statusPriorityQueue.remove(Integer.valueOf(priority));
        Integer peek2 = this.statusPriorityQueue.peek();
        if (peek2 != null) {
            i3 = peek2.intValue();
        }
        if (i3 == intValue) {
            return;
        }
        logger.d().d("ColumnLayout", 1, "removeStatusPriority oldTopPriority " + intValue + ", newTopPriority " + i3);
        Function1<Boolean, Unit> function1 = this.statusPriorityMap.get(Integer.valueOf(intValue));
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        Function1<Boolean, Unit> function12 = this.statusPriorityMap.get(Integer.valueOf(i3));
        if (function12 != null) {
            function12.invoke(Boolean.TRUE);
        }
    }

    private final <T> T t(int i3, T t16, T t17, T t18) {
        if (i3 != 1) {
            if (i3 != 2) {
                return t18;
            }
            return t17;
        }
        return t16;
    }

    private final int u(int i3, int i16, int i17, int i18) {
        return ViewUtils.dpToPx(((Number) t(i3, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).intValue());
    }

    private final void v() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (MediaChannelUtils.B(context)) {
            ViewGroup.LayoutParams layoutParams = this.mAvatarArea.getLayoutParams();
            layoutParams.width = (int) (layoutParams.width * 0.8d);
            layoutParams.height = (int) (layoutParams.height * 0.8d);
            this.mAvatarArea.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.mNickNameTv.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).weight = 1.0f;
            this.countDownTimerTv.setTextSize(10.0f);
            ImageView imageView = this.mMicIv;
            int dpToPx = ViewUtils.dpToPx(2.0f);
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams4 = imageView.getLayoutParams();
                int i16 = -2;
                if (layoutParams4 != null) {
                    i3 = layoutParams4.width;
                } else {
                    i3 = -2;
                }
                ViewGroup.LayoutParams layoutParams5 = imageView.getLayoutParams();
                if (layoutParams5 != null) {
                    i16 = layoutParams5.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, i16);
            }
            if (dpToPx != marginLayoutParams.leftMargin) {
                marginLayoutParams.leftMargin = dpToPx;
                imageView.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int w(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public final void A(final int countDownTime) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.audiofaceview.a
            @Override // java.lang.Runnable
            public final void run() {
                ColumnLayout.B(countDownTime, this);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            UiThreadUtil.runOnUiThread(runnable);
        }
    }

    public final void D(@NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        if (!Intrinsics.areEqual(this.mNickNameTv.getText(), userInfo.f228094b)) {
            this.mNickNameTv.setText(userInfo.f228094b);
        }
    }

    public final void F(@NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        String url = userInfo.L.getUrl();
        if (!StringUtil.isEmpty(url)) {
            u.q(url, this.personalMedalIv, true);
            this.personalMedalIv.setVisibility(0);
        } else {
            this.personalMedalIv.setVisibility(8);
        }
    }

    public final void G(@NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        w.c("ColumnLayout_updateThirdAppGameStatus");
        if (userInfo.f228100h) {
            e(50);
        } else {
            r(50);
        }
        w.d();
    }

    public final void H(@NotNull p userInfo, @Nullable p cardUserInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        w.c("ColumnLayout_updateUserStatus");
        I(n(userInfo));
        w.d();
    }

    public final void J(@NotNull p info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.f228117y == 2) {
            GuildWavAvatarImageView guildWavAvatarImageView = this.mAvatarIv;
            if (guildWavAvatarImageView != null) {
                guildWavAvatarImageView.setColor(f229844h0);
                return;
            }
            return;
        }
        GuildWavAvatarImageView guildWavAvatarImageView2 = this.mAvatarIv;
        if (guildWavAvatarImageView2 != null) {
            guildWavAvatarImageView2.setColor(f229843g0);
        }
    }

    public final void K(@NotNull Map<String, ? extends p> hasVolumeUserMap, @Nullable p userInfo) {
        String str;
        Intrinsics.checkNotNullParameter(hasVolumeUserMap, "hasVolumeUserMap");
        if (userInfo == null || (str = userInfo.f228093a) == null) {
            str = "";
        }
        p pVar = hasVolumeUserMap.get(str);
        if (pVar != null && pVar.f228109q > 5 && g(pVar)) {
            GuildWavAvatarImageView guildWavAvatarImageView = this.mAvatarIv;
            if (guildWavAvatarImageView != null) {
                guildWavAvatarImageView.setVolume(pVar.f228109q);
                return;
            }
            return;
        }
        GuildWavAvatarImageView guildWavAvatarImageView2 = this.mAvatarIv;
        if (guildWavAvatarImageView2 != null) {
            guildWavAvatarImageView2.z();
        }
    }

    public final void f(int column) {
        Integer num;
        int i3;
        int i16;
        if (this.mColumnsFlag == column) {
            return;
        }
        QLog.i("ColumnLayout", 1, "[bindColumn] " + column);
        this.mColumnsFlag = column;
        RelativeLayout relativeLayout = this.rootView;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            relativeLayout.setBackgroundResource(0);
            Object tag = relativeLayout.getTag(R.id.wqo);
            if (tag instanceof Integer) {
                num = (Integer) tag;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 1;
            }
            if (GuildMediaUtils.f227771a.n()) {
                i16 = R.drawable.guild_media_channel_user_item_bg;
            } else if (i3 == 1) {
                i16 = R.drawable.guild_media_channel_user_small_item_bg1;
            } else {
                i16 = R.drawable.guild_media_channel_user_small_item_bg2;
            }
            relativeLayout.setBackgroundResource(i16);
            LinearLayout linearLayout = this.mStatusLayout;
            ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
            if (layoutParams2 != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams3.rightMargin = u(column, 20, 12, 8);
                layoutParams3.topMargin = u(column, 20, 12, 8);
                linearLayout.setLayoutParams(layoutParams3);
                linearLayout.setLayoutParams(layoutParams3);
                LinearLayout linearLayout2 = this.countDownTimerContainer;
                ViewGroup.LayoutParams layoutParams4 = linearLayout2.getLayoutParams();
                if (layoutParams4 != null) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
                    layoutParams5.rightMargin = u(column, 20, 8, 2);
                    layoutParams5.topMargin = u(column, 20, 8, 2);
                    linearLayout2.setLayoutParams(layoutParams5);
                    LinearLayout linearLayout3 = this.mCenterContainer;
                    ViewGroup.LayoutParams layoutParams6 = linearLayout3.getLayoutParams();
                    if (layoutParams6 != null) {
                        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams6;
                        layoutParams7.height = u(column, 180, 180, 130);
                        FrameLayout frameLayout = this.mAvatarArea;
                        ViewGroup.LayoutParams layoutParams8 = frameLayout.getLayoutParams();
                        if (layoutParams8 != null) {
                            LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) layoutParams8;
                            layoutParams9.height = u(column, 65, 65, 44);
                            layoutParams9.width = u(column, 65, 65, 44);
                            GuildWavAvatarImageView guildWavAvatarImageView = this.mAvatarIv;
                            if (guildWavAvatarImageView != null) {
                                guildWavAvatarImageView.setImageWidth(((Number) t(column, 65, 65, 44)).intValue());
                            }
                            LinearLayout linearLayout4 = this.audioQueueNumberContainer;
                            ViewGroup.LayoutParams layoutParams10 = linearLayout4.getLayoutParams();
                            if (layoutParams10 != null) {
                                FrameLayout.LayoutParams layoutParams11 = (FrameLayout.LayoutParams) layoutParams10;
                                layoutParams11.height = u(column, 20, 20, 16);
                                layoutParams11.width = u(column, 20, 20, 16);
                                TextView textView = this.audioQueueNumberTv;
                                ViewGroup.LayoutParams layoutParams12 = textView.getLayoutParams();
                                Intrinsics.checkNotNullExpressionValue(layoutParams12, "layoutParams");
                                LinearLayout.LayoutParams h16 = h(linearLayout4, layoutParams12);
                                h16.height = u(column, 20, 20, 16);
                                h16.width = u(column, 20, 20, 16);
                                textView.setLayoutParams(h16);
                                textView.setTextSize(((Number) t(column, Float.valueOf(12.0f), Float.valueOf(12.0f), Float.valueOf(10.0f))).floatValue());
                                linearLayout4.setLayoutParams(layoutParams11);
                                frameLayout.setLayoutParams(layoutParams9);
                                LinearLayout linearLayout5 = this.mIconArea;
                                ViewGroup.LayoutParams layoutParams13 = linearLayout5.getLayoutParams();
                                if (layoutParams13 != null) {
                                    LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) layoutParams13;
                                    layoutParams14.topMargin = u(column, 16, 16, 8);
                                    TextView textView2 = this.mNickNameTv;
                                    textView2.setTextSize(((Number) t(column, Float.valueOf(16.0f), Float.valueOf(16.0f), Float.valueOf(12.0f))).floatValue());
                                    textView2.setMaxEms(((Number) t(column, 7, 7, 5)).intValue());
                                    ImageView imageView = this.mNickNameIconIv;
                                    ViewGroup.LayoutParams layoutParams15 = imageView.getLayoutParams();
                                    Intrinsics.checkNotNullExpressionValue(layoutParams15, "layoutParams");
                                    LinearLayout.LayoutParams h17 = h(linearLayout5, layoutParams15);
                                    h17.setMarginStart(u(column, 4, 4, 2));
                                    imageView.setLayoutParams(h17);
                                    ImageView imageView2 = this.mMicIv;
                                    ViewGroup.LayoutParams layoutParams16 = imageView2.getLayoutParams();
                                    Intrinsics.checkNotNullExpressionValue(layoutParams16, "layoutParams");
                                    LinearLayout.LayoutParams h18 = h(linearLayout5, layoutParams16);
                                    h18.width = u(column, 20, 20, 16);
                                    h18.height = u(column, 20, 20, 16);
                                    imageView2.setLayoutParams(h18);
                                    ImageView imageView3 = this.mMuteTv;
                                    ViewGroup.LayoutParams layoutParams17 = imageView3.getLayoutParams();
                                    Intrinsics.checkNotNullExpressionValue(layoutParams17, "layoutParams");
                                    LinearLayout.LayoutParams h19 = h(linearLayout5, layoutParams17);
                                    h19.width = u(column, 20, 20, 16);
                                    h19.height = u(column, 20, 20, 16);
                                    imageView3.setLayoutParams(h19);
                                    linearLayout5.setLayoutParams(layoutParams14);
                                    LinearLayout linearLayout6 = this.mStatusArea;
                                    ViewGroup.LayoutParams layoutParams18 = linearLayout6.getLayoutParams();
                                    if (layoutParams18 != null) {
                                        LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) layoutParams18;
                                        layoutParams19.topMargin = u(column, 9, 6, 6);
                                        this.mOnThePhoneTv.setTextSize(((Number) t(column, Float.valueOf(14.0f), Float.valueOf(14.0f), Float.valueOf(10.0f))).floatValue());
                                        linearLayout6.setLayoutParams(layoutParams19);
                                        linearLayout3.setLayoutParams(layoutParams7);
                                        relativeLayout.setLayoutParams(marginLayoutParams);
                                        v();
                                        return;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final ImageView getGiftAnimIv() {
        return this.giftAnimIv;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final View getGiftAnimShowBg() {
        return this.giftAnimShowBg;
    }

    @NotNull
    public final ViewGroup k() {
        return this.aioLottieEmojiGroup;
    }

    public final int l() {
        return (int) (this.mAvatarArea.getLayoutParams().width * 1.5f);
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final FrameLayout getMAvatarArea() {
        return this.mAvatarArea;
    }

    public final void s() {
        this.statusPriorityQueue.clear();
        Iterator<Map.Entry<Integer, Function1<Boolean, Unit>>> it = this.statusPriorityMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(Boolean.FALSE);
        }
        GuildWavAvatarImageView guildWavAvatarImageView = this.mAvatarIv;
        if (guildWavAvatarImageView != null) {
            guildWavAvatarImageView.A();
        }
        I(0);
    }

    public final void setAdminRoleTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.adminRoleTv = textView;
    }

    public final void setAioLottieEmojiGroup(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.aioLottieEmojiGroup = frameLayout;
    }

    public final void setAudioQueueNumberContainer(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.audioQueueNumberContainer = linearLayout;
    }

    public final void setAudioQueueNumberTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.audioQueueNumberTv = textView;
    }

    public final void setCountDownTimerContainer(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.countDownTimerContainer = linearLayout;
    }

    public final void setCountDownTimerTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.countDownTimerTv = textView;
    }

    public final void setGiftAnimShowBg(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.giftAnimShowBg = view;
    }

    public final void setMAvatarArea(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mAvatarArea = frameLayout;
    }

    public final void setMAvatarIv(@Nullable GuildWavAvatarImageView guildWavAvatarImageView) {
        this.mAvatarIv = guildWavAvatarImageView;
    }

    public final void setMCenterContainer(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mCenterContainer = linearLayout;
    }

    public final void setMIconArea(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mIconArea = linearLayout;
    }

    public final void setMMicIv(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mMicIv = imageView;
    }

    public final void setMMuteTv(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mMuteTv = imageView;
    }

    public final void setMNickNameIconIv(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mNickNameIconIv = imageView;
    }

    public final void setMNickNameTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mNickNameTv = textView;
    }

    public final void setMOnThePhoneIconLayout(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mOnThePhoneIconLayout = frameLayout;
    }

    public final void setMOnThePhoneTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mOnThePhoneTv = textView;
    }

    public final void setMStatusArea(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mStatusArea = linearLayout;
    }

    public final void setMThirdAppInRoomBorder(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mThirdAppInRoomBorder = view;
    }

    public final void setNetWorkStatus(@NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        int i3 = userInfo.A;
        String str = j.c().getSelfUserInfo().f228093a;
        Integer num = f229845i0.get(Integer.valueOf(i3));
        if (num == null) {
            num = Integer.valueOf(R.drawable.guild_audio_net_normal);
        }
        int intValue = num.intValue();
        if (this.mLastSetNetWorkDrawableId != intValue) {
            this.mLastSetNetWorkDrawableId = intValue;
            this.mNetWorkStatus.setImageResource(intValue);
        }
        if (i3 >= 3) {
            e(100);
            return;
        }
        r(100);
        if (Intrinsics.areEqual(userInfo.f228093a, str)) {
            e(1);
        } else {
            r(1);
        }
    }

    public final void setPersonalMedalIv(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.personalMedalIv = imageView;
    }

    public final void setRootView(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.rootView = relativeLayout;
    }

    public final void x(@NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        w.c("ColumnLayout_updateAdminRoleIcon");
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
            this.adminRoleTv.getBackground().setTint(Color.parseColor("#79798C"));
            this.adminRoleTv.setText(getContext().getString(R.string.f140130d5));
        }
        w.d();
    }

    public final void y(@Nullable String audioQueueNumber) {
        if (audioQueueNumber == null) {
            this.audioQueueNumberContainer.setVisibility(8);
        } else {
            this.audioQueueNumberContainer.setVisibility(0);
            this.audioQueueNumberTv.setText(audioQueueNumber);
        }
    }

    public final void z(@NotNull String guildId, @NotNull String tinyId, @NotNull String avatarMeta, @NotNull String avatarPendant) {
        Object obj;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        Intrinsics.checkNotNullParameter(avatarPendant, "avatarPendant");
        GuildWavAvatarImageView guildWavAvatarImageView = this.mAvatarIv;
        String str = null;
        if (guildWavAvatarImageView != null) {
            obj = guildWavAvatarImageView.getTag(R.id.f165434vz4);
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (TextUtils.equals(avatarMeta, str)) {
            return;
        }
        GuildWavAvatarImageView guildWavAvatarImageView2 = this.mAvatarIv;
        if (guildWavAvatarImageView2 != null) {
            guildWavAvatarImageView2.setTag(R.id.f165434vz4, avatarMeta);
        }
        GuildWavAvatarImageView guildWavAvatarImageView3 = this.mAvatarIv;
        if (guildWavAvatarImageView3 != null) {
            guildWavAvatarImageView3.setAvatarTinyId(guildId, tinyId, avatarMeta, avatarPendant);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ColumnLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        final ColumnLayout$statusPriorityQueue$1 columnLayout$statusPriorityQueue$1 = new Function2<Integer, Integer, Integer>() { // from class: com.tencent.mobileqq.guild.media.widget.audiofaceview.ColumnLayout$statusPriorityQueue$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(Integer o16, Integer num) {
                int intValue = num.intValue();
                Intrinsics.checkNotNullExpressionValue(o16, "o1");
                return Integer.valueOf(intValue - o16.intValue());
            }
        };
        this.statusPriorityQueue = new PriorityQueue<>(4, new Comparator() { // from class: com.tencent.mobileqq.guild.media.widget.audiofaceview.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int w3;
                w3 = ColumnLayout.w(Function2.this, obj, obj2);
                return w3;
            }
        });
        this.statusPriorityMap = new HashMap<>();
        this.mLastSetNetWorkDrawableId = -1;
        this.mColumnsFlag = -1;
        this.priorityViewMap = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<n>() { // from class: com.tencent.mobileqq.guild.media.widget.audiofaceview.ColumnLayout$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final n invoke() {
                return n.g(LayoutInflater.from(context), this, true);
            }
        });
        this.viewBinding = lazy;
        setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        this.rootView = this;
        this.mAvatarIv = o().f443049j;
        View view = o().C;
        Intrinsics.checkNotNullExpressionValue(view, "viewBinding.thirdAppInRoomBorder");
        this.mThirdAppInRoomBorder = view;
        View view2 = o().f443045f;
        Intrinsics.checkNotNullExpressionValue(view2, "viewBinding.giftAnimShowBg");
        this.giftAnimShowBg = view2;
        FrameLayout frameLayout = o().f443054o;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "viewBinding.guildAudioHeadsViewOnThePhone");
        this.mOnThePhoneIconLayout = frameLayout;
        TextView textView = o().f443052m;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.guildAudioHeadsViewItemName");
        this.mNickNameTv = textView;
        ImageView imageView = o().f443056q;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.guildAudioNameIcon");
        this.mNickNameIconIv = imageView;
        LinearLayout linearLayout = o().f443065z;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.itemStatusLayout");
        this.mStatusLayout = linearLayout;
        GuildMediaNetStatusView guildMediaNetStatusView = o().A;
        Intrinsics.checkNotNullExpressionValue(guildMediaNetStatusView, "viewBinding.networkStatus");
        this.mNetWorkStatus = guildMediaNetStatusView;
        GuildMediaNetStatusView guildMediaNetStatusView2 = o().f443044e;
        Intrinsics.checkNotNullExpressionValue(guildMediaNetStatusView2, "viewBinding.gameStatus");
        this.mGameStatus = guildMediaNetStatusView2;
        TextView textView2 = o().f443057r;
        Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.guildAudioOnThePhoneTv");
        this.mOnThePhoneTv = textView2;
        GuildMediaVoiceMicView guildMediaVoiceMicView = o().f443050k;
        Intrinsics.checkNotNullExpressionValue(guildMediaVoiceMicView, "viewBinding.guildAudioHeadsViewItemMic");
        this.mMicIv = guildMediaVoiceMicView;
        ImageView imageView2 = o().f443051l;
        Intrinsics.checkNotNullExpressionValue(imageView2, "viewBinding.guildAudioHeadsViewItemMute");
        this.mMuteTv = imageView2;
        LinearLayout linearLayout2 = o().f443043d;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "viewBinding.centerContainer");
        this.mCenterContainer = linearLayout2;
        FrameLayout frameLayout2 = o().f443042c;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "viewBinding.avatarArea");
        this.mAvatarArea = frameLayout2;
        LinearLayout linearLayout3 = o().f443063x;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "viewBinding.iconArea");
        this.mIconArea = linearLayout3;
        LinearLayout linearLayout4 = o().B;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "viewBinding.statusArea");
        this.mStatusArea = linearLayout4;
        LinearLayout linearLayout5 = o().f443047h;
        Intrinsics.checkNotNullExpressionValue(linearLayout5, "viewBinding.guildAudioCountdownTimerContainer");
        this.countDownTimerContainer = linearLayout5;
        TextView textView3 = o().f443048i;
        Intrinsics.checkNotNullExpressionValue(textView3, "viewBinding.guildAudioCountdownTimerTv");
        this.countDownTimerTv = textView3;
        LinearLayout linearLayout6 = o().f443059t;
        Intrinsics.checkNotNullExpressionValue(linearLayout6, "viewBinding.guildAudioQueueNumberContainer");
        this.audioQueueNumberContainer = linearLayout6;
        TextView textView4 = o().f443058s;
        Intrinsics.checkNotNullExpressionValue(textView4, "viewBinding.guildAudioQueueNumber");
        this.audioQueueNumberTv = textView4;
        textView4.setTypeface(TypefaceProvider.c(context, "fonts/DIN-NextLT-Pro-QQ.ttf"));
        TextView textView5 = o().f443046g;
        Intrinsics.checkNotNullExpressionValue(textView5, "viewBinding.guildAdminRoleIconTv");
        this.adminRoleTv = textView5;
        ImageView imageView3 = o().f443062w;
        Intrinsics.checkNotNullExpressionValue(imageView3, "viewBinding.guildUserPersonalMedal");
        this.personalMedalIv = imageView3;
        FrameLayout frameLayout3 = o().f443061v;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "viewBinding.guildMediaUserAioLottieArea");
        this.aioLottieEmojiGroup = frameLayout3;
        ImageView imageView4 = o().f443060u;
        Intrinsics.checkNotNullExpressionValue(imageView4, "viewBinding.guildMediaUserAioGiftArea");
        this.giftAnimIv = imageView4;
        p();
        q();
        v();
    }

    public /* synthetic */ ColumnLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
