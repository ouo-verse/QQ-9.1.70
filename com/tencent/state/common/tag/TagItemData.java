package com.tencent.state.common.tag;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/common/tag/TagItemData;", "", "text", "", "isCheck", "", "(Ljava/lang/String;Z)V", "()Z", "setCheck", "(Z)V", "getText", "()Ljava/lang/String;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class TagItemData {
    private boolean isCheck;
    private final String text;

    public TagItemData(String text, boolean z16) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.isCheck = z16;
    }

    public final String getText() {
        return this.text;
    }

    /* renamed from: isCheck, reason: from getter */
    public final boolean getIsCheck() {
        return this.isCheck;
    }

    public final void setCheck(boolean z16) {
        this.isCheck = z16;
    }

    public /* synthetic */ TagItemData(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16);
    }
}
