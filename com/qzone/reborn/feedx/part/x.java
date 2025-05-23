package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Observer;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.viewmodel.h;
import com.tencent.richframework.data.base.UIStateData;

/* compiled from: P */
/* loaded from: classes37.dex */
public class x extends QZoneFeedxInteractOperateDialogPart implements h.b {
    private com.qzone.reborn.feedx.viewmodel.h J;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hb(UIStateData uIStateData) {
        if (uIStateData.getData() != null) {
            cb((BusinessFeedData) uIStateData.getData());
        }
    }

    @Override // com.qzone.reborn.feedx.viewmodel.h.b
    public void K6(QZoneResult qZoneResult) {
        if (qZoneResult.what == 999909) {
            da(qZoneResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.part.QZoneFeedxInteractOperateDialogPart
    public void da(QZoneResult qZoneResult) {
        super.da(qZoneResult);
        if (!qZoneResult.getSucceed() || getActivity() == null) {
            return;
        }
        getActivity().finish();
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public Handler getMainHandler() {
        return this.J.g2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if ("DELETE_FEED".equals(str)) {
            qa(this.J.X1());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        com.qzone.reborn.feedx.viewmodel.h hVar = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        this.J = hVar;
        hVar.P1(this);
        this.J.f55901m.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                x.this.hb((UIStateData) obj);
            }
        });
    }
}
