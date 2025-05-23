package com.huya.huyasdk.data;

import hynb.o.c;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HYNSRequest {
    public int channel;
    public int encryptOption;
    public int iCmdType;
    public String jsonBody;
    public String sFuncName;
    public String sServantName;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        public String jsonBody;
        public String sFuncName;
        public String sServantName;
        public int channel = 1;
        public int iCmdType = 3;
        public int encryptOption = 1;

        public HYNSRequest build() {
            return new HYNSRequest(this);
        }

        public Builder channel(int i3) {
            this.channel = i3;
            return this;
        }

        public Builder encryptOption(int i3) {
            this.encryptOption = i3;
            return this;
        }

        public Builder iCmdType(int i3) {
            this.iCmdType = i3;
            return this;
        }

        public Builder jsonBody(String str) {
            this.jsonBody = str;
            return this;
        }

        public Builder jsonBodyObj(Object obj) {
            WupReq wupReq = new WupReq();
            wupReq.tReq = obj;
            this.jsonBody = c.a(wupReq);
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

    public HYNSRequest(Builder builder) {
        this.iCmdType = builder.iCmdType;
        this.sServantName = builder.sServantName;
        this.sFuncName = builder.sFuncName;
        this.jsonBody = builder.jsonBody;
        this.channel = builder.channel;
        this.encryptOption = builder.encryptOption;
    }
}
