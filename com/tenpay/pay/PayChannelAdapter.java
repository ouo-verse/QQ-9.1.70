package com.tenpay.pay;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.pay.PayChannelUtils;
import com.tenpay.pay.PayTypeItemViewHolder;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.pay.model.SelectedPayChannelBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 <2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002<=B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0006\u0010\u001b\u001a\u00020\fJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0016Jp\u0010#\u001a\u00020\u001d2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00162\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00162\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\b\b\u0002\u00104\u001a\u00020\fJ\u000e\u00105\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\fJ\u0016\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u0016\u00108\u001a\u00020\u001d2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J(\u0010:\u001a\u00020\u001d2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\fH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/tenpay/pay/PayChannelAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tenpay/pay/model/PayChannelBean;", "Lcom/tenpay/pay/PayTypeItemViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", "listener", "Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;", "(Landroidx/fragment/app/Fragment;Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "isCurrentCollapseMode", "", "getListener", "()Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;", "<set-?>", "selectedChannel", "getSelectedChannel", "()Lcom/tenpay/pay/model/PayChannelBean;", "totalPayChannel", "", "filterCollapseMode", "", "filterExpandMode", "getItemViewType", "", "position", "hasAnyChannelCanUse", "onBindViewHolder", "", "holder", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setData", "qqChannelHeader", "Lcom/tenpay/pay/model/PayChannelBean$QQHeader;", "balanceChannel", "Lcom/tenpay/pay/model/PayChannelBean$Balance;", "bankList", "Lcom/tenpay/pay/model/PayChannelBean$Bank;", "wxChannel", "Lcom/tenpay/pay/model/PayChannelBean$Wx;", "addMoreChannel", "Lcom/tenpay/pay/model/PayChannelBean$AddMore;", "friendPay", "Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "autoPayList", "Lcom/tenpay/pay/model/PayChannelBean$AutoPayCard;", "recommendSelected", "Lcom/tenpay/pay/model/SelectedPayChannelBean;", "isCollapseMode", "setMode", "setSelectedChannel", "payChannelBean", "updateBgRound", "payChannelList", "updateDefaultSelectedChannel", "finalList", "Companion", "EnumPayChannelItemType", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayChannelAdapter extends ListAdapter<PayChannelBean, PayTypeItemViewHolder> {
    private static final int ADD_WITH_MAX_BANK_VISIBLE_IN_COLLAPSE_COUNT = 2;

    @NotNull
    private static final PayChannelAdapter$Companion$ITEM_CALLBACK$1 ITEM_CALLBACK = new DiffUtil.ItemCallback<PayChannelBean>() { // from class: com.tenpay.pay.PayChannelAdapter$Companion$ITEM_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull PayChannelBean oldItem, @NotNull PayChannelBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem == newItem;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull PayChannelBean oldItem, @NotNull PayChannelBean newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private static final int MAX_CAN_CHECK_VISIBLE_IN_COLLAPSE_COUNT = 3;

    @NotNull
    private static final String TAG = "CFT-sdk-PayChannelAdapter";

    @NotNull
    private final Fragment fragment;
    private boolean isCurrentCollapseMode;

    @NotNull
    private final PayTypeItemViewHolder.IPayChannelItemClickListener listener;

    @Nullable
    private PayChannelBean selectedChannel;

    @NotNull
    private final List<PayChannelBean> totalPayChannel;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tenpay/pay/PayChannelAdapter$EnumPayChannelItemType;", "", "(Ljava/lang/String;I)V", "QQHeader", "Balance", "AutoPayCard", "Bank", "FriendPay", "BalanceDisable", "AutoPayCardDisable", "BankDisable", "AddMore", "More", "Wx", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum EnumPayChannelItemType {
        QQHeader,
        Balance,
        AutoPayCard,
        Bank,
        FriendPay,
        BalanceDisable,
        AutoPayCardDisable,
        BankDisable,
        AddMore,
        More,
        Wx
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayChannelAdapter(@NotNull Fragment fragment, @NotNull PayTypeItemViewHolder.IPayChannelItemClickListener listener) {
        super(ITEM_CALLBACK);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.fragment = fragment;
        this.listener = listener;
        this.totalPayChannel = new ArrayList();
        this.isCurrentCollapseMode = true;
    }

    private final List<PayChannelBean> filterCollapseMode() {
        Object obj;
        Object obj2;
        boolean z16;
        boolean z17;
        boolean z18 = true;
        this.isCurrentCollapseMode = true;
        List<PayChannelBean> list = this.totalPayChannel;
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : list) {
            if (((PayChannelBean) obj3).getIsCheck()) {
                arrayList.add(obj3);
            }
        }
        if (arrayList.size() > 3) {
            int i3 = 0;
            for (Object obj4 : arrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                PayChannelBean payChannelBean = (PayChannelBean) obj4;
                if (i3 < 3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                payChannelBean.setVisible(z17);
                i3 = i16;
            }
        }
        List<PayChannelBean> list2 = this.totalPayChannel;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj5 : list2) {
            if (obj5 instanceof PayChannelBean.Bank) {
                arrayList2.add(obj5);
            }
        }
        int size = arrayList2.size();
        Iterator<T> it = this.totalPayChannel.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (((PayChannelBean) obj2) instanceof PayChannelBean.More) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        PayChannelBean payChannelBean2 = (PayChannelBean) obj2;
        if (payChannelBean2 != null) {
            if (size > 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            payChannelBean2.setVisible(z16);
        }
        Iterator<T> it5 = this.totalPayChannel.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((PayChannelBean) next) instanceof PayChannelBean.AddMore) {
                obj = next;
                break;
            }
        }
        PayChannelBean payChannelBean3 = (PayChannelBean) obj;
        if (payChannelBean3 != null) {
            if (size > 2) {
                z18 = false;
            }
            payChannelBean3.setVisible(z18);
        }
        List<PayChannelBean> list3 = this.totalPayChannel;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj6 : list3) {
            if (((PayChannelBean) obj6).getVisible()) {
                arrayList3.add(obj6);
            }
        }
        return arrayList3;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final List<PayChannelBean> filterExpandMode() {
        Object obj;
        Object obj2;
        this.isCurrentCollapseMode = false;
        List<PayChannelBean> list = this.totalPayChannel;
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : list) {
            if (((PayChannelBean) obj3).getIsCheck()) {
                arrayList.add(obj3);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PayChannelBean) it.next()).setVisible(true);
        }
        Iterator<T> it5 = this.totalPayChannel.iterator();
        while (true) {
            obj = null;
            if (it5.hasNext()) {
                obj2 = it5.next();
                if (((PayChannelBean) obj2) instanceof PayChannelBean.More) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        PayChannelBean payChannelBean = (PayChannelBean) obj2;
        if (payChannelBean != null) {
            payChannelBean.setVisible(false);
        }
        Iterator<T> it6 = this.totalPayChannel.iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            Object next = it6.next();
            if (((PayChannelBean) next) instanceof PayChannelBean.AddMore) {
                obj = next;
                break;
            }
        }
        PayChannelBean payChannelBean2 = (PayChannelBean) obj;
        if (payChannelBean2 != null) {
            payChannelBean2.setVisible(true);
        }
        List<PayChannelBean> list2 = this.totalPayChannel;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj4 : list2) {
            if (((PayChannelBean) obj4).getVisible()) {
                arrayList2.add(obj4);
            }
        }
        return arrayList2;
    }

    public static /* synthetic */ void setData$default(PayChannelAdapter payChannelAdapter, PayChannelBean.QQHeader qQHeader, PayChannelBean.Balance balance, List list, PayChannelBean.Wx wx5, PayChannelBean.AddMore addMore, PayChannelBean.FriendPay friendPay, List list2, SelectedPayChannelBean selectedPayChannelBean, boolean z16, int i3, Object obj) {
        PayChannelBean.QQHeader qQHeader2;
        PayChannelBean.Wx wx6;
        PayChannelBean.FriendPay friendPay2;
        List list3;
        SelectedPayChannelBean selectedPayChannelBean2;
        boolean z17;
        if ((i3 & 1) != 0) {
            qQHeader2 = null;
        } else {
            qQHeader2 = qQHeader;
        }
        if ((i3 & 8) != 0) {
            wx6 = null;
        } else {
            wx6 = wx5;
        }
        if ((i3 & 32) != 0) {
            friendPay2 = null;
        } else {
            friendPay2 = friendPay;
        }
        if ((i3 & 64) != 0) {
            list3 = null;
        } else {
            list3 = list2;
        }
        if ((i3 & 128) != 0) {
            selectedPayChannelBean2 = null;
        } else {
            selectedPayChannelBean2 = selectedPayChannelBean;
        }
        if ((i3 & 256) != 0) {
            z17 = payChannelAdapter.isCurrentCollapseMode;
        } else {
            z17 = z16;
        }
        payChannelAdapter.setData(qQHeader2, balance, list, wx6, addMore, friendPay2, list3, selectedPayChannelBean2, z17);
    }

    private final void updateBgRound(List<? extends PayChannelBean> payChannelList) {
        Object obj;
        List<? extends PayChannelBean> list = payChannelList;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((PayChannelBean) obj) instanceof PayChannelBean.Wx) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        PayChannelBean payChannelBean = (PayChannelBean) obj;
        if (payChannelBean != null) {
            payChannelBean.setBgRadiusEnum(PayChannelUtils.BgRadiusEnum.BothRound);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (true ^ (((PayChannelBean) obj2) instanceof PayChannelBean.Wx)) {
                arrayList.add(obj2);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        if (size == 1) {
            ((PayChannelBean) arrayList.get(0)).setBgRadiusEnum(PayChannelUtils.BgRadiusEnum.BothRound);
            return;
        }
        for (Object obj3 : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            PayChannelBean payChannelBean2 = (PayChannelBean) obj3;
            if (i3 == 0) {
                payChannelBean2.setBgRadiusEnum(PayChannelUtils.BgRadiusEnum.TopRound);
            } else if (i3 == size - 1) {
                payChannelBean2.setBgRadiusEnum(PayChannelUtils.BgRadiusEnum.BottomRound);
            } else {
                payChannelBean2.setBgRadiusEnum(PayChannelUtils.BgRadiusEnum.NONE);
            }
            i3 = i16;
        }
    }

    private final void updateDefaultSelectedChannel(List<PayChannelBean> finalList, SelectedPayChannelBean recommendSelected, boolean isCollapseMode) {
        int i3;
        boolean z16;
        Object firstOrNull;
        PayChannelBean payChannelBean;
        if (recommendSelected == null) {
            return;
        }
        Object obj = null;
        if (recommendSelected.getPayType() == 0) {
            Iterator<T> it = finalList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((PayChannelBean) next) instanceof PayChannelBean.Balance) {
                    obj = next;
                    break;
                }
            }
            this.selectedChannel = (PayChannelBean) obj;
            return;
        }
        if (recommendSelected.getPayType() == 5) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : finalList) {
                if (obj2 instanceof PayChannelBean.AutoPayCard) {
                    arrayList.add(obj2);
                }
            }
            if (arrayList.size() <= recommendSelected.getBankIndex()) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                payChannelBean = (PayChannelBean) firstOrNull;
            } else {
                payChannelBean = (PayChannelBean) arrayList.get(recommendSelected.getBankIndex());
            }
            this.selectedChannel = payChannelBean;
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : finalList) {
            if (obj3 instanceof PayChannelBean.Bank) {
                arrayList2.add(obj3);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (true) {
            i3 = 0;
            if (!it5.hasNext()) {
                break;
            }
            Object next2 = it5.next();
            PayChannelBean.Bank bank = (PayChannelBean.Bank) next2;
            if (Intrinsics.areEqual(bank.getCardTail(), recommendSelected.getCardTail()) && Intrinsics.areEqual(bank.getBindSerial(), recommendSelected.getBindSerial()) && Intrinsics.areEqual(bank.getBankType(), recommendSelected.getBankType())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next2;
                break;
            }
        }
        PayChannelBean.Bank bank2 = (PayChannelBean.Bank) obj;
        if (bank2 == null) {
            return;
        }
        this.selectedChannel = bank2;
        if (!isCollapseMode) {
            return;
        }
        int indexOf = arrayList2.indexOf(bank2);
        if (indexOf < 0) {
            QLog.w(TAG, 1, "not found targetPayChannel: " + bank2);
            return;
        }
        if (indexOf == 0) {
            QLog.d(TAG, 1, "selected is first");
            return;
        }
        finalList.remove(bank2);
        Iterator<PayChannelBean> it6 = finalList.iterator();
        while (true) {
            if (it6.hasNext()) {
                if (it6.next() instanceof PayChannelBean.Bank) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        finalList.add(i3, bank2);
        QLog.d(TAG, 1, "selected channel: " + bank2 + " position=" + i3);
    }

    @NotNull
    public final Fragment getFragment() {
        return this.fragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getSortPriority();
    }

    @NotNull
    public final PayTypeItemViewHolder.IPayChannelItemClickListener getListener() {
        return this.listener;
    }

    @Nullable
    public final PayChannelBean getSelectedChannel() {
        return this.selectedChannel;
    }

    public final boolean hasAnyChannelCanUse() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Integer disable;
        boolean z26;
        boolean z27;
        Integer disable2;
        List<PayChannelBean> list = this.totalPayChannel;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (PayChannelBean payChannelBean : list) {
                if ((payChannelBean instanceof PayChannelBean.Balance) && ((PayChannelBean.Balance) payChannelBean).canUse()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (z17) {
            return true;
        }
        List<PayChannelBean> list2 = this.totalPayChannel;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            for (PayChannelBean payChannelBean2 : list2) {
                if ((payChannelBean2 instanceof PayChannelBean.Bank) && (disable = ((PayChannelBean.Bank) payChannelBean2).getDisable()) != null && disable.intValue() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z19 = true;
                    break;
                }
            }
        }
        z19 = false;
        if (z19) {
            return true;
        }
        List<PayChannelBean> list3 = this.totalPayChannel;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            for (PayChannelBean payChannelBean3 : list3) {
                if ((payChannelBean3 instanceof PayChannelBean.AutoPayCard) && (disable2 = ((PayChannelBean.AutoPayCard) payChannelBean3).getDisable()) != null && disable2.intValue() == 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    z27 = true;
                    break;
                }
            }
        }
        z27 = false;
        if (z27) {
            return true;
        }
        return false;
    }

    public final void setData(@Nullable PayChannelBean.QQHeader qqChannelHeader, @NotNull PayChannelBean.Balance balanceChannel, @NotNull List<PayChannelBean.Bank> bankList, @Nullable PayChannelBean.Wx wxChannel, @NotNull PayChannelBean.AddMore addMoreChannel, @Nullable PayChannelBean.FriendPay friendPay, @Nullable List<PayChannelBean.AutoPayCard> autoPayList, @Nullable SelectedPayChannelBean recommendSelected, boolean isCollapseMode) {
        List sortedWith;
        int ordinal;
        int ordinal2;
        int ordinal3;
        Intrinsics.checkNotNullParameter(balanceChannel, "balanceChannel");
        Intrinsics.checkNotNullParameter(bankList, "bankList");
        Intrinsics.checkNotNullParameter(addMoreChannel, "addMoreChannel");
        ArrayList arrayList = new ArrayList();
        if (qqChannelHeader != null) {
            qqChannelHeader.setSortPriority(EnumPayChannelItemType.QQHeader.ordinal());
            arrayList.add(qqChannelHeader);
        }
        for (PayChannelBean.Bank bank : bankList) {
            bank.setCheck(true);
            Integer disable = bank.getDisable();
            if (disable != null && disable.intValue() == 0) {
                ordinal3 = EnumPayChannelItemType.Bank.ordinal();
            } else {
                ordinal3 = EnumPayChannelItemType.BankDisable.ordinal();
            }
            bank.setSortPriority(ordinal3);
        }
        arrayList.addAll(bankList);
        if (Intrinsics.areEqual(balanceChannel.getHasRealName(), Boolean.TRUE)) {
            balanceChannel.setCheck(true);
            if (balanceChannel.canUse()) {
                ordinal2 = EnumPayChannelItemType.Balance.ordinal();
            } else {
                ordinal2 = EnumPayChannelItemType.BalanceDisable.ordinal();
            }
            balanceChannel.setSortPriority(ordinal2);
            arrayList.add(balanceChannel);
        }
        if (autoPayList != null) {
            for (PayChannelBean.AutoPayCard autoPayCard : autoPayList) {
                autoPayCard.setCheck(true);
                Integer disable2 = autoPayCard.getDisable();
                if (disable2 != null && disable2.intValue() == 0) {
                    ordinal = EnumPayChannelItemType.AutoPayCard.ordinal();
                } else {
                    ordinal = EnumPayChannelItemType.AutoPayCardDisable.ordinal();
                }
                autoPayCard.setSortPriority(ordinal);
            }
            arrayList.addAll(autoPayList);
        }
        if (friendPay != null) {
            if (!friendPay.canUse()) {
                friendPay = null;
            }
            if (friendPay != null) {
                friendPay.setSortPriority(EnumPayChannelItemType.FriendPay.ordinal());
                arrayList.add(friendPay);
            }
        }
        if (!(!addMoreChannel.getDisable())) {
            addMoreChannel = null;
        }
        if (addMoreChannel != null) {
            addMoreChannel.setSortPriority(EnumPayChannelItemType.AddMore.ordinal());
            arrayList.add(addMoreChannel);
        }
        PayChannelBean.More more = new PayChannelBean.More(R.drawable.dvp, "\u67e5\u770b\u5168\u90e8");
        more.setSortPriority(EnumPayChannelItemType.More.ordinal());
        arrayList.add(more);
        if (wxChannel != null) {
            wxChannel.setSortPriority(EnumPayChannelItemType.Wx.ordinal());
            arrayList.add(wxChannel);
        }
        updateDefaultSelectedChannel(arrayList, recommendSelected, isCollapseMode);
        QLog.i(TAG, 1, "selectedChannel: " + this.selectedChannel);
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.tenpay.pay.PayChannelAdapter$setData$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((PayChannelBean) t16).getSortPriority()), Integer.valueOf(((PayChannelBean) t17).getSortPriority()));
                return compareValues;
            }
        });
        this.totalPayChannel.clear();
        this.totalPayChannel.addAll(sortedWith);
        setMode(isCollapseMode);
    }

    public final void setMode(boolean isCollapseMode) {
        List<PayChannelBean> filterExpandMode;
        Iterator<T> it = this.totalPayChannel.iterator();
        while (it.hasNext()) {
            ((PayChannelBean) it.next()).setVisible(true);
        }
        if (isCollapseMode) {
            filterExpandMode = filterCollapseMode();
        } else {
            filterExpandMode = filterExpandMode();
        }
        if (QLog.isColorLevel()) {
            Iterator<T> it5 = filterExpandMode.iterator();
            while (it5.hasNext()) {
                QLog.i(TAG, 1, "print payChannel: " + ((PayChannelBean) it5.next()));
            }
        }
        updateBgRound(filterExpandMode);
        submitList(filterExpandMode);
    }

    public final void setSelectedChannel(@NotNull PayChannelBean payChannelBean, int position) {
        Intrinsics.checkNotNullParameter(payChannelBean, "payChannelBean");
        int indexOf = getCurrentList().indexOf(this.selectedChannel);
        if (indexOf != -1) {
            notifyItemChanged(indexOf);
        }
        this.selectedChannel = payChannelBean;
        notifyItemChanged(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull PayTypeItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PayChannelBean item = getItem(position);
        PayChannelBean item2 = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item2, "getItem(position)");
        holder.setData(item2, Intrinsics.areEqual(item, this.selectedChannel), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public PayTypeItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        int i3;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == EnumPayChannelItemType.Wx.ordinal()) {
            i3 = R.layout.fyy;
        } else {
            i3 = viewType == EnumPayChannelItemType.More.ordinal() ? R.layout.fyx : R.layout.fyw;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(i3, parent, false);
        Fragment fragment = this.fragment;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new PayTypeItemViewHolder(fragment, view, this.listener);
    }
}
