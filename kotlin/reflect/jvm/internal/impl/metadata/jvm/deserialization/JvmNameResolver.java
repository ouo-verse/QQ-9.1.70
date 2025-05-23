package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JvmNameResolver extends JvmNameResolverBase {

    @NotNull
    private final JvmProtoBuf.StringTableTypes types;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JvmNameResolver(@NotNull JvmProtoBuf.StringTableTypes types, @NotNull String[] strings) {
        super(strings, r0, JvmNameResolverKt.toExpandedRecordsList(r1));
        Set set;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(strings, "strings");
        List<Integer> _init_$lambda$0 = types.getLocalNameList();
        if (_init_$lambda$0.isEmpty()) {
            set = SetsKt__SetsKt.emptySet();
        } else {
            Intrinsics.checkNotNullExpressionValue(_init_$lambda$0, "_init_$lambda$0");
            set = CollectionsKt___CollectionsKt.toSet(_init_$lambda$0);
        }
        List<JvmProtoBuf.StringTableTypes.Record> recordList = types.getRecordList();
        Intrinsics.checkNotNullExpressionValue(recordList, "types.recordList");
        this.types = types;
    }
}
