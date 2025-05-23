package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasQuickUpdateServiceImpl implements IVasQuickUpdateService {
    private static final String TAG = "VasQuickUpdateServiceIm";
    private VasQuickUpdateManager mVasQuickUpdateManager;

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void addCallBacker(CallBacker callBacker) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.addCallBacker(callBacker);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void addWeakCallback(CallBacker callBacker) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.addWeakCallback(callBacker);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void callBackToAll(long j3, String str, String str2, String str3, int i3, int i16) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.callBackToAll(j3, str, str2, str3, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void cancelDwonloadItem(long j3, String str) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.cancelDwonloadItem(j3, str);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void cleanCache() {
        if (this.mVasQuickUpdateManager != null) {
            VasQuickUpdateManager.cleanCache();
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void downloadGatherItem(long j3, String str, String[] strArr, String str2) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.downloadGatherItem(j3, str, strArr, str2);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void downloadItem(long j3, String str, String str2) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.downloadItem(j3, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public <T extends IBusinessCallback> T getBusinessCallback(Class<T> cls) {
        VasQuickUpdateManager vasQuickUpdateManager;
        if (cls == null || (vasQuickUpdateManager = this.mVasQuickUpdateManager) == null || vasQuickUpdateManager.getVasEngine() == null) {
            return null;
        }
        try {
            return (BaseUpdateBusiness) this.mVasQuickUpdateManager.getVasEngine().getBusinessCallback(cls);
        } catch (NullPointerException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        VasQuickUpdateManager vasQuickUpdateManager;
        if (appRuntime != null) {
            vasQuickUpdateManager = (VasQuickUpdateManager) appRuntime.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
        } else {
            vasQuickUpdateManager = null;
        }
        this.mVasQuickUpdateManager = vasQuickUpdateManager;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void onProgressToAll(long j3, String str, String str2, long j16, long j17) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.onProgressToAll(j3, str, str2, j16, j17);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void queryItemVersion(int i3, String str, boolean z16, boolean z17, long j3, QueryItemCallback queryItemCallback) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.queryItemVersion(i3, str, z16, z17, j3, queryItemCallback);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService
    public void removeCallBacker(CallBacker callBacker) {
        VasQuickUpdateManager vasQuickUpdateManager = this.mVasQuickUpdateManager;
        if (vasQuickUpdateManager != null) {
            vasQuickUpdateManager.removeCallBacker(callBacker);
        }
    }
}
