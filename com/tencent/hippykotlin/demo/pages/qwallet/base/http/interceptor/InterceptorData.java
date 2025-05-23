package com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class InterceptorData {
    public boolean isUniqueRequest;
    public final String method;
    public final String service;

    public InterceptorData(String str, String str2, boolean z16) {
        this.service = str;
        this.method = str2;
        this.isUniqueRequest = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.method, this.service.hashCode() * 31, 31);
        boolean z16 = this.isUniqueRequest;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("InterceptorData(service=");
        m3.append(this.service);
        m3.append(", method=");
        m3.append(this.method);
        m3.append(", isUniqueRequest=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isUniqueRequest, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterceptorData)) {
            return false;
        }
        InterceptorData interceptorData = (InterceptorData) obj;
        return Intrinsics.areEqual(this.service, interceptorData.service) && Intrinsics.areEqual(this.method, interceptorData.method) && this.isUniqueRequest == interceptorData.isUniqueRequest;
    }
}
