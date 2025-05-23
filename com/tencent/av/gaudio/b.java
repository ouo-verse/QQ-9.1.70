package com.tencent.av.gaudio;

import com.tencent.avcore.engine.mav.IMavEventListener;
import com.tencent.avcore.jni.data.AVUserInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface b extends IMavEventListener {
    long a(int i3, int i16, long j3);

    void b(long j3, ArrayList<AVUserInfo> arrayList);

    boolean d(long j3, int i3);

    void g(long j3, long j16, ArrayList<a> arrayList);

    void h(byte[] bArr, int i3, int i16, int i17, int i18);

    void i(long j3, long j16, String str);

    void j();
}
