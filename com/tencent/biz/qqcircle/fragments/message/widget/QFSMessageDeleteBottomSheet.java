package com.tencent.biz.qqcircle.fragments.message.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageDeleteBottomSheet extends QFSBaseBottomSheetDialog implements View.OnClickListener {
    private final a E;
    private final View F;
    private final QFSMessageItemInfo G;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void onClick();
    }

    public QFSMessageDeleteBottomSheet(@NonNull Context context, @NonNull View view, @Nullable a aVar, QFSMessageItemInfo qFSMessageItemInfo) {
        super(context);
        this.F = view;
        this.E = aVar;
        this.G = qFSMessageItemInfo;
        initView();
    }

    private void P(View view, int i3) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        R(view, buildElementParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_DELETE_DOUBLE_CHECK_BUTTON, Integer.valueOf(i3));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, buildElementParams);
    }

    private void Q(View view) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        R(view, buildElementParams);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, buildElementParams);
    }

    private void R(View view, Map<String, Object> map) {
        FeedCloudMeta$StNotice stNotice;
        PBUInt32Field pBUInt32Field;
        PBStringField pBStringField;
        VideoReport.setLogicParent(view, this.F);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_DOUBLE_CHECK_PANEL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        QFSMessageItemInfo qFSMessageItemInfo = this.G;
        if (qFSMessageItemInfo != null) {
            if (qFSMessageItemInfo.getStNotice() == null) {
                stNotice = null;
            } else {
                stNotice = this.G.getStNotice();
            }
            if (stNotice != null && (pBStringField = stNotice.feedId) != null) {
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, pBStringField.get());
            }
            if (stNotice != null && (pBUInt32Field = stNotice.noticeType) != null) {
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_TYPE, Integer.valueOf(pBUInt32Field.get()));
            }
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gi7, (ViewGroup) null);
        inflate.findViewById(R.id.f167041k72).setOnClickListener(this);
        inflate.findViewById(R.id.f167033k60).setOnClickListener(this);
        setContentView(inflate);
        Q(inflate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSMessageDeleteBottomSheet")) {
            int id5 = view.getId();
            if (id5 == R.id.f167041k72) {
                dismiss();
                a aVar = this.E;
                if (aVar != null) {
                    aVar.onClick();
                }
                P(view, 1);
            } else if (id5 == R.id.f167033k60) {
                dismiss();
                P(view, 2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
