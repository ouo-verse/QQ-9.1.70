package com.tenpay.payment.qrcodehb;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tenpay.payment.qrcodehb.QrCodeHbAdapter;
import com.tenpay.sdk.util.QRCodeUtils;
import com.tenpay.sdk.util.TenpayUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\bJ\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J$\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\u0014\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0002J\u001d\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo;", "Lcom/tenpay/payment/qrcodehb/QrCodeHbAdapter$QrCodeHbViewHolder;", "context", "Landroid/content/Context;", "onDataChangeCallback", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", VideoTemplateParser.ITEM_LIST, "", "getItemCount", "getItemData", "position", "onBindViewHolder", "holder", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onCurrentListChanged", "previousList", "currentList", "setDataList", "dataList", "", "updateItem", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "updateReceiveNum", "listId", "", "receiveNum", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Companion", "QrCodeHbViewHolder", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QrCodeHbAdapter extends ListAdapter<QrCodeHbInfo, QrCodeHbViewHolder> {

    @NotNull
    private static final QrCodeHbAdapter$Companion$ITEM_CALLBACK$1 ITEM_CALLBACK = new DiffUtil.ItemCallback<QrCodeHbInfo>() { // from class: com.tenpay.payment.qrcodehb.QrCodeHbAdapter$Companion$ITEM_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull QrCodeHbInfo oldItem, @NotNull QrCodeHbInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull QrCodeHbInfo oldItem, @NotNull QrCodeHbInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem) || Intrinsics.areEqual(oldItem.getSendListId(), newItem.getSendListId());
        }
    };

    @NotNull
    private final Context context;

    @NotNull
    private List<QrCodeHbInfo> itemList;

    @NotNull
    private final Function1<Integer, Unit> onDataChangeCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbAdapter$QrCodeHbViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "qrCodeImgView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "qrCodeLength", "", "genQrCode", "", QrCodeHbFragment.KEY_IN_QR_DATA, "", "setItem", "hbInfo", "Lcom/tenpay/payment/qrcodehb/QrCodeHbInfo;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class QrCodeHbViewHolder extends RecyclerView.ViewHolder {
        private final ImageView qrCodeImgView;
        private final int qrCodeLength;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QrCodeHbViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.qrCodeImgView = (ImageView) view.findViewById(R.id.f651938_);
            this.qrCodeLength = view.getResources().getDimensionPixelOffset(R.dimen.d9i);
        }

        private final void genQrCode(String qrData) {
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(this.qrCodeImgView.getResources(), QRCodeUtils.getQRCode(TenpayUtil.genCodeUrl(qrData), null, this.qrCodeLength, -570320, -1));
            this.qrCodeImgView.post(new Runnable() { // from class: com.tenpay.payment.qrcodehb.b
                @Override // java.lang.Runnable
                public final void run() {
                    QrCodeHbAdapter.QrCodeHbViewHolder.genQrCode$lambda$1(QrCodeHbAdapter.QrCodeHbViewHolder.this, bitmapDrawable);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void genQrCode$lambda$1(QrCodeHbViewHolder this$0, BitmapDrawable drawable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(drawable, "$drawable");
            this$0.qrCodeImgView.setBackground(drawable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setItem$lambda$0(QrCodeHbViewHolder this$0, String qrData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(qrData, "$qrData");
            this$0.genQrCode(qrData);
        }

        public final void setItem(@NotNull QrCodeHbInfo hbInfo) {
            Intrinsics.checkNotNullParameter(hbInfo, "hbInfo");
            final String qrData = hbInfo.getQrData();
            if (qrData == null) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.payment.qrcodehb.a
                @Override // java.lang.Runnable
                public final void run() {
                    QrCodeHbAdapter.QrCodeHbViewHolder.setItem$lambda$0(QrCodeHbAdapter.QrCodeHbViewHolder.this, qrData);
                }
            }, 16, null, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QrCodeHbAdapter(@NotNull Context context, @NotNull Function1<? super Integer, Unit> onDataChangeCallback) {
        super(ITEM_CALLBACK);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onDataChangeCallback, "onDataChangeCallback");
        this.context = context;
        this.onDataChangeCallback = onDataChangeCallback;
        this.itemList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.itemList.size();
    }

    @Nullable
    public final QrCodeHbInfo getItemData(int position) {
        if (position >= 0 && getNUM_BACKGOURND_ICON() != 0 && position < getNUM_BACKGOURND_ICON()) {
            return this.itemList.get(position);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void onCurrentListChanged(@NotNull List<QrCodeHbInfo> previousList, @NotNull List<QrCodeHbInfo> currentList) {
        Intrinsics.checkNotNullParameter(previousList, "previousList");
        Intrinsics.checkNotNullParameter(currentList, "currentList");
        super.onCurrentListChanged(previousList, currentList);
        this.onDataChangeCallback.invoke(Integer.valueOf(currentList.size()));
    }

    public final void setDataList(@NotNull List<QrCodeHbInfo> dataList) {
        List<QrCodeHbInfo> mutableList;
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) dataList);
        this.itemList = mutableList;
        submitList(mutableList);
    }

    public final int updateItem(@NotNull QrCodeHbInfo item) {
        List mutableList;
        List mutableList2;
        List mutableList3;
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.itemList.isEmpty()) {
            this.itemList.add(item);
            mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) this.itemList);
            submitList(mutableList3);
            return 0;
        }
        Iterator<QrCodeHbInfo> it = this.itemList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getSendListId(), item.getSendListId())) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            this.itemList.remove(i3);
            this.itemList.add(i3, item);
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) this.itemList);
            submitList(mutableList2);
            return i3;
        }
        this.itemList.add(0, item);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.itemList);
        submitList(mutableList);
        return 0;
    }

    public final void updateReceiveNum(@NotNull String listId, @Nullable Integer receiveNum) {
        List mutableList;
        Object obj;
        Intrinsics.checkNotNullParameter(listId, "listId");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.itemList);
        Iterator it = mutableList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((QrCodeHbInfo) obj).getSendListId(), listId)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        QrCodeHbInfo qrCodeHbInfo = (QrCodeHbInfo) obj;
        if (qrCodeHbInfo == null) {
            return;
        }
        qrCodeHbInfo.setReceiveNum(receiveNum);
        submitList(mutableList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull QrCodeHbViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QrCodeHbInfo item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        holder.setItem(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public QrCodeHbViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.fz5, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ager_item, parent, false)");
        return new QrCodeHbViewHolder(inflate);
    }
}
