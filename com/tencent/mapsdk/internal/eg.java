package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.tools.Callback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface eg extends TencentMapComponent.Component {
    int a(String str);

    VisualLayer a(VisualLayerOptions visualLayerOptions);

    String a(VisualLayer visualLayer, String str);

    void a(String str, int i3);

    void a(String str, int i3, int i16);

    void a(String str, Callback<byte[]> callback);

    void a(String str, byte[] bArr);

    void a(JSONObject jSONObject);

    boolean a();

    void b(String str);

    void b(String str, Callback<byte[]> callback);

    void c(String str);

    String d(String str);

    boolean e(String str);

    void f(String str);

    void g(String str);

    bp n_();
}
