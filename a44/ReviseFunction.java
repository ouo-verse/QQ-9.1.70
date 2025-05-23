package a44;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"La44/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "b", "questionMarkUrl", "questionMarkMsg", "d", "Z", "getRevise", "()Z", "revise", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: a44.e, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class ReviseFunction {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String questionMarkUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String questionMarkMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean revise;

    public ReviseFunction(@NotNull String title, @NotNull String questionMarkUrl, @NotNull String questionMarkMsg, boolean z16) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(questionMarkUrl, "questionMarkUrl");
        Intrinsics.checkNotNullParameter(questionMarkMsg, "questionMarkMsg");
        this.title = title;
        this.questionMarkUrl = questionMarkUrl;
        this.questionMarkMsg = questionMarkMsg;
        this.revise = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getQuestionMarkMsg() {
        return this.questionMarkMsg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getQuestionMarkUrl() {
        return this.questionMarkUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReviseFunction)) {
            return false;
        }
        ReviseFunction reviseFunction = (ReviseFunction) other;
        if (Intrinsics.areEqual(this.title, reviseFunction.title) && Intrinsics.areEqual(this.questionMarkUrl, reviseFunction.questionMarkUrl) && Intrinsics.areEqual(this.questionMarkMsg, reviseFunction.questionMarkMsg) && this.revise == reviseFunction.revise) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.questionMarkUrl.hashCode()) * 31) + this.questionMarkMsg.hashCode()) * 31;
        boolean z16 = this.revise;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "ReviseFunction(title=" + this.title + ", questionMarkUrl=" + this.questionMarkUrl + ", questionMarkMsg=" + this.questionMarkMsg + ", revise=" + this.revise + ")";
    }
}
