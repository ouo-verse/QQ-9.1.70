package com.tencent.qqnt.emotion.api;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes24.dex */
public interface ICommercialDrainageManagerService extends IRuntimeService {
    int getShowCount(long j3, String str, String str2, int i3);

    boolean isIPSite(Emoticon emoticon);

    boolean isIPSite(EmoticonPackage emoticonPackage);

    boolean isRichIPSite(VipIPSiteInfo vipIPSiteInfo);

    boolean shouldHiden(EmoticonPackage emoticonPackage);

    void updateDisPlayInteval(long j3);
}
