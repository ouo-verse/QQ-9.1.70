package com.tencent.mobileqq.jsp;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ab extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private a f238797d;

    /* renamed from: e, reason: collision with root package name */
    private b f238798e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f238799f;

    /* renamed from: h, reason: collision with root package name */
    private String f238800h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        ab f238801a;

        protected a(ab abVar) {
            this.f238801a = abVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ab abVar = this.f238801a;
            if (abVar == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                abVar.p((String) message.obj);
            } else {
                if (i3 != 2) {
                    return;
                }
                abVar.q();
            }
        }

        protected void a() {
            this.f238801a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class b extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        protected Handler f238802a;

        /* renamed from: b, reason: collision with root package name */
        protected Context f238803b;

        /* renamed from: c, reason: collision with root package name */
        protected String f238804c;

        /* renamed from: d, reason: collision with root package name */
        protected String f238805d;

        public b(Handler handler, Context context, String str, String str2) {
            super(handler);
            this.f238802a = handler;
            this.f238803b = context.getApplicationContext();
            this.f238804c = str;
            this.f238805d = str2;
        }

        protected void a(Cursor cursor) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }

        public void c(String str, String str2) {
            this.f238804c = str;
            this.f238805d = str2;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            Cursor cursor;
            Throwable th5;
            super.onChange(z16);
            if (this.f238803b == null || this.f238802a == null) {
                return;
            }
            Cursor cursor2 = null;
            String str = null;
            cursor2 = null;
            try {
                try {
                    cursor = ContactsMonitor.query(this.f238803b.getContentResolver(), Uri.parse("content://sms/inbox"), new String[]{"_id", "address", "body"}, null, null, "date desc");
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                String string = cursor.getString(cursor.getColumnIndex("address"));
                                if (!TextUtils.isEmpty(this.f238804c)) {
                                    if (TextUtils.isEmpty(string)) {
                                        a(cursor);
                                        a(cursor);
                                        return;
                                    } else if (!Pattern.compile(this.f238804c).matcher(string).matches()) {
                                        a(cursor);
                                        a(cursor);
                                        return;
                                    }
                                }
                                if (TextUtils.isEmpty(this.f238805d)) {
                                    a(cursor);
                                    a(cursor);
                                    return;
                                }
                                String string2 = cursor.getString(cursor.getColumnIndex("body"));
                                if (!TextUtils.isEmpty(string2)) {
                                    Matcher matcher = Pattern.compile(this.f238805d).matcher(string2);
                                    if (!matcher.find()) {
                                        a(cursor);
                                        a(cursor);
                                        return;
                                    }
                                    String group = matcher.group();
                                    if (!TextUtils.isEmpty(group)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("sender", string);
                                            jSONObject.put("smsContent", group);
                                            str = jSONObject.toString();
                                        } catch (JSONException e16) {
                                            e16.printStackTrace();
                                        }
                                        if (!TextUtils.isEmpty(str)) {
                                            this.f238802a.obtainMessage(1, str).sendToTarget();
                                        }
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                a(cursor2);
                            }
                            if (cursor2 != null) {
                                a(cursor2);
                                return;
                            }
                            return;
                        } catch (Throwable th6) {
                            th5 = th6;
                            if (cursor != null) {
                                a(cursor);
                            }
                            throw th5;
                        }
                    }
                    if (cursor != null) {
                        a(cursor);
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th7) {
                cursor = cursor2;
                th5 = th7;
            }
        }

        public void b() {
            this.f238803b = null;
            this.f238802a = null;
        }
    }

    private void r(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("senderMatcher", null);
            String optString2 = jSONObject.optString("smsContentMatcher", null);
            int optInt = jSONObject.optInt("timeout", 0);
            String optString3 = jSONObject.optString("callback", null);
            this.f238800h = optString3;
            if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2) && optInt > 0) {
                if (!this.f238799f) {
                    Context context = getContext();
                    if (context == null) {
                        return;
                    }
                    if (this.f238797d == null) {
                        this.f238797d = new a(this);
                    }
                    if (this.f238798e == null) {
                        this.f238798e = new b(this.f238797d, context, optString, optString2);
                    }
                    this.f238799f = true;
                    context.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.f238798e);
                } else {
                    b bVar = this.f238798e;
                    if (bVar != null) {
                        bVar.c(optString, optString2);
                    }
                }
                this.f238797d.removeMessages(2);
                this.f238797d.sendEmptyMessageDelayed(2, optInt * 1000);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void s() {
        Context context;
        if (this.f238799f && this.f238798e != null && (context = getContext()) != null) {
            context.getContentResolver().unregisterContentObserver(this.f238798e);
        }
        this.f238799f = false;
    }

    protected Context getContext() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "sms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && "sms".equals(str2)) {
            if ("startReceiver".equals(str3)) {
                if (strArr == null || strArr.length <= 0) {
                    return false;
                }
                r(strArr[0]);
                return true;
            }
            if ("stopReceiver".equals(str3)) {
                s();
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WebViewPlugin", 2, "can not handle objectname:" + str2 + " methodname:" + str3);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        s();
        b bVar = this.f238798e;
        if (bVar != null) {
            bVar.b();
            this.f238798e = null;
        }
        a aVar = this.f238797d;
        if (aVar != null) {
            aVar.a();
            this.f238797d = null;
        }
        super.onDestroy();
    }

    public void p(String str) {
        if (TextUtils.isEmpty(this.f238800h)) {
            return;
        }
        callJs(this.f238800h, str);
    }

    public void q() {
        s();
    }
}
