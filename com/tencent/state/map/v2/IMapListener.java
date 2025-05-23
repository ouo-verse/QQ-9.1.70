package com.tencent.state.map.v2;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/map/v2/IMapListener;", "", "onEngineRenderRecovered", "", "onMapReady", "onObjectStateChanged", "id", "", "state", "Lcom/tencent/state/map/v2/ObjectState;", "onViewportChanged", "info", "Lcom/tencent/state/map/v2/ViewportInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapListener {
    void onEngineRenderRecovered();

    void onMapReady();

    void onObjectStateChanged(String id5, ObjectState state);

    void onViewportChanged(ViewportInfo info);
}
