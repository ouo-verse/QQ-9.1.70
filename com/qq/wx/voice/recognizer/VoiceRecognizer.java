package com.qq.wx.voice.recognizer;

import android.content.Context;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.vad.TRSilkDecoder;
import com.qq.wx.voice.vad.TRSilkEncoder;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceRecognizer {

    /* renamed from: a, reason: collision with root package name */
    private static VoiceRecognizer f41033a;

    /* renamed from: b, reason: collision with root package name */
    private b f41034b = new b();

    VoiceRecognizer() {
    }

    public static VoiceRecognizer shareInstance() {
        if (f41033a == null) {
            f41033a = new VoiceRecognizer();
        }
        return f41033a;
    }

    public int appendData(byte[] bArr, int i3, int i16, boolean z16) {
        return this.f41034b.a(bArr, i3, i16, z16);
    }

    public int cancel() {
        this.f41034b.c();
        return 0;
    }

    public void destroy() {
        this.f41034b.d();
    }

    public int init(Context context, String str) {
        return this.f41034b.a(context, str);
    }

    public int initNoLoadSo(Context context, String str) {
        return this.f41034b.b(context, str);
    }

    public byte[] processPCMToSilk(byte[] bArr) {
        return TRSilkEncoder.processPCMToSilk(bArr);
    }

    public byte[] processSilkToPCM(byte[] bArr) {
        return TRSilkDecoder.processSilkToPCM(bArr);
    }

    public void recvResponse(byte[] bArr) {
        this.f41034b.a(bArr);
    }

    public void resetDomain() {
        InfoSender.resetDomain();
    }

    public void resetGetPureRes() {
        b.f();
    }

    public void resetUri() {
        InfoSender.resetUri();
    }

    public void setBackRecord(boolean z16) {
        b.e(z16);
    }

    public void setCompressOpen(boolean z16) {
        b.b(z16);
    }

    public void setContReco(boolean z16) {
        b.d(z16);
    }

    public void setContRes(boolean z16) {
        b.c(z16);
    }

    public void setDomain(String str, int i3, String str2) {
        InfoSender.setDomain(str, i3, str2);
    }

    public void setGetArgs(String str) {
        b.b(str);
    }

    public void setGetPackageMode(boolean z16) {
        b.f(z16);
    }

    public void setGetPureRes(boolean z16) {
        b.g(z16);
    }

    public void setListener(VoiceRecognizerListener voiceRecognizerListener) {
        b.a(voiceRecognizerListener);
    }

    public void setMaxResultCount(int i3) {
        b.d(i3);
    }

    public void setOpenLogCat(boolean z16) {
        LogTool.isShow = z16;
    }

    public void setResultType(int i3) {
        b.e(i3);
    }

    public void setSaveSilk(boolean z16) {
        b.i(z16);
    }

    public void setSaveVoice(boolean z16) {
        b.h(z16);
    }

    public void setSemanticType(String str) {
        if (str != null) {
            b.a(str);
        }
    }

    public void setSilentTime(int i3) {
        b.a(i3);
    }

    public void setTimeout(int i3) {
        b.b(i3);
    }

    public void setUri(String str) {
        InfoSender.setUri(str);
    }

    public void setVadOpen(boolean z16) {
        b.a(z16);
    }

    public void setVrDomain(int i3) {
        b.c(i3);
    }

    public int start() {
        return this.f41034b.a();
    }

    public int startReceiving() {
        return this.f41034b.e();
    }

    public int stop() {
        this.f41034b.b();
        return 0;
    }

    public int init(Context context, String str, String str2) {
        return this.f41034b.a(context, str, str2);
    }

    public void setSaveSpeex(boolean z16) {
    }
}
