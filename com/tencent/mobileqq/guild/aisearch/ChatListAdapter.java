package com.tencent.mobileqq.guild.aisearch;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.aisearch.delegates.AIMsgAdapterDelegate;
import com.tencent.mobileqq.guild.aisearch.delegates.GuildSearchLLMChatAISourceMsgDelegate;
import com.tencent.mobileqq.guild.aisearch.delegates.ShareAIMsgDelegate;
import com.tencent.mobileqq.guild.aisearch.delegates.SpaceHolderDelegate;
import com.tencent.mobileqq.guild.aisearch.delegates.UserMsgAdapterDelegate;
import com.tencent.mobileqq.guild.aisearch.models.AiChatSession;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.config.GuildAISearchModel;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BS\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00109\u001a\u00020#\u0012\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0:\u0012\u0014\b\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\b0:\u0012\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\b0B\u00a2\u0006\u0004\bX\u0010YJ\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0012\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0006\u0010\u001e\u001a\u00020\bJ!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001f\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\nH\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020\nH\u0016J\u0018\u0010+\u001a\u00020\b2\u0006\u0010'\u001a\u00020\n2\u0006\u0010*\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0016R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0017\u00109\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R#\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\b0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\b0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00040F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR8\u0010T\u001a&\u0012\f\u0012\n P*\u0004\u0018\u00010\u00160\u0016 P*\u0012\u0012\f\u0012\n P*\u0004\u0018\u00010\u00160\u0016\u0018\u00010Q0O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/ChatListAdapter;", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "list", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "conversation", "", "D0", "", "input", "A0", "Ljava/lang/Runnable;", "callback", "C0", "Lcom/tencent/mobileqq/guild/config/d;", "currentModelInfo", "B0", "x0", "y0", "E0", "Lqe1/c;", "notifier", "q0", "t0", "Lqe1/a;", "provider", "r0", "u0", "z0", "llmTip", "v0", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w0", "Landroid/app/Activity;", "getActivity", "l0", "m0", "msgId", "", "n0", "isExpand", "o0", "k0", "s0", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "chatAnswerData", "p0", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "I", "Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;", "aiChatListViewModel", "J", "Landroid/app/Activity;", "getHostActivity", "()Landroid/app/Activity;", "hostActivity", "Lkotlin/Function1;", "K", "Lkotlin/jvm/functions/Function1;", "getRefreshChatSession", "()Lkotlin/jvm/functions/Function1;", "refreshChatSession", "L", "onDataStreamUpdateInject", "Lkotlin/Function0;", "M", "Lkotlin/jvm/functions/Function0;", "checkShowJumpButton", "", "N", "Ljava/util/List;", "chatList", "P", "Lcom/tencent/mobileqq/guild/config/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "currentAiChatSession", "", "kotlin.jvm.PlatformType", "", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/Set;", "configNotifiers", ExifInterface.LATITUDE_SOUTH, "Lqe1/a;", "currentCopyTextProvider", "<init>", "(Lcom/tencent/mobileqq/guild/aisearch/AIChatListViewModel;Landroid/app/Activity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChatListAdapter extends GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final AIChatListViewModel aiChatListViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Activity hostActivity;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Function1<String, Unit> refreshChatSession;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Function1<ChatAnswerData, Unit> onDataStreamUpdateInject;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> checkShowJumpButton;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.guild.aisearch.models.a> chatList;

    /* renamed from: P, reason: from kotlin metadata */
    private GuildAISearchModel currentModelInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private AiChatSession currentAiChatSession;

    /* renamed from: R, reason: from kotlin metadata */
    private final Set<qe1.c> configNotifiers;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private qe1.a currentCopyTextProvider;

    public /* synthetic */ ChatListAdapter(AIChatListViewModel aIChatListViewModel, Activity activity, Function1 function1, Function1 function12, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aIChatListViewModel, activity, (i3 & 4) != 0 ? new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.ChatListAdapter.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        } : function1, (i3 & 8) != 0 ? new Function1<ChatAnswerData, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.ChatListAdapter.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ChatAnswerData it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatAnswerData chatAnswerData) {
                invoke2(chatAnswerData);
                return Unit.INSTANCE;
            }
        } : function12, (i3 & 16) != 0 ? new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.ChatListAdapter.3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0);
    }

    private final String A0(String input) {
        CharSequence trim;
        trim = StringsKt__StringsKt.trim((CharSequence) input);
        return new Regex("[\\n\\t\\s]+").replace(trim.toString(), " ");
    }

    private final void D0(List<? extends com.tencent.mobileqq.guild.aisearch.models.a> list, AiChatSession conversation) {
        this.currentAiChatSession = conversation;
        this.chatList.clear();
        this.chatList.addAll(list);
        Logger.f235387a.d().d("guild.ai.search.AIChatListPart", 1, "LLMChatPicture setShareDataOnly list:" + list);
    }

    public final void B0(@NotNull GuildAISearchModel currentModelInfo) {
        Intrinsics.checkNotNullParameter(currentModelInfo, "currentModelInfo");
        this.currentModelInfo = currentModelInfo;
    }

    public final void C0(@NotNull AiChatSession conversation, @Nullable Runnable callback) {
        StateFlow<ChatAnswerData> b16;
        ChatAnswerData value;
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        this.currentAiChatSession = conversation;
        this.aiChatListViewModel.R1().clear();
        ArrayList arrayList = new ArrayList();
        this.chatList.clear();
        this.chatList.addAll(conversation.g());
        arrayList.addAll(this.chatList);
        a.AnswerItem e16 = conversation.e();
        boolean z16 = false;
        if (e16 != null && (b16 = e16.b()) != null && (value = b16.getValue()) != null && value.k()) {
            z16 = true;
        }
        if (z16) {
            E0(callback);
        } else {
            submitList(arrayList, callback);
        }
    }

    public final void E0(@Nullable Runnable callback) {
        Object last;
        if (!this.chatList.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.chatList);
            if (last instanceof a.e) {
                CollectionsKt__MutableCollectionsKt.removeLast(this.chatList);
            }
        }
        this.chatList.add(new a.e(ViewUtils.dpToPx(12.0f)));
        this.chatList.add(new a.d());
        this.chatList.add(new a.e(ViewUtils.dpToPx(64.0f)));
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.chatList);
        setItems(arrayList, callback);
    }

    @Override // qe1.b
    @NotNull
    /* renamed from: getActivity, reason: from getter */
    public Activity getHostActivity() {
        return this.hostActivity;
    }

    @Override // qe1.b
    public void k0() {
        this.checkShowJumpButton.invoke();
    }

    @Override // qe1.b
    @NotNull
    public String l0() {
        String str;
        a.AnswerItem e16;
        StateFlow<ChatAnswerData> b16;
        ChatAnswerData value;
        try {
            qe1.a aVar = this.currentCopyTextProvider;
            String str2 = null;
            if (aVar != null) {
                str = aVar.i();
            } else {
                str = null;
            }
            if (StringUtil.isEmpty(str)) {
                AiChatSession value2 = this.aiChatListViewModel.Q1().getValue();
                if (value2 != null && (e16 = value2.e()) != null && (b16 = e16.b()) != null && (value = b16.getValue()) != null) {
                    str2 = value.a();
                }
                if (str2 == null) {
                    return "";
                }
                return str2;
            }
            Logger.f235387a.d().d("ChatListAdapter", 1, "return getCopyText");
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception unused) {
            Logger.f235387a.d().d("ChatListAdapter", 1, "getContentText failed");
            return "";
        }
    }

    @Override // qe1.b
    @Nullable
    public AiChatSession m0() {
        return this.aiChatListViewModel.Q1().getValue();
    }

    @Override // qe1.b
    public boolean n0(@NotNull String msgId) {
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Boolean bool = this.aiChatListViewModel.R1().get(msgId);
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @Override // qe1.b
    public void o0(@NotNull String msgId, boolean isExpand) {
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        this.aiChatListViewModel.R1().put(msgId, Boolean.valueOf(isExpand));
    }

    @Override // qe1.b
    public void p0(@NotNull ChatAnswerData chatAnswerData) {
        Intrinsics.checkNotNullParameter(chatAnswerData, "chatAnswerData");
        this.onDataStreamUpdateInject.invoke(chatAnswerData);
    }

    @Override // qe1.b
    public void q0(@NotNull qe1.c notifier) {
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.configNotifiers.add(notifier);
    }

    @Override // qe1.b
    public void r0(@NotNull qe1.a provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.currentCopyTextProvider = provider;
    }

    @Override // qe1.b
    public void s0() {
        String str;
        Function1<String, Unit> function1 = this.refreshChatSession;
        AiChatSession aiChatSession = this.currentAiChatSession;
        if (aiChatSession != null) {
            str = aiChatSession.getSessionId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        function1.invoke(str);
    }

    @Override // qe1.b
    public void t0(@NotNull qe1.c notifier) {
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.configNotifiers.remove(notifier);
    }

    @Override // qe1.b
    public void u0(@NotNull qe1.a provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (Intrinsics.areEqual(this.currentCopyTextProvider, provider)) {
            this.currentCopyTextProvider = null;
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator.b
    @Nullable
    public Object v0(@NotNull String str, @NotNull Continuation<? super GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder>> continuation) {
        Continuation intercepted;
        Object m476constructorimpl;
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        boolean isBlank;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        try {
            Result.Companion companion = Result.INSTANCE;
            final ChatListAdapter chatListAdapter = new ChatListAdapter(this.aiChatListViewModel, this.hostActivity, null, null, null, 28, null);
            GuildAISearchModel guildAISearchModel = this.currentModelInfo;
            if (guildAISearchModel != null) {
                if (guildAISearchModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentModelInfo");
                    guildAISearchModel = null;
                }
                chatListAdapter.B0(guildAISearchModel);
            }
            ArrayList arrayList = new ArrayList();
            AiChatSession value = this.aiChatListViewModel.Q1().getValue();
            Intrinsics.checkNotNull(value);
            List<com.tencent.mobileqq.guild.aisearch.models.a> g16 = value.g();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (Object obj : g16) {
                if (obj instanceof a.QuestionItem) {
                    obj = a.QuestionItem.c((a.QuestionItem) obj, null, A0(((a.QuestionItem) obj).getQuestion()), 0L, 5, null);
                }
                arrayList2.add(obj);
            }
            arrayList.addAll(arrayList2);
            Logger.f235387a.d().c("guild.ai.search.AIChatListPart", 1, "clone listItems " + arrayList);
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                arrayList.add(new a.AISource(str));
            }
            AiChatSession value2 = this.aiChatListViewModel.Q1().getValue();
            Intrinsics.checkNotNull(value2);
            chatListAdapter.D0(arrayList, value2);
            chatListAdapter.setItems(arrayList, new Runnable() { // from class: com.tencent.mobileqq.guild.aisearch.ChatListAdapter$clone$2$1$4
                @Override // java.lang.Runnable
                public final void run() {
                    Continuation<GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder>> continuation2 = safeContinuation;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(chatListAdapter));
                }
            });
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            safeContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(m479exceptionOrNullimpl)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator.b
    @NotNull
    public String w0() {
        GuildAISearchModel guildAISearchModel = this.currentModelInfo;
        if (guildAISearchModel != null) {
            if (guildAISearchModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentModelInfo");
                guildAISearchModel = null;
            }
            return guildAISearchModel.getModelShareInfo();
        }
        return "";
    }

    public final void x0() {
        Object last;
        if (!this.chatList.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.chatList);
            if (!(last instanceof a.e)) {
                this.chatList.add(new a.e(ViewUtils.dpToPx(32.0f)));
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.chatList);
                setItems(arrayList);
            }
        }
    }

    public final void y0() {
        Iterator<com.tencent.mobileqq.guild.aisearch.models.a> it = this.chatList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.guild.aisearch.models.a next = it.next();
            if (next.a() == 3 || next.a() == 5) {
                it.remove();
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.chatList);
        setItems(arrayList);
    }

    public final void z0() {
        Set<qe1.c> configNotifiers = this.configNotifiers;
        Intrinsics.checkNotNullExpressionValue(configNotifiers, "configNotifiers");
        Iterator<T> it = configNotifiers.iterator();
        while (it.hasNext()) {
            ((qe1.c) it.next()).h();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatListAdapter(@NotNull AIChatListViewModel aiChatListViewModel, @NotNull Activity hostActivity, @NotNull Function1<? super String, Unit> refreshChatSession, @NotNull Function1<? super ChatAnswerData, Unit> onDataStreamUpdateInject, @NotNull Function0<Unit> checkShowJumpButton) {
        Intrinsics.checkNotNullParameter(aiChatListViewModel, "aiChatListViewModel");
        Intrinsics.checkNotNullParameter(hostActivity, "hostActivity");
        Intrinsics.checkNotNullParameter(refreshChatSession, "refreshChatSession");
        Intrinsics.checkNotNullParameter(onDataStreamUpdateInject, "onDataStreamUpdateInject");
        Intrinsics.checkNotNullParameter(checkShowJumpButton, "checkShowJumpButton");
        this.aiChatListViewModel = aiChatListViewModel;
        this.hostActivity = hostActivity;
        this.refreshChatSession = refreshChatSession;
        this.onDataStreamUpdateInject = onDataStreamUpdateInject;
        this.checkShowJumpButton = checkShowJumpButton;
        this.chatList = new ArrayList();
        this.configNotifiers = Collections.newSetFromMap(new WeakHashMap());
        this.f236209m.c(new UserMsgAdapterDelegate());
        this.f236209m.c(new AIMsgAdapterDelegate(this));
        this.f236209m.c(new ShareAIMsgDelegate(this));
        this.f236209m.c(new SpaceHolderDelegate());
        this.f236209m.c(new GuildSearchLLMChatAISourceMsgDelegate());
    }
}
