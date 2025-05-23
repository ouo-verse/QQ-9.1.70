package com.tencent.mobileqq.tts.impl;

import android.media.AudioTrack;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.richmedia.TtsResBody$RspBody;
import com.tencent.mobileqq.richmedia.TtsResBody$voice_item;
import com.tencent.mobileqq.tts.ITtsPlayer;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.raft.codegenmeta.utils.RLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class TtsPlayerImpl implements ITtsPlayer {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TtsPlayer";
    private static final boolean VERBOSE_LOG = false;
    private com.tencent.mobileqq.tts.silk.a callback;
    private com.tencent.mobileqq.tts.stream.b inputStreamQueue;
    private PlayerThread playerThread;
    private State state;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class PlayerThread implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private SilkCodecWrapper f303390d;

        /* renamed from: e, reason: collision with root package name */
        private AudioTrack f303391e;

        /* renamed from: f, reason: collision with root package name */
        private volatile boolean f303392f;

        /* renamed from: h, reason: collision with root package name */
        private int f303393h;

        /* renamed from: i, reason: collision with root package name */
        private byte[] f303394i;

        /* renamed from: m, reason: collision with root package name */
        private byte[] f303395m;

        PlayerThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TtsPlayerImpl.this);
            }
        }

        private void e(int i3) {
            if (this.f303390d == null) {
                SilkCodecWrapper silkCodecWrapper = new SilkCodecWrapper(MobileQQ.sMobileQQ, false);
                this.f303390d = silkCodecWrapper;
                try {
                    silkCodecWrapper.b(i3, 0, 1);
                    int c16 = QQAudioUtils.c(i3);
                    this.f303394i = new byte[c16];
                    this.f303395m = new byte[c16];
                } catch (Exception e16) {
                    QLog.e(TtsPlayerImpl.TAG, 1, "[initCodecResource] error: ", e16);
                    this.f303390d = null;
                    return;
                }
            }
            if (this.f303391e == null) {
                try {
                    int minBufferSize = AudioTrack.getMinBufferSize(i3, 4, 2);
                    int i16 = this.f303393h;
                    if (i16 != 0) {
                        this.f303391e = new ReportAudioTrack(3, i3, 1, 2, minBufferSize, 1, i16);
                    } else {
                        this.f303391e = new ReportAudioTrack(3, i3, 1, 2, minBufferSize, 1);
                    }
                    this.f303391e.play();
                } catch (Exception e17) {
                    QLog.e(TtsPlayerImpl.TAG, 1, "[initCodecResource] AudioTrack init error: ", e17);
                    try {
                        AudioTrack audioTrack = this.f303391e;
                        if (audioTrack != null) {
                            audioTrack.release();
                        }
                    } catch (Exception e18) {
                        QLog.e(TtsPlayerImpl.TAG, 1, "[initCodecResource] AudioTrack release error: ", e18);
                    }
                    this.f303391e = null;
                }
            }
        }

        private c g(InputStream inputStream) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TtsPlayerImpl.TAG, 4, "[PlayerThread] playStream start.");
            }
            com.tencent.mobileqq.tts.stream.a aVar = new com.tencent.mobileqq.tts.stream.a(inputStream);
            boolean z16 = true;
            int i3 = 0;
            while (this.f303392f) {
                try {
                    if (TtsPlayerImpl.this.callback != null) {
                        TtsPlayerImpl.this.callback.f();
                    }
                    byte[] a16 = aVar.a();
                    if (TtsPlayerImpl.this.callback != null) {
                        TtsPlayerImpl.this.callback.g();
                    }
                    if (a16 != null && a16.length != 0) {
                        TtsResBody$RspBody ttsResBody$RspBody = new TtsResBody$RspBody();
                        try {
                            ttsResBody$RspBody.mergeFrom(a16);
                            if (QLog.isDevelopLevel()) {
                                QLog.i(TtsPlayerImpl.TAG, 4, "[PlayerThread] trunk data is parsed: " + a16.length);
                            }
                            int i16 = ttsResBody$RspBody.ret_code.get();
                            if (i16 != 0) {
                                return new c(false, i16, ttsResBody$RspBody.err_msg.get());
                            }
                            if (i3 == 0) {
                                i3 = ttsResBody$RspBody.pcm_sample_rate.get();
                            }
                            List<TtsResBody$voice_item> list = ttsResBody$RspBody.voice_data.get();
                            if (list != null && list.size() != 0) {
                                int i17 = 0;
                                while (true) {
                                    if (i17 >= list.size() || !this.f303392f) {
                                        break;
                                    }
                                    byte[] byteArray = list.get(i17).voice.get().toByteArray();
                                    if (z16 && com.tencent.mobileqq.tts.silk.c.a(byteArray)) {
                                        if (TtsPlayerImpl.this.callback != null) {
                                            TtsPlayerImpl.this.callback.d();
                                        }
                                        if (i3 == 0) {
                                            i3 = com.tencent.mobileqq.tts.silk.b.a(byteArray[0]);
                                        }
                                        byteArray = TtsPlayerImpl.subBytes(byteArray, 10, byteArray.length - 10);
                                        z16 = false;
                                    }
                                    if (i3 == 0) {
                                        QLog.w(TtsPlayerImpl.TAG, 1, "[PlayerThread] sample rate is 0.");
                                        this.f303392f = false;
                                        break;
                                    }
                                    e(i3);
                                    if (this.f303391e == null || this.f303390d == null) {
                                        break;
                                    }
                                    if (!f(new ByteArrayInputStream(byteArray))) {
                                        this.f303392f = false;
                                        break;
                                    }
                                    i17++;
                                }
                                QLog.w(TtsPlayerImpl.TAG, 1, "[PlayerThread] codec init failed.");
                                this.f303392f = false;
                                if (ttsResBody$RspBody.islast.get()) {
                                    QLog.i(TtsPlayerImpl.TAG, 1, "[PlayerThread] play complete, is last flag is true");
                                    return new c(true, i16, "");
                                }
                            } else {
                                QLog.i(TtsPlayerImpl.TAG, 1, "[PlayerThread] play complete, no voice data. isLast=" + ttsResBody$RspBody.islast.get());
                                return new c(true, i16, "");
                            }
                        } catch (Exception e16) {
                            QLog.e(TtsPlayerImpl.TAG, 1, "[PlayerThread] pb error. dataLength=" + a16.length + " exc=" + e16);
                            return new c(false, 0, "");
                        }
                    } else {
                        QLog.d(TtsPlayerImpl.TAG, 1, "[PlayerThread] play complete, data is empty");
                        return new c(true, 0, "");
                    }
                } catch (IOException | OutOfMemoryError e17) {
                    QLog.w(TtsPlayerImpl.TAG, 1, "[PlayerThread] get chunk input stream error. ", e17);
                    return new c(false, 0, "");
                }
            }
            QLog.w(TtsPlayerImpl.TAG, 1, "[PlayerThread] play interrupted. isAudioTrackPlaying: " + this.f303392f);
            return new c(false, 0, "");
        }

        int d(InputStream inputStream) throws IOException {
            byte[] bArr = new byte[2];
            if (inputStream.read(bArr, 0, 2) > 0) {
                return QQAudioUtils.b(bArr);
            }
            return -1;
        }

        boolean f(InputStream inputStream) {
            boolean z16;
            int d16;
            while (true) {
                try {
                    if (!this.f303392f || inputStream.available() <= 0) {
                        break;
                    }
                    d16 = d(inputStream);
                    z16 = false;
                    if (d16 < 0) {
                        break;
                    }
                    byte[] bArr = this.f303394i;
                    if (d16 > bArr.length) {
                        break;
                    }
                    int read = inputStream.read(bArr, 0, d16);
                    if (read < 0) {
                        QLog.d(TtsPlayerImpl.TAG, 1, "[playSilkStream] readSize < 0, stream end.");
                        break;
                    }
                    SilkCodecWrapper silkCodecWrapper = this.f303390d;
                    byte[] bArr2 = this.f303394i;
                    byte[] bArr3 = this.f303395m;
                    int f16 = silkCodecWrapper.f(bArr2, bArr3, read, bArr3.length);
                    if (f16 <= 0) {
                        QLog.d(TtsPlayerImpl.TAG, 1, "[playSilkStream] silk decode error. dataSize:" + read + " decodeSize: " + f16);
                        break;
                    }
                    if (this.f303392f) {
                        int write = this.f303391e.write(this.f303395m, 0, f16);
                        this.f303391e.flush();
                        if (write < 0) {
                            QLog.e(TtsPlayerImpl.TAG, 1, "[playSilkStream] AudioTrack error. writeSize: ", Integer.valueOf(write));
                            break;
                        }
                    }
                } catch (IOException e16) {
                    QLog.w(TtsPlayerImpl.TAG, 1, "[playSilkStream] io exception: " + e16);
                } catch (Exception e17) {
                    QLog.w(TtsPlayerImpl.TAG, 1, "[playSilkStream] exception: " + e17);
                }
            }
            QLog.d(TtsPlayerImpl.TAG, 1, "[playSilkStream] silk frameSize invalid. size: ", Integer.valueOf(d16));
            try {
                inputStream.close();
            } catch (Exception e18) {
                QLog.w(TtsPlayerImpl.TAG, 1, "musicInput close error, ", e18);
            }
            return z16;
            z16 = true;
            inputStream.close();
            return z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f303392f) {
                QLog.d(TtsPlayerImpl.TAG, 1, "[PlayerThread] other thread is working.");
                return;
            }
            if (TtsPlayerImpl.this.inputStreamQueue != null && !TtsPlayerImpl.this.inputStreamQueue.e()) {
                this.f303392f = true;
                String str = "";
                boolean z16 = false;
                int i3 = 0;
                do {
                    if (!this.f303392f) {
                        break;
                    }
                    com.tencent.mobileqq.tts.stream.b bVar = TtsPlayerImpl.this.inputStreamQueue;
                    if (bVar == null) {
                        QLog.i(TtsPlayerImpl.TAG, 1, "[PlayerThread] inputStreamQueue is null.");
                        break;
                    }
                    InputStream b16 = bVar.b();
                    if (b16 == null) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(TtsPlayerImpl.TAG, 4, "[PlayerThread] inputStream is null.");
                        }
                    } else {
                        c g16 = g(b16);
                        z16 = g16.c();
                        i3 = g16.b();
                        str = g16.a();
                        if (b16 instanceof com.tencent.mobileqq.tts.data.a) {
                            ((com.tencent.mobileqq.tts.data.a) b16).a(z16);
                        }
                        if (!this.f303392f) {
                            break;
                        }
                    }
                } while (z16);
                if (QLog.isDevelopLevel()) {
                    QLog.i(TtsPlayerImpl.TAG, 4, "[PlayerThread] playStream interrupted. isAudioTrackPlaying: " + this.f303392f + " complete: " + z16);
                }
                this.f303392f = false;
                if (TtsPlayerImpl.this.callback != null) {
                    if (z16) {
                        TtsPlayerImpl.this.callback.a();
                    } else {
                        TtsPlayerImpl.this.callback.e(i3, str);
                    }
                }
                AudioTrack audioTrack = this.f303391e;
                if (audioTrack != null) {
                    audioTrack.release();
                    return;
                }
                return;
            }
            QLog.w(TtsPlayerImpl.TAG, 1, "[PlayerThread] inputStream is null or closed.");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes19.dex */
    static final class State {
        private static final /* synthetic */ State[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final State END;
        public static final State ERROR;
        public static final State IDLE;
        public static final State INITIALIZED;
        public static final State PAUSED;
        public static final State PLAYBACK_COMPLETED;
        public static final State PREPARED;
        public static final State PREPARING;
        public static final State STARTED;
        public static final State STOPPED;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38867);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            State state = new State("IDLE", 0);
            IDLE = state;
            State state2 = new State("INITIALIZED", 1);
            INITIALIZED = state2;
            State state3 = new State("PREPARING", 2);
            PREPARING = state3;
            State state4 = new State("PREPARED", 3);
            PREPARED = state4;
            State state5 = new State("STARTED", 4);
            STARTED = state5;
            State state6 = new State("STOPPED", 5);
            STOPPED = state6;
            State state7 = new State("PAUSED", 6);
            PAUSED = state7;
            State state8 = new State("PLAYBACK_COMPLETED", 7);
            PLAYBACK_COMPLETED = state8;
            State state9 = new State("END", 8);
            END = state9;
            State state10 = new State(RLog.ERROR, 9);
            ERROR = state10;
            $VALUES = new State[]{state, state2, state3, state4, state5, state6, state7, state8, state9, state10};
        }

        State(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public TtsPlayerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.state = State.IDLE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$0() {
        this.inputStreamQueue.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] subBytes(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        return bArr2;
    }

    @Override // com.tencent.mobileqq.tts.ITtsPlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        PlayerThread playerThread = this.playerThread;
        if (playerThread != null && playerThread.f303392f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tts.ITtsPlayer
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        PlayerThread playerThread = this.playerThread;
        if (playerThread != null) {
            playerThread.f303392f = false;
            this.playerThread = null;
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsPlayer
    public void setDataStream(InputStream inputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) inputStream);
        } else {
            if (inputStream == null) {
                this.inputStreamQueue = null;
                return;
            }
            com.tencent.mobileqq.tts.stream.b bVar = new com.tencent.mobileqq.tts.stream.b();
            this.inputStreamQueue = bVar;
            bVar.c(inputStream, true);
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsPlayer
    public void setDataStreams(com.tencent.mobileqq.tts.stream.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            this.inputStreamQueue = bVar;
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsPlayer
    public void setPlayerCallback(com.tencent.mobileqq.tts.silk.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            this.callback = aVar;
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsPlayer
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            start(0);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsPlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d(TAG, 1, "[stop] stop play.");
        PlayerThread playerThread = this.playerThread;
        if (playerThread != null) {
            playerThread.f303392f = false;
        }
        if (this.inputStreamQueue == null) {
            QLog.d(TAG, 1, "[stop] stop play but inputStream is null.");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.tts.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    TtsPlayerImpl.this.lambda$stop$0();
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsPlayer
    public void start(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        QLog.d(TAG, 1, "[start] start play, session: ", Integer.valueOf(i3));
        if (this.playerThread == null) {
            this.playerThread = new PlayerThread();
        }
        this.playerThread.f303393h = i3;
        com.tencent.mobileqq.tts.stream.b bVar = this.inputStreamQueue;
        if (bVar != null && !bVar.e()) {
            ThreadManagerV2.excute(this.playerThread, 128, null, false);
        } else {
            QLog.d(TAG, 1, "[start] start play but inputStream is null.");
        }
    }
}
