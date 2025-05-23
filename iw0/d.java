package iw0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.app.event.AnchorAtEvent;
import com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.icgame.game.liveroom.impl.room.message.event.SysMsgEvent;
import com.tencent.icgame.game.liveroom.impl.room.profile.LivingOperateHelper;
import com.tencent.icgame.game.liveroom.impl.room.util.k;
import com.tencent.icgame.game.liveroom.impl.room.util.m;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUserMsg;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.IQQLiveFollowStateListener;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.icgame.data.user.UserCardInfo;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamHintMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;
import ru0.a;
import w42.FollowPushScreenMessage;
import w42.GiftScreenMsg;
import w42.j;
import z42.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0001?B\t\u00a2\u0006\u0006\b\u00b9\u0001\u0010\u00ba\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0016\u0010\u001e\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018J\u001e\u0010#\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\"\u001a\u00020!J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010%\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J,\u0010+\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0)H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u000eH\u0016J\n\u0010.\u001a\u0004\u0018\u00010-H\u0016JP\u0010:\u001a\u00020\u00032\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u000e2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000204032\u0006\u00107\u001a\u0002062\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020803H\u0016J>\u0010?\u001a\u00020\u00032\u0006\u00100\u001a\u00020;2\u0006\u0010<\u001a\u00020\f2\b\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010>\u001a\u00020\u000e2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0)H\u0016J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001bH\u0016J\u0018\u0010B\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010A\u001a\u00020!H\u0016J\u0012\u0010E\u001a\u00020\f2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016J\u0018\u0010H\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\f2\b\b\u0002\u0010G\u001a\u00020\fJ\b\u0010I\u001a\u00020\u000eH\u0016J\u0010\u0010L\u001a\u00020\u00032\u0006\u0010K\u001a\u00020JH\u0016J\u0010\u0010N\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020OH\u0016J\b\u0010Q\u001a\u00020\u0003H\u0016J\u0018\u0010S\u001a\u00020\u00032\u0006\u00100\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010T\u001a\u00020\u00032\u0006\u00100\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010X\u001a\u00020\u00032\u0006\u0010U\u001a\u00020!2\u0006\u0010W\u001a\u00020VH\u0016J,\u0010\\\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010Y\u001a\u0004\u0018\u00010\u000e2\u0006\u0010Z\u001a\u00020\u00182\u0006\u0010[\u001a\u00020\u0018H\u0016J\u0018\u0010_\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020]2\u0006\u00100\u001a\u00020^H\u0016J\u0010\u0010`\u001a\u00020\f2\u0006\u0010[\u001a\u00020\u0018H\u0016J\b\u0010a\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020\u0003H\u0016J\u0018\u0010d\u001a\u00020\u00032\u0006\u00100\u001a\u00020;2\u0006\u0010c\u001a\u00020\u000eH\u0016J\u0012\u0010e\u001a\u00020\u000e2\b\u0010c\u001a\u0004\u0018\u00010\u000eH\u0016JC\u0010l\u001a\u00020k2\u0006\u0010\u0006\u001a\u00020f2\u0006\u0010[\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182!\u0010j\u001a\u001d\u0012\u0013\u0012\u00110f\u00a2\u0006\f\bh\u0012\b\bi\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030gH\u0016J\u001a\u0010n\u001a\u00020\u00032\b\u0010m\u001a\u0004\u0018\u00010-2\u0006\u0010[\u001a\u00020\u0018H\u0016J\u001a\u0010o\u001a\u00020\u00032\b\u0010m\u001a\u0004\u0018\u00010-2\u0006\u0010[\u001a\u00020\u0018H\u0016J\b\u0010p\u001a\u00020\fH\u0016J\b\u0010q\u001a\u00020\u0003H\u0016R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b?\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010|\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R#\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bo\u0010\u0016\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R&\u0010\u0083\u0001\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\u001c\u0010\u0016\u001a\u0005\b\u0081\u0001\u0010~\"\u0006\b\u0082\u0001\u0010\u0080\u0001R\u001c\u0010\u0088\u0001\u001a\u00030\u0084\u00018\u0006\u00a2\u0006\u000f\n\u0005\bX\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R%\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\\\u0010\u000f\u001a\u0005\b\u0015\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R'\u0010\u008c\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bq\u0010\u000f\u001a\u0006\b\u008c\u0001\u0010\u0089\u0001\"\u0006\b\u008d\u0001\u0010\u008b\u0001R\u001f\u0010\u0092\u0001\u001a\u00030\u008e\u00018\u0016X\u0096\u0004\u00a2\u0006\u000f\n\u0005\bI\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001f\u0010\u0094\u0001\u001a\u00030\u008e\u00018\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\bL\u0010\u008f\u0001\u001a\u0006\b\u0093\u0001\u0010\u0091\u0001R\u001f\u0010\u0099\u0001\u001a\u00030\u0095\u00018\u0016X\u0096\u0004\u00a2\u0006\u000f\n\u0005\b`\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001f\u0010\u009e\u0001\u001a\u00030\u009a\u00018\u0016X\u0096\u0004\u00a2\u0006\u000f\n\u0005\bN\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001f\u0010\u00a3\u0001\u001a\u00030\u009f\u00018\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\bb\u0010\u00a0\u0001\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001f\u0010\u00a8\u0001\u001a\u00030\u00a4\u00018\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\bQ\u0010\u00a5\u0001\u001a\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u001f\u0010\u00ad\u0001\u001a\u00030\u00a9\u00018\u0016X\u0096\u0004\u00a2\u0006\u000f\n\u0005\b\u001e\u0010\u00aa\u0001\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001f\u0010\u00b2\u0001\u001a\u00030\u00ae\u00018\u0016X\u0096\u0004\u00a2\u0006\u000f\n\u0005\be\u0010\u00af\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001R&\u0010\u00b8\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b4\u00010\u00b3\u00018\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\bp\u0010\u00b5\u0001\u001a\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u00a8\u0006\u00bb\u0001"}, d2 = {"Liw0/d;", "Lz42/a;", "Lz42/c;", "", "e0", "Lw42/f;", "msg", "n0", "c0", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "broadCastFreeLove", "j0", "", "d0", "", "Z", ExifInterface.LATITUDE_SOUTH, "Lz42/b;", "anchorMessageLayout", "Landroid/content/Context;", "context", "isInAnchorState", "J", "w", "", "roomId", "", "", "d", "datas", DomainData.DOMAIN_NAME, "h0", "anchorUid", "", "roomType", "f0", "g0", "B", "click", "Ljava/lang/Object;", "arg", "", "businessParams", "reportEvent", "decodeQQEmotion", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "getSelfUserInfo", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView;", "view", "start", "text", "", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "atUserInfoMap", "Landroid/text/SpannableStringBuilder;", "spannable", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AtUser;", "uidAtInfoMap", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", ReportConstant.COSTREPORT_PREFIX, com.tencent.luggage.wxa.c8.c.G, HippyTKDListViewAdapter.X, "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AtUserMsg;", "atUserMsg", "b", "show", "isLandScape", "l0", tl.h.F, "Landroid/view/MotionEvent;", "event", "i", "listScrolling", "k", "Ly42/b;", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatBaseText;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i0", "id", "Lqh2/f;", "callback", "e", "nick", "speakId", "anchorId", "f", "Lw42/m;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTeamHintMsgItemView;", "y", "j", "r", "l", "announce", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lw42/c;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "function", "Landroid/text/style/ClickableSpan;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "liveUserInfo", "t", "c", "p", "g", "Landroid/content/Context;", "L", "()Landroid/content/Context;", "k0", "(Landroid/content/Context;)V", "Lz42/b;", "T", "()Lz42/b;", "setMainLayout", "(Lz42/b;)V", "mainLayout", "X", "()J", "setRoomId", "(J)V", "U", "setOwnerId", "ownerId", "Lzv0/a;", "Lzv0/a;", "M", "()Lzv0/a;", "fansGroupPushMgr", "()Z", "setInAnchorState", "(Z)V", "isFinishing", "setFinishing", "Ly22/a;", "Ly22/a;", "P", "()Ly22/a;", "iQQLiveReceiveMessageListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "iQQLiveSysMessageListener", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "getIQQLiveAnnouncePushListener", "()Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "iQQLiveAnnouncePushListener", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "O", "()Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "iQQLiveReceiveFollowListener", "Lcom/tencent/mobileqq/icgame/api/IQQLiveFollowStateListener;", "Lcom/tencent/mobileqq/icgame/api/IQQLiveFollowStateListener;", "N", "()Lcom/tencent/mobileqq/icgame/api/IQQLiveFollowStateListener;", "followStateListener", "Lji2/a;", "Lji2/a;", "Y", "()Lji2/a;", "roomLikeInfoListener", "La32/a;", "La32/a;", "W", "()La32/a;", "roomAudienceInfoListener", "Lv22/a;", "Lv22/a;", "V", "()Lv22/a;", "receiveGiftMessageListener", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "localMsgReceiver", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class d implements z42.a, z42.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private z42.b mainLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long ownerId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInAnchorState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isFinishing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final zv0.a fansGroupPushMgr = new zv0.a();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final y22.a iQQLiveReceiveMessageListener = new y22.a() { // from class: iw0.a
        @Override // y22.a
        public final void a(LiveMessageData liveMessageData) {
            d.a0(d.this, liveMessageData);
        }
    };

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final y22.a iQQLiveSysMessageListener = new y22.a() { // from class: iw0.b
        @Override // y22.a
        public final void a(LiveMessageData liveMessageData) {
            d.b0(d.this, liveMessageData);
        }
    };

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQLiveAnnouncePushListener iQQLiveAnnouncePushListener = new b();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQLiveReceiveFollowListener iQQLiveReceiveFollowListener = new c();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQLiveFollowStateListener followStateListener = new IQQLiveFollowStateListener() { // from class: iw0.c
        @Override // com.tencent.mobileqq.icgame.api.IQQLiveFollowStateListener
        public final void onFollowStateChange(long j3, long j16, int i3, String str) {
            d.K(d.this, j3, j16, i3, str);
        }
    };

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ji2.a roomLikeInfoListener = new i();

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a32.a roomAudienceInfoListener = new h();

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final v22.a receiveGiftMessageListener = new f();

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleEventReceiver<SimpleBaseEvent> localMsgReceiver = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"iw0/d$d", "Lu22/a;", "Lcom/tencent/mobileqq/icgame/data/user/UserCardInfo;", "liveUserInfo", "", "a", "", "errorCode", "", "errorMsg", "onFailed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: iw0.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C10552d extends u22.a {
        C10552d() {
        }

        @Override // u22.a
        public void a(@NotNull UserCardInfo liveUserInfo) {
            Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
            rt0.a.INSTANCE.k(d.this.S(), "insertEnterRoomMsgAfterAnnounceMsg", "syncUserCardInfo onSuccess, nick " + liveUserInfo.nick);
            d.this.c0();
        }

        @Override // u22.a, com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            rt0.a.INSTANCE.k(d.this.S(), "insertEnterRoomMsgAfterAnnounceMsg", "syncUserCardInfo fail, errorCode " + errorCode + ", errorMsg " + errorMsg);
            d.this.c0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004`\u0005H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"iw0/d$e", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "", "onReceiveEvent", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class e implements SimpleEventReceiver<SimpleBaseEvent> {
        e() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
            ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
            arrayList.add(SysMsgEvent.class);
            arrayList.add(LiveLocalMsg.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            boolean isBlank;
            boolean isBlank2;
            if (event instanceof LiveLocalMsg) {
                LiveLocalMsg liveLocalMsg = (LiveLocalMsg) event;
                if (liveLocalMsg.getRoomId() == d.this.getRoomId()) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(liveLocalMsg.getText());
                    if (!isBlank2) {
                        d.this.s(event);
                        return;
                    }
                    return;
                }
                return;
            }
            if (event instanceof SysMsgEvent) {
                SysMsgEvent sysMsgEvent = (SysMsgEvent) event;
                if (sysMsgEvent.getRoomId() == d.this.getRoomId()) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(sysMsgEvent.getSysNotice());
                    if (!isBlank) {
                        d.this.s(new j(sysMsgEvent.getSysNotice(), 0, sysMsgEvent.getTxtColor()));
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"iw0/d$f", "Lv22/a;", "Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "giftMessage", "", "a", "", "code", "", "msg", "onError", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class f implements v22.a {
        f() {
        }

        @Override // v22.a
        public void a(@NotNull GiftMessage giftMessage) {
            Intrinsics.checkNotNullParameter(giftMessage, "giftMessage");
            rt0.a.INSTANCE.k(d.this.S(), "Msg_Receive_" + d.this.getRoomId(), "onGiftMessageReceive onNewGift:" + giftMessage);
            if (giftMessage.comboOver || giftMessage.allComboCnt == 0) {
                d.this.s(new GiftScreenMsg(giftMessage));
            }
        }

        @Override // v22.a
        public void onError(int code, @Nullable String msg2) {
            rt0.a.INSTANCE.h(d.this.S(), "onNewGiftError", "code:" + code + ", msg:" + msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"iw0/d$g", "Ldu0/a;", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "atUserId", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class g implements du0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<Long, MessageOuterClass$AtUser> f408861a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChatTextMsgItemView f408862b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f408863c;

        g(Map<Long, MessageOuterClass$AtUser> map, ChatTextMsgItemView chatTextMsgItemView, d dVar) {
            this.f408861a = map;
            this.f408862b = chatTextMsgItemView;
            this.f408863c = dVar;
        }

        @Override // du0.a
        public void a(@Nullable CommonOuterClass$QQUserId atUserId) {
            PBUInt64Field pBUInt64Field;
            if (atUserId != null && (pBUInt64Field = atUserId.uid) != null) {
                long j3 = pBUInt64Field.get();
                Map<Long, MessageOuterClass$AtUser> map = this.f408861a;
                ChatTextMsgItemView chatTextMsgItemView = this.f408862b;
                d dVar = this.f408863c;
                MessageOuterClass$AtUser messageOuterClass$AtUser = map.get(Long.valueOf(j3));
                if (messageOuterClass$AtUser != null) {
                    LivingOperateHelper livingOperateHelper = LivingOperateHelper.f115476a;
                    Context L = dVar.L();
                    long roomId = dVar.getRoomId();
                    LiveUserInfo liveUserInfo = new LiveUserInfo();
                    liveUserInfo.nick = messageOuterClass$AtUser.nick_name.get();
                    liveUserInfo.uid = messageOuterClass$AtUser.user_id.uid.get();
                    liveUserInfo.headUrl = messageOuterClass$AtUser.head_url.get();
                    Unit unit = Unit.INSTANCE;
                    livingOperateHelper.n(chatTextMsgItemView, L, roomId, liveUserInfo, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(d this$0, long j3, long j16, int i3, String str) {
        Long K;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        fu0.e n3 = ((fu0.c) qx0.a.b(fu0.c.class)).n(this$0.roomId);
        if (n3 != null) {
            boolean z16 = true;
            if (m.b(this$0.roomId) != 2 || j16 != this$0.roomId ? n3.f400636a != j16 : (K = ((fu0.c) qx0.a.b(fu0.c.class)).K()) == null || j3 != K.longValue()) {
                z16 = false;
            }
            if (!z16) {
                n3 = null;
            }
            if (n3 != null) {
                this$0.e0();
            }
        }
    }

    private final String Z(w42.f msg2) {
        if (msg2 instanceof w42.h) {
            return k.f115699a.a(((w42.h) msg2).getLiveMessageData());
        }
        if (!(msg2 instanceof GiftScreenMsg)) {
            return "";
        }
        int c16 = k.f115699a.c(this.roomId, ((GiftScreenMsg) msg2).getGiftMessage().sender);
        boolean z16 = false;
        if (1 <= c16 && c16 < 4) {
            z16 = true;
        }
        if (!z16) {
            return "";
        }
        return String.valueOf(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(d this$0, LiveMessageData messageData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rt0.a.INSTANCE.g(this$0.S(), "Msg_Receive_" + this$0.roomId, messageData.mSpeakerInfo.mSpeakerName + ProgressTracer.SEPARATOR + messageData.msgContent);
        Intrinsics.checkNotNullExpressionValue(messageData, "messageData");
        this$0.s(new w42.h(messageData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(d this$0, LiveMessageData liveMessageData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(liveMessageData.msgContent.mMsgElements, "messageData.msgContent.mMsgElements");
        if (!r0.isEmpty()) {
            rt0.a.INSTANCE.g(this$0.S(), "Msg_Receive_" + this$0.roomId, "LiveSysMsg: " + liveMessageData.msgContent.mMsgElements.get(0).mTextMsg.strText);
            String str = liveMessageData.msgContent.mMsgElements.get(0).mTextMsg.strText;
            Intrinsics.checkNotNullExpressionValue(str, "messageData.msgContent.m\u2026ments[0].mTextMsg.strText");
            this$0.s(new j(str, 0, 0, 6, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        Long l3;
        LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
        a.Companion companion = rt0.a.INSTANCE;
        String S = S();
        String str = null;
        if (selfUserInfo != null) {
            l3 = Long.valueOf(selfUserInfo.uid);
        } else {
            l3 = null;
        }
        if (selfUserInfo != null) {
            str = selfUserInfo.nick;
        }
        companion.k(S, "insertSelfEnterRoomMsg", "insertSelfEnterRoomMsg,uid:" + l3 + ",name:" + str);
        if (selfUserInfo == null) {
            return;
        }
        LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
        speakerInfo.mSpeakId = selfUserInfo.uid;
        speakerInfo.mSpeakerName = selfUserInfo.nick;
        speakerInfo.mLogo = selfUserInfo.headUrl;
        s(new w42.b(speakerInfo));
    }

    private final boolean d0(w42.f msg2) {
        if ((msg2 instanceof w42.h) && k.f115699a.d(((w42.h) msg2).getLiveMessageData())) {
            return true;
        }
        if ((msg2 instanceof GiftScreenMsg) && k.f115699a.e(this.roomId, ((GiftScreenMsg) msg2).getGiftMessage().sender)) {
            return true;
        }
        return false;
    }

    private final void e0() {
        z42.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(QLBroadCastFreeLove broadCastFreeLove) {
        boolean z16;
        if (broadCastFreeLove != null && broadCastFreeLove.roomId == this.roomId) {
            String str = broadCastFreeLove.userNick;
            boolean z17 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str2 = broadCastFreeLove.roomMsg;
                if (str2 == null || str2.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    n0(new w42.g(broadCastFreeLove));
                    return;
                }
            }
            rt0.a.INSTANCE.k(S(), "sendLikeMsg", "onReceiveRoomLikePush with empty roomMsg roomMsg:" + broadCastFreeLove.roomMsg + " userNick:" + broadCastFreeLove.userNick);
        }
    }

    public static /* synthetic */ void m0(d dVar, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z17 = false;
            }
            dVar.l0(z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showVerDanmu");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(w42.f msg2) {
        z42.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.f(msg2);
        }
    }

    @Override // z42.c
    @NotNull
    public ClickableSpan A(@NotNull FollowPushScreenMessage msg2, long anchorId, long roomId, @NotNull Function1<? super FollowPushScreenMessage, Unit> function) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(function, "function");
        return new kx0.a(msg2, anchorId, roomId, function);
    }

    @Override // z42.a
    public void B(@NotNull List<Object> datas) {
        Unit unit;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (true) {
            unit = null;
            if (it.hasNext()) {
                obj = it.next();
                if ((obj instanceof j) && Intrinsics.areEqual(((j) obj).getSystemNotice(), h())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            IQQLiveSDK f16 = ((fu0.c) qx0.a.b(fu0.c.class)).f();
            if (f16 != null) {
                f16.getUserCardModule().syncUserCardInfo(new C10552d());
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                rt0.a.INSTANCE.k(S(), "insertEnterRoomMsgAfterAnnounceMsg", "syncUserCardInfo: empty liveSDK");
                c0();
            }
        }
    }

    @Override // z42.a
    public void C(@NotNull ChatTextMsgItemView view, int start, @NotNull String text, @NotNull Map<String, CommonOuterClass$QQUserId> atUserInfoMap, @NotNull SpannableStringBuilder spannable, @NotNull Map<Long, MessageOuterClass$AtUser> uidAtInfoMap) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(atUserInfoMap, "atUserInfoMap");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(uidAtInfoMap, "uidAtInfoMap");
        du0.e.f394864a.c(start, text, atUserInfoMap, spannable, c52.a.a(R.color.f158017al3), false, new g(uidAtInfoMap, view, this));
    }

    public void J(@NotNull z42.b anchorMessageLayout, @NotNull Context context, boolean isInAnchorState) {
        Intrinsics.checkNotNullParameter(anchorMessageLayout, "anchorMessageLayout");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainLayout = anchorMessageLayout;
        k0(context);
        this.isInAnchorState = isInAnchorState;
        anchorMessageLayout.setSupportFunc(this, this);
    }

    @NotNull
    public final Context L() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @NotNull
    /* renamed from: M, reason: from getter */
    public final zv0.a getFansGroupPushMgr() {
        return this.fansGroupPushMgr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: N, reason: from getter */
    public final IQQLiveFollowStateListener getFollowStateListener() {
        return this.followStateListener;
    }

    @NotNull
    /* renamed from: O, reason: from getter */
    public IQQLiveReceiveFollowListener getIQQLiveReceiveFollowListener() {
        return this.iQQLiveReceiveFollowListener;
    }

    @NotNull
    /* renamed from: P, reason: from getter */
    public y22.a getIQQLiveReceiveMessageListener() {
        return this.iQQLiveReceiveMessageListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: Q, reason: from getter */
    public final y22.a getIQQLiveSysMessageListener() {
        return this.iQQLiveSysMessageListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final SimpleEventReceiver<SimpleBaseEvent> R() {
        return this.localMsgReceiver;
    }

    @NotNull
    public String S() {
        throw null;
    }

    @Nullable
    /* renamed from: T, reason: from getter */
    public final z42.b getMainLayout() {
        return this.mainLayout;
    }

    /* renamed from: U, reason: from getter */
    public final long getOwnerId() {
        return this.ownerId;
    }

    @NotNull
    /* renamed from: V, reason: from getter */
    public v22.a getReceiveGiftMessageListener() {
        return this.receiveGiftMessageListener;
    }

    @NotNull
    /* renamed from: W, reason: from getter */
    public a32.a getRoomAudienceInfoListener() {
        return this.roomAudienceInfoListener;
    }

    /* renamed from: X, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: Y, reason: from getter */
    public final ji2.a getRoomLikeInfoListener() {
        return this.roomLikeInfoListener;
    }

    @Override // z42.a
    public void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ru0.a) qx0.a.b(ru0.a.class)).a(view, isAsync, identifier, elementID, businessParams);
    }

    @Override // z42.a
    public boolean b(@Nullable MessageOuterClass$AtUserMsg atUserMsg) {
        Long l3;
        du0.e eVar = du0.e.f394864a;
        LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
        if (selfUserInfo != null) {
            l3 = Long.valueOf(selfUserInfo.uid);
        } else {
            l3 = null;
        }
        return eVar.b(atUserMsg, l3);
    }

    @Override // z42.c
    public void c(@Nullable LiveUserInfo liveUserInfo, long anchorId) {
        String str;
        Context L;
        if (com.tencent.icgame.game.liveroom.impl.room.util.c.a()) {
            return;
        }
        boolean z16 = false;
        if (liveUserInfo != null && liveUserInfo.uid == 1289385052) {
            z16 = true;
        }
        if (z16) {
            rt0.a.INSTANCE.j(S(), "system msg,ignore click event");
            return;
        }
        a.Companion companion = rt0.a.INSTANCE;
        String S = S();
        if (liveUserInfo != null) {
            str = liveUserInfo.nick;
        } else {
            str = null;
        }
        companion.j(S, "nickName onClick userName = " + str);
        if (liveUserInfo != null && (L = L()) != null) {
            LivingOperateHelper.f115476a.n(null, L, this.roomId, liveUserInfo, 1);
        }
    }

    @Override // z42.a
    @Nullable
    public List<Object> d(long roomId) {
        return ((fu0.c) qx0.a.b(fu0.c.class)).d(roomId);
    }

    @Override // z42.a
    @Nullable
    public String decodeQQEmotion(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return eu0.a.a(msg2);
    }

    @Override // z42.c
    public void e(int id5, @NotNull qh2.f callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId()).b().e(id5, callback);
    }

    public final void f0(long roomId, long anchorUid, int roomType) {
        this.ownerId = anchorUid;
        this.roomId = roomId;
        z42.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.b(roomId, anchorUid, roomType);
        }
    }

    public final void g0(long roomId) {
        z42.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.onExitRoom(roomId);
        }
    }

    @Override // z42.a
    @Nullable
    public LiveUserInfo getSelfUserInfo() {
        return ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
    }

    @Override // z42.c
    @NotNull
    public String h() {
        return mv0.a.f417650a.a();
    }

    public final void h0(long roomId) {
        z42.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.e(roomId);
        }
    }

    @Override // z42.c
    public void i(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.icgame.game.liveroom.impl.room.like.f.f115408a.j();
    }

    public void i0(@NotNull ChatBaseText view, @NotNull w42.f msg2) {
        List<? extends CharSequence> listOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!d0(msg2)) {
            return;
        }
        CharSequence text = view.getText();
        String Z = Z(msg2);
        a.Companion companion = rt0.a.INSTANCE;
        companion.k(S(), "renderTopThreeCrown", "currentText=" + ((Object) text));
        if (TextUtils.isEmpty(Z)) {
            companion.h(S(), "renderTopThreeCrown", "renderTopThreeCrown value=" + Z);
            return;
        }
        SpannableString spannableString = new SpannableString(" ");
        k kVar = k.f115699a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Drawable b16 = kVar.b(context, Z);
        if (b16 == null) {
            companion.h(S(), "renderTopThreeCrown", "renderTopThreeCrown drawable=null");
            return;
        }
        Bitmap a16 = com.tencent.mobileqq.qqlive.widget.util.b.f274062a.a(b16, wi2.c.b(28), wi2.c.b(16));
        if (a16 == null) {
            companion.h(S(), "renderTopThreeCrown", "renderTopThreeCrown bitmap=null");
            return;
        }
        spannableString.setSpan(new y42.a(a16, 0, wi2.c.b(4)), 0, 1, 33);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{spannableString, text});
        view.setSpanText(listOf);
    }

    @Override // z42.c
    public boolean j(long anchorId) {
        return TGLiveFollowManager.f115307a.j(anchorId);
    }

    @Override // z42.c
    public void k(boolean listScrolling) {
        com.tencent.icgame.game.liveroom.impl.room.like.f.f115408a.g(listScrolling);
    }

    public final void k0(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void l0(boolean show, boolean isLandScape) {
        rt0.a.INSTANCE.k(S(), "showVerDanmu", this.roomId + " isLandScape:" + isLandScape + ",show:" + show);
        if (isLandScape) {
            z42.b bVar = this.mainLayout;
            if (bVar != null) {
                bVar.setVisibility(8);
                return;
            }
            return;
        }
        z42.b bVar2 = this.mainLayout;
        if (bVar2 != null) {
            bVar2.a(show);
        }
        z42.b bVar3 = this.mainLayout;
        if (bVar3 != null) {
            bVar3.setVisibility(0);
        }
    }

    @Override // z42.c
    public void m() {
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
        if (!sDKImpl.isInited()) {
            rt0.a.INSTANCE.h(S(), "initGiftSDK", "QQGiftSDKConfig init call");
            sDKImpl.c(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.qqgift.sdk.config.a.a().d(QQLiveSDKConfigHelper.getSceneId()).b());
        }
    }

    @Override // z42.a
    public void n(@NotNull List<Object> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        rt0.a.INSTANCE.j(S(), "saveMessageDatas, isInAnchorState " + this.isInAnchorState + ", isFinishing " + this.isFinishing);
        if (this.isInAnchorState && this.isFinishing) {
            return;
        }
        fu0.c cVar = (fu0.c) qx0.a.b(fu0.c.class);
        long j3 = this.roomId;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(datas);
        Unit unit = Unit.INSTANCE;
        cVar.F(j3, arrayList);
    }

    @Override // z42.c
    @NotNull
    public String o(@Nullable String announce) {
        return com.tencent.icgame.game.liveroom.impl.room.notice.a.INSTANCE.a().c(announce);
    }

    @Override // z42.c
    public boolean p() {
        return false;
    }

    @Override // z42.c
    public void q(@NotNull View view, @NotNull String announce) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(announce, "announce");
        if (com.tencent.icgame.game.utils.a.c(view) != null) {
            if (com.tencent.icgame.game.liveroom.impl.room.notice.a.INSTANCE.a().b(announce) != 2) {
                com.tencent.icgame.game.liveroom.impl.room.notice.b.q0(L(), this.roomId);
            } else {
                com.tencent.icgame.game.ui.widget.f.b("\u516c\u544a\u6b63\u5728\u5ba1\u6838\uff0c\u8bf7\u7a0d\u540e\u8bbe\u7f6e");
            }
        }
    }

    @Override // z42.c
    public boolean r() {
        return false;
    }

    @Override // z42.a
    public void reportEvent(@NotNull String click, @NotNull Object arg, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(arg, "arg");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("clck", arg, businessParams);
    }

    @Override // z42.a
    public void s(@NotNull Object msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        z42.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.d(msg2);
        }
    }

    @Override // z42.c
    public void t(@Nullable LiveUserInfo liveUserInfo, long anchorId) {
        boolean z16;
        String str;
        boolean z17 = true;
        if (liveUserInfo != null && liveUserInfo.uid == 1289385052) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            rt0.a.INSTANCE.j(S(), "system msg\uff0cignore long click event");
            return;
        }
        a.Companion companion = rt0.a.INSTANCE;
        String S = S();
        if (liveUserInfo != null) {
            str = liveUserInfo.nick;
        } else {
            str = null;
        }
        companion.j(S, "nickName onLoneClick userName = " + str);
        if (liveUserInfo != null) {
            LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
            if (selfUserInfo == null || liveUserInfo.uid != selfUserInfo.uid) {
                z17 = false;
            }
            if (!z17) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                long j3 = this.roomId;
                LiveUserInfo liveUserInfo2 = new LiveUserInfo();
                liveUserInfo2.nick = liveUserInfo.nick;
                liveUserInfo2.showNick = liveUserInfo.nick;
                liveUserInfo2.uid = liveUserInfo.uid;
                liveUserInfo2.headUrl = liveUserInfo.headUrl;
                liveUserInfo2.sex = liveUserInfo.sex;
                Unit unit = Unit.INSTANCE;
                simpleEventBus.dispatchEvent(new AnchorAtEvent(j3, liveUserInfo2, null, false, 12, null));
            }
        }
    }

    @Override // z42.a
    public boolean u(@Nullable ViewParent viewParent) {
        return a.C11651a.b(this, viewParent);
    }

    @Override // z42.c
    @NotNull
    public y42.b v() {
        return new jw0.a();
    }

    @Override // z42.a
    public void x(@NotNull w42.f msg2, int pos) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        z42.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.g(pos);
        }
    }

    @Override // z42.c
    public void y(@NotNull w42.m msg2, @NotNull ChatTeamHintMsgItemView view) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(view, "view");
        mm4.a b16 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11162a.b((ru0.a) b16, view, false, String.valueOf(msg2.getTimestamp()), "em_icgame_play_news", new LinkedHashMap(), 2, null);
    }

    @Override // z42.c
    public void z(@NotNull ChatBaseText view, @NotNull w42.f msg2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        view.setTextColor(c52.a.a(R.color.f158017al3));
        i0(view, msg2);
    }

    @Override // z42.c
    public void g() {
    }

    @Override // z42.c
    public void l() {
    }

    @Override // z42.c
    public void w() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"iw0/d$h", "La32/a;", "Lcom/tencent/mobileqq/qqlive/data/room/RoomAudienceInfo;", "info", "", "onRecAudienceInfo", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData$SpeakerInfo;", "audienceInfo", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class h implements a32.a {
        h() {
        }

        @Override // a32.a
        public void a(@NotNull LiveMessageData.SpeakerInfo audienceInfo) {
            boolean z16;
            Intrinsics.checkNotNullParameter(audienceInfo, "audienceInfo");
            fu0.e n3 = ((fu0.c) qx0.a.b(fu0.c.class)).n(d.this.getRoomId());
            boolean z17 = true;
            if (n3 != null && audienceInfo.mSpeakId == n3.f400636a) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
            if (selfUserInfo == null || audienceInfo.mSpeakId != selfUserInfo.uid) {
                z17 = false;
            }
            if (z17) {
                return;
            }
            rt0.a.INSTANCE.g(d.this.S(), "Msg_Receive_" + d.this.getRoomId(), "onAudienceEnterRoom " + audienceInfo.mSpeakerName);
            d.this.n0(new w42.b(audienceInfo));
        }

        @Override // a32.a
        public void onRecAudienceInfo(@Nullable RoomAudienceInfo info) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"iw0/d$b", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "announcePushMessage", "", "onAnnounceReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements IQQLiveAnnouncePushListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener
        public void onAnnounceReceive(@NotNull AnnouncePushMessage announcePushMessage) {
            Intrinsics.checkNotNullParameter(announcePushMessage, "announcePushMessage");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"iw0/d$c", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveReceiveFollowListener;", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "followPushMessage", "", "onFollowReceive", "", "errCode", "", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements IQQLiveReceiveFollowListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFollowReceive(@NotNull FollowPushMessage followPushMessage) {
            Intrinsics.checkNotNullParameter(followPushMessage, "followPushMessage");
            rt0.a.INSTANCE.g(d.this.S(), "Msg_Receive_" + d.this.getRoomId(), "onFollowReceive " + followPushMessage.nick);
            if (followPushMessage.type == 1 && followPushMessage.toUid == d.this.getOwnerId()) {
                d.this.s(new FollowPushScreenMessage(followPushMessage));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J=\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"iw0/d$i", "Lji2/a;", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "broadCastFreeLove", "", "onReceiveRoomLikePush", "", "uid", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/heart/FreeLove;", "Lkotlin/collections/ArrayList;", "freeLoves", "", "fromBroadCast", "onReceiveFreeLove", "(JLjava/util/ArrayList;Ljava/lang/Boolean;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class i implements ji2.a {
        i() {
        }

        @Override // ji2.a
        public void onReceiveRoomLikePush(@Nullable QLBroadCastFreeLove broadCastFreeLove) {
            d.this.j0(broadCastFreeLove);
        }

        @Override // ji2.a
        public void onReceiveFreeLove(long uid, @Nullable ArrayList<FreeLove> freeLoves, @Nullable Boolean fromBroadCast) {
        }
    }

    @Override // z42.c
    @Nullable
    public String f(long roomId, @Nullable String nick, long speakId, long anchorId) {
        return nick;
    }
}
