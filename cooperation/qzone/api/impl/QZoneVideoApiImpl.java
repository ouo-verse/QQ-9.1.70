package cooperation.qzone.api.impl;

import cooperation.qzone.api.IQZoneVideoApi;
import zm.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneVideoApiImpl implements IQZoneVideoApi {
    private static final String TAG = "QZoneVideo_QZoneVideoApiImpl";

    @Override // cooperation.qzone.api.IQZoneVideoApi
    public String getExperimentGrayId() {
        return d.f452771a.a();
    }

    @Override // cooperation.qzone.api.IQZoneVideoApi
    public String getExperimentId() {
        return d.f452771a.b();
    }

    @Override // cooperation.qzone.api.IQZoneVideoApi
    public boolean isHitQQVideoExperiment() {
        return d.f452771a.c();
    }
}
