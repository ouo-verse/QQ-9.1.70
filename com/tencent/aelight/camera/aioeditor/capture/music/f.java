package com.tencent.aelight.camera.aioeditor.capture.music;

import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends qs.e {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, MusicItemInfo> f66791a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.mobileqq.vip.g> f66792b;

    /* renamed from: c, reason: collision with root package name */
    private qs.e f66793c;

    public f(ConcurrentHashMap<String, MusicItemInfo> concurrentHashMap, ConcurrentHashMap<String, com.tencent.mobileqq.vip.g> concurrentHashMap2, qs.e eVar) {
        this.f66791a = concurrentHashMap;
        this.f66792b = concurrentHashMap2;
        this.f66793c = eVar;
    }

    @Override // qs.e
    public void b(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicDownloadListener", 2, "onCancel key=" + str);
        }
        MusicItemInfo musicItemInfo = this.f66791a.get(str);
        if (musicItemInfo != null) {
            musicItemInfo.mProgress = -1;
        }
        this.f66791a.remove(str);
        this.f66792b.remove(str);
        this.f66793c.b(str);
        com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo).h();
    }

    @Override // qs.e
    public void c(String str, boolean z16, int i3) {
        MusicItemInfo musicItemInfo = this.f66791a.get(str);
        if (QLog.isColorLevel()) {
            QLog.d("QQMusicDownloadListener", 2, "onFinish, info:", musicItemInfo);
        }
        if (musicItemInfo != null) {
            if (z16) {
                musicItemInfo.mProgress = 100;
                com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo).i();
                if (musicItemInfo.isMyMusicInfo() && musicItemInfo.fileSize > 0) {
                    File file = new File(str);
                    if (file.length() != musicItemInfo.fileSize) {
                        musicItemInfo.mProgress = -1;
                        com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo).h();
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQMusicDownloadListener", 2, "file.length =" + file.length() + " info.fileSize=" + musicItemInfo.fileSize);
                    }
                }
            } else {
                musicItemInfo.mProgress = -1;
                com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo).h();
            }
        }
        this.f66791a.remove(str);
        this.f66792b.remove(str);
        this.f66793c.c(str, z16, i3);
    }

    @Override // qs.e
    public void d(int i3) {
        this.f66793c.d(i3);
    }

    @Override // qs.e
    public void e(String str, int i3) {
        MusicItemInfo musicItemInfo = this.f66791a.get(str);
        if (musicItemInfo != null) {
            if (i3 == 100 && this.f66792b.contains(musicItemInfo.getLocalPath())) {
                i3 = 99;
            }
            musicItemInfo.mProgress = i3;
        }
        this.f66793c.e(str, i3);
    }

    @Override // qs.e
    public void f(String str, boolean z16) {
        MusicItemInfo musicItemInfo = this.f66791a.get(str);
        if (musicItemInfo != null) {
            if (!z16) {
                com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo).h();
                musicItemInfo.mProgress = -1;
                this.f66791a.remove(str);
                this.f66792b.remove(str);
            } else {
                musicItemInfo.mProgress = 1;
            }
        }
        this.f66793c.f(str, z16);
    }
}
