package com.tencent.ecommerce.biz.detail;

import com.tencent.pts.utils.PTSDeviceUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\"\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "VALUE_RECOMMEND_LIST_ITEM_WIDTH_RPX", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailConstantsKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Function0<Integer> f102015a = new Function0<Integer>() { // from class: com.tencent.ecommerce.biz.detail.ECDetailConstantsKt$VALUE_RECOMMEND_LIST_ITEM_WIDTH_RPX$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return (int) ((((((PTSDeviceUtil.getScreenWidthDp() - 32.0f) - 11.0f) / 2) / PTSDeviceUtil.getScreenWidthDp()) * 750.0f) + 0.5f);
        }
    };

    public static final Function0<Integer> a() {
        return f102015a;
    }
}
