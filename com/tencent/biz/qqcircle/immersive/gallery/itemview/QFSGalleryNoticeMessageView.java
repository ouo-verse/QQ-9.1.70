package com.tencent.biz.qqcircle.immersive.gallery.itemview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo;
import com.tencent.biz.qqcircle.immersive.gallery.event.QFSGalleryNoticeMessageClickEvent;
import com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryNoticeMessageView;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGalleryNoticeMessageView extends QCircleBaseWidgetView<QCircleMessageNoticeInfo> implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private QCircleMessageNoticeInfo f86435d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f86436e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarView f86437f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f86438h;

    /* renamed from: i, reason: collision with root package name */
    private Size f86439i;

    public QFSGalleryNoticeMessageView(@NonNull Context context) {
        super(context);
        o0(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void m0() {
        QCircleMessageNoticeInfo qCircleMessageNoticeInfo = this.f86435d;
        if (qCircleMessageNoticeInfo == null) {
            QLog.d("QFSGalleryNoticeMessageView", 1, "notice info is null");
        } else if (TextUtils.isEmpty(qCircleMessageNoticeInfo.getJumpLink())) {
            QLog.d("QFSGalleryNoticeMessageView", 1, "notice info jump link is null");
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new QFSGalleryNoticeMessageClickEvent());
            QCircleHostLauncher.doJumpAction(getContext(), this.f86435d.getJumpLink());
        }
    }

    private void n0(QFSGalleryNoticeMessageClickEvent qFSGalleryNoticeMessageClickEvent) {
        if (qFSGalleryNoticeMessageClickEvent == null) {
            return;
        }
        s0(false);
    }

    private void o0(View view) {
        if (view == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.f43161lq);
        this.f86436e = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: s40.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QFSGalleryNoticeMessageView.this.p0(view2);
            }
        });
        this.f86437f = (QCircleAvatarView) view.findViewById(R.id.f43151lp);
        this.f86438h = (TextView) view.findViewById(R.id.f43171lr);
        this.f86439i = n.a(view.getContext(), R.dimen.f158714n4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        m0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void q0() {
        VideoReport.setElementId(this.f86436e, QCircleDaTongConstant.ElementId.EM_XSJ_MSG_BANNER);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QCircleMessageNoticeInfo qCircleMessageNoticeInfo = this.f86435d;
        if (qCircleMessageNoticeInfo != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_BUBBLE, qCircleMessageNoticeInfo.getExtInfo());
        }
        VideoReport.setElementParams(this.f86436e, buildElementParams);
        VideoReport.setElementExposePolicy(this.f86436e, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f86436e, ClickPolicy.REPORT_ALL);
    }

    private void r0(QCircleMessageNoticeInfo qCircleMessageNoticeInfo) {
        List<String> allSenderList;
        if (qCircleMessageNoticeInfo != null && this.f86437f != null && (allSenderList = qCircleMessageNoticeInfo.getAllSenderList()) != null && !allSenderList.isEmpty()) {
            this.f86437f.setAvatarByUin(allSenderList.get(0), this.f86439i);
        }
    }

    private void s0(boolean z16) {
        int i3;
        LinearLayout linearLayout = this.f86436e;
        if (linearLayout == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
    }

    private void u0(QCircleMessageNoticeInfo qCircleMessageNoticeInfo) {
        if (qCircleMessageNoticeInfo == null || this.f86438h == null || TextUtils.isEmpty(qCircleMessageNoticeInfo.getDisplayText())) {
            return;
        }
        this.f86438h.setText(qCircleMessageNoticeInfo.getDisplayText());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSGalleryNoticeMessageClickEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gcv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSGalleryNoticeMessageView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(QCircleMessageNoticeInfo qCircleMessageNoticeInfo, int i3) {
        if (qCircleMessageNoticeInfo != null && !TextUtils.isEmpty(qCircleMessageNoticeInfo.getDisplayText())) {
            s0(true);
            this.f86435d = qCircleMessageNoticeInfo;
            r0(qCircleMessageNoticeInfo);
            u0(qCircleMessageNoticeInfo);
            q0();
            return;
        }
        s0(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSGalleryNoticeMessageClickEvent) {
            n0((QFSGalleryNoticeMessageClickEvent) simpleBaseEvent);
        }
    }
}
