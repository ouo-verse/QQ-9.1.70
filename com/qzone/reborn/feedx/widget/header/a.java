package com.qzone.reborn.feedx.widget.header;

import android.os.Handler;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface a {
    <T extends ViewModel> T E(Class<T> cls);

    Handler Z();

    int e();

    View getContainerView();

    LifecycleOwner getLifecycleOwner();
}
