package com.tencent.smtt.export.external.extension.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import com.tencent.smtt.export.external.interfaces.IX5ScrollListener;
import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardListClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IX5WebViewExtension {
    public static final int HANDLEVIEW_ALIGNMENT_CENTER = 1;
    public static final int HANDLEVIEW_ALIGNMENT_RIGHT = 2;
    public static final int HANDLEVIEW_POSITION_CENTER = 1;
    public static final int HANDLEVIEW_POSITION_RIGHT = 2;
    public static final int HANLDEVIEW_ALIGNMENT_LEFT = 0;
    public static final int HANLDEVIEW_POSITION_LEFT = 0;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int RENDER_MODE_DEFAULT = 0;
    public static final int RENDER_MODE_SMOOTHNESS_AGGRESSIVE = 2;
    public static final int RENDER_MODE_SMOOTHNESS_NORMAL = 1;

    void active();

    void cancelLongPress();

    boolean capturePageToFile(Bitmap.Config config, String str, boolean z16, int i3, int i16);

    void clearServiceWorkerCache();

    void clearTextEntry();

    void clearTextFieldLongPressStatus();

    void copyText();

    void cutText(CharSequence charSequence);

    void deactive();

    void doFingerSearchIfNeed();

    void doTranslateAction(int i3);

    void documentAsText(Message message);

    void documentDumpRenderTree(Message message);

    boolean drawPreReadBaseLayer(Canvas canvas, boolean z16);

    void dumpDisplayTree();

    void dumpViewportForLayoutTest(Message message);

    void enterSelectionMode(boolean z16);

    void exitPluginFullScreen();

    void focusAndPopupIM(String str);

    void forceSyncOffsetToCore();

    ArrayList<IX5WebViewBase.ImageInfo> getAllImageInfo();

    Bitmap getBitmapByIndex(int i3);

    int getCurrentHistoryItemIndex();

    String getDocumentOuterHTML();

    boolean getDrawWithBuffer();

    void getFakeLoginStatus(Bundle bundle, ValueCallback<Bundle> valueCallback);

    String getFocusCandidateText();

    IX5WebHistoryItem getHistoryItem(int i3);

    HashMap<String, String> getPerformanceDataByForce();

    int getQQBrowserVersion();

    int getScrollX();

    int getScrollY();

    Bundle getSdkQBStatisticsInfo();

    String getSelectionText();

    IX5WebSettingsExtension getSettingsExtension();

    int getSharedVideoTime();

    Point getSinglePressPoint();

    int getSniffVideoID();

    String getSniffVideoRefer();

    boolean getSolarMode();

    int getTitleHeight();

    IX5WebChromeClient getWebChromeClient();

    IX5WebChromeClientExtension getWebChromeClientExtension();

    int getWebTextScrollDis();

    IX5WebViewClient getWebViewClient();

    IX5WebViewClientExtension getWebViewClientExtension();

    boolean inFullScreenMode();

    boolean inputNodeIsPasswordType();

    boolean inputNodeIsPhoneType();

    void invalidateContent();

    Object invokeMiscMethod(String str, Bundle bundle);

    boolean isActive();

    boolean isEditingMode();

    boolean isEnableSetFont();

    boolean isHorizontalScrollBarEnabled();

    boolean isMobileSite();

    boolean isPluginFullScreen();

    boolean isPreReadCanGoForward();

    boolean isSelectionMode();

    boolean isVerticalScrollBarEnabled();

    boolean isX5CoreSandboxMode();

    void leaveSelectionMode();

    void loadDataWithBaseURLWithHeaders(String str, String str2, String str3, String str4, String str5, Map<String, String> map);

    void loaddataWithHeaders(String str, String str2, String str3, Map<String, String> map);

    boolean needSniff();

    void onAppExit();

    void onFingerSearchResult(String str, int i3, int i16);

    void onPageTransFormationSettingChanged(boolean z16);

    void onPauseActiveDomObject();

    void onPauseNativeVideo();

    void onResumeActiveDomObject();

    void pasteText(CharSequence charSequence);

    void pauseAudio();

    void playAudio();

    void preConnectQProxy();

    void preLoad(String str, int i3, int i16, Map<String, String> map);

    void pruneMemoryCache();

    boolean registerEmbeddedWidget(String[] strArr, Object obj);

    void registerServiceWorkerBackground(String str, String str2);

    void registerServiceWorkerOffline(String str, List<String> list, boolean z16);

    void reloadCustomMetaData();

    void removeHistoryItem(int i3);

    void replaceAllInputText(String str);

    void replyListBox(int i3);

    void replyMultiListBox(int i3, boolean[] zArr);

    boolean requestFocusForInputNode(int i3);

    void retrieveFingerSearchContext(int i3);

    void savePageToDisk(String str, Message message);

    void savePageToDisk(String str, boolean z16, int i3, ValueCallback<String> valueCallback);

    void scrollBy(int i3, int i16);

    void scrollTo(int i3, int i16);

    int seletionStatus();

    void sendNeverRememberMsg(String str, String str2, String str3, Message message);

    void sendRememberMsg(String str, String str2, String str3, Message message);

    void sendRememberMsg(String str, String str2, String str3, String str4, String str5);

    void sendResumeMsg(String str, String str2, String str3, Message message);

    void setAudioAutoPlayNotify(boolean z16);

    void setBackFromSystem();

    void setDisableDrawingWhileLosingFocus(boolean z16);

    void setDrawWithBuffer(boolean z16);

    void setEmbTitleView(View view, ViewGroup.LayoutParams layoutParams);

    void setFakeLoginParams(Bundle bundle);

    void setForceEnableZoom(boolean z16);

    void setHandleViewBitmap(Bitmap bitmap, Bitmap bitmap2, int i3, int i16);

    void setHandleViewLineColor(int i3, int i16);

    void setHandleViewLineIsShowing(boolean z16, int i3);

    void setHandleViewSelectionColor(int i3, int i16);

    void setHorizontalScrollBarDrawable(Drawable drawable);

    void setHorizontalScrollBarEnabled(boolean z16);

    void setHorizontalTrackDrawable(Drawable drawable);

    void setIsForVideoSniff(boolean z16);

    void setLongPressTextExtensionMenu(int i3);

    void setOrientation(int i3);

    void setOverScrollParams(int i3, int i16, int i17, int i18, int i19, int i26, Drawable drawable, Drawable drawable2, Drawable drawable3);

    void setRenderMode(int i3);

    void setScreenState(int i3);

    void setScrollBarDefaultDelayBeforeFade(int i3);

    void setScrollBarFadeDuration(int i3);

    void setScrollBarFadingEnabled(boolean z16);

    void setScrollBarSize(int i3);

    void setScrollListener(IX5ScrollListener iX5ScrollListener);

    void setSelectListener(ISelectionInterface iSelectionInterface);

    void setSharedVideoTime(int i3);

    void setSniffVideoInfo(String str, int i3, String str2, String str3);

    void setTextFieldInLongPressStatus(boolean z16);

    void setVerticalScrollBarDrawable(Drawable drawable);

    void setVerticalScrollBarEnabled(boolean z16);

    void setVerticalTrackDrawable(Drawable drawable);

    void setWebBackForwardListClient(IX5WebBackForwardListClient iX5WebBackForwardListClient);

    void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension);

    void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension);

    boolean shouldFitScreenLayout();

    void showImage(int i3, int i16);

    Drawable snapshot(int i3, boolean z16);

    void snapshotVisible(Bitmap bitmap, boolean z16, boolean z17, boolean z18, boolean z19, float f16, float f17, Runnable runnable);

    void snapshotVisible(Canvas canvas, boolean z16, boolean z17, boolean z18, boolean z19);

    void snapshotWholePage(Canvas canvas, boolean z16, boolean z17);

    void snapshotWholePage(Canvas canvas, boolean z16, boolean z17, Runnable runnable);

    void stopPreLoad(String str);

    void trimMemory(int i3);

    void unRegisterServiceWorker(String str, boolean z16);

    void updateContext(Context context);

    void updateImageList(int i3, int i16, boolean z16);

    void updateSelectionPosition();

    void updateServiceWorkerBackground(String str);

    void waitSWInstalled(String str, Message message);

    @Deprecated
    Drawable wrapDrawableWithNativeBitmap(Drawable drawable, int i3, Bitmap.Config config);
}
