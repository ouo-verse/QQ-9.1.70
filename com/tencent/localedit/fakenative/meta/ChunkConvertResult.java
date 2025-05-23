package com.tencent.localedit.fakenative.meta;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ChunkConvertResult {
    public String data;
    public int retCode;
    public String retMsg;
    public int total;

    @NonNull
    public String toString() {
        return "retCode = " + this.retCode + " retMsg = " + this.retMsg + " total = " + this.total;
    }
}
