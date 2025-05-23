package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes34.dex */
public class ColorNotePlugin extends BaseJsPlugin {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqmini.proxyimpl.ColorNotePlugin$2, reason: invalid class name */
    /* loaded from: classes34.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IColorNoteController f347343d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347344e;

        AnonymousClass2(IColorNoteController iColorNoteController, RequestEvent requestEvent) {
            this.f347343d = iColorNoteController;
            this.f347344e = requestEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            QQCustomDialog qQCustomDialog = new QQCustomDialog(((BaseJsPlugin) ColorNotePlugin.this).mMiniAppContext.getAttachActivity(), R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.f168275rx);
            qQCustomDialog.setMessage("\u662f\u5426\u5c06" + ((BaseJsPlugin) ColorNotePlugin.this).mMiniAppInfo.name + "\u6dfb\u52a0\u5230\u5f69\u7b7e\uff1f");
            qQCustomDialog.setPositiveButton("\u786e\u5b9a", new a());
            qQCustomDialog.setNegativeButton("\u53d6\u6d88", new b());
            qQCustomDialog.setCanceledOnTouchOutside(false);
            qQCustomDialog.show();
        }

        /* renamed from: com.tencent.qqmini.proxyimpl.ColorNotePlugin$2$a */
        /* loaded from: classes34.dex */
        class a implements DialogInterface.OnClickListener {

            /* renamed from: com.tencent.qqmini.proxyimpl.ColorNotePlugin$2$a$a, reason: collision with other inner class name */
            /* loaded from: classes34.dex */
            class C9402a implements a {
                C9402a() {
                }

                @Override // com.tencent.qqmini.proxyimpl.ColorNotePlugin.a
                public void a(boolean z16) {
                    QLog.d("ColorNotePlugin", 1, "onAddColorSign:" + z16);
                    if (z16) {
                        AnonymousClass2.this.f347344e.ok();
                    } else {
                        AnonymousClass2.this.f347344e.fail();
                    }
                }
            }

            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (dialogInterface != null) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception e16) {
                        QLog.e("ColorNotePlugin", 1, "show modalView error." + e16);
                        return;
                    }
                }
                AnonymousClass2.this.f347343d.insertColorNote();
                if (((BaseJsPlugin) ColorNotePlugin.this).mIsMiniGame) {
                    C9402a c9402a = new C9402a();
                    if (((BaseJsPlugin) ColorNotePlugin.this).mMiniAppContext.getAttachActivity() == null || !(((BaseJsPlugin) ColorNotePlugin.this).mMiniAppContext.getAttachActivity() instanceof GameActivity1)) {
                        return;
                    }
                    ((GameActivity1) ((BaseJsPlugin) ColorNotePlugin.this).mMiniAppContext.getAttachActivity()).setColorSignAddListener(c9402a);
                    return;
                }
                AnonymousClass2.this.f347344e.ok();
            }
        }

        /* renamed from: com.tencent.qqmini.proxyimpl.ColorNotePlugin$2$b */
        /* loaded from: classes34.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                AnonymousClass2.this.f347344e.fail();
            }
        }
    }

    /* loaded from: classes34.dex */
    public interface a {
        void a(boolean z16);
    }

    private void h(boolean z16, final RequestEvent requestEvent) {
        final IColorNoteController g16;
        if (this.mMiniAppInfo.isLimitedAccessApp()) {
            requestEvent.fail();
            return;
        }
        if (this.mIsMiniGame) {
            if (this.mMiniAppContext.getAttachActivity() != null && (this.mMiniAppContext.getAttachActivity() instanceof GameActivity1)) {
                g16 = ((GameActivity1) this.mMiniAppContext.getAttachActivity()).getColorNoteController();
            }
            g16 = null;
        } else {
            PageGestureProxy pageGestureProxy = (PageGestureProxy) AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
            if (pageGestureProxy instanceof at) {
                g16 = ((at) pageGestureProxy).g();
            }
            g16 = null;
        }
        if (g16 != null) {
            if (!g16.isColorNoteExist()) {
                if (!g16.canAddColorNote()) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ColorNotePlugin.4
                        @Override // java.lang.Runnable
                        public void run() {
                            g16.onCannotAdd();
                            requestEvent.fail();
                        }
                    });
                    return;
                } else if (z16) {
                    AppBrandTask.runTaskOnUiThread(new AnonymousClass2(g16, requestEvent));
                    return;
                } else {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ColorNotePlugin.3
                        @Override // java.lang.Runnable
                        public void run() {
                            g16.insertColorNote();
                            requestEvent.ok();
                        }
                    });
                    return;
                }
            }
            requestEvent.ok();
            return;
        }
        requestEvent.fail();
    }

    @JsEvent({"addRecentColorSign"})
    public void addRecentColorSign(final RequestEvent requestEvent) {
        String str;
        final IColorNoteController g16;
        if (this.mMiniAppInfo.isLimitedAccessApp()) {
            requestEvent.fail();
            return;
        }
        if (this.mIsMiniGame) {
            if (this.mMiniAppContext.getAttachActivity() != null && (this.mMiniAppContext.getAttachActivity() instanceof GameActivity1)) {
                g16 = ((GameActivity1) this.mMiniAppContext.getAttachActivity()).getColorNoteController();
                String str2 = "miniGamePath";
                try {
                    str2 = "miniGamePath" + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + new JSONObject(requestEvent.jsonParams).optString("query");
                } catch (JSONException e16) {
                    QLog.e("ColorNotePlugin", 1, "minigame addRecentColorSign get a JSONException:" + e16.toString());
                }
                ((GameActivity1) this.mMiniAppContext.getAttachActivity()).setColorNoteQueryPath(str2);
            }
            g16 = null;
        } else {
            PageGestureProxy pageGestureProxy = (PageGestureProxy) AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
            String str3 = "";
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                str3 = jSONObject.optString("path");
                str = str3 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + jSONObject.optString("query");
            } catch (JSONException e17) {
                QLog.e("ColorNotePlugin", 1, "miniapp addRecentColorSign get a JSONException:" + e17.toString());
                str = str3;
            }
            if (pageGestureProxy instanceof at) {
                at atVar = (at) pageGestureProxy;
                atVar.updateColorSignPath(str);
                g16 = atVar.g();
            }
            g16 = null;
        }
        if (g16 != null) {
            if (!((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).isRecentColorNoteTurnOn(BaseApplicationImpl.getApplication().getRuntime())) {
                requestEvent.fail("colorNoteSwitcher is turnOff!");
                return;
            }
            if (!g16.isColorNoteExist()) {
                if (!s.d(this.mContext)) {
                    requestEvent.fail("No floating window permission");
                    return;
                } else {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ColorNotePlugin.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g16.addToRecentNote();
                            requestEvent.ok();
                        }
                    });
                    return;
                }
            }
            requestEvent.fail("This page has been added by qq.addColorSign(), which cannot be added by the qq.recentColorSign() again.");
            return;
        }
        requestEvent.fail();
    }

    @JsEvent({PluginConst.OtherJsPluginConst.API_IS_COLOR_SIGN_EXIST})
    public String isColorSignExistSync(RequestEvent requestEvent) {
        IColorNoteController g16;
        new JSONObject();
        if (this.mIsMiniGame) {
            if (this.mMiniAppContext.getAttachActivity() != null && (this.mMiniAppContext.getAttachActivity() instanceof GameActivity1)) {
                g16 = ((GameActivity1) this.mMiniAppContext.getAttachActivity()).getColorNoteController();
            }
            g16 = null;
        } else {
            PageGestureProxy pageGestureProxy = (PageGestureProxy) AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
            if (pageGestureProxy instanceof at) {
                g16 = ((at) pageGestureProxy).g();
            }
            g16 = null;
        }
        if (g16 != null && g16.isColorNoteExist()) {
            return ApiUtil.wrapCallbackOk(requestEvent.event, null).toString();
        }
        return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
    }

    @JsEvent({"addColorSign"})
    public void addColorSign(RequestEvent requestEvent) {
        h(false, requestEvent);
    }

    @JsEvent({PluginConst.OtherJsPluginConst.API_ADD_COLOR_SIGN_DIRECTLY})
    public void addColorSignDirectly(RequestEvent requestEvent) {
        h(true, requestEvent);
    }
}
