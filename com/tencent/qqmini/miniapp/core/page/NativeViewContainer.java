package com.tencent.qqmini.miniapp.core.page;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea;
import com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.miniapp.widget.CoverCameraView;
import com.tencent.qqmini.miniapp.widget.CustomInnerWebView;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqmini.miniapp.widget.media.CoverLiveView;
import com.tencent.qqmini.miniapp.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import com.tencent.smtt.sdk.CookieManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NativeViewContainer extends FrameLayout {
    private static final String CONFIG_SPLIT = ",";
    private static final String TAG = "NativeViewContainer";
    private static String mCurWhiteListConfig;
    private static String mWhiteHostConfig;
    private static ArrayList<String> needCookieAppIdList;
    private static ArrayList<String> needCookieHostList;
    private SparseArray<MiniAppTextArea> appTextAreaSparseArray;
    protected float density;
    private InnerWebView innerWebView;
    private boolean isCustomNaviStyle;
    private boolean isFullScreen;
    private View keyBoardConfirmView;
    private long lastShowInputTime;
    private final List<IConfirmListerner> mConfirmListeners;
    private SparseArray<CoverView> mCoverViewSparseArray;
    private int mCurInput;
    private WebInputHandler mInputHandler;
    private IMiniAppContext mMiniAppContext;
    private PageWebviewContainer mWebviewContainer;
    private int originalSystemUiVisibility;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IConfirmListerner {
        void onConfirm();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f346230a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f346231b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f346232c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f346233d = 0;

        /* renamed from: e, reason: collision with root package name */
        private boolean f346234e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f346235f;

        public int b() {
            return this.f346233d;
        }

        public int c() {
            return this.f346230a;
        }

        public int d() {
            return this.f346231b;
        }

        public int e() {
            return this.f346232c;
        }

        public void f(boolean z16) {
            this.f346234e = z16;
        }

        public void g(int i3) {
            this.f346233d = i3;
        }

        public void h(boolean z16) {
            this.f346235f = z16;
        }

        public void i(int i3) {
            this.f346230a = i3;
        }

        public void j(int i3) {
            this.f346231b = i3;
        }

        public void k(int i3) {
            this.f346232c = i3;
        }
    }

    @Deprecated
    public NativeViewContainer(IMiniAppContext iMiniAppContext) {
        super(iMiniAppContext.getContext());
        this.mConfirmListeners = new ArrayList();
        this.appTextAreaSparseArray = new SparseArray<>();
        this.mCurInput = -1;
        this.mCoverViewSparseArray = new SparseArray<>();
        this.lastShowInputTime = 0L;
        this.isFullScreen = false;
        this.originalSystemUiVisibility = 0;
        this.isCustomNaviStyle = false;
        this.mMiniAppContext = iMiniAppContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doInsertCustomHTMLWebView(int i3, a aVar) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "insertHTMLWebView htmlId=" + i3 + ",innerCustomWebView=" + this.innerWebView);
        }
        if (isViewInvalid()) {
            return false;
        }
        if (this.mWebviewContainer.isCustomNavibar()) {
            if (this.mWebviewContainer.getBrandPage() != null) {
                this.mWebviewContainer.getBrandPage().updateViewStyle("custom");
                this.mWebviewContainer.getBrandPage().getTabBar().hideTabBar(false);
            }
            if (this.mWebviewContainer.getNaviBar() != null) {
                this.mWebviewContainer.getNaviBar().setBarStyle("custom");
            }
        }
        this.innerWebView = new CustomInnerWebView(this.mWebviewContainer.getAttachActivity(), aVar.f346234e);
        com.tencent.qqmini.miniapp.widget.a.b().e(i3, this.innerWebView);
        this.innerWebView.htmlId = i3;
        FrameLayout.LayoutParams createLayoutParam = createLayoutParam(aVar);
        this.innerWebView.setVisibility(8);
        addView(this.innerWebView, createLayoutParam);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doInsertHTMLWebView(int i3, a aVar) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "insertHTMLWebView htmlId=" + i3 + ",innerWebView=" + this.innerWebView);
        }
        if (isViewInvalid()) {
            return false;
        }
        if (this.mWebviewContainer.isCustomNavibar()) {
            if (this.mWebviewContainer.getBrandPage() != null) {
                this.mWebviewContainer.getBrandPage().updateViewStyle("default");
                this.mWebviewContainer.getBrandPage().getTabBar().hideTabBar(false);
            }
            if (this.mWebviewContainer.getNaviBar() != null) {
                this.mWebviewContainer.getNaviBar().setBarStyle("default");
            }
        }
        InnerWebView innerWebView = new InnerWebView(this.mWebviewContainer.getAttachActivity());
        this.innerWebView = innerWebView;
        innerWebView.htmlId = i3;
        FrameLayout.LayoutParams createLayoutParam = createLayoutParam(aVar);
        this.innerWebView.setVisibility(8);
        addView(this.innerWebView, createLayoutParam);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doRemoveHTMLWebView(int i3) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "removeHTMLWebView htmlId=" + i3);
        }
        InnerWebView innerWebView = this.innerWebView;
        if (innerWebView != null && innerWebView.htmlId == i3) {
            innerWebView.loadUrl("about:blank");
            this.innerWebView.clearView();
            this.innerWebView.destroy();
            removeView(this.innerWebView);
            this.innerWebView = null;
            com.tencent.qqmini.miniapp.widget.a.b().d(this.innerWebView.htmlId);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterFullScreen(boolean z16) {
        this.isCustomNaviStyle = isCustomNavibar();
        setNaviBarState(false, z16);
        try {
            Window window = this.mWebviewContainer.getAttachActivity().getWindow();
            window.addFlags(1024);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            ImmersiveUtils.enterFullScreenMode(this.mMiniAppContext.getAttachActivity());
            this.isFullScreen = true;
        } catch (Exception e16) {
            QMLog.e(TAG, " enterFullScreen error.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitFullScreen() {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null && pageWebviewContainer.getAttachActivity() != null) {
            setNaviBarState(true, true);
            this.mWebviewContainer.getAttachActivity().getWindow().clearFlags(1024);
            this.mWebviewContainer.setSystemUiVisibility(this.originalSystemUiVisibility);
            this.isFullScreen = false;
        }
    }

    private ArrayList<String> getNeedCookieAppIdList() {
        String config;
        synchronized (ApkgInfo.class) {
            if (needCookieAppIdList == null && (config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_COOKIE_WHITE_APPID_LIST, WnsConfig.DefaultValue.DEFAULT_MINIAPP_COOKIE_LIST)) != null && !config.equals(mCurWhiteListConfig)) {
                QMLog.i(TAG, "Default white appid:" + config);
                needCookieAppIdList = new ArrayList<>();
                try {
                    String[] split = config.split(",");
                    if (split != null) {
                        for (String str : split) {
                            if (!TextUtils.isEmpty(str)) {
                                needCookieAppIdList.add(str);
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                mCurWhiteListConfig = config;
            }
        }
        return needCookieAppIdList;
    }

    private void getNeedCookieHostList() {
        String config;
        if (needCookieHostList == null && (config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_COOKIIE_WHITE_HOST_LIST, WnsConfig.DEFAULT_SET_COOKIIE_HOST)) != null && !config.equals(mWhiteHostConfig)) {
            QMLog.i(TAG, "Default white host:" + config);
            needCookieHostList = new ArrayList<>();
            try {
                String[] split = config.split(",");
                if (split != null) {
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            needCookieHostList.add(str);
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            mWhiteHostConfig = config;
        }
    }

    private void handleCanvasGetImageData(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            CoverView coverView = this.mCoverViewSparseArray.get(jSONObject.optInt("canvasId"));
            if (!(coverView instanceof CanvasView)) {
                nativeViewRequestEvent.fail();
            } else {
                ((CanvasView) coverView).getImageData(jSONObject, nativeViewRequestEvent);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            nativeViewRequestEvent.fail();
        }
    }

    private void handleCanvasPutImageData(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            CoverView coverView = this.mCoverViewSparseArray.get(jSONObject.optInt("canvasId"));
            if (!(coverView instanceof CanvasView)) {
                this.mWebviewContainer.callbackJsEventFail(nativeViewRequestEvent.event, null, nativeViewRequestEvent.callbackId);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("method", nativeViewRequestEvent.event);
                jSONObject2.put("data", jSONObject);
                jSONObject2.put("callbackId", nativeViewRequestEvent.callbackId);
                jSONArray.mo162put(jSONObject2);
                ((CanvasView) coverView).addDrawActionCommand(new CanvasView.DrawActionCommand(true, jSONArray, false));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            this.mWebviewContainer.callbackJsEventFail(nativeViewRequestEvent.event, null, nativeViewRequestEvent.callbackId);
        }
    }

    private void handleCanvasToTempFilePath(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            CoverView coverView = this.mCoverViewSparseArray.get(jSONObject.optInt("canvasId"));
            if (!(coverView instanceof CanvasView)) {
                nativeViewRequestEvent.fail();
            } else {
                ((CanvasView) coverView).saveBitmap(nativeViewRequestEvent, jSONObject);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            nativeViewRequestEvent.fail();
        }
    }

    private void handleDrawCanvas(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            drawCanvas(jSONObject.optInt("canvasId"), jSONObject.optBoolean("reserve", false), jSONObject.optBoolean("useHardwareAccelerate"), jSONObject.optJSONArray("actions"), nativeViewRequestEvent);
            nativeViewRequestEvent.ok();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleHideKeyboard(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("inputId");
                    if ((nativeViewRequestEvent.jsService instanceof PageWebview) && NativeViewContainer.this.mInputHandler != null && NativeViewContainer.this.mInputHandler.getShowingInput() != null && !NativeViewContainer.this.mInputHandler.getShowingInput().containsKey(Integer.valueOf(optInt))) {
                        MiniAppTextArea textArea = NativeViewContainer.this.getTextArea(optInt);
                        if (textArea != null) {
                            InputMethodManager inputMethodManager = (InputMethodManager) NativeViewContainer.this.mMiniAppContext.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                            if (inputMethodManager != null) {
                                inputMethodManager.hideSoftInputFromWindow(textArea.getWindowToken(), 0);
                            }
                            NativeViewContainer.this.hideKeyBoardConfirmView();
                            nativeViewRequestEvent.ok();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("inputId", optInt);
                            jSONObject.put("value", textArea.getText().toString());
                            jSONObject.put("cursor", textArea.getText().toString().length());
                            nativeViewRequestEvent.sendSubscribeJs(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString(), 0);
                            return;
                        }
                        return;
                    }
                    if (NativeViewContainer.this.mInputHandler != null) {
                        NativeViewContainer.this.mInputHandler.hideKeyboard(nativeViewRequestEvent);
                    }
                } catch (Throwable th5) {
                    QMLog.e(NativeViewContainer.TAG, "EVENT_HIDE_KEYBOARD error.", th5);
                }
            }
        });
    }

    private void handleInsertCanvas(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("canvasId");
            final int optInt2 = jSONObject.optInt("parentId");
            final JSONObject optJSONObject = jSONObject.optJSONObject("position");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            final String optString = jSONObject.optString("data");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.11
                @Override // java.lang.Runnable
                public void run() {
                    Boolean bool;
                    if (jSONObject.opt("disableScroll") != null) {
                        bool = Boolean.valueOf(jSONObject.optBoolean("disableScroll"));
                    } else {
                        bool = null;
                    }
                    NativeViewContainer.this.insertCanvas(optInt, optInt2, optJSONObject, optString, jSONObject.optBoolean("hide"), jSONObject.optBoolean("useHardwareAccelerate"), bool, jSONObject.optBoolean("gesture"), nativeViewRequestEvent.jsService);
                    nativeViewRequestEvent.ok(jSONObject2);
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void handleInsertTextArea(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("inputId");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("inputId", optInt);
            String optString = jSONObject.optString("data");
            if (!TextUtils.isEmpty(optString)) {
                jSONObject2.put("data", optString);
            }
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        NativeViewContainer.this.insertTextArea(optInt, jSONObject, nativeViewRequestEvent);
                        nativeViewRequestEvent.ok(jSONObject2);
                        NativeViewContainer.this.callbackLineChange(optInt);
                    } catch (Throwable th5) {
                        QMLog.e(NativeViewContainer.TAG, nativeViewRequestEvent.event + " error.", th5);
                    }
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void handleRemoveCanvas(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("canvasId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.13
                @Override // java.lang.Runnable
                public void run() {
                    NativeViewContainer.this.removeCanvas(optInt);
                    nativeViewRequestEvent.ok();
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void handleRemoveTextArea(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("inputId");
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("inputId", optInt);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.9
                @Override // java.lang.Runnable
                public void run() {
                    NativeViewContainer.this.removeTextArea(optInt);
                    nativeViewRequestEvent.ok(jSONObject);
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void handleSetInputValue(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.6
            @Override // java.lang.Runnable
            public void run() {
                if (NativeViewContainer.this.mInputHandler != null) {
                    NativeViewContainer.this.mInputHandler.setKeyboardValue(nativeViewRequestEvent);
                }
            }
        });
    }

    private void handleSwitchFullScreen(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
                    String optString = jSONObject.optString("mode");
                    boolean optBoolean = jSONObject.optBoolean("showCapsule", false);
                    if (TextUtils.equals(optString, "on") && !NativeViewContainer.this.isFullScreen) {
                        NativeViewContainer.this.enterFullScreen(optBoolean);
                    } else if (TextUtils.equals(optString, DebugKt.DEBUG_PROPERTY_VALUE_OFF) && NativeViewContainer.this.isFullScreen) {
                        NativeViewContainer.this.exitFullScreen();
                    }
                } catch (JSONException e16) {
                    QMLog.e(NativeViewContainer.TAG, nativeViewRequestEvent.event + " error.", e16);
                }
            }
        });
    }

    private void handleUpdateCanvas(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("canvasId");
            final JSONObject optJSONObject = jSONObject.optJSONObject("position");
            final boolean optBoolean = jSONObject.optBoolean("hide", false);
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.12
                @Override // java.lang.Runnable
                public void run() {
                    NativeViewContainer.this.updateCanvas(optInt, optJSONObject, optBoolean);
                    nativeViewRequestEvent.ok(jSONObject2);
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void handleUpdateInput(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.5
            @Override // java.lang.Runnable
            public void run() {
                if (NativeViewContainer.this.mInputHandler != null && NativeViewContainer.this.mInputHandler.updateInput(nativeViewRequestEvent.jsonParams)) {
                    nativeViewRequestEvent.ok();
                } else {
                    nativeViewRequestEvent.fail();
                }
            }
        });
    }

    private void handleUpdateTextArea(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            int optInt = jSONObject.optInt("inputId");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("inputId", optInt);
            String optString = jSONObject.optString("data");
            if (!TextUtils.isEmpty(optString)) {
                jSONObject2.put("data", optString);
            }
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.8
                @Override // java.lang.Runnable
                public void run() {
                    NativeViewContainer.this.updateTextArea(jSONObject, nativeViewRequestEvent);
                    nativeViewRequestEvent.ok(jSONObject2);
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void initKeyBoardConfirmView() {
        View inflate = LayoutInflater.from(getContext().getApplicationContext()).inflate(R.layout.mini_sdk_keyboard_confirm, (ViewGroup) null);
        this.keyBoardConfirmView = inflate;
        inflate.setVisibility(8);
        ((TextView) this.keyBoardConfirmView.findViewById(R.id.mini_app_keyboard_confirm_botton)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                synchronized (NativeViewContainer.this.mConfirmListeners) {
                    for (int i3 = 0; i3 < NativeViewContainer.this.mConfirmListeners.size(); i3++) {
                        IConfirmListerner iConfirmListerner = (IConfirmListerner) NativeViewContainer.this.mConfirmListeners.get(i3);
                        if (iConfirmListerner != null) {
                            iConfirmListerner.onConfirm();
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            pageWebviewContainer.addViewOnPage(this.keyBoardConfirmView);
        }
    }

    private void inputShowKeyboard(final NativeViewRequestEvent nativeViewRequestEvent, long j3) {
        if (System.currentTimeMillis() - j3 > 1000) {
            this.lastShowInputTime = System.currentTimeMillis();
            AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.1
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeViewContainer.this.mInputHandler != null) {
                        NativeViewContainer.this.mInputHandler.showKeyboard(nativeViewRequestEvent);
                    }
                }
            }, 200L);
        }
    }

    private boolean isViewInvalid() {
        PageWebviewContainer pageWebviewContainer;
        if (this.innerWebView == null && (pageWebviewContainer = this.mWebviewContainer) != null && pageWebviewContainer.getAttachActivity() != null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doUpdateHTMLWebView$1(final String str) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.e
            @Override // java.lang.Runnable
            public final void run() {
                NativeViewContainer.this.lambda$null$0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$null$0(String str) {
        PageWebviewContainer pageWebviewContainer;
        if (this.innerWebView != null && (pageWebviewContainer = this.mWebviewContainer) != null && pageWebviewContainer.getMiniAppContext() != null) {
            this.innerWebView.init(this.mWebviewContainer.getMiniAppContext());
            this.innerWebView.setVisibility(0);
            QMLog.e(TAG, "cookie : " + CookieManager.getInstance().getCookie(str));
            this.innerWebView.loadUrl(str);
            try {
                QMLog.e(TAG, "innerWebView.hasFocus() : " + this.innerWebView.hasFocus());
                if (!this.innerWebView.hasFocus()) {
                    this.innerWebView.requestFocus();
                    return;
                }
                return;
            } catch (Throwable th5) {
                QMLog.e(TAG, "innerWebView requestFocuserror,", th5);
                return;
            }
        }
        QMLog.e(TAG, "innerWebView or context is null.");
    }

    private void removeCoverChildView(int i3) {
        for (int i16 = 0; i16 < this.mCoverViewSparseArray.size(); i16++) {
            CoverView coverView = this.mCoverViewSparseArray.get(this.mCoverViewSparseArray.keyAt(i16));
            if (coverView != null && coverView.getParentId() == i3) {
                if (coverView.getParentId() == 0) {
                    removeView(coverView);
                } else {
                    CoverView coverView2 = this.mCoverViewSparseArray.get(coverView.getParentId());
                    if (coverView2 != null) {
                        coverView2.removeView(coverView);
                    }
                }
            }
        }
    }

    private void setNaviBarState(boolean z16, boolean z17) {
        String str;
        int i3 = 0;
        String str2 = "default";
        if (this.mWebviewContainer.getBrandPage() != null) {
            if (this.isCustomNaviStyle) {
                this.mWebviewContainer.getBrandPage().updateViewStyle("custom");
            } else {
                AppBrandPage brandPage = this.mWebviewContainer.getBrandPage();
                if (z16) {
                    str = "default";
                } else {
                    str = "custom";
                }
                brandPage.updateViewStyle(str);
                this.mWebviewContainer.getBrandPage().getTabBar().hideTabBar(false);
            }
        }
        if (this.mWebviewContainer.getNaviBar() != null) {
            if (this.isCustomNaviStyle) {
                this.mWebviewContainer.getNaviBar().setBarStyle("custom");
            } else {
                NavigationBar naviBar = this.mWebviewContainer.getNaviBar();
                if (!z16) {
                    str2 = "custom";
                }
                naviBar.setBarStyle(str2);
            }
        }
        if (this.mWebviewContainer.getNaviBar().getCapsuleButton() != null) {
            CapsuleButton capsuleButton = this.mWebviewContainer.getNaviBar().getCapsuleButton();
            if (!z17) {
                i3 = 8;
            }
            capsuleButton.setVisibility(i3);
        }
    }

    private void setWebviewCookie(String str, ChannelProxy.SetCookieCallback setCookieCallback) {
        MiniAppInfo miniAppInfo;
        ArrayList<String> arrayList;
        if (this.mWebviewContainer.getMiniAppContext() != null && this.mWebviewContainer.getMiniAppContext().getMiniAppInfo() != null) {
            miniAppInfo = this.mWebviewContainer.getMiniAppContext().getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (miniAppInfo != null && (arrayList = needCookieAppIdList) != null && arrayList.contains(miniAppInfo.appId)) {
            arrayList2.add(str);
        }
        ArrayList<String> arrayList3 = needCookieHostList;
        if (arrayList3 != null) {
            Iterator<String> it = arrayList3.iterator();
            while (it.hasNext()) {
                String next = it.next();
                QMLog.i(TAG, "setCookie : " + next);
                arrayList2.add(next);
            }
        }
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            channelProxy.setWebviewCookie(this.mWebviewContainer.getAttachActivity(), arrayList2, setCookieCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorPage(int i3, String str, MiniAppInfo miniAppInfo, NativeViewRequestEvent nativeViewRequestEvent) {
        String config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_WEBVIEWCCOMPONENT_ERRORPAGE, WnsConfig.SECONDARY_MINI_APP_WEBVIEWCCOMPONENT_ERRORPAGE);
        if (!TextUtils.isEmpty(config)) {
            config = config.replace("{url}", str);
            if (miniAppInfo != null) {
                config = config.replace("{appid}", miniAppInfo.appId);
            }
        }
        doUpdateHTMLWebView(i3, config);
        QMLog.e(TAG, "updateHTMLWebView domain valid : " + str);
        nativeViewRequestEvent.fail("domain valid");
    }

    private void textareaShowKeyboard(final NativeViewRequestEvent nativeViewRequestEvent, final int i3) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.2
            @Override // java.lang.Runnable
            public void run() {
                MiniAppTextArea textArea = NativeViewContainer.this.getTextArea(i3);
                if (textArea != null) {
                    NativeViewContainer.this.setCurInputId(i3);
                    textArea.setFocusable(true);
                    textArea.setFocusableInTouchMode(true);
                    textArea.requestFocus();
                    InputMethodManager inputMethodManager = (InputMethodManager) NativeViewContainer.this.mMiniAppContext.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                    if (inputMethodManager != null) {
                        inputMethodManager.showSoftInput(textArea, 0);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("inputId", i3);
                        nativeViewRequestEvent.ok(jSONObject);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        });
    }

    public boolean addConfirmListener(IConfirmListerner iConfirmListerner) {
        synchronized (this.mConfirmListeners) {
            if (!this.mConfirmListeners.contains(iConfirmListerner)) {
                return this.mConfirmListeners.add(iConfirmListerner);
            }
            return false;
        }
    }

    public boolean addCoverView(int i3, int i16, CoverView coverView, boolean z16) {
        QMLog.d(TAG, "addCoverView(). parentViewId = " + i3 + ", coverViewId = " + i16 + ", coverView = " + coverView);
        Objects.toString(coverView);
        if (coverView == null) {
            QMLog.w(TAG, "Failed to add coverView, coverView is null");
            return false;
        }
        this.mCoverViewSparseArray.put(i16, coverView);
        if (i3 == 0) {
            if (z16) {
                this.mWebviewContainer.addView(coverView);
                return true;
            }
            addView(coverView);
            return true;
        }
        CoverView coverView2 = getCoverView(i3);
        if (coverView2 != null) {
            coverView2.addView(coverView);
            return true;
        }
        return true;
    }

    public void addViewOnPage(View view, ViewGroup.LayoutParams layoutParams) {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            pageWebviewContainer.addViewOnPage(view, layoutParams);
        }
    }

    public void callbackLineChange(int i3) {
        MiniAppTextArea textArea = getTextArea(i3);
        if (textArea != null) {
            textArea.callbackLineChange();
        }
    }

    FrameLayout.LayoutParams createLayoutParam(a aVar) {
        float density = DisplayUtil.getDensity(this.mMiniAppContext.getContext());
        int e16 = (int) ((aVar.e() * density) + 0.5f);
        int b16 = (int) ((aVar.b() * density) + 0.5f);
        if (this.mWebviewContainer.isCustomNavibar()) {
            b16 -= ViewUtils.dpToPx(44.0f) + DisplayUtil.getStatusBarHeight(this.mMiniAppContext.getContext());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e16, b16);
        int c16 = (int) ((aVar.c() * density) + 0.5f);
        int d16 = (int) ((density * aVar.d()) + 0.5f);
        layoutParams.leftMargin = c16;
        layoutParams.topMargin = d16;
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, ",left=" + c16 + ",top=" + d16 + ",w=" + e16 + ",h=" + b16);
        }
        return layoutParams;
    }

    public void destroy() {
        InnerWebView innerWebView = this.innerWebView;
        if (innerWebView != null) {
            removeView(innerWebView);
            this.innerWebView.loadUrl("about:blank");
            this.innerWebView.clearView();
            this.innerWebView.destroy();
            this.innerWebView = null;
        }
        com.tencent.qqmini.miniapp.widget.a.b().a();
        SparseArray<MiniAppTextArea> sparseArray = this.appTextAreaSparseArray;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i3 = 0; i3 < this.appTextAreaSparseArray.size(); i3++) {
                MiniAppTextArea valueAt = this.appTextAreaSparseArray.valueAt(i3);
                if (valueAt != null) {
                    valueAt.removeKeyboardListener();
                    valueAt.removeGlobalLayoutListener();
                }
            }
        }
        SparseArray<MiniAppTextArea> sparseArray2 = this.appTextAreaSparseArray;
        if (sparseArray2 != null) {
            sparseArray2.clear();
        }
        for (int i16 = 0; i16 < this.mCoverViewSparseArray.size(); i16++) {
            CoverView valueAt2 = this.mCoverViewSparseArray.valueAt(i16);
            if (valueAt2 instanceof CoverVideoView) {
                CoverVideoView coverVideoView = (CoverVideoView) valueAt2;
                coverVideoView.stop();
                coverVideoView.release();
                removeView(valueAt2);
            } else if (valueAt2 instanceof CoverLiveView) {
                ((CoverLiveView) valueAt2).release();
                removeView(valueAt2);
            } else if (valueAt2 instanceof CoverPusherView) {
                ((CoverPusherView) valueAt2).release();
                removeView(valueAt2);
            } else if (valueAt2 instanceof CoverCameraView) {
                ((CoverCameraView) valueAt2).closeCamera();
            }
        }
        this.mCoverViewSparseArray.clear();
    }

    public boolean doUpdateHTMLWebView(int i3, final String str) {
        QMLog.d(TAG, "updateHTMLWebView htmlId=" + i3 + ",innerWebView=" + this.innerWebView + ",src=" + str);
        InnerWebView innerWebView = this.innerWebView;
        if (innerWebView == null || innerWebView.htmlId != i3 || TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.mWebviewContainer == null) {
            QMLog.d(TAG, "container is null");
            return false;
        }
        setWebviewCookie(str, new ChannelProxy.SetCookieCallback() { // from class: com.tencent.qqmini.miniapp.core.page.d
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.SetCookieCallback
            public final void onFinish() {
                NativeViewContainer.this.lambda$doUpdateHTMLWebView$1(str);
            }
        });
        return true;
    }

    public void drawCanvas(int i3, boolean z16, boolean z17, JSONArray jSONArray, NativeViewRequestEvent nativeViewRequestEvent) {
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        if (!(coverView instanceof CanvasView)) {
            QMLog.e(TAG, "updateCanvas failed! appCanvas return null! canvasId: " + i3);
            nativeViewRequestEvent.fail();
            return;
        }
        ((CanvasView) coverView).addDrawActionCommand(new CanvasView.DrawActionCommand(z16, jSONArray, z17));
    }

    public CoverView getCoverView(int i3) {
        return this.mCoverViewSparseArray.get(i3);
    }

    public int getCurInputId() {
        return this.mCurInput;
    }

    public c getCurrentPageWebview() {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            return pageWebviewContainer.getCurrentPageWebview();
        }
        return null;
    }

    public String getInnerWebViewUrl() {
        InnerWebView innerWebView = this.innerWebView;
        if (innerWebView != null) {
            return innerWebView.getOriginalUrl();
        }
        return null;
    }

    public int getNaviBarHeight() {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            return pageWebviewContainer.getNaviBarHeight();
        }
        return 0;
    }

    public PageWebviewContainer getPageWebviewContainer() {
        return this.mWebviewContainer;
    }

    public MiniAppTextArea getTextArea(int i3) {
        MiniAppTextArea miniAppTextArea;
        SparseArray<MiniAppTextArea> sparseArray = this.appTextAreaSparseArray;
        if (sparseArray != null && sparseArray.size() > 0 && (miniAppTextArea = this.appTextAreaSparseArray.get(i3)) != null) {
            return miniAppTextArea;
        }
        return null;
    }

    public int getWebScrollY() {
        return getCurrentPageWebview().getSavedScrollY();
    }

    public int getWebviewId() {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            return pageWebviewContainer.getWebViewId();
        }
        return 0;
    }

    public boolean handleBackPressed() {
        InnerWebView innerWebView = this.innerWebView;
        if (innerWebView != null && innerWebView.canGoBack()) {
            this.innerWebView.goBack();
            return true;
        }
        for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
            CoverView valueAt = this.mCoverViewSparseArray.valueAt(i3);
            if (valueAt instanceof CoverVideoView) {
                CoverVideoView coverVideoView = (CoverVideoView) valueAt;
                if (coverVideoView.isFullScreen()) {
                    coverVideoView.smallScreen();
                    return true;
                }
            } else if (valueAt instanceof CoverLiveView) {
                CoverLiveView coverLiveView = (CoverLiveView) valueAt;
                if (coverLiveView.isFullScreen()) {
                    coverLiveView.smallScreen();
                    return true;
                }
            } else {
                continue;
            }
        }
        c currentPageWebview = getCurrentPageWebview();
        if (currentPageWebview != null && currentPageWebview.handleBackPressed()) {
            return true;
        }
        if (this.isFullScreen) {
            this.mWebviewContainer.getAttachActivity().getWindow().clearFlags(1024);
            this.mWebviewContainer.setSystemUiVisibility(this.originalSystemUiVisibility);
        }
        return false;
    }

    public void handleInsertHtmlWebview(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
                    int optInt = jSONObject.optInt("htmlId");
                    JSONObject optJSONObject = jSONObject.optJSONObject("position");
                    if (optJSONObject != null) {
                        a parseWebviewParamFromJson = NativeViewContainer.this.parseWebviewParamFromJson(jSONObject, optJSONObject);
                        if (nativeViewRequestEvent.event.equals("insertCustomHTMLWebView") ? NativeViewContainer.this.doInsertCustomHTMLWebView(optInt, parseWebviewParamFromJson) : NativeViewContainer.this.doInsertHTMLWebView(optInt, parseWebviewParamFromJson)) {
                            nativeViewRequestEvent.ok();
                            return;
                        } else {
                            nativeViewRequestEvent.fail("create webview failed.");
                            return;
                        }
                    }
                    nativeViewRequestEvent.fail();
                    QMLog.e(NativeViewContainer.TAG, "posObj is null");
                } catch (Exception e16) {
                    QMLog.e(NativeViewContainer.TAG, nativeViewRequestEvent.event + " error.", e16);
                    nativeViewRequestEvent.fail();
                }
            }
        });
    }

    public String handleNativeUIEvent(NativeViewRequestEvent nativeViewRequestEvent) {
        QMLog.d(TAG, "event = " + nativeViewRequestEvent.event + ", params = " + nativeViewRequestEvent.jsonParams);
        if ("showKeyboard".equals(nativeViewRequestEvent.event)) {
            handleShowKeyboard(nativeViewRequestEvent);
            return null;
        }
        if ("hideKeyboard".equals(nativeViewRequestEvent.event)) {
            handleHideKeyboard(nativeViewRequestEvent);
            return null;
        }
        if (InputJsPlugin.EVENT_UPDATE_INPUT.equals(nativeViewRequestEvent.event)) {
            handleUpdateInput(nativeViewRequestEvent);
            return null;
        }
        if (InputJsPlugin.EVENT_SHOW_KEY_BORAD_VALUE.equals(nativeViewRequestEvent.event)) {
            handleSetInputValue(nativeViewRequestEvent);
            return null;
        }
        if ("insertTextArea".equals(nativeViewRequestEvent.event)) {
            handleInsertTextArea(nativeViewRequestEvent);
            return null;
        }
        if (UIJsPlugin.EVENT_UPDATE_TEXTAREA.equals(nativeViewRequestEvent.event)) {
            handleUpdateTextArea(nativeViewRequestEvent);
            return null;
        }
        if (UIJsPlugin.EVENT_REMOVE_TEXTAREA.equals(nativeViewRequestEvent.event)) {
            handleRemoveTextArea(nativeViewRequestEvent);
            return null;
        }
        if ("insertCanvas".equals(nativeViewRequestEvent.event)) {
            handleInsertCanvas(nativeViewRequestEvent);
            return null;
        }
        if ("updateCanvas".equals(nativeViewRequestEvent.event)) {
            handleUpdateCanvas(nativeViewRequestEvent);
            return null;
        }
        if ("removeCanvas".equals(nativeViewRequestEvent.event)) {
            handleRemoveCanvas(nativeViewRequestEvent);
            return null;
        }
        if ("drawCanvas".equals(nativeViewRequestEvent.event)) {
            handleDrawCanvas(nativeViewRequestEvent);
            return null;
        }
        if ("canvasToTempFilePath".equals(nativeViewRequestEvent.event)) {
            handleCanvasToTempFilePath(nativeViewRequestEvent);
            return null;
        }
        if ("canvasPutImageData".equals(nativeViewRequestEvent.event)) {
            handleCanvasPutImageData(nativeViewRequestEvent);
            return null;
        }
        if ("canvasGetImageData".equals(nativeViewRequestEvent.event)) {
            handleCanvasGetImageData(nativeViewRequestEvent);
            return null;
        }
        if (!"insertHTMLWebView".equals(nativeViewRequestEvent.event) && !"insertCustomHTMLWebView".equals(nativeViewRequestEvent.event)) {
            if (!"updateHTMLWebView".equals(nativeViewRequestEvent.event) && !"updateCustomHTMLWebView".equals(nativeViewRequestEvent.event)) {
                if ("removeHTMLWebView".equals(nativeViewRequestEvent.event)) {
                    handleRemoveHtmlWebview(nativeViewRequestEvent);
                    return null;
                }
                if ("switchFullScreen".equals(nativeViewRequestEvent.event)) {
                    handleSwitchFullScreen(nativeViewRequestEvent);
                    return null;
                }
                return null;
            }
            handleUpdateHtmlWebview(nativeViewRequestEvent);
            return null;
        }
        handleInsertHtmlWebview(nativeViewRequestEvent);
        return null;
    }

    public void handleRemoveHtmlWebview(final NativeViewRequestEvent nativeViewRequestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (NativeViewContainer.this.doRemoveHTMLWebView(new JSONObject(nativeViewRequestEvent.jsonParams).optInt("htmlId"))) {
                        nativeViewRequestEvent.ok();
                    } else {
                        nativeViewRequestEvent.fail();
                    }
                } catch (Exception e16) {
                    nativeViewRequestEvent.fail();
                    QMLog.e(NativeViewContainer.TAG, "removeHtmlWebview error.", e16);
                }
            }
        });
    }

    void handleShowKeyboard(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("inputId");
            if (optInt > 0) {
                textareaShowKeyboard(nativeViewRequestEvent, optInt);
            } else {
                inputShowKeyboard(nativeViewRequestEvent, this.lastShowInputTime);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, nativeViewRequestEvent.event + " error.", e16);
        }
    }

    public void handleUpdateHtmlWebview(final NativeViewRequestEvent nativeViewRequestEvent) {
        getNeedCookieAppIdList();
        getNeedCookieHostList();
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.16
            @Override // java.lang.Runnable
            public void run() {
                String str;
                JSONObject jSONObject;
                try {
                    JSONObject jSONObject2 = new JSONObject(nativeViewRequestEvent.jsonParams);
                    int optInt = jSONObject2.optInt("htmlId");
                    MiniAppInfo miniAppInfo = null;
                    if (jSONObject2.has("src")) {
                        str = jSONObject2.optString("src", "");
                    } else {
                        str = null;
                    }
                    if (jSONObject2.has("position")) {
                        jSONObject = jSONObject2.optJSONObject("position");
                    } else {
                        jSONObject = null;
                    }
                    boolean optBoolean = jSONObject2.optBoolean("__skipDomainCheck__", false);
                    if (NativeViewContainer.this.mWebviewContainer != null && NativeViewContainer.this.mWebviewContainer.getMiniAppContext() != null) {
                        miniAppInfo = NativeViewContainer.this.mWebviewContainer.getMiniAppContext().getMiniAppInfo();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        boolean isOpenUrlFilter = AppBrandUtil.isOpenUrlFilter(str);
                        if (miniAppInfo == null || !DomainUtil.isDomainValid(miniAppInfo, optBoolean, str, 4) || isOpenUrlFilter) {
                            NativeViewContainer.this.showErrorPage(optInt, str, miniAppInfo, nativeViewRequestEvent);
                            return;
                        }
                        NativeViewContainer.this.doUpdateHTMLWebView(optInt, str);
                    }
                    if (jSONObject != null) {
                        NativeViewContainer.this.doUpdateHTMLWebView(optInt, jSONObject);
                    }
                    nativeViewRequestEvent.ok();
                } catch (JSONException e16) {
                    QMLog.e(NativeViewContainer.TAG, "updateHtmlWebview error.", e16);
                }
            }
        });
    }

    public void hideKeyBoardConfirmView() {
        View view = this.keyBoardConfirmView;
        if (view != null && view.getVisibility() == 0) {
            this.keyBoardConfirmView.setVisibility(8);
        }
    }

    public void insertCanvas(int i3, int i16, JSONObject jSONObject, String str, boolean z16, boolean z17, Boolean bool, boolean z18, IJsService iJsService) {
        int i17;
        int i18;
        int optInt = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
        int optInt2 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
        c currentPageWebview = getCurrentPageWebview();
        if (currentPageWebview != null) {
            i17 = currentPageWebview.getMeasuredHeight();
        } else {
            i17 = 0;
        }
        QMLog.i(TAG, "insertCanvas currentWebview.getMeasuredHeight: " + i17 + "---canvas height----" + jSONObject.optInt("height") + "---" + optInt2 + "---canvasId---" + i3);
        int optInt3 = (int) ((this.density * ((float) jSONObject.optInt("left"))) + 0.5f);
        int optInt4 = (int) ((this.density * ((float) jSONObject.optInt("top"))) + 0.5f);
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        if (coverView == null) {
            i18 = optInt4;
            CanvasView canvasView = new CanvasView(this.mMiniAppContext, getWebviewId(), iJsService, this.mWebviewContainer.getApkgInfo(), str, i3, z17, bool, z18);
            this.mCoverViewSparseArray.put(i3, canvasView);
            addView(canvasView);
            canvasView.setParentId(i16);
            coverView = canvasView;
        } else {
            i18 = optInt4;
        }
        if (coverView instanceof CanvasView) {
            coverView.setContentDescription("CanvasView " + i3);
            if (z16) {
                coverView.setVisibility(8);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
            layoutParams.leftMargin = optInt3;
            layoutParams.topMargin = i18;
            coverView.setLayoutParams(layoutParams);
        }
    }

    public void insertTextArea(int i3, JSONObject jSONObject, NativeViewRequestEvent nativeViewRequestEvent) {
        MiniAppTextArea miniAppTextArea = this.appTextAreaSparseArray.get(i3);
        int optInt = jSONObject.optInt("parentId");
        boolean optBoolean = jSONObject.optBoolean(QCircleDaTongConstant.ElementParamValue.FIXED, false);
        if (miniAppTextArea == null) {
            miniAppTextArea = new MiniAppTextArea(getContext(), i3, this);
            miniAppTextArea.setFixed(optBoolean);
            this.appTextAreaSparseArray.put(i3, miniAppTextArea);
            if (optInt != 0) {
                CoverView coverView = this.mCoverViewSparseArray.get(optInt);
                if (coverView != null) {
                    coverView.addView(miniAppTextArea);
                    miniAppTextArea.setParentId(optInt);
                }
            } else if (optBoolean) {
                getPageWebviewContainer().addView(miniAppTextArea);
            } else {
                addView(miniAppTextArea);
            }
        }
        miniAppTextArea.setAttributes(jSONObject, false, nativeViewRequestEvent);
    }

    public boolean isCustomNavibar() {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            return pageWebviewContainer.isCustomNavibar();
        }
        return false;
    }

    public boolean isInnerWebView() {
        if (this.innerWebView != null) {
            return true;
        }
        return false;
    }

    public boolean isTextAreaFocused() {
        for (int i3 = 0; i3 < this.appTextAreaSparseArray.size(); i3++) {
            MiniAppTextArea valueAt = this.appTextAreaSparseArray.valueAt(i3);
            if (valueAt != null && valueAt.isTextAreaFocused()) {
                return true;
            }
        }
        return false;
    }

    public boolean isVideoFullScreen() {
        for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
            CoverView valueAt = this.mCoverViewSparseArray.valueAt(i3);
            if (valueAt instanceof CoverVideoView) {
                if (((CoverVideoView) valueAt).isFullScreen()) {
                    return true;
                }
            } else if ((valueAt instanceof CoverLiveView) && ((CoverLiveView) valueAt).isFullScreen()) {
                return true;
            }
        }
        return false;
    }

    public void notifyOnColorNoteAnimStart() {
        for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
            ViewParent viewParent = (CoverView) this.mCoverViewSparseArray.valueAt(i3);
            if (viewParent instanceof CoverView.OnPageChangeListener) {
                ((CoverView.OnPageChangeListener) viewParent).onAddColorNote();
            }
        }
    }

    public void notifyOnPageWebViewDestory() {
        for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
            ViewParent viewParent = (CoverView) this.mCoverViewSparseArray.valueAt(i3);
            if (viewParent instanceof CoverView.OnPageChangeListener) {
                ((CoverView.OnPageChangeListener) viewParent).onPageWebViewDestory();
            }
        }
    }

    public void notifyOnPageWebViewPause() {
        for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
            ViewParent viewParent = (CoverView) this.mCoverViewSparseArray.valueAt(i3);
            if (viewParent instanceof CoverView.OnPageChangeListener) {
                ((CoverView.OnPageChangeListener) viewParent).onPageWebViewPause();
            }
        }
        if (this.innerWebView != null) {
            QMLog.d(TAG, "innerWebView pause");
            this.innerWebView.onPause();
        }
    }

    public void notifyOnPageWebViewResume() {
        for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
            ViewParent viewParent = (CoverView) this.mCoverViewSparseArray.valueAt(i3);
            if (viewParent instanceof CoverView.OnPageChangeListener) {
                ((CoverView.OnPageChangeListener) viewParent).onPageWebViewResume();
            }
        }
        if (this.innerWebView != null) {
            QMLog.d(TAG, "innerWebView resume & requestFocus width=" + this.innerWebView.getWidth() + ", height=" + this.innerWebView.getHeight() + ", isFullScreen=" + this.isFullScreen);
            if (this.isFullScreen) {
                ImmersiveUtils.enterFullScreenMode(this.mMiniAppContext.getAttachActivity());
            }
            this.innerWebView.onResume();
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.page.NativeViewContainer.14
                @Override // java.lang.Runnable
                public void run() {
                    if (NativeViewContainer.this.innerWebView != null) {
                        NativeViewContainer.this.innerWebView.requestFocus();
                    }
                }
            });
        }
    }

    public void notifyPageBackground() {
        for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
            ViewParent viewParent = (CoverView) this.mCoverViewSparseArray.valueAt(i3);
            if (viewParent instanceof CoverView.OnPageChangeListener) {
                ((CoverView.OnPageChangeListener) viewParent).onPageBackground();
            }
        }
    }

    public void notifyPageForeground() {
        for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
            ViewParent viewParent = (CoverView) this.mCoverViewSparseArray.valueAt(i3);
            if (viewParent instanceof CoverView.OnPageChangeListener) {
                ((CoverView.OnPageChangeListener) viewParent).onPageForeground();
            }
        }
    }

    public void onPause() {
        QMLog.d(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        notifyPageBackground();
    }

    public void onResume() {
        notifyPageForeground();
    }

    protected a parseWebviewParamFromJson(JSONObject jSONObject, JSONObject jSONObject2) {
        a aVar = new a();
        aVar.g(jSONObject2.optInt("height"));
        aVar.i(jSONObject2.optInt("left"));
        aVar.j(jSONObject2.optInt("top"));
        aVar.k(jSONObject2.optInt("width"));
        aVar.f(jSONObject.optBoolean("allowtransparency"));
        aVar.h(jSONObject.optBoolean("hideSystemNavigation"));
        return aVar;
    }

    public void removeCanvas(int i3) {
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        if (!(coverView instanceof CanvasView)) {
            return;
        }
        removeCoverChildView(i3);
        int parentId = coverView.getParentId();
        if (parentId != 0) {
            if (this.mCoverViewSparseArray.get(parentId) != null) {
                this.mCoverViewSparseArray.get(parentId).removeView(coverView);
            }
        } else if (coverView.isFixed()) {
            this.mWebviewContainer.removeView(coverView);
        } else {
            removeView(coverView);
        }
        this.mCoverViewSparseArray.remove(i3);
    }

    public boolean removeConfirmListener(IConfirmListerner iConfirmListerner) {
        synchronized (this.mConfirmListeners) {
            if (this.mConfirmListeners.contains(iConfirmListerner)) {
                return this.mConfirmListeners.remove(iConfirmListerner);
            }
            return false;
        }
    }

    public boolean removeCoverView(int i3) {
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        if (coverView == null) {
            return false;
        }
        removeCoverChildView(i3);
        int parentId = coverView.getParentId();
        if (parentId != 0) {
            if (this.mCoverViewSparseArray.get(parentId) != null) {
                this.mCoverViewSparseArray.get(parentId).removeView(coverView);
            }
        } else if (coverView.isFixed()) {
            this.mWebviewContainer.removeView(coverView);
        } else {
            removeView(coverView);
        }
        this.mCoverViewSparseArray.remove(i3);
        if (coverView instanceof CoverLiveView) {
            ((CoverLiveView) coverView).release();
            return true;
        }
        if (coverView instanceof CoverPusherView) {
            ((CoverPusherView) coverView).release();
            return true;
        }
        return true;
    }

    public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener) {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            pageWebviewContainer.removeSoftKeyboardStateListener(softKeyboardStateListener);
        }
    }

    public void removeTextArea(int i3) {
        MiniAppTextArea miniAppTextArea = this.appTextAreaSparseArray.get(i3);
        if (miniAppTextArea == null) {
            return;
        }
        this.appTextAreaSparseArray.remove(i3);
        int parentId = miniAppTextArea.getParentId();
        if (parentId != 0) {
            if (this.mCoverViewSparseArray.get(parentId) != null) {
                this.mCoverViewSparseArray.get(parentId).removeView(miniAppTextArea);
            }
        } else if (miniAppTextArea.isFixed()) {
            getPageWebviewContainer().removeView(miniAppTextArea);
        } else {
            removeView(miniAppTextArea);
        }
        this.appTextAreaSparseArray.remove(i3);
    }

    public void scrollWebviewTo(int i3, int i16) {
        getCurrentPageWebview().getView().scrollTo(i3, i16);
    }

    public void setCurInputId(int i3) {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            pageWebviewContainer.setCurInputId(i3);
        }
    }

    public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener) {
        PageWebviewContainer pageWebviewContainer = this.mWebviewContainer;
        if (pageWebviewContainer != null) {
            pageWebviewContainer.setSoftKeyboardStateListener(softKeyboardStateListener);
        }
    }

    public void showKeyBoardConfirmView(int i3) {
        View view = this.keyBoardConfirmView;
        if (view != null) {
            if (view.getVisibility() == 8) {
                this.keyBoardConfirmView.setVisibility(0);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 50.0f));
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = i3;
            this.keyBoardConfirmView.setLayoutParams(layoutParams);
        }
    }

    public void updateCanvas(int i3, JSONObject jSONObject, boolean z16) {
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        if (!(coverView instanceof CanvasView)) {
            QMLog.e(TAG, "updateCanvas failed! appCanvas return null! canvasId: " + i3);
            return;
        }
        if (z16) {
            coverView.setVisibility(8);
        } else {
            coverView.setVisibility(0);
        }
        if (jSONObject != null) {
            int optInt = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
            int optInt2 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
            int optInt3 = (int) ((this.density * jSONObject.optInt("left")) + 0.5f);
            int optInt4 = (int) ((this.density * jSONObject.optInt("top")) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
            layoutParams.leftMargin = optInt3;
            layoutParams.topMargin = optInt4;
            coverView.setLayoutParams(layoutParams);
        }
    }

    public void updateTextArea(JSONObject jSONObject, NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            MiniAppTextArea miniAppTextArea = this.appTextAreaSparseArray.get(jSONObject.optInt("inputId"));
            if (miniAppTextArea == null) {
                return;
            }
            miniAppTextArea.setAttributes(jSONObject, true, nativeViewRequestEvent);
        } catch (Exception e16) {
            QMLog.e(TAG, "updateTextArea error.", e16);
        }
    }

    public boolean doUpdateHTMLWebView(int i3, JSONObject jSONObject) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "updateHTMLWebView htmlId=" + i3 + ",innerWebView=" + this.innerWebView + ",position=" + jSONObject);
        }
        InnerWebView innerWebView = this.innerWebView;
        if (innerWebView == null || innerWebView.htmlId != i3 || jSONObject == null) {
            return false;
        }
        float density = DisplayUtil.getDensity(getContext());
        int optInt = (int) ((jSONObject.optInt("width") * density) + 0.5f);
        int optInt2 = (int) ((jSONObject.optInt("height") * density) + 0.5f);
        int optInt3 = (int) ((jSONObject.optInt("left") * density) + 0.5f);
        int optInt4 = (int) ((density * jSONObject.optInt("top")) + 0.5f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
        layoutParams.leftMargin = optInt3;
        layoutParams.topMargin = optInt4;
        this.innerWebView.setLayoutParams(layoutParams);
        return true;
    }

    public NativeViewContainer(IMiniAppContext iMiniAppContext, PageWebviewContainer pageWebviewContainer) {
        super(iMiniAppContext.getContext());
        this.mConfirmListeners = new ArrayList();
        this.appTextAreaSparseArray = new SparseArray<>();
        this.mCurInput = -1;
        this.mCoverViewSparseArray = new SparseArray<>();
        this.lastShowInputTime = 0L;
        this.isFullScreen = false;
        this.originalSystemUiVisibility = 0;
        this.isCustomNaviStyle = false;
        this.density = DisplayUtil.getDensity(iMiniAppContext.getContext());
        this.mMiniAppContext = iMiniAppContext;
        this.mWebviewContainer = pageWebviewContainer;
        this.mInputHandler = new WebInputHandler(this);
        initKeyBoardConfirmView();
        this.originalSystemUiVisibility = getSystemUiVisibility();
    }

    public ViewGroup getNativeViewRoot() {
        return this;
    }
}
