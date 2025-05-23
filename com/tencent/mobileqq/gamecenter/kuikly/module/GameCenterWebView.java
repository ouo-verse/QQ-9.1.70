package com.tencent.mobileqq.gamecenter.kuikly.module;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.ad;
import com.tencent.qphone.base.util.QLog;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u000f\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\u0003J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R;\u0010*\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0003\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R;\u0010+\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0003\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)R;\u0010,\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0003\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010)R;\u0010-\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0003\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010)R;\u0010.\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0003\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010)\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/module/GameCenterWebView;", "Landroid/view/TextureView;", "Li01/c;", "", UserInfo.SEX_FEMALE, "B", "", "D", "", "url", "E", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "propKey", "", "propValue", "b", "setUrl", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Ljava/lang/String;", "mWebPageId", "e", "mUrl", "Landroid/view/Surface;", "f", "Landroid/view/Surface;", "mCurrentSurface", tl.h.F, "Z", "isDestroy", "Lcom/tencent/mobileqq/remoteweb/a;", "i", "Lcom/tencent/mobileqq/remoteweb/a;", "mRenderStatusUpdateListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onWebViewEventCallback", "onFailedCallback", "onServiceDisconnectedCallback", "onServiceConnectedCallback", "onReportTimeCostCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "G", "c", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameCenterWebView extends TextureView implements i01.c {

    @Nullable
    private static Surface H;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> onFailedCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> onServiceDisconnectedCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> onServiceConnectedCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> onReportTimeCostCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mWebPageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface mCurrentSurface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isDestroy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.remoteweb.a mRenderStatusUpdateListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> onWebViewEventCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/gamecenter/kuikly/module/GameCenterWebView$a", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "p0", "", "p1", "p2", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture p06, int p16, int p26) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            QLog.d("GameCenterWebView", 2, "[onSurfaceTextureAvailable] p1: " + p16 + ", p2: " + p26);
            GameCenterWebView.this.mCurrentSurface = new Surface(p06);
            GameCenterWebView.this.F();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            QLog.d("GameCenterWebView", 2, "[onSurfaceTextureDestroyed]");
            if (GameCenterWebView.H == GameCenterWebView.this.mCurrentSurface) {
                GameCenterWebView.H = null;
                QLog.d("GameCenterWebView", 2, "[onSurfaceTextureDestroyed] set sCurrentAttachSurface = null");
            }
            GameCenterWebView.this.mCurrentSurface = null;
            GameCenterWebView.this.A();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture p06, int p16, int p26) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            QLog.d("GameCenterWebView", 2, "[onSurfaceTextureSizeChanged] p1: " + p16 + ", p2: " + p26);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            QLog.d("GameCenterWebView", 2, "[onSurfaceTextureUpdated] p0: " + p06);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/gamecenter/kuikly/module/GameCenterWebView$b", "Lcom/tencent/mobileqq/remoteweb/ad;", "", "webPageId", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "type", "", "startTime", "", "onReportTimeCost", "Lcom/tencent/mobileqq/remoteweb/RemoteWebViewEvent;", "event", "onWebViewEvent", "", "code", "msg", "onFailed", "durationMs", "onServiceDisconnected", "onServiceConnected", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends ad {
        b() {
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onFailed(@NotNull String webPageId, int code, @Nullable String msg2) {
            Function1 function1;
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            QLog.e("GameCenterWebView", 1, "[onFailed] pageId: " + webPageId + ", code: " + code + ", msg: " + msg2);
            if (TextUtils.equals(webPageId, GameCenterWebView.this.mWebPageId) && (function1 = GameCenterWebView.this.onFailedCallback) != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("webPageId", webPageId);
                jSONObject.put("retCode", code);
                jSONObject.put("retMsg", msg2);
                function1.invoke(jSONObject);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onReportTimeCost(@NotNull String webPageId, @NotNull RemoteWebTimeCost type, long startTime) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(type, "type");
            QLog.d("GameCenterWebView", 2, "[onReportTimeCost] pageId: " + webPageId + ", type: " + type);
            Function1 function1 = GameCenterWebView.this.onReportTimeCostCallback;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("webPageId", webPageId);
                jSONObject.put("webViewStatus", type.status());
                jSONObject.put("startTime", startTime);
                function1.invoke(jSONObject);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onServiceConnected() {
            QLog.i("GameCenterWebView", 2, "[onServiceConnected] pageId:" + GameCenterWebView.this.mWebPageId);
            Function1 function1 = GameCenterWebView.this.onServiceConnectedCallback;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("webPageId", GameCenterWebView.this.getMWebPageId());
                function1.invoke(jSONObject);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onServiceDisconnected(long durationMs) {
            QLog.i("GameCenterWebView", 1, "[onServiceDisconnected] pageId:" + GameCenterWebView.this.mWebPageId + ", durationMs:" + durationMs);
            Function1 function1 = GameCenterWebView.this.onServiceDisconnectedCallback;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("webPageId", GameCenterWebView.this.getMWebPageId());
                function1.invoke(jSONObject);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onWebViewEvent(@NotNull String webPageId, @NotNull RemoteWebViewEvent event) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(event, "event");
            if (TextUtils.equals(webPageId, GameCenterWebView.this.mWebPageId)) {
                QLog.d("GameCenterWebView", 2, "[onWebViewEvent] pageId: " + webPageId + ", status: " + event.status());
                Function1 function1 = GameCenterWebView.this.onWebViewEventCallback;
                if (function1 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("webPageId", webPageId);
                    jSONObject.put("webViewStatus", event.status());
                    function1.invoke(jSONObject);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCenterWebView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mWebPageId = "";
        this.mUrl = "";
        QLog.d("GameCenterWebView", 2, "=========init========");
        this.mWebPageId = "GameCenterWebView_" + hashCode();
        setSurfaceTextureListener(new a());
        this.mRenderStatusUpdateListener = new b();
        RemoteWebRenderIPCServer.INSTANCE.a().w(this.mRenderStatusUpdateListener);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean c16;
                c16 = GameCenterWebView.c(GameCenterWebView.this, view, motionEvent);
                return c16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        if (this.mCurrentSurface != null && !TextUtils.isEmpty(this.mUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", D());
            bundle.putString("key_remote_view_type", "GameCenterWebView");
            QLog.d("GameCenterWebView", 1, "[createSurface] startRemoteWebView webPageId:" + getMWebPageId() + ",mUrl:" + this.mUrl);
            RemoteWebRenderIPCServer a16 = RemoteWebRenderIPCServer.INSTANCE.a();
            String str = this.mUrl;
            Surface surface = this.mCurrentSurface;
            Intrinsics.checkNotNull(surface);
            String mWebPageId = getMWebPageId();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a16.h0(str, surface, mWebPageId, context, bundle);
            return;
        }
        QLog.i("GameCenterWebView", 1, "[createSurface] mCurrentSurface or mUrl is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: from getter */
    public final String getMWebPageId() {
        return this.mWebPageId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(String url) {
        QLog.d("GameCenterWebView", 2, "[reLoadUrl] url\uff1a" + url);
        if (this.mCurrentSurface != null && !TextUtils.isEmpty(url)) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_web_view_width", getMeasuredWidth());
            bundle.putInt("key_web_view_height", getMeasuredHeight());
            bundle.putBoolean("key_enable_multi_display", D());
            bundle.putString("key_remote_view_type", "GameCenterWebView");
            RemoteWebRenderIPCServer a16 = RemoteWebRenderIPCServer.INSTANCE.a();
            Surface surface = this.mCurrentSurface;
            Intrinsics.checkNotNull(surface);
            a16.R(url, surface, getMWebPageId(), bundle, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.GameCenterWebView$reLoadUrl$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    QLog.d("GameCenterWebView", 1, "[loadUrl] aBoolean \uff1a" + z16 + ", webID:" + GameCenterWebView.this.mWebPageId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        if (this.mCurrentSurface == null) {
            QLog.i("GameCenterWebView", 1, "[updateOrCreateSurface] mCurrentSurface is null, webID:" + getMWebPageId());
            return;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            QLog.d("GameCenterWebView", 1, "[updateOrCreateSurface] mUrl is null");
        } else {
            RemoteWebRenderIPCServer.INSTANCE.a().x(getMWebPageId(), new GameCenterWebView$updateOrCreateSurface$1(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(GameCenterWebView this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RemoteWebRenderIPCServer a16 = RemoteWebRenderIPCServer.INSTANCE.a();
        String mWebPageId = this$0.getMWebPageId();
        Intrinsics.checkNotNullExpressionValue(event, "event");
        a16.G(mWebPageId, event);
        return true;
    }

    public final void A() {
        if (D()) {
            RemoteWebRenderIPCServer.INSTANCE.a().C(getMWebPageId(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.GameCenterWebView$clearMemory$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    QLog.i("GameCenterWebView", 1, "[clearMemory][destroyRemoteWebView] webPageId: " + GameCenterWebView.this.mWebPageId + ", isSucceed: " + z16);
                }
            });
        }
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        String str = null;
        Function1<Object, Unit> function1 = null;
        Function1<Object, Unit> function12 = null;
        Function1<Object, Unit> function13 = null;
        Function1<Object, Unit> function14 = null;
        Function1<Object, Unit> function15 = null;
        switch (propKey.hashCode()) {
            case -995752950:
                if (propKey.equals("pageId")) {
                    if (propValue instanceof String) {
                        str = (String) propValue;
                    }
                    if (str != null) {
                        this.mWebPageId = str;
                    }
                    return true;
                }
                break;
            case 114148:
                if (propKey.equals("src")) {
                    setUrl(propValue.toString());
                    return true;
                }
                break;
            case 594786609:
                if (propKey.equals("onServiceDisconnected")) {
                    if (TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        function15 = (Function1) propValue;
                    }
                    this.onServiceDisconnectedCallback = function15;
                    return true;
                }
                break;
            case 1116433148:
                if (propKey.equals("onFailed")) {
                    if (TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        function14 = (Function1) propValue;
                    }
                    this.onFailedCallback = function14;
                    return true;
                }
                break;
            case 1239168333:
                if (propKey.equals("onReportTimeCost")) {
                    if (TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        function13 = (Function1) propValue;
                    }
                    this.onReportTimeCostCallback = function13;
                    return true;
                }
                break;
            case 1668318592:
                if (propKey.equals("onWebViewEvent")) {
                    if (TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        function12 = (Function1) propValue;
                    }
                    this.onWebViewEventCallback = function12;
                    return true;
                }
                break;
            case 1903606739:
                if (propKey.equals("onServiceConnected")) {
                    if (TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        function1 = (Function1) propValue;
                    }
                    this.onServiceConnectedCallback = function1;
                    return true;
                }
                break;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        QLog.i("GameCenterWebView", 1, "[onDestroy] webPageId:" + getMWebPageId());
        RemoteWebRenderIPCServer.Companion companion = RemoteWebRenderIPCServer.INSTANCE;
        companion.a().C(getMWebPageId(), null);
        companion.a().f0(this.mRenderStatusUpdateListener);
        this.isDestroy = true;
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    public final void setUrl(@Nullable String url) {
        QLog.d("GameCenterWebView", 2, "[setUrl] webPageId: " + this.mWebPageId + ", url: " + url);
        if (url != null) {
            this.mUrl = url;
            F();
        }
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }
}
