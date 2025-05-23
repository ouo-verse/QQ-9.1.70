package com.qzone.reborn.feedx.part.detail;

import android.os.Handler;
import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.reborn.feedx.viewmodel.h;

/* compiled from: P */
/* loaded from: classes37.dex */
public class j extends com.qzone.reborn.feedx.part.p implements h.b {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.h f55178d;

    @Override // com.qzone.reborn.feedx.part.p
    protected int D9() {
        return 2;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailCommentLikePart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public Handler getMainHandler() {
        if (this.f55178d == null) {
            this.f55178d = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        }
        return this.f55178d.g2();
    }

    @Override // com.qzone.reborn.feedx.part.p, com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55178d = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h.b
    public void K6(QZoneResult qZoneResult) {
    }
}
