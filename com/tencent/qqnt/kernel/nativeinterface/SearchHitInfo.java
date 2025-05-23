package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchHitInfo {
    public int end;
    public String hitText = "";
    public int start;

    public int getEnd() {
        return this.end;
    }

    public String getHitText() {
        return this.hitText;
    }

    public int getStart() {
        return this.start;
    }

    public String toString() {
        return "SearchHitInfo{start=" + this.start + ",end=" + this.end + ",hitText=" + this.hitText + ",}";
    }
}
