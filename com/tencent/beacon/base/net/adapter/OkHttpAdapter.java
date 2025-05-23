package com.tencent.beacon.base.net.adapter;

import android.support.annotation.Nullable;
import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OkHttpAdapter extends AbstractNetAdapter {
    private OkHttpClient client;
    private int failCount;

    OkHttpAdapter(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    static /* synthetic */ int access$008(OkHttpAdapter okHttpAdapter) {
        int i3 = okHttpAdapter.failCount;
        okHttpAdapter.failCount = i3 + 1;
        return i3;
    }

    private RequestBody buildBody(com.tencent.beacon.base.net.call.e eVar) {
        BodyType a16 = eVar.a();
        int i3 = e.f77714a[a16.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return RequestBody.create(MediaType.parse("multipart/form-data"), eVar.c());
            }
            return RequestBody.create(MediaType.parse(a16.httpType), eVar.f());
        }
        return RequestBody.create(MediaType.parse(a16.httpType), com.tencent.beacon.base.net.b.d.b(eVar.d()));
    }

    public static AbstractNetAdapter create(@Nullable OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            return new OkHttpAdapter(okHttpClient);
        }
        return new OkHttpAdapter();
    }

    private Headers mapToHeaders(Map<String, String> map) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return builder.build();
    }

    @Override // com.tencent.beacon.base.net.adapter.AbstractNetAdapter
    public void request(JceRequestEntity jceRequestEntity, Callback<byte[]> callback) {
        RequestBody create = RequestBody.create(MediaType.parse("jce"), jceRequestEntity.getContent());
        Headers mapToHeaders = mapToHeaders(jceRequestEntity.getHeader());
        String name = jceRequestEntity.getType().name();
        this.client.newCall(new Request.Builder().url(jceRequestEntity.getUrl()).tag(name).post(create).headers(mapToHeaders).build()).enqueue(new c(this, callback, name));
    }

    OkHttpAdapter() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.client = builder.connectTimeout(30000L, timeUnit).readTimeout(10000L, timeUnit).build();
    }

    @Override // com.tencent.beacon.base.net.adapter.AbstractNetAdapter
    public void request(com.tencent.beacon.base.net.call.e eVar, Callback<BResponse> callback) {
        String h16 = eVar.h();
        this.client.newCall(new Request.Builder().url(eVar.i()).method(eVar.g().name(), buildBody(eVar)).headers(mapToHeaders(eVar.e())).tag(h16 == null ? "beacon" : h16).build()).enqueue(new d(this, callback, h16));
    }
}
