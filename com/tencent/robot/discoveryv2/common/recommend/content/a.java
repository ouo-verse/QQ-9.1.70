package com.tencent.robot.discoveryv2.common.recommend.content;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.ListNode;
import com.tencent.robot.discoveryv2.common.recommend.page.core.RecommendPageParams;
import com.tencent.robot.discoveryv2.common.recommend.page.core.RecommendPageViewModel;
import com.tencent.robot.discoveryv2.common.recommend.page.core.RecommendRobotsPage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B+\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\u0004\b$\u0010%J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001fj\b\u0012\u0004\u0012\u00020\u0004` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/content/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/robot/discoveryv2/common/recommend/content/a$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ListNode;", "list", "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "i0", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mUin", "Landroidx/lifecycle/LifecycleOwner;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "Lkotlin/Function1;", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendPageViewModel;", "D", "Lkotlin/jvm/functions/Function1;", "mPageViewModelGetter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "mCategoryTabList", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends RecyclerView.Adapter<C9771a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LifecycleOwner mLifecycleOwner;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<String, RecommendPageViewModel> mPageViewModelGetter;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<ListNode> mCategoryTabList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/content/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendRobotsPage;", "E", "Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendRobotsPage;", "l", "()Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendRobotsPage;", "mRecommendRobotsPage", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/tencent/robot/discoveryv2/common/recommend/page/core/RecommendRobotsPage;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.common.recommend.content.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9771a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RecommendRobotsPage mRecommendRobotsPage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9771a(@NotNull View view, @NotNull RecommendRobotsPage mRecommendRobotsPage) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(mRecommendRobotsPage, "mRecommendRobotsPage");
            this.mRecommendRobotsPage = mRecommendRobotsPage;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final RecommendRobotsPage getMRecommendRobotsPage() {
            return this.mRecommendRobotsPage;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull String mUin, @NotNull LifecycleOwner mLifecycleOwner, @NotNull Function1<? super String, RecommendPageViewModel> mPageViewModelGetter) {
        Intrinsics.checkNotNullParameter(mUin, "mUin");
        Intrinsics.checkNotNullParameter(mLifecycleOwner, "mLifecycleOwner");
        Intrinsics.checkNotNullParameter(mPageViewModelGetter, "mPageViewModelGetter");
        this.mUin = mUin;
        this.mLifecycleOwner = mLifecycleOwner;
        this.mPageViewModelGetter = mPageViewModelGetter;
        this.mCategoryTabList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mCategoryTabList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C9771a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ListNode listNode = this.mCategoryTabList.get(position);
        Intrinsics.checkNotNullExpressionValue(listNode, "mCategoryTabList[position]");
        ListNode listNode2 = listNode;
        RecommendRobotsPage mRecommendRobotsPage = holder.getMRecommendRobotsPage();
        String str = this.mUin;
        String str2 = listNode2.listId;
        Intrinsics.checkNotNullExpressionValue(str2, "category.listId");
        String str3 = listNode2.listName;
        Intrinsics.checkNotNullExpressionValue(str3, "category.listName");
        RecommendPageParams recommendPageParams = new RecommendPageParams(str, str2, str3, this.mLifecycleOwner);
        Function1<String, RecommendPageViewModel> function1 = this.mPageViewModelGetter;
        String str4 = listNode2.listId;
        Intrinsics.checkNotNullExpressionValue(str4, "category.listId");
        mRecommendRobotsPage.r(recommendPageParams, function1.invoke(str4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public C9771a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecommendRobotsPage recommendRobotsPage = new RecommendRobotsPage();
        return new C9771a(recommendRobotsPage.s(parent), recommendRobotsPage);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull C9771a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.getMRecommendRobotsPage().t();
    }

    public final void l0(@NotNull List<ListNode> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mCategoryTabList.clear();
        this.mCategoryTabList.addAll(list);
    }
}
