package com.tencent.mobileqq.qqlive.room.message;

import android.content.Context;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.room.message.QQLiveGiftMessageLayoutManager;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamHintMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.mobileqq.qqlive.widget.chat.message.i;
import com.tencent.mobileqq.qqlive.widget.chat.message.j;
import com.tencent.mobileqq.qqlive.widget.chat.message.l;
import com.tencent.mobileqq.qqlive.widget.chat.message.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.app.event.AnchorAtEvent;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.historychatmsg.d;
import com.tencent.timi.game.liveroom.impl.room.like.LikeTouchManager;
import com.tencent.timi.game.liveroom.impl.room.medal.QQLiveMedalServiceSupplier;
import com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c;
import com.tencent.timi.game.liveroom.impl.room.medal.d;
import com.tencent.timi.game.liveroom.impl.room.medal.e;
import com.tencent.timi.game.liveroom.impl.room.message.event.SysMsgEvent;
import com.tencent.timi.game.liveroom.impl.util.QQLiveActionSheetHelper;
import com.tencent.timi.game.sso.request.QQLiveGetAnnounceRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kk4.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import ug4.a;
import vi2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0006*\u0004\u00b5\u0001\u00b8\u0001\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\t\u00a2\u0006\u0006\b\u00bb\u0001\u0010\u00bc\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0016J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0016\u0010#\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u0006\u0010$\u001a\u00020\u0006J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010\u0010J&\u0010*\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010,\u001a\u00020\u0019H\u0016J,\u00102\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00102\u0006\u0010/\u001a\u00020.2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001000H\u0016J\u0012\u00103\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u0010H\u0016J\b\u00104\u001a\u00020\u001dH\u0016JP\u0010@\u001a\u00020\u00062\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00102\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020:092\u0006\u0010=\u001a\u00020<2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020>09H\u0016J>\u0010E\u001a\u00020\u00062\u0006\u00106\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00192\b\u0010C\u001a\u0004\u0018\u00010\u00102\u0006\u0010D\u001a\u00020\u00102\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001000H\u0016J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010G\u001a\u00020\u0019H\u0016J\u0010\u0010H\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010I\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020\u0006H\u0016J\u0010\u0010K\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020 H\u0016J\u0012\u0010N\u001a\u00020\u00192\b\u0010M\u001a\u0004\u0018\u00010LH\u0016J\u0018\u0010Q\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00192\b\b\u0002\u0010P\u001a\u00020\u0019J\b\u0010R\u001a\u00020\u0010H\u0016J\u0010\u0010U\u001a\u00020\u00062\u0006\u0010T\u001a\u00020SH\u0016J\u0010\u0010W\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0019H\u0016J\b\u0010Y\u001a\u00020XH\u0016J\b\u0010Z\u001a\u00020\u0006H\u0016J\u0018\u0010]\u001a\u00020\u00062\u0006\u00106\u001a\u00020[2\u0006\u0010\u0005\u001a\u00020\\H\u0016J\u0010\u0010`\u001a\u00020\u00192\b\u0010_\u001a\u0004\u0018\u00010^J\u0018\u0010a\u001a\u00020\u00062\u0006\u00106\u001a\u00020[2\u0006\u0010\u0005\u001a\u00020\\H\u0016J\u0018\u0010e\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020cH\u0016J,\u0010i\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010f\u001a\u0004\u0018\u00010\u00102\u0006\u0010g\u001a\u00020\u001d2\u0006\u0010h\u001a\u00020\u001dH\u0016J\u0018\u0010l\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020j2\u0006\u00106\u001a\u00020kH\u0016J\u0010\u0010m\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010n\u001a\u00020\u00192\u0006\u0010h\u001a\u00020\u001dH\u0016J\b\u0010o\u001a\u00020\u0019H\u0016J\b\u0010p\u001a\u00020\u0006H\u0016J\u0018\u0010q\u001a\u00020\u00062\u0006\u00106\u001a\u00020A2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010r\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016JC\u0010y\u001a\u00020x2\u0006\u0010\u0005\u001a\u00020s2\u0006\u0010h\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2!\u0010w\u001a\u001d\u0012\u0013\u0012\u00110s\u00a2\u0006\f\bu\u0012\b\bv\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060tH\u0016J\u001a\u0010|\u001a\u00020\u00062\b\u0010{\u001a\u0004\u0018\u00010z2\u0006\u0010h\u001a\u00020\u001dH\u0016J$\u0010~\u001a\u00020\u00062\b\u0010{\u001a\u0004\u0018\u00010z2\u0006\u0010h\u001a\u00020\u001d2\b\u0010}\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0081\u0001\u001a\u0004\u0018\u00010x2\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\u0006\u0010h\u001a\u00020\u001dH\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u0083\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0006H\u0016R'\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\b!\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R*\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\be\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R'\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bi\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R&\u0010(\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bR\u0010l\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R(\u0010\u009b\u0001\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bU\u0010\u0090\u0001\u001a\u0006\b\u0099\u0001\u0010\u0092\u0001\"\u0006\b\u009a\u0001\u0010\u0094\u0001R\u001c\u0010\u00a0\u0001\u001a\u00030\u009c\u00018\u0006\u00a2\u0006\u000f\n\u0005\bZ\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0017\u0010\u00a3\u0001\u001a\u00030\u00a1\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b@\u0010\u00a2\u0001R\u0018\u0010\u00a7\u0001\u001a\u00030\u00a4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R%\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b~\u0010*\u001a\u0005\b\u001a\u0010\u00a8\u0001\"\u0006\b\u00a9\u0001\u0010\u00aa\u0001R(\u0010\u00ac\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00ab\u0001\u0010*\u001a\u0006\b\u00ac\u0001\u0010\u00a8\u0001\"\u0006\b\u00ad\u0001\u0010\u00aa\u0001R'\u0010\u00b4\u0001\u001a\n\u0012\u0005\u0012\u00030\u00af\u00010\u00ae\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00b2\u0001\u0010\u00b3\u0001R\u0018\u0010\u00b7\u0001\u001a\u00030\u00b5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u00b6\u0001R\u0017\u0010\u00ba\u0001\u001a\u00030\u00b8\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bl\u0010\u00b9\u0001\u00a8\u0006\u00bd\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager;", "Lvi2/a;", "Lvi2/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "msg", "", "V", "T", "Lfp4/c;", "msgInfo", "", "cmd", "d0", "Lmt3/e;", "X", "", "announce", "state", "g0", "P", "Lvi2/b;", "anchorMessageLayout", "Landroid/content/Context;", "context", "", "isInAnchorState", "K", "w", "", "roomId", "", "", "d", "datas", DomainData.DOMAIN_NAME, "f0", "platform", "c0", "anchorUid", "roomType", "fromFloatWindow", "Z", "a0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "click", "Ljava/lang/Object;", "arg", "", "businessParams", "reportEvent", "decodeQQEmotion", "c", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView;", "view", "start", "text", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "atUserInfoMap", "Landroid/text/SpannableStringBuilder;", "spannable", "Ltrpc/yes/common/MessageOuterClass$AtUser;", "uidAtInfoMap", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", BdhLogUtil.LogTag.Tag_Req, "b", "onPush", "register", "unregister", ReportConstant.COSTREPORT_PREFIX, "Ltrpc/yes/common/MessageOuterClass$AtUserMsg;", "atUserMsg", "N", "show", "isLandScape", "j0", h.F, "Landroid/view/MotionEvent;", "event", "i", "listScrolling", "k", "Lcom/tencent/mobileqq/qqlive/widget/chat/span/b;", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatBaseText;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "M", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "medalInfo", "W", "e0", "id", "Lqh2/f;", "callback", "e", "nick", "speakId", "anchorId", "f", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/l;", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTeamHintMsgItemView;", "I", "B", "j", "r", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/c;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "function", "Landroid/text/style/ClickableSpan;", "y", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "liveUserInfo", "t", RemoteMessageConst.MessageBody.MSG_CONTENT, "E", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/o;", "message", "H", "L", "p", "g", "Landroid/content/Context;", "O", "()Landroid/content/Context;", "h0", "(Landroid/content/Context;)V", "Lvi2/b;", "getMainLayout", "()Lvi2/b;", "setMainLayout", "(Lvi2/b;)V", "mainLayout", "J", ExifInterface.LATITUDE_SOUTH, "()J", "setRoomId", "(J)V", "getRoomType", "()I", "setRoomType", "(I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "setOwnerId", "ownerId", "Lcom/tencent/timi/game/liveroom/impl/room/medal/h;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/h;", "getMedalSupplierMgr", "()Lcom/tencent/timi/game/liveroom/impl/room/medal/h;", "medalSupplierMgr", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/d;", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/d;", "historyGiftMsgMgr", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g;", "D", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g;", "normalFloatingBannerQueueManager", "()Z", "setInAnchorState", "(Z)V", UserInfo.SEX_FEMALE, "isFinishing", "i0", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "G", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "getLocalMsgReceiver", "()Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "localMsgReceiver", "com/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$b", "Lcom/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$b;", "historyGiftMsgSendCallback", "com/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$d", "Lcom/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$d;", "receiveGiftMessageListener", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveGiftMessageLayoutManager implements vi2.a, vi2.c, g {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.liveroom.impl.room.historychatmsg.d historyGiftMsgMgr;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.liveroom.impl.room.message.stack.g normalFloatingBannerQueueManager;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isInAnchorState;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFinishing;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SimpleEventReceiver<SimpleBaseEvent> localMsgReceiver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b historyGiftMsgSendCallback;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final d receiveGiftMessageListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private vi2.b mainLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long ownerId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.liveroom.impl.room.medal.h medalSupplierMgr;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.message.QQLiveGiftMessageLayoutManager$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$b", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/d$b;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "msg", "", "isHistoryMsg", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements d.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveGiftMessageLayoutManager.this);
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.historychatmsg.d.b
        public void a(@NotNull GiftMessage msg2, boolean isHistoryMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, msg2, Boolean.valueOf(isHistoryMsg));
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            AegisLogger.INSTANCE.i(QQLiveGiftMessageLayoutManager.this.P(), "onSendChatMsg, isHistoryMsg:" + isHistoryMsg);
            QQLiveGiftMessageLayoutManager.this.T(msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004`\u0005H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "", "onReceiveEvent", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements SimpleEventReceiver<SimpleBaseEvent> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveGiftMessageLayoutManager.this);
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
            arrayList.add(SysMsgEvent.class);
            arrayList.add(LiveLocalMsg.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            boolean isBlank;
            boolean isBlank2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) event);
                return;
            }
            if (event instanceof LiveLocalMsg) {
                LiveLocalMsg liveLocalMsg = (LiveLocalMsg) event;
                if (liveLocalMsg.getRoomId() == QQLiveGiftMessageLayoutManager.this.S()) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(liveLocalMsg.getText());
                    if (!isBlank2) {
                        QQLiveGiftMessageLayoutManager.this.s(event);
                        return;
                    }
                    return;
                }
                return;
            }
            if (event instanceof SysMsgEvent) {
                SysMsgEvent sysMsgEvent = (SysMsgEvent) event;
                if (sysMsgEvent.getRoomId() == QQLiveGiftMessageLayoutManager.this.S()) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(sysMsgEvent.getSysNotice());
                    if (!isBlank) {
                        QQLiveGiftMessageLayoutManager.this.s(new j(sysMsgEvent.getSysNotice(), 0, sysMsgEvent.getTxtColor(), null, null, 24, null));
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$d", "Lcom/tencent/mobileqq/qqlive/callback/gift/ReceiveGiftMessageListener;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "giftMessage", "", "onGiftMessageReceive", "", "code", "", "msg", "onError", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements ReceiveGiftMessageListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveGiftMessageLayoutManager.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QQLiveGiftMessageLayoutManager this$0, GiftMessage giftMessage) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(giftMessage, "$giftMessage");
            this$0.V(giftMessage);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onError(int code, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, code, (Object) msg2);
                return;
            }
            AegisLogger.INSTANCE.w("Chat_Message|MessagePushMgr", "onGiftFail", "errCode=" + code + ", errMsg=" + msg2);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onGiftMessageReceive(@NotNull final GiftMessage giftMessage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) giftMessage);
                return;
            }
            Intrinsics.checkNotNullParameter(giftMessage, "giftMessage");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager = QQLiveGiftMessageLayoutManager.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.message.e
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveGiftMessageLayoutManager.d.b(QQLiveGiftMessageLayoutManager.this, giftMessage);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/room/message/QQLiveGiftMessageLayoutManager$e", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/c$b;", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "innnerMedalInfo", "", "result", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements c.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.widget.chat.data.b f271645a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveGiftMessageLayoutManager f271646b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ChatBaseText f271647c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CharSequence f271648d;

        e(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar, QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager, ChatBaseText chatBaseText, CharSequence charSequence) {
            this.f271645a = bVar;
            this.f271646b = qQLiveGiftMessageLayoutManager;
            this.f271647c = chatBaseText;
            this.f271648d = charSequence;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, qQLiveGiftMessageLayoutManager, chatBaseText, charSequence);
            }
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c.b
        public void a(@Nullable com.tencent.mobileqq.qqlive.widget.chat.data.b innnerMedalInfo, @NotNull CharSequence result) {
            Long l3;
            Long l16;
            List<? extends CharSequence> listOf;
            Long l17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) innnerMedalInfo, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            com.tencent.mobileqq.qqlive.widget.chat.data.b bVar = this.f271645a;
            Object obj = null;
            if (bVar != null) {
                l3 = Long.valueOf(bVar.f273756a);
            } else {
                l3 = null;
            }
            if (innnerMedalInfo != null) {
                l16 = Long.valueOf(innnerMedalInfo.f273756a);
            } else {
                l16 = null;
            }
            if (!Intrinsics.areEqual(l3, l16)) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                String P = this.f271646b.P();
                com.tencent.mobileqq.qqlive.widget.chat.data.b bVar2 = this.f271645a;
                if (bVar2 != null) {
                    l17 = Long.valueOf(bVar2.f273756a);
                } else {
                    l17 = null;
                }
                if (innnerMedalInfo != null) {
                    obj = Long.valueOf(innnerMedalInfo.f273756a);
                }
                companion.i(P, "renderMedalInfo", "uid mismatch outer=" + l17 + ",inner=" + obj);
                return;
            }
            ChatBaseText chatBaseText = this.f271647c;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{result, this.f271648d});
            chatBaseText.setSpanText(listOf);
            if (this.f271646b.W(innnerMedalInfo)) {
                if (innnerMedalInfo != null) {
                    obj = innnerMedalInfo.f273760e;
                }
                if (obj != null) {
                    this.f271647c.setTextColor(innnerMedalInfo.f273760e.parseTextColor(com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.cla)));
                    return;
                }
            }
            this.f271647c.setTextColor(com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.cla));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31177);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 75)) {
            redirector.redirect((short) 75);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveGiftMessageLayoutManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.medalSupplierMgr = new com.tencent.timi.game.liveroom.impl.room.medal.h();
        this.historyGiftMsgMgr = new com.tencent.timi.game.liveroom.impl.room.historychatmsg.d();
        this.normalFloatingBannerQueueManager = new com.tencent.timi.game.liveroom.impl.room.message.stack.g();
        this.localMsgReceiver = new c();
        this.historyGiftMsgSendCallback = new b();
        this.receiveGiftMessageListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(GiftMessage msg2) {
        AegisLogger.INSTANCE.i("Chat_Message|QQLiveGiftMessageLayoutManager", "onGiftMessageReceive", "roomId=" + this.roomId + ", onNewGift:" + msg2);
        if (!pk4.b.z(msg2.giftID) && (msg2.comboOver || msg2.allComboCnt == 0)) {
            s(new com.tencent.mobileqq.qqlive.widget.chat.message.d(msg2));
        }
        if (msg2.sender == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
            com.tencent.timi.game.liveroom.impl.room.medal.d a16 = QQLiveMedalServiceSupplier.f377955a.a();
            long j3 = msg2.sender;
            long j16 = this.roomId;
            a16.a(j3, j16, wj4.c.a(j16), new d.a() { // from class: com.tencent.mobileqq.qqlive.room.message.c
                @Override // com.tencent.timi.game.liveroom.impl.room.medal.d.a
                public final void a(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                    QQLiveGiftMessageLayoutManager.U(bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(GiftMessage msg2) {
        if (this.historyGiftMsgMgr.g()) {
            T(msg2);
        } else {
            this.historyGiftMsgMgr.d(msg2);
        }
    }

    private final void X(mt3.e msg2) {
        final GiftMessage from = GiftMessage.from(msg2);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Chat_Message|QQLiveGiftMessageLayoutManager", "notifyGiftMsg", "name=" + from.giftName + ", id=" + from.giftID + ", num=" + from.giftNum + ", comboSeq=" + from.comboSeq);
        if (this.historyGiftMsgMgr.e(from.comboSeq)) {
            companion.i("Chat_Message|QQLiveGiftMessageLayoutManager", "Find same comboSeq:" + from.comboSeq + ", discard it.");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.message.d
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveGiftMessageLayoutManager.Y(QQLiveGiftMessageLayoutManager.this, from);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(QQLiveGiftMessageLayoutManager this$0, GiftMessage giftMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(giftMsg, "giftMsg");
        this$0.V(giftMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(QQLiveGiftMessageLayoutManager this$0, f msg2, com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AegisLogger.INSTANCE.d(this$0.P(), "onNewMsg");
        vi2.b bVar2 = this$0.mainLayout;
        if (bVar2 != null) {
            bVar2.d(msg2);
        }
    }

    private final void d0(fp4.c msgInfo, int cmd) {
        mt3.e m3;
        if (cmd == 16 && (m3 = com.tencent.mobileqq.qqlive.sail.push.a.m(msgInfo)) != null) {
            X(m3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(String announce, int state) {
        if (announce != null) {
            com.tencent.timi.game.liveroom.impl.room.notice.a.INSTANCE.a().e(announce, state);
        }
    }

    @Override // vi2.c
    public boolean B(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this, roomId)).booleanValue();
        }
        return TGLiveFollowManager.f377684a.r(roomId);
    }

    @Override // vi2.a
    public void C(@NotNull ChatTextMsgItemView view, int start, @NotNull String text, @NotNull Map<String, CommonOuterClass$QQUserId> atUserInfoMap, @NotNull SpannableStringBuilder spannable, @NotNull Map<Long, MessageOuterClass$AtUser> uidAtInfoMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, view, Integer.valueOf(start), text, atUserInfoMap, spannable, uidAtInfoMap);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(atUserInfoMap, "atUserInfoMap");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(uidAtInfoMap, "uidAtInfoMap");
    }

    @Override // vi2.c
    public void E(@Nullable LiveUserInfo liveUserInfo, long anchorId, @Nullable String msgContent) {
        boolean z16;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, this, liveUserInfo, Long.valueOf(anchorId), msgContent);
            return;
        }
        if (com.tencent.timi.game.liveroom.impl.room.util.b.a()) {
            return;
        }
        if (liveUserInfo != null && liveUserInfo.uid == 1289385052) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AegisLogger.INSTANCE.i(P(), "system msg,ignore click event");
            return;
        }
        com.tencent.timi.game.liveroom.impl.room.manager.e a16 = com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a();
        long j16 = this.roomId;
        if (liveUserInfo != null) {
            j3 = liveUserInfo.uid;
        } else {
            j3 = 0;
        }
        if (a16.g(j16, j3, anchorId)) {
            if (liveUserInfo == null || liveUserInfo.uid != com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                z17 = false;
            }
            if (!z17) {
                AegisLogger.INSTANCE.i(P(), "isInHideList\uff0cignore long click event");
                if (liveUserInfo != null) {
                    QQLiveActionSheetHelper.INSTANCE.d(O(), Long.valueOf(liveUserInfo.uid), liveUserInfo.nick, Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()), msgContent);
                    return;
                }
                return;
            }
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        String P = P();
        if (liveUserInfo != null) {
            str = liveUserInfo.nick;
        } else {
            str = null;
        }
        companion.i(P, "nickName onClick userName = " + str);
        if (liveUserInfo != null) {
            a.Companion.h(kk4.a.INSTANCE, O(), anchorId, liveUserInfo, 1, msgContent, false, 32, null);
        }
    }

    @Override // vi2.c
    @Nullable
    public ClickableSpan H(@NotNull o message, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (ClickableSpan) iPatchRedirector.redirect((short) 70, this, message, Long.valueOf(anchorId));
        }
        Intrinsics.checkNotNullParameter(message, "message");
        return null;
    }

    @Override // vi2.c
    public void I(@NotNull l msg2, @NotNull ChatTeamHintMsgItemView view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) msg2, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(view, "view");
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.b((ug4.a) b16, view, false, String.valueOf(msg2.b()), "em_qqlive_play_news", new LinkedHashMap(), 2, null);
    }

    public void K(@NotNull vi2.b anchorMessageLayout, @NotNull Context context, boolean isInAnchorState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, anchorMessageLayout, context, Boolean.valueOf(isInAnchorState));
            return;
        }
        Intrinsics.checkNotNullParameter(anchorMessageLayout, "anchorMessageLayout");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainLayout = anchorMessageLayout;
        h0(context);
        this.isInAnchorState = isInAnchorState;
        anchorMessageLayout.setSupportFunc(this, this);
    }

    @Override // vi2.c
    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this);
        }
    }

    @Override // vi2.c
    public void M(@NotNull ChatBaseText view, @NotNull f msg2) {
        com.tencent.mobileqq.qqlive.widget.chat.data.b bVar;
        com.tencent.mobileqq.qqlive.widget.chat.data.a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) view, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        e0(view, msg2);
        view.setTextColor(com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.cla));
        i header = msg2.getHeader();
        if (header != null && (a16 = header.a()) != null) {
            bVar = a16.f273754a;
        } else {
            bVar = null;
        }
        com.tencent.mobileqq.qqlive.widget.chat.data.b bVar2 = bVar;
        CharSequence text = view.getText();
        c.Companion companion = com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.d(context, view.i(), msg2, bVar2, new e(bVar2, this, view, text));
    }

    @Override // vi2.a
    public boolean N(@Nullable MessageOuterClass$AtUserMsg atUserMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, (Object) atUserMsg)).booleanValue();
        }
        return SpecialMsgUtil.f376345a.e(atUserMsg, Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
    }

    @NotNull
    public final Context O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @NotNull
    public String P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "Chat_Message|QQLiveGiftMessageLayoutManager";
    }

    public final long Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.ownerId;
    }

    @Override // vi2.a
    public int R(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, roomId)).intValue();
        }
        return wj4.c.a(roomId);
    }

    public final long S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public final boolean W(@Nullable com.tencent.mobileqq.qqlive.widget.chat.data.b medalInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this, (Object) medalInfo)).booleanValue();
        }
        if (medalInfo == null || !jj4.d.g()) {
            return false;
        }
        List<sr4.g> list = medalInfo.f273762g;
        Intrinsics.checkNotNullExpressionValue(list, "medalInfo.medalInfoNewList");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((sr4.g) it.next()).f434388d == 4) {
                return true;
            }
        }
        return false;
    }

    public final void Z(long roomId, long anchorUid, int roomType, boolean fromFloatWindow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Long.valueOf(roomId), Long.valueOf(anchorUid), Integer.valueOf(roomType), Boolean.valueOf(fromFloatWindow));
            return;
        }
        com.tencent.timi.game.liveroom.impl.util.c.f378976a.i("https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
        this.medalSupplierMgr.b(roomId, roomType);
        this.ownerId = anchorUid;
        this.roomId = roomId;
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.b(roomId, anchorUid, roomType);
        }
        this.historyGiftMsgMgr.i(roomId, fromFloatWindow, this.historyGiftMsgSendCallback);
        this.normalFloatingBannerQueueManager.d(roomId, this, this);
    }

    @Override // vi2.a
    public void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, view, Boolean.valueOf(isAsync), identifier, elementID, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) mm4.b.b(ug4.a.class)).a(view, isAsync, identifier, elementID, businessParams);
    }

    public final void a0(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, roomId);
            return;
        }
        if (roomId == this.roomId) {
            this.medalSupplierMgr.c();
        }
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.onExitRoom(roomId);
        }
        this.historyGiftMsgMgr.j();
        this.normalFloatingBannerQueueManager.e();
        com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c.INSTANCE.a();
    }

    @Override // vi2.a
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        return com.tencent.mobileqq.qqlive.sail.c.K(cVar, cVar.p(), 0, 2, null);
    }

    @Override // vi2.a
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Long) iPatchRedirector.redirect((short) 36, (Object) this)).longValue();
        }
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
    }

    public final void c0(long roomId, @Nullable String platform) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Long.valueOf(roomId), platform);
            return;
        }
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.i(roomId, platform);
        }
    }

    @Override // vi2.a
    @Nullable
    public List<Object> d(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, (Object) this, roomId);
        }
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.A(roomId);
    }

    @Override // vi2.a
    @Nullable
    public String decodeQQEmotion(@NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this, (Object) msg2);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return com.tencent.mobileqq.qqlive.widget.util.c.a(msg2);
    }

    @Override // vi2.c
    public void e(int id5, @NotNull qh2.f callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, id5, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(ni4.c.f420216a.a(Long.valueOf(this.roomId))).b().e(id5, callback);
        }
    }

    public void e0(@NotNull ChatBaseText view, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) view, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    @Override // vi2.c
    @Nullable
    public String f(long roomId, @Nullable String nick, long speakId, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, this, Long.valueOf(roomId), nick, Long.valueOf(speakId), Long.valueOf(anchorId));
        }
        return com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().d(roomId, nick, speakId, anchorId);
    }

    public final void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.h();
        }
    }

    @Override // vi2.c
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this);
        }
    }

    @Override // vi2.c
    @NotNull
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return ui4.a.f439039a.a();
    }

    public final void h0(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }
    }

    @Override // vi2.c
    public void i(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            LikeTouchManager.INSTANCE.triggerLikeIfMsgListIdle(event);
        }
    }

    public final void i0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.isFinishing = z16;
        }
    }

    @Override // vi2.c
    public boolean j(long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this, anchorId)).booleanValue();
        }
        return TGLiveFollowManager.f377684a.n(anchorId);
    }

    public final void j0(boolean show, boolean isLandScape) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Boolean.valueOf(show), Boolean.valueOf(isLandScape));
            return;
        }
        AegisLogger.INSTANCE.i(P(), "showVerDanmu", this.roomId + " isLandScape:" + isLandScape + ",show:" + show);
        if (isLandScape) {
            vi2.b bVar = this.mainLayout;
            if (bVar != null) {
                bVar.setVisibility(8);
                return;
            }
            return;
        }
        vi2.b bVar2 = this.mainLayout;
        if (bVar2 != null) {
            bVar2.a(show);
        }
        vi2.b bVar3 = this.mainLayout;
        if (bVar3 != null) {
            bVar3.setVisibility(0);
        }
    }

    @Override // vi2.c
    public void k(boolean listScrolling) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, listScrolling);
        } else {
            LikeTouchManager.INSTANCE.setMsgListScrolling(listScrolling);
        }
    }

    @Override // vi2.c
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this);
        } else {
            jk4.a.f410352a.c();
        }
    }

    @Override // vi2.c
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
            return;
        }
        IQQGiftManager iQQGiftManager = (IQQGiftManager) QRoute.api(IQQGiftManager.class);
        ni4.c cVar = ni4.c.f420216a;
        nh2.c sDKImpl = iQQGiftManager.getSDKImpl(cVar.a(Long.valueOf(this.roomId)));
        if (!sDKImpl.isInited()) {
            AegisLogger.INSTANCE.e(P(), "initGiftSDK", "QQGiftSDKConfig init call");
            sDKImpl.c(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.qqgift.sdk.config.a.a().d(cVar.a(Long.valueOf(this.roomId))).b());
        }
    }

    @Override // vi2.a
    public void n(@NotNull List<Object> datas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) datas);
            return;
        }
        Intrinsics.checkNotNullParameter(datas, "datas");
        AegisLogger.INSTANCE.i(P(), "saveMessageDatas, isInAnchorState " + this.isInAnchorState + ", isFinishing " + this.isFinishing);
        if (this.isInAnchorState && this.isFinishing) {
            return;
        }
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long j3 = this.roomId;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(datas);
        Unit unit = Unit.INSTANCE;
        cVar.L(j3, arrayList);
    }

    @Override // vi2.c
    @NotNull
    public String o(@Nullable String announce) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (String) iPatchRedirector.redirect((short) 66, (Object) this, (Object) announce);
        }
        return com.tencent.timi.game.liveroom.impl.room.notice.a.INSTANCE.a().c(announce);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        gp4.a g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        int i3 = msgInfo.f400284b;
        if ((i3 == 167 || i3 == 263 || i3 == 234 || i3 == 235) && (g16 = com.tencent.mobileqq.qqlive.sail.push.a.g(msgInfo)) != null) {
            d0(msgInfo, g16.f403047a);
        }
    }

    @Override // vi2.c
    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return ((Boolean) iPatchRedirector.redirect((short) 72, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // vi2.c
    public void q(@NotNull View view, @NotNull String announce) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) view, (Object) announce);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(announce, "announce");
        }
    }

    @Override // vi2.c
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this)).booleanValue();
        }
        return jk4.a.f410352a.b();
    }

    @Override // vi2.a
    public void register() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i(P(), "register");
        com.tencent.mobileqq.qqlive.sail.room.f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.p(167, this);
            z16.p(235, this);
        } else {
            ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(this.roomId);
            if (k3 != null) {
                k3.registerReceiveGiftMessageListener(this.receiveGiftMessageListener);
            }
        }
    }

    @Override // vi2.a
    public void reportEvent(@NotNull String click, @NotNull Object arg, @NotNull Map<String, String> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, click, arg, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(arg, "arg");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", arg, businessParams);
    }

    @Override // vi2.a
    public void s(@NotNull Object msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2 instanceof f) {
            this.medalSupplierMgr.a(this.roomId, this.roomType, com.tencent.mobileqq.qqlive.widget.chat.util.a.a(msg2)).a((f) msg2, new e.a() { // from class: com.tencent.mobileqq.qqlive.room.message.b
                @Override // com.tencent.timi.game.liveroom.impl.room.medal.e.a
                public final void a(f fVar, com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                    QQLiveGiftMessageLayoutManager.b0(QQLiveGiftMessageLayoutManager.this, fVar, bVar);
                }
            });
            return;
        }
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.d(msg2);
        }
    }

    @Override // vi2.c
    public void t(@Nullable LiveUserInfo liveUserInfo, long anchorId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, liveUserInfo, Long.valueOf(anchorId));
            return;
        }
        if (liveUserInfo == null || liveUserInfo.uid != 1289385052) {
            z16 = false;
        }
        if (z16) {
            AegisLogger.INSTANCE.i(P(), "system msg\uff0cignore long click event");
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        String P = P();
        if (liveUserInfo != null) {
            str = liveUserInfo.nick;
        } else {
            str = null;
        }
        companion.i(P, "nickName onLoneClick userName = " + str);
        if (liveUserInfo != null && liveUserInfo.uid != com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            long j3 = this.roomId;
            LiveUserInfo liveUserInfo2 = new LiveUserInfo();
            liveUserInfo2.nick = liveUserInfo.nick;
            liveUserInfo2.showNick = com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().d(this.roomId, liveUserInfo.nick, liveUserInfo.uid, anchorId);
            liveUserInfo2.uid = liveUserInfo.uid;
            liveUserInfo2.headUrl = liveUserInfo.headUrl;
            liveUserInfo2.sex = liveUserInfo.sex;
            Unit unit = Unit.INSTANCE;
            simpleEventBus.dispatchEvent(new AnchorAtEvent(j3, liveUserInfo2, null, false, 12, null));
        }
    }

    @Override // vi2.a
    public boolean u(@Nullable ViewParent viewParent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Boolean) iPatchRedirector.redirect((short) 74, (Object) this, (Object) viewParent)).booleanValue();
        }
        return a.C11420a.b(this, viewParent);
    }

    @Override // vi2.a
    public void unregister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i(P(), "unregister");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        if (com.tencent.mobileqq.qqlive.sail.c.z(cVar, this.roomId, 0, 2, null) != null) {
            com.tencent.mobileqq.qqlive.sail.room.f z16 = com.tencent.mobileqq.qqlive.sail.c.z(cVar, this.roomId, 0, 2, null);
            if (z16 != null) {
                z16.e(this);
                return;
            }
            return;
        }
        ILiveRoomMessage k3 = ((jg4.b) mm4.b.b(jg4.b.class)).k(this.roomId);
        if (k3 != null) {
            k3.unRegisterReceiveGiftMessageListener(this.receiveGiftMessageListener);
        }
    }

    @Override // vi2.c
    @NotNull
    public com.tencent.mobileqq.qqlive.widget.chat.span.b v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (com.tencent.mobileqq.qqlive.widget.chat.span.b) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return new yj4.a();
    }

    @Override // vi2.c
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetAnnounceRequest(this.roomId), new Function1<QQLiveResponse<xq4.c>, Unit>() { // from class: com.tencent.mobileqq.qqlive.room.message.QQLiveGiftMessageLayoutManager$setAnnounceIsNull$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveGiftMessageLayoutManager.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<xq4.c> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:36:0x009b, code lost:
                
                    if (r7 != false) goto L42;
                 */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
                /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
                /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x0089  */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(@NotNull QQLiveResponse<xq4.c> it) {
                    boolean z16;
                    boolean isBlank;
                    boolean isBlank2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!it.isFailed() && it.getRsp() != null) {
                        xq4.c rsp = it.getRsp();
                        boolean z17 = false;
                        boolean z18 = rsp != null && rsp.f448407b;
                        xq4.c rsp2 = it.getRsp();
                        String str = rsp2 != null ? rsp2.f448406a : null;
                        QQLiveGiftMessageLayoutManager.this.g0(str, z18 ? 1 : 2);
                        AegisLogger.INSTANCE.i(QQLiveGiftMessageLayoutManager.this.P(), "getRoomAnnounce suc reviewed=" + z18);
                        if (str != null) {
                            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                            if (!isBlank2) {
                                z16 = false;
                                if (z16 || QQLiveGiftMessageLayoutManager.this.Q() == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                                    String str2 = !z18 ? "\u623f\u95f4\u6ca1\u6709\u516c\u544a\uff0c\u8d76\u5feb\u53bb\u8bbe\u7f6e\u4e00\u4e2a\u5427~" : "";
                                    QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager = QQLiveGiftMessageLayoutManager.this;
                                    AnnouncePushMessage announcePushMessage = new AnnouncePushMessage();
                                    QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager2 = QQLiveGiftMessageLayoutManager.this;
                                    if (str != null) {
                                        isBlank = StringsKt__StringsJVMKt.isBlank(str);
                                    }
                                    z17 = true;
                                    if (z17) {
                                        str = str2;
                                    }
                                    announcePushMessage.announce = str;
                                    announcePushMessage.roomId = qQLiveGiftMessageLayoutManager2.S();
                                    announcePushMessage.uid = qQLiveGiftMessageLayoutManager2.Q();
                                    announcePushMessage.approved = z18;
                                    qQLiveGiftMessageLayoutManager.s(announcePushMessage);
                                    return;
                                }
                                return;
                            }
                        }
                        z16 = true;
                        if (z16) {
                        }
                        if (!z18) {
                        }
                        QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager3 = QQLiveGiftMessageLayoutManager.this;
                        AnnouncePushMessage announcePushMessage2 = new AnnouncePushMessage();
                        QQLiveGiftMessageLayoutManager qQLiveGiftMessageLayoutManager22 = QQLiveGiftMessageLayoutManager.this;
                        if (str != null) {
                        }
                        z17 = true;
                        if (z17) {
                        }
                        announcePushMessage2.announce = str;
                        announcePushMessage2.roomId = qQLiveGiftMessageLayoutManager22.S();
                        announcePushMessage2.uid = qQLiveGiftMessageLayoutManager22.Q();
                        announcePushMessage2.approved = z18;
                        qQLiveGiftMessageLayoutManager3.s(announcePushMessage2);
                        return;
                    }
                    AegisLogger.INSTANCE.e(QQLiveGiftMessageLayoutManager.this.P(), "onEnterRoom", "getRoomAnnounce errCode = [" + it.getRetCode() + "], errMsg = [" + it.getErrMsg() + "]");
                }
            });
        }
    }

    @Override // vi2.c
    @NotNull
    public ClickableSpan y(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.c msg2, long anchorId, long roomId, @NotNull Function1<? super com.tencent.mobileqq.qqlive.widget.chat.message.c, Unit> function) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (ClickableSpan) iPatchRedirector.redirect((short) 67, this, msg2, Long.valueOf(anchorId), Long.valueOf(roomId), function);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(function, "function");
        return new hl4.a(msg2, anchorId, roomId, function);
    }

    @Override // vi2.a
    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.m().B(this.roomId, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
    }
}
