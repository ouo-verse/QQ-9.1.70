package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.VideoView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Activity f185822a;

    /* renamed from: b, reason: collision with root package name */
    private FixedSizeVideoView f185823b;

    /* renamed from: c, reason: collision with root package name */
    private ImageButton f185824c;

    /* renamed from: d, reason: collision with root package name */
    private QQProgressDialog f185825d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Dialog> f185826e;

    /* renamed from: f, reason: collision with root package name */
    private long f185827f;

    /* renamed from: g, reason: collision with root package name */
    private long f185828g;

    /* renamed from: h, reason: collision with root package name */
    private long f185829h;

    /* renamed from: i, reason: collision with root package name */
    private String f185830i;

    /* renamed from: j, reason: collision with root package name */
    private AudioPlayer f185831j;

    /* renamed from: n, reason: collision with root package name */
    private QzoneVerticalVideoTopicInfo f185835n;

    /* renamed from: o, reason: collision with root package name */
    private DialogInterface.OnShowListener f185836o;

    /* renamed from: p, reason: collision with root package name */
    private DialogInterface.OnDismissListener f185837p;

    /* renamed from: l, reason: collision with root package name */
    private int f185833l = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f185834m = false;

    /* renamed from: q, reason: collision with root package name */
    private final AudioPlayerBase.b f185838q = new a();

    /* renamed from: r, reason: collision with root package name */
    private final P2VEditMusicDialog.c f185839r = new C7203b();

    /* renamed from: k, reason: collision with root package name */
    private jd0.d f185832k = p();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.richmedia.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7203b implements P2VEditMusicDialog.c {
        C7203b() {
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public void a() {
            b.this.A(false);
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public boolean b() {
            if (b.this.f185835n != null && b.this.f185835n.hasMusic()) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public void c() {
            QZLog.d("EditLocalVideoMusicMixe", 2, "onStopCurFragmentMusic: ");
            b.this.f185833l = 0;
            b.this.F(false);
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public boolean d() {
            return false;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public void e(String str) {
            QZLog.d("EditLocalVideoMusicMixe", 2, "onGetCurFragmentMusicPath: " + str);
            if (b.this.f185832k != null) {
                b.this.f185832k.f409846j = str;
            }
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public void f(jd0.d dVar) {
            if (dVar == null) {
                b.this.F(false);
            } else {
                QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeCurFragmentMusic: " + dVar.d() + " " + dVar.f409847k + " to " + dVar.f409848l);
                int i3 = dVar.f409844h;
                if (i3 == 0) {
                    b.this.F(false);
                    b.this.A(true);
                } else if (i3 == 1) {
                    b.this.F(false);
                    b.this.A(false);
                }
            }
            b.this.f185832k = dVar;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public jd0.d g() {
            if (b.this.f185832k != null) {
                QZLog.d("EditLocalVideoMusicMixe", 2, "getCurFragmentMusic: " + b.this.f185832k.d());
            }
            return b.this.f185832k;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public boolean h() {
            return true;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public void i() {
            QZLog.d("EditLocalVideoMusicMixe", 2, "onPauseCurFragmentMusic: ");
            if (b.this.f185831j != null) {
                b bVar = b.this;
                bVar.f185833l = bVar.f185831j.m();
            }
            b.this.F(true);
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public void j(int i3) {
            QZLog.d("EditLocalVideoMusicMixe", 2, "onChangeMusicBtnType: " + i3);
            if (b.this.f185824c != null) {
                if (i3 == 0) {
                    b.this.f185824c.setImageResource(R.drawable.ff8);
                } else if (i3 == 3) {
                    b.this.f185824c.setImageResource(R.drawable.ff7);
                } else {
                    b.this.f185824c.setImageResource(R.drawable.f161985ff2);
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.c
        public void k() {
            QZLog.d("EditLocalVideoMusicMixe", 2, "onPlayCurFragmentMusic: ");
            b.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f185842a;

        c(d dVar) {
            this.f185842a = dVar;
        }

        @Override // com.tencent.mobileqq.activity.richmedia.b.d
        public void a() {
            b.this.f185825d = new QQProgressDialog(b.this.f185822a, b.this.f185822a.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            b.this.f185825d.setMessage(R.string.gil);
            b.this.f185825d.setCancelable(false);
            b.this.f185825d.show();
            d dVar = this.f185842a;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // com.tencent.mobileqq.activity.richmedia.b.d
        public void b(String str) {
            if (b.this.f185825d != null) {
                b.this.f185825d.dismiss();
            }
            b.this.x(true);
            b.this.F(false);
            d dVar = this.f185842a;
            if (dVar != null) {
                dVar.b(str);
            }
        }

        @Override // com.tencent.mobileqq.activity.richmedia.b.d
        public void c() {
            if (b.this.f185825d != null) {
                b.this.f185825d.dismiss();
            }
            b.this.F(false);
            d dVar = this.f185842a;
            if (dVar != null) {
                dVar.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface d {
        void a();

        void b(String str);

        void c();
    }

    b(Activity activity, FixedSizeVideoView fixedSizeVideoView, ImageButton imageButton, QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo) {
        this.f185822a = activity;
        this.f185823b = fixedSizeVideoView;
        this.f185824c = imageButton;
        this.f185835n = qzoneVerticalVideoTopicInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z16) {
        float f16;
        if (this.f185823b != null) {
            try {
                Field declaredField = VideoView.class.getDeclaredField("mMediaPlayer");
                declaredField.setAccessible(true);
                MediaPlayer mediaPlayer = (MediaPlayer) declaredField.get(this.f185823b);
                if (mediaPlayer != null) {
                    float f17 = 0.0f;
                    if (z16) {
                        f16 = 0.0f;
                    } else {
                        f16 = 1.0f;
                    }
                    if (!z16) {
                        f17 = 1.0f;
                    }
                    mediaPlayer.setVolume(f16, f17);
                }
            } catch (IllegalAccessException e16) {
                QZLog.e("EditLocalVideoMusicMixe", 2, e16, new Object[0]);
            } catch (NoSuchFieldException e17) {
                QZLog.e("EditLocalVideoMusicMixe", 2, e17, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B() {
        if (this.f185832k != null && o() - this.f185832k.f409849m > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.f185831j == null) {
            AudioPlayer audioPlayer = new AudioPlayer(this.f185822a, this.f185838q);
            this.f185831j = audioPlayer;
            audioPlayer.B(3);
        }
        jd0.d dVar = this.f185832k;
        if (dVar != null) {
            if (!TextUtils.isEmpty(dVar.f409846j)) {
                this.f185831j.C(11);
                AudioPlayer audioPlayer2 = this.f185831j;
                jd0.d dVar2 = this.f185832k;
                String str = dVar2.f409846j;
                int i3 = this.f185833l;
                if (i3 == 0) {
                    i3 = dVar2.f409847k;
                }
                audioPlayer2.A(str, i3);
                this.f185822a.sendBroadcast(new Intent("action_music_start"));
                A(true);
                return;
            }
            QZLog.e("EditLocalVideoMusicMixe", 2, "startAudioPlayback: music not downloaded " + this.f185832k.f409840d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z16) {
        int i3;
        AudioPlayer audioPlayer = this.f185831j;
        if (audioPlayer != null) {
            if (z16) {
                i3 = audioPlayer.m();
            } else {
                i3 = 0;
            }
            this.f185833l = i3;
            if (this.f185832k == null) {
                A(false);
            }
            this.f185831j.stop();
            this.f185831j = null;
        }
    }

    public static b n(Activity activity, FixedSizeVideoView fixedSizeVideoView, QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo, ImageButton imageButton) {
        return new b(activity, fixedSizeVideoView, imageButton, qzoneVerticalVideoTopicInfo);
    }

    private long o() {
        return this.f185828g - this.f185827f;
    }

    private jd0.d p() {
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = this.f185835n;
        if (qzoneVerticalVideoTopicInfo != null && qzoneVerticalVideoTopicInfo.hasMusic()) {
            jd0.d dVar = new jd0.d();
            dVar.f409840d = this.f185835n.getMusicUrl();
            dVar.f409837a = this.f185835n.getTopicId();
            dVar.f409838b = this.f185835n.getMusicName();
            dVar.f409844h = 3;
            return dVar;
        }
        return null;
    }

    public boolean C() {
        int i3;
        jd0.d dVar = this.f185832k;
        if (dVar != null && (((i3 = dVar.f409844h) == 0 || i3 == 3 || i3 == 2) && !this.f185834m)) {
            return true;
        }
        return false;
    }

    public void D() {
        P2VEditMusicDialog p2VEditMusicDialog = new P2VEditMusicDialog(this.f185822a, this.f185839r, (int) o(), true);
        DialogInterface.OnDismissListener onDismissListener = this.f185837p;
        if (onDismissListener != null) {
            p2VEditMusicDialog.setOnDismissListener(onDismissListener);
        }
        DialogInterface.OnShowListener onShowListener = this.f185836o;
        if (onShowListener != null) {
            p2VEditMusicDialog.setOnShowListener(onShowListener);
        }
        p2VEditMusicDialog.setCanceledOnTouchOutside(false);
        p2VEditMusicDialog.show();
        this.f185826e = new WeakReference<>(p2VEditMusicDialog);
    }

    public void G(long j3, String str) {
        H(0, (int) j3);
        this.f185829h = j3;
        this.f185830i = str;
    }

    public void H(int i3, int i16) {
        if (i16 - i3 > 0) {
            this.f185827f = i3;
            this.f185828g = i16;
            Log.d("EditLocalVideoMusicMixe", "updateVideoFrameClippedRange: " + i3 + " " + i16);
            return;
        }
        Log.w("EditLocalVideoMusicMixe", "updateVideoFrameClippedRange: duration less or equal than zero " + i16 + " " + i3);
    }

    public void q() {
        F(false);
    }

    public void r() {
        F(true);
    }

    public void s() {
        E();
    }

    public void t() {
        F(false);
        E();
    }

    public boolean u() {
        WeakReference<Dialog> weakReference = this.f185826e;
        if (weakReference != null && weakReference.get() != null && this.f185826e.get().isShowing()) {
            return true;
        }
        return false;
    }

    public void v(d dVar) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new EditLocalVideoMusicMixRunnable(this.f185827f, this.f185828g, this.f185829h, this.f185830i, this.f185832k, new c(dVar)));
    }

    public void w(long j3) {
        if (this.f185832k != null) {
            new P2VEditMusicDialog(this.f185822a, this.f185839r, (int) j3, true);
        }
    }

    public void x(boolean z16) {
        this.f185834m = z16;
    }

    public void y(DialogInterface.OnDismissListener onDismissListener) {
        this.f185837p = onDismissListener;
    }

    public void z(DialogInterface.OnShowListener onShowListener) {
        this.f185836o = onShowListener;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements AudioPlayerBase.b {
        a() {
        }

        @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
        public void W8(AudioPlayerBase audioPlayerBase, String str) {
            if (b.this.B()) {
                b.this.F(false);
                b.this.E();
            }
        }

        @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
        public void f9(AudioPlayerBase audioPlayerBase, String str) {
        }

        @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
        public void Tg(AudioPlayerBase audioPlayerBase, int i3, String str) {
        }

        @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
        public void V3(AudioPlayerBase audioPlayerBase, int i3, String str) {
        }

        @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
        public void j5(AudioPlayerBase audioPlayerBase, int i3, String str) {
        }

        @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
        public void k9(AudioPlayerBase audioPlayerBase, int i3, String str) {
        }
    }
}
