package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBatchGetGuildLabelInfoRsp {
    public ArrayList<GProGuildLabelInfo> list = new ArrayList<>();

    public ArrayList<GProGuildLabelInfo> getList() {
        return this.list;
    }

    public String toString() {
        return "GProBatchGetGuildLabelInfoRsp{list=" + this.list + ",}";
    }
}
