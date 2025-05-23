package com.tencent.kuikly.core.render.android.scheduler;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes7.dex */
final class KRSubThreadSchedulerKt$sam$java_lang_Runnable$0 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Function0 f118175d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KRSubThreadSchedulerKt$sam$java_lang_Runnable$0(Function0 function0) {
        this.f118175d = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.f118175d.invoke(), "invoke(...)");
    }
}
