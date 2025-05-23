package com.tencent.mobileqq.utils.confighandler;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import ty2.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class NormalConfigHandler<T extends ConfigInfo> extends ConfigHandler<T> {
    T mConfig;
    Object mLock_Config;
    ReadConfigTask<T> mReadConfigTask;
    String mSPKey_Config;
    String mSPKey_Ver;
    String mSPName;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface GetConfigListen<T extends ConfigInfo> {
        void onGetConfig(AppInterface appInterface, T t16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements SyncLoadTask.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GetConfigListen f307541a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppInterface f307542b;

        a(GetConfigListen getConfigListen, AppInterface appInterface) {
            this.f307541a = getConfigListen;
            this.f307542b = appInterface;
        }

        @Override // com.tencent.mobileqq.utils.SyncLoadTask.a
        public void a(boolean z16, ArrayList<SyncLoadTask> arrayList) {
            ReadConfigTask<T> readConfigTask = (ReadConfigTask) arrayList.get(0);
            NormalConfigHandler normalConfigHandler = NormalConfigHandler.this;
            ReadConfigTask<T> readConfigTask2 = normalConfigHandler.mReadConfigTask;
            if (readConfigTask2 != null && readConfigTask2 == readConfigTask) {
                QLog.w(normalConfigHandler.TAG, 1, "\u5f02\u6b65\u52a0\u8f7dconfig\u8fd4\u56de, bsuc[" + z16 + "], TAG[" + readConfigTask.mTAG + "], config[" + readConfigTask.mConfigInfo + "]");
                NormalConfigHandler.this.mReadConfigTask = null;
            } else {
                QLog.w(normalConfigHandler.TAG, 1, "\u5f02\u6b65\u52a0\u8f7dconfig\u8fd4\u56de[" + readConfigTask.mTAG + "], \u4f46\u539f\u8bf7\u6c42\u53d6\u6d88\u4e86");
            }
            GetConfigListen getConfigListen = this.f307541a;
            if (getConfigListen != null) {
                getConfigListen.onGetConfig(this.f307542b, readConfigTask.mConfigInfo);
            }
        }
    }

    public NormalConfigHandler(String str, String str2, String str3, String str4, String str5) {
        super(str, str2);
        this.mLock_Config = new Object();
        this.mSPName = str3;
        this.mSPKey_Config = str4;
        this.mSPKey_Ver = str5;
    }

    private SharedPreferences getSP() {
        if (QQAudioHelper.f() && this.mSPName == null) {
            throw new IllegalArgumentException(this.TAG + "mSPName\u4e3a\u7a7a");
        }
        return b.a(this.TAG, this.mUin, this.mSPName);
    }

    public T getConfig() {
        if (this.mConfig == null && QQAudioHelper.f()) {
            QLog.w(this.TAG, 1, "getConfig, \u914d\u7f6e\u8fd8\u672a\u521d\u59cb\u5316", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.orr));
        }
        return this.mConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T getConfigDirect() {
        if (this.mConfig == null) {
            setConfig(ConfigHandler.getConfigInfo(this.TAG, null, 0, getConfigInfoClass(), this.mUin, this.mSPName, this.mSPKey_Config, this.mSPKey_Ver));
        }
        return this.mConfig;
    }

    protected int getConfigID() {
        return 0;
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public int getConfigVer() {
        if (QQAudioHelper.f() && this.mSPKey_Config == null) {
            throw new IllegalArgumentException(this.TAG + "mSPKey_Config\u4e3a\u7a7a");
        }
        return ConfigHandler.getConfigVer(getSP(), this.mSPKey_Config, this.mSPKey_Ver);
    }

    public boolean isConfigReady() {
        boolean z16;
        synchronized (this.mLock_Config) {
            if (this.mConfig != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigHandler
    public void saveConfig(String str, int i3) {
        if (QQAudioHelper.f() && this.mSPKey_Config == null) {
            throw new IllegalArgumentException(this.TAG + "mSPKey_Config\u4e3a\u7a7a");
        }
        ConfigHandler.saveConfigSP(this.TAG, getSP(), str, i3, this.mSPKey_Config, this.mSPKey_Ver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setConfig(T t16) {
        synchronized (this.mLock_Config) {
            this.mReadConfigTask = null;
            T t17 = this.mConfig;
            if (t17 == t16) {
                return false;
            }
            if (t17 != null && t16 != null && t17.serverVer == t16.serverVer) {
                return false;
            }
            this.mConfig = t16;
            return true;
        }
    }

    public ReadConfigTask<T> syncGetConfigInfo(AppInterface appInterface, GetConfigListen<T> getConfigListen) {
        ReadConfigTask<T> readConfigTask = this.mReadConfigTask;
        if (readConfigTask == null) {
            readConfigTask = new ReadConfigTask<>(this.TAG, this.mUin, appInterface, getConfigInfoClass());
            readConfigTask.setSPInfo(getConfigID(), this.mSPName, this.mSPKey_Config, this.mSPKey_Ver);
            this.mReadConfigTask = readConfigTask;
        }
        if (readConfigTask.isNeedRunTask()) {
            QLog.w(this.TAG, 1, "\u5f02\u6b65\u52a0\u8f7dconfig[" + readConfigTask.mTAG + "]");
            ArrayList arrayList = new ArrayList();
            arrayList.add(readConfigTask);
            SyncLoadTask.requestSyncTask(null, arrayList, new a(getConfigListen, appInterface));
        } else {
            QLog.w(this.TAG, 1, "\u5f02\u6b65\u52a0\u8f7dconfig[" + readConfigTask.mTAG + "], \u5df2\u7ecf\u5728\u52a0\u8f7d\u4e2d");
        }
        return readConfigTask;
    }
}
