package com.tencent.mobileqq.wink.publish.part;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class bo extends j {

    /* renamed from: h, reason: collision with root package name */
    public static final String f325863h = "com.tencent.mobileqq.wink.publish.part.bo";

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.wink.publish.viewmodel.u f325864d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f325865e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f325866f;

    private void D9() {
        Object obj;
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(WinkDatongCurrentParams.getMap());
        buildElementParams.put(DTParamKey.REPORT_KEY_APPKEY, WinkDTParamBuilder.APP_KEY);
        k93.b value = this.f325864d.f326072i.getValue();
        if (value != null) {
            obj = value.f411915b;
        } else {
            obj = "";
        }
        buildElementParams.put("xsj_task_id", obj);
        VideoReport.setElementId(this.f325865e, WinkDaTongReportConstant.ElementId.EM_XSJ_TASKBAR);
        VideoReport.setElementParams(this.f325865e, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E9(k93.b bVar) {
        String str;
        this.f325865e.setVisibility(8);
        if (bVar != null && (str = bVar.f411914a) != null && !str.isEmpty()) {
            this.f325865e.setVisibility(0);
            this.f325866f.setText(bVar.f411914a);
        }
    }

    private void initViewModel() {
        com.tencent.mobileqq.wink.publish.viewmodel.u uVar = (com.tencent.mobileqq.wink.publish.viewmodel.u) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.u.class);
        this.f325864d = uVar;
        uVar.L1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.bn
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bo.this.E9((k93.b) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return f325863h;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return f325863h;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f58422pz);
        if (viewStub == null) {
            QLog.e(f325863h, 1, "viewstub is null");
            return;
        }
        LinearLayout linearLayout = (LinearLayout) viewStub.inflate().findViewById(R.id.f29210l1);
        this.f325865e = linearLayout;
        if (linearLayout == null) {
            QLog.e(f325863h, 1, "container inflate failed");
            return;
        }
        this.f325866f = (TextView) linearLayout.findViewById(R.id.f10589679);
        initViewModel();
        this.f325864d.M1(getActivity().getIntent());
        D9();
    }
}
