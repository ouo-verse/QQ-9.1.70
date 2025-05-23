package com.tencent.mobileqq.winkpublish.outbox.db.gson;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/BundleTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "token", "Lcom/google/gson/reflect/TypeToken;", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class BundleTypeAdapterFactory implements TypeAdapterFactory {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> token) {
        if (gson == null || token == null || !Bundle.class.isAssignableFrom(token.getRawType())) {
            return null;
        }
        return new BundleTypeAdapter(gson);
    }
}
