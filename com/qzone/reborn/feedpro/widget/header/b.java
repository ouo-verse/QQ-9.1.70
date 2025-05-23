package com.qzone.reborn.feedpro.widget.header;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface b {
    int e();

    View getContainerView();

    LifecycleOwner getLifecycleOwner();

    <T extends ViewModel> T p(Class<T> cls);
}
