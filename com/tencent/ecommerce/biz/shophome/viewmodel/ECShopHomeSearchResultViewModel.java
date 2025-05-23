package com.tencent.ecommerce.biz.shophome.viewmodel;

import androidx.lifecycle.ViewModelKt;
import bj0.ECShopHomeProductRequest;
import bj0.ECShopHomeSearchResultRecommendRequest;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.report.service.m;
import com.tencent.ecommerce.biz.shophome.viewmodel.a;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0015\u001a\u00020\u0002R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeSearchResultViewModel;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "", FeedManager.LOAD_MORE, "isSelect", "isDistributor", "Lorg/json/JSONObject;", "data", "", "B2", NowProxyConstants.AccountInfoKey.A2, "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", Constants.BASE_IN_PLUGIN_VERSION, "C2", "isSuccess", "I2", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "J2", "Lbj0/b;", "shopHomeProductRequest", "isFirstScreen", "E2", "Lbj0/d;", "searchResultRecommendRequest", Constants.MMCCID, "k0", "Lcom/tencent/ecommerce/base/report/service/k;", "<init>", "()V", "l0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeSearchResultViewModel extends a {

    /* renamed from: k0, reason: from kotlin metadata */
    private k showPageCostTime;

    private final a.b C2(JSONObject data) {
        if (data.length() == 0) {
            return new a.b.EmptyState(null, 1, null);
        }
        int optInt = data.optInt("code", 0);
        if (optInt != 0) {
            return new a.b.ErrorState(optInt, null, 2, null);
        }
        JSONArray optJSONArray = data.optJSONArray("recom_card");
        if ((optJSONArray != null ? optJSONArray.length() : 0) > 0) {
            return a.b.d.f104429a;
        }
        return new a.b.EmptyState(null, 1, null);
    }

    private final a.b D2(boolean z16, boolean z17, JSONObject jSONObject) {
        if (jSONObject.length() == 0) {
            return new a.b.EmptyState(null, 1, null);
        }
        int optInt = jSONObject.optInt("code", 0);
        if (optInt != 0) {
            return new a.b.ErrorState(optInt, null, 2, null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("cards");
        if ((optJSONArray != null ? optJSONArray.length() : 0) > 0) {
            return a.b.d.f104429a;
        }
        if (z16) {
            return new a.b.EmptyState(null, 1, null);
        }
        if (z17) {
            return new a.b.EmptyState(null, 1, null);
        }
        return a.b.c.f104428a;
    }

    public final void I2(boolean isSuccess, boolean isSelect) {
        Map<Object, ? extends Object> d16 = new m().b(isSelect).c(isSuccess ? 2 : 3).d();
        k kVar = this.showPageCostTime;
        if (kVar != null) {
            kVar.b(d16);
        }
    }

    public final void E2(ECShopHomeProductRequest shopHomeProductRequest, boolean isFirstScreen) {
        L1(shopHomeProductRequest.loadMore);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopHomeSearchResultViewModel$getShopHomeSearchProductListData$1(this, shopHomeProductRequest, isFirstScreen, null), 3, null);
    }

    public final void G2(ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest, boolean z16) {
        L1(eCShopHomeSearchResultRecommendRequest.loadMore);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopHomeSearchResultViewModel$getShopHomeSearchProductRecommendListData$1(this, eCShopHomeSearchResultRecommendRequest, z16, null), 3, null);
    }

    public final void J2(k showPageCostTime) {
        this.showPageCostTime = showPageCostTime;
    }

    public final void A2(boolean z16, JSONObject jSONObject) {
        if (z16) {
            e2().postValue(Boolean.FALSE);
        } else {
            f2().postValue(C2(jSONObject));
        }
    }

    public final void B2(boolean r16, boolean isSelect, boolean isDistributor, JSONObject data) {
        if (r16) {
            e2().postValue(Boolean.FALSE);
        } else {
            f2().postValue(D2(isSelect, isDistributor, data));
        }
    }

    public static /* synthetic */ void F2(ECShopHomeSearchResultViewModel eCShopHomeSearchResultViewModel, ECShopHomeProductRequest eCShopHomeProductRequest, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        eCShopHomeSearchResultViewModel.E2(eCShopHomeProductRequest, z16);
    }

    public static /* synthetic */ void H2(ECShopHomeSearchResultViewModel eCShopHomeSearchResultViewModel, ECShopHomeSearchResultRecommendRequest eCShopHomeSearchResultRecommendRequest, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        eCShopHomeSearchResultViewModel.G2(eCShopHomeSearchResultRecommendRequest, z16);
    }
}
