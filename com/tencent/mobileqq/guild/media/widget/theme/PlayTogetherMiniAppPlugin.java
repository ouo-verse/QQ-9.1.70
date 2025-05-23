package com.tencent.mobileqq.guild.media.widget.theme;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildMiniProgramApi;
import com.tencent.mobileqq.guild.data.GuildJumpBaseData;
import com.tencent.mobileqq.guild.data.GuildJumpData;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.AppAuthResult;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.cg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.util.UiThreadUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClassConstructor
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\f\u0010\f\u001a\u00020\u0002*\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/theme/PlayTogetherMiniAppPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "", "appId", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "", "currentTheme", "currentAppId", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", HippyTKDListViewAdapter.X, "", "canAuth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lorg/json/JSONObject;", "data", "Lcom/tencent/mobileqq/guild/data/d;", "jumpBean", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "theme", "u", "jsonParams", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "handler", BdhLogUtil.LogTag.Tag_Conn, "D", "alertStringRes", "G", "checkAppCanAuth", "getUserProfile", "jumpToGuild", "jumpToWebBrowser", "notifyAppAuthResult", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class PlayTogetherMiniAppPlugin extends BaseJsPlugin {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/widget/theme/PlayTogetherMiniAppPlugin$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/a;", "", "isSuccess", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.thirdapp.container.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f229954b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RequestEvent f229955c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f229956d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f229957e;

        b(String str, RequestEvent requestEvent, int i3, String str2) {
            this.f229954b = str;
            this.f229955c = requestEvent;
            this.f229956d = i3;
            this.f229957e = str2;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.a
        public void onResult(boolean isSuccess, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (isSuccess) {
                PlayTogetherMiniAppPlugin playTogetherMiniAppPlugin = PlayTogetherMiniAppPlugin.this;
                String appId = this.f229954b;
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                playTogetherMiniAppPlugin.A(appId, this.f229955c, this.f229956d, this.f229957e);
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("checkAppCanAuth: user can not start third app..");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.PlayTogetherMiniAppPlugin", 1, (String) it.next(), null);
            }
            PlayTogetherMiniAppPlugin playTogetherMiniAppPlugin2 = PlayTogetherMiniAppPlugin.this;
            String appId2 = this.f229954b;
            Intrinsics.checkNotNullExpressionValue(appId2, "appId");
            playTogetherMiniAppPlugin2.C(appId2, false, this.f229955c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(final String appId, final RequestEvent req, final int currentTheme, final String currentAppId) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.theme.k
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherMiniAppPlugin.B(PlayTogetherMiniAppPlugin.this, appId, req, currentTheme, currentAppId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(PlayTogetherMiniAppPlugin this$0, String appId, RequestEvent req, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.o(appId, req, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(String appId, boolean handler, RequestEvent req) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", appId);
        jSONObject.put("canAuth", handler);
        req.ok(jSONObject);
    }

    private final void D(final String appId, final RequestEvent req) {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, BaseApplication.getContext().getText(R.string.f1499413n), qBaseActivity.getString(R.string.f140850f3), qBaseActivity.getString(R.string.f1499613p), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PlayTogetherMiniAppPlugin.E(PlayTogetherMiniAppPlugin.this, appId, req, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    PlayTogetherMiniAppPlugin.F(PlayTogetherMiniAppPlugin.this, appId, req, dialogInterface, i3);
                }
            }).show();
        } else {
            QLog.d("QGMC.PlayTogetherMiniAppPlugin", 1, "checkAppCanAuth: activity is null, do nothing.");
            m(appId, false, req);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(PlayTogetherMiniAppPlugin this$0, String appId, RequestEvent req, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.m(appId, true, req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(PlayTogetherMiniAppPlugin this$0, String appId, RequestEvent req, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.m(appId, false, req);
    }

    private final void G(@StringRes int alertStringRes) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            QQToast.makeText(context, context.getString(alertStringRes), 0).show();
        }
    }

    private final void m(final String appId, final boolean canAuth, final RequestEvent req) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.theme.n
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherMiniAppPlugin.n(RequestEvent.this, appId, canAuth);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(RequestEvent req, String appId, boolean z16) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", appId);
        jSONObject.put("canAuth", z16);
        req.ok(jSONObject);
    }

    private final void o(String appId, RequestEvent req, int currentTheme, String currentAppId) {
        if (!com.tencent.mobileqq.guild.media.thirdapp.g.f229539a.c()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("checkAppCanAuth: user can not start third app..");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.PlayTogetherMiniAppPlugin", 1, (String) it.next(), null);
            }
            C(appId, false, req);
            return;
        }
        if (u(currentTheme, appId, req)) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("checkAppCanAuth: handle by other theme mode.");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QGMC.PlayTogetherMiniAppPlugin", 1, (String) it5.next(), null);
            }
            return;
        }
        if (TextUtils.isEmpty(currentAppId)) {
            QLog.d("QGMC.PlayTogetherMiniAppPlugin", 1, "checkAppCanAuth: current app is null.");
            m(appId, true, req);
        } else {
            if (!TextUtils.isEmpty(currentAppId) && TextUtils.equals(currentAppId, appId)) {
                QLog.d("QGMC.PlayTogetherMiniAppPlugin", 1, "checkAppCanAuth: current app is same.");
                com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f1499213l);
                m(appId, false, req);
                return;
            }
            D(appId, req);
        }
    }

    private final void p(JSONObject data, GuildJumpBaseData jumpBean) {
        jumpBean.k(data.optString("guild_id"));
        jumpBean.j(data.optString("channel_id"));
        jumpBean.l(data.optString("join_sign"));
        String optString = data.optString("main_source");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(PARAM_MAIN_SOURCE)");
        jumpBean.m(optString);
        String optString2 = data.optString("sub_source");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(PARAM_SUB_SOURCE)");
        jumpBean.o(optString2);
        String optString3 = data.optString("c2c_tiny_id");
        Intrinsics.checkNotNullExpressionValue(optString3, "data.optString(PARAM_C2C_TINY_ID)");
        jumpBean.i(optString3);
        String optString4 = data.optString("c2c_src_name");
        Intrinsics.checkNotNullExpressionValue(optString4, "data.optString(PARAM_C2C_SRC_NAME)");
        jumpBean.h(optString4);
    }

    private final boolean q(String appId, RequestEvent req) {
        com.tencent.mobileqq.guild.media.core.data.p h16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().h();
        if (h16 == null) {
            return false;
        }
        if (Intrinsics.areEqual(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a, h16.f228093a)) {
            G(R.string.f1496812y);
        } else {
            G(R.string.f1496712x);
        }
        C(appId, false, req);
        return true;
    }

    private final boolean r(final String appId, final RequestEvent req) {
        Integer value = com.tencent.mobileqq.guild.media.core.j.c().T().getValue();
        if (value != null && value.intValue() == 2 && com.tencent.mobileqq.guild.media.core.j.c().o()) {
            IGProVoiceSmobaGameRoomStateInfo roomInfo = com.tencent.mobileqq.guild.media.core.j.c().n().getRoomInfo();
            Intrinsics.checkNotNull(roomInfo);
            if (roomInfo.getRoomState() != 3) {
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                    DialogUtil.createCustomDialog(qBaseActivity, 230, null, BaseApplication.getContext().getString(R.string.f14936123), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.l
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            PlayTogetherMiniAppPlugin.s(PlayTogetherMiniAppPlugin.this, appId, req, dialogInterface, i3);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.m
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            PlayTogetherMiniAppPlugin.t(PlayTogetherMiniAppPlugin.this, appId, req, dialogInterface, i3);
                        }
                    }).show();
                    return true;
                }
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("handleAlertWithMediaPlay: handle by media play, but activity is null.");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGMC.PlayTogetherMiniAppPlugin", 1, (String) it.next(), null);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(PlayTogetherMiniAppPlugin this$0, String appId, RequestEvent req, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(req, "$req");
        if (!Intrinsics.areEqual(String.valueOf(com.tencent.mobileqq.guild.media.core.m.e(com.tencent.mobileqq.guild.media.core.j.c())), com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a) && !ch.h0(com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c())) && !ch.m0(com.tencent.mobileqq.guild.media.core.m.d(com.tencent.mobileqq.guild.media.core.j.c()))) {
            QQToast.makeText(this$0.mContext, BaseApplication.getContext().getString(R.string.f1496612w), 0).show();
            this$0.C(appId, false, req);
        } else {
            this$0.C(appId, true, req);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(PlayTogetherMiniAppPlugin this$0, String appId, RequestEvent req, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.C(appId, false, req);
        dialogInterface.dismiss();
    }

    private final boolean u(int theme, String appId, RequestEvent req) {
        if (q(appId, req)) {
            QLog.d("QGMC.PlayTogetherMiniAppPlugin", 1, "handleAlertWithOtherTheme: handle with media live.");
            return true;
        }
        if (r(appId, req)) {
            QLog.d("QGMC.PlayTogetherMiniAppPlugin", 1, "handleAlertWithOtherTheme: handle with media play.");
            return true;
        }
        QLog.e("QGMC.PlayTogetherMiniAppPlugin", 1, "handleAlertWithOtherTheme: can not handle status.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GuildJumpData jumpBean) {
        Intrinsics.checkNotNullParameter(jumpBean, "$jumpBean");
        ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).jumpToGuild(jumpBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(String str) {
        ((IGuildMiniProgramApi) QRoute.api(IGuildMiniProgramApi.class)).jumpToWebBrowser(str);
    }

    private final String x(RequestEvent requestEvent) {
        return "event: " + requestEvent.event + " | jsonParams: " + requestEvent.jsonParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(int i3, JSONObject jsonArgs) {
        AppAuthResult appAuthResult;
        Intrinsics.checkNotNullParameter(jsonArgs, "$jsonArgs");
        if (i3 == 0) {
            appAuthResult = com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.p.INSTANCE.a(jsonArgs);
        } else {
            appAuthResult = null;
        }
        com.tencent.mobileqq.guild.media.core.j.a().d0().W1(i3, appAuthResult);
    }

    private final JSONObject z(String jsonParams) {
        boolean z16;
        boolean z17 = false;
        if (jsonParams != null) {
            try {
                if (jsonParams.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            } catch (JSONException e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "handleJsRequest JSONException " + e16;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QGMC.PlayTogetherMiniAppPlugin", 1, (String) it.next(), e16);
                }
                return null;
            }
        }
        if (!z17) {
            return null;
        }
        return new JSONObject(jsonParams).optJSONObject("data");
    }

    @JsEvent({"checkAppCanAuth"})
    public final void checkAppCanAuth(@NotNull RequestEvent req) {
        String str;
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.PlayTogetherMiniAppPlugin", 1, "checkAppCanAuth " + x(req));
        JSONObject z16 = z(req.jsonParams);
        if (z16 == null) {
            return;
        }
        String appId = z16.optString("appId", "");
        IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
        if (thirdAppInfo != null) {
            str = thirdAppInfo.getAppId();
        } else {
            str = null;
        }
        String str2 = str;
        Integer value = com.tencent.mobileqq.guild.media.core.j.c().T().getValue();
        if (value == null) {
            value = 0;
        }
        int intValue = value.intValue();
        int optInt = z16.optInt("antiAddiction", 0);
        int optInt2 = z16.optInt("antiAddictionMode", 0);
        if (optInt == 1 && optInt2 == 0) {
            com.tencent.mobileqq.guild.media.core.j.a().d0().f1(new b(appId, req, intValue, str2), true);
        } else {
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            A(appId, req, intValue, str2);
        }
    }

    @JsEvent({"getUserProfile"})
    public final void getUserProfile(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.PlayTogetherMiniAppPlugin", 1, "getUserProfile " + x(req));
        String z16 = com.tencent.mobileqq.guild.media.core.j.a().d0().z1();
        String y16 = com.tencent.mobileqq.guild.media.core.j.a().d0().y1();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PhotoCategorySummaryInfo.AVATAR_URL, y16);
        jSONObject.put("name", z16);
        req.ok(jSONObject);
    }

    @JsEvent({"jumpToGuild"})
    public final void jumpToGuild(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("QGMC.PlayTogetherMiniAppPlugin", 1, "[jumpToGuild] " + x(req));
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            return;
        }
        final GuildJumpData guildJumpData = new GuildJumpData();
        p(optJSONObject, guildJumpData);
        guildJumpData.v(optJSONObject.optString("guild_icon"));
        guildJumpData.w(optJSONObject.optString("guild_name"));
        guildJumpData.u(optJSONObject.optString("guild_cover_url"));
        String optString = optJSONObject.optString("trace_id");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(PARAM_TRACE_ID)");
        guildJumpData.x(optString);
        String optString2 = optJSONObject.optString("pgin_source");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(PARAM_PGIN_SOURCE)");
        guildJumpData.n(optString2);
        if (guildJumpData.t()) {
            String str = "params is ilLegal, params = " + guildJumpData;
            req.fail(str);
            QLog.e("QGMC.PlayTogetherMiniAppPlugin", 1, str);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.theme.h
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherMiniAppPlugin.v(GuildJumpData.this);
            }
        });
        req.ok();
    }

    @JsEvent({"jumpToWebBrowser", "openWebBrowserPanel"})
    public final void jumpToWebBrowser(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.i("QGMC.PlayTogetherMiniAppPlugin", 1, "[jumpToWebBrowser] " + x(req));
        JSONObject optJSONObject = new JSONObject(req.jsonParams).optJSONObject("data");
        if (optJSONObject == null) {
            req.fail("data is invalid");
            QLog.i("QGMC.PlayTogetherMiniAppPlugin", 1, "[jumpToWebBrowser] data is null");
            return;
        }
        final String optString = optJSONObject.optString("url");
        if (!cg.f307525d.matcher(optString).matches()) {
            req.fail("url is invalid");
            QLog.i("QGMC.PlayTogetherMiniAppPlugin", 1, "[jumpToWebBrowser] url is invalid, url = " + optString);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.theme.j
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherMiniAppPlugin.w(optString);
            }
        });
        req.ok();
    }

    @JsEvent({"notifyAppAuthResult"})
    public final void notifyAppAuthResult(@NotNull RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QLog.d("QGMC.PlayTogetherMiniAppPlugin", 1, "notifyAppAuthResult " + x(req));
        final JSONObject z16 = z(req.jsonParams);
        if (z16 == null) {
            return;
        }
        final int optInt = z16.optInt("code", -1);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.theme.i
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherMiniAppPlugin.y(optInt, z16);
            }
        });
        req.ok();
    }
}
