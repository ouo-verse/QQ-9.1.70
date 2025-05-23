package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsGetSugWordsRsp {
    public long expireTime;
    public ArrayList<String> sugWords = new ArrayList<>();

    public long getExpireTime() {
        return this.expireTime;
    }

    public ArrayList<String> getSugWords() {
        return this.sugWords;
    }

    public String toString() {
        return "UfsGetSugWordsRsp{sugWords=" + this.sugWords + ",expireTime=" + this.expireTime + ",}";
    }
}
