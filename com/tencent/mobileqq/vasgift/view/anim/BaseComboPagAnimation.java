package com.tencent.mobileqq.vasgift.view.anim;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.mobileqq.vasgift.utils.b;
import com.tencent.qphone.base.util.QLog;
import org.libpag.PAGView;

/* loaded from: classes20.dex */
abstract class BaseComboPagAnimation {

    /* renamed from: a, reason: collision with root package name */
    private final View f312083a;

    /* renamed from: b, reason: collision with root package name */
    protected PAGView f312084b;

    public BaseComboPagAnimation(View view) {
        this.f312083a = view;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f312084b = new PAGView(this.f312083a.getContext());
        ViewGroup viewGroup = (ViewGroup) this.f312083a.getParent();
        int indexOfChild = viewGroup.indexOfChild(this.f312083a);
        this.f312084b.setId(this.f312083a.getId());
        viewGroup.removeView(this.f312083a);
        viewGroup.addView(this.f312084b, indexOfChild, this.f312083a.getLayoutParams());
    }

    private void c() {
        if (QQGiftPAGAnimationViewImpl.f311895g.a()) {
            b();
            d();
        } else {
            View view = this.f312083a;
            if (view != null) {
                QQGiftPAGAnimationViewImpl.f311895g.b(view.getContext(), new b.InterfaceC8940b() { // from class: com.tencent.mobileqq.vasgift.view.anim.BaseComboPagAnimation.1
                    @Override // com.tencent.mobileqq.vasgift.utils.b.InterfaceC8940b
                    public void onComplete(final boolean z16) {
                        ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.view.anim.BaseComboPagAnimation.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z16) {
                                    BaseComboPagAnimation.this.b();
                                    BaseComboPagAnimation.this.d();
                                } else {
                                    QLog.e("BaseComboPagAnimation", 1, "loadPag failed");
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    abstract void d();
}
