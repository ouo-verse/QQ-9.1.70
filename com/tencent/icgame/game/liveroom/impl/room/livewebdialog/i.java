package com.tencent.icgame.game.liveroom.impl.room.livewebdialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u001c\u0010\u0013\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/i;", "Lcom/tencent/mobileqq/webview/AbsWebView;", "Lcom/tencent/mobileqq/webview/util/m;", "", "preInitWebviewPlugin", "buildLayout", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "buildContentView", "buildTitleBar", "buildBottomBar", "Lmqq/app/AppRuntime;", "mApp", "buildWebView", "buildData", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "onPageFinished", "Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/k;", "a", "Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/k;", "callback", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "inActivity", "mInterface", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "<init>", "(Landroid/content/Context;Landroid/app/Activity;Lmqq/app/AppRuntime;Lcom/tencent/biz/ui/TouchWebView;Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/k;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class i extends AbsWebView implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final k callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@Nullable Context context, @Nullable Activity activity, @Nullable AppRuntime appRuntime, @NotNull TouchWebView webView, @Nullable k kVar) {
        super(context, activity, appRuntime);
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.callback = kVar;
        this.mWebview = webView;
        buildBaseWebView(null);
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageFinished(@Nullable WebView view, @Nullable String url) {
        k kVar = this.callback;
        if (kVar != null) {
            kVar.onPageFinished(view, url);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildBottomBar() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildData() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildLayout() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildTitleBar() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void preInitWebviewPlugin() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildContentView(@Nullable Bundle savedInstanceState) {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildWebView(@Nullable AppRuntime mApp) {
    }
}
