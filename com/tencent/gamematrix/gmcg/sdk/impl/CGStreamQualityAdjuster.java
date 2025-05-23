package com.tencent.gamematrix.gmcg.sdk.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.GmCgCodecAbility;
import com.tencent.gamematrix.gmcg.api.GmCgPlayPerfListener;
import com.tencent.gamematrix.gmcg.api.GmCgSuperResolutionType;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameStreamQualityCfg;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.service.CGGameConfigResp;
import com.tencent.gamematrix.gmcg.webrtc.VideoCodecType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGStreamQualityAdjuster {
    private static final int DEFAULT_ID_OF_ADAPTIVE_CFG = 0;
    private static final int DEFAULT_MAX_BITRATE_KBPS = 400;
    public static final int DEFAULT_MIN_BITRATE_KBPS = 300;
    private static final int SDP_DEFAULT_MAX_BANDWIDTH = 15000;
    private static final int SDP_DEFAULT_MAX_BANDWIDTH_TV = 30000;
    private static final int SDP_DEFAULT_MIN_BANDWIDTH = 300;
    private static final int SDP_DEFAULT_MIN_BANDWIDTH_TV = 4000;
    private List<GmCgGameStreamQualityCfg> mDefaultStreamQualityCfg;
    private boolean mEnableAdaptiveStreamQuality;
    private final boolean mForPreview;
    private boolean mForceUseCustomDecType;
    private boolean mForceUseDecH265;
    private boolean mForceUseDecSoft;
    private boolean mIsCustom;
    private boolean mIsVip;
    private final GmCgPlayPerfListener mPlayPerfListener;
    private CGGameConfigResp.VideoCodingBean mStreamCfgOfH264;
    private CGGameConfigResp.VideoCodingBean mStreamCfgOfH265;
    private final StreamQualityAction mStreamQualityAction;
    private boolean mUseLegacyCfg;
    private int mCurStreamQualityId = -1;
    private VideoCodecType mCurVideoCodecType = VideoCodecType.H264;

    @NonNull
    private CGGameConfigResp.VideoCodingBean mCurVideoCodingBean = CGGameConfigResp.VideoCodingBean.createDefault();
    private int mMinBandwidthOfAll = 300;
    private int mMaxBandwidthOfAll = 15000;
    private int mDefaultMinBitrate = 300;
    private int mDefaultMaxBitrate = 15000;
    private int mSDPOfferMaxBandWidth = Integer.MIN_VALUE;
    private int mSDPOfferMinBandWidth = Integer.MAX_VALUE;
    private boolean mIsDefaultMinBitrateSetFromOutside = false;
    private boolean mIsDefaultMaxBitrateSetFromOutside = false;
    private int mSuperResolutionType = 0;
    private boolean mRegenerateAdaptive = false;

    @NonNull
    private List<GmCgGameStreamQualityCfg> mStreamQualityCfgList = Collections.synchronizedList(new ArrayList());

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface StreamQualityAction {
        void setVideoBitrateToEndian(int i3, int i16);
    }

    public CGStreamQualityAdjuster(boolean z16, StreamQualityAction streamQualityAction, GmCgPlayPerfListener gmCgPlayPerfListener, boolean z17, List<GmCgGameStreamQualityCfg> list) {
        this.mDefaultStreamQualityCfg = generateInternalDefaultStreamQualityCfg();
        this.mEnableAdaptiveStreamQuality = z16;
        this.mStreamQualityAction = streamQualityAction;
        this.mPlayPerfListener = gmCgPlayPerfListener;
        this.mForPreview = z17;
        if (list != null && list.size() > 0) {
            this.mDefaultStreamQualityCfg = list;
        }
    }

    @Nullable
    private GmCgGameStreamQualityCfg addAdaptiveStreamQualityCfgIfNeed(List<GmCgGameStreamQualityCfg> list, boolean z16) {
        if (this.mEnableAdaptiveStreamQuality && list != null && !list.isEmpty()) {
            GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg = list.get(0);
            boolean z17 = true;
            if (gmCgGameStreamQualityCfg.pId == 0) {
                if (list.size() == 1) {
                    CGLog.w("streamQualityCfgList only have one streamQualityCfg that is adaptive, return it!");
                    return gmCgGameStreamQualityCfg;
                }
                gmCgGameStreamQualityCfg = list.get(1);
            }
            this.mMinBandwidthOfAll = gmCgGameStreamQualityCfg.pBandwidthMin;
            this.mMaxBandwidthOfAll = gmCgGameStreamQualityCfg.pBandwidthMax;
            int i3 = -1;
            for (int i16 = 0; i16 < list.size(); i16++) {
                GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg2 = list.get(i16);
                if (gmCgGameStreamQualityCfg2.pId == 0) {
                    i3 = i16;
                } else if (!gmCgGameStreamQualityCfg2.pForVip || z16) {
                    int i17 = this.mMinBandwidthOfAll;
                    int i18 = gmCgGameStreamQualityCfg2.pBandwidthMin;
                    if (i17 > i18) {
                        this.mMinBandwidthOfAll = i18;
                    }
                    int i19 = this.mMaxBandwidthOfAll;
                    int i26 = gmCgGameStreamQualityCfg2.pBandwidthMax;
                    if (i19 < i26) {
                        this.mMaxBandwidthOfAll = i26;
                    }
                }
            }
            if (i3 == -1) {
                GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg3 = new GmCgGameStreamQualityCfg();
                gmCgGameStreamQualityCfg3.pId = 0;
                gmCgGameStreamQualityCfg3.pBandwidthMin = getCustomMinBitrate(this.mMinBandwidthOfAll);
                gmCgGameStreamQualityCfg3.pBandwidthMax = getCustomMaxBitRate(this.mMaxBandwidthOfAll);
                if (this.mCurStreamQualityId >= 0) {
                    z17 = false;
                }
                gmCgGameStreamQualityCfg3.pIsDefault = z17;
                gmCgGameStreamQualityCfg3.pName = "\u81ea\u52a8";
                gmCgGameStreamQualityCfg3.pFps = gmCgGameStreamQualityCfg.pFps;
                gmCgGameStreamQualityCfg3.pResWidth = gmCgGameStreamQualityCfg.pResWidth;
                gmCgGameStreamQualityCfg3.pResHeight = gmCgGameStreamQualityCfg.pResHeight;
                gmCgGameStreamQualityCfg3.pForVip = false;
                gmCgGameStreamQualityCfg3.pVideoCodec = this.mCurVideoCodecType.mimeType();
                gmCgGameStreamQualityCfg3.superResolutionType = this.mSuperResolutionType;
                list.add(0, gmCgGameStreamQualityCfg3);
                return gmCgGameStreamQualityCfg3;
            }
            GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg4 = list.get(i3);
            gmCgGameStreamQualityCfg4.pBandwidthMin = getCustomMinBitrate(this.mMinBandwidthOfAll);
            gmCgGameStreamQualityCfg4.pBandwidthMax = getCustomMaxBitRate(this.mMaxBandwidthOfAll);
            list.set(i3, gmCgGameStreamQualityCfg4);
            return gmCgGameStreamQualityCfg4;
        }
        return null;
    }

    private void calculateSdpOffer() {
        List<CGGameConfigResp.StreamQualityBean> list;
        List<CGGameConfigResp.StreamQualityBean> list2;
        CGGameConfigResp.VideoCodingBean videoCodingBean = this.mStreamCfgOfH265;
        boolean z16 = true;
        if (videoCodingBean != null && (list2 = videoCodingBean.streamQuality) != null) {
            for (CGGameConfigResp.StreamQualityBean streamQualityBean : list2) {
                int i3 = streamQualityBean.bandwidth;
                if (i3 > this.mSDPOfferMaxBandWidth) {
                    this.mSDPOfferMaxBandWidth = i3;
                }
                int i16 = streamQualityBean.limitBandwidth;
                if (i16 < this.mSDPOfferMinBandWidth) {
                    this.mSDPOfferMinBandWidth = i16;
                }
                z16 = false;
            }
        } else {
            CGGameConfigResp.VideoCodingBean videoCodingBean2 = this.mStreamCfgOfH264;
            if (videoCodingBean2 != null && (list = videoCodingBean2.streamQuality) != null) {
                for (CGGameConfigResp.StreamQualityBean streamQualityBean2 : list) {
                    int i17 = streamQualityBean2.bandwidth;
                    if (i17 > this.mSDPOfferMaxBandWidth) {
                        this.mSDPOfferMaxBandWidth = i17;
                    }
                    int i18 = streamQualityBean2.limitBandwidth;
                    if (i18 < this.mSDPOfferMinBandWidth) {
                        this.mSDPOfferMinBandWidth = i18;
                    }
                    z16 = false;
                }
            }
        }
        if (z16) {
            for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg : this.mDefaultStreamQualityCfg) {
                int i19 = gmCgGameStreamQualityCfg.pBandwidthMax;
                if (i19 > this.mSDPOfferMaxBandWidth) {
                    this.mSDPOfferMaxBandWidth = i19;
                }
                int i26 = gmCgGameStreamQualityCfg.pBandwidthMin;
                if (i26 < this.mSDPOfferMinBandWidth) {
                    this.mSDPOfferMinBandWidth = i26;
                }
            }
        }
        if (this.mSDPOfferMaxBandWidth == Integer.MIN_VALUE) {
            if (CGGlbConfig.isForTV()) {
                this.mSDPOfferMaxBandWidth = 30000;
            } else {
                this.mSDPOfferMaxBandWidth = 15000;
            }
        }
        if (this.mSDPOfferMinBandWidth == Integer.MAX_VALUE) {
            if (CGGlbConfig.isForTV()) {
                this.mSDPOfferMinBandWidth = 4000;
            } else {
                this.mSDPOfferMinBandWidth = 300;
            }
        }
        CGLog.i("rogers-test , CGStreamQualityAdjuster/calculateSdpOffer: result: max = " + this.mSDPOfferMaxBandWidth + ",min = " + this.mSDPOfferMinBandWidth);
    }

    private void constructStreamQualityCfg() {
        int i3;
        if (this.mIsCustom) {
            this.mEnableAdaptiveStreamQuality = false;
        }
        this.mStreamQualityCfgList = Collections.synchronizedList(new ArrayList());
        List<CGGameConfigResp.StreamQualityBean> list = this.mCurVideoCodingBean.streamQuality;
        if (list != null) {
            for (CGGameConfigResp.StreamQualityBean streamQualityBean : list) {
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
                gmCgGameStreamQualityCfg.pVideoCodec = this.mCurVideoCodecType.mimeType();
                gmCgGameStreamQualityCfg.superResolutionType = streamQualityBean.superResolutionType;
                this.mStreamQualityCfgList.add(gmCgGameStreamQualityCfg);
            }
        }
        if (this.mStreamQualityCfgList.isEmpty()) {
            this.mCurStreamQualityId = -1;
            return;
        }
        GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg2 = this.mStreamQualityCfgList.get(0);
        Collections.sort(this.mStreamQualityCfgList, new Comparator() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dv
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$constructStreamQualityCfg$0;
                lambda$constructStreamQualityCfg$0 = CGStreamQualityAdjuster.lambda$constructStreamQualityCfg$0((GmCgGameStreamQualityCfg) obj, (GmCgGameStreamQualityCfg) obj2);
                return lambda$constructStreamQualityCfg$0;
            }
        });
        this.mCurStreamQualityId = -1;
        for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg3 : this.mStreamQualityCfgList) {
            gmCgGameStreamQualityCfg3.pBandwidthMin = getCustomMinBitrate(gmCgGameStreamQualityCfg3.pBandwidthMin);
            gmCgGameStreamQualityCfg3.pBandwidthMax = getCustomMaxBitRate(gmCgGameStreamQualityCfg3.pBandwidthMax);
            if (gmCgGameStreamQualityCfg3.pIsDefault) {
                this.mCurStreamQualityId = gmCgGameStreamQualityCfg3.pId;
            }
        }
        GmCgGameStreamQualityCfg addAdaptiveStreamQualityCfgIfNeed = addAdaptiveStreamQualityCfgIfNeed(this.mStreamQualityCfgList, this.mIsVip);
        if (this.mCurStreamQualityId < 0) {
            if (addAdaptiveStreamQualityCfgIfNeed != null) {
                i3 = addAdaptiveStreamQualityCfgIfNeed.pId;
            } else {
                i3 = gmCgGameStreamQualityCfg2.pId;
            }
            this.mCurStreamQualityId = i3;
        }
        StringBuilder sb5 = new StringBuilder();
        for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg4 : this.mStreamQualityCfgList) {
            sb5.append("\n[");
            sb5.append(gmCgGameStreamQualityCfg4.pName);
            sb5.append(", ");
            sb5.append(gmCgGameStreamQualityCfg4.pBandwidthMin);
            sb5.append(", ");
            sb5.append(gmCgGameStreamQualityCfg4.pBandwidthMax);
            sb5.append(", ");
            sb5.append(gmCgGameStreamQualityCfg4.pIsDefault);
            sb5.append(", ");
            sb5.append(gmCgGameStreamQualityCfg4.pVideoCodec);
            sb5.append("]");
        }
        CGLog.i("rogers-test , setGameStreamQualityCfg StreamQualityCfgList: " + sb5.toString());
    }

    private synchronized GmCgGameStreamQualityCfg findCfgByStreamQualityId(int i3) {
        if (i3 < 0) {
            return null;
        }
        for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg : this.mStreamQualityCfgList) {
            if (i3 == gmCgGameStreamQualityCfg.pId) {
                return gmCgGameStreamQualityCfg;
            }
        }
        return null;
    }

    private synchronized int findIndexByStreamQualityId(int i3) {
        for (int i16 = 0; i16 < this.mStreamQualityCfgList.size(); i16++) {
            try {
                if (i3 == this.mStreamQualityCfgList.get(i16).pId) {
                    return i16;
                }
            } catch (IndexOutOfBoundsException unused) {
                return -1;
            }
        }
        return -1;
    }

    private static List<GmCgGameStreamQualityCfg> generateInternalDefaultStreamQualityCfg() {
        ArrayList arrayList = new ArrayList(3);
        if (CGGlbConfig.isForTV()) {
            arrayList.add(mockGmCgGameStreamQualityCfg(1, "\u81ea\u52a8", 5500, 30000, true));
            arrayList.add(mockGmCgGameStreamQualityCfg(2, "\u9ad8\u6e05", 4000, 5500, false));
            arrayList.add(mockGmCgGameStreamQualityCfg(3, "\u8d85\u6e05", 6000, 10000, false));
        } else {
            arrayList.add(mockGmCgGameStreamQualityCfg(2147483644, "\u6807\u6e05", 1000, 3000, true));
            arrayList.add(mockGmCgGameStreamQualityCfg(2147483645, "\u9ad8\u6e05", 3000, 5000, false));
            arrayList.add(mockGmCgGameStreamQualityCfg(2147483646, "\u8d85\u6e05", 5000, 8000, false));
        }
        return arrayList;
    }

    private int getCustomMaxBitRate(int i3) {
        return Math.max(i3, this.mDefaultMinBitrate + 100);
    }

    private int getCustomMinBitrate(int i3) {
        if (i3 <= 0) {
            return 300;
        }
        return Math.max(i3, this.mDefaultMinBitrate);
    }

    private int getLaunchMaxBitrate(int i3) {
        if (i3 > 0) {
            return Math.max(i3, 400);
        }
        for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg : this.mStreamQualityCfgList) {
            if (gmCgGameStreamQualityCfg.pIsDefault) {
                return gmCgGameStreamQualityCfg.pBandwidthMax;
            }
        }
        return 400;
    }

    private int getLaunchMinBitrate(int i3) {
        return 300;
    }

    private boolean hasValidH265VideoConfig(CGGameConfigResp.VideoCodingBean videoCodingBean) {
        if (hasValidVideoConfig(videoCodingBean) && GmCgCodecAbility.isHardwareAbility(videoCodingBean.codecs)) {
            return true;
        }
        return false;
    }

    private boolean hasValidVideoConfig(CGGameConfigResp.VideoCodingBean videoCodingBean) {
        if (videoCodingBean != null && videoCodingBean.hasValidStreamQuality()) {
            return true;
        }
        return false;
    }

    private boolean inAdaptiveMode() {
        if (!this.mForPreview && (!this.mEnableAdaptiveStreamQuality || this.mCurStreamQualityId != 0)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$constructStreamQualityCfg$0(GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg, GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg2) {
        return gmCgGameStreamQualityCfg.pBandwidthMax - gmCgGameStreamQualityCfg2.pBandwidthMax;
    }

    public static GmCgGameStreamQualityCfg mockGmCgGameStreamQualityCfg(int i3, String str, int i16, int i17, boolean z16) {
        GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg = new GmCgGameStreamQualityCfg();
        gmCgGameStreamQualityCfg.pId = i3;
        gmCgGameStreamQualityCfg.pName = str;
        gmCgGameStreamQualityCfg.pBandwidthMin = i16;
        gmCgGameStreamQualityCfg.pBandwidthMax = i17;
        gmCgGameStreamQualityCfg.pIsDefault = z16;
        gmCgGameStreamQualityCfg.pVideoCodec = VideoCodecType.H264.mimeType();
        return gmCgGameStreamQualityCfg;
    }

    private void setPlayVideoStreamQualityCfg(GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg) {
        if (gmCgGameStreamQualityCfg != null) {
            this.mCurStreamQualityId = gmCgGameStreamQualityCfg.pId;
            setPlayVideoBitrate(gmCgGameStreamQualityCfg.pBandwidthMin, gmCgGameStreamQualityCfg.pBandwidthMax);
        }
    }

    public void adjustAdaptivePlayStreamQuality() {
        if (this.mCurStreamQualityId == 0 && this.mRegenerateAdaptive) {
            CGLog.i("mCurStreamQualityId is adaptive and mRegenerateAdaptive is true, set adaptive stream quality again ");
            setPlayVideoStreamQuality(this.mCurStreamQualityId);
            this.mRegenerateAdaptive = false;
        }
    }

    public boolean badAbilityToRun() {
        return GmCgCodecAbility.isTooBadAbility(this.mCurVideoCodingBean.codecs);
    }

    public void forceUseCustomDecType(boolean z16, boolean z17, boolean z18) {
        CGLog.i("forceUseCustomDecType: " + z16 + "|" + z17 + "|" + z18);
        this.mForceUseCustomDecType = z16;
        this.mForceUseDecH265 = z17;
        this.mForceUseDecSoft = z18;
    }

    public GmCgGameStreamQualityCfg getCurStreamQualityCfg() {
        return findCfgByStreamQualityId(this.mCurStreamQualityId);
    }

    public int getCurStreamQualityCfgId() {
        return this.mCurStreamQualityId;
    }

    public int getCurStreamQualityId() {
        return this.mCurStreamQualityId;
    }

    public int getMaxBandwidthForSdp() {
        if (this.mIsDefaultMaxBitrateSetFromOutside) {
            return this.mDefaultMaxBitrate;
        }
        int i3 = this.mSDPOfferMaxBandWidth;
        if (i3 == Integer.MIN_VALUE) {
            if (CGGlbConfig.isForTV()) {
                return 30000;
            }
            return 15000;
        }
        return i3;
    }

    public int getMinBandwidthForSdp() {
        if (this.mIsDefaultMinBitrateSetFromOutside) {
            return this.mDefaultMinBitrate;
        }
        int i3 = this.mSDPOfferMinBandWidth;
        if (i3 == Integer.MAX_VALUE) {
            if (CGGlbConfig.isForTV()) {
                return 4000;
            }
            return 300;
        }
        return i3;
    }

    public GmCgCodecAbility getStreamCodecAbility() {
        return GmCgCodecAbility.fromValue(this.mCurVideoCodingBean.codecs);
    }

    public List<GmCgGameStreamQualityCfg> getStreamQualityCfgList() {
        return this.mStreamQualityCfgList;
    }

    public VideoCodecType getStreamVideoCodecType() {
        return this.mCurVideoCodecType;
    }

    public synchronized void onPlayStreamStutterHappen() {
        int findIndexByStreamQualityId;
        GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg = null;
        if (!inAdaptiveMode() && (findIndexByStreamQualityId = findIndexByStreamQualityId(this.mCurStreamQualityId)) > 0 && this.mStreamQualityCfgList.size() > 1) {
            GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg2 = this.mStreamQualityCfgList.get(findIndexByStreamQualityId - 1);
            if (gmCgGameStreamQualityCfg2.pId != 0) {
                gmCgGameStreamQualityCfg = gmCgGameStreamQualityCfg2;
            }
        }
        GmCgPlayPerfListener gmCgPlayPerfListener = this.mPlayPerfListener;
        if (gmCgPlayPerfListener != null) {
            gmCgPlayPerfListener.onGmCgPlayPerfStreamQualityAdjust(inAdaptiveMode(), gmCgGameStreamQualityCfg);
        }
    }

    public synchronized void onVideoCodecTypeReported(VideoCodecType videoCodecType) {
        CGLog.i("CGStreamQualityAdjuster onVideoCodecTypeReported: " + videoCodecType.mimeType());
        if (this.mUseLegacyCfg) {
            CGLog.i("CGStreamQualityAdjuster onVideoCodecTypeReported use legacy ");
            return;
        }
        VideoCodecType videoCodecType2 = VideoCodecType.H264;
        if (videoCodecType == videoCodecType2 && this.mCurVideoCodecType == VideoCodecType.H265) {
            this.mCurVideoCodecType = videoCodecType2;
            this.mCurVideoCodingBean = this.mStreamCfgOfH264;
        }
        if (!hasValidVideoConfig(this.mCurVideoCodingBean)) {
            CGGameConfigResp.VideoCodingBean videoCodingBean = new CGGameConfigResp.VideoCodingBean();
            this.mCurVideoCodingBean = videoCodingBean;
            videoCodingBean.codecs = GmCgCodecAbility.CODEC_HARDWARE.getValue();
            this.mCurVideoCodingBean.streamQuality = new ArrayList();
            List<GmCgGameStreamQualityCfg> list = this.mDefaultStreamQualityCfg;
            if (list != null && list.size() > 0) {
                for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg : this.mDefaultStreamQualityCfg) {
                    CGGameConfigResp.StreamQualityBean streamQualityBean = new CGGameConfigResp.StreamQualityBean();
                    streamQualityBean.f107892id = gmCgGameStreamQualityCfg.pId;
                    streamQualityBean.name = gmCgGameStreamQualityCfg.pName;
                    streamQualityBean.bandwidth = gmCgGameStreamQualityCfg.pBandwidthMax;
                    streamQualityBean.limitBandwidth = gmCgGameStreamQualityCfg.pBandwidthMin;
                    streamQualityBean.FPS = gmCgGameStreamQualityCfg.pFps;
                    streamQualityBean.width = gmCgGameStreamQualityCfg.pResWidth;
                    streamQualityBean.height = gmCgGameStreamQualityCfg.pResHeight;
                    streamQualityBean.isDefault = gmCgGameStreamQualityCfg.pIsDefault;
                    streamQualityBean.vip = gmCgGameStreamQualityCfg.pForVip;
                    this.mCurVideoCodingBean.streamQuality.add(streamQualityBean);
                }
            }
        }
        constructStreamQualityCfg();
    }

    public List<GmCgGameStreamQualityCfg> regenerateAdaptivePlayStreamQuality(boolean z16) {
        this.mRegenerateAdaptive = true;
        addAdaptiveStreamQualityCfgIfNeed(this.mStreamQualityCfgList, z16);
        CGLog.i("refreshStreamQualities StreamQualityCfgList: ");
        for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg : this.mStreamQualityCfgList) {
            CGLog.i("[" + gmCgGameStreamQualityCfg.pName + ", " + gmCgGameStreamQualityCfg.pBandwidthMin + ", " + gmCgGameStreamQualityCfg.pBandwidthMax + ", " + gmCgGameStreamQualityCfg.pIsDefault + ", " + gmCgGameStreamQualityCfg.pVideoCodec + "]");
        }
        return this.mStreamQualityCfgList;
    }

    public void setDefaultMaxBitrateKbps(int i3) {
        if (i3 > 0) {
            this.mDefaultMaxBitrate = i3;
            this.mIsDefaultMaxBitrateSetFromOutside = true;
        }
    }

    public void setDefaultMinBitrateKbps(int i3) {
        if (i3 > 0) {
            this.mDefaultMinBitrate = i3;
            this.mIsDefaultMinBitrateSetFromOutside = true;
        }
    }

    public void setGameStreamCfgForLegacy(List<GmCgGameStreamQualityCfg> list) {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGStreamQualityAdjuster: setGameStreamCfgForLegacy ");
        if (list != null) {
            obj = Integer.valueOf(list.size());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        CGLog.i(sb5.toString());
        this.mUseLegacyCfg = true;
        this.mIsCustom = false;
        this.mStreamCfgOfH264 = CGGameConfigResp.VideoCodingBean.createDefault();
        this.mSuperResolutionType = 0;
        if (list != null) {
            for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg : list) {
                CGGameConfigResp.StreamQualityBean streamQualityBean = new CGGameConfigResp.StreamQualityBean();
                streamQualityBean.f107892id = gmCgGameStreamQualityCfg.pId;
                streamQualityBean.name = gmCgGameStreamQualityCfg.pName;
                streamQualityBean.bandwidth = gmCgGameStreamQualityCfg.pBandwidthMax;
                streamQualityBean.limitBandwidth = gmCgGameStreamQualityCfg.pBandwidthMin;
                streamQualityBean.FPS = gmCgGameStreamQualityCfg.pFps;
                streamQualityBean.width = gmCgGameStreamQualityCfg.pResWidth;
                streamQualityBean.height = gmCgGameStreamQualityCfg.pResHeight;
                streamQualityBean.isDefault = gmCgGameStreamQualityCfg.pIsDefault;
                streamQualityBean.vip = gmCgGameStreamQualityCfg.pForVip;
                this.mStreamCfgOfH264.streamQuality.add(streamQualityBean);
            }
        }
        this.mCurVideoCodecType = VideoCodecType.H264;
        this.mCurVideoCodingBean = this.mStreamCfgOfH264;
        constructStreamQualityCfg();
    }

    public void setGameStreamCfgFromCustom(List<GmCgGameStreamQualityCfg> list) {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGStreamQualityAdjuster: setGameStreamCfgFromCustom ");
        if (list != null) {
            obj = Integer.valueOf(list.size());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        CGLog.i(sb5.toString());
        this.mIsCustom = true;
        this.mStreamCfgOfH264 = CGGameConfigResp.VideoCodingBean.createDefault();
        this.mSuperResolutionType = 0;
        if (list != null) {
            for (GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg : list) {
                CGGameConfigResp.StreamQualityBean streamQualityBean = new CGGameConfigResp.StreamQualityBean();
                streamQualityBean.f107892id = gmCgGameStreamQualityCfg.pId;
                streamQualityBean.name = gmCgGameStreamQualityCfg.pName;
                streamQualityBean.bandwidth = gmCgGameStreamQualityCfg.pBandwidthMax;
                streamQualityBean.limitBandwidth = gmCgGameStreamQualityCfg.pBandwidthMin;
                streamQualityBean.FPS = gmCgGameStreamQualityCfg.pFps;
                streamQualityBean.width = gmCgGameStreamQualityCfg.pResWidth;
                streamQualityBean.height = gmCgGameStreamQualityCfg.pResHeight;
                streamQualityBean.isDefault = gmCgGameStreamQualityCfg.pIsDefault;
                streamQualityBean.vip = gmCgGameStreamQualityCfg.pForVip;
                this.mStreamCfgOfH264.streamQuality.add(streamQualityBean);
            }
        }
        this.mCurVideoCodecType = VideoCodecType.H264;
        this.mCurVideoCodingBean = this.mStreamCfgOfH264;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setGameStreamCfgFromServer(CGGameConfigResp.VideoCodingBean videoCodingBean, CGGameConfigResp.VideoCodingBean videoCodingBean2, @GmCgSuperResolutionType int i3, boolean z16) {
        GmCgCodecAbility gmCgCodecAbility;
        CGLog.i("CGStreamQualityAdjuster: setGameStreamCfgFromServer");
        boolean z17 = false;
        this.mIsCustom = false;
        this.mStreamCfgOfH264 = videoCodingBean;
        this.mStreamCfgOfH265 = videoCodingBean2;
        this.mSuperResolutionType = i3;
        this.mIsVip = z16;
        if (this.mForceUseCustomDecType) {
            if (this.mForceUseDecH265 && videoCodingBean2 == null) {
                CGLog.w("\u5f3a\u5236\u4f7f\u7528H265\u4f46\u6ca1\u6709\u914dH265\u7684\u7801\u7387\uff0c\u5219\u4f7f\u7528H264\u7684\u7801\u7387");
                this.mStreamCfgOfH265 = videoCodingBean;
            }
            if (this.mForceUseDecH265 && hasValidH265VideoConfig(this.mStreamCfgOfH265)) {
                CGLog.i("CGStreamQualityAdjuster force use H265");
                this.mCurVideoCodecType = VideoCodecType.H265;
                this.mCurVideoCodingBean = this.mStreamCfgOfH265;
            } else {
                if (!this.mForceUseDecH265 && hasValidVideoConfig(this.mStreamCfgOfH264)) {
                    this.mCurVideoCodecType = VideoCodecType.H264;
                    this.mCurVideoCodingBean = this.mStreamCfgOfH264;
                }
                if (z17) {
                    CGGameConfigResp.VideoCodingBean videoCodingBean3 = this.mCurVideoCodingBean;
                    if (this.mForceUseDecSoft) {
                        gmCgCodecAbility = GmCgCodecAbility.CODEC_SOFTWARE;
                    } else {
                        gmCgCodecAbility = GmCgCodecAbility.CODEC_HARDWARE;
                    }
                    videoCodingBean3.codecs = gmCgCodecAbility.getValue();
                    return;
                }
            }
            z17 = true;
            if (z17) {
            }
        }
        if (hasValidH265VideoConfig(this.mStreamCfgOfH265)) {
            CGLog.i("CGStreamQualityAdjuster has valid config for H265");
            this.mCurVideoCodecType = VideoCodecType.H265;
            this.mCurVideoCodingBean = this.mStreamCfgOfH265;
        } else if (hasValidVideoConfig(this.mStreamCfgOfH264)) {
            CGLog.i("CGStreamQualityAdjuster has valid config for H264");
            this.mCurVideoCodecType = VideoCodecType.H264;
            this.mCurVideoCodingBean = this.mStreamCfgOfH264;
        } else {
            CGLog.i("CGStreamQualityAdjuster no valid config use H264");
            this.mCurVideoCodecType = VideoCodecType.H264;
            this.mCurVideoCodingBean = CGGameConfigResp.VideoCodingBean.createDefault();
        }
        CGLog.i("rogers-test , CGStreamQualityAdjuster/setGameStreamCfgFromServer: now calculate Sdp offer");
        calculateSdpOffer();
    }

    public void setPlayVideoBitrate(int i3, int i16) {
        CGLog.i("CGStreamQualityAdjuster setPlayVideoBitrate: [" + i3 + ", " + i16 + "]");
        int customMinBitrate = getCustomMinBitrate(i3);
        int customMaxBitRate = getCustomMaxBitRate(i16);
        StreamQualityAction streamQualityAction = this.mStreamQualityAction;
        if (streamQualityAction != null) {
            streamQualityAction.setVideoBitrateToEndian(customMinBitrate, customMaxBitRate);
            CGLog.i("set bitrate: [" + customMinBitrate + ", " + customMaxBitRate + "]");
        }
    }

    public void setPlayVideoBitrateMax(int i3) {
        setPlayVideoBitrate(300, i3);
    }

    public GmCgGameStreamQualityCfg setPlayVideoStreamQuality(int i3) {
        if (this.mForPreview) {
            return new GmCgGameStreamQualityCfg();
        }
        CGLog.i("setPlayVideoStreamQuality id: " + i3);
        GmCgGameStreamQualityCfg findCfgByStreamQualityId = findCfgByStreamQualityId(i3);
        setPlayVideoStreamQualityCfg(findCfgByStreamQualityId);
        return findCfgByStreamQualityId;
    }

    public boolean shouldUseH265() {
        if (VideoCodecType.H265 == this.mCurVideoCodecType) {
            return true;
        }
        return false;
    }

    public boolean shouldUseHwDecode() {
        return GmCgCodecAbility.isHardwareAbilityOfWeak(this.mCurVideoCodingBean.codecs);
    }
}
