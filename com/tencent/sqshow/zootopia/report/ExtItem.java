package com.tencent.sqshow.zootopia.report;

import av4.c;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/ExtItem;", "Ljava/io/Serializable;", "Lav4/c;", "convertToMsgExtItem", "", "component1", "component2", "name", "value", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class ExtItem implements Serializable {
    private final String name;
    private final String value;

    public ExtItem(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final c convertToMsgExtItem() {
        c cVar = new c();
        cVar.f27011a = this.name;
        cVar.f27012b = this.value;
        return cVar;
    }

    public final ExtItem copy(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new ExtItem(name, value);
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "ExtItem(name=" + this.name + ", value=" + this.value + ")";
    }

    public static /* synthetic */ ExtItem copy$default(ExtItem extItem, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = extItem.name;
        }
        if ((i3 & 2) != 0) {
            str2 = extItem.value;
        }
        return extItem.copy(str, str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtItem)) {
            return false;
        }
        ExtItem extItem = (ExtItem) other;
        return Intrinsics.areEqual(this.name, extItem.name) && Intrinsics.areEqual(this.value, extItem.value);
    }
}
