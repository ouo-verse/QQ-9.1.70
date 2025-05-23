package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory {

    @NotNull
    public static final RuntimeSourceElementFactory INSTANCE = new RuntimeSourceElementFactory();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class RuntimeSourceElement implements JavaSourceElement {

        @NotNull
        private final ReflectJavaElement javaElement;

        public RuntimeSourceElement(@NotNull ReflectJavaElement javaElement) {
            Intrinsics.checkNotNullParameter(javaElement, "javaElement");
            this.javaElement = javaElement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        @NotNull
        public SourceFile getContainingFile() {
            SourceFile NO_SOURCE_FILE = SourceFile.NO_SOURCE_FILE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
        @NotNull
        public ReflectJavaElement getJavaElement() {
            return this.javaElement;
        }

        @NotNull
        public String toString() {
            return RuntimeSourceElement.class.getName() + MsgSummary.STR_COLON + getJavaElement();
        }
    }

    RuntimeSourceElementFactory() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    @NotNull
    public JavaSourceElement source(@NotNull JavaElement javaElement) {
        Intrinsics.checkNotNullParameter(javaElement, "javaElement");
        return new RuntimeSourceElement((ReflectJavaElement) javaElement);
    }
}
