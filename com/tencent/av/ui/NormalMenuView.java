package com.tencent.av.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.av.ui.QavPanel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NormalMenuView {

    /* renamed from: a, reason: collision with root package name */
    final String f74979a;

    /* renamed from: b, reason: collision with root package name */
    a f74980b;

    /* renamed from: c, reason: collision with root package name */
    RelativeLayout f74981c;

    /* renamed from: d, reason: collision with root package name */
    int f74982d;

    /* renamed from: e, reason: collision with root package name */
    boolean f74983e = false;

    /* renamed from: f, reason: collision with root package name */
    ObjectAnimator f74984f = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(long j3, RelativeLayout relativeLayout, boolean z16);

        void b(long j3, RelativeLayout relativeLayout, boolean z16);
    }

    public NormalMenuView(RelativeLayout relativeLayout, int i3, a aVar) {
        this.f74979a = "MenuView_" + i3;
        this.f74981c = relativeLayout;
        this.f74982d = i3;
        this.f74980b = aVar;
    }

    public RelativeLayout a() {
        return this.f74981c;
    }

    public void b(long j3, boolean z16, int i3, QavPanel.m mVar) {
        c(j3, z16, i3, mVar, true);
    }

    public void c(final long j3, boolean z16, int i3, final QavPanel.m mVar, final boolean z17) {
        int i16;
        boolean z18;
        ObjectAnimator objectAnimator;
        RelativeLayout relativeLayout = this.f74981c;
        if (relativeLayout != null) {
            i16 = relativeLayout.getVisibility();
        } else {
            i16 = 4;
        }
        String str = this.f74979a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("HiddenMenuView, isShow[");
        sb5.append(this.f74983e);
        sb5.append("], needAnimation[");
        sb5.append(z16);
        sb5.append("], visibility[");
        sb5.append(i16);
        sb5.append("], lastObjectAnimator[");
        if (this.f74984f != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        sb5.append(z18);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("]");
        QLog.w(str, 1, sb5.toString());
        e();
        if (z16) {
            final int g16 = g();
            if (i3 == 2) {
                objectAnimator = ObjectAnimator.ofFloat(this.f74981c, "TranslationY", 0.0f, g16);
            } else {
                objectAnimator = null;
            }
            ObjectAnimator objectAnimator2 = objectAnimator;
            if (objectAnimator2 == null) {
                if (!com.tencent.av.utils.e.j()) {
                    return;
                }
                String str2 = HardCodeUtil.qqStr(R.string.pqy) + this.f74983e + "], height[" + g16 + "], seq[" + j3 + "]";
                QLog.w(this.f74979a, 1, str2, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
                throw new IllegalArgumentException(str2);
            }
            objectAnimator2.setDuration(300L);
            objectAnimator2.addListener(new com.tencent.mobileqq.widget.f() { // from class: com.tencent.av.ui.NormalMenuView.1
                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    int i17;
                    NormalMenuView normalMenuView = NormalMenuView.this;
                    normalMenuView.f74983e = false;
                    RelativeLayout relativeLayout2 = normalMenuView.f74981c;
                    if (relativeLayout2 != null) {
                        i17 = relativeLayout2.getVisibility();
                        NormalMenuView normalMenuView2 = NormalMenuView.this;
                        if (!normalMenuView2.f74983e && z17) {
                            normalMenuView2.f74981c.setVisibility(8);
                        } else {
                            a aVar = normalMenuView2.f74980b;
                            if (aVar != null) {
                                aVar.b(j3, normalMenuView2.f74981c, false);
                            }
                        }
                        NormalMenuView.this.f74981c.setAlpha(1.0f);
                        NormalMenuView.this.f74981c.setTranslationY(0.0f);
                    } else {
                        i17 = 4;
                    }
                    QLog.w(NormalMenuView.this.f74979a, 1, "HiddenMenuView, onAnimationEnd, isShow[" + NormalMenuView.this.f74983e + "], visibility[" + i17 + "], seq[" + j3 + "], \nlastObjectAnimator[" + NormalMenuView.this.f74984f + "], \nanimation[" + animator + "]");
                    if (NormalMenuView.this.f74984f == animator) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.NormalMenuView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QavPanel.m mVar2 = mVar;
                                if (mVar2 != null) {
                                    mVar2.a();
                                }
                            }
                        });
                        NormalMenuView.this.f74984f = null;
                    }
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    RelativeLayout relativeLayout2 = NormalMenuView.this.f74981c;
                    int visibility = relativeLayout2 != null ? relativeLayout2.getVisibility() : 4;
                    QLog.w(NormalMenuView.this.f74979a, 1, "HiddenMenuView, onAnimationStart, isShow[" + NormalMenuView.this.f74983e + "], height[" + g16 + "], visibility[" + visibility + "], seq[" + j3 + "]");
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator, boolean z19) {
                    onAnimationStart(animator);
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator, boolean z19) {
                    onAnimationEnd(animator);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.f74984f = objectAnimator2;
            objectAnimator2.start();
            this.f74983e = false;
            a aVar = this.f74980b;
            if (aVar != null) {
                aVar.b(j3, this.f74981c, true);
                return;
            }
            return;
        }
        a aVar2 = this.f74980b;
        if (aVar2 != null) {
            aVar2.b(j3, this.f74981c, true);
        }
        RelativeLayout relativeLayout2 = this.f74981c;
        if (relativeLayout2 != null && z17) {
            relativeLayout2.setVisibility(8);
            this.f74983e = false;
        }
        a aVar3 = this.f74980b;
        if (aVar3 != null) {
            aVar3.b(j3, this.f74981c, false);
        }
    }

    public void d(final long j3, boolean z16, int i3) {
        boolean z17;
        ObjectAnimator objectAnimator;
        if (this.f74981c == null) {
            return;
        }
        String str = this.f74979a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ShowMenuView, isShow[");
        sb5.append(this.f74983e);
        sb5.append("], needAnimation[");
        sb5.append(z16);
        sb5.append("], lastObjectAnimator[");
        if (this.f74984f != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("], visibility[");
        sb5.append(this.f74981c.getVisibility());
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("]");
        QLog.w(str, 1, sb5.toString());
        e();
        a aVar = this.f74980b;
        if (aVar != null) {
            aVar.a(j3, this.f74981c, true);
        }
        if (z16) {
            final int g16 = g();
            if (i3 == 3) {
                objectAnimator = ObjectAnimator.ofFloat(this.f74981c, "TranslationY", g16, 0.0f);
            } else if (i3 == 4) {
                objectAnimator = ObjectAnimator.ofFloat(this.f74981c, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            } else {
                objectAnimator = null;
            }
            if (objectAnimator == null) {
                QLog.w(this.f74979a, 1, "ShowMenuView, warning animator is null");
                return;
            }
            objectAnimator.setDuration(300L);
            objectAnimator.addListener(new com.tencent.mobileqq.widget.f() { // from class: com.tencent.av.ui.NormalMenuView.2
                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    int i16;
                    RelativeLayout relativeLayout = NormalMenuView.this.f74981c;
                    if (relativeLayout != null) {
                        i16 = relativeLayout.getVisibility();
                        NormalMenuView normalMenuView = NormalMenuView.this;
                        if (!normalMenuView.f74983e) {
                            normalMenuView.f74981c.setVisibility(8);
                        } else {
                            normalMenuView.f74981c.setVisibility(0);
                            NormalMenuView normalMenuView2 = NormalMenuView.this;
                            a aVar2 = normalMenuView2.f74980b;
                            if (aVar2 != null) {
                                aVar2.a(j3, normalMenuView2.f74981c, false);
                            }
                        }
                        NormalMenuView.this.f74981c.setAlpha(1.0f);
                        NormalMenuView.this.f74981c.setTranslationY(0.0f);
                    } else {
                        i16 = 4;
                    }
                    if (NormalMenuView.this.f74983e) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.NormalMenuView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewParent viewParent;
                                RelativeLayout relativeLayout2 = NormalMenuView.this.f74981c;
                                if (relativeLayout2 != null) {
                                    viewParent = relativeLayout2.getParent();
                                } else {
                                    viewParent = null;
                                }
                                if (viewParent != null) {
                                    viewParent.requestLayout();
                                }
                            }
                        });
                    }
                    QLog.w(NormalMenuView.this.f74979a, 1, "ShowMenuView, onAnimationEnd, isShow[" + NormalMenuView.this.f74983e + "], visibility[" + i16 + "], seq[" + j3 + "], \nlastObjectAnimator[" + NormalMenuView.this.f74984f + "], \nanimation[" + animator + "]");
                    NormalMenuView normalMenuView3 = NormalMenuView.this;
                    if (normalMenuView3.f74984f == animator) {
                        normalMenuView3.f74984f = null;
                    }
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    int i16;
                    RelativeLayout relativeLayout = NormalMenuView.this.f74981c;
                    if (relativeLayout != null) {
                        i16 = relativeLayout.getVisibility();
                        NormalMenuView.this.f74981c.setVisibility(0);
                    } else {
                        i16 = 4;
                    }
                    QLog.w(NormalMenuView.this.f74979a, 1, "ShowMenuView, onAnimationStart, height[" + g16 + "], isShow[" + NormalMenuView.this.f74983e + "], visibility[" + i16 + "], seq[" + j3 + "]");
                    if (NormalMenuView.this.f74983e) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.NormalMenuView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewParent viewParent;
                                RelativeLayout relativeLayout2 = NormalMenuView.this.f74981c;
                                if (relativeLayout2 != null) {
                                    viewParent = relativeLayout2.getParent();
                                } else {
                                    viewParent = null;
                                }
                                if (viewParent != null) {
                                    viewParent.requestLayout();
                                }
                            }
                        });
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.f74983e = true;
            this.f74984f = objectAnimator;
            objectAnimator.start();
            return;
        }
        this.f74981c.setVisibility(0);
        this.f74983e = true;
        a aVar2 = this.f74980b;
        if (aVar2 != null) {
            aVar2.a(j3, this.f74981c, false);
        }
    }

    void e() {
        ObjectAnimator objectAnimator = this.f74984f;
        this.f74984f = null;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public int f() {
        return this.f74982d;
    }

    int g() {
        RelativeLayout relativeLayout = this.f74981c;
        if (relativeLayout == null) {
            return 0;
        }
        relativeLayout.measure(0, 0);
        return this.f74981c.getMeasuredHeight();
    }
}
