package com.qq.e.tg.cfg;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class VideoResultReceiver extends ResultReceiver {
    public VideoResultReceiver(Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i3, Bundle bundle) {
        super.onReceiveResult(i3, bundle);
        if (i3 == -1 && bundle != null) {
            onReceiveResult(bundle);
        }
    }

    public abstract void onReceiveResult(Bundle bundle);
}
