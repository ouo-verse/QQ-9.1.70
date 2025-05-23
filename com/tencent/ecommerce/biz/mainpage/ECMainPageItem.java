package com.tencent.ecommerce.biz.mainpage;

import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR!\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\u0012R\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "dataName", "b", "triggerScheme", "Ljava/lang/Class;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "c", "Ljava/lang/Class;", "()Ljava/lang/Class;", "triggerActionFragmentClz", "Lkotlin/Function0;", "", "d", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", AdCommonMethodHandler.AdCommonEvent.CLICK_ACTION, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.mainpage.d, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECMainPageItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String dataName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String triggerScheme;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Class<? extends ECBaseFragment> triggerActionFragmentClz;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final Function0<Unit> clickAction;

    public ECMainPageItem(String str, String str2, Class<? extends ECBaseFragment> cls, Function0<Unit> function0) {
        this.dataName = str;
        this.triggerScheme = str2;
        this.triggerActionFragmentClz = cls;
        this.clickAction = function0;
    }

    public final Function0<Unit> a() {
        return this.clickAction;
    }

    public final Class<? extends ECBaseFragment> b() {
        return this.triggerActionFragmentClz;
    }

    public int hashCode() {
        String str = this.dataName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.triggerScheme;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Class<? extends ECBaseFragment> cls = this.triggerActionFragmentClz;
        int hashCode3 = (hashCode2 + (cls != null ? cls.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.clickAction;
        return hashCode3 + (function0 != null ? function0.hashCode() : 0);
    }

    public String toString() {
        return "ECMainPageItem(dataName=" + this.dataName + ", triggerScheme=" + this.triggerScheme + ", triggerActionFragmentClz=" + this.triggerActionFragmentClz + ", clickAction=" + this.clickAction + ")";
    }

    public /* synthetic */ ECMainPageItem(String str, String str2, Class cls, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? null : cls, (i3 & 8) != 0 ? null : function0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECMainPageItem)) {
            return false;
        }
        ECMainPageItem eCMainPageItem = (ECMainPageItem) other;
        return Intrinsics.areEqual(this.dataName, eCMainPageItem.dataName) && Intrinsics.areEqual(this.triggerScheme, eCMainPageItem.triggerScheme) && Intrinsics.areEqual(this.triggerActionFragmentClz, eCMainPageItem.triggerActionFragmentClz) && Intrinsics.areEqual(this.clickAction, eCMainPageItem.clickAction);
    }
}
