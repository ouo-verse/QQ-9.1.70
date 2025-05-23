package com.tencent.biz.qqcircle.immersive.layer.biz.inside.search.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StShadingWords;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/inside/search/event/UpdateSearchShadingWordEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "shadingWordsMap", "", "", "Lfeedcloud/FeedCloudMeta$StShadingWords;", "(Ljava/util/Map;)V", "getShadingWordsMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UpdateSearchShadingWordEvent extends SimpleBaseEvent {

    @NotNull
    private final Map<String, FeedCloudMeta$StShadingWords> shadingWordsMap;

    public UpdateSearchShadingWordEvent(@NotNull Map<String, FeedCloudMeta$StShadingWords> shadingWordsMap) {
        Intrinsics.checkNotNullParameter(shadingWordsMap, "shadingWordsMap");
        this.shadingWordsMap = shadingWordsMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateSearchShadingWordEvent copy$default(UpdateSearchShadingWordEvent updateSearchShadingWordEvent, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = updateSearchShadingWordEvent.shadingWordsMap;
        }
        return updateSearchShadingWordEvent.copy(map);
    }

    @NotNull
    public final Map<String, FeedCloudMeta$StShadingWords> component1() {
        return this.shadingWordsMap;
    }

    @NotNull
    public final UpdateSearchShadingWordEvent copy(@NotNull Map<String, FeedCloudMeta$StShadingWords> shadingWordsMap) {
        Intrinsics.checkNotNullParameter(shadingWordsMap, "shadingWordsMap");
        return new UpdateSearchShadingWordEvent(shadingWordsMap);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof UpdateSearchShadingWordEvent) && Intrinsics.areEqual(this.shadingWordsMap, ((UpdateSearchShadingWordEvent) other).shadingWordsMap)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<String, FeedCloudMeta$StShadingWords> getShadingWordsMap() {
        return this.shadingWordsMap;
    }

    public int hashCode() {
        return this.shadingWordsMap.hashCode();
    }

    @NotNull
    public String toString() {
        return "UpdateSearchShadingWordEvent(shadingWordsMap=" + this.shadingWordsMap + ")";
    }
}
