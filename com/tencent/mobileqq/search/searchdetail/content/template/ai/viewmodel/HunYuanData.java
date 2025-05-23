package com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/ai/viewmodel/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "state", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "<init>", "(ILjava/lang/String;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.a, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class HunYuanData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    public HunYuanData(int i3, @NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.state = i3;
        this.content = content;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HunYuanData)) {
            return false;
        }
        HunYuanData hunYuanData = (HunYuanData) other;
        if (this.state == hunYuanData.state && Intrinsics.areEqual(this.content, hunYuanData.content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.state * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "HunYuanData(state=" + this.state + ", content=" + this.content + ")";
    }
}
