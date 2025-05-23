package com.tencent.gamematrix.gmcg.sdk.impl;

import com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final /* synthetic */ class aw implements CGNetDetectionManager.DetectionNetListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CGPlayDetectorImpl f107742a;

    public /* synthetic */ aw(CGPlayDetectorImpl cGPlayDetectorImpl) {
        this.f107742a = cGPlayDetectorImpl;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager.DetectionNetListener
    public final void onDetectionNetRes(List list) {
        CGPlayDetectorImpl.g(this.f107742a, list);
    }
}
