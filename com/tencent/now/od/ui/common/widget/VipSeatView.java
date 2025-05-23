package com.tencent.now.od.ui.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.now.od.ui.game.meleegame.widget.PopularityView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VipSeatView extends ConstraintLayout {
    private static final List<Integer> D = Arrays.asList(1, 2, 3, 4);
    private static final List<Integer> E = Arrays.asList(5, 6, 7, 8);
    protected int C;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f338546d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f338547e;

    /* renamed from: f, reason: collision with root package name */
    protected RoundImageView f338548f;

    /* renamed from: h, reason: collision with root package name */
    protected WaveAnimationView f338549h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f338550i;

    /* renamed from: m, reason: collision with root package name */
    protected PopularityView f338551m;

    public VipSeatView(Context context) {
        super(context);
        initView();
    }

    private void z0(View view) {
        com.tencent.report.a.f364907a.c(view, true, null, "em_qqlive_seat_profilepicture", new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.f338547e = (TextView) findViewById(R.id.f98);
        this.f338548f = (RoundImageView) findViewById(R.id.a2o);
        this.f338550i = (ImageView) findViewById(R.id.t0k);
        this.f338551m = (PopularityView) findViewById(R.id.f26410dg);
        this.f338546d = (TextView) findViewById(R.id.f81334dw);
        this.f338549h = (WaveAnimationView) findViewById(R.id.f87134tj);
        z0(this.f338550i);
    }

    public void setPopularity(int i3) {
        this.f338551m.setPopularity(i3);
    }

    public void setSeatNum(int i3) {
        this.C = i3;
    }

    public VipSeatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public VipSeatView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
    }
}
