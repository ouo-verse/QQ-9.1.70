package com.qzone.common.activities.base;

import com.qzone.app.ImageEnvImpl;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;

/* compiled from: P */
@Named("BaseFeedFragmentImageImp")
/* loaded from: classes39.dex */
public class q implements d5.s {
    @Inject
    public q() {
    }

    @Override // d5.s
    public void a() {
        ImageEnvImpl.setListViewScrollIdle(false);
        if (com.qzone.util.x.b() > 2) {
            ImageEnvImpl.setCurrentLoadingImgStatus(true);
        } else {
            ImageEnvImpl.setCurrentLoadingImgStatus(false);
        }
    }

    @Override // d5.s
    public void b() {
        ImageEnvImpl.setListViewScrollIdle(true);
        ImageEnvImpl.setCurrentLoadingImgStatus(true);
    }

    @Override // d5.s
    public void c(boolean z16) {
        ImageEnvImpl.setListViewScrollIdle(false);
        if (com.qzone.util.x.b() > 2) {
            ImageEnvImpl.setCurrentLoadingImgStatus(z16);
        } else {
            ImageEnvImpl.setCurrentLoadingImgStatus(false);
        }
    }
}
