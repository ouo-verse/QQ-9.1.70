package com.tencent.ecommerce.biz.commission.subsidy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.commission.detail.ECBill;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import sj0.ECBillModel;
import tj0.ECSubsidyIncomeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b8\u00109J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR%\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001bR\u001f\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u001d8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0\u001d8\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010!R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010\u001bR\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u00198\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u001b\u001a\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyOverviewViewModel;", "Landroidx/lifecycle/ViewModel;", "Lsj0/a;", "data", "", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "Z1", "", "f2", "d2", "b2", "c2", "", "token", "e2", "i", "Ljava/lang/String;", "cookie", "", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Z", "isEnd", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_paidBills", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "U1", "()Landroidx/lifecycle/LiveData;", "paidBills", "Ltj0/b;", "E", "_overviewIncomeInfo", UserInfo.SEX_FEMALE, "T1", "overviewIncomeInfo", "G", "_taxLink", "H", "X1", "taxLink", "I", "_showLoadingDialog", "J", "W1", "()Landroidx/lifecycle/MutableLiveData;", "showLoadingDialog", "Lkotlinx/coroutines/Job;", "K", "Lkotlinx/coroutines/Job;", "job", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubsidyOverviewViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<ECBill>> _paidBills;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<List<ECBill>> paidBills;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<ECSubsidyIncomeInfo> _overviewIncomeInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<ECSubsidyIncomeInfo> overviewIncomeInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<String> _taxLink;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<String> taxLink;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _showLoadingDialog;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> showLoadingDialog;

    /* renamed from: K, reason: from kotlin metadata */
    private Job job;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String cookie = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    public ECSubsidyOverviewViewModel() {
        MutableLiveData<List<ECBill>> mutableLiveData = new MutableLiveData<>();
        this._paidBills = mutableLiveData;
        this.paidBills = mutableLiveData;
        MutableLiveData<ECSubsidyIncomeInfo> mutableLiveData2 = new MutableLiveData<>();
        this._overviewIncomeInfo = mutableLiveData2;
        this.overviewIncomeInfo = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this._taxLink = mutableLiveData3;
        this.taxLink = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._showLoadingDialog = mutableLiveData4;
        this.showLoadingDialog = mutableLiveData4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECBill> Z1(ECBillModel data) {
        int collectionSizeOrDefault;
        this.cookie = data.cookie;
        this.isEnd = data.isEnd;
        List<JSONObject> b16 = data.b();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (JSONObject jSONObject : b16) {
            arrayList.add(new ECBill(jSONObject.optString("id"), jSONObject.toString()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2() {
        i.f101155b.d(wg0.a.a().getText(R.string.wo_), ECToastIcon.ICON_ERROR, 0);
    }

    public final LiveData<ECSubsidyIncomeInfo> T1() {
        return this.overviewIncomeInfo;
    }

    public final LiveData<List<ECBill>> U1() {
        return this.paidBills;
    }

    public final MutableLiveData<Boolean> W1() {
        return this.showLoadingDialog;
    }

    public final LiveData<String> X1() {
        return this.taxLink;
    }

    /* renamed from: a2, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public final void b2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubsidyOverviewViewModel$loadFirstPagePaidBillList$1(this, null), 3, null);
    }

    public final void c2() {
        Job launch$default;
        if (this.job != null || this.isEnd) {
            return;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubsidyOverviewViewModel$loadMorePaidBillList$1(this, null), 3, null);
        this.job = launch$default;
    }

    public final void d2() {
        Job launch$default;
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1(this, null), 3, null);
        this.job = launch$default;
    }

    public final void e2(String token) {
        this._showLoadingDialog.setValue(Boolean.TRUE);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubsidyOverviewViewModel$requestTaxLink$1(this, token, wg0.a.a().getText(R.string.f169599wi4), null), 3, null);
    }
}
