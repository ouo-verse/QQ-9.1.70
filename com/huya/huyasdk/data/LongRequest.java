package com.huya.huyasdk.data;

import android.text.TextUtils;
import hynb.o.c;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LongRequest {
    public BaseLongRequest baseLongRequest;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        public static AtomicInteger sTaskIdProducer = new AtomicInteger(0);
        public String sData = "";
        public int iCmdType = 3;
        public int lRequestId = sTaskIdProducer.incrementAndGet();
        public int iEncryptType = 0;
        public boolean isDataInited = false;

        public LongRequest build() {
            return new LongRequest(this);
        }

        public Builder iCmdType(int i3) {
            this.iCmdType = i3;
            return this;
        }

        public Builder iEncryptType(int i3) {
            this.iEncryptType = i3;
            return this;
        }

        public Builder lRequestId(int i3) {
            this.lRequestId = i3;
            return this;
        }

        public Builder sData(String str) {
            this.sData = str;
            this.isDataInited = true;
            return this;
        }

        public Builder sDataObj(Object obj) {
            this.sData = c.a(obj);
            this.isDataInited = true;
            return this;
        }
    }

    public LongRequest(Builder builder) {
        BaseLongRequest baseLongRequest = new BaseLongRequest();
        this.baseLongRequest = baseLongRequest;
        baseLongRequest.iCmdType = Integer.valueOf(builder.iCmdType);
        this.baseLongRequest.lRequestId = Integer.valueOf(builder.lRequestId);
        BaseLongRequest baseLongRequest2 = this.baseLongRequest;
        baseLongRequest2.sData = builder.sData;
        baseLongRequest2.iEncryptType = Integer.valueOf(builder.iEncryptType);
    }

    public int getICmdType() {
        return this.baseLongRequest.iCmdType.intValue();
    }

    public int getIEncryptType() {
        return this.baseLongRequest.iEncryptType.intValue();
    }

    public int getLRequestId() {
        return this.baseLongRequest.lRequestId.intValue();
    }

    public String getSData() {
        return this.baseLongRequest.sData;
    }

    public void setSData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.baseLongRequest.sData = str;
        }
    }

    public String toJsonString() {
        return c.a(this.baseLongRequest);
    }
}
