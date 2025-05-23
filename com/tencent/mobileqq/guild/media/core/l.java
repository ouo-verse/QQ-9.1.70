package com.tencent.mobileqq.guild.media.core;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import at1.GuildGameCreateBean;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.data.GuildMediaMemberShowRule;
import com.tencent.mobileqq.guild.media.core.data.GuildMediaUserBarNodePermission;
import com.tencent.mobileqq.guild.media.core.data.MediaRoomStatus;
import com.tencent.mobileqq.guild.media.core.data.MediaShareLoadInfo;
import com.tencent.mobileqq.guild.util.cm;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelToolBar;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSongInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0006\b\u00c6\u0001\u0010\u00c7\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010'\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b&\u0010$R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u000205048\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020;048\u0006\u00a2\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u00109R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020?048\u0006\u00a2\u0006\f\n\u0004\b@\u00107\u001a\u0004\bA\u00109R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020C048\u0006\u00a2\u0006\f\n\u0004\bD\u00107\u001a\u0004\bE\u00109R-\u0010L\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020H0Gj\b\u0012\u0004\u0012\u00020H`I048\u0006\u00a2\u0006\f\n\u0004\bJ\u00107\u001a\u0004\bK\u00109R\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020M048\u0006\u00a2\u0006\f\n\u0004\bN\u00107\u001a\u0004\bO\u00109R'\u0010V\u001a\u0012\u0012\u0004\u0012\u00020Q0Gj\b\u0012\u0004\u0012\u00020Q`I8\u0006\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0017\u0010\\\u001a\u00020W8\u0006\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0017\u0010_\u001a\u00020W8\u0006\u00a2\u0006\f\n\u0004\b]\u0010Y\u001a\u0004\b^\u0010[R\u001a\u0010b\u001a\u00020M8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b`\u0010R\u001a\u0004\bN\u0010aR\u0017\u0010d\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\b1\u0010R\u001a\u0004\bc\u0010aR\u0017\u0010g\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\be\u0010R\u001a\u0004\bf\u0010aR\u001d\u0010i\u001a\b\u0012\u0004\u0012\u00020\t048\u0006\u00a2\u0006\f\n\u0004\bK\u00107\u001a\u0004\bh\u00109R\u001d\u0010k\u001a\b\u0012\u0004\u0012\u00020\t048\u0006\u00a2\u0006\f\n\u0004\bA\u00107\u001a\u0004\bj\u00109R\u001d\u0010r\u001a\b\u0012\u0004\u0012\u00020m0l8\u0006\u00a2\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020\t048\u0006\u00a2\u0006\f\n\u0004\bE\u00107\u001a\u0004\bJ\u00109R\u001d\u0010u\u001a\b\u0012\u0004\u0012\u00020t048\u0006\u00a2\u0006\f\n\u0004\bO\u00107\u001a\u0004\b6\u00109R\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020\t048\u0006\u00a2\u0006\f\n\u0004\bv\u00107\u001a\u0004\b@\u00109R\u0018\u0010z\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0017\u0010\u007f\u001a\u00020{8\u0006\u00a2\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b/\u0010~R)\u0010\u0085\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030\u0081\u00010\u0080\u00018\u0006\u00a2\u0006\u000f\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0005\b]\u0010\u0084\u0001R#\u0010\u008b\u0001\u001a\n\u0012\u0005\u0012\u00030\u0087\u00010\u0086\u00018\u0006\u00a2\u0006\u000f\n\u0005\b&\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R$\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u00030\u0087\u00010\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u0088\u0001\u001a\u0006\b\u008d\u0001\u0010\u008a\u0001R$\u0010\u0091\u0001\u001a\n\u0012\u0005\u0012\u00030\u0087\u00010\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0088\u0001\u001a\u0006\b\u0090\u0001\u0010\u008a\u0001R0\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u0093\u00010\u0092\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u000e\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R#\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u0088\u0001\u001a\u0006\b\u009b\u0001\u0010\u008a\u0001R#\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0086\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009d\u0001\u0010\u0088\u0001\u001a\u0006\b\u009d\u0001\u0010\u008a\u0001R1\u0010\u00a3\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030\u0081\u00010\u00a0\u00010\u009f\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u00a1\u0001\u001a\u0006\b\u008f\u0001\u0010\u00a2\u0001R\u0014\u0010\u00a6\u0001\u001a\u00020\u000b8F\u00a2\u0006\b\u001a\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u0013\u0010\u00a7\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b\u001b\u0010\u00a5\u0001R\u0012\u0010\u00a8\u0001\u001a\u00020M8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010aR\u0014\u0010\u00aa\u0001\u001a\u00020\u000b8F\u00a2\u0006\b\u001a\u0006\b\u00a9\u0001\u0010\u00a5\u0001R\u0014\u0010\u00ac\u0001\u001a\u00020\u000b8F\u00a2\u0006\b\u001a\u0006\b\u00ab\u0001\u0010\u00a5\u0001R\u0013\u0010\u00ad\u0001\u001a\u00020\u000b8F\u00a2\u0006\u0007\u001a\u0005\b`\u0010\u00a5\u0001R\u0014\u0010\u00b0\u0001\u001a\u00020C8F\u00a2\u0006\b\u001a\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u0013\u0010\u00b2\u0001\u001a\u00020\t8F\u00a2\u0006\u0007\u001a\u0005\be\u0010\u00b1\u0001R\u0012\u0010\u00b3\u0001\u001a\u00020M8F\u00a2\u0006\u0006\u001a\u0004\b|\u0010aR\u0013\u0010\u00b4\u0001\u001a\u00020M8F\u00a2\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010aR\u0013\u0010\u00b5\u0001\u001a\u00020M8F\u00a2\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010aR\u0016\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b6\u00018F\u00a2\u0006\u0007\u001a\u0005\bR\u0010\u00b7\u0001R\u0017\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00b9\u00018F\u00a2\u0006\b\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u0012\u0010\u00bd\u0001\u001a\u00020M8F\u00a2\u0006\u0006\u001a\u0004\bX\u0010aR\u0013\u0010\u00be\u0001\u001a\u00020C8F\u00a2\u0006\u0007\u001a\u0005\bn\u0010\u00af\u0001R\u0016\u0010\u00c1\u0001\u001a\u0005\u0018\u00010\u00bf\u00018F\u00a2\u0006\u0007\u001a\u0005\bv\u0010\u00c0\u0001R\u0015\u0010\u00c5\u0001\u001a\u00030\u00c2\u00018F\u00a2\u0006\b\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001\u00a8\u0006\u00c8\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/l;", "Lcom/tencent/mobileqq/guild/media/core/g;", "", "E0", "p", "h0", "u", "Lat1/a;", DomainData.DOMAIN_NAME, "", "o", "", "tinyId", "Lcom/tencent/mobileqq/guild/data/u;", "b0", "B", tl.h.F, "F0", "Landroid/os/Bundle;", "extra", "H0", "t", "Lcom/tencent/mobileqq/guild/media/core/n;", "d", "Lcom/tencent/mobileqq/guild/media/core/n;", "modelData", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "getSelfUserInfo", "()Lcom/tencent/mobileqq/guild/media/core/data/f;", "selfUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "f", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "D0", "()Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "Y", "totalUserInfoList", "Lcom/tencent/mobileqq/guild/media/core/data/l;", "i", "Lcom/tencent/mobileqq/guild/media/core/data/l;", "getTRTCUserInfoList", "()Lcom/tencent/mobileqq/guild/media/core/data/l;", "tRTCUserInfoList", "Lcom/tencent/mobileqq/guild/media/core/data/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/data/a;", "M", "()Lcom/tencent/mobileqq/guild/media/core/data/a;", "screenShareAnchorInfo", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceInfo;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "getScreenShareInfo", "()Landroidx/lifecycle/LiveData;", "screenShareInfo", "Lcom/tencent/mobileqq/guild/media/core/EnterChannelState;", "D", "l", "enterChannelState", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildThemeInfo;", "E", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "themeInfo", "", UserInfo.SEX_FEMALE, ExifInterface.LATITUDE_SOUTH, "themeSponsor", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessNode;", "Lkotlin/collections/ArrayList;", "G", "P", "themeBizNodeList", "", "H", "T", "themeType", "Lcom/tencent/mobileqq/guild/media/core/data/d;", "I", "Ljava/util/ArrayList;", "getUserBarNodePermission", "()Ljava/util/ArrayList;", "userBarNodePermission", "Lcom/tencent/mobileqq/guild/media/core/data/c;", "J", "Lcom/tencent/mobileqq/guild/media/core/data/c;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/guild/media/core/data/c;", "maxPlayerShowRule", "K", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "maxViewerShowRule", "L", "()I", "noAnimUserCountLimit", "v", "maxPlayerCacheNum", "N", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "maxViewerCacheNum", "g", "disableVoiceAnimation", "i0", "isMicCaptureInactive", "", "Lcom/tencent/mobileqq/guild/media/core/data/g;", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/List;", "getTrtcRoomList", "()Ljava/util/List;", "trtcRoomList", "needShowNavTips", "Lcom/tencent/mobileqq/guild/media/core/data/MediaShareLoadInfo;", "mediaShareLoadInfo", "U", "needShowInviteOpenMicMsg", "V", "Landroid/os/Bundle;", "enterChannelExtraData", "Lct1/a;", "W", "Lct1/a;", "()Lct1/a;", "freeGiftInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "X", "Ljava/util/concurrent/ConcurrentHashMap;", "()Ljava/util/concurrent/ConcurrentHashMap;", "presentGiftMap", "Lcom/tencent/mobileqq/guild/util/cn;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "Lcom/tencent/mobileqq/guild/util/cn;", "f0", "()Lcom/tencent/mobileqq/guild/util/cn;", "isFirstReceiveFreeGift", "Z", "e0", "isFirstReceiveChargeGift", "a0", "l0", "isTodayFirstReceiveFreeGift", "Lcom/tencent/mobileqq/guild/util/cm;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "Lcom/tencent/mobileqq/guild/util/cm;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/util/cm;", "setGiftAnimData", "(Lcom/tencent/mobileqq/guild/util/cm;)V", "giftAnimData", "c0", "j0", "isTodayFirstGetFreeGift", "d0", "isFirstGetUpperLimitFreeGift", "Landroidx/lifecycle/MutableLiveData;", "", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "trtcVolumeInfoLiveData", "r", "()Ljava/lang/String;", "guildId", "channelId", "channelType", ReportConstant.COSTREPORT_PREFIX, "key", "b", "authMeta", "roomSessionId", "a", "()J", "aioShowMsgSeq", "()Z", "selfHasOpenMic", "totalNum", "totalShowNumThreshold", "viewerNum", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPlayInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPlayInfo;", "playInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSongInfo;", "O", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSongInfo;", "songInfo", "playNum", "themePanelLaunchTime", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannelToolBar;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannelToolBar;", "toolBarConfig", "Lcom/tencent/mobileqq/guild/media/core/logic/j;", "k", "()Lcom/tencent/mobileqq/guild/media/core/logic/j;", "enterChannelParamsForTRTCRoom", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/n;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l implements g {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<IGProVoiceInfo> screenShareInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<EnterChannelState> enterChannelState;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<IGProGuildThemeInfo> themeInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> themeSponsor;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ArrayList<IGProBusinessNode>> themeBizNodeList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> themeType;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<GuildMediaUserBarNodePermission> userBarNodePermission;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final GuildMediaMemberShowRule maxPlayerShowRule;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final GuildMediaMemberShowRule maxViewerShowRule;

    /* renamed from: L, reason: from kotlin metadata */
    private final int noAnimUserCountLimit;

    /* renamed from: M, reason: from kotlin metadata */
    private final int maxPlayerCacheNum;

    /* renamed from: N, reason: from kotlin metadata */
    private final int maxViewerCacheNum;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> disableVoiceAnimation;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isMicCaptureInactive;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final List<MediaRoomStatus> trtcRoomList;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> needShowNavTips;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MediaShareLoadInfo> mediaShareLoadInfo;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> needShowInviteOpenMicMsg;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private Bundle enterChannelExtraData;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final ct1.a freeGiftInfo;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, com.tencent.mobileqq.guild.media.core.data.p> presentGiftMap;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final cn<IGProSendGiftEventData> isFirstReceiveFreeGift;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final cn<IGProSendGiftEventData> isFirstReceiveChargeGift;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<IGProSendGiftEventData> isTodayFirstReceiveFreeGift;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private cm<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> giftAnimData;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<Boolean> isTodayFirstGetFreeGift;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n modelData;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<Boolean> isFirstGetUpperLimitFreeGift;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.f selfUserInfo;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Map<String, com.tencent.mobileqq.guild.media.core.data.p>> trtcVolumeInfoLiveData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.r userInfoList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.r totalUserInfoList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.l tRTCUserInfoList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.a screenShareAnchorInfo;

    public l(@NotNull n modelData) {
        Intrinsics.checkNotNullParameter(modelData, "modelData");
        this.modelData = modelData;
        this.selfUserInfo = modelData.getSelfUserInfo();
        this.userInfoList = modelData.getUserInfoList();
        this.totalUserInfoList = modelData.getTotalUserInfoList();
        this.tRTCUserInfoList = modelData.getTRTCUserInfoList();
        this.screenShareAnchorInfo = modelData.getScreenShareAnchorInfo();
        this.screenShareInfo = modelData.C();
        this.enterChannelState = modelData.k();
        this.themeInfo = modelData.J();
        this.themeSponsor = modelData.L();
        this.themeBizNodeList = modelData.I();
        this.themeType = modelData.M();
        this.userBarNodePermission = modelData.S();
        GuildMediaMemberShowRule guildMediaMemberShowRule = new GuildMediaMemberShowRule(50, 3);
        this.maxPlayerShowRule = guildMediaMemberShowRule;
        GuildMediaMemberShowRule guildMediaMemberShowRule2 = new GuildMediaMemberShowRule(49, 3);
        this.maxViewerShowRule = guildMediaMemberShowRule2;
        this.noAnimUserCountLimit = 20;
        this.maxPlayerCacheNum = guildMediaMemberShowRule.getMaxDetailShowNum() + guildMediaMemberShowRule.getMaxThumbnailShowNum() + 10;
        this.maxViewerCacheNum = guildMediaMemberShowRule2.getMaxDetailShowNum() + guildMediaMemberShowRule2.getMaxThumbnailShowNum() + 10;
        this.disableVoiceAnimation = modelData.g();
        this.isMicCaptureInactive = modelData.a0();
        List<MediaRoomStatus> R = modelData.R();
        Intrinsics.checkNotNullExpressionValue(R, "modelData.trtcRoomList");
        this.trtcRoomList = R;
        this.needShowNavTips = modelData.t();
        this.mediaShareLoadInfo = modelData.q();
        this.needShowInviteOpenMicMsg = modelData.s();
        this.freeGiftInfo = modelData.getFreeGiftInfo();
        this.presentGiftMap = modelData.z();
        this.isFirstReceiveFreeGift = modelData.Y();
        this.isFirstReceiveChargeGift = modelData.X();
        this.isTodayFirstReceiveFreeGift = modelData.c0();
        this.giftAnimData = modelData.o();
        this.isTodayFirstGetFreeGift = modelData.b0();
        this.isFirstGetUpperLimitFreeGift = modelData.W();
        this.trtcVolumeInfoLiveData = new MutableLiveData<>(new HashMap());
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final GuildMediaMemberShowRule getMaxViewerShowRule() {
        return this.maxViewerShowRule;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.data.u B() {
        com.tencent.mobileqq.guild.data.u uVar = new com.tencent.mobileqq.guild.data.u();
        com.tencent.mobileqq.guild.media.core.data.f fVar = this.selfUserInfo;
        uVar.f216477a = fVar.f228093a;
        uVar.f216478b = fVar.f228097e;
        uVar.f216481e = fVar.f228105m;
        uVar.f216480d = fVar.f228113u;
        uVar.f216479c = fVar.f228112t;
        return uVar;
    }

    @NotNull
    public final LiveData<MediaShareLoadInfo> C() {
        return this.mediaShareLoadInfo;
    }

    @NotNull
    /* renamed from: D0, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.data.r getUserInfoList() {
        return this.userInfoList;
    }

    @NotNull
    public final LiveData<Boolean> E() {
        return this.needShowInviteOpenMicMsg;
    }

    public final boolean F0() {
        return Intrinsics.areEqual(h(), e());
    }

    @NotNull
    public final LiveData<Boolean> G() {
        return this.needShowNavTips;
    }

    /* renamed from: H, reason: from getter */
    public final int getNoAnimUserCountLimit() {
        return this.noAnimUserCountLimit;
    }

    public final void H0(@Nullable Bundle extra) {
        this.enterChannelExtraData = extra;
    }

    @Nullable
    public final IGProPlayInfo I() {
        return this.modelData.getPlayInfo();
    }

    public final int J() {
        return this.modelData.getPlayNum();
    }

    @NotNull
    public final ConcurrentHashMap<String, com.tencent.mobileqq.guild.media.core.data.p> K() {
        return this.presentGiftMap;
    }

    @NotNull
    public final String L() {
        return this.modelData.getRoomSessionId();
    }

    @NotNull
    /* renamed from: M, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.data.a getScreenShareAnchorInfo() {
        return this.screenShareAnchorInfo;
    }

    public final boolean N() {
        return this.modelData.getSelfHasOpenMic();
    }

    @Nullable
    public final IGProSongInfo O() {
        return this.modelData.getSongInfo();
    }

    @NotNull
    public final LiveData<ArrayList<IGProBusinessNode>> P() {
        return this.themeBizNodeList;
    }

    @NotNull
    public final LiveData<IGProGuildThemeInfo> Q() {
        return this.themeInfo;
    }

    public final long R() {
        return this.modelData.getThemePanelLaunchTime();
    }

    @NotNull
    public final LiveData<Long> S() {
        return this.themeSponsor;
    }

    @NotNull
    public final LiveData<Integer> T() {
        return this.themeType;
    }

    @Nullable
    public final IGProChannelToolBar U() {
        return this.modelData.getToolBarConfig();
    }

    public final int W() {
        return this.modelData.getTotalNum();
    }

    public final int X() {
        return this.modelData.getTotalShowNumThreshold();
    }

    @NotNull
    /* renamed from: Y, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.data.r getTotalUserInfoList() {
        return this.totalUserInfoList;
    }

    public final long a() {
        return this.modelData.getAioShowMsgSeq();
    }

    @NotNull
    public final MutableLiveData<Map<String, com.tencent.mobileqq.guild.media.core.data.p>> a0() {
        return this.trtcVolumeInfoLiveData;
    }

    @NotNull
    public final String b() {
        return this.modelData.getAuthMeta();
    }

    @Nullable
    public final com.tencent.mobileqq.guild.data.u b0(@NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        com.tencent.mobileqq.guild.media.core.data.p g16 = this.userInfoList.g(tinyId);
        if (g16 == null) {
            return null;
        }
        com.tencent.mobileqq.guild.data.u uVar = new com.tencent.mobileqq.guild.data.u();
        uVar.f216477a = g16.f228093a;
        uVar.f216478b = g16.f228097e;
        uVar.f216481e = g16.f228105m;
        uVar.f216480d = g16.f228113u;
        uVar.f216479c = g16.f228112t;
        return uVar;
    }

    public final int c0() {
        return this.modelData.getViewerNum();
    }

    @NotNull
    public final cn<Boolean> d0() {
        return this.isFirstGetUpperLimitFreeGift;
    }

    @NotNull
    public final String e() {
        return this.modelData.getStartParams().getChannelId();
    }

    @NotNull
    public final cn<IGProSendGiftEventData> e0() {
        return this.isFirstReceiveChargeGift;
    }

    public final int f() {
        return this.modelData.getStartParams().getChannelType();
    }

    @NotNull
    public final cn<IGProSendGiftEventData> f0() {
        return this.isFirstReceiveFreeGift;
    }

    @NotNull
    public final LiveData<Boolean> g() {
        return this.disableVoiceAnimation;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.media.core.data.f getSelfUserInfo() {
        return this.selfUserInfo;
    }

    @NotNull
    public final String h() {
        Object obj;
        String e16;
        boolean z16;
        Iterator<T> it = this.trtcRoomList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MediaRoomStatus) obj).getEnableTRTCPublish()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MediaRoomStatus mediaRoomStatus = (MediaRoomStatus) obj;
        if (mediaRoomStatus == null || (e16 = mediaRoomStatus.getRoomStrId()) == null) {
            e16 = e();
        }
        if (e16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return e();
        }
        return e16;
    }

    @NotNull
    public final LiveData<Boolean> i0() {
        return this.isMicCaptureInactive;
    }

    @NotNull
    public final cn<Boolean> j0() {
        return this.isTodayFirstGetFreeGift;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.media.core.logic.j k() {
        return this.modelData.getEnterChannelParamsForTRTCRoom();
    }

    @NotNull
    public final LiveData<EnterChannelState> l() {
        return this.enterChannelState;
    }

    @NotNull
    public final cn<IGProSendGiftEventData> l0() {
        return this.isTodayFirstReceiveFreeGift;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final ct1.a getFreeGiftInfo() {
        return this.freeGiftInfo;
    }

    @NotNull
    public final GuildGameCreateBean n() {
        return this.modelData.n();
    }

    public final boolean o() {
        return this.modelData.a();
    }

    @NotNull
    public final cm<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> q() {
        return this.giftAnimData;
    }

    @NotNull
    public final String r() {
        return this.modelData.getStartParams().getGuildId();
    }

    @NotNull
    public final String s() {
        return this.modelData.getStartParams().getKey();
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final Bundle getEnterChannelExtraData() {
        return this.enterChannelExtraData;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
        this.enterChannelExtraData = null;
    }

    /* renamed from: v, reason: from getter */
    public final int getMaxPlayerCacheNum() {
        return this.maxPlayerCacheNum;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final GuildMediaMemberShowRule getMaxPlayerShowRule() {
        return this.maxPlayerShowRule;
    }

    /* renamed from: z, reason: from getter */
    public final int getMaxViewerCacheNum() {
        return this.maxViewerCacheNum;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
    }
}
