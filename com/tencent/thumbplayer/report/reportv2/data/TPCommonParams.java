package com.tencent.thumbplayer.report.reportv2.data;

import androidx.annotation.NonNull;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPCommonParams implements Serializable {

    @TPReportParam(key = "flowid")
    private String mFlowId = "";

    @TPReportParam(key = "guid")
    private String mGuid = "";

    @TPReportParam(key = "seq")
    private int mSeq = -1;

    @TPReportParam(key = "platformtype")
    private int mPlatformType = -1;

    @TPReportParam(key = TPReportKeys.LiveExKeys.LIVE_EX_DEV_TYPE)
    private int mDeviceType = -1;

    @TPReportParam(key = QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE)
    private int mNetworkType = -1;

    @TPReportParam(key = WidgetCacheWeatherData.DEVICENAME)
    private String mDeviceName = "";

    @TPReportParam(key = TPReportKeys.Common.COMMON_OS_VERSION)
    private String mOsVersion = "";

    @TPReportParam(key = "appname")
    private String mAppName = "";

    @TPReportParam(key = "appver")
    private String mAppVer = "";

    @TPReportParam(key = TPReportKeys.Common.COMMON_PLAYER_VERSION)
    private String mPlayerVer = "";

    @TPReportParam(key = "reportprotocolver")
    private String mReportProtocolVer = "";

    @TPReportParam(key = "durationms")
    private long mDurationMs = -1;

    @TPReportParam(key = "hlssourcetype")
    private int mHlsSourceType = -1;

    @TPReportParam(key = TPReportKeys.Common.COMMON_PLAYER_TYPE)
    private int mPlayerType = -1;

    @TPReportParam(key = "urlprotocol")
    private int mUrlProtocol = -1;

    @TPReportParam(key = "containerformat")
    private String mContainerFormat = "";

    @TPReportParam(key = "videoencodefmt")
    private int mVideoEncodeFmt = -1;

    @TPReportParam(key = "audioencodefmt")
    private int mAudioEncodeFmt = -1;

    @TPReportParam(key = "subtitleencodefmt")
    private int mSubtitleEncodeFmt = -1;

    @TPReportParam(key = "streambitratekbps")
    private long mStreamBitrateKbps = -1;

    @TPReportParam(key = "videoframerate")
    private float mVideoFrameRate = -1.0f;

    @TPReportParam(key = "url")
    private String mUrl = "";

    @TPReportParam(key = "resolution")
    private String mResolution = "";

    @TPReportParam(key = "datatransportver")
    private String mDataTransportVer = "";

    @TPReportParam(key = "speedkbps")
    private int mSpeedKbps = -1;

    @TPReportParam(key = "usedatatransport")
    private int mUseDataTransport = -1;

    @TPReportParam(key = "datatransportprotocolver")
    private String mDataTransportProtocolVer = "";

    @TPReportParam(key = TPReportKeys.Common.COMMON_CDN_UIP)
    private String mCdnUip = "";

    @TPReportParam(key = TPReportKeys.Common.COMMON_CDN_IP)
    private String mCdnIp = "";

    @TPReportParam(key = "platform")
    private int mPlatform = -1;

    @TPReportParam(key = "playerconfig")
    private String mPlayerConfig = "";

    @TPReportParam(key = "drmability")
    private int mDrmAbility = -1;
    private Map<String, String> mInitRsvExtFields = null;
    private Map<String, String> mInitExtFields = null;
    private Map<String, String> mPeriodRsvExtFields = null;
    private Map<String, String> mPeriodExtFields = null;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes26.dex */
    public @interface TPReportParam {
        String key() default "";
    }

    private Map<String, String> constructMapFromFields(Field[] fieldArr) {
        HashMap hashMap = new HashMap();
        for (Field field : fieldArr) {
            TPReportParam tPReportParam = (TPReportParam) field.getAnnotation(TPReportParam.class);
            if (tPReportParam != null) {
                hashMap.put(tPReportParam.key(), getFieldValue(field));
            }
        }
        return hashMap;
    }

    private String getFieldValue(Field field) {
        String str;
        try {
            field.setAccessible(true);
            if (field.getType() == Integer.TYPE) {
                str = String.valueOf(field.getInt(this));
            } else if (field.getType() == Long.TYPE) {
                str = String.valueOf(field.getLong(this));
            } else if (field.getType() == Float.TYPE) {
                str = String.valueOf(field.getFloat(this));
            } else if (field.getType() == Boolean.TYPE) {
                str = String.valueOf(field.getBoolean(this));
            } else if (field.getType() == String.class) {
                str = (String) field.get(this);
            } else {
                TPLogUtil.e(getClass().getName(), "getFieldValue field:" + field.getName() + " is not match.");
                return "-1";
            }
            return str;
        } catch (Exception e16) {
            TPLogUtil.e(getClass().getName(), e16);
            return "-1";
        }
    }

    private void updateInitExtMapFromPeriodExtMap() {
        Map<String, String> map;
        Map<String, String> map2 = this.mInitExtFields;
        if (map2 != null && (map = this.mPeriodExtFields) != null) {
            updateMap(map2, map);
        }
    }

    private void updateInitRsvExtMapFromPeriodRsvExtMap() {
        Map<String, String> map;
        Map<String, String> map2 = this.mInitRsvExtFields;
        if (map2 != null && (map = this.mPeriodRsvExtFields) != null) {
            updateMap(map2, map);
        }
    }

    private static void updateMap(@NonNull Map<String, String> map, @NonNull Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            if (map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void copyCommonParams(TPCommonParams tPCommonParams) {
        this.mFlowId = tPCommonParams.mFlowId;
        this.mGuid = tPCommonParams.mGuid;
        this.mSeq = tPCommonParams.mSeq;
        this.mPlatformType = tPCommonParams.mPlatformType;
        this.mDeviceType = tPCommonParams.mDeviceType;
        this.mNetworkType = tPCommonParams.mNetworkType;
        this.mDeviceName = tPCommonParams.mDeviceName;
        this.mOsVersion = tPCommonParams.mOsVersion;
        this.mAppName = tPCommonParams.mAppName;
        this.mPlayerVer = tPCommonParams.mPlayerVer;
        this.mAppVer = tPCommonParams.mAppVer;
        this.mReportProtocolVer = tPCommonParams.mReportProtocolVer;
        this.mDurationMs = tPCommonParams.mDurationMs;
        this.mHlsSourceType = tPCommonParams.mHlsSourceType;
        this.mPlayerType = tPCommonParams.mPlayerType;
        this.mUrlProtocol = tPCommonParams.mUrlProtocol;
        this.mContainerFormat = tPCommonParams.mContainerFormat;
        this.mVideoEncodeFmt = tPCommonParams.mVideoEncodeFmt;
        this.mAudioEncodeFmt = tPCommonParams.mAudioEncodeFmt;
        this.mSubtitleEncodeFmt = tPCommonParams.mSubtitleEncodeFmt;
        this.mStreamBitrateKbps = tPCommonParams.mStreamBitrateKbps;
        this.mVideoFrameRate = tPCommonParams.mVideoFrameRate;
        this.mUrl = tPCommonParams.mUrl;
        this.mResolution = tPCommonParams.mResolution;
        this.mDataTransportVer = tPCommonParams.mDataTransportVer;
        this.mSpeedKbps = tPCommonParams.mSpeedKbps;
        this.mUseDataTransport = tPCommonParams.mUseDataTransport;
        this.mCdnUip = tPCommonParams.mCdnUip;
        this.mCdnIp = tPCommonParams.mCdnIp;
        this.mDataTransportProtocolVer = tPCommonParams.mDataTransportProtocolVer;
        this.mPlatform = tPCommonParams.mPlatform;
        this.mPlayerConfig = tPCommonParams.mPlayerConfig;
        this.mInitRsvExtFields = tPCommonParams.mInitRsvExtFields;
        this.mInitExtFields = tPCommonParams.mInitExtFields;
        this.mPeriodRsvExtFields = tPCommonParams.mPeriodRsvExtFields;
        this.mPeriodExtFields = tPCommonParams.mPeriodExtFields;
        this.mDrmAbility = tPCommonParams.mDrmAbility;
    }

    public Map<String, String> fillParamsToMap() {
        HashMap hashMap = new HashMap();
        Class<? super Object> superclass = getClass().getSuperclass();
        if (superclass != null) {
            hashMap.putAll(constructMapFromFields(superclass.getDeclaredFields()));
        }
        hashMap.putAll(constructMapFromFields(getClass().getDeclaredFields()));
        updateInitRsvExtMapFromPeriodRsvExtMap();
        updateInitExtMapFromPeriodExtMap();
        Map<String, String> map = this.mInitRsvExtFields;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> map2 = this.mPeriodRsvExtFields;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        Map<String, String> map3 = this.mInitExtFields;
        if (map3 != null) {
            hashMap.putAll(map3);
        }
        Map<String, String> map4 = this.mPeriodExtFields;
        if (map4 != null) {
            hashMap.putAll(map4);
        }
        return hashMap;
    }

    public String geResolution() {
        return this.mResolution;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppVer() {
        return this.mAppVer;
    }

    public int getAudioEncodeFmt() {
        return this.mAudioEncodeFmt;
    }

    public String getCdnIp() {
        return this.mCdnIp;
    }

    public String getCdnUip() {
        return this.mCdnUip;
    }

    public String getContainerFormat() {
        return this.mContainerFormat;
    }

    public String getDataTransportProtocolVer() {
        return this.mDataTransportProtocolVer;
    }

    public String getDataTransportVer() {
        return this.mDataTransportVer;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getDrmAbility() {
        return this.mDrmAbility;
    }

    public long getDurationMs() {
        return this.mDurationMs;
    }

    public String getFlowId() {
        return this.mFlowId;
    }

    public String getGuid() {
        return this.mGuid;
    }

    public int getHlsSourceType() {
        return this.mHlsSourceType;
    }

    public Map<String, String> getInitExtFields() {
        Map<String, String> map = this.mInitExtFields;
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(map);
    }

    public Map<String, String> getInitRsvExtFields() {
        Map<String, String> map = this.mInitRsvExtFields;
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(map);
    }

    public int getNetworkType() {
        return this.mNetworkType;
    }

    public String getOsVersion() {
        return this.mOsVersion;
    }

    public Map<String, String> getPeriodExtFields() {
        Map<String, String> map = this.mPeriodExtFields;
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(map);
    }

    public Map<String, String> getPeriodRsvExtFields() {
        Map<String, String> map = this.mPeriodRsvExtFields;
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(map);
    }

    public int getPlatform() {
        return this.mPlatform;
    }

    public int getPlatformType() {
        return this.mPlatformType;
    }

    public String getPlayerConfig() {
        return this.mPlayerConfig;
    }

    public int getPlayerType() {
        return this.mPlayerType;
    }

    public String getPlayerVer() {
        return this.mPlayerVer;
    }

    public String getReportProtocolVer() {
        return this.mReportProtocolVer;
    }

    public int getSeq() {
        return this.mSeq;
    }

    public int getSpeedKbps() {
        return this.mSpeedKbps;
    }

    public long getStreamBitrateKbps() {
        return this.mStreamBitrateKbps;
    }

    public int getSubtitleEncodeFmt() {
        return this.mSubtitleEncodeFmt;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getUrlProtocol() {
        return this.mUrlProtocol;
    }

    public int getUseDataTransport() {
        return this.mUseDataTransport;
    }

    public int getVideoEncodeFmt() {
        return this.mVideoEncodeFmt;
    }

    public float getVideoFrameRate() {
        return this.mVideoFrameRate;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setAppVer(String str) {
        this.mAppVer = str;
    }

    public void setAudioEncodeFmt(int i3) {
        this.mAudioEncodeFmt = i3;
    }

    public void setCdnIp(String str) {
        this.mCdnIp = str;
    }

    public void setCdnUip(String str) {
        this.mCdnUip = str;
    }

    public void setContainerFormat(String str) {
        this.mContainerFormat = str;
    }

    public void setDataTransportProtocolVer(String str) {
        this.mDataTransportProtocolVer = str;
    }

    public void setDataTransportVer(String str) {
        this.mDataTransportVer = str;
    }

    public void setDeviceName(String str) {
        this.mDeviceName = str;
    }

    public void setDeviceType(int i3) {
        this.mDeviceType = i3;
    }

    public void setDrmAbility(int i3) {
        this.mDrmAbility = i3;
    }

    public void setDurationMs(long j3) {
        this.mDurationMs = j3;
    }

    public void setFlowId(String str) {
        this.mFlowId = str;
    }

    public void setGuid(String str) {
        this.mGuid = str;
    }

    public void setHlsSourceType(int i3) {
        this.mHlsSourceType = i3;
    }

    public void setInitExtFields(Map<String, String> map) {
        this.mInitExtFields = map;
    }

    public void setInitRsvExtFields(Map<String, String> map) {
        this.mInitRsvExtFields = map;
    }

    public void setNetworkType(int i3) {
        this.mNetworkType = i3;
    }

    public void setOsVersion(String str) {
        this.mOsVersion = str;
    }

    public void setPeriodExtFields(Map<String, String> map) {
        this.mPeriodExtFields = map;
    }

    public void setPeriodRsvExtFields(Map<String, String> map) {
        this.mPeriodRsvExtFields = map;
    }

    public void setPlatform(int i3) {
        this.mPlatform = i3;
    }

    public void setPlatformType(int i3) {
        this.mPlatformType = i3;
    }

    public void setPlayerConfig(String str) {
        this.mPlayerConfig = str;
    }

    public void setPlayerType(int i3) {
        this.mPlayerType = i3;
    }

    public void setPlayerVer(String str) {
        this.mPlayerVer = str;
    }

    public void setReportProtocolVer(String str) {
        this.mReportProtocolVer = str;
    }

    public void setResolution(String str) {
        this.mResolution = str;
    }

    public void setSeq(int i3) {
        this.mSeq = i3;
    }

    public void setSpeedKbps(int i3) {
        this.mSpeedKbps = i3;
    }

    public void setStreamBitrateKbps(long j3) {
        this.mStreamBitrateKbps = j3;
    }

    public void setSubtitleEncodeFmt(int i3) {
        this.mSubtitleEncodeFmt = i3;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setUrlProtocol(int i3) {
        this.mUrlProtocol = i3;
    }

    public void setUseDataTransport(int i3) {
        this.mUseDataTransport = i3;
    }

    public void setVideoEncodeFmt(int i3) {
        this.mVideoEncodeFmt = i3;
    }

    public void setVideoFrameRate(float f16) {
        this.mVideoFrameRate = f16;
    }
}
