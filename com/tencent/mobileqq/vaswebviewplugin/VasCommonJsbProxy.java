package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\b\u0018\u0000 92\u00020\u0001:\u00019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ@\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ&\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015JH\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,J\u001e\u0010-\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0015J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010/\u001a\u00020\u0011J\"\u00100\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u00152\n\u00102\u001a\u0006\u0012\u0002\b\u000303J\u0016\u00104\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u00105\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u00106\u001a\u00020\u0011J\u001e\u00107\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "", "plugin", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;)V", "isWeakNet", "", "netStatusHandler", "com/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy$netStatusHandler$1", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy$netStatusHandler$1;", "getPlugin", "()Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "report", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "themeSetup", "Lcom/tencent/mobileqq/vaswebviewplugin/ThemeNewJsbPlugin;", "bubbleSetUp", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "", "id", "", "isVoice", "cardProfileGetInfo", "forceRequest", "callback", "Leipc/EIPCCallback;", "cardProfileSetUp", "layoutId", "", "backgroundId", "cardId", "extInfo", "diyTemplate", "cardSingleStepEndReport", "stage", QzoneIPCModule.RESULT_CODE, "chatBackgroundSetUp", "friendUin", "path", "name", "url", "feetype", "intent", "Landroid/content/Intent;", "fontSetUp", "type", "pageDestroy", GameCenterAPIJavaScript.QUERY_INFO, "itemId", "business", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "reportSetEndSetSuccess", "themeFontSetUp", "themePostChange", "themeSetUp", "themeId", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasCommonJsbProxy {
    public static final int DOWNLOADING = 2;
    public static final int Fail = 1;

    @NotNull
    public static final String JSON_KEY_SET_KEY = "setKey";

    @NotNull
    public static final String MESSAGE = "message";

    @NotNull
    public static final String RESULT = "result";

    @NotNull
    public static final String STATUS = "status";
    public static final int SUCCESS = 3;

    @NotNull
    public static final String TAG = "VasCommonJsbProxy";
    private volatile boolean isWeakNet;

    @NotNull
    private final VasCommonJsbProxy$netStatusHandler$1 netStatusHandler;

    @NotNull
    private final WebViewPlugin plugin;

    @NotNull
    private final VasJsbCommonReport report;

    @Nullable
    private ThemeNewJsbPlugin themeSetup;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean IS_NEW = VasNormalToggle.VAS_NEW_JSB_COMMON_SWITCH.isEnable(true);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy$Companion;", "", "()V", "DOWNLOADING", "", "Fail", "IS_NEW", "", "JSON_KEY_SET_KEY", "", "MESSAGE", "RESULT", CommonConstant.RETKEY.STATUS, "SUCCESS", "TAG", "createProxy", "Lcom/tencent/mobileqq/vaswebviewplugin/VasCommonJsbProxy;", "plugin", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final VasCommonJsbProxy createProxy(@NotNull WebViewPlugin plugin) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            if (VasCommonJsbProxy.IS_NEW) {
                VasCommonJsbProxy vasCommonJsbProxy = new VasCommonJsbProxy(plugin);
                vasCommonJsbProxy.themeSetup = new ThemeNewJsbPlugin(plugin);
                return vasCommonJsbProxy;
            }
            return null;
        }

        Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler, com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy$netStatusHandler$1] */
    public VasCommonJsbProxy(@NotNull WebViewPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.plugin = plugin;
        this.report = VasJsbCommonReport.INSTANCE;
        ?? r26 = new IWeakNetStatusHandler() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy$netStatusHandler$1
            @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
            public void onNormalToWeakNet(int weakReason) {
                QLog.i(VasCommonJsbProxy.TAG, 1, "onNormalToWeakNet: " + weakReason);
                VasCommonJsbProxy.this.isWeakNet = true;
            }

            @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
            public void onWeakNetToNormal(int lastWeakReason) {
                QLog.i(VasCommonJsbProxy.TAG, 1, "onWeakNetToNormal: " + lastWeakReason);
                VasCommonJsbProxy.this.isWeakNet = false;
            }
        };
        this.netStatusHandler = r26;
        AppNetConnInfo.registerWeakNetStatusHandler(BaseApplication.context, r26);
    }

    public final void bubbleSetUp(@NotNull String setKey, int id5, boolean isVoice) {
        String str;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (isVoice) {
            VipMMKV.INSTANCE.getCommon(str).encodeInt(AppConstants.Preferences.SVIP_BUBBLE_VOICE_PRINT_ID, id5);
        } else {
            VipMMKV.INSTANCE.getCommon(str).encodeInt(AppConstants.Preferences.SVIP_BUBBLE_ID, id5);
        }
        reportSetEndSetSuccess(setKey, String.valueOf(id5));
    }

    public final void cardProfileGetInfo(@NotNull String setKey, boolean forceRequest, @Nullable EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        VasUtil.getService().getJsbCallManager().getCardInfo(callback, forceRequest);
        VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(setKey);
        if (timeRecord == null) {
            return;
        }
        timeRecord.setSetupTime(System.currentTimeMillis());
    }

    public final void cardProfileSetUp(@NotNull String setKey, long layoutId, long backgroundId, long cardId, @NotNull String extInfo, @NotNull String diyTemplate, @Nullable EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        Intrinsics.checkNotNullParameter(diyTemplate, "diyTemplate");
        VasUtil.getService().getJsbCallManager().setProfileCard(layoutId, backgroundId, cardId, extInfo, diyTemplate, callback);
        VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(setKey);
        if (timeRecord == null) {
            return;
        }
        timeRecord.setSetupTime(System.currentTimeMillis());
    }

    public final void cardSingleStepEndReport(@NotNull String setKey, int id5, int stage, int resultCode) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(setKey);
        if (timeRecord == null) {
            return;
        }
        if (resultCode == 0) {
            this.report.reportSingleStepSuccess(setKey, String.valueOf(id5), System.currentTimeMillis() - timeRecord.getSetupTime(), stage);
            reportSetEndSetSuccess(setKey, String.valueOf(id5));
        } else {
            this.report.reportSingleStepFail(setKey, String.valueOf(id5), System.currentTimeMillis() - timeRecord.getSetupTime(), stage, resultCode);
            this.report.reportSetEndSetFail(setKey, String.valueOf(id5), System.currentTimeMillis() - timeRecord.getFirstQueryTime(), resultCode);
        }
    }

    public final void chatBackgroundSetUp(@NotNull String setKey, @NotNull String id5, @Nullable String friendUin, @NotNull String path, @NotNull String name, @NotNull String url, int feetype, @NotNull Intent intent) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            i3 = extras.getInt("uintype", 0);
        } else {
            i3 = 0;
        }
        Bundle extras2 = intent.getExtras();
        if (extras2 != null) {
            i16 = extras2.getInt("bg_replace_entrance", 999);
        } else {
            i16 = 999;
        }
        VasUtil.getService().getJsbCallManager().setChatBackground(id5, friendUin, path, name, url, feetype, i3, i16);
        reportSetEndSetSuccess(setKey, id5);
    }

    public final void fontSetUp(@NotNull String setKey, int id5, int type) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        VasUtil.getService().getJsbCallManager().saveFont(id5, type);
        reportSetEndSetSuccess(setKey, String.valueOf(id5));
    }

    @NotNull
    public final WebViewPlugin getPlugin() {
        return this.plugin;
    }

    /* renamed from: isWeakNet, reason: from getter */
    public final boolean getIsWeakNet() {
        return this.isWeakNet;
    }

    public final void pageDestroy() {
        this.report.reportAllPageDestroyTask();
        AppNetConnInfo.unRegisterWeakNetStatusHandler(this.netStatusHandler);
    }

    @NotNull
    public final String queryInfo(@NotNull final String setKey, final int itemId, @NotNull final QQVasUpdateBusiness<?> business) {
        boolean z16;
        boolean z17;
        IDownLoadListener iDownLoadListener;
        String errorMessage;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(business, "business");
        int i3 = 1;
        int i16 = 0;
        if (setKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e(TAG, 1, "setKey is null");
        }
        if (!TextUtils.isEmpty(setKey) && !this.report.getMSetKeyToStartTime().containsKey(setKey)) {
            VasJsbCommonReport.TimeRecord timeRecord = new VasJsbCommonReport.TimeRecord(setKey, System.currentTimeMillis(), String.valueOf(itemId), business.getBid());
            this.report.getMSetKeyToStartTime().put(setKey, timeRecord);
            this.report.reportFirstQuery(timeRecord);
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            final long currentTimeMillis = System.currentTimeMillis();
            iDownLoadListener = new IDownLoadListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy$queryInfo$1
                @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                public void onLoadFail(@NotNull UpdateListenerParams params) {
                    VasJsbCommonReport vasJsbCommonReport;
                    VasJsbCommonReport vasJsbCommonReport2;
                    VasJsbCommonReport vasJsbCommonReport3;
                    long j3;
                    Intrinsics.checkNotNullParameter(params, "params");
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    vasJsbCommonReport = this.report;
                    String str = setKey;
                    String valueOf = String.valueOf(itemId);
                    int i17 = params.mErrorCode;
                    int i18 = params.mHttpCode;
                    String str2 = params.mErrorMessage;
                    Intrinsics.checkNotNullExpressionValue(str2, "params.mErrorMessage");
                    vasJsbCommonReport.reportDownloadFail(str, valueOf, currentTimeMillis2, i17, i18, str2);
                    vasJsbCommonReport2 = this.report;
                    String str3 = setKey;
                    String valueOf2 = String.valueOf(itemId);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    vasJsbCommonReport3 = this.report;
                    VasJsbCommonReport.TimeRecord timeRecord2 = vasJsbCommonReport3.getMSetKeyToStartTime().get(setKey);
                    if (timeRecord2 != null) {
                        j3 = timeRecord2.getFirstQueryTime();
                    } else {
                        j3 = currentTimeMillis;
                    }
                    vasJsbCommonReport2.reportSetEndDownloadFail(str3, valueOf2, currentTimeMillis3 - j3, params.mErrorCode);
                }

                @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                public void onLoadSuccess(@NotNull UpdateListenerParams params) {
                    VasJsbCommonReport vasJsbCommonReport;
                    Intrinsics.checkNotNullParameter(params, "params");
                    if (business.isFileExists(itemId)) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        vasJsbCommonReport = this.report;
                        vasJsbCommonReport.reportDownloadSuccess(setKey, String.valueOf(itemId), currentTimeMillis2, business.getDownloadFileSize(itemId));
                    }
                }
            };
        } else {
            iDownLoadListener = null;
        }
        int a16 = com.tencent.mobileqq.webview.js.a.a(itemId, business, iDownLoadListener);
        VasJsbCommonReport.reportPreDownload(setKey, business, itemId, a16, z17, "jsbproxy");
        if (iDownLoadListener != null && a16 == 2) {
            this.report.setStartDownload(setKey);
        }
        JSONObject jSONObject = new JSONObject();
        String str = "";
        if (a16 != 2) {
            if (a16 == 3) {
                jSONObject.put("result", 0);
                jSONObject.put("message", "");
                jSONObject.put("status", a16);
            }
        } else {
            VasJsbCommonReport.TimeRecord timeRecord2 = this.report.getMSetKeyToStartTime().get(setKey);
            if (timeRecord2 != null) {
                i16 = timeRecord2.getErrorCode();
            }
            jSONObject.put("result", i16);
            VasJsbCommonReport.TimeRecord timeRecord3 = this.report.getMSetKeyToStartTime().get(setKey);
            if (timeRecord3 != null && (errorMessage = timeRecord3.getErrorMessage()) != null) {
                str = errorMessage;
            }
            jSONObject.put("message", str);
            if (i16 == 0) {
                i3 = a16;
            }
            jSONObject.put("status", i3);
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "result.toString()");
        return jSONObject2;
    }

    public final void reportSetEndSetSuccess(@NotNull String setKey, @NotNull String id5) {
        long j3;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(id5, "id");
        VasJsbCommonReport vasJsbCommonReport = this.report;
        long currentTimeMillis = System.currentTimeMillis();
        VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(setKey);
        if (timeRecord != null) {
            j3 = timeRecord.getFirstQueryTime();
        } else {
            j3 = 0;
        }
        vasJsbCommonReport.reportSetEndSetSuccess(setKey, id5, currentTimeMillis - j3);
    }

    public final void themeFontSetUp(@NotNull String setKey, int id5) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        VasUtil.getService().getVasThemeFontApi().switchFont(id5);
        reportSetEndSetSuccess(setKey, String.valueOf(id5));
    }

    public final void themePostChange() {
        ThemeNewJsbPlugin themeNewJsbPlugin = this.themeSetup;
        if (themeNewJsbPlugin != null) {
            themeNewJsbPlugin.postThemeChange();
        }
    }

    public final void themeSetUp(@NotNull String setKey, @NotNull String themeId, @NotNull String callback) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThemeNewJsbPlugin themeNewJsbPlugin = this.themeSetup;
        if (themeNewJsbPlugin != null) {
            themeNewJsbPlugin.setup(themeId, setKey, callback);
        }
    }
}
