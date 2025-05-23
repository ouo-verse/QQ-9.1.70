package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/nativePlugins/ae;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "openGuildUserProfile", "<init>", "()V", "d", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ae extends BaseJsPlugin {
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0126 A[Catch: JSONException -> 0x0150, TryCatch #0 {JSONException -> 0x0150, blocks: (B:17:0x0067, B:19:0x0077, B:21:0x0082, B:23:0x008d, B:24:0x009a, B:26:0x00ca, B:32:0x00d8, B:37:0x00e4, B:39:0x00f0, B:41:0x00ea, B:43:0x0106, B:45:0x0126, B:46:0x012f, B:47:0x0139, B:49:0x013f), top: B:16:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013f A[Catch: JSONException -> 0x0150, LOOP:1: B:47:0x0139->B:49:0x013f, LOOP_END, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0150, blocks: (B:17:0x0067, B:19:0x0077, B:21:0x0082, B:23:0x008d, B:24:0x009a, B:26:0x00ca, B:32:0x00d8, B:37:0x00e4, B:39:0x00f0, B:41:0x00ea, B:43:0x0106, B:45:0x0126, B:46:0x012f, B:47:0x0139, B:49:0x013f), top: B:16:0x0067 }] */
    @JsEvent({"openGuildUserProfile"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void openGuildUserProfile(RequestEvent req) {
        boolean z16;
        String str;
        Iterator<T> it;
        Intrinsics.checkNotNullParameter(req, "req");
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        Activity attachActivity = iMiniAppContext != null ? iMiniAppContext.getAttachActivity() : null;
        if (attachActivity == null) {
            req.fail("attached activity is null");
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "openGuildUserProfile failed req:" + req.jsonParams;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it5 = bVar.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("OpenGuildUserProfilePlugin", 1, (String) it5.next(), null);
            }
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
            String optString = optJSONObject != null ? optJSONObject.optString("guildId") : null;
            String optString2 = optJSONObject != null ? optJSONObject.optString("tinyId") : null;
            Integer valueOf = optJSONObject != null ? Integer.valueOf(optJSONObject.optInt("sceneType")) : null;
            Logger.f235387a.d().i("OpenGuildUserProfilePlugin", 1, "openGuildUserProfile, guildId: " + optString + ", tinyId: " + optString2 + " sceneType:" + valueOf);
            if (optString != null && optString.length() != 0) {
                z16 = false;
                if (!z16) {
                    if (!(optString2 == null || optString2.length() == 0)) {
                        if (valueOf == null || valueOf.intValue() == 0) {
                            valueOf = 11;
                        }
                        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildUserProfile(attachActivity, optString, optString2, 0, valueOf.intValue());
                        req.ok();
                        return;
                    }
                }
                req.fail("param error");
                Logger.b bVar2 = new Logger.b();
                str = "openGuildUserProfile failed req:" + req.jsonParams;
                if (str instanceof String) {
                    bVar2.a().add(str);
                }
                it = bVar2.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("OpenGuildUserProfilePlugin", 1, (String) it.next(), null);
                }
            }
            z16 = true;
            if (!z16) {
            }
            req.fail("param error");
            Logger.b bVar22 = new Logger.b();
            str = "openGuildUserProfile failed req:" + req.jsonParams;
            if (str instanceof String) {
            }
            it = bVar22.a().iterator();
            while (it.hasNext()) {
            }
        } catch (JSONException e16) {
            req.fail("attached activity is null");
            Logger logger2 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            String str3 = "openGuildUserProfile failed req:" + req.jsonParams;
            if (str3 instanceof String) {
                bVar3.a().add(str3);
            }
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("OpenGuildUserProfilePlugin", 1, (String) it6.next(), e16);
            }
        }
    }
}
