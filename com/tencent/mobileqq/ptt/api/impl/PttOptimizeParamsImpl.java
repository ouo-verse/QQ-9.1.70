package com.tencent.mobileqq.ptt.api.impl;

import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.pttlogic.api.IPttConfigService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class PttOptimizeParamsImpl implements IPttOptimizeParams {
    public static final long FLAG_ACTIVATE_NET = 4;
    public static final long FLAG_DIRECT_URL_DW = 1;
    public static final long FLAG_HTTP_SIDEWAY = 8;
    public static final long FLAG_REUSE_IP = 16;
    public static final long FLAG_SSCM = 2;
    private static final String TAG = "PttOptimizeParams";
    protected boolean sOptimizeCfgInit = false;
    private int supportDirectDownload = 1;
    private int supportSSCM = 1;
    private int supportActivateNet = 1;
    private int supportHttpSideWay = 1;
    private int tryTime = 480000;
    private int tryCount = 9;
    private int fixScheduleTryCount = 3;

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public boolean doesSupportActivateNet(AppRuntime appRuntime) {
        initOptimizeCfg(appRuntime, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doesSupportActivateNet:" + this.supportActivateNet);
        }
        if (this.supportActivateNet != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public boolean doesSupportDirectDownload(AppRuntime appRuntime) {
        initOptimizeCfg(appRuntime, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doesSupportDirectDownload:" + this.supportDirectDownload);
        }
        if (this.supportDirectDownload != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public boolean doesSupportHttpSideWay(AppRuntime appRuntime) {
        initOptimizeCfg(appRuntime, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doesSupportHttpSideWay:" + this.supportHttpSideWay);
        }
        if (this.supportHttpSideWay != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public boolean doesSupportSSCM(AppRuntime appRuntime) {
        initOptimizeCfg(appRuntime, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doesSupportSSCM:" + this.supportSSCM);
        }
        if (this.supportSSCM != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public int getFixScheduleTryCount_dpc(AppRuntime appRuntime) {
        initOptimizeCfg(appRuntime, false);
        return this.fixScheduleTryCount;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public long getOptString(AppRuntime appRuntime, boolean z16) {
        long j3;
        if (doesSupportDirectDownload(appRuntime)) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        if (doesSupportSSCM(appRuntime)) {
            j3 |= 2;
        }
        if (doesSupportActivateNet(appRuntime)) {
            j3 |= 4;
        }
        if (doesSupportHttpSideWay(appRuntime)) {
            j3 |= 8;
        }
        if (z16) {
            return j3 | 16;
        }
        return j3;
    }

    protected String getSavedPttOptimizeCfg(AppRuntime appRuntime) {
        String string = BaseApplication.getContext().getSharedPreferences("RecordParams_" + appRuntime.getCurrentAccountUin(), 0).getString(IPttConfigService.TAG_PTT_OPTIMIZE_CFG, null);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSavedPttOptimizeCfg: " + string);
        }
        return string;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public int getTryCount_dpc(AppRuntime appRuntime) {
        initOptimizeCfg(appRuntime, false);
        return this.tryCount;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public int getTryTime_dpc(AppRuntime appRuntime) {
        initOptimizeCfg(appRuntime, false);
        return this.tryTime;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public synchronized void initOptimizeCfg(AppRuntime appRuntime, boolean z16) {
        if (this.sOptimizeCfgInit && !z16) {
            return;
        }
        this.sOptimizeCfgInit = true;
        try {
            String savedPttOptimizeCfg = getSavedPttOptimizeCfg(appRuntime);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initPttOptimizeCfgStr: " + savedPttOptimizeCfg);
            }
            if (savedPttOptimizeCfg != null) {
                String[] split = savedPttOptimizeCfg.split("\\|");
                this.supportDirectDownload = Integer.valueOf(split[0]).intValue();
                this.supportSSCM = Integer.valueOf(split[1]).intValue();
                this.tryTime = Integer.valueOf(split[2]).intValue();
                this.tryCount = Integer.valueOf(split[3]).intValue();
                this.fixScheduleTryCount = Integer.valueOf(split[4]).intValue();
                this.supportActivateNet = Integer.valueOf(split[5]).intValue();
                this.supportHttpSideWay = Integer.valueOf(split[6]).intValue();
            }
            String currentAccountUin = appRuntime.getCurrentAccountUin();
            if (this.supportDirectDownload == 0) {
                if (currentAccountUin.endsWith("1")) {
                    this.supportDirectDownload = 2;
                } else {
                    this.supportDirectDownload = 1;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initDirectDownloadCfgStr: " + this.supportDirectDownload);
            }
            if (this.supportSSCM == 0) {
                if (currentAccountUin.endsWith("2")) {
                    this.supportSSCM = 2;
                } else {
                    this.supportSSCM = 1;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initSSCMCfgStr: " + this.supportSSCM);
            }
            if (this.supportActivateNet == 0) {
                if (currentAccountUin.endsWith("3")) {
                    this.supportActivateNet = 2;
                } else {
                    this.supportActivateNet = 1;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initActivateNet: " + this.supportActivateNet);
            }
            if (this.supportHttpSideWay == 0) {
                if (appRuntime.getCurrentAccountUin().endsWith("5")) {
                    this.supportHttpSideWay = 2;
                } else {
                    this.supportHttpSideWay = 1;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initHttpSideWay: " + this.supportHttpSideWay);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initOptimizeCfg exception: " + e16);
            }
            this.supportDirectDownload = 1;
            this.supportSSCM = 1;
            this.tryTime = 480000;
            this.tryCount = 9;
            this.fixScheduleTryCount = 3;
            this.supportActivateNet = 1;
            this.supportHttpSideWay = 1;
        }
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttOptimizeParams
    public void savePttOptimizeCfg(AppRuntime appRuntime, String str) {
        BaseApplication.getContext().getSharedPreferences("RecordParams_" + appRuntime.getCurrentAccountUin(), 0).edit().putString(IPttConfigService.TAG_PTT_OPTIMIZE_CFG, str).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "savePttOptimizeCfg: " + str);
        }
    }
}
