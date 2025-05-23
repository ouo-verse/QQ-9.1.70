package com.tencent.mobileqq.guild.slowmode.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import mqq.app.api.IRuntimeService;
import tencent.im.group_pro_proto.common.common$FreqLimitInfo;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildSlowModeService extends IRuntimeService {
    int getSlowModeLimitCycle(String str);

    long getSlowModeLimitTime(String str);

    void handleSlowModeFreqLimit(common$FreqLimitInfo common_freqlimitinfo, String str);

    void handleSlowModeFreqLimitFromNT(FreqLimitInfo freqLimitInfo, String str);

    boolean isInSlowMode(String str);

    void removeSlowModeLimitTime(String str);

    void updateSlowModeLimitTime(String str, long j3);
}
