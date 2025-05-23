package com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/Extra;", "", "role", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getRole", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final /* data */ class Extra {

    @SerializedName("content")
    @NotNull
    private final String content;

    @SerializedName("role")
    @NotNull
    private final String role;

    public Extra(@NotNull String role, @NotNull String content) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(content, "content");
        this.role = role;
        this.content = content;
    }

    public static /* synthetic */ Extra copy$default(Extra extra, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = extra.role;
        }
        if ((i3 & 2) != 0) {
            str2 = extra.content;
        }
        return extra.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final Extra copy(@NotNull String role, @NotNull String content) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(content, "content");
        return new Extra(role, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Extra)) {
            return false;
        }
        Extra extra = (Extra) other;
        if (Intrinsics.areEqual(this.role, extra.role) && Intrinsics.areEqual(this.content, extra.content)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getRole() {
        return this.role;
    }

    public int hashCode() {
        return (this.role.hashCode() * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "Extra(role=" + this.role + ", content=" + this.content + ")";
    }
}
