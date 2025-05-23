package com.tencent.mobileqq.activity.aio.audiopanel.impl;

import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanelPresenterImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.activity.aio.audiopanel.g;
import com.tencent.mobileqq.activity.aio.audiopanel.h;
import com.tencent.mobileqq.activity.aio.audiopanel.i;
import com.tencent.mobileqq.activity.aio.audiopanel.j;
import com.tencent.mobileqq.activity.aio.audiopanel.k;
import com.tencent.mobileqq.activity.aio.audiopanel.l;
import com.tencent.mvp.c;

/* loaded from: classes10.dex */
public class AudioPanelPresenterCreaterImpl implements IAudioPanelPresenterCreater {
    @Override // com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater
    public h createCircleProcessViewPresenter(c cVar) {
        g gVar = new g();
        gVar.h(cVar);
        return gVar;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater
    public i createCommonRecordSoundPanelPresenter(j jVar) {
        CommonRecordSoundPanelPresenterImpl commonRecordSoundPanelPresenterImpl = new CommonRecordSoundPanelPresenterImpl();
        commonRecordSoundPanelPresenterImpl.k(jVar);
        return commonRecordSoundPanelPresenterImpl;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater
    public k createThemeViewPresenter(c cVar) {
        l lVar = new l();
        lVar.c(cVar);
        return lVar;
    }
}
