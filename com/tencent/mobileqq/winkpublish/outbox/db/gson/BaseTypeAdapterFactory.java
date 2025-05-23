package com.tencent.mobileqq.winkpublish.outbox.db.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J0\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005\"\u0004\b\u0001\u0010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/BaseTypeAdapterFactory;", "T", "Lcom/google/gson/TypeAdapterFactory;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/TypeAdapter;", "a", "Lcom/google/gson/reflect/TypeToken;", "token", OperateCustomButton.OPERATE_CREATE, "Ljava/lang/Class;", "d", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/Class;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class BaseTypeAdapterFactory<T> implements TypeAdapterFactory {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Class<T> clazz;

    public BaseTypeAdapterFactory(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        this.clazz = clazz;
    }

    public abstract TypeAdapter<T> a(Gson gson);

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> token) {
        if (gson == null || token == null || !this.clazz.isAssignableFrom(token.getRawType())) {
            return null;
        }
        TypeAdapter<T> a16 = a(gson);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of com.tencent.mobileqq.winkpublish.outbox.db.gson.BaseTypeAdapterFactory.create>");
        return a16;
    }
}
