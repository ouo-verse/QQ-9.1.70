package com.tencent.icgame.game.liveroom.impl.room.profile;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001BI\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001a\u00a2\u0006\u0004\b \u0010!R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR.\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014\u00a8\u0006\""}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/i;", "", "", "a", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "setPageId", "(Ljava/lang/String;)V", "pageId", "b", "getElementId", "setElementId", "elementId", "", "c", "Ljava/util/Map;", "getParamMap", "()Ljava/util/Map;", "setParamMap", "(Ljava/util/Map;)V", "paramMap", "d", "getEquipStatus", "setEquipStatus", "equipStatus", "", "e", "getPageParam", "setPageParam", "pageParam", "pageParamMap", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String elementId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, String> paramMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String equipStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, String> pageParam;

    public i(@NotNull String pageId, @NotNull String elementId, @NotNull Map<String, String> paramMap, @NotNull String equipStatus, @NotNull Map<String, String> pageParamMap) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(paramMap, "paramMap");
        Intrinsics.checkNotNullParameter(equipStatus, "equipStatus");
        Intrinsics.checkNotNullParameter(pageParamMap, "pageParamMap");
        this.pageId = pageId;
        this.elementId = elementId;
        this.paramMap = paramMap;
        this.equipStatus = equipStatus;
        this.pageParam = pageParamMap;
    }
}
