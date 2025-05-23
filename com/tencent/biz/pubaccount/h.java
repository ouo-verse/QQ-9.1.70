package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.MutableContextWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    QQCustomDialog f79646a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f79647b = false;

    /* renamed from: c, reason: collision with root package name */
    int f79648c = 0;

    /* renamed from: d, reason: collision with root package name */
    long f79649d = 0;

    /* renamed from: e, reason: collision with root package name */
    String f79650e = "";

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79651d;

        a(JsResult jsResult) {
            this.f79651d = jsResult;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f79651d.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79653d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79654e;

        b(JsResult jsResult, Context context) {
            this.f79653d = jsResult;
            this.f79654e = context;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f79653d.cancel();
            if (h.this.f79648c > 2) {
                ((Activity) this.f79654e).finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79656d;

        c(JsResult jsResult) {
            this.f79656d = jsResult;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f79656d.confirm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79658d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79659e;

        d(JsResult jsResult, Context context) {
            this.f79658d = jsResult;
            this.f79659e = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f79658d.cancel();
            ((Activity) this.f79659e).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79661d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79662e;

        e(JsResult jsResult, Context context) {
            this.f79661d = jsResult;
            this.f79662e = context;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f79661d.cancel();
            if (h.this.f79648c > 2) {
                ((Activity) this.f79662e).finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79664d;

        f(JsResult jsResult) {
            this.f79664d = jsResult;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f79664d.confirm();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class g implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79666d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79667e;

        g(JsResult jsResult, Context context) {
            this.f79666d = jsResult;
            this.f79667e = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f79666d.cancel();
            ((Activity) this.f79667e).finish();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.h$h, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class DialogInterfaceOnClickListenerC0810h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79669d;

        DialogInterfaceOnClickListenerC0810h(JsResult jsResult) {
            this.f79669d = jsResult;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f79669d.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class i implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79671d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79672e;

        i(JsResult jsResult, Context context) {
            this.f79671d = jsResult;
            this.f79672e = context;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f79671d.cancel();
            if (h.this.f79648c > 2) {
                ((Activity) this.f79672e).finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class j implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79674d;

        j(JsResult jsResult) {
            this.f79674d = jsResult;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f79674d.confirm();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class k implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsResult f79676d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f79677e;

        k(JsResult jsResult, Context context) {
            this.f79676d = jsResult;
            this.f79677e = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f79676d.cancel();
            ((Activity) this.f79677e).finish();
        }
    }

    private String b(Context context, String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("data:")) {
            return context.getString(R.string.c07);
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException unused) {
            return str;
        }
    }

    public void a() {
        QQCustomDialog qQCustomDialog = this.f79646a;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f79646a.cancel();
        }
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        super.onConsoleMessage(consoleMessage);
        VipWebViewReportLog.m(consoleMessage);
        if ((this.f79647b && consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) || QLog.isDevelopLevel()) {
            try {
                String str = "";
                if (consoleMessage.messageLevel() != null) {
                    str = "messageLevel =" + consoleMessage.messageLevel().toString();
                }
                if (consoleMessage.sourceId() != null) {
                    str = str + ", sourceId=" + consoleMessage.sourceId();
                }
                if (consoleMessage.lineNumber() != 0) {
                    str = str + ", lineNumber=" + consoleMessage.lineNumber();
                }
                if (consoleMessage.message() != null) {
                    str = str + ", message=" + consoleMessage.message();
                }
                if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                    if (System.currentTimeMillis() - this.f79649d > 60000 || !str.equals(this.f79650e)) {
                        QLog.e(CustomWebView.TAG_WEBVIEW_CHECK, 1, "CustomWebChromeClient onConsoleMessage:" + str);
                        this.f79650e = str;
                        this.f79649d = System.currentTimeMillis();
                    }
                } else if (System.currentTimeMillis() - this.f79649d > 180000 || !str.equals(this.f79650e)) {
                    QLog.d(CustomWebView.TAG_WEBVIEW_CHECK, 2, "CustomWebChromeClient onConsoleMessage:" + str);
                    this.f79650e = str;
                    this.f79649d = System.currentTimeMillis();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return !QLog.isColorLevel();
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Context context = webView.getContext();
        if (context instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) context).getBaseContext();
        }
        if ((context instanceof Activity) && !((Activity) context).isFinishing() && (!(webView instanceof CustomWebView) || !((CustomWebView) webView).isPaused)) {
            QQCustomDialog qQCustomDialog = this.f79646a;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f79646a.dismiss();
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0);
            this.f79646a = createCustomDialog;
            createCustomDialog.setTitle(b(context, str));
            this.f79646a.setMessage(str2);
            this.f79646a.setPositiveButton(R.string.f171151ok, new c(jsResult));
            if (this.f79648c > 2) {
                this.f79646a.setNegativeButton(context.getString(R.string.f170640wz), context.getResources().getColor(R.color.f156818c9), new d(jsResult, context));
            }
            this.f79646a.setOnCancelListener(new e(jsResult, context));
            this.f79646a.show();
            this.f79648c++;
            return true;
        }
        jsResult.cancel();
        return true;
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        Context context = webView.getContext();
        if (context instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) context).getBaseContext();
        }
        if ((context instanceof Activity) && !((Activity) context).isFinishing() && (!(webView instanceof CustomWebView) || !((CustomWebView) webView).isPaused)) {
            QQCustomDialog qQCustomDialog = this.f79646a;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f79646a.dismiss();
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0);
            this.f79646a = createCustomDialog;
            createCustomDialog.setTitle(R.string.c06);
            this.f79646a.setMessage(str2);
            this.f79646a.setPositiveButton(R.string.f170577uk, new j(jsResult));
            if (this.f79648c > 2) {
                this.f79646a.setNegativeButton(context.getString(R.string.f170640wz), context.getResources().getColor(R.color.f156818c9), new k(jsResult, context));
            } else {
                this.f79646a.setNegativeButton(R.string.f170576uj, new a(jsResult));
            }
            this.f79646a.setOnCancelListener(new b(jsResult, context));
            this.f79646a.show();
            return true;
        }
        jsResult.cancel();
        return true;
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Context context = webView.getContext();
        if (context instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) context).getBaseContext();
        }
        if ((context instanceof Activity) && !((Activity) context).isFinishing() && (!(webView instanceof CustomWebView) || !((CustomWebView) webView).isPaused)) {
            QQCustomDialog qQCustomDialog = this.f79646a;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f79646a.dismiss();
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0);
            this.f79646a = createCustomDialog;
            createCustomDialog.setTitle(b(context, str));
            this.f79646a.setMessage(str2);
            this.f79646a.setPositiveButton(R.string.f171151ok, new f(jsResult));
            if (this.f79648c > 2) {
                this.f79646a.setNegativeButton(context.getString(R.string.f170640wz), context.getResources().getColor(R.color.f156818c9), new g(jsResult, context));
            } else {
                this.f79646a.setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC0810h(jsResult));
            }
            this.f79646a.setOnCancelListener(new i(jsResult, context));
            this.f79646a.show();
            return true;
        }
        jsResult.cancel();
        return true;
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        jsPromptResult.cancel();
        return true;
    }

    @Override // com.tencent.smtt.sdk.WebChromeClient
    public void onProgressChanged(WebView webView, int i3) {
        JsInjector.getInstance().onProgressChanged(webView, i3);
        super.onProgressChanged(webView, i3);
    }
}
