package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char c16) {
        super(Character.valueOf(c16));
    }

    private final String getPrintablePart(char c16) {
        if (c16 == '\b') {
            return "\\b";
        }
        if (c16 == '\t') {
            return "\\t";
        }
        if (c16 == '\n') {
            return RedTouch.NEWLINE_CHAR;
        }
        if (c16 == '\f') {
            return "\\f";
        }
        if (c16 == '\r') {
            return "\\r";
        }
        if (isPrintableUnicode(c16)) {
            return String.valueOf(c16);
        }
        return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
    }

    private final boolean isPrintableUnicode(char c16) {
        byte type = (byte) Character.getType(c16);
        if (type != 0 && type != 13 && type != 14 && type != 15 && type != 16 && type != 18 && type != 19) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(getValue().charValue()), getPrintablePart(getValue().charValue())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public SimpleType getType(@NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        SimpleType charType = module.getBuiltIns().getCharType();
        Intrinsics.checkNotNullExpressionValue(charType, "module.builtIns.charType");
        return charType;
    }
}
