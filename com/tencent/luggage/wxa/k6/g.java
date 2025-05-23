package com.tencent.luggage.wxa.k6;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebChromeClient;
import com.tencent.xweb.WebView;
import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentSkipListSet f131674a = new ConcurrentSkipListSet(new a());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(JsResult jsResult, JsResult jsResult2) {
            return jsResult.hashCode() - jsResult2.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends JsResult {

        /* renamed from: a, reason: collision with root package name */
        public boolean f131676a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsResult f131677b;

        public b(JsResult jsResult) {
            this.f131677b = jsResult;
            g.this.f131674a.add(this);
            this.f131676a = false;
        }

        @Override // com.tencent.xweb.JsResult
        public void cancel() {
            if (!this.f131676a) {
                this.f131677b.cancel();
                this.f131676a = true;
            }
            g.this.f131674a.remove(this);
        }

        @Override // com.tencent.xweb.JsResult
        public void confirm() {
            if (!this.f131676a) {
                this.f131677b.confirm();
                this.f131676a = true;
            }
            g.this.f131674a.remove(this);
        }
    }

    public boolean a(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean b(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    @Override // com.tencent.xweb.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        w.d("Luggage.STANDALONE.MMWebChromeClient", "onJsAlert hash[%d] message[%s]", Integer.valueOf(hashCode()), str2);
        return a(webView, str, str2, a(jsResult));
    }

    @Override // com.tencent.xweb.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        w.d("Luggage.STANDALONE.MMWebChromeClient", "onJsConfirm hash[%d] message[%s]", Integer.valueOf(hashCode()), str2);
        return b(webView, str, str2, a(jsResult));
    }

    public final JsResult a(JsResult jsResult) {
        return new b(jsResult);
    }

    public void a() {
        w.d("Luggage.STANDALONE.MMWebChromeClient", "cleanup hash[%d] waitingSize[%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.f131674a.size()));
        while (!this.f131674a.isEmpty()) {
            ((JsResult) this.f131674a.pollFirst()).cancel();
        }
        onGeolocationPermissionsHidePrompt();
    }
}
