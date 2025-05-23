package com.tencent.ecommerce.biz.showwindow.ui.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowListFragment;
import com.tencent.ecommerce.repo.live.ECShopDetail;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B3\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "position", "", "i0", "getItemCount", "Landroidx/fragment/app/Fragment;", "createFragment", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "fragment", "", "Lcom/tencent/ecommerce/repo/live/h;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "dataList", "Lkotlin/Function1;", "", "D", "Lkotlin/jvm/functions/Function1;", "subFragmentCallback", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "E", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends FragmentStateAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    private final List<ECShopDetail> dataList;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function1<Fragment, Unit> subFragmentCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Fragment fragment;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Fragment fragment, List<ECShopDetail> list, Function1<? super Fragment, Unit> function1) {
        super(fragment);
        this.fragment = fragment;
        this.dataList = list;
        this.subFragmentCallback = function1;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        ECShopDetail eCShopDetail = this.dataList.get(position);
        Bundle bundle = new Bundle();
        bundle.putAll(this.fragment.getArguments());
        bundle.putString("shop_id", eCShopDetail.baseInfo.shopId);
        bundle.putString("shop_name", eCShopDetail.baseInfo.shopName);
        return ECLiveShowWindowListFragment.INSTANCE.a(bundle, this.subFragmentCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    public final String i0(int position) {
        int i3 = this.dataList.size() <= 3 ? 5 : 4;
        String str = this.dataList.get(position).baseInfo.shopName;
        if (str.length() <= i3) {
            return str;
        }
        String substring = str.substring(0, i3 - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return substring + Typography.ellipsis;
    }
}
