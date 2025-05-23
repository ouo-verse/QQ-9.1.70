package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.karaoke.decodesdk.M4AInformation;
import com.tencent.karaoke.decodesdk.M4aDecoder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
class f implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final M4aDecoder f273250a;

    /* renamed from: b, reason: collision with root package name */
    private a f273251b;

    /* renamed from: c, reason: collision with root package name */
    private c f273252c;

    /* renamed from: d, reason: collision with root package name */
    private int f273253d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public byte[] f273254a;

        /* renamed from: b, reason: collision with root package name */
        public int f273255b;

        /* renamed from: c, reason: collision with root package name */
        public int f273256c;

        public a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
                return;
            }
            this.f273254a = new byte[i3];
            this.f273255b = 0;
            this.f273256c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f273250a = new M4aDecoder();
        this.f273252c = null;
        this.f273253d = -1;
    }

    private int i(M4aDecoder m4aDecoder, a aVar, byte[] bArr, int i3) {
        int i16 = aVar.f273255b;
        int i17 = aVar.f273256c;
        int i18 = 0;
        if (i16 - i17 >= i3) {
            System.arraycopy(aVar.f273254a, i17, bArr, 0, i3);
            aVar.f273256c += i3;
            return i3;
        }
        int i19 = i16 - i17;
        if (i19 > 0) {
            System.arraycopy(aVar.f273254a, i17, bArr, 0, i19);
        }
        int decode = m4aDecoder.decode(8192, aVar.f273254a);
        aVar.f273255b = decode;
        int min = Math.min(decode, i3 - i19);
        if (min > 0) {
            System.arraycopy(aVar.f273254a, 0, bArr, i19, min);
            i18 = min;
        } else {
            QLog.e("RTCWeSingDecoder", 1, "getPCMData len2=" + min + ",decodeLength=" + aVar.f273255b);
        }
        aVar.f273256c = i18;
        return i19 + i18;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.f273250a.getCurrentTime();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f273252c;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public int e(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr, i3)).intValue();
        }
        return i(this.f273250a, this.f273251b, bArr, i3);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f273253d;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public long getDurationMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        c cVar = this.f273252c;
        if (cVar == null) {
            return -1L;
        }
        return cVar.b();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public int open(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        QLog.i("RTCWeSingDecoder", 1, "Api call: open file:" + str);
        if (TextUtils.isEmpty(str)) {
            QLog.e("RTCWeSingDecoder", 1, "MusicDecoder file is null ");
            return QQLiveError.RTC_ERR_INVALID_ARGUMENT;
        }
        int init = this.f273250a.init(str);
        if (init != 0) {
            QLog.e("RTCWeSingDecoder", 1, "decoder init failed, error:" + init);
            return QQLiveError.RTC_ERR_FAIL;
        }
        M4AInformation audioInformation = this.f273250a.getAudioInformation();
        if (audioInformation == null) {
            QLog.e("RTCWeSingDecoder", 1, "getAudioInformation fail");
            return QQLiveError.RTC_ERR_FAIL;
        }
        c a16 = d.a(audioInformation);
        this.f273252c = a16;
        this.f273253d = ((int) ((a16.c() * this.f273252c.a()) * 2)) / 50;
        this.f273251b = new a(32768);
        QLog.i("RTCWeSingDecoder", 1, "  audio info=" + this.f273252c + " frameLength=" + this.f273253d);
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f273250a.release();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public void seekTo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.f273250a.seekTo((int) j3);
        }
    }
}
