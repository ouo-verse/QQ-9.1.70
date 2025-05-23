package com.tencent.open.base.http;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends com.tencent.open.base.http.a<Void, Void, Bitmap> {

    /* renamed from: c, reason: collision with root package name */
    protected String f341021c;

    /* renamed from: d, reason: collision with root package name */
    protected a f341022d;

    /* renamed from: e, reason: collision with root package name */
    protected Bundle f341023e;

    /* renamed from: f, reason: collision with root package name */
    ThreadSafeClientConnManager f341024f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void r1(String str, Bitmap bitmap);
    }

    public d(String str, String str2, Bundle bundle, String str3, a aVar) {
        super(str2, str3);
        this.f341024f = null;
        this.f341021c = str;
        this.f341022d = aVar;
        this.f341023e = bundle;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
            socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            schemeRegistry.register(new Scheme("https", socketFactory, WebSocketImpl.DEFAULT_WSS_PORT));
        } catch (Exception e16) {
            QLog.e("HttpImageDownloadAsyncTask", 1, "createHttpClient():Can't support https on this devices.", e16);
        }
        this.f341024f = new ThreadSafeClientConnManager(new BasicHttpParams(), schemeRegistry);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009d, code lost:
    
        if (r3 == null) goto L41;
     */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap doInBackground(Void... voidArr) {
        Bitmap bitmap;
        Bitmap bitmap2;
        QLog.d("HttpImageDownloadAsyncTask", 1, "doInBackground");
        InputStream inputStream = null;
        r3 = null;
        Bitmap bitmap3 = null;
        InputStream inputStream2 = null;
        InputStream inputStream3 = null;
        inputStream = null;
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(this.f341024f, null);
        try {
            try {
                HttpGet httpGet = new HttpGet(this.f341008a);
                Bundle bundle = this.f341023e;
                if (bundle != null) {
                    for (String str : bundle.keySet()) {
                        Object obj = this.f341023e.get(str);
                        if (obj instanceof String) {
                            httpGet.addHeader(str, (String) obj);
                        }
                    }
                }
                HttpEntity entity = defaultHttpClient.execute(httpGet).getEntity();
                if (entity != null) {
                    InputStream content = entity.getContent();
                    try {
                        byte[] c16 = c(content);
                        boolean z16 = false;
                        bitmap3 = SafeBitmapFactory.decodeByteArray(c16, 0, c16.length);
                        Object[] objArr = new Object[2];
                        objArr[0] = "doInBackground result==null : ";
                        if (bitmap3 == null) {
                            z16 = true;
                        }
                        objArr[1] = Boolean.valueOf(z16);
                        QLog.d("HttpImageDownloadAsyncTask", 1, objArr);
                        inputStream2 = content;
                        bitmap2 = bitmap3;
                    } catch (Exception e16) {
                        Bitmap bitmap4 = bitmap3;
                        inputStream = content;
                        e = e16;
                        bitmap = bitmap4;
                        QLog.e("HttpImageDownloadAsyncTask", 1, "Exception", e);
                    } catch (OutOfMemoryError e17) {
                        Bitmap bitmap5 = bitmap3;
                        inputStream = content;
                        e = e17;
                        bitmap = bitmap5;
                        QLog.e("HttpImageDownloadAsyncTask", 1, "OutOfMemoryError", e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return bitmap;
                    } catch (Throwable th5) {
                        inputStream3 = content;
                        th = th5;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } else {
                    bitmap2 = null;
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                        return bitmap2;
                    } catch (IOException unused3) {
                        return bitmap2;
                    }
                }
                return bitmap2;
            } catch (Exception e18) {
                e = e18;
                bitmap = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                bitmap = null;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    protected byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        a aVar = this.f341022d;
        if (aVar != null) {
            aVar.r1(this.f341021c, bitmap);
        }
    }
}
