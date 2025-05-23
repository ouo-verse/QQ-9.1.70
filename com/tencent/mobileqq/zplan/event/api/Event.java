package com.tencent.mobileqq.zplan.event.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/event/api/Event;", "Ljava/io/Serializable;", "name", "", "source", "", "errCode", "msg", "extData", "", "(Ljava/lang/String;IILjava/lang/String;Ljava/util/Map;)V", "getErrCode", "()I", "getExtData", "()Ljava/util/Map;", "getMsg", "()Ljava/lang/String;", "getName", "getSource", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final /* data */ class Event implements Serializable {
    private final int errCode;
    private final Map<String, String> extData;
    private final String msg;
    private final String name;
    private final int source;

    public Event(String name, int i3, int i16, String msg2, Map<String, String> extData) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(extData, "extData");
        this.name = name;
        this.source = i3;
        this.errCode = i16;
        this.msg = msg2;
        this.extData = extData;
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    /* renamed from: component3, reason: from getter */
    public final int getErrCode() {
        return this.errCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final Map<String, String> component5() {
        return this.extData;
    }

    public final Event copy(String name, int source, int errCode, String msg2, Map<String, String> extData) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(extData, "extData");
        return new Event(name, source, errCode, msg2, extData);
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final Map<String, String> getExtData() {
        return this.extData;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSource() {
        return this.source;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.source) * 31) + this.errCode) * 31) + this.msg.hashCode()) * 31) + this.extData.hashCode();
    }

    public String toString() {
        return "Event(name=" + this.name + ", source=" + this.source + ", errCode=" + this.errCode + ", msg=" + this.msg + ", extData=" + this.extData + ")";
    }

    public static /* synthetic */ Event copy$default(Event event, String str, int i3, int i16, String str2, Map map, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = event.name;
        }
        if ((i17 & 2) != 0) {
            i3 = event.source;
        }
        int i18 = i3;
        if ((i17 & 4) != 0) {
            i16 = event.errCode;
        }
        int i19 = i16;
        if ((i17 & 8) != 0) {
            str2 = event.msg;
        }
        String str3 = str2;
        if ((i17 & 16) != 0) {
            map = event.extData;
        }
        return event.copy(str, i18, i19, str3, map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Event)) {
            return false;
        }
        Event event = (Event) other;
        return Intrinsics.areEqual(this.name, event.name) && this.source == event.source && this.errCode == event.errCode && Intrinsics.areEqual(this.msg, event.msg) && Intrinsics.areEqual(this.extData, event.extData);
    }

    public /* synthetic */ Event(String str, int i3, int i16, String str2, Map map, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? "" : str2, (i17 & 16) != 0 ? new HashMap() : map);
    }
}
