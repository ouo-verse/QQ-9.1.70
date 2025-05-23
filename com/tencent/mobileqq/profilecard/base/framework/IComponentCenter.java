package com.tencent.mobileqq.profilecard.base.framework;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IComponentCenter extends IComponentLifecycle {
    void addComponent(IComponent iComponent);

    IComponent getComponent(int i3);

    IProfileViewLoader getViewLoader();

    void init(QBaseActivity qBaseActivity);

    void removeComponent(IComponent iComponent);
}
