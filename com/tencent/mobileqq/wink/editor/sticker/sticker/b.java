package com.tencent.mobileqq.wink.editor.sticker.sticker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
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
public class b extends ab {
    private final int T;
    private final int U;
    private final int V;
    private int W;

    public b(@NonNull Context context, WinkEditorViewModel.EditMode editMode) {
        super(context, editMode, 2);
        this.T = x.c(context, 14.0f);
        this.U = x.c(context, 24.0f);
        this.V = x.c(context, 12.0f);
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

    @Override // com.tencent.mobileqq.wink.view.ab, android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        int i16;
        if (i3 < 4) {
            i16 = 1;
        } else {
            if (((int) Math.ceil(((i3 + 1) * 1.0f) / 4.0f)) == ((int) Math.ceil((getItemCount() * 1.0f) / 4.0f))) {
                i16 = 3;
            } else {
                i16 = 2;
            }
        }
        if (i3 % 4 == 0) {
            return i16 | 16;
        }
        if ((i3 + 1) % 4 == 0) {
            return i16 | 48;
        }
        return i16 | 32;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(ab.a aVar, int i3, @NonNull MetaMaterial metaMaterial) {
        super.n0(aVar, i3, metaMaterial);
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, metaMaterial.f30533id);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_CATEGORY, com.tencent.mobileqq.wink.editor.c.o(metaMaterial));
        r0(aVar.itemView, WinkDaTongReportConstant.ElementId.EM_XSJ_PASTE_ITEM, hashMap, String.valueOf(metaMaterial.hashCode()));
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    protected ab.a o0(ViewGroup viewGroup, int i3) {
        ab.a aVar = new ab.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hfa, viewGroup, false));
        if (this.W == 0) {
            this.W = (viewGroup.getWidth() - (this.U * 2)) / 4;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) aVar.itemView.getLayoutParams();
        int i16 = this.W;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i16;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i16;
        int i17 = i3 & 15;
        if (i17 == 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.T;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.V;
        } else if (i17 == 3) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.V;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.V;
        }
        aVar.itemView.setScaleX(0.8f);
        aVar.itemView.setScaleY(0.8f);
        return aVar;
    }
}
