package com.tencent.qqnt.audio;

import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.utils.RecordParams;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface n {
    void a(String str, int i3, RecordParams.RecorderParam recorderParam);

    void b(String str);

    void c(String str);

    void d(int i3);

    void e(String str, Float f16, ArrayList<Byte> arrayList, RecordParams.RecorderParam recorderParam);

    void f(String str);

    void g(Boolean bool);

    void h(String str, Float f16, ArrayList<Byte> arrayList, RecordParams.RecorderParam recorderParam);

    void i(d.a aVar, RecordParams.RecorderParam recorderParam);

    boolean isRecording();

    String j();

    boolean n();
}
