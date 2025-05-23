package com.tencent.mobileqq.wink.editor.sticker.text;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g extends com.tencent.mobileqq.wink.view.ab {
    public g(@NonNull Context context, WinkEditorViewModel.EditMode editMode) {
        super(context, editMode);
    }

    private void r0(View view, String str, Map<String, Object> map, String str2) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementReuseIdentifier(view, str2);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(map);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(ab.a aVar, int i3, @NonNull MetaMaterial metaMaterial) {
        super.n0(aVar, i3, metaMaterial);
        aVar.f326923e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (aVar instanceof d) {
            if (!TextUtils.isEmpty(com.tencent.mobileqq.wink.editor.c.K0(metaMaterial))) {
                ((d) aVar).H.setText(com.tencent.mobileqq.wink.editor.c.K0(metaMaterial));
            } else {
                ((d) aVar).H.setText("");
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME, metaMaterial.f30533id);
        r0(aVar.itemView, WinkDaTongReportConstant.ElementId.EM_XSJ_CHAR_FORM_ITEM, hashMap, String.valueOf(metaMaterial.hashCode()));
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    protected ab.a o0(ViewGroup viewGroup, int i3) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hfg, viewGroup, false));
    }
}
