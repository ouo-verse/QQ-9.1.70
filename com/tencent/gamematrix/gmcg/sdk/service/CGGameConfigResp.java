package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.api.GmCgCodecAbility;
import com.tencent.gamematrix.gmcg.api.GmCgGameCodecConfig;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameLoadingViewCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameLoginConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameResolutionCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameSensorCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameStreamQualityCfg;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGGameConfigResp {
    public String apk;
    public int archiveLoadingTime;
    public GameLoginConfigBean autoLoginConfig;
    public boolean cloudGameAutoLogin;
    public CodecConfigBean codec_config;
    public String codecs;
    public boolean collectGame;
    public boolean disableEncryption;
    public int fps;
    public boolean frontEndShowDelay;
    public boolean imgQualityFirst;
    public boolean isSupportLocalInput;
    public LoadingViewBean loadingView;
    public float lostRate;
    public int lostReleaseTime;
    public int midasEnv;
    public String midasPathQQ;
    public String midasPathWechat;
    public int midasPayType;
    public CGModelAbility modelAbility;

    /* renamed from: msg, reason: collision with root package name */
    public String f107891msg;
    public int noConnectReleaseTime;
    public int noOperateTimeout;
    public boolean operationToCloud;
    public int protectChildren;
    public ResolutionBean resolution;
    public int ret;
    public int rttThreshold;
    public boolean saveArchive;
    public int screenOrientation;
    public SensorBean sensor;
    public int sessionTime;
    public List<StreamQualityBean> streamQuality;
    public int subAccountLostReleaseTime;
    public int subAccountNoConnectReleaseTime;
    public boolean supportNotchScreen;
    public boolean supportQuic;
    public int timeNotEnoughThreshold;
    public boolean userCanSuperResolution;
    public VideoCodingWrapper videoCoding;
    public VideoCodingHardwareWrapper videoCodingHardwareStreamRate;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class CodecConfigBean {
        public String codec;
        public int fps;
        public int references;
        public String resolution;
        public String tunnel;
        public String view;
        public String voice_switch;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class GameLoginConfigBean {
        public boolean cloudGameAutoLogin;
        public int loginAccountType;
        public int loginType;
        public String qqAppid;
        public int sdkType;
        public String wechatAppid;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class LoadingViewBean {
        public String animation;
        public String enterGamePicture;
        public String enterGamePictureVip;
        public String fpsTipPicture;
        public String picture;
        public String pictureColor;
        public List<String> tips;
        public String tipsColor;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class ResolutionBean {
        public int height;
        public int width;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class SensorBean {
        public int acceleration;
        public int gps;
        public int gravity;
        public int gyro;
        public int voice;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class StreamQualityBean {
        public int FPS;
        public int bandwidth;
        public int height;

        /* renamed from: id, reason: collision with root package name */
        public int f107892id;
        public boolean isDefault;
        public int limitBandwidth;
        public String name;
        public int superResolutionType = 0;
        public boolean vip;
        public int width;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class VideoCodingBean {
        public String codecs;
        public String codecs1080P60Hz;
        public String codecs720P60Hz;
        public List<StreamQualityBean> streamQuality;

        public static VideoCodingBean copy(VideoCodingBean videoCodingBean) {
            VideoCodingBean videoCodingBean2 = new VideoCodingBean();
            if (videoCodingBean != null) {
                videoCodingBean2.codecs = videoCodingBean.codecs;
                videoCodingBean2.codecs720P60Hz = videoCodingBean.codecs720P60Hz;
                videoCodingBean2.codecs1080P60Hz = videoCodingBean.codecs1080P60Hz;
            }
            return videoCodingBean2;
        }

        public static VideoCodingBean createDefault() {
            VideoCodingBean videoCodingBean = new VideoCodingBean();
            videoCodingBean.codecs = GmCgCodecAbility.CODEC_HARDWARE.getValue();
            videoCodingBean.codecs720P60Hz = GmCgCodecAbility.CODEC_BOTH_BAD.getValue();
            videoCodingBean.streamQuality = new ArrayList();
            return videoCodingBean;
        }

        public boolean hasValidStreamQuality() {
            List<StreamQualityBean> list = this.streamQuality;
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class VideoCodingHardwareBean {
        public List<StreamQualityBean> Ampere;
        public List<StreamQualityBean> Board8550;
        public List<StreamQualityBean> Board865;
        public List<StreamQualityBean> Default;
        public List<StreamQualityBean> Kp;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class VideoCodingHardwareWrapper {
        public VideoCodingHardwareBean H264;
        public VideoCodingHardwareBean H265;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class VideoCodingWrapper {
        public VideoCodingBean H264;
        public VideoCodingBean H264FsrSuperResolution;
        public VideoCodingBean H264SuperResolution;
        public VideoCodingBean H265;
        public VideoCodingBean H265FsrSuperResolution;
        public VideoCodingBean H265SuperResolution;
    }

    private void adjustHardwareDecode(VideoCodingBean videoCodingBean) {
        CGModelAbility cGModelAbility;
        String value;
        if (videoCodingBean != null && (cGModelAbility = this.modelAbility) != null) {
            if (cGModelAbility.isHardDecode()) {
                value = GmCgCodecAbility.CODEC_HARDWARE.getValue();
            } else {
                value = GmCgCodecAbility.CODEC_SOFTWARE.getValue();
            }
            videoCodingBean.codecs = value;
        }
    }

    private List<StreamQualityBean> matchHardWareType(String str, VideoCodingHardwareBean videoCodingHardwareBean) {
        List<StreamQualityBean> list;
        List<StreamQualityBean> list2;
        List<StreamQualityBean> list3;
        List<StreamQualityBean> list4;
        CGLog.i("matchHardWareType: " + str);
        if (CGStringUtil.notEmpty(str) && videoCodingHardwareBean != null) {
            if (str.equals("Ampere") && (list4 = videoCodingHardwareBean.Ampere) != null) {
                return list4;
            }
            if (str.equals("Kp") && (list3 = videoCodingHardwareBean.Kp) != null) {
                return list3;
            }
            if (str.equals("Board865") && (list2 = videoCodingHardwareBean.Board865) != null) {
                return list2;
            }
            if (str.equals("Board8550") && (list = videoCodingHardwareBean.Board8550) != null) {
                return list;
            }
            if (videoCodingHardwareBean.Default != null) {
                CGLog.i("matchHardWareType default for type: " + str);
                return videoCodingHardwareBean.Default;
            }
            return null;
        }
        return null;
    }

    public VideoCodingBean getVideoCodingForH264() {
        CGModelAbility cGModelAbility = this.modelAbility;
        if (cGModelAbility != null && cGModelAbility.isH264()) {
            VideoCodingWrapper videoCodingWrapper = this.videoCoding;
            if (videoCodingWrapper == null) {
                return null;
            }
            VideoCodingBean videoCodingBean = videoCodingWrapper.H264;
            if (videoCodingBean != null) {
                adjustHardwareDecode(videoCodingBean);
            }
            return this.videoCoding.H264;
        }
        VideoCodingWrapper videoCodingWrapper2 = this.videoCoding;
        if (videoCodingWrapper2 == null) {
            return null;
        }
        return videoCodingWrapper2.H264;
    }

    public VideoCodingBean getVideoCodingForH264AiSR() {
        CGModelAbility cGModelAbility = this.modelAbility;
        if (cGModelAbility != null && cGModelAbility.isH264()) {
            VideoCodingWrapper videoCodingWrapper = this.videoCoding;
            if (videoCodingWrapper == null) {
                return null;
            }
            VideoCodingBean videoCodingBean = videoCodingWrapper.H264SuperResolution;
            if (videoCodingBean != null) {
                adjustHardwareDecode(videoCodingBean);
            }
            return this.videoCoding.H264SuperResolution;
        }
        VideoCodingWrapper videoCodingWrapper2 = this.videoCoding;
        if (videoCodingWrapper2 == null) {
            return null;
        }
        return videoCodingWrapper2.H264SuperResolution;
    }

    public VideoCodingBean getVideoCodingForH264FSR() {
        CGModelAbility cGModelAbility = this.modelAbility;
        if (cGModelAbility != null && cGModelAbility.isH264()) {
            VideoCodingWrapper videoCodingWrapper = this.videoCoding;
            if (videoCodingWrapper == null) {
                return null;
            }
            VideoCodingBean videoCodingBean = videoCodingWrapper.H264FsrSuperResolution;
            if (videoCodingBean != null) {
                adjustHardwareDecode(videoCodingBean);
            }
            return this.videoCoding.H264FsrSuperResolution;
        }
        VideoCodingWrapper videoCodingWrapper2 = this.videoCoding;
        if (videoCodingWrapper2 == null) {
            return null;
        }
        return videoCodingWrapper2.H264FsrSuperResolution;
    }

    public VideoCodingBean getVideoCodingForH265() {
        CGModelAbility cGModelAbility = this.modelAbility;
        if (cGModelAbility != null && cGModelAbility.isH265()) {
            VideoCodingWrapper videoCodingWrapper = this.videoCoding;
            if (videoCodingWrapper == null) {
                return null;
            }
            if (videoCodingWrapper.H265 == null) {
                videoCodingWrapper.H265 = VideoCodingBean.copy(videoCodingWrapper.H264);
            }
            adjustHardwareDecode(this.videoCoding.H265);
            return this.videoCoding.H265;
        }
        VideoCodingWrapper videoCodingWrapper2 = this.videoCoding;
        if (videoCodingWrapper2 == null) {
            return null;
        }
        return videoCodingWrapper2.H265;
    }

    public VideoCodingBean getVideoCodingForH265AiSR() {
        CGModelAbility cGModelAbility = this.modelAbility;
        if (cGModelAbility != null && cGModelAbility.isH265()) {
            VideoCodingWrapper videoCodingWrapper = this.videoCoding;
            if (videoCodingWrapper == null) {
                return null;
            }
            VideoCodingBean videoCodingBean = videoCodingWrapper.H265SuperResolution;
            if (videoCodingBean != null) {
                adjustHardwareDecode(videoCodingBean);
            }
            return this.videoCoding.H265SuperResolution;
        }
        VideoCodingWrapper videoCodingWrapper2 = this.videoCoding;
        if (videoCodingWrapper2 == null) {
            return null;
        }
        return videoCodingWrapper2.H265SuperResolution;
    }

    public VideoCodingBean getVideoCodingForH265FSR() {
        CGModelAbility cGModelAbility = this.modelAbility;
        if (cGModelAbility != null && cGModelAbility.isH265()) {
            VideoCodingWrapper videoCodingWrapper = this.videoCoding;
            if (videoCodingWrapper == null) {
                return null;
            }
            VideoCodingBean videoCodingBean = videoCodingWrapper.H265FsrSuperResolution;
            if (videoCodingBean != null) {
                adjustHardwareDecode(videoCodingBean);
            }
            return this.videoCoding.H265FsrSuperResolution;
        }
        VideoCodingWrapper videoCodingWrapper2 = this.videoCoding;
        if (videoCodingWrapper2 == null) {
            return null;
        }
        return videoCodingWrapper2.H265FsrSuperResolution;
    }

    public GmCgGameConfigInfo toGmCgGameConfigInfo() {
        GmCgGameConfigInfo gmCgGameConfigInfo = new GmCgGameConfigInfo();
        gmCgGameConfigInfo.pPackageName = this.apk;
        gmCgGameConfigInfo.pFps = this.fps;
        gmCgGameConfigInfo.pScreenOrientation = this.screenOrientation;
        gmCgGameConfigInfo.pSupportSaveArchive = this.saveArchive;
        gmCgGameConfigInfo.pLostReleaseTime = this.lostReleaseTime;
        gmCgGameConfigInfo.pSessionTime = this.sessionTime;
        gmCgGameConfigInfo.pRttThreshold = this.rttThreshold;
        gmCgGameConfigInfo.pLostRate = this.lostRate;
        gmCgGameConfigInfo.pSupportUseCloudAction = this.operationToCloud;
        gmCgGameConfigInfo.pIsCollectGame = this.collectGame;
        gmCgGameConfigInfo.pUserCanSuperResolution = this.userCanSuperResolution;
        gmCgGameConfigInfo.pFrontEndShowDelay = this.frontEndShowDelay;
        VideoCodingWrapper videoCodingWrapper = this.videoCoding;
        boolean z16 = false;
        if (videoCodingWrapper != null) {
            VideoCodingBean videoCodingBean = videoCodingWrapper.H265;
            if (videoCodingBean != null && videoCodingBean.hasValidStreamQuality()) {
                gmCgGameConfigInfo.pSupportH265 = true;
                VideoCodingBean videoCodingBean2 = this.videoCoding.H265;
                gmCgGameConfigInfo.pCodecs = videoCodingBean2.codecs;
                gmCgGameConfigInfo.pCodecs720P60Hz = videoCodingBean2.codecs720P60Hz;
                gmCgGameConfigInfo.pCodecs1080P60Hz = videoCodingBean2.codecs1080P60Hz;
            } else {
                VideoCodingBean videoCodingBean3 = this.videoCoding.H264;
                if (videoCodingBean3 != null && videoCodingBean3.hasValidStreamQuality()) {
                    gmCgGameConfigInfo.pSupportH265 = false;
                    VideoCodingBean videoCodingBean4 = this.videoCoding.H264;
                    gmCgGameConfigInfo.pCodecs = videoCodingBean4.codecs;
                    gmCgGameConfigInfo.pCodecs720P60Hz = videoCodingBean4.codecs720P60Hz;
                    gmCgGameConfigInfo.pCodecs1080P60Hz = videoCodingBean4.codecs1080P60Hz;
                } else {
                    gmCgGameConfigInfo.pSupportH265 = false;
                    gmCgGameConfigInfo.pCodecs = GmCgCodecAbility.CODEC_HARDWARE.getValue();
                    GmCgCodecAbility gmCgCodecAbility = GmCgCodecAbility.CODEC_BOTH_BAD;
                    gmCgGameConfigInfo.pCodecs720P60Hz = gmCgCodecAbility.getValue();
                    gmCgGameConfigInfo.pCodecs1080P60Hz = gmCgCodecAbility.getValue();
                }
            }
        } else {
            gmCgGameConfigInfo.pSupportH265 = false;
            gmCgGameConfigInfo.pCodecs = this.codecs;
            GmCgCodecAbility gmCgCodecAbility2 = GmCgCodecAbility.CODEC_BOTH_BAD;
            gmCgGameConfigInfo.pCodecs720P60Hz = gmCgCodecAbility2.getValue();
            gmCgGameConfigInfo.pCodecs1080P60Hz = gmCgCodecAbility2.getValue();
        }
        if (CGStringUtil.isEmpty(gmCgGameConfigInfo.pCodecs)) {
            gmCgGameConfigInfo.pCodecs = GmCgCodecAbility.CODEC_HARDWARE.getValue();
        }
        if (CGStringUtil.isEmpty(gmCgGameConfigInfo.pCodecs720P60Hz)) {
            gmCgGameConfigInfo.pCodecs720P60Hz = GmCgCodecAbility.CODEC_BOTH_BAD.getValue();
        }
        if (CGStringUtil.isEmpty(gmCgGameConfigInfo.pCodecs1080P60Hz)) {
            gmCgGameConfigInfo.pCodecs1080P60Hz = GmCgCodecAbility.CODEC_BOTH_BAD.getValue();
        }
        if (GmCgCodecAbility.isHardwareAbility(gmCgGameConfigInfo.pCodecs720P60Hz) || GmCgCodecAbility.isHardwareAbility(gmCgGameConfigInfo.pCodecs1080P60Hz)) {
            z16 = true;
        }
        gmCgGameConfigInfo.pSupport60Hz = z16;
        gmCgGameConfigInfo.pMidasPathOfQQ = this.midasPathQQ;
        gmCgGameConfigInfo.pMidasPathOfWeChat = this.midasPathWechat;
        gmCgGameConfigInfo.pMidasEnv = this.midasEnv;
        gmCgGameConfigInfo.pMidasPayType = this.midasPayType;
        gmCgGameConfigInfo.pUseV2CloudGameLogin = this.cloudGameAutoLogin;
        gmCgGameConfigInfo.pTimeNotEnoughThreshold = this.timeNotEnoughThreshold;
        gmCgGameConfigInfo.pEnableLocalInput = this.isSupportLocalInput;
        gmCgGameConfigInfo.pArchiveLoadingTime = this.archiveLoadingTime;
        gmCgGameConfigInfo.pNoConnectReleaseTime = this.noConnectReleaseTime;
        gmCgGameConfigInfo.pSubAccountLostReleaseTime = this.subAccountLostReleaseTime;
        gmCgGameConfigInfo.pSubAccountNoConnectReleaseTime = this.subAccountNoConnectReleaseTime;
        ResolutionBean resolutionBean = this.resolution;
        if (resolutionBean != null) {
            GmCgGameResolutionCfg gmCgGameResolutionCfg = gmCgGameConfigInfo.pResolutionCfg;
            gmCgGameResolutionCfg.pWidth = resolutionBean.width;
            gmCgGameResolutionCfg.pHeight = resolutionBean.height;
        }
        SensorBean sensorBean = this.sensor;
        if (sensorBean != null) {
            GmCgGameSensorCfg gmCgGameSensorCfg = gmCgGameConfigInfo.pSensorCfg;
            gmCgGameSensorCfg.pEnableVoice = sensorBean.voice;
            gmCgGameSensorCfg.pEnableGyro = sensorBean.gyro;
            gmCgGameSensorCfg.pEnableAcceleration = sensorBean.acceleration;
            gmCgGameSensorCfg.pEnableGravity = sensorBean.gravity;
            gmCgGameSensorCfg.pEnableGps = sensorBean.gps;
        }
        LoadingViewBean loadingViewBean = this.loadingView;
        if (loadingViewBean != null) {
            GmCgGameLoadingViewCfg gmCgGameLoadingViewCfg = gmCgGameConfigInfo.pLoadingViewCfg;
            gmCgGameLoadingViewCfg.pLoadingAnimation = loadingViewBean.animation;
            gmCgGameLoadingViewCfg.pLoadingPicture = loadingViewBean.picture;
            gmCgGameLoadingViewCfg.pLoadingPictureColor = loadingViewBean.pictureColor;
            gmCgGameLoadingViewCfg.pLoadingTipsColor = loadingViewBean.tipsColor;
            gmCgGameLoadingViewCfg.pLoadingTips = new ArrayList();
            GmCgGameLoadingViewCfg gmCgGameLoadingViewCfg2 = gmCgGameConfigInfo.pLoadingViewCfg;
            LoadingViewBean loadingViewBean2 = this.loadingView;
            gmCgGameLoadingViewCfg2.pEnterGamePicture = loadingViewBean2.enterGamePicture;
            gmCgGameLoadingViewCfg2.pEnterGamePictureForVip = loadingViewBean2.enterGamePictureVip;
            gmCgGameLoadingViewCfg2.pFpsTipPicture = loadingViewBean2.fpsTipPicture;
            List<String> list = loadingViewBean2.tips;
            if (list != null) {
                gmCgGameLoadingViewCfg2.pLoadingTips.addAll(list);
            }
        }
        List<StreamQualityBean> list2 = this.streamQuality;
        if (list2 != null) {
            for (StreamQualityBean streamQualityBean : list2) {
                GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg = new GmCgGameStreamQualityCfg();
                gmCgGameStreamQualityCfg.pId = streamQualityBean.f107892id;
                gmCgGameStreamQualityCfg.pBandwidthMax = streamQualityBean.bandwidth;
                gmCgGameStreamQualityCfg.pBandwidthMin = streamQualityBean.limitBandwidth;
                gmCgGameStreamQualityCfg.pIsDefault = streamQualityBean.isDefault;
                gmCgGameStreamQualityCfg.pName = streamQualityBean.name;
                gmCgGameStreamQualityCfg.pFps = streamQualityBean.FPS;
                gmCgGameStreamQualityCfg.pResWidth = streamQualityBean.width;
                gmCgGameStreamQualityCfg.pResHeight = streamQualityBean.height;
                gmCgGameStreamQualityCfg.pForVip = streamQualityBean.vip;
                gmCgGameConfigInfo.pStreamQualityCfg.add(gmCgGameStreamQualityCfg);
            }
        }
        GameLoginConfigBean gameLoginConfigBean = this.autoLoginConfig;
        if (gameLoginConfigBean != null) {
            GmCgGameLoginConfigInfo gmCgGameLoginConfigInfo = gmCgGameConfigInfo.pGameLoginConfigInfo;
            gmCgGameLoginConfigInfo.mIsCloudGameAutoLogin = gameLoginConfigBean.cloudGameAutoLogin;
            gmCgGameLoginConfigInfo.mLoginAccountType = gameLoginConfigBean.loginAccountType;
            gmCgGameLoginConfigInfo.mLoginType = gameLoginConfigBean.loginType;
            gmCgGameLoginConfigInfo.mQQAppId = gameLoginConfigBean.qqAppid;
            gmCgGameLoginConfigInfo.mWechatAppId = gameLoginConfigBean.wechatAppid;
            gmCgGameLoginConfigInfo.mSdkType = gameLoginConfigBean.sdkType;
        }
        gmCgGameConfigInfo.pNoOperateTimeout = this.noOperateTimeout;
        gmCgGameConfigInfo.pSupportNotchScreen = this.supportNotchScreen;
        gmCgGameConfigInfo.pSupportQuic = this.supportQuic;
        CodecConfigBean codecConfigBean = this.codec_config;
        if (codecConfigBean != null) {
            GmCgGameCodecConfig gmCgGameCodecConfig = gmCgGameConfigInfo.pGameCodecConfig;
            gmCgGameCodecConfig.pEnabled = true;
            gmCgGameCodecConfig.pCodecType = codecConfigBean.codec;
            gmCgGameCodecConfig.pRenderViewType = codecConfigBean.view;
            gmCgGameCodecConfig.pEnableTunnel = "on".equalsIgnoreCase(codecConfigBean.tunnel);
            GmCgGameCodecConfig gmCgGameCodecConfig2 = gmCgGameConfigInfo.pGameCodecConfig;
            CodecConfigBean codecConfigBean2 = this.codec_config;
            gmCgGameCodecConfig2.pReferencesCnt = codecConfigBean2.references;
            gmCgGameCodecConfig2.pFps = codecConfigBean2.fps;
            gmCgGameCodecConfig2.pResolution = codecConfigBean2.resolution;
            gmCgGameCodecConfig2.pEnableVoice = "on".equalsIgnoreCase(codecConfigBean2.voice_switch);
        }
        gmCgGameConfigInfo.pImgQualityFirst = this.imgQualityFirst;
        gmCgGameConfigInfo.pDisableMediaEncryption = this.disableEncryption;
        return gmCgGameConfigInfo;
    }

    public void updateVideoCodingStreamQualityBean(String str) {
        VideoCodingHardwareWrapper videoCodingHardwareWrapper;
        CGLog.i("updateVideoCodingStreamQualityBean hardWareType: " + str);
        if (!CGStringUtil.isEmpty(str) && (videoCodingHardwareWrapper = this.videoCodingHardwareStreamRate) != null) {
            VideoCodingHardwareBean videoCodingHardwareBean = videoCodingHardwareWrapper.H265;
            if (videoCodingHardwareBean != null) {
                List<StreamQualityBean> matchHardWareType = matchHardWareType(str, videoCodingHardwareBean);
                if (this.videoCoding.H265 != null && matchHardWareType != null) {
                    CGLog.i("updateVideoCodingStreamQualityBean H265 for videoCoding");
                    this.videoCoding.H265.streamQuality = matchHardWareType;
                    return;
                }
                return;
            }
            VideoCodingHardwareBean videoCodingHardwareBean2 = videoCodingHardwareWrapper.H264;
            if (videoCodingHardwareBean2 != null) {
                List<StreamQualityBean> matchHardWareType2 = matchHardWareType(str, videoCodingHardwareBean2);
                if (this.videoCoding.H264 != null && matchHardWareType2 != null) {
                    CGLog.i("updateVideoCodingStreamQualityBean H264 for videoCoding");
                    this.videoCoding.H264.streamQuality = matchHardWareType2;
                }
            }
        }
    }
}
