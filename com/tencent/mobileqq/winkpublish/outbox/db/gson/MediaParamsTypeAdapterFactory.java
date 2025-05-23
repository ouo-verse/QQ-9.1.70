package com.tencent.mobileqq.winkpublish.outbox.db.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/MediaParamsTypeAdapterFactory;", "Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/BaseTypeAdapterFactory;", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/TypeAdapter;", "a", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MediaParamsTypeAdapterFactory extends BaseTypeAdapterFactory<MediaParams> {
    public MediaParamsTypeAdapterFactory() {
        super(MediaParams.class);
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.db.gson.BaseTypeAdapterFactory
    public TypeAdapter<MediaParams> a(Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new MediaParamsTypeAdapter(gson, this);
    }
}
