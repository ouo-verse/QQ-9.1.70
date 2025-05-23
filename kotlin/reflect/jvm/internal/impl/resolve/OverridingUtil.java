package kotlin.reflect.jvm.internal.impl.resolve;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class OverridingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final OverridingUtil DEFAULT;
    private static final KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY;
    private static final List<ExternalOverridabilityCondition> EXTERNAL_CONDITIONS;
    private final Function2<KotlinType, KotlinType, Boolean> customSubtype;
    private final KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$8, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$descriptors$Modality;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result;

        static {
            int[] iArr = new int[Modality.values().length];
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = iArr2;
            try {
                iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = iArr3;
            try {
                iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo SUCCESS = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final String debugMessage;
        private final Result overridable;

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            String format;
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
                str = "@NotNull method %s.%s must not return null";
            } else {
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            }
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
                i16 = 2;
            } else {
                i16 = 3;
            }
            Object[] objArr = new Object[i16];
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    }
                } else {
                    objArr[0] = "success";
                }
                switch (i3) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                        break;
                    case 5:
                        objArr[1] = "getResult";
                        break;
                    case 6:
                        objArr[1] = "getDebugMessage";
                        break;
                    default:
                        objArr[1] = "success";
                        break;
                }
                if (i3 == 1) {
                    if (i3 != 2) {
                        if (i3 == 3 || i3 == 4) {
                            objArr[2] = "<init>";
                        }
                    } else {
                        objArr[2] = "conflict";
                    }
                } else {
                    objArr[2] = "incompatible";
                }
                format = String.format(str, objArr);
                if (i3 != 1 || i3 == 2 || i3 == 3 || i3 == 4) {
                    throw new IllegalArgumentException(format);
                }
                throw new IllegalStateException(format);
            }
            objArr[0] = "debugMessage";
            switch (i3) {
            }
            if (i3 == 1) {
            }
            format = String.format(str, objArr);
            if (i3 != 1) {
            }
            throw new IllegalArgumentException(format);
        }

        public OverrideCompatibilityInfo(@NotNull Result result, @NotNull String str) {
            if (result == null) {
                $$$reportNull$$$0(3);
            }
            if (str == null) {
                $$$reportNull$$$0(4);
            }
            this.overridable = result;
            this.debugMessage = str;
        }

        @NotNull
        public static OverrideCompatibilityInfo conflict(@NotNull String str) {
            if (str == null) {
                $$$reportNull$$$0(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo incompatible(@NotNull String str) {
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = SUCCESS;
            if (overrideCompatibilityInfo == null) {
                $$$reportNull$$$0(0);
            }
            return overrideCompatibilityInfo;
        }

        @NotNull
        public Result getResult() {
            Result result = this.overridable;
            if (result == null) {
                $$$reportNull$$$0(5);
            }
            return result;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:93:0x02b6. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:94:0x02b9. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:95:0x02bc. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02c8 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x005a A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0036 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        Object[] objArr;
        if (i3 != 11 && i3 != 12 && i3 != 16 && i3 != 21 && i3 != 95 && i3 != 98 && i3 != 103 && i3 != 44 && i3 != 45) {
            switch (i3) {
                default:
                    switch (i3) {
                        default:
                            switch (i3) {
                                default:
                                    switch (i3) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                            break;
                    }
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    break;
            }
            if (i3 != 11 && i3 != 12 && i3 != 16 && i3 != 21 && i3 != 95 && i3 != 98 && i3 != 103 && i3 != 44 && i3 != 45) {
                switch (i3) {
                    default:
                        switch (i3) {
                            default:
                                switch (i3) {
                                    default:
                                        switch (i3) {
                                            case 90:
                                            case 91:
                                            case 92:
                                                break;
                                            default:
                                                i16 = 3;
                                                break;
                                        }
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                        i16 = 2;
                                        break;
                                }
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                                break;
                        }
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        break;
                }
                objArr = new Object[i16];
                switch (i3) {
                    case 1:
                    case 7:
                        objArr[0] = "kotlinTypePreparator";
                        break;
                    case 2:
                        objArr[0] = "customSubtype";
                        break;
                    case 3:
                    case 6:
                    default:
                        objArr[0] = "kotlinTypeRefiner";
                        break;
                    case 4:
                        objArr[0] = "equalityAxioms";
                        break;
                    case 5:
                        objArr[0] = "axioms";
                        break;
                    case 8:
                    case 9:
                        objArr[0] = "candidateSet";
                        break;
                    case 10:
                        objArr[0] = "transformFirst";
                        break;
                    case 11:
                    case 12:
                    case 16:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 44:
                    case 45:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 90:
                    case 91:
                    case 92:
                    case 95:
                    case 98:
                    case 103:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                        break;
                    case 13:
                        objArr[0] = "f";
                        break;
                    case 14:
                        objArr[0] = "g";
                        break;
                    case 15:
                    case 17:
                        objArr[0] = "descriptor";
                        break;
                    case 18:
                        objArr[0] = "result";
                        break;
                    case 19:
                    case 22:
                    case 30:
                    case 40:
                        objArr[0] = "superDescriptor";
                        break;
                    case 20:
                    case 23:
                    case 31:
                    case 41:
                        objArr[0] = "subDescriptor";
                        break;
                    case 42:
                        objArr[0] = "firstParameters";
                        break;
                    case 43:
                        objArr[0] = "secondParameters";
                        break;
                    case 46:
                        objArr[0] = "typeInSuper";
                        break;
                    case 47:
                        objArr[0] = "typeInSub";
                        break;
                    case 48:
                    case 51:
                    case 77:
                        objArr[0] = "typeCheckerState";
                        break;
                    case 49:
                        objArr[0] = "superTypeParameter";
                        break;
                    case 50:
                        objArr[0] = "subTypeParameter";
                        break;
                    case 52:
                        objArr[0] = "name";
                        break;
                    case 53:
                        objArr[0] = "membersFromSupertypes";
                        break;
                    case 54:
                        objArr[0] = "membersFromCurrent";
                        break;
                    case 55:
                    case 61:
                    case 64:
                    case 86:
                    case 89:
                    case 96:
                        objArr[0] = "current";
                        break;
                    case 56:
                    case 62:
                    case 66:
                    case 87:
                    case 106:
                        objArr[0] = AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY;
                        break;
                    case 57:
                        objArr[0] = "overriding";
                        break;
                    case 58:
                        objArr[0] = "fromSuper";
                        break;
                    case 59:
                        objArr[0] = "fromCurrent";
                        break;
                    case 60:
                        objArr[0] = "descriptorsFromSuper";
                        break;
                    case 63:
                    case 65:
                        objArr[0] = "notOverridden";
                        break;
                    case 67:
                    case 69:
                    case 73:
                        objArr[0] = "a";
                        break;
                    case 68:
                    case 70:
                    case 75:
                        objArr[0] = "b";
                        break;
                    case 71:
                        objArr[0] = "candidate";
                        break;
                    case 72:
                    case 88:
                    case 93:
                    case 109:
                        objArr[0] = "descriptors";
                        break;
                    case 74:
                        objArr[0] = "aReturnType";
                        break;
                    case 76:
                        objArr[0] = "bReturnType";
                        break;
                    case 78:
                    case 85:
                        objArr[0] = "overridables";
                        break;
                    case 79:
                    case 101:
                        objArr[0] = "descriptorByHandle";
                        break;
                    case 94:
                        objArr[0] = "classModality";
                        break;
                    case 97:
                        objArr[0] = "toFilter";
                        break;
                    case 99:
                    case 104:
                        objArr[0] = "overrider";
                        break;
                    case 100:
                    case 105:
                        objArr[0] = "extractFrom";
                        break;
                    case 102:
                        objArr[0] = "onConflict";
                        break;
                    case 107:
                    case 108:
                        objArr[0] = "memberDescriptor";
                        break;
                }
                if (i3 == 11 && i3 != 12) {
                    if (i3 != 16) {
                        if (i3 != 21) {
                            if (i3 != 95) {
                                if (i3 != 98) {
                                    if (i3 != 103) {
                                        if (i3 != 44 && i3 != 45) {
                                            switch (i3) {
                                                case 24:
                                                case 25:
                                                case 26:
                                                case 27:
                                                case 28:
                                                case 29:
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 32:
                                                        case 33:
                                                        case 34:
                                                        case 35:
                                                        case 36:
                                                        case 37:
                                                        case 38:
                                                        case 39:
                                                            objArr[1] = "isOverridableByWithoutExternalConditions";
                                                            break;
                                                        default:
                                                            switch (i3) {
                                                                case 80:
                                                                case 81:
                                                                case 82:
                                                                case 83:
                                                                case 84:
                                                                    objArr[1] = "selectMostSpecificMember";
                                                                    break;
                                                                default:
                                                                    switch (i3) {
                                                                        case 90:
                                                                        case 91:
                                                                        case 92:
                                                                            objArr[1] = "determineModalityForFakeOverride";
                                                                            break;
                                                                        default:
                                                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                                                            break;
                                                                    }
                                                            }
                                                    }
                                            }
                                        } else {
                                            objArr[1] = "createTypeCheckerState";
                                        }
                                    } else {
                                        objArr[1] = "extractMembersOverridableInBothWays";
                                    }
                                } else {
                                    objArr[1] = "filterVisibleFakeOverrides";
                                }
                            } else {
                                objArr[1] = "getMinimalModality";
                            }
                        }
                        objArr[1] = "isOverridableBy";
                    } else {
                        objArr[1] = "getOverriddenDeclarations";
                    }
                } else {
                    objArr[1] = "filterOverrides";
                }
                switch (i3) {
                    case 1:
                    case 2:
                        objArr[2] = "createWithTypePreparatorAndCustomSubtype";
                        break;
                    case 3:
                    case 4:
                        objArr[2] = OperateCustomButton.OPERATE_CREATE;
                        break;
                    case 5:
                    case 6:
                    case 7:
                        objArr[2] = "<init>";
                        break;
                    case 8:
                        objArr[2] = "filterOutOverridden";
                        break;
                    case 9:
                    case 10:
                        objArr[2] = "filterOverrides";
                        break;
                    case 11:
                    case 12:
                    case 16:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 44:
                    case 45:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 90:
                    case 91:
                    case 92:
                    case 95:
                    case 98:
                    case 103:
                        break;
                    case 13:
                    case 14:
                        objArr[2] = "overrides";
                        break;
                    case 15:
                        objArr[2] = "getOverriddenDeclarations";
                        break;
                    case 17:
                    case 18:
                        objArr[2] = "collectOverriddenDeclarations";
                        break;
                    case 19:
                    case 20:
                    case 22:
                    case 23:
                        objArr[2] = "isOverridableBy";
                        break;
                    case 30:
                    case 31:
                        objArr[2] = "isOverridableByWithoutExternalConditions";
                        break;
                    case 40:
                    case 41:
                        objArr[2] = "getBasicOverridabilityProblem";
                        break;
                    case 42:
                    case 43:
                        objArr[2] = "createTypeCheckerState";
                        break;
                    case 46:
                    case 47:
                    case 48:
                        objArr[2] = "areTypesEquivalent";
                        break;
                    case 49:
                    case 50:
                    case 51:
                        objArr[2] = "areTypeParametersEquivalent";
                        break;
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                        objArr[2] = "generateOverridesInFunctionGroup";
                        break;
                    case 57:
                    case 58:
                        objArr[2] = "isVisibleForOverride";
                        break;
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                        objArr[2] = "extractAndBindOverridesForMember";
                        break;
                    case 63:
                        objArr[2] = "allHasSameContainingDeclaration";
                        break;
                    case 64:
                    case 65:
                    case 66:
                        objArr[2] = "createAndBindFakeOverrides";
                        break;
                    case 67:
                    case 68:
                        objArr[2] = "isMoreSpecific";
                        break;
                    case 69:
                    case 70:
                        objArr[2] = "isVisibilityMoreSpecific";
                        break;
                    case 71:
                    case 72:
                        objArr[2] = "isMoreSpecificThenAllOf";
                        break;
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                        objArr[2] = "isReturnTypeMoreSpecific";
                        break;
                    case 78:
                    case 79:
                        objArr[2] = "selectMostSpecificMember";
                        break;
                    case 85:
                    case 86:
                    case 87:
                        objArr[2] = "createAndBindFakeOverride";
                        break;
                    case 88:
                    case 89:
                        objArr[2] = "determineModalityForFakeOverride";
                        break;
                    case 93:
                    case 94:
                        objArr[2] = "getMinimalModality";
                        break;
                    case 96:
                    case 97:
                        objArr[2] = "filterVisibleFakeOverrides";
                        break;
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 104:
                    case 105:
                    case 106:
                        objArr[2] = "extractMembersOverridableInBothWays";
                        break;
                    case 107:
                        objArr[2] = "resolveUnknownVisibilityForMember";
                        break;
                    case 108:
                        objArr[2] = "computeVisibilityToInherit";
                        break;
                    case 109:
                        objArr[2] = "findMaxVisibility";
                        break;
                    default:
                        objArr[2] = "createWithTypeRefiner";
                        break;
                }
                String format = String.format(str, objArr);
                if (i3 != 11 && i3 != 12 && i3 != 16 && i3 != 21 && i3 != 95 && i3 != 98 && i3 != 103 && i3 != 44 && i3 != 45) {
                    switch (i3) {
                        default:
                            switch (i3) {
                                default:
                                    switch (i3) {
                                        default:
                                            switch (i3) {
                                                case 90:
                                                case 91:
                                                case 92:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                            throw new IllegalStateException(format);
                                    }
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                    break;
                            }
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            break;
                    }
                }
                throw new IllegalStateException(format);
            }
            i16 = 2;
            objArr = new Object[i16];
            switch (i3) {
            }
            if (i3 == 11) {
            }
            objArr[1] = "filterOverrides";
            switch (i3) {
            }
            String format2 = String.format(str, objArr);
            if (i3 != 11) {
                switch (i3) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i3 != 11) {
            switch (i3) {
            }
            objArr = new Object[i16];
            switch (i3) {
            }
            if (i3 == 11) {
            }
            objArr[1] = "filterOverrides";
            switch (i3) {
            }
            String format22 = String.format(str, objArr);
            if (i3 != 11) {
            }
            throw new IllegalStateException(format22);
        }
        i16 = 2;
        objArr = new Object[i16];
        switch (i3) {
        }
        if (i3 == 11) {
        }
        objArr[1] = "filterOverrides";
        switch (i3) {
        }
        String format222 = String.format(str, objArr);
        if (i3 != 11) {
        }
        throw new IllegalStateException(format222);
    }

    static {
        List<ExternalOverridabilityCondition> list;
        list = CollectionsKt___CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
        EXTERNAL_CONDITIONS = list;
        KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality = new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.1
            private static /* synthetic */ void $$$reportNull$$$0(int i3) {
                Object[] objArr = new Object[3];
                if (i3 != 1) {
                    objArr[0] = "a";
                } else {
                    objArr[0] = "b";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
                objArr[2] = "equals";
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
            public boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                }
                if (typeConstructor2 == null) {
                    $$$reportNull$$$0(1);
                }
                return typeConstructor.equals(typeConstructor2);
            }
        };
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = typeConstructorEquality;
        DEFAULT = new OverridingUtil(typeConstructorEquality, KotlinTypeRefiner.Default.INSTANCE, KotlinTypePreparator.Default.INSTANCE, null);
    }

    OverridingUtil(@NotNull KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, @NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull KotlinTypePreparator kotlinTypePreparator, @Nullable Function2<KotlinType, KotlinType, Boolean> function2) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(5);
        }
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(6);
        }
        if (kotlinTypePreparator == null) {
            $$$reportNull$$$0(7);
        }
        this.equalityAxioms = typeConstructorEquality;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.customSubtype = function2;
    }

    private static boolean allHasSameContainingDeclaration(@NotNull Collection<CallableMemberDescriptor> collection) {
        boolean all;
        if (collection == null) {
            $$$reportNull$$$0(63);
        }
        if (collection.size() < 2) {
            return true;
        }
        final DeclarationDescriptor containingDeclaration = collection.iterator().next().getContainingDeclaration();
        all = CollectionsKt___CollectionsKt.all(collection, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.3
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == DeclarationDescriptor.this);
            }
        });
        return all;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean areTypeParametersEquivalent(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeParameterDescriptor typeParameterDescriptor2, @NotNull TypeCheckerState typeCheckerState) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(49);
        }
        if (typeParameterDescriptor2 == null) {
            $$$reportNull$$$0(50);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(51);
        }
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        ArrayList arrayList = new ArrayList(typeParameterDescriptor2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (KotlinType kotlinType : upperBounds) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (areTypesEquivalent(kotlinType, (KotlinType) listIterator.next(), typeCheckerState)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    private static boolean areTypesEquivalent(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2, @NotNull TypeCheckerState typeCheckerState) {
        boolean z16;
        if (kotlinType == null) {
            $$$reportNull$$$0(46);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(47);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(48);
        }
        if (KotlinTypeKt.isError(kotlinType) && KotlinTypeKt.isError(kotlinType2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return AbstractTypeChecker.INSTANCE.equalTypes(typeCheckerState, kotlinType.unwrap(), kotlinType2.unwrap());
    }

    @Nullable
    private static OverrideCompatibilityInfo checkReceiverAndParameterCount(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        boolean z16;
        boolean z17 = true;
        if (callableDescriptor.getExtensionReceiverParameter() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (callableDescriptor2.getExtensionReceiverParameter() != null) {
            z17 = false;
        }
        if (z16 != z17) {
            return OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
        }
        if (callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size()) {
            return OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
        }
        return null;
    }

    private static void collectOverriddenDeclarations(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(17);
        }
        if (set == null) {
            $$$reportNull$$$0(18);
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
            return;
        }
        if (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            Iterator<? extends CallableMemberDescriptor> it = callableMemberDescriptor.getOverriddenDescriptors().iterator();
            while (it.hasNext()) {
                collectOverriddenDeclarations(it.next(), set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    private static List<KotlinType> compiledValueParameters(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        Iterator<ValueParameterDescriptor> it = callableDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    @Nullable
    private static DescriptorVisibility computeVisibilityToInherit(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(108);
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        DescriptorVisibility findMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (findMaxVisibility == null) {
            return null;
        }
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
                if (callableMemberDescriptor2.getModality() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(findMaxVisibility)) {
                    return null;
                }
            }
            return findMaxVisibility;
        }
        return findMaxVisibility.normalize();
    }

    @NotNull
    public static OverridingUtil create(@NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(3);
        }
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(4);
        }
        return new OverridingUtil(typeConstructorEquality, kotlinTypeRefiner, KotlinTypePreparator.Default.INSTANCE, null);
    }

    private static void createAndBindFakeOverride(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor, @NotNull OverridingStrategy overridingStrategy) {
        DescriptorVisibility descriptorVisibility;
        if (collection == null) {
            $$$reportNull$$$0(85);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(86);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(87);
        }
        Collection<CallableMemberDescriptor> filterVisibleFakeOverrides = filterVisibleFakeOverrides(classDescriptor, collection);
        boolean isEmpty = filterVisibleFakeOverrides.isEmpty();
        if (!isEmpty) {
            collection = filterVisibleFakeOverrides;
        }
        Modality determineModalityForFakeOverride = determineModalityForFakeOverride(collection, classDescriptor);
        if (isEmpty) {
            descriptorVisibility = DescriptorVisibilities.INVISIBLE_FAKE;
        } else {
            descriptorVisibility = DescriptorVisibilities.INHERITED;
        }
        CallableMemberDescriptor copy = ((CallableMemberDescriptor) selectMostSpecificMember(collection, new Function1<CallableMemberDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.4
            @Override // kotlin.jvm.functions.Function1
            public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor;
            }
        })).copy(classDescriptor, determineModalityForFakeOverride, descriptorVisibility, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        overridingStrategy.setOverriddenDescriptors(copy, collection);
        overridingStrategy.addFakeOverride(copy);
    }

    private static void createAndBindFakeOverrides(@NotNull ClassDescriptor classDescriptor, @NotNull Collection<CallableMemberDescriptor> collection, @NotNull OverridingStrategy overridingStrategy) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(64);
        }
        if (collection == null) {
            $$$reportNull$$$0(65);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(66);
        }
        if (allHasSameContainingDeclaration(collection)) {
            Iterator<CallableMemberDescriptor> it = collection.iterator();
            while (it.hasNext()) {
                createAndBindFakeOverride(Collections.singleton(it.next()), classDescriptor, overridingStrategy);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                createAndBindFakeOverride(extractMembersOverridableInBothWays(VisibilityUtilKt.findMemberWithMaxVisibility(linkedList), linkedList, overridingStrategy), classDescriptor, overridingStrategy);
            }
        }
    }

    @NotNull
    private TypeCheckerState createTypeCheckerState(@NotNull List<TypeParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$0(42);
        }
        if (list2 == null) {
            $$$reportNull$$$0(43);
        }
        if (list.isEmpty()) {
            TypeCheckerState newTypeCheckerState = new OverridingUtilTypeSystemContext(null, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
            if (newTypeCheckerState == null) {
                $$$reportNull$$$0(44);
            }
            return newTypeCheckerState;
        }
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < list.size(); i3++) {
            hashMap.put(list.get(i3).getTypeConstructor(), list2.get(i3).getTypeConstructor());
        }
        TypeCheckerState newTypeCheckerState2 = new OverridingUtilTypeSystemContext(hashMap, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true);
        if (newTypeCheckerState2 == null) {
            $$$reportNull$$$0(45);
        }
        return newTypeCheckerState2;
    }

    @NotNull
    public static OverridingUtil createWithTypeRefiner(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(0);
        }
        return new OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, kotlinTypeRefiner, KotlinTypePreparator.Default.INSTANCE, null);
    }

    @NotNull
    private static Modality determineModalityForFakeOverride(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor) {
        Modality modality;
        if (collection == null) {
            $$$reportNull$$$0(88);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(89);
        }
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i3 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[callableMemberDescriptor.getModality().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            z18 = true;
                        }
                    } else {
                        z17 = true;
                    }
                } else {
                    throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
                }
            } else {
                Modality modality2 = Modality.FINAL;
                if (modality2 == null) {
                    $$$reportNull$$$0(90);
                }
                return modality2;
            }
        }
        if (classDescriptor.isExpect() && classDescriptor.getModality() != Modality.ABSTRACT && classDescriptor.getModality() != Modality.SEALED) {
            z16 = true;
        }
        if (z17 && !z18) {
            Modality modality3 = Modality.OPEN;
            if (modality3 == null) {
                $$$reportNull$$$0(91);
            }
            return modality3;
        }
        if (!z17 && z18) {
            if (z16) {
                modality = classDescriptor.getModality();
            } else {
                modality = Modality.ABSTRACT;
            }
            if (modality == null) {
                $$$reportNull$$$0(92);
            }
            return modality;
        }
        HashSet hashSet = new HashSet();
        Iterator<CallableMemberDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(getOverriddenDeclarations(it.next()));
        }
        return getMinimalModality(filterOutOverridden(hashSet), z16, classDescriptor.getModality());
    }

    private Collection<CallableMemberDescriptor> extractAndBindOverridesForMember(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor, @NotNull OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(59);
        }
        if (collection == null) {
            $$$reportNull$$$0(60);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(61);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(62);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        SmartSet create = SmartSet.create();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).getResult();
            boolean isVisibleForOverride = isVisibleForOverride(callableMemberDescriptor, callableMemberDescriptor2, false);
            int i3 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[result.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    if (isVisibleForOverride) {
                        overridingStrategy.overrideConflict(callableMemberDescriptor2, callableMemberDescriptor);
                    }
                    arrayList.add(callableMemberDescriptor2);
                }
            } else {
                if (isVisibleForOverride) {
                    create.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        overridingStrategy.setOverriddenDescriptors(callableMemberDescriptor, create);
        return arrayList;
    }

    @NotNull
    public static <H> Collection<H> extractMembersOverridableInBothWays(@NotNull H h16, @NotNull Collection<H> collection, @NotNull Function1<H, CallableDescriptor> function1, @NotNull Function1<H, Unit> function12) {
        if (h16 == null) {
            $$$reportNull$$$0(99);
        }
        if (collection == null) {
            $$$reportNull$$$0(100);
        }
        if (function1 == null) {
            $$$reportNull$$$0(101);
        }
        if (function12 == null) {
            $$$reportNull$$$0(102);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h16);
        CallableDescriptor invoke = function1.invoke(h16);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            CallableDescriptor invoke2 = function1.invoke(next);
            if (h16 == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result bothWaysOverridability = getBothWaysOverridability(invoke, invoke2);
                if (bothWaysOverridability == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (bothWaysOverridability == OverrideCompatibilityInfo.Result.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(@NotNull Set<D> set) {
        boolean z16;
        if (set == null) {
            $$$reportNull$$$0(8);
        }
        if (!set.isEmpty() && DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule(set.iterator().next()))) {
            z16 = true;
        } else {
            z16 = false;
        }
        return filterOverrides(set, z16, null, new Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.2
            /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;>; */
            @Override // kotlin.jvm.functions.Function2
            public Pair invoke(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
                return new Pair(callableDescriptor, callableDescriptor2);
            }
        });
    }

    @NotNull
    public static <D> Set<D> filterOverrides(@NotNull Set<D> set, boolean z16, @Nullable Function0<?> function0, @NotNull Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            $$$reportNull$$$0(9);
        }
        if (function2 == null) {
            $$$reportNull$$$0(10);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair<CallableDescriptor, CallableDescriptor> invoke = function2.invoke(obj, (Object) it.next());
                    CallableDescriptor component1 = invoke.component1();
                    CallableDescriptor component2 = invoke.component2();
                    if (overrides(component1, component2, z16, true)) {
                        it.remove();
                    } else if (overrides(component2, component1, z16, true)) {
                        break;
                    }
                } else {
                    linkedHashSet.add(obj);
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> filterVisibleFakeOverrides(@NotNull final ClassDescriptor classDescriptor, @NotNull Collection<CallableMemberDescriptor> collection) {
        List filter;
        if (classDescriptor == null) {
            $$$reportNull$$$0(96);
        }
        if (collection == null) {
            $$$reportNull$$$0(97);
        }
        filter = CollectionsKt___CollectionsKt.filter(collection, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.5
            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                boolean z16 = false;
                if (!DescriptorVisibilities.isPrivate(callableMemberDescriptor.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(callableMemberDescriptor, ClassDescriptor.this, false)) {
                    z16 = true;
                }
                return Boolean.valueOf(z16);
            }
        });
        if (filter == null) {
            $$$reportNull$$$0(98);
        }
        return filter;
    }

    @Nullable
    public static DescriptorVisibility findMaxVisibility(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        DescriptorVisibility descriptorVisibility;
        if (collection == null) {
            $$$reportNull$$$0(109);
        }
        if (collection.isEmpty()) {
            return DescriptorVisibilities.DEFAULT_VISIBILITY;
        }
        Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
        loop0: while (true) {
            descriptorVisibility = null;
            while (it.hasNext()) {
                DescriptorVisibility visibility = it.next().getVisibility();
                if (descriptorVisibility != null) {
                    Integer compare = DescriptorVisibilities.compare(visibility, descriptorVisibility);
                    if (compare == null) {
                        break;
                    }
                    if (compare.intValue() > 0) {
                    }
                }
                descriptorVisibility = visibility;
            }
        }
        if (descriptorVisibility == null) {
            return null;
        }
        Iterator<? extends CallableMemberDescriptor> it5 = collection.iterator();
        while (it5.hasNext()) {
            Integer compare2 = DescriptorVisibilities.compare(descriptorVisibility, it5.next().getVisibility());
            if (compare2 == null || compare2.intValue() < 0) {
                return null;
            }
        }
        return descriptorVisibility;
    }

    @Nullable
    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
        boolean z16;
        if (callableDescriptor == null) {
            $$$reportNull$$$0(40);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(41);
        }
        boolean z17 = callableDescriptor instanceof FunctionDescriptor;
        if ((z17 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z16 = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
            return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        }
        if (!z17 && !z16) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        }
        if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return OverrideCompatibilityInfo.incompatible("Name mismatch");
        }
        OverrideCompatibilityInfo checkReceiverAndParameterCount = checkReceiverAndParameterCount(callableDescriptor, callableDescriptor2);
        if (checkReceiverAndParameterCount != null) {
            return checkReceiverAndParameterCount;
        }
        return null;
    }

    @Nullable
    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil overridingUtil = DEFAULT;
        OverrideCompatibilityInfo.Result result = overridingUtil.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        OverrideCompatibilityInfo.Result result2 = overridingUtil.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        OverrideCompatibilityInfo.Result result3 = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (result != result3 || result2 != result3) {
            OverrideCompatibilityInfo.Result result4 = OverrideCompatibilityInfo.Result.CONFLICT;
            if (result != result4 && result2 != result4) {
                return OverrideCompatibilityInfo.Result.INCOMPATIBLE;
            }
            return result4;
        }
        return result3;
    }

    @NotNull
    private static Modality getMinimalModality(@NotNull Collection<CallableMemberDescriptor> collection, boolean z16, @NotNull Modality modality) {
        Modality modality2;
        if (collection == null) {
            $$$reportNull$$$0(93);
        }
        if (modality == null) {
            $$$reportNull$$$0(94);
        }
        Modality modality3 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            if (z16 && callableMemberDescriptor.getModality() == Modality.ABSTRACT) {
                modality2 = modality;
            } else {
                modality2 = callableMemberDescriptor.getModality();
            }
            if (modality2.compareTo(modality3) < 0) {
                modality3 = modality2;
            }
        }
        if (modality3 == null) {
            $$$reportNull$$$0(95);
        }
        return modality3;
    }

    @NotNull
    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        collectOverriddenDeclarations(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static boolean isAccessorMoreSpecific(@Nullable PropertyAccessorDescriptor propertyAccessorDescriptor, @Nullable PropertyAccessorDescriptor propertyAccessorDescriptor2) {
        if (propertyAccessorDescriptor != null && propertyAccessorDescriptor2 != null) {
            return isVisibilityMoreSpecific(propertyAccessorDescriptor, propertyAccessorDescriptor2);
        }
        return true;
    }

    public static boolean isMoreSpecific(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(67);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(68);
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        KotlinType returnType2 = callableDescriptor2.getReturnType();
        if (!isVisibilityMoreSpecific(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        TypeCheckerState createTypeCheckerState = DEFAULT.createTypeCheckerState(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
        if (callableDescriptor instanceof FunctionDescriptor) {
            return isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2, createTypeCheckerState);
        }
        if (callableDescriptor instanceof PropertyDescriptor) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
            PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
            if (!isAccessorMoreSpecific(propertyDescriptor.getSetter(), propertyDescriptor2.getSetter())) {
                return false;
            }
            if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
                return AbstractTypeChecker.INSTANCE.equalTypes(createTypeCheckerState, returnType.unwrap(), returnType2.unwrap());
            }
            if ((!propertyDescriptor.isVar() && propertyDescriptor2.isVar()) || !isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2, createTypeCheckerState)) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Unexpected callable: " + callableDescriptor.getClass());
    }

    private static boolean isMoreSpecificThenAllOf(@NotNull CallableDescriptor callableDescriptor, @NotNull Collection<CallableDescriptor> collection) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(71);
        }
        if (collection == null) {
            $$$reportNull$$$0(72);
        }
        Iterator<CallableDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            if (!isMoreSpecific(callableDescriptor, it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(@NotNull CallableDescriptor callableDescriptor, @NotNull KotlinType kotlinType, @NotNull CallableDescriptor callableDescriptor2, @NotNull KotlinType kotlinType2, @NotNull TypeCheckerState typeCheckerState) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(73);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(74);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(75);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(76);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(77);
        }
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(typeCheckerState, kotlinType.unwrap(), kotlinType2.unwrap());
    }

    private static boolean isVisibilityMoreSpecific(@NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(69);
        }
        if (declarationDescriptorWithVisibility2 == null) {
            $$$reportNull$$$0(70);
        }
        Integer compare = DescriptorVisibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        if (compare != null && compare.intValue() < 0) {
            return false;
        }
        return true;
    }

    public static boolean isVisibleForOverride(@NotNull MemberDescriptor memberDescriptor, @NotNull MemberDescriptor memberDescriptor2, boolean z16) {
        if (memberDescriptor == null) {
            $$$reportNull$$$0(57);
        }
        if (memberDescriptor2 == null) {
            $$$reportNull$$$0(58);
        }
        if (!DescriptorVisibilities.isPrivate(memberDescriptor2.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(memberDescriptor2, memberDescriptor, z16)) {
            return true;
        }
        return false;
    }

    public static <D extends CallableDescriptor> boolean overrides(@NotNull D d16, @NotNull D d17, boolean z16, boolean z17) {
        if (d16 == null) {
            $$$reportNull$$$0(13);
        }
        if (d17 == null) {
            $$$reportNull$$$0(14);
        }
        if (!d16.equals(d17) && DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(d16.getOriginal(), d17.getOriginal(), z16, z17)) {
            return true;
        }
        CallableDescriptor original = d17.getOriginal();
        Iterator it = DescriptorUtils.getAllOverriddenDescriptors(d16).iterator();
        while (it.hasNext()) {
            if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(original, (CallableDescriptor) it.next(), z16, z17)) {
                return true;
            }
        }
        return false;
    }

    public static void resolveUnknownVisibilityForMember(@NotNull CallableMemberDescriptor callableMemberDescriptor, @Nullable Function1<CallableMemberDescriptor, Unit> function1) {
        DescriptorVisibility descriptorVisibility;
        Function1<CallableMemberDescriptor, Unit> function12;
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(107);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == DescriptorVisibilities.INHERITED) {
                resolveUnknownVisibilityForMember(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() != DescriptorVisibilities.INHERITED) {
            return;
        }
        DescriptorVisibility computeVisibilityToInherit = computeVisibilityToInherit(callableMemberDescriptor);
        if (computeVisibilityToInherit == null) {
            if (function1 != null) {
                function1.invoke(callableMemberDescriptor);
            }
            descriptorVisibility = DescriptorVisibilities.PUBLIC;
        } else {
            descriptorVisibility = computeVisibilityToInherit;
        }
        if (callableMemberDescriptor instanceof PropertyDescriptorImpl) {
            ((PropertyDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility);
            for (PropertyAccessorDescriptor propertyAccessorDescriptor : ((PropertyDescriptor) callableMemberDescriptor).getAccessors()) {
                if (computeVisibilityToInherit == null) {
                    function12 = null;
                } else {
                    function12 = function1;
                }
                resolveUnknownVisibilityForMember(propertyAccessorDescriptor, function12);
            }
            return;
        }
        if (callableMemberDescriptor instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility);
            return;
        }
        PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl = (PropertyAccessorDescriptorImpl) callableMemberDescriptor;
        propertyAccessorDescriptorImpl.setVisibility(descriptorVisibility);
        if (descriptorVisibility != propertyAccessorDescriptorImpl.getCorrespondingProperty().getVisibility()) {
            propertyAccessorDescriptorImpl.setDefault(false);
        }
    }

    @NotNull
    public static <H> H selectMostSpecificMember(@NotNull Collection<H> collection, @NotNull Function1<H, CallableDescriptor> function1) {
        List map;
        H h16;
        Object first;
        Object first2;
        Object first3;
        Object first4;
        if (collection == null) {
            $$$reportNull$$$0(78);
        }
        if (function1 == null) {
            $$$reportNull$$$0(79);
        }
        if (collection.size() == 1) {
            first4 = CollectionsKt___CollectionsKt.first(collection);
            H h17 = (H) first4;
            if (h17 == null) {
                $$$reportNull$$$0(80);
            }
            return h17;
        }
        ArrayList arrayList = new ArrayList(2);
        map = CollectionsKt___CollectionsKt.map(collection, function1);
        first = CollectionsKt___CollectionsKt.first(collection);
        H h18 = (H) first;
        CallableDescriptor invoke = function1.invoke(h18);
        for (H h19 : collection) {
            CallableDescriptor invoke2 = function1.invoke(h19);
            if (isMoreSpecificThenAllOf(invoke2, map)) {
                arrayList.add(h19);
            }
            if (isMoreSpecific(invoke2, invoke) && !isMoreSpecific(invoke, invoke2)) {
                h18 = h19;
            }
        }
        if (arrayList.isEmpty()) {
            if (h18 == null) {
                $$$reportNull$$$0(81);
            }
            return h18;
        }
        if (arrayList.size() == 1) {
            first3 = CollectionsKt___CollectionsKt.first((Iterable<? extends Object>) arrayList);
            H h26 = (H) first3;
            if (h26 == null) {
                $$$reportNull$$$0(82);
            }
            return h26;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                h16 = (H) it.next();
                if (!FlexibleTypesKt.isFlexible(function1.invoke(h16).getReturnType())) {
                    break;
                }
            } else {
                h16 = null;
                break;
            }
        }
        if (h16 != null) {
            return h16;
        }
        first2 = CollectionsKt___CollectionsKt.first((Iterable<? extends Object>) arrayList);
        H h27 = (H) first2;
        if (h27 == null) {
            $$$reportNull$$$0(84);
        }
        return h27;
    }

    public void generateOverridesInFunctionGroup(@NotNull Name name, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull Collection<? extends CallableMemberDescriptor> collection2, @NotNull ClassDescriptor classDescriptor, @NotNull OverridingStrategy overridingStrategy) {
        if (name == null) {
            $$$reportNull$$$0(52);
        }
        if (collection == null) {
            $$$reportNull$$$0(53);
        }
        if (collection2 == null) {
            $$$reportNull$$$0(54);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(55);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(56);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator<? extends CallableMemberDescriptor> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(extractAndBindOverridesForMember(it.next(), collection, classDescriptor, overridingStrategy));
        }
        createAndBindFakeOverrides(classDescriptor, linkedHashSet, overridingStrategy);
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(19);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(20);
        }
        OverrideCompatibilityInfo isOverridableBy = isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (isOverridableBy == null) {
            $$$reportNull$$$0(21);
        }
        return isOverridableBy;
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, boolean z16) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(30);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(31);
        }
        OverrideCompatibilityInfo basicOverridabilityProblem = getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if (basicOverridabilityProblem != null) {
            return basicOverridabilityProblem;
        }
        List<KotlinType> compiledValueParameters = compiledValueParameters(callableDescriptor);
        List<KotlinType> compiledValueParameters2 = compiledValueParameters(callableDescriptor2);
        List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        int i3 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i3 < compiledValueParameters.size()) {
                if (!KotlinTypeChecker.DEFAULT.equalTypes(compiledValueParameters.get(i3), compiledValueParameters2.get(i3))) {
                    OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
                    if (incompatible == null) {
                        $$$reportNull$$$0(33);
                    }
                    return incompatible;
                }
                i3++;
            }
            OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
            if (conflict == null) {
                $$$reportNull$$$0(34);
            }
            return conflict;
        }
        TypeCheckerState createTypeCheckerState = createTypeCheckerState(typeParameters, typeParameters2);
        for (int i16 = 0; i16 < typeParameters.size(); i16++) {
            if (!areTypeParametersEquivalent(typeParameters.get(i16), typeParameters2.get(i16), createTypeCheckerState)) {
                OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
                if (incompatible2 == null) {
                    $$$reportNull$$$0(35);
                }
                return incompatible2;
            }
        }
        for (int i17 = 0; i17 < compiledValueParameters.size(); i17++) {
            if (!areTypesEquivalent(compiledValueParameters.get(i17), compiledValueParameters2.get(i17), createTypeCheckerState)) {
                OverrideCompatibilityInfo incompatible3 = OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
                if (incompatible3 == null) {
                    $$$reportNull$$$0(36);
                }
                return incompatible3;
            }
        }
        if ((callableDescriptor instanceof FunctionDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && ((FunctionDescriptor) callableDescriptor).isSuspend() != ((FunctionDescriptor) callableDescriptor2).isSuspend()) {
            OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("Incompatible suspendability");
            if (conflict2 == null) {
                $$$reportNull$$$0(37);
            }
            return conflict2;
        }
        if (z16) {
            KotlinType returnType = callableDescriptor.getReturnType();
            KotlinType returnType2 = callableDescriptor2.getReturnType();
            if (returnType != null && returnType2 != null) {
                if (KotlinTypeKt.isError(returnType2) && KotlinTypeKt.isError(returnType)) {
                    i3 = 1;
                }
                if (i3 == 0 && !AbstractTypeChecker.INSTANCE.isSubtypeOf(createTypeCheckerState, returnType2.unwrap(), returnType.unwrap())) {
                    OverrideCompatibilityInfo conflict3 = OverrideCompatibilityInfo.conflict("Return type mismatch");
                    if (conflict3 == null) {
                        $$$reportNull$$$0(38);
                    }
                    return conflict3;
                }
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(39);
        }
        return success;
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor, boolean z16) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(22);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(23);
        }
        OverrideCompatibilityInfo isOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z16);
        boolean z17 = isOverridableByWithoutExternalConditions.getResult() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : EXTERNAL_CONDITIONS) {
            if (externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z17 || externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i3 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i3 == 1) {
                    z17 = true;
                } else {
                    if (i3 == 2) {
                        OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("External condition failed");
                        if (conflict == null) {
                            $$$reportNull$$$0(24);
                        }
                        return conflict;
                    }
                    if (i3 == 3) {
                        OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("External condition");
                        if (incompatible == null) {
                            $$$reportNull$$$0(25);
                        }
                        return incompatible;
                    }
                }
            }
        }
        if (!z17) {
            return isOverridableByWithoutExternalConditions;
        }
        for (ExternalOverridabilityCondition externalOverridabilityCondition2 : EXTERNAL_CONDITIONS) {
            if (externalOverridabilityCondition2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i16 = AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i16 == 1) {
                    throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i16 == 2) {
                    OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("External condition failed");
                    if (conflict2 == null) {
                        $$$reportNull$$$0(27);
                    }
                    return conflict2;
                }
                if (i16 == 3) {
                    OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("External condition");
                    if (incompatible2 == null) {
                        $$$reportNull$$$0(28);
                    }
                    return incompatible2;
                }
            }
        }
        OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
        if (success == null) {
            $$$reportNull$$$0(29);
        }
        return success;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> extractMembersOverridableInBothWays(@NotNull final CallableMemberDescriptor callableMemberDescriptor, @NotNull Queue<CallableMemberDescriptor> queue, @NotNull final OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(104);
        }
        if (queue == null) {
            $$$reportNull$$$0(105);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(106);
        }
        return extractMembersOverridableInBothWays(callableMemberDescriptor, queue, new Function1<CallableMemberDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.6
            @Override // kotlin.jvm.functions.Function1
            public CallableDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                return callableMemberDescriptor2;
            }
        }, new Function1<CallableMemberDescriptor, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.7
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                OverridingStrategy.this.inheritanceConflict(callableMemberDescriptor, callableMemberDescriptor2);
                return Unit.INSTANCE;
            }
        });
    }
}
