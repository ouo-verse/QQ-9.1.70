package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.manager.diffres.QCircleChangeResEngine;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCirclePlusFollowResPackage;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import da0.b;

/* loaded from: classes4.dex */
public class QFSPlusFollowView extends QFSFollowView implements AnimationDrawableFactory.CreateResultListener, b.a {

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f90432c0;

    /* renamed from: d0, reason: collision with root package name */
    private a f90433d0;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimationEnd();
    }

    public QFSPlusFollowView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        int a16 = cx.a(12.0f);
        int a17 = cx.a(2.0f);
        QCirclePluginUtil.expandViewTouchDelegate(this, a17, a17, a16, a16);
    }

    private void S() {
        if (!i()) {
            return;
        }
        if (QCirclePluginUtil.isFollow(this.f93227a0)) {
            D(false);
        } else {
            E();
        }
    }

    private void T() {
        AnimationDrawableCreateOption.Builder defaultBuilder = QCircleAnimationHelper.getDefaultBuilder(Q().d().iconAnimUrl);
        defaultBuilder.setAllDuration(1000);
        defaultBuilder.setCreateTimeOut(1000L);
        q50.a.a(hashCode(), defaultBuilder.build(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView
    public void D(boolean z16) {
        if (z16) {
            T();
        } else {
            setVisibility(8);
        }
        setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView
    public void E() {
        setVisibility(8);
        setClickable(false);
    }

    public da0.b<QCirclePlusFollowResPackage> Q() {
        return QCircleChangeResEngine.INSTANCE.getResManager(QCirclePlusFollowResPackage.class);
    }

    @Override // da0.b.a
    public void a(fa0.d dVar) {
        S();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q().l(this);
    }

    @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
    public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
        if (z16 && qQAnimationDrawable != null) {
            qQAnimationDrawable.setOneShot(true);
            setBackgroundDrawable(qQAnimationDrawable);
            qQAnimationDrawable.setOneShot(true);
            qQAnimationDrawable.reset();
            qQAnimationDrawable.start();
            postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSPlusFollowView.this.setVisibility(8);
                    if (QFSPlusFollowView.this.f90433d0 != null) {
                        QFSPlusFollowView.this.f90433d0.onAnimationEnd();
                    }
                }
            }, 1000L);
            return;
        }
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView.2
            @Override // java.lang.Runnable
            public void run() {
                QFSPlusFollowView.this.setVisibility(8);
                if (QFSPlusFollowView.this.f90433d0 != null) {
                    QFSPlusFollowView.this.f90433d0.onAnimationEnd();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q().m(this);
    }

    public void setDismissAnimationListener(a aVar) {
        this.f90433d0 = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView
    public void x() {
        super.x();
        setVisibility(8);
        setText("");
        this.f90432c0 = new ImageView(getContext());
    }

    public QFSPlusFollowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPlusFollowView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Q().o(this);
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.ac
            @Override // java.lang.Runnable
            public final void run() {
                QFSPlusFollowView.this.R();
            }
        });
    }
}
