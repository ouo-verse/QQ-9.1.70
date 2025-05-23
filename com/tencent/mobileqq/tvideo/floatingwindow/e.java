package com.tencent.mobileqq.tvideo.floatingwindow;

import android.view.View;
import androidx.lifecycle.Observer;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class e implements Observer<Integer> {

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference<View> f304438d;

    public e(View view) {
        this.f304438d = new WeakReference<>(view);
    }
}
