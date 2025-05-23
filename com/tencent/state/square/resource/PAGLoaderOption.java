package com.tencent.state.square.resource;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/resource/PAGLoaderOption;", "", "repeatCount", "", "(I)V", "getRepeatCount", "()I", "setRepeatCount", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PAGLoaderOption {
    private int repeatCount;

    public PAGLoaderOption() {
        this(0, 1, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final PAGLoaderOption copy(int repeatCount) {
        return new PAGLoaderOption(repeatCount);
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public int hashCode() {
        return this.repeatCount;
    }

    public final void setRepeatCount(int i3) {
        this.repeatCount = i3;
    }

    public String toString() {
        return "PAGLoaderOption(repeatCount=" + this.repeatCount + ")";
    }

    public PAGLoaderOption(int i3) {
        this.repeatCount = i3;
    }

    public /* synthetic */ PAGLoaderOption(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PAGLoaderOption) && this.repeatCount == ((PAGLoaderOption) other).repeatCount;
        }
        return true;
    }

    public static /* synthetic */ PAGLoaderOption copy$default(PAGLoaderOption pAGLoaderOption, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = pAGLoaderOption.repeatCount;
        }
        return pAGLoaderOption.copy(i3);
    }
}
