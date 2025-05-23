package lx2;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoScreenTouchEvent;
import com.tencent.mobileqq.tvideo.view.ToucheInterceptLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import jy2.g;
import ox2.d;
import px2.e;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends u {

    /* renamed from: d, reason: collision with root package name */
    protected View f415739d;

    /* renamed from: e, reason: collision with root package name */
    private View f415740e;

    /* renamed from: f, reason: collision with root package name */
    private ToucheInterceptLinearLayout f415741f;

    private void A9(View view) {
        final View findViewById = view.findViewById(R.id.tzl);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: lx2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.this.C9(findViewById, view2);
            }
        });
        VideoReport.setElementParams(findViewById, gy2.c.g());
        VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(findViewById, "go_back");
    }

    private boolean B9() {
        if (2 == getContext().getResources().getConfiguration().orientation) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C9(View view, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        if (iy2.a.e()) {
            ((Activity) getContext()).finish();
        } else {
            g.Q((Activity) getContext(), 1);
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    private void E9(int i3) {
        boolean z16;
        d c16 = d.c();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        c16.i(z16);
        this.f415740e.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F9, reason: merged with bridge method [inline-methods] */
    public void D9(int i3) {
        if (B9()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoScreenTouchEvent(i3));
        }
    }

    private void G9() {
        View view = this.f415740e;
        view.setPadding(view.getPaddingLeft() + e.i(), 0, this.f415740e.getPaddingRight(), 0);
        ViewGroup.LayoutParams layoutParams = this.f415740e.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = e.h();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoChannelLandscapePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration == null) {
            return;
        }
        cy2.b.e().p(configuration.orientation);
        if (!getHostFragment().isResumed()) {
            QLog.i("TVideoChannelLandscapePart", 1, "onConfigurationChanged isResumed false\uff01\uff01\uff01");
            return;
        }
        QLog.i("TVideoChannelLandscapePart", 1, "onConfigurationChanged newConfig  : " + configuration.orientation);
        int i3 = configuration.orientation;
        if (i3 == 2) {
            E9(0);
        } else if (i3 == 1) {
            E9(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f415739d = view;
        ToucheInterceptLinearLayout toucheInterceptLinearLayout = (ToucheInterceptLinearLayout) view.findViewById(R.id.root_layout);
        this.f415741f = toucheInterceptLinearLayout;
        toucheInterceptLinearLayout.setOnActionListener(new ToucheInterceptLinearLayout.a() { // from class: lx2.a
            @Override // com.tencent.mobileqq.tvideo.view.ToucheInterceptLinearLayout.a
            public final void a(int i3) {
                c.this.D9(i3);
            }
        });
        this.f415740e = view.findViewById(R.id.f45641sf);
        G9();
        d.c().f(this.f415740e);
        A9(this.f415740e);
        cy2.b.e().z(this.f415740e);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        d.c().h();
        cy2.b.e().x();
        ox2.b.e().j();
    }
}
