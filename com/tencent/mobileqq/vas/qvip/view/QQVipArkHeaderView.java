package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQVipArkHeaderView extends RelativeLayout implements t23.a {

    /* renamed from: d, reason: collision with root package name */
    private QvipArkView f310616d;

    /* renamed from: e, reason: collision with root package name */
    private ArkAppContainer f310617e;

    /* renamed from: f, reason: collision with root package name */
    private int f310618f;

    /* renamed from: h, reason: collision with root package name */
    private QQVipMsgInfo f310619h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), BaseAIOUtils.f(16.0f, QQVipArkHeaderView.this.getContext().getResources()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnLayoutChangeListener {

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a extends ViewOutlineProvider {
            a() {
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), BaseAIOUtils.f(16.0f, QQVipArkHeaderView.this.getContext().getResources()));
            }
        }

        b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (QQVipArkHeaderView.this.f310616d.getHeight() > 0) {
                float height = ((QQVipArkHeaderView.this.getHeight() * 1.0f) - BaseAIOUtils.f(54.0f, QQVipArkHeaderView.this.getContext().getResources())) / QQVipArkHeaderView.this.f310616d.getHeight();
                QQVipArkHeaderView.this.f310616d.setScaleY(height);
                QQVipArkHeaderView.this.f310616d.setScaleX(height);
                QQVipArkHeaderView.this.f310616d.setOutlineProvider(new a());
                QQVipArkHeaderView.this.f310616d.setClipToOutline(true);
            }
        }
    }

    public QQVipArkHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.layout.fs5, this);
        QvipArkView qvipArkView = (QvipArkView) findViewById(R.id.cvu);
        this.f310616d = qvipArkView;
        qvipArkView.setOutlineProvider(new a());
        this.f310616d.setClipToOutline(true);
        this.f310616d.setmQqVipArkHeaderView(this);
        this.f310616d.addOnLayoutChangeListener(new b());
    }

    @Override // t23.a
    public void a(QQVipMsgInfo qQVipMsgInfo, Activity activity, int i3) {
        float f16;
        int i16;
        if (this.f310616d != null) {
            this.f310618f = i3;
            this.f310619h = qQVipMsgInfo;
            ArkAppContainer arkAppContainer = this.f310617e;
            if (arkAppContainer != null) {
                arkAppContainer.doOnEvent(2);
            }
            this.f310617e = new ArkAppContainer(false);
            float f17 = qQVipMsgInfo.mArkScale;
            if (f17 > 0.0f) {
                f16 = f17;
            } else {
                f16 = 0.0f;
            }
            int i17 = qQVipMsgInfo.mArkWidth;
            if (i17 <= 0 && qQVipMsgInfo.mArkHeight <= 0) {
                i17 = ViewUtils.getScreenWidth() - ViewUtils.dip2px(50.0f);
                i16 = -1;
            } else {
                i16 = qQVipMsgInfo.mArkHeight;
            }
            this.f310617e.h(qQVipMsgInfo.mArkAppName, qQVipMsgInfo.mArkAppView, "", qQVipMsgInfo.mArkAppMinVersion, qQVipMsgInfo.mArkMetaList, f16, new SessionInfo());
            QvipArkView qvipArkView = this.f310616d;
            qvipArkView.setOnTouchListener(qvipArkView);
            QvipArkView qvipArkView2 = this.f310616d;
            qvipArkView2.setOnLongClickListener(qvipArkView2);
            this.f310617e.setFixSize(i17, i16);
            this.f310616d.initArkView(this.f310617e);
        }
    }

    @Override // t23.a
    public void onDestory() {
        ArkAppContainer arkAppContainer = this.f310617e;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
