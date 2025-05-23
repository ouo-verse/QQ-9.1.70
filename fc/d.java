package fc;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.l;
import com.qzone.reborn.base.n;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hb.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc.bs;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0013H\u0014J(\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\t2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0014R\u0014\u0010!\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010-R\u0016\u00100\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010-\u00a8\u00063"}, d2 = {"Lfc/d;", "Lcom/qzone/reborn/base/l;", "Lza/a;", "data", "", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", HippyTKDListViewAdapter.X, "", "B", BdhLogUtil.LogTag.Tag_Conn, "", "selectedColor", "defaultColorId", "H", "y", "Lnc/bs;", "D", "Landroid/view/View;", "view", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "getViewStubLayoutId", "containerView", "onInitView", "position", "", "", "payload", UserInfo.SEX_FEMALE, "e", "Ljava/lang/String;", "TAG", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleTV", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "iconIV", "i", "descTV", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", ParseCommon.CONTAINER, "topLine", "bottomLine", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends l<za.a> {

    /* renamed from: C, reason: from kotlin metadata */
    private View topLine;

    /* renamed from: D, reason: from kotlin metadata */
    private View bottomLine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumTimelineTitleSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView titleTV;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView iconIV;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView descTV;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View container;

    private final void A(View view) {
        fo.c.o(view, "em_qz_time_shaft_select", new fo.b());
    }

    private final int B(za.a data) {
        if (data.getIsFirst()) {
            return R.drawable.qui_time;
        }
        bs D = D();
        Integer valueOf = D != null ? Integer.valueOf(D.getThemeType()) : null;
        return (valueOf != null && valueOf.intValue() == 2) ? R.drawable.qui_cake : (valueOf != null && valueOf.intValue() == 4) ? R.drawable.qui_plane : (valueOf != null && valueOf.intValue() == 3) ? R.drawable.qui_heart : R.drawable.qui_time;
    }

    private final int C() {
        bs D = D();
        Integer valueOf = D != null ? Integer.valueOf(D.getThemeType()) : null;
        if (valueOf != null && valueOf.intValue() == 2) {
            return H("#FFA928", R.color.qui_common_brand_standard);
        }
        if (valueOf != null && valueOf.intValue() == 4) {
            return H("#5A7DFF", R.color.qui_common_brand_standard);
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            return H("#FF64A3", R.color.qui_common_brand_standard);
        }
        return p().getColor(R.color.qui_common_brand_standard);
    }

    private final bs D() {
        n J = ((j) q(j.class)).J();
        if (J == null || !(J instanceof bs)) {
            return null;
        }
        return (bs) J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(d this$0, za.a data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        bs D = this$0.D();
        if (D != null) {
            D.X1(data);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int H(String selectedColor, int defaultColorId) {
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

    private final void v(za.a data) {
        View view = this.container;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = data.getCom.tencent.mtt.hippy.dom.node.NodeProps.MAX_WIDTH java.lang.String();
        View view3 = this.container;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            view2 = view3;
        }
        view2.setLayoutParams(layoutParams);
    }

    private final void w(za.a data) {
        int color = p().getColor(R.color.qui_common_text_primary);
        if (data.getIsClicked()) {
            color = C();
        }
        TextView textView = this.descTV;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTV");
            textView = null;
        }
        textView.setText(data.getEvent().getContent());
        TextView textView3 = this.descTV;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descTV");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(color);
    }

    private final void x(za.a data) {
        ImageView imageView = null;
        if (data.getIsLast()) {
            int i3 = QQTheme.isNowThemeIsNightForQzone() ? R.drawable.f14267e : R.drawable.f14257d;
            ImageView imageView2 = this.iconIV;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconIV");
                imageView2 = null;
            }
            ImageView imageView3 = this.iconIV;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconIV");
                imageView3 = null;
            }
            imageView2.setImageDrawable(imageView3.getResources().getDrawable(i3, null));
            return;
        }
        ImageView imageView4 = this.iconIV;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconIV");
            imageView4 = null;
        }
        ImageView imageView5 = this.iconIV;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconIV");
            imageView5 = null;
        }
        imageView4.setImageDrawable(imageView5.getResources().getDrawable(B(data), null));
        int C = C();
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView6 = this.iconIV;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconIV");
        } else {
            imageView = imageView6;
        }
        a16.m(imageView, C);
    }

    private final void y(za.a data) {
        View view = null;
        if (data.getIsFirst()) {
            View view2 = this.topLine;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topLine");
                view2 = null;
            }
            view2.setVisibility(4);
        }
        if (data.getIsLast()) {
            View view3 = this.bottomLine;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomLine");
            } else {
                view = view3;
            }
            view.setVisibility(4);
        }
    }

    private final void z(za.a data) {
        int color = p().getColor(R.color.qui_common_text_primary);
        if (data.getIsClicked()) {
            color = C();
        }
        TextView textView = this.titleTV;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTV");
            textView = null;
        }
        textView.setText(data.getEvent().getTitle());
        TextView textView3 = this.titleTV;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindData(final za.a data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        v(data);
        x(data);
        w(data);
        z(data);
        y(data);
        View view = null;
        if (!data.getEvent().getDisable()) {
            View view2 = this.container;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                view2 = null;
            }
            view2.setOnClickListener(new View.OnClickListener() { // from class: fc.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    d.G(d.this, data, view3);
                }
            });
        }
        View view3 = this.container;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            view = view3;
        }
        A(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nha);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.timeline_title)");
        this.titleTV = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nhb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026timeline_title_container)");
        this.container = findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f162948nh3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.timeline_desc)");
        this.descTV = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.nh5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.timeline_icon)");
        this.iconIV = (ImageView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.nh8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.timeline_line_top)");
        this.topLine = findViewById5;
        View findViewById6 = containerView.findViewById(R.id.nh7);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026.id.timeline_line_bottom)");
        this.bottomLine = findViewById6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
