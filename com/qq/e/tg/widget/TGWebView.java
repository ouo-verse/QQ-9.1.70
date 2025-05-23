package com.qq.e.tg.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.pi.ITGWebView;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.TGWebViewListener;
import com.qq.e.comm.pi.TangramWidget;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TGWebView {

    /* renamed from: a, reason: collision with root package name */
    private ITGWebView f40886a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        TGWebViewListener f40889a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<Context> f40890b;

        /* renamed from: c, reason: collision with root package name */
        String f40891c;

        /* renamed from: d, reason: collision with root package name */
        String f40892d;

        /* renamed from: e, reason: collision with root package name */
        String f40893e;

        public Builder bindData(String str) {
            this.f40892d = str;
            return this;
        }

        public TGWebView build() {
            WeakReference<Context> weakReference = this.f40890b;
            if (weakReference != null && weakReference.get() != null) {
                TGWebView tGWebView = new TGWebView((byte) 0);
                TGWebView.a(tGWebView, this);
                return tGWebView;
            }
            throw new IllegalArgumentException("context or appId can not be null!");
        }

        public Builder setAppId(String str) {
            this.f40891c = str;
            return this;
        }

        public Builder setContext(Context context) {
            this.f40890b = new WeakReference<>(context);
            return this;
        }

        public Builder setPosId(String str) {
            this.f40893e = str;
            return this;
        }

        public Builder setTgWebViewListener(TGWebViewListener tGWebViewListener) {
            this.f40889a = tGWebViewListener;
            return this;
        }
    }

    TGWebView() {
    }

    /* synthetic */ TGWebView(byte b16) {
        this();
    }

    static /* synthetic */ void a(TGWebView tGWebView, final Builder builder) {
        if (builder != null) {
            if (TextUtils.isEmpty(builder.f40891c) && GDTADManager.getInstance().getAppStatus() != null) {
                builder.f40891c = GDTADManager.getInstance().getAppStatus().getAPPID();
            }
            if (tGWebView.a(builder)) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.tg.widget.TGWebView.1
                @Override // java.lang.Runnable
                public void run() {
                    TGWebView.this.a(builder);
                }
            });
        }
    }

    public boolean canGoBack() {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null && iTGWebView.canGoBack()) {
            return true;
        }
        return false;
    }

    public void destroySafely() {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.destroySafely();
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.evaluateJavascript(str, valueCallback);
        }
    }

    public View getView() {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            return iTGWebView.getView();
        }
        return null;
    }

    public void goBack() {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.goBack();
        }
    }

    public void loadData(String str, String str2, String str3) {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.loadUrl(str);
        }
    }

    public void pauseTimers() {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.pauseTimers();
        }
    }

    public void reload() {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.reload();
        }
    }

    public void resumeTimers() {
        ITGWebView iTGWebView = this.f40886a;
        if (iTGWebView != null) {
            iTGWebView.resumeTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Builder builder) {
        String message;
        String str;
        if (builder == null) {
            str = "init ITGWebView failed, builder is null";
        } else {
            WeakReference<Context> weakReference = builder.f40890b;
            if (weakReference != null) {
                Context context = weakReference.get();
                if (GDTADManager.getInstance().initWith(context, builder.f40891c)) {
                    try {
                        POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.BASE);
                        if (pOFactory != null) {
                            TangramWidget tangramWidget = pOFactory.getTangramWidget(context, TangramWidget.TANGRAM_WEBVIEW);
                            if (tangramWidget instanceof ITGWebView) {
                                ITGWebView iTGWebView = (ITGWebView) tangramWidget;
                                this.f40886a = iTGWebView;
                                iTGWebView.setInnerWebViewListener(builder.f40889a);
                                this.f40886a.bindAdData(builder.f40893e, builder.f40892d);
                                this.f40886a.create();
                                return true;
                            }
                        }
                    } catch (a unused) {
                        message = "init ITGWebView failed with pe exception";
                        GDTLogger.e(message);
                        return false;
                    } catch (Throwable th5) {
                        message = th5.getMessage();
                        GDTLogger.e(message);
                        return false;
                    }
                }
                return false;
            }
            str = "init ITGWebView failed, context is null";
        }
        GDTLogger.e(str);
        return false;
    }
}
