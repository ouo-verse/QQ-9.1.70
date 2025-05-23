package com.tencent.biz.qqcircle.immersive.datacardcover.part;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0003\u0010\u000b\u001a\u00020\b\u0012\b\b\u0003\u0010\r\u001a\u00020\b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/part/j;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "d", "I", "ivRes", "e", "tvColor", "f", "tvText", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tvTitle", "<init>", "(III)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class j extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int ivRes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int tvColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int tvText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    public /* synthetic */ j(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? R.drawable.qvideo_skin_icon_nav_arrow_left : i3, (i18 & 2) != 0 ? R.color.qvideo_skin_color_text_primary : i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCoverTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.du6);
        ImageView imageView = (ImageView) findViewById;
        imageView.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(getContext(), this.ivRes));
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Im\u2026ontext, ivRes))\n        }");
        this.ivBack = imageView;
        View findViewById2 = rootView.findViewById(R.id.kbs);
        TextView textView = (TextView) findViewById2;
        textView.setTextColor(QCircleSkinHelper.getInstance().getColor(this.tvColor));
        textView.setText(com.dataline.util.j.d(getContext().getString(this.tvText)));
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Te\u2026String(tvText))\n        }");
        this.tvTitle = textView;
        ImageView imageView2 = this.ivBack;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.z9(j.this, view);
            }
        });
    }

    public j(@DrawableRes int i3, @ColorRes int i16, @StringRes int i17) {
        this.ivRes = i3;
        this.tvColor = i16;
        this.tvText = i17;
    }
}
