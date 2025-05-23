package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.util.Predicate;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface HttpDataSource extends UriDataSource {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class InterruptConnectServerException extends HttpDataSourceException {
        public InterruptConnectServerException(String str, IOException iOException, DataSpec dataSpec) {
            super(str, iOException, dataSpec);
        }

        public InterruptConnectServerException(String str, DataSpec dataSpec) {
            super(str, dataSpec);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class InterruptReadException extends HttpDataSourceException {
        public InterruptReadException(String str, DataSpec dataSpec) {
            super(str, dataSpec);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class InvalidContentException extends HttpDataSourceException {
        public InvalidContentException(String str, DataSpec dataSpec) {
            super(str, dataSpec);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;
        public final Map<String, List<String>> headerFields;

        public InvalidContentTypeException(String str, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec);
            this.contentType = str;
            this.headerFields = map;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final int responseCode;

        public InvalidResponseCodeException(int i3, Map<String, List<String>> map, DataSpec dataSpec) {
            super("Response code: " + i3, dataSpec);
            this.responseCode = i3;
            this.headerFields = map;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class MalformedResponseException extends HttpDataSourceException {
        public MalformedResponseException(String str, DataSpec dataSpec) {
            super(str, dataSpec);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class UnableConnectServerException extends HttpDataSourceException {
        public UnableConnectServerException(String str, IOException iOException, DataSpec dataSpec) {
            super(str, iOException, dataSpec);
        }
    }

    void clearAllRequestProperties();

    void clearRequestProperty(String str);

    @Override // com.tencent.oskplayer.datasource.DataSource
    void close() throws HttpDataSourceException;

    long getContentLength();

    Predicate<String> getContentPredicator();

    Map<String, List<String>> getResponseHeaders();

    @Override // com.tencent.oskplayer.datasource.DataSource
    long getTotalLength();

    @Override // com.tencent.oskplayer.datasource.DataSource
    long open(DataSpec dataSpec) throws HttpDataSourceException;

    @Override // com.tencent.oskplayer.datasource.DataSource
    int read(byte[] bArr, int i3, int i16) throws HttpDataSourceException;

    void setRequestProperty(String str, String str2);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class HttpDataSourceException extends IOException {
        public final DataSpec dataSpec;

        public HttpDataSourceException(DataSpec dataSpec) {
            this.dataSpec = dataSpec;
        }

        public HttpDataSourceException(String str, DataSpec dataSpec) {
            super(str);
            this.dataSpec = dataSpec;
        }

        public HttpDataSourceException(IOException iOException, DataSpec dataSpec) {
            super(iOException);
            this.dataSpec = dataSpec;
        }

        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec) {
            super(str, iOException);
            this.dataSpec = dataSpec;
        }
    }
}
