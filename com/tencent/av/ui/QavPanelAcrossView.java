package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;

/* loaded from: classes3.dex */
public class QavPanelAcrossView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    public TextView f75103d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f75104e;

    /* renamed from: f, reason: collision with root package name */
    public FrameLayout f75105f;

    /* renamed from: h, reason: collision with root package name */
    public FrameLayout f75106h;

    /* renamed from: i, reason: collision with root package name */
    public ConstraintLayout f75107i;

    public QavPanelAcrossView(@NonNull Context context) {
        this(context, null);
    }

    public QavPanelAcrossView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QavPanelAcrossView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(R.layout.fua, this);
        this.f75103d = (TextView) findViewById(R.id.f95335ep);
        this.f75104e = (ImageView) findViewById(R.id.xdv);
        this.f75105f = (FrameLayout) findViewById(R.id.e3l);
        this.f75106h = (FrameLayout) findViewById(R.id.veh);
        this.f75107i = (ConstraintLayout) findViewById(R.id.b_7);
    }
}
