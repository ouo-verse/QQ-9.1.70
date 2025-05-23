package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class n extends EditPicSave {
    public n(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
    }

    private void G0(View view) {
        VideoReport.setPageId(view, "pg_image_download_window");
        HashMap hashMap = new HashMap();
        hashMap.put("type_aio_pg", Integer.valueOf(kr.a.c(this.mParent.C)));
        VideoReport.setPageParams(view, kr.a.b(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave
    public Dialog t0() {
        Dialog t06 = super.t0();
        G0(t06.getWindow().getDecorView());
        return t06;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave
    public void x0() {
        super.x0();
        Map<String, Object> a16 = kr.a.a();
        a16.put("dt_pgid", "pg_image_download_window");
        a16.put("dt_eid", "em_image_download_window_cancel");
        HashMap hashMap = new HashMap();
        hashMap.put("type_aio_pg", Integer.valueOf(kr.a.c(this.mParent.C)));
        a16.put("cur_pg", hashMap);
        VideoReport.reportEvent("dt_imp", null, a16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave
    public void y0(String str) {
        super.y0(str);
        Map<String, Object> a16 = kr.a.a();
        a16.put("dt_pgid", "pg_image_edit");
        a16.put("dt_eid", "em_image_edit_download_fail");
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        a16.put("image_edit_download_fail_reason", str);
        HashMap hashMap = new HashMap();
        hashMap.put("type_aio_pg", Integer.valueOf(kr.a.c(this.mParent.C)));
        hashMap.put("image_edit_import_from", Integer.valueOf(kr.a.d(this.mParent.C)));
        hashMap.put("image_edit_import_size", kr.a.e(this.mParent.C));
        a16.put("cur_pg", hashMap);
        VideoReport.reportEvent("dt_imp", null, a16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave
    protected void z0() {
        Map<String, Object> a16 = kr.a.a();
        a16.put("dt_pgid", "pg_image_edit");
        a16.put("dt_eid", "em_image_edit_download_success");
        HashMap hashMap = new HashMap();
        hashMap.put("type_aio_pg", Integer.valueOf(kr.a.c(this.mParent.C)));
        hashMap.put("image_edit_import_from", Integer.valueOf(kr.a.d(this.mParent.C)));
        hashMap.put("image_edit_import_size", kr.a.e(this.mParent.C));
        a16.put("cur_pg", hashMap);
        VideoReport.reportEvent("dt_imp", null, a16);
    }
}
