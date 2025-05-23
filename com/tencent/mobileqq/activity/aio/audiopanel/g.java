package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.ptt.temp.api.IAudioPanelTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g implements h {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<com.tencent.mvp.c> f178321d;

    @Override // com.tencent.mvp.a
    public void c(String str, com.tencent.mvp.c cVar, Object obj) {
        if (str.equalsIgnoreCase("startPlayAnim") && cVar != null && (cVar instanceof CircleProgressView)) {
            ((IAudioPanelTempApi) QRoute.api(IAudioPanelTempApi.class)).ListenPanel_startPlayAnimByType_RecordStopToPlayType((CircleProgressView) cVar);
        }
    }

    public void h(com.tencent.mvp.c cVar) {
        this.f178321d = new WeakReference<>(cVar);
    }
}
