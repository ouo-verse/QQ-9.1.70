package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j extends i {
    private boolean Q;

    public j(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
    }

    private void t0(View view) {
        if (this.Q) {
            return;
        }
        this.Q = false;
        VideoReport.setPageId(view, "pg_image_size_crop");
        HashMap hashMap = new HashMap();
        hashMap.put("type_aio_pg", Integer.valueOf(kr.a.c(this.mParent.C)));
        hashMap.put("image_edit_import_from", Integer.valueOf(kr.a.d(this.mParent.C)));
        VideoReport.setPageParams(view, kr.a.b(hashMap));
    }

    private void u0(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        Map<String, Object> a16 = kr.a.a();
        VideoReport.setElementParams(view, a16);
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.i, com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView.a
    public void c(int i3) {
        super.c(i3);
        if (i3 == 2) {
            u0(this.f68707e, "em_image_size_crop_size");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.i, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        switch (view.getId()) {
            case R.id.rqk /* 2097545382 */:
                u0(view, "em_image_size_crop_cancel");
                break;
            case R.id.rr8 /* 2097545406 */:
                u0(view, "em_image_size_crop_finish");
                break;
            case R.id.rrk /* 2097545419 */:
                u0(view, "em_image_size_crop_reset");
                break;
            case R.id.rrm /* 2097545421 */:
                u0(view, "em_image_size_crop_rotate");
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.i
    public void s0() {
        t0(this.f68706d);
        super.s0();
    }
}
