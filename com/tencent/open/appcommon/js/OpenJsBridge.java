package com.tencent.open.appcommon.js;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsbridge.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenJsBridge extends com.tencent.mobileqq.jsbridge.a {

    /* renamed from: c, reason: collision with root package name */
    HashMap<String, a.b> f340684c = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class OpenJsBridgeListener extends a.C7950a {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<WebView> f340687d;

        /* renamed from: e, reason: collision with root package name */
        long f340688e;

        /* renamed from: f, reason: collision with root package name */
        String f340689f;

        public OpenJsBridgeListener(WebView webView, long j3, String str) {
            super(webView, j3, str);
            this.f340687d = new WeakReference<>(webView);
            this.f340688e = j3;
            this.f340689f = str;
        }

        public void e(final String str) {
            if (QLog.isDevelopLevel()) {
                QLog.d("OpenJsBridge", 4, "onNoMatchMethod");
            }
            final WebView webView = this.f340687d.get();
            if (webView == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.2
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.open.base.f.e("OpenJsBridge", "[onNoMatchMethod]AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface." + str + "',{guid:" + OpenJsBridgeListener.this.f340688e + ",'r':-2,'data':'no such method'});");
                    try {
                        webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('interface." + str + "',{guid:" + OpenJsBridgeListener.this.f340688e + ",'r':-2,'data':'no such method'});");
                    } catch (Exception unused) {
                    }
                }
            });
        }

        public void f(final String str, Object obj) {
            final String obj2;
            final WebView webView = this.f340687d.get();
            if (webView != null && obj != null) {
                if (obj instanceof String) {
                    obj2 = "'" + ((Object) ((String) obj).replace("\\", "\\\\").replace("'", "\\'")) + "'";
                } else if (!(obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Float)) {
                    if (obj instanceof Boolean) {
                        obj2 = obj.toString();
                    } else {
                        obj2 = "'undefined'";
                    }
                } else {
                    obj2 = obj.toString();
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.open.base.f.e("OpenJsBridge", "[onOpenComplete]AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface." + str + "',{guid:" + OpenJsBridgeListener.this.f340688e + ",'r':0,'data':" + obj2 + "});");
                        try {
                            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('interface." + str + "',{guid:" + OpenJsBridgeListener.this.f340688e + ",'r':0,'data':" + obj2 + "});");
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.jsbridge.a
    public boolean a(final WebView webView, final String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null || parse.getScheme() == null || !parse.getScheme().equals("jsbridge")) {
            return false;
        }
        com.tencent.open.base.f.e("OpenJsBridge", "[canHandleUrl] AsyncInterface_start:" + str);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.appcommon.js.OpenJsBridge.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                List<String> subList;
                String str3;
                String[] strArr;
                String[] split = (str + "/#").split("/");
                ArrayList arrayList = new ArrayList(Arrays.asList(split));
                if (arrayList.size() < 3) {
                    return;
                }
                String str4 = (String) arrayList.get(2);
                if (arrayList.size() < 5) {
                    return;
                }
                if (arrayList.size() == 5) {
                    String[] split2 = split[3].split("#");
                    if (split2.length <= 1) {
                        str3 = "";
                    } else {
                        str3 = split2[1];
                    }
                    String[] split3 = split2[0].split("\\?");
                    if (split3.length > 1) {
                        strArr = split3[1].split(ContainerUtils.FIELD_DELIMITER);
                        int length = strArr.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            int indexOf = strArr[i3].indexOf(61);
                            if (indexOf != -1) {
                                strArr[i3] = strArr[i3].substring(indexOf + 1);
                            } else {
                                strArr[i3] = "";
                            }
                        }
                    } else {
                        strArr = new String[0];
                    }
                    subList = new ArrayList<>();
                    for (String str5 : strArr) {
                        subList.add(str5);
                    }
                    str2 = split3[0];
                } else {
                    str2 = (String) arrayList.get(3);
                    String str6 = (String) arrayList.get(4);
                    if (str2.trim().equals("callBatch")) {
                        String str7 = (String) arrayList.get(5);
                        String str8 = (String) arrayList.get(6);
                        String str9 = (String) arrayList.get(7);
                        try {
                            long parseLong = Long.parseLong(str6);
                            Long valueOf = Long.valueOf(Long.parseLong(str8));
                            int parseInt = Integer.parseInt(str9);
                            a.b bVar = OpenJsBridge.this.f340684c.get(str4);
                            if (bVar != null && (bVar instanceof BaseInterface)) {
                                ((BaseInterface) bVar).callBatch(webView, OpenJsBridge.this.f340684c, parseLong, str7, valueOf.longValue(), parseInt);
                                return;
                            }
                            webView.loadUrl("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface." + str2 + "',{guid:" + parseLong + ",    'r':-2,'data':'no such method'})};");
                            return;
                        } catch (NumberFormatException | Exception unused) {
                            return;
                        }
                    }
                    subList = arrayList.subList(5, arrayList.size() - 1);
                    str3 = str6;
                }
                try {
                    long parseLong2 = Long.parseLong(str3);
                    if (c.f340695a.contains(str2)) {
                        subList.add(str3);
                    }
                    WebView webView2 = webView;
                    if (webView2 != null) {
                        OpenJsBridge.this.b(str4, str2, subList, new OpenJsBridgeListener(webView2, parseLong2, str));
                    }
                } catch (Exception unused2) {
                }
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.jsbridge.a
    public void b(String str, String str2, List<String> list, a.C7950a c7950a) {
        long currentTimeMillis = System.currentTimeMillis();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                list.set(i3, URLDecoder.decode(list.get(i3), "UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                if (QLog.isDevelopLevel()) {
                    QLog.i("OpenJsBridge", 4, "[getResult]decode failed: " + list.get(i3));
                }
            }
        }
        com.tencent.open.base.f.e("OpenJsBridge", "[getResult]time4-time3=" + (System.currentTimeMillis() - currentTimeMillis));
        a.b bVar = this.f340684c.get(str);
        if (bVar != null) {
            bVar.call(str2, list, c7950a);
        } else if (c7950a instanceof OpenJsBridgeListener) {
            ((OpenJsBridgeListener) c7950a).e(str2);
        }
    }

    @Override // com.tencent.mobileqq.jsbridge.a
    public void c(a.b bVar, String str) {
        this.f340684c.put(str, bVar);
    }

    @Override // com.tencent.mobileqq.jsbridge.a
    public void d(String str) {
        if (str == null) {
            this.f340684c.clear();
        } else {
            this.f340684c.remove(str);
        }
    }

    public HashMap<String, a.b> e() {
        return this.f340684c;
    }
}
