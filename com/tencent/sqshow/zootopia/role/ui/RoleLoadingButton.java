package com.tencent.sqshow.zootopia.role.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/RoleLoadingButton;", "Landroid/widget/FrameLayout;", "", "c", "", "id", IECSearchBar.METHOD_SET_TEXT, "", "text", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "setIcon", "Landroid/view/View$OnClickListener;", "onClickListener", "setOnClickListenerWithLoading", "", "sp", "setTextSize", "color", "setTextColor", "e", "b", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "buttonView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "loadingView", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "f", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "iconView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RoleLoadingButton extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView buttonView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZPlanMediaView iconView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleLoadingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.db6, this);
        setClipChildren(false);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RoleLoadingButton this$0, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.loadingView;
        boolean z16 = false;
        if (imageView != null && imageView.getVisibility() == 8) {
            z16 = true;
        }
        if (!z16 || onClickListener == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public final void b() {
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ZPlanMediaView zPlanMediaView = this.iconView;
        if (zPlanMediaView != null) {
            zPlanMediaView.setVisibility(0);
        }
        TextView textView = this.buttonView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ImageView imageView2 = this.loadingView;
        if (imageView2 != null) {
            imageView2.clearAnimation();
        }
    }

    public final void e() {
        ImageView imageView = this.loadingView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ZPlanMediaView zPlanMediaView = this.iconView;
        if (zPlanMediaView != null) {
            zPlanMediaView.setVisibility(8);
        }
        TextView textView = this.buttonView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        ImageView imageView2 = this.loadingView;
        if (imageView2 != null) {
            imageView2.startAnimation(rotateAnimation);
        }
    }

    public final void setIcon(pu4.g material) {
        Intrinsics.checkNotNullParameter(material, "material");
        ZPlanMediaView zPlanMediaView = this.iconView;
        if (zPlanMediaView != null) {
            zPlanMediaView.setVisibility(0);
        }
        ZPlanMediaView zPlanMediaView2 = this.iconView;
        if (zPlanMediaView2 != null) {
            zPlanMediaView2.e(material);
        }
    }

    public final void setOnClickListenerWithLoading(final View.OnClickListener onClickListener) {
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.role.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoleLoadingButton.d(RoleLoadingButton.this, onClickListener, view);
            }
        });
    }

    public final void setText(int id5) {
        TextView textView = this.buttonView;
        if (textView != null) {
            textView.setText(id5);
        }
    }

    public final void setTextColor(int color) {
        TextView textView = this.buttonView;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public final void setTextSize(float sp5) {
        TextView textView = this.buttonView;
        if (textView != null) {
            textView.setTextSize(1, sp5);
        }
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.buttonView;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void c() {
        this.buttonView = (TextView) findViewById(R.id.r7n);
        this.loadingView = (ImageView) findViewById(R.id.r7o);
        this.iconView = (ZPlanMediaView) findViewById(R.id.r7m);
    }
}
