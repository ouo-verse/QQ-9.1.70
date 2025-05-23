package com.tencent.mobileqq.troop.aivoicechat.aiobar;

import android.os.Bundle;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.blockstate.GroupBlockStateIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent;
import com.tencent.mobileqq.aio.input.joinstate.GroupJoinStateIntent;
import com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatMsgIntent;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatUIState;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.a;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.GetVoiceReq;
import com.tencent.qqnt.kernel.nativeinterface.GetVoiceRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetVoiceCallback;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b*\u0001\u001a\b\u0007\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/j;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "E", "p", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "newVoiceList", "w", "voiceItem", "v", "u", "o", "", "r", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "t", "com/tencent/mobileqq/troop/aivoicechat/aiobar/j$b", "e", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/j$b;", "mAction", "f", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", tl.h.F, "I", "aiChatType", "", "i", "Ljava/util/List;", "cachedVoice", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "selectedVoice", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes35.dex */
public final class j extends com.tencent.qqnt.aio.baseVM.a<a, TroopAIVoiceChatUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private VoiceItem selectedVoice;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b mAction = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int aiChatType = AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<VoiceItem> cachedVoice = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/aivoicechat/aiobar/j$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            j.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent msgIntent) {
        if (msgIntent instanceof InputAtMsgIntent.InsertAtMemberSpan) {
            InputAtMsgIntent.InsertAtMemberSpan insertAtMemberSpan = (InputAtMsgIntent.InsertAtMemberSpan) msgIntent;
            updateUI(new TroopAIVoiceChatUIState.InsertAtMemberSpanUIState(insertAtMemberSpan.c(), insertAtMemberSpan.d(), insertAtMemberSpan.a()));
            return;
        }
        if (msgIntent instanceof AIOMsgSendEvent.MsgOnClickReplyEvent) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.s(j.this);
                }
            }, 500L);
            return;
        }
        if (msgIntent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            KeyboardMsgIntent.OnKeyboardStateChanged onKeyboardStateChanged = (KeyboardMsgIntent.OnKeyboardStateChanged) msgIntent;
            updateUI(new TroopAIVoiceChatUIState.UpdateBottomMarginView(onKeyboardStateChanged.b(), onKeyboardStateChanged.a()));
            return;
        }
        if (msgIntent instanceof TroopAIVoiceChatMsgIntent.AddVoiceIntent) {
            w(((TroopAIVoiceChatMsgIntent.AddVoiceIntent) msgIntent).a());
            return;
        }
        if (msgIntent instanceof InputEvent.OnAIVoiceChatToBeExit) {
            updateUI(TroopAIVoiceChatUIState.StartAIChatExitAnim.f293840d);
            return;
        }
        if (msgIntent instanceof TroopAIVoiceChatMsgIntent.LifeCycleUpdateIntent) {
            updateUI(new TroopAIVoiceChatUIState.OnLifeCycleUpdate(((TroopAIVoiceChatMsgIntent.LifeCycleUpdateIntent) msgIntent).getLifeCycleState()));
            return;
        }
        if (msgIntent instanceof InputGagMsgIntent.ChangeInputGagMode) {
            InputGagMsgIntent.ChangeInputGagMode changeInputGagMode = (InputGagMsgIntent.ChangeInputGagMode) msgIntent;
            updateUI(new TroopAIVoiceChatUIState.UpdateGagStatus(changeInputGagMode.b(), changeInputGagMode.a(), false));
            return;
        }
        com.tencent.aio.api.runtime.a aVar = null;
        if (msgIntent instanceof GroupJoinStateIntent.GroupJoinStateChange) {
            if (((GroupJoinStateIntent.GroupJoinStateChange) msgIntent).a()) {
                return;
            }
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar2 = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar2.e();
            if (e16 != null) {
                e16.h(InputEvent.ExitAIVoiceChatState.f188567d);
            }
            com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar3;
            }
            com.tencent.mvi.base.route.j e17 = aVar.e();
            if (e17 != null) {
                e17.h(InputEvent.AIOShortcutBarShow.f188563d);
                return;
            }
            return;
        }
        if (msgIntent instanceof GroupBlockStateIntent.GroupBlockStateChange) {
            if (((GroupBlockStateIntent.GroupBlockStateChange) msgIntent).b()) {
                com.tencent.aio.api.runtime.a aVar4 = this.aioContext;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                } else {
                    aVar = aVar4;
                }
                com.tencent.mvi.base.route.j e18 = aVar.e();
                if (e18 != null) {
                    e18.h(InputEvent.ExitAIVoiceChatState.f188567d);
                    return;
                }
                return;
            }
            return;
        }
        if ((msgIntent instanceof AIOMsgListEvent.LongShotModeChangeEvent) && ((AIOMsgListEvent.LongShotModeChangeEvent) msgIntent).b()) {
            com.tencent.aio.api.runtime.a aVar5 = this.aioContext;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar5;
            }
            com.tencent.mvi.base.route.j e19 = aVar.e();
            if (e19 != null) {
                e19.h(InputEvent.ExitAIVoiceChatState.f188567d);
            }
        }
    }

    private final void o() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().h(InputReplyMsgIntent.ClearReplyData.f189807d);
        updateUI(TroopAIVoiceChatUIState.InputBarRequestFocus.f293835d);
    }

    private final void p() {
        GetVoiceReq getVoiceReq = new GetVoiceReq();
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        if (g16 != null) {
            getVoiceReq.groupCode = su3.c.a(g16);
            getVoiceReq.chatType = as2.a.a(this.aiChatType);
            s c16 = com.tencent.qqnt.msg.f.c();
            if (c16 != null) {
                c16.getAICommonVoice(getVoiceReq, new IGetVoiceCallback() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.i
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetVoiceCallback
                    public final void onResult(int i3, String str, GetVoiceRsp getVoiceRsp) {
                        j.q(j.this, i3, str, getVoiceRsp);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(j this$0, int i3, String str, GetVoiceRsp getVoiceRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopAIVoiceChatVM", 1, "[getAICommonVoice] errCode = " + i3 + " errMsg = " + str + " size = " + getVoiceRsp.voiceList.size());
        ArrayList<VoiceItem> arrayList = getVoiceRsp.voiceList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.voiceList");
        this$0.w(arrayList);
    }

    private final boolean r() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        Bundle l3 = aVar.g().l();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_TROOP)");
        boolean z16 = false;
        boolean z17 = l3.getBoolean(ITroopAIVoiceChatApi.PARAMS_KEY_SHOW_AI_VOICE_GUIDE_BUBBLE, false);
        QQAppInterface f16 = TroopUtils.f();
        String currentAccountUin = f16 != null ? f16.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        boolean z18 = fromV2.getBoolean(ITroopAIVoiceChatApi.GUIDE_BUBBLE_SHOWN_CACHE_KEY + currentAccountUin, false, true);
        if (z17 && !z18) {
            z16 = true;
        }
        if (l3.containsKey(ITroopAIVoiceChatApi.PARAMS_KEY_SHOW_AI_VOICE_GUIDE_BUBBLE)) {
            l3.remove(ITroopAIVoiceChatApi.PARAMS_KEY_SHOW_AI_VOICE_GUIDE_BUBBLE);
        }
        if (z16) {
            QQAppInterface f17 = TroopUtils.f();
            String currentAccountUin2 = f17 != null ? f17.getCurrentAccountUin() : null;
            fromV2.putBoolean(ITroopAIVoiceChatApi.GUIDE_BUBBLE_SHOWN_CACHE_KEY + (currentAccountUin2 != null ? currentAccountUin2 : ""), true, true);
        }
        QLog.i("TroopAIVoiceChatVM", 1, "[needShowGuideBubble] needShow = " + z17 + " hasShown = " + z18);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    private final void u() {
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        String str = "";
        ITroopGagService iTroopGagService = (ITroopGagService) f16.getRuntimeService(ITroopGagService.class, "");
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        com.tencent.mobileqq.troop.troopgag.data.d selfGagInfo = iTroopGagService.getSelfGagInfo(String.valueOf(su3.c.a(g16)), true);
        ITroopListRepoApi iTroopListRepoApi = (ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class);
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar3;
        }
        AIOParam g17 = aVar2.g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        boolean isExit = iTroopListRepoApi.isExit(String.valueOf(su3.c.a(g17)), "TroopAIVoiceChatVM", false);
        boolean z16 = selfGagInfo.f300235b || isExit;
        if (isExit) {
            str = "\u65e0\u6cd5\u5728\u5df2\u9000\u51fa\u7684\u7fa4\u804a\u4e2d\u53d1\u9001\u6d88\u606f";
        } else if (z16) {
            str = selfGagInfo.f300236c;
        }
        String wording = str;
        Intrinsics.checkNotNullExpressionValue(wording, "wording");
        updateUI(new TroopAIVoiceChatUIState.UpdateGagStatus(z16, wording, false, 4, null));
    }

    private final void v(VoiceItem voiceItem) {
        this.selectedVoice = voiceItem;
        Iterator<VoiceItem> it = this.cachedVoice.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getVoiceId().equals(voiceItem.voiceId)) {
                it.remove();
                break;
            }
        }
        this.cachedVoice.add(0, voiceItem);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.at.InputAtMsgIntent.InsertAtMemberSpan");
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatMsgIntent.AddVoiceIntent");
        hashSet.add("com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatMsgIntent.LifeCycleUpdateIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.OnAIVoiceChatToBeExit");
        hashSet.add("com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent.ChangeInputGagMode");
        hashSet.add("com.tencent.mobileqq.aio.input.joinstate.GroupJoinStateIntent.GroupJoinStateChange");
        hashSet.add("com.tencent.mobileqq.aio.input.blockstate.GroupBlockStateIntent.GroupBlockStateChange");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnClickReplyEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(com.tencent.aio.api.runtime.a context, boolean reuse) {
        VoiceItem voiceItem;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        this.aioContext = context;
        com.tencent.aio.api.runtime.a aVar = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            context = null;
        }
        context.e().f(this, this.mAction);
        o();
        u();
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        int i3 = aVar.g().l().getInt(ITroopAIVoiceChatApi.AI_CHAT_TYPE, AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal());
        QLog.i("TroopAIVoiceChatVM", 1, "[onCreate] aiChatType = " + this.aiChatType + " newAIChatType = " + i3 + " cachedVoice = " + this.cachedVoice.size() + " selectVoice = " + this.selectedVoice);
        if (vr2.a.f443197a.b() && i3 == this.aiChatType && (!this.cachedVoice.isEmpty()) && (voiceItem = this.selectedVoice) != null) {
            updateUI(new TroopAIVoiceChatUIState.UpdateVoiceListUI(this.cachedVoice, voiceItem));
        } else {
            this.aiChatType = i3;
            p();
        }
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void handleIntent(a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        QLog.i("TroopAIVoiceChatVM", 1, "[handleIntent] intent = " + intent);
        if (intent instanceof a.d) {
            v(((a.d) intent).getVoiceItem());
            return;
        }
        com.tencent.aio.api.runtime.a aVar = null;
        if (intent instanceof a.C8670a) {
            a.C8670a c8670a = (a.C8670a) intent;
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar2 = null;
            }
            AIOParam g16 = aVar2.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            c8670a.f(su3.c.a(g16));
            c8670a.d(this.aiChatType);
            VoiceItem voiceItem = this.selectedVoice;
            String str = voiceItem != null ? voiceItem.voiceId : null;
            if (str == null) {
                str = "";
            }
            c8670a.e(str);
            return;
        }
        if (intent instanceof a.b) {
            com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                aVar3 = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar3.e();
            if (e16 != null) {
                e16.h(InputEvent.ExitAIVoiceChatState.f188567d);
            }
            com.tencent.aio.api.runtime.a aVar4 = this.aioContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar4;
            }
            com.tencent.mvi.base.route.j e17 = aVar.e();
            if (e17 != null) {
                e17.h(InputEvent.AIOShortcutBarShow.f188563d);
                return;
            }
            return;
        }
        if (intent instanceof a.c) {
            ((a.c) intent).b(r());
        }
    }

    private final void w(List<VoiceItem> newVoiceList) {
        List<VoiceItem> list = newVoiceList;
        this.selectedVoice = list.isEmpty() ^ true ? newVoiceList.get(0) : null;
        this.cachedVoice.clear();
        this.cachedVoice.addAll(list);
        updateUI(new TroopAIVoiceChatUIState.UpdateVoiceListUI(newVoiceList, this.selectedVoice));
    }
}
