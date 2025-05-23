package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f273246a;

    /* renamed from: b, reason: collision with root package name */
    private b f273247b;

    /* renamed from: c, reason: collision with root package name */
    private c f273248c;

    /* renamed from: d, reason: collision with root package name */
    private c f273249d;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f273246a = null;
        this.f273247b = null;
        this.f273248c = null;
        this.f273249d = null;
    }

    private void i(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.f273247b = new f();
        }
        if (!TextUtils.isEmpty(str)) {
            this.f273246a = new f();
        }
    }

    private c j(@NonNull b bVar, @NonNull String str) {
        int open = bVar.open(str);
        if (open != 0) {
            QLog.e("RTCMusicDecoder", 1, " decoder open failed : " + open);
            return null;
        }
        return bVar.c();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        b bVar = this.f273246a;
        if (bVar != null) {
            return bVar.a();
        }
        b bVar2 = this.f273247b;
        if (bVar2 != null) {
            return bVar2.a();
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.a
    public int b(String str, String str2) {
        b bVar;
        b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        QLog.i("RTCMusicDecoder", 1, "Api call:open[" + str + ", " + str2 + "]");
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            QLog.e("RTCMusicDecoder", 1, "origin file and dub file is null ");
            return QQLiveError.RTC_ERR_FAIL;
        }
        i(str, str2);
        if (!TextUtils.isEmpty(str) && (bVar2 = this.f273246a) != null) {
            c j3 = j(bVar2, str);
            this.f273248c = j3;
            if (j3 == null) {
                QLog.e("RTCMusicDecoder", 1, "origin decoder open failed ");
                return QQLiveError.RTC_ERR_FAIL;
            }
            QLog.i("RTCMusicDecoder", 1, " origin file duration : " + (this.f273248c.b() / 1000));
        }
        if (!TextUtils.isEmpty(str2) && (bVar = this.f273247b) != null) {
            c j16 = j(bVar, str2);
            this.f273249d = j16;
            if (j16 == null) {
                QLog.e("RTCMusicDecoder", 1, "dub decoder open failed ");
                return QQLiveError.RTC_ERR_FAIL;
            }
            QLog.i("RTCMusicDecoder", 1, " dub file duration : " + (this.f273249d.b() / 1000));
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        b bVar = this.f273246a;
        if (bVar == null) {
            QLog.e("RTCMusicDecoder", 1, "origin decoder is null");
            return null;
        }
        return bVar.c();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.a
    public c d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        b bVar = this.f273247b;
        if (bVar == null) {
            QLog.e("RTCMusicDecoder", 1, "dub decoder is null");
            return null;
        }
        return bVar.c();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public int e(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr, i3)).intValue();
        }
        b bVar = this.f273246a;
        if (bVar == null) {
            QLog.e("RTCMusicDecoder", 1, "origin decoder is null");
            return -1;
        }
        return bVar.e(bArr, i3);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        b bVar = this.f273246a;
        if (bVar == null) {
            QLog.e("RTCMusicDecoder", 1, "origin decoder is null");
            return -1;
        }
        return bVar.f();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.a
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        b bVar = this.f273247b;
        if (bVar == null) {
            QLog.e("RTCMusicDecoder", 1, "dub decoder is null");
            return -1;
        }
        return bVar.f();
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public long getDurationMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        b bVar = this.f273246a;
        if (bVar != null) {
            return bVar.getDurationMs();
        }
        b bVar2 = this.f273247b;
        if (bVar2 != null) {
            return bVar2.getDurationMs();
        }
        return -1L;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.a
    public int h(byte[] bArr, byte[] bArr2, int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        b bVar = this.f273246a;
        int i18 = -1;
        if (bVar != null) {
            i17 = bVar.e(bArr, i3);
        } else {
            i17 = -1;
        }
        b bVar2 = this.f273247b;
        if (bVar2 != null) {
            i18 = bVar2.e(bArr2, i16);
        }
        b bVar3 = this.f273246a;
        if (bVar3 != null && this.f273247b != null) {
            if (i17 == i3) {
                return i18;
            }
            return i17;
        }
        if (bVar3 != null) {
            return i17;
        }
        if (this.f273247b == null) {
            return 0;
        }
        return i18;
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public int open(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        return b(str, null);
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        b bVar = this.f273246a;
        if (bVar != null) {
            bVar.release();
        }
        b bVar2 = this.f273247b;
        if (bVar2 != null) {
            bVar2.release();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder.b
    public void seekTo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
            return;
        }
        b bVar = this.f273246a;
        if (bVar != null) {
            bVar.seekTo(j3);
        }
        b bVar2 = this.f273247b;
        if (bVar2 != null) {
            bVar2.seekTo(j3);
        }
    }
}
