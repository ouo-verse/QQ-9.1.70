package com.tencent.mobileqq.icgame.techreport;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002J\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/icgame/techreport/f;", "", "", "eventCode", "c", "eventMsg", "d", "anchorId", "b", "roomId", "f", "roomType", "g", "userId", h.F, "ext1", "e", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "params", "eventId", "<init>", "(Ljava/lang/String;)V", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> params;

    public f(@NotNull String eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("event_id", eventId);
        this.params = hashMap;
    }

    @NotNull
    public final Map<String, String> a() {
        return this.params;
    }

    @NotNull
    public final f b(@NotNull String anchorId) {
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        this.params.put(AudienceReportConst.ANCHOR_ID, anchorId);
        return this;
    }

    @NotNull
    public final f c(@NotNull String eventCode) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        this.params.put("event_code", eventCode);
        return this;
    }

    @NotNull
    public final f d(@NotNull String eventMsg) {
        Intrinsics.checkNotNullParameter(eventMsg, "eventMsg");
        this.params.put(AudienceReportConst.EVENT_MSG, eventMsg);
        return this;
    }

    @NotNull
    public final f e(@NotNull String ext1) {
        Intrinsics.checkNotNullParameter(ext1, "ext1");
        this.params.put("ext1", ext1);
        return this;
    }

    @NotNull
    public final f f(@NotNull String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.params.put(AudienceReportConst.ROOM_ID, roomId);
        return this;
    }

    @NotNull
    public final f g(@NotNull String roomType) {
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        this.params.put("room_type", roomType);
        return this;
    }

    @NotNull
    public final f h(@NotNull String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.params.put("user_id", userId);
        return this;
    }
}
