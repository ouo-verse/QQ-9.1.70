package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.music.QQMusicDownloader;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.aioeditor.takevideo.x;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends u {
    private qs.e C;
    private final AudioPlayerBase.b D;

    /* renamed from: d, reason: collision with root package name */
    private QzoneVerticalVideoTopicInfo f66453d;

    /* renamed from: e, reason: collision with root package name */
    private View f66454e;

    /* renamed from: f, reason: collision with root package name */
    private AudioPlayer f66455f;

    /* renamed from: h, reason: collision with root package name */
    private MusicItemInfo f66456h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f66457i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f66458m;

    public i(QzEditVideoPartManager qzEditVideoPartManager, QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo) {
        super(qzEditVideoPartManager);
        this.C = new a();
        this.D = new b();
        this.f66453d = qzoneVerticalVideoTopicInfo;
    }

    private void p0(MusicItemInfo musicItemInfo) {
        com.tencent.mobileqq.vip.g b16 = QQMusicDownloader.b(musicItemInfo.mUrl, musicItemInfo.getLocalPath(), this.C);
        if (b16 != null) {
            QQMusicDownloader.c(b16, this.C);
        }
    }

    private void q0() {
        if (this.f66455f == null) {
            AudioPlayer audioPlayer = new AudioPlayer(getContext(), this.D);
            this.f66455f = audioPlayer;
            audioPlayer.B(3);
        }
    }

    private void r0() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bkf, (ViewGroup) null);
        this.f66454e = inflate;
        ((TextView) inflate.findViewById(R.id.kbk)).setText(this.f66453d.getDescName());
        URLImageView uRLImageView = (URLImageView) this.f66454e.findViewById(R.id.dwp);
        if (!TextUtils.isEmpty(this.f66453d.getThumbImgUrl())) {
            uRLImageView.setBackgroundURL(this.f66453d.getThumbImgUrl());
        } else {
            uRLImageView.setVisibility(8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewSure(R.id.rsr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BaseAIOUtils.f(110.0f, getResources());
        layoutParams.leftMargin = BaseAIOUtils.f(10.0f, getResources());
        relativeLayout.addView(this.f66454e, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(MusicItemInfo musicItemInfo) {
        if (this.f66458m) {
            return;
        }
        q0();
        if (this.f66455f == null || musicItemInfo == null || !o0(musicItemInfo)) {
            return;
        }
        this.f66455f.C(7);
        this.f66455f.u(musicItemInfo.getLocalPath());
    }

    private void t0() {
        if (this.f66453d.hasMusic()) {
            MusicItemInfo musicItemInfo = new MusicItemInfo();
            this.f66456h = musicItemInfo;
            musicItemInfo.mSongMid = this.f66453d.getMusicId();
            this.f66456h.mMusicName = this.f66453d.getMusicName();
            this.f66456h.mUrl = this.f66453d.getMusicUrl();
            this.f66456h.mType = 1;
            x xVar = (x) this.mParent.R(x.class);
            if (xVar != null) {
                xVar.K(true);
            }
            if (o0(this.f66456h)) {
                this.f66457i = true;
            } else {
                p0(this.f66456h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        if (this.f66458m) {
            return;
        }
        this.mParent.s(Message.obtain(null, 3, 1, 0));
        v0();
        s0(this.f66456h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        AudioPlayer audioPlayer = this.f66455f;
        if (audioPlayer != null) {
            audioPlayer.stop();
            this.f66455f = null;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        MusicItemInfo musicItemInfo = this.f66456h;
        if (musicItemInfo == null || TextUtils.isEmpty(musicItemInfo.getLocalPath())) {
            return;
        }
        bVar.f400387d.backgroundMusicPath = this.f66456h.getLocalPath();
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        publishVideoEntry.isMuteRecordVoice = true;
        MusicItemInfo musicItemInfo2 = this.f66456h;
        publishVideoEntry.backgroundMusicOffset = musicItemInfo2.musicStart;
        publishVideoEntry.backgroundMusicDuration = (int) ShortVideoUtils.a(musicItemInfo2.getLocalPath());
        PublishVideoEntry publishVideoEntry2 = bVar.f400387d;
        if (publishVideoEntry2.backgroundMusicDuration <= 0) {
            publishVideoEntry2.backgroundMusicPath = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        if (message.what == 14) {
            v0();
            s0(this.f66456h);
        }
        return super.handleEditVideoMessage(message);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        r0();
        t0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends qs.e {
        a() {
        }

        @Override // qs.e
        public void c(String str, boolean z16, int i3) {
            if (z16) {
                i.this.f66457i = true;
                i.this.u0();
            } else {
                QLog.i("EditPicQzComment", 2, "download music fail" + i3);
            }
        }

        @Override // qs.e
        public void b(String str) {
        }

        @Override // qs.e
        public void d(int i3) {
        }

        @Override // qs.e
        public void e(String str, int i3) {
        }

        @Override // qs.e
        public void f(String str, boolean z16) {
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onPause() {
        this.f66458m = true;
        super.onPause();
        v0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        this.f66458m = false;
        super.onResume();
        if (this.f66457i) {
            u0();
        }
    }

    private boolean o0(MusicItemInfo musicItemInfo) {
        if (musicItemInfo == null) {
            return false;
        }
        int i3 = musicItemInfo.mType;
        return !(i3 == 5 || i3 == 1) || FileUtils.fileExistsAndNotEmpty(musicItemInfo.getLocalPath());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 == 0) {
            View view = this.f66454e;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        if (i3 != 1) {
            View view2 = this.f66454e;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.f66454e;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements AudioPlayerBase.b {
        b() {
        }

        @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
        public void W8(AudioPlayerBase audioPlayerBase, String str) {
            i.this.v0();
            i iVar = i.this;
            iVar.s0(iVar.f66456h);
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
