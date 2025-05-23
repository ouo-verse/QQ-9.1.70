package com.tencent.timi.game.liveroom.impl.room.view.rank.base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqlive.webview.LiveWebDialogEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.smtt.sdk.WebView;
import com.tencent.timi.game.liveroom.impl.room.livewebdialog.LiveWebView;
import com.tencent.timi.game.liveroom.impl.room.livewebdialog.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u001c\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u001d\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b$\u0010%B\u0013\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b$\u0010&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006)"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView;", "Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/LiveWebView;", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/d;", "", "url", "", DKWebViewController.DKHippyWebviewFunction.LOAD_URL, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lmqq/app/AppRuntime;", "mInterface", "t", "onDismiss", "Ljava/util/concurrent/CopyOnWriteArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/CopyOnWriteArrayList;", "w", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setCallDataUrlList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "callDataUrlList", "", "G", "Z", "isPageFinished", "()Z", HippyTKDListViewAdapter.X, "(Z)V", "com/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView$b", "H", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView$b;", "pageFinishCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "I", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class RankWebView extends LiveWebView implements d {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<String> callDataUrlList;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isPageFinished;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b pageFinishCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/rank/base/RankWebView$b", "Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/j;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "", "onPageFinished", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements j {
        b() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.livewebdialog.j
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            int i3;
            RankWebView.this.x(true);
            QLog.i("RankWebView", 1, "onPageFinished:");
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
            CopyOnWriteArrayList<String> w3 = RankWebView.this.w();
            RankWebView rankWebView = RankWebView.this;
            Iterator<T> it = w3.iterator();
            while (it.hasNext()) {
                rankWebView.loadUrl((String) it.next());
            }
        }
    }

    public RankWebView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.callDataUrlList = new CopyOnWriteArrayList<>();
        this.pageFinishCallback = new b();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.livewebdialog.LiveWebView, com.tencent.biz.pubaccount.CustomWebView, com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(@Nullable String url) {
        boolean startsWith$default;
        if (url == null) {
            return;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "javascript:window.__WEBVIEW_CHANGETAB", false, 2, null);
        if (startsWith$default && !this.isPageFinished) {
            this.callDataUrlList.add(url);
            return;
        }
        super.loadUrl(url);
        readyForLoadJs();
        this.callDataUrlList.clear();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.livewebdialog.LiveWebView
    public void t(@NotNull Activity activity, @Nullable AppRuntime mInterface) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        new com.tencent.timi.game.liveroom.impl.room.livewebdialog.h(getContext(), activity, mInterface, this, this.pageFinishCallback);
    }

    @NotNull
    protected final CopyOnWriteArrayList<String> w() {
        return this.callDataUrlList;
    }

    protected final void x(boolean z16) {
        this.isPageFinished = z16;
    }

    public RankWebView(@Nullable Context context) {
        super(context);
        this.callDataUrlList = new CopyOnWriteArrayList<>();
        this.pageFinishCallback = new b();
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.base.d
    public void onDismiss() {
    }
}
