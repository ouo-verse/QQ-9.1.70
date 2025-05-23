package kotlin.reflect.jvm.internal.impl.descriptors;

import com.tencent.raft.codegenmeta.utils.Constants;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum ClassKind {
    CLASS(Constants.Service.CLASS),
    INTERFACE(Constants.Service.INTERFACE),
    ENUM_CLASS("enum class"),
    ENUM_ENTRY(null),
    ANNOTATION_CLASS("annotation class"),
    OBJECT("object");


    @Nullable
    private final String codeRepresentation;

    ClassKind(String str) {
        this.codeRepresentation = str;
    }

    public final boolean isSingleton() {
        if (this != OBJECT && this != ENUM_ENTRY) {
            return false;
        }
        return true;
    }
}
