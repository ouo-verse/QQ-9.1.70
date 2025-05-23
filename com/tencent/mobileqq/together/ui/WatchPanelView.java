package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;

/* loaded from: classes9.dex */
public class WatchPanelView extends RelativeLayout implements View.OnClickListener {
    public View.OnClickListener C;

    /* renamed from: d, reason: collision with root package name */
    ImageView f293408d;

    /* renamed from: e, reason: collision with root package name */
    ImageView f293409e;

    /* renamed from: f, reason: collision with root package name */
    TextView f293410f;

    /* renamed from: h, reason: collision with root package name */
    TextView f293411h;

    /* renamed from: i, reason: collision with root package name */
    PatchedButton f293412i;

    /* renamed from: m, reason: collision with root package name */
    int f293413m;

    public WatchPanelView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.caw, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.gxb);
        this.f293408d = (ImageView) findViewById(R.id.maw);
        this.f293409e = (ImageView) findViewById(R.id.f99305pf);
        this.f293410f = (TextView) findViewById(R.id.f166994mb0);
        this.f293412i = (PatchedButton) findViewById(R.id.max);
        this.f293411h = (TextView) findViewById(R.id.maz);
        this.f293412i.setOnClickListener(this);
        this.f293413m = BaseAIOUtils.f(39.0f, getResources());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        View.OnClickListener onClickListener = this.C;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
