package com.tencent.qqguild.directmessage.aio.input.inputbar;

import android.content.Context;
import android.content.res.Configuration;
import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.route.msg.InputMsg$InputEmojiMsg;
import com.tencent.aio.base.route.msg.InputMsg$ShowKeyboardMsg;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.input.realinput.u;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgIntent;
import com.tencent.guild.aio.panel.photo.e;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.configuration.GuildConfigurationManager;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.input.GuildAioInputMsgIntent;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.guild.api.media.album.GuildAlbumMediaType;
import com.tencent.guild.api.media.album.GuildPickPhotoResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.base.mvvm.AIOViewModel;
import com.tencent.qqguild.directmessage.aio.DirectMessageError;
import com.tencent.qqguild.directmessage.aio.DirectMessageNodeUpdateEvent;
import com.tencent.qqguild.directmessage.aio.input.GuildPermissionsChange;
import com.tencent.qqguild.directmessage.aio.input.UIState;
import com.tencent.qqguild.directmessage.aio.input.b;
import com.tencent.qqguild.directmessage.aio.input.c;
import com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$onMessageEventR$2;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import fo0.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kr0.a;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\u0007*\u0003s\u008d\u0001\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0003X\u0092\u0001B\u0011\u0012\u0006\u0010U\u001a\u00020R\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0015H\u0002J\u0016\u0010\u001a\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010\n\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020\u0007H\u0002J\u001e\u00100\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0017H\u0002J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020,H\u0002J\u0010\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020,H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u0010\n\u001a\u000205H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u0010\n\u001a\u000207H\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u0010\n\u001a\u000209H\u0002J\b\u0010;\u001a\u00020\u0007H\u0002J\b\u0010<\u001a\u00020\u0007H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\b\u0010>\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020?H\u0002J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020AH\u0002J\b\u0010D\u001a\u00020CH\u0002J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020,H\u0002J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020,H\u0002J\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0015\u0010J\u001a\u0004\u0018\u00010,*\u00020IH\u0002\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010N\u001a\u00020\u00072\u0006\u0010M\u001a\u00020LH\u0016J\b\u0010O\u001a\u00020\u0007H\u0016J\u0010\u0010P\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010Q\u001a\u00020\u000eH\u0016R\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\"\u0010\\\u001a\u00020L8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010d\u001a\u0004\u0018\u00010]8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010fR\u001c\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010h0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001c\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010h0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010jR\u001b\u0010r\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u001b\u0010w\u001a\u00020s8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010o\u001a\u0004\bu\u0010vR\u001b\u0010{\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bx\u0010o\u001a\u0004\by\u0010zR\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010uR\u0019\u0010\u0086\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010uR \u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010jR\u0019\u0010\u008c\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u0083\u0001R\u0017\u0010\u008f\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bH\u0010\u008e\u0001\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel;", "Lcom/tencent/qqguild/base/mvvm/AIOViewModel;", "Lcom/tencent/qqguild/directmessage/aio/input/c;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/qqguild/directmessage/aio/input/mixin/e;", "Lcom/tencent/qqguild/directmessage/aio/input/mixin/a;", "", "E0", "Lcom/tencent/qqguild/directmessage/aio/input/c$d;", "intent", "c0", "d0", "O", "", "u0", "s0", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MediaSendEvent;", "g0", "Lcom/tencent/qqguild/directmessage/aio/input/c$k;", "K0", "Lcom/tencent/qqguild/directmessage/aio/input/c$l;", "L0", "", "Lsr0/b;", "originElements", "J0", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I0", "P0", ExifInterface.LATITUDE_SOUTH, "z0", "Lcom/tencent/qqguild/base/mvvm/b;", "B0", "Lcom/tencent/mvi/base/route/MsgIntent;", "Lcom/tencent/mvi/base/route/k;", "j0", "a0", "b0", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelMsgIntent$SelectMediaChanged;", "action", "r0", "p0", "", "lastPosition", "Lcom/tencent/aio/data/msglist/a;", "msgItemList", "Q0", "D0", "X", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "H0", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MsgOnClickRecallMsgsEvent;", "n0", "Lcom/tencent/qqguild/directmessage/aio/input/GuildPermissionsChange;", "m0", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMultiSelectModeChangeEvent;", "l0", "k0", BdhLogUtil.LogTag.Tag_Req, "y0", "x0", "Lcom/tencent/guild/aio/event/GuildMsgSendEvent$MsgOnClickReplyEvent;", "q0", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/MFGestureListIntent$NotifyEvent;", "C0", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "A0", "status", "R0", "w0", "N", "Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$b;", "U", "(Lcom/tencent/guild/aio/msglist/checkbox/GuildMultiMsgManager$b;)Ljava/lang/Integer;", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e0", "onBackEvent", "Lcom/tencent/guild/aio/input/realinput/u;", "e", "Lcom/tencent/guild/aio/input/realinput/u;", "contentFetcher", "f", "Lcom/tencent/aio/api/runtime/a;", "a", "()Lcom/tencent/aio/api/runtime/a;", "M0", "(Lcom/tencent/aio/api/runtime/a;)V", "aioContext", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", tl.h.F, "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "i", "()Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "N0", "(Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;)V", "mediaRepo", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "gproGlobalService", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "types", BdhLogUtil.LogTag.Tag_Conn, "typesR", "D", "Lkotlin/Lazy;", "Y", "()Lcom/tencent/qqguild/base/mvvm/b;", "onMessageEvent", "com/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$onMessageEventR$2$a", "E", "Z", "()Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$onMessageEventR$2$a;", "onMessageEventR", UserInfo.SEX_FEMALE, "W", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "directMessageSwitchObserver", "Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$b;", "G", "Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$b;", "replyData", "H", "Ljava/lang/Integer;", "multiSelectCount", "I", "isSelectMode", "J", "c2cPermissions", "K", "isDirectSwitchOn", "L", "mChatList", "M", "mLastPosition", "com/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$e", "Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$e;", "onConfigurationChanged", "<init>", "(Lcom/tencent/guild/aio/input/realinput/u;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class InputBarViewModel extends AIOViewModel<com.tencent.qqguild.directmessage.aio.input.c, UIState> implements com.tencent.aio.api.runtime.emitter.a, com.tencent.qqguild.directmessage.aio.input.mixin.e, com.tencent.qqguild.directmessage.aio.input.mixin.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<String> typesR;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy onMessageEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy onMessageEventR;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy directMessageSwitchObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ReplyData replyData;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Integer multiSelectCount;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isSelectMode;

    /* renamed from: J, reason: from kotlin metadata */
    private int c2cPermissions;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isDirectSwitchOn;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private List<? extends com.tencent.aio.data.msglist.a> mChatList;

    /* renamed from: M, reason: from kotlin metadata */
    private int mLastPosition;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final e onConfigurationChanged;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u contentFetcher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildAIOMediasRepository mediaRepo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IGProGlobalService gproGlobalService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> types;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "nickname", "b", "d", "replyText", "", "J", "()J", "messageSequence", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$b, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ReplyData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String nickname;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String replyText;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long messageSequence;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long messageId;

        public ReplyData(@NotNull String nickname, @NotNull String replyText, long j3, long j16) {
            Intrinsics.checkNotNullParameter(nickname, "nickname");
            Intrinsics.checkNotNullParameter(replyText, "replyText");
            this.nickname = nickname;
            this.replyText = replyText;
            this.messageSequence = j3;
            this.messageId = j16;
        }

        /* renamed from: a, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* renamed from: b, reason: from getter */
        public final long getMessageSequence() {
            return this.messageSequence;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getNickname() {
            return this.nickname;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getReplyText() {
            return this.replyText;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyData)) {
                return false;
            }
            ReplyData replyData = (ReplyData) other;
            if (Intrinsics.areEqual(this.nickname, replyData.nickname) && Intrinsics.areEqual(this.replyText, replyData.replyText) && this.messageSequence == replyData.messageSequence && this.messageId == replyData.messageId) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.nickname.hashCode() * 31) + this.replyText.hashCode()) * 31) + androidx.fragment.app.a.a(this.messageSequence)) * 31) + androidx.fragment.app.a.a(this.messageId);
        }

        @NotNull
        public String toString() {
            return "ReplyData(nickname=" + this.nickname + ", replyText=" + this.replyText + ", messageSequence=" + this.messageSequence + ", messageId=" + this.messageId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f345081a;

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
            f345081a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$d", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "status", "", "onDirectMsgSwitchStatus", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d extends GPServiceObserver {
        d() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onDirectMsgSwitchStatus(int status) {
            if (status == 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("onDirectMsgSwitchStatus error, status = IDirectMsgSwitchStatus.DEFAULT");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, (String) it.next(), null);
                }
                return;
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 2, "onDirectMsgSwitchStatus switchStatus:" + status);
            }
            InputBarViewModel.this.R0(status);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$e", "Lbr0/a;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "Lmqq/util/WeakReference;", "Lcom/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel;", "kotlin.jvm.PlatformType", "a", "Lmqq/util/WeakReference;", "getWeakRef", "()Lmqq/util/WeakReference;", "weakRef", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements br0.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<InputBarViewModel> weakRef;

        e(InputBarViewModel inputBarViewModel) {
            this.weakRef = new WeakReference<>(inputBarViewModel);
        }

        @Override // br0.a
        public void onConfigurationChanged(@Nullable Configuration newConfig) {
            InputBarViewModel inputBarViewModel;
            if (QLog.isColorLevel()) {
                QLog.i("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 2, "[onConfigurationChanged] ");
            }
            if (newConfig != null && (inputBarViewModel = this.weakRef.get()) != null) {
                inputBarViewModel.updateUI(new UIState.ConfigurationChanged(newConfig));
            }
        }
    }

    public InputBarViewModel(@NotNull u contentFetcher) {
        List<String> listOf;
        List<String> listOf2;
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(contentFetcher, "contentFetcher");
        this.contentFetcher = contentFetcher;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MediaSendEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickRecallMsgsEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectCountChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(InputMsg$InputEmojiMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(InputMsg$ShowKeyboardMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(PanelMsg.HideAllPanelAndKeyboard.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildPermissionsChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(DirectMessageNodeUpdateEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaChanged.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName()});
        this.types = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.InputContainerHighGetEventR.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.GetInputEditTextEventR.class).getQualifiedName()});
        this.typesR = listOf2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqguild.base.mvvm.b>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$onMessageEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.qqguild.base.mvvm.b invoke() {
                com.tencent.qqguild.base.mvvm.b B0;
                B0 = InputBarViewModel.this.B0();
                return B0;
            }
        });
        this.onMessageEvent = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<InputBarViewModel$onMessageEventR$2.a>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$onMessageEventR$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqguild/directmessage/aio/input/inputbar/InputBarViewModel$onMessageEventR$2$a", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes22.dex */
            public static final class a implements com.tencent.mvi.base.route.b {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ InputBarViewModel f345084d;

                a(InputBarViewModel inputBarViewModel) {
                    this.f345084d = inputBarViewModel;
                }

                @Override // com.tencent.mvi.base.route.b
                @NotNull
                public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
                    com.tencent.mvi.base.route.k j06;
                    Intrinsics.checkNotNullParameter(i3, "i");
                    j06 = this.f345084d.j0(i3);
                    return j06;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(InputBarViewModel.this);
            }
        });
        this.onMessageEventR = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$directMessageSwitchObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver A0;
                A0 = InputBarViewModel.this.A0();
                return A0;
            }
        });
        this.directMessageSwitchObserver = lazy3;
        this.isDirectSwitchOn = true;
        this.mChatList = new ArrayList();
        this.mLastPosition = -1;
        this.onConfigurationChanged = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver A0() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqguild.base.mvvm.b B0() {
        return new com.tencent.qqguild.base.mvvm.b(new Function1<MsgIntent, Unit>() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.InputBarViewModel$newMessageEventHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MsgIntent msgIntent) {
                invoke2(msgIntent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MsgIntent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (intent instanceof GuildMsgSendEvent.MediaSendEvent) {
                    InputBarViewModel.this.g0((GuildMsgSendEvent.MediaSendEvent) intent);
                    return;
                }
                if (intent instanceof GuildMsgSendEvent.MsgOnClickReplyEvent) {
                    InputBarViewModel.this.q0((GuildMsgSendEvent.MsgOnClickReplyEvent) intent);
                    return;
                }
                if (intent instanceof GuildMsgSendEvent.MsgOnClickRecallMsgsEvent) {
                    InputBarViewModel.this.n0((GuildMsgSendEvent.MsgOnClickRecallMsgsEvent) intent);
                    return;
                }
                if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
                    InputBarViewModel.this.l0((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent);
                    return;
                }
                if (intent instanceof GuildMsgListIntent.GuildMultiSelectCountChangeEvent) {
                    InputBarViewModel.this.k0();
                    return;
                }
                if (intent instanceof InputMsg$InputEmojiMsg) {
                    InputBarViewModel.this.updateUI(new UIState.AddEmoticonUIState(((InputMsg$InputEmojiMsg) intent).a()));
                    return;
                }
                if (intent instanceof InputMsg$ShowKeyboardMsg) {
                    InputBarViewModel.this.updateUI(UIState.ShowSoftKeyboard.f345048f);
                    return;
                }
                if (intent instanceof PanelMsg.HideAllPanelAndKeyboard) {
                    InputBarViewModel.this.updateUI(UIState.HidePanelAndKeyboardUIState.f345038f);
                    return;
                }
                if (intent instanceof GuildPermissionsChange) {
                    InputBarViewModel.this.m0((GuildPermissionsChange) intent);
                    return;
                }
                if (intent instanceof DirectMessageNodeUpdateEvent) {
                    InputBarViewModel.this.updateUI(new UIState.HintTextUIState(((DirectMessageNodeUpdateEvent) intent).getNickName()));
                    return;
                }
                if (intent instanceof MFGestureListIntent.NotifyEvent) {
                    InputBarViewModel.this.C0((MFGestureListIntent.NotifyEvent) intent);
                    return;
                }
                if (intent instanceof GuildPhotoPanelMsgIntent.SelectMediaChanged) {
                    InputBarViewModel.this.r0((GuildPhotoPanelMsgIntent.SelectMediaChanged) intent);
                } else if (intent instanceof GuildMsgListIntent.ExposureVisibleMsgListEvent) {
                    GuildMsgListIntent.ExposureVisibleMsgListEvent exposureVisibleMsgListEvent = (GuildMsgListIntent.ExposureVisibleMsgListEvent) intent;
                    InputBarViewModel.this.Q0(exposureVisibleMsgListEvent.getLastPosition(), exposureVisibleMsgListEvent.c());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void C0(MFGestureListIntent.NotifyEvent intent) {
        rr1.i notifyData = intent.getNotifyData();
        if (notifyData.i() && notifyData.j()) {
            com.tencent.qqguild.directmessage.aio.input.mixin.d.d(this);
        } else if (notifyData.h()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("Guild.C2C.AIO.GuildAioDM.InputBarViewModel.ClosingAio", false, 2, null));
        }
    }

    private final void D0() {
        int i3;
        int X = X();
        if (X >= 0 && (i3 = this.mLastPosition) >= 0 && i3 >= X) {
            H0(X);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List, T] */
    private final void E0() {
        String inputContent = fetchVBState(t.a.f111174a).b().getString("guild_draft_input_text", "");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        lp0.a aVar = lp0.a.f415333a;
        Intrinsics.checkNotNullExpressionValue(inputContent, "inputContent");
        objectRef.element = aVar.g(inputContent);
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.f112040d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgResult.SelectMediaRepositoryResult");
        final List<GuildPickPhotoResult> h16 = ((e.a) k3).getRepo().h();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.r
            @Override // java.lang.Runnable
            public final void run() {
                InputBarViewModel.F0(Ref.ObjectRef.this, h16, this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F0(final Ref.ObjectRef elements, List guildPickPhotoResult, final InputBarViewModel this$0) {
        T t16;
        List plus;
        Intrinsics.checkNotNullParameter(elements, "$elements");
        Intrinsics.checkNotNullParameter(guildPickPhotoResult, "$guildPickPhotoResult");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!guildPickPhotoResult.isEmpty()) {
            plus = CollectionsKt___CollectionsKt.plus((Collection) elements.element, (Iterable) lp0.a.f415333a.h(guildPickPhotoResult));
            t16 = plus;
        } else {
            t16 = this$0.N((List) elements.element);
        }
        elements.element = t16;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.t
            @Override // java.lang.Runnable
            public final void run() {
                InputBarViewModel.G0(InputBarViewModel.this, elements);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(InputBarViewModel this$0, Ref.ObjectRef elements) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elements, "$elements");
        this$0.J0((List) elements.element);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H0(int first) {
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
                if (!companion.a().h(dVar, guildMsgItem) && !guildMsgItem.isWalletMsg() && !guildMsgItem.isGrayTipMsg()) {
                    companion.a().b(dVar, guildMsgItem);
                }
                first++;
            } else {
                k0();
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListRefreshEvent("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", null, 2, null));
                return;
            }
        }
    }

    private final void I0() {
        Iterator<String> it = this.types.iterator();
        while (it.hasNext()) {
            a().e().d(it.next(), Y());
        }
        Iterator<String> it5 = this.typesR.iterator();
        while (it5.hasNext()) {
            a().e().j(it5.next(), Z());
        }
    }

    private final void J0(List<sr0.b> originElements) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        if (originElements.isEmpty()) {
            return;
        }
        List<sr0.b> list = originElements;
        boolean z28 = list instanceof Collection;
        if (!z28 || !list.isEmpty()) {
            for (sr0.b bVar : list) {
                if (bVar.getElementType() != 1 && bVar.getElementType() != 6) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (!z28 || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((sr0.b) it.next()).getElementType() == 7) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z19 = true;
                    break;
                }
            }
        }
        z19 = false;
        if (!z28 || !list.isEmpty()) {
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                if (((sr0.b) it5.next()).getElementType() == 2) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    z27 = true;
                    break;
                }
            }
        }
        z27 = false;
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new InputBarViewModel$sendMsg$1(this, originElements, z19, z27, z17, null), 3, null);
    }

    private final void K0(c.SendMediaIntent intent) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (intent.getContent().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            arrayList.addAll(lp0.a.f415333a.g(intent.getContent()));
        }
        for (GuildPickPhotoResult guildPickPhotoResult : intent.b()) {
            String localPath = guildPickPhotoResult.getLocalPath();
            if (localPath == null) {
                return;
            }
            int i3 = c.f345081a[guildPickPhotoResult.getResultUriType().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    arrayList.addAll(lp0.a.c(lp0.a.f415333a, localPath, guildPickPhotoResult.getQuality(), 0, 4, null));
                } else {
                    arrayList.addAll(lp0.a.c(lp0.a.f415333a, localPath, guildPickPhotoResult.getQuality(), 0, 4, null));
                }
            } else {
                arrayList.addAll(lp0.a.f415333a.d(localPath, 4601, guildPickPhotoResult.getQuality(), guildPickPhotoResult.getThumbPath()));
            }
        }
        J0(arrayList);
    }

    private final void L0(c.SendTextIntent intent) {
        J0(lp0.a.f415333a.g(intent.getContent()));
    }

    private final List<sr0.b> N(List<sr0.b> list) {
        ReplyData replyData = this.replyData;
        if (replyData == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(lp0.a.f415333a.i(replyData.getMessageId(), replyData.getNickname(), replyData.getReplyText()));
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O() {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        updateUI(UIState.ClearEditInputUIState.f345030f);
    }

    private final void P0() {
        Iterator<String> it = this.types.iterator();
        while (it.hasNext()) {
            a().e().b(it.next(), Y());
        }
        Iterator<String> it5 = this.typesR.iterator();
        while (it5.hasNext()) {
            a().e().a(it5.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Q() {
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.f112040d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgResult.SelectMediaRepositoryResult");
        ((e.a) k3).getRepo().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(int lastPosition, List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        this.mLastPosition = lastPosition;
        this.mChatList = msgItemList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        this.replyData = null;
        updateUI(new UIState.ReplyUIState("", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(int status) {
        GuildAIOMediasRepository mediaRepo;
        this.isDirectSwitchOn = w0(status);
        updateUI(new UIState.DirectMessageSwitch(this.isDirectSwitchOn));
        if (!this.isDirectSwitchOn && (mediaRepo = getMediaRepo()) != null) {
            mediaRepo.e();
        }
    }

    private final void S() {
        QRouteApi api = QRoute.api(IQQGuildUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQGuildUtilApi::class.java)");
        final IQQGuildUtilApi iQQGuildUtilApi = (IQQGuildUtilApi) api;
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        ((IGPSService) MiscKt.c(IGPSService.class, "Guild.C2C.AIO.GuildAioDM.InputBarViewModel", "")).setDirectMsgStatus(2, 0, new cd() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.p
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                InputBarViewModel.T(IQQGuildUtilApi.this, this, i3, str, iGProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(IQQGuildUtilApi guildApi, InputBarViewModel this$0, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        String str2;
        Intrinsics.checkNotNullParameter(guildApi, "$guildApi");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str3 = null;
        if (i3 == 0 && guildApi.checkSecurityValid(iGProSecurityResult)) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                Logger.a d16 = logger.d();
                if (iGProSecurityResult != null) {
                    str3 = iGProSecurityResult.getStrDetail();
                }
                d16.d("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 2, "setDirectMsgSwitchStatus success, errMsg = " + str + ", securityErrMsg = " + str3);
            }
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).notifyDirectMsgSwitchStatus(true);
            this$0.R0(2);
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        if (iGProSecurityResult != null) {
            str2 = iGProSecurityResult.getStrDetail();
        } else {
            str2 = null;
        }
        String str4 = "setDirectMsgSwitchStatus error\uff1aresult = " + i3 + ", errMsg = " + str + ", securityErrMsg = " + str2;
        if (str4 instanceof String) {
            bVar.a().add(str4);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, (String) it.next(), null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Integer U(GuildMultiMsgManager.Companion companion) {
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        if (!companion.a().i(dVar)) {
            return null;
        }
        return Integer.valueOf(companion.a().f(dVar));
    }

    private final GPServiceObserver W() {
        return (GPServiceObserver) this.directMessageSwitchObserver.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int X() {
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

    private final com.tencent.qqguild.base.mvvm.b Y() {
        return (com.tencent.qqguild.base.mvvm.b) this.onMessageEvent.getValue();
    }

    private final InputBarViewModel$onMessageEventR$2.a Z() {
        return (InputBarViewModel$onMessageEventR$2.a) this.onMessageEventR.getValue();
    }

    private final com.tencent.mvi.base.route.k a0() {
        return new g.a(fetchVBState(b.a.f345049a).b().getInt("input_height", 0));
    }

    private final com.tencent.mvi.base.route.k b0() {
        return new a.C10677a(this.contentFetcher.g());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c0(c.IMECommandIntent intent) {
        Context context;
        if (intent.getAction() != null && intent.getData() != null && (context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext()) != null) {
            fo0.i.f400161a.b(context, (com.tencent.aio.api.runtime.a) getMContext(), intent.getAction(), intent.getData());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d0() {
        GuildAIOMediasRepository guildAIOMediasRepository;
        boolean z16;
        e.a aVar = (e.a) ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.f112040d);
        if (aVar != null) {
            guildAIOMediasRepository = aVar.getRepo();
        } else {
            guildAIOMediasRepository = null;
        }
        N0(guildAIOMediasRepository);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new InputBarViewModel$handleInitUi$1(this, null), 3, null);
        boolean i3 = GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        updateUI(new UIState.MultiSelectChanged(i3, 0, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext()), 2, null));
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        if (!com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext()) && !i3) {
            z16 = false;
        } else {
            z16 = true;
        }
        e16.h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(final GuildMsgSendEvent.MediaSendEvent intent) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.q
            @Override // java.lang.Runnable
            public final void run() {
                InputBarViewModel.h0(GuildMsgSendEvent.MediaSendEvent.this, this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, T] */
    public static final void h0(final GuildMsgSendEvent.MediaSendEvent intent, final InputBarViewModel this$0) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = lp0.a.f415333a.h(intent.b());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.s
            @Override // java.lang.Runnable
            public final void run() {
                InputBarViewModel.i0(GuildMsgSendEvent.MediaSendEvent.this, this$0, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.List, T] */
    public static final void i0(GuildMsgSendEvent.MediaSendEvent intent, InputBarViewModel this$0, Ref.ObjectRef elements) {
        ?? plus;
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elements, "$elements");
        if (intent.getNeedCarryInputText()) {
            String inputContent = this$0.fetchVBState(t.a.f111174a).b().getString("guild_draft_input_text", "");
            lp0.a aVar = lp0.a.f415333a;
            Intrinsics.checkNotNullExpressionValue(inputContent, "inputContent");
            plus = CollectionsKt___CollectionsKt.plus((Collection) aVar.g(inputContent), (Iterable) elements.element);
            elements.element = plus;
        }
        this$0.J0((List) elements.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k j0(MsgIntent intent) {
        if (intent instanceof GuildMsgSendEvent.InputContainerHighGetEventR) {
            return a0();
        }
        if (intent instanceof GuildAioInputMsgIntent.GetInputEditTextEventR) {
            return b0();
        }
        return pn0.b.f426490a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void k0() {
        boolean z16;
        this.multiSelectCount = U(GuildMultiMsgManager.INSTANCE);
        Integer num = this.multiSelectCount;
        int i3 = 0;
        if (num != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (num != null) {
            i3 = num.intValue();
        }
        updateUI(new UIState.MultiSelectChanged(z16, i3, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void l0(GuildMsgListIntent.GuildMultiSelectModeChangeEvent intent) {
        this.isSelectMode = intent.getIsSelectMode();
        if (intent.getIsSelectMode()) {
            this.multiSelectCount = U(GuildMultiMsgManager.INSTANCE);
        } else {
            this.multiSelectCount = null;
        }
        boolean z16 = true;
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, "VM handleMultiSelectModeChange isSelect:" + this.isSelectMode + " c2cPermissions:" + this.c2cPermissions + " onUpdateUI:" + System.currentTimeMillis());
        Integer num = this.multiSelectCount;
        int i3 = 0;
        if (num == null) {
            z16 = false;
        }
        if (num != null) {
            i3 = num.intValue();
        }
        updateUI(new UIState.MultiSelectChanged(z16, i3, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(GuildPermissionsChange intent) {
        this.c2cPermissions = intent.getPermissions();
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, "VM handlePermissionChange isSelect:" + this.isSelectMode + " c2cPermissions:" + this.c2cPermissions + " onUpdateUI:" + System.currentTimeMillis());
        updateUI(new UIState.GuildHandlerPermissionsChange(intent.getPermissions()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(GuildMsgSendEvent.MsgOnClickRecallMsgsEvent intent) {
        final MsgRecord msgItem = intent.getMsgItem();
        ((IMsgService) QRoute.api(IMsgService.class)).reeditRecallMsg(new Contact(msgItem.chatType, msgItem.peerUid, msgItem.guildId), msgItem.msgId, new IOperateCallback() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                InputBarViewModel.o0(InputBarViewModel.this, msgItem, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o0(InputBarViewModel this$0, MsgRecord msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Logger.f235387a.d().i("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, "handleReeditRecallMsg(" + msgItem + " -> result:" + i3 + ", errMsg:" + str);
        if (y.b(i3)) {
            ArrayList<MsgElement> arrayList = msgItem.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.elements");
            this$0.updateUI(new UIState.RecoverDraft(arrayList, true));
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new GuildMsgListIntent.UpdateReeditRecallMsgListEvent(msgItem));
            return;
        }
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e();
        if (str == null) {
            str = "";
        }
        e16.h(new DirectMessageError(i3, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p0() {
        QLog.i("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, "handleRefreshSendBtn");
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.f112040d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgResult.SelectMediaRepositoryResult");
        updateUI(new UIState.RefreshSendBtn(((e.a) k3).getRepo().k().size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(GuildMsgSendEvent.MsgOnClickReplyEvent intent) {
        GuildMsgItem guildMsgItem;
        List filterNotNull;
        com.tencent.aio.data.msglist.a msgItem = intent.getMsgItem();
        if (msgItem instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msgItem;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem == null) {
            return;
        }
        String t16 = iq0.a.t(guildMsgItem);
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        CharSequence p16 = iq0.a.p(filterNotNull, false, false, 4, null);
        SpannableStringBuilder message = new SpannableStringBuilder(t16 + ProgressTracer.SEPARATOR).append(p16);
        Intrinsics.checkNotNullExpressionValue(message, "message");
        UIState.ReplyUIState replyUIState = new UIState.ReplyUIState(message, false, 2, null);
        this.replyData = new ReplyData(t16, p16.toString(), guildMsgItem.getMsgRecord().msgSeq, guildMsgItem.getMsgRecord().msgId);
        updateUI(replyUIState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(GuildPhotoPanelMsgIntent.SelectMediaChanged action) {
        QLog.i("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, "handleSelectMediaChanged");
        updateUI(new UIState.RefreshSendBtn(action.a().size()));
    }

    private final void s0() {
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        ((IGPSService) MiscKt.c(IGPSService.class, "Guild.C2C.AIO.GuildAioDM.InputBarViewModel", "")).fetchDirectMsgStatus(new vh2.r() { // from class: com.tencent.qqguild.directmessage.aio.input.inputbar.o
            @Override // vh2.r
            public final void a(int i3, String str, int i16, int i17, int i18) {
                InputBarViewModel.t0(InputBarViewModel.this, i3, str, i16, i17, i18);
            }
        });
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(InputBarViewModel this$0, int i3, String str, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchDirectMsgStatus failed, result: " + i3 + ", errMsg: " + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", 2, "fetchDirectMsgStatus success, switchStatus: " + i16 + ", notifyStatus: " + i17 + ", userTestGroup: " + i18);
        }
        this$0.R0(i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean u0() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    private final boolean w0(int status) {
        if (status == 2 || status == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x0() {
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        if (g16.isEmpty()) {
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), R.string.f139010a4, 0).show();
        } else {
            zp0.b.f452962a.t((com.tencent.aio.api.runtime.a) getMContext(), g16);
            O();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y0() {
        if (zp0.b.f452962a.w((com.tencent.aio.api.runtime.a) getMContext(), TVKEventId.PLAYER_STATE_PLAY_REOPEN_END)) {
            O();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z0() {
        ReplyData replyData = this.replyData;
        if (replyData != null) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("Guild.C2C.AIO.GuildAioDM.InputBarViewModel", replyData.getMessageSequence()));
        }
    }

    public void M0(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.aioContext = aVar;
    }

    public void N0(@Nullable GuildAIOMediasRepository guildAIOMediasRepository) {
        this.mediaRepo = guildAIOMediasRepository;
    }

    @Override // com.tencent.qqguild.directmessage.aio.input.mixin.e, com.tencent.qqguild.directmessage.aio.input.mixin.a
    @NotNull
    public com.tencent.aio.api.runtime.a a() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        return null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqguild.directmessage.aio.input.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.a) {
            E0();
            return;
        }
        if (intent instanceof c.SendMediaIntent) {
            K0((c.SendMediaIntent) intent);
            return;
        }
        if (intent instanceof c.SendTextIntent) {
            L0((c.SendTextIntent) intent);
            return;
        }
        if (intent instanceof c.C9364c) {
            S();
            return;
        }
        if (intent instanceof c.f) {
            z0();
            return;
        }
        if (intent instanceof c.b) {
            R();
            return;
        }
        if (intent instanceof c.h) {
            x0();
            return;
        }
        if (intent instanceof c.i) {
            y0();
            return;
        }
        if (intent instanceof c.e) {
            d0();
            return;
        }
        if (intent instanceof c.IMECommandIntent) {
            c0((c.IMECommandIntent) intent);
        } else if (intent instanceof c.g) {
            p0();
        } else if (intent instanceof c.j) {
            D0();
        }
    }

    @Override // com.tencent.qqguild.directmessage.aio.input.mixin.a
    @Nullable
    /* renamed from: i, reason: from getter */
    public GuildAIOMediasRepository getMediaRepo() {
        return this.mediaRepo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        if (!com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext()) && u0()) {
            O();
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        com.tencent.qqguild.directmessage.aio.input.mixin.d.d(this);
        P0();
        IGProGlobalService iGProGlobalService = this.gproGlobalService;
        if (iGProGlobalService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gproGlobalService");
            iGProGlobalService = null;
        }
        iGProGlobalService.deleteObserver(W());
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        GuildConfigurationManager.d(this.onConfigurationChanged);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        M0(context);
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        this.gproGlobalService = (IGProGlobalService) S0;
        I0();
        IGProGlobalService iGProGlobalService = this.gproGlobalService;
        if (iGProGlobalService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gproGlobalService");
            iGProGlobalService = null;
        }
        iGProGlobalService.addObserver(W());
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        s0();
        GuildConfigurationManager.c(this.onConfigurationChanged);
    }
}
