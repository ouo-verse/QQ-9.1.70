package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerServiceIPC;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/nativePlugins/t;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "addMarketEmoticonToFavorite", "<init>", "()V", "d", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class t extends BaseJsPlugin {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(long j3, String str, String str2, RequestEvent req, int i3) {
        Intrinsics.checkNotNullParameter(req, "$req");
        QLog.i("MarketEmoticonPlugin", 1, "addMarketEmoticonToFavorite, eId=" + str + ", epId=" + str2 + ", result=" + i3 + ", costTime=" + (System.currentTimeMillis() - j3));
        if (i3 != 0) {
            req.fail();
        } else {
            req.ok();
        }
    }

    @JsEvent({"addMarketEmoticonToFavorite"})
    public final void addMarketEmoticonToFavorite(final RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("MarketEmoticonPlugin", 1, "addMarketEmoticonToFavorite, begin");
        try {
            JSONObject jSONObject = new JSONObject(req.jsonParams).getJSONObject("data");
            final String optString = jSONObject.optString("emojiId");
            final String optString2 = jSONObject.optString("emojiPkgId");
            boolean optBoolean = jSONObject.optBoolean(UIJsPlugin.EVENT_SHOW_TOAST, true);
            if (QLog.isColorLevel()) {
                QLog.i("MarketEmoticonPlugin", 1, "addMarketEmoticonToFavorite, param=" + req.jsonParams);
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                final long currentTimeMillis = System.currentTimeMillis();
                ((IEmojiManagerServiceIPC) QRoute.api(IEmojiManagerServiceIPC.class)).addMarketEmoticonToFavorite(optString, optString2, optBoolean, new IEmojiManagerServiceIPC.AddMarketEmoticonToFavoriteCallback() { // from class: com.tencent.qqmini.nativePlugins.s
                    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerServiceIPC.AddMarketEmoticonToFavoriteCallback
                    public final void onResult(int i3) {
                        t.c(currentTimeMillis, optString, optString2, req, i3);
                    }
                });
                return;
            }
            QLog.w("MarketEmoticonPlugin", 1, "addMarketEmoticonToFavorite, invalid arguments, eid=" + optString + ", epId=" + optString2);
            req.fail();
        } catch (JSONException e16) {
            QLog.w("MarketEmoticonPlugin", 1, "addMarketEmoticonToFavorite, EXCEPTION, " + e16);
            req.fail();
        }
    }
}
