package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.adapter.ak;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ac extends b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private QFSSettingSwitchView f82831d;

    private void A9(View view) {
        QFSSettingSwitchView qFSSettingSwitchView = (QFSSettingSwitchView) view.findViewById(R.id.f30660oy);
        this.f82831d = qFSSettingSwitchView;
        qFSSettingSwitchView.setVisibility(0);
        this.f82831d.setListener(new QFSSettingSwitchView.b() { // from class: com.tencent.biz.qqcircle.bizparts.ab
            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ac.B9(compoundButton, z16);
            }
        });
        C9(this.f82831d, QCircleDaTongConstant.ElementId.EM_XSJ_PORTRAIT_SET_BUTTON, QCircleDaTongConstant.ElementParamKey.XSJ_PRIVACY_SETTING_BUTTON_STATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B9(CompoundButton compoundButton, boolean z16) {
        if (!compoundButton.isPressed()) {
            return;
        }
        uq3.k.a().j("mmkv_key_open_face_detect", z16);
    }

    private void C9(QFSSettingSwitchView qFSSettingSwitchView, String str, String str2) {
        VideoReport.setElementId(qFSSettingSwitchView.D0(), str);
        VideoReport.setEventDynamicParams(qFSSettingSwitchView.D0(), new ak.b(qFSSettingSwitchView, str2));
        VideoReport.setElementClickPolicy(qFSSettingSwitchView.D0(), ClickPolicy.REPORT_ALL);
    }

    private void D9() {
        QFSSettingSwitchView qFSSettingSwitchView = this.f82831d;
        if (qFSSettingSwitchView != null) {
            qFSSettingSwitchView.setCheckedOnly(uq3.k.a().c("mmkv_key_open_face_detect", false));
        }
    }

    private void z9() {
        if (!getPartManager().onBackEvent() && getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAlbumSettingContentPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            z9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.y_2);
        imageView.setOnClickListener(this);
        if (getHostFragment() instanceof QCircleBaseFragment) {
            ((QCircleBaseFragment) getHostFragment()).setExcludeInteractiveView(imageView);
        }
        A9(view);
        D9();
    }
}
