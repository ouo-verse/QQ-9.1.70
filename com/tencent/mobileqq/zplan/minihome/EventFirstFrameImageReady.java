package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/q;", "Lcom/tencent/mobileqq/zplan/minihome/am;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "data", "Lcom/tencent/mobileqq/zplan/minihome/EventType;", "getType", "()Lcom/tencent/mobileqq/zplan/minihome/EventType;", "type", "<init>", "(Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.q, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class EventFirstFrameImageReady implements am {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String data;

    public EventFirstFrameImageReady(@Nullable String str) {
        this.data = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getData() {
        return this.data;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof EventFirstFrameImageReady) && Intrinsics.areEqual(this.data, ((EventFirstFrameImageReady) other).data)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.am
    @NotNull
    public EventType getType() {
        return EventType.EVENT_FIRST_FRAME_IMAGE_READY;
    }

    public int hashCode() {
        String str = this.data;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "EventFirstFrameImageReady(data=" + this.data + ')';
    }
}
