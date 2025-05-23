package com.tencent.mobileqq.winkpublish.outbox.db.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.NetVideoParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/MediaParamsTypeAdapter;", "Lcom/tencent/mobileqq/winkpublish/outbox/db/gson/BaseTypeAdapter;", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "gson", "Lcom/google/gson/Gson;", "factory", "Lcom/google/gson/TypeAdapterFactory;", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapterFactory;)V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class MediaParamsTypeAdapter extends BaseTypeAdapter<MediaParams> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaParamsTypeAdapter(Gson gson, TypeAdapterFactory factory) {
        super("type");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(factory, "factory");
        a(gson, factory, 1, VideoParams.class);
        a(gson, factory, 0, ImageParams.class);
        a(gson, factory, 2, NetVideoParams.class);
    }
}
