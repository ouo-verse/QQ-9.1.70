package com.tencent.mobileqq.vas.theme;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NightModeLogic {
    static final int MSG_CHANE_ERR = 4100;
    static final int MSG_COMPLETE_RSP = 1;
    static final int MSG_ERROR_RSP = -2;
    static final int MSG_NOTIFY_TO_UI = 4099;
    public static final int NIGHTMODE_ACTION_DOWNLOADING = 3;
    public static final int NIGHTMODE_ACTION_THEMESWITCH_END = 2;
    public static final int NIGHTMODE_ACTION_THEMESWITCH_START = 1;
    public static final int NIGHTMODE_STATUS_NIGHT = 1;
    public static final int NIGHTMODE_STATUS_NOT_NIGHT = 2;
    public static final int NIGHTMODE_STATUS_SWITCHING = 0;
    public static final String TAG = "NightModeLogic";
    private boolean blockScreenShot;
    private WeakReference<Activity> refActivity;
    ArrayList<NightModeCallback> callbacks = new ArrayList<>();
    ThemeSwitchCallback mThemeSwitchCallback = new ThemeSwitchCallback() { // from class: com.tencent.mobileqq.vas.theme.NightModeLogic.1
        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public boolean beforeSwitch(ThemeLocator themeLocator) {
            if (!NightModeLogic.this.blockScreenShot) {
                NightModeLogic.this.themeSwitchManager.doScreenShot();
                return false;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public void beginSwitch() {
            Activity activity;
            if (NightModeLogic.this.refActivity == null) {
                activity = null;
            } else {
                activity = (Activity) NightModeLogic.this.refActivity.get();
            }
            if (activity != null) {
                NightModeLogic.this.themeSwitchManager.openSwitchDialog(activity);
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public void onProgress(long j3, long j16) {
            int i3;
            if (j16 <= 0) {
                QLog.e(NightModeLogic.TAG, 1, "mThemeDownloadListener onDownloadProgress dwProgressMax <= 0");
                i3 = 4;
            } else {
                i3 = 100;
            }
            if (j3 <= j16) {
                i3 = (int) ((j3 * 100.0d) / j16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(NightModeLogic.TAG, 2, "mThemeDownloadListener onDownloadProgress readSize:" + j3 + ", allSize:" + j16 + ", percent:" + i3);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("percent", i3);
            bundle.putInt("start_status", 3);
            Handler handler = NightModeLogic.this.mUiHandler;
            handler.sendMessage(Message.obtain(handler, 4099, 1, 0, bundle));
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public boolean postSwitch(int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("start_status", 2);
            if (i3 == 0) {
                Handler handler = NightModeLogic.this.mUiHandler;
                handler.sendMessage(Message.obtain(handler, 4099, 1, 0, bundle));
            } else {
                NightModeLogic.this.themeSwitchManager.clearOnErr(i3);
                NightModeLogic.this.mUiHandler.sendEmptyMessage(4100);
                Handler handler2 = NightModeLogic.this.mUiHandler;
                handler2.sendMessage(Message.obtain(handler2, 4099, -2, 0, bundle));
            }
            return super.postSwitch(i3);
        }
    };
    Handler mUiHandler = new a(Looper.getMainLooper());
    IThemeSwitchManager themeSwitchManager = VasUtil.getService().getThemeSwitchManager();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface NightModeCallback {
        void onRespComplete(Bundle bundle);

        void onRespError(Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MobileQQ mobileQQ;
            int i3 = message.what;
            if (i3 != 4099) {
                if (i3 == 4100 && (mobileQQ = MobileQQ.sMobileQQ) != null) {
                    QQToast.makeText(mobileQQ, HardCodeUtil.qqStr(R.string.orq), 4000).show();
                    VasLogReporter.getTheme().report(NightModeLogic.TAG + HardCodeUtil.qqStr(R.string.orq));
                    return;
                }
                return;
            }
            Object obj = message.obj;
            if (obj != null && (obj instanceof Bundle)) {
                NightModeLogic.this.notifyCallbacks(message.arg1, (Bundle) obj);
            }
        }
    }

    public NightModeLogic(AppRuntime appRuntime) {
        updateBlockScreenShotSwitch("constructor");
    }

    private void updateBlockScreenShotSwitch(String str) {
        this.blockScreenShot = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("night_mode_logic_block_screen_shot", false);
        QLog.i(TAG, 1, "updateBlockScreenShotSwitch from=" + str + ", blockScreenShot" + this.blockScreenShot);
    }

    public int getNightModeStatus() {
        if (isDownloadOrSwtich()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "switchRightViewImage status: juhua");
            }
            return 0;
        }
        if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime())) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "switchRightViewImage status: sun");
            }
            return 1;
        }
        if (!QLog.isColorLevel()) {
            return 2;
        }
        QLog.i(TAG, 2, "switchRightViewImage status: moon");
        return 2;
    }

    public boolean isDownloadOrSwtich() {
        boolean isSwitching = ThemeSwitcher.isSwitching();
        QLog.e(TAG, 1, "isDownloadOrSwtich: " + isSwitching);
        return isSwitching;
    }

    public void notifyCallbacks(int i3, Bundle bundle) {
        Iterator<NightModeCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            NightModeCallback next = it.next();
            if (1 == i3) {
                next.onRespComplete(bundle);
            } else if (-2 == i3) {
                next.onRespError(bundle);
            }
        }
    }

    public void onAccountChanged(AppRuntime appRuntime) {
        updateBlockScreenShotSwitch("onAccountChanged");
    }

    public void onPostThemeChanged() {
        this.themeSwitchManager.onPostThemeChanged();
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            ((ISimpleUIHandler) QRoute.api(ISimpleUIHandler.class)).onPostThemeChanged();
        }
    }

    public void registerModeCallbacks(NightModeCallback nightModeCallback, boolean z16) {
        if (nightModeCallback != null) {
            this.callbacks.remove(nightModeCallback);
            if (z16) {
                this.callbacks.add(nightModeCallback);
            }
        }
    }

    public boolean setupNightTheme() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setupNightTheme");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "setupNightTheme Err runtime == null");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("start_status", 1);
        notifyCallbacks(1, bundle);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(peekAppRuntime, false, null);
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        if (!isNowThemeIsNight) {
            if (simpleUISwitch) {
                str = "2920";
            } else {
                str = "1103";
            }
            ReportController.o(peekAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 1, 0, "", "", "", "");
        } else if (simpleUISwitch) {
            str = SimpleUIUtil.getThemeId(SimpleUIUtil.getSimpleNoNightUIPref());
        } else {
            Bundle previousThemeIdVersion = ThemeSwitchUtil.getPreviousThemeIdVersion(peekAppRuntime);
            String string = previousThemeIdVersion.getString("themeID");
            QLog.d(TAG, 1, "setupNightTheme, pre themeID=" + string + MttLoader.QQBROWSER_PARAMS_VERSION + previousThemeIdVersion.getString("version"));
            if (!TextUtils.isEmpty(string)) {
                str = string;
            } else {
                str = "1000";
            }
            ReportController.o(peekAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "", "", "", "");
        }
        QLog.d(TAG, 1, "setupNightTheme themeID=" + str);
        ThemeSwitcher.startSwitch(str, ThemeReporter.FROM_NIGHT, this.mThemeSwitchCallback);
        return true;
    }

    public void startNightMode(Activity activity) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "startNightMode Err runtime == null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startNightMode, isNightMode=" + ThemeUtil.isInNightMode(peekAppRuntime) + ", nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId(peekAppRuntime) + ", runtime=" + peekAppRuntime);
        }
        this.refActivity = new WeakReference<>(activity);
        boolean z16 = setupNightTheme();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "startNightMode result=" + z16);
        }
    }

    public void destroy() {
    }
}
