package com.tencent.tavcut.rendermodel.parser;

import com.google.gson.stream.JsonReader;
import com.tencent.tavcut.rendermodel.entity.Entity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "p1", "Lcom/google/gson/stream/JsonReader;", "Lkotlin/ParameterName;", "name", "reader", "invoke"}, k = 3, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* synthetic */ class LightJsonReader$readEntity$2 extends FunctionReference implements Function1<JsonReader, Entity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LightJsonReader$readEntity$2(LightJsonReader lightJsonReader) {
        super(1, lightJsonReader);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "readEntity";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(LightJsonReader.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "readEntity$lib_tavcut_model_release(Lcom/google/gson/stream/JsonReader;)Lcom/tencent/tavcut/rendermodel/entity/Entity;";
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Entity invoke(@NotNull JsonReader p16) {
        Intrinsics.checkParameterIsNotNull(p16, "p1");
        return ((LightJsonReader) this.receiver).readEntity$lib_tavcut_model_release(p16);
    }
}
