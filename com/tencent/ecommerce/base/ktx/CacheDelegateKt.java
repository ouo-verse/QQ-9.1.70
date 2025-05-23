package com.tencent.ecommerce.base.ktx;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "ACCOUNT_SCOPE", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class CacheDelegateKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Function0<String> f100723a = new Function0<String>() { // from class: com.tencent.ecommerce.base.ktx.CacheDelegateKt$ACCOUNT_SCOPE$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().a().getCurrentAccount());
        }
    };

    public static final Function0<String> a() {
        return f100723a;
    }
}
