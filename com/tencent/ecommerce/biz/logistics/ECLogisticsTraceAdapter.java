package com.tencent.ecommerce.biz.logistics;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.LogisticsTraceItem;
import com.tencent.ecommerce.biz.orders.common.TrailStatus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 #2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b!\u0010\"J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/logistics/o;", "Lcom/tencent/ecommerce/biz/logistics/n;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "getItemViewType", "Lcom/tencent/ecommerce/biz/orders/common/e;", "logisticsInfo", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "adapterItemDatas", "", "Lcom/tencent/ecommerce/biz/orders/common/TrailStatus;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "trailStatusToStatusIconResId", "D", "currentTrailStatusToStatusIconResId", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;", "E", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;", "listener", "<init>", "(Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;)V", UserInfo.SEX_FEMALE, "ActionListener", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLogisticsTraceAdapter extends RecyclerView.Adapter<o<? extends n>> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Map<TrailStatus, Integer> trailStatusToStatusIconResId;

    /* renamed from: D, reason: from kotlin metadata */
    private final Map<TrailStatus, Integer> currentTrailStatusToStatusIconResId;

    /* renamed from: E, reason: from kotlin metadata */
    private final ActionListener listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<n> adapterItemDatas = new ArrayList();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;", "", "copyToClipboard", "", "label", "", "text", "makePhoneCall", "phone", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface ActionListener {
        void copyToClipboard(String label, String text);

        void makePhoneCall(String phone);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.adapterItemDatas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.adapterItemDatas.get(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(o<? extends n> holder, int position) {
        holder.l(this.adapterItemDatas.get(position));
    }

    public ECLogisticsTraceAdapter(ActionListener actionListener) {
        Map<TrailStatus, Integer> mapOf;
        Map<TrailStatus, Integer> mapOf2;
        this.listener = actionListener;
        TrailStatus trailStatus = TrailStatus.SIGNED;
        Integer valueOf = Integer.valueOf(R.drawable.e6v);
        TrailStatus trailStatus2 = TrailStatus.ON_THE_WAY;
        TrailStatus trailStatus3 = TrailStatus.PICKED_UP;
        TrailStatus trailStatus4 = TrailStatus.SHIPPED;
        TrailStatus trailStatus5 = TrailStatus.PLACE_ORDER;
        TrailStatus trailStatus6 = TrailStatus.WRONG;
        Integer valueOf2 = Integer.valueOf(R.drawable.dsp);
        TrailStatus trailStatus7 = TrailStatus.WAITING_RECEIVE;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(trailStatus, valueOf), TuplesKt.to(trailStatus2, Integer.valueOf(R.drawable.er5)), TuplesKt.to(trailStatus3, Integer.valueOf(R.drawable.eqr)), TuplesKt.to(trailStatus4, Integer.valueOf(R.drawable.eqm)), TuplesKt.to(trailStatus5, Integer.valueOf(R.drawable.er8)), TuplesKt.to(trailStatus6, valueOf2), TuplesKt.to(trailStatus7, Integer.valueOf(R.drawable.eqv)));
        this.trailStatusToStatusIconResId = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(trailStatus, valueOf), TuplesKt.to(trailStatus2, Integer.valueOf(R.drawable.er6)), TuplesKt.to(trailStatus3, Integer.valueOf(R.drawable.equ)), TuplesKt.to(trailStatus4, Integer.valueOf(R.drawable.eqn)), TuplesKt.to(trailStatus5, Integer.valueOf(R.drawable.ert)), TuplesKt.to(trailStatus6, valueOf2), TuplesKt.to(trailStatus7, Integer.valueOf(R.drawable.eqx)));
        this.currentTrailStatusToStatusIconResId = mapOf2;
    }

    public final void k0(LogisticsInfo logisticsInfo) {
        ReceiverAddressData receiverAddressData;
        Integer num;
        this.adapterItemDatas.clear();
        ShipStatusData shipStatusData = new ShipStatusData(0, logisticsInfo.code, logisticsInfo.shipperCompany, logisticsInfo.packageInfo, logisticsInfo.currentStatus, 1, null);
        this.adapterItemDatas.add(shipStatusData);
        if (logisticsInfo.currentStatus.status == TrailStatus.SIGNED) {
            receiverAddressData = new ReceiverAddressData(0, logisticsInfo.receiverAddress, R.drawable.f159718er1, R.color.f6942x, 1, null);
        } else {
            receiverAddressData = new ReceiverAddressData(0, logisticsInfo.receiverAddress, R.drawable.eqz, R.color.f6962z, 1, null);
        }
        this.adapterItemDatas.add(receiverAddressData);
        TrailStatus trailStatus = TrailStatus.NO_MSG;
        int i3 = 0;
        for (Object obj : logisticsInfo.f()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            LogisticsTraceItem logisticsTraceItem = (LogisticsTraceItem) obj;
            TrailStatus trailStatus2 = logisticsTraceItem.status;
            int i17 = R.drawable.bub;
            if (trailStatus2 == trailStatus) {
                this.adapterItemDatas.add(new ShipDetailItemData(0, logisticsTraceItem.acceptTime, logisticsTraceItem.acceptStation, "", R.drawable.bub, R.color.f6962z, 1, null));
                if (i3 == 0 && logisticsInfo.channel == QQECChannel.CHANNEL_QQ_VIP.getId()) {
                    shipStatusData.packageInfo.statusIconResId = R.drawable.bub;
                }
                i3 = i16;
            } else {
                boolean z16 = trailStatus2 == logisticsInfo.currentStatus.status;
                if (z16) {
                    num = this.currentTrailStatusToStatusIconResId.get(trailStatus2);
                } else {
                    num = this.trailStatusToStatusIconResId.get(trailStatus2);
                }
                if (num != null) {
                    i17 = num.intValue();
                }
                this.adapterItemDatas.add(new ShipDetailItemData(0, logisticsTraceItem.acceptTime, logisticsTraceItem.acceptStation, logisticsTraceItem.statusDesc, i17, z16 ? R.color.f6942x : R.color.f6962z, 1, null));
                if (i3 == 0 && logisticsInfo.channel == QQECChannel.CHANNEL_QQ_VIP.getId()) {
                    shipStatusData.packageInfo.statusIconResId = i17;
                }
                i3 = i16;
                trailStatus = trailStatus2;
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public o<n> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new r(LayoutInflater.from(parent.getContext()).inflate(R.layout.f167339cs2, parent, false), this.listener);
        }
        if (viewType != 1) {
            return new q(LayoutInflater.from(parent.getContext()).inflate(R.layout.crz, parent, false), this.listener);
        }
        return new p(LayoutInflater.from(parent.getContext()).inflate(R.layout.f167338cs1, parent, false));
    }
}
