package com.tencent.gamematrix.gmcg.webrtc;

import android.app.Activity;
import com.tencent.gamematrix.gmcg.base.pxlw.PixelWorks;

/* loaded from: classes6.dex */
public class GmCgPxlwManager {
    private PixelWorks impl;
    private boolean mIsEnablePxlw;

    /* loaded from: classes6.dex */
    private static class Holder {
        private static final GmCgPxlwManager INSTANCE = new GmCgPxlwManager();

        Holder() {
        }
    }

    public static GmCgPxlwManager get() {
        return Holder.INSTANCE;
    }

    public void enablePxlw(boolean z16) {
        this.mIsEnablePxlw = z16;
    }

    public void init(PixelWorks pixelWorks) {
        if (this.impl == null && this.mIsEnablePxlw) {
            this.impl = pixelWorks;
        }
    }

    public boolean isEnablePxlw() {
        return this.mIsEnablePxlw;
    }

    public boolean isHardwareSupport() {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null && pixelWorks.isHardwareSupport()) {
            return true;
        }
        return false;
    }

    public boolean isServiceSupport() {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null && pixelWorks.isServiceSupport()) {
            return true;
        }
        return false;
    }

    public boolean isSupportFrc() {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null && pixelWorks.isSupportFrc()) {
            return true;
        }
        return false;
    }

    public boolean isSupportSr() {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null && pixelWorks.isSupportSr()) {
            return true;
        }
        return false;
    }

    public void load(Activity activity) {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null) {
            pixelWorks.load(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPxlwFpsUpdated(int i3) {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null) {
            pixelWorks.onPxlwFpsUpdated(i3);
        }
    }

    public void setFrcFps(int i3) {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null) {
            pixelWorks.setFrcFps(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSrSize(int i3, int i16) {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null) {
            pixelWorks.setSrSize(i3, i16);
        }
    }

    public void turnFrcStatic(boolean z16) {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null) {
            pixelWorks.turnFrcStatic(z16, false);
        }
    }

    public void turnSr(boolean z16) {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks == null) {
            return;
        }
        if (z16) {
            pixelWorks.turnOnSr(false);
        } else {
            pixelWorks.turnOffSr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unload() {
        PixelWorks pixelWorks = this.impl;
        if (pixelWorks != null) {
            pixelWorks.unload();
        }
    }

    GmCgPxlwManager() {
        this.mIsEnablePxlw = false;
    }
}
