package org.jf.dexlib2.rewriter;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.DexFile;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RewriterModule {
    @Nonnull
    public Rewriter<AnnotationElement> getAnnotationElementRewriter(@Nonnull Rewriters rewriters) {
        return new AnnotationElementRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<Annotation> getAnnotationRewriter(@Nonnull Rewriters rewriters) {
        return new AnnotationRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<ClassDef> getClassDefRewriter(@Nonnull Rewriters rewriters) {
        return new ClassDefRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<DebugItem> getDebugItemRewriter(@Nonnull Rewriters rewriters) {
        return new DebugItemRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<DexFile> getDexFileRewriter(@Nonnull Rewriters rewriters) {
        return new DexFileRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<EncodedValue> getEncodedValueRewriter(@Nonnull Rewriters rewriters) {
        return new EncodedValueRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<ExceptionHandler> getExceptionHandlerRewriter(@Nonnull Rewriters rewriters) {
        return new ExceptionHandlerRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<FieldReference> getFieldReferenceRewriter(@Nonnull Rewriters rewriters) {
        return new FieldReferenceRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<Field> getFieldRewriter(@Nonnull Rewriters rewriters) {
        return new FieldRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<Instruction> getInstructionRewriter(@Nonnull Rewriters rewriters) {
        return new InstructionRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<MethodImplementation> getMethodImplementationRewriter(@Nonnull Rewriters rewriters) {
        return new MethodImplementationRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<MethodParameter> getMethodParameterRewriter(@Nonnull Rewriters rewriters) {
        return new MethodParameterRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<MethodReference> getMethodReferenceRewriter(@Nonnull Rewriters rewriters) {
        return new MethodReferenceRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<Method> getMethodRewriter(@Nonnull Rewriters rewriters) {
        return new MethodRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<TryBlock<? extends ExceptionHandler>> getTryBlockRewriter(@Nonnull Rewriters rewriters) {
        return new TryBlockRewriter(rewriters);
    }

    @Nonnull
    public Rewriter<String> getTypeRewriter(@Nonnull Rewriters rewriters) {
        return new TypeRewriter();
    }
}
