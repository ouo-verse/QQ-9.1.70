package com.tencent.mobileqq.qfix.redirect;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes16.dex */
public interface IPatchRedirector {
    boolean hasPatch(short s16);

    Object redirect(short s16);

    Object redirect(short s16, Object obj);

    Object redirect(short s16, Object obj, int i3);

    Object redirect(short s16, Object obj, int i3, Object obj2);

    Object redirect(short s16, Object obj, long j3);

    Object redirect(short s16, Object obj, Object obj2);

    Object redirect(short s16, Object obj, Object obj2, int i3);

    Object redirect(short s16, Object obj, Object obj2, Object obj3);

    Object redirect(short s16, Object obj, Object obj2, Object obj3, Object obj4);

    Object redirect(short s16, Object obj, boolean z16);

    Object redirect(short s16, Object... objArr);
}
