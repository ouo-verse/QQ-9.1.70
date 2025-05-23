package com.tencent.biz.qqcircle.immersive.views.live;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLiveDotWaveView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private QFSLiveDotWaveItemView f90813d;

    /* renamed from: e, reason: collision with root package name */
    private QFSLiveDotWaveItemView f90814e;

    /* renamed from: f, reason: collision with root package name */
    private QFSLiveDotWaveItemView f90815f;

    public QFSLiveDotWaveView(@NonNull Context context) {
        this(context, null);
    }

    public void a() {
        QLog.i("QFSLiveDotWaveView", 1, this + " start()");
        b();
        this.f90813d.d();
        this.f90814e.d();
        this.f90815f.d();
    }

    public void b() {
        QLog.i("QFSLiveDotWaveView", 1, this + " stop()");
        this.f90813d.e();
        this.f90814e.e();
        this.f90815f.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        QLog.i("QFSLiveDotWaveView", 1, this + " onDetachedFromWindow()");
        super.onDetachedFromWindow();
        b();
    }

    public QFSLiveDotWaveView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSLiveDotWaveView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View.inflate(context, R.layout.g3x, this);
        this.f90813d = (QFSLiveDotWaveItemView) findViewById(R.id.ymf);
        this.f90814e = (QFSLiveDotWaveItemView) findViewById(R.id.ymg);
        this.f90815f = (QFSLiveDotWaveItemView) findViewById(R.id.ymh);
    }
}
