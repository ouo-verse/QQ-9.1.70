package com.tencent.mobileqq.aio.msglist.holder.base.util;

import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.RMRichMediaInvalidState;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u001a\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0000\u001a$\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u00030\u000b*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0000\"\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"!\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "", "isMixMsg", "Lkotlin/Pair;", "", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "picSize", "d", "g", "isImportMsg", "", "", "a", "f", h.F, "e", "(Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;)Z", "isDynamic", "b", "(Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;)Lkotlin/Pair;", "thumbImageSize", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    @NotNull
    public static final List<Pair<PicSize, String>> a(@NotNull PicElement picElement, boolean z16) {
        Integer[] numArr;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        ArrayList arrayList = new ArrayList();
        if (MsgExtKt.u(picElement)) {
            if (z16) {
                numArr = new Integer[]{0, 198, 720};
            } else {
                numArr = new Integer[]{0, 198};
            }
        } else {
            numArr = new Integer[]{0, 198, 720, 0};
        }
        for (Integer num : numArr) {
            int intValue = num.intValue();
            String b16 = aj.b(picElement, intValue);
            if (c81.a.g(b16)) {
                PicSize i3 = AIOPicDownloader.f190570a.i(picElement, 2, intValue);
                Intrinsics.checkNotNull(b16);
                arrayList.add(new Pair(i3, b16));
            }
        }
        String a16 = aj.a(picElement);
        if (c81.a.g(a16)) {
            PicSize picSize = PicSize.PIC_DOWNLOAD_ORI;
            Intrinsics.checkNotNull(a16);
            arrayList.add(new Pair(picSize, a16));
        }
        return arrayList;
    }

    @NotNull
    public static final Pair<Integer, Integer> b(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        return PicUtil.f191410a.m(picElement.picWidth, picElement.picHeight, e(picElement), MsgExtKt.u(picElement));
    }

    @NotNull
    public static final Pair<Integer, Integer> c(@NotNull PicElement picElement, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        PicUtil picUtil = PicUtil.f191410a;
        int i3 = picElement.picWidth;
        int i16 = picElement.picHeight;
        boolean e16 = e(picElement);
        if (!z16 && !MsgExtKt.u(picElement)) {
            z17 = false;
        } else {
            z17 = true;
        }
        return picUtil.p(i3, i16, e16, z17);
    }

    public static final boolean d(@NotNull PicElement picElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        if (g(picElement) && (picSize == PicSize.PIC_DOWNLOAD_THUMB || picSize == PicSize.PIC_LOCAL_HD_THUMB)) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull PicElement picElement) {
        Integer num;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Integer picType = picElement.picType;
        Intrinsics.checkNotNullExpressionValue(picType, "picType");
        if (picType.intValue() < 2000 && ((num = picElement.picType) == null || num.intValue() != 2)) {
            return false;
        }
        return true;
    }

    public static final boolean f(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Integer num = picElement.invalidState;
        if (num == null || num.intValue() != 0) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull PicElement picElement) {
        int i3;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        int i16 = picElement.picHeight;
        if (i16 != 0 && (i3 = picElement.picWidth) != 0 && (i16 / i3 > 3.0f || i3 / i16 > 3.0f)) {
            return true;
        }
        return false;
    }

    public static final boolean h(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        int ordinal = RMRichMediaInvalidState.KFILESECURITYSTRIKE.ordinal();
        Integer num = picElement.invalidState;
        if (num != null && ordinal == num.intValue()) {
            return true;
        }
        return false;
    }
}
