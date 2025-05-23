package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rmonitor/base/meta/LooperMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "looperParams", "Lorg/json/JSONObject;", "threadId", "", "threadName", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "getLooperParams", "()Lorg/json/JSONObject;", "getThreadId", "()Ljava/lang/String;", "getThreadName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* data */ class LooperMeta extends MonitorMeta {

    @Nullable
    private final JSONObject looperParams;

    @Nullable
    private final String threadId;

    @Nullable
    private final String threadName;

    public LooperMeta(@Nullable JSONObject jSONObject, @Nullable String str, @Nullable String str2) {
        this.looperParams = jSONObject;
        this.threadId = str;
        this.threadName = str2;
    }

    public static /* synthetic */ LooperMeta copy$default(LooperMeta looperMeta, JSONObject jSONObject, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jSONObject = looperMeta.looperParams;
        }
        if ((i3 & 2) != 0) {
            str = looperMeta.threadId;
        }
        if ((i3 & 4) != 0) {
            str2 = looperMeta.threadName;
        }
        return looperMeta.copy(jSONObject, str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final JSONObject getLooperParams() {
        return this.looperParams;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getThreadId() {
        return this.threadId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getThreadName() {
        return this.threadName;
    }

    @NotNull
    public final LooperMeta copy(@Nullable JSONObject looperParams, @Nullable String threadId, @Nullable String threadName) {
        return new LooperMeta(looperParams, threadId, threadName);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LooperMeta) {
                LooperMeta looperMeta = (LooperMeta) other;
                if (!Intrinsics.areEqual(this.looperParams, looperMeta.looperParams) || !Intrinsics.areEqual(this.threadId, looperMeta.threadId) || !Intrinsics.areEqual(this.threadName, looperMeta.threadName)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final JSONObject getLooperParams() {
        return this.looperParams;
    }

    @Nullable
    public final String getThreadId() {
        return this.threadId;
    }

    @Nullable
    public final String getThreadName() {
        return this.threadName;
    }

    public int hashCode() {
        int i3;
        int i16;
        JSONObject jSONObject = this.looperParams;
        int i17 = 0;
        if (jSONObject != null) {
            i3 = jSONObject.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str = this.threadId;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str2 = this.threadName;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "LooperMeta(looperParams=" + this.looperParams + ", threadId=" + this.threadId + ", threadName=" + this.threadName + ")";
    }
}
