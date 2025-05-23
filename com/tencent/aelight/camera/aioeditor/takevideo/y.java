package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class y extends u {
    private double C;
    private long D;
    private HWEditLocalVideoPlayer E;
    private com.tencent.aelight.camera.aioeditor.capture.music.g F;
    private int G;
    private int H;

    /* renamed from: d, reason: collision with root package name */
    private QzEditVideoPartManager f68968d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f68969e;

    /* renamed from: f, reason: collision with root package name */
    private RotationSeekBar f68970f;

    /* renamed from: h, reason: collision with root package name */
    private ImageButton f68971h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f68972i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f68973m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (y.this.E != null) {
                if (y.this.E.w0() == 1 && y.this.H == 1) {
                    y.this.pause();
                    y.this.f68971h.setImageResource(R.drawable.f162190fx1);
                    y.this.H = 2;
                } else if (y.this.E.w0() == 2 && y.this.H == 2) {
                    y.this.s0();
                    y.this.f68971h.setImageResource(R.drawable.f162191fx2);
                    y.this.H = 1;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public y(QzEditVideoPartManager qzEditVideoPartManager) {
        super(qzEditVideoPartManager);
        this.C = 1.0d;
        this.D = -1L;
        this.G = -1;
        this.H = 0;
        this.f68968d = qzEditVideoPartManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pause() {
        HWEditLocalVideoPlayer hWEditLocalVideoPlayer = this.E;
        if (hWEditLocalVideoPlayer != null) {
            hWEditLocalVideoPlayer.pause();
        }
        com.tencent.aelight.camera.aioeditor.capture.music.g gVar = this.F;
        if (gVar != null) {
            gVar.q();
        }
    }

    private void q0() {
        HWEditLocalVideoPlayer hWEditLocalVideoPlayer;
        if (this.D >= 0 || (hWEditLocalVideoPlayer = this.f68968d.f67800r0) == null || hWEditLocalVideoPlayer.v0() == null) {
            return;
        }
        this.D = this.f68968d.f67800r0.v0().mDuration;
        this.E = this.f68968d.f67800r0;
        this.F = (com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.d().g(8);
        if (this.E.w0() == 1 && this.H != 1) {
            this.f68971h.setImageResource(R.drawable.f162191fx2);
            this.H = 1;
        } else {
            if (this.E.w0() != 2 || this.H == 2) {
                return;
            }
            this.f68971h.setImageResource(R.drawable.f162190fx1);
            this.H = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        HWEditLocalVideoPlayer hWEditLocalVideoPlayer = this.E;
        if (hWEditLocalVideoPlayer != null) {
            hWEditLocalVideoPlayer.play();
        }
        com.tencent.aelight.camera.aioeditor.capture.music.g gVar = this.F;
        if (gVar != null) {
            gVar.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        int i3 = message.what;
        if (i3 != 9) {
            if (i3 == 13) {
                if (this.f68968d.G0) {
                    q0();
                    if (this.D > 0) {
                        long longValue = ((Long[]) message.obj)[0].longValue();
                        if (this.C > 0.0d) {
                            int i16 = (int) ((100 * longValue) / this.D);
                            int i17 = this.G;
                            if (i16 < i17 && i17 < 95 && i16 > 5) {
                                QLog.d("EditVideo - progressBar", 2, "progress = " + i17 + "\uff1blastProgress = " + this.G + "; need to reset");
                                i16 = i17;
                            } else {
                                this.G = i16;
                            }
                            this.f68970f.setProgress(i16);
                            this.f68972i.setText(r0((long) (longValue * this.C)));
                            this.f68973m.setText(r0((long) (this.D * this.C)));
                        } else {
                            long j3 = this.D;
                            this.f68970f.setProgress((int) (((j3 - longValue) * 100) / j3));
                            this.f68972i.setText(r0(this.D - longValue));
                            this.f68973m.setText(r0(this.D));
                        }
                    }
                    if (this.E.w0() == 1 && this.H != 1) {
                        this.f68971h.setImageResource(R.drawable.f162191fx2);
                        this.H = 1;
                    } else if (this.E.w0() == 2 && this.H != 2) {
                        this.f68971h.setImageResource(R.drawable.f162190fx1);
                        this.H = 2;
                    }
                }
                return true;
            }
        } else if (message.arg1 == 12) {
            int i18 = message.arg2;
            if (i18 == 0) {
                this.C = 0.25d;
            } else if (i18 == 1) {
                this.C = 0.5d;
            } else if (i18 == 2) {
                this.C = 1.0d;
            } else if (i18 == 3) {
                this.C = 2.0d;
            } else if (i18 == 4) {
                this.C = 4.0d;
            } else if (i18 == 5) {
                this.C = -1.0d;
            }
        }
        return super.handleEditVideoMessage(message);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        p0();
        this.f68970f = (RotationSeekBar) findViewSure(R.id.f165040br3);
        this.f68971h = (ImageButton) findViewSure(R.id.f165041br4);
        this.f68972i = (TextView) findViewSure(R.id.br5);
        this.f68973m = (TextView) findViewSure(R.id.f165039br2);
        this.f68971h.setOnClickListener(new a());
        this.f68970f.setEnabled(true);
    }

    private static String r0(long j3) {
        long j16 = j3 / 1000;
        return String.format("%02d:%02d", Long.valueOf(j16 / 60), Long.valueOf(j16 % 60));
    }

    private void p0() {
        int f16;
        RelativeLayout relativeLayout = (RelativeLayout) findViewSure(R.id.rsr);
        this.f68969e = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.bkc, (ViewGroup) relativeLayout, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(40.0f, getResources()));
        this.f68969e.setVisibility(this.f68968d.G0 ? 0 : 8);
        layoutParams.addRule(12);
        int i3 = LiuHaiUtils.BOTTOM_HEIGHT;
        if (i3 > 0) {
            f16 = i3 + BaseAIOUtils.f(40.0f, getResources());
        } else {
            f16 = BaseAIOUtils.f(100.0f, getResources());
        }
        layoutParams.bottomMargin = f16;
        relativeLayout.addView(this.f68969e, layoutParams);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 != 0) {
            this.f68969e.setVisibility(8);
        } else if (this.f68968d.G0) {
            this.f68969e.setVisibility(0);
        } else {
            this.f68969e.setVisibility(8);
        }
    }
}
