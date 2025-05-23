package com.tencent.gamecenter.wadl.sdk.app;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gamecenter.wadl.api.IQQGameInstallService;
import com.tencent.gamecenter.wadl.biz.entity.ApkParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.receiver.GameInstallReceiver;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import mqq.app.MobileQQ;
import nl0.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlInstallActivity extends QPublicBaseFragment implements b, Handler.Callback {
    private static final int BUFFER_SIZE = 8388608;
    private static final int CODE_DO_DEFAULT_INSTALL = 0;
    private static final int CODE_INSTALL_SUCC = 3;
    private static final int CODE_INTERRUPT = 2;
    private static final int CODE_USER_CANCEL = 1;
    private static final int DELAY_TIME_500 = 500;
    private static final String INSTALL_DETAIL_HIPPY_PAGE = "mqqapi://hippy/open?src_type%3Dweb%26version%3D1%26bundleName%3DQQGameCenterV2%26url%3Dhttps%253A%252F%252Fplay.qq.com%252Fhippy-ssr%252Fv1%252Fapp%252Fgame-detail%253Fp_collections%253D%252526adtag%25253Dapp_monitoring%252526installedTip%25253D1%252526appid%25253D$GAME_APPID$%252526osVersion%25253D$OS_VERSION$%26isAnimated%3Dtrue%26isStatusBarDarkFont%3Dtrue";
    private static final String PARAMS_EXT_PARAMS = "ext_params";
    private static final String PARAMS_HARDCODER = "hardcoder";
    private static final String PARAMS_PKG_SIZE = "pkgsize";
    private static final String PARAMS_TIME = "time";
    private static final String PARAMS_TIMEOUT_ARRAY = "timeoutArray";
    public static final String TAG = "Installer_WadlInstallActivity";
    private static final int UNKNOW_SESSION_ID = -1;
    private static final int WHAT_ON_SESSION_FINISH = 2;
    private static final int WHAT_ON_TIMEOUT = 3;
    private static final int WHAT_UPDATE_PROGRESS = 1;
    private ApkParams apkParams;
    private TextView appNameView;
    private long fileSize;
    private int iconSize;
    private ImageView iconView;
    private long parseFileSize;
    private TextView pkgSizeView;
    private TextView progressView;
    private View rootView = null;
    private File apkFile = null;
    private boolean useHardCoder = false;
    private int currSessionId = -1;
    private int hardCoderId = 0;
    private boolean isCreateSession = false;
    private boolean isSendConfirm = false;
    private boolean isAbort = false;
    private boolean isInterrupt = false;
    private boolean isDoDefaultInstaller = false;
    private boolean isSessionFinish = false;
    private boolean isSessionSucc = false;
    private boolean isPause = false;
    private boolean isDestroy = false;
    private int copyFileTimeout = 0;
    private long copyFileCost = 0;
    private long lastPauseTime = 0;
    private long sendConfirmTime = 0;
    private Handler handler = new Handler(Looper.getMainLooper(), this);
    private PackageInstaller packageInstaller = MobileQQ.sMobileQQ.getPackageManager().getPackageInstaller();
    PackageInstaller.SessionCallback sessionCallback = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends PackageInstaller.SessionCallback {
        a() {
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onActiveChanged(int i3, boolean z16) {
            QLog.d(WadlInstallActivity.TAG, 4, "onActiveChanged sessionId=" + i3 + ",active=" + z16);
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onBadgingChanged(int i3) {
            QLog.d(WadlInstallActivity.TAG, 4, "onBadgingChanged sessionId=" + i3);
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onCreated(int i3) {
            QLog.i(WadlInstallActivity.TAG, 1, "onCreated currSessionId=" + WadlInstallActivity.this.currSessionId + ",sessionId=" + i3);
            if (WadlInstallActivity.this.currSessionId == i3 && !WadlInstallActivity.this.isCreateSession) {
                WadlInstallActivity.this.isCreateSession = true;
                WadlInstallActivity.this.copyFileAndExecInstallCmd();
            }
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onFinished(int i3, boolean z16) {
            QLog.i(WadlInstallActivity.TAG, 1, "onFinished sessionId=" + i3 + ",success=" + z16 + ",isSendConfirm=" + WadlInstallActivity.this.isSendConfirm);
            if (i3 == WadlInstallActivity.this.currSessionId) {
                WadlInstallActivity.this.isSessionFinish = true;
                WadlInstallActivity.this.isSessionSucc = z16;
                if (WadlInstallActivity.this.isSessionSucc) {
                    WadlInstallActivity.this.finish();
                    return;
                }
                WadlInstallActivity.this.handler.removeMessages(3);
                WadlInstallActivity.this.handler.removeMessages(2);
                WadlInstallActivity.this.handler.sendEmptyMessageDelayed(2, 500L);
            }
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onProgressChanged(int i3, float f16) {
            QLog.d(WadlInstallActivity.TAG, 4, "onProgressChanged sessionId=" + i3 + ",progress=" + f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyFileAndExecInstallCmd() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.sdk.app.WadlInstallActivity.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.i(WadlInstallActivity.TAG, 1, "copyFileAndExecInstallCmd copyInstallFile start");
                long currentTimeMillis = System.currentTimeMillis();
                int initHardCoder = WadlInstallActivity.this.initHardCoder();
                WadlInstallActivity wadlInstallActivity = WadlInstallActivity.this;
                boolean copyInstallFile = wadlInstallActivity.copyInstallFile(wadlInstallActivity.currSessionId);
                WadlInstallActivity.this.stopHardCoder(initHardCoder);
                if (WadlInstallActivity.this.isEnd()) {
                    QLog.w(WadlInstallActivity.TAG, 1, "copyFileAndExecInstallCmd abort, isDestroy=" + WadlInstallActivity.this.isDestroy + ",isDoDefaultInstaller=" + WadlInstallActivity.this.isDoDefaultInstaller);
                    return;
                }
                WadlInstallActivity.this.copyFileCost = System.currentTimeMillis() - currentTimeMillis;
                QLog.i(WadlInstallActivity.TAG, 1, "copyFileAndExecInstallCmd copyInstallFile end, currSessionId=" + WadlInstallActivity.this.currSessionId + ",hardCoderId=" + initHardCoder + ",cost=" + WadlInstallActivity.this.copyFileCost + ",copySuccess=" + copyInstallFile);
                if (copyInstallFile) {
                    copyInstallFile = ((IQQGameInstallService) QRoute.api(IQQGameInstallService.class)).execInstallCommand(WadlInstallActivity.this.packageInstaller, WadlInstallActivity.this.currSessionId, WadlInstallActivity.this.apkParams);
                }
                if (!copyInstallFile) {
                    WadlInstallActivity.this.doDefaultInstaller("copy file or exec install cmd fail");
                } else {
                    QLog.i(WadlInstallActivity.TAG, 1, "copyFileAndExecInstallCmd execInstallCommand success");
                }
            }
        }, 80, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0054, code lost:
    
        com.tencent.qphone.base.util.QLog.w(com.tencent.gamecenter.wadl.sdk.app.WadlInstallActivity.TAG, 1, "copyInstallFile abort");
        r6 = r17;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean copyInstallFile(int i3) {
        boolean z16;
        OutputStream outputStream;
        FileInputStream fileInputStream;
        PackageInstaller.Session openSession;
        OutputStream openWrite;
        byte[] bArr;
        long j3;
        boolean z17;
        int i16;
        boolean z18 = true;
        PackageInstaller.Session session = null;
        try {
            int i17 = this.copyFileTimeout;
            if (i17 > 0) {
                try {
                    this.handler.sendEmptyMessageDelayed(3, i17);
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    fileInputStream = null;
                }
            }
            openSession = this.packageInstaller.openSession(i3);
            try {
                openWrite = openSession.openWrite("base.apk", 0L, this.fileSize);
                try {
                    fileInputStream = new FileInputStream(this.apkFile);
                    try {
                        bArr = new byte[8388608];
                        j3 = 0;
                        z17 = true;
                        i16 = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        outputStream = openWrite;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    outputStream = openWrite;
                    z16 = false;
                    fileInputStream = null;
                }
            } catch (Throwable th8) {
                th = th8;
                z16 = false;
                outputStream = null;
                fileInputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
            z16 = false;
            outputStream = null;
            fileInputStream = null;
        }
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                j3 += read;
                OutputStream outputStream2 = openWrite;
                try {
                    int i18 = (int) ((100 * j3) / this.fileSize);
                    if (isEnd()) {
                        break;
                    }
                    if (i18 > i16) {
                        try {
                            z16 = false;
                            try {
                                this.handler.obtainMessage(1, i18, 0).sendToTarget();
                                i16 = i18;
                                z16 = false;
                                outputStream = outputStream2;
                            } catch (Throwable th10) {
                                th = th10;
                                outputStream = outputStream2;
                                session = openSession;
                                QLog.e(TAG, 1, "copyInstallFile sessionId=" + session + " exception ", th);
                                if (this.copyFileTimeout > 0) {
                                }
                                GameCenterUtil.closeIO(outputStream);
                                GameCenterUtil.closeIO(fileInputStream);
                                GameCenterUtil.closeIO(session);
                                return z16;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            outputStream = outputStream2;
                            session = openSession;
                        }
                    } else {
                        outputStream = outputStream2;
                        z16 = false;
                    }
                    try {
                        outputStream.write(bArr, z16 ? 1 : 0, read);
                        if (z17 && this.copyFileTimeout > 0) {
                            this.handler.removeMessages(3);
                            z17 = z16 ? 1 : 0;
                        }
                        openWrite = outputStream;
                        z17 = z17;
                    } catch (Throwable th12) {
                        th = th12;
                        session = openSession;
                        QLog.e(TAG, 1, "copyInstallFile sessionId=" + session + " exception ", th);
                        if (this.copyFileTimeout > 0) {
                        }
                        GameCenterUtil.closeIO(outputStream);
                        GameCenterUtil.closeIO(fileInputStream);
                        GameCenterUtil.closeIO(session);
                        return z16;
                    }
                    th = th11;
                    outputStream = outputStream2;
                    session = openSession;
                } catch (Throwable th13) {
                    th = th13;
                    outputStream = outputStream2;
                    z16 = false;
                    session = openSession;
                    QLog.e(TAG, 1, "copyInstallFile sessionId=" + session + " exception ", th);
                    if (this.copyFileTimeout > 0) {
                    }
                    GameCenterUtil.closeIO(outputStream);
                    GameCenterUtil.closeIO(fileInputStream);
                    GameCenterUtil.closeIO(session);
                    return z16;
                }
                z16 = false;
                try {
                    QLog.e(TAG, 1, "copyInstallFile sessionId=" + session + " exception ", th);
                    if (this.copyFileTimeout > 0) {
                        this.handler.removeMessages(3);
                    }
                    GameCenterUtil.closeIO(outputStream);
                    GameCenterUtil.closeIO(fileInputStream);
                    GameCenterUtil.closeIO(session);
                    return z16;
                } catch (Throwable th14) {
                    if (this.copyFileTimeout > 0) {
                        this.handler.removeMessages(3);
                    }
                    GameCenterUtil.closeIO(outputStream);
                    GameCenterUtil.closeIO(fileInputStream);
                    GameCenterUtil.closeIO(session);
                    throw th14;
                }
            }
            outputStream = openWrite;
            break;
        }
        z16 = false;
        if (!this.isDestroy) {
            openSession.fsync(outputStream);
        } else {
            z18 = false;
        }
        if (this.copyFileTimeout > 0) {
            this.handler.removeMessages(3);
        }
        GameCenterUtil.closeIO(outputStream);
        GameCenterUtil.closeIO(fileInputStream);
        GameCenterUtil.closeIO(openSession);
        return z18;
    }

    private boolean createInstallSession(String str) {
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
        sessionParams.setInstallLocation(0);
        sessionParams.setSize(this.fileSize);
        try {
            int createSession = this.packageInstaller.createSession(sessionParams);
            this.currSessionId = createSession;
            this.apkParams.D = createSession;
            QLog.i(TAG, 1, "createInstallSession appId=" + str + ",currSessionId=" + this.currSessionId);
            return true;
        } catch (IOException e16) {
            QLog.e(TAG, 1, "createInstallSession appId=" + str + ",exception=", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDefaultInstaller(String str) {
        QLog.w(TAG, 1, "doDefaultInstaller sessionId=" + this.currSessionId + ",isSendConfirm=" + this.isSendConfirm + ",isDoDefaultInstaller=" + this.isDoDefaultInstaller + ",reason=" + str);
        if (this.isDoDefaultInstaller) {
            return;
        }
        this.isDoDefaultInstaller = true;
        ApkParams apkParams = this.apkParams;
        GameCenterUtil.goToInstall(apkParams.f106716d, apkParams.f106718f, apkParams.f106720i, apkParams.f106721m, "custom");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        QLog.i(TAG, 1, "finish...");
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    private Intent getIntent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getIntent();
        }
        QLog.e(TAG, 1, "Fragment.getActivity() is null when calling getIntent()");
        return new Intent();
    }

    private int getReportResult() {
        boolean isAppInstalled = PackageUtil.isAppInstalled(BaseApplication.getContext(), this.apkParams.f106718f);
        if (!this.isSessionSucc && !isAppInstalled) {
            if (this.isInterrupt) {
                return 2;
            }
            if (this.isDoDefaultInstaller) {
                return 0;
            }
            return 1;
        }
        return 3;
    }

    private void initExpEntityInfo() {
        String str;
        boolean z16;
        try {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(WadlProxyConsts.EXP_QQ_QQGAME_CUSTOM_INSTALL);
            if (expEntity.isExperiment()) {
                Map<String, String> tabParams = expEntity.getTabParams();
                if (tabParams != null) {
                    str = tabParams.get("ext_params");
                } else {
                    str = "";
                }
                QLog.d(TAG, 1, "initExpEntityInfo extParams=" + str);
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(PARAMS_HARDCODER, 0) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.useHardCoder = z16;
                JSONArray optJSONArray = jSONObject.optJSONArray(PARAMS_TIMEOUT_ARRAY);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (this.parseFileSize <= optJSONObject.optInt(PARAMS_PKG_SIZE)) {
                            this.copyFileTimeout = optJSONObject.optInt("time", 0);
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initExpEntityInfo exception=", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int initHardCoder() {
        try {
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "initHardCoder exception=", th5);
        }
        if (!this.useHardCoder) {
            QLog.d(TAG, 1, "initHardCoder useHardCoder is off");
            return this.hardCoderId;
        }
        this.hardCoderId = HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{Process.myTid()}, 5000, 101, 32768L, Process.myTid(), TAG, true);
        QLog.d(TAG, 1, "initHardCoder start HardCoder hardCoderId=" + this.hardCoderId);
        return this.hardCoderId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEnd() {
        if (!this.isDestroy && !this.isDoDefaultInstaller) {
            return false;
        }
        return true;
    }

    private boolean isInterrupt() {
        if (this.isSendConfirm && this.isPause && this.sendConfirmTime < this.lastPauseTime) {
            return true;
        }
        return false;
    }

    private void openInstallDetailHippyPage() {
        String replace = INSTALL_DETAIL_HIPPY_PAGE.replace("$GAME_APPID$", this.apkParams.f106716d).replace("$OS_VERSION$", String.valueOf(Build.VERSION.SDK_INT));
        QLog.d(TAG, 1, "openInstallDetailHippyPage, jumpUrl=", replace);
        GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, replace);
    }

    private void reportInstallAction(String str, int i3, String str2, String str3) {
        String str4 = "1";
        WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("9386").setExt(1, "938601").setExt(4, str2).setExt(11, "1").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(15, String.valueOf(Build.VERSION.SDK_INT)).setExt(2, this.apkParams.E).setExt(29, DeviceInfoMonitor.getModel()).setExt(20, str3);
        if (this.hardCoderId == 0) {
            str4 = "0";
        }
        ext.setExt(21, str4).setGameAppId(this.apkParams.f106716d).setOperId(str).setRetId(i3).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopHardCoder(int i3) {
        if (i3 != 0) {
            QLog.d(TAG, 1, "stopHardCoder hardCoderId=" + i3);
            HardCoderManager.getInstance().stop(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void doResume() {
        super.doResume();
        this.isPause = false;
        if (this.isSendConfirm && !this.isSessionFinish) {
            QLog.w(TAG, 1, "onResume isSendConfirm and session not finish");
            finish();
        } else {
            QLog.d(TAG, 1, "onResume");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (this.isDestroy) {
            return false;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    doDefaultInstaller("timeout");
                }
            } else {
                if (isInterrupt()) {
                    this.isInterrupt = true;
                    openInstallDetailHippyPage();
                    ((IQQGameInstallService) QRoute.api(IQQGameInstallService.class)).saveInstallModelChecked(this.apkParams.f106716d);
                    reportInstallAction(WadlProxyConsts.OPER_ID_CUSTOM_INSTALL_NOTICE, 1, "20", "");
                } else {
                    this.isInterrupt = false;
                    if (!this.isSendConfirm) {
                        doDefaultInstaller("session finish and status error");
                        return false;
                    }
                    QLog.d(TAG, 1, "handleMessage, is user cancel install");
                }
                finish();
            }
        } else {
            this.progressView.setText(message.arg1 + "%");
        }
        return false;
    }

    @Override // nl0.b
    public void onAbort(int i3) {
        QLog.d(TAG, 1, "onAbort sessionId=" + i3);
        if (i3 == this.currSessionId) {
            this.isAbort = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        QLog.d(TAG, 4, "onActivityCreated");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.d(TAG, 4, "onCreate");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        QLog.d(TAG, 4, "onCreateView inflater=" + layoutInflater + ",container=" + viewGroup);
        View inflate = layoutInflater.inflate(R.layout.eb8, viewGroup, false);
        this.rootView = inflate;
        this.iconView = (ImageView) inflate.findViewById(R.id.d_7);
        this.appNameView = (TextView) this.rootView.findViewById(R.id.sqf);
        this.pkgSizeView = (TextView) this.rootView.findViewById(R.id.f85724pq);
        this.progressView = (TextView) this.rootView.findViewById(R.id.f28480j2);
        this.iconSize = (int) ((getResources().getDisplayMetrics().density * 100.0f) + 0.5f);
        this.apkParams = (ApkParams) getIntent().getParcelableExtra(WadlProxyConsts.WADL_INSTALL_REQUEST);
        QLog.d(TAG, 4, "onCreate apkParams=" + this.apkParams);
        ApkParams apkParams = this.apkParams;
        if (apkParams != null && !TextUtils.isEmpty(apkParams.f106720i)) {
            File file = new File(this.apkParams.f106720i);
            this.apkFile = file;
            long length = file.length();
            this.fileSize = length;
            this.parseFileSize = (length / 1024) / 1024;
            String str = this.apkParams.C;
            int i3 = this.iconSize;
            this.iconView.setImageDrawable(WadlUtils.getDrawable(str, i3, i3));
            if (!TextUtils.isEmpty(this.apkParams.f106717e)) {
                this.appNameView.setText(this.apkParams.f106717e);
            }
            if (this.apkParams.f106719h > 0) {
                this.pkgSizeView.setText(String.format(getResources().getString(R.string.f1376407e), WadlUtils.getOriginSizeStr(this.apkParams.f106719h)));
            }
            initExpEntityInfo();
            reportInstallAction(WadlProxyConsts.OPER_ID_CUSTOM_INSTALL_SHOW, 0, "8", "");
            GameInstallReceiver.c();
            ((IQQGameInstallService) QRoute.api(IQQGameInstallService.class)).addInstallListener(this);
            this.packageInstaller.registerSessionCallback(this.sessionCallback);
            if (!createInstallSession(this.apkParams.f106716d)) {
                doDefaultInstaller("create session fail");
            }
            view = this.rootView;
        } else {
            finish();
            view = this.rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.isDestroy = true;
        this.handler.removeCallbacksAndMessages(null);
        this.packageInstaller.unregisterSessionCallback(this.sessionCallback);
        ((IQQGameInstallService) QRoute.api(IQQGameInstallService.class)).removeInstallListener(this);
        GameInstallReceiver.d();
        int reportResult = getReportResult();
        QLog.i(TAG, 1, "onDestroy currSessionId=" + this.currSessionId + ",isSendConfirm=" + this.isSendConfirm + ",isInterrupt=" + this.isInterrupt + ",isSessionFinish=" + this.isSessionFinish + ",isSessionSucc=" + this.isSessionSucc + ",ret=" + reportResult + ",useHardCoder=" + this.useHardCoder + ",copyFileCost=" + this.copyFileCost);
        reportInstallAction(WadlProxyConsts.OPER_ID_CUSTOM_INSTALL_CANCEL, reportResult, "20", String.valueOf(this.copyFileCost));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        doDefaultInstaller("onNewIntent");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPause = true;
        this.lastPauseTime = System.currentTimeMillis();
        QLog.d(TAG, 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // nl0.b
    public void onSendConfirm(int i3, long j3) {
        QLog.d(TAG, 1, "onSendConfirm sessionId=" + i3);
        if (i3 == this.currSessionId) {
            this.isSendConfirm = true;
            this.sendConfirmTime = j3;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
