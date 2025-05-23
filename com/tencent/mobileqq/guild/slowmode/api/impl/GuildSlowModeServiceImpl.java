package com.tencent.mobileqq.guild.slowmode.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import st1.g;
import tencent.im.group_pro_proto.common.common$FreqLimitInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildSlowModeServiceImpl implements IGuildSlowModeService {
    private static final String TAG = "GuildSlowModeServiceImpl";
    private static final String splitter = " ";
    private AppRuntime app;
    private final ConcurrentHashMap<String, a> slowModeLimitTimeMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f235187a;

        /* renamed from: b, reason: collision with root package name */
        public long f235188b;

        /* renamed from: c, reason: collision with root package name */
        public int f235189c;

        public a() {
        }

        public a(String str, long j3, int i3) {
            this.f235187a = str;
            this.f235188b = j3;
            this.f235189c = i3;
        }
    }

    private ISlowModeInfo getSlowModeInfo(String str) {
        IGProChannelInfo channelInfo = ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getChannelInfo(str);
        if (channelInfo != null) {
            Iterator<ISlowModeInfo> it = channelInfo.getGProSlowModeInfoList().iterator();
            while (it.hasNext()) {
                ISlowModeInfo next = it.next();
                if (next.getSlowModeKey() == channelInfo.getSlowModeKey()) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    private void handleSlowModeFreqLimitInner(int i3, int i16, long j3, String str) {
        QLog.d(TAG, 1, "handleSlowModeFreqLimitInner, channelId:" + str + ", isLimit:" + i3 + ", leftCount:" + i16 + ", limitTS:" + j3);
        if (i3 != 0 && i16 == 0 && j3 > NetConnInfoCenter.getServerTimeMillis() && j3 != getSlowModeLimitTime(str)) {
            updateSlowModeLimitTime(str, j3);
            AppRuntime appRuntime = this.app;
            if (appRuntime instanceof AppInterface) {
                ((g) ((AppInterface) appRuntime).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildPushMsgHandlerName())).J1(str, j3);
            }
        }
    }

    private a parseLimitInfo(String str) {
        List asList = Arrays.asList(str.split(" "));
        if (asList.size() != 3) {
            return null;
        }
        a aVar = new a();
        aVar.f235187a = (String) asList.get(0);
        try {
            aVar.f235188b = Long.parseLong((String) asList.get(1));
            aVar.f235189c = Integer.parseInt((String) asList.get(2));
            return aVar;
        } catch (NumberFormatException e16) {
            QLog.d(TAG, 1, e16, new Object[0]);
            return null;
        }
    }

    private void saveTimeStampSP() {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, a> entry : this.slowModeLimitTimeMap.entrySet()) {
            a value = entry.getValue();
            hashSet.add(entry.getKey() + " " + value.f235188b + " " + value.f235189c);
        }
        bx.z(hashSet);
    }

    @Override // com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService
    public int getSlowModeLimitCycle(String str) {
        a aVar = this.slowModeLimitTimeMap.get(str);
        if (aVar == null) {
            return 0;
        }
        return aVar.f235189c;
    }

    @Override // com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService
    public long getSlowModeLimitTime(String str) {
        a aVar = this.slowModeLimitTimeMap.get(str);
        if (aVar == null) {
            return 0L;
        }
        return aVar.f235188b;
    }

    @Override // com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService
    public void handleSlowModeFreqLimit(common$FreqLimitInfo common_freqlimitinfo, String str) {
        int i3 = common_freqlimitinfo.is_limited.get();
        int i16 = common_freqlimitinfo.left_count.get();
        long j3 = common_freqlimitinfo.limit_timestamp.get() * 1000;
        QLog.d(TAG, 1, "handleSlowModeFreqLimit, channelId:" + str + ", isLimit:" + i3 + ", leftCount:" + i16 + ", limitTS:" + j3);
        if (i3 != 0 && i16 == 0 && j3 > NetConnInfoCenter.getServerTimeMillis() && j3 != getSlowModeLimitTime(str)) {
            updateSlowModeLimitTime(str, j3);
            AppRuntime appRuntime = this.app;
            if (appRuntime instanceof AppInterface) {
                ((g) ((AppInterface) appRuntime).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildPushMsgHandlerName())).J1(str, j3);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService
    public void handleSlowModeFreqLimitFromNT(FreqLimitInfo freqLimitInfo, String str) {
        handleSlowModeFreqLimitInner(freqLimitInfo.getIsLimited(), freqLimitInfo.getLeftCount(), freqLimitInfo.getLimitTimestamp() * 1000, str);
    }

    @Override // com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService
    public boolean isInSlowMode(String str) {
        if (getSlowModeLimitTime(str) > NetConnInfoCenter.getServerTimeMillis()) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
        Iterator<String> it = bx.i().iterator();
        while (it.hasNext()) {
            a parseLimitInfo = parseLimitInfo(it.next());
            if (parseLimitInfo != null && parseLimitInfo.f235188b > NetConnInfoCenter.getServerTimeMillis()) {
                this.slowModeLimitTimeMap.put(parseLimitInfo.f235187a, parseLimitInfo);
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.slowModeLimitTimeMap.clear();
    }

    @Override // com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService
    public void removeSlowModeLimitTime(String str) {
        this.slowModeLimitTimeMap.remove(str);
        saveTimeStampSP();
    }

    @Override // com.tencent.mobileqq.guild.slowmode.api.IGuildSlowModeService
    public void updateSlowModeLimitTime(String str, long j3) {
        ISlowModeInfo slowModeInfo = getSlowModeInfo(str);
        if (slowModeInfo == null) {
            return;
        }
        this.slowModeLimitTimeMap.put(str, new a(str, j3, slowModeInfo.getSlowModeCircle()));
        saveTimeStampSP();
    }
}
