package com.tencent.aelight.camera.aioeditor.capture.music;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.musicwavesupport.MusicWaveformManager;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends fr.e implements QQSpecialAVFilter.MusicWaveformSupporter {
    private boolean H;
    private boolean I;

    /* renamed from: d, reason: collision with root package name */
    private MusicItemInfo f66794d;

    /* renamed from: e, reason: collision with root package name */
    private MusicItemInfo f66795e;

    /* renamed from: f, reason: collision with root package name */
    private d f66796f;

    /* renamed from: m, reason: collision with root package name */
    private MusicPlayerScene f66799m;
    private int F = com.tencent.mobileqq.filter.f.f209751a;
    private volatile int G = 0;
    public ConcurrentHashMap<String, MusicItemInfo> C = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, com.tencent.mobileqq.vip.g> D = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Integer, MusicPlayerScene> f66797h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private List<e> f66798i = new ArrayList();
    private MusicWaveformManager E = new MusicWaveformManager();

    private void D() {
        if (this.f66799m != null) {
            F();
            this.f66799m.p();
        }
    }

    private void E(MusicItemInfo musicItemInfo) {
        if (this.f66796f == null || this.H) {
            return;
        }
        MusicItemInfo musicItemInfo2 = this.f66794d;
        if (musicItemInfo2 == null || musicItemInfo2.isMute() != musicItemInfo.isMute()) {
            this.f66796f.D(musicItemInfo.isMute());
        }
    }

    private synchronized MusicPlayerScene l(MusicItemInfo musicItemInfo) {
        MusicPlayerScene musicPlayerScene;
        int i3 = musicItemInfo.mType;
        if (i3 == 1) {
            musicPlayerScene = this.f66797h.get(1);
            if (musicPlayerScene == null) {
                musicPlayerScene = new MusicPlayerScene();
                musicPlayerScene.o(this.f66798i);
                this.f66797h.put(1, musicPlayerScene);
            }
            musicPlayerScene.i(musicItemInfo);
        } else if (i3 == 5) {
            musicPlayerScene = this.f66797h.get(2);
            if (musicPlayerScene == null) {
                musicPlayerScene = new QQMusicPlayerScene();
                musicPlayerScene.o(this.f66798i);
                this.f66797h.put(2, musicPlayerScene);
            }
            musicPlayerScene.i(musicItemInfo);
        } else {
            musicPlayerScene = null;
        }
        return musicPlayerScene;
    }

    public void A() {
        List<e> list;
        if (this.f66799m != null) {
            if (this.f66794d != null && (list = this.f66798i) != null) {
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    it.next().g(this.f66794d);
                }
            }
            this.f66799m.m();
            F();
        }
    }

    public void B(d dVar) {
        MusicItemInfo musicItemInfo;
        this.f66796f = dVar;
        if (this.H || (musicItemInfo = this.f66794d) == null || dVar == null) {
            return;
        }
        dVar.D(musicItemInfo.isMute());
    }

    public void C(int i3) {
        this.F = i3;
    }

    public void F() {
        MusicItemInfo j3 = j();
        if (j3 == null || this.E == null) {
            return;
        }
        QQFilterRenderManager b16 = com.tencent.mobileqq.filter.f.b(this.F);
        if (j3.needPlay() && n()) {
            this.E.j(j3, p() ? k() - j3.musicStart : 0);
            if (b16 != null) {
                b16.getBusinessOperation().setMusicWaveformSupporter(this);
                return;
            }
            return;
        }
        if (j3.needPlay() || n()) {
            this.E.k();
            if (b16 != null) {
                b16.getBusinessOperation().setMusicWaveformSupporter(null);
            }
        }
    }

    public void g(MusicItemInfo musicItemInfo) {
        com.tencent.mobileqq.vip.g gVar;
        ConcurrentHashMap<String, com.tencent.mobileqq.vip.g> concurrentHashMap = this.D;
        if (concurrentHashMap != null && (gVar = concurrentHashMap.get(musicItemInfo.getLocalPath())) != null) {
            QQMusicDownloader.a(gVar);
        }
        String localPath = musicItemInfo.getLocalPath();
        ConcurrentHashMap<String, MusicItemInfo> concurrentHashMap2 = this.C;
        if (concurrentHashMap2 != null && concurrentHashMap2.contains(localPath)) {
            this.C.remove(localPath);
        }
        musicItemInfo.mProgress = -1;
        com.tencent.aelight.camera.aioeditor.capture.view.c.c(musicItemInfo).h();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter
    public float getCurrentMusicGain() {
        MusicItemInfo j3 = j();
        if (j3 == null) {
            return -1.0f;
        }
        try {
            if (this.E != null && j3.needPlay() && p()) {
                return this.E.g(k() - j3.musicStart);
            }
            return -1.0f;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QimMusicPlayer", 2, "getCurrentMusicGain() error: " + e16.toString());
            }
            return -1.0f;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter
    public MusicItemInfo getMusicItemInfo() {
        MusicItemInfo j3 = j();
        if (j3 == null || !j3.needPlay()) {
            return null;
        }
        return j3.copy();
    }

    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("QimMusicPlayer", 2, "clearMusic ");
        }
        this.f66795e = null;
        this.f66794d = null;
        MusicPlayerScene musicPlayerScene = this.f66799m;
        if (musicPlayerScene != null) {
            musicPlayerScene.q();
        }
    }

    public MusicItemInfo j() {
        MusicItemInfo musicItemInfo = this.f66794d;
        if (musicItemInfo == null) {
            return null;
        }
        int i3 = musicItemInfo.mType;
        if (i3 == 5 || i3 == 1) {
            return musicItemInfo;
        }
        return null;
    }

    public int k() {
        if (p()) {
            return this.f66799m.h();
        }
        return -1;
    }

    public MusicItemInfo m() {
        return this.f66795e;
    }

    public boolean n() {
        QQFilterRenderManager b16 = com.tencent.mobileqq.filter.f.b(this.F);
        FilterDesc currentAVFilterIdByType = b16 != null ? b16.getBusinessOperation().getCurrentAVFilterIdByType(2) : null;
        return currentAVFilterIdByType != null && QQAVImageFilterConstants.isMusicSpecialFilter(currentAVFilterIdByType.f281357id);
    }

    public boolean o(MusicItemInfo musicItemInfo) {
        return this.I && k() != -1 && musicItemInfo.mSongMid.equals(j().mSongMid) && k() < musicItemInfo.musicDuration;
    }

    public boolean p() {
        MusicPlayerScene musicPlayerScene = this.f66799m;
        return musicPlayerScene != null && musicPlayerScene.j();
    }

    public void q() {
        MusicPlayerScene musicPlayerScene = this.f66799m;
        if (musicPlayerScene != null) {
            musicPlayerScene.k();
        }
    }

    public void r(int i3) {
        MusicPlayerScene musicPlayerScene;
        if (QLog.isColorLevel()) {
            QLog.d("QimMusicPlayer", 2, "pauseMusicCheckScene " + i3 + " " + this.G);
        }
        if (i3 == this.G && (musicPlayerScene = this.f66799m) != null) {
            musicPlayerScene.k();
        }
    }

    public void s(boolean z16) {
        this.H = z16;
    }

    public void t(e eVar) {
        List<e> list = this.f66798i;
        if (list == null || !list.contains(eVar)) {
            return;
        }
        this.f66798i.remove(eVar);
    }

    public boolean u(MusicItemInfo musicItemInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("QimMusicPlayer", 2, "replaceCurMusicInfoForFuturePlay");
        }
        if (!h(musicItemInfo)) {
            return false;
        }
        if (this.f66794d == musicItemInfo && p()) {
            QLog.i("QimMusicPlayer", 1, "have playing" + musicItemInfo);
            return false;
        }
        E(musicItemInfo);
        List<e> list = this.f66798i;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().g(musicItemInfo);
            }
        }
        i();
        this.f66794d = musicItemInfo;
        this.f66795e = musicItemInfo;
        this.f66799m = l(musicItemInfo);
        return true;
    }

    public boolean v(MusicItemInfo musicItemInfo, qs.e eVar) {
        if (h(musicItemInfo) || musicItemInfo == null) {
            return false;
        }
        String localPath = musicItemInfo.getLocalPath();
        if (TextUtils.isEmpty(localPath)) {
            return false;
        }
        if (this.C.containsKey(localPath)) {
            return true;
        }
        musicItemInfo.mProgress = 0;
        f fVar = new f(this.C, this.D, eVar);
        com.tencent.mobileqq.vip.g b16 = QQMusicDownloader.b(musicItemInfo.mUrl, localPath, fVar);
        if (b16 == null) {
            return true;
        }
        this.D.put(localPath, b16);
        QQMusicDownloader.c(b16, fVar);
        this.C.put(localPath, musicItemInfo);
        return true;
    }

    public boolean y(MusicItemInfo musicItemInfo, boolean z16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QimMusicPlayer", 2, "requestPlay " + i3 + " " + this.G);
        }
        this.G = i3;
        if (!h(musicItemInfo) || o(musicItemInfo)) {
            return false;
        }
        if (this.f66794d == musicItemInfo && p() && !z16) {
            QLog.i("QimMusicPlayer", 1, "have playing" + musicItemInfo);
            return false;
        }
        E(musicItemInfo);
        List<e> list = this.f66798i;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().g(musicItemInfo);
            }
        }
        i();
        this.f66794d = musicItemInfo;
        this.f66795e = musicItemInfo;
        this.f66799m = l(musicItemInfo);
        D();
        return true;
    }

    public void z(int i3) {
        d dVar = this.f66796f;
        if (dVar != null) {
            dVar.D(true);
        }
        w(-1, -1, i3);
    }

    @Override // fr.e
    public void d() {
        this.f66794d = null;
        this.f66795e = null;
        this.f66796f = null;
        this.f66798i.clear();
        this.f66798i = null;
        this.f66799m = null;
        this.D.clear();
        this.C.clear();
        Iterator<MusicPlayerScene> it = this.f66797h.values().iterator();
        while (it.hasNext()) {
            it.next().g();
        }
        this.f66797h.clear();
        this.f66797h = null;
        this.E.k();
        this.E = null;
    }

    public void f(e eVar) {
        List<e> list;
        if (eVar != null && (list = this.f66798i) != null) {
            if (list.contains(eVar)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener mListeners has listener");
                    return;
                }
                return;
            }
            this.f66798i.add(eVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener listener = null");
        }
    }

    public boolean w(int i3, int i16, int i17) {
        MusicItemInfo A = ((QIMMusicConfigManager) fr.f.c(2)).A(i3, i16);
        if (A != null) {
            return y(A, false, i17);
        }
        return false;
    }

    public boolean x(MusicItemInfo musicItemInfo, int i3) {
        return y(musicItemInfo, false, i3);
    }

    public boolean h(MusicItemInfo musicItemInfo) {
        if (musicItemInfo == null) {
            return false;
        }
        int i3 = musicItemInfo.mType;
        return !(i3 == 5 || i3 == 1) || FileUtils.fileExistsAndNotEmpty(musicItemInfo.getLocalPath());
    }

    @Override // fr.e
    public void e() {
    }
}
