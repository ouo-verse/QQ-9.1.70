package com.tencent.luggage.wxa.tn;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Looper;
import com.tencent.luggage.wxa.tn.l0;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f141632a = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements MediaPlayer.OnErrorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaPlayer f141633a;

        public a(MediaPlayer mediaPlayer) {
            this.f141633a = mediaPlayer;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            w.d("MicroMsg.PlaySound", "onError, what: %d, extra: %d", Integer.valueOf(i3), Integer.valueOf(i16));
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.release();
                } catch (Exception unused) {
                }
            }
            MediaPlayer mediaPlayer2 = this.f141633a;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements MediaPlayer.OnCompletionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f141634a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MediaPlayer f141635b;

        public b(String str, MediaPlayer mediaPlayer, d dVar) {
            this.f141634a = str;
            this.f141635b = mediaPlayer;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            int hashCode;
            Object[] objArr = new Object[2];
            if (mediaPlayer == null) {
                hashCode = -1;
            } else {
                hashCode = mediaPlayer.hashCode();
            }
            objArr[0] = Integer.valueOf(hashCode);
            objArr[1] = this.f141634a;
            w.d("MicroMsg.PlaySound", "play completion mp:%d  path:%s", objArr);
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            MediaPlayer mediaPlayer2 = this.f141635b;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnPreparedListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f141636a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MediaPlayer f141637b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f141638c;

        public c(String str, MediaPlayer mediaPlayer, int i3) {
            this.f141636a = str;
            this.f141637b = mediaPlayer;
            this.f141638c = i3;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            int hashCode;
            Object[] objArr = new Object[2];
            if (mediaPlayer == null) {
                hashCode = -1;
            } else {
                hashCode = mediaPlayer.hashCode();
            }
            objArr[0] = Integer.valueOf(hashCode);
            objArr[1] = this.f141636a;
            w.d("MicroMsg.PlaySound", "play onPrepared mp:%d  path:%s", objArr);
            try {
                MediaPlayer mediaPlayer2 = this.f141637b;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.start();
                }
            } catch (Exception e16) {
                w.a("MicroMsg.PlaySound", e16, "play failed pathId:%d", Integer.valueOf(this.f141638c));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum e {
        NOTSET,
        ON,
        OFF
    }

    public static MediaPlayer a(Context context, int i3, e eVar, boolean z16, d dVar) {
        return a(context, i3, eVar, -1, z16, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaPlayer a(Context context, int i3, e eVar, int i16, boolean z16, d dVar) {
        Throwable th5;
        AssetFileDescriptor assetFileDescriptor;
        MediaPlayer mediaPlayer;
        AssetFileDescriptor assetFileDescriptor2;
        if (context == null || eVar == null) {
            w.b("MicroMsg.PlaySound", "play Err context:%s pathId:%d speekeron:%s looping:%b listener:%s", context, Integer.valueOf(i3), eVar, Boolean.valueOf(z16), dVar);
            return null;
        }
        String string = context.getString(i3);
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        if (eVar != e.NOTSET && -1 == i16) {
            mediaPlayer2.setAudioStreamType(eVar == e.ON ? 3 : 8);
        } else if (i16 != -1) {
            mediaPlayer2.setAudioStreamType(i16);
        }
        w.d("MicroMsg.PlaySound", "play start mp:%d path:%s context:%s pathId:%d speakerOn:%s looping:%b listener:%s ", Integer.valueOf(mediaPlayer2.hashCode()), string, context, Integer.valueOf(i3), eVar, Boolean.valueOf(z16), dVar);
        try {
            assetFileDescriptor2 = context.getAssets().openFd(string);
            try {
                try {
                    mediaPlayer = mediaPlayer2;
                    try {
                        mediaPlayer2.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
                        mediaPlayer.setLooping(z16);
                        mediaPlayer.setOnErrorListener(new a(mediaPlayer));
                        mediaPlayer.setOnCompletionListener(new b(string, mediaPlayer, dVar));
                        try {
                            mediaPlayer.setOnPreparedListener(new c(string, mediaPlayer, i3));
                            mediaPlayer.prepareAsync();
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(mediaPlayer.hashCode());
                            objArr[1] = Boolean.valueOf(Looper.myLooper() != null);
                            objArr[2] = Boolean.valueOf(Looper.getMainLooper() != null);
                            w.d("MicroMsg.PlaySound", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", objArr);
                            try {
                                assetFileDescriptor2.close();
                            } catch (IOException e16) {
                                w.a("MicroMsg.PlaySound", e16, "", new Object[0]);
                            }
                            return mediaPlayer;
                        } catch (Exception e17) {
                            e = e17;
                            w.b("MicroMsg.PlaySound", "play failed pathId:%d e:%s", Integer.valueOf(i3), e.getMessage());
                            w.a("MicroMsg.PlaySound", e, "", new Object[0]);
                            mediaPlayer.release();
                            if (assetFileDescriptor2 == null) {
                                return null;
                            }
                            try {
                                assetFileDescriptor2.close();
                                return null;
                            } catch (IOException e18) {
                                w.a("MicroMsg.PlaySound", e18, "", new Object[0]);
                                return null;
                            }
                        }
                    } catch (Exception e19) {
                        e = e19;
                    }
                } catch (Throwable th6) {
                    assetFileDescriptor = assetFileDescriptor2;
                    th5 = th6;
                    if (assetFileDescriptor == null) {
                        try {
                            assetFileDescriptor.close();
                            throw th5;
                        } catch (IOException e26) {
                            w.a("MicroMsg.PlaySound", e26, "", new Object[0]);
                            throw th5;
                        }
                    }
                    throw th5;
                }
            } catch (Exception e27) {
                e = e27;
                mediaPlayer = mediaPlayer2;
            }
        } catch (Exception e28) {
            e = e28;
            mediaPlayer = mediaPlayer2;
            assetFileDescriptor2 = null;
        } catch (Throwable th7) {
            th5 = th7;
            assetFileDescriptor = null;
            if (assetFileDescriptor == null) {
            }
        }
    }

    public static void a(Context context, int i3) {
        if (!f141632a) {
            a(context, i3, e.NOTSET, false, null);
        } else {
            l0.a(context, i3, l0.b.NOTSET, false, null);
        }
    }
}
