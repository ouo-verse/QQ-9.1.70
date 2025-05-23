package com.tencent.ark;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkStateCenter {
    protected static String TAG = "ArkApp.ArkStateCenter";
    protected static ArkStateCenter mArkStateCenter = new ArkStateCenter();
    protected final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    protected final Set<WeakReference<ArkViewModelBase>> mArkViewModels = new HashSet();
    protected ArkStateInterface mStateInterface = null;
    protected boolean mIsForeground = true;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ArkStateInterface {
        boolean arkIsForeground();
    }

    ArkStateCenter() {
    }

    public static ArkStateCenter getInstance() {
        return mArkStateCenter;
    }

    public void addArkViewModel(ArkViewModelBase arkViewModelBase) {
        if (arkViewModelBase == null) {
            Logger.logE(TAG, "addArkView fail:arkViewModel is null");
            return;
        }
        WeakReference<ArkViewModelBase> weakReference = new WeakReference<>(arkViewModelBase);
        synchronized (this.mArkViewModels) {
            arkViewModelBase.setForeground(this.mIsForeground);
            this.mArkViewModels.add(weakReference);
        }
    }

    public boolean isForeground() {
        if (!this.mIsForeground) {
            Logger.logE(TAG, "state is in backGround");
        }
        return this.mIsForeground;
    }

    public void setForeground(boolean z16) {
        synchronized (this.mArkViewModels) {
            if (z16) {
                Logger.logE(TAG, "ark state change to foreground");
            } else {
                Logger.logE(TAG, "ark state change to  background");
            }
            this.mIsForeground = z16;
            Iterator<WeakReference<ArkViewModelBase>> it = this.mArkViewModels.iterator();
            while (it.hasNext()) {
                ArkViewModelBase arkViewModelBase = it.next().get();
                if (arkViewModelBase != null) {
                    arkViewModelBase.setForeground(z16);
                } else {
                    it.remove();
                }
            }
        }
    }

    public void setStateInterface(ArkStateInterface arkStateInterface) {
        Logger.logE(TAG, String.format("setStateInterface %h", arkStateInterface));
        this.mStateInterface = arkStateInterface;
    }
}
