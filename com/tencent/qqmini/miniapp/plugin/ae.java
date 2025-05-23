package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes23.dex */
public class ae extends BaseJsPlugin {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(IPage iPage, RequestEvent requestEvent) {
        if (iPage.hideLoading()) {
            requestEvent.ok();
        } else {
            requestEvent.fail("page hide loading failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(IPage iPage, RequestEvent requestEvent) {
        if (iPage.showLoading()) {
            requestEvent.ok();
        } else {
            requestEvent.fail("page show loading failed");
        }
    }

    @JsEvent({"getSubPkgInfo"})
    public void getSubPkgType(RequestEvent requestEvent) {
        SubPkgInfo subPkgInfo;
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optJSONObject("data").optString("subPkgName");
            Iterator<SubPkgInfo> it = du3.s.x().y().getMiniAppInfo().subpkgs.iterator();
            while (true) {
                if (it.hasNext()) {
                    subPkgInfo = it.next();
                    if (subPkgInfo.subPkgName.equals(optString)) {
                        break;
                    }
                } else {
                    subPkgInfo = null;
                    break;
                }
            }
            if (subPkgInfo != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subPkgType", subPkgInfo.subVersionType);
                jSONObject.put("version", subPkgInfo.version);
                jSONObject.put("subPkgName", subPkgInfo.subPkgName);
                jSONObject.put("mainPackVersion", subPkgInfo.mainPackVersion);
                requestEvent.ok(jSONObject);
                return;
            }
            requestEvent.fail("not found " + optString);
        } catch (Exception e16) {
            e16.printStackTrace();
            requestEvent.fail(e16.getMessage());
        }
    }

    @JsEvent({"hideNativeLoading"})
    public void hideNativeLoading(final RequestEvent requestEvent) {
        final IPage page = ((BaseRuntime) this.mMiniAppContext).getPage(requestEvent.webViewId);
        if (page != null) {
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ae.d(IPage.this, requestEvent);
                }
            });
        } else {
            requestEvent.fail("page not found");
        }
    }

    @JsEvent({"showNativeLoading"})
    public void showNativeLoading(final RequestEvent requestEvent) {
        final IPage page = ((BaseRuntime) this.mMiniAppContext).getPage(requestEvent.webViewId);
        if (page != null) {
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ae.e(IPage.this, requestEvent);
                }
            });
        } else {
            requestEvent.fail("page not found");
        }
    }
}
