package com.tencent.ecommerce.base.ktx;

import androidx.lifecycle.MutableLiveData;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/ktx/f;", "", "Landroidx/lifecycle/MutableLiveData;", "liveData", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f100751a = new f();

    f() {
    }

    public final void a(MutableLiveData<?> liveData) {
        Object value;
        try {
            Field declaredField = liveData.getClass().getSuperclass().getDeclaredField("mVersion");
            declaredField.setAccessible(true);
            Integer num = (Integer) declaredField.get(liveData);
            Field declaredField2 = liveData.getClass().getSuperclass().getDeclaredField("mObservers");
            declaredField2.setAccessible(true);
            Iterable<Map.Entry> iterable = (Iterable) declaredField2.get(liveData);
            if (iterable == null || (r6 = iterable.iterator()) == null) {
                return;
            }
            for (Map.Entry entry : iterable) {
                if (entry != null && (value = entry.getValue()) != null) {
                    Field declaredField3 = value.getClass().getSuperclass().getDeclaredField("mLastVersion");
                    declaredField3.setAccessible(true);
                    declaredField3.set(value, num);
                }
            }
        } catch (Exception e16) {
            cg0.a.b("LiveDataStickinessFix", "[fixStickiness] e = " + e16);
        }
    }
}
