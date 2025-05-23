package com.tencent.mobileqq.tvideo.parts;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private View f304551d;

    /* renamed from: e, reason: collision with root package name */
    private View f304552e;

    private void A9() {
        final ImageView imageView = (ImageView) this.f304552e.findViewById(R.id.trz);
        imageView.setVisibility(0);
        jy2.f.f411169a.j(imageView, "https://ugd.gtimg.com/vg/1686744503567_%25E7%259F%25A9%25E5%25BD%25A2.png");
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.parts.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.B9(imageView, view);
            }
        });
        C9(imageView, WadlProxyConsts.CHANNEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B9(ImageView imageView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ox2.d.c().k(this.f304551d.findViewById(R.id.f45651sg));
        VideoReport.reportEvent("clck", imageView, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void C9(View view, String str) {
        Map<String, Object> g16 = gy2.c.g();
        g16.put("style", "vertical");
        VideoReport.setElementParams(view, g16);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, str);
    }

    private void z9(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        if (qCircleConfigChangeEvent == null) {
            return;
        }
        int i3 = qCircleConfigChangeEvent.configuration.orientation;
        QLog.d("QFSLayerTVideoChannelPart", 4, "handleConfigurationChange orientation : " + i3);
        if (i3 == 2) {
            ox2.d.c().e();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerTVideoChannelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration == null) {
            return;
        }
        QLog.d("QFSLayerTVideoChannelPart", 1, "onConfigurationChanged newConfig  : " + configuration.orientation);
        if (configuration.orientation == 2) {
            px2.b.g();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f304551d = view;
        this.f304552e = view.findViewById(R.id.f45661sh);
        A9();
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
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            z9((QCircleConfigChangeEvent) simpleBaseEvent);
        }
    }
}
