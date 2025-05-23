package com.tencent.mobileqq.icgame.room.pendant.webview;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.data.pendant.PendantViewData;
import com.tencent.mobileqq.icgame.data.pendant.WebPendantData;
import com.tencent.mobileqq.icgame.room.pendant.webview.PendantWebView;
import com.tencent.mobileqq.icgame.room.pendant.webview.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.smtt.sdk.WebView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import ru0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u000f\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\tR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/icgame/room/pendant/webview/f;", "", "Lcom/tencent/mobileqq/icgame/data/pendant/PendantViewData;", "newPendantViewData", "", "f", "Lcom/tencent/mobileqq/icgame/room/pendant/webview/PendantWebView;", "webView", "pendantData", "", "i", "", "data", "", "delayTime", "d", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "pendantViewData", "g", "k", "j", "a", "Lcom/tencent/mobileqq/icgame/room/pendant/webview/PendantWebView;", "Lcom/tencent/mobileqq/icgame/room/pendant/webview/c;", "b", "Lcom/tencent/mobileqq/icgame/room/pendant/webview/c;", "webBuilder", "c", "Lcom/tencent/mobileqq/icgame/data/pendant/PendantViewData;", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f237690e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PendantWebView webView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private c webBuilder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PendantViewData pendantViewData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/pendant/webview/f$a;", "", "Lcom/tencent/mobileqq/icgame/room/pendant/webview/PendantWebView;", "webView", "", "event", "data", "", "b", "TAG", "Ljava/lang/String;", "", "firstDelayTime", "J", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "normalDelayTime", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.room.pendant.webview.f$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(PendantWebView webView, String event, String data) {
            if (webView != null && !TextUtils.isEmpty(event)) {
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONArray.mo162put(new JSONObject(data));
                    f.f237690e.i("ICGamePendantWebViewDelegate", "onCallJS, event=" + event + ", data=" + data);
                    webView.loadUrl("javascript:execEventCallback('" + event + "'," + jSONArray + ")");
                } catch (Exception e16) {
                    f.f237690e.e("ICGamePendantWebViewDelegate", "onCallJS JSONException: " + e16.getMessage());
                }
            }
        }

        Companion() {
        }
    }

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f237690e = (IAegisLogApi) api;
    }

    private final void d(final PendantWebView webView, final String data, long delayTime) {
        f237690e.i("ICGamePendantWebViewDelegate", "callJsAsync, data=" + data);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.pendant.webview.d
            @Override // java.lang.Runnable
            public final void run() {
                f.e(PendantWebView.this, data);
            }
        }, delayTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PendantWebView pendantWebView, String data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        INSTANCE.b(pendantWebView, "setActData", data);
    }

    private final boolean f(PendantViewData newPendantViewData) {
        String str;
        String str2 = null;
        if (newPendantViewData != null) {
            str = newPendantViewData.version;
        } else {
            str = null;
        }
        PendantViewData pendantViewData = this.pendantViewData;
        if (pendantViewData != null) {
            str2 = pendantViewData.version;
        }
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(PendantViewData pendantViewData, f this$0, WebView webView, String str) {
        Intrinsics.checkNotNullParameter(pendantViewData, "$pendantViewData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WebPendantData webPendantData = pendantViewData.webPendantData;
        if (webPendantData != null && webPendantData.pendantWebData != null) {
            PendantWebView pendantWebView = this$0.webView;
            PendantWebView pendantWebView2 = null;
            if (pendantWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                pendantWebView = null;
            }
            if (Intrinsics.areEqual(pendantWebView, webView)) {
                f237690e.i("ICGamePendantWebViewDelegate", "onPageFinish, url=" + str);
                PendantWebView pendantWebView3 = this$0.webView;
                if (pendantWebView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    pendantWebView2 = pendantWebView3;
                }
                String str2 = pendantViewData.webPendantData.pendantWebData;
                Intrinsics.checkNotNullExpressionValue(str2, "pendantViewData.webPendantData.pendantWebData");
                this$0.d(pendantWebView2, str2, 500L);
            }
        }
    }

    private final void i(PendantWebView webView, PendantViewData pendantData) {
        if (webView == null) {
            f237690e.e("ICGamePendantWebViewDelegate", "loadPendantWebView fail, webview is null");
            return;
        }
        if (pendantData == null) {
            f237690e.e("ICGamePendantWebViewDelegate", "loadPendantWebView fail, pendantData is null");
            return;
        }
        WebPendantData webPendantData = pendantData.webPendantData;
        if (webPendantData == null) {
            f237690e.e("ICGamePendantWebViewDelegate", "loadPendantWebView fail, pendantData.webPendantData is null");
            return;
        }
        f237690e.i("ICGamePendantWebViewDelegate", "load url:" + webPendantData.pendantWebUrl);
        webView.loadUrl(pendantData.webPendantData.pendantWebUrl);
        String str = pendantData.webPendantData.pendantWebData;
        Intrinsics.checkNotNullExpressionValue(str, "pendantData.webPendantData.pendantWebData");
        d(webView, str, 2000L);
    }

    public final void g(@NotNull ViewGroup container, @NotNull final PendantViewData pendantViewData) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(pendantViewData, "pendantViewData");
        PendantWebView pendantWebView = new PendantWebView(container.getContext());
        pendantWebView.setBackgroundColor(0);
        VideoReport.setElementId(pendantWebView, "em_icgame_pendant");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("icgame_pendant_location", String.valueOf(pendantViewData.location));
        linkedHashMap.put("icgame_resource_id", String.valueOf(pendantViewData.viewId));
        mm4.a b16 = qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11162a.a((ru0.a) b16, pendantWebView, false, null, "em_icgame_pendant", linkedHashMap, 6, null);
        this.webView = pendantWebView;
        c cVar = new c(container.getContext(), com.tencent.icgame.game.utils.a.c(container), t42.d.a(), pendantWebView);
        this.webBuilder = cVar;
        cVar.a(new c.a() { // from class: com.tencent.mobileqq.icgame.room.pendant.webview.e
            @Override // com.tencent.mobileqq.icgame.room.pendant.webview.c.a
            public final void onPageFinished(WebView webView, String str) {
                f.h(PendantViewData.this, this, webView, str);
            }
        });
        k(pendantViewData, container);
    }

    public final void j() {
        PendantWebView pendantWebView = this.webView;
        if (pendantWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pendantWebView = null;
        }
        pendantWebView.destroy();
    }

    public final void k(@NotNull PendantViewData pendantViewData, @NotNull ViewGroup container) {
        String str;
        WebPendantData webPendantData;
        Intrinsics.checkNotNullParameter(pendantViewData, "pendantViewData");
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        long j3 = pendantViewData.viewId;
        PendantWebView pendantWebView = null;
        if (j3 == 5) {
            PendantWebView pendantWebView2 = this.webView;
            if (pendantWebView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                pendantWebView2 = null;
            }
            pendantWebView2.setPendantLocation(PendantWebView.PendantLocation.LEFT_TOP);
        } else if (j3 == 1) {
            PendantWebView pendantWebView3 = this.webView;
            if (pendantWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                pendantWebView3 = null;
            }
            pendantWebView3.setPendantLocation(PendantWebView.PendantLocation.RIGHT_TOP);
        } else if (j3 == 4) {
            PendantWebView pendantWebView4 = this.webView;
            if (pendantWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                pendantWebView4 = null;
            }
            pendantWebView4.setPendantLocation(PendantWebView.PendantLocation.RIGHT_BOTTOM);
        }
        if (f(pendantViewData)) {
            String str2 = pendantViewData.webPendantData.pendentWebDataSig;
            PendantViewData pendantViewData2 = this.pendantViewData;
            if (pendantViewData2 != null && (webPendantData = pendantViewData2.webPendantData) != null) {
                str = webPendantData.pendentWebDataSig;
            } else {
                str = null;
            }
            if (!TextUtils.equals(str2, str)) {
                f237690e.i("ICGamePendantWebViewDelegate", "update webData");
                PendantWebView pendantWebView5 = this.webView;
                if (pendantWebView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    pendantWebView = pendantWebView5;
                }
                String str3 = pendantViewData.webPendantData.pendantWebData;
                Intrinsics.checkNotNullExpressionValue(str3, "pendantViewData.webPendantData.pendantWebData");
                d(pendantWebView, str3, 500L);
            }
            this.pendantViewData = pendantViewData;
            return;
        }
        this.pendantViewData = pendantViewData;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) pendantViewData.viewWidth, (int) pendantViewData.viewHeight);
        container.removeAllViews();
        PendantWebView pendantWebView6 = this.webView;
        if (pendantWebView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pendantWebView6 = null;
        }
        container.addView(pendantWebView6, layoutParams);
        PendantWebView pendantWebView7 = this.webView;
        if (pendantWebView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            pendantWebView = pendantWebView7;
        }
        i(pendantWebView, pendantViewData);
    }
}
