package fg3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qshadow.AIFacePtaData$ZplanFaceStyle;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016R\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0010*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lfg3/j;", "Lfg3/c;", "Landroid/widget/FrameLayout;", "frameLayout", "Lfg3/l;", "faceItemData", "", ReportConstant.COSTREPORT_PREFIX, "", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "position", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "image", "Landroid/view/View;", "G", "Landroid/view/View;", "mask", "itemView", "<init>", "(Landroid/view/View;)V", "H", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j extends c {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView image;

    /* renamed from: G, reason: from kotlin metadata */
    private final View mask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lfg3/j$a;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lfg3/j;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fg3.j$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j a(Context context, ViewGroup parent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(context).inflate(R.layout.f167445dc4, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026lse\n                    )");
            return new j(inflate);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.image = (ImageView) itemView.findViewById(R.id.qch);
        this.mask = itemView.findViewById(R.id.q7v);
    }

    private final Map<String, Object> q(FaceItemData faceItemData) {
        PBStringField pBStringField;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_elem_pos", Integer.valueOf(getPosition()));
        AIFacePtaData$ZplanFaceStyle face2 = faceItemData.getFace();
        String str = (face2 == null || (pBStringField = face2.style_id) == null) ? null : pBStringField.get();
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "faceItemData.face?.style_id?.get() ?: \"\"");
        }
        linkedHashMap.put("zplan_style_id", str);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(j this$0, FaceItemData faceItemData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(faceItemData, "$faceItemData");
        x listener = this$0.getListener();
        if (listener != null) {
            listener.a(faceItemData, -1);
        }
        VideoReport.reportEvent("dt_clck", this$0.itemView, this$0.q(faceItemData));
        faceItemData.m(true);
    }

    private final void s(FrameLayout frameLayout, final FaceItemData faceItemData) {
        String valueOf;
        AIFacePtaData$ZplanFaceStyle aIFacePtaData$ZplanFaceStyle;
        com.tencent.mobileqq.zplan.report.c cVar = com.tencent.mobileqq.zplan.report.c.f335070a;
        Map<String, Object> q16 = q(faceItemData);
        AIFacePtaData$ZplanFaceStyle face2 = faceItemData.getFace();
        if (face2 == null || (aIFacePtaData$ZplanFaceStyle = face2.get()) == null || (valueOf = Integer.valueOf(aIFacePtaData$ZplanFaceStyle.hashCode()).toString()) == null) {
            valueOf = String.valueOf(getPosition());
        }
        cVar.c(frameLayout, "em_zplan_sculpt_template", q16, false, false, valueOf);
        if (!faceItemData.getIsSelected() || faceItemData.getIsSelectedReport()) {
            return;
        }
        this.itemView.post(new Runnable() { // from class: fg3.i
            @Override // java.lang.Runnable
            public final void run() {
                j.t(j.this, faceItemData);
            }
        });
        faceItemData.m(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(j this$0, FaceItemData faceItemData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(faceItemData, "$faceItemData");
        VideoReport.reportEvent("dt_clck", this$0.itemView, this$0.q(faceItemData));
    }

    @Override // fg3.c
    public void m(final FaceItemData faceItemData, int position) {
        Intrinsics.checkNotNullParameter(faceItemData, "faceItemData");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: fg3.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.r(j.this, faceItemData, view);
            }
        });
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) view;
        ImageView imageView = this.image;
        if (imageView != null) {
            imageView.setImageBitmap(faceItemData.getThumbnailBitmap());
        }
        View view2 = this.mask;
        if (view2 != null) {
            view2.setVisibility(faceItemData.getIsSelected() ? 0 : 8);
        }
        s(frameLayout, faceItemData);
    }
}
