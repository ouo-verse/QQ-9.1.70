package com.tencent.gamematrix.gmcg.sdk.nonage.bean;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNonageGetUserAgeResp {
    private int errCode;
    private info result;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class info {
        private int age;
        private int ret;

        public int getAge() {
            return this.age;
        }

        public int getRet() {
            return this.ret;
        }
    }

    public int getErrCode() {
        return this.errCode;
    }

    public info getResult() {
        return this.result;
    }
}
