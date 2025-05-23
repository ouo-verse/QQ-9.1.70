package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.VideoFilterPlayView;
import com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import nr.a;

/* loaded from: classes32.dex */
public class HWEditImportVideoPlayer extends u implements HWDecodeListener, x, Handler.Callback, HWVideoPlayView.b {
    private Handler C;
    protected LocalMediaInfo D;
    protected List<a> E;
    protected int F;
    private AtomicBoolean G;
    private int H;
    private int I;
    final boolean J;
    boolean K;
    boolean L;
    boolean M;

    /* renamed from: d, reason: collision with root package name */
    protected VideoFilterPlayView f67875d;

    /* renamed from: e, reason: collision with root package name */
    private String f67876e;

    /* renamed from: f, reason: collision with root package name */
    private String f67877f;

    /* renamed from: h, reason: collision with root package name */
    private int f67878h;

    /* renamed from: i, reason: collision with root package name */
    private int f67879i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f67880m;

    /* loaded from: classes32.dex */
    public static class a extends ae {

        /* renamed from: c, reason: collision with root package name */
        private long f67883c;

        /* renamed from: d, reason: collision with root package name */
        private long f67884d;

        /* renamed from: e, reason: collision with root package name */
        private int f67885e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f67886f;

        /* renamed from: g, reason: collision with root package name */
        private Bitmap f67887g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f67888h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f67889i;

        /* renamed from: j, reason: collision with root package name */
        private Bitmap f67890j;

        /* renamed from: k, reason: collision with root package name */
        public String f67891k;

        /* renamed from: l, reason: collision with root package name */
        public String f67892l;

        public a(int i3, Bitmap bitmap) {
            super(i3, bitmap);
            this.f67883c = 0L;
            this.f67884d = 0L;
            this.f67885e = 0;
            this.f67886f = false;
            this.f67887g = null;
            this.f67888h = false;
            this.f67889i = false;
            this.f67890j = bitmap;
        }

        public a o(Bitmap bitmap) {
            a aVar = new a(this.f67934a, bitmap);
            aVar.f67890j = this.f67890j;
            aVar.f67883c = this.f67883c;
            aVar.f67884d = this.f67884d;
            aVar.f67885e = this.f67885e;
            aVar.f67886f = this.f67886f;
            aVar.f67887g = this.f67887g;
            aVar.f67891k = this.f67891k;
            aVar.f67892l = this.f67892l;
            this.f67888h = false;
            this.f67889i = false;
            return aVar;
        }

        public String toString() {
            return "Mp4VideoFragmentInfo{index=" + this.f67934a + ", bitmap=" + this.f67935b + ", startTime=" + this.f67883c + ", endTime=" + this.f67884d + '}';
        }
    }

    public HWEditImportVideoPlayer(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.C = new Handler(ThreadManagerV2.getFileThreadLooper(), this);
        this.E = new CopyOnWriteArrayList();
        this.F = -1;
        this.G = new AtomicBoolean(false);
        this.H = 0;
        this.I = 0;
        this.J = true;
    }

    private void q0() {
        int i3;
        EditVideoPartManager editVideoPartManager = this.mParent;
        if (editVideoPartManager.C.f204055d != 14 || editVideoPartManager.f0() == null || this.mParent.f0().isLandTakePicToVideo()) {
            return;
        }
        EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
        if (editSource instanceof EditLocalVideoSource) {
            int i16 = ((EditLocalVideoSource) editSource).f204044e.rotation;
            int width = editSource.getWidth();
            int height = this.mParent.C.f204059i.getHeight();
            if (i16 == 90 || i16 == 270) {
                width = Math.min(this.mParent.C.f204059i.getWidth(), this.mParent.C.f204059i.getHeight());
                height = Math.max(this.mParent.C.f204059i.getWidth(), this.mParent.C.f204059i.getHeight());
            }
            float f16 = width / height;
            int i17 = ScreenUtil.SCREEN_WIDTH;
            if (!ScreenUtil.checkDeviceHasNavigationBar(getContext())) {
                i3 = ScreenUtil.getRealHeight(getContext());
            } else {
                i3 = ScreenUtil.SCREEN_HIGHT;
            }
            int i18 = (int) (i17 / f16);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f67875d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = i17;
                layoutParams.height = i18;
                layoutParams.addRule(16);
                layoutParams.setMargins(0, (i3 / 2) - (i18 / 2), 0, 0);
                this.f67875d.setLayoutParams(layoutParams);
            }
            QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size viewWidth ane viewHeight:" + i17 + " " + i18);
        }
    }

    private int s0(int i3) {
        return 0;
    }

    private int t0(int i3) {
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
    public void v0(a aVar) {
        hd0.c.m("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayInfo\uff0cindex : %d => %d", Integer.valueOf(this.F), Integer.valueOf(aVar.f67934a));
        if (aVar.f67891k == null) {
            if (!this.f67875d.g().equalsIgnoreCase(this.f67876e)) {
                this.f67875d.o();
                this.H = this.f67875d.d(this.D);
                this.f67875d.setFilePath(this.f67876e, this.f67877f, true, this.K, this.L);
                this.f67875d.n();
                this.f67875d.m();
                this.I = 1;
            }
            this.f67875d.setPlayRange((int) aVar.f67883c, (int) aVar.f67884d);
            EditVideoSpeedFilter editVideoSpeedFilter = this.mParent.J;
            if (editVideoSpeedFilter != null) {
                editVideoSpeedFilter.x0(3, HardCodeUtil.qqStr(R.string.ncn));
            }
        } else {
            if (!this.f67875d.g().equalsIgnoreCase(aVar.f67891k)) {
                this.f67875d.o();
                this.H = this.f67875d.d(this.D);
                this.f67875d.setFilePath(aVar.f67891k, aVar.f67892l, true, this.K, this.L);
                this.f67875d.e();
                this.f67875d.n();
                this.f67875d.m();
                this.I = 1;
            }
            EditVideoSpeedFilter editVideoSpeedFilter2 = this.mParent.J;
            if (editVideoSpeedFilter2 != null) {
                editVideoSpeedFilter2.x0(3, "");
            }
        }
        this.F = aVar.f67934a;
    }

    private Bitmap x0(a aVar, boolean z16) {
        Bitmap b16;
        Bitmap bitmap = aVar.f67890j;
        long e06 = this.mParent.e0() / 1000000;
        if (e06 != 0 && z16 && (b16 = nr.a.b(this.f67876e, this.D, e06)) != null) {
            bitmap = b16;
        }
        if (bitmap == null) {
            return null;
        }
        int i3 = 0;
        if (!com.tencent.biz.qqstory.utils.k.f(this.D) && this.D.rotation == 180) {
            i3 = 180;
        }
        if (i3 != 0) {
            bitmap = UIUtils.p(bitmap, i3);
        }
        mr.a aVar2 = new mr.a();
        if (this.L) {
            bitmap = r0(getContext(), bitmap, aVar2);
        } else {
            aVar2.c(bitmap.getWidth(), bitmap.getHeight());
        }
        QQFilterRenderManager b17 = com.tencent.mobileqq.filter.f.b(com.tencent.mobileqq.filter.f.f209753c);
        if (b17 != null && b17.getBusinessOperation().hasAvOrSpecialEffect()) {
            Bitmap h16 = aVar2.h(bitmap, z16 ? this.mParent.e0() : 0L);
            if (h16 != null) {
                bitmap = h16;
            }
        }
        if (aVar.f67889i && aVar.f67887g != null) {
            com.tencent.mobileqq.filter.c cVar = (com.tencent.mobileqq.filter.c) com.tencent.mobileqq.filter.a.a(106);
            cVar.c(aVar.f67887g);
            cVar.init();
            Bitmap g16 = aVar2.g(bitmap, cVar);
            hd0.c.b("Q.qqstory.record.HWEditImportVideoPlayer", "updateFragmentThumbBitmapIfNeeded, mosaicThumbBitmap = %s", g16);
            if (g16 != null) {
                bitmap = g16;
            }
            cVar.destroy();
        }
        aVar2.b();
        if (i3 != 0) {
            bitmap = UIUtils.p(bitmap, 360 - i3);
        }
        if (this.M) {
            bitmap = UIUtils.p(bitmap, 90.0f);
        }
        return (bitmap != aVar.f67890j || aVar.f67888h || aVar.f67889i) ? bitmap : aVar.f67935b;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void K(boolean z16) {
        int N = this.mParent.N();
        if (N < this.E.size()) {
            this.E.get(N).f67886f = z16;
        }
        this.f67875d.setMuteAudio(z16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void c0(TransferData transferData) {
        VideoFilterPlayView videoFilterPlayView = this.f67875d;
        if (videoFilterPlayView != null) {
            videoFilterPlayView.setTransferData(transferData);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void d(Bitmap bitmap, boolean z16) {
        int N = this.mParent.N();
        if (N < this.E.size()) {
            a aVar = this.E.get(N);
            aVar.f67887g = bitmap;
            aVar.f67889i = aVar.f67889i || z16;
        }
        this.f67875d.setMosaicFilterType(bitmap);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        publishVideoEntry.videoNeedRotate = false;
        publishVideoEntry.videoRangeStart = this.f67878h;
        publishVideoEntry.videoRangeEnd = this.f67879i;
        publishVideoEntry.putExtra("local_import", Boolean.TRUE);
        bVar.f400387d.putExtra("video_rotation", Integer.valueOf(this.H));
        boolean f16 = com.tencent.biz.qqstory.utils.k.f(this.D);
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "landscape:" + f16 + " w:" + this.D.mediaWidth + " h:" + this.D.mediaHeight + " r:" + this.D.rotation);
        }
        bVar.f400387d.putExtra("landscape_video", Boolean.valueOf(f16));
        bVar.f400387d.putExtra("extra_is_need_gaussion_blur", Boolean.valueOf(this.L));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        VideoFilterPlayView videoFilterPlayView = this.f67875d;
        if (videoFilterPlayView == null || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
            return;
        }
        videoFilterPlayView.m();
        this.I = 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.b
    public void g0() {
        if (this.I == 2) {
            this.f67875d.l();
        } else {
            this.I = 1;
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
            VideoFilterPlayView videoFilterPlayView = this.f67875d;
            if (videoFilterPlayView != null) {
                videoFilterPlayView.n();
                this.I = 1;
            }
        } else if (i3 == 2) {
            this.f67875d.o();
            this.I = 0;
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        Bitmap x06;
        int i3 = message.what;
        if (i3 >= this.E.size() || (x06 = x0((aVar = this.E.get(i3)), false)) == null || x06 == aVar.f67935b) {
            return true;
        }
        a o16 = aVar.o(x06);
        this.E.set(i3, o16);
        hd0.c.l("Q.qqstory.record.HWEditImportVideoPlayer", "update fragment bitmap : %s", o16);
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public Bitmap m(int i3) {
        if (i3 < this.E.size()) {
            return x0(this.E.get(i3), true);
        }
        hd0.c.i("Q.qqstory.record.HWEditImportVideoPlayer", "getDurationOfFragment with invalid index = %d", Integer.valueOf(i3));
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        this.f67880m = new Handler();
        EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
        if (editSource instanceof EditLocalVideoSource) {
            EditLocalVideoSource editLocalVideoSource = (EditLocalVideoSource) editSource;
            String str = editLocalVideoSource.f204043d;
            this.f67877f = str;
            LocalMediaInfo localMediaInfo = editLocalVideoSource.f204044e;
            this.D = localMediaInfo;
            this.f67878h = editLocalVideoSource.f204045f;
            this.f67879i = editLocalVideoSource.f204046h;
            this.f67876e = str;
            if (localMediaInfo.mediaWidth == 0 || localMediaInfo.mediaHeight == 0) {
                d.a aVar = new d.a();
                com.tencent.mobileqq.shortvideo.util.d.a(this.f67876e, aVar);
                LocalMediaInfo localMediaInfo2 = this.D;
                int[] iArr = aVar.f288248a;
                localMediaInfo2.mediaWidth = iArr[0];
                localMediaInfo2.mediaHeight = iArr[1];
                localMediaInfo2.rotation = iArr[2];
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 2, "LocalMediaInfo:" + this.D.toString());
            }
            VideoFilterPlayView videoFilterPlayView = (VideoFilterPlayView) findViewSure(R.id.ruo);
            this.f67875d = videoFilterPlayView;
            videoFilterPlayView.setVisibility(0);
            EditVideoPartManager editVideoPartManager = this.mParent;
            if (editVideoPartManager.C.f204055d != 14) {
                this.H = this.f67875d.d(this.D);
            } else {
                if ((editVideoPartManager.f0() != null && this.mParent.f0().isLandTakePicToVideo()) || !com.tencent.biz.qqstory.utils.k.f(this.D)) {
                    this.H = this.f67875d.d(this.D);
                } else if (this.D.rotation == 180) {
                    this.H = this.f67875d.c(180);
                }
                if (com.tencent.biz.qqstory.utils.k.h()) {
                    q0();
                    QLog.d("Q.qqstory.record.HWEditImportVideoPlayer", 4, "adjust view size end");
                }
            }
            this.K = this.mParent.C.c("extra_is_fit_center", false);
            boolean c16 = this.mParent.C.c("extra_is_need_gaussion_blur", false);
            this.L = c16;
            if (c16) {
                this.f67875d.H(com.tencent.biz.qqstory.utils.k.f(this.D) ? -90 : 0);
            }
            this.f67875d.setMediaInfo(this.D);
            this.f67875d.setFilePath(this.f67876e, this.f67877f, true, this.K, this.L);
            Bundle bundle = this.mParent.Y;
            if (bundle != null) {
                VideoStoryDataBean videoStoryDataBean = (VideoStoryDataBean) bundle.getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
                this.M = videoStoryDataBean != null && videoStoryDataBean.isLandTakePicToVideo();
            }
            this.f67875d.setRepeat(true);
            this.f67875d.setSpeedType(0);
            this.f67875d.setDecodeListener(this);
            this.f67875d.setPlayViewListener(this);
            this.I = 0;
            publishEditExport(x.class, this);
            this.C.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.1
                /* JADX WARN: Removed duplicated region for block: B:35:0x010f  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x01a9 A[LOOP:1: B:12:0x0054->B:42:0x01a9, LOOP_END] */
                /* JADX WARN: Removed duplicated region for block: B:43:0x01ad A[EDGE_INSN: B:43:0x01ad->B:44:0x01ad BREAK  A[LOOP:1: B:12:0x0054->B:42:0x01a9], SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    long j3;
                    a.c d16;
                    Bitmap bitmap;
                    hd0.c.t("Q.qqstory.record.HWEditImportVideoPlayer", "thumb get start");
                    ArrayList<k.a> d17 = com.tencent.biz.qqstory.utils.k.d(HWEditImportVideoPlayer.this.f67876e, TTL.MAX_VALUE);
                    if (d17 == null) {
                        d17 = new ArrayList<>();
                        int i3 = 0;
                        while (true) {
                            long j16 = i3;
                            if (j16 >= HWEditImportVideoPlayer.this.D.mDuration / TTL.MAX_VALUE) {
                                break;
                            }
                            d17.add(new k.a(j16 * TTL.MAX_VALUE, TTL.MAX_VALUE));
                            i3++;
                        }
                    }
                    if (d17.size() <= 0) {
                        d17.add(new k.a(0L, HWEditImportVideoPlayer.this.D.mDuration));
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    for (int i16 = 0; i16 < d17.size(); i16++) {
                        k.a aVar2 = d17.get(i16);
                        long uptimeMillis2 = SystemClock.uptimeMillis();
                        long min = Math.min(HWEditImportVideoPlayer.this.f67878h + aVar2.f94470b, HWEditImportVideoPlayer.this.D.mDuration);
                        long j17 = min + 1000;
                        HWEditImportVideoPlayer hWEditImportVideoPlayer = HWEditImportVideoPlayer.this;
                        long j18 = hWEditImportVideoPlayer.D.mDuration;
                        if (j17 > j18) {
                            min = j18;
                        }
                        if (i16 != 5) {
                            j18 = min;
                        }
                        Bitmap c17 = nr.a.c(hWEditImportVideoPlayer.f67876e, HWEditImportVideoPlayer.this.f67878h);
                        if (i16 == 0 && c17 != null) {
                            float c18 = MediaCodecThumbnailGenerator.c(c17);
                            hd0.c.l("Q.qqstory.record.HWEditImportVideoPlayer", "blackPrecent = %f start fix black frame.", Float.valueOf(c18));
                            if (c18 > 0.9f && (bitmap = (d16 = nr.a.d(HWEditImportVideoPlayer.this.f67876e, HWEditImportVideoPlayer.this.f67878h)).f420732a) != null) {
                                j3 = j18;
                                if (d16.f420733b > 0 && MediaCodecThumbnailGenerator.c(bitmap) <= 0.9f) {
                                    if (!c17.isRecycled()) {
                                        c17.recycle();
                                    }
                                    c17 = d16.f420732a;
                                    HWEditImportVideoPlayer.this.f67878h = (int) (d16.f420733b / 1000);
                                    hd0.c.t("Q.qqstory.record.HWEditImportVideoPlayer", "Fix black frame. adjust star time to " + HWEditImportVideoPlayer.this.f67878h);
                                }
                                if (c17 != null) {
                                    int alainSize = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).alainSize(c17.getWidth());
                                    int alainSize2 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).alainSize(c17.getHeight());
                                    if (alainSize != c17.getWidth() || alainSize2 != c17.getHeight()) {
                                        hd0.c.v("Q.qqstory.record.HWEditImportVideoPlayer", "origin bitmap width:%d, height:%d, should change size to w:%d, h:%d", Integer.valueOf(c17.getWidth()), Integer.valueOf(c17.getHeight()), Integer.valueOf(alainSize), Integer.valueOf(alainSize));
                                        c17 = com.tencent.biz.qqstory.utils.b.d(c17, new Rect(0, 0, alainSize, alainSize2), true);
                                    }
                                }
                                a aVar3 = new a(i16, c17);
                                aVar3.f67883c = HWEditImportVideoPlayer.this.f67878h;
                                aVar3.f67884d = HWEditImportVideoPlayer.this.f67879i;
                                HWEditImportVideoPlayer.this.E.add(aVar3);
                                hd0.c.m("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info = %s, cost = %dms", aVar3, Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis2));
                                if (j3 < HWEditImportVideoPlayer.this.D.mDuration) {
                                    break;
                                }
                            }
                        }
                        j3 = j18;
                        if (c17 != null) {
                        }
                        a aVar32 = new a(i16, c17);
                        aVar32.f67883c = HWEditImportVideoPlayer.this.f67878h;
                        aVar32.f67884d = HWEditImportVideoPlayer.this.f67879i;
                        HWEditImportVideoPlayer.this.E.add(aVar32);
                        hd0.c.m("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info = %s, cost = %dms", aVar32, Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis2));
                        if (j3 < HWEditImportVideoPlayer.this.D.mDuration) {
                        }
                    }
                    hd0.c.m("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(HWEditImportVideoPlayer.this.E.size()), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                    for (int i17 = 0; i17 < HWEditImportVideoPlayer.this.E.size(); i17++) {
                        a aVar4 = HWEditImportVideoPlayer.this.E.get(i17);
                        String str2 = g.a.C0559a.f65250d + com.tencent.biz.qqstory.utils.d.m(HWEditImportVideoPlayer.this.f67876e) + "_" + i17 + ".IFrames.audio";
                        int b16 = com.tencent.mobileqq.editor.composite.step.a.b(HWEditImportVideoPlayer.this.f67877f, str2, (((float) aVar4.f67883c) * 1.0f) / ((float) HWEditImportVideoPlayer.this.D.mDuration), (((float) aVar4.f67884d) * 1.0f) / ((float) HWEditImportVideoPlayer.this.D.mDuration));
                        if (b16 == 0) {
                            hd0.c.a("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile finished audioFilePath" + str2);
                            aVar4.f67892l = str2;
                        } else {
                            hd0.c.i("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", Integer.valueOf(b16), str2, Long.valueOf(HWEditImportVideoPlayer.this.D.mDuration), Long.valueOf(aVar4.f67883c), Long.valueOf(aVar4.f67884d));
                        }
                    }
                    HWEditImportVideoPlayer.this.u0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (HWEditImportVideoPlayer.this.E.size() > 0) {
                                HWEditImportVideoPlayer.this.v0(HWEditImportVideoPlayer.this.E.get(0));
                            } else {
                                hd0.c.g("Q.qqstory.record.HWEditImportVideoPlayer", "mFragmentInfos is empty");
                            }
                            HWEditImportVideoPlayer.this.G.set(true);
                        }
                    }, 0L);
                }
            }, 200L);
            return;
        }
        throw new IllegalArgumentException("HWEditLocalVideoPlayer only support EditLocalVideoSource now");
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeError(int i3, Throwable th5) {
        QLog.e("Q.qqstory.record.HWEditImportVideoPlayer", 4, "onDecodeError errorCode = " + i3, th5);
        throw new RuntimeException(th5);
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFrame(long j3, final long j16) throws InterruptedException {
        u0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.3
            /* JADX WARN: Removed duplicated region for block: B:7:0x0033 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i3;
                EditVideoPartManager editVideoPartManager;
                long j17 = j16 / 1000000;
                if (j17 < HWEditImportVideoPlayer.this.f67878h) {
                    i3 = HWEditImportVideoPlayer.this.f67878h;
                } else {
                    if (j17 > HWEditImportVideoPlayer.this.f67879i) {
                        i3 = HWEditImportVideoPlayer.this.f67879i;
                    }
                    editVideoPartManager = HWEditImportVideoPlayer.this.mParent;
                    if (editVideoPartManager.f67784f) {
                        editVideoPartManager.s(Message.obtain(null, 13, new Long[]{Long.valueOf(j17), Long.valueOf(j16)}));
                        return;
                    }
                    return;
                }
                j17 = i3;
                editVideoPartManager = HWEditImportVideoPlayer.this.mParent;
                if (editVideoPartManager.f67784f) {
                }
            }
        }, 0L);
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeRepeat() {
        u0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                HWEditImportVideoPlayer hWEditImportVideoPlayer = HWEditImportVideoPlayer.this;
                if (hWEditImportVideoPlayer.mIsDestroy) {
                    return;
                }
                f fVar = (f) hWEditImportVideoPlayer.getEditExport(f.class);
                if (fVar != null) {
                    fVar.A();
                }
                HWEditImportVideoPlayer.this.mParent.s(Message.obtain((Handler) null, 14));
            }
        }, 0L);
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeStart() {
        u0(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                f fVar;
                HWEditImportVideoPlayer hWEditImportVideoPlayer = HWEditImportVideoPlayer.this;
                if (hWEditImportVideoPlayer.mIsDestroy || (fVar = (f) hWEditImportVideoPlayer.getEditExport(f.class)) == null) {
                    return;
                }
                fVar.A();
            }
        }, 200L);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        this.f67875d.o();
        this.I = 0;
        this.f67875d.setPlayViewListener(null);
        Handler handler = this.f67880m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
        if (com.tencent.mobileqq.monitor.a.f247270d) {
            VideoFilterPlayView videoFilterPlayView = this.f67875d;
            if (videoFilterPlayView.f67502d0 <= 100 || videoFilterPlayView.f67500c0 <= 0) {
                return;
            }
            int K = this.mParent.K();
            float f16 = (r2.f67502d0 / ((float) this.f67875d.f67500c0)) * 1000.0f;
            if (id0.a.g((int) f16, 0L, 30L)) {
                id0.a.r("CamEditFreq", true, 0L, String.valueOf(this.mParent.C.f204055d), String.valueOf(f16), id0.a.b(K), String.valueOf(this.f67875d.f67502d0), String.valueOf(this.f67875d.f67500c0));
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onPause() {
        super.onPause();
        this.f67875d.l();
        this.f67875d.onPause();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        super.onResume();
        this.f67875d.onResume();
        if (this.I != 2) {
            this.f67875d.m();
        } else {
            this.f67875d.l();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onStop() {
        super.onStop();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void pause() {
        VideoFilterPlayView videoFilterPlayView = this.f67875d;
        videoFilterPlayView.Q = false;
        videoFilterPlayView.l();
        this.I = 2;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void play() {
        this.f67875d.m();
        this.I = 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void setPlayMode(int i3) {
        hd0.c.b("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode mode=%s", Integer.valueOf(i3));
        int N = this.mParent.N();
        if (N < this.E.size()) {
            a aVar = this.E.get(N);
            if (aVar.f67885e != i3) {
                aVar.f67885e = i3;
                aVar.f67888h = true;
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void setVolume(float f16) {
        this.f67875d.setVolume(f16);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void u(int i3, byte[] bArr) {
        throw new UnsupportedOperationException("please use setMosaicMp4(Bitmap,boolean) instead");
    }

    public void u0(Runnable runnable, long j3) {
        Handler handler = this.f67880m;
        if (handler != null) {
            if (j3 != 0) {
                handler.postDelayed(runnable, j3);
            } else {
                handler.post(runnable);
            }
        }
    }

    public void w0(int i3) {
        int t06 = t0(i3);
        if (t06 == 5 && this.E.size() > 0) {
            a aVar = this.E.get(this.F);
            if (aVar.f67891k == null) {
                this.f67875d.l();
                this.I = 2;
            } else {
                hd0.c.a("Q.qqstory.record.HWEditImportVideoPlayer", "setPlayMode change to iframe video");
                v0(aVar);
            }
            this.f67875d.setSpeedType(5);
            return;
        }
        this.f67875d.setSpeedType(t06);
        this.f67875d.m();
        this.I = 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.b
    public void N() {
        this.I = 0;
    }

    public static Bitmap r0(Context context, Bitmap bitmap, mr.a aVar) {
        Bitmap copy;
        if (bitmap == null || aVar == null) {
            return null;
        }
        Pair<Integer, Integer> b16 = com.tencent.biz.qqstory.utils.k.b(bitmap.getWidth(), bitmap.getHeight(), ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
        int intValue = ((Integer) b16.first).intValue();
        int intValue2 = ((Integer) b16.second).intValue();
        int i3 = com.tencent.mobileqq.editor.composite.step.b.f204002c;
        if (intValue2 > i3) {
            intValue = (int) ((intValue * i3) / intValue2);
            intValue2 = i3;
        }
        int alainSize = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).alainSize(intValue);
        int alainSize2 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).alainSize(intValue2);
        aVar.c(alainSize, alainSize2);
        GaussianBlurFilter gaussianBlurFilter = new GaussianBlurFilter();
        gaussianBlurFilter.init(bitmap.getWidth(), bitmap.getHeight());
        if (gaussianBlurFilter.isInitSucc()) {
            copy = BaseImageUtil.gaussionBlur(context, BaseImageUtil.rgb565Toargb888(bitmap), 0.4f, 25.0f);
            if (copy != null) {
                Canvas canvas = new Canvas();
                canvas.setBitmap(copy.isMutable() ? copy : copy.copy(copy.getConfig(), true));
                canvas.drawColor(Color.parseColor("#3F000000"), PorterDuff.Mode.SRC_OVER);
            }
        } else {
            copy = bitmap.copy(bitmap.getConfig(), true);
            Canvas canvas2 = new Canvas();
            canvas2.setBitmap(copy.isMutable() ? copy : copy.copy(copy.getConfig(), true));
            canvas2.drawColor(Color.parseColor("#CC000000"), PorterDuff.Mode.SRC_OVER);
        }
        Bitmap l3 = com.tencent.biz.qqstory.utils.b.l(com.tencent.biz.qqstory.utils.b.n(copy, alainSize, alainSize2, true), bitmap);
        gaussianBlurFilter.destroy();
        return l3;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.x
    public void d0(int i3, int i16, float f16) {
        float f17 = 1.0f - f16;
        if (f17 != 0.0f && f17 <= 0.95f) {
            EditVideoParams.EditSource editSource = this.mParent.C.f204059i;
            if (editSource instanceof EditLocalVideoSource) {
                this.f67875d.setColorFilterType(s0(i3), s0(i16), f17, ((EditLocalVideoSource) editSource).f204044e.rotation);
                return;
            } else {
                if (editSource instanceof EditTakeVideoSource) {
                    this.f67875d.setColorFilterType(s0(i3), s0(i16), f17, 0);
                    return;
                }
                return;
            }
        }
        this.f67875d.setColorFilterType(s0(i3));
        w0(i3);
        hd0.c.d("Q.qqstory.record.HWEditImportVideoPlayer", "setSlideMode lefPlayMode=%s rightMode=%s, offset=%s", Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
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
