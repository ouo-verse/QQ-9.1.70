package la;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.util.ar;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002'(B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014J0\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lla/l;", "Lcom/qzone/reborn/base/l;", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "v", "", "getLogTag", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mReasonTv", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mListRv", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Lca/f;", "i", "Lca/f;", "mListAdapter", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l extends com.qzone.reborn.base.l<List<? extends RFWUploadRecommendInfo>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mReasonTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mListRv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ca.f mListAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lla/l$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spacing", "<init>", "(Lla/l;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public final class b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spacing;

        public b(int i3) {
            this.spacing = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int i3 = this.spacing;
            outRect.top = i3;
            outRect.bottom = i3;
            outRect.left = i3;
            outRect.right = i3;
        }
    }

    private final void u() {
        ca.f fVar = new ca.f();
        this.mListAdapter = fVar;
        fVar.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        ca.f fVar2 = this.mListAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListAdapter");
            fVar2 = null;
        }
        adapterArr[0] = fVar2;
        this.mConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.mListRv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListRv");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.mConcatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mConcatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public String getLogTag() {
        return "QZoneAlbumxLocalPhotoRecommendVideoContentSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mow);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026hoto_recommend_reason_tv)");
        TextView textView = (TextView) findViewById;
        this.mReasonTv = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReasonTv");
            textView = null;
        }
        textView.setText(com.qzone.util.l.a(R.string.jfw));
        View findViewById2 = containerView.findViewById(R.id.f162799mp2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026_recommend_video_list_rv)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.mListRv = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListRv");
            recyclerView = null;
        }
        RecyclerView recyclerView2 = this.mListRv;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListRv");
            recyclerView2 = null;
        }
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView2.getContext(), 0, false));
        RecyclerView recyclerView3 = this.mListRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListRv");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new b(ar.d(8.0f)));
        u();
        TextView textView3 = this.mReasonTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReasonTv");
        } else {
            textView2 = textView3;
        }
        fo.c.n(textView2, "em_qz_video_module");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mqf};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(List<RFWUploadRecommendInfo> data, int position, List<Object> payload) {
        if (data == null) {
            QLog.e(getLogTag(), 1, "[onBindData] data is null");
        }
        if (data != null) {
            QLog.d(getLogTag(), 1, "[onBindData] data.size = " + data.size());
            if (data.isEmpty()) {
                this.mRootView.setVisibility(8);
                return;
            }
            this.mRootView.setVisibility(0);
            ca.f fVar = this.mListAdapter;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListAdapter");
                fVar = null;
            }
            fVar.setItems(data);
        }
    }
}
