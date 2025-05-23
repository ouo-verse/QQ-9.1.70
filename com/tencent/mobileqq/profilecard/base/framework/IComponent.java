package com.tencent.mobileqq.profilecard.base.framework;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IComponent<VIEW, DATA> extends IComponentLifecycle {
    void addComponent(IComponent<? extends View, DATA> iComponent);

    void attachToComponentCenter();

    void changeEmptyAndRefreshStatus(boolean z16);

    void containerInvalidate();

    void detachFromComponentCenter();

    IComponent<? extends View, DATA> getComponent(int i3);

    IComponentCenter getComponentCenter();

    String getComponentName();

    int getComponentType();

    VIEW getContainerView();

    boolean isComponentContentEmpty();

    boolean isNeedForceRefresh();

    boolean onDataUpdate(DATA data);

    void removeComponent(IComponent<? extends View, DATA> iComponent);

    void setComponentContainer(AbsProfileContainer<VIEW> absProfileContainer);

    void setContainerView(VIEW view);
}
