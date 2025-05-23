package ic4;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.usercenter.view.items.UserCenterWorkItemCard;
import com.tencent.sqshow.zootopia.usercenter.view.items.UserCenterWorksEmptyCard;
import java.util.ArrayList;
import java.util.List;
import jc4.UserCenterCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b%\u0010&J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR'\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001ej\b\u0012\u0004\u0012\u00020\u0004`\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lic4/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lic4/a$b;", "", "Ljc4/a;", "newData", "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "position", "getItemViewType", "vh", "j0", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "getUserCenterPage", "()Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "userCenterPage", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "i0", "()Ljava/util/ArrayList;", "mData", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;)V", "E", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage;

    /* renamed from: D, reason: from kotlin metadata */
    private final ArrayList<UserCenterCardData> mData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lic4/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    public a(Context context, com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userCenterPage, "userCenterPage");
        this.context = context;
        this.userCenterPage = userCenterPage;
        this.mData = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position >= this.mData.size()) {
            return 0;
        }
        return this.mData.get(position).getItemType();
    }

    public final ArrayList<UserCenterCardData> i0() {
        return this.mData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b vh5, int position) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        View view = vh5.itemView;
        if (view instanceof nc4.a) {
            view.setTag(Integer.valueOf(position));
            KeyEvent.Callback callback = vh5.itemView;
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.usercenter.view.items.IUserCenterCard");
            UserCenterCardData userCenterCardData = this.mData.get(position);
            Intrinsics.checkNotNullExpressionValue(userCenterCardData, "mData[position]");
            ((nc4.a) callback).w0(userCenterCardData, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 202232:
                return new b(new UserCenterWorkItemCard(this.context, this.userCenterPage));
            case 202233:
                return new b(new UserCenterWorksEmptyCard(this.context, this.userCenterPage));
            default:
                return new b(new FrameLayout(this.context));
        }
    }

    public final void l0(List<UserCenterCardData> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.mData.clear();
        this.mData.addAll(newData);
        notifyDataSetChanged();
    }
}
