package kotlin;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010\u0007\u001a\u001f\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\b\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"UIntArray", "Lkotlin/UIntArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/UInt;", "(ILkotlin/jvm/functions/Function1;)[I", "uintArrayOf", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "uintArrayOf--ajY-9A", "([I)[I", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class UIntArrayKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] UIntArray(int i3, Function1<? super Integer, UInt> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        int[] iArr = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            iArr[i16] = init.invoke(Integer.valueOf(i16)).getData();
        }
        return UIntArray.m624constructorimpl(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: uintArrayOf--ajY-9A, reason: not valid java name */
    private static final int[] m640uintArrayOfajY9A(int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements;
    }
}
