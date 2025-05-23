package com.tencent.biz.qqcircle.widgets.pymk;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.d;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.pymk.a;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.part.block.base.GalleryLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qqcircle.QQCircleDitto$StItemContainer;

/* loaded from: classes5.dex */
public class QFSNewUserPYMKGuideWidget extends QCirclePYMKRecommendView {
    private GalleryLayoutManager P;

    public QFSNewUserPYMKGuideWidget(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.f29670m_);
        this.f93822i = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.f29580m1);
        this.f93820f = textView;
        textView.setOnClickListener(this);
        this.f93821h = (TextView) findViewById(R.id.f32920v2);
        int dpToPx = ImmersiveUtils.dpToPx(10.0f);
        QCirclePluginUtil.expandViewTouchDelegate(this.f93822i, dpToPx, dpToPx, dpToPx, dpToPx);
        QCirclePluginUtil.expandViewTouchDelegate(this.f93820f, dpToPx, dpToPx, dpToPx, dpToPx);
        this.f93823m = (RecyclerView) findViewById(R.id.f29680ma);
        findViewById(R.id.f29660m9).setVisibility(8);
        this.f93823m.setVisibility(0);
        GalleryLayoutManager galleryLayoutManager = new GalleryLayoutManager(0);
        this.P = galleryLayoutManager;
        galleryLayoutManager.attach(this.f93823m, 0);
        this.P.setCallbackInFling(true);
        this.P.setItemTransformer(new com.tencent.biz.qqcircle.richframework.part.block.base.a());
        this.C = new a();
        this.f93823m.getLayoutParams().height = cx.a(306.0f);
        this.C.q0(this);
        this.C.z0(true);
        this.f93823m.setAdapter(this.C);
        this.f93823m.addItemDecoration(new a.b());
    }

    @Override // com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendView, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.G;
        if (qQCircleDitto$StItemContainer == null) {
            QLog.d("QCircleSplashPYMKRecommendWidget", 1, "[onClick] container not is null.");
        } else {
            c.o0(getContext(), d.d(qQCircleDitto$StItemContainer.urlInfo.get(), "personRecomListUrl"), null, -1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
