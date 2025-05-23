package com.tencent.relation.common.api.impl;

import android.animation.Animator;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationFloatWindowAnim;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationFloatWindowAnimImpl implements IRelationFloatWindowAnim {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RelationFloatWindowAnimImpl";

    public RelationFloatWindowAnimImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.relation.common.api.IRelationFloatWindowAnim
    public void doCircleEnterAnimation(View view, com.tencent.relation.common.window.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, aVar.f364879a, aVar.f364880b, aVar.f364881c, aVar.f364882d);
        createCircularReveal.setDuration(500L);
        createCircularReveal.start();
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f).setDuration(500L).setListener(null);
    }

    @Override // com.tencent.relation.common.api.IRelationFloatWindowAnim
    public void doCircleOuterAnimation(View view, com.tencent.relation.common.window.a aVar, IRelationFloatWindowAnim.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, aVar, aVar2);
        } else if (view == null) {
            QLog.e(TAG, 1, "doCircleOuterAnimation is error! contentView is empty!");
        } else {
            view.post(new Runnable(view, aVar, aVar2) { // from class: com.tencent.relation.common.api.impl.RelationFloatWindowAnimImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f364658d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.relation.common.window.a f364659e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ IRelationFloatWindowAnim.a f364660f;

                /* compiled from: P */
                /* renamed from: com.tencent.relation.common.api.impl.RelationFloatWindowAnimImpl$1$a */
                /* loaded from: classes25.dex */
                class a implements Animator.AnimatorListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                            return;
                        }
                        IRelationFloatWindowAnim.a aVar = AnonymousClass1.this.f364660f;
                        if (aVar != null) {
                            aVar.onAnimationEnd();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                            iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                        }
                    }
                }

                {
                    this.f364658d = view;
                    this.f364659e = aVar;
                    this.f364660f = aVar2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RelationFloatWindowAnimImpl.this, view, aVar, aVar2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f364658d.getVisibility() == 0 && this.f364658d.isAttachedToWindow()) {
                        try {
                            View view2 = this.f364658d;
                            com.tencent.relation.common.window.a aVar3 = this.f364659e;
                            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, aVar3.f364879a, aVar3.f364880b, aVar3.f364881c, aVar3.f364882d);
                            createCircularReveal.setDuration(500L);
                            createCircularReveal.addListener(new a());
                            createCircularReveal.start();
                            this.f364658d.setAlpha(1.0f);
                            this.f364658d.animate().alpha(0.0f).setDuration(500L).setListener(null);
                            return;
                        } catch (Exception e16) {
                            QLog.e(RelationFloatWindowAnimImpl.TAG, 1, "ViewAnimationUtils.createCircularReveal is error " + e16.toString());
                            IRelationFloatWindowAnim.a aVar4 = this.f364660f;
                            if (aVar4 != null) {
                                aVar4.onAnimationEnd();
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e(RelationFloatWindowAnimImpl.TAG, 1, "doCircleOuterAnimation is error! contentView is invalid!");
                }
            });
        }
    }
}
