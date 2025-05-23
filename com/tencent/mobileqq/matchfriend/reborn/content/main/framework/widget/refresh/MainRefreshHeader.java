package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.refresh;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q3.d;
import q3.f;
import tl.h;
import x72.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003J \u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/refresh/MainRefreshHeader;", "Lcom/qqnt/widget/smartrefreshlayout/layout/simple/SimpleComponent;", "Lq3/d;", "", "resid", "", "setLoadingText", "Lq3/f;", "refreshLayout", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "d", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MainRefreshHeader extends SimpleComponent implements d {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView imageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRefreshHeader(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, o.e(50)));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(o.e(20), o.e(20)));
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        this.textView = textView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(o.e(4));
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(14.0f);
        textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_secondary));
        textView.setText(context.getString(R.string.x3v));
        linearLayout.addView(textView);
        addView(linearLayout);
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, r3.i
    public void d(f refreshLayout, RefreshState oldState, RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        boolean z16 = newState == RefreshState.Refreshing || newState == RefreshState.PullDownToRefresh || newState == RefreshState.ReleaseToRefresh || newState == RefreshState.RefreshReleased || newState == RefreshState.RefreshFinish || newState == RefreshState.PullDownCanceled;
        if (z16 && this.imageView.getDrawable() == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.imageView.setImageDrawable(a.a(context));
        } else {
            if (z16 || this.imageView.getDrawable() == null) {
                return;
            }
            this.imageView.setImageDrawable(null);
        }
    }

    public final void setLoadingText(int resid) {
        this.textView.setText(resid);
    }
}
