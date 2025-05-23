package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildAdapterService extends IRuntimeService {
    List<IGProChannelInfo> getChannelList(String str, boolean z16);

    @Deprecated
    HashMap<String, List<IGProChannelInfo>> getChannelMap(String str, boolean z16);

    IGProGlobalBanner getGuildBanner(String str, int i3);

    void setVisitorGuildCardInfo(String str, IGProGuildInfo iGProGuildInfo, List<cy> list);
}
