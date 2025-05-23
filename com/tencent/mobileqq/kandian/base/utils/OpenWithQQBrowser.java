package com.tencent.mobileqq.kandian.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.filemanageraux.app.UniformDownload;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.WeakReferenceHandler;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes33.dex */
public class OpenWithQQBrowser implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private Activity f239071d;

    /* renamed from: e, reason: collision with root package name */
    private a f239072e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f239073f = false;

    /* renamed from: h, reason: collision with root package name */
    private Handler f239074h = null;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface a {
        void a();

        void b();
    }

    public OpenWithQQBrowser(Activity activity, a aVar) {
        this.f239071d = activity;
        this.f239072e = aVar;
    }

    private void e(Context context, String str, String str2, int i3, final String str3) {
        if (this.f239073f) {
            return;
        }
        this.f239073f = true;
        if (this.f239071d.isFinishing()) {
            a aVar = this.f239072e;
            if (aVar != null) {
                aVar.b();
            }
        } else {
            a aVar2 = this.f239072e;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
        try {
            new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.utils.OpenWithQQBrowser.1
                @Override // java.lang.Runnable
                public void run() {
                    OpenWithQQBrowser.this.d(MsfSdkUtils.insertMtype(GdtLog.WEB_TAG, str3), 0);
                }
            }).start();
        } catch (Throwable unused) {
        }
    }

    public boolean b(String str) {
        return c(str, true, QQBrowserActivity.QQBROWSER_DOWNLOAD_URL_DIRECT_QBSHARE, 0);
    }

    protected boolean c(String str, boolean z16, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(MttLoader.KEY_PID, String.valueOf(50079));
        hashMap.put(MttLoader.KEY_EUSESTAT, String.valueOf(5));
        hashMap.put("ChannelID", this.f239071d.getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i3));
        int loadUrl = MttLoader.loadUrl(this.f239071d, MttLoader.getValidQBUrl(this.f239071d, str), hashMap, null);
        if (z16) {
            if (4 == loadUrl) {
                e(this.f239071d, str, this.f239071d.getResources().getString(R.string.f169956a1), R.string.f169962a7, str2);
            } else if (5 == loadUrl) {
                e(this.f239071d, str, this.f239071d.getResources().getString(R.string.f169955a0), R.string.f169965ac, str2);
            } else if (loadUrl != 0) {
                e(this.f239071d, str, this.f239071d.getResources().getString(R.string.f169956a1), R.string.f169962a7, str2);
            }
        }
        return loadUrl == 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Bundle bundle;
        if (message.what == 101) {
            if (!this.f239071d.isFinishing() && (bundle = (Bundle) message.obj) != null) {
                SharedPreferences sharedPreferences = this.f239071d.getSharedPreferences("qb_info", 0);
                if (sharedPreferences != null) {
                    bundle.putString("param_content_memo", sharedPreferences.getString("content_memo", null));
                    bundle.putString("param_icon_path", sharedPreferences.getString("icon_url", null));
                }
                String string = bundle.getString("qb_param_url");
                if (string != null && string.length() != 0) {
                    bundle.remove("qb_param_url");
                    UniformDownload.b(this.f239071d, string, bundle);
                }
            }
            a aVar = this.f239072e;
            if (aVar != null) {
                aVar.b();
            }
            this.f239073f = false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, int i3) {
        String str2;
        Bundle bundle = null;
        if (i3 < 12) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 301 && responseCode != 302) {
                    if (responseCode == 200) {
                        Bundle bundle2 = new Bundle();
                        try {
                            bundle2.putLong("_filesize", httpURLConnection.getContentLength());
                            bundle2.putString("qb_param_url", httpURLConnection.getURL().toString());
                            bundle2.putString("param_content_des", "");
                            bundle2.putString("param_mime_type", httpURLConnection.getContentType());
                            bundle = bundle2;
                        } catch (Throwable unused) {
                            bundle = bundle2;
                        }
                    }
                    httpURLConnection.disconnect();
                }
                Iterator<String> it = httpURLConnection.getHeaderFields().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = null;
                        break;
                    }
                    String next = it.next();
                    if ("location".equalsIgnoreCase(next)) {
                        str2 = httpURLConnection.getHeaderField(next);
                        break;
                    }
                }
                if (str2 != null) {
                    d(MsfSdkUtils.insertMtype(GdtLog.WEB_TAG, str2), i3 + 1);
                    return;
                }
                httpURLConnection.disconnect();
            } catch (Throwable unused2) {
            }
        }
        if (this.f239074h == null) {
            synchronized (this) {
                if (this.f239074h == null) {
                    this.f239074h = new WeakReferenceHandler(Looper.getMainLooper(), this);
                }
            }
        }
        Message.obtain(this.f239074h, 101, bundle).sendToTarget();
    }
}
