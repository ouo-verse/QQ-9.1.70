package com.qzone.reborn.feedpro.widget.header;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u0012\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/NavigatorItem;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "e", "(I)V", "iEntranceId", "b", "f", "iconResId", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "text", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "g", "(Lkotlin/jvm/functions/Function0;)V", NodeProps.ON_CLICK, "<init>", "(IILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class NavigatorItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int iEntranceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int iconResId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private Function0<Unit> onClick;

    public NavigatorItem() {
        this(0, 0, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getIEntranceId() {
        return this.iEntranceId;
    }

    /* renamed from: b, reason: from getter */
    public final int getIconResId() {
        return this.iconResId;
    }

    public final Function0<Unit> c() {
        return this.onClick;
    }

    /* renamed from: d, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final void e(int i3) {
        this.iEntranceId = i3;
    }

    public final void f(int i3) {
        this.iconResId = i3;
    }

    public final void g(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onClick = function0;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public int hashCode() {
        return (((((this.iEntranceId * 31) + this.iconResId) * 31) + this.text.hashCode()) * 31) + this.onClick.hashCode();
    }

    public String toString() {
        return "NavigatorItem(iEntranceId=" + this.iEntranceId + ", iconResId=" + this.iconResId + ", text=" + this.text + ", onClick=" + this.onClick + ")";
    }

    public NavigatorItem(int i3, int i16, String text, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.iEntranceId = i3;
        this.iconResId = i16;
        this.text = text;
        this.onClick = onClick;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigatorItem)) {
            return false;
        }
        NavigatorItem navigatorItem = (NavigatorItem) other;
        return this.iEntranceId == navigatorItem.iEntranceId && this.iconResId == navigatorItem.iconResId && Intrinsics.areEqual(this.text, navigatorItem.text) && Intrinsics.areEqual(this.onClick, navigatorItem.onClick);
    }

    public /* synthetic */ NavigatorItem(int i3, int i16, String str, Function0 function0, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16, (i17 & 4) != 0 ? "" : str, (i17 & 8) != 0 ? new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.NavigatorItem.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0);
    }
}
