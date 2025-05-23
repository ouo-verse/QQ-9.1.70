package com.qzone.widget;

import android.view.View;
import android.widget.FrameLayout;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.luan.ioc.annotation.Singleton;

/* compiled from: P */
@Singleton
@Named("PullToRefreshListViewCoverImp")
/* loaded from: classes37.dex */
public class j implements d5.e {
    @Inject
    public j() {
    }

    @Override // d5.e
    public int a() {
        return CoverEnv.getCoverPaddingTop();
    }

    @Override // d5.e
    public FrameLayout getAttachView() {
        return null;
    }

    @Override // d5.e
    public void b(View view) {
    }

    @Override // d5.e
    public void onDestroy() {
    }
}
