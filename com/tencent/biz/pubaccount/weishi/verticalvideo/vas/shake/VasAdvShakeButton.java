package com.tencent.biz.pubaccount.weishi.verticalvideo.vas.shake;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0014J\u0006\u0010\u000b\u001a\u00020\u0002J\u001c\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R.\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/shake/VasAdvShakeButton;", "Landroid/widget/RelativeLayout;", "", "e", "", "visibility", "setIconVisibility", "", "url", "setIconResUrl", NodeProps.ON_DETACHED_FROM_WINDOW, "a", "repeatCount", "repeatIntervalMillis", "c", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "d", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "gdtShakeIconView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "", "value", "f", "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/CharSequence;)V", "text", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class VasAdvShakeButton extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final GdtShakeIconView gdtShakeIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CharSequence text;

    public VasAdvShakeButton(Context context) {
        this(context, null, 0, 0, 14, null);
    }

    private final void e() {
        CharSequence charSequence;
        TextView textView = this.textView;
        if (this.gdtShakeIconView.getVisibility() == 0) {
            charSequence = getContext().getString(R.string.x_k) + ((Object) this.text);
        } else {
            charSequence = this.text;
        }
        textView.setText(charSequence);
    }

    public final void c(int repeatCount, int repeatIntervalMillis) {
        this.gdtShakeIconView.startAnimation(repeatCount, repeatIntervalMillis);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public final void setIconVisibility(int visibility) {
        this.gdtShakeIconView.setVisibility(visibility);
        e();
    }

    public final void setText(CharSequence charSequence) {
        this.text = charSequence;
        e();
    }

    public VasAdvShakeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public VasAdvShakeButton(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
    }

    public final void a() {
        setIconVisibility(8);
        this.gdtShakeIconView.stop();
        this.gdtShakeIconView.resetImageResource();
    }

    public final void setIconResUrl(String url) {
        if (url == null || url.length() == 0) {
            this.gdtShakeIconView.setImageResource();
        } else {
            this.gdtShakeIconView.setImageDrawable(URLDrawable.getDrawable(url, (URLDrawable.URLDrawableOptions) null));
        }
    }

    public /* synthetic */ VasAdvShakeButton(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    public final void b() {
        d(this, 0, 0, 3, null);
    }

    public VasAdvShakeButton(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        View.inflate(context, R.layout.f167391d24, this);
        View findViewById = findViewById(R.id.p8d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.vas_ad_shake_icon)");
        this.gdtShakeIconView = (GdtShakeIconView) findViewById;
        View findViewById2 = findViewById(R.id.p8c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.vas_ad_btn_text)");
        this.textView = (TextView) findViewById2;
    }

    public static /* synthetic */ void d(VasAdvShakeButton vasAdvShakeButton, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        if ((i17 & 2) != 0) {
            i16 = 5000;
        }
        vasAdvShakeButton.c(i3, i16);
    }
}
