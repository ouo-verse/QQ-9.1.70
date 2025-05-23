package com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget.RightTextRecyclerLayout;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.m;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import e80.b;
import e80.c;
import e80.d;
import e80.g;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.List;
import n80.a;
import nb0.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSSearchMixResultBaseView<T> extends QFSSearchBaseWidgetView<T> implements g, c, b, d {
    private a C;
    private m D;
    private T E;

    /* renamed from: e, reason: collision with root package name */
    private View f91070e;

    /* renamed from: f, reason: collision with root package name */
    private RightTextRecyclerLayout f91071f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f91072h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b f91073i;

    /* renamed from: m, reason: collision with root package name */
    private final i80.a f91074m;

    public QFSSearchMixResultBaseView(@NonNull Context context) {
        super(context);
        this.f91074m = q0();
        initView();
    }

    private void initView() {
        this.f91070e = findViewById(R.id.f47021w6);
        this.f91071f = (RightTextRecyclerLayout) findViewById(R.id.f47341x1);
        this.f91072h = (RecyclerView) findViewById(R.id.f47351x2);
        this.f91070e.setVisibility(8);
        this.f91072h.setAdapter(this.f91074m);
        this.f91074m.l0(hashCode());
        this.f91072h.setLayoutManager(new SafeLinearLayoutManager(getContext(), 0, false));
        h80.a aVar = new h80.a(new b.c() { // from class: h80.b
            @Override // nb0.b.c
            public final void b(int i3) {
                QFSSearchMixResultBaseView.this.s0(i3);
            }
        });
        aVar.g(o());
        this.f91072h.addOnScrollListener(aVar);
        a aVar2 = new a(8388611, aVar);
        this.C = aVar2;
        aVar2.attachToRecyclerView(this.f91072h);
        this.D = new m(this.f91072h, this.f91074m, this.C, hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(int i3) {
        play();
        QFSSearchPrerenderManager.E(getContext()).U(o(), i3);
    }

    private void u0(List<FeedCloudMeta$StFeed> list) {
        this.f91073i.Z1(list);
        this.f91073i.X1(list);
    }

    private void v0(List<FeedCloudMeta$StFeed> list) {
        ad.t(this.f91071f, list, QCircleApplication.getAPP().getString(R.string.fr5), m0());
        this.f91074m.setDatas(list);
        u0(list);
        this.C.l(0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        this.D.a();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(T t16, int i3) {
        if (this.E == t16) {
            return;
        }
        this.E = t16;
        if (!l0(t16)) {
            QLog.d("QFSSearchMixResultBaseView", 1, "#bindData checkData fail");
            this.f91070e.setVisibility(8);
            this.f91074m.setDatas(null);
        } else {
            this.f91070e.setVisibility(0);
            v0(n0(t16));
            w0(t16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchMixResultBaseView";
    }

    @Override // e80.b
    public boolean hasData() {
        if (this.f91074m.getNUM_BACKGOURND_ICON() > 0) {
            return true;
        }
        return false;
    }

    @Override // e80.g
    public boolean isPlaying() {
        return this.D.isPlaying();
    }

    @Override // e80.c
    public boolean l() {
        return this.D.l();
    }

    public abstract boolean l0(T t16);

    public abstract Runnable m0();

    public abstract List<FeedCloudMeta$StFeed> n0(T t16);

    /* JADX INFO: Access modifiers changed from: protected */
    public int o0() {
        return !r0() ? 1 : 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.D.g();
    }

    public abstract com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b p0();

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        this.D.pause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        this.D.play();
    }

    public abstract i80.a q0();

    public boolean r0() {
        return this.D.e();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setExtraTypeInfo(Serializable serializable) {
        super.setExtraTypeInfo(serializable);
        this.f91074m.j0(getQCircleExtraTypeInfo());
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView
    public void setFragment(Fragment fragment) {
        super.setFragment(fragment);
        com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b p06 = p0();
        this.f91073i = p06;
        p06.O1(getContext());
        this.f91073i.Q1(o());
        this.f91074m.k0(getQCircleBaseFragment());
    }

    @Override // e80.g
    public void stop() {
        this.D.stop();
    }

    public abstract void w0(T t16);
}
