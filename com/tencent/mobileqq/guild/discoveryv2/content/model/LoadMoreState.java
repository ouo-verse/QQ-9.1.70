package com.tencent.mobileqq.guild.discoveryv2.content.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\t\u0010\u001eR\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b \u0010\fR\u0019\u0010$\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b\u0011\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "f", "(Z)V", "isCompleted", "Lri1/a;", "b", "Lri1/a;", "c", "()Lri1/a;", "success", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;", "getLoadMoreType", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;", "loadMoreType", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "Ljava/util/List;", "()Ljava/util/List;", "contentList", "e", "isEnd", "Ljava/lang/String;", "()Ljava/lang/String;", "endMsg", "<init>", "(ZLri1/a;Lcom/tencent/mobileqq/guild/discoveryv2/content/model/LoadMoreType;Ljava/util/List;ZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.model.h, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class LoadMoreState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isCompleted;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ri1.a success;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LoadMoreType loadMoreType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> contentList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String endMsg;

    /* JADX WARN: Multi-variable type inference failed */
    public LoadMoreState(boolean z16, @NotNull ri1.a success, @NotNull LoadMoreType loadMoreType, @Nullable List<? extends com.tencent.mobileqq.guild.discoveryv2.content.base.h> list, boolean z17, @Nullable String str) {
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(loadMoreType, "loadMoreType");
        this.isCompleted = z16;
        this.success = success;
        this.loadMoreType = loadMoreType;
        this.contentList = list;
        this.isEnd = z17;
        this.endMsg = str;
    }

    @Nullable
    public final List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> a() {
        return this.contentList;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getEndMsg() {
        return this.endMsg;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ri1.a getSuccess() {
        return this.success;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsCompleted() {
        return this.isCompleted;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadMoreState)) {
            return false;
        }
        LoadMoreState loadMoreState = (LoadMoreState) other;
        if (this.isCompleted == loadMoreState.isCompleted && Intrinsics.areEqual(this.success, loadMoreState.success) && this.loadMoreType == loadMoreState.loadMoreType && Intrinsics.areEqual(this.contentList, loadMoreState.contentList) && this.isEnd == loadMoreState.isEnd && Intrinsics.areEqual(this.endMsg, loadMoreState.endMsg)) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.isCompleted = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isCompleted;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode2 = ((((r06 * 31) + this.success.hashCode()) * 31) + this.loadMoreType.hashCode()) * 31;
        List<com.tencent.mobileqq.guild.discoveryv2.content.base.h> list = this.contentList;
        int i16 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i17 = (hashCode2 + hashCode) * 31;
        boolean z17 = this.isEnd;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (i17 + i3) * 31;
        String str = this.endMsg;
        if (str != null) {
            i16 = str.hashCode();
        }
        return i18 + i16;
    }

    @NotNull
    public String toString() {
        return "LoadMoreState(isCompleted=" + this.isCompleted + ", success=" + this.success + ", loadMoreType=" + this.loadMoreType + ", contentList=" + this.contentList + ", isEnd=" + this.isEnd + ", endMsg=" + this.endMsg + ")";
    }

    public /* synthetic */ LoadMoreState(boolean z16, ri1.a aVar, LoadMoreType loadMoreType, List list, boolean z17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, aVar, loadMoreType, list, (i3 & 16) != 0 ? false : z17, (i3 & 32) != 0 ? null : str);
    }
}
