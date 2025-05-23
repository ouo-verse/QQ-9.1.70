package com.tencent.mobileqq.transfile;

import android.content.SharedPreferences;
import android.view.animation.AnimationUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.startup.task.cm;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes19.dex */
public class LastModifySupportDownloader extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_SIZE = 4096;
    private static final String PREF_NAME = "http_lastmodify";
    private static final String TAG = "LastModifySupportDownloader";
    private DefaultHttpClient sHttpClient;

    public LastModifySupportDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            schemeRegistry.register(new Scheme("https", socketFactory, WebSocketImpl.DEFAULT_WSS_PORT));
        } catch (Exception unused) {
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, 3000L);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        this.sHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), schemeRegistry), null);
    }

    public static String getCacheFilePath(String str) {
        String Crc64String = Utils.Crc64String(str);
        DiskCache a16 = cm.INSTANCE.a();
        if (a16 == null) {
            return null;
        }
        File cleanFile = a16.getCleanFile(Crc64String);
        if (!cleanFile.exists()) {
            return null;
        }
        return cleanFile.getAbsolutePath();
    }

    private String getLastModified(String str) {
        return com.tencent.open.adapter.a.f().e().getSharedPreferences(PREF_NAME, 0).getString(str, "");
    }

    private void saveLastModified(String str, String str2) {
        SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences(PREF_NAME, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        String str = downloadParams.urlStr;
        File cleanFile = cm.INSTANCE.a().getCleanFile(Utils.Crc64String(str));
        int i3 = 0;
        if (cleanFile != null && cleanFile.exists()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String replace = str.replace(ProtocolDownloaderConstants.PROTOCOL_GAMEAD, "https");
        HttpGet httpGet = new HttpGet(replace);
        if (downloadParams.cookies != null) {
            Iterator<Header> it = this.sHttpClient.getCookieSpecs().getCookieSpec(CookiePolicy.BEST_MATCH).formatCookies(downloadParams.cookies.getCookies()).iterator();
            while (it.hasNext()) {
                httpGet.addHeader(it.next());
            }
        }
        Header[] headerArr = downloadParams.headers;
        if (headerArr != null && headerArr.length > 0) {
            for (Header header : headerArr) {
                httpGet.addHeader(header);
            }
        }
        if (z16) {
            httpGet.addHeader("If-Modified-Since", getLastModified(Utils.Crc64String(replace)));
        }
        try {
            HttpResponse execute = this.sHttpClient.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "-->status code: " + statusCode);
            }
            if (statusCode != 200 && statusCode != 304) {
                throw new IOException(downloadParams.url + " response error! response code: " + statusCode + " . reason: " + execute.getStatusLine().getReasonPhrase());
            }
            HttpEntity entity = execute.getEntity();
            if (statusCode == 200) {
                if (z16) {
                    cleanFile.delete();
                }
                BufferedInputStream bufferedInputStream = new BufferedInputStream(entity.getContent(), 4096);
                try {
                    byte[] bArr = new byte[4096];
                    long j3 = 0;
                    long j16 = 0;
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(bArr, i3, read);
                        byte[] bArr2 = bArr;
                        j16 += read;
                        if (AnimationUtils.currentAnimationTimeMillis() - j3 > 100) {
                            uRLDrawableHandler.publishProgress((int) ((((float) j16) / ((float) entity.getContentLength())) * 9500.0f));
                        }
                        bArr = bArr2;
                        i3 = 0;
                        j3 = 0;
                    }
                    if (execute.containsHeader("Last-Modified")) {
                        saveLastModified(Utils.Crc64String(replace), execute.getFirstHeader("Last-Modified").getValue());
                    }
                    bufferedInputStream.close();
                } catch (Throwable th5) {
                    bufferedInputStream.close();
                    throw th5;
                }
            } else if (statusCode != 304 && uRLDrawableHandler != null) {
                uRLDrawableHandler.publishProgress(10000);
            }
            httpGet.abort();
            return null;
        } catch (Throwable th6) {
            httpGet.abort();
            throw th6;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        DiskCache.Editor edit = cm.INSTANCE.a().edit(Utils.Crc64String(downloadParams.urlStr));
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(edit.dirtyFile, false);
                try {
                    downloadImage(fileOutputStream2, downloadParams, uRLDrawableHandler);
                    File commit = edit.commit();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return commit;
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    if (edit != null) {
                        edit.abort(false);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "-->download image exception.", e);
                    }
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
