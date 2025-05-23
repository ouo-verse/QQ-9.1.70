package com.tencent.mobileqq.winkpublish.outbox.db.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/DeclarationParamsAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "Lcom/google/gson/stream/JsonWriter;", "out", "value", "", "b", "Lcom/google/gson/stream/JsonReader;", "in", "a", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class DeclarationParamsAdapter extends TypeAdapter<DeclarationParams> {
    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DeclarationParams read2(JsonReader in5) throws IOException {
        Intrinsics.checkNotNullParameter(in5, "in");
        String json = in5.nextString();
        DeclarationParams.Companion companion = DeclarationParams.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(json, "json");
        DeclarationParams b16 = companion.b(json);
        QLog.d("DeclarationParamsAdapter", 1, "result:" + b16);
        return b16;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter out, DeclarationParams value) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        if (value == null) {
            out.nullValue();
            return;
        }
        QLog.d("DeclarationParamsAdapter", 1, "write:" + value);
        out.value(value.toString());
    }
}
