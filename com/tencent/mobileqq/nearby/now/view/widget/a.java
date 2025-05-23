package com.tencent.mobileqq.nearby.now.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends Dialog {

    /* renamed from: d, reason: collision with root package name */
    protected AnimationPoint f253012d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f253013e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.nearby.now.view.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class ViewOnTouchListenerC8145a implements View.OnTouchListener {
        ViewOnTouchListenerC8145a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                a.this.dismiss();
            }
            return true;
        }
    }

    public a(Context context) {
        super(context, ((IResourceUtil) QRoute.api(IResourceUtil.class)).getAddDescribeDialogStyleNoFull());
        View inflate = LayoutInflater.from(context).inflate(((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQStoryNewGuideDialog(), (ViewGroup) null);
        inflate.setOnTouchListener(new ViewOnTouchListenerC8145a());
        super.setContentView(inflate);
        this.f253012d = (AnimationPoint) super.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getAnimationPoint());
        this.f253013e = (TextView) super.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getGuideTv());
        this.f253012d.setDuration(-1L);
        this.f253012d.setOnAnimationListener(new b());
    }

    public void a(String str) {
        this.f253013e.setText(str);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f253012d.h();
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        this.f253012d.g();
        super.show();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
