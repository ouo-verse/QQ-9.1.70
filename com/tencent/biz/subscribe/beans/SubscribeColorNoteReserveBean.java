package com.tencent.biz.subscribe.beans;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeColorNoteReserveBean implements Serializable {
    public byte[] feedData;
    public int pageType;

    public SubscribeColorNoteReserveBean(byte[] bArr, int i3) {
        this.feedData = bArr;
        this.pageType = i3;
    }
}
