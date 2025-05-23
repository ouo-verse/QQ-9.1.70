package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes34.dex */
public class AIOEntryPlugin extends BaseJsPlugin {
    @JsEvent({"hideMiniAIOEntrance"})
    public void hideMiniAIOEntrance(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.AIOEntryPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                IPage page;
                if (((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext.getAttachActivity() instanceof GameActivity1) {
                    ((GameActivity1) ((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext.getAttachActivity()).hideMiniAIOEntrance();
                } else if (((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext.getMiniAppInfo() != null && ((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext.getMiniAppInfo().isEngineTypeMiniApp() && (((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext instanceof BaseRuntime) && (page = ((BaseRuntime) ((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext).getPage()) != null) {
                    page.setMiniAIOEntranceVisible(false, null);
                }
                requestEvent.ok();
            }
        });
    }

    @JsEvent({"showMiniAIOEntrance"})
    public void showMiniAIOEntrance(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.AIOEntryPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    IPage page;
                    if (((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext.getAttachActivity() instanceof GameActivity1) {
                        z16 = ((GameActivity1) ((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext.getAttachActivity()).showMiniAIOEntrance(jSONObject);
                    } else {
                        if (((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext.getMiniAppInfo() != null && ((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext.getMiniAppInfo().isEngineTypeMiniApp() && (((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext instanceof BaseRuntime) && (page = ((BaseRuntime) ((BaseJsPlugin) AIOEntryPlugin.this).mMiniAppContext).getPage()) != null) {
                            page.setMiniAIOEntranceVisible(true, jSONObject);
                        }
                        z16 = false;
                    }
                    if (z16) {
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
