package com.tencent.mobileqq.qwallet.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qwallet.utils.QWalletUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B*\u0012!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00050\u001b\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0014\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\rH\u0016R/\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00050\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\"j\b\u0012\u0004\u0012\u00020\n`#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00030&j\b\u0012\u0004\u0012\u00020\u0003`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qwallet/setting/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qwallet/setting/a$a;", "", "i0", "", "n0", "str", "l0", "", "Lcom/tencent/mobileqq/qwallet/setting/g;", "settingDataItems", "m0", "", "settingType", "", h.f248218g, "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k0", "position", "getItemViewType", "getItemCount", "holder", "j0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "settingDataItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onItemClickListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "D", "Ljava/util/HashSet;", "reportItemNameSet", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "E", "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends RecyclerView.Adapter<C8484a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<SettingDataItem> settingDataItems;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashSet<String> reportItemNameSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<SettingDataItem, Unit> onItemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qwallet/setting/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.setting.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8484a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8484a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function1<? super SettingDataItem, Unit> onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
        this.settingDataItems = new ArrayList<>();
        this.reportItemNameSet = new HashSet<>();
    }

    private final String i0() {
        return com.tencent.mobileqq.qwallet.utils.g.j("setting_page_report_item_id" + com.tencent.mobileqq.base.a.c(), "");
    }

    private final void l0(String str) {
        com.tencent.mobileqq.qwallet.utils.g.q("setting_page_report_item_id" + com.tencent.mobileqq.base.a.c(), str);
    }

    private final void n0() {
        boolean z16;
        String i06 = i0();
        if (QLog.isColorLevel()) {
            QLog.i("QWalletSettingAdapter", 2, "tryReportAppsShow:" + i06);
        }
        if (i06.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.qwallet.c.e("set.show", "", "", i06, AppSetting.f99551k);
            QWalletUtils.s("set_show", "", "", "", i06);
            this.reportItemNameSet.clear();
            l0("");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.settingDataItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.settingDataItems.get(position).getId() == -1) {
            return 2;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C8484a holder, int position) {
        boolean z16;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof e) {
            SettingDataItem settingDataItem = this.settingDataItems.get(position);
            Intrinsics.checkNotNullExpressionValue(settingDataItem, "settingDataItems[position]");
            SettingDataItem settingDataItem2 = settingDataItem;
            if (settingDataItem2.getPv().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.reportItemNameSet.add(settingDataItem2.getPv());
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.reportItemNameSet, ";", null, null, 0, null, null, 62, null);
                l0(joinToString$default);
            }
            ((e) holder).r(settingDataItem2, this.onItemClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public C8484a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bda, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026tem_space, parent, false)");
            return new C8484a(inflate);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hk5, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new e(view);
    }

    public final void m0(@NotNull List<SettingDataItem> settingDataItems) {
        Intrinsics.checkNotNullParameter(settingDataItems, "settingDataItems");
        n0();
        this.settingDataItems.clear();
        this.settingDataItems.addAll(settingDataItems);
        notifyDataSetChanged();
    }

    public final void o0(int settingType, boolean isOpen) {
        Object obj;
        boolean z16;
        Iterator<T> it = this.settingDataItems.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SettingDataItem) obj).getSettingType() == settingType) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SettingDataItem settingDataItem = (SettingDataItem) obj;
        if (settingDataItem != null) {
            settingDataItem.l(isOpen);
        }
        notifyDataSetChanged();
    }
}
