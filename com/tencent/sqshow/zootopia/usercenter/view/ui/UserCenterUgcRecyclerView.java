package com.tencent.sqshow.zootopia.usercenter.view.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.ZootopiaPullRefreshLayoutV2;
import java.util.Iterator;
import java.util.List;
import jc4.UserCenterCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterUgcRecyclerView;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/androidx/ZootopiaPullRefreshLayoutV2;", "", "fixedPos", "N", "", "Ljc4/a;", "newData", "", "O", "Lic4/a;", "W", "Lic4/a;", "mAdapter", "a0", "I", "mLeftMargin", "b0", "mRightMargin", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "userCenterPage", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UserCenterUgcRecyclerView extends ZootopiaPullRefreshLayoutV2 {

    /* renamed from: W, reason: from kotlin metadata */
    private ic4.a mAdapter;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final int mLeftMargin;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int mRightMargin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterUgcRecyclerView$a", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ic4.a f373204a;

        a(ic4.a aVar) {
            this.f373204a = aVar;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            return this.f373204a.getItemViewType(position) != 202232 ? 3 : 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/view/ui/UserCenterUgcRecyclerView$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ic4.a f373205d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UserCenterUgcRecyclerView f373206e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f373207f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f373208h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f373209i;

        b(ic4.a aVar, UserCenterUgcRecyclerView userCenterUgcRecyclerView, int i3, int i16, int i17) {
            this.f373205d = aVar;
            this.f373206e = userCenterUgcRecyclerView;
            this.f373207f = i3;
            this.f373208h = i16;
            this.f373209i = i17;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Object obj;
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            Integer valueOf = layoutManager != null ? Integer.valueOf(layoutManager.getItemViewType(view)) : null;
            if (valueOf == null || valueOf.intValue() != 202232) {
                outRect.set(0, 0, 0, 0);
                return;
            }
            Iterator<T> it = this.f373205d.i0().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((UserCenterCardData) obj).getItemType() == 202232) {
                        break;
                    }
                }
            }
            UserCenterCardData userCenterCardData = (UserCenterCardData) obj;
            int indexOf = userCenterCardData == null ? -1 : this.f373205d.i0().indexOf(userCenterCardData);
            Object tag = view.getTag();
            Integer num = tag instanceof Integer ? (Integer) tag : null;
            int intValue = num != null ? num.intValue() : -1;
            if (indexOf < 0 || intValue < 0 || (i3 = intValue - indexOf) < 0) {
                return;
            }
            int i16 = i3 % 3;
            if (i16 == 0) {
                outRect.set(this.f373206e.mLeftMargin, this.f373206e.N(i3), (this.f373207f - this.f373206e.mLeftMargin) - this.f373208h, i.b(4));
            } else if (i16 != 2) {
                outRect.set(this.f373209i, this.f373206e.N(i3), this.f373209i, i.b(4));
            } else {
                outRect.set((this.f373207f - this.f373206e.mRightMargin) - this.f373208h, this.f373206e.N(i3), this.f373206e.mRightMargin, i.b(4));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCenterUgcRecyclerView(Context context, com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage) {
        super(context, null, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userCenterPage, "userCenterPage");
        this.mLeftMargin = i.b(16);
        this.mRightMargin = i.b(16);
        setRefreshEnable(false);
        G(false);
        E().setClipChildren(false);
        E().setItemAnimator(null);
        ic4.a aVar = new ic4.a(context, userCenterPage);
        this.mAdapter = aVar;
        E().setAdapter(this.mAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        E().setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new a(aVar));
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).saveCache(context, ZplanCacheComponentType.USER_CENTER_LIST_VIEW, this);
        int c16 = u.INSTANCE.c(BaseApplication.context);
        int b16 = (c16 - i.b(48)) / 3;
        int i3 = c16 / 3;
        E().addItemDecoration(new b(aVar, this, i3, b16, (i3 - b16) / 2));
    }

    public final void O(List<UserCenterCardData> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        ic4.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.l0(newData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int N(int fixedPos) {
        return i.b(fixedPos < 3 ? 20 : 4);
    }
}
