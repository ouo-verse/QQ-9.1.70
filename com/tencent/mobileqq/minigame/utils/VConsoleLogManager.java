package com.tencent.mobileqq.minigame.utils;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.ui.VConsoleDragView;
import com.tencent.mobileqq.minigame.ui.VConsoleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VConsoleLogManager implements VConsoleDragView.Listener {
    public static final String ERROR = "error";
    public static final String INFO = "info";
    public static final String LOG = "log";
    private static final int MAX_QUEUE_CAPACITY = 1000;
    public static final String TAG = "[minigame] VConsoleLogManager";
    public static final String WARN = "warn";
    private boolean isVConsoleOpened;
    private VConsoleDragView vConsoleBtn;
    private View vConsoleGap;
    private VConsoleView vConsoleLayout;
    private WebView vConsoleWebView;
    private ArrayBlockingQueue queue = new ArrayBlockingQueue(1000);
    private boolean isPrintingLogs = false;
    private boolean isLogSystemReady = false;
    private boolean hasRequestedToOpenPanel = false;
    String url = "file:///android_asset/mini/mini_vconsole.html";
    private View.OnClickListener mOnvConsoleBtn = new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.utils.VConsoleLogManager.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VConsoleLogManager.this.invokeHideOrShowPanel();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateJavascript(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.utils.VConsoleLogManager.4
            @Override // java.lang.Runnable
            public void run() {
                VConsoleLogManager.this.vConsoleWebView.loadUrl(str);
            }
        });
    }

    private void injectLogInterface(final String str, final String str2) {
        if (this.vConsoleWebView == null) {
            QLog.e(TAG, 2, "consoleWebView is not ready");
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.utils.VConsoleLogManager.3
                @Override // java.lang.Runnable
                public void run() {
                    VConsoleLogManager.this.evaluateJavascript("javascript:console." + str + "(\"" + str2 + "\")");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeHideOrShowPanel() {
        VConsoleView vConsoleView;
        if (this.vConsoleWebView == null || (vConsoleView = this.vConsoleLayout) == null) {
            return;
        }
        if (this.isLogSystemReady) {
            vConsoleView.setVisibility(this.isVConsoleOpened ? 8 : 0);
            this.isVConsoleOpened = !this.isVConsoleOpened;
        } else {
            this.hasRequestedToOpenPanel = !this.isVConsoleOpened;
        }
        this.vConsoleBtn.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogSystemReady(boolean z16) {
        this.isLogSystemReady = z16;
        evaluateJavascript("javascript:showPannel()");
        if (this.hasRequestedToOpenPanel) {
            this.vConsoleLayout.setVisibility(this.isVConsoleOpened ? 8 : 0);
            this.isVConsoleOpened = !this.isVConsoleOpened;
        }
        printLog();
    }

    public void injectLog(String str, String str2) {
        String replace = str2.replace("\n", "\\r\\n").replace("\\\"", "\"").replace("\"", "\\\"");
        if (replace.endsWith("\\")) {
            replace = replace + "\\";
        }
        synchronized (VConsoleLogManager.class) {
            try {
                if (this.queue == null) {
                    this.queue = new ArrayBlockingQueue(1000);
                }
                if (this.queue.size() == 1000) {
                    this.queue.poll();
                }
                this.queue.add(new Pair(str, replace));
                if (this.isLogSystemReady && !this.isPrintingLogs) {
                    printLog();
                }
            } finally {
            }
        }
    }

    @Override // com.tencent.mobileqq.minigame.ui.VConsoleDragView.Listener
    public void onVConsoleMoveUp() {
        invokeHideOrShowPanel();
    }

    public void updateVconsoleView(VConsoleView vConsoleView, VConsoleDragView vConsoleDragView, boolean z16) {
        this.vConsoleLayout = vConsoleView;
        this.vConsoleBtn = vConsoleDragView;
        vConsoleDragView.bringToFront();
        this.vConsoleBtn.setListener(this);
        WebView webView = vConsoleView.vConsoleWebView;
        this.vConsoleWebView = webView;
        webView.loadUrl(this.url);
        this.vConsoleWebView.setWebViewClient(new WebViewClient() { // from class: com.tencent.mobileqq.minigame.utils.VConsoleLogManager.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                VConsoleLogManager.this.setLogSystemReady(true);
            }
        });
        this.isVConsoleOpened = false;
        vConsoleView.setOnClickListener(this.mOnvConsoleBtn);
        ImageView imageView = vConsoleView.vConsoleGap;
        this.vConsoleGap = imageView;
        imageView.setOnClickListener(this.mOnvConsoleBtn);
        if (z16) {
            invokeHideOrShowPanel();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void printLog() {
        this.isPrintingLogs = true;
        Pair pair = (Pair) this.queue.poll();
        while (pair != null) {
            injectLogInterface((String) pair.first, (String) pair.second);
            pair = (Pair) this.queue.poll();
        }
        this.isPrintingLogs = false;
    }
}
