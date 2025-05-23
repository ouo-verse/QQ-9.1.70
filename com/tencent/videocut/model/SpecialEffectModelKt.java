package com.tencent.videocut.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"simpleHashString", "", "Lcom/tencent/videocut/model/SpecialEffectModel;", "getSimpleHashString", "(Lcom/tencent/videocut/model/SpecialEffectModel;)Ljava/lang/String;", "valid", "", "getValid", "(Lcom/tencent/videocut/model/SpecialEffectModel;)Z", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class SpecialEffectModelKt {
    @NotNull
    public static final String getSimpleHashString(@NotNull SpecialEffectModel specialEffectModel) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        Intrinsics.checkNotNullParameter(specialEffectModel, "<this>");
        String str = specialEffectModel.id;
        int i39 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i46 = (i3 + 0) * 37;
        String str2 = specialEffectModel.name;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i47 = (i46 + i16) * 37;
        String str3 = specialEffectModel.filePath;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i48 = (i47 + i17) * 37;
        Float f16 = specialEffectModel.scale;
        if (f16 != null) {
            i18 = f16.hashCode();
        } else {
            i18 = 0;
        }
        int i49 = (i48 + i18) * 37;
        Integer num = specialEffectModel.timeLineIndex;
        if (num != null) {
            i19 = num.hashCode();
        } else {
            i19 = 0;
        }
        int i56 = (i49 + i19) * 37;
        String str4 = specialEffectModel.materialId;
        if (str4 != null) {
            i26 = str4.hashCode();
        } else {
            i26 = 0;
        }
        int i57 = (i56 + i26) * 37;
        Long l3 = specialEffectModel.durationUs;
        if (l3 != null) {
            i27 = l3.hashCode();
        } else {
            i27 = 0;
        }
        int i58 = (i57 + i27) * 37;
        Long l16 = specialEffectModel.startTimeUs;
        if (l16 != null) {
            i28 = l16.hashCode();
        } else {
            i28 = 0;
        }
        int i59 = (i58 + i28) * 37;
        String str5 = specialEffectModel.landscapeFilePath;
        if (str5 != null) {
            i29 = str5.hashCode();
        } else {
            i29 = 0;
        }
        int i65 = (i59 + i29) * 37;
        Integer num2 = specialEffectModel.scaleMode;
        if (num2 != null) {
            i36 = num2.hashCode();
        } else {
            i36 = 0;
        }
        int i66 = (i65 + i36) * 37;
        Float f17 = specialEffectModel.scaleWithCrop;
        if (f17 != null) {
            i37 = f17.hashCode();
        } else {
            i37 = 0;
        }
        int i67 = (i66 + i37) * 37;
        Integer num3 = specialEffectModel.temporary;
        if (num3 != null) {
            i38 = num3.hashCode();
        } else {
            i38 = 0;
        }
        int i68 = (i67 + i38) * 37;
        Integer num4 = specialEffectModel.effectType;
        if (num4 != null) {
            i39 = num4.hashCode();
        }
        return String.valueOf(i68 + i39);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean getValid(@NotNull SpecialEffectModel specialEffectModel) {
        Long l3;
        Long l16;
        boolean z16;
        boolean z17;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(specialEffectModel, "<this>");
        if (specialEffectModel.materialId == null || (l3 = specialEffectModel.startTimeUs) == null || l3.longValue() < 0 || (l16 = specialEffectModel.durationUs) == null || l16.longValue() <= 0) {
            return false;
        }
        String str = specialEffectModel.filePath;
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                String str2 = specialEffectModel.name;
                if (str2 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                    if (!isBlank) {
                        z17 = false;
                        if (!z17) {
                            return false;
                        }
                        return true;
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
