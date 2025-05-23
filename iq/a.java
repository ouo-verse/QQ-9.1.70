package iq;

import android.os.Handler;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends AudioCapture {
    private final g G;
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.g H;
    private final AudioCapture.b I;

    /* compiled from: P */
    /* renamed from: iq.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10547a implements AudioCapture.b {
        C10547a() {
        }

        @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
        public void onAudioCaptured(String str) {
            if (a.this.H != null) {
                a.this.U();
            }
            if (a.this.I != null) {
                a.this.I.onAudioCaptured(str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
        public void onAudioChangeCaptured(String str) {
            if (a.this.I != null) {
                a.this.I.onAudioChangeCaptured(str);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
        public void onAudioError(int i3) {
            if (a.this.I != null) {
                a.this.I.onAudioError(i3);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
        public void onAudioFrames(byte[] bArr, int i3, int i16) {
            if (a.this.I != null) {
                a.this.I.onAudioFrames(bArr, i3, i16);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
        public void onAudioInit() {
            if (a.this.I != null) {
                a.this.I.onAudioInit();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
        public void onAudioUnInit() {
            if (a.this.I != null) {
                a.this.I.onAudioUnInit();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
        public void onEncodeAudioCaptured(String str) {
            if (a.this.I != null) {
                a.this.I.onEncodeAudioCaptured(str);
            }
        }
    }

    public a(String str, int i3, int i16, int i17, int i18, AudioCapture.b bVar, Handler handler) {
        super(str, i3, i16, i17, i18, bVar, handler);
        this.G = new g();
        this.I = bVar;
        this.f312493y = new C10547a();
    }

    private void V(byte[] bArr, int i3, boolean z16) {
        if (this.H == null || bArr == null || i3 <= 0 || i3 > bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        this.G.c(bArr2, i3, z16);
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture
    public void N() {
        if (this.H == null) {
            ms.a.c("AEAudioCapture", "startRecording but muxerWrapper not set");
            super.N();
        } else {
            this.G.b();
            this.G.d(this.H, this.f312475g);
            super.N();
        }
    }

    public void U() {
        ms.a.f("AEAudioCapture", "destroy");
        this.G.a();
    }

    public void W(com.tencent.mobileqq.videocodec.mediacodec.recorder.g gVar) {
        this.H = gVar;
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture
    public void Q(byte[] bArr, int i3) {
        V(bArr, i3, false);
        super.Q(bArr, i3);
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture
    public void R(byte[] bArr, int i3) {
        V(bArr, i3, true);
    }
}
