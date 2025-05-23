package com.tencent.biz.qqcircle.immersive.personal.part;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleAchievementInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {
    private QCircleAchievementInfo C;

    /* renamed from: d, reason: collision with root package name */
    private View f88816d;

    /* renamed from: e, reason: collision with root package name */
    private View f88817e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f88818f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f88819h;

    /* renamed from: i, reason: collision with root package name */
    private Button f88820i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f88821m;

    private void initView() {
        View view = this.f88817e;
        if (view == null) {
            return;
        }
        this.f88818f = (TextView) view.findViewById(R.id.kbs);
        this.f88819h = (TextView) this.f88817e.findViewById(R.id.f107316a3);
        this.f88820i = (Button) this.f88817e.findViewById(R.id.ai5);
        ImageView imageView = (ImageView) this.f88817e.findViewById(R.id.dum);
        this.f88821m = imageView;
        imageView.setOnClickListener(this);
        this.f88820i.setOnClickListener(this);
    }

    private void x9() {
        QCircleAchievementInfo qCircleAchievementInfo = this.C;
        if (qCircleAchievementInfo != null && !TextUtils.isEmpty(qCircleAchievementInfo.mRocketButtonUrl)) {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.C.mRocketButtonUrl);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(56).setThrActionType(2).setExt6(this.C.mAchievementLevel + "").setExt7(this.C.mRocketButtonDesc));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleAchievementPopupWindowPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "open_achievement_popup_window_message") && (obj instanceof QCircleAchievementInfo)) {
            View view = this.f88816d;
            if (view == null) {
                QLog.e("QCircleAchievementPopupWindowPart", 1, "handleBroadcastMessage()  mRootView == null");
                return;
            }
            if (this.f88817e == null) {
                this.f88817e = ((ViewStub) view.findViewById(R.id.f1203679c)).inflate();
                initView();
            }
            this.f88817e.setVisibility(0);
            QCircleAchievementInfo qCircleAchievementInfo = (QCircleAchievementInfo) obj;
            this.C = qCircleAchievementInfo;
            this.f88818f.setText(qCircleAchievementInfo.mTitle);
            this.f88819h.setText(this.C.mDes);
            this.f88820i.setText(this.C.mRocketButtonDesc);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(56).setThrActionType(1).setExt6(this.C.mAchievementLevel + "").setExt7(this.C.mRocketButtonDesc));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        View view = this.f88817e;
        if (view != null && view.getVisibility() == 0) {
            this.f88817e.setVisibility(8);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.dum) {
            onBackEvent();
        } else if (id5 == R.id.ai5) {
            x9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88816d = view;
    }
}
