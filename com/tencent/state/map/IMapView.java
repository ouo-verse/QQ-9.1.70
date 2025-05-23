package com.tencent.state.map;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019H&\u00a2\u0006\u0002\u0010\u001aR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/map/IMapView;", "", "currentZoomLevel", "", "getCurrentZoomLevel", "()I", "currentZoomRatio", "", "getCurrentZoomRatio", "()F", "isInDetailMode", "", "()Z", "manipulator", "Lcom/tencent/state/map/IMapViewManipulator;", "getManipulator", "()Lcom/tencent/state/map/IMapViewManipulator;", "mapAdapter", "Lcom/tencent/state/map/MapAdapter;", "getMapAdapter", "()Lcom/tencent/state/map/MapAdapter;", "getComponent", "T", "Lcom/tencent/state/map/IMapComponent;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/state/map/IMapComponent;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapView {
    <T extends IMapComponent> T getComponent(Class<T> clazz);

    int getCurrentZoomLevel();

    float getCurrentZoomRatio();

    IMapViewManipulator getManipulator();

    MapAdapter getMapAdapter();

    boolean isInDetailMode();
}
