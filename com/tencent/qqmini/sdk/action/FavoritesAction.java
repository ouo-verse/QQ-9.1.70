package com.tencent.qqmini.sdk.action;

import android.os.Bundle;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class FavoritesAction implements Action<Boolean> {
    public static final int ADD_FAVORITES = 1;
    private Bundle data;
    private int what;

    private int getCurrPageId(IMiniAppContext iMiniAppContext) {
        return PageAction.obtain(iMiniAppContext).getPageId();
    }

    private String getCurrPageUrl(IMiniAppContext iMiniAppContext) {
        return PageAction.obtain(iMiniAppContext).getPageUrl();
    }

    private void handleAddFavorites(BaseRuntime baseRuntime, ShareState shareState) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (shareState.launchFrom == 1) {
                jSONObject.put("fromFavoritesButton", 1);
            } else {
                jSONObject.put("fromFavoritesButton", 0);
            }
            if (!baseRuntime.isMiniGame() && getCurrPageUrl(baseRuntime) != null) {
                jSONObject.put("webviewUrl", getCurrPageUrl(baseRuntime));
            }
        } catch (JSONException e16) {
            QMLog.e(Action.TAG, "on add favorite click exception ", e16);
        }
        IJsService jsService = baseRuntime.getJsService();
        if (jsService != null) {
            jsService.evaluateSubscribeJS(com.tencent.luggage.wxa.b7.a.NAME, jSONObject.toString(), getCurrPageId(baseRuntime));
        } else {
            QMLog.e(Action.TAG, "on add favorite click exception mGameJsPluginEngine == null");
        }
    }

    public static FavoritesAction obtain(int i3) {
        return obtain(i3, null);
    }

    public static FavoritesAction obtain(int i3, Bundle bundle) {
        FavoritesAction favoritesAction = new FavoritesAction();
        favoritesAction.what = i3;
        favoritesAction.data = bundle;
        return favoritesAction;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        ShareState shareState = baseRuntime.getShareState();
        if (shareState == null) {
            QMLog.e(Action.TAG, "Failed to perform " + this + ". shareState is null");
            return Boolean.FALSE;
        }
        if (baseRuntime.getPage() == null) {
            QMLog.e(Action.TAG, "Failed to perform " + this + ". page is null");
            return Boolean.FALSE;
        }
        if (this.what == 1) {
            handleAddFavorites(baseRuntime, shareState);
        }
        return Boolean.TRUE;
    }
}
