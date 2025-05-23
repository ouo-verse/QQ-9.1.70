package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b&\u0010*B#\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010+\u001a\u00020\u0005\u00a2\u0006\u0004\b&\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u0005R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneTitleIconWithTextButton;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Luh/d;", "", "n0", "", "getLayoutId", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, com.tencent.luggage.wxa.c8.c.G, "m0", "colorInt", "o0", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "getButtonContainer", "()Landroid/view/ViewGroup;", "setButtonContainer", "(Landroid/view/ViewGroup;)V", "buttonContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "getIconImage", "()Landroid/widget/ImageView;", "setIconImage", "(Landroid/widget/ImageView;)V", "iconImage", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "getIconText", "()Landroid/widget/TextView;", "setIconText", "(Landroid/widget/TextView;)V", "iconText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneTitleIconWithTextButton extends QZoneBaseWidgetView<uh.d> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup buttonContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView iconImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView iconText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneTitleIconWithTextButton(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        n0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130368k;
    }

    public final void o0(int colorInt) {
        com.tencent.mobileqq.qzone.picload.c.a().m(this.iconImage, colorInt);
        TextView textView = this.iconText;
        if (textView != null) {
            textView.setTextColor(colorInt);
        }
        TextView textView2 = this.iconText;
        if (textView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.e(com.qzone.reborn.feedpro.utils.aa.f54263a, textView2, 0.0f, 1, null);
        }
    }

    public final void setButtonContainer(ViewGroup viewGroup) {
        this.buttonContainer = viewGroup;
    }

    public final void setIconImage(ImageView imageView) {
        this.iconImage = imageView;
    }

    public final void setIconText(TextView textView) {
        this.iconText = textView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneTitleIconWithTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        n0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(uh.d item, int pos) {
        if (item != null) {
            AccessibilityUtil.p(this, item.getContentDescription());
            TextView textView = this.iconText;
            if (textView != null) {
                textView.setText(item.getButtonText());
            }
            ImageView imageView = this.iconImage;
            if (imageView != null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ImageView imageView2 = this.iconImage;
            if (imageView2 != null) {
                imageView2.setImageResource(item.getDrawableId());
            }
            TextView textView2 = this.iconText;
            if (textView2 != null) {
                com.qzone.reborn.feedpro.utils.aa.e(com.qzone.reborn.feedpro.utils.aa.f54263a, textView2, 0.0f, 1, null);
            }
            ImageView imageView3 = this.iconImage;
            if (imageView3 != null) {
                com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView3, 0.0f, 1, null);
            }
            setOnClickListener(item.getOnClickListener());
            setOnLongClickListener(item.getOnLongClickListener());
            if (item.getButtonText().length() == 0) {
                TextView textView3 = this.iconText;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
                setPadding(rVar.e(6), rVar.e(6), rVar.e(6), rVar.e(6));
                return;
            }
            TextView textView4 = this.iconText;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            com.qzone.reborn.util.r rVar2 = com.qzone.reborn.util.r.f59560a;
            setPadding(rVar2.e(8), rVar2.e(6), rVar2.e(10), rVar2.e(6));
        }
    }

    private final void n0() {
        this.buttonContainer = (ViewGroup) findViewById(R.id.mxc);
        this.iconImage = (ImageView) findViewById(R.id.mxd);
        this.iconText = (TextView) findViewById(R.id.mxe);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneTitleIconWithTextButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        n0();
    }
}
