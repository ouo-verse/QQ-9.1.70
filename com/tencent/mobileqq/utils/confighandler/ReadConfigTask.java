package com.tencent.mobileqq.utils.confighandler;

import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ReadConfigTask<T extends ConfigInfo> extends SyncLoadTask {
    int mConfigID;
    public T mConfigInfo;
    Class<T> mConfigInfoClass;
    WeakReference<AppInterface> mRefApp;
    String mSPKey_Config;
    String mSPKey_Ver;
    String mSPName;
    final String mUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadConfigTask(String str, String str2, AppInterface appInterface, Class<T> cls) {
        super(str);
        this.mConfigID = 0;
        this.mUin = str2;
        this.mRefApp = new WeakReference<>(appInterface);
        this.mConfigInfoClass = cls;
    }

    @Override // com.tencent.mobileqq.utils.SyncLoadTask
    public void innerClean() {
        this.mConfigInfo = null;
    }

    @Override // com.tencent.mobileqq.utils.SyncLoadTask
    public boolean runOnSubThread(Resources resources) {
        Class<T> cls = this.mConfigInfoClass;
        int i3 = this.mConfigID;
        if (i3 != 0) {
            this.mConfigInfo = (T) ConfigHandler.getConfigInfoNew(this.mTAG, null, i3, cls, this.mUin);
        } else {
            this.mConfigInfo = (T) ConfigHandler.getConfigInfo(this.mTAG, null, 0, cls, this.mUin, this.mSPName, this.mSPKey_Config, this.mSPKey_Ver);
        }
        QLog.w(this.mTAG, 1, "ReadConfigTask,ConfigInfo[" + this.mConfigInfo + "]");
        QQAudioHelper.n(this.mRefApp.get());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSPInfo(int i3, String str, String str2, String str3) {
        this.mConfigID = i3;
        this.mSPName = str;
        this.mSPKey_Config = str2;
        this.mSPKey_Ver = str3;
    }
}
