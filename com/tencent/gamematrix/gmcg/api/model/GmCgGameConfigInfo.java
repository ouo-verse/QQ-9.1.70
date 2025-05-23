package com.tencent.gamematrix.gmcg.api.model;

import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.api.GmCgGameCodecConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgGameConfigInfo {
    public int pArchiveLoadingTime;
    public String pCodecs;
    public String pCodecs1080P60Hz;
    public String pCodecs720P60Hz;
    public boolean pDisableMediaEncryption;
    public boolean pEnableLocalInput;
    public int pFps;
    public boolean pFrontEndShowDelay;
    public boolean pImgQualityFirst;
    public boolean pIsCollectGame;
    public float pLostRate;
    public int pLostReleaseTime;
    public int pMidasEnv;
    public String pMidasPathOfQQ;
    public String pMidasPathOfWeChat;
    public int pMidasPayType;
    public int pNoConnectReleaseTime;
    public int pNoOperateTimeout;
    public String pPackageName;
    public int pRttThreshold;
    public int pScreenOrientation;
    public int pSessionTime;
    public int pSubAccountLostReleaseTime;
    public int pSubAccountNoConnectReleaseTime;
    public boolean pSupport60Hz;
    public boolean pSupportH265;
    public boolean pSupportNotchScreen;
    public boolean pSupportQuic;
    public boolean pSupportSaveArchive;
    public int pSupportSuperResolutionType;
    public boolean pSupportUseCloudAction;
    public int pTimeNotEnoughThreshold;
    public boolean pUseV2CloudGameLogin;
    public boolean pUserCanSuperResolution;

    @NonNull
    public GmCgGameResolutionCfg pResolutionCfg = new GmCgGameResolutionCfg();

    @NonNull
    public GmCgGameSensorCfg pSensorCfg = new GmCgGameSensorCfg();

    @NonNull
    public GmCgGameLoadingViewCfg pLoadingViewCfg = new GmCgGameLoadingViewCfg();
    public List<GmCgGameStreamQualityCfg> pStreamQualityCfg = new ArrayList();
    public GmCgGameLoginConfigInfo pGameLoginConfigInfo = new GmCgGameLoginConfigInfo();
    public GmCgGameCodecConfig pGameCodecConfig = new GmCgGameCodecConfig();

    public boolean hasStreamQualityCfg() {
        return !this.pStreamQualityCfg.isEmpty();
    }

    public boolean support60Hz() {
        return this.pSupport60Hz;
    }

    public boolean supportH265() {
        return this.pSupportH265;
    }
}
