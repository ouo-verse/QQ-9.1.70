package com.tencent.xweb.pinus.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.ar.f0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CalledByRuntime;
import com.tencent.xweb.XWebExtendInputClient;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.XWebExtendPluginClient;
import com.tencent.xweb.XWebExtendTextAreaClient;
import com.tencent.xweb.pinus.PSCoreWrapper;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebView extends FrameLayout implements WebViewInterface, XWebExtendInterface {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "Pinus.WebView";
    private final ArrayList<Object> constructorParams;
    private final ArrayList<Object> constructorTypes;
    private PSCoreWrapper coreWrapper;
    private Object inner;
    private OverScrolledListener mOverScrolledListener;
    private ScrollChangedListener mScrollChangedListener;
    private WebViewInterface reflectInterface;
    private WebSettingsInterface webSettings;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OverScrolledListener {
        void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view);

        void onOverScrolled(boolean z16);

        boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i3, int i16, int i17, int i18);
    }

    public WebView(Context context) {
        super(context, null);
        ArrayList<Object> arrayList = new ArrayList<>();
        this.constructorTypes = arrayList;
        arrayList.add(Context.class);
        ArrayList<Object> arrayList2 = new ArrayList<>();
        this.constructorParams = arrayList2;
        arrayList2.add(context);
        init();
    }

    private void init() {
        PSCoreWrapper pSCoreWrapper = PSCoreWrapper.getInstance();
        this.coreWrapper = pSCoreWrapper;
        if (pSCoreWrapper == null) {
            return;
        }
        int size = this.constructorTypes.size();
        Class[] clsArr = new Class[size + 1];
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = this.constructorTypes.get(i3);
            if (obj instanceof String) {
                clsArr[i3] = this.coreWrapper.getBridgeClass((String) obj);
                ArrayList<Object> arrayList = this.constructorParams;
                arrayList.set(i3, this.coreWrapper.getBridgeObject(arrayList.get(i3)));
            } else if (obj instanceof Class) {
                clsArr[i3] = (Class) obj;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            Object a16 = new f0(this.coreWrapper.getBridgeClass("PSWebview"), clsArr).a(this.constructorParams.toArray());
            this.inner = a16;
            addView((FrameLayout) a16, new FrameLayout.LayoutParams(-1, -1));
            WebViewInterfaceImpl webViewInterfaceImpl = new WebViewInterfaceImpl(this.inner);
            this.reflectInterface = webViewInterfaceImpl;
            this.webSettings = new WebSettingsInterfaceImpl(webViewInterfaceImpl.getSettingsInner());
        } catch (Throwable th5) {
            x0.a(TAG, "init, error", th5);
        }
    }

    @CalledByRuntime
    private boolean performLongClickDelegate() {
        return performLongClick();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int addDocumentStartJavaScript(String str, String[] strArr) {
        return this.reflectInterface.addDocumentStartJavaScript(str, strArr);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void addJavascriptInterface(Object obj, String str) {
        this.reflectInterface.addJavascriptInterface(obj, str);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean canGoBack() {
        return this.reflectInterface.canGoBack();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean canGoBackOrForward(int i3) {
        return this.reflectInterface.canGoBackOrForward(i3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean canGoForward() {
        return this.reflectInterface.canGoForward();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearCache(boolean z16) {
        this.reflectInterface.clearCache(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearFormData() {
        this.reflectInterface.clearFormData();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearHistory() {
        this.reflectInterface.clearHistory();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearMatches() {
        this.reflectInterface.clearMatches();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearSslPreferences() {
        this.reflectInterface.clearSslPreferences();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearView() {
        this.reflectInterface.clearView();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return view_computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return view_computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return view_computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return view_computeVerticalScrollOffset();
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        return view_computeVerticalScrollRange();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public WebBackForwardList copyBackForwardList() {
        return this.reflectInterface.copyBackForwardList();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public PrintDocumentAdapter createPrintDocumentAdapter(String str) {
        return this.reflectInterface.createPrintDocumentAdapter(str);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void destroy() {
        this.reflectInterface.destroy();
    }

    @Override // android.view.ViewGroup, android.view.View, com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.reflectInterface.dispatchKeyEvent(keyEvent);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void documentHasImages(Message message) {
        this.reflectInterface.documentHasImages(message);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.reflectInterface.evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void findAllAsync(String str) {
        this.reflectInterface.findAllAsync(str);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void findNext(boolean z16) {
        this.reflectInterface.findNext(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void flingScroll(int i3, int i16) {
        this.reflectInterface.flingScroll(i3, i16);
    }

    @Override // android.view.View, com.tencent.xweb.pinus.sdk.WebViewInterface
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return this.reflectInterface.getAccessibilityNodeProvider();
    }

    public Object getBridge() {
        return this.inner;
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public SslCertificate getCertificate() {
        return this.reflectInterface.getCertificate();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int getContentHeight() {
        return this.reflectInterface.getContentHeight();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public ViewGroup getContentView() {
        return this.reflectInterface.getContentView();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public Bitmap getFavicon() {
        return this.reflectInterface.getFavicon();
    }

    public HitTestResultInterface getHitTestResult() {
        return new HitTestResultInterfaceImpl(this.reflectInterface.getHitTestResultInner());
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public Object getHitTestResultInner() {
        return this.reflectInterface.getHitTestResultInner();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean getImageBitmapToFile(String str, String str2, String str3, Object obj) {
        return this.reflectInterface.getImageBitmapToFile(str, str2, str3, obj);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public String getOriginalUrl() {
        return this.reflectInterface.getOriginalUrl();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int getProgress() {
        return this.reflectInterface.getProgress();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public float getScale() {
        return this.reflectInterface.getScale();
    }

    public WebSettingsInterface getSettings() {
        return this.webSettings;
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public Object getSettingsInner() {
        return this.reflectInterface.getSettingsInner();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public String getTitle() {
        return this.reflectInterface.getTitle();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void getTranslateSampleString(int i3) {
        this.reflectInterface.getTranslateSampleString(i3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public String getUrl() {
        return this.reflectInterface.getUrl();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void goBack() {
        this.reflectInterface.goBack();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void goBackOrForward(int i3) {
        this.reflectInterface.goBackOrForward(i3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void goForward() {
        this.reflectInterface.goForward();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void invokeZoomPicker() {
        this.reflectInterface.invokeZoomPicker();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean isPrivateBrowsingEnabled() {
        return this.reflectInterface.isPrivateBrowsingEnabled();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void loadData(String str, String str2, String str3) {
        this.reflectInterface.loadData(str, str2, str3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.reflectInterface.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void loadUrl(String str) {
        this.reflectInterface.loadUrl(str);
    }

    @Override // android.view.View, com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean onCheckIsTextEditor() {
        return this.reflectInterface.onCheckIsTextEditor();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void onExtendInputKeyboardHeightChanged(boolean z16, int i3, boolean z17) {
        this.reflectInterface.onExtendInputKeyboardHeightChanged(z16, i3, z17);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void onExtendTextAreaKeyboardHeightChanged(boolean z16, int i3, boolean z17) {
        this.reflectInterface.onExtendTextAreaKeyboardHeightChanged(z16, i3, z17);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void onHide() {
        this.reflectInterface.onHide();
    }

    @CalledByRuntime
    public void onOverScrolledDelegate(int i3, int i16, boolean z16, boolean z17, View view) {
        OverScrolledListener overScrolledListener = this.mOverScrolledListener;
        if (overScrolledListener != null) {
            overScrolledListener.onOverScrolled(i3, i16, z16, z17, view);
        }
    }

    @CalledByRuntime
    public void onOverscrollRefresh(boolean z16) {
        OverScrolledListener overScrolledListener = this.mOverScrolledListener;
        if (overScrolledListener != null) {
            overScrolledListener.onOverScrolled(z16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void onPause() {
        this.reflectInterface.onPause();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void onResume() {
        this.reflectInterface.onResume();
    }

    @CalledByRuntime
    public void onScrollChangedDelegate(int i3, int i16, int i17, int i18) {
        onScrollChanged(i3, i16, i17, i18);
        ScrollChangedListener scrollChangedListener = this.mScrollChangedListener;
        if (scrollChangedListener != null) {
            scrollChangedListener.onScrollChanged(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void onShow() {
        this.reflectInterface.onShow();
    }

    @Override // android.view.View, com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.reflectInterface.onTouchEvent(motionEvent);
    }

    @CalledByRuntime
    public boolean overScrollByDelegate(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view) {
        OverScrolledListener overScrolledListener = this.mOverScrolledListener;
        if (overScrolledListener != null) {
            return overScrolledListener.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16, view);
        }
        return false;
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean pageDown(boolean z16) {
        return this.reflectInterface.pageDown(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean pageUp(boolean z16) {
        return this.reflectInterface.pageUp(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void pauseTimers() {
        this.reflectInterface.pauseTimers();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void postUrl(String str, byte[] bArr) {
        this.reflectInterface.postUrl(str, bArr);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void reload() {
        this.reflectInterface.reload();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void removeDocumentStartJavaScript(int i3) {
        this.reflectInterface.removeDocumentStartJavaScript(i3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void removeJavascriptInterface(String str) {
        this.reflectInterface.removeJavascriptInterface(str);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void replaceTranslatedString(Map<String, String> map) {
        this.reflectInterface.replaceTranslatedString(map);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void requestFocusNodeHref(Message message) {
        this.reflectInterface.requestFocusNodeHref(message);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void requestImageRef(Message message) {
        this.reflectInterface.requestImageRef(message);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public WebBackForwardList restoreState(Bundle bundle) {
        return this.reflectInterface.restoreState(bundle);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void resumeTimers() {
        this.reflectInterface.resumeTimers();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean savePage(String str, String str2, int i3) {
        return this.reflectInterface.savePage(str, str2, i3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public WebBackForwardList saveState(Bundle bundle) {
        return this.reflectInterface.saveState(bundle);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void saveWebArchive(String str) {
        this.reflectInterface.saveWebArchive(str);
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        view_scrollBy(i3, i16);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        view_scrollTo(i3, i16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setAudioMuted(boolean z16) {
        this.reflectInterface.setAudioMuted(z16);
    }

    @Override // android.view.View, com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setBackgroundColor(int i3) {
        this.reflectInterface.setBackgroundColor(i3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setBottomHeight(int i3) {
        this.reflectInterface.setBottomHeight(i3);
    }

    public void setCustomOnOverScrolledListener(OverScrolledListener overScrolledListener) {
        this.mOverScrolledListener = overScrolledListener;
    }

    public void setCustomOnScrollChangedListener(ScrollChangedListener scrollChangedListener) {
        this.mScrollChangedListener = scrollChangedListener;
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setDownloadListener(DownloadListener downloadListener) {
        this.reflectInterface.setDownloadListener(downloadListener);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setExtendInputClient(Object obj) {
        this.reflectInterface.setExtendInputClient(obj);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setExtendPluginClient(Object obj) {
        this.reflectInterface.setExtendPluginClient(obj);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setExtendTextAreaClient(Object obj) {
        this.reflectInterface.setExtendTextAreaClient(obj);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setFindListener(WebView.FindListener findListener) {
        this.reflectInterface.setFindListener(findListener);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setHorizontalScrollBarEnable(boolean z16) {
        this.reflectInterface.setHorizontalScrollBarEnable(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setInitialScale(int i3) {
        this.reflectInterface.setInitialScale(i3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setNetworkAvailable(boolean z16) {
        this.reflectInterface.setNetworkAvailable(z16);
    }

    @Override // android.view.View, com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.reflectInterface.setOnTouchListener(onTouchListener);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setPluginTextureScale(String str, int i3, float f16, float f17) {
        this.reflectInterface.setPluginTextureScale(str, i3, f16, f17);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setProxyWebViewClientExtension(Object obj) {
        this.reflectInterface.setProxyWebViewClientExtension(obj);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setTranslateMode(boolean z16) {
        this.reflectInterface.setTranslateMode(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setVerticalScrollBarEnable(boolean z16) {
        this.reflectInterface.setVerticalScrollBarEnable(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setWebChromeClient(Object obj) {
        this.reflectInterface.setWebChromeClient(obj);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setWebContentsDebuggingEnabled(boolean z16) {
        this.reflectInterface.setWebContentsDebuggingEnabled(z16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setWebContentsSize(int i3, int i16) {
        this.reflectInterface.setWebContentsSize(i3, i16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setWebViewClient(Object obj) {
        this.reflectInterface.setWebViewClient(obj);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void smoothScroll(int i3, int i16, long j3) {
        this.reflectInterface.smoothScroll(i3, i16, j3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void stopLoading() {
        this.reflectInterface.stopLoading();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void takePluginScreenshot(String str, int i3) {
        this.reflectInterface.takePluginScreenshot(str, i3);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeHorizontalScrollOffset() {
        return this.reflectInterface.view_computeHorizontalScrollOffset();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeHorizontalScrollRange() {
        return this.reflectInterface.view_computeHorizontalScrollRange();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeVerticalScrollExtent() {
        return this.reflectInterface.view_computeVerticalScrollExtent();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeVerticalScrollOffset() {
        return this.reflectInterface.view_computeVerticalScrollOffset();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeVerticalScrollRange() {
        return this.reflectInterface.view_computeVerticalScrollRange();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void view_scrollBy(int i3, int i16) {
        this.reflectInterface.view_scrollBy(i3, i16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void view_scrollTo(int i3, int i16) {
        this.reflectInterface.view_scrollTo(i3, i16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void zoomBy(float f16) {
        this.reflectInterface.zoomBy(f16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean zoomIn() {
        return this.reflectInterface.zoomIn();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean zoomOut() {
        return this.reflectInterface.zoomOut();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearHistory(int i3, int i16) {
        this.reflectInterface.clearHistory(i3, i16);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void loadUrl(String str, Map<String, String> map) {
        this.reflectInterface.loadUrl(str, map);
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void saveWebArchive(String str, boolean z16, ValueCallback<String> valueCallback) {
        this.reflectInterface.saveWebArchive(str, z16, valueCallback);
    }

    @Override // com.tencent.xweb.XWebExtendInterface
    public void setExtendInputClient(XWebExtendInputClient xWebExtendInputClient) {
        setExtendInputClient((Object) xWebExtendInputClient);
    }

    @Override // com.tencent.xweb.XWebExtendInterface
    public void setExtendPluginClient(XWebExtendPluginClient xWebExtendPluginClient) {
        setExtendPluginClient((Object) xWebExtendPluginClient);
    }

    @Override // com.tencent.xweb.XWebExtendInterface
    public void setExtendTextAreaClient(XWebExtendTextAreaClient xWebExtendTextAreaClient) {
        setExtendTextAreaClient((Object) xWebExtendTextAreaClient);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        super(context, null);
        ArrayList<Object> arrayList = new ArrayList<>();
        this.constructorTypes = arrayList;
        arrayList.add(Context.class);
        arrayList.add(AttributeSet.class);
        ArrayList<Object> arrayList2 = new ArrayList<>();
        this.constructorParams = arrayList2;
        arrayList2.add(context);
        arrayList2.add(attributeSet);
        init();
    }
}
