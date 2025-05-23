package com.tencent.guild.aio.input.realinput;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.route.msg.InputMsg$InputEmojiMsg;
import com.tencent.aio.base.route.msg.InputMsg$ShowKeyboardMsg;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.aio.part.root.panel.mvx.result.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.activity.GuildChatActivityAbility;
import com.tencent.guild.aio.event.GuildAtPanelEvent;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleAvatarLongClickEvent;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgIntent;
import com.tencent.guild.aio.panel.photo.e;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.aio.util.flowbus.FlowEventReceiver;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.configuration.GuildConfigurationManager;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.input.GuildAioInputMsgIntent;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.guild.api.media.album.GuildAlbumMediaType;
import com.tencent.guild.api.media.album.GuildPickPhotoResult;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildConfigApi;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import fo0.e;
import fo0.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kr0.a;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007*\b\u0088\u0001\u008e\u0001\u0091\u0001\u0094\u0001\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0002\u0099\u0001B\u0011\u0012\u0006\u0010r\u001a\u00020o\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020\b2\u0006\u0010#\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0002J4\u00108\u001a\u00020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u000202012\f\u00105\u001a\b\u0012\u0004\u0012\u000204012\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0002J\u0010\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u00020\rH\u0002J\b\u0010;\u001a\u00020\bH\u0002J\u0010\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020<H\u0002J\b\u0010?\u001a\u00020<H\u0002J\b\u0010@\u001a\u00020\bH\u0002J\u0010\u0010B\u001a\u00020\b2\u0006\u0010\n\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020\bH\u0002J\u0010\u0010D\u001a\u00020\b2\u0006\u0010#\u001a\u00020%H\u0002J\u0010\u0010E\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010F\u001a\u00020\bH\u0002J\b\u0010G\u001a\u00020\bH\u0002J\u0018\u0010J\u001a\u00020.2\u0006\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020.H\u0002J\u0012\u0010L\u001a\u00020\b2\b\u0010K\u001a\u0004\u0018\u00010.H\u0002J\b\u0010M\u001a\u00020\rH\u0002J\b\u0010N\u001a\u00020\bH\u0002J\b\u0010O\u001a\u00020\bH\u0002J\b\u0010P\u001a\u00020\bH\u0002J\b\u0010Q\u001a\u00020\bH\u0002J\u0010\u0010R\u001a\u00020\b2\u0006\u0010\n\u001a\u000204H\u0002J\u0010\u0010T\u001a\u00020\b2\u0006\u0010\n\u001a\u00020SH\u0002J\"\u0010Y\u001a\u00020\b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020U012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010WH\u0002J\"\u0010Z\u001a\u00020\b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020U012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010WH\u0002J\u0016\u0010]\u001a\u00020\b2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020.0[H\u0002J\u0010\u0010^\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010`\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020_H\u0002J\u001e\u0010c\u001a\u00020\b2\u0006\u0010a\u001a\u00020<2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020'01H\u0002J\b\u0010d\u001a\u00020\bH\u0002J\u0010\u0010f\u001a\u00020\b2\u0006\u0010e\u001a\u00020\rH\u0002J\b\u0010g\u001a\u00020\bH\u0002J\u0010\u0010j\u001a\u00020\b2\u0006\u0010i\u001a\u00020hH\u0002J\b\u0010k\u001a\u00020\bH\u0002J\b\u0010l\u001a\u00020\bH\u0002J\u0010\u0010n\u001a\u00020W2\u0006\u0010m\u001a\u00020<H\u0002R\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010~\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u007fR!\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0085\u0001\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b:\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bP\u0010\u0086\u0001R\u0017\u0010\u008a\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b^\u0010\u0089\u0001R\u0017\u0010\u008d\u0001\u001a\u00030\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b?\u0010\u008c\u0001R\u0017\u0010\u0090\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bn\u0010\u008f\u0001R\u0017\u0010\u0093\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001a\u0010\u0092\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0095\u0001\u00a8\u0006\u009a\u0001"}, d2 = {"Lcom/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "onCreate", "intent", BdhLogUtil.LogTag.Tag_Req, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "i0", "g0", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "U", "action", "T", "Lcom/tencent/aio/part/root/panel/mvx/intent/PanelStatusIntent$PanelStatusChangeIntent;", "W", "Lcom/tencent/guild/aio/activity/GuildChatActivityAbility$ActivityResultIntent;", "H", NodeProps.ENABLED, "G0", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent$SelectMediaChanged;", "c0", "Lrr1/i;", "notifyData", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "N", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "O", "Lcom/tencent/aio/data/msglist/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/aio/base/route/msg/InputMsg$InputEmojiMsg;", "M", "Lcom/tencent/guild/aio/event/GuildAtPanelEvent;", "atPanelEvent", "J", "", "path", "w0", "", "Lcom/tencent/guild/api/media/album/d;", "mediaList", "Lfo0/e$l;", "textList", "needClearMedia", "fromCamera", "x0", "clearReply", BdhLogUtil.LogTag.Tag_Conn, "o0", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "p0", UserInfo.SEX_FEMALE, "K", "Lfo0/e$e;", "l0", "b0", "a0", "L", "h0", "Y", "uid", "guildID", "q0", "tinyId", "e0", "B", "F0", "r0", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D0", "Lfo0/e$k;", "C0", "Lsr0/b;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "Landroid/os/Bundle;", "extData", "y", "A0", "Lcom/tencent/aio/msgservice/j;", "resp", "d0", "E", "Lcom/tencent/guild/aio/input/GuildPermissionsChangeWrapperMsgIntent;", "X", "lastPosition", "msgItemList", "E0", "m0", "isMultiSelectMode", "n0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/msg/data/b;", "limitInfoData", "k0", "j0", "s0", "clearInputStatus", "G", "Lcom/tencent/guild/aio/input/realinput/u;", "d", "Lcom/tencent/guild/aio/input/realinput/u;", "fetcher", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "e", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "flowBusEventReceiver", "Lcom/tencent/aio/data/AIOContact;", "f", "Lcom/tencent/aio/data/AIOContact;", "mContact", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", tl.h.F, "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "mMediaRepo", "Lcom/tencent/aio/part/root/panel/mvx/intent/PanelStatusIntent$PanelStatusChangeIntent;", "mCurPanelState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mChatList", "I", "mLastPosition", "Z", "mIsShowRobotHint", "com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$d", "Lcom/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$d;", "mAction", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpServiceObserver", "com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$e", "Lcom/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$e;", "msgSendAction", "com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$f", "Lcom/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$f;", "msgSendActionR", "com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$g", "Lcom/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$g;", "onConfigurationChanged", "<init>", "(Lcom/tencent/guild/aio/input/realinput/u;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioDefaultInputViewModel extends com.tencent.aio.base.mvvm.b<fo0.e, GuildAioDefaultInputUIState> implements com.tencent.aio.api.runtime.emitter.a, LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsShowRobotHint;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final d mAction;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpServiceObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e msgSendAction;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final f msgSendActionR;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final g onConfigurationChanged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u fetcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FlowEventReceiver flowBusEventReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AIOContact mContact;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildAIOMediasRepository mMediaRepo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PanelStatusIntent.PanelStatusChangeIntent mCurPanelState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends com.tencent.aio.data.msglist.a> mChatList;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f111141a;

        static {
            int[] iArr = new int[GuildAlbumMediaType.values().length];
            try {
                iArr[GuildAlbumMediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildAlbumMediaType.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f111141a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "tinyId", "nickName", "onUserNickUpdate", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            AppInterface appInterface;
            IRuntimeService iRuntimeService;
            if (channelUin != null) {
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputViewModel.this.getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.b(g16), channelUin)) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    IGProChannelInfo iGProChannelInfo = null;
                    if (peekAppRuntime instanceof AppInterface) {
                        appInterface = (AppInterface) peekAppRuntime;
                    } else {
                        appInterface = null;
                    }
                    if (appInterface != null) {
                        iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
                    } else {
                        iRuntimeService = null;
                    }
                    IGPSService iGPSService = (IGPSService) iRuntimeService;
                    if (iGPSService != null) {
                        iGProChannelInfo = iGPSService.getChannelInfo(channelUin);
                    }
                    if (iGProChannelInfo == null) {
                        return;
                    }
                    GuildAioDefaultInputViewModel guildAioDefaultInputViewModel = GuildAioDefaultInputViewModel.this;
                    String channelName = iGProChannelInfo.getChannelName();
                    Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
                    guildAioDefaultInputViewModel.updateUI(new GuildAioDefaultInputUIState.GuildInputHint(channelName, GuildAioDefaultInputViewModel.this.mIsShowRobotHint));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserNickUpdate(@Nullable String tinyId, @Nullable String nickName) {
            super.onUserNickUpdate(tinyId, nickName);
            GuildAioDefaultInputViewModel.this.e0(tinyId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildAioDefaultInputViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$e", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "call", "", "sticky", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements com.tencent.mvi.base.route.a {
        e() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            GuildAioDefaultInputViewModel.this.T(intent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$f", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f implements com.tencent.mvi.base.route.b {
        f() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildAioDefaultInputViewModel.this.U(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel$g", "Lbr0/a;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "Lmqq/util/WeakReference;", "Lcom/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewModel;", "kotlin.jvm.PlatformType", "a", "Lmqq/util/WeakReference;", "getWeakRef", "()Lmqq/util/WeakReference;", "weakRef", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g implements br0.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildAioDefaultInputViewModel> weakRef;

        g(GuildAioDefaultInputViewModel guildAioDefaultInputViewModel) {
            this.weakRef = new WeakReference<>(guildAioDefaultInputViewModel);
        }

        @Override // br0.a
        public void onConfigurationChanged(@Nullable Configuration newConfig) {
            GuildAioDefaultInputViewModel guildAioDefaultInputViewModel;
            if (QLog.isColorLevel()) {
                QLog.i("GuildAioDefaultInputViewModel", 2, "[onThemeChanged] ");
            }
            if (newConfig != null && (guildAioDefaultInputViewModel = this.weakRef.get()) != null) {
                guildAioDefaultInputViewModel.updateUI(new GuildAioDefaultInputUIState.GuildConfigurationChanged(newConfig));
            }
        }
    }

    public GuildAioDefaultInputViewModel(@NotNull u fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.fetcher = fetcher;
        this.flowBusEventReceiver = new FlowEventReceiver(null, 1, null);
        this.mChatList = new ArrayList();
        this.mLastPosition = -1;
        this.mAction = new d();
        this.gpServiceObserver = new c();
        this.msgSendAction = new e();
        this.msgSendActionR = new f();
        this.onConfigurationChanged = new g(this);
    }

    private final void A() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.h(), new GuildAioDefaultInputViewModel$channelFreqLimitInfoUpdate$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A0(List<sr0.b> elements, Bundle extData) {
        if (elements.isEmpty()) {
            return;
        }
        QLog.i("GuildAioDefaultInputViewModel", 1, "sendMsg. elementSize: " + elements.size());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(SendMsgInterceptUtil.f112285a.a(new com.tencent.aio.msgservice.k(((com.tencent.aio.api.runtime.a) getMContext()).g().r(), elements), (com.tencent.aio.api.runtime.a) getMContext(), extData), new GuildAioDefaultInputViewModel$sendMsg$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    private final boolean B() {
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        AIOContact aIOContact = this.mContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact = null;
        }
        String f16 = aIOContact.f();
        AIOContact aIOContact3 = this.mContact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
        } else {
            aIOContact2 = aIOContact3;
        }
        return !companion.r(fo0.h.a(f16, aIOContact2.j()));
    }

    static /* synthetic */ void B0(GuildAioDefaultInputViewModel guildAioDefaultInputViewModel, List list, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        guildAioDefaultInputViewModel.A0(list, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(boolean clearReply) {
        updateUI(new GuildAioDefaultInputUIState.GuideClearEditInput(clearReply));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C0(e.InputSendMultiTextIntent intent) {
        List<sr0.b> e16 = lp0.a.f415333a.e(intent);
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.f112040d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgResult.SelectMediaRepositoryResult");
        List<GuildPickPhotoResult> h16 = ((e.a) k3).getRepo().h();
        if (!h16.isEmpty()) {
            x0(h16, com.tencent.guild.aio.util.e.f112380a.a(this.fetcher.g()), true, false);
        } else {
            A0(e16, G(5));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D() {
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        if (g16.isEmpty()) {
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), R.string.f139010a4, 0).show();
        } else {
            zp0.b.f452962a.t((com.tencent.aio.api.runtime.a) getMContext(), g16);
            z();
        }
    }

    private final void D0(e.InputSendTextIntent intent) {
        A0(lp0.a.f415333a.f(intent), G(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            n0(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) i3).getIsSelectMode());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectCountChangeEvent) {
            m0();
            return;
        }
        if (i3 instanceof GuildPermissionsChangeWrapperMsgIntent) {
            X((GuildPermissionsChangeWrapperMsgIntent) i3);
        } else if (i3 instanceof GuildMsgListIntent.ExposureVisibleMsgListEvent) {
            GuildMsgListIntent.ExposureVisibleMsgListEvent exposureVisibleMsgListEvent = (GuildMsgListIntent.ExposureVisibleMsgListEvent) i3;
            E0(exposureVisibleMsgListEvent.getLastPosition(), exposureVisibleMsgListEvent.c());
        }
    }

    private final void E0(int lastPosition, List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        this.mLastPosition = lastPosition;
        this.mChatList = msgItemList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int F() {
        com.tencent.aio.data.msglist.a aVar;
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        List<? extends com.tencent.aio.data.msglist.a> list = this.mChatList;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<? extends com.tencent.aio.data.msglist.a> list2 = this.mChatList;
            if (list2 != null) {
                aVar = list2.get(i3);
            } else {
                aVar = null;
            }
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            if (GuildMultiMsgManager.INSTANCE.a().h(dVar, (GuildMsgItem) aVar)) {
                return i3;
            }
        }
        return -1;
    }

    private final void F0() {
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        AIOContact aIOContact = this.mContact;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact = null;
        }
        String channelName = iGuildChannelApi.getChannelName(aIOContact);
        boolean z16 = true;
        if (((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).isRobotSlashPanelUsed() && Math.random() >= ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getInputRobotHintProbability()) {
            z16 = false;
        }
        this.mIsShowRobotHint = z16;
        updateUI(new GuildAioDefaultInputUIState.GuildInputHint(channelName, this.mIsShowRobotHint));
    }

    private final Bundle G(int clearInputStatus) {
        Bundle bundle = new Bundle();
        bundle.putInt("clearInputStatus", clearInputStatus);
        return bundle;
    }

    private final void G0(boolean enabled) {
        updateUI(new GuildAioDefaultInputUIState.UpdateSendBtnClickable(enabled));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H(GuildChatActivityAbility.ActivityResultIntent action) {
        FragmentActivity activity;
        List<GuildPickPhotoResult> listOf;
        List<e.InputSendTextIntent> emptyList;
        if (action.getRequestCode() == 17000 && (activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity()) != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new GuildPickPhotoResult(false, PreferenceManager.getDefaultSharedPreferences(activity).getString(AppConstants.Preferences.CAMERA_PHOTO_PATH, ""), GuildAlbumMediaType.VIDEO, null, null, 24, null));
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            x0(listOf, emptyList, false, false);
        }
    }

    private final void J(GuildAtPanelEvent atPanelEvent) {
        if (atPanelEvent instanceof GuildAtPanelEvent.ShowHashtagPanel) {
            updateUI(new GuildAioDefaultInputUIState.GuildAtStateEvent.ShowHashtagPanel(((GuildAtPanelEvent.ShowHashtagPanel) atPanelEvent).getIsShow()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildAioDefaultInputViewModel"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L(GuildMsgItem msgItem) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GuildAioDefaultInputViewModel", msgItem.getMsgSeq()));
    }

    private final void M(InputMsg$InputEmojiMsg action) {
        updateUI(new GuildAioDefaultInputUIState.GuideReplaceInputEmotion(action.a()));
    }

    private final void N(GuildMsgItem msgItem) {
        updateUI(new GuildAioDefaultInputUIState.GuildInputInsertAt(msgItem));
    }

    private final void O(final MsgRecord msgItem) {
        updateUI(new GuildAioDefaultInputUIState.GuideInputRecallMsg(msgItem, B()));
        ((IMsgService) QRoute.api(IMsgService.class)).reeditRecallMsg(new Contact(msgItem.chatType, msgItem.peerUid, msgItem.guildId), msgItem.msgId, new IOperateCallback() { // from class: com.tencent.guild.aio.input.realinput.m
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GuildAioDefaultInputViewModel.P(GuildAioDefaultInputViewModel.this, msgItem, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(GuildAioDefaultInputViewModel this$0, MsgRecord msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        QLog.i("GuildAioDefaultInputViewModel", 4, "handleReeditRecallMsg result:" + i3 + ", errMsg:" + str);
        if (y.b(i3)) {
            this$0.a0(msgItem);
        }
    }

    private final void Q(com.tencent.aio.data.msglist.a msgItem) {
        updateUI(new GuildAioDefaultInputUIState.GuideInputReplyMsg(msgItem, !msgItem.isSelf()));
    }

    private final void S(rr1.i notifyData) {
        if (notifyData.f() == 3) {
            if (notifyData.c() != 1) {
                s0();
                return;
            } else {
                if (notifyData.c() == 1) {
                    if (notifyData.a() == 3 || notifyData.a() == 2) {
                        updateUI(GuildAioDefaultInputUIState.NotifyAtClusterAioOpened.f110866e);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (notifyData.f() == 1) {
            if (notifyData.a() == 1) {
                updateUI(GuildAioDefaultInputUIState.GuildInputDismissPanel.f110844e);
                updateUI(GuildAioDefaultInputUIState.GuideInputHideState.f110831e);
            } else if (notifyData.a() == 3) {
                F0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(MsgIntent action) {
        List<e.InputSendTextIntent> emptyList;
        if (action instanceof GuildMsgSendEvent.MediaSendEvent) {
            GuildMsgSendEvent.MediaSendEvent mediaSendEvent = (GuildMsgSendEvent.MediaSendEvent) action;
            if (!mediaSendEvent.getNeedCarryInputText()) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList = com.tencent.guild.aio.util.e.f112380a.a(this.fetcher.g());
            }
            x0(mediaSendEvent.b(), emptyList, mediaSendEvent.getNeedCarryInputText(), mediaSendEvent.getFromCamera());
            return;
        }
        if (action instanceof InputMsg$InputEmojiMsg) {
            M((InputMsg$InputEmojiMsg) action);
            return;
        }
        if (action instanceof InputMsg$ShowKeyboardMsg) {
            updateUI(GuildAioDefaultInputUIState.GuildShowKeyboard.f110855e);
            return;
        }
        if (action instanceof GuildMsgSendEvent.FileSendEvent) {
            w0(((GuildMsgSendEvent.FileSendEvent) action).getPath());
            return;
        }
        if (action instanceof GuildMsgSendEvent.MsgOnClickReplyEvent) {
            Q(((GuildMsgSendEvent.MsgOnClickReplyEvent) action).getMsgItem());
            return;
        }
        if (action instanceof GuildBubbleAvatarLongClickEvent) {
            N(((GuildBubbleAvatarLongClickEvent) action).getMsgItem());
            return;
        }
        if (action instanceof PanelMsg.HideAllPanelAndKeyboard) {
            updateUI(GuildAioDefaultInputUIState.GuideInputHideState.f110831e);
            return;
        }
        if (action instanceof GuildMsgSendEvent.MsgOnClickRecallMsgsEvent) {
            O(((GuildMsgSendEvent.MsgOnClickRecallMsgsEvent) action).getMsgItem());
            return;
        }
        if (action instanceof GuildAioInputMsgIntent.InputDeleteEvent) {
            UIUtil.f112434a.i(this.fetcher.g());
            return;
        }
        if (action instanceof MFGestureListIntent.NotifyEvent) {
            S(((MFGestureListIntent.NotifyEvent) action).getNotifyData());
            return;
        }
        if (action instanceof GuildPhotoPanelMsgIntent.SelectMediaChanged) {
            c0((GuildPhotoPanelMsgIntent.SelectMediaChanged) action);
            return;
        }
        if (action instanceof GuildAioInputMsgIntent.UpdateSendBtnClickable) {
            G0(((GuildAioInputMsgIntent.UpdateSendBtnClickable) action).getClickable());
            return;
        }
        if (action instanceof GuildAtPanelEvent) {
            J((GuildAtPanelEvent) action);
            return;
        }
        if (action instanceof GuildChatActivityAbility.ActivityResultIntent) {
            H((GuildChatActivityAbility.ActivityResultIntent) action);
        } else if (action instanceof GuildPhotoPanelMsgIntent.SelectMediaRepositoryPost) {
            this.mMediaRepo = ((GuildPhotoPanelMsgIntent.SelectMediaRepositoryPost) action).getRepo();
        } else if (action instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            W((PanelStatusIntent.PanelStatusChangeIntent) action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k U(MsgIntent i3) {
        if (i3 instanceof GuildMsgSendEvent.InputContainerHighGetEventR) {
            return new g.a(this.fetcher.b());
        }
        if (i3 instanceof GuildAioInputMsgIntent.GetInputEditTextEventR) {
            return new a.C10677a(this.fetcher.g());
        }
        return pn0.b.f426490a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r2) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void W(PanelStatusIntent.PanelStatusChangeIntent action) {
        Boolean bool;
        Boolean b16 = action.b();
        PanelStatusIntent.PanelStatusChangeIntent panelStatusChangeIntent = this.mCurPanelState;
        Integer num = null;
        if (panelStatusChangeIntent != null) {
            bool = panelStatusChangeIntent.b();
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(b16, bool)) {
            Integer a16 = action.a();
            PanelStatusIntent.PanelStatusChangeIntent panelStatusChangeIntent2 = this.mCurPanelState;
            if (panelStatusChangeIntent2 != null) {
                num = panelStatusChangeIntent2.a();
            }
        }
        if (!Intrinsics.areEqual(action.b(), Boolean.TRUE) && action.a() != null) {
            updateUI(GuildAioDefaultInputUIState.GuildInputDismissPanel.f110844e);
        }
        this.mCurPanelState = action;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X(GuildPermissionsChangeWrapperMsgIntent i3) {
        boolean z16 = true;
        QLog.d("GuildAioDefaultInputViewModel", 1, "handleAction input permissions = " + i3.getPermissions());
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        int permissions = i3.getPermissions();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (!companion.d(permissions, com.tencent.guild.aio.util.a.g(g16))) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildAioDefaultInputViewModel", false));
        }
        if (!GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))) && !com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())) {
            z16 = false;
        }
        updateUI(new GuildAioDefaultInputUIState.GuildHandlerPermissionsChange(i3.getPermissions(), null, z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Y() {
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        final Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        ((IMsgService) QRoute.api(IMsgService.class)).getDraft(contact, new IGetDraftOperateCallback() { // from class: com.tencent.guild.aio.input.realinput.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, long j3) {
                GuildAioDefaultInputViewModel.Z(Contact.this, this, i3, str, arrayList, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Z(Contact contact, final GuildAioDefaultInputViewModel this$0, int i3, String str, ArrayList msgElements, long j3) {
        String str2;
        Bundle l3;
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildAioDefaultInputViewModel", 4, "getDraft() result:" + i3 + ", errMsg:" + str + ", msgElements:" + msgElements + ", draftTime:" + j3);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        Intrinsics.checkNotNullExpressionValue(msgElements, "msgElements");
        guildDraftUtil.e(msgElements, contact, this$0.vmScope(), new Function1<com.tencent.aio.data.msglist.a, Unit>() { // from class: com.tencent.guild.aio.input.realinput.GuildAioDefaultInputViewModel$handleRecoverDraft$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.data.msglist.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.aio.data.msglist.a msgItem) {
                Intrinsics.checkNotNullParameter(msgItem, "msgItem");
                GuildAioDefaultInputViewModel.this.updateUI(new GuildAioDefaultInputUIState.GuideInputReplyMsg(msgItem, false));
            }
        });
        GuildAIOMediasRepository guildAIOMediasRepository = this$0.mMediaRepo;
        if (guildAIOMediasRepository != null) {
            guildAIOMediasRepository.p(((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).msgElement2MediaInfo(msgElements));
        }
        this$0.updateUI(new GuildAioDefaultInputUIState.RecoverDraft(msgElements, this$0.B()));
        if (i3 != 0) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
            if (g16 != null && (l3 = g16.l()) != null) {
                str2 = l3.getString("atTinyid");
            } else {
                str2 = null;
            }
            this$0.e0(str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a0(MsgRecord msgItem) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.UpdateReeditRecallMsgListEvent(msgItem));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b0() {
        QLog.i("GuildAioDefaultInputViewModel", 1, "handleRefreshSendBtn");
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.f112040d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgResult.SelectMediaRepositoryResult");
        updateUI(new GuildAioDefaultInputUIState.RefreshSendBtn(((e.a) k3).getRepo().k().size()));
    }

    private final void c0(GuildPhotoPanelMsgIntent.SelectMediaChanged action) {
        QLog.i("GuildAioDefaultInputViewModel", 1, "handleSelectMediaChanged");
        updateUI(new GuildAioDefaultInputUIState.RefreshSendBtn(action.a().size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(com.tencent.aio.msgservice.j<String> resp) {
        updateUI(new GuildAioDefaultInputUIState.GuildSendResp(resp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void e0(String tinyId) {
        String str;
        Bundle l3;
        Bundle l16;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        if (g16 != null && (l16 = g16.l()) != null) {
            str = l16.getString("atTinyid");
        } else {
            str = null;
        }
        if (str != null && Intrinsics.areEqual(str, tinyId)) {
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            String q06 = q0(str, com.tencent.guild.aio.util.a.g(g17));
            if (!TextUtils.isEmpty(q06)) {
                updateUI(new GuildAioDefaultInputUIState.UpdateAtInfo((com.tencent.aio.api.runtime.a) getMContext(), str, q06));
                return;
            }
            return;
        }
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        boolean z16 = false;
        if (g18 != null && (l3 = g18.l()) != null && l3.getBoolean("showKeyboard", false)) {
            z16 = true;
        }
        if (z16) {
            updateUI(new GuildAioDefaultInputUIState.UpdateAtInfo((com.tencent.aio.api.runtime.a) getMContext(), null, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0(com.tencent.aio.api.runtime.a context) {
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MediaSendEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.FileSendEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.PttSendEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(InputMsg$InputEmojiMsg.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickRecallMsgsEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildBubbleAvatarLongClickEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(PanelMsg.HideAllPanelAndKeyboard.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(InputMsg$ShowKeyboardMsg.class).getQualifiedName(), this.msgSendAction);
        context.e().j(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.InputContainerHighGetEventR.class).getQualifiedName(), this.msgSendActionR);
        context.e().j(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.GetInputEditTextEventR.class).getQualifiedName(), this.msgSendActionR);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.InputDeleteEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaChanged.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.UpdateSendBtnClickable.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildAtPanelEvent.ShowHashtagPanel.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildChatActivityAbility.ActivityResultIntent.class).getQualifiedName(), this.msgSendAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaRepositoryPost.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.msgSendAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h0() {
        n0(GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean i0() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j0() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildAioDefaultInputViewModel", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void k0(com.tencent.qqnt.msg.data.b limitInfoData) {
        String str;
        QLog.d("GuildAioDefaultInputViewModel", 4, limitInfoData);
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Contact b16 = limitInfoData.b();
        String str2 = null;
        if (b16 != null) {
            str = b16.guildId;
        } else {
            str = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (Intrinsics.areEqual(str, com.tencent.guild.aio.util.a.g(it))) {
            Contact b17 = limitInfoData.b();
            if (b17 != null) {
                str2 = b17.peerUid;
            }
            Intrinsics.areEqual(str2, com.tencent.guild.aio.util.a.b(it));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l0(e.IMECommandIntent intent) {
        Context context;
        if (intent.getAction() != null && intent.getData() != null && (context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext()) != null) {
            fo0.i.f400161a.b(context, (com.tencent.aio.api.runtime.a) getMContext(), intent.getAction(), intent.getData());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m0() {
        updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n0(boolean isMultiSelectMode) {
        if (isMultiSelectMode) {
            updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
        }
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        AIOContact aIOContact = this.mContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact = null;
        }
        String f16 = aIOContact.f();
        AIOContact aIOContact3 = this.mContact;
        if (aIOContact3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact3 = null;
        }
        int a16 = fo0.h.a(f16, aIOContact3.j());
        AIOContact aIOContact4 = this.mContact;
        if (aIOContact4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
        } else {
            aIOContact2 = aIOContact4;
        }
        updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectModeChanged(isMultiSelectMode, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext()), companion.a(a16, aIOContact2.f())));
    }

    private final void o0() {
        int i3;
        int F = F();
        if (F >= 0 && (i3 = this.mLastPosition) >= 0 && i3 >= F) {
            p0(F);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p0(int first) {
        int collectionSizeOrDefault;
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(dVar);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = g16.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((GuildMsgItem) it.next()).getMsgRecord().msgSeq));
        }
        GuildMultiMsgManager.INSTANCE.a().l(dVar, arrayList);
        int i3 = this.mLastPosition + 1;
        while (true) {
            com.tencent.aio.data.msglist.a aVar = null;
            if (first < i3) {
                List<? extends com.tencent.aio.data.msglist.a> list = this.mChatList;
                if (list != null) {
                    aVar = list.get(first);
                }
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                GuildMultiMsgManager.Companion companion = GuildMultiMsgManager.INSTANCE;
                if (!companion.a().h(dVar, guildMsgItem) && !guildMsgItem.isWalletMsg() && !guildMsgItem.isGrayTipMsg() && !guildMsgItem.isReviewingMsg()) {
                    companion.a().b(dVar, guildMsgItem);
                }
                first++;
            } else {
                m0();
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListRefreshEvent("GuildAioDefaultInputViewModel", null, 2, null));
                return;
            }
        }
    }

    private final String q0(String uid, String guildID) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getGuildUserDisplayNameInternal(guildID, uid);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r0() {
        if (zp0.b.x(zp0.b.f452962a, (com.tencent.aio.api.runtime.a) getMContext(), 0, 2, null)) {
            z();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s0() {
        List<e.InputSendTextIntent> emptyList;
        List<com.tencent.guild.api.media.album.e> arrayList;
        Bundle b16 = fetchVBState(t.a.f111174a).b();
        Long valueOf = Long.valueOf(b16.getLong("guild_draft_input_reply_msg_id"));
        e.ReplyData replyData = null;
        if (valueOf.longValue() == QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR) {
            valueOf = null;
        }
        String string = b16.getString("guild_draft_input_reply_nick");
        String str = "";
        if (string == null) {
            string = "";
        }
        String string2 = b16.getString("guild_draft_input_reply_content");
        if (string2 == null) {
            string2 = "";
        }
        CharSequence charSequence = b16.getCharSequence("guild_draft_input_editable_text");
        String string3 = b16.getString("guild_draft_input_text");
        if (string3 != null) {
            str = string3;
        }
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        QLog.d("GuildAioDefaultInputViewModel", 4, "[saveDraft] replyMsgId = " + valueOf + ", replyNickName = " + string + ", replySourceTxt= " + string2 + ", editableInputText= " + ((Object) charSequence) + ", inputText=" + str);
        if (!(charSequence instanceof Spannable)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = com.tencent.guild.aio.util.e.f112380a.b(str, (Spannable) charSequence);
        }
        if (valueOf != null) {
            replyData = new e.ReplyData(valueOf.longValue(), string, string2);
        }
        ArrayList<MsgElement> a16 = com.tencent.guild.api.msg.service.l.f112634a.a(lp0.a.f415333a.e(new e.InputSendMultiTextIntent(emptyList, replyData)));
        GuildAIOMediasRepository guildAIOMediasRepository = this.mMediaRepo;
        if (guildAIOMediasRepository == null || (arrayList = guildAIOMediasRepository.k()) == null) {
            arrayList = new ArrayList<>();
        }
        a16.addAll(((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).guildMediaInfo2MsgElement(arrayList));
        if (a16.isEmpty()) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteDraft(contact, new IOperateCallback() { // from class: com.tencent.guild.aio.input.realinput.p
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    GuildAioDefaultInputViewModel.t0(i3, str2);
                }
            });
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).setDraft(contact, a16, new IOperateCallback() { // from class: com.tencent.guild.aio.input.realinput.q
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    GuildAioDefaultInputViewModel.u0(i3, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(int i3, String str) {
        QLog.i("GuildAioDefaultInputViewModel", 4, "deleteDraft() result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(int i3, String str) {
        QLog.i("GuildAioDefaultInputViewModel", 4, "saveDraft() result:" + i3 + ", errMsg:" + str);
    }

    private final void w0(String path) {
        ArrayList arrayList = new ArrayList();
        if (new File(path).exists()) {
            arrayList.addAll(lp0.a.f415333a.a(path));
        }
        B0(this, arrayList, null, 2, null);
    }

    private final void x0(List<GuildPickPhotoResult> mediaList, List<e.InputSendTextIntent> textList, final boolean needClearMedia, final boolean fromCamera) {
        final List list;
        final List list2;
        list = CollectionsKt___CollectionsKt.toList(mediaList);
        list2 = CollectionsKt___CollectionsKt.toList(textList);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.input.realinput.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildAioDefaultInputViewModel.y0(needClearMedia, this, list2, list, fromCamera);
            }
        }, 64, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(List<sr0.b> elements, Bundle extData) {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(SendMsgInterceptUtil.f112285a.a(new com.tencent.aio.msgservice.k(((com.tencent.aio.api.runtime.a) getMContext()).g().r(), elements), (com.tencent.aio.api.runtime.a) getMContext(), extData), new GuildAioDefaultInputViewModel$addSendMsg$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(boolean z16, final GuildAioDefaultInputViewModel this$0, List textListCopy, List mediaListCopy, boolean z17) {
        final Bundle bundle;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(textListCopy, "$textListCopy");
        Intrinsics.checkNotNullParameter(mediaListCopy, "$mediaListCopy");
        if (z16) {
            bundle = this$0.G(3);
        } else {
            bundle = null;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ArrayList arrayList = new ArrayList();
        Iterator it = textListCopy.iterator();
        while (it.hasNext()) {
            arrayList.addAll(com.tencent.guild.aio.util.e.f112380a.e((e.InputSendTextIntent) it.next()));
        }
        Iterator it5 = mediaListCopy.iterator();
        while (it5.hasNext()) {
            GuildPickPhotoResult guildPickPhotoResult = (GuildPickPhotoResult) it5.next();
            String localPath = guildPickPhotoResult.getLocalPath();
            if (localPath != null) {
                int i17 = b.f111141a[guildPickPhotoResult.getResultUriType().ordinal()];
                if (i17 != 1) {
                    if (i17 != 2) {
                        arrayList.addAll(lp0.a.c(lp0.a.f415333a, localPath, guildPickPhotoResult.getQuality(), 0, 4, null));
                    } else {
                        if (ur0.a.f439860a.a(new File(localPath))) {
                            i3 = 11;
                        } else {
                            i3 = 0;
                        }
                        arrayList.addAll(lp0.a.f415333a.b(localPath, guildPickPhotoResult.getQuality(), i3));
                    }
                } else {
                    if (z17) {
                        i16 = 4602;
                    } else {
                        i16 = 4601;
                    }
                    arrayList.addAll(lp0.a.f415333a.d(localPath, i16, guildPickPhotoResult.getQuality(), guildPickPhotoResult.getThumbPath()));
                    booleanRef.element = true;
                }
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.aio.input.realinput.r
            @Override // java.lang.Runnable
            public final void run() {
                GuildAioDefaultInputViewModel.z0(Ref.BooleanRef.this, this$0, arrayList, bundle);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildAioDefaultInputViewModel", false));
        n0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(Ref.BooleanRef sendVideo, GuildAioDefaultInputViewModel this$0, ArrayList elements, Bundle bundle) {
        Intrinsics.checkNotNullParameter(sendVideo, "$sendVideo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elements, "$elements");
        if (sendVideo.element) {
            this$0.y(elements, bundle);
        } else {
            this$0.A0(elements, bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.InputSendTextIntent) {
            D0((e.InputSendTextIntent) intent);
            return;
        }
        if (intent instanceof e.InputSendMultiTextIntent) {
            C0((e.InputSendMultiTextIntent) intent);
            return;
        }
        if (intent instanceof e.j) {
            r0();
            return;
        }
        if (intent instanceof e.h) {
            D();
            return;
        }
        if (intent instanceof e.i) {
            F0();
            return;
        }
        if (intent instanceof e.q) {
            o0();
            return;
        }
        if (intent instanceof e.f) {
            updateUI(new GuildAioDefaultInputUIState.InitAtCluster((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof e.m) {
            Y();
            return;
        }
        if (intent instanceof e.g) {
            h0();
            return;
        }
        if (intent instanceof e.b) {
            K();
            return;
        }
        if (intent instanceof e.c) {
            L(((e.c) intent).getMsgItem());
            return;
        }
        if (intent instanceof e.o) {
            b0();
        } else if (intent instanceof e.a) {
            j0();
        } else if (intent instanceof e.IMECommandIntent) {
            l0((e.IMECommandIntent) intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        if (i0()) {
            z();
            return true;
        }
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
        a.C0653a c0653a = (a.C0653a) k3;
        if (!Intrinsics.areEqual(c0653a.b(), Boolean.TRUE) && c0653a.a() == null) {
            return false;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildAioDefaultInputViewModel", false, 2, null));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        Lifecycle lifecycle;
        super.onDestroy();
        s0();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MediaSendEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.FileSendEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.PttSendEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(InputMsg$InputEmojiMsg.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(InputMsg$ShowKeyboardMsg.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickRecallMsgsEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildBubbleAvatarLongClickEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelMsg.HideAllPanelAndKeyboard.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.InputContainerHighGetEventR.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.GetInputEditTextEventR.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.InputDeleteEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaChanged.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.UpdateSendBtnClickable.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildChatActivityAbility.ActivityResultIntent.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaRepositoryPost.class).getQualifiedName(), this.msgSendAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.msgSendAction);
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
            iGPSService.deleteObserver(this.gpServiceObserver);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        LifecycleOwner d16 = ((com.tencent.aio.api.runtime.a) getMContext()).d();
        if (d16 != null && (lifecycle = d16.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        GuildConfigurationManager.d(this.onConfigurationChanged);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.mContact = context.g().r().c();
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectCountChangeEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName(), this.mAction);
        g0(context);
        A();
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.gpServiceObserver);
        }
        LifecycleOwner d16 = ((com.tencent.aio.api.runtime.a) getMContext()).d();
        if (d16 != null && (lifecycle = d16.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
        GuildConfigurationManager.c(this.onConfigurationChanged);
    }
}
