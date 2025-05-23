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
import q3.c;
import q3.f;
import tl.h;
import x72.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/refresh/MainRefreshFooter;", "Lcom/qqnt/widget/smartrefreshlayout/layout/simple/SimpleComponent;", "Lq3/c;", "Lq3/f;", "refreshLayout", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "", "d", "", "noMoreData", "setNoMoreData", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MainRefreshFooter extends SimpleComponent implements c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView imageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRefreshFooter(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(o.e(20), o.e(20)));
        this.imageView = imageView;
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(o.e(4));
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(14.0f);
        textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_secondary));
        textView.setText(context.getString(R.string.x3u));
        textView.setVisibility(4);
        this.textView = textView;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, o.e(16), 0, o.e(32));
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        addView(linearLayout);
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, r3.i
    public void d(f refreshLayout, RefreshState oldState, RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        boolean z16 = newState == RefreshState.Loading;
        if (z16 && this.imageView.getDrawable() == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.imageView.setImageDrawable(a.a(context));
            this.textView.setText(getContext().getString(R.string.x3v));
            this.textView.setVisibility(0);
            return;
        }
        if (z16 || this.imageView.getDrawable() == null) {
            return;
        }
        this.imageView.setImageDrawable(null);
    }

    @Override // com.qqnt.widget.smartrefreshlayout.layout.simple.SimpleComponent, q3.c
    public boolean setNoMoreData(boolean noMoreData) {
        if (noMoreData) {
            this.imageView.setVisibility(8);
            this.textView.setText(getContext().getString(R.string.x3u));
            this.textView.setVisibility(0);
            return true;
        }
        this.imageView.setVisibility(0);
        this.textView.setVisibility(8);
        return true;
    }
}
