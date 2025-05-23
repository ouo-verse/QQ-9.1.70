package com.tencent.mtt.supportui.views.recyclerview;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface IViewRecycleStateListener {
    public static final int NOTIFY_ON_RECYCLE = 2;
    public static final int NOTIFY_ON_USE = 1;

    void onRecycle();

    void onUse();
}
