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
import com.tencent.mobileqq.wink.view.af;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class h extends com.tencent.mobileqq.wink.view.af {
    public h(@NonNull Context context, WinkEditorViewModel.EditMode editMode) {
        super(context, editMode);
    }

    private void q0(View view, String str, Map<String, Object> map, String str2) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementReuseIdentifier(view, str2);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(map);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.af
    public void n0(af.a aVar, int i3, @NonNull MetaMaterial metaMaterial) {
        super.n0(aVar, i3, metaMaterial);
        aVar.f326936e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (aVar instanceof e) {
            if (!TextUtils.isEmpty(com.tencent.mobileqq.wink.editor.c.K0(metaMaterial))) {
                ((e) aVar).F.setText(com.tencent.mobileqq.wink.editor.c.K0(metaMaterial));
            } else {
                ((e) aVar).F.setText("");
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHAR_FORM_NAME, metaMaterial.f30533id);
        q0(aVar.itemView, WinkDaTongReportConstant.ElementId.EM_XSJ_CHAR_FORM_ITEM, hashMap, String.valueOf(metaMaterial.hashCode()));
    }

    @Override // com.tencent.mobileqq.wink.view.af
    protected af.a o0(ViewGroup viewGroup, int i3) {
        return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hfh, viewGroup, false));
    }
}
