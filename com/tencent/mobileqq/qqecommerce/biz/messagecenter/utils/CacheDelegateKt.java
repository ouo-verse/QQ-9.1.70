package com.tencent.mobileqq.qqecommerce.biz.messagecenter.utils;

import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\"\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "ACCOUNT_SCOPE", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CacheDelegateKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Function0<Long> f263363a = new Function0<Long>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.utils.CacheDelegateKt$ACCOUNT_SCOPE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return Long.valueOf(ECRuntimeManager.f262445b.e());
        }
    };

    public static final Function0<Long> a() {
        return f263363a;
    }
}
