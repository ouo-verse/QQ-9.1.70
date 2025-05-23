package com.tencent.ilinkservice;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IlinkServiceCallback {
    void onAllResourceNeedRecreate();

    void onCloneMultiProcessTdiSession(int i3, String str, IlinkTdiCloneSessionInterface ilinkTdiCloneSessionInterface);

    void onDeviceInfoNotMatch();
}
