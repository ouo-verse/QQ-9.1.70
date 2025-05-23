package com.tencent.rmonitor.fd.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdCountable implements Serializable {
    private final int count;
    private final String item;

    public FdCountable(String str, int i3) {
        this.item = str;
        this.count = i3;
    }

    public int getCount() {
        return this.count;
    }

    public String getItem() {
        return this.item;
    }
}
