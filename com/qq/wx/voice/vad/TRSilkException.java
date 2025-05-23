package com.qq.wx.voice.vad;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TRSilkException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private int f41137a;

    /* renamed from: b, reason: collision with root package name */
    private String f41138b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TRSilkException(int i3) {
        String str;
        this.f41138b = "";
        this.f41137a = i3;
        switch (i3) {
            case -107:
                str = "the input size is too long";
                break;
            case -106:
                str = "sample rate must between 0 and 16000";
                break;
            case -105:
                str = "bit rate must between 0 and 48000";
                break;
            case -104:
                str = "null param or 0 length";
                break;
            case -103:
                str = "already init";
                break;
            case -102:
                str = "should init at first";
                break;
            case -101:
                str = "silk engine error";
                break;
            case -100:
                str = "out of memory";
                break;
            default:
                str = "unknown error";
                break;
        }
        this.f41138b = str;
        Log.e("TRSilkException", "errorCode: " + this.f41137a + "\t msg: " + this.f41138b);
    }

    public int getErrorCode() {
        return this.f41137a;
    }

    public String getErrorMsg() {
        return this.f41138b;
    }
}
