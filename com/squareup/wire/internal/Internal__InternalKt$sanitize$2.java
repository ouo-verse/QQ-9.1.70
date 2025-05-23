package com.squareup.wire.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", "invoke"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* synthetic */ class Internal__InternalKt$sanitize$2 extends FunctionReference implements Function1<String, String> {
    public static final Internal__InternalKt$sanitize$2 INSTANCE = new Internal__InternalKt$sanitize$2();

    Internal__InternalKt$sanitize$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "sanitize";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(Internal.class, "wire-runtime");
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "sanitize(Ljava/lang/String;)Ljava/lang/String;";
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final String invoke(@NotNull String p16) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        return Internal.sanitize(p16);
    }
}
