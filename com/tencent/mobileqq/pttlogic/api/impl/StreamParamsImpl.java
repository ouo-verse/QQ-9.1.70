package com.tencent.mobileqq.pttlogic.api.impl;

import com.tencent.mobileqq.pttlogic.api.IStreamParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class StreamParamsImpl implements IStreamParams {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_SIZE = 800;
    private static final String TAG = "StreamParams";
    private boolean sSliceCfgInit;
    private int[] sSliceSizeCfg;
    private boolean sSupportCfgInit;
    private boolean sSupportStream;

    public StreamParamsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.sSupportStream = true;
            this.sSliceSizeCfg = new int[6];
        }
    }

    private String getSavedStreamCfg(AppRuntime appRuntime) {
        String string = BaseApplication.getContext().getSharedPreferences("RecordParams_" + appRuntime.getCurrentAccountUin(), 0).getString("StreamCfg", null);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSavedStreamCfg: " + string);
        }
        return string;
    }

    private String getSavedStreamSliceCfg(AppRuntime appRuntime) {
        String string = BaseApplication.getContext().getSharedPreferences("RecordParams_" + appRuntime.getCurrentAccountUin(), 0).getString("StreamSliceCfg", null);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSavedStreamSliceCfg: " + string);
        }
        return string;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IStreamParams
    public int getSliceSize(AppRuntime appRuntime, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, appRuntime, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (appRuntime == null || i3 == 0) {
            return 800;
        }
        initSliceCfg(appRuntime, false);
        int[] iArr = this.sSliceSizeCfg;
        if (i16 >= 0 && i16 < iArr.length) {
            i17 = iArr[i16];
        }
        if (i17 == 0) {
            return 800;
        }
        return i17;
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IStreamParams
    public void initSliceCfg(AppRuntime appRuntime, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appRuntime, Boolean.valueOf(z16));
            return;
        }
        if (this.sSliceCfgInit && !z16) {
            return;
        }
        this.sSliceCfgInit = true;
        try {
            String savedStreamSliceCfg = getSavedStreamSliceCfg(appRuntime);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initSliceCfg: " + savedStreamSliceCfg);
            }
            if (savedStreamSliceCfg != null) {
                String[] split = savedStreamSliceCfg.split("\\|");
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (split[i3].startsWith("1-")) {
                        String[] split2 = split[i3].split("-");
                        this.sSliceSizeCfg[Integer.parseInt(split2[1])] = Integer.parseInt(split2[2]);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IStreamParams
    public void initSupportCfg(AppRuntime appRuntime, boolean z16) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, Boolean.valueOf(z16));
            return;
        }
        if (this.sSupportCfgInit && !z16) {
            return;
        }
        this.sSupportCfgInit = true;
        try {
            String savedStreamCfg = getSavedStreamCfg(appRuntime);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initSupportCfg :" + savedStreamCfg);
            }
            if (savedStreamCfg != null && savedStreamCfg.length() != 0 && (split = savedStreamCfg.split("\\|")) != null && split.length >= 1) {
                this.sSupportStream = "1".equals(split[0]);
            }
        } catch (Exception unused) {
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init params: " + this.sSupportStream);
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IStreamParams
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.sSupportCfgInit = false;
        this.sSupportStream = true;
        this.sSliceCfgInit = false;
        this.sSliceSizeCfg = new int[6];
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IStreamParams
    public void saveStreamCfg(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        BaseApplication.getContext().getSharedPreferences("RecordParams_" + appRuntime.getCurrentAccountUin(), 0).edit().putString("StreamCfg", str).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveStreamCfg: " + str);
        }
    }

    @Override // com.tencent.mobileqq.pttlogic.api.IStreamParams
    public void saveStreamSliceCfg(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime, (Object) str);
            return;
        }
        BaseApplication.getContext().getSharedPreferences("RecordParams_" + appRuntime.getCurrentAccountUin(), 0).edit().putString("StreamSliceCfg", str).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveStreamSliceCfg: " + str);
        }
    }
}
