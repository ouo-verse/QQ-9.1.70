package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBatchBotGetCommandResponse {
    public ArrayList<GProBotFeatures> botFeatures;
    public int nextPage;

    public GProBatchBotGetCommandResponse() {
        this.botFeatures = new ArrayList<>();
    }

    public ArrayList<GProBotFeatures> getBotFeatures() {
        return this.botFeatures;
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public String toString() {
        return "GProBatchBotGetCommandResponse{botFeatures=" + this.botFeatures + ",nextPage=" + this.nextPage + ",}";
    }

    public GProBatchBotGetCommandResponse(ArrayList<GProBotFeatures> arrayList, int i3) {
        new ArrayList();
        this.botFeatures = arrayList;
        this.nextPage = i3;
    }
}
