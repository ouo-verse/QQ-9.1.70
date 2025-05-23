package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes5.dex */
public class QFSBarragePopupView extends FrameLayout implements View.OnClickListener {
    private View C;
    private View D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private String f93170d;

    /* renamed from: e, reason: collision with root package name */
    private View f93171e;

    /* renamed from: f, reason: collision with root package name */
    private View f93172f;

    /* renamed from: h, reason: collision with root package name */
    private View f93173h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f93174i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f93175m;

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public static class b {
    }

    public QFSBarragePopupView(@NonNull Context context) {
        super(context);
        this.f93170d = "";
        this.E = 0;
        d();
    }

    private void a() {
        QLog.d("QFSBarragePopupView", 1, "[handlerBarrageDeleteItemClick] barrage popup param should not be null.");
    }

    private void b() {
        QLog.d("QFSBarragePopupView", 1, "[handlerBarrageReportItemClick] barrage popup param should not be null.");
    }

    private void c() {
        QLog.d("QFSBarragePopupView", 1, "[handlerBarrageVipJumpClick] barrage popup param should not be null.");
    }

    private void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.g86, this);
        this.f93171e = findViewById(R.id.f34160ye);
        this.f93172f = findViewById(R.id.f34100y9);
        this.f93173h = findViewById(R.id.f34120ya);
        this.f93174i = (ImageView) findViewById(R.id.f34150yd);
        this.f93175m = (LinearLayout) findViewById(R.id.f34140yc);
        this.C = findViewById(R.id.f34200yi);
        this.D = findViewById(R.id.f34210yj);
        this.f93171e.setOnClickListener(this);
        this.f93172f.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.f93170d = uq3.c.L0("https://act.qzone.qq.com/v2/vip/tx/p/46124_c4b3bc39?_wv=16777217&_wwv=1");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f34160ye) {
            b();
        } else if (id5 == R.id.f34100y9) {
            a();
        } else if (id5 == R.id.f34200yi) {
            c();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setBarragePopupParam(b bVar) {
        QLog.d("QFSBarragePopupView", 1, "[setBarragePopupParam] barrage popup param should not be null.");
    }

    public void setPopupBadgePoint(int i3, int i16, int i17) {
        if (i3 < 0) {
            this.f93175m.setGravity(3);
        } else if (i3 + i16 > i17) {
            this.f93175m.setGravity(5);
        } else {
            this.f93175m.setGravity(1);
        }
    }

    public QFSBarragePopupView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93170d = "";
        this.E = 0;
        d();
    }

    public QFSBarragePopupView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93170d = "";
        this.E = 0;
        d();
    }

    public void setItemActionListener(a aVar) {
    }
}
