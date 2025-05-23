package com.tencent.guildlive.aio.input;

import android.os.Bundle;
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
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.aio.usecase.channel.title.ChannelNameUseCase;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.input.GuildLiveAioInputUIState;
import com.tencent.guildlive.aio.msglist.holder.component.GuildLiveLongClickAvatar;
import com.tencent.guildlive.aio.msglist.item.graytips.GuildLiveRevokeMsgIntent$ReeditIntent;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$GetPanelState;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$JumpToSeqMsg;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveVideoScreenChange;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$UpdateInputText;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import fo0.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001<B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0018H\u0002J\u0016\u0010\u001d\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u0016\u0010\"\u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001aH\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\u0006H\u0007J\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020-H\u0016R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputViewModel;", "Lpn0/a;", "Lfo0/e;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Landroidx/lifecycle/LifecycleObserver;", "", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/aio/part/root/panel/mvx/intent/PanelStatusIntent$PanelStatusChangeIntent;", "intent", "D", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "B", "Lcom/tencent/aio/base/route/msg/InputMsg$InputEmojiMsg;", "action", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "H", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "y", UserInfo.SEX_FEMALE, "Lfo0/e$l;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lfo0/e$k;", "P", "", "Lsr0/b;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "O", HippyTKDListViewAdapter.X, "Lcom/tencent/aio/msgservice/j;", "", "resp", "K", "L", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "j", BdhLogUtil.LogTag.Tag_Conn, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", "Lcom/tencent/guild/aio/usecase/channel/title/ChannelNameUseCase;", "f", "Lcom/tencent/guild/aio/usecase/channel/title/ChannelNameUseCase;", "mChannelNameUseCase", "Lcom/tencent/aio/data/AIOContact;", tl.h.F, "Lcom/tencent/aio/data/AIOContact;", "mContact", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "reeditMsg", "<init>", "()V", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAioInputViewModel extends pn0.a<fo0.e, GuildLiveAioInputUIState> implements com.tencent.aio.api.runtime.emitter.a, LifecycleObserver {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelNameUseCase mChannelNameUseCase = new ChannelNameUseCase();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AIOContact mContact;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord reeditMsg;

    private final void A(InputMsg$InputEmojiMsg action) {
        updateUI(new GuildLiveAioInputUIState.GuildReplaceInputEmotion(action.a()));
    }

    private final void B(com.tencent.aio.data.msglist.a msgItem) {
        updateUI(new GuildLiveAioInputUIState.GuildInputReplyMsg(msgItem, !msgItem.isSelf()));
    }

    private final void D(PanelStatusIntent.PanelStatusChangeIntent intent) {
        boolean z16;
        if (intent.a() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        updateUI(new GuildLiveAioInputUIState.GuildInputPanelChange(z16, Intrinsics.areEqual(intent.b(), Boolean.TRUE)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        final Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        ((IMsgService) QRoute.api(IMsgService.class)).getDraft(contact, new IGetDraftOperateCallback() { // from class: com.tencent.guildlive.aio.input.o
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, long j3) {
                GuildLiveAioInputViewModel.G(Contact.this, this, i3, str, arrayList, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G(Contact contact, final GuildLiveAioInputViewModel this$0, int i3, String str, ArrayList msgElements, long j3) {
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioInputViewModel", "getDraft() result:" + i3 + ", errMsg:" + str + ", msgElements:" + msgElements + ", draftTime:" + j3);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        Intrinsics.checkNotNullExpressionValue(msgElements, "msgElements");
        guildDraftUtil.e(msgElements, contact, this$0.vmScope(), new Function1<com.tencent.aio.data.msglist.a, Unit>() { // from class: com.tencent.guildlive.aio.input.GuildLiveAioInputViewModel$handleRecoverDraft$1$1
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
                GuildLiveAioInputViewModel.this.updateUI(new GuildLiveAioInputUIState.GuildInputReplyMsg(msgItem, false));
            }
        });
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        this$0.updateUI(new GuildLiveAioInputUIState.RecoverDraft(msgElements, g16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(final MsgRecord msgItem) {
        ((IMsgService) QRoute.api(IMsgService.class)).reeditRecallMsg(new Contact(msgItem.chatType, msgItem.peerUid, msgItem.guildId), msgItem.msgId, new IOperateCallback() { // from class: com.tencent.guildlive.aio.input.k
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GuildLiveAioInputViewModel.J(GuildLiveAioInputViewModel.this, msgItem, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void J(GuildLiveAioInputViewModel this$0, MsgRecord msgItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioInputViewModel", "[handleReeditRecallMsgUpdate]  result:" + i3 + ", errMsg:" + str);
        if (y.b(i3)) {
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new GuildMsgListIntent.UpdateReeditRecallMsgListEvent(msgItem));
        }
        this$0.reeditMsg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(com.tencent.aio.msgservice.j<String> resp) {
        updateUI(new GuildLiveAioInputUIState.GuildSendResp(resp));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L() {
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
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioInputViewModel", "[saveDraft] replyMsgId = " + valueOf + ", replyNickName = " + string + ", replySourceTxt= " + string2 + ", editableInputText= " + ((Object) charSequence) + ", inputText=" + str);
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
            ((IMsgService) QRoute.api(IMsgService.class)).deleteDraft(contact, new IOperateCallback() { // from class: com.tencent.guildlive.aio.input.m
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    GuildLiveAioInputViewModel.M(i3, str2);
                }
            });
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).setDraft(contact, a16, new IOperateCallback() { // from class: com.tencent.guildlive.aio.input.n
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    GuildLiveAioInputViewModel.N(i3, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(int i3, String str) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioInputViewModel", "deleteDraft() result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(int i3, String str) {
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioInputViewModel", "saveDraft() result:" + i3 + ", errMsg:" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O(List<sr0.b> elements) {
        if (elements.isEmpty()) {
            return;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(SendMsgInterceptUtil.b(SendMsgInterceptUtil.f112285a, new com.tencent.aio.msgservice.k(((com.tencent.aio.api.runtime.a) getMContext()).g().r(), elements), (com.tencent.aio.api.runtime.a) getMContext(), null, 4, null), new GuildLiveAioInputViewModel$sendMsg$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    private final void P(e.InputSendMultiTextIntent intent) {
        O(lp0.a.f415333a.e(intent));
    }

    private final void Q(e.InputSendTextIntent intent) {
        O(lp0.a.f415333a.f(intent));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        updateUI(new GuildLiveAioInputUIState.UpdateTextWatcherUIState(g16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        updateUI(GuildLiveAioInputUIState.GuildClearEditInput.f112724d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(GuildMsgItem msgItem) {
        ArrayList<Long> arrayListOf;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildLiveOuterMsgIntent$JumpToSeqMsg(msgItem.getMsgSeq()));
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(msgItem.getMsgId()));
        iMsgService.getRecallMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.guildlive.aio.input.l
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                GuildLiveAioInputViewModel.z(GuildLiveAioInputViewModel.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(GuildLiveAioInputViewModel this$0, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildLiveLogUtil.INSTANCE.e("GuildLiveAioInputViewModel", "[handleClickReplyLayout] result = " + i3 + " errMsg = " + str + ", msgList = " + arrayList);
        if (y.b(i3) && arrayList != null && (!arrayList.isEmpty())) {
            this$0.updateUI(new GuildLiveAioInputUIState.LiveInputToast(Integer.valueOf(R.string.f153011ay), 0, 2, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.InputSendTextIntent) {
            Q((e.InputSendTextIntent) intent);
            return;
        }
        if (intent instanceof e.InputSendMultiTextIntent) {
            P((e.InputSendMultiTextIntent) intent);
            return;
        }
        if (intent instanceof e.m) {
            F();
            return;
        }
        if (intent instanceof e.f) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            updateUI(new GuildLiveAioInputUIState.InitAtCluster(g16));
        } else if (intent instanceof e.c) {
            y(((e.c) intent).getMsgItem());
        } else if (intent instanceof e.ReeditRecallMsg) {
            this.reeditMsg = ((e.ReeditRecallMsg) intent).getMsgItem();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof InputMsg$InputEmojiMsg) {
            A((InputMsg$InputEmojiMsg) intent);
            return;
        }
        if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            D((PanelStatusIntent.PanelStatusChangeIntent) intent);
            return;
        }
        if (intent instanceof GuildMsgSendEvent.MsgOnClickReplyEvent) {
            B(((GuildMsgSendEvent.MsgOnClickReplyEvent) intent).getMsgItem());
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$LiveVideoScreenChange) {
            updateUI(new GuildLiveAioInputUIState.VideoScreenChange(((GuildLiveOuterMsgIntent$LiveVideoScreenChange) intent).getVideoScreenState()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildLiveAioInputViewModel", false, 2, null));
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$UpdateInputText) {
            updateUI(new GuildLiveAioInputUIState.UpdateInputText(((GuildLiveOuterMsgIntent$UpdateInputText) intent).getMsg()));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildLiveAioInputViewModel"));
            return;
        }
        if (intent instanceof PanelMsg.HideAllPanelAndKeyboard) {
            updateUI(GuildLiveAioInputUIState.GuideHideKeyboard.f112723d);
            return;
        }
        if (intent instanceof InputMsg$ShowKeyboardMsg) {
            updateUI(GuildLiveAioInputUIState.GuildShowKeyboard.f112735d);
            return;
        }
        if (intent instanceof GuildPermissionsChangeWrapperMsgIntent) {
            updateUI(new GuildLiveAioInputUIState.GuildHandlerPermissionsChange(((GuildPermissionsChangeWrapperMsgIntent) intent).getPermissions()));
            R();
            return;
        }
        if (intent instanceof GuildLiveLongClickAvatar) {
            updateUI(new GuildLiveAioInputUIState.GuildLiveLongClickAvatar(((GuildLiveLongClickAvatar) intent).getMsgItem()));
            return;
        }
        if (intent instanceof GuildLiveRevokeMsgIntent$ReeditIntent) {
            updateUI(new GuildLiveAioInputUIState.ReeditMsg(((GuildLiveRevokeMsgIntent$ReeditIntent) intent).getMsgRecord(), (com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent) {
            updateUI(new GuildLiveAioInputUIState.GuildInputHint(((GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent) intent).getRoomName()));
            return;
        }
        if (intent instanceof GuildLiveInputMsgIntent$OnAddGuildWithInfoMsgIntent) {
            R();
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$GetPanelState) {
            com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
            Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
            a.C0653a c0653a = (a.C0653a) k3;
            GuildLiveOuterMsgIntent$GetPanelState guildLiveOuterMsgIntent$GetPanelState = (GuildLiveOuterMsgIntent$GetPanelState) intent;
            guildLiveOuterMsgIntent$GetPanelState.getPanelState().c(c0653a.a());
            guildLiveOuterMsgIntent$GetPanelState.getPanelState().d(c0653a.b());
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(InputMsg$InputEmojiMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$LiveVideoScreenChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$UpdateInputText.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$LiveRoomTitleUpdateMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(InputMsg$ShowKeyboardMsg.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(PanelMsg.HideAllPanelAndKeyboard.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveLongClickAvatar.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveRevokeMsgIntent$ReeditIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveInputMsgIntent$OnAddGuildWithInfoMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$GetPanelState.class).getQualifiedName()});
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
        a.C0653a c0653a = (a.C0653a) k3;
        if (!Intrinsics.areEqual(c0653a.b(), Boolean.TRUE) && c0653a.a() == null) {
            return false;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildLiveAioInputViewModel", false, 2, null));
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
        L();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.mContact = context.g().r().c();
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
    }
}
