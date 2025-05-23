package com.tencent.mobileqq.filter;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.filter.music.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;
import com.tencent.mobileqq.videocodec.mediacodec.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e implements QQSpecialAVFilter.MusicWaveformSupporter, a.InterfaceC8954a {
    static IPatchRedirector $redirector_;
    private int C;
    private boolean D;
    public boolean E;

    /* renamed from: d, reason: collision with root package name */
    private MusicItemInfo f209744d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.filter.music.a f209745e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f209746f;

    /* renamed from: h, reason: collision with root package name */
    private int f209747h;

    /* renamed from: i, reason: collision with root package name */
    private QQFilterRenderManager f209748i;

    /* renamed from: m, reason: collision with root package name */
    private int f209749m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements a.InterfaceC7597a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.filter.music.a.InterfaceC7597a
        public boolean a(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return e.this.f209746f;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16))).booleanValue();
        }
    }

    public e(List<FilterDesc> list, MusicItemInfo musicItemInfo, int i3, int i16, PublishVideoEntry publishVideoEntry) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, musicItemInfo, Integer.valueOf(i3), Integer.valueOf(i16), publishVideoEntry);
            return;
        }
        this.E = false;
        this.f209748i = f.a();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<FilterDesc> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FilterDesc next = it.next();
                if (next != null) {
                    int filterType = QQAVImageFilterConstants.getFilterType(next.f281357id);
                    if (filterType == 0) {
                        this.E = false;
                        arrayList.add(next);
                    } else if (filterType == 2) {
                        this.E = false;
                        arrayList.add(next);
                    } else if (filterType == 5) {
                        this.E = false;
                        arrayList.add(next);
                    } else if (filterType == 1) {
                        this.E = true;
                        arrayList.clear();
                        arrayList.add(next);
                        break;
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.f209748i.getBusinessOperation().setFilterEffectList(arrayList);
            }
        }
        List<QQBaseFilter> qQFilters = this.f209748i.getQQFilters(80);
        if (musicItemInfo != null && qQFilters.size() > 0) {
            Iterator<QQBaseFilter> it5 = qQFilters.iterator();
            while (it5.hasNext()) {
                ((QQSpecialAVFilter) it5.next()).setMusicWaveformSupporter(this);
            }
        }
        this.f209744d = musicItemInfo;
        this.f209746f = false;
        this.f209749m = i3;
        this.C = i16;
        if (musicItemInfo != null) {
            g();
        }
    }

    @TargetApi(17)
    private void g() {
        if (this.f209744d != null) {
            this.f209745e = new com.tencent.mobileqq.filter.music.a();
            if (com.tencent.mobileqq.filter.music.a.e()) {
                this.D = true;
                if (QLog.isColorLevel()) {
                    QLog.e("QQEncodeFilterRender", 2, "musicSoundFile create give up, is rubbish Meizu");
                    return;
                }
                return;
            }
            this.f209746f = true;
            a aVar = new a();
            try {
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                boolean a16 = this.f209745e.a(this.f209744d, aVar, 0);
                if (QLog.isColorLevel()) {
                    QLog.d("QQEncodeFilterRender", 2, "createSoundFile time: " + ((SystemClock.elapsedRealtimeNanos() - elapsedRealtimeNanos) / 1000000) + "ms");
                }
                if (!a16) {
                    this.f209745e = null;
                    if (QLog.isColorLevel()) {
                        QLog.e("QQEncodeFilterRender", 2, "create MusicSoundFile fail");
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("QQEncodeFilterRender", 2, e16.toString());
                }
                this.f209745e = null;
            }
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.a.InterfaceC8954a
    public int a(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Long.valueOf(j3))).intValue();
        }
        return d(this.f209749m, this.C, i3, j3);
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.a.InterfaceC8954a
    public void b(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f209748i.surfaceCreate(i3, i16, i17, i18);
        }
    }

    public int d(int i3, int i16, int i17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3))).intValue();
        }
        this.f209747h = (int) (j3 / 1000000);
        this.f209748i.getBusinessOperation().SetTimeStamp(j3, j3);
        return this.f209748i.drawFrame(i17);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f209748i.surfaceDestroyed();
            this.f209745e = null;
        }
    }

    public void f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f209748i.surfaceCreate(i3, i16, i3, i16);
            this.f209748i.surfaceChange(i3, i16, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter
    public float getCurrentMusicGain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        try {
            com.tencent.mobileqq.filter.music.a aVar = this.f209745e;
            if (aVar == null) {
                return -1.0f;
            }
            if (this.D) {
                return 0.5f;
            }
            return aVar.b(this.f209747h);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQEncodeFilterRender", 2, "getCurrentMusicGain() error: " + e16.toString());
            }
            return -1.0f;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter
    public MusicItemInfo getMusicItemInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MusicItemInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f209744d;
    }
}
