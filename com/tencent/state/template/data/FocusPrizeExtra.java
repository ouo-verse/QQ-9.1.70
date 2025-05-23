package com.tencent.state.template.data;

import com.tencent.mobileqq.vas.banner.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/template/data/FocusPrizeExtra;", "Lcom/tencent/state/template/data/BasePrizeExtra;", "focusId", "", "tagId", "", "(JLjava/lang/String;)V", "getFocusId", "()J", "getTagId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class FocusPrizeExtra extends BasePrizeExtra {
    private final long focusId;
    private final String tagId;

    public FocusPrizeExtra(long j3, String tagId) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        this.focusId = j3;
        this.tagId = tagId;
    }

    /* renamed from: component1, reason: from getter */
    public final long getFocusId() {
        return this.focusId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTagId() {
        return this.tagId;
    }

    public final FocusPrizeExtra copy(long focusId, String tagId) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        return new FocusPrizeExtra(focusId, tagId);
    }

    public final long getFocusId() {
        return this.focusId;
    }

    public final String getTagId() {
        return this.tagId;
    }

    public int hashCode() {
        int a16 = c.a(this.focusId) * 31;
        String str = this.tagId;
        return a16 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FocusPrizeExtra(focusId=" + this.focusId + ", tagId=" + this.tagId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FocusPrizeExtra)) {
            return false;
        }
        FocusPrizeExtra focusPrizeExtra = (FocusPrizeExtra) other;
        return this.focusId == focusPrizeExtra.focusId && Intrinsics.areEqual(this.tagId, focusPrizeExtra.tagId);
    }

    public static /* synthetic */ FocusPrizeExtra copy$default(FocusPrizeExtra focusPrizeExtra, long j3, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = focusPrizeExtra.focusId;
        }
        if ((i3 & 2) != 0) {
            str = focusPrizeExtra.tagId;
        }
        return focusPrizeExtra.copy(j3, str);
    }
}
