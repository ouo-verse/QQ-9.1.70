package com.tencent.biz.qqcircle.widgets.search;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QFSSearchResultBaseView<T> extends QCircleBaseWidgetView<T> implements View.OnClickListener {
    protected i60.a C;

    /* renamed from: d, reason: collision with root package name */
    protected View f93847d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f93848e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f93849f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f93850h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f93851i;

    /* renamed from: m, reason: collision with root package name */
    protected View f93852m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            QFSSearchResultBaseView.this.k0(rect, view, recyclerView);
        }
    }

    public QFSSearchResultBaseView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93849f = (ImageView) findViewById(R.id.f53502co);
        this.f93850h = (TextView) findViewById(R.id.f54422f6);
        this.f93851i = (ImageView) findViewById(R.id.f53702d8);
        this.f93847d = findViewById(R.id.f55592ib);
        this.f93852m = findViewById(R.id.f3660150);
        this.f93851i.setOnClickListener(this);
        this.f93847d.setVisibility(8);
        this.f93852m.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f52542a3);
        this.f93848e = recyclerView;
        recyclerView.addItemDecoration(new a());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsg;
    }

    protected abstract void l0();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f53702d8) {
            l0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnClickMoreListener(i60.a aVar) {
        this.C = aVar;
    }

    protected void k0(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView) {
    }
}
