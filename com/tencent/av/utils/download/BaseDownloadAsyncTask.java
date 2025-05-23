package com.tencent.av.utils.download;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.dataline.util.g;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpConnectionParams;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BaseDownloadAsyncTask extends AsyncTask<ArrayList<com.tencent.av.utils.download.a>, com.tencent.av.utils.download.a, Integer> {

    /* renamed from: d, reason: collision with root package name */
    private static final Handler f77089d = new b();

    /* renamed from: b, reason: collision with root package name */
    private HttpClient f77091b;

    /* renamed from: a, reason: collision with root package name */
    private String f77090a = BaseDownloadAsyncTask.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    boolean f77092c = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a<Data> {

        /* renamed from: a, reason: collision with root package name */
        final BaseDownloadAsyncTask f77094a;

        /* renamed from: b, reason: collision with root package name */
        final Data[] f77095b;

        a(BaseDownloadAsyncTask baseDownloadAsyncTask, Data... dataArr) {
            this.f77094a = baseDownloadAsyncTask;
            this.f77095b = dataArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class b extends Handler {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (message.what == 1) {
                aVar.f77094a.e(((com.tencent.av.utils.download.a[]) aVar.f77095b)[0]);
            }
        }
    }

    private HttpGet b(com.tencent.av.utils.download.a aVar, com.tencent.av.utils.download.b bVar) {
        HttpGet httpGet;
        try {
            httpGet = new HttpGet(aVar.f77096a);
        } catch (IllegalArgumentException e16) {
            bVar.f77106e = e16.toString();
            httpGet = null;
        }
        if (httpGet != null) {
            if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
                httpGet.setHeader("Net-type", q.f250391w);
            } else {
                httpGet.setHeader("Net-type", "gprs");
            }
            HashMap<String, String> hashMap = aVar.f77097b;
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        return httpGet;
    }

    private boolean g(com.tencent.av.utils.download.b bVar, HttpEntity httpEntity, int i3) {
        InputStream inputStream;
        int i16;
        int i17;
        byte[] bArr = new byte[i3];
        try {
            inputStream = httpEntity.getContent();
        } catch (IOException e16) {
            bVar.f77105d = 3;
            bVar.f77106e = e16.toString();
            inputStream = null;
        }
        if (inputStream == null) {
            i16 = 0;
        } else {
            byte[] bArr2 = new byte[2048];
            i16 = 0;
            while (true) {
                try {
                    i17 = inputStream.read(bArr2);
                } catch (IOException e17) {
                    bVar.f77105d = 3;
                    bVar.f77106e = e17.toString();
                    i17 = 0;
                }
                if (i17 <= 0) {
                    break;
                }
                int i18 = i16 + i17;
                if (i18 > i3) {
                    i16 = i18;
                    break;
                }
                System.arraycopy(bArr2, 0, bArr, i16, i17);
                i16 = i18;
            }
        }
        boolean z16 = true;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e18) {
                QLog.e(this.f77090a, 1, "readContent close error: " + e18);
            }
        }
        if (i16 != i3) {
            z16 = false;
        }
        if (z16) {
            bVar.f77102a = bArr;
            bVar.f77103b = i3;
            bVar.f77105d = 0;
        } else {
            bVar.f77105d = 3;
            if (i16 < i3) {
                bVar.f77106e = "ContentLength " + i3 + " but read " + i16;
            } else {
                bVar.f77106e = "ContentLength " + i3 + ",but read " + i16;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f77090a, 2, "readContent done. isSucess = " + z16 + ",length=" + i3);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean c(HttpClient httpClient, com.tencent.av.utils.download.a aVar) {
        HttpResponse httpResponse;
        com.tencent.av.utils.download.b bVar = aVar.f77101f;
        bVar.f77105d = -2;
        HttpGet b16 = b(aVar, bVar);
        if (b16 != null) {
            try {
                httpResponse = httpClient.execute(b16);
            } catch (IOException e16) {
                bVar.f77106e = e16.toString();
                httpResponse = null;
                if (httpResponse == null) {
                }
            } catch (Exception e17) {
                bVar.f77106e = e17.toString();
                httpResponse = null;
                if (httpResponse == null) {
                }
            }
            if (httpResponse == null) {
                return false;
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null) {
                bVar.f77105d = 2;
            } else {
                StatusLine statusLine = httpResponse.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                int contentLength = (int) entity.getContentLength();
                if (statusCode != 200 && statusCode != 206) {
                    bVar.f77105d = 2;
                    bVar.f77106e = statusLine.getReasonPhrase();
                } else if (contentLength <= 0) {
                    bVar.f77105d = 2;
                    bVar.f77106e = "invalid contentLength " + contentLength;
                } else {
                    bVar.f77107f = g(bVar, entity, contentLength);
                }
                if (!bVar.f77107f) {
                    try {
                        entity.getContent().close();
                    } catch (IOException | Exception unused) {
                    }
                }
            }
        }
        return bVar.f77107f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(ArrayList<com.tencent.av.utils.download.a>... arrayListArr) {
        ArrayList<com.tencent.av.utils.download.a> arrayList;
        boolean z16;
        if (arrayListArr != null && (arrayList = arrayListArr[0]) != null) {
            Iterator<com.tencent.av.utils.download.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.av.utils.download.a next = it.next();
                com.tencent.av.utils.download.b bVar = new com.tencent.av.utils.download.b();
                next.f77101f = bVar;
                bVar.f77105d = -1;
            }
            if (g.d() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f77092c = z16;
            int i3 = 5000;
            int i16 = 60000;
            this.f77091b = g.a(false, z16, 5000, 60000);
            StringBuilder sb5 = new StringBuilder();
            Iterator<com.tencent.av.utils.download.a> it5 = arrayListArr[0].iterator();
            int i17 = 0;
            while (it5.hasNext()) {
                com.tencent.av.utils.download.a next2 = it5.next();
                int i18 = next2.f77099d;
                if (i18 != i3) {
                    HttpConnectionParams.setConnectionTimeout(this.f77091b.getParams(), i18);
                    i3 = i18;
                }
                int i19 = next2.f77100e;
                if (i19 != i16) {
                    HttpConnectionParams.setSoTimeout(this.f77091b.getParams(), i19);
                    i16 = i19;
                }
                int i26 = next2.f77098c;
                if (isCancelled()) {
                    break;
                }
                long currentTimeMillis = System.currentTimeMillis();
                while (true) {
                    if (!isCancelled() && !c(this.f77091b, next2)) {
                        int i27 = 3;
                        while (true) {
                            try {
                                LockMethodProxy.sleep(1000L);
                                int i28 = i27 - 1;
                                if (i27 <= 0 || NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                                    break;
                                }
                                i27 = i28;
                            } catch (InterruptedException e16) {
                                e16.printStackTrace();
                            }
                        }
                        int i29 = i26 - 1;
                        if (i26 <= 0) {
                            i26 = i29;
                            break;
                        }
                        i26 = i29;
                    }
                }
                i17++;
                next2.f77101f.f77104c = System.currentTimeMillis() - currentTimeMillis;
                next2.f77101f.f77108g = next2.f77098c - i26;
                sb5.append(next2.toString());
                sb5.append(", ");
                f77089d.obtainMessage(1, new a(this, next2)).sendToTarget();
            }
            if (QLog.isColorLevel() && !sb5.toString().equals("")) {
                QLog.i(this.f77090a, 2, sb5.toString());
            }
            return Integer.valueOf(i17);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        final HttpClient httpClient = this.f77091b;
        if (httpClient != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.download.BaseDownloadAsyncTask.1
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i(BaseDownloadAsyncTask.this.f77090a, 1, "getConnectionManager().shutdown()");
                    httpClient.getConnectionManager().shutdown();
                }
            }, 16, null, false);
            this.f77091b = null;
        }
    }

    public void e(com.tencent.av.utils.download.a aVar) {
    }
}
