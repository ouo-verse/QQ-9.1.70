package com.tencent.luggage.wxa.ri;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.FileReaderHelper;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f139756a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends b {
        @Override // com.tencent.luggage.wxa.ri.b
        public d b(String str) {
            w.d("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", str);
            if (!com.tencent.luggage.wxa.qi.g.d(str)) {
                return null;
            }
            if (FileReaderHelper.AAC_EXT.equalsIgnoreCase(str)) {
                return new com.tencent.luggage.wxa.ri.a();
            }
            if (FileReaderHelper.MP3_EXT.equalsIgnoreCase(str)) {
                return new e();
            }
            if (FileReaderHelper.WAV_EXT.equalsIgnoreCase(str)) {
                return new g();
            }
            if (!"pcm".equalsIgnoreCase(str)) {
                return null;
            }
            return new f();
        }
    }

    public static void a(b bVar) {
        f139756a = bVar;
    }

    public abstract d b(String str);

    public static d a(String str) {
        return f139756a.b(str);
    }
}
