package com.tencent.mobileqq.zplan.web.impl;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/UpdateCustomTitleEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final /* data */ class UpdateCustomTitleEvent extends SimpleBaseEvent {
    private final String data;

    public UpdateCustomTitleEvent(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    public final UpdateCustomTitleEvent copy(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new UpdateCustomTitleEvent(data);
    }

    public final String getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "UpdateCustomTitleEvent(data=" + this.data + ")";
    }

    public static /* synthetic */ UpdateCustomTitleEvent copy$default(UpdateCustomTitleEvent updateCustomTitleEvent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = updateCustomTitleEvent.data;
        }
        return updateCustomTitleEvent.copy(str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UpdateCustomTitleEvent) && Intrinsics.areEqual(this.data, ((UpdateCustomTitleEvent) other).data);
    }
}
