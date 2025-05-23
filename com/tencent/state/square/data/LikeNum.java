package com.tencent.state.square.data;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/data/LikeNum;", "", "likeType", "", WidgetCacheConstellationData.NUM, "(II)V", "getLikeType", "()I", "getNum", "setNum", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class LikeNum {
    private final int likeType;
    private int num;

    public LikeNum(int i3, int i16) {
        this.likeType = i3;
        this.num = i16;
    }

    /* renamed from: component1, reason: from getter */
    public final int getLikeType() {
        return this.likeType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getNum() {
        return this.num;
    }

    public final LikeNum copy(int likeType, int num) {
        return new LikeNum(likeType, num);
    }

    public final int getLikeType() {
        return this.likeType;
    }

    public final int getNum() {
        return this.num;
    }

    public int hashCode() {
        return (this.likeType * 31) + this.num;
    }

    public final void setNum(int i3) {
        this.num = i3;
    }

    public String toString() {
        return "LikeNum(likeType=" + this.likeType + ", num=" + this.num + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeNum)) {
            return false;
        }
        LikeNum likeNum = (LikeNum) other;
        return this.likeType == likeNum.likeType && this.num == likeNum.num;
    }

    public static /* synthetic */ LikeNum copy$default(LikeNum likeNum, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = likeNum.likeType;
        }
        if ((i17 & 2) != 0) {
            i16 = likeNum.num;
        }
        return likeNum.copy(i3, i16);
    }
}
