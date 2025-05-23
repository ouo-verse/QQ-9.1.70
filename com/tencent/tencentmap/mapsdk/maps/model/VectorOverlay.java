package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface VectorOverlay extends IOverlay {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnVectorOverlayClickListener {
        void onClicked(LatLng latLng, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnVectorOverlayLoadListener {
        void onVectorOverlayLoaded(boolean z16);
    }

    void enableClick(boolean z16);

    ReturnInfoModelClass.ReturnStatus executeCommandFunction(CommandFunctionModelClass.BaseCommandFunction baseCommandFunction);

    String getType();

    boolean isClickEnabled();

    void remove();

    void setLevel(int i3);

    void setOpacity(float f16);

    void setVisibility(boolean z16);

    void setZIndex(int i3);
}
