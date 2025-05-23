package com.tencent.beacon.event;

import android.support.annotation.NonNull;
import com.tencent.beacon.event.open.EventResult;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface h {
    EventResult a(String str, @NonNull EventBean eventBean);

    void a();

    void a(boolean z16);

    boolean a(Runnable runnable);

    EventResult b(String str, @NonNull EventBean eventBean);

    void b();

    void c();
}
