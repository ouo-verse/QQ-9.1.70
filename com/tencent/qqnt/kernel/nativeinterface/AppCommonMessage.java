package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AppCommonMessage implements Serializable {
    public int type;
    long serialVersionUID = 1;

    /* renamed from: msg, reason: collision with root package name */
    public byte[] f359159msg = new byte[0];

    public byte[] getMsg() {
        return this.f359159msg;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "AppCommonMessage{type=" + this.type + ",msg=" + this.f359159msg + ",}";
    }
}
