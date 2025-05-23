package com.xingin.xhssharesdk.model.config;

import androidx.annotation.Keep;
import com.xingin.xhssharesdk.log.IShareLogger;
import zz4.a;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public class XhsShareGlobalConfig {
    private String fileProviderAuthority;
    private boolean enableLog = false;
    private IShareLogger iShareLogger = new a();
    private String cacheDirPath = null;
    private boolean clearCacheWhenShareComplete = true;
    private boolean needRegisterReceiverWithOutsideActivity = false;

    public String getCacheDirPath() {
        return this.cacheDirPath;
    }

    public String getFileProviderAuthority() {
        return this.fileProviderAuthority;
    }

    public IShareLogger getShareLogger() {
        return this.iShareLogger;
    }

    public boolean isClearCacheWhenShareComplete() {
        return this.clearCacheWhenShareComplete;
    }

    public boolean isEnableLog() {
        return this.enableLog;
    }

    public boolean isNeedRegisterReceiverWithOutsideActivity() {
        return this.needRegisterReceiverWithOutsideActivity;
    }

    public XhsShareGlobalConfig setCacheDirPath(String str) {
        this.cacheDirPath = str;
        return this;
    }

    public XhsShareGlobalConfig setClearCacheWhenShareComplete(boolean z16) {
        this.clearCacheWhenShareComplete = z16;
        return this;
    }

    public XhsShareGlobalConfig setEnableLog(boolean z16) {
        this.enableLog = z16;
        return this;
    }

    public XhsShareGlobalConfig setFileProviderAuthority(String str) {
        this.fileProviderAuthority = str;
        return this;
    }

    public XhsShareGlobalConfig setNeedRegisterReceiverWithOutsideActivity(boolean z16) {
        this.needRegisterReceiverWithOutsideActivity = z16;
        return this;
    }

    public void setShareLogger(IShareLogger iShareLogger) {
        this.iShareLogger = iShareLogger;
    }
}
