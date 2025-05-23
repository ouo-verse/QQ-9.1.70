package com.tencent.gamecenter.wadl.api.widget;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FloatKeepLiveView extends FrameLayout {
    public FloatKeepLiveView(Context context) {
        super(context);
        setClickable(false);
        setFocusable(false);
        QLog.d("WadlFloat_FloatKeepLiveView", 1, "new Instance...");
    }

    public void a() {
        QLog.d("WadlFloat_FloatKeepLiveView", 1, "onDestroy...");
    }
}
