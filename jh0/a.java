package jh0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.ECAfterSaleApplyExtraHolder;
import com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.c;
import com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.f;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyEntryItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ItemType;
import com.tencent.ecommerce.repo.aftersale.apply.item.d;
import com.tencent.ecommerce.repo.aftersale.apply.item.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010;\u001a\u000204\u00a2\u0006\u0004\b<\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u001e\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R6\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0004\u0018\u0001`\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR<\u0010(\u001a\u001c\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001ej\u0004\u0018\u0001`!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R<\u0010.\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0004\u0018\u0001`*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR&\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00030/j\b\u0012\u0004\u0012\u00020\u0003`08\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Ljh0/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/b;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "", VideoTemplateParser.ITEM_LIST, "", "o0", "", "position", "i0", "setData", "getItemCount", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k0", "holder", "j0", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/b;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/EntryClick;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "getEntryClick", "()Lkotlin/jvm/functions/Function1;", "l0", "(Lkotlin/jvm/functions/Function1;)V", "entryClick", "Lkotlin/Function2;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/e;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/d;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/OptionClick;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "getOptionClick", "()Lkotlin/jvm/functions/Function2;", "n0", "(Lkotlin/jvm/functions/Function2;)V", "optionClick", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/MediaListener;", "D", "getMediaListener", "m0", "mediaListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "applyItemList", "Landroidx/fragment/app/FragmentActivity;", UserInfo.SEX_FEMALE, "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "G", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a extends RecyclerView.Adapter<com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.b<d>> {

    /* renamed from: C, reason: from kotlin metadata */
    private Function2<? super e, ? super com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.d, Unit> optionClick;

    /* renamed from: D, reason: from kotlin metadata */
    private Function1<? super List<ECMediaInfo>, Unit> mediaListener;

    /* renamed from: E, reason: from kotlin metadata */
    private ArrayList<d> applyItemList = new ArrayList<>();

    /* renamed from: F, reason: from kotlin metadata */
    private FragmentActivity activity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ECAfterSaleApplyEntryItem, Unit> entryClick;

    public a(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
    }

    private final d i0(int position) {
        int size = this.applyItemList.size();
        if (position >= 0 && size > position) {
            return this.applyItemList.get(position);
        }
        return null;
    }

    private final void o0(List<? extends d> itemList) {
        this.applyItemList.clear();
        if (itemList != null) {
            List<? extends d> list = itemList;
            if (!list.isEmpty()) {
                this.applyItemList.addAll(list);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.applyItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ItemType itemType;
        d i06 = i0(position);
        if (i06 == null || (itemType = i06.getItemType()) == null) {
            return 0;
        }
        return itemType.value;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.b<d> holder, int position) {
        holder.o(i0(position));
        cg0.a.b("ECAfterSaleApplyAdapter", "onBindViewHolder position:" + position + " applyItem:" + holder + ".applyItem");
        holder.p(i0(position + 1));
        holder.n(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.b<d> onCreateViewHolder(ViewGroup parent, int viewType) {
        cg0.a.b("ECAfterSaleApplyAdapter", "onCreateViewHolder viewType:" + viewType);
        int i3 = b.f409930a[ItemType.INSTANCE.a(viewType).ordinal()];
        if (i3 == 1) {
            return new f(new kh0.a(parent));
        }
        if (i3 == 2) {
            return new com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.a(LayoutInflater.from(parent.getContext()).inflate(R.layout.cos, parent, false));
        }
        if (i3 == 3) {
            return new com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.e(LayoutInflater.from(parent.getContext()).inflate(R.layout.cos, parent, false));
        }
        if (i3 == 4) {
            return new ECAfterSaleApplyExtraHolder(this.activity, LayoutInflater.from(parent.getContext()).inflate(R.layout.cor, parent, false), this.mediaListener);
        }
        if (i3 != 5) {
            return new com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.d(LayoutInflater.from(parent.getContext()).inflate(R.layout.cot, parent, false), this.optionClick);
        }
        return new c(LayoutInflater.from(parent.getContext()).inflate(R.layout.cos, parent, false), this.entryClick);
    }

    public final void l0(Function1<? super ECAfterSaleApplyEntryItem, Unit> function1) {
        this.entryClick = function1;
    }

    public final void m0(Function1<? super List<ECMediaInfo>, Unit> function1) {
        this.mediaListener = function1;
    }

    public final void n0(Function2<? super e, ? super com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.d, Unit> function2) {
        this.optionClick = function2;
    }

    public final void setData(List<? extends d> itemList) {
        o0(itemList);
        notifyDataSetChanged();
    }
}
