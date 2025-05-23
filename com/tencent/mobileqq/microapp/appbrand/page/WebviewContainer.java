package com.tencent.mobileqq.microapp.appbrand.page;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.apkg.j;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.microapp.widget.CanvasView;
import com.tencent.mobileqq.microapp.widget.CoverImageView;
import com.tencent.mobileqq.microapp.widget.CoverView;
import com.tencent.mobileqq.microapp.widget.MapContext;
import com.tencent.mobileqq.microapp.widget.MiniAppTextArea;
import com.tencent.mobileqq.microapp.widget.b;
import com.tencent.mobileqq.microapp.widget.media.CameraSurfaceView;
import com.tencent.mobileqq.microapp.widget.media.MiniAppCamera;
import com.tencent.mobileqq.microapp.widget.media.MiniAppVideoPlayer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class WebviewContainer extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener, PageWebview.OnWebviewScrollListener {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "WebViewContainer";
    protected c apkgInfo$5475ea27;
    public a appBrandRuntime;
    private SparseArray appTextAreaSparseArray;
    private SparseArray cameraViewSparseArray;
    private SparseArray canvasSparseArray;
    private FrameLayout componentLayout;
    private MiniAppCamera currentCamera;
    protected float density;
    private SparseArray imageViewSparseArray;
    private ProgressWebView innerWebView;
    private CanvasView mCurrCanvas;
    private SparseArray mTextViewSparseArray;
    private SparseArray mapContextArray;
    private b miniAppFileView;
    protected j pageInfo;
    private PageWebview pageWebview;
    public SwipeRefreshLayout swipeRefreshLayout;
    private SparseArray videoPlayerSparseArray;

    public WebviewContainer(Context context, a aVar, c cVar, String str) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, aVar, cVar, str);
            return;
        }
        this.cameraViewSparseArray = new SparseArray();
        this.videoPlayerSparseArray = new SparseArray();
        this.mTextViewSparseArray = new SparseArray();
        this.imageViewSparseArray = new SparseArray();
        this.canvasSparseArray = new SparseArray();
        this.appTextAreaSparseArray = new SparseArray();
        this.density = DisplayUtil.getDensity(context);
        this.appBrandRuntime = aVar;
        this.apkgInfo$5475ea27 = cVar;
        this.pageInfo = cVar.f245821b.b(str);
        this.componentLayout = new FrameLayout(getContext());
        this.mapContextArray = new SparseArray();
        SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(getContext());
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(this.pageInfo.f245863a.f245875b);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        addView(this.swipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
        notifyChangePullDownRefreshStyle();
    }

    private String getActualColor(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        return "#" + str.substring(str.length() - 2) + str.substring(1, str.length() - 2);
    }

    private FrameLayout.LayoutParams getLayoutParams(int i3) {
        MiniAppVideoPlayer miniAppVideoPlayer = (MiniAppVideoPlayer) this.videoPlayerSparseArray.get(i3);
        if (miniAppVideoPlayer != null) {
            return (FrameLayout.LayoutParams) miniAppVideoPlayer.getLayoutParams();
        }
        MiniAppCamera miniAppCamera = (MiniAppCamera) this.cameraViewSparseArray.get(i3);
        if (miniAppCamera != null) {
            return (FrameLayout.LayoutParams) miniAppCamera.getLayoutParams();
        }
        CanvasView canvasView = (CanvasView) this.canvasSparseArray.get(i3);
        if (canvasView != null) {
            return (FrameLayout.LayoutParams) canvasView.getLayoutParams();
        }
        MapContext mapContext = (MapContext) this.mapContextArray.get(i3);
        if (mapContext != null) {
            return (FrameLayout.LayoutParams) mapContext.f246076c.getLayoutParams();
        }
        TextView textView = (TextView) this.mTextViewSparseArray.get(i3);
        if (textView != null) {
            return (FrameLayout.LayoutParams) textView.getLayoutParams();
        }
        ImageView imageView = (ImageView) this.imageViewSparseArray.get(i3);
        if (imageView != null) {
            return (FrameLayout.LayoutParams) imageView.getLayoutParams();
        }
        return null;
    }

    private void removeCoverChildView(int i3) {
        for (int i16 = 0; i16 < this.mTextViewSparseArray.size(); i16++) {
            int keyAt = this.mTextViewSparseArray.keyAt(i16);
            CoverView coverView = (CoverView) this.mTextViewSparseArray.get(keyAt);
            if (coverView != null && coverView.f246073a == i3) {
                removeCoverChildView(keyAt);
                this.componentLayout.removeView(coverView);
            }
        }
        for (int i17 = 0; i17 < this.imageViewSparseArray.size(); i17++) {
            int keyAt2 = this.imageViewSparseArray.keyAt(i17);
            CoverImageView coverImageView = (CoverImageView) this.imageViewSparseArray.get(keyAt2);
            if (coverImageView != null && coverImageView.f246072a == i3) {
                removeCoverChildView(keyAt2);
                this.componentLayout.removeView(coverImageView);
            }
        }
    }

    public void addVidepPlayer(MiniAppVideoPlayer miniAppVideoPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) miniAppVideoPlayer);
            return;
        }
        JSONObject jSONObject = miniAppVideoPlayer.f246203o;
        int optInt = jSONObject.optInt("left");
        int optInt2 = jSONObject.optInt("top");
        int optInt3 = jSONObject.optInt("width");
        int optInt4 = jSONObject.optInt("height");
        float f16 = this.density;
        int i3 = (int) ((optInt * f16) + 0.5f);
        int i16 = (int) ((f16 * optInt2) + 0.5f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) ((optInt3 * f16) + 0.5f), (int) ((optInt4 * f16) + 0.5f));
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i16;
        this.componentLayout.addView(miniAppVideoPlayer, layoutParams);
    }

    public void callbackJsEventFail(String str, JSONObject jSONObject, int i3) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, jSONObject, Integer.valueOf(i3));
            return;
        }
        if (this.pageWebview != null) {
            JSONObject b16 = c.b(str, jSONObject);
            if (b16 != null) {
                str2 = b16.toString();
            } else {
                str2 = "";
            }
            this.pageWebview.evaluateCallbackJs(i3, str2);
        }
    }

    public void callbackJsEventOK(String str, JSONObject jSONObject, int i3) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, jSONObject, Integer.valueOf(i3));
            return;
        }
        if (this.pageWebview != null) {
            JSONObject a16 = c.a(str, jSONObject);
            if (a16 != null) {
                str2 = a16.toString();
            } else {
                str2 = "";
            }
            this.pageWebview.evaluateCallbackJs(i3, str2);
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 2, "-----destroy----");
        }
        PageWebview pageWebview = this.pageWebview;
        if (pageWebview != null) {
            this.swipeRefreshLayout.removeView(pageWebview);
            this.pageWebview.destroy();
        }
        for (int i3 = 0; i3 < this.videoPlayerSparseArray.size(); i3++) {
            MiniAppVideoPlayer miniAppVideoPlayer = (MiniAppVideoPlayer) this.videoPlayerSparseArray.valueAt(i3);
            if (miniAppVideoPlayer != null) {
                miniAppVideoPlayer.a();
                miniAppVideoPlayer.d();
                com.tencent.mobileqq.microapp.app.b.a().deleteObserver(miniAppVideoPlayer.f246205q);
                this.componentLayout.removeView(miniAppVideoPlayer);
            }
        }
        this.videoPlayerSparseArray.clear();
        for (int i16 = 0; i16 < this.cameraViewSparseArray.size(); i16++) {
            MiniAppCamera miniAppCamera = (MiniAppCamera) this.cameraViewSparseArray.valueAt(i16);
            if (miniAppCamera != null) {
                miniAppCamera.d();
                this.componentLayout.removeView(miniAppCamera);
            }
        }
        this.cameraViewSparseArray.clear();
        this.imageViewSparseArray.clear();
        this.mapContextArray.clear();
        ProgressWebView progressWebView = this.innerWebView;
        if (progressWebView != null) {
            this.componentLayout.removeView(progressWebView);
            h.a().a(this.innerWebView, getContext());
        }
    }

    public void drawCanvas(int i3, boolean z16, boolean z17, JSONArray jSONArray, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), jSONArray, str, Integer.valueOf(i16));
            return;
        }
        CanvasView canvasView = (CanvasView) this.canvasSparseArray.get(i3);
        if (canvasView == null) {
            callbackJsEventFail(str, null, i16);
            return;
        }
        canvasView.f246047a = z16;
        canvasView.f246048b = jSONArray;
        canvasView.invalidate();
    }

    public MapContext getMapContext(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (MapContext) iPatchRedirector.redirect((short) 36, (Object) this, i3);
        }
        return (MapContext) this.mapContextArray.get(i3);
    }

    public PageWebview getPageWebview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PageWebview) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.pageWebview;
    }

    public boolean handleBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        ProgressWebView progressWebView = this.innerWebView;
        if (progressWebView != null && progressWebView.canGoBack()) {
            this.innerWebView.goBack();
            return true;
        }
        for (int i3 = 0; i3 < this.videoPlayerSparseArray.size(); i3++) {
            MiniAppVideoPlayer miniAppVideoPlayer = (MiniAppVideoPlayer) this.videoPlayerSparseArray.valueAt(i3);
            if (miniAppVideoPlayer.f246204p) {
                miniAppVideoPlayer.g();
                return true;
            }
        }
        b bVar = this.miniAppFileView;
        if (bVar == null) {
            return false;
        }
        bVar.a();
        this.miniAppFileView.a(this.componentLayout);
        this.miniAppFileView = null;
        return true;
    }

    public void insertCamera$6f1019db(int i3, int i16, int i17, int i18, int i19, ApkgConfigManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), aVar);
            return;
        }
        MiniAppCamera miniAppCamera = (MiniAppCamera) this.cameraViewSparseArray.get(i3);
        if (miniAppCamera == null) {
            miniAppCamera = new MiniAppCamera(getContext(), this);
            this.cameraViewSparseArray.put(i3, miniAppCamera);
        }
        miniAppCamera.a(aVar);
        miniAppCamera.c();
        float f16 = this.density;
        int i26 = (int) ((i18 * f16) + 0.5f);
        int i27 = (int) ((i19 * f16) + 0.5f);
        int i28 = (int) ((i16 * f16) + 0.5f);
        int i29 = (int) ((f16 * i17) + 0.5f);
        CameraSurfaceView.f246170h = i26;
        CameraSurfaceView.f246171i = i27;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i26, i27);
        layoutParams.leftMargin = i28;
        layoutParams.topMargin = i29;
        this.componentLayout.addView(miniAppCamera, layoutParams);
    }

    public void insertCanvas(int i3, JSONObject jSONObject, String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), jSONObject, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        int optInt = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
        int optInt2 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
        int measuredHeight = this.pageWebview.getMeasuredHeight();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "insertCanvas currentWebview.getMeasuredHeight: " + measuredHeight + "---canvas height----" + jSONObject.optInt("height") + "---" + optInt2);
        }
        int optInt3 = (int) ((this.density * jSONObject.optInt("left")) + 0.5f);
        int optInt4 = (int) ((this.density * jSONObject.optInt("top")) + 0.5f);
        CanvasView canvasView = (CanvasView) this.canvasSparseArray.get(i3);
        if (canvasView == null) {
            CanvasView canvasView2 = new CanvasView(getContext(), this, this.appBrandRuntime.f245898c, str, i3, z17);
            this.canvasSparseArray.put(i3, canvasView2);
            canvasView = canvasView2;
        }
        if (z16) {
            canvasView.setVisibility(8);
        }
        this.mCurrCanvas = canvasView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
        layoutParams.leftMargin = optInt3;
        layoutParams.topMargin = optInt4;
        this.componentLayout.addView(canvasView, layoutParams);
    }

    public void insertFileView(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) file);
            return;
        }
        if (this.miniAppFileView == null) {
            this.miniAppFileView = new b(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getPageWebview().getWidth(), getPageWebview().getHeight());
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            this.miniAppFileView.a(this.componentLayout, layoutParams);
        }
        this.miniAppFileView.a(file);
    }

    public void insertHTMLWebView(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "insertHTMLWebView htmlId=" + i3 + ",innerWebView=" + this.innerWebView);
        }
        if (this.innerWebView != null) {
            return;
        }
        float f16 = this.density;
        int i26 = (int) ((i18 * f16) + 0.5f);
        int i27 = (int) ((i19 * f16) + 0.5f);
        int i28 = (int) ((i16 * f16) + 0.5f);
        int i29 = (int) ((f16 * i17) + 0.5f);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "insertHTMLWebView htmlId=" + i3 + ",left=" + i28 + ",top=" + i29 + ",w=" + i26 + ",h=" + i27);
        }
        this.innerWebView = h.a().a(this.apkgInfo$5475ea27.f245823d, i3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i26, i27);
        layoutParams.leftMargin = i28;
        layoutParams.topMargin = i29;
        this.innerWebView.setVisibility(8);
        this.componentLayout.addView(this.innerWebView, layoutParams);
    }

    public void insertImageView(JSONObject jSONObject, String str, int i3, int i16, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, jSONObject, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Boolean.valueOf(z16));
            return;
        }
        CoverImageView coverImageView = (CoverImageView) this.imageViewSparseArray.get(i16);
        if (coverImageView == null) {
            coverImageView = new CoverImageView(getContext());
            coverImageView.f246072a = i3;
            this.imageViewSparseArray.put(i16, coverImageView);
        }
        FrameLayout.LayoutParams layoutParams = getLayoutParams(i3);
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        if (!StringUtil.isEmpty(str2)) {
            if (!str2.startsWith("http") && !str2.startsWith("https")) {
                String j3 = this.appBrandRuntime.f245898c.j(str2);
                if (!StringUtil.isEmpty(j3)) {
                    coverImageView.setImageBitmap(c.q(j3));
                }
            } else {
                try {
                    URLDrawable drawable = URLDrawable.getDrawable(str2, (URLDrawable.URLDrawableOptions) null);
                    if (drawable != null) {
                        coverImageView.setImageDrawable(drawable);
                    }
                } catch (OutOfMemoryError e16) {
                    e16.printStackTrace();
                }
            }
        }
        coverImageView.setClickable(true);
        coverImageView.setOnClickListener(new View.OnClickListener(str) { // from class: com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$data;

            {
                this.val$data = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebviewContainer.this, (Object) str);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("data", this.val$data);
                        WebviewContainer.this.pageWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onImageViewClick\", " + jSONObject2 + "," + WebviewContainer.this.pageWebview.pageWebviewId + ")");
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        int optInt = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
        int optInt2 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
        int optInt3 = (int) ((this.density * jSONObject.optInt("left")) + 0.5f);
        int optInt4 = (int) ((this.density * jSONObject.optInt("top")) + 0.5f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(optInt, optInt2);
        layoutParams2.leftMargin = layoutParams.leftMargin + optInt3;
        layoutParams2.topMargin = layoutParams.topMargin + optInt4;
        this.componentLayout.addView(coverImageView, layoutParams2);
    }

    public void insertMap(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
            return;
        }
        MapContext mapContext = (MapContext) this.mapContextArray.get(i3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "insertMapView mapId=" + i3 + ",mapContext=" + mapContext);
        }
        if (mapContext != null) {
            return;
        }
        QQMapView qQMapView = new QQMapView(getContext(), null);
        this.componentLayout.addView(qQMapView);
        this.mapContextArray.put(i3, new MapContext(this.pageWebview, this.appBrandRuntime.f245904i, qQMapView, i3, this.apkgInfo$5475ea27));
    }

    public void insertTextArea(int i3, String str, int i16, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), str, Integer.valueOf(i16), jSONObject);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        int optInt = (int) ((this.density * optJSONObject.optInt("width")) + 0.5f);
        int optInt2 = (int) ((this.density * optJSONObject.optInt("height", optJSONObject.optInt(NodeProps.MIN_HEIGHT))) + 0.5f);
        if (optInt2 == 0) {
            optInt2 = -2;
        }
        int optInt3 = (int) ((this.density * optJSONObject.optInt("left")) + 0.5f);
        int optInt4 = (int) ((this.density * optJSONObject.optInt("top")) + 0.5f);
        MiniAppTextArea miniAppTextArea = (MiniAppTextArea) this.appTextAreaSparseArray.get(i3);
        if (miniAppTextArea == null) {
            miniAppTextArea = new MiniAppTextArea(getContext());
            this.appTextAreaSparseArray.put(i3, miniAppTextArea);
        }
        miniAppTextArea.a(i3, jSONObject, this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
        layoutParams.leftMargin = optInt3;
        layoutParams.topMargin = optInt4 - getPageWebview().scrollY;
        this.componentLayout.addView(miniAppTextArea, layoutParams);
    }

    public void insertTextView(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) jSONObject);
            return;
        }
        int optInt = jSONObject.optInt("viewId");
        int optInt2 = jSONObject.optInt("parentId");
        CoverView coverView = (CoverView) this.mTextViewSparseArray.get(optInt);
        if (coverView == null) {
            coverView = new CoverView(getContext());
            coverView.f246073a = optInt2;
            coverView.setBackgroundColor(getResources().getColor(R.color.holo_blue_dark));
            this.mTextViewSparseArray.put(optInt, coverView);
        }
        FrameLayout.LayoutParams layoutParams = getLayoutParams(jSONObject.optInt("parentId"));
        QLog.i(TAG, 2, "insertTextView layoutParams: " + layoutParams);
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null && !StringUtil.isEmpty(getActualColor(optJSONObject.optString("bgColor")))) {
            coverView.setBackgroundColor(Color.parseColor(getActualColor(optJSONObject.optString("bgColor"))));
            coverView.setScaleX(Float.parseFloat(optJSONObject.optString(BasicAnimation.KeyPath.SCALE_X)));
            coverView.setScaleY(Float.parseFloat(optJSONObject.optString(BasicAnimation.KeyPath.SCALE_Y)));
            JSONArray optJSONArray = optJSONObject.optJSONArray("padding");
            coverView.setPadding(optJSONArray.optInt(3), optJSONArray.optInt(2), optJSONArray.optInt(1), optJSONArray.optInt(0));
            coverView.a(optJSONObject.optInt(NodeProps.BORDER_WIDTH), Color.parseColor(getActualColor(optJSONObject.optString(NodeProps.BORDER_COLOR))), (float) optJSONObject.optDouble(NodeProps.BORDER_RADIUS), Color.parseColor(getActualColor(optJSONObject.optString("bgColor"))));
        }
        coverView.setClickable(jSONObject.optBoolean("clickable"));
        coverView.setIncludeFontPadding(false);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("label");
        if (optJSONObject2 != null) {
            if (!StringUtil.isEmpty(optJSONObject2.optString("color"))) {
                coverView.setTextColor(Color.parseColor(getActualColor(optJSONObject2.optString("color"))));
            }
            coverView.setTextSize(1, optJSONObject2.optInt("fontSize"));
            if ("left".equals(optJSONObject2.optString("textAlign"))) {
                coverView.setGravity(3);
            } else if ("center".equals(optJSONObject2.optString("textAlign"))) {
                coverView.setGravity(17);
            }
            if (!StringUtil.isEmpty(optJSONObject2.optString("content"))) {
                coverView.setText(optJSONObject2.optString("content"));
            }
            if ("bold".equals(optJSONObject2.optString("fontWeight"))) {
                coverView.setTypeface(Typeface.defaultFromStyle(1));
            }
        }
        coverView.setClickable(jSONObject.optBoolean("clickable"));
        coverView.setOnClickListener(new View.OnClickListener(jSONObject) { // from class: com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ JSONObject val$jsonObject;

            {
                this.val$jsonObject = jSONObject;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebviewContainer.this, (Object) jSONObject);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    try {
                        String optString = this.val$jsonObject.optString("data");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("data", optString);
                        WebviewContainer.this.pageWebview.evaluteJs("WeixinJSBridge.subscribeHandler(\"onTextViewClick\", " + jSONObject2 + "," + WebviewContainer.this.pageWebview.pageWebviewId + ")");
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        if (jSONObject.optJSONObject("position") != null) {
            int optInt3 = (int) ((this.density * r12.optInt("width")) + 0.5f);
            int optInt4 = (int) ((this.density * r12.optInt("height")) + 0.5f);
            int optInt5 = (int) ((this.density * r12.optInt("left")) + 0.5f);
            int optInt6 = (int) ((this.density * r12.optInt("top")) + 0.5f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(optInt3, optInt4);
            layoutParams2.leftMargin = layoutParams.leftMargin + optInt5;
            layoutParams2.topMargin = layoutParams.topMargin + optInt6;
            this.componentLayout.addView(coverView, layoutParams2);
        }
    }

    public void insertVideoPlayer(int i3, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) jSONObject);
            return;
        }
        MiniAppVideoPlayer miniAppVideoPlayer = (MiniAppVideoPlayer) this.videoPlayerSparseArray.get(i3);
        if (miniAppVideoPlayer == null) {
            miniAppVideoPlayer = new MiniAppVideoPlayer(getContext());
            miniAppVideoPlayer.f246201m = new WeakReference(this.appBrandRuntime.f245899d);
            miniAppVideoPlayer.f246190b = jSONObject.optString("data");
            miniAppVideoPlayer.f246191c = this.appBrandRuntime.f245904i;
            miniAppVideoPlayer.f246192d = this.pageWebview.pageWebviewId;
            com.tencent.mobileqq.microapp.app.b.a().addObserver(miniAppVideoPlayer.f246205q);
            this.videoPlayerSparseArray.put(i3, miniAppVideoPlayer);
        }
        miniAppVideoPlayer.b(jSONObject);
        miniAppVideoPlayer.f246202n = this;
        miniAppVideoPlayer.f246203o = jSONObject.optJSONObject("position");
        addVidepPlayer(miniAppVideoPlayer);
        if (jSONObject.optBoolean("hide")) {
            miniAppVideoPlayer.setVisibility(8);
        }
    }

    public float measureText(String str, int i3, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Float) iPatchRedirector.redirect((short) 28, this, str, Integer.valueOf(i3), jSONObject)).floatValue();
        }
        CanvasView canvasView = this.mCurrCanvas;
        if (canvasView == null) {
            return -1.0f;
        }
        return canvasView.a(jSONObject);
    }

    public void notifyChangePullDownRefreshStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.swipeRefreshLayout.setProgressBackgroundColorSchemeColor(this.appBrandRuntime.f245902g.refreshStyleColor);
        if (this.appBrandRuntime.f245902g.refreshStyleColor == -1) {
            this.swipeRefreshLayout.setColorSchemeColors(-16777216);
        } else {
            this.swipeRefreshLayout.setColorSchemeColors(-1);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
        }
        this.appBrandRuntime.a(PageWebviewContainer.EVENT_TO_SERVICE_ON_PULLDOWN_REFRESH, "{}", this.pageWebview.pageWebviewId);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.PageWebview.OnWebviewScrollListener
    public void onVerticalScroll(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onVerticalScroll scrollY=" + i3);
        }
        this.componentLayout.scrollTo(0, i3);
    }

    public void onVideoPlayerPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.videoPlayerSparseArray.size(); i3++) {
            ((MiniAppVideoPlayer) this.videoPlayerSparseArray.valueAt(i3)).c();
        }
    }

    public void onVideoPlayerResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < this.videoPlayerSparseArray.size(); i3++) {
            ((MiniAppVideoPlayer) this.videoPlayerSparseArray.valueAt(i3)).b();
        }
    }

    public void operateCamera(String str, int i3, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), jSONObject);
            return;
        }
        MiniAppCamera miniAppCamera = (MiniAppCamera) this.cameraViewSparseArray.get(jSONObject.optInt("cameraId"));
        if (miniAppCamera == null) {
            callbackJsEventFail(str, null, i3);
            return;
        }
        this.currentCamera = miniAppCamera;
        String optString = jSONObject.optString("type");
        if ("takePhoto".equals(optString)) {
            miniAppCamera.a(this, str, i3, jSONObject.optString(CustomImageProps.QUALITY));
        } else if ("startRecord".equals(optString)) {
            miniAppCamera.a(this, str, i3);
        } else if ("stopRecord".equals(optString)) {
            miniAppCamera.b(this, str, i3);
        }
    }

    public void operateVideoPlayer(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) str);
            return;
        }
        MiniAppVideoPlayer miniAppVideoPlayer = (MiniAppVideoPlayer) this.videoPlayerSparseArray.get(i3);
        if (miniAppVideoPlayer == null) {
            return;
        }
        if ("play".equals(str)) {
            miniAppVideoPlayer.f();
        } else if ("pause".equals(str)) {
            miniAppVideoPlayer.c();
        } else if ("sendDanmu".equals(str)) {
            miniAppVideoPlayer.b("aaaaa");
        }
    }

    public void removeCanvas(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        CanvasView canvasView = (CanvasView) this.canvasSparseArray.get(i3);
        if (canvasView == null) {
            return;
        }
        this.componentLayout.removeView(canvasView);
        this.canvasSparseArray.remove(i3);
    }

    public void removeImageView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        CoverImageView coverImageView = (CoverImageView) this.imageViewSparseArray.get(i3);
        if (coverImageView == null) {
            return;
        }
        removeCoverChildView(i3);
        this.componentLayout.removeView(coverImageView);
    }

    public void removeTextArea(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
            return;
        }
        MiniAppTextArea miniAppTextArea = (MiniAppTextArea) this.appTextAreaSparseArray.get(i3);
        if (miniAppTextArea == null) {
            return;
        }
        this.videoPlayerSparseArray.remove(i3);
        this.componentLayout.removeView(miniAppTextArea);
    }

    public void removeTextView(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        CoverView coverView = (CoverView) this.mTextViewSparseArray.get(i3);
        if (coverView == null) {
            return;
        }
        removeCoverChildView(i3);
        this.componentLayout.removeView(coverView);
    }

    public void removeVideoPlayer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        MiniAppVideoPlayer miniAppVideoPlayer = (MiniAppVideoPlayer) this.videoPlayerSparseArray.get(i3);
        if (miniAppVideoPlayer == null) {
            return;
        }
        this.videoPlayerSparseArray.remove(i3);
        this.componentLayout.removeView(miniAppVideoPlayer);
    }

    public void saveCanvasFile(int i3, String str, int i16, JSONObject jSONObject) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), str, Integer.valueOf(i16), jSONObject);
            return;
        }
        CanvasView canvasView = (CanvasView) this.canvasSparseArray.get(i3);
        if (canvasView == null) {
            callbackJsEventFail(str, null, i16);
        } else {
            canvasView.a(this, getContext(), jSONObject, str, i16);
        }
    }

    public void setPageWebview(PageWebview pageWebview) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pageWebview);
            return;
        }
        this.pageWebview = pageWebview;
        pageWebview.setOnWebviewScrollListener(this);
        pageWebview.addView(this.componentLayout, new FrameLayout.LayoutParams(-1, -1));
        this.swipeRefreshLayout.addView(pageWebview, new ViewGroup.LayoutParams(-1, -1));
    }

    public void startPullDownRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.swipeRefreshLayout.setRefreshing(true);
        }
    }

    public void stopPullDownRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.swipeRefreshLayout.setRefreshing(false);
        }
    }

    public void updateCanvas(int i3, JSONObject jSONObject, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), jSONObject, Boolean.valueOf(z16));
            return;
        }
        CanvasView canvasView = (CanvasView) this.canvasSparseArray.get(i3);
        if (canvasView == null) {
            return;
        }
        if (jSONObject == null) {
            if (z16) {
                canvasView.setVisibility(8);
                return;
            }
            return;
        }
        int optInt = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
        int optInt2 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
        int optInt3 = (int) ((this.density * jSONObject.optInt("left")) + 0.5f);
        int optInt4 = (int) ((this.density * jSONObject.optInt("top")) + 0.5f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
        layoutParams.leftMargin = optInt3;
        layoutParams.topMargin = optInt4;
        canvasView.setLayoutParams(layoutParams);
    }

    public void updateHTMLWebView(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateHTMLWebView htmlId=" + i3 + ",innerWebView=" + this.innerWebView + ",src=" + str);
        }
        ProgressWebView progressWebView = this.innerWebView;
        if (progressWebView != null && progressWebView.htmlId == i3 && !TextUtils.isEmpty(str)) {
            this.innerWebView.setVisibility(0);
            this.innerWebView.loadUrl(str);
        }
    }

    public void updateImageView(JSONObject jSONObject, int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, jSONObject, Integer.valueOf(i3), str, Boolean.valueOf(z16));
            return;
        }
        CoverImageView coverImageView = (CoverImageView) this.imageViewSparseArray.get(i3);
        if (coverImageView != null) {
            if (!StringUtil.isEmpty(str)) {
                if (!str.startsWith("http") && !str.startsWith("https")) {
                    String j3 = this.appBrandRuntime.f245898c.j(str);
                    if (!StringUtil.isEmpty(j3)) {
                        coverImageView.setImageBitmap(c.q(j3));
                    }
                } else {
                    try {
                        URLDrawable drawable = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null);
                        if (drawable != null) {
                            coverImageView.setImageDrawable(drawable);
                        }
                    } catch (OutOfMemoryError e16) {
                        e16.printStackTrace();
                    }
                }
            }
            int optInt = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
            int optInt2 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
            int optInt3 = (int) ((this.density * jSONObject.optInt("left")) + 0.5f);
            int optInt4 = (int) ((this.density * jSONObject.optInt("top")) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
            layoutParams.leftMargin = optInt3;
            layoutParams.topMargin = optInt4;
            coverImageView.setLayoutParams(layoutParams);
        }
    }

    public void updateTextArea(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3, (Object) str);
            return;
        }
        MiniAppTextArea miniAppTextArea = (MiniAppTextArea) this.appTextAreaSparseArray.get(i3);
        if (miniAppTextArea == null) {
            return;
        }
        miniAppTextArea.setText(str);
    }

    public void updateTextView(int i3, JSONObject jSONObject, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), jSONObject, str);
            return;
        }
        CoverView coverView = (CoverView) this.mTextViewSparseArray.get(i3);
        if (coverView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) coverView.getLayoutParams();
            if (jSONObject != null) {
                int optInt = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
                int optInt2 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
                int optInt3 = (int) ((this.density * jSONObject.optInt("left")) + 0.5f);
                int optInt4 = (int) ((this.density * jSONObject.optInt("top")) + 0.5f);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(optInt, optInt2);
                layoutParams2.leftMargin = layoutParams.leftMargin + optInt3;
                layoutParams2.topMargin = layoutParams.topMargin + optInt4;
                coverView.setLayoutParams(layoutParams2);
            }
            coverView.setText(str);
        }
    }

    public void updateVideoPlayer(int i3, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) jSONObject);
            return;
        }
        MiniAppVideoPlayer miniAppVideoPlayer = (MiniAppVideoPlayer) this.videoPlayerSparseArray.get(i3);
        if (miniAppVideoPlayer != null) {
            miniAppVideoPlayer.b(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("left");
                int optInt2 = optJSONObject.optInt("top");
                int optInt3 = optJSONObject.optInt("width");
                int optInt4 = optJSONObject.optInt("height");
                float f16 = this.density;
                int i16 = (int) ((optInt3 * f16) + 0.5f);
                int i17 = (int) ((optInt4 * f16) + 0.5f);
                int i18 = (int) ((optInt * f16) + 0.5f);
                int i19 = (int) ((f16 * optInt2) + 0.5f);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) miniAppVideoPlayer.getLayoutParams();
                layoutParams.width = i16;
                layoutParams.height = i17;
                layoutParams.leftMargin = i18;
                layoutParams.topMargin = i19;
            }
            String optString = jSONObject.optString("filePath");
            if (!StringUtil.isEmpty(optString)) {
                miniAppVideoPlayer.a(optString.replace("https:", "http:"));
                if (miniAppVideoPlayer.f246197i) {
                    miniAppVideoPlayer.f();
                }
            }
        }
    }
}
