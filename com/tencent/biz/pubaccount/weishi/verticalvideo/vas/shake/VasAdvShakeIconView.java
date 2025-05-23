package com.tencent.biz.pubaccount.weishi.verticalvideo.vas.shake;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.verticalvideo.vas.shake.VasAdvShakeIconView;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0014R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/shake/VasAdvShakeIconView;", "Landroid/widget/RelativeLayout;", "", "repeatCount", "repeatIntervalMillis", "", "c", "", "url", "title", "setData", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "d", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "gdtShakeIconView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class VasAdvShakeIconView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final GdtShakeIconView gdtShakeIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    public VasAdvShakeIconView(Context context) {
        this(context, null, 0, 0, 14, null);
    }

    private final void c(int repeatCount, int repeatIntervalMillis) {
        this.gdtShakeIconView.startAnimation(repeatCount, repeatIntervalMillis);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gdtShakeIconView.stop();
        this.gdtShakeIconView.resetImageResource();
    }

    public VasAdvShakeIconView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public VasAdvShakeIconView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
    }

    public /* synthetic */ VasAdvShakeIconView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    public VasAdvShakeIconView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        View.inflate(context, R.layout.f167392d25, this);
        View findViewById = findViewById(R.id.p8d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.vas_ad_shake_icon)");
        this.gdtShakeIconView = (GdtShakeIconView) findViewById;
        View findViewById2 = findViewById(R.id.p8c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.vas_ad_btn_text)");
        this.textView = (TextView) findViewById2;
    }

    public final void setData(String url, String title) {
        if (url == null || url.length() == 0) {
            this.gdtShakeIconView.setImageResource();
        } else {
            this.gdtShakeIconView.setImageDrawable(URLDrawable.getDrawable(url, (URLDrawable.URLDrawableOptions) null));
        }
        postDelayed(new Runnable() { // from class: w10.b
            @Override // java.lang.Runnable
            public final void run() {
                VasAdvShakeIconView.d(VasAdvShakeIconView.this, 0, 0, 3, null);
            }
        }, 300L);
        TextView textView = this.textView;
        if (title == null || title.length() == 0) {
            title = getContext().getString(R.string.x_l);
        }
        textView.setText(title);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(VasAdvShakeIconView vasAdvShakeIconView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 2;
        }
        if ((i17 & 2) != 0) {
            i16 = PlayerResources.ViewId.GET_MORE_TOGGLE_AREA;
        }
        vasAdvShakeIconView.c(i3, i16);
    }
}
