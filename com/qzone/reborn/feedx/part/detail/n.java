package com.qzone.reborn.feedx.part.detail;

import android.os.Handler;
import android.view.View;
import androidx.lifecycle.Observer;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.part.QZoneFeedxForwardOperationPart;
import com.qzone.reborn.feedx.viewmodel.QZoneBlogDetailViewModel;
import com.qzone.reborn.feedx.viewmodel.h;
import com.tencent.richframework.data.base.UIStateData;

/* compiled from: P */
/* loaded from: classes37.dex */
public class n extends QZoneFeedxForwardOperationPart implements h.b {

    /* renamed from: h, reason: collision with root package name */
    private final boolean f55181h;

    /* renamed from: i, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.h f55182i;

    public n(boolean z16) {
        this.f55181h = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(UIStateData uIStateData) {
        if (uIStateData.getData() != null) {
            M9((BusinessFeedData) uIStateData.getData());
        }
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFeedxForwardOperationPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailForwardOperationPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public Handler getMainHandler() {
        if (this.f55182i == null) {
            this.f55182i = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        }
        return this.f55182i.g2();
    }

    @Override // com.qzone.reborn.feedx.part.QZoneFeedxForwardOperationPart, com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (this.f55181h) {
            this.f55182i = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(QZoneBlogDetailViewModel.class);
        } else {
            this.f55182i = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        }
        this.f55182i.P1(this);
        this.f55182i.f55901m.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.detail.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.O9((UIStateData) obj);
            }
        });
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h.b
    public void K6(QZoneResult qZoneResult) {
    }
}
