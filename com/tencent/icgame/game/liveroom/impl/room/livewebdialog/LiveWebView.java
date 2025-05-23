package com.tencent.icgame.game.liveroom.impl.room.livewebdialog;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.webview.LiveWebDialogEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0017\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u001d\b\u0016\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 B\u0013\b\u0016\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001f\u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/LiveWebView;", "Lcom/tencent/biz/ui/TouchWebView;", "", ReportConstant.COSTREPORT_PREFIX, "", "url", "u", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lmqq/app/AppRuntime;", "mInterface", "t", "Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/LiveWebView$b;", "callback", "setOnLoadCallback", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", DKWebViewController.DKHippyWebviewFunction.LOAD_URL, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/LiveWebView$b;", "loadCallback", "com/tencent/icgame/game/liveroom/impl/room/livewebdialog/LiveWebView$c", "D", "Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/LiveWebView$c;", "pageFinishCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "E", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class LiveWebView extends TouchWebView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b loadCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c pageFinishCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/LiveWebView$b;", "", "", "url", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
        void a(@Nullable String url);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/livewebdialog/LiveWebView$c", "Lcom/tencent/icgame/game/liveroom/impl/room/livewebdialog/k;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "", "onPageFinished", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements k {
        c() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.livewebdialog.k
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            int i3;
            tt0.c.a().i("ICGameUnknown|ICGameLive_web_dialogICGame[LiveWebView]", 1, "onPageFinished:" + url);
            try {
                b bVar = LiveWebView.this.loadCallback;
                if (bVar != null) {
                    bVar.a(url);
                }
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                if (url == null) {
                    url = "";
                }
                if (view != null) {
                    i3 = view.hashCode();
                } else {
                    i3 = 0;
                }
                simpleEventBus.dispatchEvent(new LiveWebDialogEvent(UIJsPlugin.EVENT_HIDE_LOADING, url, i3));
            } catch (Exception e16) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a("ICGameUnknown|ICGameLive_web_dialogICGame[LiveWebView]", 1, "loadFinish\u53d1\u751f\u5f02\u5e38! " + e16.getMessage());
            }
        }
    }

    public LiveWebView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s();
        this.pageFinishCallback = new c();
    }

    private final void s() {
        com.tencent.icgame.api.cookie.impl.b.f114807a.d(true);
    }

    private final void u(String url) {
        SwiftBrowserOfflineHandler d16 = SwiftBrowserOfflineHandler.d(url);
        if (d16 != null) {
            d16.b(new SwiftBrowserOfflineHandler.b() { // from class: com.tencent.icgame.game.liveroom.impl.room.livewebdialog.h
                @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.b
                public final void onCheckOfflineFinish(int i3) {
                    LiveWebView.v(i3);
                }
            }, url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(int i3) {
        boolean z16;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        SwiftBrowserStatistics.V0 = z16;
    }

    @Override // com.tencent.biz.pubaccount.CustomWebView, com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(@Nullable String url) {
        if (url == null) {
            return;
        }
        u(url);
        tt0.c.a().i("ICGameUnknown|ICGameLive_web_dialogICGame[LiveWebView]", 1, "loadUrl: " + url);
        super.loadUrl(url);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        return false;
    }

    public final void setOnLoadCallback(@Nullable b callback) {
        this.loadCallback = callback;
    }

    public void t(@NotNull Activity activity, @Nullable AppRuntime mInterface) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        new i(getContext(), activity, mInterface, this, this.pageFinishCallback);
    }

    public LiveWebView(@Nullable Context context) {
        super(context);
        s();
        this.pageFinishCallback = new c();
    }
}
