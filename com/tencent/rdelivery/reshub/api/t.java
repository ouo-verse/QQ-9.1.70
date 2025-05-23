package com.tencent.rdelivery.reshub.api;

import com.tencent.rdelivery.RDeliverySetting;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0005\"\u0017\u0010\u0004\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "a", "I", "()I", "defaultConfigUpdateStrategy", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final int f364396a = RDeliverySetting.UpdateStrategy.START_UP.getValue() | RDeliverySetting.UpdateStrategy.PERIODIC.getValue();

    public static final int a() {
        return f364396a;
    }
}
