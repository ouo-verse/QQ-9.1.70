package com.huya.huyasdk.data;

import com.huya.huyasdk.data.LongRequest;
import hynb.o.c;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ShortRequest {
    public BaseShortRequest baseShortRequest;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        public String sBuffer;
        public String sFuncName;
        public String sServantName;
        public int iVersion = 4;
        public int iRequestId = LongRequest.Builder.sTaskIdProducer.incrementAndGet();

        public ShortRequest build() {
            return new ShortRequest(this);
        }

        public Builder iRequestId(int i3) {
            this.iRequestId = i3;
            return this;
        }

        public Builder iVersion(int i3) {
            this.iVersion = i3;
            return this;
        }

        public Builder sBuffer(String str) {
            this.sBuffer = str;
            return this;
        }

        public Builder sBufferObj(Object obj) {
            this.sBuffer = c.a(obj);
            return this;
        }

        public Builder sFuncName(String str) {
            this.sFuncName = str;
            return this;
        }

        public Builder sServantName(String str) {
            this.sServantName = str;
            return this;
        }
    }

    public ShortRequest(Builder builder) {
        BaseShortRequest baseShortRequest = new BaseShortRequest();
        this.baseShortRequest = baseShortRequest;
        baseShortRequest.iVersion = Integer.valueOf(builder.iVersion);
        this.baseShortRequest.iRequestId = Integer.valueOf(builder.iRequestId);
        BaseShortRequest baseShortRequest2 = this.baseShortRequest;
        baseShortRequest2.sFuncName = builder.sFuncName;
        baseShortRequest2.sServantName = builder.sServantName;
        baseShortRequest2.sBuffer = builder.sBuffer;
    }

    public int getIRequestId() {
        return this.baseShortRequest.iRequestId.intValue();
    }

    public String toJsonString() {
        return c.a(this.baseShortRequest);
    }
}
