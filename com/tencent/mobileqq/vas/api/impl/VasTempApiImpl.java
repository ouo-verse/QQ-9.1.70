package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.activity.aio.vasbubble.BubbleTextColorManage;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.vas.BalanceExplainDialogData;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.gift.BalanceExplainDialogHelper;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017J,\u0010\u0019\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016JJ\u0010 \u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0013H\u0016J\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0003\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasTempApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasTempApi;", "Lkotlin/Function0;", "", "block", "requestPagDownload", "", "initPagSo", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/BalanceExplainDialogData;", "data", "showCoinExplainDialog", "Landroid/content/DialogInterface$OnClickListener;", "onClickListener", "Ljava/lang/Runnable;", "defaultRunnable", "showNotEnoughExplainDialog", "isTabletDevice", "", "uin", "path", "", "effectId", "uinType", "setCustomChatBackground", "id", "friendUin", "name", "url", "feetype", "entryType", "setChatBackground", "type", "saveFont", "themeId", "setThemeAndBackGround", "isDisable", "prepareForProtect", "afterForProtect", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasTempApiImpl implements IVasTempApi {

    @NotNull
    private static final String PAG_CRASH_PROTECT = "disable_when_crash";

    @NotNull
    private static final String PAG_SO_NAME = "libpag.so";

    @NotNull
    private static final String TAG = "VasTempApiImpl";

    public final void afterForProtect() {
        if (Build.VERSION.SDK_INT != 24) {
            return;
        }
        VasMMKV.INSTANCE.getPagView().encodeBool(PAG_CRASH_PROTECT, false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    public boolean initPagSo() {
        IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_PAG;
        if (!iAEResUtil.isAEResExist(aEResInfo)) {
            QLog.i(PagViewProxy.INSTANCE.getTAG(), 1, "Pag_so\u5e93,\u672a\u4e0b\u8f7d\u5b8c\u6210");
            return false;
        }
        if (isDisable()) {
            QLog.w(PagViewProxy.INSTANCE.getTAG(), 1, "pag\u5e93,\u5728\u6b64\u7528\u6237\u673a\u578b\u4e0a\u53d1\u751f\u8fc7native-crash\uff0c\u56e0\u6b64\u8fdb\u884c\u4e86\u5c4f\u853d");
            return false;
        }
        try {
            prepareForProtect();
            int loadLibrary = VasSoUtils.loadLibrary(((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResUnzipFinalPath(aEResInfo.agentType), "libpag.so");
            if (loadLibrary != 0) {
                if (loadLibrary != 1) {
                    if (loadLibrary == 2) {
                        QLog.e(PagViewProxy.INSTANCE.getTAG(), 1, "\u521d\u59cb\u5316Pag_so\u5e93,\u52a0\u8f7d\u5f02\u5e38");
                    }
                } else {
                    QLog.e(PagViewProxy.INSTANCE.getTAG(), 1, "\u521d\u59cb\u5316Pag_so\u5e93,\u4e0d\u5b58\u5728");
                }
                return false;
            }
            QLog.i(PagViewProxy.INSTANCE.getTAG(), 1, "\u521d\u59cb\u5316Pag_so\u5e93,\u5b8c\u6210");
            return true;
        } finally {
            afterForProtect();
        }
    }

    public final boolean isDisable() {
        if (Build.VERSION.SDK_INT != 24) {
            return false;
        }
        return VasMMKV.INSTANCE.getPagView().decodeBool(PAG_CRASH_PROTECT, false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    @RequiresApi(4)
    public boolean isTabletDevice(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual("tablet", cu.d("ro.build.characteristics"))) {
            QLog.i("VAS_GIFT", 1, "isTabletDevice systemProp: tablet");
            return true;
        }
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        return false;
    }

    public final void prepareForProtect() {
        if (Build.VERSION.SDK_INT != 24) {
            return;
        }
        VasMMKV.INSTANCE.getPagView().encodeBool(PAG_CRASH_PROTECT, true);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    public void requestPagDownload(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_PAG;
            if (iAEResUtil.isAEResExist(aEResInfo.agentType)) {
                QLog.i(PagViewProxy.INSTANCE.getTAG(), 1, "already download");
                block.invoke();
            } else {
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType, new b(block));
            }
        } catch (Throwable th5) {
            QLog.e(PagViewProxy.INSTANCE.getTAG(), 1, th5, new Object[0]);
            block.invoke();
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    public void saveFont(int id5, int type) {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ISVIPHandler iSVIPHandler = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        Object businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        if (businessHandler instanceof ISVIPHandler) {
            iSVIPHandler = (ISVIPHandler) businessHandler;
        }
        if (iSVIPHandler != null) {
            iSVIPHandler.setSelfFontInfo(id5, type);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    public void setChatBackground(@NotNull String id5, @Nullable String friendUin, @NotNull String path, @NotNull String name, @NotNull String url, int feetype, int uinType, int entryType) {
        String account;
        ChatBackgroundManager chatBackgroundManager;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i("setChatBackground", 1, "setBackground");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (account = peekAppRuntime.getAccount()) == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
        if (manager instanceof ChatBackgroundManager) {
            chatBackgroundManager = (ChatBackgroundManager) manager;
        } else {
            chatBackgroundManager = null;
        }
        if (chatBackgroundManager == null) {
            return;
        }
        chatBackgroundManager.z(account, friendUin, path, uinType);
        if (entryType != 999) {
            ReportController.o(null, "CliOper", "", "", "background", "bkground_replace", entryType, 0, "0", "0", "", "");
        }
        chatBackgroundManager.r(peekAppRuntime.getApplicationContext(), account);
        ThemeBackground.setThemeBackgroundPic(peekAppRuntime.getApplicationContext(), AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, account, path, url, id5, name, feetype, null, false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    public void setCustomChatBackground(@Nullable String uin, @Nullable String path, int effectId, int uinType) {
        String str;
        QLog.i("setCustomChatBackground", 1, "setBackground");
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            return;
        }
        AppRuntime peekAppRuntime = mobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        ThemeBackground.setThemeBackgroundPic(mobileQQ, AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, str, path, "", "", "", 0, null, false);
        ChatBackgroundUtil.setChatBackground(mobileQQ, str, uin, path, effectId, uinType);
        BubbleTextColorManage.d().h();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    public void setThemeAndBackGround(@NotNull String themeId) {
        ChatBackgroundManager chatBackgroundManager;
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ThemeUtil.setCurrentThemeIdVersion(peekAppRuntime, themeId, "20000000");
        ThemeUtil.setWeekLoopTheme(peekAppRuntime, null, null, 0L);
        String string = ThemeBackground.getSharedPreferences(peekAppRuntime.getApp(), peekAppRuntime.getAccount(), 0).getString(AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, "null");
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
        if (manager instanceof ChatBackgroundManager) {
            chatBackgroundManager = (ChatBackgroundManager) manager;
        } else {
            chatBackgroundManager = null;
        }
        if (chatBackgroundManager == null) {
            return;
        }
        String o16 = chatBackgroundManager.o(null);
        if (string != null && !Intrinsics.areEqual("null", string) && o16 != null && Intrinsics.areEqual(string, o16)) {
            chatBackgroundManager.z(peekAppRuntime.getAccount(), null, "null", -1);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    public void showCoinExplainDialog(@NotNull Context context, @NotNull BalanceExplainDialogData data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        BalanceExplainDialogHelper.g(context, data);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasTempApi
    public void showNotEnoughExplainDialog(@NotNull Context context, @NotNull DialogInterface.OnClickListener onClickListener, @NotNull Runnable defaultRunnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Intrinsics.checkNotNullParameter(defaultRunnable, "defaultRunnable");
        BalanceExplainDialogHelper.h(context, onClickListener, defaultRunnable);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasTempApiImpl$b", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "", "onAEDownloadFinish", "", "currentOffset", "totalLength", "onAEProgressUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f308548d;

        b(Function0<Unit> function0) {
            this.f308548d = function0;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int errorType) {
            if (!Intrinsics.areEqual(aeResInfo, AEResInfo.LIGHT_RES_PAG)) {
                return;
            }
            QLog.i(PagViewProxy.INSTANCE.getTAG(), 1, "onAEDownloadFinish : downloaded : " + downloaded + "errorType : " + errorType);
            this.f308548d.invoke();
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(@Nullable AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
