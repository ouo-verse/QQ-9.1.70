package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.minigame.R;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VConsoleView extends LinearLayout implements Handler.Callback {
    private static final String CONSOLE_URL = "https://miniapp.gtimg.cn/qqdevtools/game_vconsole/vconsole.html";
    private static final int MAX_QUEUE_CAPACITY = 500;
    private static final int MSG_PRINT_LOG = 17;
    private static final long PRINT_LOG_INTERVAL = 500;
    private boolean isDestroyed;
    private final ArrayBlockingQueue<String> logQueue;
    private final Handler mainHandler;
    private ImageView vConsoleGap;
    private WebView vConsoleWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            webView.loadUrl("javascript:showPannel()");
            VConsoleView.this.mainHandler.sendEmptyMessage(17);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }
    }

    public VConsoleView(Context context) {
        super(context);
        this.logQueue = new ArrayBlockingQueue<>(500);
        this.mainHandler = new Handler(Looper.getMainLooper(), this);
        this.isDestroyed = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.mini_sdk_vconsole_layout, this);
        this.vConsoleGap = (ImageView) findViewById(R.id.mini_game_vconsole_gap);
        WebView webView = (WebView) findViewById(R.id.mini_game_console_webview);
        this.vConsoleWebView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.vConsoleWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.vConsoleWebView.removeJavascriptInterface("accessibility");
        this.vConsoleWebView.removeJavascriptInterface("accessibilityTraversal");
        this.vConsoleWebView.loadUrl(CONSOLE_URL);
        this.vConsoleWebView.setWebViewClient(new a());
    }

    @MainThread
    private void printLogToWebView() {
        synchronized (this.logQueue) {
            if (this.logQueue.isEmpty()) {
                return;
            }
            ArrayList<String> arrayList = new ArrayList(this.logQueue.size());
            this.logQueue.drainTo(arrayList);
            for (String str : arrayList) {
                this.vConsoleWebView.loadUrl("javascript:console._log(\"" + str + "\")");
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 17) {
            if (!this.isDestroyed) {
                printLogToWebView();
                this.mainHandler.sendEmptyMessageDelayed(17, 500L);
                return true;
            }
            return true;
        }
        return false;
    }

    public void onDestroy() {
        this.mainHandler.removeMessages(17);
        this.isDestroyed = true;
    }

    public void printLogToVConsole(String str) {
        String replace = str.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", RedTouch.NEWLINE_CHAR).replace("\r", "\\r");
        synchronized (this.logQueue) {
            if (this.logQueue.size() == 500) {
                this.logQueue.poll();
            }
            this.logQueue.add(replace);
        }
    }

    public void setOnGapAreaClickListener(View.OnClickListener onClickListener) {
        this.vConsoleGap.setOnClickListener(onClickListener);
    }

    public VConsoleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.logQueue = new ArrayBlockingQueue<>(500);
        this.mainHandler = new Handler(Looper.getMainLooper(), this);
        this.isDestroyed = false;
        initUI();
    }

    public VConsoleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.logQueue = new ArrayBlockingQueue<>(500);
        this.mainHandler = new Handler(Looper.getMainLooper(), this);
        this.isDestroyed = false;
        initUI();
    }
}
