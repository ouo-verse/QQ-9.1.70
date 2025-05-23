package com.tencent.mobileqq.guild.aisearch.models;

import androidx.annotation.UiThread;
import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.mobileqq.guild.aisearch.SSESearchConfig;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.aisearch.models.i;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchDepositary;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetSessionMsgListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAllGuildAIInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.co;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bn;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0004*\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J<\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J,\u0010\u001d\u001a\u00020\u001c*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00182\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\f\u0010#\u001a\u00020\u0004*\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0002H\u0016J*\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00162\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0007J\u0018\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00162\u0006\u0010\u0010\u001a\u00020\u0002H\u0007J\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00162\u0006\u0010\u0010\u001a\u00020\u0002R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040+j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u00109\u001a\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010>\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/AIChatRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "newSessionId", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "searchInfo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "aiSearchStateFlow", "Lkotlinx/coroutines/Job;", DomainData.DOMAIN_NAME, "searchText", "modelType", "sessionId", "Lkotlin/Result;", "Lcom/tencent/mobileqq/guild/aisearch/models/h;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chatUuid", "Lkotlinx/coroutines/flow/Flow;", "p", "Lkotlinx/coroutines/channels/SendChannel;", "Lri1/a;", "error", "from", "", "l", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAISearchGetSessionMsgListRsp;", "rsp", "", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "i", "j", "account", "", "onAccountChanged", "queryMessage", "v", "u", "o", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "e", "Ljava/util/LinkedHashMap;", "sessionCache", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchDepositary;", "f", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchDepositary;", "dsSearchDepositary", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", tl.h.F, "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIChatRepository implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final AIChatRepository f214077d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LinkedHashMap<String, AiChatSession> sessionCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final DSSearchDepositary dsSearchDepositary;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final RuntimeServiceHolder serviceHolder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy gproService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineScope coroutineScope;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAllGuildAIInfoRsp;", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAllGuildAIInfoRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements bn {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Result<SearchAllGuildAIInfoResponseResult>> f214101a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Result<SearchAllGuildAIInfoResponseResult>> continuation) {
            this.f214101a = continuation;
        }

        @Override // wh2.bn
        public final void a(int i3, String str, IGProGuildSearchAllGuildAIInfoRsp iGProGuildSearchAllGuildAIInfoRsp) {
            Logger.f235387a.d().i("AIChatRepository", 1, "getAllGuildSearchAIInfo " + str + " " + i3 + " " + iGProGuildSearchAllGuildAIInfoRsp);
            Continuation<Result<SearchAllGuildAIInfoResponseResult>> continuation = this.f214101a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Result.m475boximpl(Result.m476constructorimpl(new SearchAllGuildAIInfoResponseResult(i3, str, iGProGuildSearchAllGuildAIInfoRsp)))));
        }
    }

    static {
        AIChatRepository aIChatRepository = new AIChatRepository();
        f214077d = aIChatRepository;
        sessionCache = new LinkedHashMap<>(100, 0.75f, true);
        dsSearchDepositary = new DSSearchDepositary(new SSESearchConfig("https://qun.qq.com/qunng/sse/guildsearch/ai/v1/getallguildaianswer", "UVHpopHpgZPlhoXmkJzntKI=", "ALL_GUILD"));
        RuntimeServiceHolder runtimeServiceHolder = new RuntimeServiceHolder();
        serviceHolder = runtimeServiceHolder;
        gproService = runtimeServiceHolder.a("AIChatRepository", IGPSService.class);
        coroutineScope = CoroutineScopeKt.CoroutineScope(GuildAIODispatchers.f112358a.a().plus(new CoroutineName("AIChatRepository")));
        AccountChangedNotifier.f214789d.a(aIChatRepository);
    }

    AIChatRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.guild.aisearch.models.a> i(IGProAISearchGetSessionMsgListRsp rsp) {
        Object questionItem;
        int i3;
        String str;
        String str2;
        ArrayList<IGProAISearchSessionMsg> sessionMsgList = rsp.getSessionMsgList();
        Intrinsics.checkNotNullExpressionValue(sessionMsgList, "rsp.sessionMsgList");
        ArrayList arrayList = new ArrayList();
        for (IGProAISearchSessionMsg iGProAISearchSessionMsg : sessionMsgList) {
            int type = iGProAISearchSessionMsg.getType();
            String str3 = "ServerError";
            if (type != 1) {
                if (type != 2) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str4 = "loadMsgList: unknown type=" + iGProAISearchSessionMsg.getType();
                    if (str4 instanceof String) {
                        bVar.a().add(str4);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (true) {
                        questionItem = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        Logger.f235387a.d().e("AIChatRepository", 1, (String) it.next(), null);
                    }
                } else {
                    String msgId = iGProAISearchSessionMsg.getMsgId();
                    int finishReason = iGProAISearchSessionMsg.getContent().getFinishReason();
                    if (finishReason != 0) {
                        if (finishReason != 1) {
                            i3 = 6;
                        } else {
                            i3 = 7;
                        }
                    } else {
                        i3 = 5;
                    }
                    int i16 = i3;
                    String modelContent = iGProAISearchSessionMsg.getContent().getModelContent();
                    if (modelContent == null) {
                        str = "ServerError";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(modelContent, "it.content.modelContent ?: \"ServerError\"");
                        str = modelContent;
                    }
                    String reasoningContent = iGProAISearchSessionMsg.getContent().getReasoningContent();
                    if (reasoningContent == null) {
                        str2 = "ServerError";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(reasoningContent, "it.content.reasoningContent ?: \"ServerError\"");
                        str2 = reasoningContent;
                    }
                    MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(new ChatAnswerData(i16, str, str2, iGProAISearchSessionMsg.getCreateTime(), iGProAISearchSessionMsg.getCreateTime() + iGProAISearchSessionMsg.getContent().getModelThinkingTime(), 0L, 32, null));
                    long createTime = iGProAISearchSessionMsg.getCreateTime();
                    String valueOf = String.valueOf(iGProAISearchSessionMsg.getModelType());
                    Intrinsics.checkNotNullExpressionValue(msgId, "msgId");
                    questionItem = new a.AnswerItem(msgId, MutableStateFlow, null, valueOf, null, createTime, 16, null);
                }
            } else {
                String msgId2 = iGProAISearchSessionMsg.getMsgId();
                Intrinsics.checkNotNullExpressionValue(msgId2, "it.msgId");
                String userQuery = iGProAISearchSessionMsg.getContent().getUserQuery();
                if (userQuery != null) {
                    Intrinsics.checkNotNullExpressionValue(userQuery, "it.content.userQuery ?: \"ServerError\"");
                    str3 = userQuery;
                }
                questionItem = new a.QuestionItem(msgId2, str3, iGProAISearchSessionMsg.getCreateTime());
            }
            if (questionItem != null) {
                arrayList.add(questionItem);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AiChatSession j(AiChatSession aiChatSession) {
        sessionCache.put(aiChatSession.getSessionId(), aiChatSession);
        return aiChatSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGPSService k() {
        return (IGPSService) gproService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(SendChannel<? super AiChatSession> sendChannel, String str, ri1.a aVar, String str2) {
        if (aVar.d() && aVar.f431479c != null) {
            return false;
        }
        String str3 = str2 + ": error=" + aVar;
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        if (str3 instanceof String) {
            bVar.a().add(str3);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("AIChatRepository", 1, (String) it.next(), null);
        }
        sendChannel.mo2003trySendJP2dKIU(AiChatSession.INSTANCE.a(str, str3));
        sendChannel.cancel(new CancellationException(str3));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AiChatSession m(AiChatSession aiChatSession) {
        com.tencent.mobileqq.guild.aisearch.models.a aVar;
        com.tencent.mobileqq.guild.aisearch.models.a aVar2;
        List<com.tencent.mobileqq.guild.aisearch.models.a> g16 = aiChatSession.g();
        ListIterator<com.tencent.mobileqq.guild.aisearch.models.a> listIterator = g16.listIterator(g16.size());
        while (true) {
            aVar = null;
            if (listIterator.hasPrevious()) {
                aVar2 = listIterator.previous();
                if (aVar2 instanceof a.AnswerItem) {
                    break;
                }
            } else {
                aVar2 = null;
                break;
            }
        }
        if (aVar2 instanceof a.AnswerItem) {
            aVar = aVar2;
        }
        a.AnswerItem answerItem = (a.AnswerItem) aVar;
        if (answerItem == null) {
            Logger logger = Logger.f235387a;
            NullPointerException nullPointerException = new NullPointerException();
            Logger.b bVar = new Logger.b();
            String str = "list is null";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AIChatRepository", 1, (String) it.next(), nullPointerException);
            }
            return aiChatSession;
        }
        IGProGuildSearchAISearchInfo searchInfo = answerItem.getSearchInfo();
        if (searchInfo == null) {
            Logger logger2 = Logger.f235387a;
            NullPointerException nullPointerException2 = new NullPointerException();
            Logger.b bVar2 = new Logger.b();
            String str2 = "lastAnswerItem.searchInfo is null";
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("AIChatRepository", 1, (String) it5.next(), nullPointerException2);
            }
            return aiChatSession;
        }
        StateFlow<ChatAnswerData> b16 = answerItem.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlinx.coroutines.flow.MutableStateFlow<com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData>");
        aiChatSession.k(n(searchInfo, (MutableStateFlow) b16));
        return aiChatSession;
    }

    private final Job n(IGProGuildSearchAISearchInfo searchInfo, MutableStateFlow<ChatAnswerData> aiSearchStateFlow) {
        DSSearchDepositary dSSearchDepositary = dsSearchDepositary;
        String searchKey = searchInfo.getSearchKey();
        Intrinsics.checkNotNullExpressionValue(searchKey, "searchInfo.searchKey");
        return FlowKt.launchIn(FlowKt.onCompletion(FlowKt.onEach(dSSearchDepositary.l(searchKey), new AIChatRepository$launchNewSearch$1(aiSearchStateFlow, null)), new AIChatRepository$launchNewSearch$2(null)), coroutineScope);
    }

    private final Flow<AiChatSession> p(String chatUuid) {
        return FlowKt.callbackFlow(new AIChatRepository$loadMsgListFromServer$1(chatUuid, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AiChatSession q(String newSessionId) {
        AiChatSession aiChatSession = sessionCache.get(newSessionId);
        if (aiChatSession == null) {
            return j(r(newSessionId));
        }
        return aiChatSession;
    }

    private static final AiChatSession r(String str) {
        Logger.f235387a.d().i("AIChatRepository", 1, "obtainSession: new session created, sessionId=" + str);
        return new AiChatSession(str, new ArrayList(), 0, i.d.f214154a, 0L, true, 20, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object s(String str, String str2, String str3, Continuation<? super Result<SearchAllGuildAIInfoResponseResult>> continuation) {
        AIChatRepository$requestSearch$1 aIChatRepository$requestSearch$1;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof AIChatRepository$requestSearch$1) {
            aIChatRepository$requestSearch$1 = (AIChatRepository$requestSearch$1) continuation;
            int i16 = aIChatRepository$requestSearch$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                aIChatRepository$requestSearch$1.label = i16 - Integer.MIN_VALUE;
                Object obj = aIChatRepository$requestSearch$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = aIChatRepository$requestSearch$1.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    aIChatRepository$requestSearch$1.L$0 = str;
                    aIChatRepository$requestSearch$1.L$1 = str2;
                    aIChatRepository$requestSearch$1.L$2 = str3;
                    aIChatRepository$requestSearch$1.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(aIChatRepository$requestSearch$1);
                    SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                    co coVar = new co();
                    coVar.e(str);
                    coVar.d(MiscKt.k(str2));
                    if (str3.length() <= 0) {
                        z16 = false;
                    }
                    if (z16) {
                        coVar.f(str3);
                    }
                    f214077d.k().getAllGuildSearchAIInfo(coVar, new a(safeContinuation));
                    obj = safeContinuation.getOrThrow();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (obj == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(aIChatRepository$requestSearch$1);
                    }
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return ((Result) obj).getValue();
            }
        }
        aIChatRepository$requestSearch$1 = new AIChatRepository$requestSearch$1(this, continuation);
        Object obj2 = aIChatRepository$requestSearch$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = aIChatRepository$requestSearch$1.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object t(AIChatRepository aIChatRepository, String str, String str2, String str3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        return aIChatRepository.s(str, str2, str3, continuation);
    }

    @NotNull
    public final Flow<AiChatSession> o(@NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return FlowKt.onEmpty(FlowKt.filterNotNull(FlowKt.flow(new AIChatRepository$loadChatMessageList$$inlined$transform$1(p(sessionId), null, sessionId))), new AIChatRepository$loadChatMessageList$2(sessionId, null));
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        serviceHolder.e();
    }

    @UiThread
    @NotNull
    public final Flow<AiChatSession> u(@NotNull final String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        AiChatSession aiChatSession = sessionCache.get(sessionId);
        String str = "sessionOf(" + sessionId + ")";
        if (aiChatSession == null) {
            Logger logger = Logger.f235387a;
            NullPointerException nullPointerException = new NullPointerException();
            Logger.b bVar = new Logger.b();
            String str2 = str + " is null";
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AIChatRepository", 1, (String) it.next(), nullPointerException);
            }
            return FlowKt.flowOf((Object[]) new AiChatSession[0]);
        }
        Intrinsics.checkNotNullExpressionValue(aiChatSession, "sessionCache[sessionId].\u2026Id)\") { return flowOf() }");
        AiChatSession aiChatSession2 = aiChatSession;
        a.AnswerItem e16 = aiChatSession2.e();
        if (e16 == null) {
            Logger logger2 = Logger.f235387a;
            NullPointerException nullPointerException2 = new NullPointerException();
            Logger.b bVar2 = new Logger.b();
            String str3 = "lastAnswerItem is null";
            if (str3 instanceof String) {
                bVar2.a().add(str3);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("AIChatRepository", 1, (String) it5.next(), nullPointerException2);
            }
            return FlowKt.flowOf((Object[]) new AiChatSession[0]);
        }
        a.QuestionItem f16 = aiChatSession2.f();
        if (f16 == null) {
            Logger logger3 = Logger.f235387a;
            NullPointerException nullPointerException3 = new NullPointerException();
            Logger.b bVar3 = new Logger.b();
            String str4 = "lastQuery is null";
            if (str4 instanceof String) {
                bVar3.a().add(str4);
            }
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("AIChatRepository", 1, (String) it6.next(), nullPointerException3);
            }
            return FlowKt.flowOf((Object[]) new AiChatSession[0]);
        }
        final String question = f16.getQuestion();
        final String modelType = e16.getModelType();
        Job job = aiChatSession2.getJob();
        if (job != null) {
            job.cancel(new CancellationException("retry last message"));
        }
        final Flow flow = FlowKt.flow(new AIChatRepository$retryLastMessage$1(f16, e16, null));
        return FlowKt.onStart(new Flow<AiChatSession>() { // from class: com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$retryLastMessage$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$retryLastMessage$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass2 implements FlowCollector<SearchAllGuildAIInfoResponseResult> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f214089d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f214090e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f214091f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f214092h;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$retryLastMessage$$inlined$map$1$2", f = "AIChatRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$retryLastMessage$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str, String str2, String str3) {
                    this.f214089d = flowCollector;
                    this.f214090e = str;
                    this.f214091f = str2;
                    this.f214092h = str3;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(SearchAllGuildAIInfoResponseResult searchAllGuildAIInfoResponseResult, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    AiChatSession q16;
                    List plus;
                    AiChatSession m3;
                    AiChatSession j3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f214089d;
                                SearchAllGuildAIInfoResponseResult searchAllGuildAIInfoResponseResult2 = searchAllGuildAIInfoResponseResult;
                                Logger.f235387a.d().i("AIChatRepository", 1, "retryLastMessage: start new chat message. sessionId=" + this.f214090e);
                                if (searchAllGuildAIInfoResponseResult2.getIsError()) {
                                    j3 = AIChatRepository.f214077d.j(AiChatSession.Companion.e(AiChatSession.INSTANCE, this.f214090e, this.f214091f, this.f214092h, searchAllGuildAIInfoResponseResult2.getErrorState(), null, 16, null));
                                } else {
                                    IGProGuildSearchAllGuildAIInfoRsp response = searchAllGuildAIInfoResponseResult2.getResponse();
                                    if (response != null) {
                                        AIChatRepository aIChatRepository = AIChatRepository.f214077d;
                                        String sessionId = response.getSessionId();
                                        Intrinsics.checkNotNullExpressionValue(sessionId, "rsp.sessionId");
                                        q16 = aIChatRepository.q(sessionId);
                                        plus = CollectionsKt___CollectionsKt.plus((Collection) q16.g(), (Iterable) searchAllGuildAIInfoResponseResult2.b(this.f214091f, this.f214092h));
                                        m3 = aIChatRepository.m(q16.j(new ArrayList(plus)));
                                        j3 = aIChatRepository.j(m3);
                                    } else {
                                        throw new IllegalStateException("Required value was null.".toString());
                                    }
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(j3, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super AiChatSession> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, sessionId, question, modelType), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new AIChatRepository$retryLastMessage$3(aiChatSession2, sessionId, question, modelType, f16, e16, null));
    }

    @UiThread
    @NotNull
    public final Flow<AiChatSession> v(@NotNull final String queryMessage, @NotNull final String modelType, @NotNull final String sessionId) {
        Intrinsics.checkNotNullParameter(queryMessage, "queryMessage");
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        final Flow flow = FlowKt.flow(new AIChatRepository$sendMessage$1(queryMessage, modelType, sessionId, null));
        return FlowKt.onStart(new Flow<AiChatSession>() { // from class: com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$sendMessage$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$sendMessage$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass2 implements FlowCollector<SearchAllGuildAIInfoResponseResult> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f214097d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f214098e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f214099f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f214100h;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$sendMessage$$inlined$map$1$2", f = "AIChatRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.aisearch.models.AIChatRepository$sendMessage$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String str, String str2, String str3) {
                    this.f214097d = flowCollector;
                    this.f214098e = str;
                    this.f214099f = str2;
                    this.f214100h = str3;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(SearchAllGuildAIInfoResponseResult searchAllGuildAIInfoResponseResult, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    AiChatSession q16;
                    List plus;
                    AiChatSession m3;
                    AiChatSession j3;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f214097d;
                                SearchAllGuildAIInfoResponseResult searchAllGuildAIInfoResponseResult2 = searchAllGuildAIInfoResponseResult;
                                if (searchAllGuildAIInfoResponseResult2.getIsError()) {
                                    j3 = AIChatRepository.f214077d.j(AiChatSession.Companion.e(AiChatSession.INSTANCE, this.f214098e, this.f214099f, this.f214100h, searchAllGuildAIInfoResponseResult2.getErrorState(), null, 16, null));
                                } else {
                                    IGProGuildSearchAllGuildAIInfoRsp response = searchAllGuildAIInfoResponseResult2.getResponse();
                                    if (response != null) {
                                        AIChatRepository aIChatRepository = AIChatRepository.f214077d;
                                        String sessionId = response.getSessionId();
                                        Intrinsics.checkNotNullExpressionValue(sessionId, "rsp.sessionId");
                                        q16 = aIChatRepository.q(sessionId);
                                        Job job = q16.getJob();
                                        boolean z16 = false;
                                        if (job != null && !job.isCompleted()) {
                                            z16 = true;
                                        }
                                        if (z16 && !job.isCancelled()) {
                                            Logger.f235387a.d().i("AIChatRepository", 1, "sendMessage: job not finish! ");
                                            j3 = q16;
                                        } else {
                                            Logger.f235387a.d().i("AIChatRepository", 1, "sendMessage: modelType=" + this.f214100h + ", queryMessage=" + this.f214099f);
                                            plus = CollectionsKt___CollectionsKt.plus((Collection) q16.g(), (Iterable) searchAllGuildAIInfoResponseResult2.b(this.f214099f, this.f214100h));
                                            m3 = aIChatRepository.m(q16.j(new ArrayList(plus)));
                                            j3 = aIChatRepository.j(m3);
                                        }
                                    } else {
                                        throw new IllegalStateException("Required value was null.".toString());
                                    }
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(j3, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super AiChatSession> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, sessionId, queryMessage, modelType), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new AIChatRepository$sendMessage$3(sessionId, queryMessage, modelType, null));
    }
}
