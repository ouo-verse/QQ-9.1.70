package com.qzone.reborn.feedx.widget.header;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.lifecycle.LifecycleOwner;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneMoodListHeaderContainerView extends QZoneBaseFeedxHeaderContainerView {
    private u C;
    private w D;
    private y E;

    /* renamed from: m, reason: collision with root package name */
    private QZoneFeedxMoodListViewModel f56143m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.viewmodel.g {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i6() {
            QZoneMoodListHeaderContainerView.this.delayShow();
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void onHandleMessage(Message message) {
            QZoneMoodListHeaderContainerView.this.onHandleMessage(message);
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void v0(QZoneResult qZoneResult) {
            QZoneMoodListHeaderContainerView.this.a0(qZoneResult);
        }
    }

    public QZoneMoodListHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context, lifecycleOwner, cVar);
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public Handler Z() {
        return this.f56143m.getMHandler();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cly;
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void n0() {
        u uVar = new u(this);
        this.C = uVar;
        r0(uVar);
        w wVar = new w(this);
        this.D = wVar;
        r0(wVar);
        y yVar = new y(this);
        this.E = yVar;
        r0(yVar);
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void o0() {
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = (QZoneFeedxMoodListViewModel) this.f56121f.W(QZoneFeedxMoodListViewModel.class);
        this.f56143m = qZoneFeedxMoodListViewModel;
        qZoneFeedxMoodListViewModel.k2(new a());
    }

    @Override // com.qzone.reborn.feedx.widget.header.QZoneBaseFeedxHeaderContainerView
    public void p0() {
        u uVar = this.C;
        if (uVar != null) {
            uVar.o();
        }
    }
}
