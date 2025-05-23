package com.tencent.luggage.wxa.vf;

import android.nfc.Tag;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        SUCCESS,
        FAIL_SYSTEM_INTERNAL_ERROR,
        FAIL_ALREADY_STARTED,
        FAIL_NOT_STARTED
    }

    a a();

    void a(ArrayList arrayList);

    void a(Function3 function3);

    void a(boolean z16);

    a b();

    Set c();

    Tag getTag();
}
