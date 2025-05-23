package com.tencent.mobileqq.guild.aisearch;

import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.aisearch.AIChatListViewModel;
import com.tencent.mobileqq.guild.aisearch.models.AIChatRepository;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0002'(B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R3\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019`\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "Lef1/b;", "", "chatUuid", "", "S1", "queryMessage", "modelType", "sessionId", "U1", "T1", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a;", "chatState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "D", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_aiChatSession", "Lkotlinx/coroutines/Job;", "E", "Lkotlinx/coroutines/Job;", "loadChatJob", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "R1", "()Ljava/util/HashMap;", "msgExpandState", "Lkotlinx/coroutines/flow/StateFlow;", "Q1", "()Lkotlinx/coroutines/flow/StateFlow;", "currentAiChatSession", "<init>", "()V", "G", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIChatListViewModel extends ef1.b {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Job loadChatJob;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private a chatState = a.C7663a.f213931a;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableStateFlow<AiChatSession> _aiChatSession = StateFlowKt.MutableStateFlow(null);

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Boolean> msgExpandState = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a;", "", "<init>", "()V", "a", "b", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a$a;", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a$b;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static abstract class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a$a;", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.aisearch.AIChatListViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C7663a extends a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C7663a f213931a = new C7663a();

            C7663a() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a$b;", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel$a;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class b extends a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f213932a = new b();

            b() {
                super(null);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @NotNull
    public final StateFlow<AiChatSession> Q1() {
        return this._aiChatSession;
    }

    @NotNull
    public final HashMap<String, Boolean> R1() {
        return this.msgExpandState;
    }

    public final void S1(@NotNull final String chatUuid) {
        boolean z16;
        Intrinsics.checkNotNullParameter(chatUuid, "chatUuid");
        if (chatUuid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger.f235387a.d().i("AIChatListViewModel", 1, "loadChat: chatUuid is empty, load a new chat!");
            this.chatState = a.C7663a.f213931a;
            this._aiChatSession.setValue(AiChatSession.INSTANCE.c());
            return;
        }
        this._aiChatSession.setValue(AiChatSession.INSTANCE.b(chatUuid));
        Job job = this.loadChatJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.chatState = a.b.f213932a;
        Job launchIn = FlowKt.launchIn(FlowKt.onEach(AIChatRepository.f214077d.o(chatUuid), new AIChatListViewModel$loadChat$2(this, null)), ViewModelKt.getViewModelScope(this));
        this.loadChatJob = launchIn;
        if (launchIn != null) {
            launchIn.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIChatListViewModel$loadChat$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    Logger logger = Logger.f235387a;
                    String str = chatUuid;
                    logger.d().i("AIChatListViewModel", 1, "loadChat: chatUuid=" + str + ", job is completed");
                    AIChatListViewModel.this.chatState = AIChatListViewModel.a.C7663a.f213931a;
                }
            });
        }
    }

    public final void T1(@NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        FlowKt.launchIn(FlowKt.onEmpty(FlowKt.onEach(AIChatRepository.f214077d.u(sessionId), new AIChatListViewModel$retryChat$1(this, sessionId, null)), new AIChatListViewModel$retryChat$2(sessionId, null)), ViewModelKt.getViewModelScope(this));
    }

    public final void U1(@NotNull String queryMessage, @NotNull String modelType, @NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(queryMessage, "queryMessage");
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (!Intrinsics.areEqual(this.chatState, a.C7663a.f213931a)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "submitChat: chatState is " + this.chatState + ", ignore";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AIChatListViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        FlowKt.launchIn(FlowKt.onEmpty(FlowKt.onEach(AIChatRepository.f214077d.v(queryMessage, modelType, sessionId), new AIChatListViewModel$submitChat$2(sessionId, this, null)), new AIChatListViewModel$submitChat$3(sessionId, null)), ViewModelKt.getViewModelScope(this));
    }
}
