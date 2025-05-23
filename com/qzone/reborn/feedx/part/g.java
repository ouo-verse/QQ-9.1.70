package com.qzone.reborn.feedx.part;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends com.qzone.reborn.base.k implements com.qzone.reborn.feedx.viewmodel.b {
    public tc.b C9() {
        if (getPartHost() instanceof com.qzone.reborn.feedx.viewmodel.a) {
            return ((com.qzone.reborn.feedx.viewmodel.a) getPartHost()).getFeedxViewModel();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Handler getMainHandler() {
        if (C9() != null) {
            return C9().getMHandler();
        }
        return new Handler(Looper.getMainLooper());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    public void i6() {
    }

    public void p4() {
    }

    @Override // com.qzone.reborn.feedx.viewmodel.b
    public void f7(QZoneResult qZoneResult) {
    }

    public void i5(QZoneResult qZoneResult) {
    }

    public void onHandleMessage(Message message) {
    }

    public void v0(QZoneResult qZoneResult) {
    }

    @Override // com.qzone.reborn.feedx.viewmodel.b
    public void j7(List<? extends BusinessFeedData> list, int i3) {
    }
}
