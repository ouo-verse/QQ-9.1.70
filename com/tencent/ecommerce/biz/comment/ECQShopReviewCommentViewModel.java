package com.tencent.ecommerce.biz.comment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.ecommerce.repo.comment.ECQShopOrderReviewCommentInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001f\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECQShopReviewCommentViewModel;", "Landroidx/lifecycle/ViewModel;", "", WSAutoShowCommentParams.KEY_COMMENT_ID, "", "N1", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "skuId", "spuId", "O1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/ecommerce/repo/comment/c;", "i", "Landroidx/lifecycle/MutableLiveData;", "_reviewCommentInfo", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "reviewCommentInfo", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopReviewCommentViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ECQShopOrderReviewCommentInfo> _reviewCommentInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<ECQShopOrderReviewCommentInfo> reviewCommentInfo;

    public ECQShopReviewCommentViewModel() {
        MutableLiveData<ECQShopOrderReviewCommentInfo> mutableLiveData = new MutableLiveData<>();
        this._reviewCommentInfo = mutableLiveData;
        this.reviewCommentInfo = mutableLiveData;
    }

    public final LiveData<ECQShopOrderReviewCommentInfo> M1() {
        return this.reviewCommentInfo;
    }

    public final void N1(String commentId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECQShopReviewCommentViewModel$requestCommentInfoByCommentId$1(this, commentId, null), 3, null);
    }

    public final void O1(String orderId, String skuId, String spuId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECQShopReviewCommentViewModel$requestCommentInfoByOrder$1(this, orderId, skuId, spuId, null), 3, null);
    }
}
