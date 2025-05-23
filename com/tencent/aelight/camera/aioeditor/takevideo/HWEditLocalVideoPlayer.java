package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes32.dex */
public class HWEditLocalVideoPlayer extends u implements HWDecodeListener, x, Handler.Callback, HWVideoPlayView.b {
    private boolean C;
    private Handler D;
    private Handler E;
    protected LocalMediaInfo F;
    protected List<a> G;
    protected int H;
    private AtomicBoolean I;
    private int J;
    private Runnable K;
    boolean L;
    boolean M;

    /* renamed from: d, reason: collision with root package name */
    protected VideoFilterPlayView f67893d;

    /* renamed from: e, reason: collision with root package name */
    private String f67894e;

    /* renamed from: f, reason: collision with root package name */
    private String f67895f;

    /* renamed from: h, reason: collision with root package name */
    private String f67896h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.a f67897i;

    /* renamed from: m, reason: collision with root package name */
    private ConvertIFramesRunnable f67898m;

    /* loaded from: classes32.dex */
    public static class a extends ae {

        /* renamed from: c, reason: collision with root package name */
        private long f67908c;

        /* renamed from: d, reason: collision with root package name */
        private long f67909d;

        /* renamed from: e, reason: collision with root package name */
        private int f67910e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f67911f;

        /* renamed from: g, reason: collision with root package name */
        private Bitmap f67912g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f67913h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f67914i;

        /* renamed from: j, reason: collision with root package name */
        private Bitmap f67915j;

        /* renamed from: k, reason: collision with root package name */
        public String f67916k;

        /* renamed from: l, reason: collision with root package name */
        public String f67917l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f67918m;

        public a(int i3, Bitmap bitmap) {
            super(i3, bitmap);
            this.f67908c = 0L;
            this.f67909d = 0L;
            this.f67910e = 0;
            this.f67911f = false;
            this.f67912g = null;
            this.f67913h = false;
            this.f67914i = false;
            this.f67918m = false;
            this.f67915j = bitmap;
        }

        public a o(Bitmap bitmap) {
            a aVar = new a(this.f67934a, bitmap);
            aVar.f67915j = this.f67915j;
            aVar.f67908c = this.f67908c;
            aVar.f67909d = this.f67909d;
            aVar.f67910e = this.f67910e;
            aVar.f67911f = this.f67911f;
            aVar.f67912g = this.f67912g;
            aVar.f67916k = this.f67916k;
            aVar.f67917l = this.f67917l;
            this.f67913h = false;
            this.f67914i = false;
            this.f67918m = false;
            return aVar;
        }

        public String toString() {
            return "Mp4VideoFragmentInfo{index=" + this.f67934a + ", bitmap=" + this.f67935b + ", startTime=" + this.f67908c + ", endTime=" + this.f67909d + ", mRevertFailed=" + this.f67918m + '}';
        }
    }

    public HWEditLocalVideoPlayer(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.C = true;
        this.E = new Handler(ThreadManagerV2.getFileThreadLooper(), this);
        this.G = new CopyOnWriteArrayList();
        this.H = 0;
        this.I = new AtomicBoolean(false);
        this.J = 0;
        this.K = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) HWEditLocalVideoPlayer.this.getEditExport(f.class);
                if (fVar != null) {
                    fVar.A();
                }
            }
        };
        this.L = false;
        this.M = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i3) {
        ConvertIFramesRunnable convertIFramesRunnable = this.f67898m;
        if (convertIFramesRunnable == null) {
            if (i3 < this.G.size()) {
                a aVar = this.G.get(i3);
                if (!aVar.f67918m && TextUtils.isEmpty(aVar.f67916k)) {
                    ConvertIFramesRunnable t06 = t0(aVar.f67934a);
                    this.f67898m = t06;
                    this.E.postDelayed(t06, 300L);
                }
            }
            if (this.f67898m == null) {
                Iterator<a> it = this.G.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (!next.f67918m && TextUtils.isEmpty(next.f67916k)) {
                        ConvertIFramesRunnable t07 = t0(next.f67934a);
                        this.f67898m = t07;
                        this.E.postDelayed(t07, 300L);
                        break;
                    }
                }
            }
            if (this.f67898m == null) {
                hd0.c.k("Q.qqstory.record.HWEditLocalVideoPlayer", "no fragment info should convert I frame");
                return;
            } else {
                hd0.c.o("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable, priorVideoIndex=%d, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(i3), Integer.valueOf(this.f67898m.f67901d), Integer.valueOf(this.f67898m.f67902e), Integer.valueOf(this.f67898m.f67903f));
                return;
            }
        }
        hd0.c.n("Q.qqstory.record.HWEditLocalVideoPlayer", "triggerConvertIFramesRunnable ignore, mFrameRate=%d, mIFrameInterval=%d, mFragmentIndex=%d", Integer.valueOf(convertIFramesRunnable.f67901d), Integer.valueOf(this.f67898m.f67902e), Integer.valueOf(this.f67898m.f67903f));
    }

    private Bitmap D0(a aVar, boolean z16) {
        Bitmap b16;
        Bitmap bitmap = aVar.f67915j;
        long e06 = this.mParent.e0() / 1000000;
        if (e06 != 0 && z16 && (b16 = nr.a.b(this.f67894e, this.F, e06)) != null) {
            bitmap = b16;
        }
        if (bitmap == null) {
            return null;
        }
        int i3 = this.F.rotation;
        if (i3 != 0) {
            bitmap = UIUtils.p(bitmap, 360 - i3);
        }
        mr.a aVar2 = new mr.a();
        aVar2.c(bitmap.getWidth(), bitmap.getHeight());
        QQFilterRenderManager b17 = com.tencent.mobileqq.filter.f.b(com.tencent.mobileqq.filter.f.f209753c);
        if (b17 != null && b17.getBusinessOperation().hasAvOrSpecialEffect()) {
            Bitmap h16 = aVar2.h(bitmap, z16 ? this.mParent.e0() : 0L);
            if (h16 != null) {
                bitmap = h16;
            }
        }
        if (aVar.f67914i && aVar.f67912g != null) {
            com.tencent.mobileqq.filter.c cVar = (com.tencent.mobileqq.filter.c) com.tencent.mobileqq.filter.a.a(106);
            cVar.c(aVar.f67912g);
            cVar.init();
            Bitmap g16 = aVar2.g(bitmap, cVar);
            hd0.c.b("Q.qqstory.record.HWEditLocalVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", g16);
            if (g16 != null) {
                bitmap = g16;
            }
            cVar.destroy();
        }
        aVar2.b();
        if (i3 != 0) {
            bitmap = UIUtils.p(bitmap, i3);
        }
        return (bitmap != aVar.f67915j || aVar.f67913h || aVar.f67914i) ? bitmap : aVar.f67935b;
    }

    private ConvertIFramesRunnable t0(int i3) {
        if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("MX5") && !DeviceInfoMonitor.getModel().contains("vivo X5") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("M2 Note") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("m1 metal") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("HLA Note3") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("OPPO R7") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("LON-AL00")) {
            return new ConvertIFramesRunnable(30, 0, i3);
        }
        return new ConvertIFramesRunnable(3, 1, i3);
    }

    private int u0(int i3) {
        return 0;
    }

    private int x0(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 3) {
                return 2;
            }
            if (i3 == 8) {
                return 3;
            }
            if (i3 != 9) {
                return 0;
            }
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(a aVar) {
        hd0.c.m("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayInfo\uff0cindex : %d => %d", Integer.valueOf(this.H), Integer.valueOf(aVar.f67934a));
        if (aVar.f67916k == null) {
            if (!this.f67893d.g().equalsIgnoreCase(this.f67894e)) {
                this.f67893d.o();
                this.f67893d.setFilePath(this.f67894e, this.f67895f);
                this.f67893d.n();
                this.f67893d.m();
                this.J = 1;
            }
            this.f67893d.setPlayRange((int) aVar.f67908c, (int) aVar.f67909d);
            EditVideoSpeedFilter editVideoSpeedFilter = this.mParent.J;
            if (editVideoSpeedFilter != null) {
                editVideoSpeedFilter.x0(3, HardCodeUtil.qqStr(R.string.ncs));
            }
        } else {
            if (!this.f67893d.g().equalsIgnoreCase(aVar.f67916k)) {
                this.f67893d.o();
                this.f67893d.setFilePath(aVar.f67916k, aVar.f67917l);
                this.f67893d.e();
                this.f67893d.n();
                this.f67893d.m();
                this.J = 1;
            }
            EditVideoSpeedFilter editVideoSpeedFilter2 = this.mParent.J;
            if (editVideoSpeedFilter2 != null) {
                editVideoSpeedFilter2.x0(3, "");
            }
        }
        this.H = aVar.f67934a;
    }

    public void B0(int i3) {
        int x06 = x0(i3);
        if (x06 == 5 && this.G.size() > 0) {
            a aVar = this.G.get(this.H);
            if (aVar.f67916k == null) {
                this.f67893d.l();
                this.J = 2;
            } else {
                hd0.c.a("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode change to iframe video");
                z0(aVar);
            }
            this.f67893d.setSpeedType(5);
        } else {
            this.f67893d.setSpeedType(x06);
            this.f67893d.m();
            this.J = 1;
        }
        A0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void K(boolean z16) {
        int N = this.mParent.N();
        if (N < this.G.size()) {
            this.G.get(N).f67911f = z16;
        }
        this.f67893d.setMuteAudio(z16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void c0(TransferData transferData) {
        VideoFilterPlayView videoFilterPlayView = this.f67893d;
        if (videoFilterPlayView != null) {
            videoFilterPlayView.setTransferData(transferData);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void d(Bitmap bitmap, boolean z16) {
        int N = this.mParent.N();
        if (N < this.G.size()) {
            a aVar = this.G.get(N);
            aVar.f67912g = bitmap;
            aVar.f67914i = aVar.f67914i || z16;
        }
        this.f67893d.setMosaicFilterType(bitmap);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        if (bVar.f400386c instanceof EditTakeVideoSource) {
            com.tencent.mobileqq.videocodec.mediacodec.a aVar = this.f67897i;
            if (aVar != null) {
                aVar.a();
                this.f67897i = null;
            }
            a aVar2 = this.G.get(i3);
            PublishVideoEntry publishVideoEntry = bVar.f400387d;
            publishVideoEntry.videoNeedRotate = false;
            publishVideoEntry.mIFrameVideoPath = aVar2.f67916k;
            boolean f16 = com.tencent.biz.qqstory.utils.k.f(this.F);
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.record.HWEditLocalVideoPlayer", 2, "landscape:" + f16 + " w:" + this.F.mediaWidth + " h:" + this.F.mediaHeight + " r:" + this.F.rotation);
            }
            bVar.f400387d.putExtra("landscape_video", Boolean.valueOf(f16));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        VideoFilterPlayView videoFilterPlayView = this.f67893d;
        if (videoFilterPlayView == null || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6 || this.M) {
            return;
        }
        videoFilterPlayView.m();
        this.J = 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.b
    public void g0() {
        if (this.J == 2) {
            this.f67893d.l();
        } else {
            this.J = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public boolean handleEditVideoMessage(Message message) {
        if (message.what != 3) {
            return false;
        }
        int i3 = message.arg1;
        if (i3 == 1) {
            VideoFilterPlayView videoFilterPlayView = this.f67893d;
            if (videoFilterPlayView != null) {
                videoFilterPlayView.n();
                this.J = 1;
            }
        } else if (i3 == 2) {
            this.f67893d.o();
            this.J = 0;
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        Bitmap D0;
        int i3 = message.what;
        if (i3 < 0 || i3 >= this.G.size() || (D0 = D0((aVar = this.G.get(i3)), false)) == null || D0 == aVar.f67935b) {
            return true;
        }
        a o16 = aVar.o(D0);
        this.G.set(i3, o16);
        hd0.c.l("Q.qqstory.record.HWEditLocalVideoPlayer", "update fragment bitmap : %s", o16);
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public Bitmap m(int i3) {
        if (i3 < this.G.size()) {
            return D0(this.G.get(i3), true);
        }
        hd0.c.i("Q.qqstory.record.HWEditLocalVideoPlayer", "getDurationOfFragment with invalid index = %d", Integer.valueOf(i3));
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.D = new Handler();
        EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
        if (editSource instanceof EditTakeVideoSource) {
            EditTakeVideoSource editTakeVideoSource = (EditTakeVideoSource) editSource;
            String str = editTakeVideoSource.f204053f;
            this.f67895f = str;
            this.F = editTakeVideoSource.f204052e;
            this.f67894e = editTakeVideoSource.f204051d;
            this.f67896h = editTakeVideoSource.f204054h;
            if (!TextUtils.isEmpty(str) && this.f67895f.endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)) {
                com.tencent.aelight.camera.aioeditor.capture.music.g gVar = (com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.d().g(8);
                MusicItemInfo I = MusicProviderView.I(this.f67895f);
                if (I != null) {
                    gVar.u(I);
                    String str2 = Image2Video.f94285a + "/noaudio";
                    FileUtils.createFileIfNotExits(str2);
                    this.f67895f = str2;
                }
            }
            VideoFilterPlayView videoFilterPlayView = (VideoFilterPlayView) findViewSure(R.id.ruo);
            this.f67893d = videoFilterPlayView;
            videoFilterPlayView.setVisibility(0);
            this.f67893d.setBgmFilePath(this.f67896h);
            this.f67893d.setMediaInfo(this.F);
            this.f67893d.setFilePath(this.f67894e, this.f67895f);
            this.f67893d.setRepeat(true);
            this.f67893d.setSpeedType(0);
            this.f67893d.setDecodeListener(this);
            this.f67893d.setPlayViewListener(this);
            this.J = 0;
            publishEditExport(x.class, this);
            this.mParent.f1(false);
            this.E.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.1
                /* JADX WARN: Removed duplicated region for block: B:25:0x00bd A[LOOP:1: B:10:0x003e->B:25:0x00bd, LOOP_END] */
                /* JADX WARN: Removed duplicated region for block: B:26:0x00c4 A[EDGE_INSN: B:26:0x00c4->B:27:0x00c4 BREAK  A[LOOP:1: B:10:0x003e->B:25:0x00bd], SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    String str3;
                    a aVar;
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j3 = i3;
                        if (j3 >= HWEditLocalVideoPlayer.this.F.mDuration / TTL.MAX_VALUE) {
                            break;
                        }
                        arrayList.add(new k.a(j3 * TTL.MAX_VALUE, TTL.MAX_VALUE));
                        i3++;
                    }
                    if (arrayList.size() <= 0) {
                        arrayList.add(new k.a(0L, HWEditLocalVideoPlayer.this.F.mDuration));
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    int i16 = 0;
                    while (true) {
                        if (i16 >= arrayList.size()) {
                            str3 = "Q.qqstory.record.HWEditLocalVideoPlayer";
                            break;
                        }
                        k.a aVar2 = (k.a) arrayList.get(i16);
                        long uptimeMillis2 = SystemClock.uptimeMillis();
                        long min = Math.min(aVar2.f94469a + aVar2.f94470b, HWEditLocalVideoPlayer.this.F.mDuration);
                        long j16 = 1000 + min;
                        HWEditLocalVideoPlayer hWEditLocalVideoPlayer = HWEditLocalVideoPlayer.this;
                        long j17 = hWEditLocalVideoPlayer.F.mDuration;
                        if (j16 > j17) {
                            min = j17;
                        }
                        if (i16 != 5) {
                            j17 = min;
                        }
                        try {
                            aVar = new a(i16, nr.a.c(hWEditLocalVideoPlayer.f67894e, (int) aVar2.f94469a));
                            aVar.f67908c = aVar2.f94469a;
                            aVar.f67909d = j17;
                            HWEditLocalVideoPlayer.this.G.add(aVar);
                            str3 = "Q.qqstory.record.HWEditLocalVideoPlayer";
                        } catch (RuntimeException e16) {
                            e = e16;
                            str3 = "Q.qqstory.record.HWEditLocalVideoPlayer";
                        }
                        try {
                            hd0.c.m(str3, "create fragment info = %s, cost = %dms", aVar, Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis2));
                        } catch (RuntimeException e17) {
                            e = e17;
                            QLog.e(str3, 1, e, new Object[0]);
                            if (j17 < HWEditLocalVideoPlayer.this.F.mDuration) {
                            }
                        }
                        if (j17 < HWEditLocalVideoPlayer.this.F.mDuration) {
                            break;
                        } else {
                            i16++;
                        }
                    }
                    hd0.c.m(str3, "create fragment info count = %d, cost = %dms", Integer.valueOf(HWEditLocalVideoPlayer.this.G.size()), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                    for (int i17 = 0; i17 < HWEditLocalVideoPlayer.this.G.size(); i17++) {
                        a aVar3 = HWEditLocalVideoPlayer.this.G.get(i17);
                        String str4 = g.a.C0559a.f65250d + com.tencent.biz.qqstory.utils.d.m(HWEditLocalVideoPlayer.this.f67894e) + "_" + i17 + ".IFrames.audio";
                        int b16 = com.tencent.mobileqq.editor.composite.step.a.b(HWEditLocalVideoPlayer.this.f67895f, str4, (((float) aVar3.f67908c) * 1.0f) / ((float) HWEditLocalVideoPlayer.this.F.mDuration), (((float) aVar3.f67909d) * 1.0f) / ((float) HWEditLocalVideoPlayer.this.F.mDuration));
                        if (b16 == 0) {
                            hd0.c.a(str3, "clipAudioFile finished audioFilePath" + str4);
                            aVar3.f67917l = str4;
                        } else {
                            hd0.c.i(str3, "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", Integer.valueOf(b16), str4, Long.valueOf(HWEditLocalVideoPlayer.this.F.mDuration), Long.valueOf(aVar3.f67908c), Long.valueOf(aVar3.f67909d));
                        }
                    }
                    HWEditLocalVideoPlayer.this.y0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (HWEditLocalVideoPlayer.this.G.size() > 0) {
                                HWEditLocalVideoPlayer.this.z0(HWEditLocalVideoPlayer.this.G.get(0));
                            } else {
                                hd0.c.g("Q.qqstory.record.HWEditLocalVideoPlayer", "mFragmentInfos is empty");
                            }
                            HWEditLocalVideoPlayer hWEditLocalVideoPlayer2 = HWEditLocalVideoPlayer.this;
                            hWEditLocalVideoPlayer2.C0(hWEditLocalVideoPlayer2.H);
                            HWEditLocalVideoPlayer.this.I.set(true);
                            HWEditLocalVideoPlayer.this.mParent.f1(true);
                        }
                    }, 0L);
                }
            }, 200L);
            return;
        }
        throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditTakeVideoSource now");
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeError(int i3, Throwable th5) {
        QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 4, "onDecodeError errorCode = " + i3, th5);
        throw new RuntimeException(th5);
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFrame(long j3, final long j16) {
        y0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                EditVideoPartManager editVideoPartManager = HWEditLocalVideoPlayer.this.mParent;
                if (editVideoPartManager.f67784f) {
                    return;
                }
                editVideoPartManager.s(Message.obtain(null, 13, new Long[]{Long.valueOf(j16 / 1000000), Long.valueOf(j16)}));
            }
        }, 0L);
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeRepeat() {
        if (this.J != 2) {
            y0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.4
                @Override // java.lang.Runnable
                public void run() {
                    f fVar = (f) HWEditLocalVideoPlayer.this.getEditExport(f.class);
                    if (fVar != null) {
                        fVar.A();
                    }
                    HWEditLocalVideoPlayer.this.mParent.s(Message.obtain((Handler) null, 14));
                }
            }, 0L);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeStart() {
        Handler handler;
        if (this.J == 2 || (handler = this.D) == null) {
            return;
        }
        handler.removeCallbacks(this.K);
        y0(this.K, 200L);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        VideoFilterPlayView videoFilterPlayView;
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.D = null;
        }
        VideoFilterPlayView videoFilterPlayView2 = this.f67893d;
        if (videoFilterPlayView2 != null) {
            videoFilterPlayView2.o();
            this.f67893d.J();
            this.J = 0;
            this.f67893d.setPlayViewListener(null);
        }
        super.onDestroy();
        if (!com.tencent.mobileqq.monitor.a.f247270d || (videoFilterPlayView = this.f67893d) == null || videoFilterPlayView.f67502d0 <= 100 || videoFilterPlayView.f67500c0 <= 0) {
            return;
        }
        int K = this.mParent.K();
        float f16 = (r1.f67502d0 / ((float) this.f67893d.f67500c0)) * 1000.0f;
        if (id0.a.g((int) f16, 0L, 30L)) {
            id0.a.r("CamEditFreq", true, 0L, String.valueOf(this.mParent.C.f204055d), String.valueOf(f16), id0.a.b(K), String.valueOf(this.f67893d.f67502d0), String.valueOf(this.f67893d.f67500c0));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onPause() {
        super.onPause();
        this.f67893d.l();
        this.f67893d.onPause();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        super.onResume();
        this.f67893d.onResume();
        if (this.J != 2) {
            this.f67893d.m();
        } else {
            this.f67893d.l();
        }
        this.L = false;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onStart() {
        super.onStart();
        this.C = true;
        C0(0);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onStop() {
        super.onStop();
        this.C = false;
        com.tencent.mobileqq.videocodec.mediacodec.a aVar = this.f67897i;
        if (aVar != null) {
            aVar.a();
            this.f67897i = null;
        }
        ConvertIFramesRunnable convertIFramesRunnable = this.f67898m;
        if (convertIFramesRunnable != null) {
            this.D.removeCallbacks(convertIFramesRunnable);
            this.f67898m = null;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void pause() {
        VideoFilterPlayView videoFilterPlayView = this.f67893d;
        videoFilterPlayView.Q = false;
        videoFilterPlayView.l();
        this.J = 2;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void play() {
        this.f67893d.m();
        this.J = 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void setPlayMode(int i3) {
        hd0.c.b("Q.qqstory.record.HWEditLocalVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(i3));
        int N = this.mParent.N();
        if (N < this.G.size()) {
            a aVar = this.G.get(N);
            if (aVar.f67910e != i3) {
                aVar.f67910e = i3;
                aVar.f67913h = true;
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void setVolume(float f16) {
        this.f67893d.setVolume(f16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void u(int i3, byte[] bArr) {
        throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
    }

    public LocalMediaInfo v0() {
        return this.F;
    }

    public int w0() {
        return this.J;
    }

    public void y0(Runnable runnable, long j3) {
        Handler handler = this.D;
        if (handler != null) {
            if (j3 != 0) {
                handler.postDelayed(runnable, j3);
            } else {
                handler.post(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public class ConvertIFramesRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public int f67901d;

        /* renamed from: e, reason: collision with root package name */
        public int f67902e;

        /* renamed from: f, reason: collision with root package name */
        public int f67903f;

        ConvertIFramesRunnable(int i3, int i16, int i17) {
            this.f67902e = i16;
            this.f67901d = i3;
            this.f67903f = i17;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            hd0.c.t("Q.qqstory.record.HWEditLocalVideoPlayer", "start convert i frame video. mVideoPath = " + HWEditLocalVideoPlayer.this.f67894e);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(HWEditLocalVideoPlayer.this.f67894e);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                mediaMetadataRetriever.release();
                if (TextUtils.isEmpty(extractMetadata) || TextUtils.isEmpty(extractMetadata2)) {
                    return;
                }
                try {
                    i3 = Integer.valueOf(extractMetadata3).intValue();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    i3 = 0;
                }
                int i16 = i3;
                HWEditLocalVideoPlayer.this.f67897i = new com.tencent.mobileqq.videocodec.mediacodec.a();
                String str = HWEditLocalVideoPlayer.this.f67894e + "_" + this.f67903f + ".IFrames.mp4";
                if (this.f67902e != 0) {
                    HWEditLocalVideoPlayer.this.f67897i.K = this.f67902e * this.f67901d;
                }
                final a aVar = HWEditLocalVideoPlayer.this.G.get(this.f67903f);
                HWEditLocalVideoPlayer.this.f67897i.g(new DecodeConfig(HWEditLocalVideoPlayer.this.f67894e, 0, false, true, aVar.f67908c, aVar.f67909d), new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(str, Integer.valueOf(extractMetadata).intValue(), Integer.valueOf(extractMetadata2).intValue(), 12582912, this.f67902e, this.f67901d, 0, false, i16, null, null, null, false), new com.tencent.mobileqq.videocodec.mediacodec.recorder.c() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1
                    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
                    public void onEncodeError(int i17, Throwable th6) {
                        hd0.c.g("Q.qqstory.record.HWEditLocalVideoPlayer", "encode error errorCode = " + i17 + " Exception = " + th6);
                        ConvertIFramesRunnable convertIFramesRunnable = ConvertIFramesRunnable.this;
                        if (convertIFramesRunnable.f67902e == 0) {
                            convertIFramesRunnable.f67902e = 1;
                            convertIFramesRunnable.f67901d = 3;
                            hd0.c.t("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video by mIFrameInterval = " + ConvertIFramesRunnable.this.f67902e + " mFrameRate = " + ConvertIFramesRunnable.this.f67901d);
                            ConvertIFramesRunnable convertIFramesRunnable2 = ConvertIFramesRunnable.this;
                            HWEditLocalVideoPlayer.this.y0(convertIFramesRunnable2, 1000L);
                            return;
                        }
                        hd0.c.t("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video failed");
                        try {
                            im2.b.a(th6);
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                        HWEditLocalVideoPlayer.this.y0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                a aVar2 = aVar;
                                aVar2.f67917l = null;
                                aVar2.f67918m = true;
                                HWEditLocalVideoPlayer hWEditLocalVideoPlayer = HWEditLocalVideoPlayer.this;
                                hWEditLocalVideoPlayer.C0(hWEditLocalVideoPlayer.H);
                            }
                        }, 0L);
                    }

                    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
                    public void onEncodeFinish(String str2) {
                        aVar.f67916k = str2;
                        hd0.c.t("Q.qqstory.record.HWEditLocalVideoPlayer", "onEncodeFinish  iframe file filePath = " + str2);
                        HWEditLocalVideoPlayer.this.y0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HWEditLocalVideoPlayer.this.f67898m = null;
                                if (!HWEditLocalVideoPlayer.this.C) {
                                    hd0.c.t("Q.qqstory.record.HWEditLocalVideoPlayer", "Convert video finished but player not displayed.");
                                    return;
                                }
                                EditVideoSpeedFilter editVideoSpeedFilter = HWEditLocalVideoPlayer.this.mParent.J;
                                if (editVideoSpeedFilter != null && editVideoSpeedFilter.p0() == 3) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    ConvertIFramesRunnable convertIFramesRunnable = ConvertIFramesRunnable.this;
                                    int i17 = convertIFramesRunnable.f67903f;
                                    HWEditLocalVideoPlayer hWEditLocalVideoPlayer = HWEditLocalVideoPlayer.this;
                                    if (i17 == hWEditLocalVideoPlayer.H) {
                                        hWEditLocalVideoPlayer.z0(aVar);
                                    }
                                }
                                HWEditLocalVideoPlayer.this.A0();
                                HWEditLocalVideoPlayer hWEditLocalVideoPlayer2 = HWEditLocalVideoPlayer.this;
                                hWEditLocalVideoPlayer2.C0(hWEditLocalVideoPlayer2.H);
                            }
                        }, 0L);
                    }

                    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
                    public void onEncodeFrame() {
                    }

                    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
                    public void onEncodeStart() {
                    }
                }, null);
            } catch (Exception e16) {
                hd0.c.h("Q.qqstory.record.HWEditLocalVideoPlayer", "setDataSource failed when convert i frame", e16);
                mediaMetadataRetriever.release();
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.b
    public void N() {
        this.J = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            if (this.G.get(i3).f67910e == 1 && TextUtils.isEmpty(this.G.get(i3).f67916k)) {
                this.mParent.f1(false);
                return;
            }
        }
        if (this.I.compareAndSet(true, true)) {
            this.mParent.f1(true);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void d0(int i3, int i16, float f16) {
        float f17 = 1.0f - f16;
        if (f17 != 0.0f && f17 <= 0.95f) {
            EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
            if (editSource instanceof EditLocalVideoSource) {
                this.f67893d.setColorFilterType(u0(i3), u0(i16), f17, ((EditLocalVideoSource) editSource).f204044e.rotation);
                return;
            } else {
                if (editSource instanceof EditTakeVideoSource) {
                    this.f67893d.setColorFilterType(u0(i3), u0(i16), f17, 0);
                    return;
                }
                return;
            }
        }
        this.f67893d.setColorFilterType(u0(i3));
        B0(i3);
        hd0.c.d("Q.qqstory.record.HWEditLocalVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void b(Bitmap bitmap) {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeSeekTo(long j3) {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeCancel() {
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFinish() {
    }
}
