package com.tencent.mobileqq.qwallet.home;

import android.app.Activity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/ae;", "Lz3/b;", "", "buildLayout", "Lcom/tencent/biz/ui/TouchWebView;", "c", "Lcom/tencent/biz/ui/TouchWebView;", "getWebView", "()Lcom/tencent/biz/ui/TouchWebView;", "webView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lmqq/app/AppRuntime;", "appRuntime", "<init>", "(Landroid/app/Activity;Lcom/tencent/biz/ui/TouchWebView;Lmqq/app/AppRuntime;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class ae extends z3.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TouchWebView webView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(@NotNull Activity activity, @NotNull TouchWebView webView, @NotNull AppRuntime appRuntime) {
        super(activity, activity, appRuntime);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.webView = webView;
    }

    @Override // z3.b, com.tencent.mobileqq.webview.util.m
    public void buildLayout() {
        super.buildLayout();
        TouchWebView touchWebView = this.webView;
        this.mWebview = touchWebView;
        touchWebView.setBackgroundColor(0);
        this.mWebview.setWillNotCacheDrawing(false);
        this.mWebview.setDrawingCacheEnabled(true);
    }
}
