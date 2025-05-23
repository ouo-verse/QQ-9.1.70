package com.tencent.luggage.wxa.k6;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.xweb.WebSettings;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m extends WebView {

    /* renamed from: l, reason: collision with root package name */
    public boolean f131707l;

    /* renamed from: m, reason: collision with root package name */
    public static final a f131706m = new a(null);
    public static final AtomicBoolean C = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean A() {
        if (isXWalkKernel() && XWebSdk.getAvailableVersion() >= 472) {
            return isOverScrollStart();
        }
        if (getWebScrollY() == 0) {
            return true;
        }
        return false;
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(getContext() instanceof MutableContextWrapper)) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.MutableContextWrapper");
        MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) context2;
        if (mutableContextWrapper.getBaseContext() == context) {
            return;
        }
        mutableContextWrapper.setBaseContext(context);
    }

    public void d(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            reload();
        } else {
            loadUrl(str);
        }
    }

    @Override // com.tencent.xweb.WebView, com.tencent.xweb.internal.IWebView
    public void destroy() {
        if (!this.f131707l) {
            setWebViewClient(null);
            setWebChromeClient(null);
            setWebViewCallbackClient(null);
            setWebViewClientExtension(null);
            setOnTouchListener(null);
            setOnLongClickListener(null);
            removeAllViews();
            clearView();
            super.destroy();
            System.gc();
            this.f131707l = true;
        }
    }

    public final boolean getDestroyed() {
        return this.f131707l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
    
        if (r3 != 2) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i3) {
        int i16;
        WebSettings settings = getSettings();
        if (i3 != 1) {
            i16 = 2;
        }
        i16 = 0;
        settings.setForceDarkMode(i16);
    }

    public final void setForceDarkMode(int i3) {
        getSettings().setForceDarkMode(i3);
    }

    public /* synthetic */ m(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        if (!C.getAndSet(true)) {
            XWebSdk.initWebviewCore(z.c(), WebView.sDefaultWebViewKind, "main", null);
        } else {
            com.tencent.luggage.wxa.q5.e.f();
        }
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setMixedContentMode(0);
    }
}
