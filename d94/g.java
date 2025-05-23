package d94;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.StoreItemViewHolder;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.u;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.x;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.z;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PanelSubTitlePageDataRepo;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelCategoryData;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.aa;
import n74.ab;
import n74.ac;
import n74.ad;
import n74.s;
import uv4.az;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001`B'\u0012\u0006\u0010(\u001a\u00020#\u0012\u0006\u0010.\u001a\u00020)\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00108\u001a\u000203\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\u0012\u001a\u00020\u0007J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0014\u0010\u0017\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0014\u0010\u0018\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0007J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0002H\u0016R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R$\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u001409j\b\u0012\u0004\u0012\u00020\u0014`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R$\u0010@\u001a\u0012\u0012\u0004\u0012\u00020>09j\b\u0012\u0004\u0012\u00020>`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010<R$\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u000209j\b\u0012\u0004\u0012\u00020\u0002`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010<R\u0018\u0010E\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010T\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\\\u001a\u00020U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[\u00a8\u0006a"}, d2 = {"Ld94/g;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder;", "", "position", "", "l0", "", "m0", "u0", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/b;", "l", "z0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "p0", "getItemViewType", "destroy", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/g;", "getData", "dataList", "v0", "j0", "Luv4/az;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "w0", "q0", "holder", "n0", "getItemCount", "t0", "r0", "s0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "panelSubTitlePageDataRepo", "Lg94/g;", "E", "Lg94/g;", "getSizeHelper", "()Lg94/g;", "sizeHelper", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mDataList", "Luv4/bk;", "G", "storeTypeItemList", "H", "viewHolderList", "I", "Lcom/tencent/sqshow/zootopia/nativeui/view/page/b;", "mDataChangedListener", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "J", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "getCurrentData", "()Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "x0", "(Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;)V", "currentData", "K", "Z", "getHandleDressChangeNotify", "()Z", "setHandleDressChangeNotify", "(Z)V", "handleDressChangeNotify", "", "L", "Ljava/lang/String;", "k0", "()Ljava/lang/String;", "y0", "(Ljava/lang/String;)V", "currentTabId", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;Lg94/g;)V", "M", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends RecyclerView.Adapter<BaseAvatarPanelItemViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: D, reason: from kotlin metadata */
    private final PanelSubTitlePageDataRepo panelSubTitlePageDataRepo;

    /* renamed from: E, reason: from kotlin metadata */
    private final g94.g sizeHelper;

    /* renamed from: F, reason: from kotlin metadata */
    private final ArrayList<com.tencent.sqshow.zootopia.nativeui.data.repo.g> mDataList;

    /* renamed from: G, reason: from kotlin metadata */
    private final ArrayList<bk> storeTypeItemList;

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<BaseAvatarPanelItemViewHolder> viewHolderList;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.view.page.b mDataChangedListener;

    /* renamed from: J, reason: from kotlin metadata */
    private PortalStorePanelCategoryData currentData;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean handleDressChangeNotify;

    /* renamed from: L, reason: from kotlin metadata */
    private String currentTabId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    private final boolean l0(int position) {
        return com.tencent.sqshow.zootopia.nativeui.adapter.holder.j.f370868a.e(this.currentTabId, this.mDataList, position);
    }

    private final void m0() {
        com.tencent.sqshow.zootopia.nativeui.adapter.holder.j.f370868a.f(this.currentTabId, this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(g this$0, az storeItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storeItem, "storeItem");
        this$0.w0(storeItem);
    }

    private final void u0() {
        if (this.viewHolderList.isEmpty()) {
            return;
        }
        QLog.i("PortalStoreStoreItemAdapter_", 1, "processPageHide clearRedDot");
        int size = this.viewHolderList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.viewHolderList.get(i3).q0();
        }
        this.viewHolderList.clear();
    }

    public final List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> getData() {
        return this.mDataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar = this.mDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(gVar, "mDataList[position]");
        com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar2 = gVar;
        if (l0(position)) {
            return 3;
        }
        bk storeTypeItem = gVar2.getStoreTypeItem();
        if (storeTypeItem != null && storeTypeItem.f440365a == 2) {
            return 2;
        }
        bk storeTypeItem2 = gVar2.getStoreTypeItem();
        if (storeTypeItem2 != null && storeTypeItem2.f440365a == 3) {
            return 2;
        }
        return gVar2.getType();
    }

    public final void j0(List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        QLog.i("PortalStoreStoreItemAdapter_", 1, "appendData dataList:" + dataList.size());
        if (dataList.isEmpty()) {
            return;
        }
        int size = this.mDataList.size();
        this.mDataList.addAll(dataList);
        this.storeTypeItemList.clear();
        ArrayList<bk> arrayList = this.storeTypeItemList;
        ArrayList<com.tencent.sqshow.zootopia.nativeui.data.repo.g> arrayList2 = this.mDataList;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            bk storeTypeItem = ((com.tencent.sqshow.zootopia.nativeui.data.repo.g) it.next()).getStoreTypeItem();
            if (storeTypeItem != null) {
                arrayList3.add(storeTypeItem);
            }
        }
        arrayList.addAll(arrayList3);
        m0();
        notifyItemRangeInserted(size, dataList.size());
        com.tencent.sqshow.zootopia.nativeui.view.page.b bVar = this.mDataChangedListener;
        if (bVar != null) {
            bVar.onDataChanged();
        }
    }

    /* renamed from: k0, reason: from getter */
    public final String getCurrentTabId() {
        return this.currentTabId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseAvatarPanelItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar = this.mDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(gVar, "mDataList[position]");
        com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar2 = gVar;
        if (holder instanceof z) {
            ((z) holder).M0(gVar2.getRecommendText());
        }
        holder.y(gVar2.getStoreTypeItem(), position, this.storeTypeItemList);
        holder.z();
        holder.G0(new BaseAvatarPanelItemViewHolder.b() { // from class: d94.f
            @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder.b
            public final void a(az azVar) {
                g.o0(g.this, azVar);
            }
        });
        this.viewHolderList.add(holder);
        bk storeTypeItem = gVar2.getStoreTypeItem();
        if (storeTypeItem != null) {
            ZPlanAvatarPreDownloadManager.f371947a.r(storeTypeItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public BaseAvatarPanelItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            s g16 = s.g(LayoutInflater.from(this.context));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026  )\n                    )");
            return new x(g16, this.channel, this.panelSubTitlePageDataRepo);
        }
        if (viewType == 3) {
            aa g17 = aa.g(LayoutInflater.from(this.context));
            Intrinsics.checkNotNullExpressionValue(g17, "inflate(LayoutInflater.from(context))");
            return new com.tencent.sqshow.zootopia.nativeui.adapter.holder.m(g17, this.sizeHelper, this.channel);
        }
        if (viewType == 4) {
            ac g18 = ac.g(LayoutInflater.from(this.context));
            Intrinsics.checkNotNullExpressionValue(g18, "inflate(LayoutInflater.from(context))");
            return new z(g18, this.channel);
        }
        if (viewType != 5) {
            ad g19 = ad.g(LayoutInflater.from(this.context));
            Intrinsics.checkNotNullExpressionValue(g19, "inflate(LayoutInflater.from(context))");
            g94.g gVar = this.sizeHelper;
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.channel;
            int i3 = this.currentData.getGroupCfgV1().f440266b;
            String str = this.currentData.getSectionCfgV1().f440331a;
            Intrinsics.checkNotNullExpressionValue(str, "currentData.sectionCfgV1.id");
            String str2 = this.currentData.getCategoryCfg().f440183a;
            Intrinsics.checkNotNullExpressionValue(str2, "currentData.categoryCfg.id");
            return new StoreItemViewHolder(g19, gVar, jVar, new StoreItemViewHolder.Companion.CategoryData(i3, str, str2));
        }
        ab g26 = ab.g(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(g26, "inflate(LayoutInflater.from(context))");
        return new u(g26, this.channel);
    }

    public final void q0() {
        u0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseAvatarPanelItemViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        QLog.i("PortalStoreStoreItemAdapter_", 1, "onViewAttachedToWindow, holder:" + holder);
        this.viewHolderList.add(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(BaseAvatarPanelItemViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        u0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(BaseAvatarPanelItemViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onViewRecycled();
        this.viewHolderList.remove(holder);
    }

    public final void v0(List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        QLog.i("PortalStoreStoreItemAdapter_", 1, "refreshData dataList:" + dataList.size());
        this.mDataList.clear();
        this.mDataList.addAll(dataList);
        this.storeTypeItemList.clear();
        ArrayList<bk> arrayList = this.storeTypeItemList;
        ArrayList<com.tencent.sqshow.zootopia.nativeui.data.repo.g> arrayList2 = this.mDataList;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            bk storeTypeItem = ((com.tencent.sqshow.zootopia.nativeui.data.repo.g) it.next()).getStoreTypeItem();
            if (storeTypeItem != null) {
                arrayList3.add(storeTypeItem);
            }
        }
        arrayList.addAll(arrayList3);
        m0();
        notifyDataSetChanged();
        com.tencent.sqshow.zootopia.nativeui.view.page.b bVar = this.mDataChangedListener;
        if (bVar != null) {
            bVar.onDataChanged();
        }
    }

    public final void w0(az item) {
        Object obj;
        az azVar;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = this.mDataList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            bk storeTypeItem = ((com.tencent.sqshow.zootopia.nativeui.data.repo.g) next).getStoreTypeItem();
            if (storeTypeItem != null && (azVar = storeTypeItem.f440366b) != null) {
                obj = azVar.B;
            }
            if (Intrinsics.areEqual(obj, item.B)) {
                obj = next;
                break;
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.repo.g gVar = (com.tencent.sqshow.zootopia.nativeui.data.repo.g) obj;
        if (gVar == null) {
            return;
        }
        int indexOf = this.mDataList.indexOf(gVar);
        this.mDataList.remove(indexOf);
        this.storeTypeItemList.clear();
        ArrayList<bk> arrayList = this.storeTypeItemList;
        ArrayList<com.tencent.sqshow.zootopia.nativeui.data.repo.g> arrayList2 = this.mDataList;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            bk storeTypeItem2 = ((com.tencent.sqshow.zootopia.nativeui.data.repo.g) it5.next()).getStoreTypeItem();
            if (storeTypeItem2 != null) {
                arrayList3.add(storeTypeItem2);
            }
        }
        arrayList.addAll(arrayList3);
        notifyItemRemoved(indexOf);
    }

    public final void x0(PortalStorePanelCategoryData portalStorePanelCategoryData) {
        Intrinsics.checkNotNullParameter(portalStorePanelCategoryData, "<set-?>");
        this.currentData = portalStorePanelCategoryData;
    }

    public final void y0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentTabId = str;
    }

    public final void z0(com.tencent.sqshow.zootopia.nativeui.view.page.b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mDataChangedListener = l3;
    }

    public g(Context context, com.tencent.sqshow.zootopia.nativeui.data.j channel, PanelSubTitlePageDataRepo panelSubTitlePageDataRepo, g94.g sizeHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(panelSubTitlePageDataRepo, "panelSubTitlePageDataRepo");
        Intrinsics.checkNotNullParameter(sizeHelper, "sizeHelper");
        this.context = context;
        this.channel = channel;
        this.panelSubTitlePageDataRepo = panelSubTitlePageDataRepo;
        this.sizeHelper = sizeHelper;
        this.mDataList = new ArrayList<>();
        this.storeTypeItemList = new ArrayList<>();
        this.viewHolderList = new ArrayList<>();
        this.currentData = new PortalStorePanelCategoryData(0, 0, 0, null, null, null, null, null, null, 511, null);
        this.handleDressChangeNotify = true;
        this.currentTabId = "";
    }

    public final void destroy() {
    }
}
