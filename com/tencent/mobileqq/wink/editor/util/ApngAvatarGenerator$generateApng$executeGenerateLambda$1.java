package com.tencent.mobileqq.wink.editor.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class ApngAvatarGenerator$generateApng$executeGenerateLambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ApngAvatarGenerator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApngAvatarGenerator$generateApng$executeGenerateLambda$1(ApngAvatarGenerator apngAvatarGenerator) {
        super(0);
        this.this$0 = apngAvatarGenerator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ApngAvatarGenerator this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.k();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final ApngAvatarGenerator apngAvatarGenerator = this.this$0;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.util.b
            @Override // java.lang.Runnable
            public final void run() {
                ApngAvatarGenerator$generateApng$executeGenerateLambda$1.b(ApngAvatarGenerator.this);
            }
        }, 64, null, false);
    }
}
