package com.tencent.mobileqq.tvideo.parts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.authpay.TVideoAuthPayWebView;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayPanelEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayReloadEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPageWebViewShowEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPlayOrPauseEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ab extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver {

    /* renamed from: i, reason: collision with root package name */
    private static final int f304512i = cx.a(500.0f);

    /* renamed from: d, reason: collision with root package name */
    private TVideoAuthPayWebView f304513d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f304514e;

    /* renamed from: f, reason: collision with root package name */
    private ConstraintLayout f304515f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f304516h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("QFSTVideoPageAuthPayPart", 1, "webViewParentView onClick");
            ab.this.F9();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements TVideoAuthPayWebView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.tvideo.authpay.TVideoAuthPayWebView.b
        public void clear() {
            ab.this.F9();
        }
    }

    private void A9(Object obj) {
        if (getContext().getResources().getConfiguration().orientation == 2) {
            jy2.g.Q(Foreground.getTopActivity(), 1);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f304513d.getLayoutParams();
        if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0) {
            layoutParams.topToTop = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
        } else {
            layoutParams.topToTop = -1;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = f304512i;
        }
        this.f304513d.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B9, reason: merged with bridge method [inline-methods] */
    public void F9() {
        TVideoAuthPayWebView tVideoAuthPayWebView = this.f304513d;
        if (tVideoAuthPayWebView != null && this.f304514e != null) {
            tVideoAuthPayWebView.loadUrl("about:blank");
            this.f304514e.setVisibility(8);
            this.f304513d.setVisibility(8);
            if (this.f304516h) {
                H9();
            }
        }
    }

    private void C9() {
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.aa
            @Override // java.lang.Runnable
            public final void run() {
                ab.this.F9();
            }
        });
    }

    private void D9(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        if (qCircleConfigChangeEvent == null) {
            return;
        }
        int i3 = qCircleConfigChangeEvent.configuration.orientation;
        QLog.d("QFSTVideoPageAuthPayPart", 1, "handleConfigurationChange orientation : " + i3);
        if (i3 == 2) {
            F9();
        }
    }

    private void E9() {
        if (this.f304514e == null) {
            View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f44751q1)).inflate();
            this.f304515f = (ConstraintLayout) inflate.findViewById(R.id.sxo);
            this.f304514e = (FrameLayout) inflate.findViewById(R.id.sxq);
            this.f304513d = (TVideoAuthPayWebView) inflate.findViewById(R.id.sxr);
            this.f304514e.setOnClickListener(new a());
        }
    }

    private void G9(Map<String, ?> map) {
        String str = (String) map.get("url");
        QLog.d("QFSTVideoPageAuthPayPart", 1, "onReceiveEvent openUrl  : " + str);
        this.f304513d.setWebViewPartListener(new b());
        this.f304513d.loadUrl(str);
        I9();
    }

    private void H9() {
        QFSTVideoPlayOrPauseEvent qFSTVideoPlayOrPauseEvent = new QFSTVideoPlayOrPauseEvent();
        qFSTVideoPlayOrPauseEvent.setPlay(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoPlayOrPauseEvent);
    }

    private void I9() {
        TVideoAuthPayWebView tVideoAuthPayWebView = this.f304513d;
        if (tVideoAuthPayWebView != null && this.f304514e != null) {
            if (tVideoAuthPayWebView.getParent() == null) {
                QLog.d("QFSTVideoPageAuthPayPart", 1, "showWebView webView.getParent() == null");
                ConstraintLayout constraintLayout = this.f304515f;
                TVideoAuthPayWebView tVideoAuthPayWebView2 = this.f304513d;
                constraintLayout.addView(tVideoAuthPayWebView2, tVideoAuthPayWebView2.getLayoutParams());
            }
            this.f304514e.setVisibility(0);
            this.f304513d.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSTVideoPageWebViewShowEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        arrayList.add(QFSTVideoAuthPayPanelEvent.class);
        arrayList.add(QFSTVideoAuthPayReloadEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        FrameLayout frameLayout = this.f304514e;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            F9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
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
        jy2.f.f411169a.b(this.f304513d);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTVideoPageWebViewShowEvent) {
            QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent = (QFSTVideoPageWebViewShowEvent) simpleBaseEvent;
            if (!qFSTVideoPageWebViewShowEvent.isFromAuthPay()) {
                return;
            }
            this.f304516h = qFSTVideoPageWebViewShowEvent.isNeedInterceptVideo();
            E9();
            Map<String, ?> paramsMap = qFSTVideoPageWebViewShowEvent.getParamsMap();
            A9(paramsMap.get("style"));
            G9(paramsMap);
            return;
        }
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            D9((QCircleConfigChangeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSTVideoAuthPayReloadEvent) {
            C9();
        } else if ((simpleBaseEvent instanceof QFSTVideoAuthPayPanelEvent) && !((QFSTVideoAuthPayPanelEvent) simpleBaseEvent).isShow()) {
            C9();
        }
    }
}
