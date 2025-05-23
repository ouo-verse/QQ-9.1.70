package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.minigame.ui.a;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@JsPlugin
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqmini/minigame/plugins/GameGroupJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "", h.F, "(Landroid/app/Activity;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;[Ljava/lang/String;)V", "f", "(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;[Ljava/lang/String;)V", "", "errCode", "Lorg/json/JSONObject;", "e", "jsonParams", "g", "(Ljava/lang/String;)[Ljava/lang/String;", "joinGroupByTags", "", "d", "Z", "mJoinGroupConfirming", "<init>", "()V", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GameGroupJsPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mJoinGroupConfirming;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "isSuccess", "", "result", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onReceiveResult"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class b implements AsyncResult {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346596b;

        b(RequestEvent requestEvent) {
            this.f346596b = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
            QMLog.i("GameGroupJsPlugin", "joinGroupByTags: succeed=" + z16 + ", result=" + jSONObject);
            if (z16) {
                int optInt = jSONObject.optInt("retCode", 68503);
                if (optInt == 0) {
                    this.f346596b.ok();
                    return;
                } else {
                    this.f346596b.fail(GameGroupJsPlugin.this.e(optInt), null);
                    return;
                }
            }
            this.f346596b.fail(GameGroupJsPlugin.this.e(68503), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject e(int errCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errCode", errCode);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MiniAppInfo appInfo, RequestEvent req, String[] tags) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            channelProxy.joinGroupByTags(appInfo.appId, tags, new b(req));
        }
    }

    private final String[] g(String jsonParams) {
        boolean z16;
        if (jsonParams != null && jsonParams.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(jsonParams).getJSONArray("groupTags");
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String string = jSONArray.getString(i3);
                Intrinsics.checkExpressionValueIsNotNull(string, "tagsJSONArray.getString(i)");
                arrayList.add(string);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (JSONException unused) {
            return null;
        }
    }

    private final void h(final Activity activity, final MiniAppInfo appInfo, final RequestEvent req, final String[] tags) {
        if (this.mJoinGroupConfirming) {
            req.fail(e(68501), null);
        } else {
            this.mJoinGroupConfirming = true;
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.GameGroupJsPlugin$showJoinGroupConfirmDialog$1

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqmini/minigame/plugins/GameGroupJsPlugin$showJoinGroupConfirmDialog$1$a", "Lcom/tencent/qqmini/minigame/ui/a$a;", "", "isAllowed", "", "onResult", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
                /* loaded from: classes23.dex */
                public static final class a implements a.InterfaceC9395a {
                    a() {
                    }

                    @Override // com.tencent.qqmini.minigame.ui.a.InterfaceC9395a
                    public void onResult(boolean isAllowed) {
                        String str;
                        GameGroupJsPlugin.this.mJoinGroupConfirming = false;
                        if (!isAllowed) {
                            GameGroupJsPlugin$showJoinGroupConfirmDialog$1 gameGroupJsPlugin$showJoinGroupConfirmDialog$1 = GameGroupJsPlugin$showJoinGroupConfirmDialog$1.this;
                            req.fail(GameGroupJsPlugin.this.e(68502), null);
                            return;
                        }
                        MiniAppInfo miniAppInfo = appInfo;
                        if (isAllowed) {
                            str = "minigame_join_group_popwindow_confirm";
                        } else {
                            str = "minigame_join_group_popwindow_cancel";
                        }
                        SDKMiniProgramLpReportDC04239.reportPageView(miniAppInfo, "1", null, "em_click", str);
                        GameGroupJsPlugin$showJoinGroupConfirmDialog$1 gameGroupJsPlugin$showJoinGroupConfirmDialog$12 = GameGroupJsPlugin$showJoinGroupConfirmDialog$1.this;
                        GameGroupJsPlugin.this.f(appInfo, req, tags);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (!activity.isDestroyed() && !activity.isFinishing()) {
                        com.tencent.qqmini.minigame.ui.a aVar = new com.tencent.qqmini.minigame.ui.a(activity);
                        aVar.O(appInfo, new a());
                        aVar.show();
                        SDKMiniProgramLpReportDC04239.reportPageView(appInfo, "1", null, "em_expo", "minigame_join_group_popwindow");
                        return;
                    }
                    req.fail(GameGroupJsPlugin.this.e(68504), null);
                }
            });
        }
    }

    @JsEvent({"joinGroupByTags"})
    public final void joinGroupByTags(@NotNull RequestEvent req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        QMLog.i("GameGroupJsPlugin", "joinGroupByTags: " + req.jsonParams);
        String[] g16 = g(req.jsonParams);
        if (g16 == null) {
            req.fail(e(68500), null);
            return;
        }
        IMiniAppContext mMiniAppContext = this.mMiniAppContext;
        Intrinsics.checkExpressionValueIsNotNull(mMiniAppContext, "mMiniAppContext");
        Activity attachActivity = mMiniAppContext.getAttachActivity();
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (attachActivity != null && miniAppInfo != null) {
            h(attachActivity, miniAppInfo, req, g16);
        } else {
            req.fail(e(68504), null);
        }
    }
}
