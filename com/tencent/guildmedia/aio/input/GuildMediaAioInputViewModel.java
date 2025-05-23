package com.tencent.guildmedia.aio.input;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.Spannable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.route.msg.InputMsg$InputEmojiMsg;
import com.tencent.aio.base.route.msg.InputMsg$ShowKeyboardMsg;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.aio.part.root.panel.mvx.result.a;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.combinestyle.GuildMediaLongClickAvatar;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.aio.usecase.channel.title.ChannelNameUseCase;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.guildmedia.GuildMediaLottieEmojiConfigParser;
import com.tencent.guildmedia.aio.input.GuildMediaAioInputUIState;
import com.tencent.guildmedia.aio.msglist.item.graytips.GuildMediaRevokeMsgIntent$ReeditIntent;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$HideInputKeyboardStatus;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$JumpToSeqMsg;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$SetAioInputBarVisible;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$ShowInputEmojiPanel;
import com.tencent.guildmedia.api.intent.GuildMediaOuterMsgIntent$ShowInputKeyboardStatus;
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import fo0.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001GB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u001fH\u0002J\u0016\u0010$\u001a\u00020\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\u0016\u0010'\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\b\u0010(\u001a\u00020\bH\u0002J\u0016\u0010,\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\bH\u0002J\u0010\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0016J\u0010\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0!H\u0016J\u0010\u00105\u001a\u00020\b2\u0006\u0010\u000b\u001a\u000204H\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u00107\u001a\u00020\bH\u0007J\b\u00108\u001a\u00020\bH\u0016J\b\u00109\u001a\u00020\u0006H\u0016R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010C\u00a8\u0006H"}, d2 = {"Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputViewModel;", "Lpn0/a;", "Lfo0/e;", "Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Landroidx/lifecycle/LifecycleObserver;", "", BdhLogUtil.LogTag.Tag_Req, "", "T", "Lcom/tencent/aio/part/root/panel/mvx/intent/PanelStatusIntent$PanelStatusChangeIntent;", "intent", "K", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "H", "Lcom/tencent/aio/base/route/msg/InputMsg$InputEmojiMsg;", "action", "G", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "N", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", BdhLogUtil.LogTag.Tag_Conn, "L", "W", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "y", "Lfo0/e$l;", "c0", "Lfo0/e$k;", "b0", "", "Lsr0/b;", "list", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.LATITUDE_SOUTH, DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "a0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/msgservice/j;", "", "resp", "P", "isMultiSelectMode", "U", "X", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "j", "J", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "Lcom/tencent/guild/aio/usecase/channel/title/ChannelNameUseCase;", "f", "Lcom/tencent/guild/aio/usecase/channel/title/ChannelNameUseCase;", "mChannelNameUseCase", "Lcom/tencent/aio/data/AIOContact;", tl.h.F, "Lcom/tencent/aio/data/AIOContact;", "mContact", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "reeditMsg", "<init>", "()V", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAioInputViewModel extends pn0.a<fo0.e, GuildMediaAioInputUIState> implements com.tencent.aio.api.runtime.emitter.a, LifecycleObserver {

    @NotNull
    private static final Lazy<IGuildMediaChannelApi> E;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelNameUseCase mChannelNameUseCase = new ChannelNameUseCase();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AIOContact mContact;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord reeditMsg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final LinkedList<Long> C = new LinkedList<>();

    @NotNull
    private static GuildMediaLottieEmojiConfigParser.Config D = new GuildMediaLottieEmojiConfigParser.Config();

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputViewModel$a;", "", "Lcom/tencent/mobileqq/guild/api/IGuildMediaChannelApi;", "iMediaChannelApi$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/api/IGuildMediaChannelApi;", "iMediaChannelApi", "", "IMPEACH_SCENE_GUILD_LIVE_STATION_UGC", "I", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/guildmedia/GuildMediaLottieEmojiConfigParser$b;", "lottieEmojiSendConfig", "Lcom/tencent/guildmedia/GuildMediaLottieEmojiConfigParser$b;", "Ljava/util/LinkedList;", "", "lottieEmojiSendTimeList", "Ljava/util/LinkedList;", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildmedia.aio.input.GuildMediaAioInputViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IGuildMediaChannelApi b() {
            return (IGuildMediaChannelApi) GuildMediaAioInputViewModel.E.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<IGuildMediaChannelApi> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildMediaChannelApi>() { // from class: com.tencent.guildmedia.aio.input.GuildMediaAioInputViewModel$Companion$iMediaChannelApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildMediaChannelApi invoke() {
                return (IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class);
            }
        });
        E = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        if (g16.isEmpty()) {
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), R.string.f139010a4, 0).show();
        } else {
            zp0.b.f452962a.t((com.tencent.aio.api.runtime.a) getMContext(), g16);
            y();
        }
    }

    private final void B() {
        ChannelNameUseCase channelNameUseCase = this.mChannelNameUseCase;
        AIOContact aIOContact = this.mContact;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact = null;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelNameUseCase.e(new com.tencent.guild.aio.usecase.channel.title.a(aIOContact)), new GuildMediaAioInputViewModel$getInputHint$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(GuildMsgItem msgItem) {
        ArrayList<Long> arrayListOf;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMediaOuterMsgIntent$JumpToSeqMsg(msgItem.getMsgSeq()));
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(msgItem.getMsgId()));
        iMsgService.getRecallMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.guildmedia.aio.input.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                GuildMediaAioInputViewModel.D(GuildMediaAioInputViewModel.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(GuildMediaAioInputViewModel this$0, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewModel", "[handleClickReplyLayout] result = " + i3 + " errMsg = " + str + ", msgList = " + arrayList);
        if (y.b(i3) && arrayList != null && (!arrayList.isEmpty())) {
            this$0.updateUI(new GuildMediaAioInputUIState.InputToast(Integer.valueOf(R.string.f153011ay), 0, 2, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMediaOuterMsgIntent$HideInputKeyboardStatus(false));
    }

    private final void G(InputMsg$InputEmojiMsg action) {
        updateUI(new GuildMediaAioInputUIState.GuildReplaceInputEmotion(action.a()));
    }

    private final void H(com.tencent.aio.data.msglist.a msgItem) {
        updateUI(new GuildMediaAioInputUIState.GuildInputReplyMsg(msgItem, !msgItem.isSelf()));
    }

    private final void K(PanelStatusIntent.PanelStatusChangeIntent intent) {
        boolean z16;
        if (intent.a() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        updateUI(new GuildMediaAioInputUIState.GuildInputPanelChange(z16, Intrinsics.areEqual(intent.b(), Boolean.TRUE)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L() {
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        final Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        ((IMsgService) QRoute.api(IMsgService.class)).getDraft(contact, new IGetDraftOperateCallback() { // from class: com.tencent.guildmedia.aio.input.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, long j3) {
                GuildMediaAioInputViewModel.M(Contact.this, this, i3, str, arrayList, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void M(Contact contact, final GuildMediaAioInputViewModel this$0, int i3, String str, ArrayList msgElements, long j3) {
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewModel", "getDraft() result:" + i3 + ", errMsg:" + str + ", msgElements:" + msgElements + ", draftTime:" + j3);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        Intrinsics.checkNotNullExpressionValue(msgElements, "msgElements");
        guildDraftUtil.e(msgElements, contact, this$0.vmScope(), new Function1<com.tencent.aio.data.msglist.a, Unit>() { // from class: com.tencent.guildmedia.aio.input.GuildMediaAioInputViewModel$handleRecoverDraft$1$1
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
                GuildMediaAioInputViewModel.this.updateUI(new GuildMediaAioInputUIState.GuildInputReplyMsg(msgItem, false));
            }
        });
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        this$0.updateUI(new GuildMediaAioInputUIState.RecoverDraft(msgElements, g16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(final MsgRecord msgItem) {
        ((IMsgService) QRoute.api(IMsgService.class)).reeditRecallMsg(new Contact(msgItem.chatType, msgItem.peerUid, msgItem.guildId), msgItem.msgId, new IOperateCallback() { // from class: com.tencent.guildmedia.aio.input.m
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GuildMediaAioInputViewModel.O(GuildMediaAioInputViewModel.this, msgItem, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void O(GuildMediaAioInputViewModel this$0, MsgRecord msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewModel", "[handleReeditRecallMsgUpdate]  result:" + i3 + ", errMsg:" + str);
        if (y.b(i3)) {
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new GuildMsgListIntent.UpdateReeditRecallMsgListEvent(msgItem));
        }
        this$0.reeditMsg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(com.tencent.aio.msgservice.j<String> resp) {
        updateUI(new GuildMediaAioInputUIState.GuildSendResp(resp));
    }

    private final boolean Q(List<sr0.b> list) {
        int i3 = 0;
        if (list.size() != 1) {
            return false;
        }
        a.FaceElement faceElement = list.get(0).getFaceElement();
        if (faceElement != null) {
            i3 = faceElement.getFaceIndex();
        }
        return ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).isSupportLottie(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean R() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    private final boolean S() {
        LinkedList<Long> linkedList;
        if (INSTANCE.b().isLowDisplayMode()) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        while (true) {
            linkedList = C;
            if (!(!linkedList.isEmpty())) {
                break;
            }
            Long first = linkedList.getFirst();
            Intrinsics.checkNotNullExpressionValue(first, "lottieEmojiSendTimeList.first");
            if (uptimeMillis - first.longValue() <= D.b()) {
                break;
            }
            linkedList.removeFirst();
        }
        if (linkedList.size() >= D.getCount()) {
            com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f1498813h);
            return true;
        }
        linkedList.add(Long.valueOf(uptimeMillis));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T() {
        updateUI(new GuildMediaAioInputUIState.MultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
    }

    private final void U(boolean isMultiSelectMode) {
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewModel", "[onMultiSelectModeChanged] isMultiSelectMode = " + isMultiSelectMode);
        ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).updateMultiSelectState(isMultiSelectMode);
        updateUI(new GuildMediaAioInputUIState.GuildMultiSelectState(isMultiSelectMode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W() {
        if (zp0.b.f452962a.w((com.tencent.aio.api.runtime.a) getMContext(), TVKEventId.PLAYER_STATE_SEEK_COMPLETE)) {
            y();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X() {
        List<e.InputSendTextIntent> emptyList;
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
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewModel", "[saveDraft] replyMsgId = " + valueOf + ", replyNickName = " + string + ", replySourceTxt= " + string2 + ", editableInputText= " + ((Object) charSequence) + ", inputText=" + str);
        if (!(charSequence instanceof Spannable)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = com.tencent.guild.aio.util.e.f112380a.b(str, (Spannable) charSequence);
        }
        if (valueOf != null) {
            replyData = new e.ReplyData(valueOf.longValue(), string, string2);
        }
        ArrayList<MsgElement> a16 = com.tencent.guild.api.msg.service.l.f112634a.a(lp0.a.f415333a.e(new e.InputSendMultiTextIntent(emptyList, replyData)));
        if (a16.isEmpty()) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteDraft(contact, new IOperateCallback() { // from class: com.tencent.guildmedia.aio.input.o
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    GuildMediaAioInputViewModel.Y(i3, str2);
                }
            });
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).setDraft(contact, a16, new IOperateCallback() { // from class: com.tencent.guildmedia.aio.input.p
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    GuildMediaAioInputViewModel.Z(i3, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(int i3, String str) {
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewModel", "deleteDraft() result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(int i3, String str) {
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewModel", "saveDraft() result:" + i3 + ", errMsg:" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a0(List<sr0.b> elements) {
        if (elements.isEmpty()) {
            return;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(SendMsgInterceptUtil.b(SendMsgInterceptUtil.f112285a, new com.tencent.aio.msgservice.k(((com.tencent.aio.api.runtime.a) getMContext()).g().r(), elements), (com.tencent.aio.api.runtime.a) getMContext(), null, 4, null), new GuildMediaAioInputViewModel$sendMsg$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    private final void b0(e.InputSendMultiTextIntent intent) {
        List<sr0.b> e16 = lp0.a.f415333a.e(intent);
        if (Q(e16) && S()) {
            GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewModel", "[sendMultiText] send lottie fast");
        } else {
            a0(e16);
        }
    }

    private final void c0(e.InputSendTextIntent intent) {
        a0(lp0.a.f415333a.f(intent));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildMediaAioInputViewModel", false));
        U(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        updateUI(GuildMediaAioInputUIState.GuildClearEditInput.f113010d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.InputSendTextIntent) {
            c0((e.InputSendTextIntent) intent);
            return;
        }
        if (intent instanceof e.InputSendMultiTextIntent) {
            b0((e.InputSendMultiTextIntent) intent);
            return;
        }
        if (intent instanceof e.j) {
            W();
            return;
        }
        if (intent instanceof e.h) {
            A();
            return;
        }
        if (intent instanceof e.i) {
            B();
            return;
        }
        if (intent instanceof e.d) {
            F();
            return;
        }
        if (intent instanceof e.m) {
            L();
            return;
        }
        if (intent instanceof e.f) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            updateUI(new GuildMediaAioInputUIState.InitAtCluster(g16));
        } else if (intent instanceof e.c) {
            C(((e.c) intent).getMsgItem());
        } else if (intent instanceof e.ReeditRecallMsg) {
            this.reeditMsg = ((e.ReeditRecallMsg) intent).getMsgItem();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            U(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent).getIsSelectMode());
            return;
        }
        if (intent instanceof InputMsg$InputEmojiMsg) {
            G((InputMsg$InputEmojiMsg) intent);
            return;
        }
        if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            K((PanelStatusIntent.PanelStatusChangeIntent) intent);
            return;
        }
        if (intent instanceof GuildMsgSendEvent.MsgOnClickReplyEvent) {
            H(((GuildMsgSendEvent.MsgOnClickReplyEvent) intent).getMsgItem());
            return;
        }
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectCountChangeEvent) {
            T();
            return;
        }
        if (intent instanceof GuildMediaOuterMsgIntent$ShowInputKeyboardStatus) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildMediaAioInputViewModel"));
            return;
        }
        if (intent instanceof GuildMediaOuterMsgIntent$ShowInputEmojiPanel) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowPanel("GuildMediaAioInputViewModel", 1001, false, 4, null));
            return;
        }
        if (intent instanceof GuildMediaOuterMsgIntent$HideInputKeyboardStatus) {
            if (((GuildMediaOuterMsgIntent$HideInputKeyboardStatus) intent).getClearContent()) {
                Logger.f235387a.d().i("GuildMediaAioInputViewModel", 1, "[handleIntentAction] clear input text");
                updateUI(new GuildMediaAioInputUIState.UpdateInputText(""));
            }
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildMediaAioInputViewModel", false));
            return;
        }
        if (intent instanceof GuildMediaOuterMsgIntent$SetAioInputBarVisible) {
            updateUI(new GuildMediaAioInputUIState.SetInputBarVisible(((GuildMediaOuterMsgIntent$SetAioInputBarVisible) intent).getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String()));
            return;
        }
        if (intent instanceof PanelMsg.HideAllPanelAndKeyboard) {
            updateUI(GuildMediaAioInputUIState.GuideHideKeyboard.f113009d);
            return;
        }
        if (intent instanceof InputMsg$ShowKeyboardMsg) {
            updateUI(GuildMediaAioInputUIState.GuildShowKeyboard.f113021d);
            return;
        }
        if (intent instanceof GuildPermissionsChangeWrapperMsgIntent) {
            updateUI(new GuildMediaAioInputUIState.GuildHandlerPermissionsChange(((GuildPermissionsChangeWrapperMsgIntent) intent).getPermissions()));
        } else if (intent instanceof GuildMediaLongClickAvatar) {
            updateUI(new GuildMediaAioInputUIState.GuildMediaLongClickAvatar(((GuildMediaLongClickAvatar) intent).getMsgItem()));
        } else if (intent instanceof GuildMediaRevokeMsgIntent$ReeditIntent) {
            updateUI(new GuildMediaAioInputUIState.ReeditMsg(((GuildMediaRevokeMsgIntent$ReeditIntent) intent).getMsgRecord(), (com.tencent.aio.api.runtime.a) getMContext()));
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(InputMsg$InputEmojiMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectCountChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaOuterMsgIntent$SetAioInputBarVisible.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaOuterMsgIntent$ShowInputKeyboardStatus.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaOuterMsgIntent$ShowInputEmojiPanel.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaOuterMsgIntent$HideInputKeyboardStatus.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(InputMsg$ShowKeyboardMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(PanelMsg.HideAllPanelAndKeyboard.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaLongClickAvatar.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMediaRevokeMsgIntent$ReeditIntent.class).getQualifiedName()});
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        if (R()) {
            y();
            return true;
        }
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
        a.C0653a c0653a = (a.C0653a) k3;
        if (!Intrinsics.areEqual(c0653a.b(), Boolean.TRUE) && c0653a.a() == null) {
            return false;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildMediaAioInputViewModel", false, 2, null));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        X();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.mContact = context.g().r().c();
        U(R());
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        D = GuildMediaLottieEmojiConfigParser.INSTANCE.a();
    }
}
