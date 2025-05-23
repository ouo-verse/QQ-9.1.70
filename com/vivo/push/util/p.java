package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.vivo.push.f.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class p extends AsyncTask<String, Void, List<Bitmap>> {

    /* renamed from: a, reason: collision with root package name */
    private Context f387920a;

    /* renamed from: b, reason: collision with root package name */
    private InsideNotificationItem f387921b;

    /* renamed from: c, reason: collision with root package name */
    private long f387922c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f387923d;

    /* renamed from: e, reason: collision with root package name */
    private int f387924e = 0;

    /* renamed from: f, reason: collision with root package name */
    private NotifyArriveCallbackByUser f387925f;

    /* renamed from: g, reason: collision with root package name */
    private u.a f387926g;

    public p(Context context, InsideNotificationItem insideNotificationItem, long j3, boolean z16, u.a aVar, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f387920a = context;
        this.f387921b = insideNotificationItem;
        this.f387922c = j3;
        this.f387923d = z16;
        this.f387926g = aVar;
        this.f387925f = notifyArriveCallbackByUser;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        u.c("ImageDownTask", "onPostExecute");
        com.vivo.push.t.c(new q(this, list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009b, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009e, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
    
        if (r5 == null) goto L31;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Bitmap> doInBackground(String... strArr) {
        InputStream inputStream;
        Bitmap bitmap;
        this.f387924e = this.f387921b.getNotifyDisplayStatus();
        InputStream inputStream2 = null;
        if (!this.f387923d) {
            u.d("ImageDownTask", "bitmap is not display by forbid net");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            String str = strArr[i3];
            u.d("ImageDownTask", "imgUrl=" + str + " i=" + i3);
            if (!TextUtils.isEmpty(str)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    u.c("ImageDownTask", "code=".concat(String.valueOf(responseCode)));
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                bitmap = BitmapFactory.decodeStream(inputStream);
                            } catch (MalformedURLException unused) {
                                u.a("ImageDownTask", "MalformedURLException");
                            } catch (IOException unused2) {
                                u.a("ImageDownTask", "IOException");
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception unused3) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        inputStream = null;
                        bitmap = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                } catch (MalformedURLException unused5) {
                    inputStream = null;
                } catch (IOException unused6) {
                    inputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                }
                arrayList.add(bitmap);
            } else if (i3 == 0) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }
}
