package com.tencent.mobileqq.guild.robot.components.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Context f232145d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f232146e;

    public RobotLoadingView(@NonNull Context context) {
        super(context);
        this.f232145d = context;
        a();
    }

    private void a() {
        LayoutInflater.from(this.f232145d).inflate(R.layout.emg, this);
        this.f232146e = (ImageView) findViewById(R.id.vsw);
    }

    public void setLoadingBg(@DrawableRes int i3) {
        this.f232146e.setImageResource(i3);
    }

    public RobotLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f232145d = context;
        a();
    }

    public RobotLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f232145d = context;
        a();
    }
}
