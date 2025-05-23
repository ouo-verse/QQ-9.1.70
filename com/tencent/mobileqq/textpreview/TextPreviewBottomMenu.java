package com.tencent.mobileqq.textpreview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.textpreview.inject.f;
import com.tencent.qqnt.textpreview.inject.g;
import com.tencent.util.TokenResUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

/* loaded from: classes18.dex */
public class TextPreviewBottomMenu implements com.tencent.qqnt.textpreview.inject.b {
    static IPatchRedirector $redirector_;
    private TextView C;
    private TextView D;
    private TextView E;
    protected String F;
    private ImageView G;
    private ImageView H;
    private ImageView I;
    private Activity J;
    private AnimationDrawable K;
    private f L;
    protected QQProgressDialog M;

    /* renamed from: d, reason: collision with root package name */
    public View f292744d;

    /* renamed from: e, reason: collision with root package name */
    public View f292745e;

    /* renamed from: f, reason: collision with root package name */
    public View f292746f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f292747h;

    /* renamed from: i, reason: collision with root package name */
    public View f292748i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f292749m;

    public TextPreviewBottomMenu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.F = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.L.b(this.J, false);
        s();
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.L.b(this.J, true);
        m();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.L.b(this.J, false);
        m();
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        QQProgressDialog qQProgressDialog = this.M;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.M.dismiss();
        }
    }

    private void n() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.L = g.a().h();
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        if (((TicketManager) peekAppRuntime.getManager(2)) == null) {
            this.L = null;
        } else {
            this.L.a(currentAccountUin, null, 0);
            this.L.c(new f.a() { // from class: com.tencent.mobileqq.textpreview.TextPreviewBottomMenu.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextPreviewBottomMenu.this);
                    }
                }

                @Override // com.tencent.qqnt.textpreview.inject.f.a
                public void a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, (Object) this);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewBottomMenu.2.5
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    TextPreviewBottomMenu.this.l();
                                    QQToast.makeText(TextPreviewBottomMenu.this.J.getApplicationContext(), TextPreviewBottomMenu.this.J.getText(R.string.u3k), 0).show();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.qqnt.textpreview.inject.f.a
                public void b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewBottomMenu.2.3
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    TextPreviewBottomMenu.this.k();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.qqnt.textpreview.inject.f.a
                public void c() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewBottomMenu.2.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    TextPreviewBottomMenu.this.j();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.qqnt.textpreview.inject.f.a
                public void e(String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewBottomMenu.2.4
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    TextPreviewBottomMenu.this.l();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.qqnt.textpreview.inject.f.a
                public void onError(int i3, String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewBottomMenu.2.6
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    TextPreviewBottomMenu.this.l();
                                    QQToast.makeText(TextPreviewBottomMenu.this.J.getApplicationContext(), TextPreviewBottomMenu.this.J.getText(R.string.u3k), 0).show();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.qqnt.textpreview.inject.f.a
                public void onPlayStart(String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewBottomMenu.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    TextPreviewBottomMenu.this.k();
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void o() {
        MobileQQ mobileQQ;
        AppRuntime peekAppRuntime;
        if (!ar.b("shouyouye", "2024-01-26", "vas_dress_up_recovery").isEnable(true) || TextUtils.isEmpty(this.F) || this.E == null || (mobileQQ = MobileQQ.sMobileQQ) == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) {
            return;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin) && TextUtils.equals(currentAccountUin, this.F)) {
            this.E.setText(R.string.f2309870m);
            this.E.setContentDescription(this.J.getResources().getString(R.string.f2309870m));
        }
    }

    private void p() {
        if (this.M == null) {
            Activity activity = this.J;
            this.M = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
        if (!this.J.isFinishing()) {
            this.M.show();
        }
    }

    private void r() {
        if (TokenResUtils.useTokenRes3()) {
            this.f292747h.setBackgroundResource(R.drawable.j9b);
        } else if (g.a().c()) {
            this.f292747h.setBackgroundResource(R.drawable.j9a);
        } else {
            this.f292747h.setBackgroundResource(R.drawable.gxt);
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f292747h.getBackground();
        this.K = animationDrawable;
        animationDrawable.start();
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void a(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
        } else {
            LayoutInflater.from(activity).inflate(R.layout.dwg, (ViewGroup) activity.findViewById(R.id.acl), true);
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public boolean b(@NonNull MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return com.tencent.qqnt.utils.a.f363000a.a(this.f292748i, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void c(@NonNull Activity activity, @NonNull Intent intent, @NonNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, intent, appRuntime);
            return;
        }
        this.J = activity;
        this.f292744d = activity.findViewById(R.id.lib);
        this.f292745e = activity.findViewById(R.id.m9f);
        if (intent.getBooleanExtra("is_block_speech", false)) {
            this.f292745e.setVisibility(8);
        }
        this.f292747h = (ImageView) activity.findViewById(R.id.llo);
        this.f292746f = activity.findViewById(R.id.let);
        this.f292748i = activity.findViewById(R.id.lif);
        this.f292749m = (TextView) activity.findViewById(R.id.f166975ma4);
        this.C = (TextView) activity.findViewById(R.id.m_t);
        this.D = (TextView) activity.findViewById(R.id.jgz);
        this.E = (TextView) activity.findViewById(R.id.f95355er);
        this.F = intent.getStringExtra("real_msg_sender_uin");
        this.G = (ImageView) activity.findViewById(R.id.llf);
        this.H = (ImageView) activity.findViewById(R.id.llg);
        this.I = (ImageView) activity.findViewById(R.id.llh);
        this.G.setBackgroundResource(R.drawable.qui_copy_plus_selector);
        this.H.setBackgroundResource(R.drawable.qui_edit_plus_selector);
        this.f292747h.setBackgroundResource(R.drawable.qui_volume_plus_selector);
        this.I.setBackgroundResource(R.drawable.qui_communication_plus_brand_standard_selector);
        o();
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public boolean d(int i3, @NonNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) bundle)).booleanValue();
        }
        if (i3 == R.id.m9e) {
            q(bundle.getString("content"));
            return false;
        }
        return false;
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        f fVar = this.L;
        if (fVar != null) {
            fVar.destroy();
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.textpreview.inject.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            p();
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.textpreview.TextPreviewBottomMenu.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextPreviewBottomMenu.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TextPreviewBottomMenu.this.m();
                        QQToast.makeText(TextPreviewBottomMenu.this.J, TextPreviewBottomMenu.this.J.getText(R.string.u3k), 0).show();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 2000L);
            QLog.d("TextPreviewBottomMenu", 1, "[startSpeechAndAnimation] network invalid.");
            return;
        }
        QLog.d("TextPreviewBottomMenu", 1, "[startSpeechAndAnimation] attempt to play text: ", Character.valueOf(str.charAt(0)));
        if (this.L == null) {
            n();
        }
        f fVar = this.L;
        if (fVar == null) {
            QQToast.makeText(this.J.getApplicationContext(), this.J.getText(R.string.oty), 0).show();
        } else if (fVar.isWorking()) {
            this.L.stop();
        } else {
            this.L.speak(str, this.F);
            TextPlayStateManager.b().c(this.L);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Drawable background = this.f292747h.getBackground();
        if (background instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) background;
            this.K = animationDrawable;
            animationDrawable.stop();
            if (TokenResUtils.useTokenRes3()) {
                this.f292747h.setBackgroundResource(R.drawable.qui_volume_plus_selector);
            } else if (g.a().c()) {
                this.f292747h.setBackgroundResource(R.drawable.j9_);
            } else {
                this.f292747h.setBackgroundResource(R.drawable.gxu);
            }
        }
    }
}
