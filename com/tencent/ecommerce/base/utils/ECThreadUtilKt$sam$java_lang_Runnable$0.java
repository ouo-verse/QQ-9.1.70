package com.tencent.ecommerce.base.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes5.dex */
final class ECThreadUtilKt$sam$java_lang_Runnable$0 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Function0 f101282d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECThreadUtilKt$sam$java_lang_Runnable$0(Function0 function0) {
        this.f101282d = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        this.f101282d.invoke();
    }
}
