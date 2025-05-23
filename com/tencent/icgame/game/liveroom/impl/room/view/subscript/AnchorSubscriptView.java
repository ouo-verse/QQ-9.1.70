package com.tencent.icgame.game.liveroom.impl.room.view.subscript;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AnchorSubscriptView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f115775d;

    /* renamed from: e, reason: collision with root package name */
    private AnchorSubscriptViewFlipper f115776e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f115777f;

    public AnchorSubscriptView(@NonNull Context context) {
        super(context);
        A0(context);
    }

    private void A0(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fad, this);
        this.f115775d = inflate;
        inflate.setVisibility(8);
        this.f115776e = (AnchorSubscriptViewFlipper) this.f115775d.findViewById(R.id.spc);
        this.f115777f = (ImageView) this.f115775d.findViewById(R.id.j7n);
        z0(this.f115775d);
    }

    public AnchorSubscriptView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A0(context);
    }

    public AnchorSubscriptView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        A0(context);
    }

    private void z0(View view) {
    }
}
