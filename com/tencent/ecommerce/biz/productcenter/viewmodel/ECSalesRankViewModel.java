package com.tencent.ecommerce.biz.productcenter.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ecommerce.biz.productcenter.repo.ECSalesRankRepo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import xj0.RankGoodsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/viewmodel/ECSalesRankViewModel;", "Landroidx/lifecycle/ViewModel;", "", "P1", "N1", "Ljava/util/ArrayList;", "Lxj0/a;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "_salesRankList", "Landroidx/lifecycle/MutableLiveData;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "rankListLiveData", "Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", "rankType", "", "D", "Ljava/lang/String;", WadlProxyConsts.CHANNEL, "<init>", "(Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;Ljava/lang/String;)V", "E", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSalesRankViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    public final ECSalesRankRepo.SalesRankType rankType;

    /* renamed from: D, reason: from kotlin metadata */
    private final String channel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ArrayList<RankGoodsInfo> _salesRankList = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<RankGoodsInfo>> rankListLiveData = new MutableLiveData<>(this._salesRankList);

    public ECSalesRankViewModel(ECSalesRankRepo.SalesRankType salesRankType, String str) {
        this.rankType = salesRankType;
        this.channel = str;
    }

    public final void N1() {
        ArrayList<RankGoodsInfo> c16 = ECSalesRankRepo.f103920a.c(this.rankType);
        if (c16 != null) {
            this._salesRankList.clear();
            this._salesRankList = c16;
            this.rankListLiveData.postValue(c16);
        }
    }

    public final MutableLiveData<List<RankGoodsInfo>> O1() {
        return this.rankListLiveData;
    }

    public final void P1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSalesRankViewModel$reqSalesRankList$1(this, null), 3, null);
    }
}
