package com.qzone.reborn.layer.recommendphoto;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ho.i;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxLayerUserHomeEntranceView extends QZoneBaseWidgetView<QZoneFeedxLayerRecommendPhotoBean> {

    /* renamed from: e, reason: collision with root package name */
    private Context f58102e;

    /* renamed from: f, reason: collision with root package name */
    private long f58103f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFeedxLayerUserHomeEntranceView.this.o0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneFeedxLayerUserHomeEntranceView(Context context) {
        super(context);
        this.f58103f = 0L;
        this.f58102e = context;
        q0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        if (this.f58102e instanceof Activity) {
            if (this.f58103f == 0) {
                RFWLog.e("QZoneFeedxLayerUserHomeEntranceView", RFWLog.USR, "illegal uin, not jump");
            } else {
                i.z().r(this.f58102e, this.f58103f);
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean, int i3) {
        if (qZoneFeedxLayerRecommendPhotoBean != null && qZoneFeedxLayerRecommendPhotoBean.albumOwnerUin != 0) {
            r0(qZoneFeedxLayerRecommendPhotoBean);
        } else {
            setVisibility(8);
        }
    }

    private void p0(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new a());
    }

    private void q0(View view) {
        if (view == null) {
            return;
        }
        p0(view);
    }

    private void r0(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (qZoneFeedxLayerRecommendPhotoBean == null) {
            return;
        }
        this.f58103f = qZoneFeedxLayerRecommendPhotoBean.albumOwnerUin;
    }
}
