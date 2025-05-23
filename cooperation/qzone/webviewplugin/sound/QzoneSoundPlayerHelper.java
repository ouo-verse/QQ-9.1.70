package cooperation.qzone.webviewplugin.sound;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes38.dex */
public class QzoneSoundPlayerHelper {

    /* renamed from: mp, reason: collision with root package name */
    private MediaPlayer f390882mp;

    public synchronized int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f390882mp;
        if (mediaPlayer == null) {
            return -1;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public synchronized int getDuration() {
        MediaPlayer mediaPlayer = this.f390882mp;
        if (mediaPlayer == null) {
            return -1;
        }
        return mediaPlayer.getDuration();
    }

    public synchronized boolean isPlaying() {
        MediaPlayer mediaPlayer = this.f390882mp;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    public synchronized boolean pause() {
        MediaPlayer mediaPlayer = this.f390882mp;
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

    public synchronized void release() {
        MediaPlayer mediaPlayer = this.f390882mp;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
        this.f390882mp.release();
        this.f390882mp = null;
    }

    public synchronized boolean setDataSource(Context context, Uri uri) {
        MediaPlayer mediaPlayer = this.f390882mp;
        if (mediaPlayer == null) {
            this.f390882mp = new ReportMediaPlayer();
        } else {
            mediaPlayer.reset();
        }
        try {
            try {
                this.f390882mp.setAudioStreamType(3);
                this.f390882mp.setDataSource(context, uri);
                this.f390882mp.prepare();
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

    public synchronized boolean setLooping(boolean z16) {
        MediaPlayer mediaPlayer = this.f390882mp;
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

    public synchronized void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.f390882mp == null) {
            this.f390882mp = new ReportMediaPlayer();
        }
        this.f390882mp.setOnCompletionListener(onCompletionListener);
    }

    public synchronized boolean start() {
        MediaPlayer mediaPlayer = this.f390882mp;
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

    public synchronized boolean stop() {
        MediaPlayer mediaPlayer = this.f390882mp;
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

    public synchronized boolean setDataSource(Context context, String str) {
        MediaPlayer mediaPlayer = this.f390882mp;
        if (mediaPlayer == null) {
            this.f390882mp = new ReportMediaPlayer();
        } else {
            mediaPlayer.reset();
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                this.f390882mp.setAudioStreamType(3);
                File file = new File(context.getFilesDir(), str);
                if (!file.exists()) {
                    return false;
                }
                FileInputStream fileInputStream2 = new FileInputStream(file.getAbsolutePath());
                try {
                    this.f390882mp.setDataSource(fileInputStream2.getFD());
                    this.f390882mp.prepare();
                    fileInputStream2.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (IllegalArgumentException e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (IllegalStateException e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return false;
                } catch (SecurityException e19) {
                    e = e19;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
            } catch (IllegalArgumentException e27) {
                e = e27;
            } catch (IllegalStateException e28) {
                e = e28;
            } catch (SecurityException e29) {
                e = e29;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean setDataSource(String str) {
        SecurityException e16;
        FileInputStream fileInputStream;
        IllegalStateException e17;
        IllegalArgumentException e18;
        IOException e19;
        MediaPlayer mediaPlayer = this.f390882mp;
        if (mediaPlayer == null) {
            this.f390882mp = new ReportMediaPlayer();
        } else {
            mediaPlayer.reset();
        }
        ?? r16 = 0;
        try {
            try {
                this.f390882mp.setAudioStreamType(3);
                File file = new File(str);
                if (!file.exists()) {
                    return false;
                }
                fileInputStream = new FileInputStream(file.getAbsolutePath());
                try {
                    this.f390882mp.setDataSource(fileInputStream.getFD());
                    this.f390882mp.prepare();
                    fileInputStream.close();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (IOException e26) {
                    e19 = e26;
                    e19.printStackTrace();
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
                if (r16 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r16 = str;
            if (r16 != 0) {
                try {
                    r16.close();
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
    }
}
