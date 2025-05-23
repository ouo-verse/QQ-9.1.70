package com.tencent.now.app.music.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import cm3.a;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.component.core.event.EventCenter;
import com.tencent.mobileqq.R;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import ul3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AudioVolumeSettingDialog extends a implements SeekBar.OnSeekBarChangeListener {
    private View C;
    private View D;
    private int E;
    private int F;
    private boolean G = false;
    private boolean H = false;
    private Timer I;
    private TimerTask J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private long R;
    private MusicPlayMgr S;

    /* renamed from: e, reason: collision with root package name */
    private int f338086e;

    /* renamed from: f, reason: collision with root package name */
    private SeekBar f338087f;

    /* renamed from: h, reason: collision with root package name */
    private SeekBar f338088h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f338089i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f338090m;

    public AudioVolumeSettingDialog() {
        setStyle(0, R.style.au9);
    }

    private void b() {
        Timer timer = this.I;
        if (timer != null) {
            timer.cancel();
            this.I = null;
        }
        TimerTask timerTask = this.J;
        if (timerTask != null) {
            timerTask.cancel();
            this.J = null;
        }
    }

    private void e() {
        if (this.I == null) {
            this.I = new BaseTimer();
        }
        if (this.J == null) {
            this.J = new TimerTask() { // from class: com.tencent.now.app.music.widget.AudioVolumeSettingDialog.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    AudioVolumeSettingDialog.this.dismiss();
                }
            };
        }
        this.I.schedule(this.J, 5000L);
    }

    private void f(int i3) {
        boolean z16;
        boolean z17;
        if (i3 == R.id.t6k) {
            if (this.E == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 != this.G) {
                if (z17) {
                    this.C.setBackgroundResource(R.drawable.nld);
                    UIUtil.f(R.string.zd6, false, 1);
                } else {
                    this.C.setBackgroundResource(R.drawable.nlc);
                }
                this.G = z17;
                return;
            }
            return;
        }
        if (i3 == R.id.f1201678t) {
            if (this.F == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 != this.H) {
                if (z16) {
                    this.D.setBackgroundResource(R.drawable.nlb);
                    UIUtil.f(R.string.f238457jt, false, 1);
                } else {
                    this.D.setBackgroundResource(R.drawable.nla);
                }
                this.H = z16;
            }
        }
    }

    private void g(TextView textView, int i3) {
        int i16 = ((int) ((i3 / 100.0f) * this.K)) + this.Q;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i16;
        textView.setLayoutParams(layoutParams);
        textView.setText(i3 + "%");
    }

    public void c(int i3) {
        this.f338086e = i3;
    }

    public void d(MusicPlayMgr musicPlayMgr) {
        this.S = musicPlayMgr;
    }

    @Override // cm3.a, android.app.DialogFragment, android.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        int i3;
        super.onCreate(bundle);
        this.R = b.b().getUid();
        this.E = com.tencent.hy.common.store.a.c("bgm_vol_key" + this.R, 50);
        this.F = com.tencent.hy.common.store.a.c("voice_vol_key" + this.R, 50);
        this.M = com.tencent.misc.utils.a.b(b.d(), 72.0f);
        this.N = com.tencent.misc.utils.a.b(b.d(), 32.0f);
        this.L = com.tencent.misc.utils.a.b(b.d(), 37.0f);
        int b16 = com.tencent.misc.utils.a.b(b.d(), 16.0f);
        this.P = b16;
        this.Q = (b16 / 2) - (this.L / 2);
        this.K = ((com.tencent.misc.utils.a.c(getActivity()) - this.P) - this.M) - this.N;
        e();
        if (this.S != null) {
            dm3.a b17 = new dm3.a().e("add_music").d("enter_sound_page").a("obj1", this.S.t()).b("obj2", this.E + "%," + this.D + "%");
            if (this.f338086e == 0) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            b17.a("res2", i3).c();
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.e_y, viewGroup, false);
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.t6k);
        this.f338087f = seekBar;
        seekBar.setProgress(this.E);
        this.f338087f.setOnSeekBarChangeListener(this);
        this.f338089i = (TextView) inflate.findViewById(R.id.t6m);
        this.C = inflate.findViewById(R.id.t6l);
        SeekBar seekBar2 = (SeekBar) inflate.findViewById(R.id.f1201678t);
        this.f338088h = seekBar2;
        seekBar2.setProgress(this.F);
        this.f338088h.setOnSeekBarChangeListener(this);
        this.f338090m = (TextView) inflate.findViewById(R.id.f1201878v);
        this.D = inflate.findViewById(R.id.f1201778u);
        com.tencent.misc.utils.b.a(this.f338089i);
        com.tencent.misc.utils.b.a(this.f338090m);
        f(R.id.t6k);
        f(R.id.f1201678t);
        FragmentCollector.onFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // cm3.a, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.hy.common.store.a.h("bgm_vol_key" + this.R, this.E);
        com.tencent.hy.common.store.a.h("voice_vol_key" + this.R, this.F);
    }

    @Override // cm3.a, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        b();
        if (this.S != null) {
            new dm3.a().e("add_music").d("comeout_sound_page ").a("obj1", this.S.t()).b("obj2", this.E + "%," + this.D + "%").c();
        }
        EventCenter.post(new com.tencent.misc.widget.a(0, Boolean.FALSE));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        b();
        if (seekBar.getId() == R.id.t6k) {
            this.E = i3;
            this.f338087f.setProgress(i3);
            g(this.f338089i, i3);
            MusicPlayMgr musicPlayMgr = this.S;
            if (musicPlayMgr != null) {
                musicPlayMgr.M(this.E);
                return;
            }
            return;
        }
        if (seekBar.getId() == R.id.f1201678t) {
            this.F = i3;
            this.f338088h.setProgress(i3);
            g(this.f338090m, i3);
            MusicPlayMgr musicPlayMgr2 = this.S;
            if (musicPlayMgr2 != null) {
                musicPlayMgr2.L(this.F);
            }
        }
    }

    @Override // cm3.a, android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.f2435312);
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = AppUtils.UI.dip2px(208.0f);
        window.setAttributes(attributes);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (seekBar.getId() == R.id.t6k) {
            if (this.f338089i.getVisibility() != 0) {
                this.f338089i.setVisibility(0);
            }
        } else if (seekBar.getId() == R.id.f1201678t && this.f338090m.getVisibility() != 0) {
            this.f338090m.setVisibility(0);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        int i3 = 0;
        if (seekBar.getId() == R.id.t6k) {
            this.f338089i.setVisibility(4);
            dm3.a d16 = new dm3.a().e("add_music").d("move_musicbar");
            if (this.f338086e != 0) {
                i3 = 4;
            }
            d16.a("res2", i3).c();
        } else if (seekBar.getId() == R.id.f1201678t) {
            this.f338090m.setVisibility(4);
            dm3.a d17 = new dm3.a().e("add_music").d("move_voicebar");
            if (this.f338086e != 0) {
                i3 = 4;
            }
            d17.a("res2", i3).c();
        }
        f(seekBar.getId());
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }
}
