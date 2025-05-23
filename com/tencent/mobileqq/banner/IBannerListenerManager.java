package com.tencent.mobileqq.banner;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes11.dex */
public interface IBannerListenerManager extends IRuntimeService {
    void addBannerListener(c cVar);

    void notifyBannerDismiss(int i3);

    void notifyBannerShow(int i3);

    void removeBannerListener(c cVar);
}
