package com.epicgames.ue4;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UEAppStatusManager implements IUEAppStatus {
    private static volatile UEAppStatusManager sInstance;
    private IUEAppStatus mUEAppStatus;

    UEAppStatusManager() {
    }

    public static UEAppStatusManager getInstance() {
        if (sInstance == null) {
            synchronized (UEAppStatusManager.class) {
                if (sInstance == null) {
                    sInstance = new UEAppStatusManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.epicgames.ue4.IUEAppStatus
    public boolean appForeground() {
        IUEAppStatus iUEAppStatus = this.mUEAppStatus;
        if (iUEAppStatus != null) {
            return iUEAppStatus.appForeground();
        }
        return false;
    }

    public void setUEAppStatus(IUEAppStatus iUEAppStatus) {
        this.mUEAppStatus = iUEAppStatus;
    }
}
