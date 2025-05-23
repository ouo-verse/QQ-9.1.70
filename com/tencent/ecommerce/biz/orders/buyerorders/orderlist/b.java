package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECQueryType;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/b;", "Landroidx/lifecycle/AndroidViewModel;", "", WadlProxyConsts.CHANNEL, "", "scene", "", "M1", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/d;", "i", "Ljava/util/List;", "defaultTabList", "Lkotlinx/coroutines/flow/MutableStateFlow;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/flow/MutableStateFlow;", "_tabInfoListState", "Lkotlinx/coroutines/flow/StateFlow;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/StateFlow;", "L1", "()Lkotlinx/coroutines/flow/StateFlow;", "tabInfoListState", "Landroid/app/Application;", "D", "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends AndroidViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final StateFlow<List<ECOrderListTabInfo>> tabInfoListState;

    /* renamed from: D, reason: from kotlin metadata */
    public final Application context;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<ECOrderListTabInfo> defaultTabList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<List<ECOrderListTabInfo>> _tabInfoListState;

    public b(Application application) {
        super(application);
        ArrayList arrayListOf;
        this.context = application;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ECOrderListTabInfo(ECQueryType.ALL, application.getResources().getString(R.string.wgn)), new ECOrderListTabInfo(ECQueryType.UNPAID, application.getResources().getString(R.string.wgp)), new ECOrderListTabInfo(ECQueryType.UNSHIPPED, application.getResources().getString(R.string.wgr)), new ECOrderListTabInfo(ECQueryType.UNRECEIVED, application.getResources().getString(R.string.wgs)), new ECOrderListTabInfo(ECQueryType.UNCOMMENTED, application.getResources().getString(R.string.wgo)));
        this.defaultTabList = arrayListOf;
        MutableStateFlow<List<ECOrderListTabInfo>> MutableStateFlow = StateFlowKt.MutableStateFlow(arrayListOf);
        this._tabInfoListState = MutableStateFlow;
        this.tabInfoListState = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<List<ECOrderListTabInfo>> L1() {
        return this.tabInfoListState;
    }

    public final void M1(int channel, String scene) {
        List<ECOrderListTabInfo> listOf;
        if (channel == QQECChannel.CHANNEL_QQ_VIP.getId() && Intrinsics.areEqual(scene, "1")) {
            MutableStateFlow<List<ECOrderListTabInfo>> mutableStateFlow = this._tabInfoListState;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECOrderListTabInfo[]{new ECOrderListTabInfo(ECQueryType.ALL, this.context.getResources().getString(R.string.wgn)), new ECOrderListTabInfo(ECQueryType.UNSHIPPED, this.context.getResources().getString(R.string.wgr)), new ECOrderListTabInfo(ECQueryType.UNRECEIVED, this.context.getResources().getString(R.string.wgs)), new ECOrderListTabInfo(ECQueryType.RECEIVED, this.context.getResources().getString(R.string.wgq))});
            mutableStateFlow.setValue(listOf);
        }
    }
}
