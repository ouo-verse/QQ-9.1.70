package com.tencent.qqmini.sdk.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import com.tencent.ark.ark;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncMultiObjResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.b;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+JD\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fH\u0002J0\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0002JB\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2 \u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\r0\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J0\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J*\u0010%\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fR\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqmini/sdk/manager/MiniGameUserAgreementManager;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "appId", "", "isSubscribe", "Lcom/tencent/qqmini/sdk/manager/c;", "data", "Landroid/content/DialogInterface;", "dialog", "Lkotlin/Function1;", "", "callback", "d", "Lkotlin/Function2;", "i", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "Lkotlin/Function3;", "l", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "g", "contentStr", "Landroid/content/Context;", "context", "", "Lcom/tencent/qqmini/sdk/manager/d;", "textData", "useExternalBrowser", "Landroid/text/SpannableString;", "e", h.F, "f", "j", "k", "", "a", "Ljava/util/Map;", "userAgreementDataMap", "<init>", "()V", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class MiniGameUserAgreementManager {

    /* renamed from: b, reason: collision with root package name */
    public static final MiniGameUserAgreementManager f348129b = new MiniGameUserAgreementManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Map<String, UserAgreementData> userAgreementDataMap = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "isSuccess", "", "result", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "onReceiveResult"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f348130a;

        a(Function2 function2) {
            this.f348130a = function2;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
            if (z16 && jSONObject != null) {
                UserAgreementData g16 = MiniGameUserAgreementManager.f348129b.g(jSONObject);
                Function2 function2 = this.f348130a;
                if (function2 != null) {
                    return;
                }
                return;
            }
            Function2 function22 = this.f348130a;
            if (function22 != null) {
            }
            QMLog.w("MiniGameUserAgreementManager", "requestUserAgreement fail isSuccess:" + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isSuccess", "", "resultObj", "", "dataJsonObj", "Lorg/json/JSONObject;", "onReceiveResult"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class b implements AsyncMultiObjResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UserAgreementData f348137a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3 f348138b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MiniAppInfo f348139c;

        b(UserAgreementData userAgreementData, Function3 function3, MiniAppInfo miniAppInfo) {
            this.f348137a = userAgreementData;
            this.f348138b = function3;
            this.f348139c = miniAppInfo;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncMultiObjResult
        public final void onReceiveResult(boolean z16, @Nullable Object obj, @Nullable JSONObject jSONObject) {
            if (z16 && obj != null) {
                if (this.f348137a.getIsSubscribe()) {
                    Function3 function3 = this.f348138b;
                    Boolean bool = Boolean.TRUE;
                    function3.invoke(bool, bool, (DialogInterface) obj);
                } else {
                    boolean z17 = false;
                    if (jSONObject != null) {
                        try {
                            z17 = jSONObject.optBoolean("isSubscribe");
                        } catch (Exception e16) {
                            QMLog.e("MiniGameUserAgreementManager", "showUserAgreementDialog exception:", e16);
                        }
                    }
                    this.f348138b.invoke(Boolean.TRUE, Boolean.valueOf(z17), (DialogInterface) obj);
                }
                MiniAppInfo miniAppInfo = this.f348139c;
                SDKMiniProgramLpReportDC04239.report(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "page_view", "em_click", "minigame_service_agreement_panel", "", "", "", "1", "");
                return;
            }
            Function3 function32 = this.f348138b;
            Boolean bool2 = Boolean.FALSE;
            function32.invoke(bool2, bool2, null);
            MiniAppInfo miniAppInfo2 = this.f348139c;
            SDKMiniProgramLpReportDC04239.report(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "page_view", "em_click", "minigame_service_agreement_panel", "", "", "", "2", "");
        }
    }

    MiniGameUserAgreementManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final Activity activity, final String appId, boolean isSubscribe, UserAgreementData data, final DialogInterface dialog, final Function1<? super Boolean, Unit> callback) {
        final ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        channelProxy.signMiniGameUserAgreement(appId, data.getVersion(), isSubscribe, new AsyncResult() { // from class: com.tencent.qqmini.sdk.manager.MiniGameUserAgreementManager$agreeUserAgreement$1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public final void onReceiveResult(final boolean z16, @Nullable JSONObject jSONObject) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.MiniGameUserAgreementManager$agreeUserAgreement$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Map map;
                        QMLog.d("MiniGameUserAgreementManager", "agreeUserAgreement isSucc:" + z16);
                        if (z16) {
                            dialog.dismiss();
                            MiniGameUserAgreementManager miniGameUserAgreementManager = MiniGameUserAgreementManager.f348129b;
                            map = MiniGameUserAgreementManager.userAgreementDataMap;
                            map.remove(appId);
                            MiniGameUserAgreementManager$agreeUserAgreement$1 miniGameUserAgreementManager$agreeUserAgreement$1 = MiniGameUserAgreementManager$agreeUserAgreement$1.this;
                            channelProxy.clearMiniGameUserAgreementData(appId);
                        } else {
                            MiniToast.makeText(activity, "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5", 0).show();
                        }
                        callback.invoke(Boolean.valueOf(z16));
                    }
                });
            }
        });
    }

    private final SpannableString e(String contentStr, Context context, List<UserAgreementLink> textData, boolean useExternalBrowser) {
        ArrayList arrayList = new ArrayList();
        for (UserAgreementLink userAgreementLink : textData) {
            arrayList.add(new b.c(userAgreementLink.getLinkText(), userAgreementLink.getUrl()));
        }
        return com.tencent.qqmini.sdk.manager.b.a(contentStr, context, useExternalBrowser, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserAgreementData g(JSONObject json) {
        boolean optBoolean = json.optBoolean("is_compulsory");
        String appid = json.optString("appid");
        String version = json.optString("version");
        boolean optBoolean2 = json.optBoolean("isSigned");
        String title = json.optString("title");
        String text = json.optString("text");
        boolean optBoolean3 = json.optBoolean("isSubscribe");
        JSONArray optJSONArray = json.optJSONArray("links");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                int i16 = length;
                String linkText = optJSONObject.optString("linkText");
                String url = optJSONObject.optString("url");
                Intrinsics.checkExpressionValueIsNotNull(linkText, "linkText");
                Intrinsics.checkExpressionValueIsNotNull(url, "url");
                arrayList.add(new UserAgreementLink(linkText, url));
                i3++;
                optJSONArray = optJSONArray;
                length = i16;
                optBoolean3 = optBoolean3;
                optBoolean2 = optBoolean2;
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(appid, "appid");
        Intrinsics.checkExpressionValueIsNotNull(version, "version");
        Intrinsics.checkExpressionValueIsNotNull(title, "title");
        Intrinsics.checkExpressionValueIsNotNull(text, "text");
        return new UserAgreementData(optBoolean, appid, version, optBoolean2, title, text, optBoolean3, arrayList);
    }

    private final void i(String appId, Function2<? super Boolean, ? super UserAgreementData, Unit> callback) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).queryMiniGameUserAgreement(appId, new a(callback));
    }

    private final void l(Activity activity, MiniAppInfo miniAppInfo, UserAgreementData data, Function3<? super Boolean, ? super Boolean, ? super DialogInterface, Unit> callback) {
        String str = miniAppInfo.appId;
        QMLog.d("MiniGameUserAgreementManager", "showUserAgreementDialog appId:" + str + ", data:" + data);
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).showMiniGameUserAgreementDialog(activity, str, data.getTitle(), e(data.getText(), activity, data.a(), true), com.tencent.qqmini.sdk.manager.b.c(), data.getIsSubscribe(), new b(data, callback, miniAppInfo));
        SDKMiniProgramLpReportDC04239.reportAsyncR9(miniAppInfo, "page_view", "em_expo", "minigame_service_agreement_panel", "", "", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(@NotNull String appId) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        QMLog.i("MiniGameUserAgreementManager", "initUserAgreementDataForSetting appId:" + appId);
        Object miniGameUserAgreementData = ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getMiniGameUserAgreementData(appId);
        if (miniGameUserAgreementData != null && (miniGameUserAgreementData instanceof UserAgreementData)) {
            userAgreementDataMap.put(appId, miniGameUserAgreementData);
        }
    }

    public final void h(@NotNull final String appId) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        boolean z16 = false;
        if (wnsConfigProxy != null) {
            z16 = wnsConfigProxy.getToggleEnableStatus("minigame_user_agreement", false);
        }
        QMLog.i("MiniGameUserAgreementManager", "requestUserAgreement enable:" + z16);
        if (!z16) {
            return;
        }
        i(appId, new Function2<Boolean, UserAgreementData, Unit>() { // from class: com.tencent.qqmini.sdk.manager.MiniGameUserAgreementManager$requestUserAgreement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, UserAgreementData userAgreementData) {
                invoke(bool.booleanValue(), userAgreementData);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17, @Nullable UserAgreementData userAgreementData) {
                Map map;
                QMLog.i("MiniGameUserAgreementManager", "requestUserAgreement rsp isSucc:" + z17 + ", data:" + userAgreementData);
                if (!z17 || userAgreementData == null) {
                    return;
                }
                MiniGameUserAgreementManager miniGameUserAgreementManager = MiniGameUserAgreementManager.f348129b;
                map = MiniGameUserAgreementManager.userAgreementDataMap;
                map.put(appId, userAgreementData);
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).saveMiniGameUserAgreementData(appId, userAgreementData);
            }
        });
    }

    public final boolean j(@NotNull String appId) {
        UserAgreementData userAgreementData;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        boolean z17 = false;
        if (userAgreementDataMap.containsKey(appId) && (userAgreementData = userAgreementDataMap.get(appId)) != null && userAgreementData.getIsCompulsory() && !userAgreementData.getIsSigned()) {
            if (userAgreementData.getText().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        QMLog.i("MiniGameUserAgreementManager", "shouldShowUserAgreement result:" + z17);
        return z17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.tencent.qqmini.sdk.manager.c, T] */
    public final void k(@NotNull final Activity activity, @NotNull MiniAppInfo miniAppInfo, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        final String appId = miniAppInfo.appId;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        if (userAgreementDataMap.containsKey(appId)) {
            objectRef.element = userAgreementDataMap.get(appId);
        }
        if (((UserAgreementData) objectRef.element) == null) {
            QMLog.d("MiniGameUserAgreementManager", "showUserAgreement data null");
            callback.invoke(Boolean.FALSE);
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(appId, "appId");
        if (!j(appId)) {
            QMLog.d("MiniGameUserAgreementManager", "showUserAgreement should show false");
            callback.invoke(Boolean.FALSE);
        } else {
            l(activity, miniAppInfo, (UserAgreementData) objectRef.element, new Function3<Boolean, Boolean, DialogInterface, Unit>() { // from class: com.tencent.qqmini.sdk.manager.MiniGameUserAgreementManager$showUserAgreement$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, DialogInterface dialogInterface) {
                    invoke(bool.booleanValue(), bool2.booleanValue(), dialogInterface);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(boolean z16, boolean z17, @Nullable DialogInterface dialogInterface) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("agree:");
                    sb5.append(z16);
                    sb5.append(", dialogInterface:");
                    sb5.append(dialogInterface != null);
                    QMLog.d("MiniGameUserAgreementManager", sb5.toString());
                    if (z16 && dialogInterface != null) {
                        MiniGameUserAgreementManager miniGameUserAgreementManager = MiniGameUserAgreementManager.f348129b;
                        Activity activity2 = activity;
                        String appId2 = appId;
                        Intrinsics.checkExpressionValueIsNotNull(appId2, "appId");
                        miniGameUserAgreementManager.d(activity2, appId2, z17, (UserAgreementData) objectRef.element, dialogInterface, callback);
                        return;
                    }
                    callback.invoke(Boolean.FALSE);
                }
            });
        }
    }
}
