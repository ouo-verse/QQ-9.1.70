package com.tencent.beacon.base.net.call;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackageV2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class JceRequestEntity {
    private static final String TAG = "JceRequestEntity";
    private final String appKey;
    private final byte[] content;
    private final String domain;
    private final Map<String, String> header;
    private final int port;
    private final int requestCmd;
    private final int responseCmd;
    private final RequestType type;
    private final String url;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f77738a;

        /* renamed from: b, reason: collision with root package name */
        private int f77739b;

        /* renamed from: c, reason: collision with root package name */
        private String f77740c;

        /* renamed from: d, reason: collision with root package name */
        private int f77741d;

        /* renamed from: e, reason: collision with root package name */
        private int f77742e;

        /* renamed from: f, reason: collision with root package name */
        private RequestType f77743f;

        /* renamed from: g, reason: collision with root package name */
        private String f77744g;

        /* renamed from: h, reason: collision with root package name */
        private Map<String, String> f77745h = new ConcurrentHashMap(5);

        /* renamed from: i, reason: collision with root package name */
        private Map<String, String> f77746i = new LinkedHashMap(10);

        /* renamed from: j, reason: collision with root package name */
        private byte[] f77747j;

        /* renamed from: k, reason: collision with root package name */
        private AbstractJceStruct f77748k;

        public a a(RequestType requestType) {
            this.f77743f = requestType;
            return this;
        }

        public a b(String str) {
            this.f77738a = str;
            return this;
        }

        public a a(String str, int i3) {
            this.f77744g = str;
            this.f77739b = i3;
            return this;
        }

        public a b(int i3) {
            this.f77742e = i3;
            return this;
        }

        public a b(String str, String str2) {
            if (str2 == null) {
                str2 = "";
            }
            this.f77746i.put(str, str2);
            return this;
        }

        public a a(@NonNull String str, String str2) {
            this.f77745h.put(str, str2);
            return this;
        }

        public a a(int i3) {
            this.f77741d = i3;
            return this;
        }

        public a a(Map<String, String> map) {
            if (map != null) {
                this.f77746i.putAll(map);
            }
            return this;
        }

        public a a(String str) {
            this.f77740c = str;
            return this;
        }

        public a a(AbstractJceStruct abstractJceStruct) {
            this.f77748k = abstractJceStruct;
            return this;
        }

        public JceRequestEntity a() {
            if (TextUtils.isEmpty(this.f77738a) && TextUtils.isEmpty(this.f77744g)) {
                throw new IllegalArgumentException("url || domain == null");
            }
            if (!TextUtils.isEmpty(this.f77740c)) {
                com.tencent.beacon.base.net.c c16 = com.tencent.beacon.base.net.c.c();
                this.f77745h.putAll(com.tencent.beacon.base.net.b.d.a());
                if (this.f77743f == RequestType.EVENT) {
                    this.f77747j = c16.f77734e.c().a((RequestPackageV2) this.f77748k);
                } else {
                    AbstractJceStruct abstractJceStruct = this.f77748k;
                    this.f77747j = c16.f77733d.c().a(com.tencent.beacon.base.net.b.d.a(this.f77741d, abstractJceStruct == null ? "".getBytes() : abstractJceStruct.toByteArray(), this.f77746i, this.f77740c));
                }
                return new JceRequestEntity(this.f77743f, this.f77738a, this.f77744g, this.f77739b, this.f77740c, this.f77747j, this.f77745h, this.f77741d, this.f77742e);
            }
            throw new IllegalArgumentException("appKey == null");
        }
    }

    public static a builder() {
        return new a();
    }

    public String getAppKey() {
        return this.appKey;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getDomain() {
        return this.domain;
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public int getPort() {
        return this.port;
    }

    public int getRequestCmd() {
        return this.requestCmd;
    }

    public int getResponseCmd() {
        return this.responseCmd;
    }

    public RequestType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "JceRequestEntity{type=" + this.type + ", url='" + this.url + "', domain='" + this.domain + "', port=" + this.port + ", appKey='" + this.appKey + "', content.length=" + this.content.length + ", header=" + this.header + ", requestCmd=" + this.requestCmd + ", responseCmd=" + this.responseCmd + '}';
    }

    JceRequestEntity(RequestType requestType, String str, String str2, int i3, String str3, byte[] bArr, Map<String, String> map, int i16, int i17) {
        this.type = requestType;
        this.url = str;
        this.domain = str2;
        this.port = i3;
        this.appKey = str3;
        this.content = bArr;
        this.header = map;
        this.requestCmd = i16;
        this.responseCmd = i17;
    }
}
