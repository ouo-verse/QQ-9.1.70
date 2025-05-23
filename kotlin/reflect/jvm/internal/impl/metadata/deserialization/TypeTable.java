package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TypeTable {

    @NotNull
    private final List<ProtoBuf.Type> types;

    public TypeTable(@NotNull ProtoBuf.TypeTable typeTable) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<ProtoBuf.Type> typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> typeList2 = typeTable.getTypeList();
            Intrinsics.checkNotNullExpressionValue(typeList2, "typeTable.typeList");
            List<ProtoBuf.Type> list = typeList2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ProtoBuf.Type type = (ProtoBuf.Type) obj;
                if (i3 >= firstNullable) {
                    type = type.toBuilder().setNullable(true).build();
                }
                arrayList.add(type);
                i3 = i16;
            }
            typeList = arrayList;
        }
        Intrinsics.checkNotNullExpressionValue(typeList, "run {\n        val origin\u2026 else originalTypes\n    }");
        this.types = typeList;
    }

    @NotNull
    public final ProtoBuf.Type get(int i3) {
        return this.types.get(i3);
    }
}
