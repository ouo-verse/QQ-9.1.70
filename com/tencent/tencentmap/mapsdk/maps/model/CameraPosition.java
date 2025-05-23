package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: classes26.dex */
public final class CameraPosition {
    public final float bearing;
    public LatLng target;
    public final float tilt;
    public final float zoom;

    CameraPosition(int i3, LatLng latLng, float f16, float f17, float f18) {
        this.target = latLng;
        this.zoom = f16;
        this.tilt = f17;
        this.bearing = f18;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f16) {
        return new CameraPosition(latLng, f16, 0.0f, 0.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "latlng:" + this.target.latitude + "," + this.target.longitude + ",zoom:" + this.zoom + ",tilt=" + this.tilt + ",bearing:" + this.bearing;
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    /* loaded from: classes26.dex */
    public static final class Builder {

        /* renamed from: p, reason: collision with root package name */
        private LatLng f375371p;

        /* renamed from: q, reason: collision with root package name */
        private float f375372q;

        /* renamed from: r, reason: collision with root package name */
        private float f375373r;

        /* renamed from: s, reason: collision with root package name */
        private float f375374s;

        public Builder() {
            this.f375373r = Float.MIN_VALUE;
            this.f375374s = Float.MIN_VALUE;
        }

        public final Builder bearing(float f16) {
            this.f375374s = f16;
            return this;
        }

        public final CameraPosition build() {
            return new CameraPosition(this.f375371p, this.f375372q, this.f375373r, this.f375374s);
        }

        public final Builder target(LatLng latLng) {
            this.f375371p = latLng;
            return this;
        }

        public final Builder tilt(float f16) {
            this.f375373r = f16;
            return this;
        }

        public final Builder zoom(float f16) {
            this.f375372q = f16;
            return this;
        }

        public Builder(CameraPosition cameraPosition) {
            this.f375373r = Float.MIN_VALUE;
            this.f375374s = Float.MIN_VALUE;
            this.f375371p = cameraPosition.target;
            this.f375372q = cameraPosition.zoom;
            this.f375373r = cameraPosition.tilt;
            this.f375374s = cameraPosition.bearing;
        }
    }

    public CameraPosition(LatLng latLng, float f16, float f17, float f18) {
        this(1, latLng, f16, f17, f18);
    }
}
