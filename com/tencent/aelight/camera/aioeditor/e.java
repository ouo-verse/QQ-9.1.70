package com.tencent.aelight.camera.aioeditor;

import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.r;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends r {
    public e(EditVideoPartManager editVideoPartManager, int i3) {
        super(editVideoPartManager, i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        Long l3 = this.P.get(view.getId());
        if (l3 != null) {
            int longValue = (int) l3.longValue();
            if (longValue == 1) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
            } else if (longValue == 2) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
            } else if (longValue == 8) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        N0();
    }

    private void N0() {
        findViewSure(R.id.s2v).setVisibility(8);
        QUIButton qUIButton = (QUIButton) findViewSure(R.id.rrb);
        qUIButton.setPadding(0, 0, 0, 0);
        qUIButton.setText(HardCodeUtil.qqStr(R.string.slw));
    }
}
