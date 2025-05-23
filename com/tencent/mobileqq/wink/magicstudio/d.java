package com.tencent.mobileqq.wink.magicstudio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BB\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u001a\u00a2\u0006\u0004\b-\u0010.J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R/\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR'\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00040 j\b\u0012\u0004\u0012\u00020\u0004`!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010,\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/magicstudio/AIGCImgItem;", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "list", "", "refresh", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isVerticalImg", BdhLogUtil.LogTag.Tag_Conn, "isSupportMultiSelect", "D", "I", "recyclerViewMaxHeight", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "E", "Lkotlin/jvm/functions/Function1;", "onItemClicked", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "i0", "()Ljava/util/ArrayList;", "dataList", "G", "j0", "()Z", "m0", "(Z)V", "needReportResult", "<init>", "(ZZILkotlin/jvm/functions/Function1;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d extends RecyclerView.Adapter<AIGCImgItem> {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isSupportMultiSelect;

    /* renamed from: D, reason: from kotlin metadata */
    private final int recyclerViewMaxHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onItemClicked;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<GenerateInfo> dataList;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needReportResult;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isVerticalImg;

    /* JADX WARN: Multi-variable type inference failed */
    public d(boolean z16, boolean z17, int i3, @NotNull Function1<? super Integer, Unit> onItemClicked) {
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.isVerticalImg = z16;
        this.isSupportMultiSelect = z17;
        this.recyclerViewMaxHeight = i3;
        this.onItemClicked = onItemClicked;
        this.dataList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @NotNull
    public final ArrayList<GenerateInfo> i0() {
        return this.dataList;
    }

    /* renamed from: j0, reason: from getter */
    public final boolean getNeedReportResult() {
        return this.needReportResult;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull AIGCImgItem holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        GenerateInfo generateInfo = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(generateInfo, "dataList[position]");
        holder.v(generateInfo, this.onItemClicked);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public AIGCImgItem onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        int coerceAtMost;
        int coerceAtMost2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dty, parent, false);
        if (this.isVerticalImg) {
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(com.tencent.videocut.utils.o.g(), this.recyclerViewMaxHeight);
            int i3 = (int) (coerceAtMost2 * 0.6d);
            int i16 = (i3 * 3) / 2;
            if (i16 > ViewExKt.d(LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT)) {
                i16 = ViewExKt.d(LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT);
                i3 = (i16 * 2) / 3;
            }
            view.setLayoutParams(new RecyclerView.LayoutParams(i3, i16));
        } else {
            int g16 = com.tencent.videocut.utils.o.g();
            com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(g16, oVar.f(context));
            int d16 = coerceAtMost - ViewExKt.d(32);
            view.setLayoutParams(new RecyclerView.LayoutParams(d16, (d16 * 2) / 3));
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new AIGCImgItem(view, this.isSupportMultiSelect);
    }

    public final void m0(boolean z16) {
        this.needReportResult = z16;
    }

    public final void refresh(@NotNull List<GenerateInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<GenerateInfo> list2 = list;
        Object[] array = list2.toArray(new GenerateInfo[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String arrays = Arrays.toString(array);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        w53.b.a("MultiSelectFragment", "allAigcFlow collect = " + arrays);
        this.dataList.clear();
        this.dataList.addAll(list2);
        notifyDataSetChanged();
        if (this.needReportResult) {
            this.needReportResult = !m83.b.t(m83.b.f416442a, list, false, 2, null);
        }
    }
}
