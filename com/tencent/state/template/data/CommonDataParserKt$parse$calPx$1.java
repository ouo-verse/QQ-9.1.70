package com.tencent.state.template.data;

import android.app.Application;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Lkotlin/ParameterName;", "name", "pxValue", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final /* synthetic */ class CommonDataParserKt$parse$calPx$1 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
        return Integer.valueOf(invoke(num.intValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommonDataParserKt$parse$calPx$1(Application application) {
        super(1, application, ViewExtensionsKt.class, "calPx", "calPx(Landroid/content/Context;I)I", 1);
    }

    public final int invoke(int i3) {
        return ViewExtensionsKt.calPx((Application) this.receiver, i3);
    }
}
