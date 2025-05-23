package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Map;

/* loaded from: classes23.dex */
public class DefaultMediaHTTPConnection implements IMediaHTTPConnection {
    private static final int CONNECT_TIMEOUT_MS = 30000;
    private static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "MediaHTTPConnection";
    private static final boolean VERBOSE = false;
    private long mCurrentOffset = -1;
    private URL mURL = null;
    private Map<String, String> mHeaders = null;
    private HttpURLConnection mConnection = null;
    private long mTotalSize = -1;
    private InputStream mInputStream = null;
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;

    private boolean filterOutInternalHeaders(String str, String str2) {
        if ("android-allow-cross-domain-redirect".equalsIgnoreCase(str)) {
            boolean parseBoolean = parseBoolean(str2);
            this.mAllowCrossDomainRedirect = parseBoolean;
            this.mAllowCrossProtocolRedirect = parseBoolean;
            return true;
        }
        return false;
    }

    private static final boolean isLocalHost(URL url) {
        String host;
        if (url == null || (host = url.getHost()) == null) {
            return false;
        }
        try {
        } catch (IllegalArgumentException e16) {
            Logger.e(TAG, "isLocalHost", e16);
        }
        if (!host.equalsIgnoreCase("localhost")) {
            return false;
        }
        return true;
    }

    private boolean parseBoolean(String str) {
        try {
            if (Long.parseLong(str) != 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            if ("true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e4, code lost:
    
        r17.mURL = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void seekTo(long j3) throws IOException {
        boolean z16;
        int lastIndexOf;
        teardownConnection();
        try {
            URL url = this.mURL;
            boolean isLocalHost = isLocalHost(url);
            int i3 = 0;
            while (true) {
                if (isLocalHost) {
                    this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                } else {
                    this.mConnection = (HttpURLConnection) url.openConnection();
                }
                Logger.i(TAG, "setConnectTimeout " + this.mURL);
                this.mConnection.setConnectTimeout(30000);
                this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
                Map<String, String> map = this.mHeaders;
                if (map != null) {
                    z16 = false;
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        this.mConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        if (!z16 && "Accept-Encoding".equals(entry.getKey())) {
                            z16 = true;
                        }
                    }
                } else {
                    z16 = false;
                }
                if (j3 > 0) {
                    this.mConnection.setRequestProperty("Range", "bytes=" + j3 + "-");
                }
                if (!z16) {
                    this.mConnection.setRequestProperty("Accept-Encoding", "");
                }
                try {
                    int responseCode = this.mConnection.getResponseCode();
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307) {
                        if (this.mAllowCrossDomainRedirect) {
                            this.mURL = this.mConnection.getURL();
                        }
                        if (responseCode == 206) {
                            String headerField = this.mConnection.getHeaderField("Content-Range");
                            this.mTotalSize = -1L;
                            if (headerField != null && (lastIndexOf = headerField.lastIndexOf(47)) >= 0) {
                                try {
                                    this.mTotalSize = Long.parseLong(headerField.substring(lastIndexOf + 1));
                                } catch (NumberFormatException unused) {
                                }
                            }
                        } else if (responseCode == 200) {
                            this.mTotalSize = this.mConnection.getContentLength();
                        } else {
                            throw new IOException("failed! status code: " + responseCode);
                        }
                        if (j3 > 0 && responseCode != 206) {
                            throw new ProtocolException();
                        }
                        this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                        this.mCurrentOffset = j3;
                        return;
                    }
                    i3++;
                    if (i3 <= 20) {
                        String requestMethod = this.mConnection.getRequestMethod();
                        if (responseCode == 307 && !requestMethod.equals("GET") && !requestMethod.equals("HEAD")) {
                            throw new NoRouteToHostException("Invalid redirect");
                        }
                        String headerField2 = this.mConnection.getHeaderField("Location");
                        if (headerField2 != null) {
                            URL url2 = new URL(this.mURL, headerField2);
                            if (!url2.getProtocol().equals("https") && !url2.getProtocol().equals("http")) {
                                throw new NoRouteToHostException("Unsupported protocol redirect");
                            }
                            boolean equals = this.mURL.getProtocol().equals(url2.getProtocol());
                            if (!this.mAllowCrossProtocolRedirect && !equals) {
                                throw new NoRouteToHostException("Cross-protocol redirects are disallowed");
                            }
                            boolean equals2 = this.mURL.getHost().equals(url2.getHost());
                            if (!this.mAllowCrossDomainRedirect && !equals2) {
                                throw new NoRouteToHostException("Cross-domain redirects are disallowed");
                            }
                            url = url2;
                        } else {
                            throw new NoRouteToHostException("Invalid redirect");
                        }
                    } else {
                        throw new NoRouteToHostException("Too many redirects: " + i3);
                    }
                } catch (Exception e16) {
                    throw new IOException("An suspicious exception occurred: " + e16.getMessage());
                }
            }
        } catch (IOException e17) {
            this.mTotalSize = -1L;
            this.mInputStream = null;
            this.mConnection = null;
            this.mCurrentOffset = -1L;
            Logger.e(TAG, "seekTo", e17);
            throw e17;
        }
    }

    private void teardownConnection() {
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            this.mInputStream = null;
            httpURLConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1L;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public boolean connect(URL url, Map<String, String> map) {
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.mHeaders = map;
        return true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public void disconnect() {
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public String getMIMEType() {
        if (this.mConnection == null) {
            try {
                seekTo(0L);
            } catch (IOException e16) {
                Logger.e(TAG, "getMIMEType", e16);
                return "application/octet-stream";
            }
        }
        return this.mConnection.getContentType();
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public long getSize() {
        if (this.mConnection == null) {
            try {
                seekTo(0L);
            } catch (IOException e16) {
                Logger.e(TAG, "getSize", e16);
                return -1L;
            }
        }
        return this.mTotalSize;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public String getUri() {
        return this.mURL.toString();
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public int readAt(long j3, byte[] bArr, int i3, int i16) {
        try {
            if (j3 != this.mCurrentOffset) {
                seekTo(j3);
            }
            int read = this.mInputStream.read(bArr, i3, i16);
            if (read == -1) {
                read = 0;
            }
            this.mCurrentOffset += read;
            return read;
        } catch (NoRouteToHostException e16) {
            Logger.w(TAG, "readAt " + j3 + " / " + i16 + " => " + e16);
            return -1010;
        } catch (ProtocolException e17) {
            Logger.w(TAG, "readAt " + j3 + " / " + i16 + " => " + e17);
            return -1010;
        } catch (UnknownServiceException e18) {
            Logger.w(TAG, "readAt " + j3 + " / " + i16 + " => " + e18);
            return -1010;
        } catch (IOException unused) {
            return -2;
        } catch (Exception unused2) {
            return -3;
        }
    }
}
