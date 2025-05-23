package com.tencent.mobileqq.vas.VasResEngine;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface AbsVasRes {
    public static final int MSG_DOWNLOAD_DONE = 10002;
    public static final int MSG_RELOAD = 10003;
    public static final int MSG_UI_REFRESH = 10001;

    VasResAdapter getVasResAdapter();

    VasResController getVasResController();

    void recycle();

    void update(int i3);
}
