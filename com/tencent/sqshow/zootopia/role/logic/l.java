package com.tencent.sqshow.zootopia.role.logic;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.ar;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/l;", "Lcom/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "r", "Lcom/tencent/sqshow/zootopia/role/ui/h;", "g", "Lcom/tencent/sqshow/zootopia/role/ui/h;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/sqshow/zootopia/role/ui/h;", "adapter", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ln74/ar;", "mBinding", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "mController", "<init>", "(Landroid/app/Activity;Ln74/ar;Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;)V", tl.h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l extends BaseCreateRoleSelectStep {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.role.ui.h adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/l$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Activity activity, ar mBinding, CreateRoleController mController) {
        super(activity, mBinding, mController);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mBinding, "mBinding");
        Intrinsics.checkNotNullParameter(mController, "mController");
        this.adapter = new com.tencent.sqshow.zootopia.role.ui.h(mController);
    }

    @Override // com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep
    public void E() {
        super.E();
        ViewGroup.LayoutParams layoutParams = getMBinding().f418699j.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = com.tencent.sqshow.zootopia.utils.i.b(141);
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = com.tencent.sqshow.zootopia.utils.i.b(14);
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = com.tencent.sqshow.zootopia.utils.i.b(5);
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = com.tencent.sqshow.zootopia.utils.i.b(5);
        ViewGroup.LayoutParams layoutParams3 = getMBinding().f418692c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams3)).bottomMargin = com.tencent.sqshow.zootopia.utils.i.b(20);
        ViewGroup.LayoutParams layoutParams4 = getMBinding().f418713x.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams4)).bottomMargin = com.tencent.sqshow.zootopia.utils.i.b(15);
    }

    @Override // com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep
    /* renamed from: Q, reason: from getter and merged with bridge method [inline-methods] */
    public com.tencent.sqshow.zootopia.role.ui.h o() {
        return this.adapter;
    }

    @Override // com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep
    public RecyclerView.ItemDecoration r() {
        return new b();
    }

    @Override // com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep
    public void z() {
        getMBinding().f418709t.setBackgroundDrawable(URLDrawable.getDrawable("https://image.superqqshow.qq.com/qq/register_resource/basic_back.jpg", new ColorDrawable(-1), new ColorDrawable(-1)));
        getMBinding().f418695f.setVisibility(8);
        getMBinding().B.setVisibility(8);
    }
}
