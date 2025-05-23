package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IQzoneEventApi;
import cooperation.qzone.event.ExoticEvent;
import cooperation.qzone.event.ExoticEventPool;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneEventApiImpl implements IQzoneEventApi {
    @Override // com.tencent.qzonehub.api.IQzoneEventApi
    public ClassLoader getLoader() {
        return ExoticEvent.getLoader();
    }

    @Override // com.tencent.qzonehub.api.IQzoneEventApi
    public IQzoneEventApi.ExoticEventInterface obtain(int i3, String str, Object obj) {
        return ExoticEvent.obtain(i3, str, obj);
    }

    @Override // com.tencent.qzonehub.api.IQzoneEventApi
    public boolean onEventReceived(IQzoneEventApi.ExoticEventInterface exoticEventInterface) {
        return ExoticEventPool.getInstance().onEventReceived(exoticEventInterface);
    }

    @Override // com.tencent.qzonehub.api.IQzoneEventApi
    public IQzoneEventApi.ExoticEventInterface pollEvent() {
        return ExoticEventPool.getInstance().pollEvent();
    }
}
