package com.tencent.mobileqq.guild.home.views.embeddable;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.home.views.embeddable.GuildHomeMainProcessWebView;
import com.tencent.mobileqq.guild.home.views.embeddable.WebViewFrameLayoutForegroundService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.ad;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wifiphoto.fragment.RequestApplyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0001\u0013\u0018\u0000 J2\u00020\u0001:\u0001$B#\b\u0007\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010&\u001a\u00020#\u0012\b\b\u0002\u0010G\u001a\u00020\u0016\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\f\u001a\u00020\bH\u0007J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u0004R\u0014\u0010\"\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*\"\u0004\b.\u0010/R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010AR\u0014\u0010F\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/embeddable/RemoteSurfaceHolder;", "", "Landroid/view/Surface;", "surface", "", "u", "Landroid/graphics/SurfaceTexture;", "v", "", "forceLoad", DomainData.DOMAIN_NAME, UserInfo.SEX_FEMALE, FileReaderHelper.OPEN_FILE_FROM_FORCE, "y", "Landroid/content/Context;", "context", "E", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "com/tencent/mobileqq/guild/home/views/embeddable/RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1", "D", "()Lcom/tencent/mobileqq/guild/home/views/embeddable/RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1;", "", "url", "t", HippyTKDListViewAdapter.X, "w", "", "dX", "dY", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Z", "singleInstance", "Landroid/view/TextureView;", "b", "Landroid/view/TextureView;", "clientView", "c", "Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/String;", "webPageId", "d", "r", "setUrl", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", "e", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", "p", "()Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;", "B", "(Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$a;)V", "scrollChangeListener", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$b;", "f", "Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$b;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/mobileqq/guild/home/views/embeddable/GuildHomeMainProcessWebView$b;)V", "statusListener", "g", "Landroid/view/Surface;", h.F, "attachedSurface", "i", "Lcom/tencent/mobileqq/guild/home/views/embeddable/RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1;", "webListener", "tag", "<init>", "(ZLandroid/view/TextureView;Ljava/lang/String;)V", "j", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RemoteSurfaceHolder {

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private static Surface f225596k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean singleInstance;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextureView clientView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String webPageId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildHomeMainProcessWebView.a scrollChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildHomeMainProcessWebView.b statusListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface surface;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Surface attachedSurface;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1 webListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/home/views/embeddable/RemoteSurfaceHolder$a", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "surface", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "d", "Z", "firstTime", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements TextureView.SurfaceTextureListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean firstTime;

        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
            Logger logger = Logger.f235387a;
            RemoteSurfaceHolder remoteSurfaceHolder = RemoteSurfaceHolder.this;
            logger.d().d("RemoteSurfaceHolder", 1, "[onSurfaceTextureAvailable] " + remoteSurfaceHolder.getWebPageId());
            RemoteSurfaceHolder.this.u(new Surface(surfaceTexture));
            this.firstTime = false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[onSurfaceTextureDestroyed]");
            RemoteSurfaceHolder.this.v(surface);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surfaceTexture, int width, int height) {
            Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            if (!this.firstTime) {
                Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[onSurfaceTextureUpdated] first!");
                this.firstTime = true;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RemoteSurfaceHolder(boolean z16, @NotNull TextureView clientView) {
        this(z16, clientView, null, 4, null);
        Intrinsics.checkNotNullParameter(clientView, "clientView");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.home.views.embeddable.RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1] */
    private final RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1 D() {
        return new ad() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes13.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f225609a;

                static {
                    int[] iArr = new int[RemoteWebViewEvent.values().length];
                    try {
                        iArr[RemoteWebViewEvent.ON_PAGE_FINISH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[RemoteWebViewEvent.ON_PAGE_SCROLL_EVENT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[RemoteWebViewEvent.ON_BEFORE_INIT_WEB_VIEW.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[RemoteWebViewEvent.ON_PAGE_STARTED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f225609a = iArr;
                }
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onFailed(@com.tencent.qqmini.v8rt.anno.NotNull @NotNull final String webPageId, int code, @Nullable String msg2) {
                Intrinsics.checkNotNullParameter(webPageId, "webPageId");
                if (!Intrinsics.areEqual(RemoteSurfaceHolder.this.getWebPageId(), webPageId)) {
                    String str = webPageId + "/" + RemoteSurfaceHolder.this.getWebPageId();
                    Logger logger = Logger.f235387a;
                    final RemoteSurfaceHolder remoteSurfaceHolder = RemoteSurfaceHolder.this;
                    logger.l(logger.j(new Function1<Logger, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1$onFailed$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Logger logger2) {
                            invoke2(logger2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Logger log) {
                            Intrinsics.checkNotNullParameter(log, "$this$log");
                            String str2 = webPageId;
                            RemoteSurfaceHolder remoteSurfaceHolder2 = remoteSurfaceHolder;
                            Logger.b bVar = new Logger.b();
                            String str3 = "[onFailed] webPageId mismatch " + str2 + " " + remoteSurfaceHolder2.getWebPageId();
                            if (str3 instanceof String) {
                                bVar.a().add(str3);
                            }
                            Iterator<T> it = bVar.a().iterator();
                            while (it.hasNext()) {
                                Logger.f235387a.d().e("RemoteSurfaceHolder", 1, (String) it.next(), null);
                            }
                        }
                    }), str);
                    return;
                }
                GuildHomeMainProcessWebView.b statusListener = RemoteSurfaceHolder.this.getStatusListener();
                if (statusListener != null) {
                    statusListener.a(RemoteSurfaceHolder.this.getUrl(), code, msg2);
                }
                Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[onFailed] " + webPageId + " " + msg2);
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onReportTimeCost(@com.tencent.qqmini.v8rt.anno.NotNull @NotNull String webPageId, @com.tencent.qqmini.v8rt.anno.NotNull @NotNull RemoteWebTimeCost type, long startTime) {
                Intrinsics.checkNotNullParameter(webPageId, "webPageId");
                Intrinsics.checkNotNullParameter(type, "type");
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onServiceConnected() {
                Logger logger = Logger.f235387a;
                RemoteSurfaceHolder remoteSurfaceHolder = RemoteSurfaceHolder.this;
                logger.d().d("RemoteSurfaceHolder", 1, "[onServiceConnected] " + remoteSurfaceHolder.getWebPageId());
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onServiceDisconnected(long durationMs) {
                GuildHomeMainProcessWebView.b statusListener = RemoteSurfaceHolder.this.getStatusListener();
                if (statusListener != null) {
                    statusListener.a(RemoteSurfaceHolder.this.getUrl(), -1, "onServiceDisconnected");
                }
                Logger logger = Logger.f235387a;
                RemoteSurfaceHolder remoteSurfaceHolder = RemoteSurfaceHolder.this;
                logger.d().d("RemoteSurfaceHolder", 1, "[onServiceDisconnected] " + remoteSurfaceHolder.getWebPageId());
            }

            @Override // com.tencent.mobileqq.remoteweb.ad, com.tencent.mobileqq.remoteweb.a
            public void onWebViewEvent(@com.tencent.qqmini.v8rt.anno.NotNull @NotNull final String webPageId, @com.tencent.qqmini.v8rt.anno.NotNull @NotNull final RemoteWebViewEvent event, @NotNull final Bundle extras) {
                GuildHomeMainProcessWebView.b statusListener;
                TextureView textureView;
                Intrinsics.checkNotNullParameter(webPageId, "webPageId");
                Intrinsics.checkNotNullParameter(event, "event");
                Intrinsics.checkNotNullParameter(extras, "extras");
                if (!Intrinsics.areEqual(RemoteSurfaceHolder.this.getWebPageId(), webPageId)) {
                    String str = webPageId + "/" + RemoteSurfaceHolder.this.getWebPageId();
                    Logger logger = Logger.f235387a;
                    final RemoteSurfaceHolder remoteSurfaceHolder = RemoteSurfaceHolder.this;
                    logger.l(logger.j(new Function1<Logger, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.RemoteSurfaceHolder$simpleWebRenderStatusUpdateListener$1$onWebViewEvent$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Logger logger2) {
                            invoke2(logger2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Logger log) {
                            Intrinsics.checkNotNullParameter(log, "$this$log");
                            String str2 = webPageId;
                            RemoteSurfaceHolder remoteSurfaceHolder2 = remoteSurfaceHolder;
                            RemoteWebViewEvent remoteWebViewEvent = event;
                            Bundle bundle = extras;
                            Logger.b bVar = new Logger.b();
                            String str3 = "[onWebViewEvent] webPageId mismatch " + str2 + " " + remoteSurfaceHolder2.getWebPageId() + " " + remoteWebViewEvent + " " + bundle;
                            if (str3 instanceof String) {
                                bVar.a().add(str3);
                            }
                            Iterator<T> it = bVar.a().iterator();
                            while (it.hasNext()) {
                                Logger.f235387a.d().e("RemoteSurfaceHolder", 1, (String) it.next(), null);
                            }
                        }
                    }), str);
                    return;
                }
                int i3 = a.f225609a[event.ordinal()];
                boolean z16 = false;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[onWebViewEvent] EVENT: " + event.status());
                                return;
                            }
                            Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[onWebViewEvent] ON_PAGE_STARTED: " + webPageId + ", " + extras);
                            return;
                        }
                        Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[onWebViewEvent] ON_BEFORE_INIT_WEB_VIEW: " + webPageId + ", " + extras);
                        return;
                    }
                    int[] intArray = extras.getIntArray(RemoteWebViewEvent.SCROLL_VALUES);
                    if (intArray == null) {
                        intArray = new int[0];
                    }
                    GuildHomeMainProcessWebView.a scrollChangeListener = RemoteSurfaceHolder.this.getScrollChangeListener();
                    if (scrollChangeListener != null) {
                        textureView = RemoteSurfaceHolder.this.clientView;
                        scrollChangeListener.a(textureView, intArray);
                    }
                    Logger logger2 = Logger.f235387a;
                    if (QLog.isDevelopLevel()) {
                        String arrays = Arrays.toString(intArray);
                        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                        Log.d("RemoteSurfaceHolder", "[onWebViewEvent] ON_PAGE_SCROLL_EVENT:" + arrays);
                        return;
                    }
                    return;
                }
                Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[onWebViewEvent] load succeed: " + webPageId + ", " + extras);
                String str2 = "";
                String string = extras.getString("ON_PAGE_FINISH_URL", "");
                RemoteSurfaceHolder remoteSurfaceHolder2 = RemoteSurfaceHolder.this;
                if (string.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    string = remoteSurfaceHolder2.getUrl();
                }
                int[] intArray2 = extras.getIntArray("CAN_SCROLL_INIT_DATA");
                GuildHomeMainProcessWebView.b statusListener2 = RemoteSurfaceHolder.this.getStatusListener();
                if (statusListener2 != null) {
                    statusListener2.b(string, intArray2);
                }
                int i16 = extras.getInt(RequestApplyFragment.ERROR_CODE);
                if (i16 != 0 && (statusListener = RemoteSurfaceHolder.this.getStatusListener()) != null) {
                    String string2 = extras.getString("ERROR_MESSAGE");
                    if (string2 != null) {
                        str2 = string2;
                    }
                    statusListener.a(string, i16, str2);
                }
            }
        };
    }

    private final void E(Context context) {
        Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[stopWebView]");
        WebViewFrameLayoutForegroundService.INSTANCE.d(context, this.webPageId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(boolean forceLoad) {
        boolean z16;
        Logger logger = Logger.f235387a;
        logger.d().d("RemoteSurfaceHolder", 1, "[updateSurface] " + this.singleInstance + " " + Intrinsics.areEqual(f225596k, this.surface) + " webPageId: " + getWebPageId() + ", url: " + getUrl());
        if (this.singleInstance) {
            if (!Intrinsics.areEqual(f225596k, this.surface)) {
                RemoteWebRenderIPCServer.INSTANCE.a().j0(this.webPageId, this.surface, this.clientView.getMeasuredWidth(), this.clientView.getMeasuredHeight(), new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.c
                    @Override // eipc.EIPCResultCallback
                    public final void onCallback(EIPCResult eIPCResult) {
                        RemoteSurfaceHolder.G(RemoteSurfaceHolder.this, eIPCResult);
                    }
                });
                return;
            }
            Logger.a d16 = logger.d();
            if (f225596k != this.surface) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16.d("RemoteSurfaceHolder", 1, "checkIfAttach: what to do? " + z16 + ", will reloadUrl");
            z();
            return;
        }
        if (this.surface == null) {
            y(true);
            return;
        }
        if (forceLoad) {
            if (QLog.isColorLevel()) {
                logger.d().d("RemoteSurfaceHolder", 2, "[reloadUrl] webPageId:" + getWebPageId() + ", " + getUrl());
            }
            WebViewFrameLayoutForegroundService.Companion companion = WebViewFrameLayoutForegroundService.INSTANCE;
            Context context = this.clientView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
            int measuredWidth = this.clientView.getMeasuredWidth();
            int measuredHeight = this.clientView.getMeasuredHeight();
            boolean z17 = !this.singleInstance;
            String str = this.webPageId;
            String str2 = this.url;
            Intrinsics.checkNotNull(str2);
            Surface surface = this.surface;
            Intrinsics.checkNotNull(surface);
            WebViewFrameLayoutForegroundService.Companion.c(companion, context, measuredWidth, measuredHeight, z17, str, str2, surface, null, 128, null);
            return;
        }
        WebViewFrameLayoutForegroundService.Companion companion2 = WebViewFrameLayoutForegroundService.INSTANCE;
        int measuredWidth2 = this.clientView.getMeasuredWidth();
        int measuredHeight2 = this.clientView.getMeasuredHeight();
        String str3 = this.webPageId;
        Surface surface2 = this.surface;
        Intrinsics.checkNotNull(surface2);
        companion2.e(measuredWidth2, measuredHeight2, str3, surface2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(RemoteSurfaceHolder this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult.isSuccess()) {
            f225596k = this$0.surface;
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("RemoteSurfaceHolder", 2, "[updateSurface] succeed webPageId: " + this$0.getWebPageId() + ", url: " + this$0.getUrl());
            }
            this$0.z();
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("RemoteSurfaceHolder", 2, "[updateSurface] error " + eIPCResult.f396321e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(RemoteSurfaceHolder this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RemoteWebRenderIPCServer a16 = RemoteWebRenderIPCServer.INSTANCE.a();
        String str = this$0.webPageId;
        Intrinsics.checkNotNullExpressionValue(event, "event");
        a16.G(str, event);
        return true;
    }

    private final boolean l() {
        String str;
        Surface surface = this.surface;
        if (surface == null || (str = this.url) == null) {
            return false;
        }
        WebViewFrameLayoutForegroundService.Companion companion = WebViewFrameLayoutForegroundService.INSTANCE;
        Context context = this.clientView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
        WebViewFrameLayoutForegroundService.Companion.c(companion, context, this.clientView.getMeasuredWidth(), this.clientView.getMeasuredHeight(), !this.singleInstance, this.webPageId, str, surface, null, 128, null);
        return true;
    }

    private final void n(final boolean forceLoad) {
        Logger.f235387a.d().d("RemoteSurfaceHolder", 1, "[ensureStatus] try checkIfAttach webPageId " + getWebPageId());
        RemoteWebRenderIPCServer.INSTANCE.a().x(this.webPageId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.RemoteSurfaceHolder$ensureStatus$2
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
                Logger logger = Logger.f235387a;
                RemoteSurfaceHolder remoteSurfaceHolder = RemoteSurfaceHolder.this;
                logger.d().d("RemoteSurfaceHolder", 1, "[ensureStatus] checkIfAttach webPageId " + remoteSurfaceHolder.getWebPageId() + " result " + z16);
                if (!z16) {
                    RemoteSurfaceHolder.this.y(forceLoad);
                } else {
                    RemoteSurfaceHolder.this.F(forceLoad);
                }
            }
        });
    }

    static /* synthetic */ void o(RemoteSurfaceHolder remoteSurfaceHolder, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        remoteSurfaceHolder.n(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(Surface surface) {
        this.surface = surface;
        RemoteWebRenderIPCServer.INSTANCE.a().w(this.webListener);
        o(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(SurfaceTexture surface) {
        Logger logger = Logger.f235387a;
        logger.d().d("RemoteSurfaceHolder", 1, "[notifySurfaceDestroy]");
        if (f225596k == surface) {
            f225596k = null;
            logger.d().d("RemoteSurfaceHolder", 1, "set sCurrentAttachSurface = null");
        }
        if (this.surface == surface) {
            this.surface = null;
            Context context = this.clientView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
            E(context);
            logger.d().d("RemoteSurfaceHolder", 1, "set surface = null");
        }
        this.surface = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(boolean force) {
        if ((force || f225596k != this.surface) && l()) {
            Surface surface = this.surface;
            f225596k = surface;
            this.attachedSurface = surface;
        }
    }

    private final void z() {
        final String str;
        Surface surface = this.surface;
        if (surface == null || (str = this.url) == null) {
            return;
        }
        final String str2 = this.webPageId;
        RemoteWebRenderIPCServer.INSTANCE.a().R(str, surface, str2, new Bundle(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.RemoteSurfaceHolder$reloadUrl$1
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
                Logger logger = Logger.f235387a;
                String str3 = str2;
                String str4 = str;
                if (QLog.isColorLevel()) {
                    logger.d().d("RemoteSurfaceHolder", 2, "[reloadUrl] result\uff1a" + z16 + ", webID:" + str3 + ", " + str4);
                }
            }
        });
    }

    public final void B(@Nullable GuildHomeMainProcessWebView.a aVar) {
        this.scrollChangeListener = aVar;
    }

    public final void C(@Nullable GuildHomeMainProcessWebView.b bVar) {
        this.statusListener = bVar;
    }

    public final void m() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("RemoteSurfaceHolder", 2, "[destroyHolder][destroyRemoteWebView] webPageId: " + getWebPageId());
        }
        final String str = this.webPageId;
        Context context = this.clientView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
        E(context);
        RemoteWebRenderIPCServer.Companion companion = RemoteWebRenderIPCServer.INSTANCE;
        companion.a().f0(this.webListener);
        companion.a().C(str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.RemoteSurfaceHolder$destroyHolder$2
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
                    logger2.d().d("RemoteSurfaceHolder", 2, "[destroyHolder][destroyRemoteWebView] webPageId: " + str2 + ", isSucceed: " + z16);
                }
            }
        });
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final GuildHomeMainProcessWebView.a getScrollChangeListener() {
        return this.scrollChangeListener;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final GuildHomeMainProcessWebView.b getStatusListener() {
        return this.statusListener;
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

    @JvmOverloads
    public final void t(@Nullable String url, boolean force) {
        if (force || !Intrinsics.areEqual(this.url, url)) {
            this.url = url;
            n(force);
        }
    }

    public final void w() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("RemoteSurfaceHolder", 2, "[notifyPause] webPageId: " + getWebPageId());
        }
        WebViewFrameLayoutForegroundService.Companion companion = WebViewFrameLayoutForegroundService.INSTANCE;
        Context context = this.clientView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
        companion.a(context, this.webPageId, false);
        RemoteWebRenderIPCServer.INSTANCE.a().U(this.webPageId, false);
    }

    public final void x() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("RemoteSurfaceHolder", 2, "[notifyResume] webPageId: " + getWebPageId());
        }
        WebViewFrameLayoutForegroundService.Companion companion = WebViewFrameLayoutForegroundService.INSTANCE;
        Context context = this.clientView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "clientView.context");
        companion.a(context, this.webPageId, true);
        RemoteWebRenderIPCServer.INSTANCE.a().U(this.webPageId, true);
        o(this, false, 1, null);
    }

    @JvmOverloads
    public RemoteSurfaceHolder(boolean z16, @NotNull TextureView clientView, @NotNull String tag) {
        String str;
        Intrinsics.checkNotNullParameter(clientView, "clientView");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.singleInstance = z16;
        this.clientView = clientView;
        this.webListener = D();
        if (z16) {
            str = tag + "_SINGLETON_WEB";
        } else {
            str = tag + "_WEB_" + System.identityHashCode(this);
        }
        this.webPageId = str;
        clientView.setSurfaceTextureListener(new a());
        clientView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.home.views.embeddable.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean c16;
                c16 = RemoteSurfaceHolder.c(RemoteSurfaceHolder.this, view, motionEvent);
                return c16;
            }
        });
    }

    public /* synthetic */ RemoteSurfaceHolder(boolean z16, TextureView textureView, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, textureView, (i3 & 4) != 0 ? "GuildRemoteSurfaceHolder" : str);
    }

    public final void A(int dX, int dY) {
    }
}
