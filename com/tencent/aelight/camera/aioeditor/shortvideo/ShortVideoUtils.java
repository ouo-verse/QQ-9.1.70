package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.g;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ShortVideoUtils implements ShortVideoConstants {

    /* renamed from: a, reason: collision with root package name */
    private static int[] f67588a = {1, 97, 125};

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class VideoFileSaveRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        String f67589d;

        /* renamed from: e, reason: collision with root package name */
        MqqHandler f67590e;

        /* renamed from: f, reason: collision with root package name */
        String f67591f;

        /* renamed from: h, reason: collision with root package name */
        boolean f67592h;

        /* renamed from: i, reason: collision with root package name */
        InputStream f67593i;

        /* JADX WARN: Removed duplicated region for block: B:59:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            File file;
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            if ((TextUtils.isEmpty(this.f67589d) || !FileUtils.fileExists(this.f67589d)) && this.f67593i == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(com.tencent.mobileqq.shortvideo.ShortVideoUtils.TAG, 2, "save file failue, mVideoPath=" + this.f67589d);
                }
                this.f67590e.sendEmptyMessage(1);
                return;
            }
            FileOutputStream fileOutputStream2 = null;
            r4 = null;
            InputStream inputStream2 = null;
            fileOutputStream2 = null;
            File file2 = this.f67593i == null ? new File(this.f67589d) : null;
            if (VersionUtils.isrFroyo()) {
                file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            } else {
                file = new File(g.f185858f);
            }
            file.mkdirs();
            File file3 = new File(file, ShortVideoUtils.c(this.f67591f));
            if (!this.f67592h && file3.exists()) {
                this.f67590e.sendMessage(this.f67590e.obtainMessage(3, this.f67589d));
                return;
            }
            try {
                try {
                    fileOutputStream = new FileOutputStream(file3);
                } catch (Exception e16) {
                    e = e16;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
                try {
                    InputStream inputStream3 = this.f67593i;
                    if (inputStream3 == null) {
                        inputStream3 = new FileInputStream(file2);
                    }
                    inputStream2 = inputStream3;
                    byte[] bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    this.f67590e.sendMessage(this.f67590e.obtainMessage(2, file3.getAbsolutePath()));
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    inputStream2.close();
                } catch (Exception e17) {
                    e = e17;
                    inputStream = inputStream2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e(com.tencent.mobileqq.shortvideo.ShortVideoUtils.TAG, 2, "save file failue", e);
                        }
                        this.f67590e.sendEmptyMessage(1);
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (inputStream == null) {
                            try {
                                inputStream.close();
                                throw th;
                            } catch (IOException unused4) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    inputStream = inputStream2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                    }
                    if (inputStream == null) {
                    }
                }
            } catch (IOException unused5) {
            }
        }
    }

    public static long a(String str) {
        long j3 = -1;
        if (!new File(str).exists()) {
            if (QLog.isColorLevel()) {
                QLog.e(com.tencent.mobileqq.shortvideo.ShortVideoUtils.TAG, 2, "Path:" + str + ", not exits!");
            }
            return -1L;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            try {
                reportMediaPlayer.setDataSource(str);
                reportMediaPlayer.prepare();
                j3 = reportMediaPlayer.getDuration();
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(com.tencent.mobileqq.shortvideo.ShortVideoUtils.TAG, 2, "getDuration", e16);
                }
            }
            return j3;
        } finally {
            reportMediaPlayer.release();
        }
    }

    public static String c(String str) {
        return "QIM\u89c6\u9891_" + str;
    }

    public static String b(File file) {
        if (file == null) {
            return null;
        }
        String name = file.getName();
        StringBuilder sb5 = new StringBuilder(g.f185856d);
        sb5.append("shortvideo");
        String str = File.separator;
        sb5.append(str);
        sb5.append(FaceUtil.IMG_TEMP);
        sb5.append(str);
        sb5.append("source");
        sb5.append(str);
        sb5.append(name);
        sb5.append("_local");
        sb5.append(".mp4");
        return sb5.toString();
    }
}
