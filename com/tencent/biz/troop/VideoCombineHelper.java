package com.tencent.biz.troop;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandUnit;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VideoCombineHelper {

    /* renamed from: g, reason: collision with root package name */
    protected static final String f96661g = AppConstants.SDCARD_ROOT + "/Tencent/QQ_business/videocombine";

    /* renamed from: b, reason: collision with root package name */
    FFmpeg f96663b;

    /* renamed from: c, reason: collision with root package name */
    QBaseActivity f96664c;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.biz.troop.b f96665d;

    /* renamed from: a, reason: collision with root package name */
    long f96662a = 0;

    /* renamed from: e, reason: collision with root package name */
    Object f96666e = new Object();

    /* renamed from: f, reason: collision with root package name */
    HashMap<String, g> f96667f = new HashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.biz.troop.VideoCombineHelper$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ VideoCombineHelper this$0;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.troop.VideoCombineHelper$4$a */
        /* loaded from: classes5.dex */
        class a extends l {
            a() {
                super();
            }

            @Override // com.tencent.biz.troop.VideoCombineHelper.l
            public void b(k kVar) {
                QLog.d(".troop.VideoCombineHelper", 2, "");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb5 = new StringBuilder();
            String str = VideoCombineHelper.f96661g;
            sb5.append(str);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("v1.mp4");
            File file = new File(sb5.toString());
            File file2 = new File(str + str2 + "v2.mp4");
            File file3 = new File(str + str2 + "v3.mp4");
            File file4 = new File(str + str2 + "v4.mp4");
            File file5 = new File(str + str2 + "m1.m4a");
            ArrayList arrayList = new ArrayList();
            arrayList.add(file4.getAbsolutePath());
            arrayList.add(file2.getAbsolutePath());
            arrayList.add(file3.getAbsolutePath());
            arrayList.add(file.getAbsolutePath());
            new CombineTask(new a(), "key", arrayList, file5.getAbsolutePath(), HardCodeUtil.qqStr(R.string.f172876v01)).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class CombineTask extends k {

        /* renamed from: f, reason: collision with root package name */
        List<String> f96679f;

        /* renamed from: g, reason: collision with root package name */
        String f96680g;

        /* renamed from: h, reason: collision with root package name */
        String f96681h;

        /* renamed from: i, reason: collision with root package name */
        int f96682i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a implements e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f96684a;

            /* compiled from: P */
            /* renamed from: com.tencent.biz.troop.VideoCombineHelper$CombineTask$a$a, reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            class C0978a implements e {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f96686a;

                /* compiled from: P */
                /* renamed from: com.tencent.biz.troop.VideoCombineHelper$CombineTask$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                class C0979a implements e {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ long f96688a;

                    C0979a(long j3) {
                        this.f96688a = j3;
                    }

                    @Override // com.tencent.biz.troop.VideoCombineHelper.e
                    public void a(String str, boolean z16, String str2) {
                        if (QLog.isColorLevel()) {
                            QLog.d(".troop.VideoCombineHelper", 2, "combineWording end! isSuccess:" + z16 + " path = " + str);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("combineWordingTime:");
                            sb5.append(System.currentTimeMillis() - this.f96688a);
                            QLog.d(".troop.trace_video_combine", 2, sb5.toString());
                        }
                        File file = new File(str);
                        if (z16 && file.exists()) {
                            a aVar = a.this;
                            aVar.f96684a.f96724j = str;
                            CombineTask combineTask = CombineTask.this;
                            combineTask.f96737a.b(combineTask);
                            CombineTask.this.e();
                            return;
                        }
                        CombineTask combineTask2 = CombineTask.this;
                        combineTask2.f96740d = str2;
                        combineTask2.f96737a.a(combineTask2);
                    }
                }

                C0978a(long j3) {
                    this.f96686a = j3;
                }

                @Override // com.tencent.biz.troop.VideoCombineHelper.e
                public void a(String str, boolean z16, String str2) {
                    if (QLog.isColorLevel()) {
                        QLog.d(".troop.VideoCombineHelper", 2, "combineMp4_M4a end! isSuccess:" + z16 + " path = " + str);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("combineMp4_M4aTime:");
                        sb5.append(System.currentTimeMillis() - this.f96686a);
                        QLog.d(".troop.trace_video_combine", 2, sb5.toString());
                    }
                    File file = new File(str);
                    if (z16 && file.exists()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        CombineTask combineTask = CombineTask.this;
                        combineTask.g(file, combineTask.f96681h, new C0979a(currentTimeMillis));
                    } else {
                        CombineTask combineTask2 = CombineTask.this;
                        combineTask2.f96740d = str2;
                        combineTask2.f96737a.a(combineTask2);
                    }
                }
            }

            /* compiled from: P */
            /* loaded from: classes5.dex */
            class b implements e {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f96690a;

                b(long j3) {
                    this.f96690a = j3;
                }

                @Override // com.tencent.biz.troop.VideoCombineHelper.e
                public void a(String str, boolean z16, String str2) {
                    if (QLog.isColorLevel()) {
                        QLog.d(".troop.VideoCombineHelper", 2, "combineWording end! isSuccess:" + z16 + " path = " + str);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("combineWordingTime:");
                        sb5.append(System.currentTimeMillis() - this.f96690a);
                        QLog.d(".troop.trace_video_combine", 2, sb5.toString());
                    }
                    File file = new File(str);
                    if (z16 && file.exists()) {
                        a aVar = a.this;
                        aVar.f96684a.f96724j = str;
                        CombineTask combineTask = CombineTask.this;
                        combineTask.f96737a.b(combineTask);
                        CombineTask.this.e();
                        return;
                    }
                    CombineTask combineTask2 = CombineTask.this;
                    combineTask2.f96740d = str2;
                    combineTask2.f96737a.a(combineTask2);
                }
            }

            a(g gVar) {
                this.f96684a = gVar;
            }

            @Override // com.tencent.biz.troop.VideoCombineHelper.e
            public void a(String str, boolean z16, String str2) {
                if (QLog.isColorLevel()) {
                    QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + z16 + " path = " + str);
                }
                File file = new File(str);
                if (z16 && file.exists()) {
                    if (this.f96684a.f96715a) {
                        CombineTask combineTask = CombineTask.this;
                        combineTask.f96737a.b(combineTask);
                        return;
                    } else if (CombineTask.this.f96680g != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        CombineTask combineTask2 = CombineTask.this;
                        VideoCombineHelper.this.a(str, combineTask2.f96680g, new C0978a(currentTimeMillis));
                        return;
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        CombineTask combineTask3 = CombineTask.this;
                        combineTask3.g(file, combineTask3.f96681h, new b(currentTimeMillis2));
                        return;
                    }
                }
                CombineTask combineTask4 = CombineTask.this;
                combineTask4.f96740d = str2;
                combineTask4.f96737a.a(combineTask4);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class b extends i {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f96692b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f96693c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ File f96694d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(long j3, e eVar, File file) {
                super();
                this.f96692b = j3;
                this.f96693c = eVar;
                this.f96694d = file;
            }

            @Override // com.tencent.biz.troop.VideoCombineHelper.i
            public void a(boolean z16) {
                if (QLog.isColorLevel()) {
                    QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.f96692b));
                }
                this.f96693c.a(this.f96694d.getAbsolutePath(), z16, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class c extends ExecuteBinResponseCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f96696a;

            c(i iVar) {
                this.f96696a = iVar;
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onFailure(String str) {
                QLog.w(".troop.VideoCombineHelper", 1, "concatMediaByTs change ts onSuccess: " + str);
                this.f96696a.onFailure(str);
            }

            @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
            public void onSuccess(String str) {
                if (QLog.isColorLevel()) {
                    QLog.w(".troop.trace_video_combine", 2, "concatMediaByTs change ts onSuccess: " + str);
                    QLog.d(".troop.trace_video_combine", 2, "convertToTsTime = " + (System.currentTimeMillis() - VideoCombineHelper.this.f96662a));
                }
                VideoCombineHelper.this.f96662a = System.currentTimeMillis();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class d extends i {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f96698b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f96699c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(e eVar, String str) {
                super();
                this.f96698b = eVar;
                this.f96699c = str;
            }

            @Override // com.tencent.biz.troop.VideoCombineHelper.i
            public void a(boolean z16) {
                if (QLog.isColorLevel()) {
                    QLog.d(".troop.VideoCombineHelper", 2, "watermark doen");
                }
                this.f96698b.a(this.f96699c, z16, null);
            }
        }

        public CombineTask(l lVar, String str, List<String> list, String str2, String str3) {
            super(lVar, str);
            this.f96682i = 0;
            this.f96680g = str2;
            this.f96681h = str3;
            this.f96679f = list;
            this.f96739c = new j(lVar, str);
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.k
        public void d() {
            List<String> list = this.f96679f;
            if (list != null && list.size() > 0) {
                String str = b() + File.separator + "v.ts";
                g c16 = c();
                if (c16.f96716b) {
                    this.f96737a.b(this);
                } else {
                    f(this.f96679f, str, new a(c16));
                }
            }
        }

        public void f(List<String> list, String str, e eVar) {
            if (list != null && this.f96679f.size() != 0) {
                if (list.size() == 1) {
                    eVar.a(this.f96679f.get(0), true, "combineVideos Success size = 1");
                    return;
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(str);
                    h(this.f96679f, file.getAbsolutePath(), new b(currentTimeMillis, eVar, file));
                    return;
                } catch (Exception e16) {
                    QLog.e(".troop.VideoCombineHelper", 2, "combineVideos failed", e16);
                    return;
                }
            }
            eVar.a("", false, "videoFiles empty!");
        }

        public File g(File file, String str, e eVar) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            mediaMetadataRetriever.release();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(file.getParent());
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("wording.png");
            String sb6 = sb5.toString();
            String str3 = file.getParent() + str2 + "vmw.mp4";
            try {
                int parseInt = Integer.parseInt(extractMetadata);
                int parseInt2 = Integer.parseInt(extractMetadata2);
                long currentTimeMillis = System.currentTimeMillis();
                i(parseInt, parseInt2, str, sb6);
                if (QLog.isColorLevel()) {
                    QLog.d(".troop.trace_video_combine", 2, "createWatermarkPng time = " + (System.currentTimeMillis() - currentTimeMillis));
                }
                c().f96725k.add(new File(sb6));
                VideoCombineHelper.this.f96663b.watermark(sb6, file.getAbsolutePath(), str3, parseInt, parseInt2, new d(eVar, str3));
                return null;
            } catch (Exception e16) {
                QLog.e(".troop.VideoCombineHelper", 2, "combineWording failed!", e16);
                return null;
            }
        }

        public void h(List<String> list, String str, i iVar) throws FFmpegCommandAlreadyRunningException, IOException {
            File file = new File(str);
            if (file.exists() && file.length() > 0) {
                iVar.a(true);
                return;
            }
            ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
            VideoCombineHelper.this.f96662a = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer("concat:");
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str2 = list.get(i3);
                File file2 = new File(str2);
                String str3 = file2.getAbsoluteFile().getParent() + File.separator + file2.getName().split("\\.")[0] + ".ts";
                stringBuffer.append(str3);
                if (i3 != list.size() - 1) {
                    stringBuffer.append("|");
                }
                File file3 = new File(str3);
                if (!file3.exists() || file3.length() <= 0) {
                    if (!file3.getParentFile().exists()) {
                        file3.getParentFile().mkdirs();
                    }
                    FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
                    fFmpegCommandUnit.cmdType = 5;
                    fFmpegCommandUnit.arguments = new ArrayList<Object>(str2, str3) { // from class: com.tencent.biz.troop.VideoCombineHelper.CombineTask.3
                        final /* synthetic */ String val$inputPath;
                        final /* synthetic */ String val$tsFilePath;

                        {
                            this.val$inputPath = str2;
                            this.val$tsFilePath = str3;
                            add(str2);
                            add(str3);
                        }
                    };
                    fFmpegCommandUnit.callback = new c(iVar);
                    arrayList.add(fFmpegCommandUnit);
                }
            }
            File file4 = new File(str);
            String str4 = file4.getParent() + File.separator + file4.getName().split("\\.")[0] + ".ts";
            FFmpegCommandUnit fFmpegCommandUnit2 = new FFmpegCommandUnit();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("-y");
            arrayList2.add(Argument.FILE_INPUT);
            arrayList2.add(stringBuffer.toString());
            arrayList2.add(LogCmdOptions.CLEAR);
            arrayList2.add("copy");
            arrayList2.add(str4);
            fFmpegCommandUnit2.cmd = (String[]) arrayList2.toArray(new String[0]);
            fFmpegCommandUnit2.callback = iVar;
            arrayList.add(fFmpegCommandUnit2);
            if (VideoCombineHelper.this.f96663b.isFFmpegCommandRunning()) {
                try {
                    VideoCombineHelper.this.f96663b.insertFFmpegQueue(arrayList);
                    return;
                } catch (FFmpegCommandAlreadyRunningException e16) {
                    e16.printStackTrace();
                    return;
                } catch (IOException e17) {
                    e17.printStackTrace();
                    return;
                }
            }
            try {
                VideoCombineHelper.this.f96663b.cmdFFmpegQueue(arrayList);
            } catch (FFmpegCommandAlreadyRunningException e18) {
                e18.printStackTrace();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
        }

        public boolean i(int i3, int i16, String str, String str2) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setColor(-1);
                paint.setTextSize(30.0f);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.getTextBounds(str, 0, str.length(), new Rect());
                Paint paint2 = new Paint();
                paint2.setColor(-16777216);
                RectF rectF = new RectF();
                rectF.top = ((i16 - r5.height()) - 15) - 15;
                rectF.left = ((i3 - r5.width()) / 2) - 15;
                rectF.bottom = rectF.top + r5.height() + 15;
                rectF.right = rectF.left + r5.width() + 30;
                canvas.drawRoundRect(rectF, 8.0f, 8.0f, paint2);
                canvas.drawText(str, i3 / 2, (i16 - 15) - (r5.height() / 2), paint);
                com.tencent.biz.qqstory.utils.b.a(createBitmap, Bitmap.CompressFormat.PNG, 100, str2);
                com.tencent.biz.qqstory.utils.b.m(createBitmap);
                return true;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(".troop.VideoCombineHelper", 2, "createWatermarkByWording", th5);
                }
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f96701b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f96702c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e eVar, String str) {
            super();
            this.f96701b = eVar;
            this.f96702c = str;
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.i
        public void a(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d(".troop.VideoCombineHelper", 2, "splitAudio end : isSuccess = " + z16);
                QLog.d(".troop.trace_video_combine", 2, "splitAudioTime: " + (System.currentTimeMillis() - VideoCombineHelper.this.f96662a));
                VideoCombineHelper.this.f96662a = System.currentTimeMillis();
            }
            if (!z16) {
                this.f96701b.a(this.f96702c, false, "splitAudio done.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f96704b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f96705c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e eVar, String str) {
            super();
            this.f96704b = eVar;
            this.f96705c = str;
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.i
        public void a(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d(".troop.VideoCombineHelper", 2, "splitVideoUnit end : isSuccess = " + z16);
                QLog.d(".troop.trace_video_combine", 2, "splitVideoTime: " + (System.currentTimeMillis() - VideoCombineHelper.this.f96662a));
                VideoCombineHelper.this.f96662a = System.currentTimeMillis();
            }
            if (!z16) {
                this.f96704b.a(this.f96705c, false, "splitVideo done.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f96707b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f96708c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(e eVar, String str) {
            super();
            this.f96707b = eVar;
            this.f96708c = str;
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.i
        public void a(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d(".troop.VideoCombineHelper", 2, "mixAudio end : isSuccess = " + z16);
                QLog.d(".troop.trace_video_combine", 2, "mixAudioTime: " + (System.currentTimeMillis() - VideoCombineHelper.this.f96662a));
                VideoCombineHelper.this.f96662a = System.currentTimeMillis();
            }
            if (!z16) {
                this.f96707b.a(this.f96708c, false, "mixAudio done.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f96710b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f96711c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f96712d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(e eVar, String str, String str2) {
            super();
            this.f96710b = eVar;
            this.f96711c = str;
            this.f96712d = str2;
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.i
        public void a(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d(".troop.VideoCombineHelper", 2, "combineUnit end : isSuccess = " + z16);
                QLog.d(".troop.trace_video_combine", 2, "combineAudioAndVideoTime: " + (System.currentTimeMillis() - VideoCombineHelper.this.f96662a));
                VideoCombineHelper.this.f96662a = System.currentTimeMillis();
            }
            if (z16) {
                this.f96710b.a(this.f96711c, true, "cmobine auido video done.");
            } else {
                this.f96710b.a(this.f96712d, false, "cmobine auido video done.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface e {
        void a(String str, boolean z16, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f extends k {
        public f(l lVar, String str) {
            super(lVar, str);
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.k
        public void d() {
            this.f96737a.b(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        boolean f96715a;

        /* renamed from: c, reason: collision with root package name */
        String f96717c;

        /* renamed from: e, reason: collision with root package name */
        public String f96719e;

        /* renamed from: f, reason: collision with root package name */
        public String f96720f;

        /* renamed from: g, reason: collision with root package name */
        public int f96721g;

        /* renamed from: i, reason: collision with root package name */
        public String f96723i;

        /* renamed from: j, reason: collision with root package name */
        public String f96724j;

        /* renamed from: b, reason: collision with root package name */
        boolean f96716b = false;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<String> f96718d = new ArrayList<>();

        /* renamed from: h, reason: collision with root package name */
        public ArrayList<String> f96722h = new ArrayList<>();

        /* renamed from: k, reason: collision with root package name */
        public ArrayList<File> f96725k = new ArrayList<>();

        public g() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class h extends k {

        /* renamed from: f, reason: collision with root package name */
        ArrayList<String> f96727f;

        /* renamed from: g, reason: collision with root package name */
        HashMap<String, File> f96728g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a extends com.tencent.mobileqq.vip.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f96730a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ArrayList f96731b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f96732c;

            a(g gVar, ArrayList arrayList, long j3) {
                this.f96730a = gVar;
                this.f96731b = arrayList;
                this.f96732c = j3;
            }

            @Override // com.tencent.mobileqq.vip.f
            public void onDone(com.tencent.mobileqq.vip.g gVar) {
                if (gVar.f313006d == 0) {
                    Iterator<File> it = h.this.f96728g.values().iterator();
                    while (it.hasNext()) {
                        if (!it.next().exists()) {
                            h hVar = h.this;
                            hVar.f96737a.a(hVar);
                            return;
                        }
                    }
                    try {
                        Iterator<String> it5 = this.f96730a.f96722h.iterator();
                        int i3 = 1;
                        while (it5.hasNext()) {
                            String next = it5.next();
                            File file = new File(h.this.b() + File.separator + "v_" + i3 + ".mp4");
                            this.f96731b.add(file.getAbsolutePath());
                            if (!file.exists()) {
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                com.tencent.biz.qqstory.utils.d.e(new File(next), file);
                            }
                            i3++;
                        }
                    } catch (IOException e16) {
                        QLog.e(".troop.VideoCombineHelper", 1, e16, new Object[0]);
                        h hVar2 = h.this;
                        hVar2.f96737a.a(hVar2);
                    }
                    this.f96730a.f96722h = this.f96731b;
                    h hVar3 = h.this;
                    hVar3.f96737a.b(hVar3);
                    h hVar4 = h.this;
                    VideoCombineHelper videoCombineHelper = VideoCombineHelper.this;
                    l lVar = hVar4.f96737a;
                    String str = hVar4.f96738b;
                    g gVar2 = this.f96730a;
                    hVar4.f96739c = new CombineTask(lVar, str, gVar2.f96722h, gVar2.f96723i, gVar2.f96720f);
                    if (VideoEnvironment.checkAndLoadAVCodec()) {
                        h.this.e();
                    } else if (this.f96730a.f96715a) {
                        h hVar5 = h.this;
                        hVar5.f96737a.b(hVar5.f96739c);
                    } else {
                        h hVar6 = h.this;
                        hVar6.f96737a.a(hVar6.f96739c);
                    }
                    QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - this.f96732c));
                    return;
                }
                h.this.f96740d = "donwload failed!code = " + gVar.f313006d + "errmsg = " + gVar.f313007e;
                h hVar7 = h.this;
                hVar7.f96737a.a(hVar7);
            }
        }

        public h(l lVar, String str) {
            super(lVar, str);
            this.f96727f = new ArrayList<>();
            this.f96728g = new HashMap<>();
            g c16 = c();
            if (c16 != null) {
                for (int i3 = 0; i3 < c16.f96718d.size(); i3++) {
                    String str2 = c16.f96718d.get(i3);
                    String f16 = f(str2, ".mp4");
                    c16.f96722h.add(f16);
                    if (!new File(f16).exists() && !this.f96727f.contains(str2)) {
                        this.f96727f.add(str2);
                        this.f96728g.put(str2, new File(f16));
                    }
                }
                if (!TextUtils.isEmpty(c16.f96719e)) {
                    File file = new File(f(c16.f96719e, ".m4a"));
                    if (!file.exists()) {
                        this.f96727f.add(c16.f96719e);
                        this.f96728g.put(c16.f96719e, new File(file.getAbsolutePath()));
                    }
                    c16.f96723i = file.getAbsolutePath();
                }
            }
        }

        private String f(String str, String str2) {
            String str3 = a().getAbsolutePath() + File.separator + "v_" + UUID.nameUUIDFromBytes(str.getBytes()).toString() + str2;
            File file = new File(str3);
            if (!file.getParentFile().exists()) {
                file.mkdirs();
            }
            return str3;
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.k
        public void d() {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle bundle = new Bundle();
            g c16 = c();
            if (c16.f96716b) {
                this.f96737a.b(this);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            if (this.f96727f.size() > 0) {
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(this.f96727f, this.f96728g, this.f96738b);
                gVar.f313008f = 3;
                VideoCombineHelper.this.c().startDownload(gVar, new a(c16, arrayList, currentTimeMillis), bundle);
            } else {
                try {
                    Iterator<String> it = c16.f96722h.iterator();
                    int i3 = 1;
                    while (it.hasNext()) {
                        String next = it.next();
                        File file = new File(b() + File.separator + "v_" + i3 + ".mp4");
                        arrayList.add(file.getAbsolutePath());
                        if (!file.exists()) {
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            com.tencent.biz.qqstory.utils.d.e(new File(next), file);
                        }
                        i3++;
                    }
                } catch (IOException e16) {
                    QLog.e(".troop.VideoCombineHelper", 1, e16, new Object[0]);
                    this.f96737a.a(this);
                }
                c16.f96722h = arrayList;
                this.f96737a.b(this);
                this.f96739c = new CombineTask(this.f96737a, this.f96738b, c16.f96722h, c16.f96723i, c16.f96720f);
                if (VideoEnvironment.checkAndLoadAVCodec()) {
                    e();
                } else if (c16.f96715a) {
                    this.f96737a.b(this.f96739c);
                } else {
                    k kVar = this.f96739c;
                    kVar.f96740d = "lib not ready";
                    this.f96737a.a(kVar);
                }
                QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (QLog.isColorLevel()) {
                QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.f96738b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class j extends k {

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements ITroopMemberApiClientApi.a {
            a() {
            }

            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public void callback(Bundle bundle) {
                VideoCombineHelper.this.f96665d.q();
            }
        }

        public j(l lVar, String str) {
            super(lVar, str);
        }

        @Override // com.tencent.biz.troop.VideoCombineHelper.k
        public void d() {
            VideoCombineHelper.this.f96665d.p();
            g c16 = c();
            VideoCombineHelper.this.f96665d.A0(c16.f96724j, c16.f96717c, c16.f96721g, new a());
            this.f96737a.b(this);
            this.f96739c = new f(this.f96737a, this.f96738b);
            e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public abstract class k {

        /* renamed from: a, reason: collision with root package name */
        l f96737a;

        /* renamed from: b, reason: collision with root package name */
        String f96738b;

        /* renamed from: c, reason: collision with root package name */
        k f96739c;

        /* renamed from: d, reason: collision with root package name */
        String f96740d;

        public k(l lVar, String str) {
            this.f96737a = lVar;
            this.f96738b = str;
        }

        public File a() {
            File file = new File(VideoCombineHelper.f96661g + File.separator + "cache");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public File b() {
            int indexOf = this.f96738b.indexOf("_");
            String str = this.f96738b;
            File file = new File(VideoCombineHelper.f96661g + File.separator + str.substring(indexOf + 1, str.length()));
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public g c() {
            g gVar;
            synchronized (VideoCombineHelper.this.f96666e) {
                gVar = VideoCombineHelper.this.f96667f.get(this.f96738b);
            }
            return gVar;
        }

        public abstract void d();

        public void e() {
            k kVar = this.f96739c;
            if (kVar != null) {
                kVar.d();
            }
        }
    }

    public VideoCombineHelper(QBaseActivity qBaseActivity) {
        File file = new File(f96661g);
        if (!file.exists()) {
            file.mkdirs();
        }
        FFmpeg fFmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
        this.f96663b = fFmpeg;
        fFmpeg.setFFMpegCanExe();
        this.f96664c = qBaseActivity;
        this.f96665d = com.tencent.biz.troop.b.A();
    }

    public void a(String str, String str2, e eVar) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ArrayList<FFmpegCommandUnit> arrayList = new ArrayList<>();
        this.f96662a = System.currentTimeMillis();
        FFmpegCommandUnit fFmpegCommandUnit = new FFmpegCommandUnit();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(parentFile.getAbsolutePath());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append("vn.m4a");
        String sb6 = sb5.toString();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("-y");
        arrayList2.add(Argument.FILE_INPUT);
        arrayList2.add(str);
        arrayList2.add("-strict");
        arrayList2.add("-2");
        arrayList2.add(Argument.AUDIO_CODEC);
        arrayList2.add(FileReaderHelper.AAC_EXT);
        arrayList2.add("-vn");
        arrayList2.add(sb6);
        fFmpegCommandUnit.cmd = (String[]) arrayList2.toArray(new String[0]);
        fFmpegCommandUnit.callback = new a(eVar, str);
        arrayList.add(fFmpegCommandUnit);
        arrayList2.clear();
        FFmpegCommandUnit fFmpegCommandUnit2 = new FFmpegCommandUnit();
        String str4 = parentFile.getAbsolutePath() + str3 + "an.ts";
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("-y");
        arrayList3.add(Argument.FILE_INPUT);
        arrayList3.add(str);
        arrayList3.add(Argument.VIDEO_CODEC);
        arrayList3.add("copy");
        arrayList3.add("-an");
        arrayList3.add(str4);
        fFmpegCommandUnit2.cmd = (String[]) arrayList3.toArray(new String[0]);
        fFmpegCommandUnit2.callback = new b(eVar, str);
        arrayList.add(fFmpegCommandUnit2);
        FFmpegCommandUnit fFmpegCommandUnit3 = new FFmpegCommandUnit();
        String str5 = parentFile.getAbsolutePath() + str3 + "mixed.m4a";
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("-y");
        arrayList4.add(Argument.FILE_INPUT);
        arrayList4.add(sb6);
        arrayList4.add(Argument.FILE_INPUT);
        arrayList4.add(str2);
        arrayList4.add(Argument.FILTER_COMPLEX);
        arrayList4.add("amix=inputs=2:duration=first:dropout_transition=2");
        arrayList4.add(str5);
        fFmpegCommandUnit3.cmd = (String[]) arrayList4.toArray(new String[0]);
        fFmpegCommandUnit3.callback = new c(eVar, str);
        arrayList.add(fFmpegCommandUnit3);
        FFmpegCommandUnit fFmpegCommandUnit4 = new FFmpegCommandUnit();
        String str6 = parentFile.getAbsolutePath() + str3 + "combine.mp4";
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("-y");
        arrayList5.add(Argument.FILE_INPUT);
        arrayList5.add(str4);
        arrayList5.add(Argument.FILE_INPUT);
        arrayList5.add(str5);
        arrayList5.add("-strict");
        arrayList5.add("2");
        arrayList5.add(Argument.VIDEO_CODEC);
        arrayList5.add("copy");
        arrayList5.add(Argument.AUDIO_CODEC);
        arrayList5.add(FileReaderHelper.AAC_EXT);
        arrayList5.add(str6);
        fFmpegCommandUnit4.cmd = (String[]) arrayList5.toArray(new String[0]);
        fFmpegCommandUnit4.callback = new d(eVar, str6, str);
        arrayList.add(fFmpegCommandUnit4);
        arrayList5.clear();
        if (this.f96663b.isFFmpegCommandRunning()) {
            try {
                this.f96663b.insertFFmpegQueue(arrayList);
                return;
            } catch (FFmpegCommandAlreadyRunningException e16) {
                e16.printStackTrace();
                return;
            } catch (IOException e17) {
                e17.printStackTrace();
                return;
            }
        }
        try {
            this.f96663b.cmdFFmpegQueue(arrayList);
        } catch (FFmpegCommandAlreadyRunningException e18) {
            e18.printStackTrace();
        } catch (IOException e19) {
            e19.printStackTrace();
        }
    }

    public String b(final g gVar, final e eVar) {
        UUID nameUUIDFromBytes = UUID.nameUUIDFromBytes(gVar.f96720f.getBytes());
        final String str = "combineVideo_" + nameUUIDFromBytes.toString();
        String str2 = "prepareVideo_" + nameUUIDFromBytes.toString();
        synchronized (this.f96666e) {
            if (this.f96667f.containsKey(str2)) {
                this.f96667f.get(str2).f96716b = true;
                Looper.prepare();
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.biz.troop.VideoCombineHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoCombineHelper.this.b(gVar, eVar);
                    }
                }, 300L);
                return str;
            }
            this.f96667f.put(str, gVar);
            final long currentTimeMillis = System.currentTimeMillis();
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.troop.VideoCombineHelper.2

                /* compiled from: P */
                /* renamed from: com.tencent.biz.troop.VideoCombineHelper$2$a */
                /* loaded from: classes5.dex */
                class a extends l {
                    a() {
                        super();
                    }

                    @Override // com.tencent.biz.troop.VideoCombineHelper.l
                    public void a(k kVar) {
                        if (kVar instanceof h) {
                            eVar.a("", false, "download failed! msg = " + kVar.f96740d);
                            return;
                        }
                        if (kVar instanceof CombineTask) {
                            eVar.a("", false, "combine failed! msg = " + kVar.f96740d);
                            return;
                        }
                        if (kVar instanceof j) {
                            eVar.a("", false, "sending failed! msg = " + kVar.f96740d);
                        }
                    }

                    @Override // com.tencent.biz.troop.VideoCombineHelper.l
                    public void b(k kVar) {
                        if (kVar instanceof j) {
                            eVar.a(kVar.c().f96724j, true, "seding success");
                            QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - currentTimeMillis));
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    new h(new a(), str).d();
                }
            }, 8, null, false);
            return str;
        }
    }

    public com.tencent.mobileqq.vip.h c() {
        return new DownloaderFactory(null).u(1);
    }

    public void d(g gVar, final e eVar) {
        final String str = "prepareVideo_" + UUID.nameUUIDFromBytes(gVar.f96720f.getBytes()).toString();
        gVar.f96715a = true;
        synchronized (this.f96666e) {
            if (this.f96667f.containsKey(str)) {
                return;
            }
            this.f96667f.put(str, gVar);
            final long currentTimeMillis = System.currentTimeMillis();
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.troop.VideoCombineHelper.3

                /* compiled from: P */
                /* renamed from: com.tencent.biz.troop.VideoCombineHelper$3$a */
                /* loaded from: classes5.dex */
                class a extends l {
                    a() {
                        super();
                    }

                    @Override // com.tencent.biz.troop.VideoCombineHelper.l
                    public void a(k kVar) {
                        synchronized (VideoCombineHelper.this.f96666e) {
                            VideoCombineHelper.this.f96667f.remove(kVar.f96738b);
                        }
                        if (kVar instanceof h) {
                            eVar.a("", false, "download failed! msg = " + kVar.f96740d);
                            return;
                        }
                        if (kVar instanceof CombineTask) {
                            eVar.a("", false, "combine failed! msg = " + kVar.f96740d);
                            return;
                        }
                        if (kVar instanceof j) {
                            eVar.a("", false, "sending failed! msg = " + kVar.f96740d);
                        }
                    }

                    @Override // com.tencent.biz.troop.VideoCombineHelper.l
                    public void b(k kVar) {
                        g c16 = kVar.c();
                        if ((kVar instanceof CombineTask) || c16.f96716b) {
                            synchronized (VideoCombineHelper.this.f96666e) {
                                VideoCombineHelper.this.f96667f.remove(kVar.f96738b);
                            }
                            eVar.a(c16.f96724j, true, "seding success");
                            QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - currentTimeMillis));
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    new h(new a(), str).d();
                }
            }, 8, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class i implements FFmpegExecuteResponseCallback {
        i() {
        }

        public void a(boolean z16) {
            throw null;
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            a(false);
            if (QLog.isColorLevel()) {
                QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onFailure" + str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onProgress(String str) {
            if (QLog.isColorLevel()) {
                QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onProgress" + str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onStart() {
            if (QLog.isColorLevel()) {
                QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onStart");
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            a(true);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFinish(boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class l {
        public l() {
        }

        public void b(k kVar) {
            throw null;
        }

        public void a(k kVar) {
        }
    }
}
