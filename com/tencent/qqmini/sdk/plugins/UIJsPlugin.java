package com.tencent.qqmini.sdk.plugins;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.UiJsProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class UIJsPlugin extends BaseJsPlugin {
    public static final String EVENT_GET_MENU_BUTTON_RECT = "getMenuButtonBoundingClientRect";
    public static final String EVENT_HIDE_HOME_BUTTON = "hideHomeButton";
    public static final String EVENT_HIDE_LOADING = "hideLoading";
    public static final String EVENT_HIDE_TOAST = "hideToast";
    public static final String EVENT_INSERT_TEXTAREA = "insertTextArea";
    public static final String EVENT_REMOVE_TEXTAREA = "removeTextArea";
    public static final String EVENT_SHOW_LOADING = "showLoading";
    public static final String EVENT_SHOW_MODAL = "showModal";
    public static final String EVENT_SHOW_TOAST = "showToast";
    public static final String EVENT_UPDATE_TEXTAREA = "updateTextArea";
    private static final String TAG = "UIJsPlugin";
    private ToastView loadingView;
    private String mLastPage;
    private ToastView toastView;

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "hideLoadingView LoadingView=" + this.loadingView);
        }
        ToastView toastView = this.loadingView;
        if (toastView != null && toastView.shown()) {
            this.loadingView.hide();
            this.loadingView.onViewDestroy();
            this.loadingView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideToastView() {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "hideToastView toastView=" + this.toastView);
        }
        ToastView toastView = this.toastView;
        if (toastView != null && toastView.shown()) {
            this.toastView.hide();
            this.toastView.onViewDestroy();
            this.toastView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLastPageValid(String str) {
        if (!this.mIsMiniGame && !this.mIsContainer && str == null) {
            return false;
        }
        return true;
    }

    @JsEvent({"insertTextArea", EVENT_UPDATE_TEXTAREA, EVENT_REMOVE_TEXTAREA, "getMenuButtonBoundingClientRect"})
    public String doInterceptJsEvent(RequestEvent requestEvent) {
        if (!this.mIsMiniGame && "getMenuButtonBoundingClientRect".equals(requestEvent.event)) {
            return (String) this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 3));
        }
        return (String) this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 2));
    }

    @JsEvent({"hideHomeButton"})
    public void hideHomeButton(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.UIJsPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                if (((BaseJsPlugin) UIJsPlugin.this).mIsMiniGame) {
                    ShareState obtain = GetShareState.obtain(((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext);
                    if (obtain != null) {
                        obtain.showRestart = false;
                        requestEvent.ok();
                        return;
                    } else {
                        requestEvent.fail();
                        return;
                    }
                }
                if (PageAction.obtain(((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext).getPageUrl() != null) {
                    ShareState obtain2 = GetShareState.obtain(((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext);
                    if (obtain2 != null) {
                        obtain2.showRestart = false;
                    }
                    requestEvent.ok();
                    return;
                }
                requestEvent.fail();
            }
        });
    }

    @JsEvent({EVENT_HIDE_LOADING})
    public void hideLoading(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.UIJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                if (UIJsPlugin.this.loadingView != null && UIJsPlugin.this.loadingView.shown()) {
                    if (UIJsPlugin.this.loadingView != null) {
                        UIJsPlugin.this.loadingView.hide();
                        UIJsPlugin.this.loadingView.onViewDestroy();
                        UIJsPlugin.this.loadingView = null;
                    }
                    requestEvent.ok();
                    return;
                }
                requestEvent.fail("toast can't be found");
            }
        });
    }

    @JsEvent({EVENT_HIDE_TOAST})
    public void hideToast(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.UIJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                IPage page;
                if (((BaseJsPlugin) UIJsPlugin.this).mIsContainer && (page = ((BaseRuntime) ((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext).getPage(requestEvent.webViewId)) != null && page.hideLoading()) {
                    QMLog.d(UIJsPlugin.TAG, "hide loading consumed by container");
                    requestEvent.ok();
                }
                if (UIJsPlugin.this.toastView != null && UIJsPlugin.this.toastView.shown()) {
                    if (UIJsPlugin.this.toastView != null) {
                        UIJsPlugin.this.toastView.hide();
                        UIJsPlugin.this.toastView.onViewDestroy();
                        UIJsPlugin.this.toastView = null;
                    }
                    requestEvent.ok();
                    return;
                }
                requestEvent.fail("toast can't be found");
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        hideToastView();
        hideLoadingView();
    }

    @JsEvent({EVENT_SHOW_LOADING})
    public void showLoading(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.UIJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WeakReference weakReference = new WeakReference(((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext.getAttachActivity());
                    if (weakReference.get() != null && !((Activity) weakReference.get()).isFinishing()) {
                        JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                        String optString = jSONObject.optString("title", "");
                        boolean optBoolean = jSONObject.optBoolean("mask", false);
                        UIJsPlugin uIJsPlugin = UIJsPlugin.this;
                        if (uIJsPlugin.isLastPageValid(uIJsPlugin.mLastPage)) {
                            UIJsPlugin.this.hideLoadingView();
                        }
                        UIJsPlugin uIJsPlugin2 = UIJsPlugin.this;
                        uIJsPlugin2.mLastPage = PageAction.obtain(((BaseJsPlugin) uIJsPlugin2).mMiniAppContext).getPageUrl();
                        UIJsPlugin uIJsPlugin3 = UIJsPlugin.this;
                        if (uIJsPlugin3.isLastPageValid(uIJsPlugin3.mLastPage)) {
                            UIJsPlugin.this.loadingView = new ToastView((Context) weakReference.get(), (ViewGroup) ((Activity) weakReference.get()).findViewById(R.id.content));
                            UIJsPlugin.this.loadingView.show(1, ToastView.ICON_LOADING, null, optString, -1, optBoolean);
                            requestEvent.ok();
                            return;
                        }
                        QMLog.w(UIJsPlugin.TAG, "showLoading event=" + requestEvent.event + "\uff0c top page not found");
                        requestEvent.fail();
                        return;
                    }
                    QMLog.w(UIJsPlugin.TAG, "showLoading(). Do nothing, activity is null or finishing");
                } catch (JSONException e16) {
                    Log.e(UIJsPlugin.TAG, e16.getMessage(), e16);
                }
            }
        });
    }

    @JsEvent({EVENT_SHOW_MODAL})
    public void showModal(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.UIJsPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                if (((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext.getAttachActivity() != null && !((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext.getAttachActivity().isFinishing()) {
                    ((UiJsProxy) ProxyManager.get(UiJsProxy.class)).showModal(((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext.getAttachActivity(), requestEvent);
                }
            }
        });
    }

    @JsEvent({EVENT_SHOW_TOAST})
    public void showToast(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("title", "");
            final int optInt = jSONObject.optInt("duration", 1500);
            final boolean optBoolean = jSONObject.optBoolean("mask", false);
            final String optString2 = jSONObject.optString("icon", "success");
            final String optString3 = jSONObject.optString("image", "");
            final boolean equals = ToastView.ICON_LOADING.equals(optString2);
            final boolean optBoolean2 = jSONObject.optBoolean("custom", true);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.UIJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    WeakReference weakReference = new WeakReference(((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext.getAttachActivity());
                    if (weakReference.get() != null && !((Activity) weakReference.get()).isFinishing()) {
                        if (((BaseJsPlugin) UIJsPlugin.this).mIsContainer && equals && optBoolean2) {
                            IPage page = ((BaseRuntime) ((BaseJsPlugin) UIJsPlugin.this).mMiniAppContext).getPage(requestEvent.webViewId);
                            if (page != null && page.showLoading()) {
                                requestEvent.ok();
                                return;
                            } else if (page == null) {
                                requestEvent.fail("page not found");
                                return;
                            } else {
                                requestEvent.fail("page show loading failed");
                                return;
                            }
                        }
                        UIJsPlugin uIJsPlugin = UIJsPlugin.this;
                        if (uIJsPlugin.isLastPageValid(uIJsPlugin.mLastPage)) {
                            UIJsPlugin.this.hideToastView();
                        }
                        UIJsPlugin uIJsPlugin2 = UIJsPlugin.this;
                        uIJsPlugin2.mLastPage = PageAction.obtain(((BaseJsPlugin) uIJsPlugin2).mMiniAppContext).getPageUrl();
                        UIJsPlugin uIJsPlugin3 = UIJsPlugin.this;
                        if (uIJsPlugin3.isLastPageValid(uIJsPlugin3.mLastPage)) {
                            UIJsPlugin.this.toastView = new ToastView((Context) weakReference.get(), (ViewGroup) ((Activity) weakReference.get()).findViewById(R.id.content));
                            UIJsPlugin.this.toastView.show(0, optString2, optString3, optString, optInt, optBoolean);
                            requestEvent.ok();
                            return;
                        }
                        QMLog.w(UIJsPlugin.TAG, "showToast event=" + requestEvent.event + "\uff0c top page not found");
                        requestEvent.fail();
                        return;
                    }
                    QMLog.w(UIJsPlugin.TAG, "showToast(). Do nothing, activity is null or finishing");
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, e16.getMessage(), e16);
        }
    }
}
