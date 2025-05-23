package com.tencent.mobileqq.winkpublish.outbox.db.gson;

import android.util.SparseArray;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b\"\u0010#J8\u0010\r\u001a\u00020\f\"\b\b\u0001\u0010\u0003*\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0004J\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018R \u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/BaseTypeAdapter;", "T", "Lcom/google/gson/TypeAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/TypeAdapterFactory;", "factory", "", "type", "Ljava/lang/Class;", "clazz", "", "a", "Lcom/google/gson/stream/JsonWriter;", "writer", DTConstants.TAG.ELEMENT, k.f247492f, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "Lcom/google/gson/stream/JsonReader;", "reader", k.f247491e, "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "", "Ljava/lang/String;", "typeFieldName", "Landroid/util/SparseArray;", "b", "Landroid/util/SparseArray;", "typeToAdapter", "", "c", "Ljava/util/Map;", "nameToAdapter", "<init>", "(Ljava/lang/String;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class BaseTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String typeFieldName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<TypeAdapter<T>> typeToAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, TypeAdapter<T>> nameToAdapter;

    public BaseTypeAdapter(String typeFieldName) {
        Intrinsics.checkNotNullParameter(typeFieldName, "typeFieldName");
        this.typeFieldName = typeFieldName;
        this.typeToAdapter = new SparseArray<>();
        this.nameToAdapter = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <C extends T> void a(Gson gson, TypeAdapterFactory factory, int type, Class<C> clazz) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(factory, TypeToken.get((Class) clazz));
        Intrinsics.checkNotNull(delegateAdapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.tencent.mobileqq.winkpublish.outbox.db.gson.BaseTypeAdapter>");
        Map<String, TypeAdapter<T>> map = this.nameToAdapter;
        String name = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
        map.put(name, delegateAdapter);
        this.typeToAdapter.put(type, delegateAdapter);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public T read2(JsonReader reader) {
        JsonObject asJsonObject = Streams.parse(reader).getAsJsonObject();
        return this.typeToAdapter.get(asJsonObject.get(this.typeFieldName).getAsInt()).fromJsonTree(asJsonObject);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter writer, T element) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (element == null) {
            writer.nullValue();
            return;
        }
        TypeAdapter<T> typeAdapter = this.nameToAdapter.get(element.getClass().getName());
        Intrinsics.checkNotNull(typeAdapter);
        typeAdapter.write(writer, element);
    }
}
