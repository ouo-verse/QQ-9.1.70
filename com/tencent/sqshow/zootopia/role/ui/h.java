package com.tencent.sqshow.zootopia.role.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.role.logic.CreateRoleController;
import com.tencent.sqshow.zootopia.role.ui.a;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import qv4.bb;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/h;", "Lcom/tencent/sqshow/zootopia/role/ui/a;", "", "", "w0", "Landroid/graphics/drawable/Drawable;", "v0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "position", "", "", "payloads", "", "onBindViewHolder", "getItemCount", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "mController", "<init>", "(Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;)V", "J", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\u000e\u001a\n \u0003*\u0004\u0018\u00010\t0\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/h$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "figureImage", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "l", "()Landroid/view/View;", "circleView", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ZPlanMediaView figureImage;

        /* renamed from: F, reason: from kotlin metadata */
        private final View circleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.figureImage = (ZPlanMediaView) itemView.findViewById(R.id.qih);
            this.circleView = itemView.findViewById(R.id.qii);
        }

        /* renamed from: l, reason: from getter */
        public final View getCircleView() {
            return this.circleView;
        }

        /* renamed from: m, reason: from getter */
        public final ZPlanMediaView getFigureImage() {
            return this.figureImage;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(CreateRoleController mController) {
        super(mController);
        Intrinsics.checkNotNullParameter(mController, "mController");
    }

    private final Drawable v0() {
        if (getCurGender() == UEAvatarGender.FEMALE.getIndex()) {
            Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.il7);
            Intrinsics.checkNotNullExpressionValue(drawable, "{\n            BaseApplic\u2026_figure_female)\n        }");
            return drawable;
        }
        Drawable drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.il8);
        Intrinsics.checkNotNullExpressionValue(drawable2, "{\n            BaseApplic\u2026lt_figure_male)\n        }");
        return drawable2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(h this$0, int i3, bb materialInfo, RecyclerView.ViewHolder holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(materialInfo, "$materialInfo");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.p0(i3);
        a.b onItemClickListener = this$0.getOnItemClickListener();
        if (onItemClickListener != null) {
            onItemClickListener.a(this$0.getSelectedPosition(), materialInfo);
        }
        ZplanViewReportHelper reportHelper = this$0.getMController().getReportHelper();
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        reportHelper.e(view2, "em_zplan_avatar_switch", this$0.w0());
    }

    @Override // com.tencent.sqshow.zootopia.role.ui.a, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return l0().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder instanceof b) {
            final bb bbVar = l0().get(position);
            if (bbVar.f430045b[0].f430100g == null) {
                QLog.e("RoleFigureAdapter", 1, "onBindViewHolder material null");
                return;
            }
            if (payloads.isEmpty()) {
                b bVar = (b) holder;
                bVar.getFigureImage().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                bVar.getFigureImage().setDefaultDrawable(v0());
                ZPlanMediaView figureImage = bVar.getFigureImage();
                pu4.g gVar = bbVar.f430045b[0].f430100g;
                Intrinsics.checkNotNullExpressionValue(gVar, "materialInfo.list[0].fullBody");
                figureImage.e(gVar);
            }
            if (position == getSelectedPosition()) {
                com.tencent.sqshow.zootopia.role.logic.f fVar = com.tencent.sqshow.zootopia.role.logic.f.f372762a;
                View circleView = ((b) holder).getCircleView();
                Intrinsics.checkNotNullExpressionValue(circleView, "holder.circleView");
                fVar.b(circleView);
            } else {
                com.tencent.sqshow.zootopia.role.logic.f fVar2 = com.tencent.sqshow.zootopia.role.logic.f.f372762a;
                View circleView2 = ((b) holder).getCircleView();
                Intrinsics.checkNotNullExpressionValue(circleView2, "holder.circleView");
                fVar2.a(circleView2);
            }
            ((b) holder).getFigureImage().h();
            String str = bbVar.f430045b[0].f430096c;
            Intrinsics.checkNotNullExpressionValue(str, "materialInfo.list[0].id");
            q0(str);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.ui.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.x0(h.this, position, bbVar, holder, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.der, parent, false);
        view.getLayoutParams().width = (ViewUtils.getScreenWidth() - ViewUtils.dpToPx(20.0f)) / getPageItemNum();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(view);
    }

    private final Map<String, String> w0() {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("zplan_avatar_id", getAvatarId()), TuplesKt.to("zplan_avatar_pos", String.valueOf(getSelectedPosition())), TuplesKt.to("is_new_type", "1"));
        return mapOf;
    }
}
