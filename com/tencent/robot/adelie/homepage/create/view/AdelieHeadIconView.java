package com.tencent.robot.adelie.homepage.create.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.util.LoadingUtil;
import com.tencent.util.URLUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00017B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0013J\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c0\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0016\u0010*\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00068"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/view/AdelieHeadIconView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "onPreviewClick", "onChangeClick", "", "f", "c", "Landroid/view/View;", "d", "Landroid/graphics/drawable/Drawable;", "drawable", "setDrawable", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "setBitmap", "", "url", "setImageViewUrl", "", NodeProps.ENABLED, "setEnabled", "Lcom/tencent/robot/adelie/homepage/create/view/ImageCategory;", "category", "setImageCategory", "show", "i", "", "", "e", "Landroid/view/View;", "contentView", "Landroid/widget/RelativeLayout;", "headContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "headImageView", tl.h.F, "changeIconView", "loadingView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hasSetImage", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/adelie/homepage/create/view/ImageCategory;", "imageCategory", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHeadIconView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ImageCategory imageCategory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout headContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView headImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView changeIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View loadingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasSetImage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHeadIconView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        TextView textView;
        this.hasSetImage = true;
        ImageView imageView = this.changeIconView;
        if (imageView != null) {
            imageView.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.qui_edit, R.color.qui_common_icon_secondary, 1001));
        }
        View view = this.contentView;
        if (view != null && (textView = (TextView) view.findViewById(R.id.at_)) != null) {
            textView.setText("\u66f4\u6539\u5f62\u8c61");
            textView.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        }
    }

    private final void f(final View.OnClickListener onPreviewClick, final View.OnClickListener onChangeClick) {
        String str;
        View view = this.contentView;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.d39);
        this.headImageView = imageView;
        if (imageView != null && URLUtil.isValidUrl("https://grouppro.gtimg.cn/wupload/xy/qq_channel/common_pic/cmFk4t8T.png")) {
            Option url = Option.obtain().setTargetView(imageView).setUrl("https://grouppro.gtimg.cn/wupload/xy/qq_channel/common_pic/cmFk4t8T.png");
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            Option option = url.setLoadingDrawable(drawable).setFailDrawable(drawable);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        }
        ImageView imageView2 = this.headImageView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdelieHeadIconView.g(AdelieHeadIconView.this, onPreviewClick, onChangeClick, view2);
                }
            });
        }
        ImageView imageView3 = (ImageView) view.findViewById(R.id.trg);
        this.changeIconView = imageView3;
        if (imageView3 != null) {
            imageView3.setImageDrawable(ie0.a.f().o(getContext(), R.drawable.qui_add, R.color.qui_common_brand_standard, 1001));
        }
        final RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.x7y);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdelieHeadIconView.h(AdelieHeadIconView.this, onPreviewClick, relativeLayout, onChangeClick, view2);
            }
        });
        this.headContainer = relativeLayout;
        ImageView imageView4 = (ImageView) view.findViewById(R.id.a87);
        if (je0.a.a(BaseApplication.getContext())) {
            str = "https://grouppro.gtimg.cn/wupload/xy/qq_channel/common_pic/NM3mlhPo.png";
        } else {
            str = "https://grouppro.gtimg.cn/wupload/xy/qq_channel/common_pic/3cgAmNlJ.png";
        }
        if (URLUtil.isValidUrl(str)) {
            Option url2 = Option.obtain().setTargetView(imageView4).setUrl(str);
            Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
            Option option2 = url2.setLoadingDrawable(drawable2).setFailDrawable(drawable2);
            QQPicLoader qQPicLoader2 = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option2, "option");
            qQPicLoader2.e(option2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AdelieHeadIconView this$0, View.OnClickListener onPreviewClick, View.OnClickListener onChangeClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onPreviewClick, "$onPreviewClick");
        Intrinsics.checkNotNullParameter(onChangeClick, "$onChangeClick");
        if (this$0.hasSetImage) {
            onPreviewClick.onClick(view);
        } else {
            onChangeClick.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AdelieHeadIconView this$0, View.OnClickListener onPreviewClick, RelativeLayout relativeLayout, View.OnClickListener onChangeClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onPreviewClick, "$onPreviewClick");
        Intrinsics.checkNotNullParameter(onChangeClick, "$onChangeClick");
        if (this$0.hasSetImage) {
            onPreviewClick.onClick(relativeLayout);
        } else {
            onChangeClick.onClick(relativeLayout);
        }
        VideoReport.reportEvent("clck", relativeLayout, this$0.e());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    public final View d(@NotNull View.OnClickListener onPreviewClick, @NotNull View.OnClickListener onChangeClick) {
        Intrinsics.checkNotNullParameter(onPreviewClick, "onPreviewClick");
        Intrinsics.checkNotNullParameter(onChangeClick, "onChangeClick");
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        this.contentView = LayoutInflater.from(getContext()).inflate(R.layout.f167568ds0, this);
        f(onPreviewClick, onChangeClick);
        return this.contentView;
    }

    @NotNull
    public final Map<String, Object> e() {
        Map<String, Object> mapOf;
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("image_category", Integer.valueOf(this.imageCategory.getValue()));
        if (!this.hasSetImage) {
            i3 = 1;
        }
        pairArr[1] = TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, Integer.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    public final void i(boolean show) {
        RelativeLayout relativeLayout;
        setEnabled(!show);
        View view = this.contentView;
        if (view == null) {
            return;
        }
        if (this.loadingView == null) {
            View loadingView = LoadingUtil.getLoadingView(getContext(), ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f), 1);
            this.loadingView = loadingView;
            if (loadingView != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f));
                layoutParams.addRule(13);
                loadingView.setLayoutParams(layoutParams);
            }
        }
        if (show) {
            View view2 = this.loadingView;
            if (view2 != null) {
                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.x7y);
                if (relativeLayout2 != null) {
                    relativeLayout2.removeView(view2);
                }
                RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.x7y);
                if (relativeLayout3 != null) {
                    relativeLayout3.addView(view2);
                    return;
                }
                return;
            }
            return;
        }
        View view3 = this.loadingView;
        if (view3 != null && (relativeLayout = (RelativeLayout) view.findViewById(R.id.x7y)) != null) {
            relativeLayout.removeView(view3);
        }
    }

    public final void setBitmap(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ImageView imageView = this.headImageView;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        c();
    }

    public final void setDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        ImageView imageView = this.headImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        c();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ImageView imageView = this.headImageView;
        if (imageView != null) {
            imageView.setEnabled(enabled);
        }
    }

    public final void setImageCategory(@NotNull ImageCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.imageCategory = category;
    }

    public final void setImageViewUrl(@Nullable String url) {
        ImageView imageView;
        if (url != null && (imageView = this.headImageView) != null) {
            CommonExKt.h(imageView, url, null, null, null, 14, null);
        }
        c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHeadIconView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieHeadIconView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieHeadIconView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.imageCategory = ImageCategory.NO_IMAGE;
    }
}
