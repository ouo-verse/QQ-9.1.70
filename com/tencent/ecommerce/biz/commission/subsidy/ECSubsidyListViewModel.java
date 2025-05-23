package com.tencent.ecommerce.biz.commission.subsidy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR%\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b0\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00168\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/subsidy/ECSubsidyListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/json/JSONObject;", "W1", "", "U1", "T1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_profitList", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "profitList", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "cookie", "", "<set-?>", "D", "Z", "S1", "()Z", "isEnd", "Lkotlinx/coroutines/Job;", "E", "Lkotlinx/coroutines/Job;", "job", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubsidyListViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private String cookie;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: E, reason: from kotlin metadata */
    private Job job;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<JSONObject>> _profitList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<JSONObject>> profitList;

    public ECSubsidyListViewModel() {
        MutableLiveData<List<JSONObject>> mutableLiveData = new MutableLiveData<>();
        this._profitList = mutableLiveData;
        this.profitList = mutableLiveData;
        this.cookie = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject W1(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("subsidy_info");
        if (optJSONObject != null) {
            optJSONObject.put(WidgetCacheConstellationData.MONEY, i.f104869a.b(optJSONObject.optLong(WidgetCacheConstellationData.MONEY)));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("order_info");
        if (optJSONObject2 != null) {
            optJSONObject2.put("order_price", i.f104869a.b(optJSONObject2.optLong("order_price")));
        }
        return jSONObject;
    }

    public final LiveData<List<JSONObject>> R1() {
        return this.profitList;
    }

    /* renamed from: S1, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public final void T1() {
        Job launch$default;
        if (this.job == null && !this.isEnd) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubsidyListViewModel$loadMoreSubsidyList$1(this, null), 3, null);
            this.job = launch$default;
        } else {
            cg0.a.b("ECSubsidyListViewModel", "current state is loading or no data to load");
        }
    }

    public final void U1() {
        Job launch$default;
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSubsidyListViewModel$loadSubsidyFirstPageList$1(this, null), 3, null);
        this.job = launch$default;
    }
}
