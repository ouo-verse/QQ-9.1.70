package com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.composite.step.HwVideoMerge;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class EncodeVideoTask extends AsyncTask<Void, Void, Integer> {

    /* renamed from: v, reason: collision with root package name */
    public static ConcurrentHashMap<Long, EncodeVideoTask> f186192v = new ConcurrentHashMap<>();

    /* renamed from: w, reason: collision with root package name */
    private static FFmpeg f186193w;

    /* renamed from: a, reason: collision with root package name */
    private boolean f186194a;

    /* renamed from: b, reason: collision with root package name */
    private Context f186195b;

    /* renamed from: c, reason: collision with root package name */
    private String f186196c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f186197d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.shortvideo.g f186198e;

    /* renamed from: f, reason: collision with root package name */
    private d f186199f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f186200g;

    /* renamed from: h, reason: collision with root package name */
    private String f186201h;

    /* renamed from: i, reason: collision with root package name */
    private String f186202i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f186203j;

    /* renamed from: k, reason: collision with root package name */
    private String f186204k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f186205l;

    /* renamed from: m, reason: collision with root package name */
    private String f186206m;

    /* renamed from: n, reason: collision with root package name */
    private int f186207n;

    /* renamed from: o, reason: collision with root package name */
    private int f186208o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f186209p;

    /* renamed from: q, reason: collision with root package name */
    public PublishVideoEntry f186210q;

    /* renamed from: r, reason: collision with root package name */
    public MessageForShortVideo f186211r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f186212s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f186213t;

    /* renamed from: u, reason: collision with root package name */
    private b f186214u;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements b {
        AnonymousClass2() {
        }

        @Override // com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.b
        public void a(final int i3, String str, final PublishVideoEntry publishVideoEntry, String str2, final long j3) {
            if (i3 == 0 && publishVideoEntry != null && str2 != null) {
                EncodeVideoTask.this.f186214u.c(publishVideoEntry, str2);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("EncodeVideoTask", 2, "composite error, fakeVid:", EncodeVideoTask.this.f186196c, ", errorCode:", Integer.valueOf(i3), ", errorMsg:", str);
                }
                EncodeVideoTask.this.f186214u.onError(i3);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.2
                @Override // java.lang.Runnable
                public void run() {
                    EncodeVideoTask.this.E(i3, publishVideoEntry, j3);
                }
            }, 64, null, true);
        }

        @Override // com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.b
        public void b(final PublishVideoEntry publishVideoEntry, final String str) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.1
                /* JADX WARN: Code restructure failed: missing block: B:100:0x0110, code lost:
                
                    if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L53;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:101:0x01b8, code lost:
                
                    r8 = -6;
                    r3 = r3;
                    r5 = r5;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:104:0x01b4, code lost:
                
                    r3 = 2;
                    com.tencent.qphone.base.util.QLog.e("EncodeVideoTask", 2, "doInBackground(), mThumbMd5 is empty");
                 */
                /* JADX WARN: Code restructure failed: missing block: B:126:0x01b2, code lost:
                
                    if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L53;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:12:0x02ae  */
                /* JADX WARN: Removed duplicated region for block: B:145:0x0215  */
                /* JADX WARN: Removed duplicated region for block: B:150:0x0220  */
                /* JADX WARN: Removed duplicated region for block: B:162:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0361  */
                /* JADX WARN: Removed duplicated region for block: B:19:0x037c  */
                /* JADX WARN: Removed duplicated region for block: B:86:0x035d  */
                /* JADX WARN: Type inference failed for: r3v12 */
                /* JADX WARN: Type inference failed for: r3v13 */
                /* JADX WARN: Type inference failed for: r3v16, types: [com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask] */
                /* JADX WARN: Type inference failed for: r3v17 */
                /* JADX WARN: Type inference failed for: r3v19 */
                /* JADX WARN: Type inference failed for: r3v44 */
                /* JADX WARN: Type inference failed for: r3v45 */
                /* JADX WARN: Type inference failed for: r3v52 */
                /* JADX WARN: Type inference failed for: r3v53 */
                /* JADX WARN: Type inference failed for: r5v13, types: [boolean] */
                /* JADX WARN: Type inference failed for: r5v14, types: [boolean] */
                /* JADX WARN: Type inference failed for: r5v15, types: [boolean] */
                /* JADX WARN: Type inference failed for: r5v18, types: [java.lang.StringBuilder] */
                /* JADX WARN: Type inference failed for: r5v25, types: [boolean] */
                /* JADX WARN: Type inference failed for: r5v26, types: [boolean] */
                /* JADX WARN: Type inference failed for: r5v27, types: [boolean] */
                /* JADX WARN: Type inference failed for: r5v46 */
                /* JADX WARN: Type inference failed for: r5v47 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Throwable th5;
                    FileInputStream fileInputStream;
                    String str2;
                    String str3;
                    String l3;
                    String str4;
                    ?? r36;
                    ?? r56;
                    String str5;
                    String str6;
                    String str7;
                    ?? r37;
                    Throwable th6;
                    byte[] bArr;
                    String str8 = ", thumbPath=";
                    String str9 = "doInBackground(), rename failure, mThumbPath = ";
                    String str10 = "failed to close thumb file, exc=";
                    int i3 = 0;
                    AutoSaveUtils.c(str, false, true);
                    if (TextUtils.isEmpty(EncodeVideoTask.this.f186201h)) {
                        EncodeVideoTask.this.f186201h = publishVideoEntry.thumbPath;
                    }
                    FileInputStream fileInputStream2 = null;
                    if (EncodeVideoTask.this.f186199f != null) {
                        EncodeVideoTask encodeVideoTask = EncodeVideoTask.this;
                        encodeVideoTask.f186206m = encodeVideoTask.f186199f.f186233b;
                        EncodeVideoTask encodeVideoTask2 = EncodeVideoTask.this;
                        if (encodeVideoTask2.f186199f.f186234c == null) {
                            bArr = HexUtil.hexStr2Bytes(EncodeVideoTask.this.f186206m);
                        } else {
                            bArr = EncodeVideoTask.this.f186199f.f186234c;
                        }
                        encodeVideoTask2.f186205l = bArr;
                        EncodeVideoTask encodeVideoTask3 = EncodeVideoTask.this;
                        encodeVideoTask3.f186207n = encodeVideoTask3.f186199f.f186235d;
                        EncodeVideoTask encodeVideoTask4 = EncodeVideoTask.this;
                        encodeVideoTask4.f186208o = encodeVideoTask4.f186199f.f186236e;
                    } else {
                        EncodeVideoTask.this.f186207n = publishVideoEntry.videoWidth;
                        EncodeVideoTask.this.f186208o = publishVideoEntry.videoHeight;
                        File file = new File(EncodeVideoTask.this.f186201h);
                        if (file.exists()) {
                            try {
                                try {
                                    fileInputStream = new FileInputStream(EncodeVideoTask.this.f186201h);
                                } catch (FileNotFoundException e16) {
                                    e = e16;
                                    fileInputStream = null;
                                } catch (Throwable th7) {
                                    th5 = th7;
                                    str3 = str8;
                                    str2 = str10;
                                    if (fileInputStream2 != null) {
                                    }
                                    if (!TextUtils.isEmpty(EncodeVideoTask.this.f186206m)) {
                                    }
                                }
                                try {
                                    EncodeVideoTask.this.f186205l = MD5.toMD5Byte(fileInputStream, file.length());
                                    EncodeVideoTask encodeVideoTask5 = EncodeVideoTask.this;
                                    encodeVideoTask5.f186206m = HexUtil.bytes2HexStr(encodeVideoTask5.f186205l);
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e17) {
                                        QLog.w("EncodeVideoTask", 1, "failed to close thumb file, exc=" + e17);
                                    }
                                } catch (FileNotFoundException e18) {
                                    e = e18;
                                    QLog.w("EncodeVideoTask", 1, "failed to compute thumb md5, exc=" + e);
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e19) {
                                            QLog.w("EncodeVideoTask", 1, "failed to close thumb file, exc=" + e19);
                                        }
                                    }
                                    if (TextUtils.isEmpty(EncodeVideoTask.this.f186206m)) {
                                        r37 = str8;
                                    } else {
                                        l3 = j.l(EncodeVideoTask.this.f186206m, "jpg");
                                        ?? rename = FileUtils.rename(EncodeVideoTask.this.f186201h, l3);
                                        str7 = rename;
                                        if (rename == 0) {
                                            ?? fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(l3);
                                            str6 = str8;
                                            str5 = fileExistsAndNotEmpty;
                                            if (fileExistsAndNotEmpty == 0) {
                                                ?? isColorLevel = QLog.isColorLevel();
                                                r36 = str8;
                                                str4 = isColorLevel;
                                                if (isColorLevel != 0) {
                                                    r56 = new StringBuilder();
                                                    r56.append("doInBackground(), rename failure, mThumbPath = ");
                                                    str9 = EncodeVideoTask.this.f186201h;
                                                    r56.append(str9);
                                                    r56.append(", thumbPath=");
                                                    r56.append(l3);
                                                    r36 = 2;
                                                    QLog.e("EncodeVideoTask", 2, r56.toString());
                                                    str4 = r56;
                                                }
                                                i3 = -7;
                                                str8 = r36;
                                                str10 = str4;
                                                EncodeVideoTask.this.f186202i = str;
                                                if (TextUtils.isEmpty(EncodeVideoTask.this.f186202i)) {
                                                }
                                                if (i3 != 0) {
                                                }
                                            }
                                            i3 = 0;
                                            str8 = str6;
                                            str10 = str5;
                                            EncodeVideoTask.this.f186202i = str;
                                            if (TextUtils.isEmpty(EncodeVideoTask.this.f186202i)) {
                                            }
                                            if (i3 != 0) {
                                            }
                                        }
                                        ?? r38 = EncodeVideoTask.this;
                                        ((EncodeVideoTask) r38).f186201h = l3;
                                        str6 = r38;
                                        str5 = str7;
                                        i3 = 0;
                                        str8 = str6;
                                        str10 = str5;
                                        EncodeVideoTask.this.f186202i = str;
                                        if (TextUtils.isEmpty(EncodeVideoTask.this.f186202i)) {
                                        }
                                        if (i3 != 0) {
                                        }
                                    }
                                }
                                if (TextUtils.isEmpty(EncodeVideoTask.this.f186206m)) {
                                    r37 = str8;
                                } else {
                                    l3 = j.l(EncodeVideoTask.this.f186206m, "jpg");
                                    ?? rename2 = FileUtils.rename(EncodeVideoTask.this.f186201h, l3);
                                    str7 = rename2;
                                    if (rename2 == 0) {
                                        ?? fileExistsAndNotEmpty2 = FileUtils.fileExistsAndNotEmpty(l3);
                                        str6 = str8;
                                        str5 = fileExistsAndNotEmpty2;
                                        if (fileExistsAndNotEmpty2 == 0) {
                                            ?? isColorLevel2 = QLog.isColorLevel();
                                            r36 = str8;
                                            str4 = isColorLevel2;
                                            if (isColorLevel2 != 0) {
                                                r56 = new StringBuilder();
                                                r56.append("doInBackground(), rename failure, mThumbPath = ");
                                                str9 = EncodeVideoTask.this.f186201h;
                                                r56.append(str9);
                                                r56.append(", thumbPath=");
                                                r56.append(l3);
                                                r36 = 2;
                                                QLog.e("EncodeVideoTask", 2, r56.toString());
                                                str4 = r56;
                                            }
                                            i3 = -7;
                                            str8 = r36;
                                            str10 = str4;
                                        }
                                        i3 = 0;
                                        str8 = str6;
                                        str10 = str5;
                                    }
                                    ?? r382 = EncodeVideoTask.this;
                                    ((EncodeVideoTask) r382).f186201h = l3;
                                    str6 = r382;
                                    str5 = str7;
                                    i3 = 0;
                                    str8 = str6;
                                    str10 = str5;
                                }
                            } catch (Throwable th8) {
                                th5 = th8;
                                fileInputStream2 = fileInputStream;
                                str3 = str8;
                                str2 = str10;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e26) {
                                        QLog.w("EncodeVideoTask", 1, str2 + e26);
                                    }
                                }
                                if (!TextUtils.isEmpty(EncodeVideoTask.this.f186206m)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("EncodeVideoTask", 2, "doInBackground(), mThumbMd5 is empty");
                                        throw th5;
                                    }
                                    throw th5;
                                }
                                String l16 = j.l(EncodeVideoTask.this.f186206m, "jpg");
                                if (FileUtils.rename(EncodeVideoTask.this.f186201h, l16)) {
                                    EncodeVideoTask.this.f186201h = l16;
                                    throw th5;
                                }
                                if (!FileUtils.fileExistsAndNotEmpty(l16)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("EncodeVideoTask", 2, str9 + EncodeVideoTask.this.f186201h + str3 + l16);
                                        throw th5;
                                    }
                                    throw th5;
                                }
                                throw th5;
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.e("EncodeVideoTask", 2, "doInBackground(), coverFile not exists, mThumbPath=" + EncodeVideoTask.this.f186201h);
                            }
                            i3 = -8;
                        }
                    }
                    EncodeVideoTask.this.f186202i = str;
                    if (TextUtils.isEmpty(EncodeVideoTask.this.f186202i)) {
                        File file2 = new File(EncodeVideoTask.this.f186202i);
                        try {
                            if (file2.exists()) {
                                try {
                                    FileInputStream fileInputStream3 = new FileInputStream(EncodeVideoTask.this.f186202i);
                                    try {
                                        EncodeVideoTask.this.f186203j = MD5.toMD5Byte(fileInputStream3, file2.length());
                                        EncodeVideoTask encodeVideoTask6 = EncodeVideoTask.this;
                                        encodeVideoTask6.f186204k = HexUtil.bytes2HexStr(encodeVideoTask6.f186203j);
                                        try {
                                            fileInputStream3.close();
                                        } catch (IOException e27) {
                                            QLog.w("EncodeVideoTask", 1, "failed to close video file, exc=" + e27);
                                        }
                                    } catch (FileNotFoundException e28) {
                                        e = e28;
                                        fileInputStream2 = fileInputStream3;
                                        QLog.w("EncodeVideoTask", 1, "failed to compute video md5, exc=" + e);
                                        if (fileInputStream2 != null) {
                                            try {
                                                fileInputStream2.close();
                                            } catch (IOException e29) {
                                                QLog.w("EncodeVideoTask", 1, "failed to close video file, exc=" + e29);
                                            }
                                        }
                                        i3 = -10;
                                        if (i3 != 0) {
                                        }
                                    } catch (Throwable th9) {
                                        th6 = th9;
                                        fileInputStream2 = fileInputStream3;
                                        if (fileInputStream2 != null) {
                                            try {
                                                fileInputStream2.close();
                                                throw th6;
                                            } catch (IOException e36) {
                                                QLog.w("EncodeVideoTask", 1, "failed to close video file, exc=" + e36);
                                                throw th6;
                                            }
                                        }
                                        throw th6;
                                    }
                                } catch (FileNotFoundException e37) {
                                    e = e37;
                                }
                            }
                        } catch (Throwable th10) {
                            th6 = th10;
                        }
                    } else {
                        i3 = -9;
                    }
                    if (i3 != 0) {
                        QLog.i("EncodeVideoTask", 1, "result err code:" + i3);
                        AnonymousClass2.this.onError(i3);
                        return;
                    }
                    QLog.i("EncodeVideoTask", 1, "thumbPath:" + EncodeVideoTask.this.f186201h + ", mThumbMd5:" + EncodeVideoTask.this.f186205l + ", mThumbMd5String:" + EncodeVideoTask.this.f186206m + ", width:" + EncodeVideoTask.this.f186207n + ", height:" + EncodeVideoTask.this.f186208o + ", videoPath:" + EncodeVideoTask.this.f186202i + ", recordTime:" + ((int) publishVideoEntry.recordTime) + ", mVideoMd5:" + EncodeVideoTask.this.f186203j + ", mVideoMd5String:" + EncodeVideoTask.this.f186204k);
                    if (!TextUtils.isEmpty(EncodeVideoTask.this.f186201h) && EncodeVideoTask.this.f186205l != null && !TextUtils.isEmpty(EncodeVideoTask.this.f186206m) && EncodeVideoTask.this.f186203j != null && !TextUtils.isEmpty(EncodeVideoTask.this.f186204k)) {
                        try {
                            if (EncodeVideoTask.this.f186194a) {
                                String str11 = publishVideoEntry.mLocalRawVideoDir;
                                if (EncodeVideoTask.this.f186197d) {
                                    str11 = new File(publishVideoEntry.mLocalRawVideoDir).getParentFile().getAbsolutePath();
                                }
                                RMVideoStateMgr.n(str11);
                                FileUtils.deleteDirectory(str11);
                            }
                        } catch (Exception e38) {
                            QLog.i("EncodeVideoTask", 1, "clear file, exception is " + e38);
                        }
                        EncodeVideoTask encodeVideoTask7 = EncodeVideoTask.this;
                        MessageForShortVideo messageForShortVideo = encodeVideoTask7.f186211r;
                        if (messageForShortVideo != null) {
                            messageForShortVideo.sourceVideoCodecFormat = ShortVideoUtils.isH265FormatShortVideo(encodeVideoTask7.f186202i) ? 1 : 0;
                            EncodeVideoTask.this.f186211r.serial();
                        }
                        if (EncodeVideoTask.this.f186198e != null) {
                            EncodeVideoTask.this.f186198e.a(EncodeVideoTask.this.f186202i, EncodeVideoTask.this.f186203j, EncodeVideoTask.this.f186201h, EncodeVideoTask.this.f186207n, EncodeVideoTask.this.f186208o, EncodeVideoTask.this.f186205l, (int) publishVideoEntry.recordTime);
                            return;
                        }
                        return;
                    }
                    QLog.w("EncodeVideoTask", 1, "video md5 not exist");
                    AnonymousClass2.this.onError(-10);
                }
            }, 64, null, true);
        }

        @Override // com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.b
        public void c(PublishVideoEntry publishVideoEntry, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("EncodeVideoTask", 2, "generate files|onNext file: " + str);
            }
            if (EncodeVideoTask.this.f186197d) {
                b(publishVideoEntry, str);
            } else if (publishVideoEntry != null && !TextUtils.isEmpty(publishVideoEntry.doodlePath) && FileUtils.fileExistsAndNotEmpty(publishVideoEntry.doodlePath)) {
                EncodeVideoTask.K(str, publishVideoEntry, EncodeVideoTask.this.f186214u);
            } else {
                b(publishVideoEntry, str);
            }
        }

        @Override // com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.b
        public void onError(int i3) {
            if (EncodeVideoTask.this.f186198e != null) {
                EncodeVideoTask.this.f186198e.onError(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements VideoCompositeHelper.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PublishVideoEntry f186223a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f186224b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f186225c;

        a(PublishVideoEntry publishVideoEntry, String str, long j3) {
            this.f186223a = publishVideoEntry;
            this.f186224b = str;
            this.f186225c = j3;
        }

        @Override // com.tencent.mobileqq.editor.composite.VideoCompositeHelper.f
        public void a(int i3, String str, String str2) {
            int i16;
            if (EncodeVideoTask.this.f186212s) {
                i16 = -24;
            } else {
                i16 = i3;
            }
            if (QLog.isColorLevel()) {
                QLog.i("EncodeVideoTask", 2, "onVideoCompositeFinish isCancel:" + EncodeVideoTask.this.f186212s + ", errCode:" + i3);
            }
            EncodeVideoTask encodeVideoTask = EncodeVideoTask.this;
            encodeVideoTask.f186213t = true;
            encodeVideoTask.f186214u.a(i16, str, this.f186223a, this.f186224b, this.f186225c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void a(int i3, String str, PublishVideoEntry publishVideoEntry, String str2, long j3);

        void b(PublishVideoEntry publishVideoEntry, String str);

        void c(PublishVideoEntry publishVideoEntry, String str);

        void onError(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class c extends ExecuteBinResponseCallback {

        /* renamed from: a, reason: collision with root package name */
        b f186227a;

        /* renamed from: b, reason: collision with root package name */
        PublishVideoEntry f186228b;

        /* renamed from: c, reason: collision with root package name */
        String f186229c;

        /* renamed from: d, reason: collision with root package name */
        String f186230d;

        /* renamed from: e, reason: collision with root package name */
        long f186231e = System.currentTimeMillis();

        public c(PublishVideoEntry publishVideoEntry, String str, String str2) {
            this.f186228b = publishVideoEntry;
            this.f186229c = str;
            this.f186230d = str2;
        }

        public void a(b bVar) {
            this.f186227a = bVar;
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            this.f186227a.onError(-11);
            if (QLog.isColorLevel()) {
                QLog.d("EncodeVideoTask", 2, "generate files|second step fail:" + str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFinish(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("EncodeVideoTask", 2, "generate files|second step cost:" + ((System.currentTimeMillis() - this.f186231e) / 1000.0d) + ", isSuccess:" + z16);
            }
            if (z16) {
                this.f186227a.c(this.f186228b, this.f186230d);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onStart() {
            super.onStart();
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback, com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            FileUtils.deleteFile(this.f186229c);
            EncodeVideoTask.C(System.currentTimeMillis() - this.f186231e, 2);
            if (QLog.isColorLevel()) {
                QLog.d("EncodeVideoTask", 2, "generate files|second step success!");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f186232a;

        /* renamed from: b, reason: collision with root package name */
        public String f186233b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f186234c;

        /* renamed from: d, reason: collision with root package name */
        public int f186235d;

        /* renamed from: e, reason: collision with root package name */
        public int f186236e;

        public d() {
        }

        public d(String str, String str2, byte[] bArr, int i3, int i16) {
            this.f186232a = str;
            this.f186233b = str2;
            this.f186234c = bArr;
            this.f186235d = i3;
            this.f186236e = i16;
        }
    }

    public EncodeVideoTask(Context context, String str, boolean z16, d dVar) {
        this(context, str, z16, dVar, false);
    }

    public static void C(long j3, int i3) {
        D(j3, i3, 0);
    }

    public static void D(long j3, int i3, int i16) {
        String str;
        HashMap<String, String> hashMap;
        if (j3 <= 0) {
            return;
        }
        if (i3 == 1) {
            str = "actShortVideoGenerateSource";
        } else if (i3 == 2) {
            str = "actShortVideoGenerateAudio";
        } else if (i3 == 3) {
            str = "actShortVideoGeneratePic";
        } else if (i3 == 4) {
            str = "actMediaCodecMergeEdit";
        } else if (i3 == 5) {
            str = "actMediaCodecMergeSelfAudio";
        } else {
            str = "";
        }
        String str2 = str;
        if (i16 != 0) {
            hashMap = new HashMap<>();
            hashMap.put("hcState", String.valueOf(i16));
        } else {
            hashMap = null;
        }
        HashMap<String, String> hashMap2 = hashMap;
        if (!TextUtils.isEmpty(str2)) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str2, true, j3, 0L, hashMap2, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(String str, PublishVideoEntry publishVideoEntry, b bVar) {
        String mergeVideoPath = ShortVideoUtils.getMergeVideoPath(new File(publishVideoEntry.mLocalRawVideoDir));
        if (f186193w == null) {
            f186193w = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
        }
        if (f186193w.isFFmpegCommandRunning()) {
            if (QLog.isColorLevel()) {
                QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
                return;
            }
            return;
        }
        try {
            e eVar = new e(publishVideoEntry, str, mergeVideoPath, bVar);
            f186193w.setCurrentTaskUni(mergeVideoPath);
            f186193w.watermark(publishVideoEntry.doodlePath, str, mergeVideoPath, publishVideoEntry.videoWidth, publishVideoEntry.videoHeight, eVar);
        } catch (Exception e16) {
            bVar.onError(-12);
            QLog.e("EncodeVideoTask", 2, "generate files save alum:", e16);
        }
    }

    protected Integer A(Void... voidArr) {
        if (TextUtils.isEmpty(this.f186196c)) {
            this.f186214u.a(-61, null, null, null, 0L);
            return -61;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        int start = HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{Process.myTid()}, 8000, 603, 1L, Process.myTid(), "video", true);
        int intValue = G().intValue();
        if (intValue != 0) {
            this.f186214u.a(intValue, null, null, null, 0L);
        }
        if (start != 0) {
            HardCoderManager.getInstance().stop(start);
        }
        if (QLog.isColorLevel()) {
            QLog.d("EncodeVideoTask", 2, "encode cost=" + (SystemClock.uptimeMillis() - uptimeMillis), " ret:", Integer.valueOf(intValue));
        }
        return Integer.valueOf(intValue);
    }

    protected Integer B(Void... voidArr) {
        int i3;
        if (TextUtils.isEmpty(this.f186196c)) {
            return -1;
        }
        PublishVideoEntry k3 = VideoCompositeHelper.k(this.f186196c);
        if (k3 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("EncodeVideoTask", 2, "configure param error, fakeVid:" + this.f186196c);
            }
            return -2;
        }
        CodecParam.mRecordTime = (int) k3.recordTime;
        CodecParam.mRecordFrames = k3.recordFrames;
        int i16 = k3.saveMode;
        if (i16 != 0) {
            CodecParam.mSaveMode = i16;
        }
        if (k3.businessId == 2) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        CodecParam.mAdjustSpecialSpeed = i3;
        boolean z16 = !TextUtils.isEmpty(k3.backgroundMusicPath);
        boolean z17 = !TextUtils.isEmpty(k3.doodlePath);
        File file = new File(k3.mLocalRawVideoDir);
        String tempVideoPath = ShortVideoUtils.getTempVideoPath(file);
        if (!z16 && !z17) {
            tempVideoPath = ShortVideoUtils.getMergeVideoPath(file);
        }
        long currentTimeMillis = System.currentTimeMillis();
        EncodeThread encodeThread = new EncodeThread(null, null, k3.mLocalRawVideoDir, tempVideoPath, null);
        encodeThread.setEnableHardEncode(false);
        encodeThread.setEnableDeleteCache(false);
        encodeThread.setMuteVoice(k3.isMuteRecordVoice);
        byte[] bArr = k3.mMosaicMask;
        if (bArr != null) {
            encodeThread.setMosaicMask(bArr, k3.mMosaicSize);
        }
        encodeThread.run();
        C(System.currentTimeMillis() - currentTimeMillis, 1);
        if (QLog.isColorLevel()) {
            QLog.d("EncodeVideoTask", 2, "generate files|first step cost:" + ((System.currentTimeMillis() - currentTimeMillis) / 1000.0d));
        }
        if (z16) {
            try {
                String tempAudioPath = ShortVideoUtils.getTempAudioPath(file);
                long durationOfVideo = ShortVideoUtils.getDurationOfVideo(tempVideoPath);
                c cVar = new c(k3, tempVideoPath, tempAudioPath);
                cVar.a(this.f186214u);
                FFmpegUtils.combinBackgroundMusic(this.f186195b, tempVideoPath, k3.backgroundMusicPath, k3.backgroundMusicOffset, (int) durationOfVideo, tempAudioPath, cVar);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("EncodeVideoTask", 2, "generate error:", e16);
                }
            }
        } else {
            this.f186214u.c(k3, tempVideoPath);
        }
        return 0;
    }

    public void E(int i3, PublishVideoEntry publishVideoEntry, long j3) {
        boolean z16;
        String str;
        boolean z17;
        if (publishVideoEntry != null && publishVideoEntry.publishState == 0) {
            return;
        }
        if (publishVideoEntry != null) {
            publishVideoEntry.publishState = 0;
            QQStoryContext.h().e().createEntityManager().update(publishVideoEntry);
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String[] strArr = new String[1];
        if (i3 == 0) {
            str = "1";
        } else {
            str = "0";
        }
        strArr[0] = str;
        long j16 = 0;
        id0.a.r("AIOMergeVideoSuc", z16, 0L, strArr);
        if (i3 != 0) {
            id0.a.r("AIOMergeVideoError", true, 0L, String.valueOf(i3));
            return;
        }
        if (j3 != 0) {
            j16 = System.currentTimeMillis() - j3;
        }
        if (publishVideoEntry != null && publishVideoEntry.isPicture) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (com.tencent.mobileqq.monitor.a.f247270d && !z17 && com.tencent.mobileqq.monitor.a.f247272f.c()) {
            long[] jArr = com.tencent.mobileqq.monitor.a.f247272f.f247274b;
            long j17 = jArr[0];
            long j18 = jArr[1];
            long j19 = jArr[2];
            long j26 = jArr[3];
            long j27 = jArr[4];
            if (id0.a.g(j16, 0L, 120000L) && id0.a.g(j17, 0L, 120000L) && id0.a.g(j18, 0L, 120000L) && id0.a.g(j19, 0L, 10000L) && id0.a.g(j26, 0L, 120000L) && id0.a.g(j27, 0L, 120000L)) {
                id0.a.r("AIOMergeVideoCost", true, j16, String.valueOf(j17), String.valueOf(j18), String.valueOf(j19), String.valueOf(j26), String.valueOf(j27));
            }
            com.tencent.mobileqq.monitor.a.f247272f.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        boolean z16;
        super.onPostExecute(num);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", Integer.toString(num.intValue()));
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        if (num.intValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance(null, "actMediaCodecEncodeSuccessRate", z16, 0L, 0L, hashMap, "");
        if (num.intValue() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("EncodeVideoTask", 2, "onPostExecute result:" + num);
            }
            this.f186198e.onError(num.intValue());
        }
    }

    protected Integer G() {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.tencent.mobileqq.monitor.a.f247270d) {
            com.tencent.mobileqq.monitor.a.f247272f.f();
        }
        PublishVideoEntry k3 = VideoCompositeHelper.k(this.f186196c);
        if (k3 == null) {
            if (QLog.isColorLevel()) {
                QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeVid:" + this.f186196c);
            }
            return -62;
        }
        this.f186210q = k3;
        if (TextUtils.isEmpty(k3.mLocalRawVideoDir)) {
            if (QLog.isColorLevel()) {
                QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeId:" + this.f186196c + ", EntryId:" + k3.fakeVid);
            }
            im2.b.a(new RuntimeException("onMediaCodecEncode failed"));
            return -62;
        }
        String mergeVideoPath = ShortVideoUtils.getMergeVideoPath(new File(k3.mLocalRawVideoDir).getParentFile());
        new VideoCompositeHelper().b(k3, mergeVideoPath, false, true, new a(k3, mergeVideoPath, currentTimeMillis));
        return 0;
    }

    public void H(boolean z16) {
        this.f186209p = z16;
    }

    public void I(com.tencent.mobileqq.shortvideo.g gVar) {
        this.f186198e = gVar;
    }

    public void J(boolean z16) {
        this.f186194a = z16;
    }

    public boolean y() {
        if (!this.f186213t) {
            PublishVideoEntry publishVideoEntry = this.f186210q;
            if (publishVideoEntry != null) {
                publishVideoEntry.isCancel = true;
            }
            this.f186212s = true;
            boolean destroyRunningProcess = HwVideoMerge.destroyRunningProcess();
            FFmpegUtils.killRunningProcesses();
            if (QLog.isColorLevel()) {
                QLog.i("EncodeVideoTask", 2, "shortVideoCancel, cancelMerge:" + destroyRunningProcess);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        if (!this.f186197d) {
            return B(voidArr);
        }
        return A(voidArr);
    }

    public EncodeVideoTask(Context context, String str, boolean z16, d dVar, boolean z17) {
        this.f186194a = true;
        this.f186212s = false;
        this.f186213t = false;
        this.f186214u = new AnonymousClass2();
        this.f186195b = context;
        this.f186196c = str;
        this.f186199f = dVar;
        this.f186197d = z16;
        if (dVar != null) {
            this.f186201h = dVar.f186232a;
        }
        this.f186200g = z17;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e implements FFmpegExecuteResponseCallback {

        /* renamed from: a, reason: collision with root package name */
        PublishVideoEntry f186237a;

        /* renamed from: b, reason: collision with root package name */
        b f186238b;

        /* renamed from: c, reason: collision with root package name */
        String f186239c;

        /* renamed from: d, reason: collision with root package name */
        String f186240d;

        /* renamed from: e, reason: collision with root package name */
        long f186241e = System.currentTimeMillis();

        public e(PublishVideoEntry publishVideoEntry, String str, String str2, b bVar) {
            this.f186237a = publishVideoEntry;
            this.f186238b = bVar;
            this.f186239c = str;
            this.f186240d = str2;
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFailure(String str) {
            this.f186238b.onError(-12);
            if (QLog.isColorLevel()) {
                QLog.d("EncodeVideoTask", 2, "generate files|third step fail:" + str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onFinish(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("EncodeVideoTask", 2, "generate files|third step cost:" + ((System.currentTimeMillis() - this.f186241e) / 1000.0d) + ", isSuccess:" + z16);
            }
            if (z16) {
                this.f186238b.b(this.f186237a, this.f186240d);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onSuccess(String str) {
            com.tencent.biz.qqstory.utils.d.a(BaseApplication.getContext(), new File(this.f186240d));
            FileUtils.deleteFile(this.f186239c);
            EncodeVideoTask.C(System.currentTimeMillis() - this.f186241e, 3);
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onStart() {
        }

        @Override // com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback
        public void onProgress(String str) {
        }
    }
}
