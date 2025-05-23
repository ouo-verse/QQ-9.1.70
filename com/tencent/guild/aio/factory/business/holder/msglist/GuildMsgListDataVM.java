package com.tencent.guild.aio.factory.business.holder.msglist;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgRepoDelegate;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest.GuildGuestMsgRepoDelegate;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.v;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.factory.business.holder.msglist.k;
import com.tencent.guild.aio.halfpop.menu.GuildMsgResendStatusIntent;
import com.tencent.guild.aio.msglist.highlight.BeforeNavigateToMsgEvent;
import com.tencent.guild.aio.msglist.highlight.HighLightUnreadAtMsgState;
import com.tencent.guild.aio.msglist.highlight.HighLightViewHolderUIState;
import com.tencent.guild.aio.msglist.reply.GuildRefreshReplyNickEvent;
import com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.toptip.AIOTopHeightChangedEvent;
import com.tencent.guild.aio.util.flowbus.FlowEventReceiver;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmoPreviewApi;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.msg.service.l;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n*\u0006\u0098\u0001\u009c\u0001\u00a6\u0001\u0018\u0000 \u00ac\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0005\u00ad\u0001\u0016\u00ae\u0001B\u001d\u0012\b\b\u0002\u0010r\u001a\u00020o\u0012\b\b\u0002\u0010v\u001a\u00020s\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u0006\u0010\u0014\u001a\u00020\u0007J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\u001a\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J\b\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0007H\u0002J\u0010\u00102\u001a\u00020!2\u0006\u00101\u001a\u000200H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\u0016\u00106\u001a\u00020\u00072\f\u00105\u001a\b\u0012\u0004\u0012\u00020004H\u0002J\u0010\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010;\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010<\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020=H\u0002J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020@H\u0002J\u0010\u0010D\u001a\u00020C2\u0006\u0010>\u001a\u00020=H\u0002J\u0010\u0010G\u001a\u00020\u00072\u0006\u0010F\u001a\u00020EH\u0002J\b\u0010H\u001a\u00020CH\u0002J\b\u0010I\u001a\u00020CH\u0002J\b\u0010J\u001a\u00020CH\u0002J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020KH\u0002J\u0010\u0010N\u001a\u00020\u00072\u0006\u0010L\u001a\u00020KH\u0002J\b\u0010O\u001a\u00020\u0007H\u0002J\u0010\u0010Q\u001a\u00020\u00072\u0006\u0010F\u001a\u00020PH\u0002J\u0018\u0010U\u001a\u00020\u00072\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020&H\u0002J\u001a\u0010X\u001a\u00020\u00072\u0006\u00101\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010Z\u001a\u00020!2\b\u0010Y\u001a\u0004\u0018\u00010VH\u0002J\u0010\u0010[\u001a\u00020!2\u0006\u00101\u001a\u000200H\u0002J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010A\u001a\u00020@H\u0002J\u0018\u0010^\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010]2\u0006\u0010A\u001a\u00020@H\u0002J\"\u0010b\u001a\u00020\u00072\b\b\u0002\u0010_\u001a\u00020!2\u000e\b\u0002\u0010a\u001a\b\u0012\u0004\u0012\u00020`04H\u0002J$\u0010f\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u001b2\b\u0010d\u001a\u0004\u0018\u00010V2\b\u0010e\u001a\u0004\u0018\u00010VH\u0002J\u0012\u0010h\u001a\u00020\u00072\b\b\u0002\u0010g\u001a\u00020!H\u0002J\u0010\u0010j\u001a\u00020\u00072\u0006\u0010i\u001a\u00020&H\u0002J\u0010\u0010l\u001a\u00020\u00072\u0006\u0010k\u001a\u00020&H\u0002J\b\u0010n\u001a\u00020mH\u0002R\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010v\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010x\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010wR\u0018\u0010y\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010wR\u0014\u0010}\u001a\u00020z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0015\u0010\u0080\u0001\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0017\u0010\u0081\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\u000bR)\u0010\u0086\u0001\u001a\u0014\u0012\u0004\u0012\u00020R0\u0082\u0001j\t\u0012\u0004\u0012\u00020R`\u0083\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010\u000bR\u001e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020R0\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0093\u0001\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0084\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0018\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R-\u0010\u00a3\u0001\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0005\u0012\u00030\u0098\u00010\u00a0\u00010]8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R-\u0010\u00a5\u0001\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0005\u0012\u00030\u009c\u00010\u00a0\u00010]8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a2\u0001R\u0018\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001\u00a8\u0006\u00af\u0001"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "onResume", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "Z", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "o", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "p", "w", "W0", "state", "b", "implState", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataState;", "Y", "k0", "", "tag", "e0", "Landroid/os/Bundle;", "extra", "U0", "", "G0", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a$g;", "z0", "A0", "", "position", "Landroid/view/View;", "itemView", "o0", "F0", "g0", "n0", "c0", "B0", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "H0", "N0", "", "msgItems", "Q0", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "K0", "I0", "J0", "y0", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "E", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "w0", "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/guild/aio/msglist/highlight/BeforeNavigateToMsgEvent;", "event", "i0", "j0", "l0", "m0", "Lrr1/i;", "notifyData", "q0", "u0", "t0", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgItemContentViewClickEvent;", "r0", "", "msgId", "msgStatus", "x0", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "clickedView", "V0", "msg", "C0", "D0", "E0", "", "h0", "forceUpdate", "", "payloads", "L0", "source", "aioTopMsg", "aioBottomMsg", "b0", FileReaderHelper.OPEN_FILE_FROM_FORCE, "X0", "height", "p0", "topMargin", "s0", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "a0", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$c;", "repoProvider", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$a;", "D", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$a;", "extraParamProvider", "Lcom/tencent/aio/data/msglist/a;", "topAIOMsg", "bottomAIOMsg", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "G", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "eventReceiver", "H", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpsObserver", "handleFirstPageDelayed", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "J", "Ljava/util/HashSet;", "pendingHighLightMsgSeqSet", "K", "Ljava/lang/Long;", "lastLogDisplayMsgSeqFirstSeq", "L", "lastLogAioFirstRecMsgSeq", "M", "hasGetChannelEventFlow", "Ljava/util/concurrent/CopyOnWriteArrayList;", "N", "Ljava/util/concurrent/CopyOnWriteArrayList;", "visibleIds", "P", "mNewMsgLineSeq", "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/guild/aio/factory/business/holder/msglist/scrollers/a;", "scrollDispatcher", "com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$f", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$f;", "mAction", "com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$g", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$g;", "mActionR", "Lkotlin/Pair;", "T", "Ljava/util/List;", "messageList", "U", "messageRList", "com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$h", "V", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$h;", "onThemeChanged", "<init>", "(Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$c;Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$a;)V", "W", "a", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgListDataVM extends MsgListVMWrapper<at.b, MsgListUiState> implements LifecycleObserver {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c repoProvider;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final a extraParamProvider;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a topAIOMsg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a bottomAIOMsg;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final FlowEventReceiver eventReceiver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpsObserver;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean handleFirstPageDelayed;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final HashSet<Long> pendingHighLightMsgSeqSet;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Long lastLogDisplayMsgSeqFirstSeq;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Long lastLogAioFirstRecMsgSeq;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean hasGetChannelEventFlow;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<Long> visibleIds;

    /* renamed from: P, reason: from kotlin metadata */
    private long mNewMsgLineSeq;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.factory.business.holder.msglist.scrollers.a scrollDispatcher;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final f mAction;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final g mActionR;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, f>> messageList;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, g>> messageRList;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final h onThemeChanged;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$a;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/os/Bundle;", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface a {
        @Nullable
        Bundle a(@NotNull com.tencent.aio.api.runtime.a aioContext);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$b;", "", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$c;", "g", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$a;", "e", "", "DEFAULT_PAGE_SIZE", "I", "DEFAULT_PRE_PAGE_SIZE", "", "DELAY_GET_CHANNEL_EVENT", "J", "GET_CHANNEL_EVENT_TIMEOUT", "", "INTENT_SOURCE", "Ljava/lang/String;", "LOAD_LOCAL_MSG_SIZE", "TAG", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM$b, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$b$a", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/v;", "", "msgSeq", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM$b$a */
        /* loaded from: classes6.dex */
        public static final class a implements v {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.aio.api.runtime.a f110397a;

            a(com.tencent.aio.api.runtime.a aVar) {
                this.f110397a = aVar;
            }

            @Override // com.tencent.guild.aio.factory.business.holder.msglist.data.guild.v
            public void a(long msgSeq) {
                this.f110397a.e().h(new BeforeNavigateToMsgEvent("GuildMsgListDataVM", msgSeq));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final a e() {
            return new a() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.g
                @Override // com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM.a
                public final Bundle a(com.tencent.aio.api.runtime.a aVar) {
                    Bundle f16;
                    f16 = GuildMsgListDataVM.Companion.f(aVar);
                    return f16;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Bundle f(com.tencent.aio.api.runtime.a it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final c g() {
            return new c() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.f
                @Override // com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM.c
                public final MsgListRepo a(com.tencent.aio.api.runtime.a aVar, CoroutineScope coroutineScope) {
                    MsgListRepo h16;
                    h16 = GuildMsgListDataVM.Companion.h(aVar, coroutineScope);
                    return h16;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MsgListRepo h(com.tencent.aio.api.runtime.a aioContext, CoroutineScope coroutineScope) {
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f fVar;
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            GuildMsgListRepo guildMsgListRepo = new GuildMsgListRepo(aioContext, coroutineScope);
            IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
            AIOParam g16 = aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g16);
            AIOParam g17 = aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
            if (iGuildChannelApi.isSelfGuest(b16, com.tencent.guild.aio.util.a.g(g17))) {
                fVar = new GuildGuestMsgRepoDelegate(guildMsgListRepo);
            } else {
                GuildMsgRepoDelegate guildMsgRepoDelegate = new GuildMsgRepoDelegate(guildMsgListRepo);
                guildMsgRepoDelegate.a0(new a(aioContext));
                fVar = guildMsgRepoDelegate;
            }
            guildMsgListRepo.Y(fVar);
            return guildMsgListRepo;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$c;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public interface c {
        @NotNull
        MsgListRepo a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope coroutineScope);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$d", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "type", "", "e", "guildId", "onMemberTopRoleChanged", "onUserDisplayNameUpdate", "onGuildMemberClientIdentityUpdate", "onUserLevelRoleIdChanged", "userMedalUrl", "onGuildUserMedalsUpdated", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends GPServiceObserver {
        d() {
        }

        private final void e(final String tinyId, final int type) {
            zs.a a16 = zs.b.a(Dispatchers.INSTANCE);
            final GuildMsgListDataVM guildMsgListDataVM = GuildMsgListDataVM.this;
            a.C11711a.b(a16, new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgListDataVM.d.f(GuildMsgListDataVM.this, tinyId, type);
                }
            }, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(GuildMsgListDataVM this$0, String tinyId, int i3) {
            GuildMsgItem guildMsgItem;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
            List<com.tencent.aio.data.msglist.a> l3 = this$0.l();
            if (!TypeIntrinsics.isMutableList(l3)) {
                l3 = null;
            }
            if (l3 != null) {
                int i16 = 0;
                for (Object obj : l3) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
                    if (aVar instanceof GuildMsgItem) {
                        guildMsgItem = (GuildMsgItem) aVar;
                    } else {
                        guildMsgItem = null;
                    }
                    if (guildMsgItem != null && Intrinsics.areEqual(guildMsgItem.getMsgRecord().senderUid, tinyId)) {
                        com.tencent.aio.data.msglist.a cloneNewInstance = guildMsgItem.cloneNewInstance();
                        Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                        GuildMsgItem guildMsgItem2 = (GuildMsgItem) cloneNewInstance;
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    guildMsgItem2.getPreParseInfo().j(null);
                                }
                            } else {
                                guildMsgItem2.getPreParseInfo().o(null);
                                guildMsgItem2.getPreParseInfo().l(null);
                            }
                        } else {
                            guildMsgItem2.getPreParseInfo().m(null);
                        }
                        l3.set(i16, guildMsgItem2);
                    }
                    i16 = i17;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildMemberClientIdentityUpdate(@Nullable String guildId, @Nullable String tinyId) {
            if (tinyId != null) {
                GuildMsgListDataVM guildMsgListDataVM = GuildMsgListDataVM.this;
                e(tinyId, 3);
                ((com.tencent.aio.api.runtime.a) guildMsgListDataVM.getMContext()).e().h(new GuildMsgListIntent.GuildRefreshNickEvent(3, tinyId));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildUserMedalsUpdated(@Nullable String tinyId, @Nullable String userMedalUrl) {
            if (tinyId != null) {
                ((com.tencent.aio.api.runtime.a) GuildMsgListDataVM.this.getMContext()).e().h(new GuildMsgListIntent.GuildRefreshNickEvent(5, tinyId));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onMemberTopRoleChanged(@Nullable String guildId, @Nullable String tinyId) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildMsgListDataVM.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("GuildMsgListDataVM", 4, "onMemberTopRoleChanged. tinyId: " + tinyId + ", guildId: " + guildId);
                }
                if (tinyId != null) {
                    GuildMsgListDataVM guildMsgListDataVM = GuildMsgListDataVM.this;
                    up0.a.f439407a.h("TAG_MEMBER_ROLE_CACHE", com.tencent.guild.aio.util.h.f112401a.y(tinyId, ((com.tencent.aio.api.runtime.a) guildMsgListDataVM.getMContext()).g().r().c().j()));
                    e(tinyId, 2);
                    ((com.tencent.aio.api.runtime.a) guildMsgListDataVM.getMContext()).e().h(new GuildMsgListIntent.GuildRefreshNickEvent(2, tinyId));
                    ((com.tencent.aio.api.runtime.a) guildMsgListDataVM.getMContext()).e().h(new GuildMsgListIntent.GuildRefreshNickEvent(4, tinyId));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            if (tinyId != null) {
                GuildMsgListDataVM guildMsgListDataVM = GuildMsgListDataVM.this;
                e(tinyId, 1);
                ((com.tencent.aio.api.runtime.a) guildMsgListDataVM.getMContext()).e().h(new GuildRefreshReplyNickEvent(tinyId));
                ((com.tencent.aio.api.runtime.a) guildMsgListDataVM.getMContext()).e().h(new GuildMsgListIntent.GuildRefreshNickEvent(1, tinyId));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserLevelRoleIdChanged(@Nullable String guildId, @Nullable String tinyId) {
            if (tinyId != null) {
                ((com.tencent.aio.api.runtime.a) GuildMsgListDataVM.this.getMContext()).e().h(new GuildMsgListIntent.GuildRefreshNickEvent(4, tinyId));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$e", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "lastMsg", "firstMsg", "", "b", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual(r6, r1) == false) goto L14;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Object firstOrNull;
            Long l3;
            Object firstOrNull2;
            Long l16;
            Long l17;
            Object firstOrNull3;
            Long l18;
            Object first;
            Object first2;
            Long l19;
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            Long l26 = GuildMsgListDataVM.this.lastLogDisplayMsgSeqFirstSeq;
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) displayList);
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            Long l27 = null;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.getMsgSeq());
            } else {
                l3 = null;
            }
            if (Intrinsics.areEqual(l26, l3)) {
                Long l28 = GuildMsgListDataVM.this.lastLogAioFirstRecMsgSeq;
                com.tencent.aio.data.msglist.a a16 = GuildMsgListDataVM.this.m().E().a();
                if (a16 != null) {
                    l19 = Long.valueOf(a16.getMsgSeq());
                } else {
                    l19 = null;
                }
            }
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) displayList);
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) firstOrNull2;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.getMsgSeq());
            } else {
                l16 = null;
            }
            com.tencent.aio.data.msglist.a a17 = GuildMsgListDataVM.this.m().E().a();
            if (a17 != null) {
                l17 = Long.valueOf(a17.getMsgSeq());
            } else {
                l17 = null;
            }
            QLog.i("GuildMsgListDataVM", 1, "enableRefresh, firstDisplayMsgSeq = " + l16 + ", aioFirstRecMsg = " + l17);
            GuildMsgListDataVM guildMsgListDataVM = GuildMsgListDataVM.this;
            firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) displayList);
            com.tencent.aio.data.msglist.a aVar3 = (com.tencent.aio.data.msglist.a) firstOrNull3;
            if (aVar3 != null) {
                l18 = Long.valueOf(aVar3.getMsgSeq());
            } else {
                l18 = null;
            }
            guildMsgListDataVM.lastLogDisplayMsgSeqFirstSeq = l18;
            GuildMsgListDataVM guildMsgListDataVM2 = GuildMsgListDataVM.this;
            com.tencent.aio.data.msglist.a a18 = guildMsgListDataVM2.m().E().a();
            if (a18 != null) {
                l27 = Long.valueOf(a18.getMsgSeq());
            }
            guildMsgListDataVM2.lastLogAioFirstRecMsgSeq = l27;
            if (Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) GuildMsgListDataVM.this.getMContext()).g().n(), com.tencent.guild.aio.factory.a.class.getName()) && displayList.isEmpty()) {
                if (GuildMsgListDataVM.this.m().E().a() != null) {
                    com.tencent.aio.data.msglist.a a19 = GuildMsgListDataVM.this.m().E().a();
                    Intrinsics.checkNotNull(a19);
                    if (a19.getMsgSeq() > 1) {
                        return true;
                    }
                }
            } else if (!displayList.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
                if (!(first instanceof GuildWelcomeMsgItem)) {
                    first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
                    if (((com.tencent.aio.data.msglist.a) first2).getMsgSeq() > 1 && GuildMsgListDataVM.this.m().E().a() != null) {
                        com.tencent.aio.data.msglist.a a26 = GuildMsgListDataVM.this.m().E().a();
                        Intrinsics.checkNotNull(a26);
                        if (a26.getMsgSeq() > 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
        public boolean b(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
            Long l3;
            Object lastOrNull;
            Object last;
            Intrinsics.checkNotNullParameter(displayList, "displayList");
            Long l16 = null;
            if (lastMsg != null) {
                l3 = Long.valueOf(lastMsg.getMsgSeq());
            } else {
                l3 = null;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) displayList);
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar != null) {
                l16 = Long.valueOf(aVar.getMsgSeq());
            }
            QLog.i("GuildMsgListDataVM", 1, "enableLoadMore, lastMsgSeq = " + l3 + ", lastDisplayMsgSeq = " + l16);
            if ((!displayList.isEmpty()) && lastMsg != null) {
                long msgSeq = lastMsg.getMsgSeq();
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
                if (msgSeq > ((com.tencent.aio.data.msglist.a) last).getMsgSeq()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$f", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f implements com.tencent.mvi.base.route.a {
        f() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildMsgListDataVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$g", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g implements com.tencent.mvi.base.route.b {
        g() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildMsgListDataVM.this.I(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVM$h", "Lor0/a;", "", "onThemeChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class h implements or0.a {
        h() {
        }

        @Override // or0.a
        public void onThemeChanged() {
            if (QLog.isColorLevel()) {
                QLog.i("GuildMsgListDataVM", 2, "[onThemeChanged] ");
            }
            GuildMsgListDataVM.this.updateUI(GuildMsgListViewState.GuildOnThemeChanged.f110457d);
        }
    }

    public GuildMsgListDataVM() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A0() {
        Object lastOrNull;
        Long l3;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) l());
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
        Long l16 = null;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        com.tencent.aio.data.msglist.a H = m().H();
        if (H != null) {
            l16 = Long.valueOf(H.getMsgSeq());
        }
        if (Intrinsics.areEqual(l3, l16)) {
            IGuildSpeakThresholdApi iGuildSpeakThresholdApi = (IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
            if (iGuildSpeakThresholdApi.canEnableKeyboard(g17, com.tencent.guild.aio.util.a.b(g18))) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildMsgListDataVM"));
            }
        }
    }

    private final void B0() {
        if (this.mNewMsgLineSeq <= 0) {
            return;
        }
        String selfTid = ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId();
        long j3 = this.mNewMsgLineSeq;
        Intrinsics.checkNotNullExpressionValue(selfTid, "selfTid");
        updateUI(new HighLightUnreadAtMsgState(j3, selfTid));
    }

    private final boolean C0(GuildMsgItem msg2) {
        if (msg2 == null || !qr0.d.i(msg2)) {
            return false;
        }
        return true;
    }

    private final boolean D0(com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        return ((GuildMsgItem) msgItem).isMixMsg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            M0(this, true, null, 2, null);
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMsgListRefreshEvent) {
            L0(true, ((GuildMsgListIntent.GuildMsgListRefreshEvent) i3).a());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildInputBarHeightChangEvent) {
            p0(((GuildMsgListIntent.GuildInputBarHeightChangEvent) i3).getHeight());
            return;
        }
        if (i3 instanceof AIOTopHeightChangedEvent) {
            s0(((AIOTopHeightChangedEvent) i3).getHeight());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMsgItemContentViewClickEvent) {
            r0((GuildMsgListIntent.GuildMsgItemContentViewClickEvent) i3);
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMsgListTopMarginUpdateEvent) {
            s0(((GuildMsgListIntent.GuildMsgListTopMarginUpdateEvent) i3).getTopMargin());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.NavigateToDeletedMsgEvent) {
            t0();
            return;
        }
        if (i3 instanceof BeforeNavigateToMsgEvent) {
            i0((BeforeNavigateToMsgEvent) i3);
            return;
        }
        if (i3 instanceof GuildMsgListIntent.UpdateReeditRecallMsgListEvent) {
            w0(((GuildMsgListIntent.UpdateReeditRecallMsgListEvent) i3).getMsgRecord());
            return;
        }
        if (i3 instanceof MFGestureListIntent.NotifyEvent) {
            q0(((MFGestureListIntent.NotifyEvent) i3).getNotifyData());
            return;
        }
        if (i3 instanceof GuildMsgResendStatusIntent) {
            x0(((GuildMsgResendStatusIntent) i3).getMsgId(), 1);
            return;
        }
        if (i3 instanceof GuildMsgSendEvent.CancelSendVideoMsg) {
            x0(((GuildMsgSendEvent.CancelSendVideoMsg) i3).getMsgId(), 0);
        } else if (i3 instanceof GuildMsgListIntent.HandleFirstPageDelayed) {
            this.handleFirstPageDelayed = true;
        } else if (i3 instanceof GuildMsgListIntent.LoadFirstPageFinEvent) {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), Dispatchers.getMain(), null, new GuildMsgListDataVM$handleAction$1(this, null), 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void E0(MsgRecord msgRecord) {
        Fragment c16;
        FragmentActivity activity;
        if (MsgExtKt.R(msgRecord) && MsgExtKt.U(msgRecord) && (c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c()) != null && (activity = c16.getActivity()) != null) {
            Contact contact = new Contact();
            contact.peerUid = msgRecord.peerUid;
            contact.guildId = msgRecord.guildId;
            in0.c.c(activity, contact, msgRecord.msgSeq, null, (com.tencent.aio.api.runtime.a) getMContext(), 0, 32, null);
        }
    }

    private final void F0() {
        com.tencent.aio.data.msglist.a aVar;
        Object firstOrNull;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (l3 != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) l3);
            aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
        } else {
            aVar = null;
        }
        boolean z16 = aVar instanceof GuildWelcomeMsgItem;
        QLog.i("GuildMsgListDataVM", 1, "loadPrePageIfNeed, disable = " + z16);
        if (z16) {
            W0();
        } else {
            m().x();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean G0() {
        return Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) getMContext()).g().n(), com.tencent.guild.aio.factory.a.class.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean H0(com.tencent.aio.data.msglist.a msgItem) {
        if ((msgItem instanceof GuildMsgItem) && com.tencent.guild.api.data.msglist.a.b((GuildMsgItem) msgItem) && msgItem.getMsgSeq() == this.mNewMsgLineSeq) {
            IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g16);
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (!iGuildChannelApi.isSelfGuest(b16, com.tencent.guild.aio.util.a.g(g17)) && msgItem.getMsgSeq() > 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GetAIOTopMsgEvent) {
            return new i.d(this.topAIOMsg);
        }
        if (i3 instanceof GuildMsgListIntent.GetAIOBottomMsgEvent) {
            com.tencent.aio.data.msglist.a aVar = this.bottomAIOMsg;
            if (aVar == null) {
                aVar = m().H();
            }
            return new i.a(aVar);
        }
        if (i3 instanceof GuildMsgListIntent.GetAIOExtremalMsgEvent) {
            return j0();
        }
        if (i3 instanceof GuildMsgListIntent.GetAIORichMediaMsgListEvent) {
            return new i.c(h0(((GuildMsgListIntent.GetAIORichMediaMsgListEvent) i3).getMsgRecord()));
        }
        if (i3 instanceof GuildMsgListIntent.GetLastMsgPosEvent) {
            return l0();
        }
        if (i3 instanceof GuildMsgListIntent.GetSkeletonState) {
            return m0();
        }
        return pn0.b.f426490a;
    }

    private final void I0(FileTransNotifyInfo fileInfo) {
        QLog.d("GuildMsgListDataVM", 1, "onRichMediaDownloadComplete fileInfo: " + fileInfo);
        y0(fileInfo);
    }

    private final void J0(FileTransNotifyInfo fileInfo) {
        QLog.d("GuildMsgListDataVM", 1, "onRichMediaDownloadProgressUpdate fileInfo: " + fileInfo);
        y0(fileInfo);
    }

    private final void K0(FileTransNotifyInfo fileInfo) {
        QLog.d("GuildMsgListDataVM", 1, "onRichMediaUploadComplete fileInfo: " + fileInfo);
        y0(fileInfo);
    }

    private final void L0(boolean forceUpdate, List<Object> payloads) {
        X0(forceUpdate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void M0(GuildMsgListDataVM guildMsgListDataVM, boolean z16, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            list = new ArrayList();
        }
        guildMsgListDataVM.L0(z16, list);
    }

    private final void N0() {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListDataVM.P0(GuildMsgListDataVM.this);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(GuildMsgListDataVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<com.tencent.aio.data.msglist.a> l3 = this$0.l();
        if (!l3.isEmpty()) {
            if (!TypeIntrinsics.isMutableList(l3)) {
                l3 = null;
            }
            if (l3 != null) {
                this$0.Q0(l3);
            }
            this$0.W0();
        }
    }

    private final void Q0(List<com.tencent.aio.data.msglist.a> msgItems) {
        GuildMsgItem guildMsgItem;
        int i3 = 0;
        boolean z16 = false;
        for (Object obj : msgItems) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            if (aVar instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) aVar;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem == null) {
                return;
            }
            if (!z16 && H0(guildMsgItem)) {
                com.tencent.aio.data.msglist.a cloneNewInstance = aVar.cloneNewInstance();
                Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                GuildMsgItem guildMsgItem2 = (GuildMsgItem) cloneNewInstance;
                guildMsgItem2.saveExtInfoToExtStr("guild_first_unread_msg_seq_json_key", "1");
                guildMsgItem2.setIsNeedCombine(false);
                guildMsgItem2.setIsLastMsgNeedCombine(false);
                Logger.f235387a.d().i("GuildMsgListDataVM", 1, "setFirstUnreadExt by refreshNewMsgLine " + this.mNewMsgLineSeq);
                msgItems.set(i3, guildMsgItem2);
                z16 = true;
            } else if (!Intrinsics.areEqual(guildMsgItem.getExtInfoFromExtStr("guild_first_unread_msg_seq_json_key", "0"), "0")) {
                com.tencent.aio.data.msglist.a cloneNewInstance2 = aVar.cloneNewInstance();
                Intrinsics.checkNotNull(cloneNewInstance2, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                GuildMsgItem guildMsgItem3 = (GuildMsgItem) cloneNewInstance2;
                guildMsgItem3.saveExtInfoToExtStr("guild_first_unread_msg_seq_json_key", "0");
                msgItems.set(i3, guildMsgItem3);
            }
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object R0(GuildMsgListDataVM guildMsgListDataVM, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildMsgListDataVM.I0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object S0(GuildMsgListDataVM guildMsgListDataVM, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildMsgListDataVM.J0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object T0(GuildMsgListDataVM guildMsgListDataVM, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildMsgListDataVM.K0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U0(Bundle extra) {
        if (extra == null) {
            return;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).g().l().putAll(extra);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void V0(GuildMsgItem msgItem, View clickedView) {
        boolean z16;
        QLog.i("GuildMsgListDataVM", 4, "showMarketFacePreview");
        MarketFaceElement a16 = qr0.d.a(msgItem);
        if (clickedView != null && a16 != null) {
            QLog.i("GuildMsgListDataVM", 4, "showEmoPreview===");
            if (((com.tencent.aio.api.runtime.a) getMContext()).g().l().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            IGuildEmoPreviewApi iGuildEmoPreviewApi = (IGuildEmoPreviewApi) QRoute.api(IGuildEmoPreviewApi.class);
            long msgId = msgItem.getMsgId();
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g16);
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            iGuildEmoPreviewApi.showEmoPreview(clickedView, a16, msgId, b16, com.tencent.guild.aio.util.a.g(g17), z16);
        }
    }

    private final void X0(boolean force) {
        updateUI(new GuildMsgListDataState(l(), force, m().H(), v(3), null, 16, null));
    }

    private final GPServiceObserver a0() {
        return new d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b0(String source, GuildMsgItem aioTopMsg, GuildMsgItem aioBottomMsg) {
        this.topAIOMsg = aioTopMsg;
        this.bottomAIOMsg = aioBottomMsg;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListScrollEvent(source, aioTopMsg, aioBottomMsg, (GuildMsgItem) m().H()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c0() {
        uh2.c gProGuildMsgService = ((IGProSession) bz.b(IGProSession.class)).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getFirstUnreadCommonMsg(l.f112634a.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r()), new IGuildFetchChannelLatestSeqCallback() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.d
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildFetchChannelLatestSeqCallback
                public final void onFetchChannelLatestSeq(int i3, String str, long j3) {
                    GuildMsgListDataVM.d0(GuildMsgListDataVM.this, i3, str, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(GuildMsgListDataVM this$0, int i3, String str, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildMsgListDataVM", 1, "fetchNewMsgLineSeq: ret:" + i3 + " err:" + str + " v:" + j3);
        if (i3 != 0) {
            j3 = 0;
        }
        this$0.mNewMsgLineSeq = j3;
        this$0.N0();
        this$0.B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(com.tencent.aio.api.runtime.a context, String tag) {
        if (!this.hasGetChannelEventFlow) {
            j.f110625a.a(context);
            this.hasGetChannelEventFlow = true;
            QLog.i("GuildMsgListDataVM", 1, "getChannelEventFlow TAG:" + tag);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(GuildMsgListIntent.GetLatestDbMsgsEvent.f110412d);
    }

    private final List<MsgRecord> h0(MsgRecord msgRecord) {
        GuildMsgItem guildMsgItem;
        MsgRecord msgRecord2;
        GuildMsgItem guildMsgItem2;
        MsgRecord msgRecord3;
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = msgRecord.channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.channelId");
        String str2 = msgRecord.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.guildId");
        if (iGuildChannelApi.isSelfGuest(str, str2)) {
            List<com.tencent.aio.data.msglist.a> l3 = l();
            ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
            for (Object obj : l3) {
                if (j.f110625a.c((com.tencent.aio.data.msglist.a) obj, false)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.aio.data.msglist.a aVar : arrayList) {
                if (aVar instanceof GuildMsgItem) {
                    guildMsgItem2 = (GuildMsgItem) aVar;
                } else {
                    guildMsgItem2 = null;
                }
                if (guildMsgItem2 != null) {
                    msgRecord3 = guildMsgItem2.getMsgRecord();
                } else {
                    msgRecord3 = null;
                }
                if (msgRecord3 != null) {
                    arrayList2.add(msgRecord3);
                }
            }
            return arrayList2;
        }
        List<com.tencent.aio.data.msglist.a> l16 = l();
        ArrayList<com.tencent.aio.data.msglist.a> arrayList3 = new ArrayList();
        for (Object obj2 : l16) {
            if (j.f110625a.c((com.tencent.aio.data.msglist.a) obj2, true)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (com.tencent.aio.data.msglist.a aVar2 : arrayList3) {
            if (aVar2 instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) aVar2;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem != null) {
                msgRecord2 = guildMsgItem.getMsgRecord();
            } else {
                msgRecord2 = null;
            }
            if (msgRecord2 != null) {
                arrayList4.add(msgRecord2);
            }
        }
        return arrayList4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(BeforeNavigateToMsgEvent event) {
        QLog.i("GuildMsgListDataVM", 1, "handleBeforeNavigateToMsg | eventSourceTag=" + event.getSourceTag() + ", msgSeq=" + event.getMsgSeq());
        this.pendingHighLightMsgSeqSet.add(Long.valueOf(event.getMsgSeq()));
    }

    private final com.tencent.mvi.base.route.k j0() {
        Long l3;
        Long l16;
        Long l17;
        com.tencent.mvi.api.ability.e fetchVBState = fetchVBState(k.a.f110626a);
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) fetchVBState.b().getSerializable("aio_top_msg");
        com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) fetchVBState.b().getSerializable("aio_bottom_msg");
        com.tencent.aio.data.msglist.a H = m().H();
        Long l18 = null;
        if (aVar2 != null) {
            l3 = Long.valueOf(aVar2.getMsgSeq());
        } else {
            l3 = null;
        }
        if (aVar2 != null) {
            l16 = Long.valueOf(aVar2.getMsgId());
        } else {
            l16 = null;
        }
        if (H != null) {
            l17 = Long.valueOf(H.getMsgSeq());
        } else {
            l17 = null;
        }
        if (H != null) {
            l18 = Long.valueOf(H.getMsgId());
        }
        QLog.i("GuildMsgListDataVM", 1, "handleGetAIOLatestAndBottomMsgResult, bottomMsg seq = " + l3 + ", id = " + l16 + ", latestMsg seq = " + l17 + ", id = " + l18);
        return new i.b(aVar, aVar2, H);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k0(com.tencent.aio.api.runtime.a context) {
        i.e eVar;
        boolean z16;
        if (!Intrinsics.areEqual(((com.tencent.aio.api.runtime.a) getMContext()).g().n(), com.tencent.guild.aio.factory.a.class.getName())) {
            e0(context, "otherFactory");
            return;
        }
        com.tencent.mvi.base.route.k k3 = context.e().k(GuildMsgListIntent.GetLoadFirstPageFin.f110413d);
        if (k3 instanceof i.e) {
            eVar = (i.e) k3;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            z16 = eVar.getResult();
        } else {
            z16 = true;
        }
        if (z16) {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), Dispatchers.getMain(), null, new GuildMsgListDataVM$handleGetChannelEventFlow$1(this, context, null), 2, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), Dispatchers.getMain(), null, new GuildMsgListDataVM$handleGetChannelEventFlow$2(this, context, null), 2, null);
        }
    }

    private final com.tencent.mvi.base.route.k l0() {
        com.tencent.mvi.api.ability.e fetchVBState = fetchVBState(new k.b(l().size() - 1));
        return new i.f(new Rect(fetchVBState.b().getInt("left", 0), fetchVBState.b().getInt("top", 0), fetchVBState.b().getInt("right", 0), fetchVBState.b().getInt("bottom", 0)));
    }

    private final com.tencent.mvi.base.route.k m0() {
        boolean z16 = fetchVBState(k.c.f110628a).b().getBoolean("is_skeleton_showing", false);
        boolean isEmpty = l().isEmpty();
        QLog.i("GuildMsgListDataVM", 1, "handleGetSkeletonState, isShowing " + z16 + ", isDisplayListEmpty: " + isEmpty);
        return new i.g(z16, isEmpty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n0() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildMsgListDataVM", false, 2, null));
    }

    private final void o0(int position, View itemView) {
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (l3 == null) {
            l3 = new CopyOnWriteArrayList<>();
        }
        if (l3.size() > position) {
            long msgSeq = l3.get(position).getMsgSeq();
            if (!this.pendingHighLightMsgSeqSet.contains(Long.valueOf(msgSeq))) {
                return;
            }
            QLog.i("GuildMsgListDataVM", 1, "handleHighLightViewHolder|msgSeq=" + msgSeq);
            com.tencent.aio.data.msglist.a aVar = l3.get(position);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            updateUI(new HighLightViewHolderUIState(position, ((GuildMsgItem) aVar).getMsgRecord(), 0, new Bundle(), itemView));
            this.pendingHighLightMsgSeqSet.remove(Long.valueOf(msgSeq));
        }
    }

    private final void p0(int height) {
        updateUI(new GuildMsgListViewState.GuildInputBarHeightChangeDataState(height));
    }

    private final void q0(rr1.i notifyData) {
        u0(notifyData);
    }

    private final void r0(GuildMsgListIntent.GuildMsgItemContentViewClickEvent event) {
        GuildMsgItem guildMsgItem;
        com.tencent.aio.data.msglist.a msgItem = event.getMsgItem();
        QLog.i("GuildMsgListDataVM", 4, "handleMsgBubbleClick type=" + msgItem.getViewType());
        if (D0(msgItem)) {
            Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            E0(((GuildMsgItem) msgItem).getMsgRecord());
            return;
        }
        if (msgItem instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msgItem;
        } else {
            guildMsgItem = null;
        }
        if (C0(guildMsgItem)) {
            Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            V0((GuildMsgItem) msgItem, event.getMsgBubbleView());
        }
    }

    private final void s0(int topMargin) {
        updateUI(new GuildMsgListViewState.GuildMsgListTopMarginChangeState(topMargin));
    }

    private final void t0() {
        com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f152991aw);
    }

    private final void u0(rr1.i notifyData) {
        if ((notifyData.f() == 3 && notifyData.c() == 3 && notifyData.a() == 1) || (notifyData.f() == 1 && notifyData.d() == 2 && notifyData.a() == 3)) {
            c0();
        }
    }

    private final void w0(MsgRecord msgRecord) {
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if ((!l3.isEmpty()) && l3.size() > 0) {
            Iterator<com.tencent.aio.data.msglist.a> it = l3.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i16 = i3 + 1;
                if (it.next().getMsgId() == msgRecord.msgId) {
                    updateUI(new GuildMsgListViewState.GuildMsgItemChangedState(i3));
                    return;
                }
                i3 = i16;
            }
        }
    }

    private final void x0(long msgId, int msgStatus) {
        GuildMsgItem guildMsgItem;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (!TypeIntrinsics.isMutableList(l3)) {
            l3 = null;
        }
        if (l3 != null) {
            boolean z16 = false;
            int i3 = 0;
            for (Object obj : l3) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
                if (aVar.getMsgId() == msgId) {
                    if (aVar instanceof GuildMsgItem) {
                        guildMsgItem = (GuildMsgItem) aVar;
                    } else {
                        guildMsgItem = null;
                    }
                    if (guildMsgItem == null) {
                        return;
                    }
                    com.tencent.aio.data.msglist.a cloneNewInstanceWithMsgRecord = guildMsgItem.cloneNewInstanceWithMsgRecord(qr0.e.a(((GuildMsgItem) aVar).getMsgRecord(), msgStatus));
                    Intrinsics.checkNotNull(cloneNewInstanceWithMsgRecord, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                    l3.set(i3, (GuildMsgItem) cloneNewInstanceWithMsgRecord);
                    z16 = true;
                }
                i3 = i16;
            }
            if (z16) {
                Q0(l3);
                W0();
            }
        }
    }

    private final void y0(FileTransNotifyInfo fileInfo) {
        GuildMsgItem guildMsgItem;
        List<com.tencent.aio.data.msglist.a> l3 = l();
        if (!TypeIntrinsics.isMutableList(l3)) {
            l3 = null;
        }
        if (l3 != null) {
            boolean z16 = false;
            int i3 = 0;
            for (Object obj : l3) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
                if (aVar.getMsgId() == fileInfo.msgId) {
                    if (aVar instanceof GuildMsgItem) {
                        guildMsgItem = (GuildMsgItem) aVar;
                    } else {
                        guildMsgItem = null;
                    }
                    if (guildMsgItem == null) {
                        return;
                    }
                    com.tencent.aio.data.msglist.a cloneNewInstance = guildMsgItem.cloneNewInstance();
                    Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                    GuildMsgItem guildMsgItem2 = (GuildMsgItem) cloneNewInstance;
                    guildMsgItem2.setFileTransNotifyInfo(fileInfo);
                    l3.set(i3, guildMsgItem2);
                    z16 = true;
                }
                i3 = i16;
            }
            if (z16) {
                Q0(l3);
                W0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z0(a.g intent) {
        if (intent.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.SCROLL_STATE java.lang.String() == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(intent.getFirstPosition(), intent.getLastPosition(), new CopyOnWriteArrayList(l())));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d F() {
        return new e();
    }

    public final void W0() {
        X0(false);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper
    @Nullable
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public GuildMsgListDataState D(@NotNull MsgListUiState implState) {
        Intrinsics.checkNotNullParameter(implState, "implState");
        if (implState instanceof MsgListState) {
            MsgListState msgListState = (MsgListState) implState;
            return new GuildMsgListDataState((Collection) implState, false, m().H(), msgListState.getUpdateType(), msgListState.getExtra());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final MsgListRepo Z() {
        return this.repoProvider.a((com.tencent.aio.api.runtime.a) getMContext(), vmScope());
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.c
    public void b(@NotNull MsgListUiState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MsgListState) {
            Q0((List) state);
        }
        super.b(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull at.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof MsgListIntent.a) {
            p((MsgListIntent.a) intent);
            return;
        }
        if (intent instanceof a.d) {
            w();
            return;
        }
        if (intent instanceof a.b) {
            m().v(((a.b) intent).a());
            return;
        }
        if (intent instanceof a.c) {
            F0();
            return;
        }
        if (intent instanceof a.C0640a) {
            m().w();
            return;
        }
        if (intent instanceof a.q) {
            g0();
            return;
        }
        if (intent instanceof a.t) {
            if (((com.tencent.aio.api.runtime.a) getMContext()).g().l().getBoolean("no_need_new_msg_line")) {
                return;
            }
            c0();
            return;
        }
        if (intent instanceof a.C1186a) {
            n0();
            return;
        }
        if (intent instanceof a.l) {
            A0();
            return;
        }
        if (intent instanceof bq0.c) {
            bq0.c cVar = (bq0.c) intent;
            o0(cVar.getPosition(), cVar.getItemView());
            return;
        }
        if (intent instanceof a.f) {
            com.tencent.guild.aio.factory.business.holder.msglist.scrollers.a aVar = this.scrollDispatcher;
            Function1<com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d, Unit> a16 = ((a.f) intent).a();
            Iterator<T> it = aVar.a().iterator();
            while (it.hasNext()) {
                a16.invoke((com.tencent.guild.aio.factory.business.holder.msglist.scrollers.d) it.next());
            }
            return;
        }
        if (intent instanceof a.g) {
            z0((a.g) intent);
            return;
        }
        if (intent instanceof a.e) {
            ((a.e) intent).b(G0());
            return;
        }
        if (intent instanceof a.r) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(GuildMsgNavigateEvent.NavigateCompleteEvent.f112240d);
            return;
        }
        if (intent instanceof MsgListIntent.b) {
            s((MsgListIntent.b) intent);
            return;
        }
        if (intent instanceof a.v) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(GuildMsgListIntent.OnSkeletonLastEnoughTime.f110443d);
        } else if (intent instanceof a.SkeletonShow) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.OnSkeletonShow(((a.SkeletonShow) intent).getStartTime()));
        } else if (intent instanceof a.u) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(GuildMsgListIntent.OnSkeletonHide.f110442d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<T> it5 = this.messageRList.iterator();
        while (it5.hasNext()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().a((String) ((Pair) it5.next()).getFirst());
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        this.eventReceiver.d();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.gpsObserver);
        }
        up0.a.f439407a.c();
        this.handleFirstPageDelayed = false;
        this.pendingHighLightMsgSeqSet.clear();
        QQGuildThemeManager.d(this.onThemeChanged);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.i("GuildMsgListDataVM", 4, "onResume");
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void p(@NotNull MsgListIntent.a intent) {
        GuildMsgItem guildMsgItem;
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.p(intent);
        GuildMsgItem guildMsgItem2 = null;
        if (intent.b() instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) intent.b();
        } else {
            guildMsgItem = null;
        }
        if (intent.d() instanceof GuildMsgItem) {
            guildMsgItem2 = (GuildMsgItem) intent.d();
        }
        b0("GuildMsgListDataVM", guildMsgItem, guildMsgItem2);
        if (intent.e() == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(intent.a(), intent.c(), new CopyOnWriteArrayList(l())));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a
    public void w() {
        ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.D(), new GuildMsgListDataVM$registerMsgNotification$1(this)), Dispatchers.getIO()), vmScope());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.B(), new GuildMsgListDataVM$registerMsgNotification$2(this)), Dispatchers.getIO()), vmScope());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.C(), new GuildMsgListDataVM$registerMsgNotification$3(this)), Dispatchers.getIO()), vmScope());
    }

    public /* synthetic */ GuildMsgListDataVM(c cVar, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? INSTANCE.g() : cVar, (i3 & 2) != 0 ? INSTANCE.e() : aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        z(Z());
        U0(this.extraParamProvider.a((com.tencent.aio.api.runtime.a) getMContext()));
        super.onCreate(context);
        QLog.i("GuildMsgListDataVM", 1, "onCreate");
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            context.e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        Iterator<T> it5 = this.messageRList.iterator();
        while (it5.hasNext()) {
            Pair pair2 = (Pair) it5.next();
            context.e().j((String) pair2.getFirst(), (com.tencent.mvi.base.route.b) pair2.getSecond());
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.gpsObserver);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        this.eventReceiver.c(nq0.d.class, true, new GuildMsgListDataVM$onCreate$3(this, null));
        k0(context);
        QQGuildThemeManager.c(this.onThemeChanged);
    }

    public GuildMsgListDataVM(@NotNull c repoProvider, @NotNull a extraParamProvider) {
        List<Pair<String, f>> listOf;
        List<Pair<String, g>> listOf2;
        Intrinsics.checkNotNullParameter(repoProvider, "repoProvider");
        Intrinsics.checkNotNullParameter(extraParamProvider, "extraParamProvider");
        this.repoProvider = repoProvider;
        this.extraParamProvider = extraParamProvider;
        this.eventReceiver = new FlowEventReceiver(null, 1, null);
        this.gpsObserver = a0();
        this.pendingHighLightMsgSeqSet = new HashSet<>();
        this.lastLogDisplayMsgSeqFirstSeq = 0L;
        this.lastLogAioFirstRecMsgSeq = 0L;
        this.visibleIds = new CopyOnWriteArrayList<>();
        this.mNewMsgLineSeq = Long.MIN_VALUE;
        this.scrollDispatcher = new com.tencent.guild.aio.factory.business.holder.msglist.scrollers.a(this);
        f fVar = new f();
        this.mAction = fVar;
        g gVar = new g();
        this.mActionR = gVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListRefreshEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListTopMarginUpdateEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgItemContentViewClickEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(AIOTopHeightChangedEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.NavigateToDeletedMsgEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.UpdateReeditRecallMsgListEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgResendStatusIntent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.CancelSendVideoMsg.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.HandleFirstPageDelayed.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(BeforeNavigateToMsgEvent.class).getQualifiedName(), fVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.LoadFirstPageFinEvent.class).getQualifiedName(), fVar)});
        this.messageList = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.NewMsgLineMsgGet.class).getQualifiedName(), gVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetAIOTopMsgEvent.class).getQualifiedName(), gVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetAIOBottomMsgEvent.class).getQualifiedName(), gVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetAIORichMediaMsgListEvent.class).getQualifiedName(), gVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetLastMsgPosEvent.class).getQualifiedName(), gVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetAIOExtremalMsgEvent.class).getQualifiedName(), gVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetSkeletonState.class).getQualifiedName(), gVar)});
        this.messageRList = listOf2;
        this.onThemeChanged = new h();
    }
}
