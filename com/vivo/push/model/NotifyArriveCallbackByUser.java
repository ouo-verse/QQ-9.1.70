package com.vivo.push.model;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class NotifyArriveCallbackByUser {
    private Intent mIntent;
    private boolean mIsIntercept;

    public NotifyArriveCallbackByUser(Intent intent, boolean z16) {
        this.mIntent = intent;
        this.mIsIntercept = z16;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public boolean isIntercept() {
        return this.mIsIntercept;
    }
}
