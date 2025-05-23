package kotlin.reflect.jvm.internal.impl.util;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class OperatorNameConventions {

    @JvmField
    @NotNull
    public static final Name AND;

    @JvmField
    @NotNull
    public static final Set<Name> ASSIGNMENT_OPERATIONS;

    @JvmField
    @NotNull
    public static final Set<Name> BINARY_OPERATION_NAMES;

    @JvmField
    @NotNull
    public static final Name COMPARE_TO;

    @JvmField
    @NotNull
    public static final Regex COMPONENT_REGEX;

    @JvmField
    @NotNull
    public static final Name CONTAINS;

    @JvmField
    @NotNull
    public static final Name DEC;

    @JvmField
    @NotNull
    public static final Set<Name> DELEGATED_PROPERTY_OPERATORS;

    @JvmField
    @NotNull
    public static final Name DIV;

    @JvmField
    @NotNull
    public static final Name DIV_ASSIGN;

    @JvmField
    @NotNull
    public static final Name EQUALS;

    @JvmField
    @NotNull
    public static final Name GET;

    @JvmField
    @NotNull
    public static final Name GET_VALUE;

    @JvmField
    @NotNull
    public static final Name HASH_CODE;

    @JvmField
    @NotNull
    public static final Name HAS_NEXT;

    @JvmField
    @NotNull
    public static final Name INC;

    @NotNull
    public static final OperatorNameConventions INSTANCE = new OperatorNameConventions();

    @JvmField
    @NotNull
    public static final Name INV;

    @JvmField
    @NotNull
    public static final Name INVOKE;

    @JvmField
    @NotNull
    public static final Name ITERATOR;

    @JvmField
    @NotNull
    public static final Name MINUS;

    @JvmField
    @NotNull
    public static final Name MINUS_ASSIGN;

    @JvmField
    @NotNull
    public static final Name MOD;

    @JvmField
    @NotNull
    public static final Name MOD_ASSIGN;

    @JvmField
    @NotNull
    public static final Name NEXT;

    @JvmField
    @NotNull
    public static final Name NOT;

    @JvmField
    @NotNull
    public static final Name OR;

    @JvmField
    @NotNull
    public static final Name PLUS;

    @JvmField
    @NotNull
    public static final Name PLUS_ASSIGN;

    @JvmField
    @NotNull
    public static final Name PROVIDE_DELEGATE;

    @JvmField
    @NotNull
    public static final Name RANGE_TO;

    @JvmField
    @NotNull
    public static final Name RANGE_UNTIL;

    @JvmField
    @NotNull
    public static final Name REM;

    @JvmField
    @NotNull
    public static final Name REM_ASSIGN;

    @JvmField
    @NotNull
    public static final Name SET;

    @JvmField
    @NotNull
    public static final Name SET_VALUE;

    @JvmField
    @NotNull
    public static final Name SHL;

    @JvmField
    @NotNull
    public static final Name SHR;

    @JvmField
    @NotNull
    public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES;

    @JvmField
    @NotNull
    public static final Name TIMES;

    @JvmField
    @NotNull
    public static final Name TIMES_ASSIGN;

    @JvmField
    @NotNull
    public static final Name TO_STRING;

    @JvmField
    @NotNull
    public static final Name UNARY_MINUS;

    @JvmField
    @NotNull
    public static final Set<Name> UNARY_OPERATION_NAMES;

    @JvmField
    @NotNull
    public static final Name UNARY_PLUS;

    @JvmField
    @NotNull
    public static final Name USHR;

    @JvmField
    @NotNull
    public static final Name XOR;

    static {
        Set<Name> of5;
        Set<Name> of6;
        Set<Name> of7;
        Set<Name> of8;
        Set<Name> of9;
        Name identifier = Name.identifier(HippyTextInputController.COMMAND_getValue);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"getValue\")");
        GET_VALUE = identifier;
        Name identifier2 = Name.identifier(HippyTextInputController.COMMAND_setValue);
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"setValue\")");
        SET_VALUE = identifier2;
        Name identifier3 = Name.identifier("provideDelegate");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"provideDelegate\")");
        PROVIDE_DELEGATE = identifier3;
        Name identifier4 = Name.identifier("equals");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"equals\")");
        EQUALS = identifier4;
        Name identifier5 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"hashCode\")");
        HASH_CODE = identifier5;
        Name identifier6 = Name.identifier("compareTo");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(\"compareTo\")");
        COMPARE_TO = identifier6;
        Name identifier7 = Name.identifier("contains");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(\"contains\")");
        CONTAINS = identifier7;
        Name identifier8 = Name.identifier("invoke");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(\"invoke\")");
        INVOKE = identifier8;
        Name identifier9 = Name.identifier("iterator");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(\"iterator\")");
        ITERATOR = identifier9;
        Name identifier10 = Name.identifier("get");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(\"get\")");
        GET = identifier10;
        Name identifier11 = Name.identifier("set");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(\"set\")");
        SET = identifier11;
        Name identifier12 = Name.identifier("next");
        Intrinsics.checkNotNullExpressionValue(identifier12, "identifier(\"next\")");
        NEXT = identifier12;
        Name identifier13 = Name.identifier("hasNext");
        Intrinsics.checkNotNullExpressionValue(identifier13, "identifier(\"hasNext\")");
        HAS_NEXT = identifier13;
        Name identifier14 = Name.identifier("toString");
        Intrinsics.checkNotNullExpressionValue(identifier14, "identifier(\"toString\")");
        TO_STRING = identifier14;
        COMPONENT_REGEX = new Regex("component\\d+");
        Name identifier15 = Name.identifier("and");
        Intrinsics.checkNotNullExpressionValue(identifier15, "identifier(\"and\")");
        AND = identifier15;
        Name identifier16 = Name.identifier("or");
        Intrinsics.checkNotNullExpressionValue(identifier16, "identifier(\"or\")");
        OR = identifier16;
        Name identifier17 = Name.identifier("xor");
        Intrinsics.checkNotNullExpressionValue(identifier17, "identifier(\"xor\")");
        XOR = identifier17;
        Name identifier18 = Name.identifier("inv");
        Intrinsics.checkNotNullExpressionValue(identifier18, "identifier(\"inv\")");
        INV = identifier18;
        Name identifier19 = Name.identifier("shl");
        Intrinsics.checkNotNullExpressionValue(identifier19, "identifier(\"shl\")");
        SHL = identifier19;
        Name identifier20 = Name.identifier("shr");
        Intrinsics.checkNotNullExpressionValue(identifier20, "identifier(\"shr\")");
        SHR = identifier20;
        Name identifier21 = Name.identifier("ushr");
        Intrinsics.checkNotNullExpressionValue(identifier21, "identifier(\"ushr\")");
        USHR = identifier21;
        Name identifier22 = Name.identifier("inc");
        Intrinsics.checkNotNullExpressionValue(identifier22, "identifier(\"inc\")");
        INC = identifier22;
        Name identifier23 = Name.identifier("dec");
        Intrinsics.checkNotNullExpressionValue(identifier23, "identifier(\"dec\")");
        DEC = identifier23;
        Name identifier24 = Name.identifier(QCircleDaTongConstant.ElementParamValue.PLUS);
        Intrinsics.checkNotNullExpressionValue(identifier24, "identifier(\"plus\")");
        PLUS = identifier24;
        Name identifier25 = Name.identifier("minus");
        Intrinsics.checkNotNullExpressionValue(identifier25, "identifier(\"minus\")");
        MINUS = identifier25;
        Name identifier26 = Name.identifier("not");
        Intrinsics.checkNotNullExpressionValue(identifier26, "identifier(\"not\")");
        NOT = identifier26;
        Name identifier27 = Name.identifier("unaryMinus");
        Intrinsics.checkNotNullExpressionValue(identifier27, "identifier(\"unaryMinus\")");
        UNARY_MINUS = identifier27;
        Name identifier28 = Name.identifier("unaryPlus");
        Intrinsics.checkNotNullExpressionValue(identifier28, "identifier(\"unaryPlus\")");
        UNARY_PLUS = identifier28;
        Name identifier29 = Name.identifier(Element.ELEMENT_NAME_TIMES);
        Intrinsics.checkNotNullExpressionValue(identifier29, "identifier(\"times\")");
        TIMES = identifier29;
        Name identifier30 = Name.identifier("div");
        Intrinsics.checkNotNullExpressionValue(identifier30, "identifier(\"div\")");
        DIV = identifier30;
        Name identifier31 = Name.identifier("mod");
        Intrinsics.checkNotNullExpressionValue(identifier31, "identifier(\"mod\")");
        MOD = identifier31;
        Name identifier32 = Name.identifier("rem");
        Intrinsics.checkNotNullExpressionValue(identifier32, "identifier(\"rem\")");
        REM = identifier32;
        Name identifier33 = Name.identifier("rangeTo");
        Intrinsics.checkNotNullExpressionValue(identifier33, "identifier(\"rangeTo\")");
        RANGE_TO = identifier33;
        Name identifier34 = Name.identifier("rangeUntil");
        Intrinsics.checkNotNullExpressionValue(identifier34, "identifier(\"rangeUntil\")");
        RANGE_UNTIL = identifier34;
        Name identifier35 = Name.identifier("timesAssign");
        Intrinsics.checkNotNullExpressionValue(identifier35, "identifier(\"timesAssign\")");
        TIMES_ASSIGN = identifier35;
        Name identifier36 = Name.identifier("divAssign");
        Intrinsics.checkNotNullExpressionValue(identifier36, "identifier(\"divAssign\")");
        DIV_ASSIGN = identifier36;
        Name identifier37 = Name.identifier("modAssign");
        Intrinsics.checkNotNullExpressionValue(identifier37, "identifier(\"modAssign\")");
        MOD_ASSIGN = identifier37;
        Name identifier38 = Name.identifier("remAssign");
        Intrinsics.checkNotNullExpressionValue(identifier38, "identifier(\"remAssign\")");
        REM_ASSIGN = identifier38;
        Name identifier39 = Name.identifier("plusAssign");
        Intrinsics.checkNotNullExpressionValue(identifier39, "identifier(\"plusAssign\")");
        PLUS_ASSIGN = identifier39;
        Name identifier40 = Name.identifier("minusAssign");
        Intrinsics.checkNotNullExpressionValue(identifier40, "identifier(\"minusAssign\")");
        MINUS_ASSIGN = identifier40;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Name[]{identifier22, identifier23, identifier28, identifier27, identifier26, identifier18});
        UNARY_OPERATION_NAMES = of5;
        of6 = SetsKt__SetsKt.setOf((Object[]) new Name[]{identifier28, identifier27, identifier26, identifier18});
        SIMPLE_UNARY_OPERATION_NAMES = of6;
        of7 = SetsKt__SetsKt.setOf((Object[]) new Name[]{identifier29, identifier24, identifier25, identifier30, identifier31, identifier32, identifier33, identifier34});
        BINARY_OPERATION_NAMES = of7;
        of8 = SetsKt__SetsKt.setOf((Object[]) new Name[]{identifier35, identifier36, identifier37, identifier38, identifier39, identifier40});
        ASSIGNMENT_OPERATIONS = of8;
        of9 = SetsKt__SetsKt.setOf((Object[]) new Name[]{identifier, identifier2, identifier3});
        DELEGATED_PROPERTY_OPERATORS = of9;
    }

    OperatorNameConventions() {
    }
}
