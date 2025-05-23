package com.tencent.ecommerce.biz.commission.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.commission.detail.ECCommissionItemFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import sj0.ECBillModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010<\u001a\u000209\u00a2\u0006\u0004\b=\u0010>J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J \u0010\f\u001a\u00020\u00072\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u0004J \u0010\r\u001a\u00020\u00072\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u0004J=\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR#\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010)\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u001eR\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0006\u00a2\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010$R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\u001eR\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00150\u001c8\u0006\u00a2\u0006\f\n\u0004\b1\u0010\u001e\u001a\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006A"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemViewModel;", "Landroidx/lifecycle/ViewModel;", "Lsj0/a;", "data", "", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "W1", "", "d2", "Lkotlin/Pair;", "", "list", "b2", "Z1", "cookie", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "token", "c2", "i", "Ljava/lang/String;", "", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "X1", "()Z", "isEnd", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_billsList", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "billsList", "E", "S1", "()Ljava/lang/String;", "noticeString", UserInfo.SEX_FEMALE, "_taxLink", "G", "U1", "taxLink", "H", "_showLoadingDialog", "I", "T1", "()Landroidx/lifecycle/MutableLiveData;", "showLoadingDialog", "Lkotlinx/coroutines/Job;", "J", "Lkotlinx/coroutines/Job;", "job", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;", "K", "Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;", "type", "<init>", "(Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionItemFragment$TYPE;)V", "L", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionItemViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<ECBill>> _billsList;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<List<ECBill>> billsList;

    /* renamed from: E, reason: from kotlin metadata */
    private String noticeString;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<String> _taxLink;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<String> taxLink;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _showLoadingDialog;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> showLoadingDialog;

    /* renamed from: J, reason: from kotlin metadata */
    private Job job;

    /* renamed from: K, reason: from kotlin metadata */
    private final ECCommissionItemFragment.TYPE type;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String cookie = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    public ECCommissionItemViewModel(ECCommissionItemFragment.TYPE type) {
        this.type = type;
        MutableLiveData<List<ECBill>> mutableLiveData = new MutableLiveData<>();
        this._billsList = mutableLiveData;
        this.billsList = mutableLiveData;
        this.noticeString = "";
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._taxLink = mutableLiveData2;
        this.taxLink = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._showLoadingDialog = mutableLiveData3;
        this.showLoadingDialog = mutableLiveData3;
    }

    private final List<ECBill> W1(ECBillModel data) {
        int collectionSizeOrDefault;
        this.cookie = data.cookie;
        this.isEnd = data.isEnd;
        this.noticeString = data.getNotice();
        List<JSONObject> b16 = data.b();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (JSONObject jSONObject : b16) {
            arrayList.add(new ECBill(jSONObject.optString("id"), jSONObject.toString()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2() {
        i.f101155b.d(wg0.a.a().getText(R.string.wo_), ECToastIcon.ICON_ERROR, 0);
    }

    public final LiveData<List<ECBill>> R1() {
        return this.billsList;
    }

    /* renamed from: S1, reason: from getter */
    public final String getNoticeString() {
        return this.noticeString;
    }

    public final MutableLiveData<Boolean> T1() {
        return this.showLoadingDialog;
    }

    public final LiveData<String> U1() {
        return this.taxLink;
    }

    /* renamed from: X1, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public final void Z1(List<Pair<String, String>> list) {
        Job launch$default;
        if (this.job == null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECCommissionItemViewModel$loadMoreBills$1(this, list, null), 3, null);
            this.job = launch$default;
        } else {
            cg0.a.b("ECCommissionItemViewModel", "is requesting data, so wait a moment");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object a2(String str, List<Pair<String, String>> list, Continuation<? super List<ECBill>> continuation) {
        ECCommissionItemViewModel$requestBills$1 eCCommissionItemViewModel$requestBills$1;
        Object coroutine_suspended;
        int i3;
        ECCommissionItemViewModel eCCommissionItemViewModel;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECCommissionItemViewModel$requestBills$1) {
            eCCommissionItemViewModel$requestBills$1 = (ECCommissionItemViewModel$requestBills$1) continuation;
            int i16 = eCCommissionItemViewModel$requestBills$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCCommissionItemViewModel$requestBills$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCCommissionItemViewModel$requestBills$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCCommissionItemViewModel$requestBills$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    int i17 = d.f101468a[this.type.ordinal()];
                    if (i17 == 1) {
                        rj0.a aVar = rj0.a.f431541a;
                        eCCommissionItemViewModel$requestBills$1.L$0 = this;
                        eCCommissionItemViewModel$requestBills$1.label = 1;
                        obj = aVar.d(str, list, eCCommissionItemViewModel$requestBills$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        eCCommissionItemViewModel = this;
                        eCNetworkResponse = (ECNetworkResponse) obj;
                    } else if (i17 == 2) {
                        rj0.a aVar2 = rj0.a.f431541a;
                        eCCommissionItemViewModel$requestBills$1.L$0 = this;
                        eCCommissionItemViewModel$requestBills$1.label = 2;
                        obj = aVar2.c(str, list, eCCommissionItemViewModel$requestBills$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        eCCommissionItemViewModel = this;
                        eCNetworkResponse = (ECNetworkResponse) obj;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else if (i3 == 1) {
                    eCCommissionItemViewModel = (ECCommissionItemViewModel) eCCommissionItemViewModel$requestBills$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    eCNetworkResponse = (ECNetworkResponse) obj;
                } else if (i3 == 2) {
                    eCCommissionItemViewModel = (ECCommissionItemViewModel) eCCommissionItemViewModel$requestBills$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    eCNetworkResponse = (ECNetworkResponse) obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECBillModel eCBillModel = (ECBillModel) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0 && eCBillModel != null) {
                    return eCCommissionItemViewModel.W1(eCBillModel);
                }
                cg0.a.a("ECCommissionItemViewModel", "requestBills", "errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCCommissionItemViewModel$requestBills$1 = new ECCommissionItemViewModel$requestBills$1(this, continuation);
        Object obj2 = eCCommissionItemViewModel$requestBills$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCCommissionItemViewModel$requestBills$1.label;
        if (i3 != 0) {
        }
        ECBillModel eCBillModel2 = (ECBillModel) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() != 0) {
        }
        cg0.a.a("ECCommissionItemViewModel", "requestBills", "errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return null;
    }

    public final void b2(List<Pair<String, String>> list) {
        Job launch$default;
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECCommissionItemViewModel$requestFirstPageBills$1(this, list, null), 3, null);
        this.job = launch$default;
    }

    public final void c2(String token) {
        this._showLoadingDialog.setValue(Boolean.TRUE);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECCommissionItemViewModel$requestTaxLink$1(this, token, wg0.a.a().getText(R.string.f169599wi4), null), 3, null);
    }
}
