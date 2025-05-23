package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ee<OUT extends JsonComposer> extends eb {

    /* renamed from: a, reason: collision with root package name */
    private Class<OUT> f148150a;

    public ee(Class<OUT> cls) {
        this.f148150a = cls;
    }

    private a<OUT> b(NetResponse netResponse) {
        return new a<>(netResponse, this.f148150a);
    }

    @Override // com.tencent.mapsdk.internal.eb, com.tencent.mapsdk.internal.ef
    public final /* synthetic */ NetResponse a(NetResponse netResponse) {
        return new a(netResponse, this.f148150a);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a<OUT extends JsonComposer> extends NetResponse {

        /* renamed from: a, reason: collision with root package name */
        public String f148151a;

        /* renamed from: b, reason: collision with root package name */
        public OUT f148152b;

        public a(NetResponse netResponse) {
            clone(netResponse);
            if (netResponse.available()) {
                try {
                    this.f148151a = new String(netResponse.data, netResponse.charset);
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            }
        }

        private String a() {
            return this.f148151a;
        }

        private OUT b() {
            return this.f148152b;
        }

        @Override // com.tencent.map.tools.net.NetResponse
        public final boolean available() {
            String str;
            if (super.available() && (str = this.f148151a) != null && !TextUtils.isEmpty(str)) {
                return true;
            }
            return false;
        }

        public a(NetResponse netResponse, Class<OUT> cls) {
            clone(netResponse);
            if (netResponse.available()) {
                try {
                    String str = new String(netResponse.data, netResponse.charset);
                    this.f148151a = str;
                    this.f148152b = (OUT) JsonUtils.parseToModel(str, cls, new Object[0]);
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
