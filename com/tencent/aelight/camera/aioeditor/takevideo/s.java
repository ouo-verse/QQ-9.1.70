package com.tencent.aelight.camera.aioeditor.takevideo;

import android.support.v4.util.LongSparseArray;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.r;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class s extends r {
    public s(EditVideoPartManager editVideoPartManager, int i3) {
        super(editVideoPartManager, i3);
    }

    private void O0(View view, String str, Map<String, String> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        Map<String, Object> a16 = kr.a.a();
        if (map != null) {
            a16.putAll(map);
        }
        VideoReport.setElementParams(view, a16);
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    protected void k0(int i3) {
        u0();
        LongSparseArray<r.d> longSparseArray = r.Z;
        longSparseArray.put(1L, new r.d(1024L, R.drawable.iuo, HardCodeUtil.qqStr(R.string.lzl)));
        longSparseArray.put(4L, new r.d(262144L, R.drawable.qui_doodle_mosaic_icon_white, HardCodeUtil.qqStr(R.string.f212315n7)));
        longSparseArray.put(8L, new r.d(1L, R.drawable.iur, HardCodeUtil.qqStr(R.string.f171938m23)));
        longSparseArray.put(64L, new r.d(4L, R.drawable.iup, HardCodeUtil.qqStr(R.string.m28)));
        if ((i3 & 524288) == 524288) {
            longSparseArray.put(1024L, new r.d(524288L, com.tencent.aelight.camera.aioeditor.takevideo.eliminate.a.a(), HardCodeUtil.qqStr(R.string.f212325n8)));
            longSparseArray.put(262144L, new r.d(64L, R.drawable.ius, HardCodeUtil.qqStr(R.string.m1y)));
            longSparseArray.put(524288L, new r.d(8L, R.drawable.iuw, HardCodeUtil.qqStr(R.string.f171936m12)));
        } else {
            longSparseArray.put(1024L, new r.d(64L, R.drawable.ius, HardCodeUtil.qqStr(R.string.m1y)));
            longSparseArray.put(262144L, new r.d(8L, R.drawable.iuw, HardCodeUtil.qqStr(R.string.f171936m12)));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    public int p0() {
        return 200;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    protected int q0() {
        return getResources().getColor(R.color.bf9);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    protected void u0() {
        LongSparseArray<r.d> longSparseArray = r.Z;
        longSparseArray.clear();
        longSparseArray.put(1L, new r.d(1L, R.drawable.iur, HardCodeUtil.qqStr(R.string.f171938m23)));
        longSparseArray.put(4L, new r.d(4L, R.drawable.iup, HardCodeUtil.qqStr(R.string.m28)));
        longSparseArray.put(8L, new r.d(8L, R.drawable.iuw, HardCodeUtil.qqStr(R.string.f171936m12)));
        longSparseArray.put(64L, new r.d(64L, R.drawable.ius, HardCodeUtil.qqStr(R.string.m1y)));
        longSparseArray.put(1024L, new r.d(1024L, R.drawable.iuo, HardCodeUtil.qqStr(R.string.lzl)));
        longSparseArray.put(262144L, new r.d(262144L, R.drawable.qui_doodle_mosaic_icon_white, HardCodeUtil.qqStr(R.string.f212315n7)));
        longSparseArray.put(524288L, new r.d(524288L, com.tencent.aelight.camera.aioeditor.takevideo.eliminate.a.a(), HardCodeUtil.qqStr(R.string.f212325n8)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    public void x0(View view) {
        super.x0(view);
        int id5 = view.getId();
        if (id5 != R.id.s2v) {
            switch (id5) {
                case R.id.rrb /* 2097545410 */:
                    HashMap<String, String> r06 = r0();
                    r06.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, this.F.getText().toString());
                    O0(view, "em_image_edit_finish", r06);
                    w53.b.a("Q.qqstory.record.EditVideoButton", "finish button click report extrasMap: " + r06);
                    return;
                case R.id.rrc /* 2097545411 */:
                case R.id.rrd /* 2097545412 */:
                    N0(view, "em_image_edit_back");
                    return;
                default:
                    return;
            }
        }
        N0(view, "em_image_edit_download");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    public void y0(View view, int i3) {
        super.y0(view, i3);
        if (i3 == 1) {
            N0(view, "em_image_edit_word");
            return;
        }
        if (i3 == 4) {
            N0(view, "em_image_edit_size ");
            return;
        }
        if (i3 == 8) {
            N0(view, "em_image_edit_sticker ");
            return;
        }
        if (i3 == 64) {
            N0(view, "em_image_edit_filter ");
        } else if (i3 == 262144) {
            N0(view, "em_image_edit_mosaic");
        } else {
            if (i3 != 524288) {
                return;
            }
            N0(view, "em_bas_ai_erase ");
        }
    }

    private void N0(View view, String str) {
        O0(view, str, null);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    public void E0(boolean z16, boolean z17, boolean z18) {
        super.E0(z16, z17, false);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    public void F0(boolean z16, boolean z17, boolean z18) {
        super.F0(z16, z17, false);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    protected void M0(View view, View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
