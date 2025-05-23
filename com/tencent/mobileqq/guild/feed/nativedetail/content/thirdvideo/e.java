package com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/e;", "Lcom/tencent/mobileqq/remoteweb/view/e;", "Landroid/view/View;", "view", "", "orientation", "Lcom/tencent/smtt/export/external/interfaces/IX5WebChromeClient$CustomViewCallback;", "callback", "", "showCustomView", "onHideCustomView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/d;", "listener", "b", "a", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/d;", "fullScreenListener", "Landroid/app/Activity;", "inActivity", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "Landroid/os/Bundle;", "extraInfo", "<init>", "(Landroid/app/Activity;Lcom/tencent/biz/ui/TouchWebView;Landroid/os/Bundle;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends com.tencent.mobileqq.remoteweb.view.e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d fullScreenListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Activity inActivity, @NotNull TouchWebView webView, @NotNull Bundle extraInfo) {
        super(inActivity, webView, extraInfo);
        Intrinsics.checkNotNullParameter(inActivity, "inActivity");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    public final void a() {
        this.fullScreenListener = null;
    }

    public final void b(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.fullScreenListener = listener;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onHideCustomView() {
        d dVar = this.fullScreenListener;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void showCustomView(@Nullable View view, int orientation, @Nullable IX5WebChromeClient.CustomViewCallback callback) {
        d dVar = this.fullScreenListener;
        if (dVar != null) {
            dVar.b(view);
        }
    }
}
