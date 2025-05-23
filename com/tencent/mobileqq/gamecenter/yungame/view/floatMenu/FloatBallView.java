package com.tencent.mobileqq.gamecenter.yungame.view.floatMenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FloatBallView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private int f213599d;

    /* renamed from: e, reason: collision with root package name */
    private View f213600e;

    public FloatBallView(Context context) {
        this(context, null);
    }

    public void a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f213600e.setBackground(null);
                    setAlpha(0.5f);
                }
            } else {
                this.f213600e.setBackground(getContext().getDrawable(R.drawable.jok));
                setAlpha(1.0f);
            }
        } else {
            this.f213600e.setBackground(getContext().getDrawable(R.drawable.jol));
            setAlpha(1.0f);
        }
        this.f213599d = i3;
        if (QLog.isDevelopLevel()) {
            QLog.d("FloatBallView", 4, "[changeMode] mode:" + i3);
        }
    }

    public void b(Context context) {
        View.inflate(context, R.layout.i8v, this);
        this.f213600e = findViewById(R.id.ee7);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public FloatBallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatBallView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f213599d = 0;
        b(context);
    }
}
