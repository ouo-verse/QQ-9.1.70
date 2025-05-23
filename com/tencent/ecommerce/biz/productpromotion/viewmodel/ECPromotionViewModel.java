package com.tencent.ecommerce.biz.productpromotion.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import yj0.ECPromoteItem;
import yj0.d;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR-\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/productpromotion/viewmodel/ECPromotionViewModel;", "Landroidx/lifecycle/ViewModel;", "", "userId", "", "N1", "Ljava/util/ArrayList;", "Lyj0/c;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "_promotionItemList", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "promotionListLiveData", "Lyj0/d;", BdhLogUtil.LogTag.Tag_Conn, "Lyj0/d;", "M1", "()Lyj0/d;", "P1", "(Lyj0/d;)V", "getPromotionResp", "<init>", "()V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECPromotionViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private d getPromotionResp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ECPromoteItem> _promotionItemList = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ArrayList<ECPromoteItem>> promotionListLiveData = new MutableLiveData<>();

    /* renamed from: M1, reason: from getter */
    public final d getGetPromotionResp() {
        return this.getPromotionResp;
    }

    public final void N1(long userId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECPromotionViewModel$getPromotionItemList$1(this, userId, null), 3, null);
    }

    public final MutableLiveData<ArrayList<ECPromoteItem>> O1() {
        return this.promotionListLiveData;
    }

    public final void P1(d dVar) {
        this.getPromotionResp = dVar;
    }
}
