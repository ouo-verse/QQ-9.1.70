package com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame;

import com.tencent.gamematrix.gmcg.api.GmCgKingsHonorMidGameErrorCode;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGKingsHonorMidAbnormalResponse {
    private int ack;
    private Data data;
    public long seq;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Data {

        @GmCgKingsHonorMidGameErrorCode
        public Integer err_code;
        public String message_type;
    }

    public Integer getErrorCode() {
        Data data = this.data;
        if (data != null) {
            return data.err_code;
        }
        return null;
    }
}
