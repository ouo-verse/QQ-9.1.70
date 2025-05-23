package com.tencent.ecommerce.biz.submitsucceed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\n\u001a\u00020\tR \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u0010/\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,\u00a8\u00066"}, d2 = {"Lcom/tencent/ecommerce/biz/submitsucceed/ECSubmitSucceedViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Z1", "X1", "", "shopId", "", "spuIds", "Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "scene", "W1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/ecommerce/biz/recommend/models/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_productList", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "productList", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_showOfficialAccountDialogEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "D", "Lkotlinx/coroutines/flow/SharedFlow;", "T1", "()Lkotlinx/coroutines/flow/SharedFlow;", "showOfficialAccountDialogEvent", "E", "_followAccountEvent", UserInfo.SEX_FEMALE, "R1", "followAccountEvent", "G", "Ljava/lang/String;", "cookie", "<set-?>", "H", "Z", "U1", "()Z", "isEnd", "I", "isLoadingData", "<init>", "()V", "J", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubmitSucceedViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableSharedFlow<Boolean> _showOfficialAccountDialogEvent;

    /* renamed from: D, reason: from kotlin metadata */
    private final SharedFlow<Boolean> showOfficialAccountDialogEvent;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableSharedFlow<Boolean> _followAccountEvent;

    /* renamed from: F, reason: from kotlin metadata */
    private final SharedFlow<Boolean> followAccountEvent;

    /* renamed from: G, reason: from kotlin metadata */
    private String cookie;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isLoadingData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<ECProductRecommendItemData>> _productList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<ECProductRecommendItemData>> productList;

    public ECSubmitSucceedViewModel() {
        MutableLiveData<List<ECProductRecommendItemData>> mutableLiveData = new MutableLiveData<>();
        this._productList = mutableLiveData;
        this.productList = mutableLiveData;
        MutableSharedFlow<Boolean> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._showOfficialAccountDialogEvent = MutableSharedFlow$default;
        this.showOfficialAccountDialogEvent = MutableSharedFlow$default;
        MutableSharedFlow<Boolean> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._followAccountEvent = MutableSharedFlow$default2;
        this.followAccountEvent = MutableSharedFlow$default2;
        this.cookie = "";
    }

    public final SharedFlow<Boolean> R1() {
        return this.followAccountEvent;
    }

    public final LiveData<List<ECProductRecommendItemData>> S1() {
        return this.productList;
    }

    public final SharedFlow<Boolean> T1() {
        return this.showOfficialAccountDialogEvent;
    }

    /* renamed from: U1, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public final void W1(String shopId, List<String> spuIds, ECShopRecommendScene scene) {
        JSONObject b16;
        if (this.isEnd || this.isLoadingData) {
            return;
        }
        this.isLoadingData = true;
        b16 = ti0.a.f436377a.b((r13 & 1) != 0 ? "" : shopId, spuIds, scene, (r13 & 8) != 0 ? "" : null, this.cookie);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubmitSucceedViewModel$loadRecommendProduct$1(this, b16, null), 3, null);
    }

    public final void X1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubmitSucceedViewModel$requestFollowOfficialAccount$1(this, null), 3, null);
    }

    public final void Z1() {
        cg0.a.b("ECSubmitSucceedViewModel", "tryShowOfficialAccountDialog");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubmitSucceedViewModel$tryShowOfficialAccountDialog$1(this, null), 3, null);
    }
}
