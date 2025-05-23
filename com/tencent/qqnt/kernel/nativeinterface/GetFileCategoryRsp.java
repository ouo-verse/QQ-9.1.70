package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetFileCategoryRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public ArrayList<FileCategoryInfo> categoryInfos = new ArrayList<>();

    public ArrayList<FileCategoryInfo> getCategoryInfos() {
        return this.categoryInfos;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }
}
