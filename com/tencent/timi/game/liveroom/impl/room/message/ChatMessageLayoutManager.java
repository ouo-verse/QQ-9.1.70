package com.tencent.timi.game.liveroom.impl.room.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.userlevel.UserLevelUpgrade;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamHintMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamJoinMsgView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qqlive.widget.chat.message.j;
import com.tencent.mobileqq.qqlive.widget.chat.message.k;
import com.tencent.mobileqq.qqlive.widget.chat.message.l;
import com.tencent.mobileqq.qqlive.widget.chat.message.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.app.event.AnchorAtEvent;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.historychatmsg.b;
import com.tencent.timi.game.liveroom.impl.room.like.LikeTouchManager;
import com.tencent.timi.game.liveroom.impl.room.medal.QQLiveMedalServiceSupplier;
import com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c;
import com.tencent.timi.game.liveroom.impl.room.medal.d;
import com.tencent.timi.game.liveroom.impl.room.medal.e;
import com.tencent.timi.game.liveroom.impl.room.message.event.SysMsgEvent;
import com.tencent.timi.game.liveroom.impl.room.message.i;
import com.tencent.timi.game.liveroom.impl.room.message.stack.NormalFloatingBannerLogic;
import com.tencent.timi.game.liveroom.impl.room.notice.UpdateNoticeEvent;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle;
import com.tencent.timi.game.liveroom.impl.util.QQLiveActionSheetHelper;
import com.tencent.timi.game.sso.request.QQLiveGetAnnounceRequest;
import com.tencent.timi.game.web.business.api.task.LiveLotteryTaskDataManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kk4.a;
import kl4.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AnchorChargeMsg;
import trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$LiveRoomEnterGameTeamMsg;
import trpc.yes.common.MessageOuterClass$LiveRoomLotteryResultMsg;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import ug4.a;
import vi2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0002\u00ed\u0001\b\u0016\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001RB\t\u00a2\u0006\u0006\b\u00f0\u0001\u0010\u00f1\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013H\u0002J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0016J \u0010$\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010(\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010'\u001a\u00020\u0015J\b\u0010)\u001a\u00020\u0006H\u0016J\u0018\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010+\u001a\u00020*H\u0016J\u0016\u00100\u001a\u00020\u00062\f\u0010/\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\u0006\u00101\u001a\u00020\u0006J\u0018\u00103\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u00010\u0015J0\u00107\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\"J\u000e\u00108\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*J\b\u00109\u001a\u00020\"H\u0016J,\u0010?\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00152\u0006\u0010<\u001a\u00020;2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150=H\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J\b\u0010A\u001a\u00020*H\u0016JP\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u00152\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020G0F2\u0006\u0010J\u001a\u00020I2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020K0FH\u0016J>\u0010R\u001a\u00020\u00062\u0006\u0010C\u001a\u00020N2\u0006\u0010O\u001a\u00020\"2\b\u0010P\u001a\u0004\u0018\u00010\u00152\u0006\u0010Q\u001a\u00020\u00152\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150=H\u0016J\u0010\u0010S\u001a\u00020\u00172\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010T\u001a\u00020\"H\u0016J\u0006\u0010U\u001a\u00020\u0006J\u0010\u0010V\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u000e\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020WJ\u0010\u0010Z\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u0010\u0010[\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010]\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\\H\u0016J\u0010\u0010`\u001a\u00020\u00062\u0006\u0010_\u001a\u00020^H\u0016J\u0012\u0010a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020bH\u0016J\u0012\u0010d\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020eH\u0016J\u0010\u0010g\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\\H\u0016J\u0012\u0010h\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010i\u001a\u00020\u0006H\u0016J\b\u0010j\u001a\u00020\u0006H\u0016J\u0010\u0010l\u001a\u00020\u00062\u0006\u0010k\u001a\u00020-H\u0016J\u0012\u0010o\u001a\u00020\"2\b\u0010n\u001a\u0004\u0018\u00010mH\u0016J\u0018\u0010r\u001a\u00020\u00062\u0006\u0010p\u001a\u00020\"2\b\b\u0002\u0010q\u001a\u00020\"J\b\u0010s\u001a\u00020\u0015H\u0016J\u0010\u0010v\u001a\u00020\u00062\u0006\u0010u\u001a\u00020tH\u0016J\u0010\u0010x\u001a\u00020\u00062\u0006\u0010w\u001a\u00020\"H\u0016J\b\u0010z\u001a\u00020yH\u0016J\b\u0010{\u001a\u00020\u0006H\u0016J\u0018\u0010}\u001a\u00020\u00062\u0006\u0010C\u001a\u00020|2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\"2\b\u0010\u007f\u001a\u0004\u0018\u00010~J\u0019\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010C\u001a\u00020|2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0085\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u00020\u00172\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001H\u0016J0\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020*2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0087\u0001\u001a\u00020*2\u0007\u0010\u0088\u0001\u001a\u00020*H\u0016J\u001b\u0010\u008c\u0001\u001a\u00020\u00062\u0007\u0010\u0010\u001a\u00030\u008a\u00012\u0007\u0010C\u001a\u00030\u008b\u0001H\u0016J\u0011\u0010\u008d\u0001\u001a\u00020\"2\u0006\u0010+\u001a\u00020*H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020*H\u0016J\t\u0010\u008f\u0001\u001a\u00020\"H\u0016J\t\u0010\u0090\u0001\u001a\u00020\u0006H\u0016J\u0019\u0010\u0091\u0001\u001a\u00020\u00062\u0006\u0010C\u001a\u00020N2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0013\u0010\u0092\u0001\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016JL\u0010\u0099\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0010\u001a\u00030\u0093\u00012\u0007\u0010\u0088\u0001\u001a\u00020*2\u0006\u0010+\u001a\u00020*2&\u0010\u0097\u0001\u001a!\u0012\u0016\u0012\u00140\u0093\u0001\u00a2\u0006\u000e\b\u0095\u0001\u0012\t\b\u0096\u0001\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u0094\u0001H\u0016J\u001e\u0010\u009c\u0001\u001a\u00020\u00062\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0007\u0010\u0088\u0001\u001a\u00020*H\u0016J)\u0010\u009e\u0001\u001a\u00020\u00062\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0007\u0010\u0088\u0001\u001a\u00020*2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J\u001f\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u0098\u00012\b\u0010\u00a0\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u0088\u0001\u001a\u00020*H\u0016J\t\u0010\u00a2\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u00a3\u0001\u001a\u00020\"H\u0016J\t\u0010\u00a4\u0001\u001a\u00020\u0006H\u0016R'\u0010!\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\b.\u0010\u00a5\u0001\u001a\u0006\b\u00a6\u0001\u0010\u00a7\u0001\"\u0006\b\u00a8\u0001\u0010\u00a9\u0001R+\u0010\u00af\u0001\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u00aa\u0001\u001a\u0006\b\u00ab\u0001\u0010\u00ac\u0001\"\u0006\b\u00ad\u0001\u0010\u00ae\u0001R'\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0089\u0001\u0010]\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001\"\u0006\b\u00b2\u0001\u0010\u00b3\u0001R'\u00105\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bs\u0010\u008c\u0001\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001\"\u0006\b\u00b6\u0001\u0010\u00b7\u0001R'\u0010\u00ba\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bv\u0010]\u001a\u0006\b\u00b8\u0001\u0010\u00b1\u0001\"\u0006\b\u00b9\u0001\u0010\u00b3\u0001R\u001c\u0010\u00bf\u0001\u001a\u00030\u00bb\u00018\u0006\u00a2\u0006\u000f\n\u0005\b{\u0010\u00bc\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001R\u001c\u0010\u00c4\u0001\u001a\u00030\u00c0\u00018\u0006\u00a2\u0006\u000f\n\u0005\bM\u0010\u00c1\u0001\u001a\u0006\b\u00c2\u0001\u0010\u00c3\u0001R\u0017\u0010\u00c7\u0001\u001a\u00030\u00c5\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bV\u0010\u00c6\u0001R\u0018\u0010\u00ca\u0001\u001a\u00030\u00c8\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u00c9\u0001R&\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bg\u0010$\u001a\u0006\b\u00cb\u0001\u0010\u00cc\u0001\"\u0006\b\u00cd\u0001\u0010\u00ce\u0001R'\u0010\u00cf\u0001\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b`\u0010$\u001a\u0006\b\u00cf\u0001\u0010\u00cc\u0001\"\u0006\b\u00d0\u0001\u0010\u00ce\u0001R,\u0010\u00d7\u0001\u001a\u0005\u0018\u00010\u00d1\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a1\u0001\u0010\u00d2\u0001\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001\"\u0006\b\u00d5\u0001\u0010\u00d6\u0001R \u0010\u00dc\u0001\u001a\u00030\u00d8\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u00d9\u0001\u001a\u0006\b\u00da\u0001\u0010\u00db\u0001R\u001f\u0010\u00e1\u0001\u001a\u00030\u00dd\u00018\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\b]\u0010\u00de\u0001\u001a\u0006\b\u00df\u0001\u0010\u00e0\u0001R\u001f\u0010\u00e6\u0001\u001a\u00030\u00e2\u00018\u0004X\u0084\u0004\u00a2\u0006\u000f\n\u0005\bd\u0010\u00e3\u0001\u001a\u0006\b\u00e4\u0001\u0010\u00e5\u0001R'\u0010\u00ec\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e8\u00010\u00e7\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00a2\u0001\u0010\u00e9\u0001\u001a\u0006\b\u00ea\u0001\u0010\u00eb\u0001R\u0017\u0010\u00ef\u0001\u001a\u00030\u00ed\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b}\u0010\u00ee\u0001\u00a8\u0006\u00f2\u0001"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager;", "Lvi2/a;", "Lvi2/c;", "Lxj4/b;", "Ltrpc/yes/common/MessageOuterClass$LiveRoomLotteryResultMsg;", "lotteryResultMsg", "", "p0", "Ltrpc/yes/common/MessageOuterClass$AnchorChargeMsg;", "anchorChargeMsg", "n0", "v0", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "announcePushMessage", "O0", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "q0", "M0", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "r0", "", "announce", "", "state", "E0", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "broadCastFreeLove", "F0", "f0", "Lvi2/b;", "anchorMessageLayout", "Landroid/content/Context;", "context", "", "isInAnchorState", "Z", "", "data", "from", "o0", "w", "", "roomId", "", "", "d", "datas", DomainData.DOMAIN_NAME, "D0", "platform", "A0", "anchorUid", "roomType", "fromFloatWindow", "w0", "x0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "click", "Ljava/lang/Object;", "arg", "", "businessParams", "reportEvent", "decodeQQEmotion", "c", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTextMsgItemView;", "view", "start", "text", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "atUserInfoMap", "Landroid/text/SpannableStringBuilder;", "spannable", "Ltrpc/yes/common/MessageOuterClass$AtUser;", "uidAtInfoMap", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", BdhLogUtil.LogTag.Tag_Req, "b", "s0", "D", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic;", "normalFloatingBannerLogic", "J0", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "J", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$SpeakerInfo;", "audienceInfo", "G", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "onGiftMessageReceive", "K", "Lcom/tencent/mobileqq/qqlive/callback/userlevel/UserLevelUpgrade;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, "O", "register", "unregister", "newMsg", ReportConstant.COSTREPORT_PREFIX, "Ltrpc/yes/common/MessageOuterClass$AtUserMsg;", "atUserMsg", "N", "show", "isLandScape", "P0", tl.h.F, "Landroid/view/MotionEvent;", "event", "i", "listScrolling", "k", "Lcom/tencent/mobileqq/qqlive/widget/chat/span/b;", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatBaseText;", "M", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "medalInfo", "t0", "C0", "id", "Lqh2/f;", "callback", "e", "nick", "speakId", "anchorId", "f", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/l;", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTeamHintMsgItemView;", "I", "B", "j", "r", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/c;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "function", "Landroid/text/style/ClickableSpan;", "y", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "liveUserInfo", "t", RemoteMessageConst.MessageBody.MSG_CONTENT, "E", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/o;", "message", "H", "L", "p", "g", "Landroid/content/Context;", "b0", "()Landroid/content/Context;", "H0", "(Landroid/content/Context;)V", "Lvi2/b;", "g0", "()Lvi2/b;", "setMainLayout", "(Lvi2/b;)V", "mainLayout", "l0", "()J", "L0", "(J)V", "m0", "()I", "setRoomType", "(I)V", "k0", "K0", "ownerId", "Lhj4/a;", "Lhj4/a;", "c0", "()Lhj4/a;", "fansGroupPushMgr", "Lcom/tencent/timi/game/liveroom/impl/room/medal/h;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/h;", "h0", "()Lcom/tencent/timi/game/liveroom/impl/room/medal/h;", "medalSupplierMgr", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/b;", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/b;", "historyChatMsgMgr", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g;", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g;", "normalFloatingBannerQueueManager", "u0", "()Z", "setInAnchorState", "(Z)V", "isFinishing", "I0", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout$d;", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout$d;", "getChatInfoMessageListener", "()Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout$d;", "G0", "(Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout$d;)V", "chatInfoMessageListener", "Lxj4/a;", "Lxj4/a;", "i0", "()Lxj4/a;", "msgPushMgr", "Lcom/tencent/timi/game/liveroom/impl/room/message/i$b;", "Lcom/tencent/timi/game/liveroom/impl/room/message/i$b;", "j0", "()Lcom/tencent/timi/game/liveroom/impl/room/message/i$b;", "newLocalMsgReceiver", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "d0", "()Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "followStateListener", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "e0", "()Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "localMsgReceiver", "com/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$b", "Lcom/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$b;", "historyChatMsgSendCallback", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class ChatMessageLayoutManager implements vi2.a, vi2.c, xj4.b {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isInAnchorState;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isFinishing;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ChatMessageLayout.d chatInfoMessageListener;

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
    private final hj4.a fansGroupPushMgr = new hj4.a();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.liveroom.impl.room.medal.h medalSupplierMgr = new com.tencent.timi.game.liveroom.impl.room.medal.h();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.liveroom.impl.room.historychatmsg.b historyChatMsgMgr = new com.tencent.timi.game.liveroom.impl.room.historychatmsg.b();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.timi.game.liveroom.impl.room.message.stack.g normalFloatingBannerQueueManager = new com.tencent.timi.game.liveroom.impl.room.message.stack.g();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final xj4.a msgPushMgr = xj4.c.f448041a.a();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final i.b newLocalMsgReceiver = new d();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final IQQLiveFollowApi.IQQLiveFollowStateListener followStateListener = new IQQLiveFollowApi.IQQLiveFollowStateListener() { // from class: com.tencent.timi.game.liveroom.impl.room.message.a
        @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener
        public final void onFollowStateChange(long j3, long j16, int i3, String str) {
            ChatMessageLayoutManager.a0(ChatMessageLayoutManager.this, j3, j16, i3, str);
        }
    };

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final SimpleEventReceiver<SimpleBaseEvent> localMsgReceiver = new c();

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final b historyChatMsgSendCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$b", "Lcom/tencent/timi/game/liveroom/impl/room/historychatmsg/b$b;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "msg", "", "isHistoryMsg", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements b.InterfaceC9938b {
        b() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.historychatmsg.b.InterfaceC9938b
        public void a(@NotNull LiveMessageData msg2, boolean isHistoryMsg) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            AegisLogger.INSTANCE.i(ChatMessageLayoutManager.this.f0(), "onSendChatMsg, isHistoryMsg:" + isHistoryMsg);
            ChatMessageLayoutManager.this.r0(msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0004`\u0005H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "", "onReceiveEvent", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements SimpleEventReceiver<SimpleBaseEvent> {
        c() {
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
                if (liveLocalMsg.getRoomId() == ChatMessageLayoutManager.this.getRoomId()) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(liveLocalMsg.getText());
                    if (!isBlank2) {
                        ChatMessageLayoutManager.this.s(event);
                        return;
                    }
                    return;
                }
                return;
            }
            if (event instanceof SysMsgEvent) {
                SysMsgEvent sysMsgEvent = (SysMsgEvent) event;
                if (sysMsgEvent.getRoomId() == ChatMessageLayoutManager.this.getRoomId()) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(sysMsgEvent.getSysNotice());
                    if (!isBlank) {
                        ChatMessageLayoutManager.this.s(new j(sysMsgEvent.getSysNotice(), 0, sysMsgEvent.getTxtColor(), null, null, 24, null));
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$d", "Lcom/tencent/timi/game/liveroom/impl/room/message/i$b;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "msg", "", "t6", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends i.b {
        d() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.message.i.a
        public void t6(@NotNull LiveMessageData msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ChatMessageLayoutManager.this.D(msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$e", "Lkotlin/Function1;", "Lnr4/f;", "Lkotlin/ParameterName;", "name", "msg", "", "Lcom/tencent/timi/game/liveroom/impl/room/fans/FansGroupReceiver;", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements Function1<nr4.f, Unit> {
        e() {
        }

        public void a(@Nullable nr4.f msg2) {
            if (msg2 != null) {
                ChatMessageLayoutManager chatMessageLayoutManager = ChatMessageLayoutManager.this;
                if (chatMessageLayoutManager.getRoomId() == msg2.f421231e) {
                    String str = msg2.f421232f;
                    Intrinsics.checkNotNullExpressionValue(str, "it.content");
                    chatMessageLayoutManager.s(new j(str, 0, 0, null, null, 30, null));
                    if (com.tencent.mobileqq.qqlive.sail.c.f272176a.G() == msg2.f421227a) {
                        uj4.b.f439096a.b(chatMessageLayoutManager.getRoomId(), chatMessageLayoutManager.getRoomType());
                    }
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(nr4.f fVar) {
            a(fVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$f", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f extends ClickableSpan {
        f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            jk4.a.f410352a.c();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$g", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/c$b;", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "innnerMedalInfo", "", "result", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g implements c.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.widget.chat.data.b f378054a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChatMessageLayoutManager f378055b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ChatBaseText f378056c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CharSequence f378057d;

        g(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar, ChatMessageLayoutManager chatMessageLayoutManager, ChatBaseText chatBaseText, CharSequence charSequence) {
            this.f378054a = bVar;
            this.f378055b = chatMessageLayoutManager;
            this.f378056c = chatBaseText;
            this.f378057d = charSequence;
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c.b
        public void a(@Nullable com.tencent.mobileqq.qqlive.widget.chat.data.b innnerMedalInfo, @NotNull CharSequence result) {
            Long l3;
            Long l16;
            List<? extends CharSequence> listOf;
            Long l17;
            Intrinsics.checkNotNullParameter(result, "result");
            com.tencent.mobileqq.qqlive.widget.chat.data.b bVar = this.f378054a;
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
                String f06 = this.f378055b.f0();
                com.tencent.mobileqq.qqlive.widget.chat.data.b bVar2 = this.f378054a;
                if (bVar2 != null) {
                    l17 = Long.valueOf(bVar2.f273756a);
                } else {
                    l17 = null;
                }
                if (innnerMedalInfo != null) {
                    obj = Long.valueOf(innnerMedalInfo.f273756a);
                }
                companion.i(f06, "renderMedalInfo", "uid mismatch outer=" + l17 + ",inner=" + obj);
                return;
            }
            ChatBaseText chatBaseText = this.f378056c;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{result, this.f378057d});
            chatBaseText.setSpanText(listOf);
            if (this.f378055b.t0(innnerMedalInfo)) {
                if (innnerMedalInfo != null) {
                    obj = innnerMedalInfo.f273760e;
                }
                if (obj != null) {
                    this.f378056c.setTextColor(innnerMedalInfo.f273760e.parseTextColor(com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.cla)));
                    return;
                }
            }
            this.f378056c.setTextColor(com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.cla));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager$h", "Lcom/tencent/timi/game/component/chat/at/a;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "atUserId", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h implements com.tencent.timi.game.component.chat.at.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<Long, MessageOuterClass$AtUser> f378058a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChatMessageLayoutManager f378059b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f378060c;

        h(Map<Long, MessageOuterClass$AtUser> map, ChatMessageLayoutManager chatMessageLayoutManager, String str) {
            this.f378058a = map;
            this.f378059b = chatMessageLayoutManager;
            this.f378060c = str;
        }

        @Override // com.tencent.timi.game.component.chat.at.a
        public void a(@Nullable CommonOuterClass$QQUserId atUserId) {
            PBUInt64Field pBUInt64Field;
            if (atUserId != null && (pBUInt64Field = atUserId.uid) != null) {
                long j3 = pBUInt64Field.get();
                Map<Long, MessageOuterClass$AtUser> map = this.f378058a;
                ChatMessageLayoutManager chatMessageLayoutManager = this.f378059b;
                String str = this.f378060c;
                MessageOuterClass$AtUser messageOuterClass$AtUser = map.get(Long.valueOf(j3));
                if (messageOuterClass$AtUser != null) {
                    LiveUserInfo liveUserInfo = new LiveUserInfo();
                    liveUserInfo.nick = messageOuterClass$AtUser.nick_name.get();
                    liveUserInfo.uid = messageOuterClass$AtUser.user_id.uid.get();
                    liveUserInfo.headUrl = messageOuterClass$AtUser.head_url.get();
                    if (com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().g(chatMessageLayoutManager.getRoomId(), messageOuterClass$AtUser.user_id.uid.get(), chatMessageLayoutManager.getOwnerId())) {
                        long j16 = messageOuterClass$AtUser.user_id.uid.get();
                        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
                        if (j16 != cVar.G()) {
                            AegisLogger.INSTANCE.i(chatMessageLayoutManager.f0(), "resetAtContentSpan", "handleAtMsg... isInHideList");
                            QQLiveActionSheetHelper.INSTANCE.d(chatMessageLayoutManager.b0(), Long.valueOf(messageOuterClass$AtUser.user_id.uid.get()), messageOuterClass$AtUser.nick_name.get(), Long.valueOf(cVar.G()), str);
                            return;
                        }
                    }
                    a.Companion.j(kk4.a.INSTANCE, chatMessageLayoutManager.b0(), chatMessageLayoutManager.getOwnerId(), liveUserInfo, 1, false, 16, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(String announce, int state) {
        if (announce != null) {
            com.tencent.timi.game.liveroom.impl.room.notice.a.INSTANCE.a().e(announce, state);
        }
    }

    private final void F0(QLBroadCastFreeLove broadCastFreeLove) {
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
                    q0(new com.tencent.mobileqq.qqlive.widget.chat.message.g(broadCastFreeLove));
                    return;
                }
            }
            AegisLogger.INSTANCE.i(f0(), "sendLikeMsg", "onReceiveRoomLikePush with empty roomMsg roomMsg:" + broadCastFreeLove.roomMsg + " userNick:" + broadCastFreeLove.userNick);
        }
    }

    private final void M0() {
        final String A;
        vi2.b bVar;
        RecyclerView x16;
        if (!ht3.a.e("qqlive_enter_room_system_notice_enable", true)) {
            return;
        }
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        if (com.tencent.mobileqq.qqlive.sail.c.K(cVar, this.roomId, 0, 2, null)) {
            A = cVar.d().s();
        } else {
            A = SailAudienceRoomManager.A(cVar.m(), this.roomId, 0, 2, null);
        }
        if (!TextUtils.isEmpty(A) && (bVar = this.mainLayout) != null && (x16 = bVar.x()) != null) {
            x16.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.message.c
                @Override // java.lang.Runnable
                public final void run() {
                    ChatMessageLayoutManager.N0(ChatMessageLayoutManager.this, A);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(ChatMessageLayoutManager this$0, String sysNotice) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sysNotice, "$sysNotice");
        this$0.s(new j(sysNotice, 0, 0, null, null, 30, null));
    }

    private final void O0(AnnouncePushMessage announcePushMessage) {
        AegisLogger.INSTANCE.d(f0(), "iQQLiveAnnouncePushListener " + this.isInAnchorState + "," + announcePushMessage.approved);
        if (this.isInAnchorState) {
            new m(b0(), announcePushMessage.roomId, this.ownerId, announcePushMessage.announce).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ChatMessageLayoutManager this$0, long j3, long j16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        Long valueOf = Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.l(cVar, this$0.roomId, 0, 2, null));
        long longValue = valueOf.longValue();
        boolean z16 = true;
        if (com.tencent.mobileqq.qqlive.sail.c.F(cVar, this$0.roomId, 0, 2, null) != 2 || j16 != this$0.roomId ? longValue != j16 : j3 != cVar.G()) {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.longValue();
            this$0.v0();
        }
    }

    private final void n0(MessageOuterClass$AnchorChargeMsg anchorChargeMsg) {
        MessageOuterClass$AnchorChargeMsg messageOuterClass$AnchorChargeMsg;
        if (anchorChargeMsg != null) {
            messageOuterClass$AnchorChargeMsg = anchorChargeMsg.get();
        } else {
            messageOuterClass$AnchorChargeMsg = null;
        }
        if (messageOuterClass$AnchorChargeMsg == null) {
            return;
        }
        PBUInt64Field pBUInt64Field = anchorChargeMsg.uid;
        boolean z16 = false;
        if (pBUInt64Field != null && pBUInt64Field.get() == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
            z16 = true;
        }
        if (z16) {
            jk4.a.f410352a.e(this.roomId);
        }
        s(new com.tencent.mobileqq.qqlive.widget.chat.message.a(anchorChargeMsg));
    }

    private final void p0(MessageOuterClass$LiveRoomLotteryResultMsg lotteryResultMsg) {
        LiveLotteryTaskDataManager.f380318a.g(lotteryResultMsg);
    }

    private final void q0(com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        if (ht3.a.e("qqlive_chat_area_normal_banner_enable", true)) {
            this.normalFloatingBannerQueueManager.b(msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(LiveMessageData msg2) {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.d(f0(), "Msg_Receive_" + this.roomId, msg2.mSpeakerInfo.mSpeakerName + ProgressTracer.SEPARATOR + msg2.msgContent);
        com.tencent.mobileqq.qqlive.widget.chat.message.h hVar = new com.tencent.mobileqq.qqlive.widget.chat.message.h(msg2);
        if (ht3.a.e("qqlive_push_message_log_enable", true)) {
            companion.i(f0(), "Msg_Receive_" + this.roomId, "LiveMsgReceive " + hVar.c().mSpeakerName + "(" + hVar.c().mSpeakId + "): " + hVar.message());
        }
        s(hVar);
    }

    private final void v0() {
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(ChatMessageLayoutManager this$0, com.tencent.mobileqq.qqlive.widget.chat.message.f msg2, com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        com.tencent.mobileqq.qqlive.widget.chat.message.i header = msg2.getHeader();
        if (header != null) {
            header.a();
        }
        vi2.b bVar2 = this$0.mainLayout;
        if (bVar2 != null) {
            bVar2.d(msg2);
        }
    }

    @Override // xj4.b
    public void A(@NotNull UserLevelUpgrade msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!UserLevelToggle.INSTANCE.d()) {
            AegisLogger.INSTANCE.i(f0(), "toggle \u63a7\u5236\u4e0d\u5c55\u793a\u5347\u7ea7\u4fe1\u606f");
            return;
        }
        String string = b0().getString(R.string.f1651627s, com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().b(this.roomId, msg2.getNick(), msg2.getUid(), this.ownerId), Long.valueOf(msg2.getNewLevel()));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026   msg.newLevel\n        )");
        AegisLogger.INSTANCE.d(f0(), "Msg_Receive_" + this.roomId, "UserLevelUpgrade " + msg2.getNick() + " content:" + msg2);
        s(new j(new SpannableStringBuilder(string), 0, 0, null, null, 30, null));
        com.tencent.timi.game.liveroom.impl.room.medal.d a16 = QQLiveMedalServiceSupplier.f377955a.a();
        long uid = msg2.getUid();
        long j3 = this.roomId;
        a16.a(uid, j3, wj4.c.a(j3), new d.a() { // from class: com.tencent.timi.game.liveroom.impl.room.message.e
            @Override // com.tencent.timi.game.liveroom.impl.room.medal.d.a
            public final void a(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                ChatMessageLayoutManager.B0(bVar);
            }
        });
    }

    public final void A0(long roomId, @Nullable String platform) {
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.i(roomId, platform);
        }
    }

    @Override // vi2.c
    public boolean B(long roomId) {
        return TGLiveFollowManager.f377684a.r(roomId);
    }

    @Override // vi2.a
    public void C(@NotNull ChatTextMsgItemView view, int start, @NotNull String text, @NotNull Map<String, CommonOuterClass$QQUserId> atUserInfoMap, @NotNull SpannableStringBuilder spannable, @NotNull Map<Long, MessageOuterClass$AtUser> uidAtInfoMap) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(atUserInfoMap, "atUserInfoMap");
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(uidAtInfoMap, "uidAtInfoMap");
        SpecialMsgUtil.f376345a.f(start, text, atUserInfoMap, spannable, com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.cla), false, new h(uidAtInfoMap, this, text));
    }

    public void C0(@NotNull ChatBaseText view, @NotNull com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        List<? extends CharSequence> listOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if ((msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.h) && jk4.a.f410352a.f(view.i())) {
            CharSequence text = view.getText();
            SpannableString spannableString = new SpannableString(" ");
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.o4w);
            if (drawable == null) {
                AegisLogger.INSTANCE.e(f0(), "renderLivePowerIcon", "renderLivePowerIcon drawable=null");
                return;
            }
            Bitmap b16 = com.tencent.open.base.d.b(drawable);
            if (b16 == null) {
                AegisLogger.INSTANCE.e(f0(), "renderLivePowerIcon", "renderLivePowerIcon bitmap=null");
                return;
            }
            spannableString.setSpan(new com.tencent.mobileqq.qqlive.widget.chat.span.a(b16, 0, 0, 6, null), 0, 1, 33);
            spannableString.setSpan(new f(), 0, 1, 17);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{spannableString, " ", text});
            view.setSpanText(listOf);
        }
    }

    @Override // xj4.b
    public void D(@NotNull LiveMessageData msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.historyChatMsgMgr.f()) {
            r0(msg2);
        } else {
            this.historyChatMsgMgr.d(msg2);
        }
    }

    public final void D0() {
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.h();
        }
    }

    @Override // vi2.c
    public void E(@Nullable LiveUserInfo liveUserInfo, long anchorId, @Nullable String msgContent) {
        boolean z16;
        long j3;
        String str;
        if (com.tencent.timi.game.liveroom.impl.room.util.b.a()) {
            return;
        }
        boolean z17 = true;
        if (liveUserInfo != null && liveUserInfo.uid == 1289385052) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AegisLogger.INSTANCE.i(f0(), "system msg,ignore click event");
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
                AegisLogger.INSTANCE.i(f0(), "isInHideList\uff0cignore long click event");
                if (liveUserInfo != null) {
                    QQLiveActionSheetHelper.INSTANCE.d(b0(), Long.valueOf(liveUserInfo.uid), liveUserInfo.nick, Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()), msgContent);
                    return;
                }
                return;
            }
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        String f06 = f0();
        if (liveUserInfo != null) {
            str = liveUserInfo.nick;
        } else {
            str = null;
        }
        companion.i(f06, "nickName onClick userName = " + str);
        if (liveUserInfo != null) {
            a.Companion.h(kk4.a.INSTANCE, b0(), anchorId, liveUserInfo, 1, msgContent, false, 32, null);
        }
    }

    public void F(@NotNull FollowPushMessage msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    @Override // xj4.b
    public void G(@NotNull LiveMessageData.SpeakerInfo audienceInfo) {
        Intrinsics.checkNotNullParameter(audienceInfo, "audienceInfo");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long l3 = com.tencent.mobileqq.qqlive.sail.c.l(cVar, this.roomId, 0, 2, null);
        long j3 = audienceInfo.mSpeakId;
        if (j3 == l3 || j3 == cVar.G()) {
            return;
        }
        AegisLogger.INSTANCE.d(f0(), "Msg_Receive_" + this.roomId, "onAudienceEnterRoom " + audienceInfo.mSpeakerName);
        q0(new com.tencent.mobileqq.qqlive.widget.chat.message.b(audienceInfo));
    }

    public final void G0(@Nullable ChatMessageLayout.d dVar) {
        this.chatInfoMessageListener = dVar;
    }

    @Nullable
    public ClickableSpan H(@NotNull o message, long anchorId) {
        Intrinsics.checkNotNullParameter(message, "message");
        return null;
    }

    public final void H0(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    @Override // vi2.c
    public void I(@NotNull l msg2, @NotNull ChatTeamHintMsgItemView view) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(view, "view");
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.b((ug4.a) b16, view, false, String.valueOf(msg2.b()), "em_qqlive_play_news", new LinkedHashMap(), 2, null);
    }

    public final void I0(boolean z16) {
        this.isFinishing = z16;
    }

    @Override // xj4.b
    public void J(@NotNull FollowPushMessage msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AegisLogger.INSTANCE.d(f0(), "Msg_Receive_" + this.roomId, "onFollowReceive " + msg2.nick);
        if (msg2.type == 1 && msg2.toUid == this.ownerId) {
            q0(new com.tencent.mobileqq.qqlive.widget.chat.message.c(msg2));
        }
    }

    public final void J0(@NotNull NormalFloatingBannerLogic normalFloatingBannerLogic) {
        Intrinsics.checkNotNullParameter(normalFloatingBannerLogic, "normalFloatingBannerLogic");
        this.normalFloatingBannerQueueManager.f(normalFloatingBannerLogic);
    }

    public void K(@Nullable byte[] data) {
        o0(data, "old push channel");
    }

    public final void K0(long j3) {
        this.ownerId = j3;
    }

    public final void L0(long j3) {
        this.roomId = j3;
    }

    @Override // vi2.c
    public void M(@NotNull ChatBaseText view, @NotNull com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        com.tencent.mobileqq.qqlive.widget.chat.data.b bVar;
        com.tencent.mobileqq.qqlive.widget.chat.data.a a16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        C0(view, msg2);
        view.setTextColor(com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.cla));
        com.tencent.mobileqq.qqlive.widget.chat.message.i header = msg2.getHeader();
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
        companion.d(context, view.i(), msg2, bVar2, new g(bVar2, this, view, text));
    }

    @Override // vi2.a
    public boolean N(@Nullable MessageOuterClass$AtUserMsg atUserMsg) {
        return SpecialMsgUtil.f376345a.e(atUserMsg, Long.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()));
    }

    public void O(@Nullable byte[] data) {
        o0(data, "new push channel(0xef)");
    }

    @Override // xj4.b
    public void P(@NotNull LiveMessageData msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullExpressionValue(msg2.msgContent.mMsgElements, "msg.msgContent.mMsgElements");
        if (!r0.isEmpty()) {
            AegisLogger.INSTANCE.i(f0(), "Msg_Receive_" + this.roomId, "LiveSysMsg: " + msg2.msgContent.mMsgElements.get(0).mTextMsg.strText);
            String str = msg2.msgContent.mMsgElements.get(0).mTextMsg.strText;
            Intrinsics.checkNotNullExpressionValue(str, "msg.msgContent.mMsgElements[0].mTextMsg.strText");
            s(new j(str, 0, 0, null, null, 30, null));
        }
    }

    public final void P0(boolean show, boolean isLandScape) {
        AegisLogger.INSTANCE.i(f0(), "showVerDanmu", this.roomId + " isLandScape:" + isLandScape + ",show:" + show);
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

    public void Q(@NotNull AnnouncePushMessage msg2) {
        int i3;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.approved) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        E0(msg2.announce, i3);
        if (!msg2.approved) {
            O0(msg2);
        }
        AnnouncePushMessage announcePushMessage = new AnnouncePushMessage();
        announcePushMessage.roomId = msg2.roomId;
        announcePushMessage.uid = msg2.uid;
        announcePushMessage.announce = msg2.announce;
        announcePushMessage.approved = true;
        AegisLogger.INSTANCE.d(f0(), "Msg_Receive_" + this.roomId, "announce:" + msg2.announce);
        SimpleEventBus.getInstance().dispatchEvent(new UpdateNoticeEvent());
        if (!this.isInAnchorState) {
            s(announcePushMessage);
        } else {
            v0();
        }
    }

    @Override // vi2.a
    public int R(long roomId) {
        return wj4.c.a(roomId);
    }

    public void Z(@NotNull vi2.b anchorMessageLayout, @NotNull Context context, boolean isInAnchorState) {
        Intrinsics.checkNotNullParameter(anchorMessageLayout, "anchorMessageLayout");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainLayout = anchorMessageLayout;
        H0(context);
        this.isInAnchorState = isInAnchorState;
        anchorMessageLayout.setSupportFunc(this, this);
    }

    @Override // vi2.a
    public void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) mm4.b.b(ug4.a.class)).a(view, isAsync, identifier, elementID, businessParams);
    }

    @Override // vi2.a
    public boolean b() {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        return com.tencent.mobileqq.qqlive.sail.c.K(cVar, cVar.p(), 0, 2, null);
    }

    @NotNull
    public final Context b0() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    @Override // vi2.a
    public long c() {
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
    }

    @NotNull
    /* renamed from: c0, reason: from getter */
    public final hj4.a getFansGroupPushMgr() {
        return this.fansGroupPushMgr;
    }

    @Override // vi2.a
    @Nullable
    public List<Object> d(long roomId) {
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.A(roomId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: d0, reason: from getter */
    public final IQQLiveFollowApi.IQQLiveFollowStateListener getFollowStateListener() {
        return this.followStateListener;
    }

    @Override // vi2.a
    @Nullable
    public String decodeQQEmotion(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return com.tencent.mobileqq.qqlive.widget.util.c.a(msg2);
    }

    @Override // vi2.c
    public void e(int id5, @NotNull qh2.f callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(ni4.c.f420216a.a(Long.valueOf(this.roomId))).b().e(id5, callback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final SimpleEventReceiver<SimpleBaseEvent> e0() {
        return this.localMsgReceiver;
    }

    @Override // vi2.c
    @Nullable
    public String f(long roomId, @Nullable String nick, long speakId, long anchorId) {
        return com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().d(roomId, nick, speakId, anchorId);
    }

    @NotNull
    public String f0() {
        return "Chat_Message|ChatMessageLayoutManager";
    }

    @Nullable
    /* renamed from: g0, reason: from getter */
    public final vi2.b getMainLayout() {
        return this.mainLayout;
    }

    @Override // vi2.c
    @NotNull
    public String h() {
        return ui4.a.f439039a.a();
    }

    @NotNull
    /* renamed from: h0, reason: from getter */
    public final com.tencent.timi.game.liveroom.impl.room.medal.h getMedalSupplierMgr() {
        return this.medalSupplierMgr;
    }

    @Override // vi2.c
    public void i(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        LikeTouchManager.INSTANCE.triggerLikeIfMsgListIdle(event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: i0, reason: from getter */
    public final xj4.a getMsgPushMgr() {
        return this.msgPushMgr;
    }

    @Override // vi2.c
    public boolean j(long anchorId) {
        return TGLiveFollowManager.f377684a.n(anchorId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: j0, reason: from getter */
    public final i.b getNewLocalMsgReceiver() {
        return this.newLocalMsgReceiver;
    }

    @Override // vi2.c
    public void k(boolean listScrolling) {
        LikeTouchManager.INSTANCE.setMsgListScrolling(listScrolling);
    }

    /* renamed from: k0, reason: from getter */
    public final long getOwnerId() {
        return this.ownerId;
    }

    @Override // vi2.c
    public void l() {
        jk4.a.f410352a.c();
    }

    /* renamed from: l0, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @Override // vi2.c
    public void m() {
        IQQGiftManager iQQGiftManager = (IQQGiftManager) QRoute.api(IQQGiftManager.class);
        ni4.c cVar = ni4.c.f420216a;
        nh2.c sDKImpl = iQQGiftManager.getSDKImpl(cVar.a(Long.valueOf(this.roomId)));
        if (!sDKImpl.isInited()) {
            AegisLogger.INSTANCE.e(f0(), "initGiftSDK", "QQGiftSDKConfig init call");
            sDKImpl.c(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.qqgift.sdk.config.a.a().d(cVar.a(Long.valueOf(this.roomId))).b());
        }
    }

    /* renamed from: m0, reason: from getter */
    public final int getRoomType() {
        return this.roomType;
    }

    @Override // vi2.a
    public void n(@NotNull List<Object> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        AegisLogger.INSTANCE.i(f0(), "saveMessageDatas, isInAnchorState " + this.isInAnchorState + ", isFinishing " + this.isFinishing);
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
        return com.tencent.timi.game.liveroom.impl.room.notice.a.INSTANCE.a().c(announce);
    }

    public final void o0(@Nullable byte[] data, @NotNull String from) {
        Integer num;
        Integer num2;
        View view;
        RecyclerView x16;
        RecyclerView x17;
        RecyclerView x18;
        Intrinsics.checkNotNullParameter(from, "from");
        MessageOuterClass$TimMsgBody a16 = zk4.a.f452717a.a(data);
        if (a16 == null) {
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i(f0(), "handleCmdMsg type:" + a16.msg_type.get() + ", from=" + from);
        switch (a16.msg_type.get()) {
            case 85:
                companion.d(f0(), "onReceive kMsgTypeKPLScheduleModifyNotify");
                ui4.c.INSTANCE.b(a16);
                return;
            case 86:
                companion.d(f0(), "onReceive kMsgAnchorRoomInfoMsg");
                ChatMessageLayout.d dVar = this.chatInfoMessageListener;
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            case 87:
                companion.d(f0(), "onReceive kMsgAnchorRoomBulletScreenMsg, txt[" + a16.content.anchor_room_bullet_screen_msg.nickname.get() + "]");
                MessageOuterClass$AnchorRoomBulletScreenMsg messageOuterClass$AnchorRoomBulletScreenMsg = a16.content.anchor_room_bullet_screen_msg;
                Intrinsics.checkNotNullExpressionValue(messageOuterClass$AnchorRoomBulletScreenMsg, "msg.content.anchor_room_bullet_screen_msg");
                s(messageOuterClass$AnchorRoomBulletScreenMsg);
                return;
            case 88:
                MessageOuterClass$LiveRoomLotteryResultMsg messageOuterClass$LiveRoomLotteryResultMsg = a16.content.live_room_lottery_result_msg;
                Intrinsics.checkNotNullExpressionValue(messageOuterClass$LiveRoomLotteryResultMsg, "msg.content.live_room_lottery_result_msg");
                p0(messageOuterClass$LiveRoomLotteryResultMsg);
                return;
            case 89:
            default:
                return;
            case 90:
                MessageOuterClass$LiveRoomEnterGameTeamMsg messageOuterClass$LiveRoomEnterGameTeamMsg = a16.content.live_room_enter_game_room_msg;
                if (messageOuterClass$LiveRoomEnterGameTeamMsg != null) {
                    s(new k(messageOuterClass$LiveRoomEnterGameTeamMsg));
                    return;
                }
                return;
            case 91:
                if (!this.isInAnchorState && a16.content.live_room_update_team_info_msg.game_start.get() == 1) {
                    s(new l(a16, System.currentTimeMillis()));
                }
                vi2.b bVar = this.mainLayout;
                if (bVar != null && (x18 = bVar.x()) != null) {
                    num = Integer.valueOf(x18.getChildCount());
                } else {
                    num = null;
                }
                Intrinsics.checkNotNull(num);
                if (num.intValue() > 0) {
                    vi2.b bVar2 = this.mainLayout;
                    if (bVar2 != null && (x17 = bVar2.x()) != null) {
                        num2 = Integer.valueOf(x17.getChildCount());
                    } else {
                        num2 = null;
                    }
                    Intrinsics.checkNotNull(num2);
                    int intValue = num2.intValue();
                    if (intValue >= 0) {
                        int i3 = 0;
                        while (true) {
                            vi2.b bVar3 = this.mainLayout;
                            if (bVar3 != null && (x16 = bVar3.x()) != null) {
                                view = x16.getChildAt(i3);
                            } else {
                                view = null;
                            }
                            if (view instanceof ChatTeamJoinMsgView) {
                                ((ChatTeamJoinMsgView) view).s();
                            }
                            if (i3 != intValue) {
                                i3++;
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                break;
            case 92:
                n0(a16.content.anchor_charge_msg);
                return;
        }
    }

    @Override // xj4.b
    public void onGiftMessageReceive(@NotNull GiftMessage msg2) {
        String str;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        if (cVar.G() != msg2.sender && !com.tencent.mobileqq.qqlive.sail.c.K(cVar, cVar.p(), 0, 2, null)) {
            str = f0();
        } else {
            str = AegisLogger.SEND_GIFT_MONITOR;
        }
        AegisLogger.INSTANCE.i(str, "onGiftMessageReceive", "roomId=" + this.roomId + ", onNewGift:" + msg2);
        if (!pk4.b.z(msg2.giftID) && (msg2.comboOver || msg2.allComboCnt == 0)) {
            s(new com.tencent.mobileqq.qqlive.widget.chat.message.d(msg2));
        }
        if (msg2.sender == cVar.G()) {
            com.tencent.timi.game.liveroom.impl.room.medal.d a16 = QQLiveMedalServiceSupplier.f377955a.a();
            long j3 = msg2.sender;
            long j16 = this.roomId;
            a16.a(j3, j16, wj4.c.a(j16), new d.a() { // from class: com.tencent.timi.game.liveroom.impl.room.message.d
                @Override // com.tencent.timi.game.liveroom.impl.room.medal.d.a
                public final void a(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                    ChatMessageLayoutManager.y0(bVar);
                }
            });
        }
    }

    @Override // vi2.c
    public boolean p() {
        return false;
    }

    @Override // vi2.c
    public void q(@NotNull View view, @NotNull String announce) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(announce, "announce");
        if (com.tencent.timi.game.utils.b.d(view) != null) {
            if (com.tencent.timi.game.liveroom.impl.room.notice.a.INSTANCE.a().b(announce) != 2) {
                com.tencent.timi.game.liveroom.impl.room.notice.i.q0(b0(), this.roomId);
            } else {
                com.tencent.timi.game.ui.widget.f.c("\u516c\u544a\u6b63\u5728\u5ba1\u6838\uff0c\u8bf7\u7a0d\u540e\u8bbe\u7f6e");
            }
        }
    }

    @Override // vi2.c
    public boolean r() {
        return jk4.a.f410352a.b();
    }

    @Override // vi2.a
    public void register() {
        AegisLogger.INSTANCE.i(f0(), "register");
        this.msgPushMgr.a(this.roomId, this, this.isInAnchorState);
        i.f378067a.a(this.newLocalMsgReceiver);
        SimpleEventBus.getInstance().registerReceiver(this.localMsgReceiver);
        TGLiveFollowManager.f377684a.u(this.followStateListener);
        hj4.a.d(this.fansGroupPushMgr, this.roomId, new e(), null, 4, null);
    }

    @Override // vi2.a
    public void reportEvent(@NotNull String click, @NotNull Object arg, @NotNull Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(arg, "arg");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", arg, businessParams);
    }

    @Override // vi2.a
    public void s(@NotNull Object newMsg) {
        Intrinsics.checkNotNullParameter(newMsg, "newMsg");
        if (newMsg instanceof com.tencent.mobileqq.qqlive.widget.chat.message.f) {
            int a16 = com.tencent.mobileqq.qqlive.widget.chat.util.a.a(newMsg);
            com.tencent.timi.game.liveroom.impl.room.medal.e a17 = this.medalSupplierMgr.a(this.roomId, this.roomType, a16);
            AegisLogger.INSTANCE.d("Chat_Message|ChatMessageLayoutManager", "onNewMsg", "msgType=" + a16 + ", supplier=" + a17.getClass().getSimpleName());
            a17.a((com.tencent.mobileqq.qqlive.widget.chat.message.f) newMsg, new e.a() { // from class: com.tencent.timi.game.liveroom.impl.room.message.b
                @Override // com.tencent.timi.game.liveroom.impl.room.medal.e.a
                public final void a(com.tencent.mobileqq.qqlive.widget.chat.message.f fVar, com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                    ChatMessageLayoutManager.z0(ChatMessageLayoutManager.this, fVar, bVar);
                }
            });
            return;
        }
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.d(newMsg);
        }
    }

    public final void s0() {
        Long l3;
        LiveLoginInfo u16 = com.tencent.mobileqq.qqlive.sail.c.f272176a.u();
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        String f06 = f0();
        String str = null;
        if (u16 != null) {
            l3 = Long.valueOf(u16.q());
        } else {
            l3 = null;
        }
        if (u16 != null) {
            str = u16.m();
        }
        companion.i(f06, "insertSelfEnterRoomMsg", "insertSelfEnterRoomMsg,uid:" + l3 + ",name:" + str);
        if (u16 == null || b()) {
            return;
        }
        LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
        speakerInfo.mSpeakId = u16.q();
        speakerInfo.mSpeakerName = u16.m();
        speakerInfo.mLogo = u16.j();
        q0(new com.tencent.mobileqq.qqlive.widget.chat.message.b(speakerInfo));
    }

    @Override // vi2.c
    public void t(@Nullable LiveUserInfo liveUserInfo, long anchorId) {
        String str;
        boolean z16 = false;
        if (liveUserInfo != null && liveUserInfo.uid == 1289385052) {
            z16 = true;
        }
        if (z16) {
            AegisLogger.INSTANCE.i(f0(), "system msg\uff0cignore long click event");
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        String f06 = f0();
        if (liveUserInfo != null) {
            str = liveUserInfo.nick;
        } else {
            str = null;
        }
        companion.i(f06, "nickName onLoneClick userName = " + str);
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

    public final boolean t0(@Nullable com.tencent.mobileqq.qqlive.widget.chat.data.b medalInfo) {
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

    @Override // vi2.a
    public boolean u(@Nullable ViewParent viewParent) {
        return a.C11420a.b(this, viewParent);
    }

    /* renamed from: u0, reason: from getter */
    public final boolean getIsInAnchorState() {
        return this.isInAnchorState;
    }

    @Override // vi2.a
    public void unregister() {
        AegisLogger.INSTANCE.i(f0(), "unregister");
        this.msgPushMgr.unregister();
        i.f378067a.c(this.newLocalMsgReceiver);
        TGLiveFollowManager.f377684a.w(this.followStateListener);
        SimpleEventBus.getInstance().unRegisterReceiver(this.localMsgReceiver);
        this.fansGroupPushMgr.e();
    }

    @Override // vi2.c
    @NotNull
    public com.tencent.mobileqq.qqlive.widget.chat.span.b v() {
        return new yj4.a();
    }

    @Override // vi2.c
    public void w() {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetAnnounceRequest(this.roomId), new Function1<QQLiveResponse<xq4.c>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager$setAnnounceIsNull$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<xq4.c> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
            
                if (r7 != false) goto L37;
             */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull QQLiveResponse<xq4.c> it) {
                boolean z16;
                boolean isBlank;
                boolean isBlank2;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isFailed() && it.getRsp() != null) {
                    xq4.c rsp = it.getRsp();
                    boolean z17 = false;
                    boolean z18 = rsp != null && rsp.f448407b;
                    xq4.c rsp2 = it.getRsp();
                    String str = rsp2 != null ? rsp2.f448406a : null;
                    ChatMessageLayoutManager.this.E0(str, z18 ? 1 : 2);
                    AegisLogger.INSTANCE.i(ChatMessageLayoutManager.this.f0(), "getRoomAnnounce suc reviewed=" + z18);
                    if (str != null) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                        if (!isBlank2) {
                            z16 = false;
                            if (z16 || ChatMessageLayoutManager.this.getOwnerId() == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                                String str2 = !z18 ? "\u623f\u95f4\u6ca1\u6709\u516c\u544a\uff0c\u8d76\u5feb\u53bb\u8bbe\u7f6e\u4e00\u4e2a\u5427~" : "";
                                ChatMessageLayoutManager chatMessageLayoutManager = ChatMessageLayoutManager.this;
                                AnnouncePushMessage announcePushMessage = new AnnouncePushMessage();
                                ChatMessageLayoutManager chatMessageLayoutManager2 = ChatMessageLayoutManager.this;
                                if (str != null) {
                                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                                }
                                z17 = true;
                                if (z17) {
                                    str = str2;
                                }
                                announcePushMessage.announce = str;
                                announcePushMessage.roomId = chatMessageLayoutManager2.getRoomId();
                                announcePushMessage.uid = chatMessageLayoutManager2.getOwnerId();
                                announcePushMessage.approved = z18;
                                chatMessageLayoutManager.s(announcePushMessage);
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
                    ChatMessageLayoutManager chatMessageLayoutManager3 = ChatMessageLayoutManager.this;
                    AnnouncePushMessage announcePushMessage2 = new AnnouncePushMessage();
                    ChatMessageLayoutManager chatMessageLayoutManager22 = ChatMessageLayoutManager.this;
                    if (str != null) {
                    }
                    z17 = true;
                    if (z17) {
                    }
                    announcePushMessage2.announce = str;
                    announcePushMessage2.roomId = chatMessageLayoutManager22.getRoomId();
                    announcePushMessage2.uid = chatMessageLayoutManager22.getOwnerId();
                    announcePushMessage2.approved = z18;
                    chatMessageLayoutManager3.s(announcePushMessage2);
                    return;
                }
                AegisLogger.INSTANCE.e(ChatMessageLayoutManager.this.f0(), "onEnterRoom", "getRoomAnnounce errCode = [" + it.getRetCode() + "], errMsg = [" + it.getErrMsg() + "]");
            }
        });
    }

    public final void w0(long roomId, @Nullable String platform, long anchorUid, int roomType, boolean fromFloatWindow) {
        com.tencent.timi.game.liveroom.impl.util.c.f378976a.i("https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf");
        this.medalSupplierMgr.b(roomId, roomType);
        this.ownerId = anchorUid;
        this.roomId = roomId;
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.b(roomId, anchorUid, roomType);
        }
        this.historyChatMsgMgr.h(roomId, platform, fromFloatWindow, this.historyChatMsgSendCallback);
        this.normalFloatingBannerQueueManager.d(roomId, this, this);
        M0();
    }

    @Override // xj4.b
    public void x(@Nullable QLBroadCastFreeLove broadCastFreeLove) {
        F0(broadCastFreeLove);
    }

    public final void x0(long roomId) {
        if (roomId == this.roomId) {
            this.medalSupplierMgr.c();
        }
        vi2.b bVar = this.mainLayout;
        if (bVar != null) {
            bVar.onExitRoom(roomId);
        }
        this.historyChatMsgMgr.i();
        this.normalFloatingBannerQueueManager.e();
        com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c.INSTANCE.a();
    }

    @Override // vi2.c
    @NotNull
    public ClickableSpan y(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.c msg2, long anchorId, long roomId, @NotNull Function1<? super com.tencent.mobileqq.qqlive.widget.chat.message.c, Unit> function) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(function, "function");
        return new hl4.a(msg2, anchorId, roomId, function);
    }

    @Override // vi2.a
    public boolean z() {
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.m().B(this.roomId, 1);
    }

    public void L() {
    }

    @Override // vi2.c
    public void g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
    }
}
