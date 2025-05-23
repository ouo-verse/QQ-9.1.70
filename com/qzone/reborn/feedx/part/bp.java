package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.reborn.widget.ZPlanRefreshHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bp extends bw {
    public static boolean K9() {
        return !((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(LoginData.getInstance().getUin()) || ZPlanRefreshHeaderView.y();
    }

    @Override // com.qzone.reborn.feedx.part.bw, com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("ExoticPositionBag".equals(event.source.getName())) {
            if (K9()) {
                com.qzone.widget.e.b(event);
                return;
            }
            return;
        }
        gf.o oVar = (gf.o) getIocInterface(gf.o.class);
        if (!(oVar != null && oVar.handleEventUIThread(event))) {
            super.onEventUIThread(event);
        } else if (QLog.isDebugVersion() || QLog.isColorLevel()) {
            QLog.d("QZoneFrameFeedxEventHandlePart", 1, "[onEventUIThread] intercept handler event.");
        }
    }

    @Override // com.qzone.reborn.feedx.part.bw, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        EventCenter.getInstance().addUIObserver(this, "ExoticPositionBag", 54610, 54611);
    }

    @Override // com.qzone.reborn.feedx.part.bw, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
    }
}
