package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.api.model.GmCgAllocDeviceLabel;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import com.tencent.gamematrix.gmcg.sdk.config.CGUserDeviceInfo;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGAllocDeviceReqBody {
    public String bizInfo;
    public String bussid;
    public boolean canWait;
    public int height;
    public String identity;
    public List<GmCgAllocDeviceLabel> labels;
    public String localSession;
    public long maxUseTime;
    public String midGame;
    public boolean newDevice;
    public String packageName;
    public int pcLoginType;

    @Deprecated
    public Map<String, Integer> ping;
    public int queuePriority;
    public boolean replaceDevice;
    public int roi;
    public List<GmCgNetDetectionInfo> speedTest;
    public int superResolution;
    public boolean supportInstIp;
    public String tag;
    public boolean tiyanVip;
    public int type;
    public CGUserDeviceInfo userDeviceInfo;
    public boolean vip;
    public int width;
}
