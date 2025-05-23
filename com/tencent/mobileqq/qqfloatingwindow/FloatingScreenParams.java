package com.tencent.mobileqq.qqfloatingwindow;

import android.content.res.Resources;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class FloatingScreenParams implements Cloneable {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_LENGTH = 500;
    public static final float DEFAULT_SCREEN_RATIO = 0.5625f;
    private static final float HORIZONTAL_MAX = 0.92f;
    private static final float HORIZONTAL_MIN = 0.5f;
    public static final String QQFS_SP_NAME = "qqfs_floating_sp";
    public static final int SHAPE_CUSTOM = 4;
    public static final int SHAPE_HORIZONTAL = 1;
    public static final int SHAPE_SQUARE = 3;
    public static final int SHAPE_VERTICAL = 2;
    private static final float SQUARE_MAX = 0.6f;
    private static final float SQUARE_MIN = 0.24f;
    private static final float VERTICAL_MAX = 0.6f;
    private static final float VERTICAL_MIN = 0.24f;
    private static boolean mShowPadding;
    private boolean mCanMove;
    private boolean mCanZoom;
    private int mCustomHeight;
    private int mCustomWidth;
    private int mFloatingCenterX;
    private int mFloatingCenterY;
    private boolean mHasZoomed;
    private int mHeight;
    private int mHorizontalWidthMax;
    private int mHorizontalWidthMin;
    private int mInitialHeight;
    private int mInitialWidth;
    private int mOuterPadding;
    private int mRoundCorner;
    private int mScreenLonger;
    private float mScreenRatio;
    private int mShapeType;
    private int mSquareLength;
    private int mSquareWidthMax;
    private int mSquareWidthMin;
    private int mVerticalWidthMax;
    private int mVerticalWidthMin;
    private int mWidth;
    private int mWindowFlags;
    private float mZoomRatio;

    /* loaded from: classes16.dex */
    public static class FloatingBuilder {
        static IPatchRedirector $redirector_ = null;
        private static final int INVALID_FLOATING_XY = Integer.MIN_VALUE;
        private boolean canMove;
        private boolean canZoom;
        private int customHeight;
        private int customWidth;
        private int floatingCenterX;
        private int floatingCenterY;
        private float ratio;
        private int roundCorner;
        private int shapeType;
        private int windowFlag;

        public FloatingBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.canMove = true;
            this.canZoom = true;
            this.floatingCenterX = Integer.MIN_VALUE;
            this.floatingCenterY = Integer.MIN_VALUE;
            this.ratio = 0.5625f;
            this.roundCorner = -1;
        }

        public FloatingScreenParams build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (FloatingScreenParams) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            FloatingScreenParams floatingScreenParams = new FloatingScreenParams();
            floatingScreenParams.setScreenRatio(this.ratio);
            floatingScreenParams.setCustomSize(this.customWidth, this.customHeight);
            floatingScreenParams.setShapeType(this.shapeType);
            floatingScreenParams.setCanMove(this.canMove);
            floatingScreenParams.setCanZoom(this.canZoom);
            floatingScreenParams.setWindowFlags(this.windowFlag);
            int i3 = this.roundCorner;
            if (i3 >= 0) {
                floatingScreenParams.setRoundCorner(i3);
            }
            int i16 = this.floatingCenterX;
            if (i16 != Integer.MIN_VALUE) {
                floatingScreenParams.setFloatingCenterX(i16);
            }
            int i17 = this.floatingCenterY;
            if (i17 != Integer.MIN_VALUE) {
                floatingScreenParams.setFloatingCenterY(i17);
            }
            return floatingScreenParams;
        }

        public FloatingBuilder setCanMove(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.canMove = z16;
            return this;
        }

        public FloatingBuilder setCanZoom(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.canZoom = z16;
            return this;
        }

        public FloatingBuilder setCustomSize(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            this.customWidth = i3;
            this.customHeight = i16;
            return this;
        }

        public FloatingBuilder setFloatingCenter(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            this.floatingCenterX = i3;
            this.floatingCenterY = i16;
            return this;
        }

        @Deprecated
        public FloatingBuilder setIsHorizontal(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            return setShapeType(i3);
        }

        public FloatingBuilder setRatio(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            }
            if (f16 > 0.0f) {
                this.ratio = f16;
            } else {
                this.ratio = 0.5625f;
            }
            return this;
        }

        public FloatingBuilder setRoundCorner(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.roundCorner = i3;
            return this;
        }

        public FloatingBuilder setShapeType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.shapeType = i3;
            return this;
        }

        public FloatingBuilder setWindowFlags(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (FloatingBuilder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.windowFlag = i3;
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            mShowPadding = true;
        }
    }

    FloatingScreenParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mScreenLonger = 500;
        this.mSquareLength = 300;
        this.mScreenRatio = 0.5625f;
        this.mInitialWidth = 500;
        this.mInitialHeight = 500;
        this.mHasZoomed = false;
        this.mZoomRatio = 1.0f;
        this.mRoundCorner = 24;
        this.mOuterPadding = 2;
        this.mFloatingCenterX = 0;
        this.mFloatingCenterY = 200;
        this.mCanMove = true;
        this.mCanZoom = true;
        this.mShapeType = 1;
        this.mWindowFlags = 0;
        this.mHorizontalWidthMax = 500;
        this.mHorizontalWidthMin = 500;
        this.mVerticalWidthMax = 500;
        this.mVerticalWidthMin = 500;
        this.mSquareWidthMax = 500;
        this.mSquareWidthMin = 500;
        initParam();
    }

    private int getFixedWith(int i3, int i16, int i17) {
        return Math.max(i17, Math.min(i3, i16));
    }

    private float getZoomRatio() {
        return this.mZoomRatio;
    }

    private void initMaxWidth(int i3) {
        float f16 = i3;
        this.mHorizontalWidthMax = (int) (HORIZONTAL_MAX * f16);
        this.mHorizontalWidthMin = (int) (0.5f * f16);
        int i16 = (int) (0.6f * f16);
        this.mVerticalWidthMax = i16;
        int i17 = (int) (f16 * 0.24f);
        this.mVerticalWidthMin = i17;
        this.mSquareWidthMax = i16;
        this.mSquareWidthMin = i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanMove(boolean z16) {
        this.mCanMove = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanZoom(boolean z16) {
        this.mCanZoom = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoundCorner(int i3) {
        this.mRoundCorner = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWindowFlags(int i3) {
        this.mWindowFlags = i3;
    }

    public boolean getCanMove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.mCanMove;
    }

    public boolean getCanZoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.mCanZoom;
    }

    public int getFloatingCenterX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mFloatingCenterX;
    }

    public int getFloatingCenterY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mFloatingCenterY;
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    public int getInitialHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        try {
            return (int) Math.ceil(getHeight() / getZoomRatio());
        } catch (Exception unused) {
            return getHeight();
        }
    }

    public int getInitialWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        try {
            return (int) Math.ceil(getWidth() / getZoomRatio());
        } catch (Exception unused) {
            return getWidth();
        }
    }

    public int getInnerRoundCorner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        if (mShowPadding) {
            return this.mRoundCorner - this.mOuterPadding;
        }
        return this.mRoundCorner;
    }

    public int getOuterHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        if (mShowPadding) {
            return this.mHeight + (this.mOuterPadding * 2);
        }
        return this.mHeight;
    }

    public int getOuterRoundCorner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.mRoundCorner;
    }

    public int getOuterWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        if (mShowPadding) {
            return this.mWidth + (this.mOuterPadding * 2);
        }
        return this.mWidth;
    }

    public int getReboundSize() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        int width = getWidth();
        int shapeType = getShapeType();
        if (shapeType != 2) {
            if (shapeType != 3) {
                int i18 = this.mHorizontalWidthMax;
                int i19 = this.mCustomWidth;
                if (i19 > 0) {
                    i17 = Math.min(this.mHorizontalWidthMin, i19);
                } else {
                    i17 = this.mHorizontalWidthMin;
                }
                return getFixedWith(width, i18, i17);
            }
            int i26 = this.mSquareWidthMax;
            int i27 = this.mCustomWidth;
            if (i27 > 0) {
                i16 = Math.min(this.mSquareWidthMin, i27);
            } else {
                i16 = this.mSquareWidthMin;
            }
            return getFixedWith(width, i26, i16);
        }
        int i28 = this.mVerticalWidthMax;
        int i29 = this.mCustomWidth;
        if (i29 > 0) {
            i3 = Math.min(this.mVerticalWidthMin, i29);
        } else {
            i3 = this.mVerticalWidthMin;
        }
        return getFixedWith(width, i28, i3);
    }

    int getRoundCorner() {
        return this.mRoundCorner;
    }

    public float getScreenRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.mScreenRatio;
    }

    public int getShapeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mShapeType;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    public int getWindowFlags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mWindowFlags;
    }

    public void initParam() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Resources resources = BaseApplication.getContext().getResources();
        if (resources != null) {
            this.mScreenLonger = resources.getDimensionPixelSize(R.dimen.b7x);
            this.mSquareLength = resources.getDimensionPixelSize(R.dimen.f159495b92);
            this.mRoundCorner = resources.getDimensionPixelSize(R.dimen.b7y);
            this.mOuterPadding = resources.getDimensionPixelSize(R.dimen.b7z);
        }
        int i16 = this.mScreenLonger;
        this.mWidth = i16;
        this.mHeight = (int) (i16 * this.mScreenRatio);
        if (QLog.isColorLevel()) {
            QLog.d("FSParams", 2, "param corner:", Integer.valueOf(this.mRoundCorner), ", pad:", Integer.valueOf(this.mOuterPadding), ", width:", Integer.valueOf(this.mWidth), ", height:", Integer.valueOf(this.mHeight));
        }
        WindowManager windowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
        if (windowManager != null) {
            int height = windowManager.getDefaultDisplay().getHeight();
            int width = windowManager.getDefaultDisplay().getWidth();
            int i17 = (height / 2) - 214;
            int i18 = this.mHeight;
            if (i17 - (i18 / 2) > 0) {
                i3 = i17 - (i18 / 2);
            } else {
                i3 = 200;
            }
            this.mFloatingCenterY = i3;
            initMaxWidth(width);
        }
    }

    public boolean isHasZoomed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return this.mHasZoomed;
    }

    public void resetParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            updateZoomRatio(1.0f);
            this.mHasZoomed = false;
        }
    }

    public void setCustomSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mCustomWidth = i3;
            this.mCustomHeight = i16;
        }
    }

    public void setFloatingCenterX(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mFloatingCenterX = i3;
        }
    }

    public void setFloatingCenterY(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.mFloatingCenterY = i3;
        }
    }

    public void setHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mHeight = i3;
        }
    }

    public void setScreenLonger(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mScreenLonger = i3;
        }
    }

    public void setScreenRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else if (this.mScreenRatio != f16) {
            this.mScreenRatio = f16;
            setShapeType(this.mShapeType);
        }
    }

    public void setShapeType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        if (i3 < 1 || i3 > 4) {
            i3 = 1;
        }
        this.mShapeType = i3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        setWidth(this.mCustomWidth);
                        setHeight(this.mCustomHeight);
                        return;
                    }
                    return;
                }
                setWidth(this.mSquareLength);
                setHeight(this.mSquareLength);
                return;
            }
            setWidth((int) (this.mScreenLonger * this.mScreenRatio));
            setHeight(this.mScreenLonger);
            return;
        }
        setWidth(this.mScreenLonger);
        setHeight((int) (this.mScreenLonger * this.mScreenRatio));
    }

    public void setShowPadding(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            mShowPadding = z16;
        }
    }

    public void setWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mWidth = i3;
        }
    }

    public void updateZoomRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
            return;
        }
        if (!this.mHasZoomed) {
            this.mInitialWidth = getWidth();
            this.mInitialHeight = getHeight();
            this.mZoomRatio = 1.0f;
            this.mHasZoomed = true;
        }
        int i3 = (int) (this.mInitialWidth * f16);
        int i16 = (int) (this.mInitialHeight * f16);
        setWidth(i3);
        setHeight(i16);
        int shapeType = getShapeType();
        if (shapeType != 1) {
            if (shapeType != 2) {
                if (shapeType == 3) {
                    this.mSquareLength = i3;
                }
            } else {
                this.mScreenLonger = i16;
            }
        } else {
            this.mScreenLonger = i3;
        }
        this.mZoomRatio = f16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FloatingScreenParams m216clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (FloatingScreenParams) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        try {
            return (FloatingScreenParams) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
