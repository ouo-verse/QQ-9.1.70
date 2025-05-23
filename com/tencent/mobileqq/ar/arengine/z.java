package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class z extends ab {

    /* renamed from: b, reason: collision with root package name */
    public long f198322b;

    /* renamed from: c, reason: collision with root package name */
    public int f198323c;

    /* renamed from: d, reason: collision with root package name */
    public String f198324d;

    /* renamed from: e, reason: collision with root package name */
    public int f198325e;

    /* renamed from: f, reason: collision with root package name */
    public float f198326f;

    /* renamed from: g, reason: collision with root package name */
    public float f198327g;

    /* renamed from: h, reason: collision with root package name */
    public float f198328h;

    /* renamed from: i, reason: collision with root package name */
    public float[] f198329i;

    /* renamed from: j, reason: collision with root package name */
    public ArCloudConfigInfo f198330j;

    public z() {
        this.f197989a = 1L;
        this.f198322b = 0L;
        this.f198323c = 2;
        this.f198324d = "";
        this.f198325e = 0;
        this.f198326f = 0.0f;
        this.f198327g = 0.0f;
        this.f198328h = 0.0f;
        this.f198329i = null;
        this.f198330j = null;
    }

    @Override // com.tencent.mobileqq.ar.arengine.ab
    public String toString() {
        return "ARLocalMarkerRecogResult{recogType = " + this.f197989a + ", frameIdx = " + this.f198322b + ", state = " + this.f198323c + ", markerName = " + this.f198324d + ", markerType = " + this.f198325e + ", markerWidth = " + this.f198326f + ", markerHeight = " + this.f198327g + ", markerDiameter = " + this.f198328h + ", pose = " + this.f198329i + ", arResourceInfo = " + this.f198330j + '}';
    }
}
