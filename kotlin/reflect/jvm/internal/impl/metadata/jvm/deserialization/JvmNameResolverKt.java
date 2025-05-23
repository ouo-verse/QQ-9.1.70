package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JvmNameResolverKt {
    @NotNull
    public static final List<JvmProtoBuf.StringTableTypes.Record> toExpandedRecordsList(@NotNull List<JvmProtoBuf.StringTableTypes.Record> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list.size());
        for (JvmProtoBuf.StringTableTypes.Record record : list) {
            int range = record.getRange();
            for (int i3 = 0; i3 < range; i3++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
