package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSearchRsp {
    public GProUnionResult unionResult = new GProUnionResult();
    public ArrayList<String> highlightWords = new ArrayList<>();

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public GProUnionResult getUnionResult() {
        return this.unionResult;
    }

    public String toString() {
        return "GProGuildSearchRsp{unionResult=" + this.unionResult + ",highlightWords=" + this.highlightWords + ",}";
    }
}
