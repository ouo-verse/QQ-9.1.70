package com.qq.wx.voice.embedqqegg.recognizer;

import android.content.Context;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Grammar {

    /* renamed from: a, reason: collision with root package name */
    private a f40904a;

    /* renamed from: b, reason: collision with root package name */
    private Context f40905b;

    /* renamed from: c, reason: collision with root package name */
    private GrammarResult f40906c = new GrammarResult();

    /* renamed from: d, reason: collision with root package name */
    private int f40907d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f40908e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f40909f = -1;

    public Grammar() {
        this.f40904a = null;
        this.f40904a = new a();
    }

    public int begin() {
        if (this.f40909f == 0) {
            this.f40909f = 1;
            try {
                if (GrammarNative.setKeywordSetIndex(InfoRecognizer.f40914e) < 0) {
                    return -1;
                }
                if (GrammarNative.begin() < 0) {
                    return -1;
                }
                return 0;
            } catch (Exception e16) {
                e16.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    public int destroy() {
        try {
            if (GrammarNative.destroy() < 0) {
                return -1;
            }
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public int end() {
        if (this.f40909f == 1) {
            this.f40909f = 0;
            try {
                if (GrammarNative.end() < 0) {
                    return -1;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    public int getResult(GrammarResult grammarResult) {
        try {
            if (GrammarNative.getResult(this) < 0) {
                return -1;
            }
            GrammarResult grammarResult2 = this.f40906c;
            grammarResult.text = grammarResult2.text;
            grammarResult.name = grammarResult2.name;
            grammarResult.action = grammarResult2.action;
            grammarResult.type = grammarResult2.type;
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public int getVersion(SDKVersion sDKVersion) {
        try {
            if (GrammarNative.getVersion(this) < 0) {
                return -1;
            }
            sDKVersion.soVer = this.f40907d;
            sDKVersion.binVer = this.f40908e;
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public int init(Context context) {
        this.f40905b = context;
        if (this.f40904a.a(context) < 0) {
            return -1;
        }
        try {
            if (GrammarNative.init(this.f40904a.a().getBytes(), this.f40904a.b().getBytes(), null) < 0) {
                return -1;
            }
            this.f40909f = 0;
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0017, code lost:
    
        if (r3.f40906c.type != 0) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGetResult(int i3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        GrammarResult grammarResult = this.f40906c;
        grammarResult.type = i3;
        if (bArr != null) {
            try {
                grammarResult.text = new String(bArr, "GBK");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return;
            }
        }
        this.f40906c.text = "";
        if (bArr2 != null) {
            this.f40906c.action = new String(bArr2, "GBK");
        } else {
            this.f40906c.action = "";
        }
        if (bArr3 != null) {
            this.f40906c.name = new String(bArr3, "GBK");
        } else {
            this.f40906c.name = "";
        }
    }

    public void onGetVersion(int i3, int i16) {
        this.f40907d = i3;
        this.f40908e = i16;
    }

    public int recognize(byte[] bArr, int i3) {
        if (this.f40909f != 1) {
            return 0;
        }
        try {
            int recognize = GrammarNative.recognize(bArr, i3);
            if (recognize < 0) {
                return -1;
            }
            if (recognize == 1) {
                this.f40909f = 0;
                return 1;
            }
            return recognize;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public int setKeywordSetIndex(int i3) {
        return GrammarNative.setKeywordSetIndex(i3);
    }
}
