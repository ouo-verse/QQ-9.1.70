package com.tencent.karaoke.recordsdk.media.audio;

import android.os.Process;
import com.tencent.component.utils.LogUtil;
import com.tencent.karaoke.audiobasesdk.KaraMediaCrypto;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;

/* loaded from: classes7.dex */
public class KaraM4aPlayer extends m {

    /* loaded from: classes7.dex */
    private class FileThread extends BaseHandlerThread {
        private boolean C;
        private RandomAccessFile D;
        private LinkedList<ByteBuffer> E;
        private KaraMediaCrypto F;
        private int G;

        /* renamed from: m, reason: collision with root package name */
        private boolean f116995m;
        final /* synthetic */ KaraM4aPlayer this$0;

        /* renamed from: com.tencent.karaoke.recordsdk.media.audio.KaraM4aPlayer$FileThread$1, reason: invalid class name */
        /* loaded from: classes7.dex */
        class AnonymousClass1 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ByteBuffer f116996d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f116997e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ FileThread f116998f;

            @Override // java.lang.Runnable
            public void run() {
                if (this.f116998f.f116995m && !this.f116998f.C) {
                    try {
                        this.f116996d.flip();
                        FileChannel channel = this.f116998f.D.getChannel();
                        if (this.f116998f.F != null && this.f116997e > 0) {
                            this.f116998f.F.encryptByteBuffer((int) channel.position(), this.f116996d, this.f116997e);
                        }
                        if (channel.write(this.f116996d) == 0) {
                            LogUtil.i("KaraM4aPlayer", "onDecode -> write data to file failed");
                            this.f116998f.f116995m = false;
                            try {
                                this.f116998f.D.close();
                            } catch (IOException e16) {
                                LogUtil.w("KaraM4aPlayer", e16);
                            }
                            this.f116998f.D = null;
                        }
                        FileThread.k(this.f116998f);
                        this.f116996d.clear();
                        synchronized (this.f116998f.E) {
                            if (this.f116998f.E.size() < 8) {
                                this.f116998f.E.add(this.f116996d);
                            }
                        }
                    } catch (IOException e17) {
                        LogUtil.w("KaraM4aPlayer", e17);
                        this.f116998f.f116995m = false;
                        try {
                            this.f116998f.D.close();
                        } catch (IOException e18) {
                            LogUtil.w("KaraM4aPlayer", e18);
                        }
                        this.f116998f.D = null;
                    }
                }
            }
        }

        /* renamed from: com.tencent.karaoke.recordsdk.media.audio.KaraM4aPlayer$FileThread$2, reason: invalid class name */
        /* loaded from: classes7.dex */
        class AnonymousClass2 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f116999d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FileThread f117000e;

            @Override // java.lang.Runnable
            public void run() {
                if (this.f117000e.f116995m) {
                    try {
                        try {
                            long length = this.f117000e.D.length();
                            LogUtil.i("KaraM4aPlayer", "onSeek -> seek position:" + this.f116999d + ", file length:" + length);
                            int i3 = this.f116999d;
                            if (i3 > length) {
                                LogUtil.w("KaraM4aPlayer", "seek exceed the file size, pause saving obbligato");
                                this.f117000e.C = true;
                                return;
                            }
                            if (i3 < length) {
                                LogUtil.i("KaraM4aPlayer", "seek, continue saving obbligato");
                                this.f117000e.C = false;
                                try {
                                    this.f117000e.D.seek(this.f116999d);
                                    this.f117000e.D.setLength(this.f116999d);
                                    LogUtil.i("KaraM4aPlayer", "yes, file seek finish\uff1a" + this.f116999d);
                                    return;
                                } catch (IOException e16) {
                                    LogUtil.w("KaraM4aPlayer", e16);
                                    try {
                                        this.f117000e.D.close();
                                    } catch (IOException e17) {
                                        LogUtil.w("KaraM4aPlayer", e17);
                                    }
                                    this.f117000e.f116995m = false;
                                    this.f117000e.D = null;
                                    return;
                                }
                            }
                            return;
                        } catch (IOException e18) {
                            LogUtil.w("KaraM4aPlayer", e18);
                            this.f117000e.f116995m = false;
                            this.f117000e.D = null;
                            return;
                        }
                    } catch (IOException unused) {
                        this.f117000e.D.close();
                        this.f117000e.f116995m = false;
                        this.f117000e.D = null;
                        return;
                    }
                }
                LogUtil.i("KaraM4aPlayer", "onSeek -> ignore seek request");
                if (this.f117000e.D != null) {
                    try {
                        this.f117000e.D.close();
                    } catch (IOException e19) {
                        LogUtil.w("KaraM4aPlayer", e19);
                    }
                    this.f117000e.D = null;
                }
            }
        }

        /* renamed from: com.tencent.karaoke.recordsdk.media.audio.KaraM4aPlayer$FileThread$3, reason: invalid class name */
        /* loaded from: classes7.dex */
        class AnonymousClass3 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FileThread f117001d;

            @Override // java.lang.Runnable
            public void run() {
                if (this.f117001d.D != null) {
                    try {
                        this.f117001d.D.close();
                    } catch (IOException e16) {
                        LogUtil.w("KaraM4aPlayer", e16);
                    }
                }
                if (this.f117001d.F != null) {
                    this.f117001d.F.java_release();
                }
                this.f117001d.quit();
                LogUtil.i("KaraM4aPlayer", "onStop -> file thread quit");
            }
        }

        static /* synthetic */ int k(FileThread fileThread) {
            int i3 = fileThread.G;
            fileThread.G = i3 + 1;
            return i3;
        }
    }

    /* loaded from: classes7.dex */
    private class PlayThread extends BaseThread {
        final /* synthetic */ KaraM4aPlayer this$0;

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            LogUtil.i("KaraM4aPlayer", getName() + " begin");
            System.currentTimeMillis();
            Process.setThreadPriority(-16);
            KaraM4aPlayer.d(null).getDuration();
            System.currentTimeMillis();
            throw null;
        }
    }

    static /* synthetic */ sz0.a d(KaraM4aPlayer karaM4aPlayer) {
        throw null;
    }
}
