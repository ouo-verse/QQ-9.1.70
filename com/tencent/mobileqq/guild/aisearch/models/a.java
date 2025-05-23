package com.tencent.mobileqq.guild.aisearch.models;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\b\t\n\u000bB\t\b\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0005\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/a;", "", "", "a", "()I", "viewType", "<init>", "()V", "b", "c", "d", "e", "Lcom/tencent/mobileqq/guild/aisearch/models/a$a;", "Lcom/tencent/mobileqq/guild/aisearch/models/a$b;", "Lcom/tencent/mobileqq/guild/aisearch/models/a$c;", "Lcom/tencent/mobileqq/guild/aisearch/models/a$d;", "Lcom/tencent/mobileqq/guild/aisearch/models/a$e;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/a$a;", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "content", "", "J", "getStableId", "()J", "stableId", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class AISource extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long stableId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AISource(@NotNull String content) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
            this.stableId = hashCode();
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AISource) && Intrinsics.areEqual(this.content, ((AISource) other).content)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        @NotNull
        public String toString() {
            return "AISource(content=" + this.content + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020\u001e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/a$b;", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "messageId", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "b", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "answerFlow", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "e", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "searchInfo", "d", "modelType", "getModelName", "modelName", "", "f", "J", "getTimestamp", "()J", "timestamp", "g", "getStableId", "stableId", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/flow/StateFlow;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;Ljava/lang/String;Ljava/lang/String;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.a$b, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class AnswerItem extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String messageId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final StateFlow<ChatAnswerData> answerFlow;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final IGProGuildSearchAISearchInfo searchInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String modelType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String modelName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final long timestamp;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final long stableId;

        public /* synthetic */ AnswerItem(String str, StateFlow stateFlow, IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo, String str2, String str3, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, stateFlow, iGProGuildSearchAISearchInfo, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? 0L : j3);
        }

        @NotNull
        public final StateFlow<ChatAnswerData> b() {
            return this.answerFlow;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getModelType() {
            return this.modelType;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final IGProGuildSearchAISearchInfo getSearchInfo() {
            return this.searchInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnswerItem)) {
                return false;
            }
            AnswerItem answerItem = (AnswerItem) other;
            if (Intrinsics.areEqual(this.messageId, answerItem.messageId) && Intrinsics.areEqual(this.answerFlow, answerItem.answerFlow) && Intrinsics.areEqual(this.searchInfo, answerItem.searchInfo) && Intrinsics.areEqual(this.modelType, answerItem.modelType) && Intrinsics.areEqual(this.modelName, answerItem.modelName) && this.timestamp == answerItem.timestamp) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.messageId.hashCode() * 31) + this.answerFlow.hashCode()) * 31;
            IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo = this.searchInfo;
            if (iGProGuildSearchAISearchInfo == null) {
                hashCode = 0;
            } else {
                hashCode = iGProGuildSearchAISearchInfo.hashCode();
            }
            return ((((((hashCode2 + hashCode) * 31) + this.modelType.hashCode()) * 31) + this.modelName.hashCode()) * 31) + androidx.fragment.app.a.a(this.timestamp);
        }

        @NotNull
        public String toString() {
            return "AnswerItem(messageId=" + this.messageId + ", answerFlow=" + this.answerFlow + ", searchInfo=" + this.searchInfo + ", modelType=" + this.modelType + ", modelName=" + this.modelName + ", timestamp=" + this.timestamp + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnswerItem(@NotNull String messageId, @NotNull StateFlow<ChatAnswerData> answerFlow, @Nullable IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo, @NotNull String modelType, @NotNull String modelName, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(answerFlow, "answerFlow");
            Intrinsics.checkNotNullParameter(modelType, "modelType");
            Intrinsics.checkNotNullParameter(modelName, "modelName");
            this.messageId = messageId;
            this.answerFlow = answerFlow;
            this.searchInfo = iGProGuildSearchAISearchInfo;
            this.modelType = modelType;
            this.modelName = modelName;
            this.timestamp = j3;
            this.stableId = Objects.hash(answerFlow, iGProGuildSearchAISearchInfo, messageId, Long.valueOf(j3));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/a$c;", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "", "messageId", "question", "", "timestamp", "b", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "e", "c", "J", "getTimestamp", "()J", "getStableId", "stableId", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.a$c, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class QuestionItem extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String messageId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String question;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long timestamp;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long stableId;

        public /* synthetic */ QuestionItem(String str, String str2, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i3 & 4) != 0 ? 0L : j3);
        }

        public static /* synthetic */ QuestionItem c(QuestionItem questionItem, String str, String str2, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = questionItem.messageId;
            }
            if ((i3 & 2) != 0) {
                str2 = questionItem.question;
            }
            if ((i3 & 4) != 0) {
                j3 = questionItem.timestamp;
            }
            return questionItem.b(str, str2, j3);
        }

        @NotNull
        public final QuestionItem b(@NotNull String messageId, @NotNull String question, long timestamp) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(question, "question");
            return new QuestionItem(messageId, question, timestamp);
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getQuestion() {
            return this.question;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuestionItem)) {
                return false;
            }
            QuestionItem questionItem = (QuestionItem) other;
            if (Intrinsics.areEqual(this.messageId, questionItem.messageId) && Intrinsics.areEqual(this.question, questionItem.question) && this.timestamp == questionItem.timestamp) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.messageId.hashCode() * 31) + this.question.hashCode()) * 31) + androidx.fragment.app.a.a(this.timestamp);
        }

        @NotNull
        public String toString() {
            return "QuestionItem(messageId=" + this.messageId + ", question=" + this.question + ", timestamp=" + this.timestamp + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuestionItem(@NotNull String messageId, @NotNull String question, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(question, "question");
            this.messageId = messageId;
            this.question = question;
            this.timestamp = j3;
            this.stableId = question.hashCode();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/a$d;", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "", "a", "J", "getStableId", "()J", "stableId", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long stableId;

        public d() {
            super(null);
            this.stableId = hashCode();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/a$e;", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "", "a", "I", "b", "()I", "height", "", "J", "getStableId", "()J", "stableId", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int height;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long stableId;

        public e(int i3) {
            super(null);
            this.height = i3;
            this.stableId = hashCode();
        }

        /* renamed from: b, reason: from getter */
        public final int getHeight() {
            return this.height;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int a() {
        if (this instanceof QuestionItem) {
            return 1;
        }
        if (this instanceof AnswerItem) {
            return 2;
        }
        if (this instanceof d) {
            return 3;
        }
        if (this instanceof e) {
            return 5;
        }
        if (this instanceof AISource) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    a() {
    }
}
