package com.tencent.timi.game.profile.impl;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import hi4.b;

/* loaded from: classes26.dex */
public class ProfileDestroyObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void whenDestroy() {
        ((b) mm4.b.b(b.class)).x1("ProfileActivity.destroy");
    }
}
