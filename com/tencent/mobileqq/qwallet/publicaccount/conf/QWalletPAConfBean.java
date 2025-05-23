package com.tencent.mobileqq.qwallet.publicaccount.conf;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/publicaccount/conf/QWalletPAConfBean;", "", "tabItems", "", "Lcom/tencent/mobileqq/qwallet/publicaccount/conf/TabItem;", "(Ljava/util/List;)V", "getTabItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class QWalletPAConfBean {

    @NotNull
    private final List<TabItem> tabItems;

    public QWalletPAConfBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QWalletPAConfBean copy$default(QWalletPAConfBean qWalletPAConfBean, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = qWalletPAConfBean.tabItems;
        }
        return qWalletPAConfBean.copy(list);
    }

    @NotNull
    public final List<TabItem> component1() {
        return this.tabItems;
    }

    @NotNull
    public final QWalletPAConfBean copy(@NotNull List<TabItem> tabItems) {
        Intrinsics.checkNotNullParameter(tabItems, "tabItems");
        return new QWalletPAConfBean(tabItems);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof QWalletPAConfBean) && Intrinsics.areEqual(this.tabItems, ((QWalletPAConfBean) other).tabItems)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<TabItem> getTabItems() {
        return this.tabItems;
    }

    public int hashCode() {
        return this.tabItems.hashCode();
    }

    @NotNull
    public String toString() {
        return "QWalletPAConfBean(tabItems=" + this.tabItems + ")";
    }

    public QWalletPAConfBean(@NotNull List<TabItem> tabItems) {
        Intrinsics.checkNotNullParameter(tabItems, "tabItems");
        this.tabItems = tabItems;
    }

    public /* synthetic */ QWalletPAConfBean(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list);
    }
}
