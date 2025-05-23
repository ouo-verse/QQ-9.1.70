package com.tencent.mobileqq.wink.editor.sticker.text;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f extends com.tencent.mobileqq.wink.view.ab {
    private final int T;
    private final int U;

    public f(@NonNull Context context, WinkEditorViewModel.EditMode editMode) {
        super(context, editMode, 2);
        this.T = com.tencent.mobileqq.util.x.c(context, 14.0f);
        this.U = com.tencent.mobileqq.util.x.c(context, 12.0f);
    }

    private void r0(View view, String str, Map<String, Object> map, String str2) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementReuseIdentifier(view, str2);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(map);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void s0(View view, MetaMaterial metaMaterial, int i3) {
        HashMap hashMap = new HashMap();
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("CATEGORY_TEXT_PATTERN")) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_ART_NAME, metaMaterial.f30533id);
            r0(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CHAR_ART_ITEM, hashMap, String.valueOf(metaMaterial.hashCode()));
        } else if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("CATEGORY_TEXT_DECOR")) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_PATTERN_NAME, metaMaterial.f30533id);
            r0(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CHAR_PATTERN_ITEM, hashMap, String.valueOf(metaMaterial.hashCode()));
        }
    }

    @Override // com.tencent.mobileqq.wink.view.ab, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 < 4) {
            return 1;
        }
        if (((int) Math.ceil(((i3 + 1) * 1.0f) / 4.0f)) == ((int) Math.ceil((getItemCount() * 1.0f) / 4.0f))) {
            return 3;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(ab.a aVar, int i3, @NonNull MetaMaterial metaMaterial) {
        super.n0(aVar, i3, metaMaterial);
        s0(aVar.itemView, metaMaterial, i3);
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    protected ab.a o0(ViewGroup viewGroup, int i3) {
        ab.a aVar = new ab.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hff, viewGroup, false));
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) aVar.itemView.getLayoutParams();
        int i16 = i3 & 15;
        if (i16 == 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.T;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.U;
        } else if (i16 == 3) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 12;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.U;
        }
        return aVar;
    }
}
