package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class FaceDrawable extends AsynLoadDrawable implements DecodeCompletionListener, IZplanOutboundAvatar {
    static IPatchRedirector $redirector_ = null;
    private static final int AVATAR_SQUARE_RADIUS = 10;
    private static final String TAG = "Q.qqhead.FaceDrawable";
    private boolean addWhiteBorder;
    private Paint borderPaint;
    private boolean isHideZplanAvatar;
    boolean isSupportMaskView;
    boolean mCancelled;
    protected FaceInfo mFaceInfo;
    OnLoadingStateChangeListener mListener;
    Paint mMaskPaint;
    private Paint outboundsBgPaint;
    private Path path;
    private long showAvatarAtTime;
    RectF tempRectF;
    private Handler uiHandler;
    private URLDrawable zplanFaceBg;
    private URLDrawable.URLDrawableListener zplanFaceBgListener;
    private int zplanOutboundSceneId;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface OnLoadingStateChangeListener {
        void onLoadingStateChanged(int i3, int i16);
    }

    protected FaceDrawable() {
        super(null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.tempRectF = new RectF();
        this.isSupportMaskView = false;
        this.addWhiteBorder = false;
        this.zplanOutboundSceneId = 0;
        this.isHideZplanAvatar = false;
        this.showAvatarAtTime = 0L;
        this.outboundsBgPaint = new Paint(1);
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.path = new Path();
        this.zplanFaceBg = null;
        this.zplanFaceBgListener = new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.app.face.FaceDrawable.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FaceDrawable.this);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) uRLDrawable);
                } else {
                    QLog.e(FaceDrawable.TAG, 1, "onLoadCanceled ");
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
                    return;
                }
                QLog.e(FaceDrawable.TAG, 1, "onLoadFialed");
                if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isToggleBugfix106568443Enable()) {
                    FaceDrawable.this.invalidateSelf();
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                } else {
                    FaceDrawable.this.invalidateSelf();
                }
            }
        };
        this.borderPaint = new Paint(1);
    }

    private Drawable createLoadedDrawable(Bitmap bitmap) {
        if (bitmap == null) {
            QLog.e(TAG, 1, "createLoadedDrawable bitmap is null");
        }
        FaceInfo faceInfo = this.mFaceInfo;
        if (faceInfo != null && faceInfo.isUserHeadType() && this.mFaceInfo.isRealLoadZplanStaticAvatar()) {
            int i3 = this.zplanOutboundSceneId;
            if (i3 != 101 && i3 != 100) {
                return new BitmapDrawable(BaseApplication.getContext().getResources(), bitmap);
            }
            ZplanAvatarAnimateDrawable zplanAvatarAnimateDrawable = new ZplanAvatarAnimateDrawable(BaseApplication.getContext().getResources(), bitmap, this.isHideZplanAvatar);
            zplanAvatarAnimateDrawable.setParentCallback(this);
            return zplanAvatarAnimateDrawable;
        }
        return new BitmapDrawable(BaseApplication.getContext().getResources(), bitmap);
    }

    private void disableClipOnParents() {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            com.tencent.mobileqq.avatar.utils.g.b(view);
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.mobileqq.app.face.FaceDrawable.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceDrawable.this);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2);
                    } else {
                        com.tencent.mobileqq.avatar.utils.g.b(view2);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) view2);
                    } else {
                        com.tencent.mobileqq.avatar.utils.g.d(view2);
                    }
                }
            });
        }
    }

    public static FaceDrawable getFaceDrawable(AppInterface appInterface, int i3, String str, int i16, Drawable drawable, Drawable drawable2) {
        return getFaceDrawable(appInterface, i3, str, i16, drawable, drawable2, null);
    }

    public static FaceDrawable getFaceDrawableFrom(AppInterface appInterface, int i3, String str, int i16, Drawable drawable, Drawable drawable2, int i17) {
        return getFaceDrawable(appInterface, i3, str, i16, drawable, drawable2, null);
    }

    private static byte getFaceShapeType(int i3) {
        if (i3 == 115) {
            return (byte) 4;
        }
        return (byte) 3;
    }

    public static FaceDrawable getMobileFaceDrawable(AppInterface appInterface, String str, byte b16) {
        Drawable defaultDrawable = getDefaultDrawable(11, b16);
        return getFaceDrawable(appInterface, 11, str, b16, defaultDrawable, defaultDrawable);
    }

    public static String getOpenIdUrl(String str, String str2) {
        return "https://q.qlogo.cn/qqapp/" + str2 + "/" + str + "/100";
    }

    public static FaceDrawable getOutboundUserFaceDrawable(AppInterface appInterface, String str, byte b16) {
        return getOutboundUserFaceDrawable(appInterface, str, b16, 1);
    }

    public static FaceDrawable getStrangerFaceDrawable(AppInterface appInterface, int i3, String str, boolean z16) {
        return getStrangerFaceDrawable(appInterface, i3, str, z16, false);
    }

    private URLDrawable getURLDrawable(String str) {
        URLDrawable drawable;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[getURLDrawable] url is empty");
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        updateUrlDrawableOptionsDimens(obtain);
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        try {
            if (str.startsWith("/storage/")) {
                drawable = URLDrawable.getFileDrawable(str, obtain);
            } else {
                drawable = URLDrawable.getDrawable(str, obtain);
            }
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            } else if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).enableSetBgDrawableDimens() && drawable.getStatus() == 0) {
                drawable.startDownload();
            }
            return drawable;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getDrawable: " + str, th5);
            return null;
        }
    }

    public static FaceDrawable getUserFaceDrawable(AppInterface appInterface, String str, byte b16) {
        Drawable defaultDrawable = getDefaultDrawable(1, b16);
        return getFaceDrawable(appInterface, 1, str, b16, defaultDrawable, defaultDrawable);
    }

    private void setImageViewScaleType() {
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ((ImageView) callback).setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    private void updateUrlDrawableOptionsDimens(URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (!((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).enableSetBgDrawableDimens() || uRLDrawableOptions == null) {
            return;
        }
        Rect bounds = getBounds();
        if (bounds != null) {
            int width = bounds.width();
            int height = bounds.height();
            if (width > 0 && height > 0) {
                uRLDrawableOptions.mRequestWidth = width;
                uRLDrawableOptions.mRequestHeight = height;
                return;
            }
        }
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            int width2 = imageView.getWidth();
            int height2 = imageView.getHeight();
            if (width2 > 0 && height2 > 0) {
                uRLDrawableOptions.mRequestWidth = width2;
                uRLDrawableOptions.mRequestHeight = height2;
                return;
            }
        }
        uRLDrawableOptions.mRequestWidth = 200;
        uRLDrawableOptions.mRequestHeight = 200;
    }

    private void zplanAvatarOnDraw(Canvas canvas) {
        disableClipOnParents();
        setImageViewScaleType();
        int i3 = this.zplanOutboundSceneId;
        if ((i3 == 102 || i3 == 100) && this.tempRectF.width() != this.tempRectF.height()) {
            QLog.e(TAG, 1, "zplanAvatarOnDraw drawable bounds error: " + this.tempRectF);
            return;
        }
        if (this.mCurState != 1) {
            super.draw(canvas);
            return;
        }
        if (this.zplanFaceBg == null) {
            URLDrawable uRLDrawable = getURLDrawable(this.mFaceInfo.zplanFaceBgUrl);
            this.zplanFaceBg = uRLDrawable;
            if (uRLDrawable != null) {
                uRLDrawable.setURLDrawableListener(this.zplanFaceBgListener);
            }
        }
        URLDrawable uRLDrawable2 = this.zplanFaceBg;
        if (uRLDrawable2 != null) {
            if (uRLDrawable2.getStatus() != 4 && this.zplanFaceBg.getStatus() != 1) {
                if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isToggleBugfix106568443Enable()) {
                    try {
                        canvas.drawArc(this.tempRectF, 0.0f, 360.0f, true, this.outboundsBgPaint);
                        canvas.save();
                        com.tencent.mobileqq.avatar.utils.g.a(canvas, this.path, this.tempRectF.width(), this.tempRectF.height(), this.mFaceInfo.zplanFaceClipPercent / 100.0f);
                        super.draw(canvas);
                        canvas.restore();
                        return;
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "zplanAvatarOnDraw catch exception", e16);
                    }
                }
            } else {
                this.zplanFaceBg.setBounds(getBounds());
                this.path.reset();
                this.path.addArc(this.tempRectF, 0.0f, 360.0f);
                canvas.save();
                canvas.clipPath(this.path);
                this.zplanFaceBg.draw(canvas);
                canvas.restore();
                if (this.addWhiteBorder) {
                    canvas.drawArc(this.tempRectF, 0.0f, 360.0f, true, this.borderPaint);
                }
                canvas.save();
                com.tencent.mobileqq.avatar.utils.g.a(canvas, this.path, this.tempRectF.width(), this.tempRectF.height(), this.mFaceInfo.zplanFaceClipPercent / 100.0f);
                super.draw(canvas);
                canvas.restore();
                return;
            }
        }
        Drawable drawable = this.mLoadingDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.tencent.mobileqq.util.AsynLoadDrawable
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!this.mCancelled) {
            this.mCancelled = true;
            this.mFaceInfo = null;
            this.mFailureDrawable = null;
            this.mLoadedDrawable = null;
            this.mLoadingDrawable = null;
            setCallback(null);
            this.mListener = null;
            setApp(null);
            this.uiHandler.removeCallbacksAndMessages(null);
        }
        super.cancel();
    }

    public boolean checkZplanOutboundAvatarState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        FaceInfo faceInfo = this.mFaceInfo;
        if (faceInfo != null && faceInfo.isRealLoadZplanStaticAvatar() && (this.mLoadedDrawable instanceof ZplanAvatarAnimateDrawable) && this.mCurState == 1) {
            return true;
        }
        return false;
    }

    public void disableZplanOutbound() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        FaceInfo faceInfo = this.mFaceInfo;
        if (faceInfo != null) {
            if (faceInfo.isEnableZplanOutbound()) {
                this.mFaceInfo.setEnableZplanOutbound(false);
                requestDecode();
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "setForbidZplanOutbound FaceInfo is null");
    }

    @Override // com.tencent.mobileqq.util.AsynLoadDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        FaceInfo faceInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) canvas);
            return;
        }
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && (faceInfo = this.mFaceInfo) != null && faceInfo.isSupportStaticZplanAvatarInfo() && this.mFaceInfo.isEnableZplanOutbound()) {
            this.tempRectF.set(getBounds());
            zplanAvatarOnDraw(canvas);
            return;
        }
        if (this.isSupportMaskView && QQTheme.isNowThemeIsNight()) {
            this.tempRectF.set(getBounds());
            FaceInfo faceInfo2 = this.mFaceInfo;
            if (faceInfo2 != null && faceInfo2.shape == 1) {
                super.draw(canvas);
                canvas.drawRoundRect(this.tempRectF, 10.0f, 10.0f, this.mMaskPaint);
                return;
            } else {
                super.draw(canvas);
                RectF rectF = this.tempRectF;
                canvas.drawRoundRect(rectF, rectF.centerX(), this.tempRectF.centerY(), this.mMaskPaint);
                return;
            }
        }
        super.draw(canvas);
    }

    public void enableZplanOutbound(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        FaceInfo faceInfo = this.mFaceInfo;
        if (faceInfo != null) {
            this.zplanOutboundSceneId = i3;
            if (!faceInfo.isEnableZplanOutbound() && ((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).checkOutboundHeadSceneEnable(i3)) {
                this.mFaceInfo.setEnableZplanOutbound(true);
                requestDecode();
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "setForbidZplanOutbound FaceInfo is null");
    }

    protected abstract Bitmap getBitmapFromCache();

    protected abstract Bitmap getBitmapFromCache(boolean z16);

    @Override // com.tencent.mobileqq.util.AsynLoadDrawable
    public Drawable getDefaultDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? getDefaultDrawable(1, 3) : (Drawable) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    @Nullable
    public String getZPlanAvatarBackgroundUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        FaceInfo faceInfo = this.mFaceInfo;
        if (faceInfo == null) {
            return "";
        }
        return faceInfo.zplanFaceBgUrl;
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public void hideZplanAvatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            hideZplanAvatar(0L);
        } else {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public boolean isShowZplanOutboundAvatar() {
        FaceInfo faceInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && (faceInfo = this.mFaceInfo) != null && faceInfo.isSupportStaticZplanAvatarInfo() && this.mFaceInfo.isEnableZplanOutbound()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public boolean isSupportZPlanOutboundAvatar() {
        FaceInfo faceInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn() && (faceInfo = this.mFaceInfo) != null && faceInfo.isSupportStaticZplanAvatarInfo()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.util.AsynLoadDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) rect);
            return;
        }
        if (this.mCurState == 1) {
            Drawable createLoadedDrawable = createLoadedDrawable(((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDrawableBitmap(this.mLoadedDrawable));
            this.mLoadedDrawable = createLoadedDrawable;
            createLoadedDrawable.setBounds(rect);
            int i3 = this.mAlpha;
            if (i3 != -1) {
                this.mLoadedDrawable.setAlpha(i3);
            }
            invalidateSelf();
            return;
        }
        super.onBoundsChange(rect);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x005d, code lost:
    
        if (r5.mCurState != 2) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    @Override // com.tencent.mobileqq.app.face.DecodeCompletionListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDecodeTaskCompleted(FaceInfo faceInfo, Bitmap bitmap) {
        boolean z16;
        FaceInfo faceInfo2;
        FaceInfo faceInfo3;
        Drawable drawable;
        OnLoadingStateChangeListener onLoadingStateChangeListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) faceInfo, (Object) bitmap);
            return;
        }
        boolean z17 = false;
        if (!this.mCancelled && faceInfo != null && (faceInfo3 = this.mFaceInfo) != null && faceInfo.equals(faceInfo3)) {
            if (faceInfo.isRealLoadZplanStaticAvatar() != this.mFaceInfo.isRealLoadZplanStaticAvatar()) {
                QLog.e(TAG, 1, "onDecodeTaskCompleted outbound state change");
                return;
            }
            FaceInfo faceInfo4 = this.mFaceInfo;
            faceInfo4.staticZplanFaceFlag = faceInfo.staticZplanFaceFlag;
            faceInfo4.dynamicZplanFaceFlag = faceInfo.dynamicZplanFaceFlag;
            faceInfo4.zplanFaceBgUrl = faceInfo.zplanFaceBgUrl;
            if (bitmap != null) {
                drawable = createLoadedDrawable(bitmap);
            } else {
                drawable = null;
            }
            if (drawable != null) {
                this.mLoadedDrawable = drawable;
            } else {
                if (this.mLoadedDrawable == null) {
                }
                if (z17) {
                    return;
                }
                int i3 = this.mCurState;
                Drawable drawable2 = this.mLoadedDrawable;
                if (drawable2 != null) {
                    this.mCurState = 1;
                    int i16 = this.mAlpha;
                    if (i16 != -1) {
                        drawable2.setAlpha(i16);
                    }
                    if (this.mColorFilter != null && !isShowZplanOutboundAvatar()) {
                        this.mLoadedDrawable.setColorFilter(this.mColorFilter);
                    }
                    this.mLoadedDrawable.setVisible(isVisible(), true);
                    this.mLoadedDrawable.setBounds(getBounds());
                } else {
                    this.mCurState = 2;
                    Drawable drawable3 = this.mFailureDrawable;
                    if (drawable3 != null) {
                        int i17 = this.mAlpha;
                        if (i17 != -1) {
                            drawable3.setAlpha(i17);
                        }
                        ColorFilter colorFilter = this.mColorFilter;
                        if (colorFilter != null) {
                            this.mFailureDrawable.setColorFilter(colorFilter);
                        }
                        this.mFailureDrawable.setVisible(isVisible(), true);
                        this.mFailureDrawable.setBounds(getBounds());
                    }
                }
                invalidateSelf();
                int i18 = this.mCurState;
                if (i3 != i18 && (onLoadingStateChangeListener = this.mListener) != null) {
                    onLoadingStateChangeListener.onLoadingStateChanged(i3, i18);
                    return;
                }
                return;
            }
            z17 = true;
            if (z17) {
            }
        } else if (!this.mCancelled) {
            if (faceInfo != null && (faceInfo2 = this.mFaceInfo) != null) {
                if (!faceInfo.equals(faceInfo2)) {
                    QLog.e(TAG, 1, "onDecodeTaskCompleted faceInfo change: " + faceInfo + " /" + this.mFaceInfo);
                    return;
                }
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onDecodeTaskCompleted faceInfo null. (");
            if (faceInfo == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(",");
            if (this.mFaceInfo == null) {
                z17 = true;
            }
            sb5.append(z17);
            sb5.append(")");
            QLog.e(TAG, 1, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.app.face.DecodeCompletionListener
    public void onDecodeTaskCompletedNeedDownload(FaceInfo faceInfo) {
        FaceInfo faceInfo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) faceInfo);
        } else if (!this.mCancelled && faceInfo != null && (faceInfo2 = this.mFaceInfo) != null && faceInfo.equals(faceInfo2)) {
            onNeedDownload();
        }
    }

    protected abstract void onNeedDownload();

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public void preloadOutboundResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    protected abstract boolean requestDecode();

    public void setAddWhiteBorder(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else if (i3 > 0) {
            this.addWhiteBorder = true;
            this.borderPaint.setStrokeWidth(i3);
        } else {
            this.addWhiteBorder = false;
            this.borderPaint.setStrokeWidth(0.0f);
        }
    }

    protected abstract void setApp(AppInterface appInterface);

    public void setSupportMaskView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.isSupportMaskView = z16;
        }
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public void showZplanAvatar(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
            return;
        }
        this.isHideZplanAvatar = false;
        this.showAvatarAtTime = 0L;
        if (!checkZplanOutboundAvatarState()) {
            return;
        }
        QLog.i(TAG, 1, "showZplanAvatar: " + j3);
        if (this.mLoadedDrawable instanceof ZplanAvatarAnimateDrawable) {
            this.uiHandler.removeCallbacksAndMessages(null);
            ((ZplanAvatarAnimateDrawable) this.mLoadedDrawable).showAvatar(j3);
        }
    }

    public static Drawable getDefaultDrawable(int i3, int i16) {
        if (i3 == 4) {
            return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDefaultTroopFaceDrawable();
        }
        if (i3 == 113 || i3 == 101 || i3 == 1001) {
            return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDefaultDiscusionFaceDrawable();
        }
        if (i3 == 115) {
            return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
        }
        if (i16 == 1) {
            return new ColorDrawable(Color.parseColor("#ebe9e9"));
        }
        return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
    }

    public static FaceDrawable getFaceDrawable(AppInterface appInterface, int i3, String str, int i16, Drawable drawable, Drawable drawable2, OnLoadingStateChangeListener onLoadingStateChangeListener) {
        return getFaceDrawable(appInterface, i3, str, i16, drawable, drawable2, onLoadingStateChangeListener, false, false, 0);
    }

    public static FaceDrawable getFaceDrawableFrom(AppInterface appInterface, int i3, String str, int i16) {
        byte faceShapeType = getFaceShapeType(i3);
        Drawable defaultDrawable = getDefaultDrawable(i3, faceShapeType);
        return getFaceDrawableFrom(appInterface, i3, str, faceShapeType, defaultDrawable, defaultDrawable, i16);
    }

    @Nullable
    public static FaceDrawable getOutboundUserFaceDrawable(AppInterface appInterface, String str, byte b16, int i3) {
        return getOutboundUserFaceDrawable(appInterface, str, b16, true, i3);
    }

    public static FaceDrawable getStrangerFaceDrawable(AppInterface appInterface, int i3, String str, boolean z16, boolean z17) {
        FaceDrawable faceDrawableImpl;
        if (!TextUtils.isEmpty(str) && appInterface != null) {
            Drawable defaultDrawable = getDefaultDrawable(32, 3);
            if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(appInterface.getModuleId())) {
                return new NearByFaceDrawable(appInterface, 32, i3, str, (byte) 1, 3, z16, defaultDrawable, defaultDrawable, null, z17);
            }
            if (AvatarOptimiseConfigUtil.b()) {
                faceDrawableImpl = new com.tencent.mobileqq.proavatar.g(appInterface, 32, i3, str, (byte) 1, 3, 100, z16, defaultDrawable, defaultDrawable, null, z17);
            } else {
                faceDrawableImpl = new FaceDrawableImpl(appInterface, 32, i3, str, (byte) 1, 3, 100, z16, defaultDrawable, defaultDrawable, null, z17);
            }
            return faceDrawableImpl;
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i(TAG, 2, "getFaceDrawable fail, uin=" + str + ", idType=" + i3 + ",appIntf=" + appInterface);
        return null;
    }

    @Override // com.tencent.mobileqq.app.face.IZplanOutboundAvatar
    public void hideZplanAvatar(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, j3);
            return;
        }
        this.isHideZplanAvatar = true;
        if (j3 > 0) {
            this.showAvatarAtTime = System.currentTimeMillis() + j3 + 100;
        } else {
            this.showAvatarAtTime = 0L;
        }
        if (checkZplanOutboundAvatarState() && (this.mLoadedDrawable instanceof ZplanAvatarAnimateDrawable)) {
            QLog.i(TAG, 1, "hideZplanAvatar: " + (this.showAvatarAtTime - System.currentTimeMillis()));
            ((ZplanAvatarAnimateDrawable) this.mLoadedDrawable).hideAvatar();
            if (this.showAvatarAtTime > 0) {
                this.uiHandler.postDelayed(new Runnable(j3) { // from class: com.tencent.mobileqq.app.face.FaceDrawable.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long val$hideMaxDuration;

                    {
                        this.val$hideMaxDuration = j3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, FaceDrawable.this, Long.valueOf(j3));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QLog.i(FaceDrawable.TAG, 1, "auto showZplanAvatar delay: " + this.val$hideMaxDuration);
                        FaceDrawable.this.showZplanAvatar(0L);
                    }
                }, j3 + 100);
            }
        }
    }

    public static FaceDrawable getFaceDrawable(AppInterface appInterface, int i3, int i16, String str, int i17, Drawable drawable, Drawable drawable2, OnLoadingStateChangeListener onLoadingStateChangeListener) {
        return getFaceDrawable(appInterface, i3, i16, str, i17, drawable, drawable2, onLoadingStateChangeListener, false, false, 0);
    }

    @Nullable
    public static FaceDrawable getOutboundUserFaceDrawable(AppInterface appInterface, String str, byte b16, boolean z16, int i3) {
        if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).checkOutboundHeadSceneEnable(i3)) {
            return getUserFaceDrawable(appInterface, str, b16, z16, i3);
        }
        return null;
    }

    @Nullable
    public static FaceDrawable getUserFaceDrawable(AppInterface appInterface, String str, byte b16, boolean z16) {
        return getUserFaceDrawable(appInterface, str, b16, z16, 1);
    }

    public static FaceDrawable getFaceDrawable(AppInterface appInterface, int i3, int i16, String str, int i17, Drawable drawable, Drawable drawable2, OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z16, boolean z17, int i18) {
        if (!TextUtils.isEmpty(str) && appInterface != null) {
            String trim = (i3 == 1 && StringUtil.isValideUin(str)) ? str.trim() : str;
            if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(appInterface.getModuleId())) {
                return new NearByFaceDrawable(appInterface, i3, 200, trim, (byte) 1, i17, false, drawable, drawable2, onLoadingStateChangeListener, z16);
            }
            int i19 = i16 >= 100 ? i16 : 100;
            int i26 = i19 > 1080 ? 1080 : i19;
            if (AvatarOptimiseConfigUtil.b()) {
                return new com.tencent.mobileqq.proavatar.g(appInterface, i3, 200, trim, (byte) 0, i17, i26, false, drawable, drawable2, onLoadingStateChangeListener, z16, z17, i18);
            }
            return new FaceDrawableImpl(appInterface, i3, 200, trim, (byte) 0, i17, i26, false, drawable, drawable2, onLoadingStateChangeListener, z16, z17, i18);
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i(TAG, 2, "getFaceDrawable fail, uin=" + str + ", type=" + i3 + ",appIntf=" + appInterface);
        return null;
    }

    public static FaceDrawable getUserFaceDrawable(AppInterface appInterface, String str, byte b16, boolean z16, int i3) {
        Drawable defaultDrawable = getDefaultDrawable(1, b16);
        return getFaceDrawable(appInterface, 1, str, b16, defaultDrawable, defaultDrawable, null, false, z16, i3);
    }

    public static FaceDrawable getStrangerFaceDrawable(AppInterface appInterface, int i3, String str, int i16) {
        return getStrangerFaceDrawable(appInterface, i3, str, i16, false);
    }

    public static FaceDrawable getStrangerFaceDrawable(AppInterface appInterface, int i3, String str, int i16, boolean z16) {
        FaceDrawable faceDrawableImpl;
        if (!TextUtils.isEmpty(str) && appInterface != null) {
            Drawable defaultDrawable = getDefaultDrawable(32, i16);
            if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(appInterface.getModuleId())) {
                return new NearByFaceDrawable(appInterface, 32, i3, str, (byte) 1, i16, true, defaultDrawable, defaultDrawable, null, z16);
            }
            if (AvatarOptimiseConfigUtil.b()) {
                faceDrawableImpl = new com.tencent.mobileqq.proavatar.g(appInterface, 32, i3, str, (byte) 1, i16, 100, true, defaultDrawable, defaultDrawable, null, z16);
            } else {
                faceDrawableImpl = new FaceDrawableImpl(appInterface, 32, i3, str, (byte) 1, i16, 100, true, defaultDrawable, defaultDrawable, null, z16);
            }
            return faceDrawableImpl;
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i(TAG, 2, "getFaceDrawable fail, uin=" + str + ", idType=" + i3 + ",appIntf=" + appInterface + ",shape=" + i16);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FaceDrawable(AppInterface appInterface, int i3, int i16, String str, byte b16, int i17, int i18, boolean z16, Drawable drawable, Drawable drawable2, OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z17, boolean z18, int i19) {
        super(drawable, drawable2);
        Bitmap bitmapFromCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i26 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), str, Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), drawable, drawable2, onLoadingStateChangeListener, Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i19));
            return;
        }
        this.tempRectF = new RectF();
        this.isSupportMaskView = false;
        this.addWhiteBorder = false;
        this.zplanOutboundSceneId = 0;
        this.isHideZplanAvatar = false;
        this.showAvatarAtTime = 0L;
        this.outboundsBgPaint = new Paint(1);
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.path = new Path();
        this.zplanFaceBg = null;
        this.zplanFaceBgListener = new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.app.face.FaceDrawable.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FaceDrawable.this);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) uRLDrawable);
                } else {
                    QLog.e(FaceDrawable.TAG, 1, "onLoadCanceled ");
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
                    return;
                }
                QLog.e(FaceDrawable.TAG, 1, "onLoadFialed");
                if (((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isToggleBugfix106568443Enable()) {
                    FaceDrawable.this.invalidateSelf();
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i36) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) uRLDrawable, i36);
                }
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                } else {
                    FaceDrawable.this.invalidateSelf();
                }
            }
        };
        this.borderPaint = new Paint(1);
        long currentTimeMillis = System.currentTimeMillis();
        setApp(appInterface);
        this.mListener = onLoadingStateChangeListener;
        if (i3 != 101 && i3 != 1001) {
            i26 = i17;
        }
        this.mFaceInfo = new FaceInfo(i3, str, false, b16, (int) com.tencent.mobileqq.avatar.utils.c.a((byte) i26), z16, i16, z17, i18);
        if (i3 == 4 && !((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(str)) {
            this.mFaceInfo.headType = 113;
        }
        if (i3 == 1) {
            if (z18 && ((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).checkOutboundHeadSceneEnable(i19)) {
                enableZplanOutbound(i19);
            } else {
                disableZplanOutbound();
            }
        }
        if (this instanceof NearByFaceDrawable) {
            bitmapFromCache = getBitmapFromCache();
        } else {
            bitmapFromCache = getBitmapFromCache(true);
        }
        if (bitmapFromCache != null) {
            this.mCurState = 1;
            Drawable createLoadedDrawable = createLoadedDrawable(bitmapFromCache);
            this.mLoadedDrawable = createLoadedDrawable;
            createLoadedDrawable.setVisible(isVisible(), true);
            this.mLoadedDrawable.setBounds(getBounds());
        } else {
            this.mCurState = 0;
            requestDecode();
        }
        OnLoadingStateChangeListener onLoadingStateChangeListener2 = this.mListener;
        if (onLoadingStateChangeListener2 != null) {
            onLoadingStateChangeListener2.onLoadingStateChanged(-1, this.mCurState);
        }
        Paint paint = new Paint();
        this.mMaskPaint = paint;
        paint.setAntiAlias(true);
        this.mMaskPaint.setColor(ThemeConstants.NIGHTMODE_MASKCOLOR);
        Paint paint2 = new Paint(1);
        this.borderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.borderPaint.setColor(-1);
        Paint paint3 = new Paint(1);
        this.outboundsBgPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.outboundsBgPaint.setColor(-2171170);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (!QLog.isColorLevel() || currentTimeMillis2 <= 16) {
            return;
        }
        QLog.i(TAG, 2, "time cost FaceDrawable:" + currentTimeMillis2);
    }

    public static FaceDrawable getFaceDrawable(AppInterface appInterface, int i3, String str, int i16, Drawable drawable, Drawable drawable2, OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z16, boolean z17, int i17) {
        if (!TextUtils.isEmpty(str) && appInterface != null) {
            String trim = (i3 == 1 && StringUtil.isValideUin(str)) ? str.trim() : str;
            if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(appInterface.getModuleId())) {
                return new NearByFaceDrawable(appInterface, i3, 200, trim, (byte) 1, i16, false, drawable, drawable2, onLoadingStateChangeListener, z16);
            }
            int i18 = i17 > 0 ? 140 : 100;
            if (AvatarOptimiseConfigUtil.b()) {
                return new com.tencent.mobileqq.proavatar.g(appInterface, i3, 200, trim, (byte) 0, i16, i18, false, drawable, drawable2, onLoadingStateChangeListener, z16, z17, i17);
            }
            return new FaceDrawableImpl(appInterface, i3, 200, trim, (byte) 0, i16, i18, false, drawable, drawable2, onLoadingStateChangeListener, z16, z17, i17);
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i(TAG, 2, "getFaceDrawable fail, uin=" + str + ", type=" + i3 + ",appIntf=" + appInterface);
        return null;
    }

    public static FaceDrawable getStrangerFaceDrawable(AppInterface appInterface, int i3, String str, int i16, OnLoadingStateChangeListener onLoadingStateChangeListener) {
        return getStrangerFaceDrawable(appInterface, i3, str, i16, onLoadingStateChangeListener, false);
    }

    public static FaceDrawable getStrangerFaceDrawable(AppInterface appInterface, int i3, String str, int i16, OnLoadingStateChangeListener onLoadingStateChangeListener, boolean z16) {
        FaceDrawable faceDrawableImpl;
        if (!TextUtils.isEmpty(str) && appInterface != null) {
            Drawable defaultDrawable = getDefaultDrawable(32, i16);
            if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(appInterface.getModuleId())) {
                return new NearByFaceDrawable(appInterface, 32, i3, str, (byte) 1, i16, true, defaultDrawable, defaultDrawable, onLoadingStateChangeListener, z16);
            }
            if (AvatarOptimiseConfigUtil.b()) {
                faceDrawableImpl = new com.tencent.mobileqq.proavatar.g(appInterface, 32, i3, str, (byte) 1, i16, 100, true, defaultDrawable, defaultDrawable, onLoadingStateChangeListener, z16);
            } else {
                faceDrawableImpl = new FaceDrawableImpl(appInterface, 32, i3, str, (byte) 1, i16, 100, true, defaultDrawable, defaultDrawable, onLoadingStateChangeListener, z16);
            }
            return faceDrawableImpl;
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.i(TAG, 2, "getFaceDrawable fail, uin=" + str + ", idType=" + i3 + ",appIntf=" + appInterface + ",shape=" + i16);
        return null;
    }

    public static FaceDrawable getFaceDrawable(AppInterface appInterface, int i3, String str) {
        byte faceShapeType = getFaceShapeType(i3);
        Drawable defaultDrawable = getDefaultDrawable(i3, faceShapeType);
        return getFaceDrawable(appInterface, i3, str, faceShapeType, defaultDrawable, defaultDrawable);
    }

    public static FaceDrawable getFaceDrawable(AppInterface appInterface, int i3, int i16, String str) {
        Drawable defaultDrawable = getDefaultDrawable(i3, i16);
        return getFaceDrawable(appInterface, i3, str, i16, defaultDrawable, defaultDrawable);
    }

    public static FaceDrawable getFaceDrawable(AppInterface appInterface, int i3, int i16, String str, OnLoadingStateChangeListener onLoadingStateChangeListener) {
        Drawable defaultDrawable = getDefaultDrawable(i3, i16);
        return getFaceDrawable(appInterface, i3, str, i16, defaultDrawable, defaultDrawable, onLoadingStateChangeListener);
    }
}
