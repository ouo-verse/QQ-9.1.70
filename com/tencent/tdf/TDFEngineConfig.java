package com.tencent.tdf;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tdf.view.overlay.TDFOverlayViewFactory;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFEngineConfig {
    static IPatchRedirector $redirector_;
    private GraphicsAPI graphicsAPI;
    private boolean isSimulateVsync;
    private TDFOverlayViewFactory.OverlayViewKind overlayViewKind;
    private int pipelineDriverInterval;
    private RasterTarget rasterTarget;
    private ThreadMode threadMode;
    private TDFViewMode viewMode;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class GraphicsAPI {
        private static final /* synthetic */ GraphicsAPI[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final GraphicsAPI kGLES;
        public static final GraphicsAPI kSoftware;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14580);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            GraphicsAPI graphicsAPI = new GraphicsAPI("kGLES", 0);
            kGLES = graphicsAPI;
            GraphicsAPI graphicsAPI2 = new GraphicsAPI("kSoftware", 1);
            kSoftware = graphicsAPI2;
            $VALUES = new GraphicsAPI[]{graphicsAPI, graphicsAPI2};
        }

        GraphicsAPI(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static GraphicsAPI valueOf(String str) {
            return (GraphicsAPI) Enum.valueOf(GraphicsAPI.class, str);
        }

        public static GraphicsAPI[] values() {
            return (GraphicsAPI[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class RasterTarget {
        private static final /* synthetic */ RasterTarget[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RasterTarget Screen;
        public static final RasterTarget Texture;
        public static final RasterTarget TextureToScreen;
        private int mValue;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14588);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            RasterTarget rasterTarget = new RasterTarget("Screen", 0, 0);
            Screen = rasterTarget;
            RasterTarget rasterTarget2 = new RasterTarget("Texture", 1, 1);
            Texture = rasterTarget2;
            RasterTarget rasterTarget3 = new RasterTarget("TextureToScreen", 2, 2);
            TextureToScreen = rasterTarget3;
            $VALUES = new RasterTarget[]{rasterTarget, rasterTarget2, rasterTarget3};
        }

        RasterTarget(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.mValue = i16;
            }
        }

        public static RasterTarget valueOf(String str) {
            return (RasterTarget) Enum.valueOf(RasterTarget.class, str);
        }

        public static RasterTarget[] values() {
            return (RasterTarget[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class TDFViewMode {
        private static final /* synthetic */ TDFViewMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TDFViewMode SurfaceView;
        public static final TDFViewMode TextureView;

        /* renamed from: id, reason: collision with root package name */
        int f375113id;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14614);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TDFViewMode tDFViewMode = new TDFViewMode("SurfaceView", 0, 0);
            SurfaceView = tDFViewMode;
            TDFViewMode tDFViewMode2 = new TDFViewMode("TextureView", 1, 1);
            TextureView = tDFViewMode2;
            $VALUES = new TDFViewMode[]{tDFViewMode, tDFViewMode2};
        }

        TDFViewMode(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f375113id = i16;
            }
        }

        public static TDFViewMode valueOf(String str) {
            return (TDFViewMode) Enum.valueOf(TDFViewMode.class, str);
        }

        public static TDFViewMode[] values() {
            return (TDFViewMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class ThreadMode {
        private static final /* synthetic */ ThreadMode[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ThreadMode kDefault;
        public static final ThreadMode kPerformancePriority;
        public static final ThreadMode kSynchronicityPriority;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14637);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ThreadMode threadMode = new ThreadMode("kDefault", 0);
            kDefault = threadMode;
            ThreadMode threadMode2 = new ThreadMode("kPerformancePriority", 1);
            kPerformancePriority = threadMode2;
            ThreadMode threadMode3 = new ThreadMode("kSynchronicityPriority", 2);
            kSynchronicityPriority = threadMode3;
            $VALUES = new ThreadMode[]{threadMode, threadMode2, threadMode3};
        }

        ThreadMode(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ThreadMode valueOf(String str) {
            return (ThreadMode) Enum.valueOf(ThreadMode.class, str);
        }

        public static ThreadMode[] values() {
            return (ThreadMode[]) $VALUES.clone();
        }
    }

    public TDFEngineConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.threadMode = ThreadMode.kDefault;
        this.isSimulateVsync = false;
        this.pipelineDriverInterval = 8;
        this.rasterTarget = RasterTarget.Screen;
        this.viewMode = TDFViewMode.SurfaceView;
        this.graphicsAPI = GraphicsAPI.kGLES;
        this.overlayViewKind = TDFOverlayViewFactory.OverlayViewKind.TextureView;
    }

    public GraphicsAPI getGraphicsAPI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (GraphicsAPI) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.graphicsAPI;
    }

    public TDFOverlayViewFactory.OverlayViewKind getOverlayViewKind() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TDFOverlayViewFactory.OverlayViewKind) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.overlayViewKind;
    }

    public int getPipelineDriverInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.pipelineDriverInterval;
    }

    public RasterTarget getRasterTarget() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RasterTarget) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.rasterTarget;
    }

    public ThreadMode getThreadMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ThreadMode) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.threadMode;
    }

    public TDFViewMode getViewMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TDFViewMode) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.viewMode;
    }

    public boolean isSimulateVsync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isSimulateVsync;
    }

    public void setViewMode(TDFViewMode tDFViewMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) tDFViewMode);
        } else {
            this.viewMode = tDFViewMode;
        }
    }

    public TDFEngineConfig(ThreadMode threadMode, int i3, RasterTarget rasterTarget, TDFOverlayViewFactory.OverlayViewKind overlayViewKind) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, threadMode, Integer.valueOf(i3), rasterTarget, overlayViewKind);
            return;
        }
        this.threadMode = ThreadMode.kDefault;
        this.isSimulateVsync = false;
        this.pipelineDriverInterval = 8;
        this.rasterTarget = RasterTarget.Screen;
        this.viewMode = TDFViewMode.SurfaceView;
        this.graphicsAPI = GraphicsAPI.kGLES;
        TDFOverlayViewFactory.OverlayViewKind overlayViewKind2 = TDFOverlayViewFactory.OverlayViewKind.SurfaceView;
        this.threadMode = threadMode;
        this.pipelineDriverInterval = i3;
        this.rasterTarget = rasterTarget;
        this.overlayViewKind = overlayViewKind;
    }

    public TDFEngineConfig(ThreadMode threadMode, RasterTarget rasterTarget, TDFOverlayViewFactory.OverlayViewKind overlayViewKind) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, threadMode, rasterTarget, overlayViewKind);
            return;
        }
        this.threadMode = ThreadMode.kDefault;
        this.isSimulateVsync = false;
        this.pipelineDriverInterval = 8;
        this.rasterTarget = RasterTarget.Screen;
        this.viewMode = TDFViewMode.SurfaceView;
        this.graphicsAPI = GraphicsAPI.kGLES;
        TDFOverlayViewFactory.OverlayViewKind overlayViewKind2 = TDFOverlayViewFactory.OverlayViewKind.SurfaceView;
        this.overlayViewKind = overlayViewKind;
        this.threadMode = threadMode;
        this.rasterTarget = rasterTarget;
    }
}
