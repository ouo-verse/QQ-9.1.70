package com.tencent.luggage.wxa.a3;

import com.tencent.luggage.wxa.ih.h;
import com.tencent.luggage.wxa.ri.b;
import com.tencent.luggage.wxa.ri.d;
import com.tencent.luggage.wxa.ri.e;
import com.tencent.luggage.wxa.ri.f;
import com.tencent.luggage.wxa.ri.g;
import com.tencent.xweb.FileReaderHelper;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends h {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C5983a extends b {
        @Override // com.tencent.luggage.wxa.ri.b
        public d b(String str) {
            if (FileReaderHelper.AAC_EXT.equalsIgnoreCase(str)) {
                return new com.tencent.luggage.wxa.ri.a();
            }
            if (FileReaderHelper.MP3_EXT.equalsIgnoreCase(str)) {
                return new e();
            }
            if (FileReaderHelper.WAV_EXT.equalsIgnoreCase(str)) {
                return new g();
            }
            if ("pcm".equalsIgnoreCase(str)) {
                return new f();
            }
            return null;
        }
    }

    static {
        b.a(new C5983a());
    }
}
