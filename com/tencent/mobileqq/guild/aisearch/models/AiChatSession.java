package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.aisearch.models.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0010BI\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b8\u00109J\u0014\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002JK\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u000f\u0010*R$\u00100\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010,\u001a\u0004\b \u0010-\"\u0004\b.\u0010/R\u0013\u00103\u001a\u0004\u0018\u0001018F\u00a2\u0006\u0006\u001a\u0004\b$\u00102R\u0013\u00106\u001a\u0004\u0018\u0001048F\u00a2\u0006\u0006\u001a\u0004\b(\u00105R\u0013\u00107\u001a\u0004\u0018\u0001048F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/d;", "", "", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "listItems", "j", "", "sessionId", "", "updateSequence", "Lcom/tencent/mobileqq/guild/aisearch/models/i;", "sessionState", "", "cookie", "", "isEnd", "a", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "b", "Ljava/util/List;", "g", "()Ljava/util/List;", "c", "I", "getUpdateSequence", "()I", "d", "Lcom/tencent/mobileqq/guild/aisearch/models/i;", "i", "()Lcom/tencent/mobileqq/guild/aisearch/models/i;", "e", "J", "getCookie", "()J", "f", "Z", "()Z", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "()Lkotlinx/coroutines/Job;", "k", "(Lkotlinx/coroutines/Job;)V", "job", "Lcom/tencent/mobileqq/guild/aisearch/models/a$b;", "()Lcom/tencent/mobileqq/guild/aisearch/models/a$b;", "lastAnswerItem", "Lcom/tencent/mobileqq/guild/aisearch/models/a$c;", "()Lcom/tencent/mobileqq/guild/aisearch/models/a$c;", "lastQuestionItem", "firstQuestionItem", "<init>", "(Ljava/lang/String;Ljava/util/List;ILcom/tencent/mobileqq/guild/aisearch/models/i;JZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.models.d, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class AiChatSession {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<a> listItems;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int updateSequence;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final i sessionState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long cookie;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job job;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0005J8\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/d$a;", "", "", "sessionId", "message", "Lcom/tencent/mobileqq/guild/aisearch/models/d;", "a", "b", "c", "queryMessage", "modelType", "", "errorState", "", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "initList", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.d$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AiChatSession e(Companion companion, String str, String str2, String str3, int i3, List list, int i16, Object obj) {
            if ((i16 & 8) != 0) {
                i3 = 10;
            }
            int i17 = i3;
            if ((i16 & 16) != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            return companion.d(str, str2, str3, i17, list);
        }

        @NotNull
        public final AiChatSession a(@NotNull String sessionId, @NotNull String message) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(message, "message");
            return new AiChatSession(sessionId, null, 0, new i.a(message), 0L, false, 54, null);
        }

        @NotNull
        public final AiChatSession b(@NotNull String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return new AiChatSession(sessionId, null, 0, i.b.f214152a, 0L, false, 54, null);
        }

        @NotNull
        public final AiChatSession c() {
            return new AiChatSession("", null, 0, i.c.f214153a, 0L, false, 54, null);
        }

        @NotNull
        public final AiChatSession d(@NotNull String sessionId, @NotNull String queryMessage, @NotNull String modelType, int errorState, @NotNull List<? extends a> initList) {
            List listOf;
            List plus;
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(queryMessage, "queryMessage");
            Intrinsics.checkNotNullParameter(modelType, "modelType");
            Intrinsics.checkNotNullParameter(initList, "initList");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new a.QuestionItem("", queryMessage, 0L, 4, null), new a.AnswerItem("", StateFlowKt.MutableStateFlow(new ChatAnswerData(errorState, null, null, 0L, 0L, 0L, 62, null)), null, modelType, null, 0L, 48, null)});
            plus = CollectionsKt___CollectionsKt.plus((Collection) initList, (Iterable) listOf);
            return new AiChatSession(sessionId, plus, 0, i.d.f214154a, 0L, true, 20, null);
        }

        Companion() {
        }
    }

    public AiChatSession() {
        this(null, null, 0, null, 0L, false, 63, null);
    }

    public static /* synthetic */ AiChatSession b(AiChatSession aiChatSession, String str, List list, int i3, i iVar, long j3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = aiChatSession.sessionId;
        }
        if ((i16 & 2) != 0) {
            list = aiChatSession.listItems;
        }
        List list2 = list;
        if ((i16 & 4) != 0) {
            i3 = aiChatSession.updateSequence;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            iVar = aiChatSession.sessionState;
        }
        i iVar2 = iVar;
        if ((i16 & 16) != 0) {
            j3 = aiChatSession.cookie;
        }
        long j16 = j3;
        if ((i16 & 32) != 0) {
            z16 = aiChatSession.isEnd;
        }
        return aiChatSession.a(str, list2, i17, iVar2, j16, z16);
    }

    @NotNull
    public final AiChatSession a(@NotNull String sessionId, @NotNull List<? extends a> listItems, int updateSequence, @NotNull i sessionState, long cookie, boolean isEnd) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(listItems, "listItems");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        return new AiChatSession(sessionId, listItems, updateSequence, sessionState, cookie, isEnd);
    }

    @Nullable
    public final a.QuestionItem c() {
        Object obj;
        Iterator<T> it = this.listItems.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((a) obj) instanceof a.QuestionItem) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (!(obj instanceof a.QuestionItem)) {
            return null;
        }
        return (a.QuestionItem) obj;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Job getJob() {
        return this.job;
    }

    @Nullable
    public final a.AnswerItem e() {
        a aVar;
        a aVar2;
        boolean z16;
        List<a> g16 = g();
        ListIterator<a> listIterator = g16.listIterator(g16.size());
        while (true) {
            aVar = null;
            if (listIterator.hasPrevious()) {
                aVar2 = listIterator.previous();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    z16 = aVar3 instanceof a.AnswerItem;
                } else {
                    z16 = true;
                }
                if (z16) {
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
        return (a.AnswerItem) aVar;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiChatSession)) {
            return false;
        }
        AiChatSession aiChatSession = (AiChatSession) other;
        if (Intrinsics.areEqual(this.sessionId, aiChatSession.sessionId) && Intrinsics.areEqual(this.listItems, aiChatSession.listItems) && this.updateSequence == aiChatSession.updateSequence && Intrinsics.areEqual(this.sessionState, aiChatSession.sessionState) && this.cookie == aiChatSession.cookie && this.isEnd == aiChatSession.isEnd) {
            return true;
        }
        return false;
    }

    @Nullable
    public final a.QuestionItem f() {
        a aVar;
        a aVar2;
        boolean z16;
        List<a> g16 = g();
        ListIterator<a> listIterator = g16.listIterator(g16.size());
        while (true) {
            aVar = null;
            if (listIterator.hasPrevious()) {
                aVar2 = listIterator.previous();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    z16 = aVar3 instanceof a.QuestionItem;
                } else {
                    z16 = true;
                }
                if (z16) {
                    break;
                }
            } else {
                aVar2 = null;
                break;
            }
        }
        if (aVar2 instanceof a.QuestionItem) {
            aVar = aVar2;
        }
        return (a.QuestionItem) aVar;
    }

    @NotNull
    public final List<a> g() {
        return this.listItems;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.sessionId.hashCode() * 31) + this.listItems.hashCode()) * 31) + this.updateSequence) * 31) + this.sessionState.hashCode()) * 31) + androidx.fragment.app.a.a(this.cookie)) * 31;
        boolean z16 = this.isEnd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final i getSessionState() {
        return this.sessionState;
    }

    @NotNull
    public final AiChatSession j(@NotNull List<? extends a> listItems) {
        Intrinsics.checkNotNullParameter(listItems, "listItems");
        return b(this, null, listItems, this.updateSequence + 1, null, 0L, false, 57, null);
    }

    public final void k(@Nullable Job job) {
        this.job = job;
    }

    @NotNull
    public String toString() {
        return "AiChatSession(sessionId=" + this.sessionId + ", listItems=" + this.listItems + ", updateSequence=" + this.updateSequence + ", sessionState=" + this.sessionState + ", cookie=" + this.cookie + ", isEnd=" + this.isEnd + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AiChatSession(@NotNull String sessionId, @NotNull List<? extends a> listItems, int i3, @NotNull i sessionState, long j3, boolean z16) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(listItems, "listItems");
        Intrinsics.checkNotNullParameter(sessionState, "sessionState");
        this.sessionId = sessionId;
        this.listItems = listItems;
        this.updateSequence = i3;
        this.sessionState = sessionState;
        this.cookie = j3;
        this.isEnd = z16;
    }

    public /* synthetic */ AiChatSession(String str, List list, int i3, i iVar, long j3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? i.b.f214152a : iVar, (i16 & 16) != 0 ? 0L : j3, (i16 & 32) == 0 ? z16 : false);
    }
}
