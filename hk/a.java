package hk;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.l;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.qzone.util.ar;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetAlbumListRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0014J*\u0010\u0018\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0014R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lhk/a;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "w", HippyTKDListViewAdapter.X, "", "getLogTag", "", "getViewStubLayoutId", "containerView", "onInitView", "data", "", "position", "", "", "payload", "y", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lgj/b;", "f", "Lgj/b;", "mAlbumContentAdapter", "<init>", "()V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends l<QZoneAlbumInfoBean> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private gj.b mAlbumContentAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"hk/a$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (((Section) a.this).mData == null) {
                return;
            }
            a.this.w(outRect, view, parent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Rect outRect, View view, RecyclerView parent) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        outRect.bottom = ar.d(16.0f);
        if (childAdapterPosition == 0) {
            outRect.left = ar.d(16.0f);
            outRect.right = 0;
            return;
        }
        gj.b bVar = this.mAlbumContentAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumContentAdapter");
            bVar = null;
        }
        if (childAdapterPosition == bVar.getItemCount() - 1) {
            outRect.left = ar.d(10.0f);
            outRect.right = ar.d(16.0f);
        } else {
            outRect.left = ar.d(10.0f);
            outRect.right = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        PBRepeatMessageField<QZoneBaseAlbumMeta$AlbumInfo> pBRepeatMessageField;
        QZIntimateSpaceAlbum$GetAlbumListRsp qZIntimateSpaceAlbum$GetAlbumListRsp = ((QZoneAlbumInfoBean) this.mData).getAlbumInfo().album_list;
        gj.b bVar = null;
        List<QZoneBaseAlbumMeta$AlbumInfo> list = (qZIntimateSpaceAlbum$GetAlbumListRsp == null || (pBRepeatMessageField = qZIntimateSpaceAlbum$GetAlbumListRsp.album_list) == null) ? null : pBRepeatMessageField.get();
        if (list == null) {
            return;
        }
        gj.b bVar2 = this.mAlbumContentAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumContentAdapter");
            bVar2 = null;
        }
        bVar2.i0((QZoneAlbumInfoBean) this.mData);
        gj.b bVar3 = this.mAlbumContentAdapter;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumContentAdapter");
        } else {
            bVar = bVar3;
        }
        bVar.q3(list, this.mPosition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumIntimateTabContentSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mnl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_intimate_tab_content_rv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.mRecyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new SafeLinearLayoutManager(containerView.getContext(), 0, false));
        gj.b bVar = new gj.b();
        bVar.setHasStableIds(true);
        this.mAlbumContentAdapter = bVar;
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        gj.b bVar2 = this.mAlbumContentAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumContentAdapter");
            bVar2 = null;
        }
        recyclerView4.setAdapter(bVar2);
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.addItemDecoration(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZoneAlbumInfoBean data, int position, List<Object> payload) {
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlw};
    }
}
