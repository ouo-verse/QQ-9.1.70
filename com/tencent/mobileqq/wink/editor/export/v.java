package com.tencent.mobileqq.wink.editor.export;

import com.gyailib.library.GYAssessPicQualityOption;

/* compiled from: P */
/* loaded from: classes21.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private boolean f320264a;

    /* renamed from: b, reason: collision with root package name */
    private GYAssessPicQualityOption f320265b;

    /* renamed from: c, reason: collision with root package name */
    private String f320266c;

    private String d(GYAssessPicQualityOption gYAssessPicQualityOption) {
        if (gYAssessPicQualityOption == null) {
            return "null";
        }
        return "{enableDelogo = " + gYAssessPicQualityOption.enableDelogo + ", enableDeblur = " + gYAssessPicQualityOption.enableDeblur + ", enableFace = " + gYAssessPicQualityOption.enableFace + "}";
    }

    public String a() {
        return this.f320266c;
    }

    public GYAssessPicQualityOption b() {
        return this.f320265b;
    }

    public boolean c() {
        return this.f320264a;
    }

    public void e(String str) {
        this.f320266c = str;
    }

    public void f(GYAssessPicQualityOption gYAssessPicQualityOption) {
        this.f320265b = gYAssessPicQualityOption;
    }

    public void g(boolean z16) {
        this.f320264a = z16;
    }

    public String toString() {
        return "WinkPicQualityOption: {isHDREnable=" + this.f320264a + ", gyAssessPicQualityOption=" + d(this.f320265b) + ", cacheDir='" + this.f320266c + "'}";
    }
}
