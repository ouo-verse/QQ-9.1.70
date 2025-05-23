package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalQzoneAlumView extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    View f89324d;

    /* renamed from: e, reason: collision with root package name */
    TextView f89325e;

    public QFSPersonalQzoneAlumView(@NonNull Context context) {
        super(context);
        b(context);
    }

    private void a(View view, int i3, int i16) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_QZONE_ALBUM_ENTRANCE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_WORKS_NUM, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_QZONE_ALBUM_ENTRANCE_TYPE, Integer.valueOf(i16));
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void b(Context context) {
        View.inflate(context, R.layout.g4w, this);
        this.f89324d = findViewById(R.id.f166467zz3);
        this.f89325e = (TextView) findViewById(R.id.zz6);
        if (!TextUtils.isEmpty(QFSPersonalInfo.P)) {
            this.f89325e.setText(QFSPersonalInfo.P);
        }
    }

    public void c(int i3, int i16) {
        View view = this.f89324d;
        if (view != null && view.getVisibility() != 0) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.zz5);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(this);
                a(linearLayout, i3, i16);
            }
            this.f89324d.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!TextUtils.isEmpty(QFSPersonalInfo.Q)) {
            str = QFSPersonalInfo.Q;
        } else {
            str = "mqqapi://qcircle/openqqpublish?target=1&album_id=qzonealbum";
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), str + ContainerUtils.FIELD_DELIMITER + "xsj_qzone_entrance_source" + ContainerUtils.KEY_VALUE_DELIMITER + 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    public QFSPersonalQzoneAlumView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }
}
