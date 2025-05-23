package com.tencent.luggage.wxa.kh;

import com.tencent.luggage.wxa.gl.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f132015a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(int i3, String str);

        void a(com.tencent.luggage.wxa.gl.a aVar);

        void a(h hVar, Map map);

        void a(String str);

        void a(ByteBuffer byteBuffer);

        void b(String str);

        void c(String str);
    }

    e a(String str);

    void a(e eVar);

    void a(e eVar, int i3, String str);

    void a(e eVar, String str);

    void a(e eVar, ByteBuffer byteBuffer);

    void a(String str, String str2, int i3, int i16, JSONObject jSONObject, Map map, a aVar);

    boolean b(e eVar);

    void release();
}
