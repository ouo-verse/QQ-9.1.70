package com.tencent.ecommerce.biz.comment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/b;", "Landroidx/lifecycle/ViewModel;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "productId", "", "goodType", "Lorg/json/JSONObject;", "M1", "", "O1", "i", "I", "getScore", "()I", "P1", "(I)V", LocalPhotoFaceInfo.SCORE, "Landroidx/lifecycle/MutableLiveData;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_isEvaluateSucceed", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "isEvaluateSucceed", "<init>", "()V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<Boolean> isEvaluateSucceed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int score;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _isEvaluateSucceed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/comment/b$b", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.comment.b$b, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1046b implements IECJsonNetworkCallback {
        C1046b() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            b.this._isEvaluateSucceed.postValue(Boolean.FALSE);
            cg0.a.a("ECBuyerOrderCommentViewModel", "sendEvaluate", "sendEvaluate error: " + String.valueOf(errorResponse));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            b.this._isEvaluateSucceed.postValue(Boolean.TRUE);
            if (respData == null) {
                cg0.a.b("ECBuyerOrderCommentViewModel", "sendEvaluate success and rspData is null");
                return;
            }
            cg0.a.b("ECBuyerOrderCommentViewModel", "sendEvaluate success, retCode = " + respData.optString("ret_code") + ", retMsg = " + respData.optString("ret_msg"));
        }
    }

    public b() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._isEvaluateSucceed = mutableLiveData;
        this.isEvaluateSucceed = mutableLiveData;
    }

    private final JSONObject M1(String orderId, String productId, int goodType) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("order_id", orderId);
        jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        jSONObject.put("goods_type", goodType);
        jSONObject.put(LocalPhotoFaceInfo.SCORE, this.score);
        return jSONObject;
    }

    public final LiveData<Boolean> N1() {
        return this.isEvaluateSucceed;
    }

    public final void O1(String orderId, String productId, int goodType) {
        com.tencent.ecommerce.base.network.service.a.c("trpc.ecom.evaluate_svr.EvaluateSvr", "/trpc.ecom.evaluate_svr.EvaluateSvr/SetEvaluate", M1(orderId, productId, goodType), new C1046b());
    }

    public final void P1(int i3) {
        this.score = i3;
    }
}
