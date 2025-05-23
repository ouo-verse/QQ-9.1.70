package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface b {
    void A0(String str, Object obj, int i3);

    void W();

    void X1(int i3, int i16, long j3);

    void c0(String str);

    AppInterface getApp();

    void j2(String[] strArr, int[] iArr);

    void m(int i3);

    @Nullable
    d m0(String str);

    void o0(int i3, Bundle bundle, com.tencent.mobileqq.profile.like.a aVar);

    void request(String str, MessageMicro messageMicro, Class cls, BusinessObserver businessObserver);

    void request(String str, String str2, BusinessObserver businessObserver);

    void request(String str, byte[] bArr, BusinessObserver businessObserver);

    void y0(int i3, String str, int i16, String str2, int i17);
}
