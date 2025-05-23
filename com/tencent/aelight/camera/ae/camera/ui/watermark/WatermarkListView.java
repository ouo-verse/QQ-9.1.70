package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WatermarkListView extends ScrollView {

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f63416d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView.Adapter<RecyclerView.ViewHolder> f63417e;

    /* renamed from: f, reason: collision with root package name */
    private List<RecyclerView.ViewHolder> f63418f;

    public WatermarkListView(Context context) {
        super(context);
        c(context);
    }

    public RecyclerView.ViewHolder a(int i3) {
        return this.f63418f.get(i3);
    }

    public int b() {
        List<RecyclerView.ViewHolder> list = this.f63418f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this.f63417e = adapter;
        this.f63418f = new ArrayList();
        this.f63416d.removeAllViews();
        for (int i3 = 0; i3 < adapter.getItemCount(); i3++) {
            RecyclerView.ViewHolder onCreateViewHolder = adapter.onCreateViewHolder(this.f63416d, 0);
            adapter.onBindViewHolder(onCreateViewHolder, i3);
            this.f63416d.addView(onCreateViewHolder.itemView, new FrameLayout.LayoutParams(-1, -2));
            this.f63418f.add(onCreateViewHolder);
        }
    }

    private void c(Context context) {
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f63416d = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f63416d, new FrameLayout.LayoutParams(-1, -2));
    }

    public WatermarkListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public WatermarkListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c(context);
    }
}
