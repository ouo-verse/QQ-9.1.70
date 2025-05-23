package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$a;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$b;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$c;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$d;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$e;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$f;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class q {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$a;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends q {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f231710a = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$b;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "reason", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class Failed extends q {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(@NotNull String reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Failed) && Intrinsics.areEqual(this.reason, ((Failed) other).reason)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        @NotNull
        public String toString() {
            return "Failed(reason=" + this.reason + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$c;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends q {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f231712a = new c();

        c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$d;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getContentUUID", "()Ljava/lang/String;", "contentUUID", "b", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q$d, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class ReceiveContent extends q {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String contentUUID;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReceiveContent(@NotNull String contentUUID, @NotNull String content) {
            super(null);
            Intrinsics.checkNotNullParameter(contentUUID, "contentUUID");
            Intrinsics.checkNotNullParameter(content, "content");
            this.contentUUID = contentUUID;
            this.content = content;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReceiveContent)) {
                return false;
            }
            ReceiveContent receiveContent = (ReceiveContent) other;
            if (Intrinsics.areEqual(this.contentUUID, receiveContent.contentUUID) && Intrinsics.areEqual(this.content, receiveContent.content)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.contentUUID.hashCode() * 31) + this.content.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReceiveContent(contentUUID=" + this.contentUUID + ", content=" + this.content + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$e;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends q {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final e f231715a = new e();

        e() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q$f;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getContentUUID", "()Ljava/lang/String;", "contentUUID", "b", "reasonContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q$f, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class ReceiveReasonContent extends q {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String contentUUID;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String reasonContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReceiveReasonContent(@NotNull String contentUUID, @NotNull String reasonContent) {
            super(null);
            Intrinsics.checkNotNullParameter(contentUUID, "contentUUID");
            Intrinsics.checkNotNullParameter(reasonContent, "reasonContent");
            this.contentUUID = contentUUID;
            this.reasonContent = reasonContent;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getReasonContent() {
            return this.reasonContent;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReceiveReasonContent)) {
                return false;
            }
            ReceiveReasonContent receiveReasonContent = (ReceiveReasonContent) other;
            if (Intrinsics.areEqual(this.contentUUID, receiveReasonContent.contentUUID) && Intrinsics.areEqual(this.reasonContent, receiveReasonContent.reasonContent)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.contentUUID.hashCode() * 31) + this.reasonContent.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReceiveReasonContent(contentUUID=" + this.contentUUID + ", reasonContent=" + this.reasonContent + ")";
        }
    }

    public /* synthetic */ q(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    q() {
    }
}
