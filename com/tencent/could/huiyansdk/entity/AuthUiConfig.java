package com.tencent.could.huiyansdk.entity;

import android.graphics.drawable.Drawable;
import com.tencent.could.huiyansdk.enums.VideoSize;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AuthUiConfig {
    static IPatchRedirector $redirector_;
    private int authCircleCorrectColor;
    private int authCircleErrorColor;
    private int authLayoutBgColor;
    private int authLayoutResId;
    private int authWithLongCheck720LayoutResId;
    private int feedBackErrorColor;
    private int feedBackExtraTipColor;
    private int feedBackTxtColor;
    private boolean isCancelBtnRight;
    private boolean isHiddenExtraTipsTxt;
    private boolean isHideAvatarGuideFrame;
    private boolean isHideFrontCircleViewOnCheck;
    private boolean isHideFrontCircleViewOnReflect;
    private boolean isHideFrontCircleViewOnStart;
    private boolean isShowCountdown;
    private boolean isShowErrorDialog;
    private boolean isTransparentStatusBar;
    private int landAuthLayoutResId;
    private int mainActivityThemeId;
    private Drawable prepareImageViewDrawable;
    private int statusBarColor;
    private int transparentStatusBarMoveHeight;
    private boolean useDeepColorStatusBarIcon;
    private VideoSize videoSize;

    public AuthUiConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.videoSize = VideoSize.SIZE_480P;
        this.isShowCountdown = true;
        this.isShowErrorDialog = true;
        this.authLayoutResId = -1;
        this.landAuthLayoutResId = -1;
        this.authWithLongCheck720LayoutResId = -1;
        this.feedBackErrorColor = -1;
        this.feedBackExtraTipColor = -1;
        this.feedBackTxtColor = -1;
        this.authCircleErrorColor = -1;
        this.authCircleCorrectColor = -1;
        this.authLayoutBgColor = -1;
        this.mainActivityThemeId = -1;
        this.isCancelBtnRight = false;
        this.prepareImageViewDrawable = null;
        this.isHiddenExtraTipsTxt = false;
        this.statusBarColor = -1;
        this.isTransparentStatusBar = false;
        this.transparentStatusBarMoveHeight = 15;
        this.useDeepColorStatusBarIcon = false;
        this.isHideFrontCircleViewOnStart = false;
        this.isHideFrontCircleViewOnCheck = false;
        this.isHideFrontCircleViewOnReflect = false;
        this.isHideAvatarGuideFrame = false;
    }

    public int getAuthCircleCorrectColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.authCircleCorrectColor;
    }

    public int getAuthCircleErrorColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.authCircleErrorColor;
    }

    public int getAuthLayoutBgColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.authLayoutBgColor;
    }

    public int getAuthLayoutResId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.authLayoutResId;
    }

    public int getAuthWithLongCheck720LayoutResId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return this.authWithLongCheck720LayoutResId;
    }

    public int getFeedBackErrorColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.feedBackErrorColor;
    }

    public int getFeedBackExtraTipColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        return this.feedBackExtraTipColor;
    }

    public int getFeedBackTxtColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.feedBackTxtColor;
    }

    public int getLandAuthLayoutResId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.landAuthLayoutResId;
    }

    public int getMainActivityThemeId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.mainActivityThemeId;
    }

    public Drawable getPrepareImageViewDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Drawable) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.prepareImageViewDrawable;
    }

    public int getStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return this.statusBarColor;
    }

    public int getTransparentStatusBarMoveHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return this.transparentStatusBarMoveHeight;
    }

    public VideoSize getVideoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (VideoSize) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.videoSize;
    }

    public boolean isCancelBtnRight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.isCancelBtnRight;
    }

    public boolean isHiddenExtraTipsTxt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.isHiddenExtraTipsTxt;
    }

    public boolean isHideAvatarGuideFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        return this.isHideAvatarGuideFrame;
    }

    public boolean isHideFrontCircleViewOnCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return this.isHideFrontCircleViewOnCheck;
    }

    public boolean isHideFrontCircleViewOnReflect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        return this.isHideFrontCircleViewOnReflect;
    }

    public boolean isHideFrontCircleViewOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return this.isHideFrontCircleViewOnStart;
    }

    public boolean isShowCountdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isShowCountdown;
    }

    public boolean isShowErrorDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isShowErrorDialog;
    }

    public boolean isTransparentStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.isTransparentStatusBar;
    }

    public boolean isUseDeepColorStatusBarIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.useDeepColorStatusBarIcon;
    }

    public void setAuthCircleCorrectColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.authCircleCorrectColor = i3;
        }
    }

    public void setAuthCircleErrorColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.authCircleErrorColor = i3;
        }
    }

    public void setAuthLayoutBgColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.authLayoutBgColor = i3;
        }
    }

    public void setAuthLayoutResId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.authLayoutResId = i3;
        }
    }

    public void setAuthWithLongCheck720LayoutResId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
        } else {
            this.authWithLongCheck720LayoutResId = i3;
        }
    }

    public void setCancelBtnRight(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.isCancelBtnRight = z16;
        }
    }

    public void setFeedBackErrorColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.feedBackErrorColor = i3;
        }
    }

    public void setFeedBackExtraTipColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, i3);
        } else {
            this.feedBackExtraTipColor = i3;
        }
    }

    public void setFeedBackTxtColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.feedBackTxtColor = i3;
        }
    }

    public void setHiddenExtraTipsTxt(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.isHiddenExtraTipsTxt = z16;
        }
    }

    public void setHideAvatarGuideFrame(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
        } else {
            this.isHideAvatarGuideFrame = z16;
        }
    }

    public void setHideFrontCircleViewOnCheck(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else {
            this.isHideFrontCircleViewOnCheck = z16;
        }
    }

    public void setHideFrontCircleViewOnReflect(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
        } else {
            this.isHideFrontCircleViewOnReflect = z16;
        }
    }

    public void setHideFrontCircleViewOnStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, z16);
        } else {
            this.isHideFrontCircleViewOnStart = z16;
        }
    }

    public void setLandAuthLayoutResId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
        } else {
            this.landAuthLayoutResId = i3;
        }
    }

    public void setMainActivityThemeId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.mainActivityThemeId = i3;
        }
    }

    public void setPrepareImageViewDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) drawable);
        } else {
            this.prepareImageViewDrawable = drawable;
        }
    }

    public void setShowCountdown(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.isShowCountdown = z16;
        }
    }

    public void setShowErrorDialog(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isShowErrorDialog = z16;
        }
    }

    public void setStatusBarColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            this.statusBarColor = i3;
        }
    }

    public void setTransparentStatusBar(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
        } else {
            this.isTransparentStatusBar = z16;
        }
    }

    public void setTransparentStatusBarMoveHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
        } else {
            this.transparentStatusBarMoveHeight = i3;
        }
    }

    public void setUseDeepColorStatusBarIcon(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
        } else {
            this.useDeepColorStatusBarIcon = z16;
        }
    }

    public void setVideoSize(VideoSize videoSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) videoSize);
        } else {
            this.videoSize = videoSize;
        }
    }
}
