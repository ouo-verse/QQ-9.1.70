package com.tencent.sqshow.zootopia.role.logic;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n74.ar;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleSelectFaceStep;", "Lcom/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "r", "Lcom/tencent/sqshow/zootopia/role/ui/f;", "g", "Lcom/tencent/sqshow/zootopia/role/ui/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/sqshow/zootopia/role/ui/f;", "adapter", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ln74/ar;", "mBinding", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "mController", "<init>", "(Landroid/app/Activity;Ln74/ar;Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;)V", tl.h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CreateRoleSelectFaceStep extends BaseCreateRoleSelectStep {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.role.ui.f adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleSelectFaceStep$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
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
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.right = com.tencent.sqshow.zootopia.utils.i.b(6);
                outRect.left = com.tencent.sqshow.zootopia.utils.i.b(8);
            } else {
                outRect.right = com.tencent.sqshow.zootopia.utils.i.b(6);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateRoleSelectFaceStep(Activity activity, ar mBinding, CreateRoleController mController) {
        super(activity, mBinding, mController);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mBinding, "mBinding");
        Intrinsics.checkNotNullParameter(mController, "mController");
        this.adapter = new com.tencent.sqshow.zootopia.role.ui.f(mController);
    }

    @Override // com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep
    public void E() {
        super.E();
    }

    @Override // com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep
    /* renamed from: Q, reason: from getter and merged with bridge method [inline-methods] */
    public com.tencent.sqshow.zootopia.role.ui.f o() {
        return this.adapter;
    }

    @Override // com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep
    public RecyclerView.ItemDecoration r() {
        return new b();
    }

    @Override // com.tencent.sqshow.zootopia.role.logic.BaseCreateRoleSelectStep
    public void z() {
        Drawable drawable = ContextCompat.getDrawable(getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), R.drawable.il6);
        if (drawable != null) {
            getMBinding().f418695f.setLoadingDrawable(drawable);
        }
        pu4.g gVar = new pu4.g();
        gVar.f427435b = "pag";
        gVar.f427434a = "https://zplan-image-1300343094.cos.ap-nanjing.myqcloud.com/role/vfx_CreateCharacter_BG.pag";
        gVar.f427436c = "local_image";
        getMBinding().f418695f.setPagViewReadyListener(new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.role.logic.CreateRoleSelectFaceStep$initBackground$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    CreateRoleSelectFaceStep.this.getMBinding().f418695f.setScaleMode(1);
                }
            }
        });
        getMBinding().f418695f.setRadius(0);
        getMBinding().f418695f.C(gVar);
        URLImageView uRLImageView = getMBinding().B;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.watermarkView");
        CommonExKt.w(uRLImageView, "https://image.superqqshow.qq.com/client/role/ztp_create_role_bg.png", com.tencent.mobileqq.urldrawable.b.f306350a, null, 4, null);
    }
}
