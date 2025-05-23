package com.tencent.mobileqq.guild.media.core.logic;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import at1.GuildGameCreateBean;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.GuildMediaUserBarNodePermission;
import com.tencent.mobileqq.guild.media.core.data.UserAVInfo;
import com.tencent.mobileqq.guild.media.core.data.UserBusinessInfo;
import com.tencent.mobileqq.guild.media.core.logic.entertips.UserEnterTipsTrigger;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.guild.media.widget.MediaChannelDialogFragment;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.security.GuildChannelSwitchManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVShowMsgInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSchemaConfig;
import com.tencent.mobileqq.qqguildsdk.data.es;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.qqguildsdk.data.type.IUserPlatformType;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import dt0.MediaUserEnterTipsModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.group_pro_proto.channel_share.GuildChannelShare$ChannelShareGuidancePush;

@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\b*\u0004\u009c\u0001\u00a0\u0001\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002\u00a6\u0001B\u0013\u0012\b\u0010\u008c\u0001\u001a\u00030\u0089\u0001\u00a2\u0006\u0006\b\u00a4\u0001\u0010\u00a5\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\u0012\u001a\u00020\u00052\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u001c\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0018\u0010\"\u001a\u00020\u001b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0002J#\u0010)\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010&H\u0002\u00a2\u0006\u0004\b)\u0010*J\b\u0010+\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0002J\u0018\u0010-\u001a\u00020\u00052\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u0018\u00100\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u000fH\u0002J\u0016\u00101\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u00102\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\u0010\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020&H\u0002J\u0018\u0010:\u001a\u00020\u000b2\u0006\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\u000bH\u0002J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020;H\u0002J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020>H\u0002J\u0018\u0010B\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000bH\u0002J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u001bH\u0002J \u0010F\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000bH\u0002J\u001c\u0010G\u001a\u00020\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010I\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010J\u001a\u00020\u0005H\u0016J\b\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\u0005H\u0016J\b\u0010M\u001a\u00020\u0005H\u0016J&\u0010O\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\b\u0010N\u001a\u0004\u0018\u00010\u000bH\u0014J$\u0010R\u001a\u00020\u00052\u0006\u0010P\u001a\u00020&2\b\u0010Q\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J4\u0010S\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J&\u0010T\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\b\u0010N\u001a\u0004\u0018\u00010\u000bH\u0014J\u0018\u0010X\u001a\u00020\u00052\u0006\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020&H\u0014J\u001a\u0010\\\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020&2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0014J\u0010\u0010]\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010_\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010`\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0014J(\u0010c\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020&2\u0006\u0010b\u001a\u00020&H\u0014J\u0018\u0010e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020&H\u0014J\u001e\u0010h\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u000b0fH\u0014J:\u0010i\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J:\u0010j\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014JF\u0010m\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J(\u0010q\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020oH\u0014J \u0010t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u001bH\u0014J0\u0010x\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020&2\u0006\u0010w\u001a\u00020\u000bH\u0014J6\u0010y\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J6\u0010z\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J6\u0010{\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010|\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J6\u0010}\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014JA\u0010\u0080\u0001\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b2\u0006\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020&H\u0014J*\u0010\u0082\u0001\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b2\u0007\u0010\u0081\u0001\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020oH\u0014J)\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020;H\u0014J\u0011\u0010\u0084\u0001\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000bH\u0014J)\u0010\u0085\u0001\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020oH\u0014J\u0019\u0010\u0086\u0001\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000bH\u0014J(\u0010\u0088\u0001\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\t\u0010[\u001a\u0005\u0018\u00010\u0087\u0001H\u0014R\u0018\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R!\u0010\u0092\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R(\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u008f\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0018\u0010\u00a3\u0001\u001a\u00030\u00a0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u00a8\u0006\u00a7\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProHeartbeatRsq;", "heartBeatRsp", "", "B", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessNode;", "bizNode", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "guildId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "Lkotlin/collections/ArrayList;", "avUserInfoList", "U", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelUserNumInfo", "Y", "o", "from", "X", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "targetInfo", "", "bAllow", "d0", "isGlobalMute", "a0", "O", "userList", "G", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVUserStateChangeInfo;", "userStateInfo", "W", "", "avState", "devOpt", "c0", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "I", ExifInterface.LATITUDE_SOUTH, "f0", ITVKPlayerEventListener.KEY_USER_INFO, "updateUserInfo", "e0", "b0", DomainData.DOMAIN_NAME, "channelUin", "J", "H", "type", "K", "code", "msg", "v", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSchemaConfig;", "schemaConfig", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "view", "P", "reason", ReportConstant.COSTREPORT_PREFIX, "hasTalkPermission", "N", "channelId", "r", "E", "tips", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "E0", "u", "p", "h0", "showTips", "onPushAVForceKickOut", "result", "errMsg", "onPushAVHeartbeatRsp", "onRobotStateChangeNotifyForAll", "onPushAVForceStopScreenShare", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "sourceType", "onAddGuildWithInfo", "bussinessId", "", "eventdata", "onPushBussinessConfig", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "onChannelListUpdated", "oldVisibleType", "newVisibleType", "onChannelVisibleChanged", "black", "onBeKickFromGuild", "", "channelIds", "onPushChannelDestroy", "onUserEnterListNotifyForAll", "onUserLeaveListNotifyForAll", "playerList", "viewerList", "onAVUserInfoChangeNotifyForAll", "tinyId", "", "source", "onPushPermissionInGuild", "admint", "bAdmin", "onAdminChanged", "chnnUin", "leavePlat", "message", "onAudioChannelUserPlatSwith", "onUserWaitingToSpeakNotifyForAll", "onUserSpeakingNotifyForAll", "onUserAVStateResetNotifyForAll", "onPushAVUserStateChange", "onEnterSpeakQueueNotifyForAll", "operatorTinyId", "leavePlatform", "onPushKickOutAudioChannel", "bMute", "onUserMuteSeatInGuild", "onPushInviteMemberEvent", "onChannelInfoUpdated", "onPushAllowScreenShareInGuild", "onVoiceHeartbeatTimeout", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserGiftRankInfo;", "onPushUserGiftRankChangeNotify", "Lcom/tencent/mobileqq/guild/media/core/f;", "d", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "e", "Lkotlin/Lazy;", "t", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "igpsService", "Lcom/tencent/mobileqq/guild/media/core/logic/entertips/b;", "Ldt0/a;", "f", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/guild/media/core/logic/entertips/b;", "userEnterTrigger", tl.h.F, "Ljava/lang/Integer;", "speakMode", "com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$f", "i", "Lcom/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$f;", "talkPermissionUpdateObserver", "com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$b;", "bizNodeUpdateObserver", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class InnerMediaGProObserverHelper extends GPServiceObserver implements com.tencent.mobileqq.guild.media.core.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy igpsService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy userEnterTrigger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer speakMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f talkPermissionUpdateObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b bizNodeUpdateObserver;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/e;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.e> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.e event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getBizNode().getNodeType() == 2) {
                InnerMediaGProObserverHelper.this.A(event.getBizNode());
            } else if (event.getBizNode().getNodeType() == 1) {
                InnerMediaGProObserverHelper.this.z(event.getBizNode());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$c", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.i {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "onSelfTalkPermissionUpdate: result[" + result + "] errMsg[" + errMsg + "]");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$d", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.i {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "onSelfTalkPermissionUpdate: result[" + result + "] errMsg[" + errMsg + "]");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$e", "Lcom/tencent/mobileqq/guild/media/core/h;", "", "isSuccess", "", "authMeta", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.h {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.h
        public void a(boolean isSuccess, @NotNull String authMeta) {
            Intrinsics.checkNotNullParameter(authMeta, "authMeta");
            if (isSuccess) {
                com.tencent.mobileqq.guild.media.core.j.a().Q().L0(null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bi;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.bi> {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.bi event) {
            Intrinsics.checkNotNullParameter(event, "event");
            InnerMediaGProObserverHelper.this.N(event.getHasTalkPermission());
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$g", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.i {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "closeMic result: " + result + ", " + errMsg);
        }
    }

    public InnerMediaGProObserverHelper(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$igpsService$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGPSService invoke() {
                IRuntimeService runtimeService = InnerMediaGProObserverHelper.this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
                return (IGPSService) runtimeService;
            }
        });
        this.igpsService = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<UserEnterTipsTrigger<MediaUserEnterTipsModel>>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$userEnterTrigger$2

            @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/InnerMediaGProObserverHelper$userEnterTrigger$2$a", "Lcom/tencent/mobileqq/guild/media/core/logic/entertips/a;", "Ldt0/a;", "", "data", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements com.tencent.mobileqq.guild.media.core.logic.entertips.a<MediaUserEnterTipsModel> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ InnerMediaGProObserverHelper f228166a;

                a(InnerMediaGProObserverHelper innerMediaGProObserverHelper) {
                    this.f228166a = innerMediaGProObserverHelper;
                }

                @Override // com.tencent.mobileqq.guild.media.core.logic.entertips.a
                public void a(@NotNull List<? extends MediaUserEnterTipsModel> data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    this.f228166a.core.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bc(data));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UserEnterTipsTrigger<MediaUserEnterTipsModel> invoke() {
                final InnerMediaGProObserverHelper innerMediaGProObserverHelper = InnerMediaGProObserverHelper.this;
                return new UserEnterTipsTrigger<>(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$userEnterTrigger$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final CoroutineScope invoke() {
                        return InnerMediaGProObserverHelper.this.core.getCoroutineScope();
                    }
                }, new a(InnerMediaGProObserverHelper.this));
            }
        });
        this.userEnterTrigger = lazy2;
        this.talkPermissionUpdateObserver = new f();
        this.bizNodeUpdateObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(IGProBusinessNode bizNode) {
        IGProVoiceInfo screenShareInfo = bizNode.getScreenShareInfo();
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.Core.MediaGProObserverHelper", 1, "handleScreenShareChange, screenState:" + screenShareInfo.getScreenState() + ", screenShareTinyId:" + screenShareInfo.getScreenShareTinyId());
        this.core.o0().C().setValue(screenShareInfo);
        if (Intrinsics.areEqual(String.valueOf(screenShareInfo.getScreenShareTinyId()), com.tencent.mobileqq.guild.util.ch.f()) && screenShareInfo.getScreenState() == 2) {
            logger.d().i("QGMC.Core.MediaGProObserverHelper", 1, "handleScreenShareChange, self:" + screenShareInfo.getScreenShareTinyId() + ", perform closeScreenShare");
            this.core.W().d(false);
        }
    }

    private final void B(IGProHeartbeatRsq heartBeatRsp) {
        if (heartBeatRsp.getNoStreamDisconnectTrtcSecond() <= 0) {
            this.core.o0().getEnterChannelParamsForTRTCRoom().g(heartBeatRsp.getNoStreamDisconnectTrtcSecond());
            QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVHeartbeatRsp stopExitTRTCRoomCountDownTimer");
            this.core.Q().y();
            if (!this.core.i0(String.valueOf(heartBeatRsp.getChannelId()))) {
                QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVHeartbeatRsp need enter trtc room");
                this.core.Q().L0(null);
                return;
            }
            return;
        }
        if (this.core.o0().getEnterChannelParamsForTRTCRoom().getDisConnectTRTCSeconds() != heartBeatRsp.getNoStreamDisconnectTrtcSecond()) {
            this.core.o0().getEnterChannelParamsForTRTCRoom().g(heartBeatRsp.getNoStreamDisconnectTrtcSecond());
            QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVHeartbeatRsp need restart timer");
            this.core.Q().g0(true);
        }
    }

    private final void C(IGuildSchemaConfig schemaConfig) {
        boolean z16;
        boolean startsWith$default;
        String schema = schemaConfig.getSchema();
        if (schema != null) {
            if (schema.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(schema, "mqqapi:", false, 2, null);
                if (startsWith$default) {
                    if (!((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(this.core.getQQAppInterface(), BaseApplication.context, schema)) {
                        QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "invokeInviteSchema jump failed: " + schema);
                        return;
                    }
                    return;
                }
            }
        }
        QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "invokeInviteSchema schema is null or invalid: " + schema);
    }

    private final boolean E(String guildId, String channelId) {
        if (this.core.isInChannel() && Intrinsics.areEqual(this.core.getGuildID(), guildId) && Intrinsics.areEqual(this.core.E(), channelId)) {
            return true;
        }
        return false;
    }

    private final boolean G(ArrayList<IGProUserInfo> userList) {
        if (userList == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : userList) {
            if (Intrinsics.areEqual(((IGProUserInfo) obj).getTinyId(), this.core.getSelfUserInfo().f228093a)) {
                arrayList.add(obj);
            }
        }
        if (!(!arrayList.isEmpty())) {
            return false;
        }
        return true;
    }

    private final boolean H() {
        IGProChannelInfo channelInfo = t().getChannelInfo(this.core.E());
        if (channelInfo == null || channelInfo.getType() != 8) {
            return false;
        }
        return true;
    }

    private final boolean I() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing() && !QBaseActivity.sTopActivity.isDestroyed()) {
            return false;
        }
        return true;
    }

    private final void J(String channelUin) {
        if (StringUtil.isEmpty(channelUin)) {
            return;
        }
        this.core.l0().o(t().getChannelInfo(channelUin));
    }

    private final void K(int type) {
        if (this.core.E().equals(this.core.E())) {
            boolean canTalkinChannel = ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).canTalkinChannel(this.core.getQQAppInterface(), this.core.getGuildID(), this.core.E());
            this.core.l0().n(canTalkinChannel, type);
            QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onChannelTalkPermissionUpdated canTalk " + canTalkinChannel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(InnerMediaGProObserverHelper this$0, IGuildSchemaConfig schemaConfig, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(schemaConfig, "$schemaConfig");
        Intrinsics.checkNotNullParameter(dialogInterface, "dialogInterface");
        this$0.C(schemaConfig);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(boolean hasTalkPermission) {
        boolean z16;
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
        boolean z17 = this.core.getSelfUserInfo().f228114v;
        boolean d06 = this.core.C().d0();
        if (!d06 && !z17) {
            z16 = false;
        } else {
            z16 = true;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "onSelfTalkPermissionUpdate: mute[" + d06 + "] ban[" + z17 + "]");
        com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(selfUserInfo.f228093a);
        if (g16 != null) {
            a0(g16, z16);
        }
        a0(selfUserInfo, z16);
        this.core.l0().m("onPushPermissionInGuild", selfUserInfo);
        if (!hasTalkPermission) {
            if (this.core.getSelfUserInfo().f228101i) {
                this.core.J().i(false, new d());
            }
            if (this.core.getSelfUserInfo().f228103k) {
                this.core.W().d(true);
            }
        }
    }

    private final void O() {
        if (com.tencent.mobileqq.guild.media.core.j.c().k().getSigValidSecond() > NetConnInfoCenter.getServerTime()) {
            com.tencent.mobileqq.guild.media.core.j.a().Q().L0(null);
        } else {
            com.tencent.mobileqq.guild.media.core.j.a().F(new e());
        }
    }

    private final void P(View view) {
        VideoReport.setPageId(view.getRootView().findViewById(R.id.b8q), "pg_sgrp_voicechannel_aio");
        VideoReport.setElementId(view, "em_sgrp_wzgameteam_invite_accept");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private final void Q(String tips) {
        QBaseActivity qBaseActivity;
        if (tips != null && (qBaseActivity = QBaseActivity.sTopActivity) != null && !qBaseActivity.isDestroyed()) {
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, tips, (String) null, HardCodeUtil.qqStr(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.x
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    InnerMediaGProObserverHelper.R(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null).show();
        }
    }

    private final void S(IGProAVUserStateChangeInfo userStateInfo) {
        boolean z16;
        boolean z17;
        if (TextUtils.isEmpty(userStateInfo.getMsg())) {
            return;
        }
        if (userStateInfo.getIGProAVShowMsgInfo() != null) {
            IGProAVShowMsgInfo iGProAVShowMsgInfo = userStateInfo.getIGProAVShowMsgInfo();
            if (iGProAVShowMsgInfo != null && iGProAVShowMsgInfo.getShowType() == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "[showMsg] isTipAlert: " + z16 + ", msg: " + userStateInfo.getMsg());
                if (!z16 && !I()) {
                    QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                    Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.content.Context");
                    DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, userStateInfo.getMsg(), "", BaseApplication.context.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.w
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            InnerMediaGProObserverHelper.T(dialogInterface, i3);
                        }
                    }, (DialogInterface.OnClickListener) null).show();
                    return;
                }
                QQToast.makeText(com.tencent.mobileqq.guild.util.ch.i(), userStateInfo.getMsg(), 0).show();
            }
        }
        z16 = false;
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "[showMsg] isTipAlert: " + z16 + ", msg: " + userStateInfo.getMsg());
        if (!z16) {
        }
        QQToast.makeText(com.tencent.mobileqq.guild.util.ch.i(), userStateInfo.getMsg(), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void U(ArrayList<IGProUserInfo> avUserInfoList) {
        ArrayList arrayList = new ArrayList();
        if (avUserInfoList != null) {
            for (IGProUserInfo iGProUserInfo : avUserInfoList) {
                com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(iGProUserInfo.getTinyId());
                if (g16 == null) {
                    com.tencent.mobileqq.guild.media.core.data.p j3 = com.tencent.mobileqq.guild.media.core.data.p.j();
                    j3.f(iGProUserInfo);
                    arrayList.add(j3);
                } else {
                    g16.f(iGProUserInfo);
                }
                if (Intrinsics.areEqual(iGProUserInfo.getTinyId(), this.core.getSelfUserInfo().f228093a)) {
                    this.core.getSelfUserInfo().f(iGProUserInfo);
                    this.core.w0().f(iGProUserInfo);
                }
            }
        }
        this.core.D0().c(arrayList);
    }

    private final void W(IGProAVUserStateChangeInfo userStateInfo) {
        Integer num;
        IGProAVDevOptInfo a16;
        int b16 = userStateInfo.getUserCtlInfo().b();
        if (b16 == 0 || b16 == 5) {
            com.tencent.mobileqq.guild.media.core.j.a().J().i(false, new g());
        }
        Integer valueOf = Integer.valueOf(b16);
        es userCtlInfo = userStateInfo.getUserCtlInfo();
        if (userCtlInfo != null && (a16 = userCtlInfo.a()) != null) {
            num = Integer.valueOf(a16.getScreenOpt());
        } else {
            num = null;
        }
        c0(valueOf, num);
    }

    private final void X(String from, IGProChannelUserNum channelUserNumInfo) {
        this.core.I0().Z(from, channelUserNumInfo);
    }

    private final void Y(IGProChannelUserNum channelUserNumInfo) {
        if (MediaChannelUtils.C(this.core.E()) && channelUserNumInfo != null) {
            List<com.tencent.mobileqq.guild.media.core.data.p> anchors = this.core.D0().f228125a;
            Intrinsics.checkNotNullExpressionValue(anchors, "anchors");
            List<com.tencent.mobileqq.guild.media.core.data.p> list = anchors;
            int i3 = 0;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    boolean z16 = true;
                    if (((com.tencent.mobileqq.guild.media.core.data.p) it.next()).f228099g != 1) {
                        z16 = false;
                    }
                    if (z16 && (i16 = i16 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
                i3 = i16;
            }
            channelUserNumInfo.setPlayersNum(i3);
            channelUserNumInfo.setViewersNum(channelUserNumInfo.getUserNum() - channelUserNumInfo.getPlayersNum());
        }
    }

    private final void a0(com.tencent.mobileqq.guild.media.core.data.p targetInfo, boolean isGlobalMute) {
        targetInfo.f228113u = isGlobalMute;
    }

    private final void b0(ArrayList<IGProUserInfo> userList) {
        String joinToString$default;
        UserAVInfo userAVInfo;
        com.tencent.mobileqq.guild.media.core.data.f fVar;
        UserBusinessInfo userBusinessInfo;
        UserBusinessInfo userBusinessInfo2;
        Logger.a d16 = Logger.f235387a.d();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(userList, null, null, null, 0, null, new Function1<IGProUserInfo, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$updateRaiseUpAVState$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull IGProUserInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return "id[" + it.getTinyId() + "]|state[" + it.getBusinessInfo().getUserAVInfo().getUserAVState() + "]";
            }
        }, 31, null);
        d16.d("QGMC.Core.MediaGProObserverHelper", 1, "updateAVState: " + joinToString$default);
        for (IGProUserInfo iGProUserInfo : userList) {
            com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(iGProUserInfo.getTinyId());
            UserAVInfo userAVInfo2 = null;
            if (g16 != null && (userBusinessInfo2 = g16.C) != null) {
                userAVInfo = userBusinessInfo2.getUserAVInfo();
            } else {
                userAVInfo = null;
            }
            if (userAVInfo != null) {
                userAVInfo.f(iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserAVState());
            }
            if (Intrinsics.areEqual(this.core.getSelfUserInfo().f228093a, iGProUserInfo.getTinyId())) {
                fVar = this.core.getSelfUserInfo();
            } else {
                fVar = null;
            }
            if (fVar != null && (userBusinessInfo = fVar.C) != null) {
                userAVInfo2 = userBusinessInfo.getUserAVInfo();
            }
            if (userAVInfo2 != null) {
                userAVInfo2.f(iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserAVState());
            }
        }
        if (!userList.isEmpty()) {
            this.core.l0().m("onUserRaiseUpHandStateUpdate", this.core.getSelfUserInfo());
        }
    }

    private final void c0(Integer avState, Integer devOpt) {
        boolean contains;
        boolean contains2;
        Integer[] numArr = {11, 13, 14};
        contains = ArraysKt___ArraysKt.contains(new Integer[]{5, 0, 4}, avState);
        if (contains) {
            contains2 = ArraysKt___ArraysKt.contains(numArr, devOpt);
            if (contains2) {
                com.tencent.mobileqq.guild.media.core.j.a().W().g();
            }
        }
    }

    private final void d0(com.tencent.mobileqq.guild.media.core.data.p targetInfo, boolean bAllow) {
        boolean z16 = false;
        if (bAllow) {
            targetInfo.f228114v = false;
            targetInfo.f228105m = 1;
        } else {
            targetInfo.f228114v = true;
            targetInfo.f228105m = 2;
        }
        if (TextUtils.equals(targetInfo.f228093a, this.core.getSelfUserInfo().f228093a)) {
            boolean d06 = this.core.C().d0();
            Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "onSelfTalkPermissionUpdate: mute[" + d06 + "] ban[" + targetInfo.f228114v + "]");
            if (targetInfo.f228114v || d06) {
                z16 = true;
            }
            targetInfo.f228113u = z16;
            return;
        }
        targetInfo.f228113u = targetInfo.f228114v;
    }

    private final void e0(com.tencent.mobileqq.guild.media.core.data.p userInfo, IGProUserInfo updateUserInfo) {
        boolean z16;
        UserAVInfo userAVInfo;
        IGProUserDevStateData userDevState = updateUserInfo.getBusinessInfo().getUserAVInfo().getUserDevState();
        long sortKey = updateUserInfo.getBusinessInfo().getSortKey();
        boolean z17 = true;
        Logger.f235387a.d().d("QGMC.Core.MediaGProObserverHelper", 1, "[onUserSpeakingNotifyForAll] updateDevState, mic[" + userDevState.getMicState() + "], phoneBusy[" + userDevState.getSysMicBusy() + "], screenShare[" + userDevState.getScreenState() + "], sortKey[" + sortKey + "]");
        if (userDevState.getMicState() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        userInfo.f228101i = z16;
        if (userDevState.getSysMicBusy() != 2) {
            z17 = false;
        }
        userInfo.B = z17;
        if (sortKey != 0) {
            userInfo.C.i(sortKey);
        }
        UserBusinessInfo userBusinessInfo = userInfo.C;
        if (userBusinessInfo != null) {
            userAVInfo = userBusinessInfo.getUserAVInfo();
        } else {
            userAVInfo = null;
        }
        if (userAVInfo != null) {
            userAVInfo.f(updateUserInfo.getBusinessInfo().getUserAVInfo().getUserAVState());
        }
    }

    private final void f0(ArrayList<IGProUserInfo> userList) {
        String str;
        if (userList == null) {
            return;
        }
        for (IGProUserInfo iGProUserInfo : userList) {
            com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
            if (selfUserInfo != null) {
                str = selfUserInfo.f228093a;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, iGProUserInfo.getTinyId())) {
                e0(this.core.getSelfUserInfo(), iGProUserInfo);
            }
            com.tencent.mobileqq.guild.media.core.data.p it = this.core.D0().g(iGProUserInfo.getTinyId());
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                e0(it, iGProUserInfo);
            }
        }
    }

    private final void n() {
        Integer num;
        IGProVoiceSpeakModeCfg voiceSpeakModeCfg;
        if (this.speakMode == null) {
            IGProChannelInfo channelInfo = this.core.getChannelInfo();
            if (channelInfo != null && (voiceSpeakModeCfg = channelInfo.getVoiceSpeakModeCfg()) != null) {
                num = Integer.valueOf(voiceSpeakModeCfg.getSpeakMode());
            } else {
                num = null;
            }
            this.speakMode = num;
            return;
        }
        int n3 = MediaChannelUtils.f228046a.n(com.tencent.mobileqq.guild.media.core.j.c().e());
        Integer num2 = this.speakMode;
        if (num2 == null || num2.intValue() != n3) {
            com.tencent.mobileqq.guild.media.core.notify.p eventBus = this.core.getEventBus();
            Integer num3 = this.speakMode;
            Intrinsics.checkNotNull(num3);
            eventBus.i(new com.tencent.mobileqq.guild.media.core.notify.z(num3.intValue(), n3));
            this.speakMode = Integer.valueOf(n3);
            o();
        }
    }

    private final void o() {
        int viewerNum = this.core.o0().getViewerNum();
        int totalNum = this.core.o0().getTotalNum() - viewerNum;
        List<com.tencent.mobileqq.guild.media.core.data.p> anchors = this.core.D0().f228125a;
        Integer num = this.speakMode;
        if (num != null && num.intValue() == 4) {
            Intrinsics.checkNotNullExpressionValue(anchors, "anchors");
            for (com.tencent.mobileqq.guild.media.core.data.p it : anchors) {
                MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (mediaChannelUtils.t(it) && it.f228099g == 2) {
                    it.f228099g = 1;
                    if (Intrinsics.areEqual(it.f228093a, this.core.getSelfUserInfo().f228093a)) {
                        this.core.getSelfUserInfo().f228099g = 1;
                        this.core.w0().f228099g = 1;
                    }
                    totalNum++;
                    viewerNum--;
                }
            }
        } else {
            Integer num2 = this.speakMode;
            if (num2 == null || num2.intValue() != 2) {
                Intrinsics.checkNotNullExpressionValue(anchors, "anchors");
                for (com.tencent.mobileqq.guild.media.core.data.p it5 : anchors) {
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    if (MediaChannelUtils.E(it5) && it5.f228099g == 1) {
                        it5.f228099g = 2;
                        if (Intrinsics.areEqual(it5.f228093a, this.core.getSelfUserInfo().f228093a)) {
                            this.core.getSelfUserInfo().f228099g = 2;
                            this.core.w0().f228099g = 2;
                        }
                        totalNum--;
                        viewerNum++;
                    }
                }
            }
        }
        int i3 = viewerNum;
        int i16 = totalNum;
        if (i3 != this.core.o0().getViewerNum()) {
            X("SpeakModeChanged", new MediaGProChannelUserNum(this.core.o0().getUserNumDataVersion(), this.core.o0().getTotalNum(), i16, i3, this.core.o0().getTotalShowNumThreshold()));
            this.core.l0().m("onAVUserInfoChangeNotifyForAll", this.core.getSelfUserInfo());
        }
    }

    private final void q(String guildId) {
        List<IGProChannelInfo> channelList = t().getChannelList(guildId);
        Intrinsics.checkNotNullExpressionValue(channelList, "igpsService.getChannelList(guildId)");
        IGProChannelInfo channelInfo = t().getChannelInfo(this.core.E());
        if (channelInfo != null) {
            List<IGProChannelInfo> list = channelList;
            boolean z16 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (Intrinsics.areEqual(((IGProChannelInfo) it.next()).getChannelUin(), channelInfo.getChannelUin())) {
                        z16 = false;
                        break;
                    }
                }
            }
            if (!z16) {
                return;
            }
        }
        String string = this.core.getAppContext().getResources().getString(R.string.f141890hw);
        Intrinsics.checkNotNullExpressionValue(string, "core.getAppContext().res\u2026ild_channel_right_change)");
        r(guildId, this.core.E(), string);
    }

    private final void r(String guildId, String channelId, String reason) {
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "exitRoomPreviewAndNotifyByChannel guild=" + guildId + ", channelId=" + channelId + ", reason=" + reason);
        if (this.core.isInChannel() && Intrinsics.areEqual(this.core.getGuildID(), guildId) && Intrinsics.areEqual(this.core.E(), channelId)) {
            this.core.D(reason, "exitRoomAndNotifyByChannel, " + reason);
        }
    }

    private final void s(String guildId, String reason) {
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "exitRoomAndPreviewByGuild guild=" + guildId + ", reason=" + reason);
        if (Intrinsics.areEqual(this.core.getGuildID(), guildId)) {
            this.core.D(reason, "exitRoomAndNotifyByGuild, " + reason);
        }
    }

    private final IGPSService t() {
        return (IGPSService) this.igpsService.getValue();
    }

    private final String v(int code, String msg2) {
        if (code != 10000) {
            String string = this.core.getAppContext().getResources().getString(R.string.f140100d2);
            Intrinsics.checkNotNullExpressionValue(string, "core.getAppContext().res\u2026y_admin\n                )");
            return string;
        }
        return msg2;
    }

    private final com.tencent.mobileqq.guild.media.core.logic.entertips.b<MediaUserEnterTipsModel> x() {
        return (com.tencent.mobileqq.guild.media.core.logic.entertips.b) this.userEnterTrigger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(IGProBusinessNode bizNode) {
        IGProVoiceSmobaGameRoomStateInfo roomStateInfo = bizNode.getRoomStateInfo();
        Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "handleGameInfoChange: roomId:" + roomStateInfo.getRoomId() + ", roomState:" + roomStateInfo.getRoomState());
        if (!this.core.o0().a()) {
            this.core.o0().j0(new GuildGameCreateBean(1, roomStateInfo, 0L, 0L, 0, null, 60, null));
        } else {
            this.core.o0().n().j(roomStateInfo);
        }
        com.tencent.mobileqq.guild.media.core.notify.p eventBus = this.core.getEventBus();
        Intrinsics.checkNotNullExpressionValue(roomStateInfo, "roomStateInfo");
        eventBus.i(new com.tencent.mobileqq.guild.media.core.notify.am(roomStateInfo));
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.x(roomStateInfo.getRoomState());
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        t().addObserver(this);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.bi.class, this.talkPermissionUpdateObserver);
        this.core.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.e.class, this.bizNodeUpdateObserver);
        this.speakMode = Integer.valueOf(MediaChannelUtils.f228046a.n(this.core.E()));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onAVUserInfoChangeNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> playerList, @Nullable ArrayList<IGProUserInfo> viewerList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String joinToString$default;
        if (!E(guildId, channelId)) {
            QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "[onAVUserInfoChangeNotifyForAll] not match!!! " + guildId + ", " + channelId + "; current room " + this.core.getGuildID() + ", " + this.core.E());
            return;
        }
        if (QLog.isColorLevel()) {
            String str5 = null;
            if (playerList != null) {
                str = ", ";
                str2 = "QGMC.Core.MediaGProObserverHelper";
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(playerList, null, null, null, 0, null, new Function1<IGProUserInfo, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onAVUserInfoChangeNotifyForAll$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull IGProUserInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return "id=" + it.getTinyId() + " + mic=" + it.getBusinessInfo().getUserAVInfo().getUserDevState().getMicState();
                    }
                }, 31, null);
                str3 = joinToString$default;
            } else {
                str = ", ";
                str2 = "QGMC.Core.MediaGProObserverHelper";
                str3 = null;
            }
            if (viewerList != null) {
                str4 = str3;
                str5 = CollectionsKt___CollectionsKt.joinToString$default(viewerList, null, null, null, 0, null, new Function1<IGProUserInfo, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onAVUserInfoChangeNotifyForAll$2
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull IGProUserInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return "it=" + it.getTinyId();
                    }
                }, 31, null);
            } else {
                str4 = str3;
            }
            QLog.w(str2, 1, "[onAVUserInfoChangeNotifyForAll] " + guildId + str + channelId + ", memberIdList=" + str4 + ",viewerIdList=" + str5);
        }
        U(playerList);
        U(viewerList);
        Y(channelUserNumInfo);
        X("onAVUserInfoChangeNotifyForAll", channelUserNumInfo);
        this.core.l0().m("onAVUserInfoChangeNotifyForAll", this.core.getSelfUserInfo());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onAddGuildWithInfo(@NotNull IGProGuildInfo info, int sourceType) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.core.isInChannel() && Intrinsics.areEqual(this.core.getGuildID(), info.getGuildID())) {
            Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "onAddGuildWithInfo, should re enter channel.");
            this.core.F(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(admint, "admint");
        if (this.core.getSelfUserInfo().f228093a.equals(admint)) {
            if ((bAdmin && this.core.getSelfUserInfo().f228097e == 0) || (!bAdmin && this.core.getSelfUserInfo().f228097e == 1)) {
                int i3 = this.core.getSelfUserInfo().f228097e;
                this.core.getSelfUserInfo().f228097e = bAdmin ? 1 : 0;
                if (QLog.isColorLevel()) {
                    QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onAdminChanged tinyId[" + admint + "], guildId[" + guildId + "], userType[" + i3 + " -> " + this.core.getSelfUserInfo().f228097e + "]");
                }
                this.core.l0().m("onAdminChanged", this.core.getSelfUserInfo());
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onAudioChannelUserPlatSwith(@NotNull String guildId, @NotNull String chnnUin, @NotNull String tinyId, int leavePlat, @NotNull String message) {
        boolean contains;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(chnnUin, "chnnUin");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(message, "message");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onAudioChannelUserPlatSwith guild:" + guildId + ", chnnUin:" + chnnUin + ", tinyId:" + tinyId + "leavePlat: " + leavePlat + ", msg: " + message);
        if (this.core.isInChannel() && this.core.getSelfUserInfo().f228093a.equals(tinyId)) {
            DeviceType a16 = PadUtil.a(BaseApplication.getContext());
            if ((leavePlat != 1 || (a16 != DeviceType.TABLET && a16 != DeviceType.FOLD)) && leavePlat != 3) {
                contains = ArraysKt___ArraysKt.contains(new Integer[]{Integer.valueOf(IUserPlatformType.PLATFORM_PC_WEB), Integer.valueOf(IUserPlatformType.PLATFORM_MOBILE_WEB), Integer.valueOf(IUserPlatformType.PLATFORM_PCQQ_WEB)}, Integer.valueOf(leavePlat));
                if (contains) {
                    return;
                }
                if (leavePlat == 2 && a16 == DeviceType.PHONE) {
                    return;
                }
                QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onAudioChannelUserPlatSwith exit room");
                com.tencent.mobileqq.guild.media.core.f fVar = this.core;
                fVar.D(fVar.getAppContext().getResources().getString(R.string.f140110d3), "onAudioChannelUserPlatSwitch.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onBeKickFromGuild(@NotNull String guildId, int black) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onBeKickFromGuild guild=" + guildId + ", black=" + black);
        String string = this.core.getQQAppInterface().getApplicationContext().getResources().getString(R.string.f140120d4);
        Intrinsics.checkNotNullExpressionValue(string, "core.getQQAppInterface()\u2026o_kickout_guild_by_admin)");
        s(guildId, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onChannelInfoUpdated(@NotNull String channelUin) {
        Intrinsics.checkNotNullParameter(channelUin, "channelUin");
        super.onChannelInfoUpdated(channelUin);
        if (this.core.getSelfUserInfo().Q.equals(channelUin)) {
            K(2);
            J(channelUin);
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onChannelListUpdated(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onChannelListUpdated guild=" + guildId);
        if (Intrinsics.areEqual(guildId, this.core.getSelfUserInfo().P)) {
            if (!this.core.isInChannel()) {
                QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "[onChannelListUpdated] local user is not in room. ignore notify-push");
                return;
            }
            IGProChannelInfo channelInfo = t().getChannelInfo(this.core.E());
            boolean z16 = false;
            if (channelInfo != null && channelInfo.getTalkPermission() == 2) {
                z16 = true;
            }
            if (z16) {
                K(1);
            }
            q(guildId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onChannelVisibleChanged(@NotNull String guildId, @NotNull String channelId, int oldVisibleType, int newVisibleType) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onChannelVisibleChanged guild=" + guildId);
        if (Intrinsics.areEqual(guildId, this.core.getSelfUserInfo().P)) {
            if (!this.core.isInChannel()) {
                QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "[onChannelVisibleChanged] local user is not in room. ignore notify-push");
            } else {
                q(guildId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onDeleteGuild(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onDeleteGuild guild=" + guildId);
        String string = this.core.getAppContext().getResources().getString(R.string.f141810ho);
        Intrinsics.checkNotNullExpressionValue(string, "core.getAppContext().res\u2026.guild_channel_not_exist)");
        s(guildId, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onDestoryGuild(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onDestoryGuild guild=" + guildId);
        String string = this.core.getAppContext().getResources().getString(R.string.f141810ho);
        Intrinsics.checkNotNullExpressionValue(string, "core.getAppContext().res\u2026.guild_channel_not_exist)");
        s(guildId, string);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onEnterSpeakQueueNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        String str;
        int collectionSizeOrDefault;
        if (!E(guildId, channelId)) {
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onEnterSpeakQueueNotifyForAll not match!!! guild=" + guildId + ", channelId=" + channelId + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
            return;
        }
        if (userList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(userList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = userList.iterator();
            while (it.hasNext()) {
                arrayList.add(((IGProUserInfo) it.next()).getTinyId());
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onEnterSpeakQueueNotifyForAll$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(String str2) {
                    return "tinyId=" + str2;
                }
            }, 31, null);
        } else {
            str = null;
        }
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "[onEnterSpeakQueueNotifyForAll] guild:" + guildId + ", channelId:" + channelId + ", id: " + str);
        f0(userList);
        IGProChannelInfo channelInfo = this.core.getChannelInfo();
        if (G(userList)) {
            this.core.l0().v(channelInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onPushAVForceKickOut(@Nullable String guildId, @Nullable String channelId, @Nullable String showTips) {
        if (!E(guildId, channelId)) {
            return;
        }
        Intrinsics.checkNotNull(guildId);
        GuildChannelSwitchManager.h(guildId, null, "onPushAVForceKickOut");
        this.core.D(showTips, "onPushAVForceKickOut.");
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onPushAVForceStopScreenShare(@Nullable String guildId, @Nullable String channelId, @Nullable String showTips) {
        boolean z16;
        if (!E(guildId, channelId)) {
            return;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVForceStopScreenShare, " + showTips);
        if (this.core.H0().C()) {
            this.core.W().d(true);
            Q(showTips);
        }
        ArrayList<GuildMediaUserBarNodePermission> S = this.core.o0().S();
        Iterator<GuildMediaUserBarNodePermission> it = S.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getNodeType() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            S.set(i3, new GuildMediaUserBarNodePermission(4, 1));
            Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVForceStopScreenShare, reset screen share permission.");
        }
        this.core.X().R(true);
        this.core.l0().c();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onPushAVHeartbeatRsp(int result, @Nullable String errMsg, @Nullable IGProHeartbeatRsq heartBeatRsp) {
        if (heartBeatRsp == null) {
            QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVHeartbeatRsp heartBeatRsp == null");
            return;
        }
        QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVHeartbeatRsp " + heartBeatRsp.getNoStreamDisconnectTrtcSecond());
        B(heartBeatRsp);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onPushAVUserStateChange(@Nullable IGProAVUserStateChangeInfo userStateInfo) {
        Integer num;
        IGProAVDevOptInfo a16;
        if (userStateInfo == null) {
            return;
        }
        if (!E(userStateInfo.getGuildId(), userStateInfo.getChannelId())) {
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVUserStateChange not match");
            return;
        }
        long tinyId = userStateInfo.getTinyId();
        int micOpt = userStateInfo.getUserCtlInfo().a().getMicOpt();
        es userCtlInfo = userStateInfo.getUserCtlInfo();
        if (userCtlInfo != null && (a16 = userCtlInfo.a()) != null) {
            num = Integer.valueOf(a16.getScreenOpt());
        } else {
            num = null;
        }
        QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onPushAVUserStateChange, tinyId: " + tinyId + ", mic: " + micOpt + ", share: " + num + ", avState: " + userStateInfo.getUserCtlInfo().b());
        if (Intrinsics.areEqual(String.valueOf(userStateInfo.getTinyId()), this.core.getSelfUserInfo().f228093a)) {
            W(userStateInfo);
            S(userStateInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onPushAllowScreenShareInGuild(@NotNull String guildId, @NotNull String tinyId, boolean bAllow, long source) {
        int i3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        int i16 = 1;
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onPushAllowScreenShareInGuild," + bAllow);
        com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(tinyId);
        if (g16 != null) {
            if (bAllow) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            g16.f228105m = i3;
        }
        if (Intrinsics.areEqual(tinyId, this.core.getSelfUserInfo().f228093a)) {
            com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
            if (!bAllow) {
                i16 = 2;
            }
            selfUserInfo.f228105m = i16;
        }
        this.core.l0().r("onPushAllowScreenShareInGuild", tinyId, bAllow);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onPushBussinessConfig(int bussinessId, @Nullable byte[] eventdata) {
        GuildChannelShare$ChannelShareGuidancePush mergeFrom = new GuildChannelShare$ChannelShareGuidancePush().mergeFrom(eventdata);
        boolean z16 = true;
        Logger.f235387a.d().i("QGMC.Core.MediaGProObserverHelper", 1, "onPushBussinessConfig " + bussinessId + " \nguildId: " + mergeFrom.guild_id.get() + " ; " + this.core.getGuildID() + " | channelId: " + mergeFrom.channel_id.get() + " ; " + this.core.E());
        if (bussinessId == 78 && E(String.valueOf(mergeFrom.guild_id.get()), String.valueOf(mergeFrom.channel_id.get()))) {
            IGProChannelInfo B = com.tencent.mobileqq.guild.util.ch.B(this.core.E());
            if (B == null || B.getVisibleType() != 1) {
                z16 = false;
            }
            if (z16) {
                this.core.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.aq());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onPushChannelDestroy(@NotNull String guildId, @NotNull List<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onPushChannelDestroy guild=" + guildId + ", channelIds=" + channelIds);
        String string = this.core.getAppContext().getResources().getString(R.string.f156611ko);
        Intrinsics.checkNotNullExpressionValue(string, "core.getAppContext().res\u2026_share_channel_not_found)");
        Iterator<String> it = channelIds.iterator();
        while (it.hasNext()) {
            r(guildId, it.next(), string);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onPushInviteMemberEvent(@NotNull String guildId, @NotNull String channelId, @NotNull String tinyId, @NotNull final IGuildSchemaConfig schemaConfig) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(schemaConfig, "schemaConfig");
        if (!E(guildId, channelId)) {
            return;
        }
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onPushInviteMemberEvent guildId=" + guildId + ", channelId=" + channelId + ", tinyId=" + tinyId + ", schema=(" + schemaConfig.getText() + "," + schemaConfig.getSchema() + ")");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(QBaseActivity.sTopActivity, 230);
        String string = QBaseActivity.sTopActivity.getBaseContext().getString(R.string.f140180d_);
        Intrinsics.checkNotNullExpressionValue(string, "sTopActivity.baseContext\u2026_invite_msg_receive_hint)");
        TextView btnight = createCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        P(btnight);
        createCustomDialog.setMessage(string).setPositiveButton(R.string.f143520ma, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                InnerMediaGProObserverHelper.L(InnerMediaGProObserverHelper.this, schemaConfig, dialogInterface, i3);
            }
        }).setNegativeButton(R.string.f140470e2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.core.logic.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                InnerMediaGProObserverHelper.M(dialogInterface, i3);
            }
        }).show();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onPushKickOutAudioChannel(@NotNull String guildId, @NotNull String chnnUin, @NotNull String operatorTinyId, @NotNull String tinyId, int code, @NotNull String msg2, int leavePlatform) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(chnnUin, "chnnUin");
        Intrinsics.checkNotNullParameter(operatorTinyId, "operatorTinyId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!E(guildId, chnnUin)) {
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onAudioChannelUserAdd not match!!! guild=" + guildId + ", channelId=" + chnnUin + ", id:=" + tinyId + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
            return;
        }
        QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onPushKickOutAudioChannel guild=" + guildId + ", channelId=" + chnnUin + ", id:=" + tinyId + ", operatorid:" + operatorTinyId + ", code:" + code + ", msg:" + msg2 + ", leavePlatform:" + leavePlatform);
        if (this.core.getSelfUserInfo().f228093a.equals(tinyId)) {
            if (leavePlatform == 0 || leavePlatform == 1) {
                String str = "";
                if (!si1.a.f433837a.a(guildId, "", 2)) {
                    str = v(code, msg2);
                }
                this.core.D(str, "onPushKickOutAudioChannel.");
                return;
            }
            return;
        }
        this.core.D0().l(tinyId);
        this.core.l0().m("onPushKickOutAudioChannel", this.core.getSelfUserInfo());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onPushPermissionInGuild(@NotNull String guildId, @NotNull String tinyId, boolean bAllow, long source) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        super.onPushPermissionInGuild(guildId, tinyId, bAllow, source);
        if (Intrinsics.areEqual(this.core.getGuildID(), guildId) && source != 1) {
            Logger.f235387a.d().d("QGMC.Core.MediaGProObserverHelper", 1, "onPushPermissionInGuild, guildId " + guildId + ", tinyId " + tinyId + ", bAllow " + bAllow + ", source " + source);
            com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(tinyId);
            if (g16 != null) {
                d0(g16, bAllow);
            }
            com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
            if (Intrinsics.areEqual(selfUserInfo.f228093a, tinyId)) {
                d0(selfUserInfo, bAllow);
            }
            this.core.l0().m("onPushPermissionInGuild", selfUserInfo);
            if (!bAllow && Intrinsics.areEqual(selfUserInfo.f228093a, tinyId)) {
                if (this.core.getSelfUserInfo().f228101i) {
                    this.core.J().i(false, new c());
                }
                if (this.core.getSelfUserInfo().f228103k) {
                    this.core.W().d(true);
                }
            }
            this.core.C().M0(guildId, tinyId, bAllow, source);
            this.core.T().A1(guildId, tinyId, bAllow, source);
            return;
        }
        QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onPushPermissionInGuild not match!!! guild=" + guildId + ", source:=" + source + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onPushUserGiftRankChangeNotify(@Nullable String guildId, @Nullable String channelId, @Nullable IGProUserGiftRankInfo eventdata) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        String str2;
        long j3;
        String str3;
        IGProRoleManagementTag roleManagementTag;
        String l3;
        if (eventdata == null) {
            return;
        }
        String guildID = this.core.getGuildID();
        String E = this.core.E();
        boolean z19 = false;
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && Intrinsics.areEqual(guildID, guildId)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (channelId != null && channelId.length() != 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (!z18 && Intrinsics.areEqual(E, channelId)) {
            z19 = true;
        }
        String str4 = null;
        if (z19 && z17) {
            IGProUser userInfo = eventdata.getUserInfo();
            if (userInfo == null || (l3 = Long.valueOf(userInfo.getTinyId()).toString()) == null) {
                str = "";
            } else {
                str = l3;
            }
            IGProUser userInfo2 = eventdata.getUserInfo();
            if (userInfo2 != null) {
                str4 = userInfo2.getNickName();
            }
            if (str4 == null) {
                str2 = "";
            } else {
                str2 = str4;
            }
            IGProUser userInfo3 = eventdata.getUserInfo();
            if (userInfo3 != null && (roleManagementTag = userInfo3.getRoleManagementTag()) != null) {
                j3 = roleManagementTag.getColor();
            } else {
                j3 = 0;
            }
            long j16 = j3;
            String rankInfo = eventdata.getRankInfo();
            if (rankInfo == null) {
                str3 = "";
            } else {
                str3 = rankInfo;
            }
            NotifyGiftRankChanged notifyGiftRankChanged = new NotifyGiftRankChanged(str, str2, j16, str3, eventdata.getTopNum());
            this.core.getEventBus().i(notifyGiftRankChanged);
            Logger.f235387a.d().d("QGMC.Core.MediaGProObserverHelper", 1, "[onPushUserGiftRankChangeNotify] " + notifyGiftRankChanged);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str5 = "[onPushUserGiftRankChangeNotify] guildId " + guildId + " channelId " + channelId + "\uff0ccurGuildID " + guildID + ", curChannelId " + E;
        if (str5 instanceof String) {
            bVar.a().add(str5);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.Core.MediaGProObserverHelper", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onRemoveGuild(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onRemoveGuild guild=" + guildId);
        String string = this.core.getAppContext().getResources().getString(R.string.f141450gp);
        Intrinsics.checkNotNullExpressionValue(string, "core.getAppContext().res\u2026d_channel_exited_channel)");
        s(guildId, string);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onRobotStateChangeNotifyForAll(@Nullable String guildId, @Nullable String channelId, @NotNull ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        Intrinsics.checkNotNullParameter(userList, "userList");
        for (IGProUserInfo iGProUserInfo : userList) {
            com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(iGProUserInfo.getTinyId());
            if (g16 != null) {
                g16.f(iGProUserInfo);
            }
        }
        this.core.l0().m("onRobotInfoChange", this.core.getSelfUserInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onUserAVStateResetNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        String str;
        int collectionSizeOrDefault;
        if (!E(guildId, channelId)) {
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onUserAVStateResetNotifyForAll not match!!! guild=" + guildId + ", channelId=" + channelId + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
            return;
        }
        if (userList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(userList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = userList.iterator();
            while (it.hasNext()) {
                arrayList.add(((IGProUserInfo) it.next()).getTinyId());
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onUserAVStateResetNotifyForAll$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(String str2) {
                    return "tinyId=" + str2;
                }
            }, 31, null);
        } else {
            str = null;
        }
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "[onUserAVStateResetNotifyForAll] guild:" + guildId + ", channelId:" + channelId + ", id: " + str);
        boolean G = G(userList);
        f0(userList);
        U(userList);
        Y(channelUserNumInfo);
        if (G) {
            this.core.l0().u(this.core.getChannelInfo());
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onUserEnterListNotifyForAll(@NotNull String guildId, @NotNull String channelId, @NotNull ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        String joinToString$default;
        String joinToString$default2;
        boolean z16;
        boolean z17;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z18;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(userList, "userList");
        if (!Intrinsics.areEqual(this.core.E(), channelId) || !Intrinsics.areEqual(this.core.getGuildID(), guildId) || userList.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(userList, null, null, null, 0, null, new Function1<IGProUserInfo, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onUserEnterListNotifyForAll$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull IGProUserInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return "id=" + it.getTinyId();
                }
            }, 31, null);
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onAudioChannelUserAdd not match!!! guild=" + guildId + ", channelId=" + channelId + ", list:=" + joinToString$default + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
            return;
        }
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(userList, null, null, null, 0, null, new Function1<IGProUserInfo, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onUserEnterListNotifyForAll$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull IGProUserInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return "id=" + it.getTinyId();
            }
        }, 31, null);
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onUserEnterListNotifyForAll guild=" + guildId + ", channelId=" + channelId + ", list:" + joinToString$default2 + ", tid:" + Thread.currentThread().getId());
        Iterator<IGProUserInfo> it = userList.iterator();
        while (it.hasNext()) {
            IGProUserInfo next = it.next();
            this.core.D0().b(next);
            if (this.core.getSelfUserInfo().f228093a.equals(next.getTinyId())) {
                this.core.getSelfUserInfo().f(next);
                com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(this.core.getSelfUserInfo().f228093a);
                if (g16 != null) {
                    g16.e(this.core.getSelfUserInfo());
                }
            }
            if (next.isVoiceless()) {
                this.core.y0().muteRemoteAudio(next.getTinyId(), true);
            }
            Set<Long> r16 = this.core.o0().r();
            String tinyId = next.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "info.tinyId");
            if (r16.contains(Long.valueOf(Long.parseLong(tinyId)))) {
                com.tencent.mobileqq.guild.media.core.data.p g17 = this.core.D0().g(next.getTinyId());
                if (g17 != null) {
                    g17.f228112t = true;
                }
                this.core.y0().muteRemoteAudio(next.getTinyId(), true);
            }
        }
        Y(channelUserNumInfo);
        X("onUserEnterListNotifyForAll", channelUserNumInfo);
        if (!userList.isEmpty()) {
            Iterator<T> it5 = userList.iterator();
            while (it5.hasNext()) {
                if (Intrinsics.areEqual(this.core.getSelfUserInfo().f228093a, ((IGProUserInfo) it5.next()).getTinyId())) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onAudioChannelUserSelfAdd");
            this.core.l0().m("onAudioChannelUserSelfAdd", this.core.getSelfUserInfo());
        }
        if (!userList.isEmpty()) {
            Iterator<T> it6 = userList.iterator();
            while (it6.hasNext()) {
                if (!Intrinsics.areEqual(this.core.getSelfUserInfo().f228093a, ((IGProUserInfo) it6.next()).getTinyId())) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (z17) {
            this.core.l0().m("onAudioChannelUserAdd", this.core.getSelfUserInfo());
        }
        AudioNotifyHelper l06 = this.core.l0();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(userList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it7 = userList.iterator();
        while (it7.hasNext()) {
            arrayList.add(((IGProUserInfo) it7.next()).getTinyId());
        }
        l06.i(arrayList, true);
        com.tencent.mobileqq.guild.media.core.logic.entertips.b<MediaUserEnterTipsModel> x16 = x();
        ArrayList<IGProUserInfo> arrayList2 = new ArrayList();
        for (Object obj : userList) {
            if (!Intrinsics.areEqual(this.core.getSelfUserInfo().f228093a, ((IGProUserInfo) obj).getTinyId())) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        for (IGProUserInfo iGProUserInfo : arrayList2) {
            String tinyId2 = iGProUserInfo.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId2, "it.tinyId");
            String d06 = com.tencent.mobileqq.guild.util.ch.d0(iGProUserInfo);
            Intrinsics.checkNotNullExpressionValue(d06, "getUserShowName(it)");
            boolean contains = iGProUserInfo.getMyRoles().contains(6);
            if (iGProUserInfo.getRobotType() == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            arrayList3.add(new MediaUserEnterTipsModel(tinyId2, d06, contains, z18));
        }
        x16.a(arrayList3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onUserLeaveListNotifyForAll(@NotNull String guildId, @NotNull String channelId, @NotNull ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        String joinToString$default;
        String joinToString$default2;
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(userList, "userList");
        if (!Intrinsics.areEqual(this.core.E(), channelId) || !Intrinsics.areEqual(this.core.getGuildID(), guildId) || userList.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(userList, null, null, null, 0, null, new Function1<IGProUserInfo, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onUserLeaveListNotifyForAll$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull IGProUserInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return "id=" + it.getTinyId();
                }
            }, 31, null);
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onUserLeaveListNotifyForAll not match!!! guild=" + guildId + ", channelId=" + channelId + ", list:=" + joinToString$default + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
            return;
        }
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(userList, null, null, null, 0, null, new Function1<IGProUserInfo, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onUserLeaveListNotifyForAll$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull IGProUserInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return "id=" + it.getTinyId();
            }
        }, 31, null);
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onUserLeaveListNotifyForAll guild=" + guildId + ", channelId=" + channelId + ", idList:=" + joinToString$default2);
        if (!userList.isEmpty()) {
            Iterator<T> it = userList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((IGProUserInfo) it.next()).getTinyId(), this.core.getSelfUserInfo().f228093a)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onUserLeaveListNotifyForAll contains self, ignore.");
            return;
        }
        Iterator<T> it5 = userList.iterator();
        while (it5.hasNext()) {
            this.core.D0().l(((IGProUserInfo) it5.next()).getTinyId());
        }
        Y(channelUserNumInfo);
        X("onUserLeaveListNotifyForAll", channelUserNumInfo);
        this.core.l0().m("onAudioChannelUserExit", this.core.getSelfUserInfo());
        AudioNotifyHelper l06 = this.core.l0();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(userList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it6 = userList.iterator();
        while (it6.hasNext()) {
            arrayList.add(((IGProUserInfo) it6.next()).getTinyId());
        }
        l06.i(arrayList, false);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onUserMuteSeatInGuild(@NotNull String guildId, @NotNull String tinyId, boolean bMute, long source) {
        com.tencent.mobileqq.guild.media.core.data.p g16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        QLog.d("QGMC.Core.MediaGProObserverHelper", 1, "onUserMuteSeatInGuild guild=" + guildId + ", id=" + tinyId + ", bMute=" + bMute + "source=" + source);
        if (!this.core.getGuildID().equals(guildId)) {
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onUserMuteSeatInGuild not match!!! guild=" + guildId + ", id:=" + tinyId + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
            return;
        }
        if (source != 1 && (g16 = this.core.D0().g(tinyId)) != null) {
            g16.f228113u = bMute;
            if (Intrinsics.areEqual(g16.f228093a, this.core.getSelfUserInfo().f228093a)) {
                this.core.getSelfUserInfo().f228113u = bMute;
                if (this.core.getSelfUserInfo().f228113u) {
                    this.core.J().g(false);
                }
                this.core.l0().n(!bMute, 0);
            }
            this.core.l0().m("onUserMuteSeatInGuild", this.core.getSelfUserInfo());
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onUserSpeakingNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        String str;
        int collectionSizeOrDefault;
        if (!E(guildId, channelId)) {
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onUserSpeakingNotifyForAll not match!!! guild=" + guildId + ", channelId=" + channelId + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
            return;
        }
        if (userList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(userList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = userList.iterator();
            while (it.hasNext()) {
                arrayList.add(((IGProUserInfo) it.next()).getTinyId());
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onUserSpeakingNotifyForAll$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(String str2) {
                    return "tinyId=" + str2;
                }
            }, 31, null);
        } else {
            str = null;
        }
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onUserSpeakingNotifyForAll guild:" + guildId + ", channelId:" + channelId + ", id: " + str);
        if (userList == null) {
            return;
        }
        com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
        Intrinsics.checkNotNull(channelId);
        if (!a16.i0(channelId)) {
            O();
        }
        f0(userList);
        if (!userList.isEmpty()) {
            this.core.l0().m("onUserRaiseUpHandStateUpdate", this.core.getSelfUserInfo());
        }
        IGProChannelInfo channelInfo = this.core.getChannelInfo();
        if (G(userList)) {
            this.core.l0().y(channelInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onUserWaitingToSpeakNotifyForAll(@Nullable String guildId, @Nullable String channelId, @Nullable ArrayList<IGProUserInfo> userList, @Nullable IGProChannelUserNum channelUserNumInfo) {
        String str;
        int collectionSizeOrDefault;
        if (!E(guildId, channelId)) {
            QLog.w("QGMC.Core.MediaGProObserverHelper", 1, "onUserWaitingToSpeakNotifyForAll not match!!! guild=" + guildId + ", channelId=" + channelId + "; in room guildId=" + this.core.getGuildID() + ", channelId=" + this.core.E());
            return;
        }
        if (userList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(userList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = userList.iterator();
            while (it.hasNext()) {
                arrayList.add(((IGProUserInfo) it.next()).getTinyId());
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.logic.InnerMediaGProObserverHelper$onUserWaitingToSpeakNotifyForAll$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(String str2) {
                    return "tinyId=" + str2;
                }
            }, 31, null);
        } else {
            str = null;
        }
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "onUserWaitingToSpeakNotifyForAll guild:" + guildId + ", channelId:" + channelId + ", id: " + str);
        if (userList == null) {
            return;
        }
        b0(userList);
        IGProChannelInfo channelInfo = this.core.getChannelInfo();
        if (G(userList)) {
            this.core.l0().A(channelInfo);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    protected void onVoiceHeartbeatTimeout(@NotNull String guildId, @NotNull String channelId) {
        int i3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "[onVoiceHeartbeatTimeout] guildId: " + guildId + ", channelId: " + channelId);
        if (!this.core.isInChannel()) {
            QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "[onVoiceHeartbeatTimeout] not in audio room");
            return;
        }
        if (Intrinsics.areEqual(guildId, this.core.getSelfUserInfo().P) && Intrinsics.areEqual(channelId, this.core.getSelfUserInfo().Q)) {
            if (this.core.isInChannel()) {
                this.core.J().g(false);
                if (this.core.H0().C()) {
                    this.core.W().g();
                }
                if (H()) {
                    i3 = R.string.f140050cx;
                } else {
                    i3 = R.string.f140060cy;
                }
                String string = BaseApplication.getContext().getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(resId)");
                this.core.D("", "onVoiceHeartbeatTimeout.");
                String btnContent = QQGuildUIUtil.r(R.string.f146610un);
                MediaChannelDialogFragment.Companion companion = MediaChannelDialogFragment.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(btnContent, "btnContent");
                companion.a(string, btnContent);
                return;
            }
            return;
        }
        QLog.i("QGMC.Core.MediaGProObserverHelper", 1, "[onVoiceHeartbeatTimeout] not current audio room channel\u3002 " + this.core + ".getSelfUserInfo()");
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
        t().deleteObserver(this);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.bi.class, this.talkPermissionUpdateObserver);
        this.core.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.e.class, this.bizNodeUpdateObserver);
        this.speakMode = null;
        x().release();
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(DialogInterface dialogInterface, int i3) {
    }
}
