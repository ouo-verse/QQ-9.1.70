package com.tencent.mobileqq.qqlive.widget.player;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.callback.room.VideoSeiInfo;
import com.tencent.mobileqq.qqlive.widget.player.b;
import com.tencent.mobileqq.qqlive.widget.player.c;
import com.tencent.mobileqq.qqlive.widget.player.d;
import com.tencent.mobileqq.qqlive.widget.player.e;
import com.tencent.mobileqq.qqlive.widget.player.f;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0013\u001a\u00020\u0004R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010*\u001a\u0004\u0018\u00010#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010)R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u0016R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00104\u001a\u0004\u0018\u00010-8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b2\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010\u0016R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010>\u001a\u0004\u0018\u0001078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010\u001d\u001a\u0004\b<\u0010=R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010\u0016R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001d\u0010H\u001a\u0004\u0018\u00010A8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010\u001d\u001a\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/player/RemotePlayerListenerDispatcher;", "", "Lmi2/c;", "listener", "", "r", BdhLogUtil.LogTag.Tag_Conn, "Lmi2/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "Lmi2/d;", ReportConstant.COSTREPORT_PREFIX, "D", "Lmi2/e;", "t", "E", "Lmi2/a;", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "a", "Ljava/util/Set;", "errorListeners", "Lcom/tencent/mobileqq/qqlive/widget/player/c;", "b", "Lcom/tencent/mobileqq/qqlive/widget/player/c;", "_remoteErrorListener", "c", "Lkotlin/Lazy;", "w", "()Lcom/tencent/mobileqq/qqlive/widget/player/c;", "remoteErrorListener", "d", "definitionListeners", "Lcom/tencent/mobileqq/qqlive/widget/player/f;", "e", "Lcom/tencent/mobileqq/qqlive/widget/player/f;", "_remoteDefinitionListener", "f", "v", "()Lcom/tencent/mobileqq/qqlive/widget/player/f;", "remoteDefinitionListener", "g", "firstFrameRenderedListeners", "Lcom/tencent/mobileqq/qqlive/widget/player/d;", h.F, "Lcom/tencent/mobileqq/qqlive/widget/player/d;", "_remoteFirstFrameRenderedListener", "i", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/qqlive/widget/player/d;", "remoteFirstFrameRenderedListener", "j", "seiInfoListeners", "Lcom/tencent/mobileqq/qqlive/widget/player/e;", "k", "Lcom/tencent/mobileqq/qqlive/widget/player/e;", "_remoteSeiInfoListener", "l", "y", "()Lcom/tencent/mobileqq/qqlive/widget/player/e;", "remoteSeiInfoListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bufferListeners", "Lcom/tencent/mobileqq/qqlive/widget/player/b;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqlive/widget/player/b;", "_remoteBufferListener", "o", "u", "()Lcom/tencent/mobileqq/qqlive/widget/player/b;", "remoteBufferListener", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RemotePlayerListenerDispatcher {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<mi2.c> errorListeners;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c _remoteErrorListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy remoteErrorListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<mi2.f> definitionListeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f _remoteDefinitionListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy remoteDefinitionListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<mi2.d> firstFrameRenderedListeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d _remoteFirstFrameRenderedListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy remoteFirstFrameRenderedListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<mi2.e> seiInfoListeners;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e _remoteSeiInfoListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy remoteSeiInfoListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<mi2.a> bufferListeners;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b _remoteBufferListener;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy remoteBufferListener;

    public RemotePlayerListenerDispatcher() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.errorListeners = new LinkedHashSet();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.qqlive.widget.player.RemotePlayerListenerDispatcher$remoteErrorListener$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/widget/player/RemotePlayerListenerDispatcher$remoteErrorListener$2$a", "Lcom/tencent/mobileqq/qqlive/widget/player/c$a;", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "", "onError", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes17.dex */
            public static final class a extends c.a {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RemotePlayerListenerDispatcher f274027d;

                a(RemotePlayerListenerDispatcher remotePlayerListenerDispatcher) {
                    this.f274027d = remotePlayerListenerDispatcher;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) remotePlayerListenerDispatcher);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.widget.player.c
                public void onError(int module, int errorType, int errorCode, @Nullable String extraInfo) {
                    Set set;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        set = this.f274027d.errorListeners;
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((mi2.c) it.next()).onError(module, errorType, errorCode, extraInfo);
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(module), Integer.valueOf(errorType), Integer.valueOf(errorCode), extraInfo);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RemotePlayerListenerDispatcher.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final c invoke() {
                c cVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RemotePlayerListenerDispatcher.this._remoteErrorListener = new a(RemotePlayerListenerDispatcher.this);
                cVar = RemotePlayerListenerDispatcher.this._remoteErrorListener;
                return cVar;
            }
        });
        this.remoteErrorListener = lazy;
        this.definitionListeners = new LinkedHashSet();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<f>() { // from class: com.tencent.mobileqq.qqlive.widget.player.RemotePlayerListenerDispatcher$remoteDefinitionListener$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/widget/player/RemotePlayerListenerDispatcher$remoteDefinitionListener$2$a", "Lcom/tencent/mobileqq/qqlive/widget/player/f$a;", "", "o", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes17.dex */
            public static final class a extends f.a {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RemotePlayerListenerDispatcher f274026d;

                a(RemotePlayerListenerDispatcher remotePlayerListenerDispatcher) {
                    this.f274026d = remotePlayerListenerDispatcher;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) remotePlayerListenerDispatcher);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.widget.player.f
                public void o() {
                    Set set;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        set = this.f274026d.definitionListeners;
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((mi2.f) it.next()).o();
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RemotePlayerListenerDispatcher.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final f invoke() {
                f fVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (f) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RemotePlayerListenerDispatcher.this._remoteDefinitionListener = new a(RemotePlayerListenerDispatcher.this);
                fVar = RemotePlayerListenerDispatcher.this._remoteDefinitionListener;
                return fVar;
            }
        });
        this.remoteDefinitionListener = lazy2;
        this.firstFrameRenderedListeners = new LinkedHashSet();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.qqlive.widget.player.RemotePlayerListenerDispatcher$remoteFirstFrameRenderedListener$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/widget/player/RemotePlayerListenerDispatcher$remoteFirstFrameRenderedListener$2$a", "Lcom/tencent/mobileqq/qqlive/widget/player/d$a;", "", "onFirstFrameRendered", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes17.dex */
            public static final class a extends d.a {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RemotePlayerListenerDispatcher f274028d;

                a(RemotePlayerListenerDispatcher remotePlayerListenerDispatcher) {
                    this.f274028d = remotePlayerListenerDispatcher;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) remotePlayerListenerDispatcher);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.widget.player.d
                public void onFirstFrameRendered() {
                    Set set;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        set = this.f274028d.firstFrameRenderedListeners;
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((mi2.d) it.next()).onFirstFrameRendered();
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RemotePlayerListenerDispatcher.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final d invoke() {
                d dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RemotePlayerListenerDispatcher.this._remoteFirstFrameRenderedListener = new a(RemotePlayerListenerDispatcher.this);
                dVar = RemotePlayerListenerDispatcher.this._remoteFirstFrameRenderedListener;
                return dVar;
            }
        });
        this.remoteFirstFrameRenderedListener = lazy3;
        this.seiInfoListeners = new LinkedHashSet();
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.qqlive.widget.player.RemotePlayerListenerDispatcher$remoteSeiInfoListener$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/widget/player/RemotePlayerListenerDispatcher$remoteSeiInfoListener$2$a", "Lcom/tencent/mobileqq/qqlive/widget/player/e$a;", "Lcom/tencent/mobileqq/qqlive/callback/room/VideoSeiInfo;", "seiInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes17.dex */
            public static final class a extends e.a {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RemotePlayerListenerDispatcher f274029d;

                a(RemotePlayerListenerDispatcher remotePlayerListenerDispatcher) {
                    this.f274029d = remotePlayerListenerDispatcher;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) remotePlayerListenerDispatcher);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.widget.player.e
                public void q(@Nullable VideoSeiInfo seiInfo) {
                    Set set;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        set = this.f274029d.seiInfoListeners;
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((mi2.e) it.next()).q(seiInfo);
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) seiInfo);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RemotePlayerListenerDispatcher.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final e invoke() {
                e eVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RemotePlayerListenerDispatcher.this._remoteSeiInfoListener = new a(RemotePlayerListenerDispatcher.this);
                eVar = RemotePlayerListenerDispatcher.this._remoteSeiInfoListener;
                return eVar;
            }
        });
        this.remoteSeiInfoListener = lazy4;
        this.bufferListeners = new LinkedHashSet();
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.qqlive.widget.player.RemotePlayerListenerDispatcher$remoteBufferListener$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqlive/widget/player/RemotePlayerListenerDispatcher$remoteBufferListener$2$a", "Lcom/tencent/mobileqq/qqlive/widget/player/b$a;", "", "K", "w", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes17.dex */
            public static final class a extends b.a {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RemotePlayerListenerDispatcher f274025d;

                a(RemotePlayerListenerDispatcher remotePlayerListenerDispatcher) {
                    this.f274025d = remotePlayerListenerDispatcher;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) remotePlayerListenerDispatcher);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.widget.player.b
                public void K() {
                    Set set;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        set = this.f274025d.bufferListeners;
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((mi2.a) it.next()).K();
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }

                @Override // com.tencent.mobileqq.qqlive.widget.player.b
                public void w() {
                    Set set;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        set = this.f274025d.bufferListeners;
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            ((mi2.a) it.next()).w();
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RemotePlayerListenerDispatcher.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final b invoke() {
                b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RemotePlayerListenerDispatcher.this._remoteBufferListener = new a(RemotePlayerListenerDispatcher.this);
                bVar = RemotePlayerListenerDispatcher.this._remoteBufferListener;
                return bVar;
            }
        });
        this.remoteBufferListener = lazy5;
    }

    public final void A(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.bufferListeners.remove(listener);
        }
    }

    public final void B(@Nullable mi2.f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.definitionListeners.remove(listener);
        }
    }

    public final void C(@Nullable mi2.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.errorListeners.remove(listener);
        }
    }

    public final void D(@Nullable mi2.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.firstFrameRenderedListeners.remove(listener);
        }
    }

    public final void E(@Nullable mi2.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.seiInfoListeners.remove(listener);
        }
    }

    public final void p(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.bufferListeners.add(listener);
        }
    }

    public final void q(@Nullable mi2.f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.definitionListeners.add(listener);
        }
    }

    public final void r(@Nullable mi2.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.errorListeners.add(listener);
        }
    }

    public final void s(@Nullable mi2.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.firstFrameRenderedListeners.add(listener);
        }
    }

    public final void t(@Nullable mi2.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.seiInfoListeners.add(listener);
        }
    }

    @Nullable
    public final b u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (b) this.remoteBufferListener.getValue();
    }

    @Nullable
    public final f v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (f) this.remoteDefinitionListener.getValue();
    }

    @Nullable
    public final c w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (c) this.remoteErrorListener.getValue();
    }

    @Nullable
    public final d x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (d) this.remoteFirstFrameRenderedListener.getValue();
    }

    @Nullable
    public final e y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (e) this.remoteSeiInfoListener.getValue();
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        this._remoteErrorListener = null;
        this.errorListeners.clear();
        this._remoteDefinitionListener = null;
        this.definitionListeners.clear();
        this._remoteFirstFrameRenderedListener = null;
        this.firstFrameRenderedListeners.clear();
        this._remoteSeiInfoListener = null;
        this.seiInfoListeners.clear();
        this._remoteBufferListener = null;
        this.bufferListeners.clear();
    }
}
