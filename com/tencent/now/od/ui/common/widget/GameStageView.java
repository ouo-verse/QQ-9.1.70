package com.tencent.now.od.ui.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class GameStageView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    protected VipSeatView[] f338530d;

    public GameStageView(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(A0(), this);
        z0(this);
    }

    private void z0(View view) {
        this.f338530d[0] = (VipSeatView) view.findViewById(R.id.f81344dx);
        this.f338530d[1] = (VipSeatView) view.findViewById(R.id.f81354dy);
        this.f338530d[2] = (VipSeatView) view.findViewById(R.id.f81364dz);
        this.f338530d[3] = (VipSeatView) view.findViewById(R.id.f81374e0);
        this.f338530d[4] = (VipSeatView) view.findViewById(R.id.f81384e1);
        this.f338530d[5] = (VipSeatView) view.findViewById(R.id.f81394e2);
        this.f338530d[6] = (VipSeatView) view.findViewById(R.id.f81404e3);
        this.f338530d[7] = (VipSeatView) view.findViewById(R.id.f81414e4);
    }

    @LayoutRes
    protected abstract int A0();

    public GameStageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameStageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338530d = new VipSeatView[8];
        initView();
    }
}
