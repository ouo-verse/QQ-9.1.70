package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.ResInfo;
import com.tencent.mobileqq.qwallet.config.PreloadConfProcessor;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class PreloadBackControlConfig implements Serializable {
    public static final String CONFIG_NAME = "back_config";
    private static final long serialVersionUID = 1;
    private String mConfigVersion = "0";
    private ArrayList<ResInfo> mLastBackResInfos;

    public static String getConfigPath() {
        return com.tencent.mobileqq.qwallet.preload.a.d() + CONFIG_NAME;
    }

    public static PreloadBackControlConfig readBackControlConfig() {
        PreloadBackControlConfig preloadBackControlConfig;
        try {
            preloadBackControlConfig = (PreloadBackControlConfig) d.v(getConfigPath());
        } catch (Exception unused) {
            preloadBackControlConfig = null;
        }
        if (preloadBackControlConfig == null) {
            preloadBackControlConfig = new PreloadBackControlConfig();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BackControlConfig", 2, "readBackControlConfig:" + preloadBackControlConfig);
        }
        return preloadBackControlConfig;
    }

    public synchronized ArrayList<ResInfo> getLastBackResInfos() {
        ArrayList<ResInfo> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<ResInfo> arrayList2 = this.mLastBackResInfos;
        if (arrayList2 != null) {
            Iterator<ResInfo> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public synchronized boolean isLocalResNewest() {
        return g.j(PreloadConfProcessor.d(), "0").equals(this.mConfigVersion);
    }

    public String toString() {
        return "BackControlConfig [mVersion=" + this.mConfigVersion + ", mLastRes=" + this.mLastBackResInfos + "]";
    }

    public synchronized void update(ArrayList<ResInfo> arrayList) {
        this.mConfigVersion = g.j(PreloadConfProcessor.d(), "0");
        this.mLastBackResInfos = arrayList;
        d.x(this, getConfigPath());
    }
}
