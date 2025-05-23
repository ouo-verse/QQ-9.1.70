package com.tencent.ecommerce.biz.hr.adapter;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.res.api.IECResourceApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/adapter/b;", "Ld01/e;", "", "colorStr", "", "a", "(Ljava/lang/String;)Ljava/lang/Integer;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b implements d01.e {

    /* renamed from: a, reason: collision with root package name */
    public static final b f102523a = new b();

    b() {
    }

    @Override // d01.e
    public Integer a(String colorStr) {
        boolean startsWith$default;
        boolean contains$default;
        boolean contains$default2;
        int indexOf$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(colorStr, "qui_color://", false, 2, null);
        if (!startsWith$default) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) colorStr, (CharSequence) "_color_unique_id_", false, 2, (Object) null);
            if (contains$default) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) colorStr, "_color_unique_id_", 0, false, 6, (Object) null);
                ECSkin eCSkin = ECSkin.INSTANCE;
                if (colorStr != null) {
                    String substring = colorStr.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    return eCSkin.getColor(substring);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) colorStr, (CharSequence) "qecommerce", false, 2, (Object) null);
            if (!contains$default2) {
                return null;
            }
            cg0.a.b("ECHRColorParserAdapter", "#toColor: colorStr=" + colorStr);
            return ECSkin.INSTANCE.getColor(colorStr);
        }
        IECResourceApi resourceApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getResourceApi();
        if (resourceApi != null) {
            return Integer.valueOf(resourceApi.getColor(colorStr));
        }
        return null;
    }
}
