package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.tencent.local_edit.andserver.util.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes2.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private final HttpDataSource.Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map<String, String> keyRequestProperties;

    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    private static byte[] executePost(HttpDataSource.Factory factory, String str, byte[] bArr, Map<String, String> map) throws IOException {
        HttpDataSource createDataSource = factory.createDataSource();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                createDataSource.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(createDataSource, new DataSpec(Uri.parse(str), bArr, 0L, 0L, -1L, null, 1));
        try {
            return Util.toByteArray(dataSourceInputStream);
        } finally {
            Util.closeQuietly(dataSourceInputStream);
        }
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.clear();
        }
    }

    public void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.remove(str);
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws Exception {
        String str;
        String defaultUrl = keyRequest.getDefaultUrl();
        if (this.forceDefaultLicenseUrl || TextUtils.isEmpty(defaultUrl)) {
            defaultUrl = this.defaultLicenseUrl;
        }
        HashMap hashMap = new HashMap();
        UUID uuid2 = C.PLAYREADY_UUID;
        if (uuid2.equals(uuid)) {
            str = MediaType.TEXT_XML_VALUE;
        } else if (C.CLEARKEY_UUID.equals(uuid)) {
            str = "application/json";
        } else {
            str = "application/octet-stream";
        }
        hashMap.put("Content-Type", str);
        if (uuid2.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.keyRequestProperties) {
            hashMap.putAll(this.keyRequestProperties);
        }
        return executePost(this.dataSourceFactory, defaultUrl, keyRequest.getData(), hashMap);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws IOException {
        return executePost(this.dataSourceFactory, provisionRequest.getDefaultUrl() + "&signedRequest=" + new String(provisionRequest.getData()), new byte[0], null);
    }

    public void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.put(str, str2);
        }
    }

    public HttpMediaDrmCallback(String str, boolean z16, HttpDataSource.Factory factory) {
        this.dataSourceFactory = factory;
        this.defaultLicenseUrl = str;
        this.forceDefaultLicenseUrl = z16;
        this.keyRequestProperties = new HashMap();
    }
}
