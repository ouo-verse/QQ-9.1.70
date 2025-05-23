package com.tencent.aelight.camera.aioeditor.musicwavesupport;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filter.music.a;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class MusicWaveformManager {

    /* renamed from: a, reason: collision with root package name */
    private boolean f67443a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.filter.music.a f67444b;

    /* renamed from: c, reason: collision with root package name */
    private MusicItemInfo f67445c;

    /* renamed from: d, reason: collision with root package name */
    private int f67446d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f67447e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f67448f = false;

    /* renamed from: g, reason: collision with root package name */
    private a.InterfaceC7597a f67449g = new a();

    /* renamed from: h, reason: collision with root package name */
    private Runnable f67450h = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.musicwavesupport.MusicWaveformManager.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                boolean a16 = MusicWaveformManager.this.f67444b.a(MusicWaveformManager.this.f67445c, MusicWaveformManager.this.f67449g, MusicWaveformManager.this.f67446d);
                if (QLog.isColorLevel()) {
                    QLog.d("MusicWaveformManager", 2, "createSoundFile time: " + ((SystemClock.elapsedRealtimeNanos() - elapsedRealtimeNanos) / 1000000) + "ms");
                }
                if (a16) {
                    return;
                }
                MusicWaveformManager.this.f67447e = false;
                if (QLog.isColorLevel()) {
                    QLog.e("MusicWaveformManager", 2, "create musicSoundFile fail");
                }
            } catch (Exception e16) {
                MusicWaveformManager.this.f67447e = false;
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("MusicWaveformManager", 2, e16.toString());
                }
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements a.InterfaceC7597a {
        a() {
        }

        @Override // com.tencent.mobileqq.filter.music.a.InterfaceC7597a
        public boolean a(double d16) {
            return MusicWaveformManager.this.f67443a;
        }
    }

    public static boolean h() {
        CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equals(Build.MANUFACTURER);
        return false;
    }

    private void i() {
        this.f67444b = new com.tencent.mobileqq.filter.music.a();
        this.f67443a = true;
        ThreadManagerV2.postImmediately(this.f67450h, null, true);
    }

    public float g(int i3) {
        com.tencent.mobileqq.filter.music.a aVar;
        int i16;
        boolean z16 = this.f67447e;
        if (z16 && this.f67448f) {
            return 0.5f;
        }
        if (!z16 || (aVar = this.f67444b) == null || !aVar.f209774f || i3 < (i16 = this.f67446d)) {
            return -1.0f;
        }
        return aVar.b(i3 - i16);
    }

    public void k() {
        if (this.f67447e) {
            this.f67443a = false;
            if (this.f67444b != null) {
                this.f67444b = null;
            }
            this.f67447e = false;
        }
    }

    public void j(MusicItemInfo musicItemInfo, int i3) {
        if (musicItemInfo == null) {
            k();
            return;
        }
        if (this.f67447e) {
            if (musicItemInfo.equals(this.f67445c) && this.f67446d <= i3) {
                int i16 = musicItemInfo.musicStart;
                MusicItemInfo musicItemInfo2 = this.f67445c;
                if (i16 == musicItemInfo2.musicStart && musicItemInfo.musicEnd == musicItemInfo2.musicEnd) {
                    return;
                }
            }
            k();
        }
        this.f67447e = true;
        this.f67445c = musicItemInfo.copy();
        this.f67444b = null;
        this.f67446d = i3;
        if (h()) {
            this.f67448f = true;
            if (QLog.isColorLevel()) {
                QLog.e("MusicWaveformManager", 2, "musicSoundFile create give up, is rubbish Meizu");
                return;
            }
            return;
        }
        i();
    }
}
