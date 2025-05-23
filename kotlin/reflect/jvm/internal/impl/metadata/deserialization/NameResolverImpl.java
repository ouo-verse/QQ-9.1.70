package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class NameResolverImpl implements NameResolver {

    @NotNull
    private final ProtoBuf.QualifiedNameTable qualifiedNames;

    @NotNull
    private final ProtoBuf.StringTable strings;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NameResolverImpl(@NotNull ProtoBuf.StringTable strings, @NotNull ProtoBuf.QualifiedNameTable qualifiedNames) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(qualifiedNames, "qualifiedNames");
        this.strings = strings;
        this.qualifiedNames = qualifiedNames;
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int i3) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z16 = false;
        while (i3 != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.qualifiedNames.getQualifiedName(i3);
            String string = this.strings.getString(qualifiedName.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            Intrinsics.checkNotNull(kind);
            int i16 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        linkedList2.addFirst(string);
                        z16 = true;
                    }
                } else {
                    linkedList.addFirst(string);
                }
            } else {
                linkedList2.addFirst(string);
            }
            i3 = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z16));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getQualifiedClassName(int i3) {
        String joinToString$default;
        String joinToString$default2;
        Triple<List<String>, List<String>, Boolean> traverseIds = traverseIds(i3);
        List<String> component1 = traverseIds.component1();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(traverseIds.component2(), ".", null, null, 0, null, null, 62, null);
        if (!component1.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(component1, "/", null, null, 0, null, null, 62, null);
            sb5.append(joinToString$default2);
            sb5.append('/');
            sb5.append(joinToString$default);
            return sb5.toString();
        }
        return joinToString$default;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getString(int i3) {
        String string = this.strings.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "strings.getString(index)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i3) {
        return traverseIds(i3).getThird().booleanValue();
    }
}
