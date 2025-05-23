package com.qq.wx.voice.synthesizer;

import android.content.Context;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.UnsupportedEncodingException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private boolean f41100b = false;

    /* renamed from: a, reason: collision with root package name */
    protected InnerHttp f41099a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(SpeechSynthesizerListener speechSynthesizerListener) {
        InfoSynthesizer.f41069b.f41095b = speechSynthesizerListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        if (this.f41100b) {
            a();
            this.f41100b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(Context context, String str) {
        SpeechSynthesizerCallback speechSynthesizerCallback = InfoSynthesizer.f41069b;
        if (speechSynthesizerCallback.f41095b == null) {
            return -1;
        }
        speechSynthesizerCallback.f41094a = this;
        if (this.f41100b) {
            return 0;
        }
        InfoSynthesizer.f41068a = str;
        InfoSynthesizer.f41070c.init(context);
        InfoSynthesizer.f41071d.init(context);
        InfoSynthesizer.f41072e.init(context);
        this.f41100b = true;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(String str) {
        SpeechSynthesizerCallback speechSynthesizerCallback = InfoSynthesizer.f41069b;
        if (speechSynthesizerCallback.f41095b == null) {
            return -1;
        }
        if (!this.f41100b) {
            speechSynthesizerCallback.a(ErrorCode.WX_TTS_ERROR_UNINIT);
            return -1;
        }
        if (this.f41099a != null) {
            speechSynthesizerCallback.a(ErrorCode.WX_TTS_ERROR_RESTART);
            return -1;
        }
        speechSynthesizerCallback.a();
        if (str != null && !str.isEmpty()) {
            try {
                if (str.getBytes("gbk").length > InfoSynthesizer.f41073f) {
                    InfoSynthesizer.f41069b.a(ErrorCode.WX_TTS_ERROR_TEXT_OVER_LENGTH);
                    return -1;
                }
                this.f41099a = new InnerHttp(str);
                new BaseThread(this.f41099a).start();
                return 0;
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                InfoSynthesizer.f41069b.a(ErrorCode.WX_TTS_ERROR_TEXT_TO_GBK);
                return -1;
            }
        }
        InfoSynthesizer.f41069b.a(ErrorCode.WX_TTS_ERROR_TEXT_NULL);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        if (this.f41099a != null) {
            InfoSynthesizer.f41069b.a(SpeechSynthesizerState.Canceling);
            this.f41099a.a();
            this.f41099a = null;
            InfoSynthesizer.f41069b.a(SpeechSynthesizerState.Canceled);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(int i3) {
        InfoSynthesizer.f41075h = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(float f16) {
        InfoSynthesizer.f41076i = f16;
    }
}
