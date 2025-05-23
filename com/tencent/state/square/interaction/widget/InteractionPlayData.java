package com.tencent.state.square.interaction.widget;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/interaction/widget/InteractionPlayData;", "", "optionId", "", "pagUrl", "", "text", "(JLjava/lang/String;Ljava/lang/String;)V", "getOptionId", "()J", "getPagUrl", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InteractionPlayData {
    private final long optionId;
    private final String pagUrl;
    private final String text;

    public InteractionPlayData(long j3, String pagUrl, String text) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        this.optionId = j3;
        this.pagUrl = pagUrl;
        this.text = text;
    }

    /* renamed from: component1, reason: from getter */
    public final long getOptionId() {
        return this.optionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPagUrl() {
        return this.pagUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final InteractionPlayData copy(long optionId, String pagUrl, String text) {
        Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
        Intrinsics.checkNotNullParameter(text, "text");
        return new InteractionPlayData(optionId, pagUrl, text);
    }

    public final long getOptionId() {
        return this.optionId;
    }

    public final String getPagUrl() {
        return this.pagUrl;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int a16 = c.a(this.optionId) * 31;
        String str = this.pagUrl;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.text;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InteractionPlayData(optionId=" + this.optionId + ", pagUrl=" + this.pagUrl + ", text=" + this.text + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionPlayData)) {
            return false;
        }
        InteractionPlayData interactionPlayData = (InteractionPlayData) other;
        return this.optionId == interactionPlayData.optionId && Intrinsics.areEqual(this.pagUrl, interactionPlayData.pagUrl) && Intrinsics.areEqual(this.text, interactionPlayData.text);
    }

    public static /* synthetic */ InteractionPlayData copy$default(InteractionPlayData interactionPlayData, long j3, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = interactionPlayData.optionId;
        }
        if ((i3 & 2) != 0) {
            str = interactionPlayData.pagUrl;
        }
        if ((i3 & 4) != 0) {
            str2 = interactionPlayData.text;
        }
        return interactionPlayData.copy(j3, str, str2);
    }
}
