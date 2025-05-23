package com.tencent.state.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/utils/FlagsHelper;", "", "keys", "", "", "onFlagsChange", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "flagMap", "", "", "getOnFlagsChange", "()Lkotlin/jvm/functions/Function1;", "isFlagsTrue", "update", "key", "value", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FlagsHelper {
    private final Map<String, Boolean> flagMap;
    private final Function1<FlagsHelper, Unit> onFlagsChange;

    /* JADX WARN: Multi-variable type inference failed */
    public FlagsHelper(List<String> keys, Function1<? super FlagsHelper, Unit> onFlagsChange) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(onFlagsChange, "onFlagsChange");
        this.onFlagsChange = onFlagsChange;
        this.flagMap = new LinkedHashMap();
        Iterator<T> it = keys.iterator();
        while (it.hasNext()) {
            this.flagMap.put((String) it.next(), Boolean.FALSE);
        }
    }

    public final Function1<FlagsHelper, Unit> getOnFlagsChange() {
        return this.onFlagsChange;
    }

    public final synchronized boolean isFlagsTrue(List<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator<T> it = keys.iterator();
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(this.flagMap.get((String) it.next()), Boolean.TRUE)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void update(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.flagMap.put(key, Boolean.valueOf(value));
        this.onFlagsChange.invoke(this);
    }
}
