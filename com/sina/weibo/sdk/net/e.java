package com.sina.weibo.sdk.net;

import android.os.Bundle;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e implements d {

    /* renamed from: k, reason: collision with root package name */
    private Bundle f61253k = new Bundle();

    /* renamed from: l, reason: collision with root package name */
    private Bundle f61254l = new Bundle();

    /* renamed from: m, reason: collision with root package name */
    private Map<String, Object<File>> f61255m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    private Map<String, byte[]> f61256n = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    private int f61257o;

    /* renamed from: p, reason: collision with root package name */
    private int f61258p;
    private String url;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: k, reason: collision with root package name */
        Bundle f61259k = new Bundle();

        /* renamed from: l, reason: collision with root package name */
        Bundle f61260l = new Bundle();

        /* renamed from: m, reason: collision with root package name */
        Map<String, Object<File>> f61261m = new HashMap();

        /* renamed from: n, reason: collision with root package name */
        Map<String, byte[]> f61262n = new HashMap();

        /* renamed from: o, reason: collision with root package name */
        int f61263o = 30000;

        /* renamed from: p, reason: collision with root package name */
        int f61264p = 60000;
        public String url;

        public final a a(String str, Object obj) {
            a(this.f61259k, str, obj);
            return this;
        }

        public final a b(String str, Object obj) {
            a(this.f61260l, str, obj);
            return this;
        }

        public final e i() {
            return new e(this);
        }

        private void a(Bundle bundle, String str, Object obj) {
            if (obj != null) {
                if (obj instanceof String) {
                    bundle.putString(str, String.valueOf(obj));
                    return;
                }
                if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                    return;
                }
                if (obj instanceof Short) {
                    bundle.putShort(str, ((Short) obj).shortValue());
                    return;
                }
                if (obj instanceof Character) {
                    bundle.putChar(str, ((Character) obj).charValue());
                    return;
                }
                if (obj instanceof Byte) {
                    bundle.putByte(str, ((Byte) obj).byteValue());
                    return;
                }
                if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                    return;
                }
                if (obj instanceof Float) {
                    bundle.putFloat(str, ((Float) obj).floatValue());
                    return;
                }
                if (obj instanceof Double) {
                    bundle.putDouble(str, ((Double) obj).doubleValue());
                    return;
                }
                if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof byte[]) {
                    this.f61262n.put(str, (byte[]) obj);
                } else {
                    if (obj instanceof Serializable) {
                        bundle.putSerializable(str, (Serializable) obj);
                        return;
                    }
                    throw new IllegalArgumentException("Unsupported params type!");
                }
            }
        }
    }

    public e(a aVar) {
        this.url = aVar.url;
        this.f61253k.putAll(aVar.f61259k);
        this.f61254l.putAll(aVar.f61260l);
        this.f61255m.putAll(aVar.f61261m);
        this.f61256n.putAll(aVar.f61262n);
        this.f61257o = aVar.f61263o;
        this.f61258p = aVar.f61264p;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getConnectTimeout() {
        return this.f61257o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle getParams() {
        return this.f61253k;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getReadTimeout() {
        return this.f61258p;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final String getUrl() {
        return this.url;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final Bundle h() {
        return this.f61254l;
    }
}
