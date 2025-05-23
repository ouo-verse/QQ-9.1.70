package com.qzone.reborn.feedx.part.detail;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class l extends com.qzone.reborn.feedx.part.g implements IObserver.main {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.h f55179d;

    private void D9(Event event) {
        if (event.what != 23) {
            return;
        }
        RFWLog.d(getTAG(), RFWLog.USR, "do feed refresh event : " + event.what);
        com.qzone.reborn.feedx.viewmodel.h hVar = this.f55179d;
        if (hVar != null) {
            hVar.K2();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFriendFeedxEventHandlePart";
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Personalize".equals(event.source.getName())) {
            D9(event);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f55179d = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        EventCenter.getInstance().addUIObserver(this, "Personalize", 23);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
    }
}
