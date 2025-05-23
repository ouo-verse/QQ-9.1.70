package com.qzone.album.ui.widget;

import android.view.View;
import android.widget.TextView;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private View f44324d;

    /* renamed from: e, reason: collision with root package name */
    private AsyncImageView f44325e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f44326f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f44327h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f44328i;

    /* renamed from: m, reason: collision with root package name */
    private View f44329m;

    public d(View view) {
        if (view != null) {
            this.f44325e = (AsyncImageView) view.findViewById(R.id.hbf);
            this.f44326f = (TextView) view.findViewById(R.id.hdy);
            this.f44327h = (TextView) view.findViewById(R.id.hao);
            this.f44328i = (TextView) view.findViewById(R.id.hal);
            this.f44329m = view.findViewById(R.id.han);
            this.f44324d = view;
            view.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.hal) {
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
