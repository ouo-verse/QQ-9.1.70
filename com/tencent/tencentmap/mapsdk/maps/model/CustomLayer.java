package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Removable;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface CustomLayer extends Removable, IOverlay {
    void clearDiskCache();

    void reload();
}
