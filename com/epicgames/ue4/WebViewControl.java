package com.epicgames.ue4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.ark.EGLContextHolder;
import com.tencent.filter.GLSLRender;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.ByteArrayInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class WebViewControl {
    private static final String TAG = "WebViewControl";
    private static int initialHeight = 500;
    private static int initialWidth = 500;
    private String NextContent;
    private String NextURL;
    boolean PendingSetAndroid3DBrowser;
    boolean PendingSetVisibility;
    private boolean SwizzlePixels;
    private boolean VulkanRenderer;
    private volatile boolean WaitOnBitmapRender;
    private boolean bClosed;
    private boolean bShown;
    public int curH;
    public int curW;
    public int curX;
    public int curY;
    private BitmapRenderer mBitmapRenderer = null;
    private OESTextureRenderer mOESTextureRenderer = null;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    private long nativePtr;
    private WebViewPositionLayout positionLayout;
    public GLWebView webView;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class ChromeClient extends WebChromeClient {
        ChromeClient() {
        }

        public long GetNativePtr() {
            return WebViewControl.this.nativePtr;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            UE4.Log.warn(consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z16, boolean z17, Message message) {
            Activity GetActivity = GameActivityBase.GetActivity();
            if (GetActivity == null) {
                return false;
            }
            QmWebview qmWebview = new QmWebview(GetActivity);
            webView.addView(qmWebview);
            ((WebView.WebViewTransport) message.obj).setWebView(qmWebview);
            message.sendToTarget();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public native boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult);

        @Override // android.webkit.WebChromeClient
        public native boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
        }

        @Override // android.webkit.WebChromeClient
        public native void onReceivedTitle(WebView webView, String str);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class FrameUpdateInfo {
        public Buffer Buffer;
        public boolean FrameReady;
        public boolean RegionChanged;
        public float UOffset;
        public float UScale;
        public float VOffset;
        public float VScale;

        public FrameUpdateInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class OESTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mTextureID;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private boolean mFrameAvailable = false;
        private float[] mTransformMatrix = new float[16];
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private float mUScale = 1.0f;
        private float mVScale = -1.0f;
        private float mUOffset = 0.0f;
        private float mVOffset = 1.0f;

        public OESTextureRenderer(int i3) {
            this.mSurfaceTexture = null;
            this.mSurface = null;
            this.mTextureID = i3;
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setDefaultBufferSize(WebViewControl.initialWidth, WebViewControl.initialHeight);
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
        }

        private FrameUpdateInfo getFrameUpdateInfo() {
            FrameUpdateInfo frameUpdateInfo = new FrameUpdateInfo();
            frameUpdateInfo.Buffer = null;
            frameUpdateInfo.FrameReady = false;
            frameUpdateInfo.RegionChanged = false;
            frameUpdateInfo.UScale = this.mUScale;
            frameUpdateInfo.UOffset = this.mUOffset;
            frameUpdateInfo.VScale = -this.mVScale;
            frameUpdateInfo.VOffset = 1.0f - this.mVOffset;
            if (!this.mFrameAvailable) {
                return frameUpdateInfo;
            }
            this.mFrameAvailable = false;
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture == null) {
                return frameUpdateInfo;
            }
            frameUpdateInfo.FrameReady = true;
            surfaceTexture.updateTexImage();
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, 0);
            return frameUpdateInfo;
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            if (this.mSurfaceTexture != null) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }

        public boolean resolutionChanged() {
            boolean z16;
            synchronized (this) {
                z16 = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z16;
        }

        public void setSize(int i3, int i16) {
            synchronized (this) {
                if (i3 != this.mTextureWidth || i16 != this.mTextureHeight) {
                    this.mTextureWidth = i3;
                    this.mTextureHeight = i16;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public FrameUpdateInfo updateVideoFrame() {
            FrameUpdateInfo frameUpdateInfo;
            synchronized (this) {
                frameUpdateInfo = getFrameUpdateInfo();
            }
            return frameUpdateInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class ViewClient extends WebViewClient {
        ViewClient() {
        }

        private native byte[] shouldInterceptRequestImpl(String str);

        public long GetNativePtr() {
            return WebViewControl.this.nativePtr;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            onPageLoad(str, false, copyBackForwardList.getSize(), copyBackForwardList.getCurrentIndex());
        }

        public native void onPageLoad(String str, boolean z16, int i3, int i16);

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            onPageLoad(str, true, copyBackForwardList.getSize(), copyBackForwardList.getCurrentIndex());
        }

        @Override // android.webkit.WebViewClient
        public native void onReceivedError(WebView webView, int i3, String str, String str2);

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            byte[] shouldInterceptRequestImpl = shouldInterceptRequestImpl(str);
            if (shouldInterceptRequestImpl != null) {
                return new WebResourceResponse("text/html", "utf8", new ByteArrayInputStream(shouldInterceptRequestImpl));
            }
            return null;
        }

        @Override // android.webkit.WebViewClient
        public native boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    public WebViewControl(long j3, int i3, int i16, boolean z16, boolean z17, final boolean z18, final boolean z19) {
        this.SwizzlePixels = true;
        this.VulkanRenderer = false;
        this.WaitOnBitmapRender = false;
        initialWidth = i3;
        initialHeight = i16;
        this.SwizzlePixels = z16;
        this.VulkanRenderer = z17;
        this.WaitOnBitmapRender = false;
        this.nativePtr = j3;
        final Activity GetActivity = GameActivityBase.GetActivity();
        if (GetActivity == null) {
            return;
        }
        GetActivity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z26;
                if (z18 && !GameActivityBase.IsShippingBuild()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                WebView.setWebContentsDebuggingEnabled(z26);
                WebViewControl.this.webView = new GLWebView(GetActivity);
                WebViewControl.this.webView.setWebViewClient(new ViewClient());
                WebViewControl.this.webView.setWebChromeClient(new ChromeClient());
                WebViewControl.this.webView.getSettings().setJavaScriptEnabled(true);
                WebViewControl.this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                WebViewControl.this.webView.getSettings().setAppCacheMaxSize(10485760L);
                WebViewControl.this.webView.getSettings().setAppCachePath(GetActivity.getApplicationContext().getCacheDir().getAbsolutePath());
                WebViewControl.this.webView.getSettings().setAllowFileAccess(true);
                WebViewControl.this.webView.getSettings().setAppCacheEnabled(true);
                WebViewControl.this.webView.getSettings().setAllowContentAccess(true);
                WebViewControl.this.webView.getSettings().setAllowFileAccessFromFileURLs(true);
                WebViewControl.this.webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
                WebViewControl.this.webView.getSettings().setSupportMultipleWindows(true);
                WebViewControl.this.webView.getSettings().setMixedContentMode(0);
                WebViewControl.this.webView.getSettings().setCacheMode(-1);
                WebViewControl.this.webView.getSettings().setLoadWithOverviewMode(true);
                WebViewControl.this.webView.getSettings().setUseWideViewPort(true);
                WebViewControl.this.webView.SetAndroid3DBrowser(true);
                if (z19) {
                    WebViewControl.this.webView.setBackgroundColor(0);
                }
                WebViewControl.this.positionLayout = new WebViewPositionLayout(GetActivity, this);
                WebViewControl.this.positionLayout.addView(WebViewControl.this.webView, new ViewGroup.LayoutParams(-1, -1));
                WebViewControl.this.bShown = false;
                WebViewControl.this.NextURL = null;
                WebViewControl.this.NextContent = null;
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.curH = 0;
                webViewControl.curW = 0;
                webViewControl.curY = 0;
                webViewControl.curX = 0;
            }
        });
    }

    private boolean CreateBitmapRenderer() {
        releaseBitmapRenderer();
        BitmapRenderer bitmapRenderer = new BitmapRenderer(this.SwizzlePixels, this.VulkanRenderer);
        this.mBitmapRenderer = bitmapRenderer;
        if (!bitmapRenderer.isValid()) {
            this.mBitmapRenderer = null;
            return false;
        }
        this.mBitmapRenderer.setSize(initialWidth, initialHeight);
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.12
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.webView.setSurface(webViewControl.mBitmapRenderer.getSurface());
            }
        });
        return true;
    }

    private boolean CreateOESTextureRenderer(int i3) {
        releaseOESTextureRenderer();
        OESTextureRenderer oESTextureRenderer = new OESTextureRenderer(i3);
        this.mOESTextureRenderer = oESTextureRenderer;
        if (!oESTextureRenderer.isValid()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.setSize(initialWidth, initialHeight);
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.13
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.webView.setSurface(webViewControl.mOESTextureRenderer.getSurface());
            }
        });
        return true;
    }

    public boolean CanGoBackOrForward(int i3) {
        return this.webView.canGoBackOrForward(i3);
    }

    public void Close() {
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.11
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewControl.this.bShown) {
                    ViewGroup viewGroup = (ViewGroup) WebViewControl.this.webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(WebViewControl.this.webView);
                    }
                    ViewGroup viewGroup2 = (ViewGroup) WebViewControl.this.positionLayout.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(WebViewControl.this.positionLayout);
                    }
                    WebViewControl.this.bShown = false;
                }
                WebViewControl.this.bClosed = true;
            }
        });
    }

    public void ExecuteJavascript(final String str) {
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.4
            @Override // java.lang.Runnable
            public void run() {
                GLWebView gLWebView = WebViewControl.this.webView;
                if (gLWebView != null) {
                    gLWebView.evaluateJavascript(str, null);
                }
            }
        });
    }

    public long GetNativePtr() {
        return this.nativePtr;
    }

    public void GoBackOrForward(final int i3) {
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.9
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.goBackOrForward(i3);
            }
        });
    }

    public void LoadString(final String str, final String str2) {
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.6
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.NextURL = str2;
                WebViewControl.this.NextContent = str;
            }
        });
    }

    public void LoadURL(final String str) {
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.5
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.NextURL = str;
                WebViewControl.this.NextContent = null;
            }
        });
    }

    public void Reload() {
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.8
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.reload();
            }
        });
    }

    public void SetAndroid3DBrowser(boolean z16) {
        this.PendingSetAndroid3DBrowser = z16;
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.2
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl webViewControl = WebViewControl.this;
                webViewControl.webView.SetAndroid3DBrowser(webViewControl.PendingSetAndroid3DBrowser);
            }
        });
    }

    public void SetVisibility(boolean z16) {
        this.PendingSetVisibility = z16;
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.3
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                WebViewControl webViewControl = WebViewControl.this;
                GLWebView gLWebView = webViewControl.webView;
                if (webViewControl.PendingSetVisibility) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                gLWebView.setVisibility(i3);
            }
        });
    }

    public void StopLoad() {
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.7
            @Override // java.lang.Runnable
            public void run() {
                WebViewControl.this.webView.stopLoading();
            }
        });
    }

    public void Update(final int i3, final int i16, final int i17, final int i18) {
        this.mUIHandler.post(new Runnable() { // from class: com.epicgames.ue4.WebViewControl.10
            @Override // java.lang.Runnable
            public void run() {
                if (WebViewControl.this.bClosed) {
                    return;
                }
                boolean z16 = true;
                if (!WebViewControl.this.bShown) {
                    WebViewControl.this.bShown = true;
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    Activity GetActivity = GameActivityBase.GetActivity();
                    if (GetActivity != null) {
                        GetActivity.addContentView(WebViewControl.this.positionLayout, layoutParams);
                    }
                    GLWebView gLWebView = WebViewControl.this.webView;
                    if (!gLWebView.IsAndroid3DBrowser) {
                        gLWebView.requestFocus();
                    }
                } else {
                    WebViewControl webViewControl = WebViewControl.this;
                    if (webViewControl.webView != null) {
                        if (webViewControl.NextContent != null) {
                            WebViewControl webViewControl2 = WebViewControl.this;
                            webViewControl2.webView.loadDataWithBaseURL(webViewControl2.NextURL, WebViewControl.this.NextContent, "text/html", "UTF-8", null);
                            WebViewControl.this.NextURL = null;
                            WebViewControl.this.NextContent = null;
                        } else if (WebViewControl.this.NextURL != null) {
                            int indexOf = WebViewControl.this.NextURL.indexOf(58);
                            if (indexOf >= 0) {
                                z16 = false;
                            }
                            if (!z16 && !WebViewControl.this.NextURL.equalsIgnoreCase("about:blank")) {
                                try {
                                    String substring = WebViewControl.this.NextURL.substring(indexOf + 1);
                                    z16 = substring.matches("[0-9]+");
                                    if (!z16) {
                                        String substring2 = WebViewControl.this.NextURL.substring(0, indexOf);
                                        if ((WebViewControl.this.NextURL.equalsIgnoreCase("http") || WebViewControl.this.NextURL.equalsIgnoreCase("https")) && !substring.startsWith("/")) {
                                            WebViewControl.this.NextURL = substring2 + QzoneWebViewOfflinePlugin.STR_DEVIDER + substring;
                                        }
                                    }
                                } catch (IndexOutOfBoundsException unused) {
                                }
                            }
                            if (z16) {
                                WebViewControl.this.NextURL = "http://" + WebViewControl.this.NextURL;
                            }
                            WebViewControl webViewControl3 = WebViewControl.this;
                            webViewControl3.webView.loadUrl(webViewControl3.NextURL);
                            WebViewControl.this.NextURL = null;
                        } else {
                            GLWebView gLWebView2 = WebViewControl.this.webView;
                            if (!gLWebView2.IsAndroid3DBrowser) {
                                gLWebView2.requestFocus();
                            }
                        }
                    }
                }
                WebViewControl webViewControl4 = WebViewControl.this;
                if (webViewControl4.webView != null) {
                    int i19 = i3;
                    if (i19 != webViewControl4.curX || i16 != webViewControl4.curY || i17 != webViewControl4.curW || i18 != webViewControl4.curH) {
                        webViewControl4.curX = i19;
                        webViewControl4.curY = i16;
                        webViewControl4.curW = i17;
                        webViewControl4.curH = i18;
                        webViewControl4.positionLayout.requestLayout();
                    }
                }
            }
        });
    }

    public boolean didResolutionChange() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.resolutionChanged();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.resolutionChanged();
        }
        return false;
    }

    public FrameUpdateInfo getVideoLastFrame(int i3) {
        initBitmapRenderer();
        if (this.mBitmapRenderer != null) {
            this.WaitOnBitmapRender = true;
            FrameUpdateInfo updateFrameData = this.mBitmapRenderer.updateFrameData(i3);
            this.WaitOnBitmapRender = false;
            return updateFrameData;
        }
        return null;
    }

    public FrameUpdateInfo getVideoLastFrameData() {
        initBitmapRenderer();
        if (this.mBitmapRenderer != null) {
            this.WaitOnBitmapRender = true;
            FrameUpdateInfo updateFrameData = this.mBitmapRenderer.updateFrameData();
            this.WaitOnBitmapRender = false;
            return updateFrameData;
        }
        return null;
    }

    public void initBitmapRenderer() {
        if (this.mBitmapRenderer == null && !CreateBitmapRenderer()) {
            UE4.Log.warn("initBitmapRenderer failed to alloc mBitmapRenderer ");
            release();
        }
    }

    public native void nativeClearCachedAttributeState(int i3, int i16);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
    
        Close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        if (r1.mOESTextureRenderer != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1.mBitmapRenderer == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release() {
    }

    void releaseBitmapRenderer() {
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            bitmapRenderer.release();
            this.mBitmapRenderer = null;
        }
    }

    void releaseOESTextureRenderer() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            oESTextureRenderer.release();
            this.mOESTextureRenderer = null;
        }
    }

    public FrameUpdateInfo updateVideoFrame(int i3) {
        if (this.mOESTextureRenderer == null && !CreateOESTextureRenderer(i3)) {
            UE4.Log.warn("updateVideoFrame failed to alloc mOESTextureRenderer ");
            release();
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo updateVideoFrame = this.mOESTextureRenderer.updateVideoFrame();
        this.WaitOnBitmapRender = false;
        return updateVideoFrame;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class GLWebView extends QmWebview {
        public boolean IsAndroid3DBrowser;
        private Surface mSurface;

        public GLWebView(Context context) {
            super(context);
            this.mSurface = null;
            this.IsAndroid3DBrowser = false;
            init();
        }

        public void SetAndroid3DBrowser(boolean z16) {
            boolean z17;
            synchronized (this) {
                if (this.IsAndroid3DBrowser != z16) {
                    this.IsAndroid3DBrowser = z16;
                    GLWebView gLWebView = WebViewControl.this.webView;
                    if (!z16) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    gLWebView.setFocusableInTouchMode(z17);
                }
            }
        }

        public void init() {
            setOnTouchListener(new View.OnTouchListener() { // from class: com.epicgames.ue4.WebViewControl.GLWebView.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return GLWebView.this.IsAndroid3DBrowser;
                }
            });
        }

        @Override // android.webkit.WebView, android.view.View
        public void onDraw(Canvas canvas) {
            if (!this.IsAndroid3DBrowser) {
                super.onDraw(canvas);
                return;
            }
            Surface surface = this.mSurface;
            if (surface != null) {
                try {
                    Canvas lockCanvas = surface.lockCanvas(null);
                    float width = lockCanvas.getWidth() / canvas.getWidth();
                    lockCanvas.scale(width, width);
                    lockCanvas.translate(-getScrollX(), -getScrollY());
                    super.onDraw(lockCanvas);
                    this.mSurface.unlockCanvasAndPost(lockCanvas);
                } catch (Exception e16) {
                    Log.e(WebViewControl.TAG, "error while rendering view to gl: " + e16);
                }
            }
        }

        @Override // android.widget.AbsoluteLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            super.onLayout(z16, i3, i16, i17, i18);
        }

        public void setSurface(Surface surface) {
            this.mSurface = surface;
        }

        public GLWebView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mSurface = null;
            this.IsAndroid3DBrowser = false;
            init();
        }

        public GLWebView(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.mSurface = null;
            this.IsAndroid3DBrowser = false;
            init();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class BitmapRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 16;
        private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 2;
        private int mBlitBuffer;
        private int mPositionAttrib;
        private int mProgram;
        private EGLContext mSavedContext;
        private EGLDisplay mSavedDisplay;
        private EGLSurface mSavedSurfaceDraw;
        private EGLSurface mSavedSurfaceRead;
        private boolean mSwizzlePixels;
        private int mTexCoordsAttrib;
        private int mTextureUniform;
        private FloatBuffer mTriangleVertices;
        private boolean mUseOwnContext;
        private boolean mVulkanRenderer;
        private Buffer mFrameData = null;
        private int mLastFramePosition = -1;
        private SurfaceTexture mSurfaceTexture = null;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private Surface mSurface = null;
        private boolean mFrameAvailable = false;
        private int mTextureID = -1;
        private int mFBO = -1;
        private int mBlitVertexShaderID = -1;
        private int mBlitFragmentShaderID = -1;
        private float[] mTransformMatrix = new float[16];
        private boolean mTriangleVerticesDirty = true;
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private boolean mCreatedEGLDisplay = false;
        private float[] mTriangleVerticesData = {-1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        private final String mBlitVextexShader = "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n";
        private final String mBlitFragmentShaderBGRA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
        private final String mBlitFragmentShaderRGBA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
        private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;

        public BitmapRenderer(boolean z16, boolean z17) {
            this.mUseOwnContext = true;
            this.mSwizzlePixels = z16;
            this.mVulkanRenderer = z17;
            this.mUseOwnContext = true;
            if (z17) {
                this.mSwizzlePixels = true;
            } else {
                String glGetString = GLES20.glGetString(7937);
                if (glGetString.contains("Adreno (TM) ") && Integer.parseInt(glGetString.substring(12)) < 400) {
                    UE4.Log.debug("WebViewControl: disabled shared GL context on " + glGetString);
                    this.mUseOwnContext = false;
                }
            }
            if (this.mUseOwnContext) {
                initContext();
                saveContext();
                makeCurrent();
                initSurfaceTexture();
                restoreContext();
                return;
            }
            initSurfaceTexture();
        }

        private void UpdateVertexData() {
            if (this.mTriangleVerticesDirty && this.mBlitBuffer > 0) {
                this.mTriangleVertices.position(0);
                this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
                int[] iArr = new int[1];
                GLES20.glGetIntegerv(34964, iArr, 0);
                int i3 = iArr[0];
                GLES20.glBindBuffer(34962, this.mBlitBuffer);
                GLES20.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mTriangleVertices, 35044);
                GLES20.glBindBuffer(34962, i3);
                this.mTriangleVerticesDirty = false;
            }
        }

        private boolean copyFrameTexture(int i3, Buffer buffer) {
            int i16;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            int i17;
            boolean z27;
            int i18;
            int i19;
            int i26;
            int i27;
            int i28;
            int i29;
            int i36;
            int i37;
            char c16;
            if (!this.mFrameAvailable) {
                return false;
            }
            this.mFrameAvailable = false;
            if (this.mSurfaceTexture == null) {
                return false;
            }
            int[] iArr = new int[1];
            int[] iArr2 = new int[4];
            if (this.mUseOwnContext) {
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10241, iArr, 0);
                int i38 = iArr[0];
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10240, iArr, 0);
                int i39 = iArr[0];
                saveContext();
                makeCurrent();
                i16 = i39;
                i19 = 0;
                z27 = false;
                z26 = false;
                z19 = false;
                z18 = false;
                z17 = false;
                z16 = false;
                i17 = i38;
                i18 = 0;
            } else {
                GLES20.glGetError();
                boolean glIsEnabled = GLES20.glIsEnabled(3042);
                boolean glIsEnabled2 = GLES20.glIsEnabled(2884);
                boolean glIsEnabled3 = GLES20.glIsEnabled(3089);
                boolean glIsEnabled4 = GLES20.glIsEnabled(2960);
                boolean glIsEnabled5 = GLES20.glIsEnabled(2929);
                boolean glIsEnabled6 = GLES20.glIsEnabled(3024);
                GLES20.glGetIntegerv(36006, iArr, 0);
                int i46 = iArr[0];
                GLES20.glGetIntegerv(34964, iArr, 0);
                int i47 = iArr[0];
                GLES20.glGetIntegerv(2978, iArr2, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10241, iArr, 0);
                int i48 = iArr[0];
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10240, iArr, 0);
                int i49 = iArr[0];
                glVerify("save state");
                i16 = i49;
                z16 = glIsEnabled6;
                z17 = glIsEnabled5;
                z18 = glIsEnabled4;
                z19 = glIsEnabled3;
                z26 = glIsEnabled2;
                i17 = i48;
                z27 = glIsEnabled;
                i18 = i47;
                i19 = i46;
            }
            this.mSurfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float[] fArr = this.mTransformMatrix;
            float f16 = fArr[12];
            float f17 = f16 + fArr[0];
            float f18 = fArr[13];
            float f19 = f18 + fArr[5];
            float[] fArr2 = this.mTriangleVerticesData;
            if (fArr2[2] != f16 || fArr2[6] != f17 || fArr2[11] != f18 || fArr2[3] != f19) {
                fArr2[10] = f16;
                fArr2[2] = f16;
                fArr2[14] = f17;
                fArr2[6] = f17;
                fArr2[15] = f18;
                fArr2[11] = f18;
                fArr2[7] = f19;
                fArr2[3] = f19;
                this.mTriangleVerticesDirty = true;
            }
            if (buffer != null) {
                buffer.position(0);
            }
            if (!this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
                glVerify("reset state");
            }
            GLES20.glViewport(0, 0, this.mTextureWidth, this.mTextureHeight);
            glVerify("set viewport");
            if (buffer != null) {
                GLES20.glGenTextures(1, iArr, 0);
                i26 = iArr[0];
            } else {
                i26 = i3;
            }
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i26);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            if (buffer != null) {
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.mTextureWidth, this.mTextureHeight, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            }
            glVerify("set-up FBO texture");
            GLES20.glBindFramebuffer(36160, this.mFBO);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i26, 0);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus != 36053) {
                UE4.Log.warn("Failed to complete framebuffer attachment (" + glCheckFramebufferStatus + ")");
            }
            GLES20.glUseProgram(this.mProgram);
            UpdateVertexData();
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glEnableVertexAttribArray(this.mPositionAttrib);
            GLES20.glVertexAttribPointer(this.mPositionAttrib, 2, 5126, false, 16, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordsAttrib);
            GLES20.glVertexAttribPointer(this.mTexCoordsAttrib, 2, 5126, false, 16, 8);
            glVerify("setup movie texture read");
            GLES20.glClear(16384);
            GLES20.glUniform1i(this.mTextureUniform, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFlush();
            if (buffer != null) {
                i37 = 36064;
                i27 = i18;
                i28 = i16;
                i29 = i17;
                i36 = i26;
                GLES20.glReadPixels(0, 0, this.mTextureWidth, this.mTextureHeight, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
            } else {
                i27 = i18;
                i28 = i16;
                i29 = i17;
                i36 = i26;
                i37 = 36064;
            }
            glVerify("draw & read movie texture");
            if (this.mUseOwnContext) {
                GLES20.glFramebufferTexture2D(36160, i37, GLSLRender.GL_TEXTURE_2D, 0, 0);
                if (buffer != null && i36 > 0) {
                    iArr[0] = i36;
                    GLES20.glDeleteTextures(1, iArr, 0);
                }
                restoreContext();
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, i29);
                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, i28);
                return true;
            }
            int i56 = i29;
            GLES20.glBindFramebuffer(36160, i19);
            if (buffer != null && i36 > 0) {
                iArr[0] = i36;
                c16 = 1;
                GLES20.glDeleteTextures(1, iArr, 0);
            } else {
                c16 = 1;
            }
            GLES20.glBindBuffer(34962, i27);
            GLES20.glViewport(iArr2[0], iArr2[c16], iArr2[2], iArr2[3]);
            if (z27) {
                GLES20.glEnable(3042);
            }
            if (z26) {
                GLES20.glEnable(2884);
            }
            if (z19) {
                GLES20.glEnable(3089);
            }
            if (z18) {
                GLES20.glEnable(2960);
            }
            if (z17) {
                GLES20.glEnable(2929);
            }
            if (z16) {
                GLES20.glEnable(3024);
            }
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, i56);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, i28);
            GLES20.glDisableVertexAttribArray(this.mPositionAttrib);
            GLES20.glDisableVertexAttribArray(this.mTexCoordsAttrib);
            WebViewControl.this.nativeClearCachedAttributeState(this.mPositionAttrib, this.mTexCoordsAttrib);
            return true;
        }

        private int createShader(int i3, String str) {
            int glCreateShader = GLES20.glCreateShader(i3);
            if (glCreateShader != 0) {
                GLES20.glShaderSource(glCreateShader, str);
                GLES20.glCompileShader(glCreateShader);
                int[] iArr = new int[1];
                GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
                if (iArr[0] == 0) {
                    UE4.Log.error("Could not compile shader " + i3 + ":");
                    UE4.Log.error(GLES20.glGetShaderInfoLog(glCreateShader));
                    GLES20.glDeleteShader(glCreateShader);
                    return 0;
                }
                return glCreateShader;
            }
            return glCreateShader;
        }

        private void glVerify(String str) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            showGlError(str, glGetError);
            throw new RuntimeException(str + ": glGetError " + glGetError);
        }

        private void glWarn(String str) {
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError != 0) {
                    showGlError(str, glGetError);
                } else {
                    return;
                }
            }
        }

        private void initContext() {
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
            if (!this.mVulkanRenderer) {
                this.mEglDisplay = EGL14.eglGetCurrentDisplay();
                eGLContext = EGL14.eglGetCurrentContext();
            } else {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                this.mEglDisplay = eglGetDisplay;
                if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    UE4.Log.error("unable to get EGL14 display");
                    return;
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    this.mEglDisplay = null;
                    UE4.Log.error("unable to initialize EGL14 display");
                    return;
                }
                this.mCreatedEGLDisplay = true;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
            this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfigArr[0], eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
            if (EGL14.eglQueryString(this.mEglDisplay, 12373).contains("EGL_KHR_surfaceless_context")) {
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            } else {
                this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, eGLConfigArr[0], new int[]{12344}, 0);
            }
        }

        private void initSurfaceTexture() {
            String str;
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i3 = iArr[0];
            this.mTextureID = i3;
            if (i3 <= 0) {
                UE4.Log.error("mTextureID <= 0");
                release();
                return;
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setDefaultBufferSize(WebViewControl.initialWidth, WebViewControl.initialHeight);
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
            int[] iArr2 = new int[1];
            GLES20.glGenFramebuffers(1, iArr2, 0);
            int i16 = iArr2[0];
            this.mFBO = i16;
            if (i16 <= 0) {
                UE4.Log.error("mFBO <= 0");
                release();
                return;
            }
            int createShader = createShader(35633, "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n");
            this.mBlitVertexShaderID = createShader;
            if (createShader == 0) {
                UE4.Log.error("mBlitVertexShaderID == 0");
                release();
                return;
            }
            if (this.mSwizzlePixels) {
                str = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
            } else {
                str = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
            }
            int createShader2 = createShader(35632, str);
            if (createShader2 == 0) {
                UE4.Log.error("mBlitFragmentShaderID == 0");
                release();
                return;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            this.mProgram = glCreateProgram;
            if (glCreateProgram <= 0) {
                UE4.Log.error("mProgram <= 0");
                release();
                return;
            }
            GLES20.glAttachShader(glCreateProgram, this.mBlitVertexShaderID);
            GLES20.glAttachShader(this.mProgram, createShader2);
            GLES20.glLinkProgram(this.mProgram);
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(this.mProgram, 35714, iArr3, 0);
            if (iArr3[0] != 1) {
                UE4.Log.error("Could not link program: ");
                UE4.Log.error(GLES20.glGetProgramInfoLog(this.mProgram));
                GLES20.glDeleteProgram(this.mProgram);
                this.mProgram = 0;
                release();
                return;
            }
            this.mPositionAttrib = GLES20.glGetAttribLocation(this.mProgram, "Position");
            this.mTexCoordsAttrib = GLES20.glGetAttribLocation(this.mProgram, "TexCoords");
            this.mTextureUniform = GLES20.glGetUniformLocation(this.mProgram, "VideoTexture");
            GLES20.glGenBuffers(1, iArr2, 0);
            int i17 = iArr2[0];
            this.mBlitBuffer = i17;
            if (i17 <= 0) {
                UE4.Log.error("mBlitBuffer <= 0");
                release();
                return;
            }
            this.mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mTriangleVerticesDirty = true;
            if (this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
            }
        }

        private void makeCurrent() {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = this.mEglSurface;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext);
        }

        private void restoreContext() {
            EGL14.eglMakeCurrent(this.mSavedDisplay, this.mSavedSurfaceDraw, this.mSavedSurfaceRead, this.mSavedContext);
        }

        private void saveContext() {
            this.mSavedDisplay = EGL14.eglGetCurrentDisplay();
            this.mSavedContext = EGL14.eglGetCurrentContext();
            this.mSavedSurfaceDraw = EGL14.eglGetCurrentSurface(12377);
            this.mSavedSurfaceRead = EGL14.eglGetCurrentSurface(12378);
        }

        private void showGlError(String str, int i3) {
            switch (i3) {
                case 1280:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_INVALID_ENUM");
                    return;
                case 1281:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_INVALID_VALUE");
                    return;
                case 1282:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_INVALID_OPERATION");
                    return;
                case 1285:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_OUT_OF_MEMORY");
                    return;
                case 1286:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_INVALID_FRAMEBUFFER_OPERATION");
                    return;
                case 36054:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
                    return;
                case 36057:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
                    return;
                case 36061:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_UNSUPPORTED");
                    return;
                default:
                    UE4.Log.error("WebViewControl$BitmapRenderer: " + str + ": glGetError " + i3);
                    return;
            }
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            if (this.mSurfaceTexture != null) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            int[] iArr = new int[1];
            int i3 = this.mBlitBuffer;
            if (i3 > 0) {
                iArr[0] = i3;
                GLES20.glDeleteBuffers(1, iArr, 0);
                this.mBlitBuffer = -1;
            }
            int i16 = this.mProgram;
            if (i16 > 0) {
                GLES20.glDeleteProgram(i16);
                this.mProgram = -1;
            }
            int i17 = this.mBlitVertexShaderID;
            if (i17 > 0) {
                GLES20.glDeleteShader(i17);
                this.mBlitVertexShaderID = -1;
            }
            int i18 = this.mBlitFragmentShaderID;
            if (i18 > 0) {
                GLES20.glDeleteShader(i18);
                this.mBlitFragmentShaderID = -1;
            }
            int i19 = this.mFBO;
            if (i19 > 0) {
                iArr[0] = i19;
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.mFBO = -1;
            }
            int i26 = this.mTextureID;
            if (i26 > 0) {
                iArr[0] = i26;
                GLES20.glDeleteTextures(1, iArr, 0);
                this.mTextureID = -1;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface);
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.mEglDisplay, eGLContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            if (this.mCreatedEGLDisplay) {
                EGL14.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
                this.mCreatedEGLDisplay = false;
            }
        }

        public boolean resolutionChanged() {
            boolean z16;
            synchronized (this) {
                z16 = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z16;
        }

        public void setSize(int i3, int i16) {
            synchronized (this) {
                if (i3 != this.mTextureWidth || i16 != this.mTextureHeight) {
                    this.mTextureWidth = i3;
                    this.mTextureHeight = i16;
                    this.mFrameData = null;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public FrameUpdateInfo updateFrameData() {
            int i3;
            int i16;
            synchronized (this) {
                if (this.mFrameData == null && (i3 = this.mTextureWidth) > 0 && (i16 = this.mTextureHeight) > 0) {
                    this.mFrameData = ByteBuffer.allocateDirect(i3 * i16 * 4);
                }
                if (!copyFrameTexture(0, this.mFrameData)) {
                    return null;
                }
                FrameUpdateInfo frameUpdateInfo = new FrameUpdateInfo();
                frameUpdateInfo.Buffer = this.mFrameData;
                frameUpdateInfo.FrameReady = true;
                frameUpdateInfo.RegionChanged = false;
                return frameUpdateInfo;
            }
        }

        public FrameUpdateInfo updateFrameData(int i3) {
            synchronized (this) {
                if (!copyFrameTexture(i3, null)) {
                    return null;
                }
                FrameUpdateInfo frameUpdateInfo = new FrameUpdateInfo();
                frameUpdateInfo.Buffer = null;
                frameUpdateInfo.FrameReady = true;
                frameUpdateInfo.RegionChanged = false;
                return frameUpdateInfo;
            }
        }
    }
}
