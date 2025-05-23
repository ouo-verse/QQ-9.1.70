package com.tencent.ecommerce.biz.applysample;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.biz.comment.BatchUploader;
import com.tencent.ecommerce.biz.comment.UploadStateListener;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.ecommerce.repo.sampleorder.ECAbortFulfillOption;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0002R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u001f\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00188\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001cR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel;", "Landroidx/lifecycle/ViewModel;", "", "oderId", "", "Q1", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "mediaInfos", "S1", "Lcom/tencent/ecommerce/repo/aftersale/apply/j;", "optionValue", "R1", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "reason", "desc", "Lkotlinx/coroutines/flow/Flow;", "", "P1", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a;", "i", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_uiState", "Lkotlinx/coroutines/flow/StateFlow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/StateFlow;", "O1", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", BdhLogUtil.LogTag.Tag_Conn, "_selectedReasonFlow", "D", "N1", "selectedReasonFlow", "Lcom/tencent/ecommerce/biz/comment/BatchUploader;", "E", "Lcom/tencent/ecommerce/biz/comment/BatchUploader;", "batchUploader", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAbortFulfillOrderViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableStateFlow<OptionValue> _selectedReasonFlow;

    /* renamed from: D, reason: from kotlin metadata */
    private final StateFlow<OptionValue> selectedReasonFlow;

    /* renamed from: E, reason: from kotlin metadata */
    private final BatchUploader batchUploader;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<a> _uiState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final StateFlow<a> uiState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a$b;", "Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a$c;", "Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a$a;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a$a;", "Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a;", "", "a", "I", "errCode", "", "b", "Ljava/lang/String;", "errMsg", "<init>", "(ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.applysample.ECAbortFulfillOrderViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1041a extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final int errCode;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final String errMsg;

            public C1041a(int i3, String str) {
                super(null);
                this.errCode = i3;
                this.errMsg = str;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a$b;", "Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class b extends a {
            public b() {
                super(null);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a$c;", "Lcom/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$a;", "Lcom/tencent/ecommerce/repo/sampleorder/a;", "a", "Lcom/tencent/ecommerce/repo/sampleorder/a;", "data", "<init>", "(Lcom/tencent/ecommerce/repo/sampleorder/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class c extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final ECAbortFulfillOption data;

            public c(ECAbortFulfillOption eCAbortFulfillOption) {
                super(null);
                this.data = eCAbortFulfillOption;
            }
        }

        a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECAbortFulfillOrderViewModel() {
        MutableStateFlow<a> MutableStateFlow = StateFlowKt.MutableStateFlow(new a.b());
        this._uiState = MutableStateFlow;
        this.uiState = MutableStateFlow;
        MutableStateFlow<OptionValue> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._selectedReasonFlow = MutableStateFlow2;
        this.selectedReasonFlow = MutableStateFlow2;
        this.batchUploader = new BatchUploader("applysample", new b(), null, null, null, 28, null);
    }

    public final StateFlow<OptionValue> N1() {
        return this.selectedReasonFlow;
    }

    public final StateFlow<a> O1() {
        return this.uiState;
    }

    public final Flow<Boolean> P1(String orderId, OptionValue reason, String desc) {
        return FlowKt.flow(new ECAbortFulfillOrderViewModel$requestAbortFulfillOrder$1(this, orderId, reason, desc, null));
    }

    public final void Q1(String oderId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new ECAbortFulfillOrderViewModel$requestAbortFulfillOrderReasonOption$1(this, oderId, null), 2, null);
    }

    public final void R1(OptionValue optionValue) {
        this._selectedReasonFlow.setValue(optionValue);
    }

    public final void S1(List<ECMediaInfo> mediaInfos) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECAbortFulfillOrderViewModel$uploadImages$1(this, mediaInfos, null), 3, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/applysample/ECAbortFulfillOrderViewModel$b", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "state", "", "onStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements UploadStateListener {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.comment.UploadStateListener
        public void onStateChanged(UploadStateListener.a state) {
        }
    }
}
