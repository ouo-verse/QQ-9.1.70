package com.tencent.mobileqq.gamecenter;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class YunGameRuntime extends BaseQQAppInterface {
    public static final String TAG = "YunGameRuntime";
    public static final String YUN_GAME_ID = "yungame.apk";
    private boolean isGameRunning;

    public YunGameRuntime(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        this.isGameRunning = false;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        return "yungame.apk";
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        QLog.i(TAG, 1, "highPriorityWhenBackground: " + this.isGameRunning);
        return this.isGameRunning;
    }

    @Override // mqq.app.AppRuntime
    public boolean isProcessIdle() {
        QLog.i(TAG, 1, "isProcessIdle: " + this.isGameRunning);
        return this.isGameRunning;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i(TAG, 1, "onCreate...");
    }

    @Override // mqq.app.AppRuntime
    public void preExit() {
        QLog.i(TAG, 1, "preExit...");
        super.preExit();
    }

    public void setGameRunning(boolean z16) {
        QLog.i(TAG, 1, "setGameRunning: " + z16);
        this.isGameRunning = z16;
    }
}
