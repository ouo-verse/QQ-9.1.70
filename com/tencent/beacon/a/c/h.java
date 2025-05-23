package com.tencent.beacon.a.c;

import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.qimei.log.IObservableLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* compiled from: P */
/* loaded from: classes2.dex */
class h implements IObservableLog {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BeaconLogger f77674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BeaconLogger beaconLogger) {
        this.f77674a = beaconLogger;
    }

    @Override // com.tencent.qimei.log.IObservableLog
    public void onLog(String str) {
        this.f77674a.d(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, str);
    }
}
