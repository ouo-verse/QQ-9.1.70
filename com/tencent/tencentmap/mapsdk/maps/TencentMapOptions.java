package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.AdapterType;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LoggerConfig;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import java.lang.reflect.Field;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TencentMapOptions {
    public static final int LOGO_POSITION_BOTTOM_CENTER = 4;
    public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
    public static final int LOGO_POSITION_BOTTOM_RIGHT = 1;
    public static final int LOGO_POSITION_TOP_CENTER = 5;
    public static final int LOGO_POSITION_TOP_LEFT = 3;
    public static final int LOGO_POSITION_TOP_RIGHT = 2;
    public static final int SCALEVIEW_POSITION_BOTTOM_CENTER = 4;
    public static final int SCALEVIEW_POSITION_BOTTOM_LEFT = 0;
    public static final int SCALEVIEW_POSITION_BOTTOM_RIGHT = 1;
    public static final int SCALEVIEW_POSITION_TOP_CENTER = 5;
    public static final int SCALEVIEW_POSITION_TOP_LEFT = 3;
    public static final int SCALEVIEW_POSITION_TOP_RIGHT = 2;
    public static final int ZOOM_POSITION_BOTTOM_LEFT = 0;
    public static final int ZOOM_POSITION_BOTTOM_RIGHT = 1;
    public static final int ZOOM_POSITION_TOP_LEFT = 3;
    public static final int ZOOM_POSITION_TOP_RIGHT = 2;
    private String customAssetsPath;
    private String customLocalPath;
    private String mCustomCacheRootPath;
    private String mCustomUserId;
    private boolean mDisallowIntercept;
    private Object mExtSurface;
    private int mExtSurfaceHeight;
    private int mExtSurfaceWidth;
    private Callback<TencentMap> mMapCallback;
    private IMapKernel mMapKernel;
    private String mMapKey;
    private MapViewType mMapViewType;
    private Bundle mNetParams;
    private boolean mOfflineMapEnable;
    private TencentMap.OnAuthResultCallback mOnAuthResultCallback;
    private TencentMap.OnMapLoadedCallback mOnMapLoadedCallback;
    private Object mProtocolDataDesc;
    private int mProtocolFrom;
    private String mSubId;
    private String mSubKey;
    private TrafficStyle mTrafficStyle;
    private Typeface mUserTypeface;
    private boolean isHandDrawMapEnable = false;
    private boolean isEnableMultipleInfoWindow = false;
    private String mSatelliteVersion = "0";
    private AdapterType mNetAdapterType = AdapterType.DEFAULT;
    private OverSeaSource mOverSeaSource = OverSeaSource.DEFAULT;
    private float mMapFrameRate = 60.0f;
    private boolean mOpaque = true;
    private boolean mMSAA = false;
    private boolean mForceHttps = true;
    private int mMaxIconMemoryCacheSize = 30;
    private LoggerConfig mLoggerConfig = null;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IMapKernel {
        String name();
    }

    public final TencentMapOptions enableMSAA(boolean z16) {
        this.mMSAA = z16;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TencentMapOptions.class == obj.getClass()) {
            TencentMapOptions tencentMapOptions = (TencentMapOptions) obj;
            if (this.isHandDrawMapEnable != tencentMapOptions.isHandDrawMapEnable || this.mExtSurfaceWidth != tencentMapOptions.mExtSurfaceWidth || this.mExtSurfaceHeight != tencentMapOptions.mExtSurfaceHeight || this.isEnableMultipleInfoWindow != tencentMapOptions.isEnableMultipleInfoWindow || this.mProtocolFrom != tencentMapOptions.mProtocolFrom || this.mOfflineMapEnable != tencentMapOptions.mOfflineMapEnable || Float.compare(tencentMapOptions.mMapFrameRate, this.mMapFrameRate) != 0 || this.mForceHttps != tencentMapOptions.mForceHttps) {
                return false;
            }
            String str = this.customAssetsPath;
            if (str == null ? tencentMapOptions.customAssetsPath != null : !str.equals(tencentMapOptions.customAssetsPath)) {
                return false;
            }
            String str2 = this.customLocalPath;
            if (str2 == null ? tencentMapOptions.customLocalPath != null : !str2.equals(tencentMapOptions.customLocalPath)) {
                return false;
            }
            String str3 = this.mCustomCacheRootPath;
            if (str3 == null ? tencentMapOptions.mCustomCacheRootPath != null : !str3.equals(tencentMapOptions.mCustomCacheRootPath)) {
                return false;
            }
            Object obj2 = this.mExtSurface;
            if (obj2 == null ? tencentMapOptions.mExtSurface != null : !obj2.equals(tencentMapOptions.mExtSurface)) {
                return false;
            }
            String str4 = this.mSubId;
            if (str4 == null ? tencentMapOptions.mSubId != null : !str4.equals(tencentMapOptions.mSubId)) {
                return false;
            }
            String str5 = this.mSubKey;
            if (str5 == null ? tencentMapOptions.mSubKey != null : !str5.equals(tencentMapOptions.mSubKey)) {
                return false;
            }
            String str6 = this.mMapKey;
            if (str6 == null ? tencentMapOptions.mMapKey != null : !str6.equals(tencentMapOptions.mMapKey)) {
                return false;
            }
            if (!Arrays.equals(getDebugTags(), tencentMapOptions.getDebugTags())) {
                return false;
            }
            String str7 = this.mSatelliteVersion;
            if (str7 == null ? tencentMapOptions.mSatelliteVersion != null : !str7.equals(tencentMapOptions.mSatelliteVersion)) {
                return false;
            }
            if (this.mMapViewType != tencentMapOptions.mMapViewType) {
                return false;
            }
            IMapKernel iMapKernel = this.mMapKernel;
            if (iMapKernel == null ? tencentMapOptions.mMapKernel != null : !iMapKernel.equals(tencentMapOptions.mMapKernel)) {
                return false;
            }
            Typeface typeface = this.mUserTypeface;
            if (typeface == null ? tencentMapOptions.mUserTypeface != null : !typeface.equals(tencentMapOptions.mUserTypeface)) {
                return false;
            }
            Object obj3 = this.mProtocolDataDesc;
            if (obj3 == null ? tencentMapOptions.mProtocolDataDesc != null : !obj3.equals(tencentMapOptions.mProtocolDataDesc)) {
                return false;
            }
            if (this.mNetAdapterType != tencentMapOptions.mNetAdapterType) {
                return false;
            }
            Bundle bundle = this.mNetParams;
            if (bundle == null ? tencentMapOptions.mNetParams != null : !bundle.equals(tencentMapOptions.mNetParams)) {
                return false;
            }
            String str8 = this.mCustomUserId;
            if (str8 == null ? tencentMapOptions.mCustomUserId != null : !str8.equals(tencentMapOptions.mCustomUserId)) {
                return false;
            }
            Callback<TencentMap> callback = this.mMapCallback;
            if (callback == null ? tencentMapOptions.mMapCallback != null : !callback.equals(tencentMapOptions.mMapCallback)) {
                return false;
            }
            if (this.mOverSeaSource != tencentMapOptions.mOverSeaSource) {
                return false;
            }
            TrafficStyle trafficStyle = this.mTrafficStyle;
            TrafficStyle trafficStyle2 = tencentMapOptions.mTrafficStyle;
            if (trafficStyle != null) {
                return trafficStyle.equals(trafficStyle2);
            }
            if (trafficStyle2 == null) {
                return true;
            }
        }
        return false;
    }

    public final String getCustomAssetsPath() {
        return this.customAssetsPath;
    }

    public final String getCustomCacheRootPath() {
        return this.mCustomCacheRootPath;
    }

    public final String getCustomLocalPath() {
        return this.customLocalPath;
    }

    public final String getCustomUserId() {
        return this.mCustomUserId;
    }

    public final String[] getDebugTags() {
        LoggerConfig loggerConfig = this.mLoggerConfig;
        if (loggerConfig != null) {
            return loggerConfig.getTags();
        }
        return null;
    }

    public final Object getExtSurface() {
        return this.mExtSurface;
    }

    public final int getExtSurfaceHeight() {
        return this.mExtSurfaceHeight;
    }

    public final int getExtSurfaceWidth() {
        return this.mExtSurfaceWidth;
    }

    public final LoggerConfig getLoggerConfig() {
        return this.mLoggerConfig;
    }

    public final Callback<TencentMap> getMapAsyncCallback() {
        return this.mMapCallback;
    }

    public final float getMapFrameRate() {
        return this.mMapFrameRate;
    }

    public final IMapKernel getMapKernel() {
        return this.mMapKernel;
    }

    public final String getMapKey() {
        return this.mMapKey;
    }

    public final MapViewType getMapViewType() {
        return this.mMapViewType;
    }

    public final int getMaxIconMemoryCacheSize() {
        return this.mMaxIconMemoryCacheSize;
    }

    public final AdapterType getNetAdapterType() {
        return this.mNetAdapterType;
    }

    public final Bundle getNetParams() {
        return this.mNetParams;
    }

    public final TencentMap.OnAuthResultCallback getOnAuthCallback() {
        return this.mOnAuthResultCallback;
    }

    public final TencentMap.OnMapLoadedCallback getOnMapLoadedCallback() {
        return this.mOnMapLoadedCallback;
    }

    public final OverSeaSource getOverSeaSource() {
        return this.mOverSeaSource;
    }

    public final Object getProtocolDataDesc() {
        return this.mProtocolDataDesc;
    }

    public final int getProtocolFrom() {
        return this.mProtocolFrom;
    }

    public final String getSatelliteVersion() {
        return this.mSatelliteVersion;
    }

    public final String getSubId() {
        return this.mSubId;
    }

    public final String getSubKey() {
        return this.mSubKey;
    }

    public final TrafficStyle getTrafficStyle() {
        return this.mTrafficStyle;
    }

    public final Typeface getTypeface() {
        Typeface typeface = this.mUserTypeface;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    public final int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        String str = this.customAssetsPath;
        int i57 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i58 = i3 * 31;
        String str2 = this.customLocalPath;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i59 = (i58 + i16) * 31;
        String str3 = this.mCustomCacheRootPath;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i65 = (((i59 + i17) * 31) + (this.isHandDrawMapEnable ? 1 : 0)) * 31;
        Object obj = this.mExtSurface;
        if (obj != null) {
            i18 = obj.hashCode();
        } else {
            i18 = 0;
        }
        int i66 = (((((i65 + i18) * 31) + this.mExtSurfaceWidth) * 31) + this.mExtSurfaceHeight) * 31;
        String str4 = this.mSubId;
        if (str4 != null) {
            i19 = str4.hashCode();
        } else {
            i19 = 0;
        }
        int i67 = (i66 + i19) * 31;
        String str5 = this.mSubKey;
        if (str5 != null) {
            i26 = str5.hashCode();
        } else {
            i26 = 0;
        }
        int i68 = (i67 + i26) * 31;
        String str6 = this.mMapKey;
        if (str6 != null) {
            i27 = str6.hashCode();
        } else {
            i27 = 0;
        }
        int hashCode = (((((i68 + i27) * 31) + (this.isEnableMultipleInfoWindow ? 1 : 0)) * 31) + Arrays.hashCode(getDebugTags())) * 31;
        String str7 = this.mSatelliteVersion;
        if (str7 != null) {
            i28 = str7.hashCode();
        } else {
            i28 = 0;
        }
        int i69 = (hashCode + i28) * 31;
        MapViewType mapViewType = this.mMapViewType;
        if (mapViewType != null) {
            i29 = mapViewType.hashCode();
        } else {
            i29 = 0;
        }
        int i75 = (i69 + i29) * 31;
        IMapKernel iMapKernel = this.mMapKernel;
        if (iMapKernel != null) {
            i36 = iMapKernel.hashCode();
        } else {
            i36 = 0;
        }
        int i76 = (i75 + i36) * 31;
        Typeface typeface = this.mUserTypeface;
        if (typeface != null) {
            i37 = typeface.hashCode();
        } else {
            i37 = 0;
        }
        int i77 = (((i76 + i37) * 31) + this.mProtocolFrom) * 31;
        Object obj2 = this.mProtocolDataDesc;
        if (obj2 != null) {
            i38 = obj2.hashCode();
        } else {
            i38 = 0;
        }
        int i78 = (i77 + i38) * 31;
        AdapterType adapterType = this.mNetAdapterType;
        if (adapterType != null) {
            i39 = adapterType.hashCode();
        } else {
            i39 = 0;
        }
        int i79 = (i78 + i39) * 31;
        Bundle bundle = this.mNetParams;
        if (bundle != null) {
            i46 = bundle.hashCode();
        } else {
            i46 = 0;
        }
        int i85 = (i79 + i46) * 31;
        String str8 = this.mCustomUserId;
        if (str8 != null) {
            i47 = str8.hashCode();
        } else {
            i47 = 0;
        }
        int i86 = (i85 + i47) * 31;
        Callback<TencentMap> callback = this.mMapCallback;
        if (callback != null) {
            i48 = callback.hashCode();
        } else {
            i48 = 0;
        }
        int i87 = (((i86 + i48) * 31) + (this.mOfflineMapEnable ? 1 : 0)) * 31;
        OverSeaSource overSeaSource = this.mOverSeaSource;
        if (overSeaSource != null) {
            i49 = overSeaSource.hashCode();
        } else {
            i49 = 0;
        }
        int i88 = (i87 + i49) * 31;
        TrafficStyle trafficStyle = this.mTrafficStyle;
        if (trafficStyle != null) {
            i56 = trafficStyle.hashCode();
        } else {
            i56 = 0;
        }
        int i89 = (i88 + i56) * 31;
        float f16 = this.mMapFrameRate;
        if (f16 != 0.0f) {
            i57 = Float.floatToIntBits(f16);
        }
        return ((i89 + i57) * 31) + (this.mForceHttps ? 1 : 0);
    }

    public final TencentMapOptions initLogger(LoggerConfig loggerConfig) {
        this.mLoggerConfig = loggerConfig;
        return this;
    }

    public final boolean isDisallowInterceptTouchEvent() {
        return this.mDisallowIntercept;
    }

    public final boolean isForceHttps() {
        return this.mForceHttps;
    }

    public final boolean isHandDrawMapEnable() {
        return this.isHandDrawMapEnable;
    }

    public final boolean isMSAA() {
        return this.mMSAA;
    }

    public final boolean isMultipleInfoWindowEnable() {
        return this.isEnableMultipleInfoWindow;
    }

    public final boolean isOfflineMapEnable() {
        return this.mOfflineMapEnable;
    }

    public final boolean isOpaque() {
        return this.mOpaque;
    }

    public final TencentMapOptions openDebugLogByTags(String... strArr) {
        initLogger(LoggerConfig.newBuilder().toFile(false).toConsole(false).level(2).tags(strArr).logCallback(null).build());
        return this;
    }

    public final TencentMapOptions setCustomAssetsPath(String str) {
        this.customAssetsPath = str;
        return this;
    }

    public final TencentMapOptions setCustomCacheRootPath(String str) {
        this.mCustomCacheRootPath = str;
        return this;
    }

    public final TencentMapOptions setCustomLocalPath(String str) {
        this.customLocalPath = str;
        return this;
    }

    public final TencentMapOptions setCustomUserID(String str) {
        this.mCustomUserId = str;
        return this;
    }

    public final TencentMapOptions setDisallowInterceptTouchEvent(boolean z16) {
        this.mDisallowIntercept = z16;
        return this;
    }

    public final TencentMapOptions setExtSurface(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture) && !(obj instanceof SurfaceHolder)) {
            throw new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
        }
        this.mExtSurface = obj;
        return this;
    }

    public final TencentMapOptions setExtSurfaceDimension(int i3, int i16) {
        this.mExtSurfaceWidth = i3;
        this.mExtSurfaceHeight = i16;
        return this;
    }

    public final TencentMapOptions setForceHttps(boolean z16) {
        this.mForceHttps = z16;
        return this;
    }

    public final TencentMapOptions setGetMapAsync(Callback<TencentMap> callback) {
        this.mMapCallback = callback;
        return this;
    }

    public final TencentMapOptions setHandDrawMapEnable(boolean z16) {
        this.isHandDrawMapEnable = z16;
        return this;
    }

    public final TencentMapOptions setMapFrameRate(float f16) {
        this.mMapFrameRate = f16;
        return this;
    }

    public final TencentMapOptions setMapKernel(IMapKernel iMapKernel) {
        this.mMapKernel = iMapKernel;
        return this;
    }

    public final TencentMapOptions setMapKey(String str) {
        this.mMapKey = str;
        return this;
    }

    public final TencentMapOptions setMapViewType(MapViewType mapViewType) {
        this.mMapViewType = mapViewType;
        return this;
    }

    public final TencentMapOptions setMaxIconMemoryCacheSize(int i3) {
        this.mMaxIconMemoryCacheSize = i3;
        return this;
    }

    public final TencentMapOptions setMultipleInfoWindowEnable(boolean z16) {
        this.isEnableMultipleInfoWindow = z16;
        return this;
    }

    public final TencentMapOptions setNetAdapter(AdapterType adapterType, Bundle bundle) {
        this.mNetAdapterType = adapterType;
        this.mNetParams = bundle;
        return this;
    }

    public final TencentMapOptions setOfflineMapEnable(boolean z16) {
        this.mOfflineMapEnable = z16;
        return this;
    }

    public final TencentMapOptions setOnAuthCallback(TencentMap.OnAuthResultCallback onAuthResultCallback) {
        this.mOnAuthResultCallback = onAuthResultCallback;
        return this;
    }

    public final TencentMapOptions setOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.mOnMapLoadedCallback = onMapLoadedCallback;
        return this;
    }

    public final TencentMapOptions setOpaque(boolean z16) {
        this.mOpaque = z16;
        return this;
    }

    public final TencentMapOptions setOverSeaSource(OverSeaSource overSeaSource) {
        this.mOverSeaSource = overSeaSource;
        return this;
    }

    public final TencentMapOptions setSatelliteVersion(String str) {
        this.mSatelliteVersion = str;
        return this;
    }

    public final TencentMapOptions setServiceProtocol(int i3, Object obj) {
        this.mProtocolFrom = i3;
        this.mProtocolDataDesc = obj;
        return this;
    }

    public final TencentMapOptions setSubInfo(String str, String str2) {
        if (str != null) {
            this.mSubKey = str.trim();
        } else {
            this.mSubKey = "";
        }
        if (str2 != null) {
            this.mSubId = str2.trim();
        } else {
            this.mSubId = "";
        }
        return this;
    }

    public final TencentMapOptions setTrafficStyle(TrafficStyle trafficStyle) {
        this.mTrafficStyle = trafficStyle;
        return this;
    }

    public final TencentMapOptions setTypeface(Typeface typeface) {
        setTypeface(typeface, false);
        return this;
    }

    public final String toString() {
        return "TencentMapOptions{customAssetsPath='" + this.customAssetsPath + "', customLocalPath='" + this.customLocalPath + "', mCustomCacheRootPath='" + this.mCustomCacheRootPath + "', isHandDrawMapEnable=" + this.isHandDrawMapEnable + ", mExtSurface=" + this.mExtSurface + ", mExtSurfaceWidth=" + this.mExtSurfaceWidth + ", mExtSurfaceHeight=" + this.mExtSurfaceHeight + ", mSubId='" + this.mSubId + "', mSubKey='" + this.mSubKey + "', mMapKey='" + this.mMapKey + "', isEnableMultipleInfoWindow=" + this.isEnableMultipleInfoWindow + ", mTags=" + Arrays.toString(getDebugTags()) + ", mSatelliteVersion='" + this.mSatelliteVersion + "', mMapViewType=" + this.mMapViewType + ", mMapKernel=" + this.mMapKernel + ", mUserTypeface=" + this.mUserTypeface + ", mProtocolFrom=" + this.mProtocolFrom + ", mProtocolDataDesc=" + this.mProtocolDataDesc + ", mNetAdapterType=" + this.mNetAdapterType + ", mNetParams=" + this.mNetParams + ", mCustomUserId='" + this.mCustomUserId + "', mMapCallback=" + this.mMapCallback + ", mOfflineMapEnable=" + this.mOfflineMapEnable + ", mOverSeaSource=" + this.mOverSeaSource + ", mTrafficStyle=" + this.mTrafficStyle + ", mMapFrameRate=" + this.mMapFrameRate + ", mForceHttps=" + this.mForceHttps + ", mDisallowIntercept=" + this.mDisallowIntercept + '}';
    }

    private void setTypeface(Typeface typeface, boolean z16) {
        if (typeface == null) {
            return;
        }
        if (z16) {
            try {
                Field declaredField = Typeface.class.getDeclaredField("DEFAULT");
                declaredField.setAccessible(true);
                declaredField.set(Typeface.DEFAULT, typeface);
                return;
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return;
            } catch (NoSuchFieldException e17) {
                e17.printStackTrace();
                return;
            }
        }
        this.mUserTypeface = typeface;
    }
}
