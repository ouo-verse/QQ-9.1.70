package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/data/SquareStyleInfo;", "", "styleId", "", "picUrl", "", "(ILjava/lang/String;)V", "getPicUrl", "()Ljava/lang/String;", "setPicUrl", "(Ljava/lang/String;)V", "getStyleId", "()I", "setStyleId", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareStyleInfo {
    private String picUrl;
    private int styleId;

    public SquareStyleInfo(int i3, String picUrl) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        this.styleId = i3;
        this.picUrl = picUrl;
    }

    /* renamed from: component1, reason: from getter */
    public final int getStyleId() {
        return this.styleId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    public final SquareStyleInfo copy(int styleId, String picUrl) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        return new SquareStyleInfo(styleId, picUrl);
    }

    public final String getPicUrl() {
        return this.picUrl;
    }

    public final int getStyleId() {
        return this.styleId;
    }

    public int hashCode() {
        int i3 = this.styleId * 31;
        String str = this.picUrl;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public final void setPicUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.picUrl = str;
    }

    public final void setStyleId(int i3) {
        this.styleId = i3;
    }

    public String toString() {
        return "SquareStyleInfo(styleId=" + this.styleId + ", picUrl=" + this.picUrl + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareStyleInfo)) {
            return false;
        }
        SquareStyleInfo squareStyleInfo = (SquareStyleInfo) other;
        return this.styleId == squareStyleInfo.styleId && Intrinsics.areEqual(this.picUrl, squareStyleInfo.picUrl);
    }

    public static /* synthetic */ SquareStyleInfo copy$default(SquareStyleInfo squareStyleInfo, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = squareStyleInfo.styleId;
        }
        if ((i16 & 2) != 0) {
            str = squareStyleInfo.picUrl;
        }
        return squareStyleInfo.copy(i3, str);
    }
}
