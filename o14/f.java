package o14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfoType;
import com.tencent.robot.adelie.homepage.cards.hot.AdelieHotAndFriendItem;
import com.tencent.robot.adelie.homepage.category.viewmodel.HotDelegateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0018j\b\u0012\u0004\u0012\u00020\u000b`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006,"}, d2 = {"Lo14/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lo14/f$b;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/d;", "data", "", "k0", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfoType;", "type", "", "Lo14/i;", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "l0", "getItemCount", "i0", "o0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "pageList", BdhLogUtil.LogTag.Tag_Conn, "I", "hotPageCount", "D", "Ljava/lang/Integer;", "getCurrentPage", "()Ljava/lang/Integer;", "n0", "(Ljava/lang/Integer;)V", "currentPage", "<init>", "()V", "E", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private int hotPageCount;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Integer currentPage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<AdelieHotAndFriendPageData> pageList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lo14/f$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/adelie/homepage/cards/hot/AdelieHotAndFriendItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lo14/h;", "data", "", DomainData.DOMAIN_NAME, "Lo14/i;", ISchemeApi.KEY_PAGE_DATA, "l", "", "last", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", UserInfo.SEX_FEMALE, "Lcom/tencent/robot/adelie/homepage/cards/hot/AdelieHotAndFriendItem;", "item1", "G", "item2", "H", "item3", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private AdelieHotAndFriendItem item1;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private AdelieHotAndFriendItem item2;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private AdelieHotAndFriendItem item3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.itemView = itemView;
            this.item1 = (AdelieHotAndFriendItem) this.itemView.findViewById(R.id.dor);
            this.item2 = (AdelieHotAndFriendItem) this.itemView.findViewById(R.id.doy);
            this.item3 = (AdelieHotAndFriendItem) this.itemView.findViewById(R.id.f165845dp4);
        }

        private final void n(AdelieHotAndFriendItem item, AdelieHotAndFriendItemData data) {
            if (item != null) {
                item.setVisibility(8);
            }
            if (data != null) {
                if (item != null) {
                    item.setVisibility(0);
                }
                if (item != null) {
                    item.c(data);
                }
            }
        }

        public final void l(@NotNull AdelieHotAndFriendPageData pageData) {
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            n(this.item1, pageData.getItemData1());
            n(this.item2, pageData.getItemData2());
            n(this.item3, pageData.getItemData3());
        }

        public final void m(boolean last) {
            AdelieHotAndFriendItem adelieHotAndFriendItem = this.item1;
            if (adelieHotAndFriendItem != null) {
                adelieHotAndFriendItem.setPageMarginRight(last);
            }
            AdelieHotAndFriendItem adelieHotAndFriendItem2 = this.item2;
            if (adelieHotAndFriendItem2 != null) {
                adelieHotAndFriendItem2.setPageMarginRight(last);
            }
            AdelieHotAndFriendItem adelieHotAndFriendItem3 = this.item3;
            if (adelieHotAndFriendItem3 != null) {
                adelieHotAndFriendItem3.setPageMarginRight(last);
            }
        }
    }

    private final List<AdelieHotAndFriendPageData> j0(RobotRecommendCardInfo data, RobotRecommendCardInfoType type) {
        String str;
        List<List> chunked;
        int i3;
        List<AdelieHotAndFriendPageData> emptyList;
        ArrayList<RobotCoreInfo> arrayList = null;
        if (data != null) {
            str = data.name;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (data != null) {
            arrayList = data.robots;
        }
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        chunked = CollectionsKt___CollectionsKt.chunked(arrayList, 3);
        ArrayList arrayList2 = new ArrayList();
        int i16 = 0;
        for (List<RobotCoreInfo> list : chunked) {
            AdelieHotAndFriendPageData adelieHotAndFriendPageData = new AdelieHotAndFriendPageData(null, null, null, 7, null);
            for (RobotCoreInfo robotCoreInfo : list) {
                if (adelieHotAndFriendPageData.getItemData1() == null) {
                    i3 = i16 + 1;
                    adelieHotAndFriendPageData.d(new AdelieHotAndFriendItemData(type, i16, robotCoreInfo, str));
                } else if (adelieHotAndFriendPageData.getItemData2() == null) {
                    i3 = i16 + 1;
                    adelieHotAndFriendPageData.e(new AdelieHotAndFriendItemData(type, i16, robotCoreInfo, str));
                } else if (adelieHotAndFriendPageData.getItemData3() == null) {
                    i3 = i16 + 1;
                    adelieHotAndFriendPageData.f(new AdelieHotAndFriendItemData(type, i16, robotCoreInfo, str));
                }
                i16 = i3;
            }
            arrayList2.add(adelieHotAndFriendPageData);
        }
        return arrayList2;
    }

    private final void k0(HotDelegateData data) {
        if (data.b().size() > 0) {
            RobotRecommendCardInfo robotRecommendCardInfo = data.b().get(0);
            RobotRecommendCardInfoType robotRecommendCardInfoType = data.b().get(0).type;
            Intrinsics.checkNotNullExpressionValue(robotRecommendCardInfoType, "data.cards[0].type");
            List<AdelieHotAndFriendPageData> j06 = j0(robotRecommendCardInfo, robotRecommendCardInfoType);
            this.pageList.addAll(j06);
            this.hotPageCount = j06.size();
        }
        if (data.b().size() > 1) {
            RobotRecommendCardInfo robotRecommendCardInfo2 = data.b().get(1);
            RobotRecommendCardInfoType robotRecommendCardInfoType2 = data.b().get(1).type;
            Intrinsics.checkNotNullExpressionValue(robotRecommendCardInfoType2, "data.cards[1].type");
            this.pageList.addAll(j0(robotRecommendCardInfo2, robotRecommendCardInfoType2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.pageList.size();
    }

    /* renamed from: i0, reason: from getter */
    public final int getHotPageCount() {
        return this.hotPageCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= 0 && position < this.pageList.size()) {
            AdelieHotAndFriendPageData adelieHotAndFriendPageData = this.pageList.get(position);
            Intrinsics.checkNotNullExpressionValue(adelieHotAndFriendPageData, "pageList[position]");
            holder.l(adelieHotAndFriendPageData);
            boolean z16 = true;
            if (position != this.pageList.size() - 1) {
                z16 = false;
            }
            holder.m(z16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dss, parent, false);
        FontSettingManager.resetViewSize2Normal(itemView.getContext(), itemView);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(itemView);
    }

    public final void n0(@Nullable Integer num) {
        this.currentPage = num;
    }

    public final void o0(@NotNull HotDelegateData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.pageList.clear();
        k0(data);
        Integer num = this.currentPage;
        if (num == null) {
            notifyDataSetChanged();
        } else if (num != null) {
            notifyItemChanged(num.intValue());
        }
    }
}
