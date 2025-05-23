package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class c implements b, IOrderElement {
    private final Handler C = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    protected e30.b f90601d;

    /* renamed from: e, reason: collision with root package name */
    protected FeedCloudMeta$StFeed f90602e;

    /* renamed from: f, reason: collision with root package name */
    protected int f90603f;

    /* renamed from: h, reason: collision with root package name */
    protected final View f90604h;

    /* renamed from: i, reason: collision with root package name */
    private final a f90605i;

    /* renamed from: m, reason: collision with root package name */
    private final Context f90606m;

    public c(@NonNull a aVar) {
        Context context;
        this.f90605i = aVar;
        View rootView = aVar.getRootView();
        this.f90604h = rootView;
        if (rootView == null) {
            context = null;
        } else {
            context = rootView.getContext();
        }
        this.f90606m = context;
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void g() {
        r();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return this.f90605i.getContextHashCode();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return this.f90605i.getGroup();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroupExtraKey() {
        return this.f90605i.getGroupExtraKey();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        this.f90601d = bVar;
        this.f90602e = bVar.g();
        this.f90603f = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void i() {
        q();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context j() {
        return this.f90606m;
    }

    public QCircleExtraTypeInfo k() {
        QCircleInitBean qCircleInitBean;
        int i3;
        QCircleExtraTypeInfo r16 = this.f90605i.r();
        t40.a o16 = o();
        QCircleExtraTypeInfo qCircleExtraTypeInfo = null;
        if (o16 != null) {
            qCircleInitBean = o16.getInitBean();
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean != null) {
            qCircleExtraTypeInfo = qCircleInitBean.getExtraTypeInfo();
        }
        if (qCircleExtraTypeInfo != null && (i3 = qCircleExtraTypeInfo.sourceType) != 0) {
            r16.sourceType = i3;
        }
        return r16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String l() {
        e30.b bVar = this.f90601d;
        if (bVar != null && bVar.g() != null) {
            return this.f90601d.g().f398449id.get();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String m();

    /* JADX INFO: Access modifiers changed from: protected */
    public Handler n() {
        return this.C;
    }

    public t40.a o() {
        return this.f90605i.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleReportBean p() {
        return this.f90605i.getReportBean();
    }

    protected abstract void q();

    protected abstract void r();

    public void s(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        a aVar = this.f90605i;
        if (aVar == null) {
            QLog.e("QFSAbsFeedBottomBannerView", 1, "[sendPresenterMessageEvent] host proxy should not be null.");
        } else {
            aVar.E(hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onAttachedToWindow() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    @CallSuper
    public void onDestroy() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onDetachedFromWindow() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    @CallSuper
    public void e(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    @CallSuper
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }
}
