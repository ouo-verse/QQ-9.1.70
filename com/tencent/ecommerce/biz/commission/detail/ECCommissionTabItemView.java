package com.tencent.ecommerce.biz.commission.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionTabItemView;", "Landroid/widget/LinearLayout;", "", "a", "b", "", "weight", "setLeftWeight", "setRightWeight", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "e", "Landroid/view/View;", "divideLine", "f", "leftView", h.F, "rightView", "Landroid/content/Context;", "context", "", "text", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionTabItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View divideLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View leftView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View rightView;

    public ECCommissionTabItemView(Context context, String str) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.cpi, this);
        TextView textView = (TextView) findViewById(R.id.oc7);
        this.textView = textView;
        this.divideLine = findViewById(R.id.nvm);
        this.leftView = findViewById(R.id.o2i);
        this.rightView = findViewById(R.id.f163094o93);
        textView.setText(str);
    }

    public final void a() {
        this.divideLine.setVisibility(0);
    }

    public final void b() {
        this.divideLine.setVisibility(4);
    }

    public final void setLeftWeight(float weight) {
        ViewGroup.LayoutParams layoutParams = this.leftView.getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).weight = weight;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final void setRightWeight(float weight) {
        ViewGroup.LayoutParams layoutParams = this.rightView.getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).weight = weight;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
