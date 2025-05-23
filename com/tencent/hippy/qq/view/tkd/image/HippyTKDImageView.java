package com.tencent.hippy.qq.view.tkd.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.hippy.qq.view.tkd.listview.ResourceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.UrlUtils;
import com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView;
import com.tencent.mtt.supportui.views.asyncimage.ContentDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDImageView extends HippyImageView implements HippyTKDCommonBorderHandler.HippyQBCommonBorder, HippyTKDSkinHandler.HippyQBCommonSkin, GaussianBlurListener {
    public static final String EXTRA_BUSINESS_NAME = "businessname";
    public static final String EXTRA_ICONTROLLER = "IController";
    public static final String EXTRA_REPORTDATA_NAME = "reportdata";
    public static final String EXTRA_REQUEST_GIF_ENABLED = "gifEnabled";
    public static final String EXTRA_REQUEST_LEVLE = "RequestLevel";
    public static final String EXTRA_REQUEST_USE_DNS_PARSE = "useDNSParse";
    public static final String EXTRA_REQUEST_USE_THUMBNAIL = "useThumbnail";
    public static final String EXTRA_REQUEST_VIEW_HEIGHT = "viewHeight";
    public static final String EXTRA_REQUEST_VIEW_WIDTH = "viewWidth";
    private static final int FILE_DESCRIPTOR = 7;
    public static final int MAX_RETRYCOUNTS = 2;
    public static final int NIGHT_MODE_MASK_COLOR = Integer.MIN_VALUE;
    public static final long RETRY_INTERVAL = 2000;
    private Bitmap mBlurBitmap;
    private String mBlurBitmapKey;
    int mBlurRadius;
    private String mBusinessName;
    private int mClipBgColor;
    private HippyMap mClipInfoMap;
    boolean mEnableCacheImg;
    boolean mEnableLoadingImg;
    boolean mEnableNoPicMode;
    Path mFeedsClipPath;
    private boolean mFeedsNeedClip;
    boolean mFitSystemRotation;
    private boolean mGifEnabled;
    private HippyEngineContext mHippyContext;
    HippyTKDSkinHandler mHippyTKDSkinHandler;
    private HippyMap mInitPropMap;
    private long mLastTriggerTime;
    private boolean mReported;
    protected boolean mRequestUseDnsParse;
    private int mRetryCounts;
    private Bitmap mRotationBitmap;
    private String mRotationBitmapKey;
    private String mSourceFrom;
    HippyArray mSources;
    private long mStartFetchTime;
    HippyArray mTintColors;
    boolean mUseNightModeMask;
    private boolean mUseThumbnail;

    public HippyTKDImageView(Context context) {
        super(context);
        this.mBlurBitmap = null;
        this.mBlurBitmapKey = null;
        this.mRotationBitmap = null;
        this.mRotationBitmapKey = null;
        this.mBusinessName = "";
        this.mFeedsClipPath = new Path();
        this.mFeedsNeedClip = false;
        this.mClipBgColor = 0;
        this.mSourceFrom = "";
        this.mReported = false;
        this.mClipInfoMap = null;
        setFocusable(true);
        init();
        this.mHippyContext = ((HippyInstanceContext) context).getEngineContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getBlurRate(int i3, int i16, int i17) {
        float sqrt = (float) Math.sqrt(i17);
        float f16 = i3;
        if (sqrt > f16) {
            sqrt = f16;
        }
        float f17 = i16;
        if (sqrt > f17) {
            return f17;
        }
        return sqrt;
    }

    public static int getPicOrientation(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    i3 = 270;
                } else {
                    i3 = 90;
                }
            } else {
                i3 = 180;
            }
            return i3;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }

    private void resetRetry() {
        this.mRetryCounts = 0;
        this.mLastTriggerTime = 0L;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public Bitmap getBitmap() {
        if (this.mBlurRadius > 0) {
            return this.mBlurBitmap;
        }
        if (this.mFitSystemRotation) {
            return this.mRotationBitmap;
        }
        return super.getBitmap();
    }

    public HippyMap getClipInfo() {
        return this.mClipInfoMap;
    }

    @Override // android.view.View
    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        return super.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public Object getFetchParam() {
        RenderNode renderNode;
        int i3;
        int i16;
        RenderNode renderNode2;
        Object fetchParam = super.getFetchParam();
        if (fetchParam == null) {
            fetchParam = new HippyMap();
        }
        if (fetchParam instanceof HippyMap) {
            HippyMap hippyMap = (HippyMap) fetchParam;
            if (!this.mEnableLoadingImg && this.mEnableCacheImg) {
                hippyMap.pushObject(EXTRA_REQUEST_LEVLE, new Integer(2));
            } else {
                hippyMap.pushObject(EXTRA_REQUEST_LEVLE, new Integer(1));
            }
            if (this.mUseThumbnail) {
                HippyEngineContext hippyEngineContext = this.mHippyContext;
                if (hippyEngineContext != null && (renderNode2 = hippyEngineContext.getRenderManager().getRenderNode(getId())) != null) {
                    i3 = renderNode2.getWidth();
                    i16 = renderNode2.getHeight();
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                hippyMap.pushObject(EXTRA_REQUEST_USE_THUMBNAIL, Boolean.TRUE);
                hippyMap.pushObject("viewWidth", Integer.valueOf(i3));
                hippyMap.pushObject("viewHeight", Integer.valueOf(i16));
            }
            hippyMap.pushObject(EXTRA_REQUEST_GIF_ENABLED, Boolean.valueOf(this.mGifEnabled));
            hippyMap.pushObject(EXTRA_REPORTDATA_NAME, this.mSourceFrom);
            hippyMap.pushObject(EXTRA_BUSINESS_NAME, "Hippy_" + this.mBusinessName);
            HippyEngineContext hippyEngineContext2 = this.mHippyContext;
            if (hippyEngineContext2 != null && (renderNode = hippyEngineContext2.getRenderManager().getRenderNode(getId())) != null) {
                this.mInitPropMap = renderNode.getProps();
            }
            HippyMap hippyMap2 = this.mInitPropMap;
            if (hippyMap2 != null) {
                hippyMap.pushJSONObject(hippyMap2.toJSONObject());
            }
        }
        return fetchParam;
    }

    public String getSourceFrom() {
        return this.mSourceFrom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void handleGetImageFail(Throwable th5) {
        resetRetry();
        super.handleGetImageFail(th5);
        onGetImageFailed(this.mUrl, th5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void handleGetImageStart() {
        super.handleGetImageStart();
        this.mStartFetchTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleGetImageSuccess() {
        int i3;
        IDrawableTarget iDrawableTarget;
        Bitmap bitmap;
        super.handleGetImageSuccess();
        resetRetry();
        IDrawableTarget iDrawableTarget2 = this.mSourceDrawable;
        if (iDrawableTarget2 != null && (iDrawableTarget2.getExtraData() instanceof Map)) {
            Object obj = ((Map) this.mSourceDrawable.getExtraData()).get(EXTRA_REQUEST_LEVLE);
            if (obj instanceof Integer) {
                i3 = ((Integer) obj).intValue();
                int i16 = i3;
                String str = this.mUrl;
                iDrawableTarget = this.mSourceDrawable;
                if (iDrawableTarget == null) {
                    bitmap = iDrawableTarget.getBitmap();
                } else {
                    bitmap = null;
                }
                onGetImageSuccess(str, bitmap, System.currentTimeMillis() - this.mStartFetchTime, i16);
            }
        }
        i3 = 1;
        int i162 = i3;
        String str2 = this.mUrl;
        iDrawableTarget = this.mSourceDrawable;
        if (iDrawableTarget == null) {
        }
        onGetImageSuccess(str2, bitmap, System.currentTimeMillis() - this.mStartFetchTime, i162);
    }

    protected void handleNightModeMask() {
        HippyArray hippyArray = this.mTintColors;
        if (hippyArray != null) {
            super.setTintColor(HippyTKDSkinHandler.getColor(hippyArray));
        } else {
            super.setTintColor(this.mTintColor);
        }
    }

    public void init() {
        this.mHippyTKDSkinHandler = new HippyTKDSkinHandler();
        this.mUseNightModeMask = true;
        this.mEnableNoPicMode = true;
        this.mEnableLoadingImg = true;
        this.mEnableCacheImg = true;
        setFadeEnabled(true);
        setFadeDuration(150L);
        this.mRequestUseDnsParse = false;
        this.mFitSystemRotation = false;
        this.mBlurRadius = 0;
        this.mTintColors = null;
        this.mSources = null;
        this.mBlurBitmap = null;
        this.mBlurBitmapKey = null;
        this.mRotationBitmap = null;
        this.mRotationBitmapKey = null;
        resetFadeAnimation();
        this.mStartFetchTime = 0L;
        resetRetry();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        String str;
        if (!this.mEnableLoadingImg && !this.mEnableCacheImg && (str = this.mUrl) != null && UrlUtils.isWebUrl(str)) {
            onFetchImage(this.mUrl);
        }
        super.onAttachedToWindow();
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    protected void onFetchImage(String str) {
        Drawable background = getBackground();
        this.mContentDrawable = null;
        this.mBGDrawable = null;
        if (str != null && (UrlUtils.isWebUrl(str) || UrlUtils.isFileUrl(str))) {
            int color = ResourceUtil.getColor(R.color.cv9);
            if (this.mHippyTKDSkinHandler.getBackgroundColors() != null) {
                color = HippyTKDSkinHandler.getColor(this.mHippyTKDSkinHandler.getBackgroundColors());
            }
            if (background instanceof CommonBackgroundDrawable) {
                CommonBackgroundDrawable commonBackgroundDrawable = (CommonBackgroundDrawable) background;
                commonBackgroundDrawable.setBackgroundColor(color);
                setCustomBackgroundDrawable(commonBackgroundDrawable);
            } else if (background instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) background;
                if (layerDrawable.getNumberOfLayers() > 0) {
                    Drawable drawable = layerDrawable.getDrawable(0);
                    if (drawable instanceof CommonBackgroundDrawable) {
                        CommonBackgroundDrawable commonBackgroundDrawable2 = (CommonBackgroundDrawable) drawable;
                        commonBackgroundDrawable2.setBackgroundColor(color);
                        setCustomBackgroundDrawable(commonBackgroundDrawable2);
                    }
                }
            }
            setBackgroundColor(color);
            return;
        }
        resetContent();
    }

    @Override // com.tencent.hippy.qq.view.tkd.image.GaussianBlurListener
    public void onGaussianBlurComplete(Bitmap bitmap, Map map) {
        this.mBlurBitmap = bitmap;
        post(new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView.2
            @Override // java.lang.Runnable
            public void run() {
                HippyTKDImageView.this.performSetContent();
            }
        });
    }

    public void onGetImageFailed(String str, Throwable th5) {
        if (th5 != null) {
            th5.toString();
        }
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    protected void onSetContent(String str) {
        super.setBackgroundColor(0);
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.views.list.HippyRecycler
    public void resetProps() {
        super.resetProps();
        init();
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    protected void restoreBackgroundColorAfterSetContent() {
        if (this.mBGDrawable != null && this.mHippyTKDSkinHandler.getBackgroundColors() == null) {
            this.mBGDrawable.setBackgroundColor(0);
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBackgroundColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBackgroundColors(this, hippyArray);
    }

    public void setBlurRadius(int i3) {
        this.mBlurRadius = i3;
        if (QLog.isColorLevel()) {
            QLog.d("hippyImageView", 2, "setBlurRadius blurRadius:" + i3);
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderBottomColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderBottomColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderLeftColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderLeftColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderRightColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderRightColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderTopColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderTopColors(this, hippyArray);
    }

    public void setClipInfo(HippyMap hippyMap) {
        this.mClipInfoMap = hippyMap;
    }

    public void setFitSystemRotation(boolean z16) {
        this.mFitSystemRotation = z16;
    }

    public void setGifEnabled(boolean z16) {
        this.mGifEnabled = z16;
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView
    public void setInitProps(HippyMap hippyMap) {
        super.setInitProps(hippyMap);
        this.mInitPropMap = hippyMap;
    }

    public void setNightModeOption(HippyMap hippyMap) {
        boolean z16;
        if (hippyMap != null) {
            z16 = hippyMap.getBoolean("enable");
        } else {
            z16 = true;
        }
        this.mUseNightModeMask = z16;
        handleNightModeMask();
    }

    public void setNoPicModeOption(HippyMap hippyMap) {
        boolean z16;
        boolean z17 = true;
        if (hippyMap != null) {
            z16 = hippyMap.getBoolean("enable");
        } else {
            z16 = true;
        }
        this.mEnableNoPicMode = z16;
        if (!this.mEnableLoadingImg && z16) {
            z17 = false;
        }
        this.mEnableLoadingImg = z17;
    }

    public void setReportData(HippyMap hippyMap) {
        String str;
        if (hippyMap != null) {
            str = hippyMap.getString(GetAdInfoRequest.SOURCE_FROM);
        } else {
            str = "";
        }
        this.mSourceFrom = str;
    }

    public void setSources(HippyArray hippyArray) {
        this.mSources = hippyArray;
        super.setUrl(HippyTKDSkinHandler.getSource(hippyArray));
    }

    public void setTintColors(HippyArray hippyArray) {
        this.mTintColors = hippyArray;
        handleNightModeMask();
    }

    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void setUrl(String str) {
        if (!TextUtils.equals(str, this.mUrl)) {
            this.mRequestUseDnsParse = false;
        }
        super.setUrl(str);
    }

    public void setUseThumbnail(boolean z16) {
        this.mUseThumbnail = z16;
    }

    public void setpointsForCrop(HippyArray hippyArray) {
        if (hippyArray != null && hippyArray.size() >= 4) {
            this.mFeedsClipPath.reset();
            this.mFeedsClipPath.moveTo(PixelUtil.dp2px(hippyArray.getInt(0)), PixelUtil.dp2px(hippyArray.getInt(1)));
            int i3 = 1;
            while (true) {
                if ((i3 * 2) + 1 < hippyArray.size()) {
                    this.mFeedsClipPath.lineTo(PixelUtil.dp2px(hippyArray.getInt(r1)), PixelUtil.dp2px(hippyArray.getInt(r3)));
                    i3++;
                } else {
                    this.mFeedsClipPath.close();
                    this.mFeedsNeedClip = true;
                    return;
                }
            }
        } else {
            this.mFeedsNeedClip = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public boolean shouldFetchImage() {
        if (!this.mEnableLoadingImg && !this.mEnableCacheImg) {
            return false;
        }
        return super.shouldFetchImage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public boolean shouldSetContent() {
        IDrawableTarget iDrawableTarget;
        int i3;
        int i16;
        int i17;
        int i18;
        int min;
        IDrawableTarget iDrawableTarget2;
        String source;
        IDrawableTarget iDrawableTarget3 = this.mSourceDrawable;
        int i19 = 0;
        if (iDrawableTarget3 != null && (source = iDrawableTarget3.getSource()) != null && !source.equals(this.mUrl) && isAttached()) {
            return false;
        }
        if (this.mBlurRadius > 0 && (iDrawableTarget2 = this.mSourceDrawable) != null && iDrawableTarget2.getBitmap() != null) {
            String str = getUrl() + "_" + this.mBlurRadius;
            if (str.equals(this.mBlurBitmapKey)) {
                return true;
            }
            this.mBlurBitmapKey = str;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap = ((AsyncImageView) HippyTKDImageView.this).mSourceDrawable.getBitmap();
                    if (bitmap != null && !bitmap.isRecycled()) {
                        try {
                            try {
                                int width = bitmap.getWidth();
                                int height = bitmap.getHeight();
                                HippyTKDImageView hippyTKDImageView = HippyTKDImageView.this;
                                float blurRate = hippyTKDImageView.getBlurRate(width, height, hippyTKDImageView.mBlurRadius);
                                bitmap = Bitmap.createScaledBitmap(bitmap, (int) (width / blurRate), (int) (height / blurRate), true);
                                eh.a(bitmap, (int) (HippyTKDImageView.this.mBlurRadius / blurRate));
                                if (QLog.isColorLevel()) {
                                    QLog.d("", 2, "mBlurRadius", Integer.valueOf(HippyTKDImageView.this.mBlurRadius), " blurRate:", Float.valueOf(blurRate));
                                }
                            } catch (Throwable unused) {
                                QLog.e("HippyImageView", 1, "shouldSetContent BlurBitmap oom");
                            }
                            return;
                        } finally {
                            HippyTKDImageView.this.onGaussianBlurComplete(bitmap, null);
                        }
                    }
                    QLog.e("HippyImageView", 1, "shouldSetContent BlurBitmap tempBitmap == null || tempBitmap.isRecycled()");
                }
            }, 16, null, false);
            return false;
        }
        if (this.mFitSystemRotation && (iDrawableTarget = this.mSourceDrawable) != null && iDrawableTarget.getBitmap() != null) {
            String url = getUrl();
            if (url.equals(this.mRotationBitmapKey)) {
                return true;
            }
            this.mRotationBitmapKey = url;
            if (this.mUrl.startsWith("file://")) {
                i3 = getPicOrientation(this.mUrl.substring(7));
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                Matrix matrix = new Matrix();
                int width = this.mSourceDrawable.getBitmap().getWidth();
                int height = this.mSourceDrawable.getBitmap().getHeight();
                if ((i3 / 90) % 2 != 0) {
                    i17 = width;
                    i16 = height;
                } else {
                    i16 = width;
                    i17 = height;
                }
                RenderNode renderNode = this.mHippyContext.getRenderManager().getRenderNode(getId());
                if (renderNode != null) {
                    i19 = renderNode.getWidth();
                    i18 = renderNode.getHeight();
                } else {
                    i18 = 0;
                }
                if (i19 > 0 && i18 > 0 && (min = Math.min(i16 / i19, i17 / i18)) > 1) {
                    float f16 = 1.0f / min;
                    matrix.postScale(f16, f16);
                }
                matrix.postRotate(i3);
                this.mRotationBitmap = Bitmap.createBitmap(this.mSourceDrawable.getBitmap(), 0, 0, width, height, matrix, true);
            } else {
                this.mRotationBitmap = this.mSourceDrawable.getBitmap();
            }
            return true;
        }
        return super.shouldSetContent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public void updateContentDrawableProperty(int i3) {
        if (this.mFeedsNeedClip) {
            ((ContentDrawable) this.mContentDrawable).mSelfClipPath = this.mFeedsClipPath;
            setLayerType(1, null);
        }
        super.updateContentDrawableProperty(i3);
    }

    public HippyTKDImageView(Context context, String str) {
        super(context);
        this.mBlurBitmap = null;
        this.mBlurBitmapKey = null;
        this.mRotationBitmap = null;
        this.mRotationBitmapKey = null;
        this.mBusinessName = "";
        this.mFeedsClipPath = new Path();
        this.mFeedsNeedClip = false;
        this.mClipBgColor = 0;
        this.mSourceFrom = "";
        this.mReported = false;
        this.mClipInfoMap = null;
        this.mBusinessName = str;
        setFocusable(true);
        init();
        this.mHippyContext = ((HippyInstanceContext) context).getEngineContext();
    }

    public void handleNoPicModeChange() {
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler.HippyQBCommonSkin
    public void hippySwitchSkin() {
    }

    public void onGetImageRetry(String str, Throwable th5) {
    }

    public void onGetImageSuccess(String str, Bitmap bitmap, long j3, int i3) {
    }
}
