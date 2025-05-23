package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.ac;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.d;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideBottomPanel;
import com.tencent.mobileqq.widget.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes32.dex */
public class SendPanelPart extends u implements b, a, ac.a, r, View.OnClickListener {
    private ImageView C;
    private d D;
    private Handler E;
    private ObjectAnimator F;
    private boolean G;
    private volatile boolean H;
    public boolean I;

    /* renamed from: d, reason: collision with root package name */
    private View f68811d;

    /* renamed from: e, reason: collision with root package name */
    private SlideBottomPanel f68812e;

    /* renamed from: f, reason: collision with root package name */
    private View f68813f;

    /* renamed from: h, reason: collision with root package name */
    private XListView f68814h;

    /* renamed from: i, reason: collision with root package name */
    private View f68815i;

    /* renamed from: m, reason: collision with root package name */
    private View f68816m;

    public SendPanelPart(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.G = false;
        this.H = false;
        this.I = false;
    }

    private void l0() {
        d dVar;
        View view = this.f68815i;
        if (view != null && view.getVisibility() == 8 && this.f68812e.n() && (dVar = this.D) != null && dVar.e()) {
            this.H = true;
            q0(0, 1, 0);
            com.tencent.aelight.camera.aioeditor.b.l(this.mParent);
        }
    }

    private View m0() {
        View view = new View(getContext());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, BaseAIOUtils.f(130.0f, getResources())));
        view.setBackgroundResource(R.drawable.skin_setting_strip_bg_unpressed);
        return view;
    }

    private void n0() {
        this.E = new Handler(Looper.getMainLooper());
        SendPanelManager.k().v(this);
        List<e> m3 = SendPanelManager.k().m();
        if (m3 != null && this.D != null) {
            k0(m3);
            this.D.setData(m3);
        }
        ac.a().d(this);
    }

    private boolean p0(int i3, int i16) {
        if (i3 == 1) {
            if (i16 != 0 && i16 != 1000 && i16 != 1004) {
                return false;
            }
            return true;
        }
        if (i3 == 4) {
            if (i16 != 1) {
                return false;
            }
            return true;
        }
        if (i3 != 101 || i16 != 3000) {
            return false;
        }
        return true;
    }

    private void q0(int i3, int i16, int i17) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(i3, i16);
        this.f68815i.startAnimation(alphaAnimation);
        alphaAnimation.setDuration(500L);
        this.f68815i.setVisibility(i17);
    }

    private void r0() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f68813f, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.3f, 0.0f), Keyframe.ofFloat(0.45f, -80.0f), Keyframe.ofFloat(0.65f, 50.0f), Keyframe.ofFloat(0.8f, -30.0f), Keyframe.ofFloat(0.9f, 10.0f), Keyframe.ofFloat(1.0f, 0.0f)));
        this.F = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(1600L);
        this.F.setStartDelay(1000L);
        this.F.setRepeatCount(1);
        this.F.start();
        this.G = true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.ac.a
    public void G() {
        Handler handler;
        if (this.D == null || (handler = this.E) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelPart.3
            @Override // java.lang.Runnable
            public void run() {
                SendPanelPart.this.D.h(true);
            }
        });
        this.H = false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.a
    public void I(String str, int i3, String str2, Bitmap bitmap) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("SendPanelPart", 4, "onUpdateIcon uin is empty");
                return;
            }
            return;
        }
        List<e> m3 = SendPanelManager.k().m();
        if (m3 != null && m3.size() > 0) {
            int size = m3.size();
            for (final int i16 = 0; i16 < size; i16++) {
                final e eVar = m3.get(i16);
                if (!TextUtils.isEmpty(eVar.f68834a) && eVar.f68834a.equals(str) && p0(i3, eVar.f68837d)) {
                    eVar.f68841h = bitmap;
                    eVar.f68840g = str2;
                    Handler handler = this.E;
                    if (handler != null) {
                        handler.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelPart.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SendPanelPart.this.Q(i16, eVar);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SendPanelPart", 4, "onUpdateIcon itemInfoList is empty");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.b
    public void Q(int i3, e eVar) {
        d dVar = this.D;
        if (dVar != null) {
            dVar.i(i3, eVar);
            XListView xListView = this.f68814h;
            if (xListView != null) {
                int firstVisiblePosition = xListView.getFirstVisiblePosition();
                int lastVisiblePosition = this.f68814h.getLastVisiblePosition();
                if (i3 >= firstVisiblePosition && i3 <= lastVisiblePosition) {
                    View childAt = this.f68814h.getChildAt(i3 - firstVisiblePosition);
                    if (childAt.getTag() instanceof d.e) {
                        d.e eVar2 = (d.e) childAt.getTag();
                        eVar2.f68832d = eVar;
                        this.D.b(i3, eVar2);
                    }
                }
            }
            if (this.H) {
                return;
            }
            l0();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.ac.a
    public void X(boolean z16) {
        SlideBottomPanel slideBottomPanel = this.f68812e;
        if (slideBottomPanel != null) {
            if (z16) {
                if (slideBottomPanel.m()) {
                    return;
                }
                this.f68812e.o();
            } else if (slideBottomPanel.m()) {
                this.f68812e.p();
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.b
    public void a(List<e> list) {
        d dVar = this.D;
        if (dVar != null) {
            dVar.setData(list);
        }
    }

    @Override // com.tencent.mobileqq.widget.r
    public void cancelAnimator() {
        ObjectAnimator objectAnimator;
        if (!this.G || (objectAnimator = this.F) == null) {
            return;
        }
        objectAnimator.cancel();
        this.G = false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.b
    public void destroy() {
        d dVar = this.D;
        if (dVar != null) {
            dVar.destroy();
        }
    }

    @Override // com.tencent.mobileqq.widget.r
    public void displayPanel() {
        l0();
        View view = this.f68816m;
        if (view != null) {
            view.setVisibility(0);
        }
        com.tencent.aelight.camera.aioeditor.b.k(this.mParent);
    }

    @Override // com.tencent.mobileqq.widget.r
    public void displayPanelFinish() {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setBackgroundResource(R.drawable.hzl);
        }
    }

    @Override // com.tencent.mobileqq.widget.r
    public void fadeBackground(float f16) {
        View view = this.f68816m;
        if (view != null) {
            view.setVisibility(0);
            this.f68816m.setAlpha(f16);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public Context getContext() {
        return super.getContext();
    }

    @Override // com.tencent.mobileqq.widget.r
    public void hidePanel() {
        View view = this.f68815i;
        if (view != null && view.getVisibility() == 0) {
            q0(1, 0, 8);
        }
        View view2 = this.f68816m;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.widget.r
    public void hidePanelFinish() {
        ImageView imageView = this.C;
        if (imageView != null) {
            imageView.setBackgroundResource(R.drawable.hzk);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.imy) {
            if (this.mParent.C.b()) {
                this.I = true;
            }
            this.mParent.n1();
            com.tencent.aelight.camera.aioeditor.b.e(this.mParent);
            ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        o0();
        n0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        d dVar = this.D;
        if (dVar != null) {
            dVar.g();
        }
        this.H = false;
        ac.a().e(this);
        super.onDestroy();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        super.onResume();
        if (SendPanelManager.k().F) {
            SendPanelManager.k().F = false;
            r0();
            SendPanelManager.k().y(false);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.b
    public void q() {
        if (QLog.isColorLevel()) {
            QLog.i("SendPanelPart", 4, "compositeFail");
        }
        Handler handler = this.E;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelPart.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(SendPanelPart.this.getContext().getApplicationContext(), HardCodeUtil.qqStr(R.string.f172684tb4), 0).show();
                }
            });
        }
    }

    private void k0(List<e> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<e> it = list.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void o0() {
        View inflate = ((ViewStub) findViewSure(R.id.s0q)).inflate();
        this.f68811d = inflate;
        this.f68812e = (SlideBottomPanel) inflate.findViewById(R.id.m8z);
        this.f68813f = this.f68811d.findViewById(R.id.b_7);
        this.f68814h = (XListView) this.f68811d.findViewById(R.id.eap);
        this.f68815i = this.f68811d.findViewById(R.id.m7z);
        this.f68816m = this.f68811d.findViewById(R.id.a4f);
        this.C = (ImageView) this.f68811d.findViewById(R.id.f167007jv2);
        this.f68814h.addFooterView(m0());
        d dVar = new d(getContext(), this);
        this.D = dVar;
        dVar.j(this);
        this.f68814h.setAdapter((ListAdapter) this.D);
        this.f68812e.setSlidePanelListener(this);
        this.f68815i.findViewById(R.id.imy).setOnClickListener(this);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.b
    public void onLoadStart() {
    }
}
