package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.segment.HwResponse;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IRequestCallback {
    void onFailed(int i3);

    void onResponse(HwResponse hwResponse);
}
