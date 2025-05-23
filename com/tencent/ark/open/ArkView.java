package com.tencent.ark.open;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.Constants;
import com.tencent.ark.Logger;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkView extends ArkTextureView {
    private static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final String TAG = "ArkApp.ArkView";
    private ArkModel mArkModel;
    private WeakReference<ArkViewImplement.LoadCallback> mArkViewCallback;
    private int mBorderType;
    private Context mContext;
    private boolean mGetArkViewSize;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHardwareRenderingEnable;
    private ArkAppInfo.Size mHintSize;
    private InitInfo mInfo;
    private ArkAppInfo.Size mMaxSize;
    private ArkAppInfo.Size mMinSize;
    private ArkAppInfo.Size mPreferSize;
    private float mRadius;
    private float mRadiusTop;
    private float mScale;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class InitInfo {
        public String appID;
        public String appPath;
        public String resPath;
        public String view;
        public String minVersion = Constants.DEFAULT_MIN_APP_VERSION;
        public String meta = "";
        public String config = "";
        public String bizSrc = "";

        public boolean isValid() {
            if (!TextUtils.isEmpty(this.appID) && !TextUtils.isEmpty(this.view)) {
                return true;
            }
            return false;
        }
    }

    public ArkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImpl(InitInfo initInfo) {
        if (initInfo != null) {
            StringBuilder sb5 = new StringBuilder("loadImpl() appPath=");
            sb5.append(initInfo.appPath);
            this.mArkModel = new ArkModel(ArkDelegateManager.getInstance().getApplicationCallback(), this.mHardwareRenderingEnable);
            sb5.append(",gpuRenderingEnabled=");
            sb5.append(this.mHardwareRenderingEnable);
            setInputCallback(ArkDelegateManager.getInstance().getInputCallback());
            WeakReference<ArkViewImplement.LoadCallback> weakReference = this.mArkViewCallback;
            if (weakReference != null) {
                setLoadCallback(weakReference.get());
            }
            float f16 = this.mScale;
            if (f16 == 0.0f) {
                f16 = this.mContext.getResources().getDisplayMetrics().scaledDensity;
            }
            this.mArkModel.setAppPath(initInfo.appPath);
            this.mArkModel.setResPath(initInfo.resPath);
            this.mArkModel.init(initInfo.appID, initInfo.view, initInfo.minVersion, initInfo.meta, initInfo.config, initInfo.bizSrc, f16);
            ArkAppInfo.Size size = this.mMinSize;
            if (size != null) {
                this.mArkModel.setMinSize(size.width, size.height);
                sb5.append(".mMinSize=(");
                sb5.append(this.mMinSize.width);
                sb5.append(",");
                sb5.append(this.mMinSize.height);
                sb5.append(")");
            }
            ArkAppInfo.Size size2 = this.mMaxSize;
            if (size2 != null) {
                this.mArkModel.setMaxSize(size2.width, size2.height);
                sb5.append(".mMaxSize=(");
                sb5.append(this.mMaxSize.width);
                sb5.append(",");
                sb5.append(this.mMaxSize.height);
                sb5.append(")");
            }
            ArkAppInfo.Size size3 = this.mPreferSize;
            if (size3 != null) {
                this.mArkModel.setFixSize(size3.width, size3.height);
                sb5.append(".mPreferSize=(");
                sb5.append(this.mPreferSize.width);
                sb5.append(",");
                sb5.append(this.mPreferSize.height);
                sb5.append(")");
            }
            float f17 = this.mRadius;
            if (f17 > 0.0f) {
                super.setClipRadius(f17);
            }
            float f18 = this.mRadiusTop;
            if (f18 > 0.0f) {
                super.setClipRadiusTop(f18);
            }
            int i3 = this.mBorderType;
            if (i3 >= 0) {
                super.setBorderType(i3);
            }
            Logger.logI(TAG, sb5.toString());
            super.initArkView(this.mArkModel);
        }
    }

    public ArkAppInfo.Size getContainerSize() {
        ArkModel arkModel = this.mArkModel;
        if (arkModel == null) {
            return new ArkAppInfo.Size(0, 0);
        }
        ArkViewModelBase.Size containerHintSize = arkModel.getContainerHintSize();
        return new ArkAppInfo.Size(containerHintSize.width, containerHintSize.height);
    }

    public boolean load(String str, String str2, String str3, String str4, String str5, String str6, ArkViewImplement.LoadCallback loadCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Logger.logI(TAG, "load appName=" + str + ", appView=" + str2 + ", bizSrc = " + str3);
        this.mArkViewCallback = new WeakReference<>(loadCallback);
        InitInfo initInfo = new InitInfo();
        initInfo.appPath = "";
        initInfo.appID = str;
        initInfo.view = str2;
        initInfo.bizSrc = str3;
        initInfo.minVersion = str4;
        initInfo.meta = str5;
        initInfo.config = str6;
        if (this.mGetArkViewSize) {
            loadImpl(initInfo);
            this.mInfo = null;
            return true;
        }
        this.mInfo = initInfo;
        return true;
    }

    public boolean loadPath(String str, String str2, String str3, String str4, String str5, String str6, ArkViewImplement.LoadCallback loadCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            this.mArkViewCallback = new WeakReference<>(loadCallback);
            Logger.logI(TAG, "loadPath appName=" + str2 + ", appView=" + str3 + ", bizSrc=" + str4);
            InitInfo initInfo = new InitInfo();
            initInfo.appPath = str;
            initInfo.appID = str2;
            initInfo.view = str3;
            initInfo.bizSrc = str4;
            initInfo.minVersion = "";
            initInfo.meta = str5;
            initInfo.config = str6;
            if (this.mGetArkViewSize) {
                loadImpl(initInfo);
                this.mInfo = null;
                return true;
            }
            this.mInfo = initInfo;
            return true;
        }
        return false;
    }

    public void onDestroy() {
        if (this.mGlobalLayoutListener != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        if (this.mArkViewCallback != null) {
            setLoadCallback(null);
            this.mArkViewCallback.clear();
            this.mArkViewCallback = null;
        }
        if (this.mArkModel != null) {
            Logger.logI(TAG, "onDestroy()");
            this.mArkModel.doOnEvent(2);
            this.mArkModel = null;
        }
    }

    public void onPause() {
        if (this.mArkModel != null) {
            Logger.logI(TAG, "onPause()");
            this.mArkModel.doOnEvent(0);
        }
    }

    public void onResume() {
        if (this.mArkModel != null) {
            Logger.logI(TAG, "onResume()");
            this.mArkModel.doOnEvent(1);
        }
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setBorderType(int i3) {
        if (i3 < 0) {
            Logger.logI(TAG, "setBorderType invalid type=" + i3);
            return;
        }
        this.mBorderType = i3;
        Logger.logI(TAG, "setBorderType invalid type=" + this.mBorderType);
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setClipRadius(float f16) {
        if (f16 < 0.0f) {
            Logger.logI(TAG, "setClipRadius invalid radius=" + f16);
            return;
        }
        this.mRadius = f16;
        Logger.logI(TAG, "setClipRadius radius=" + f16);
    }

    @Override // com.tencent.ark.ArkTextureView, com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setClipRadiusTop(float f16) {
        if (f16 < 0.0f) {
            Logger.logI(TAG, "setClipRadiusTop invalid radiusTop=" + f16);
            return;
        }
        this.mRadiusTop = f16;
        Logger.logI(TAG, "setClipRadiusTop radiusTop=" + f16);
    }

    public void setHardwareRenderingEnable(boolean z16) {
        this.mHardwareRenderingEnable = z16;
        Logger.logI(TAG, "setHardwareRenderingEnable:" + z16);
    }

    public void setOnStartTemporaryDetach(boolean z16) {
        this.mOnStartTemporaryDetach = z16;
        Logger.logI(TAG, "setOnStartTemporaryDetach:" + z16);
    }

    public void setScaleDensity(float f16) {
        this.mScale = f16;
    }

    public boolean setSize(ArkAppInfo.Size size, ArkAppInfo.Size size2, ArkAppInfo.Size size3) {
        if (size == null && size2 == null && size3 == null) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder("setSize");
        sb5.append(".hitSize=(");
        sb5.append(this.mHintSize.width);
        sb5.append(",");
        sb5.append(this.mHintSize.height);
        sb5.append(")");
        if (size != null) {
            ArkAppInfo.Size size4 = this.mPreferSize;
            size4.width = size.width;
            size4.height = size.height;
            sb5.append(".preferSize=(");
            sb5.append(this.mPreferSize.width);
            sb5.append(",");
            sb5.append(this.mPreferSize.height);
            sb5.append(")");
        }
        if (size2 != null) {
            ArkAppInfo.Size size5 = this.mMinSize;
            size5.width = size2.width;
            size5.height = size2.height;
            sb5.append(".minSize=(");
            sb5.append(this.mMinSize.width);
            sb5.append(",");
            sb5.append(this.mMinSize.height);
            sb5.append(")");
        }
        if (size3 != null) {
            ArkAppInfo.Size size6 = this.mMaxSize;
            size6.width = size3.width;
            size6.height = size3.height;
            sb5.append(".maxSize=(");
            sb5.append(this.mMaxSize.width);
            sb5.append(",");
            sb5.append(this.mMaxSize.height);
            sb5.append(")");
        }
        Logger.logI(TAG, sb5.toString());
        return true;
    }

    public boolean updateSize(ArkAppInfo.Size size) {
        if (size != null) {
            setViewRect(size.width, size.height);
            Logger.logI(TAG, "updateSize.setViewRect=(" + size.width + "," + size.height + ")");
            return true;
        }
        return false;
    }

    public ArkView(Context context, AttributeSet attributeSet, boolean z16) {
        super(context, attributeSet);
        this.mArkModel = null;
        this.mContext = null;
        this.mArkViewCallback = null;
        this.mPreferSize = null;
        this.mMinSize = null;
        this.mMaxSize = null;
        this.mHintSize = null;
        this.mGetArkViewSize = false;
        this.mInfo = null;
        this.mRadius = 0.0f;
        this.mRadiusTop = 0.0f;
        this.mBorderType = -1;
        this.mScale = 0.0f;
        this.mGlobalLayoutListener = null;
        this.mHardwareRenderingEnable = true;
        ArkDelegateManager.setupArkEnvironment(true);
        this.mContext = context;
        setOnTouchListener(this);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        this.mPreferSize = new ArkAppInfo.Size(-1, -1);
        this.mMinSize = new ArkAppInfo.Size(30, 30);
        this.mMaxSize = new ArkAppInfo.Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.mHintSize = new ArkAppInfo.Size(320, 480);
        this.mOnStartTemporaryDetach = false;
        if (z16) {
            this.mGetArkViewSize = true;
        } else {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.ark.open.ArkView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    int width = ArkView.this.getWidth();
                    int height = ArkView.this.getHeight();
                    if (width > 0) {
                        ArkView.this.mPreferSize.width = width;
                    }
                    if (height > 0) {
                        ArkView.this.mPreferSize.height = height;
                    }
                    Logger.logI(ArkView.TAG, "onGlobalLayout width=" + width + ", height=" + height);
                    ArkView.this.mGetArkViewSize = true;
                    if (ArkView.this.mInfo != null) {
                        ArkView arkView = ArkView.this;
                        arkView.loadImpl(arkView.mInfo);
                        ArkView.this.mInfo = null;
                    }
                    ArkView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ArkView.this.mGlobalLayoutListener = null;
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
        }
    }

    public boolean load(String str, String str2, String str3, String str4, String str5, ArkViewImplement.LoadCallback loadCallback) {
        return load(str, str2, "", str3, str4, str5, loadCallback);
    }

    public boolean load(InitInfo initInfo, ArkViewImplement.LoadCallback loadCallback) {
        if (initInfo == null || !initInfo.isValid()) {
            return false;
        }
        Logger.logI(TAG, "load app=" + initInfo.appID + ", view=" + initInfo.view + ", bizSrc =" + initInfo.bizSrc);
        this.mArkViewCallback = new WeakReference<>(loadCallback);
        if (this.mGetArkViewSize) {
            loadImpl(initInfo);
            this.mInfo = null;
            return true;
        }
        this.mInfo = initInfo;
        return true;
    }
}
