package com.tencent.biz.richframework.order;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IOrderElement {
    String getContextHashCode();

    String getElementExtraKey();

    String getGroup();

    String getGroupExtraKey();

    int getPriority();

    boolean isDataReady();

    boolean isElementCanActivate();

    void onElementActivated();

    void onElementInactivated();
}
