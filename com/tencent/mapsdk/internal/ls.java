package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum ls {
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


    /* renamed from: l, reason: collision with root package name */
    private final int f149261l;

    ls(int i3) {
        this.f149261l = i3;
    }

    private static ls a(int i3) {
        for (ls lsVar : values()) {
            if (lsVar.f149261l == i3) {
                return lsVar;
            }
        }
        return NONE;
    }

    private int a() {
        return this.f149261l;
    }
}
