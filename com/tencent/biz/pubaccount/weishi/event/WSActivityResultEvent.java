package com.tencent.biz.pubaccount.weishi.event;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSActivityResultEvent extends WSSimpleBaseEvent {
    private final Intent data;
    private final int requestCode;
    private final int resultCode;

    public WSActivityResultEvent(int i3, int i16, Intent intent) {
        this.requestCode = i3;
        this.resultCode = i16;
        this.data = intent;
    }

    public Intent getData() {
        return this.data;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public int getResultCode() {
        return this.resultCode;
    }
}
