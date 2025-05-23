package com.tencent.mobileqq.qcircle.api.event;

import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HostActivityResultEvent extends SimpleBaseEvent {
    private final int mHostContextHashCode;
    private final Intent mIntent;
    private final int mRequestCode;
    private final int mResultCode;
    private final int mShadowTopContextHashCode;

    public HostActivityResultEvent(int i3, int i16, int i17, int i18, Intent intent) {
        this.mHostContextHashCode = i3;
        this.mShadowTopContextHashCode = i16;
        this.mRequestCode = i17;
        this.mResultCode = i18;
        this.mIntent = intent;
    }

    public int getHostContextHashCode() {
        return this.mHostContextHashCode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public int getShadowTopContextHashCode() {
        return this.mShadowTopContextHashCode;
    }
}
