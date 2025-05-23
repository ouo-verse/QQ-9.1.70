package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AmrPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.SilkPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes20.dex */
public class VoicePlayer implements com.tencent.mobileqq.qqaudio.audioplayer.j {
    private boolean C;
    private boolean D;
    private Context E;
    private Runnable F;

    /* renamed from: d, reason: collision with root package name */
    private String f307367d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f307368e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqaudio.audioplayer.i f307369f;

    /* renamed from: h, reason: collision with root package name */
    private int f307370h;

    /* renamed from: i, reason: collision with root package name */
    private int f307371i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<a> f307372m;

    /* loaded from: classes20.dex */
    public interface a {
        void c5(String str, int i3, int i16);

        void ic(String str, int i3, int i16);

        void u4(int i3, String str, int i16);
    }

    public VoicePlayer(String str, Handler handler) {
        this(str, handler, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m() {
        com.tencent.mobileqq.qqaudio.audioplayer.i iVar = this.f307369f;
        if (iVar != null) {
            return iVar.getCurrentPosition();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        com.tencent.mobileqq.qqaudio.audioplayer.i iVar = this.f307369f;
        if (iVar != null) {
            return iVar.getDuration();
        }
        return 0;
    }

    private void q() {
        if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.VoicePlayer", 2, "onCompletion duration=" + n() + " current=" + m() + " enableEndBuffer=" + this.C + " thread=" + Thread.currentThread().getName());
        }
        if (this.C) {
            Handler handler = this.f307368e;
            if (handler != null) {
                this.f307370h = 7;
                handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.VoicePlayer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VoicePlayer.this.t(false);
                    }
                }, 500L);
                return;
            } else {
                t(false);
                return;
            }
        }
        t(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z16) {
        int i3 = 0;
        if (this.D) {
            QQAudioUtils.i(this.E, false);
        }
        if (z16) {
            this.f307370h = 8;
        } else {
            this.f307370h = 4;
        }
        com.tencent.mobileqq.qqaudio.audioplayer.i iVar = this.f307369f;
        if (iVar != null) {
            if (this.f307370h == 4) {
                i3 = iVar.getDuration();
            }
            this.f307369f.release();
            this.f307369f = null;
        }
        Iterator<a> it = this.f307372m.iterator();
        while (it.hasNext()) {
            it.next().u4(this.f307370h, this.f307367d, i3);
        }
    }

    public void A() {
        int i3 = this.f307370h;
        if (i3 == 1) {
            try {
                this.f307370h = 2;
                if (this.f307371i != 1) {
                    this.f307369f.setDataSource(this.f307367d);
                    this.f307369f.prepare();
                }
                this.f307369f.d(this);
                this.f307369f.start();
            } catch (Exception e16) {
                e16.printStackTrace();
                t(true);
            }
            if (this.D) {
                QQAudioUtils.i(this.E, true);
            }
            QLog.d("Q.profilecard.VoicePlayer", 2, "start to play...  for test time=" + System.currentTimeMillis());
        } else if (i3 == 3) {
            this.f307370h = 2;
            this.f307369f.start();
            if (this.D) {
                QQAudioUtils.i(this.E, true);
            }
            QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
        }
        Handler handler = this.f307368e;
        if (handler != null) {
            handler.post(this.F);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.j
    public void a(com.tencent.mobileqq.qqaudio.audioplayer.i iVar, int i3, int i16, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.VoicePlayer", 2, "onError what=" + i3 + " extra=" + i16);
        }
        t(true);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.j
    public void b(String str) {
        q();
    }

    public void l(a aVar) {
        if (!this.f307372m.contains(aVar)) {
            this.f307372m.add(aVar);
        }
    }

    public String o() {
        return this.f307367d;
    }

    public int p() {
        return this.f307370h;
    }

    public boolean r() {
        com.tencent.mobileqq.qqaudio.audioplayer.i iVar = this.f307369f;
        if (iVar != null && (iVar instanceof SilkPlayer)) {
            return true;
        }
        return false;
    }

    public void s() {
        if (this.f307370h != 7) {
            if (this.D) {
                QQAudioUtils.i(this.E, false);
            }
            this.f307370h = 3;
            com.tencent.mobileqq.qqaudio.audioplayer.i iVar = this.f307369f;
            if (iVar != null) {
                iVar.pause();
            }
            Iterator<a> it = this.f307372m.iterator();
            while (it.hasNext()) {
                it.next().ic(this.f307367d, n(), m());
            }
        }
    }

    public void u() {
        com.tencent.mobileqq.qqaudio.audioplayer.i iVar = this.f307369f;
        if (iVar instanceof AmrPlayer) {
            this.f307370h = 2;
            ((AmrPlayer) iVar).h();
            if (this.D) {
                QQAudioUtils.i(this.E, true);
            }
            QLog.d("Q.profilecard.VoicePlayer", 2, "continue to play... for test time=" + System.currentTimeMillis());
            Handler handler = this.f307368e;
            if (handler != null) {
                handler.post(this.F);
            }
        }
    }

    public void v() {
        if (this.D) {
            QQAudioUtils.i(this.E, false);
        }
        this.f307370h = 6;
        com.tencent.mobileqq.qqaudio.audioplayer.i iVar = this.f307369f;
        if (iVar != null) {
            iVar.stop();
            this.f307369f.release();
            this.f307369f = null;
        }
    }

    public void w(int i3) {
        this.f307369f.seekTo(i3);
    }

    public void x(com.tencent.mobileqq.qqaudio.audioplayer.h hVar) {
        if (r()) {
            ((SilkPlayer) this.f307369f).w(hVar);
        }
    }

    public boolean y(Context context) {
        this.E = context;
        if (context != null) {
            this.D = true;
        }
        return this.D;
    }

    public boolean z() {
        if (this.f307368e == null) {
            this.C = false;
            return false;
        }
        this.C = true;
        return true;
    }

    public VoicePlayer(String str, Handler handler, int i3) {
        this.f307372m = new ArrayList<>();
        this.C = false;
        this.D = false;
        this.F = new Runnable() { // from class: com.tencent.mobileqq.utils.VoicePlayer.1

            /* renamed from: d, reason: collision with root package name */
            int f307373d = 0;

            @Override // java.lang.Runnable
            public void run() {
                if (VoicePlayer.this.f307370h != 4 && VoicePlayer.this.f307370h != 5 && VoicePlayer.this.f307370h != 6 && VoicePlayer.this.f307370h != 8) {
                    if (VoicePlayer.this.f307370h == 3) {
                        this.f307373d = VoicePlayer.this.m();
                        return;
                    }
                    if (VoicePlayer.this.f307369f != null) {
                        int n3 = VoicePlayer.this.n();
                        int m3 = VoicePlayer.this.m();
                        int i16 = this.f307373d;
                        if (m3 < i16) {
                            m3 = i16;
                        }
                        if (i16 != 0 && i16 == m3 && i16 > n3 - 200) {
                            QLog.d("Q.profilecard.VoicePlayer", 2, "change duration from " + m3 + " to " + m3);
                            n3 = m3;
                        }
                        if (m3 > this.f307373d) {
                            this.f307373d = m3;
                        }
                        Iterator it = VoicePlayer.this.f307372m.iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).c5(VoicePlayer.this.f307367d, n3, m3);
                        }
                        if (VoicePlayer.this.f307368e != null) {
                            VoicePlayer.this.f307368e.postDelayed(this, 50L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f307373d = 0;
            }
        };
        this.f307367d = str;
        this.f307368e = handler;
        if (i3 == 0) {
            this.f307369f = new AmrPlayer();
            this.f307371i = 2;
        } else {
            this.f307369f = new SilkPlayer();
            this.f307371i = 3;
        }
        this.f307370h = 1;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.j
    public void f() {
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.j
    public void onProgressChanged(int i3) {
    }
}
