package com.tencent.mobileqq.shortvideo.mediadevice;

import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.editor.composite.CodecParam;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static String f288187b;

    /* renamed from: c, reason: collision with root package name */
    public static c f288188c = new c();

    /* renamed from: a, reason: collision with root package name */
    private yq2.d f288189a;

    c() {
        f288187b = getClass().getSimpleName();
    }

    public static c b() {
        return f288188c;
    }

    public void a() {
        this.f288189a = null;
    }

    public AVCodec c() {
        return AVCodec.get();
    }

    public ar2.a d() {
        return ar2.a.a();
    }

    public yq2.d e() {
        if (this.f288189a == null) {
            this.f288189a = new yq2.d(40, CodecParam.RECORD_MAX_TIME);
        }
        return this.f288189a;
    }
}
