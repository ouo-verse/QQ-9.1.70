package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.ci;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface cg extends ci.a {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f148041a;

        /* renamed from: b, reason: collision with root package name */
        public LatLng f148042b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f148043c;

        /* renamed from: d, reason: collision with root package name */
        public int f148044d;
    }

    BitmapDescriptor a(ce ceVar, byte[] bArr, boolean z16, boolean z17);

    void a();

    void a(CameraPosition cameraPosition, boolean z16);

    List<b> b();

    void c();
}
