package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u00a2\u0006\u0004\b\t\u0010\nR'\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/QQStrangerLiteActionPullAllEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "Lkotlin/collections/ArrayList;", IQQGameCommApi.K_ABTEST_MODELS, "Ljava/util/ArrayList;", "getModels", "()Ljava/util/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLiteActionPullAllEvent extends SimpleBaseEvent {
    private final ArrayList<QQStrangerLiteActionModel> models;

    public QQStrangerLiteActionPullAllEvent(ArrayList<QQStrangerLiteActionModel> models) {
        Intrinsics.checkNotNullParameter(models, "models");
        this.models = models;
    }

    public final ArrayList<QQStrangerLiteActionModel> getModels() {
        return this.models;
    }
}
