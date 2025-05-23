package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.editor.composite.CodecParam;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AudioEncoder {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f288226a;

        /* renamed from: b, reason: collision with root package name */
        public String f288227b;

        /* renamed from: c, reason: collision with root package name */
        public int f288228c;

        /* renamed from: d, reason: collision with root package name */
        public int f288229d;

        /* renamed from: e, reason: collision with root package name */
        public int f288230e;

        /* renamed from: f, reason: collision with root package name */
        public int f288231f;

        /* renamed from: g, reason: collision with root package name */
        public int f288232g;

        /* renamed from: h, reason: collision with root package name */
        public float f288233h = 1.0f;
    }

    public static int a(String str) {
        if (str != null && !"".equals(str)) {
            File file = new File(str);
            if (!file.exists()) {
                return -202;
            }
            if (file.length() <= 0) {
                return -203;
            }
            return 0;
        }
        return -201;
    }

    public static int b(a aVar) {
        try {
            return encode(aVar.f288226a, aVar.f288227b, aVar.f288228c, aVar.f288229d, aVar.f288230e, aVar.f288231f, aVar.f288232g);
        } catch (UnsatisfiedLinkError unused) {
            return -200;
        }
    }

    public static a c(String str, String str2, int i3) {
        a aVar = new a();
        aVar.f288226a = str;
        aVar.f288227b = str2;
        aVar.f288228c = i3;
        aVar.f288231f = CodecParam.mAudioSampleRate;
        aVar.f288230e = CodecParam.mDstAudioEncBitrate;
        if (CodecParam.mAudioFormat == 2) {
            aVar.f288229d = 16;
        } else {
            aVar.f288229d = 8;
        }
        if (CodecParam.mAudioChannel == 16) {
            aVar.f288232g = 1;
        } else {
            aVar.f288232g = 2;
        }
        return aVar;
    }

    private static native int encode(String str, String str2, int i3, int i16, int i17, int i18, int i19);
}
