package com.tencent.mobileqq.wink.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\b\u00a2\u0006\u0002\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR1\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/event/WinkQZoneMoodAppendEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "imagePathList", "", "", "videoPathList", "publishEventTagParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/List;Ljava/util/List;Ljava/util/HashMap;)V", "getImagePathList", "()Ljava/util/List;", "getPublishEventTagParams", "()Ljava/util/HashMap;", "getVideoPathList", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkQZoneMoodAppendEvent extends SimpleBaseEvent {

    @NotNull
    private final List<String> imagePathList;

    @NotNull
    private final HashMap<String, String> publishEventTagParams;

    @NotNull
    private final List<String> videoPathList;

    public WinkQZoneMoodAppendEvent(@NotNull List<String> imagePathList, @NotNull List<String> videoPathList, @NotNull HashMap<String, String> publishEventTagParams) {
        Intrinsics.checkNotNullParameter(imagePathList, "imagePathList");
        Intrinsics.checkNotNullParameter(videoPathList, "videoPathList");
        Intrinsics.checkNotNullParameter(publishEventTagParams, "publishEventTagParams");
        this.imagePathList = imagePathList;
        this.videoPathList = videoPathList;
        this.publishEventTagParams = publishEventTagParams;
    }

    @NotNull
    public final List<String> getImagePathList() {
        return this.imagePathList;
    }

    @NotNull
    public final HashMap<String, String> getPublishEventTagParams() {
        return this.publishEventTagParams;
    }

    @NotNull
    public final List<String> getVideoPathList() {
        return this.videoPathList;
    }
}
