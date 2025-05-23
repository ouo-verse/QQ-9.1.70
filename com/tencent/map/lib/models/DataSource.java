package com.tencent.map.lib.models;

import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public enum DataSource {
    NONE(-1),
    SATELLITE(0),
    DEM(1),
    MAP(2),
    STREET_VIEW_ROAD(3),
    TRAFFIC_NETWORK(4),
    INDOOR_BUILDINGS(5),
    LANDMARK(6),
    TILE_OVERLAY(7),
    INDOOR_CONFIG(8),
    NUM(9);

    private final int mValue;

    DataSource(int i3) {
        this.mValue = i3;
    }

    public static DataSource get(int i3) {
        for (DataSource dataSource : values()) {
            if (dataSource.mValue == i3) {
                return dataSource;
            }
        }
        return NONE;
    }

    public final int getValue() {
        return this.mValue;
    }
}
