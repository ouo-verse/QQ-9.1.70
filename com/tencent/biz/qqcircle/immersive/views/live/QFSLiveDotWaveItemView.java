package com.tencent.biz.qqcircle.immersive.views.live;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLiveDotWaveItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f90809d;

    /* renamed from: e, reason: collision with root package name */
    private View f90810e;

    /* renamed from: f, reason: collision with root package name */
    private AnimRunnable f90811f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f90812h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class AnimRunnable implements Runnable {
        AnimRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!QFSLiveDotWaveItemView.this.f90812h) {
                return;
            }
            int nextInt = new Random().nextInt(3);
            if (nextInt == 0) {
                QFSLiveDotWaveItemView.this.f90809d.setVisibility(4);
                QFSLiveDotWaveItemView.this.f90810e.setVisibility(0);
            } else if (nextInt == 1) {
                QFSLiveDotWaveItemView.this.f90809d.setVisibility(4);
                QFSLiveDotWaveItemView.this.f90810e.setVisibility(4);
            } else {
                QFSLiveDotWaveItemView.this.f90809d.setVisibility(0);
                QFSLiveDotWaveItemView.this.f90810e.setVisibility(0);
            }
            QFSLiveDotWaveItemView.this.postDelayed(this, 200L);
        }
    }

    public QFSLiveDotWaveItemView(@NonNull Context context) {
        this(context, null);
    }

    public void d() {
        QLog.i("QFSLiveDotWaveItemView", 1, this + " startAnim");
        this.f90812h = true;
        AnimRunnable animRunnable = new AnimRunnable();
        this.f90811f = animRunnable;
        post(animRunnable);
    }

    public void e() {
        QLog.i("QFSLiveDotWaveItemView", 1, this + " stopAnim");
        removeCallbacks(this.f90811f);
        this.f90812h = false;
        this.f90811f = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        QLog.i("QFSLiveDotWaveItemView", 1, this + " onDetachedFromWindow");
        super.onDetachedFromWindow();
        e();
    }

    public QFSLiveDotWaveItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public QFSLiveDotWaveItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View.inflate(context, R.layout.g3w, this);
        this.f90809d = findViewById(R.id.f11839741);
        this.f90810e = findViewById(R.id.f11840742);
    }
}
