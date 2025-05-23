package com.tencent.mobileqq.tvideo.parts;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.base.TVideoLayerMultiTabPageFragment;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFeedsItemSelectedEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEntranceVisibleEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEvent;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tvideo.Video;
import zt2.l;

/* compiled from: P */
/* loaded from: classes19.dex */
public class z extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private View f304592d;

    /* renamed from: e, reason: collision with root package name */
    private View f304593e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleRoundImageView f304594f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f304595h;

    /* renamed from: i, reason: collision with root package name */
    private Video f304596i;

    /* renamed from: m, reason: collision with root package name */
    private l.a f304597m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            QQToast.makeText(z.this.getContext(), "\u6e05\u9664\u9690\u79c1\u62cd\u8138\u56fe\u8bb0\u5f55", 0).show();
            qx2.a.c().p(false);
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    private void E9(QFSTVideoFloatingWindowEntranceVisibleEvent qFSTVideoFloatingWindowEntranceVisibleEvent) {
        R9(qFSTVideoFloatingWindowEntranceVisibleEvent.getIsShow());
    }

    private void F9(Video video) {
        if (Q9()) {
            return;
        }
        this.f304596i = video;
        if (this.f304595h != null) {
            Map<String, Object> i3 = gy2.c.i(video);
            VideoReport.setElementId(this.f304595h, "float_screen");
            VideoReport.setElementParams(this.f304595h, i3);
            VideoReport.setElementClickPolicy(this.f304595h, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(this.f304595h, ExposurePolicy.REPORT_NONE);
        }
    }

    private void G9(View view) {
        QCircleRoundImageView qCircleRoundImageView = (QCircleRoundImageView) view.findViewById(R.id.f164551a35);
        this.f304594f = qCircleRoundImageView;
        l.a aVar = new l.a(qCircleRoundImageView);
        this.f304597m = aVar;
        zt2.e.f453199a.w(aVar);
        this.f304594f.setVisibility(0);
        jy2.f.f411169a.e(this.f304594f, 10, 10, 6, 6);
        this.f304594f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.parts.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                z.this.K9(view2);
            }
        });
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.w
            @Override // java.lang.Runnable
            public final void run() {
                z.this.L9();
            }
        });
        S9(this.f304594f, "myinfo");
    }

    private void H9(View view) {
        View findViewById = view.findViewById(R.id.f45661sh);
        this.f304593e = findViewById;
        findViewById.findViewById(R.id.tzk).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.parts.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                z.this.M9(view2);
            }
        });
    }

    private void I9(View view) {
        this.f304595h = (ImageView) view.findViewById(R.id.vb8);
        if (AppSetting.t(getContext())) {
            this.f304595h.setVisibility(8);
        }
        jy2.f.f411169a.j(this.f304595h, "https://ugd.gtimg.com//vg/1682232044394_tvideo_floating_window_button.png");
        this.f304595h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.parts.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                z.N9(view2);
            }
        });
    }

    private void J9(View view) {
        final View findViewById = view.findViewById(R.id.zep);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.parts.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                z.this.O9(findViewById, view2);
            }
        });
        findViewById.setOnLongClickListener(new a());
        S9(findViewById, "setting");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        zt2.l.c(getActivity(), jy2.g.y(this));
        VideoReport.reportEvent("clck", view, gy2.c.i(this.f304596i));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L9() {
        zt2.l.e(this.f304594f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        getActivity().onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N9(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowEvent(true));
        HashMap hashMap = new HashMap();
        if (com.tencent.mobileqq.tvideo.floatingwindow.j.g()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_enable_float_screen", str);
        VideoReport.reportEvent("clck", view, hashMap);
        uq3.k.a().j("tvideo_floating_window_guide_key", true);
        com.tencent.mobileqq.tvideo.floatingwindow.d.f304435a.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        ((ITVideoPublicAccountLauncherApi) QRoute.api(ITVideoPublicAccountLauncherApi.class)).launchTVideoPublicAccountDetailPage(getActivity());
        VideoReport.reportEvent("clck", view, gy2.c.i(this.f304596i));
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(boolean z16) {
        int i3;
        String str;
        ImageView imageView = this.f304595h;
        if (imageView == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        imageView.setVisibility(i3);
        if (z16) {
            HashMap hashMap = new HashMap();
            if (com.tencent.mobileqq.tvideo.floatingwindow.j.g()) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("is_enable_float_screen", str);
            VideoReport.reportEvent("imp", this.f304595h, hashMap);
            com.tencent.mobileqq.tvideo.floatingwindow.d.l(this.f304595h);
        }
    }

    private boolean Q9() {
        if (jy2.g.D(this) && !((TVideoLayerMultiTabPageFragment) getPartHost()).isResumed()) {
            return true;
        }
        return false;
    }

    private void R9(final boolean z16) {
        if (Q9()) {
            return;
        }
        com.tencent.mobileqq.tvideo.floatingwindow.a.a().f(z16);
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.y
            @Override // java.lang.Runnable
            public final void run() {
                z.this.P9(z16);
            }
        });
    }

    private void S9(View view, String str) {
        Map<String, Object> g16 = gy2.c.g();
        g16.put("style", "vertical");
        VideoReport.setElementParams(view, g16);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(view, str);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSTVideoFloatingWindowEntranceVisibleEvent.class);
        arrayList.add(QFSTVideoFeedsItemSelectedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerTVideoTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration == null) {
            return;
        }
        QLog.i("QFSLayerTVideoTitlePart", 1, "onConfigurationChanged newConfig  : " + configuration.orientation);
        int i3 = configuration.orientation;
        if (i3 == 2) {
            this.f304593e.setVisibility(8);
            px2.b.g();
        } else if (i3 == 1) {
            this.f304593e.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f304592d = view;
        H9(view);
        J9(view);
        G9(view);
        I9(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        zt2.e.f453199a.x(this.f304597m);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        rx2.c.a2();
        com.tencent.mobileqq.tvideo.floatingwindow.d.f304435a.g();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTVideoFloatingWindowEntranceVisibleEvent) {
            E9((QFSTVideoFloatingWindowEntranceVisibleEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSTVideoFeedsItemSelectedEvent) {
            F9(((QFSTVideoFeedsItemSelectedEvent) simpleBaseEvent).getTVideoFeed());
        }
    }
}
