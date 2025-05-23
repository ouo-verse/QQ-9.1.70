package com.tencent.mobileqq.guild.aisearch;

import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.guild.aisearch.AIChatListPart;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.aisearch.models.i;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/d;", "aiChatSession", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.AIChatListPart$onInitView$5", f = "AIChatListPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class AIChatListPart$onInitView$5 extends SuspendLambda implements Function2<AiChatSession, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIChatListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatListPart$onInitView$5(AIChatListPart aIChatListPart, Continuation<? super AIChatListPart$onInitView$5> continuation) {
        super(2, continuation);
        this.this$0 = aIChatListPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(HashMap hashMap, z zVar) {
        zVar.Eb(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AIChatListPart aIChatListPart) {
        re1.e eVar;
        eVar = aIChatListPart.jumpBtnController;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpBtnController");
            eVar = null;
        }
        re1.e.g(eVar, false, false, 3, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AIChatListPart$onInitView$5 aIChatListPart$onInitView$5 = new AIChatListPart$onInitView$5(this.this$0, continuation);
        aIChatListPart$onInitView$5.L$0 = obj;
        return aIChatListPart$onInitView$5;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@Nullable AiChatSession aiChatSession, @Nullable Continuation<? super Unit> continuation) {
        return ((AIChatListPart$onInitView$5) create(aiChatSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        TouchCaptureRecyclerView touchCaptureRecyclerView;
        ChatListAdapter chatListAdapter;
        AIChatListPart.ChatReportState chatReportState;
        AIChatListPart.ChatReportState chatReportState2;
        String str2;
        AIChatListPart.ChatReportState chatReportState3;
        String str3;
        AIChatListPart.ChatReportState chatReportState4;
        AIChatListPart.ChatReportState chatReportState5;
        StateFlow<ChatAnswerData> b16;
        ChatAnswerData value;
        TouchCaptureRecyclerView touchCaptureRecyclerView2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AiChatSession aiChatSession = (AiChatSession) this.L$0;
            Logger logger = Logger.f235387a;
            int i3 = 1;
            logger.d().i("guild.ai.search.AIChatListPart", 1, "chatList: " + aiChatSession);
            if (aiChatSession != null) {
                final HashMap hashMap = new HashMap();
                hashMap.put("sgrp_ai_session_id", aiChatSession.getSessionId());
                a.QuestionItem c16 = aiChatSession.c();
                if (c16 == null || (str = c16.getQuestion()) == null) {
                    str = "";
                }
                hashMap.put(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, str);
                IocPromise ioc = RFWIocAbilityProvider.g().getIoc(z.class);
                touchCaptureRecyclerView = this.this$0.chatRvList;
                ChatListAdapter chatListAdapter2 = null;
                if (touchCaptureRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatRvList");
                    touchCaptureRecyclerView = null;
                }
                ioc.originView(touchCaptureRecyclerView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.aisearch.c
                    @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                    public final void onDone(Object obj2) {
                        AIChatListPart$onInitView$5.c(hashMap, (z) obj2);
                    }
                }).run();
                if (!Intrinsics.areEqual(aiChatSession.getSessionState(), i.c.f214153a)) {
                    this.this$0.M9();
                    touchCaptureRecyclerView2 = this.this$0.chatRvList;
                    if (touchCaptureRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatRvList");
                        touchCaptureRecyclerView2 = null;
                    }
                    touchCaptureRecyclerView2.d0(null);
                }
                this.this$0.currentAiChatSession = aiChatSession;
                chatListAdapter = this.this$0.chatListAdapter;
                if (chatListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatListAdapter");
                } else {
                    chatListAdapter2 = chatListAdapter;
                }
                final AIChatListPart aIChatListPart = this.this$0;
                chatListAdapter2.C0(aiChatSession, new Runnable() { // from class: com.tencent.mobileqq.guild.aisearch.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIChatListPart$onInitView$5.d(AIChatListPart.this);
                    }
                });
                chatReportState = this.this$0.chatReportState;
                chatReportState.i(aiChatSession.getSessionId());
                chatReportState2 = this.this$0.chatReportState;
                a.QuestionItem f16 = aiChatSession.f();
                if (f16 == null || (str2 = f16.getQuestion()) == null) {
                    str2 = "NO_QUESTION_TEXT";
                }
                chatReportState2.h(str2);
                chatReportState3 = this.this$0.chatReportState;
                a.AnswerItem e16 = aiChatSession.e();
                if (e16 == null || (str3 = e16.getMessageId()) == null) {
                    str3 = "NO_ANSWER_ID";
                }
                chatReportState3.g(str3);
                chatReportState4 = this.this$0.chatReportState;
                a.AnswerItem e17 = aiChatSession.e();
                if (e17 != null && (b16 = e17.b()) != null && (value = b16.getValue()) != null) {
                    i3 = value.getState();
                }
                chatReportState4.j(i3);
                AIChatListPart aIChatListPart2 = this.this$0;
                if (QLog.isColorLevel()) {
                    Logger.a d16 = logger.d();
                    chatReportState5 = aIChatListPart2.chatReportState;
                    d16.d("guild.ai.search.AIChatListPart", 2, "reportState: setup " + chatReportState5);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
