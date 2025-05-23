package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.QAdExposure;
import com.tencent.tvideo.protocol.pb.AdExposureType;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends ExposureChecker {
    public c(a aVar, boolean z16, AdExposureType adExposureType, int i3, QAdExposure.b bVar) {
        super(aVar, z16, adExposureType, i3, bVar);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.ExposureChecker
    protected void S(View view, boolean z16) {
        o();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.ExposureChecker
    protected void T(boolean z16, boolean z17, boolean z18, long j3) {
        n.a("ExposureChecker", "onCheckReport , immersive checker");
        o();
        r(1000L);
        c0(2);
        n.a("ExposureChecker", "onCheckResult, order:" + F() + " immersive report finish.");
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadexposure.ExposureChecker
    protected void U(View view, b bVar) {
        if (I() == 0) {
            if (s(1L)) {
                c0(1);
            }
        } else {
            n.a("ExposureChecker", "check, is running, state:" + I());
        }
    }
}
