package com.tencent.state.battery;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0014J\b\u0010!\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/battery/SquareBatteryLevelInfo;", "", "uin", "", "isMale", "", "dressKey", "list", "", "Lcom/tencent/state/battery/SquareBatteryLevelItem;", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getDressKey", "()Ljava/lang/String;", "setDressKey", "(Ljava/lang/String;)V", "()Z", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "getUin", "changeDressKey", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "isDressKeyDiff", "isSamePersonInfo", "resetDefaultResource", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* data */ class SquareBatteryLevelInfo {
    private String dressKey;
    private final boolean isMale;
    private final List<SquareBatteryLevelItem> list;
    private final String uin;

    public SquareBatteryLevelInfo(String uin, boolean z16, String dressKey, List<SquareBatteryLevelItem> list) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(list, "list");
        this.uin = uin;
        this.isMale = z16;
        this.dressKey = dressKey;
        this.list = list;
    }

    public final void changeDressKey(String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        this.dressKey = dressKey;
        resetDefaultResource();
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMale() {
        return this.isMale;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDressKey() {
        return this.dressKey;
    }

    public final List<SquareBatteryLevelItem> component4() {
        return this.list;
    }

    public final SquareBatteryLevelInfo copy(String uin, boolean isMale, String dressKey, List<SquareBatteryLevelItem> list) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(list, "list");
        return new SquareBatteryLevelInfo(uin, isMale, dressKey, list);
    }

    public final String getDressKey() {
        return this.dressKey;
    }

    public final List<SquareBatteryLevelItem> getList() {
        return this.list;
    }

    public final String getUin() {
        return this.uin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z16 = this.isMale;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        String str2 = this.dressKey;
        int hashCode2 = (i16 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<SquareBatteryLevelItem> list = this.list;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isDressKeyDiff(String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        return !TextUtils.equals(dressKey, this.dressKey);
    }

    public final boolean isMale() {
        return this.isMale;
    }

    public final boolean isSamePersonInfo(String uin, boolean isMale) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return TextUtils.equals(uin, this.uin) && isMale == this.isMale;
    }

    public final void resetDefaultResource() {
        Iterator<T> it = this.list.iterator();
        while (it.hasNext()) {
            ((SquareBatteryLevelItem) it.next()).getResource().resetDefault();
        }
    }

    public final void setDressKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dressKey = str;
    }

    public String toString() {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append('[');
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.list, ",", null, null, 0, null, new Function1<SquareBatteryLevelItem, CharSequence>() { // from class: com.tencent.state.battery.SquareBatteryLevelInfo$toString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(SquareBatteryLevelItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it);
            }
        }, 30, null);
        sb5.append(joinToString$default);
        sb5.append(']');
        return sb5.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareBatteryLevelInfo)) {
            return false;
        }
        SquareBatteryLevelInfo squareBatteryLevelInfo = (SquareBatteryLevelInfo) other;
        return Intrinsics.areEqual(this.uin, squareBatteryLevelInfo.uin) && this.isMale == squareBatteryLevelInfo.isMale && Intrinsics.areEqual(this.dressKey, squareBatteryLevelInfo.dressKey) && Intrinsics.areEqual(this.list, squareBatteryLevelInfo.list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SquareBatteryLevelInfo copy$default(SquareBatteryLevelInfo squareBatteryLevelInfo, String str, boolean z16, String str2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareBatteryLevelInfo.uin;
        }
        if ((i3 & 2) != 0) {
            z16 = squareBatteryLevelInfo.isMale;
        }
        if ((i3 & 4) != 0) {
            str2 = squareBatteryLevelInfo.dressKey;
        }
        if ((i3 & 8) != 0) {
            list = squareBatteryLevelInfo.list;
        }
        return squareBatteryLevelInfo.copy(str, z16, str2, list);
    }
}
