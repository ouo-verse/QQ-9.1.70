package com.tencent.aelight.camera.aioeditor.capture.music;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends com.tencent.aelight.camera.aioeditor.capture.data.a {
    int C;
    qs.e D;

    /* renamed from: m, reason: collision with root package name */
    public MusicItemInfo f66784m;

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("QCombo.Music", 2, "applyMusic" + this.f66784m);
        }
        if (this.f66784m == null) {
            return 0;
        }
        ((MusicProviderView) activity.findViewById(R.id.apn)).N(this.f66784m);
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int h() {
        MusicItemInfo musicItemInfo = this.f66784m;
        if (musicItemInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.i("MusicProviderView.Downloader", 2, "download STATE_DOWNLOADED" + this.f66784m);
            }
            return 3;
        }
        if (musicItemInfo.mProgress > -1) {
            if (QLog.isColorLevel()) {
                QLog.i("MusicProviderView.Downloader", 2, "download mMusic.mProgress" + this.f66784m.mProgress);
            }
            return 1;
        }
        if (!FileUtils.fileExists(musicItemInfo.getLocalPath())) {
            if (QLog.isColorLevel()) {
                QLog.i("MusicProviderView.Downloader", 2, "download ." + this.f66784m.mProgress);
            }
            MusicItemInfo musicItemInfo2 = this.f66784m;
            musicItemInfo2.mProgress = 1;
            QimMusicDownloader.a(musicItemInfo2.mUrl, musicItemInfo2.getLocalPath(), this.D);
            l();
            return 2;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MusicProviderView.Downloader", 2, "STATE_DOWNLOADED ." + this.f66784m.mProgress);
        }
        return 3;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized float i() {
        return (this.f66784m.mProgress * 1.0f) / 100.0f;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int j() {
        MusicItemInfo musicItemInfo = this.f66784m;
        if (musicItemInfo == null) {
            return 3;
        }
        int i3 = musicItemInfo.mProgress;
        if (i3 > -1) {
            return i3 == 100 ? 3 : 1;
        }
        try {
            if (FileUtils.fileExists(musicItemInfo.getLocalPath())) {
                return 3;
            }
        } catch (Exception unused) {
        }
        return 2;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
        if (this.f66784m == null || i3 == 1 || i3 == 3) {
            return;
        }
        ((g) fr.f.d().g(8)).z(i3);
    }

    public String toString() {
        return "Music@" + this.C + "@" + this.f66784m + hashCode();
    }

    public a(int i3) {
        super(null);
        this.D = new C0578a();
        this.C = i3;
        this.f66784m = ((QIMMusicConfigManager) fr.f.c(2)).z(i3);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.capture.music.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0578a extends qs.e {
        C0578a() {
        }

        @Override // qs.e
        public void c(String str, boolean z16, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicDownloadListener", 2, "notifyDownloadFinish key: " + str + ", success " + z16);
            }
            synchronized (a.this) {
                if (z16) {
                    a aVar = a.this;
                    aVar.f66784m.mProgress = 100;
                    aVar.n();
                } else {
                    a aVar2 = a.this;
                    aVar2.f66784m.mProgress = -1;
                    aVar2.m(4);
                }
            }
        }

        @Override // qs.e
        public void e(String str, int i3) {
            synchronized (a.this) {
                a.this.f66784m.mProgress = i3;
            }
        }

        @Override // qs.e
        public void b(String str) {
        }

        @Override // qs.e
        public void d(int i3) {
        }

        @Override // qs.e
        public void f(String str, boolean z16) {
        }
    }
}
