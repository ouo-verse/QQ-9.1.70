package org.jf.dexlib2.analysis;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import javax.annotation.Nonnull;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.instruction.InlineIndexInstruction;
import org.jf.dexlib2.iface.instruction.VariableRegisterInstruction;
import org.jf.dexlib2.immutable.ImmutableAnnotation;
import org.jf.dexlib2.immutable.ImmutableMethod;
import org.jf.dexlib2.immutable.ImmutableMethodImplementation;
import org.jf.dexlib2.immutable.ImmutableMethodParameter;
import org.jf.dexlib2.immutable.util.ParamUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class InlineMethodResolver {
    public static final int DIRECT = 2;
    public static final int STATIC = 8;
    public static final int VIRTUAL = 1;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class InlineMethodResolver_version35 extends InlineMethodResolver {
        private final Method[] inlineMethods = {InlineMethodResolver.inlineMethod(8, "Lorg/apache/harmony/dalvik/NativeTestTarget;", "emptyInlineMethod", "", "V"), InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "charAt", "I", BdhLogUtil.LogTag.Tag_Conn), InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "compareTo", "Ljava/lang/String;", "I"), InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "equals", "Ljava/lang/Object;", "Z"), InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "length", "", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "abs", "I", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "abs", "J", "J"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "abs", UserInfo.SEX_FEMALE, UserInfo.SEX_FEMALE), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "abs", "D", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", Element.ELEMENT_NAME_MIN, "II", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "max", "II", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "sqrt", "D", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "cos", "D", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "sin", "D", "D")};

        @Override // org.jf.dexlib2.analysis.InlineMethodResolver
        @Nonnull
        public Method resolveExecuteInline(@Nonnull AnalyzedInstruction analyzedInstruction) {
            int inlineIndex = ((InlineIndexInstruction) analyzedInstruction.instruction).getInlineIndex();
            if (inlineIndex >= 0) {
                Method[] methodArr = this.inlineMethods;
                if (inlineIndex < methodArr.length) {
                    return methodArr[inlineIndex];
                }
            }
            throw new RuntimeException("Invalid inline index: " + inlineIndex);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class InlineMethodResolver_version36 extends InlineMethodResolver {
        private final Method indexOfIMethod = InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "indexOf", "I", "I");
        private final Method indexOfIIMethod = InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "indexOf", "II", "I");
        private final Method fastIndexOfMethod = InlineMethodResolver.inlineMethod(2, "Ljava/lang/String;", "fastIndexOf", "II", "I");
        private final Method isEmptyMethod = InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "isEmpty", "", "Z");
        private final Method[] inlineMethods = {InlineMethodResolver.inlineMethod(8, "Lorg/apache/harmony/dalvik/NativeTestTarget;", "emptyInlineMethod", "", "V"), InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "charAt", "I", BdhLogUtil.LogTag.Tag_Conn), InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "compareTo", "Ljava/lang/String;", "I"), InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "equals", "Ljava/lang/Object;", "Z"), null, null, InlineMethodResolver.inlineMethod(1, "Ljava/lang/String;", "length", "", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "abs", "I", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "abs", "J", "J"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "abs", UserInfo.SEX_FEMALE, UserInfo.SEX_FEMALE), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "abs", "D", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", Element.ELEMENT_NAME_MIN, "II", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "max", "II", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "sqrt", "D", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "cos", "D", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Math;", "sin", "D", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Float;", "floatToIntBits", UserInfo.SEX_FEMALE, "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Float;", "floatToRawIntBits", UserInfo.SEX_FEMALE, "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Float;", "intBitsToFloat", "I", UserInfo.SEX_FEMALE), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Double;", "doubleToLongBits", "D", "J"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Double;", "doubleToRawLongBits", "D", "J"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/Double;", "longBitsToDouble", "J", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/StrictMath;", "abs", "I", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/StrictMath;", "abs", "J", "J"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/StrictMath;", "abs", UserInfo.SEX_FEMALE, UserInfo.SEX_FEMALE), InlineMethodResolver.inlineMethod(8, "Ljava/lang/StrictMath;", "abs", "D", "D"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/StrictMath;", Element.ELEMENT_NAME_MIN, "II", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/StrictMath;", "max", "II", "I"), InlineMethodResolver.inlineMethod(8, "Ljava/lang/StrictMath;", "sqrt", "D", "D")};

        @Override // org.jf.dexlib2.analysis.InlineMethodResolver
        @Nonnull
        public Method resolveExecuteInline(@Nonnull AnalyzedInstruction analyzedInstruction) {
            InlineIndexInstruction inlineIndexInstruction = (InlineIndexInstruction) analyzedInstruction.instruction;
            int inlineIndex = inlineIndexInstruction.getInlineIndex();
            if (inlineIndex >= 0) {
                Method[] methodArr = this.inlineMethods;
                if (inlineIndex < methodArr.length) {
                    if (inlineIndex == 4) {
                        int registerCount = ((VariableRegisterInstruction) inlineIndexInstruction).getRegisterCount();
                        if (registerCount == 2) {
                            return this.indexOfIMethod;
                        }
                        if (registerCount == 3) {
                            return this.fastIndexOfMethod;
                        }
                        throw new RuntimeException("Could not determine the correct inline method to use");
                    }
                    if (inlineIndex == 5) {
                        int registerCount2 = ((VariableRegisterInstruction) inlineIndexInstruction).getRegisterCount();
                        if (registerCount2 == 3) {
                            return this.indexOfIIMethod;
                        }
                        if (registerCount2 == 1) {
                            return this.isEmptyMethod;
                        }
                        throw new RuntimeException("Could not determine the correct inline method to use");
                    }
                    return methodArr[inlineIndex];
                }
            }
            throw new RuntimeException("Invalid method index: " + inlineIndex);
        }
    }

    @Nonnull
    public static InlineMethodResolver createInlineMethodResolver(int i3) {
        if (i3 == 35) {
            return new InlineMethodResolver_version35();
        }
        if (i3 == 36) {
            return new InlineMethodResolver_version36();
        }
        throw new RuntimeException(String.format("odex version %d is not supported yet", Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nonnull
    public static Method inlineMethod(int i3, @Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4) {
        return new ImmutableMethod(str, str2, (ImmutableList<? extends ImmutableMethodParameter>) ImmutableList.copyOf(ParamUtil.parseParamString(str3)), str4, i3, (ImmutableSet<? extends ImmutableAnnotation>) null, (ImmutableSet<HiddenApiRestriction>) null, (ImmutableMethodImplementation) null);
    }

    @Nonnull
    public abstract Method resolveExecuteInline(@Nonnull AnalyzedInstruction analyzedInstruction);
}
