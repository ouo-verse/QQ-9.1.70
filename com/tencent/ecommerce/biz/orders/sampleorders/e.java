package com.tencent.ecommerce.biz.orders.sampleorders;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.repo.sampleorder.ECApplySampleQueryType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b&\u0010'J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/e;", "Landroidx/lifecycle/AndroidViewModel;", "", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", "pageTypes", "", "N1", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/ecommerce/biz/orders/sampleorders/d;", "i", "Ljava/util/List;", "defaultTabList", "Lkotlinx/coroutines/flow/MutableStateFlow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_tabInfoListState", "Lkotlinx/coroutines/flow/StateFlow;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/StateFlow;", "M1", "()Lkotlinx/coroutines/flow/StateFlow;", "tabInfoListState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/ecommerce/biz/orders/sampleorders/e$a;", "D", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_operateEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "E", "Lkotlinx/coroutines/flow/SharedFlow;", "L1", "()Lkotlinx/coroutines/flow/SharedFlow;", "operateEvent", "Landroid/app/Application;", UserInfo.SEX_FEMALE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e extends AndroidViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final StateFlow<List<ECSampleOrderTabInfo>> tabInfoListState;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableSharedFlow<UpdatePageEvent> _operateEvent;

    /* renamed from: E, reason: from kotlin metadata */
    private final SharedFlow<UpdatePageEvent> operateEvent;

    /* renamed from: F, reason: from kotlin metadata */
    public final Application context;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<ECSampleOrderTabInfo> defaultTabList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<List<ECSampleOrderTabInfo>> _tabInfoListState;

    public e(Application application) {
        super(application);
        ArrayList arrayListOf;
        this.context = application;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ECSampleOrderTabInfo(ECApplySampleQueryType.ALL, application.getResources().getString(R.string.wgn)), new ECSampleOrderTabInfo(ECApplySampleQueryType.AUDITING, application.getResources().getString(R.string.wrv)), new ECSampleOrderTabInfo(ECApplySampleQueryType.SIGNING, application.getResources().getString(R.string.f169637ws1)), new ECSampleOrderTabInfo(ECApplySampleQueryType.FULFILLING, application.getResources().getString(R.string.wry)), new ECSampleOrderTabInfo(ECApplySampleQueryType.FULFILLED, application.getResources().getString(R.string.wrx)), new ECSampleOrderTabInfo(ECApplySampleQueryType.CANCELLED, application.getResources().getString(R.string.wrw)), new ECSampleOrderTabInfo(ECApplySampleQueryType.UNFULFILLED, application.getResources().getString(R.string.f169638ws2)));
        this.defaultTabList = arrayListOf;
        MutableStateFlow<List<ECSampleOrderTabInfo>> MutableStateFlow = StateFlowKt.MutableStateFlow(arrayListOf);
        this._tabInfoListState = MutableStateFlow;
        this.tabInfoListState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<UpdatePageEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._operateEvent = MutableSharedFlow$default;
        this.operateEvent = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    public final SharedFlow<UpdatePageEvent> L1() {
        return this.operateEvent;
    }

    public final StateFlow<List<ECSampleOrderTabInfo>> M1() {
        return this.tabInfoListState;
    }

    public final Object N1(Set<? extends ECApplySampleQueryType> set, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object emit = this._operateEvent.emit(new UpdatePageEvent(set), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return emit == coroutine_suspended ? emit : Unit.INSTANCE;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/e$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/ecommerce/repo/sampleorder/ECApplySampleQueryType;", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "pageTypes", "<init>", "(Ljava/util/Set;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.sampleorders.e$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class UpdatePageEvent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final Set<ECApplySampleQueryType> pageTypes;

        /* JADX WARN: Multi-variable type inference failed */
        public UpdatePageEvent(Set<? extends ECApplySampleQueryType> set) {
            this.pageTypes = set;
        }

        public final Set<ECApplySampleQueryType> a() {
            return this.pageTypes;
        }

        public int hashCode() {
            Set<ECApplySampleQueryType> set = this.pageTypes;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "UpdatePageEvent(pageTypes=" + this.pageTypes + ")";
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UpdatePageEvent) && Intrinsics.areEqual(this.pageTypes, ((UpdatePageEvent) other).pageTypes);
            }
            return true;
        }
    }
}
