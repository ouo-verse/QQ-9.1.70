package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchResult {
    public long context;
    public byte[] cookie;
    public boolean isEnd;
    public ArrayList<SearchResultGroup> resultGroup;

    public SearchResult() {
        this.cookie = new byte[0];
        this.resultGroup = new ArrayList<>();
    }

    public long getContext() {
        return this.context;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<SearchResultGroup> getResultGroup() {
        return this.resultGroup;
    }

    public String toString() {
        return "SearchResult{context=" + this.context + ",isEnd=" + this.isEnd + ",cookie=" + this.cookie + ",resultGroup=" + this.resultGroup + ",}";
    }

    public SearchResult(long j3, boolean z16, byte[] bArr, ArrayList<SearchResultGroup> arrayList) {
        this.cookie = new byte[0];
        new ArrayList();
        this.context = j3;
        this.isEnd = z16;
        this.cookie = bArr;
        this.resultGroup = arrayList;
    }
}
