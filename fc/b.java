package fc;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.base.l;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hb.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc.bs;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010H\u0014J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0014R\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lfc/b;", "Lcom/qzone/reborn/base/l;", "Lza/a;", "data", "", "v", "", "content", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "selectedColor", "defaultColorId", BdhLogUtil.LogTag.Tag_Conn, "y", "Lnc/bs;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "view", HippyTKDListViewAdapter.X, "", "getViewStubLayoutId", "containerView", "onInitView", "position", "", "", "payload", "B", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "contentTV", "Landroid/widget/LinearLayout;", h.F, "Landroid/widget/LinearLayout;", "contentContainer", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<za.a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumTimelineContentSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView contentTV;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout contentContainer;

    private final int A(String content) {
        int color = p().getColor(R.color.qui_common_text_primary);
        bs z16 = z();
        boolean z17 = false;
        if (z16 != null && z16.getThemeType() == 4) {
            z17 = true;
        }
        return (z17 && Intrinsics.areEqual(content, "\u5f85\u547d\u540d\u5730\u70b9")) ? p().getColor(R.color.qui_common_text_secondary_light) : color;
    }

    private final int C(String selectedColor, int defaultColorId) {
        int color = p().getColor(defaultColorId);
        if (selectedColor == null || selectedColor.length() == 0) {
            return color;
        }
        try {
            return Color.parseColor(selectedColor);
        } catch (IllegalArgumentException unused) {
            RFWLog.e(this.TAG, RFWLog.USR, "event Color parse exception:" + selectedColor);
            return color;
        }
    }

    private final void v(final za.a data) {
        LinearLayout linearLayout = this.contentContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            linearLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = data.getCom.tencent.mtt.hippy.dom.node.NodeProps.MAX_WIDTH java.lang.String();
        LinearLayout linearLayout3 = this.contentContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            linearLayout3 = null;
        }
        linearLayout3.setLayoutParams(layoutParams);
        TextView textView = this.contentTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTV");
            textView = null;
        }
        textView.setText(data.getEvent().getContent());
        int A = A(data.getEvent().getContent());
        if (data.getIsClicked()) {
            A = y();
        }
        TextView textView2 = this.contentTV;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTV");
            textView2 = null;
        }
        textView2.setTextColor(A);
        if (!data.getEvent().getDisable()) {
            LinearLayout linearLayout4 = this.contentContainer;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                linearLayout4 = null;
            }
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: fc.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.w(b.this, data, view);
                }
            });
        }
        LinearLayout linearLayout5 = this.contentContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        } else {
            linearLayout2 = linearLayout5;
        }
        x(linearLayout2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(b this$0, za.a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        bs z16 = this$0.z();
        if (z16 != null) {
            z16.X1(data);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x(View view) {
        fo.c.o(view, "em_qz_time_shaft_select", new fo.b());
    }

    private final int y() {
        bs z16 = z();
        Integer valueOf = z16 != null ? Integer.valueOf(z16.getThemeType()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            return C("#FFA928", R.color.qui_common_brand_standard);
        }
        if (valueOf != null && valueOf.intValue() == 4) {
            return C("#5A7DFF", R.color.qui_common_brand_standard);
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            return C("#FF64A3", R.color.qui_common_brand_standard);
        }
        return p().getColor(R.color.qui_common_brand_standard);
    }

    private final bs z() {
        n J = ((j) q(j.class)).J();
        if (J == null || !(J instanceof bs)) {
            return null;
        }
        return (bs) J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindData(za.a data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        v(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f162946nh1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.timeline_content)");
        this.contentTV = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f162947nh2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026meline_content_container)");
        this.contentContainer = (LinearLayout) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
