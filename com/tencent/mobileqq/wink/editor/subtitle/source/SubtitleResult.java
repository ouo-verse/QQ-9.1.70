package com.tencent.mobileqq.wink.editor.subtitle.source;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleResult;", "", "items", "", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLine;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class SubtitleResult {

    @Nullable
    private List<SubtitleLine> items;

    public SubtitleResult() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubtitleResult copy$default(SubtitleResult subtitleResult, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = subtitleResult.items;
        }
        return subtitleResult.copy(list);
    }

    @Nullable
    public final List<SubtitleLine> component1() {
        return this.items;
    }

    @NotNull
    public final SubtitleResult copy(@Nullable List<SubtitleLine> items) {
        return new SubtitleResult(items);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SubtitleResult) && Intrinsics.areEqual(this.items, ((SubtitleResult) other).items)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<SubtitleLine> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<SubtitleLine> list = this.items;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setItems(@Nullable List<SubtitleLine> list) {
        this.items = list;
    }

    @NotNull
    public String toString() {
        return "SubtitleResult(items=" + this.items + ")";
    }

    public SubtitleResult(@Nullable List<SubtitleLine> list) {
        this.items = list;
    }

    public /* synthetic */ SubtitleResult(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
    }
}
