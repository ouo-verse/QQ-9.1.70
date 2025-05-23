package com.tencent.biz.qqcircle.immersive.search.filter;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudRead$FilterGroup;
import p70.d;
import q60.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchFilterGroupItemView extends QFSSearchBaseWidgetView<FeedCloudRead$FilterGroup> {

    /* renamed from: e, reason: collision with root package name */
    private TextView f89875e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f89876f;

    /* renamed from: h, reason: collision with root package name */
    private c f89877h;

    public QFSSearchFilterGroupItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f89875e = (TextView) findViewById(R.id.f52772ap);
        this.f89876f = (RecyclerView) findViewById(R.id.f52762ao);
        c cVar = new c(new Bundle());
        this.f89877h = cVar;
        this.f89876f.setAdapter(cVar);
        this.f89876f.setLayoutManager(new SafeLinearLayoutManager(getContext(), 0, false));
        this.f89876f.setNestedScrollingEnabled(false);
        this.f89876f.setOverScrollMode(2);
        if (this.f89876f.getItemAnimator() instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) this.f89876f.getItemAnimator()).setSupportsChangeAnimations(false);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.grv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudRead$FilterGroup feedCloudRead$FilterGroup, int i3) {
        if (feedCloudRead$FilterGroup == null) {
            return;
        }
        this.f89875e.setText(feedCloudRead$FilterGroup.name.get());
        this.f89877h.p0(feedCloudRead$FilterGroup.name.get());
        this.f89877h.setDatas(feedCloudRead$FilterGroup.choices.get());
        this.f89877h.n0(getQCircleBaseFragment());
        this.f89877h.m0((d) getViewModel(d.class));
        this.f89877h.o0(i3);
    }
}
