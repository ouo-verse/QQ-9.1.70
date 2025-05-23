package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.mobileqq.activity.specialcare.i;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bp {

    /* renamed from: b, reason: collision with root package name */
    private static bp f307495b;

    /* renamed from: a, reason: collision with root package name */
    private MediaPlayer f307496a;

    bp() {
    }

    public static bp a() {
        if (f307495b == null) {
            f307495b = new bp();
        }
        return f307495b;
    }

    public synchronized boolean b() {
        MediaPlayer mediaPlayer = this.f307496a;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    public synchronized boolean c() {
        MediaPlayer mediaPlayer = this.f307496a;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.pause();
            return true;
        } catch (IllegalStateException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public synchronized void d() {
        MediaPlayer mediaPlayer = this.f307496a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
        this.f307496a.reset();
        this.f307496a.release();
        this.f307496a = null;
    }

    public synchronized boolean e(Context context, Uri uri) {
        MediaPlayer mediaPlayer = this.f307496a;
        if (mediaPlayer == null) {
            this.f307496a = new ReportMediaPlayer();
        } else {
            mediaPlayer.reset();
        }
        try {
            try {
                this.f307496a.setAudioStreamType(3);
                this.f307496a.setDataSource(context, uri);
                this.f307496a.prepare();
            } catch (IOException e16) {
                e16.printStackTrace();
                return false;
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
                return false;
            }
        } catch (IllegalStateException e18) {
            e18.printStackTrace();
            return false;
        } catch (SecurityException e19) {
            e19.printStackTrace();
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean f(Context context, String str, i.e eVar) {
        SecurityException e16;
        FileInputStream fileInputStream;
        IllegalStateException e17;
        IllegalArgumentException e18;
        IOException e19;
        MediaPlayer mediaPlayer = this.f307496a;
        if (mediaPlayer == null) {
            this.f307496a = new ReportMediaPlayer();
        } else {
            mediaPlayer.reset();
        }
        ?? r06 = 0;
        try {
            try {
                this.f307496a.setAudioStreamType(3);
                File file = new File(str);
                if (!file.exists()) {
                    return false;
                }
                fileInputStream = new FileInputStream(file.getAbsolutePath());
                try {
                    this.f307496a.setDataSource(fileInputStream.getFD());
                    this.f307496a.setOnPreparedListener(eVar);
                    this.f307496a.prepareAsync();
                    fileInputStream.close();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (IOException e26) {
                    e19 = e26;
                    e19.printStackTrace();
                    eVar.a();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (IllegalArgumentException e27) {
                    e18 = e27;
                    e18.printStackTrace();
                    eVar.a();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (IllegalStateException e28) {
                    e17 = e28;
                    e17.printStackTrace();
                    eVar.a();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return false;
                } catch (SecurityException e29) {
                    e16 = e29;
                    e16.printStackTrace();
                    eVar.a();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    return false;
                }
            } catch (IOException e36) {
                e19 = e36;
                fileInputStream = null;
            } catch (IllegalArgumentException e37) {
                e18 = e37;
                fileInputStream = null;
            } catch (IllegalStateException e38) {
                e17 = e38;
                fileInputStream = null;
            } catch (SecurityException e39) {
                e16 = e39;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (r06 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r06 = str;
            if (r06 != 0) {
                try {
                    r06.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }

    public synchronized boolean g(boolean z16) {
        MediaPlayer mediaPlayer = this.f307496a;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.setLooping(z16);
            return true;
        } catch (IllegalStateException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public synchronized void h(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.f307496a == null) {
            this.f307496a = new ReportMediaPlayer();
        }
        this.f307496a.setOnCompletionListener(onCompletionListener);
    }

    public synchronized boolean i() {
        MediaPlayer mediaPlayer = this.f307496a;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.start();
            return true;
        } catch (IllegalStateException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public synchronized boolean j() {
        MediaPlayer mediaPlayer = this.f307496a;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.stop();
            return true;
        } catch (IllegalStateException e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
