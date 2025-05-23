package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.qzone.business.tianshu.model.QZoneQuickCommentInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/layer/part/ag;", "Lcom/qzone/reborn/layer/part/ap;", "Lxc/g;", "", "R9", "P9", "", "Lq5/a;", "quickInputList", "U9", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Q9", "", "isPartEnable", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getPageType", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "position", "u7", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/view/ViewGroup;", "G", "Landroid/view/ViewGroup;", "mBottomContainerView", "H", "Landroidx/recyclerview/widget/RecyclerView;", "mQuickInputRv", "Lvc/b;", "I", "Lvc/b;", "mQuickInputAdapter", "J", "Z", "mIsSetQuickItemDecoration", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ag extends ap implements xc.g {
    private static final int L = com.qzone.util.ar.e(16.0f);
    private static final int M = com.qzone.util.ar.e(8.0f);
    private static final int N = com.qzone.util.ar.e(20.0f);

    /* renamed from: G, reason: from kotlin metadata */
    private ViewGroup mBottomContainerView;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView mQuickInputRv;

    /* renamed from: I, reason: from kotlin metadata */
    private vc.b mQuickInputAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsSetQuickItemDecoration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/layer/part/ag$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
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
            ag.this.Q9(outRect, view, parent);
        }
    }

    private final void P9() {
        ViewGroup viewGroup = this.mBottomContainerView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomContainerView");
            viewGroup = null;
        }
        viewGroup.setPadding(0, 0, 0, N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(Rect outRect, View view, RecyclerView parent) {
        if (this.mQuickInputAdapter == null) {
            return;
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            outRect.left = L;
            outRect.right = 0;
            return;
        }
        Intrinsics.checkNotNull(this.mQuickInputAdapter);
        if (childAdapterPosition == r0.getNUM_BACKGOURND_ICON() - 1) {
            outRect.left = M;
            outRect.right = L;
        } else {
            outRect.left = M;
            outRect.right = 0;
        }
    }

    private final void R9() {
        if (!F9()) {
            QLog.d("QZoneFeedxLayerQuickCommentPart", 1, "[initQuickComment] user is master");
        } else {
            QZoneCommentQuickInputHelper.n().p(new QZoneCommentQuickInputHelper.a() { // from class: com.qzone.reborn.layer.part.ae
                @Override // com.qzone.business.tianshu.QZoneCommentQuickInputHelper.a
                public final void a(QZoneQuickCommentInfo qZoneQuickCommentInfo) {
                    ag.S9(ag.this, qZoneQuickCommentInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(final ag this$0, final QZoneQuickCommentInfo qZoneQuickCommentInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.layer.part.af
                @Override // java.lang.Runnable
                public final void run() {
                    ag.T9(QZoneQuickCommentInfo.this, this$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(QZoneQuickCommentInfo qZoneQuickCommentInfo, ag this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qZoneQuickCommentInfo != null) {
            this$0.U9(qZoneQuickCommentInfo.getCardList());
            this$0.P9();
        }
    }

    @Override // xc.g
    public int getPageType() {
        return 1;
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return super.isPartEnable() && com.qzone.reborn.a.e(com.qzone.reborn.a.f52169a, "exp_qzone_pic_float_v1", null, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.n0a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026x_layer_bottom_container)");
        this.mBottomContainerView = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.n0o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026eedx_layer_quick_comment)");
        this.mQuickInputRv = (RecyclerView) findViewById2;
        RFWIocAbilityProvider.g().registerIoc(rootView, this, xc.g.class);
        R9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneCommentQuickInputHelper.n().r();
    }

    @Override // xc.g
    public void u7(q5.a item, int position) {
        String c16;
        Intrinsics.checkNotNullParameter(item, "item");
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        RecyclerView recyclerView = this.mQuickInputRv;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
            recyclerView = null;
        }
        pk.a aVar = (pk.a) g16.getIocInterface(pk.a.class, recyclerView, null);
        if (com.qzone.reborn.configx.g.f53821a.a().k()) {
            c16 = item.a();
        } else {
            String a16 = item.a();
            Intrinsics.checkNotNullExpressionValue(a16, "item.getText()");
            c16 = cd.b.c(a16);
        }
        if (aVar != null) {
            aVar.X0(c16, position);
        }
    }

    private final void U9(List<? extends q5.a> quickInputList) {
        if (com.tencent.mobileqq.utils.bl.b(quickInputList)) {
            QLog.i("QZoneFeedxLayerQuickCommentPart", 1, "[showQuickInputView] no quick input list");
            return;
        }
        RecyclerView recyclerView = this.mQuickInputRv;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
            recyclerView = null;
        }
        recyclerView.setVisibility(0);
        if (!this.mIsSetQuickItemDecoration) {
            this.mIsSetQuickItemDecoration = true;
            RecyclerView recyclerView3 = this.mQuickInputRv;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
                recyclerView3 = null;
            }
            recyclerView3.addItemDecoration(new b());
        }
        this.mQuickInputAdapter = new vc.b();
        RecyclerView recyclerView4 = this.mQuickInputRv;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
            recyclerView4 = null;
        }
        recyclerView4.setAdapter(this.mQuickInputAdapter);
        RecyclerView recyclerView5 = this.mQuickInputRv;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQuickInputRv");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        Intrinsics.checkNotNull(quickInputList);
        ArrayList arrayList = new ArrayList();
        for (Object obj : quickInputList) {
            if (((q5.a) obj).f428352a != QZoneCommentQuickInputHelper.f44832g) {
                arrayList.add(obj);
            }
        }
        vc.b bVar = this.mQuickInputAdapter;
        Intrinsics.checkNotNull(bVar);
        bVar.setItems(new ArrayList(arrayList));
    }
}
