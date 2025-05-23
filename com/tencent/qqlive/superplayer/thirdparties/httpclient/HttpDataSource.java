package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface HttpDataSource extends d {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        @Nullable
        public final String responseMessage;

        public InvalidResponseCodeException(int i3, @Nullable String str, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: " + i3, dataSpec, 1);
            this.responseCode = i3;
            this.responseMessage = str;
            this.headerFields = map;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final c f345417a = new c();

        protected abstract HttpDataSource a(int i3, c cVar);

        @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.HttpDataSource.b
        public final HttpDataSource createDataSource(int i3) {
            return a(i3, this.f345417a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        HttpDataSource createDataSource(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, String> f345418a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private Map<String, String> f345419b;

        public synchronized Map<String, String> a() {
            if (this.f345419b == null) {
                this.f345419b = Collections.unmodifiableMap(new HashMap(this.f345418a));
            }
            return this.f345419b;
        }

        public synchronized void b(String str, String str2) {
            this.f345419b = null;
            this.f345418a.put(str, str2);
        }
    }

    Map<String, List<String>> getResponseHeaders();

    void setRequestProperty(String str, String str2);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class HttpDataSourceException extends IOException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final DataSpec dataSpec;
        public final int type;

        /* compiled from: P */
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes22.dex */
        public @interface Type {
        }

        public HttpDataSourceException(DataSpec dataSpec, int i3) {
            this.dataSpec = dataSpec;
            this.type = i3;
        }

        public HttpDataSourceException(String str, DataSpec dataSpec, int i3) {
            super(str);
            this.dataSpec = dataSpec;
            this.type = i3;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i3) {
            super(iOException);
            this.dataSpec = dataSpec;
            this.type = i3;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i3) {
            super(str, iOException);
            this.dataSpec = dataSpec;
            this.type = i3;
        }
    }
}
