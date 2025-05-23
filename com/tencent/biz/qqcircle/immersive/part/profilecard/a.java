package com.tencent.biz.qqcircle.immersive.part.profilecard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.bizparts.b;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QFSSetCoverFeedEvent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends b implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    protected Button f88240d;

    /* renamed from: e, reason: collision with root package name */
    private View f88241e;

    /* renamed from: f, reason: collision with root package name */
    private final String f88242f;

    public a(String str) {
        this.f88242f = str;
    }

    void A9() {
        this.f88240d.setText(getContext().getResources().getString(R.string.f193794a6));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSetCoverFeedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSChangeProfileCardCoverPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        View findViewById = this.f88241e.findViewById(R.id.u28);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            View findViewById2 = this.f88241e.findViewById(R.id.jha);
            if (findViewById2 != null) {
                findViewById2.callOnClick();
            }
        } else if (view.getId() == R.id.f3482107) {
            z9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88241e = view;
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f3483108);
        if (viewStub == null) {
            return;
        }
        this.f88240d = (Button) viewStub.inflate().findViewById(R.id.f3482107);
        if (!QCirclePluginUtil.isOwner(this.f88242f)) {
            A9();
        }
        this.f88240d.setOnClickListener(this);
        x9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSSetCoverFeedEvent) && getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    public void x9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        VideoReport.setElementId(this.f88240d, QCircleDaTongConstant.ElementId.EM_XSJ_SETTING_BUTTON);
        VideoReport.setElementParams(this.f88240d, buildElementParams);
    }

    public void z9() {
        QCircleSchemeLauncher.d(getContext(), "mqqapi://qcircle/openpersonalcoverfeedpage?source_type=1");
    }
}
