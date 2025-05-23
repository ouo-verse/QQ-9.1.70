package com.qzone.reborn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneAvatarLoopView extends GuildVoicingAvatarLayout {
    private static final int T = ViewUtils.dip2px(1.0f);
    private final a Q;
    private boolean R;
    private int S;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends GuildVoicingAvatarLayout.c<b, Long> {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.c
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(b bVar, Long l3) {
            bVar.b(l3);
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.c
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public b l(ViewGroup viewGroup) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.clo, viewGroup, false), ((GuildVoicingAvatarLayout) QZoneAvatarLoopView.this).C, QZoneAvatarLoopView.this.S, QZoneAvatarLoopView.this.R);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b extends GuildVoicingAvatarLayout.e {

        /* renamed from: b, reason: collision with root package name */
        QZoneUserAvatarView f59606b;

        public b(View view, int i3, int i16, boolean z16) {
            super(view);
            QZoneUserAvatarView qZoneUserAvatarView = (QZoneUserAvatarView) view.findViewById(R.id.f19024k);
            this.f59606b = qZoneUserAvatarView;
            qZoneUserAvatarView.setBorderWidth(i16);
            if (!z16) {
                this.f59606b.setOnClickListener(null);
                this.f59606b.setClickable(false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59606b.getLayoutParams();
            layoutParams.width = i3 - (view.getPaddingLeft() + view.getPaddingRight());
            layoutParams.height = i3 - (view.getPaddingBottom() + view.getPaddingTop());
            this.f59606b.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            view.setLayoutParams(layoutParams2);
        }

        public void b(Long l3) {
            if (this.f59606b == null) {
                return;
            }
            QZoneUserAvatarView.b bVar = new QZoneUserAvatarView.b();
            bVar.f55960b = false;
            this.f59606b.setUser(l3.longValue(), bVar);
        }
    }

    public QZoneAvatarLoopView(Context context) {
        super(context);
        this.Q = new a();
        this.R = true;
        this.S = T;
    }

    private void H() {
        int i3 = this.C + (T * 2);
        this.C = i3;
        setAvatarSize(i3);
        setChildrenDrawingOrderEnabled(true);
        setAdapter(this.Q);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        return (i3 - 1) - i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        J();
        super.onDetachedFromWindow();
    }

    public void setBorderWidth(int i3) {
        this.S = i3;
    }

    public void setNeedAvatarClick(boolean z16) {
        this.R = z16;
    }

    public void I() {
        setAnimateEnable(true);
    }

    public void J() {
        setAnimateEnable(false);
    }

    public void K(List<Long> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        J();
        this.Q.j(new ArrayList(), list);
        I();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        if (i3 == 0 && isShown()) {
            I();
        } else {
            J();
        }
        super.onVisibilityChanged(view, i3);
    }

    public QZoneAvatarLoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = new a();
        this.R = true;
        this.S = T;
        H();
    }
}
