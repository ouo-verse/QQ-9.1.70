package com.tencent.kuikly.core.kmp;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\u0010'\n\u0002\b\u0002\u001a.\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u00a8\u0006\u0005"}, d2 = {"K", "V", "", "", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0010'\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0003\u001a\u00028\u00012\u0006\u0010\u0002\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00028\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\n"}, d2 = {"com/tencent/kuikly/core/kmp/h$a", "", "newValue", HippyTextInputController.COMMAND_setValue, "(Ljava/lang/Object;)Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "key", HippyTextInputController.COMMAND_getValue, "value", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map.Entry<K, V> f117271d;

        /* JADX WARN: Multi-variable type inference failed */
        a(Map.Entry<? extends K, ? extends V> entry) {
            this.f117271d = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f117271d.getKey();
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f117271d.getValue();
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            throw new UnsupportedOperationException("This entry is immutable");
        }
    }

    public static final <K, V> Map.Entry<K, V> a(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return new a(entry);
    }
}
