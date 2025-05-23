package com.tencent.ecommerce.base.plugin;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/HashMap;", "a", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "requestParams", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "result", "<init>", "(Ljava/util/HashMap;Ljava/lang/Object;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.plugin.d, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECPluginServiceEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final HashMap<String, String> requestParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Object result;

    public ECPluginServiceEvent(@NotNull HashMap<String, String> hashMap, @NotNull Object obj) {
        this.requestParams = hashMap;
        this.result = obj;
    }

    @NotNull
    public final HashMap<String, String> a() {
        return this.requestParams;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Object getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECPluginServiceEvent) {
                ECPluginServiceEvent eCPluginServiceEvent = (ECPluginServiceEvent) other;
                if (!Intrinsics.areEqual(this.requestParams, eCPluginServiceEvent.requestParams) || !Intrinsics.areEqual(this.result, eCPluginServiceEvent.result)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        HashMap<String, String> hashMap = this.requestParams;
        int i16 = 0;
        if (hashMap != null) {
            i3 = hashMap.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        Object obj = this.result;
        if (obj != null) {
            i16 = obj.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "ECPluginServiceEvent(requestParams=" + this.requestParams + ", result=" + this.result + ")";
    }
}
