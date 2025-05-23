package com.tencent.mobileqq.guild.message.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.util.api.IAppBadgeService;

/* compiled from: P */
/* loaded from: classes33.dex */
public class j extends com.tencent.mobileqq.guild.message.base.k {
    @Override // com.tencent.mobileqq.guild.message.base.k
    public void a(AppInterface appInterface) {
        if (appInterface.isLogin()) {
            ((IAppBadgeService) appInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }
}
