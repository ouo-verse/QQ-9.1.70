package com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.FeedRemoteSurfaceHolder;
import com.tencent.mobileqq.guild.home.views.embeddable.WebViewFrameLayoutForegroundService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.ad;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u000b*\u0001\u001c\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001'BE\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b@\u0010AJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u000f\u0010\u001d\u001a\u00020\u001cH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010$R\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010$R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010$R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010=\u001a\n ;*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010$R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010>\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder;", "", "", "y", "", "url", "t", "", "forceLoad", HippyTKDListViewAdapter.X, "w", DomainData.DOMAIN_NAME, "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/Surface;", "surface", "u", "v", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "B", "Lkotlin/Pair;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "com/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder$d", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder$d;", "Landroid/view/TextureView;", "a", "Landroid/view/TextureView;", "clientView", "b", "Ljava/lang/String;", "viewType", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;", "webEventListener", "d", "linkedWebPageId", "e", "Lkotlin/Pair;", "size", "f", "webPageId", "g", h.F, "Landroid/view/Surface;", "i", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder$d;", "webListener", "", "j", "J", "lastStartWebViewTime", "kotlin.jvm.PlatformType", "k", "deviceModel", "Z", "specialDeviceCanReAttach", "<init>", "(Landroid/view/TextureView;Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;Ljava/lang/String;Lkotlin/Pair;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes13.dex */
public final class FeedRemoteSurfaceHolder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextureView clientView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String viewType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c webEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String linkedWebPageId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> size;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String webPageId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String url;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface surface;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d webListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long lastStartWebViewTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final String deviceModel;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean specialDeviceCanReAttach;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder$a", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "surface", "onSurfaceTextureUpdated", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(FeedRemoteSurfaceHolder this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (((Number) this$0.size.getSecond()).intValue() != this$0.clientView.getMeasuredHeight()) {
                this$0.size = new Pair(Integer.valueOf(i3), Integer.valueOf(this$0.clientView.getMeasuredHeight()));
                this$0.B();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            Logger logger = Logger.f235387a;
            FeedRemoteSurfaceHolder feedRemoteSurfaceHolder = FeedRemoteSurfaceHolder.this;
            logger.d().i("FeedRemoteSurfaceHolder", 1, "[onSurfaceTextureAvailable] " + feedRemoteSurfaceHolder.webPageId);
            FeedRemoteSurfaceHolder.this.u(new Surface(surfaceTexture));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surfaceTexture) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            Logger logger = Logger.f235387a;
            FeedRemoteSurfaceHolder feedRemoteSurfaceHolder = FeedRemoteSurfaceHolder.this;
            logger.d().i("FeedRemoteSurfaceHolder", 1, "[onSurfaceTextureDestroyed] " + feedRemoteSurfaceHolder.webPageId + ", surface: " + surfaceTexture.hashCode());
            FeedRemoteSurfaceHolder.this.v();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, final int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            Logger logger = Logger.f235387a;
            FeedRemoteSurfaceHolder feedRemoteSurfaceHolder = FeedRemoteSurfaceHolder.this;
            logger.d().i("FeedRemoteSurfaceHolder", 1, "[onSurfaceTextureSizeChanged] " + feedRemoteSurfaceHolder.webPageId + ", currentWidth: " + feedRemoteSurfaceHolder.size.getFirst() + ",  currentHeight: " + feedRemoteSurfaceHolder.size.getSecond() + ", newWidth: " + width + ", newHeight: " + height + ", surface: " + surfaceTexture.hashCode());
            if (((Number) FeedRemoteSurfaceHolder.this.size.getFirst()).intValue() != width) {
                FeedRemoteSurfaceHolder.this.size = new Pair(Integer.valueOf(width), Integer.valueOf(height));
                FeedRemoteSurfaceHolder.this.B();
            } else if (((Number) FeedRemoteSurfaceHolder.this.size.getSecond()).intValue() != height) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final FeedRemoteSurfaceHolder feedRemoteSurfaceHolder2 = FeedRemoteSurfaceHolder.this;
                uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        FeedRemoteSurfaceHolder.a.b(FeedRemoteSurfaceHolder.this, width);
                    }
                }, 150L);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder$b", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "", "d", UserInfo.SEX_FEMALE, "xDownPos", "e", "yDownPos", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float xDownPos;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float yDownPos;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
            if (event == null) {
                return true;
            }
            RemoteWebRenderIPCServer.INSTANCE.a().G(FeedRemoteSurfaceHolder.this.webPageId, event);
            if (event.getAction() == 0) {
                this.xDownPos = event.getX();
                this.yDownPos = event.getY();
            } else if (event.getAction() == 2) {
                float x16 = event.getX() - this.xDownPos;
                float y16 = event.getY() - this.yDownPos;
                if (x16 > 0.0f && Math.abs(x16) > Math.abs(y16)) {
                    FeedRemoteSurfaceHolder.this.clientView.getParent().requestDisallowInterceptTouchEvent(true);
                }
            } else if (event.getAction() == 1) {
                FeedRemoteSurfaceHolder.this.clientView.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u0012\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/FeedRemoteSurfaceHolder$d", "Lcom/tencent/mobileqq/remoteweb/ad;", "", "webPageId", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "type", "", "startTime", "", "onReportTimeCost", "Lcom/tencent/mobileqq/remoteweb/RemoteWebViewEvent;", "event", "Landroid/os/Bundle;", "extras", "onWebViewEvent", "", "code", "msg", "onFailed", "durationMs", "onServiceDisconnected", "onServiceConnected", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends ad {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f221673a;

            static {
                int[] iArr = new int[RemoteWebViewEvent.values().length];
                try {
                    iArr[RemoteWebViewEvent.ON_PAGE_FINISH.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RemoteWebViewEvent.ON_BEFORE_INIT_WEB_VIEW.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RemoteWebViewEvent.ON_PAGE_STARTED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RemoteWebViewEvent.ON_FULL_SCREEN_EVENT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f221673a = iArr;
            }
        }

        d() {
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onFailed(@com.tencent.qqmini.v8rt.anno.NotNull @NotNull String webPageId, int code, @Nullable String msg2) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            if (Intrinsics.areEqual(FeedRemoteSurfaceHolder.this.webPageId, webPageId)) {
                c cVar = FeedRemoteSurfaceHolder.this.webEventListener;
                if (cVar != null) {
                    cVar.onError(code, msg2);
                }
                Logger.f235387a.d().d("FeedRemoteSurfaceHolder", 1, "[onFailed] " + webPageId + " " + msg2);
            }
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onReportTimeCost(@com.tencent.qqmini.v8rt.anno.NotNull @NotNull String webPageId, @com.tencent.qqmini.v8rt.anno.NotNull @NotNull RemoteWebTimeCost type, long startTime) {
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(type, "type");
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onServiceConnected() {
            Logger logger = Logger.f235387a;
            FeedRemoteSurfaceHolder feedRemoteSurfaceHolder = FeedRemoteSurfaceHolder.this;
            logger.d().d("FeedRemoteSurfaceHolder", 1, "[onServiceConnected] " + feedRemoteSurfaceHolder.webPageId);
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onServiceDisconnected(long durationMs) {
            c cVar = FeedRemoteSurfaceHolder.this.webEventListener;
            if (cVar != null) {
                cVar.onError(-1, "onServiceDisconnected");
            }
            Logger logger = Logger.f235387a;
            FeedRemoteSurfaceHolder feedRemoteSurfaceHolder = FeedRemoteSurfaceHolder.this;
            logger.d().d("FeedRemoteSurfaceHolder", 1, "[onServiceDisconnected] " + feedRemoteSurfaceHolder.webPageId);
        }

        @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
        public void onWebViewEvent(@com.tencent.qqmini.v8rt.anno.NotNull @NotNull String webPageId, @com.tencent.qqmini.v8rt.anno.NotNull @NotNull RemoteWebViewEvent event, @NotNull Bundle extras) {
            c cVar;
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (!Intrinsics.areEqual(FeedRemoteSurfaceHolder.this.webPageId, webPageId)) {
                return;
            }
            int i3 = a.f221673a[event.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        FeedRemoteSurfaceHolder.this.specialDeviceCanReAttach = true;
                        Logger.f235387a.d().d("FeedRemoteSurfaceHolder", 1, "[onWebViewEvent] ON_PAGE_STARTED: " + webPageId + ", " + extras);
                        return;
                    }
                    if (i3 != 4) {
                        Logger.f235387a.d().d("FeedRemoteSurfaceHolder", 1, "[onWebViewEvent] EVENT: " + event.status());
                        return;
                    }
                    Logger.f235387a.d().d("FeedRemoteSurfaceHolder", 1, "[onWebViewEvent] ON_FULL_SCREEN_EVENT: " + webPageId + ", " + extras);
                    boolean z16 = extras.getBoolean(RemoteWebViewEvent.OPEN_FULL_SCREEN, false);
                    c cVar2 = FeedRemoteSurfaceHolder.this.webEventListener;
                    if (cVar2 != null) {
                        cVar2.a(z16);
                        return;
                    }
                    return;
                }
                Logger.f235387a.d().d("FeedRemoteSurfaceHolder", 1, "[onWebViewEvent] ON_BEFORE_INIT_WEB_VIEW: " + webPageId + ", " + extras);
                return;
            }
            Logger.f235387a.d().d("FeedRemoteSurfaceHolder", 1, "[onWebViewEvent] load succeed: " + webPageId + ", " + extras);
            c cVar3 = FeedRemoteSurfaceHolder.this.webEventListener;
            if (cVar3 != null) {
                cVar3.loadSucceed();
            }
            int i16 = extras.getInt(RequestApplyFragment.ERROR_CODE);
            if (i16 != 0 && (cVar = FeedRemoteSurfaceHolder.this.webEventListener) != null) {
                String string = extras.getString("ERROR_MESSAGE");
                if (string == null) {
                    string = "";
                }
                cVar.onError(i16, string);
            }
        }
    }

    @JvmOverloads
    public FeedRemoteSurfaceHolder(@NotNull TextureView clientView, @NotNull String viewType, @Nullable c cVar, @Nullable String str, @NotNull Pair<Integer, Integer> size) {
        Intrinsics.checkNotNullParameter(clientView, "clientView");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(size, "size");
        this.clientView = clientView;
        this.viewType = viewType;
        this.webEventListener = cVar;
        this.linkedWebPageId = str;
        this.size = size;
        this.webPageId = "GuildFeedRemoteSurfaceHolder_WEB_" + System.identityHashCode(this);
        this.webListener = z();
        this.deviceModel = DeviceInfoMonitor.getModel();
        this.specialDeviceCanReAttach = true;
        this.clientView.setSurfaceTextureListener(new a());
        this.clientView.setOnTouchListener(new b());
    }

    private final void A(Context context) {
        Logger.f235387a.d().d("FeedRemoteSurfaceHolder", 1, "[stopWebView] " + this.webPageId);
        WebViewFrameLayoutForegroundService.INSTANCE.d(context, this.webPageId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        if (this.surface == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[updateSurface] surface is null! " + this.webPageId;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("FeedRemoteSurfaceHolder", 1, (String) it.next(), null);
            }
            return;
        }
        Pair<Integer, Integer> q16 = q();
        Logger.f235387a.d().i("FeedRemoteSurfaceHolder", 1, "[updateSurface] " + this.webPageId + ", " + this.surface + "\uff0c (" + q16.getFirst() + " X " + q16.getSecond() + ")");
        WebViewFrameLayoutForegroundService.Companion companion = WebViewFrameLayoutForegroundService.INSTANCE;
        int intValue = q16.getFirst().intValue();
        int intValue2 = q16.getSecond().intValue();
        String str2 = this.webPageId;
        Surface surface = this.surface;
        Intrinsics.checkNotNull(surface);
        companion.e(intValue, intValue2, str2, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        String str;
        Surface surface = this.surface;
        if (surface != null && (str = this.url) != null && System.currentTimeMillis() - this.lastStartWebViewTime >= 200 && m()) {
            Bundle bundle = new Bundle();
            bundle.putString("key_remote_view_type", this.viewType);
            bundle.putString("key_linked_web_page_id", this.linkedWebPageId);
            Pair<Integer, Integer> q16 = q();
            Logger.f235387a.d().i("FeedRemoteSurfaceHolder", 1, "[attachSurface] " + this.webPageId + ", " + surface + ", (" + q16.getFirst() + " X " + q16.getSecond() + ")");
            WebViewFrameLayoutForegroundService.Companion companion = WebViewFrameLayoutForegroundService.INSTANCE;
            Context context = this.clientView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
            companion.b(context, q16.getFirst().intValue(), q16.getSecond().intValue(), true, this.webPageId, str, surface, bundle);
            this.lastStartWebViewTime = System.currentTimeMillis();
            this.specialDeviceCanReAttach = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        String str = this.deviceModel;
        if (str != null) {
            contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "MI 9", false, 2, (Object) null);
            if (contains$default3) {
                z16 = true;
                if (!z16) {
                    String str2 = this.deviceModel;
                    if (str2 != null) {
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "Mi9 Pro 5G", false, 2, (Object) null);
                        if (contains$default2) {
                            z18 = true;
                            if (!z18) {
                                String str3 = this.deviceModel;
                                if (str3 != null) {
                                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "Mi 10", false, 2, (Object) null);
                                    if (contains$default) {
                                        z19 = true;
                                        if (!z19) {
                                            z17 = false;
                                            if (!this.specialDeviceCanReAttach || !z17) {
                                                return true;
                                            }
                                            return false;
                                        }
                                    }
                                }
                                z19 = false;
                                if (!z19) {
                                }
                            }
                        }
                    }
                    z18 = false;
                    if (!z18) {
                    }
                }
                z17 = true;
                if (!this.specialDeviceCanReAttach) {
                }
                return true;
            }
        }
        z16 = false;
        if (!z16) {
        }
        z17 = true;
        if (!this.specialDeviceCanReAttach) {
        }
        return true;
    }

    private final void o(final boolean forceLoad) {
        RemoteWebRenderIPCServer.INSTANCE.a().x(this.webPageId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.FeedRemoteSurfaceHolder$ensureStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Boolean bool) {
                Logger logger = Logger.f235387a;
                FeedRemoteSurfaceHolder feedRemoteSurfaceHolder = this;
                boolean z16 = forceLoad;
                logger.d().d("FeedRemoteSurfaceHolder", 1, "[ensureStatus] " + feedRemoteSurfaceHolder.webPageId + ", isAttach: " + bool + ", forceLoad: " + z16 + ", this: " + feedRemoteSurfaceHolder.hashCode());
                if (Intrinsics.areEqual(bool, Boolean.FALSE) || forceLoad) {
                    this.l();
                } else {
                    this.B();
                }
            }
        });
    }

    static /* synthetic */ void p(FeedRemoteSurfaceHolder feedRemoteSurfaceHolder, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        feedRemoteSurfaceHolder.o(z16);
    }

    private final Pair<Integer, Integer> q() {
        int intValue;
        if (this.size.getFirst().intValue() != 0 && this.size.getSecond().intValue() != 0) {
            if (this.clientView.getMeasuredHeight() > 0) {
                intValue = this.clientView.getMeasuredHeight();
            } else {
                intValue = this.size.getSecond().intValue();
            }
            return new Pair<>(this.size.getFirst(), Integer.valueOf(intValue));
        }
        return new Pair<>(Integer.valueOf(this.clientView.getMeasuredWidth()), Integer.valueOf(this.clientView.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(Surface surface) {
        this.surface = surface;
        RemoteWebRenderIPCServer.INSTANCE.a().w(this.webListener);
        Logger.f235387a.d().d("FeedRemoteSurfaceHolder", 1, "[notifyCreateSurface] surface: " + surface.hashCode() + ", this: " + hashCode());
        p(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        this.surface = null;
    }

    private final d z() {
        return new d();
    }

    public final void n() {
        final String str = this.webPageId;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FeedRemoteSurfaceHolder", 2, "[destroyHolder][destroyRemoteWebView] webPageId: " + str);
        }
        Context context = this.clientView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
        A(context);
        RemoteWebRenderIPCServer.Companion companion = RemoteWebRenderIPCServer.INSTANCE;
        companion.a().f0(this.webListener);
        companion.a().C(str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.FeedRemoteSurfaceHolder$destroyHolder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Logger logger2 = Logger.f235387a;
                String str2 = str;
                if (QLog.isColorLevel()) {
                    logger2.d().d("FeedRemoteSurfaceHolder", 2, "[destroyHolder][destroyRemoteWebView] webPageId: " + str2 + ", isSucceed: " + z16);
                }
            }
        });
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getWebPageId() {
        return this.webPageId;
    }

    public final void t(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!Intrinsics.areEqual(this.url, url)) {
            Logger.f235387a.d().i("FeedRemoteSurfaceHolder", 1, "[loadUrl] " + this.webPageId);
            this.url = url;
            p(this, false, 1, null);
        }
    }

    public final void w() {
        String str = this.webPageId;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FeedRemoteSurfaceHolder", 2, "[notifyPause] webPageId: " + str);
        }
        this.specialDeviceCanReAttach = true;
        WebViewFrameLayoutForegroundService.Companion companion = WebViewFrameLayoutForegroundService.INSTANCE;
        Context context = this.clientView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
        companion.a(context, str, false);
        RemoteWebRenderIPCServer.INSTANCE.a().U(str, false);
    }

    public final void x(boolean forceLoad) {
        String str = this.webPageId;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FeedRemoteSurfaceHolder", 2, "[notifyResume] webPageId: " + str);
        }
        WebViewFrameLayoutForegroundService.Companion companion = WebViewFrameLayoutForegroundService.INSTANCE;
        Context context = this.clientView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
        companion.a(context, str, true);
        RemoteWebRenderIPCServer.INSTANCE.a().U(str, true);
        o(forceLoad);
    }

    public final void y() {
        this.webEventListener = null;
    }
}
