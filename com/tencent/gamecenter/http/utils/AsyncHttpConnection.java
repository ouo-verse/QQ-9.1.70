package com.tencent.gamecenter.http.utils;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import il0.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

/* compiled from: P */
/* loaded from: classes6.dex */
public class AsyncHttpConnection implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private String f106587d;

    /* renamed from: e, reason: collision with root package name */
    private int f106588e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f106589f;

    /* renamed from: h, reason: collision with root package name */
    private String f106590h;

    /* renamed from: i, reason: collision with root package name */
    private HttpClient f106591i;

    public AsyncHttpConnection(Handler handler) {
        this.f106589f = handler;
    }

    private void c(HttpEntity httpEntity, int i3) throws IllegalStateException, IOException {
        long length;
        Message obtain;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent()));
        StringBuilder sb5 = new StringBuilder("");
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            } else {
                sb5.append(readLine);
            }
        }
        String sb6 = sb5.toString();
        if (httpEntity.getContentLength() > 0) {
            length = httpEntity.getContentLength();
        } else {
            length = sb6.getBytes().length;
        }
        String[] strArr = {"" + i3, sb6, "" + length};
        if (QLog.isColorLevel()) {
            QLog.d("GameCenter", 2, "statusCode = " + strArr[0] + ",result = " + strArr[1] + "contentLength = " + length);
        }
        if (i3 != 200 && i3 != 201) {
            obtain = Message.obtain(this.f106589f, 1, strArr);
        } else {
            obtain = Message.obtain(this.f106589f, 2, strArr);
        }
        Handler handler = this.f106589f;
        if (handler != null) {
            handler.sendMessage(obtain);
        } else if (QLog.isColorLevel()) {
            QLog.d("GameCenter", 2, "AsyncHttpConnection_processEntity() handler was null.");
        }
        bufferedReader.close();
    }

    public void a(int i3, String str, String str2) {
        this.f106588e = i3;
        this.f106587d = str;
        this.f106590h = str2;
        a.a().b(this);
    }

    public void b(String str, String str2) {
        a(2, str, str2);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpResponse execute;
        Handler handler = this.f106589f;
        int i3 = 0;
        if (handler != null) {
            handler.sendMessage(Message.obtain(handler, 0));
        } else if (QLog.isColorLevel()) {
            QLog.d("GameCenter", 2, "AsyncHttpConnection_run() Could not call handler to post DID_START message because it was null.");
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        this.f106591i = defaultHttpClient;
        HttpConnectionParams.setConnectionTimeout(defaultHttpClient.getParams(), 20000);
        try {
            this.f106587d = MsfSdkUtils.insertMtype("GameCenter", this.f106587d);
            if (QLog.isColorLevel()) {
                QLog.d("GameCenter", 2, "Http url= " + k.f(this.f106587d, new String[0]));
            }
            int i16 = this.f106588e;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        execute = null;
                    } else {
                        HttpPost httpPost = new HttpPost(this.f106587d);
                        httpPost.setHeader("Content-Type", "multipart/form-data");
                        httpPost.setEntity(new StringEntity(this.f106590h, "utf-8"));
                        httpPost.getParams().setBooleanParameter("http.protocol.expect-continue", false);
                        execute = this.f106591i.execute(httpPost);
                    }
                } else {
                    HttpPost httpPost2 = new HttpPost(this.f106587d);
                    httpPost2.setHeader("Content-Type", "application/x-www-form-urlencoded");
                    httpPost2.setEntity(new StringEntity(this.f106590h, "utf-8"));
                    httpPost2.getParams().setBooleanParameter("http.protocol.expect-continue", false);
                    execute = this.f106591i.execute(httpPost2);
                }
            } else {
                execute = this.f106591i.execute(new HttpGet(this.f106587d));
            }
            if (this.f106588e <= 2 && execute != null) {
                i3 = execute.getStatusLine().getStatusCode();
                c(execute.getEntity(), i3);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("GameCenter", 2, "AsyncHttpConnection_run() statusCode = " + i3 + "," + e16.toString());
            }
            e16.printStackTrace();
            Handler handler2 = this.f106589f;
            if (handler2 != null) {
                this.f106589f.sendMessage(Message.obtain(handler2, 1, e16));
            } else if (QLog.isColorLevel()) {
                QLog.d("GameCenter", 2, "AsyncHttpConnection_run() handler post DID_ERROR because it was null.");
            }
        }
    }
}
