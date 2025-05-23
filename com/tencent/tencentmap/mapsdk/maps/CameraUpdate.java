package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.model.CamerParameter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class CameraUpdate {
    private final CamerParameter camerPara;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraUpdate(CamerParameter camerParameter) {
        this.camerPara = camerParameter;
    }

    public final CamerParameter getParams() {
        return this.camerPara;
    }

    public final String toString() {
        return "CameraUpdate{camerPara=" + this.camerPara + '}';
    }
}
