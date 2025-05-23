package com.qzone.reborn.feedx.presenter.ad.appinfo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.widget.listitem.ab;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001b\u0010\u001fB!\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0018\u001a\u00020\u000b*\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/appinfo/TextViewWithDivider;", "Landroid/widget/LinearLayout;", "", "d", "", "content", IECSearchBar.METHOD_SET_TEXT, "setTextUnderline", "", "isNeedDiviver", "setDivider", "", "c", "Landroid/graphics/Paint;", "b", "Landroid/view/View;", "Landroid/view/View;", "divider", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "textView", "a", "(I)I", "dp", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class TextViewWithDivider extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View divider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewWithDivider(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        d();
    }

    public final int a(int i3) {
        return ar.e(i3 / (getContext().getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density));
    }

    public final Paint b() {
        TextView textView = this.textView;
        if (textView != null) {
            return textView.getPaint();
        }
        return null;
    }

    public final int c() {
        TextView textView = this.textView;
        if (textView != null) {
            return textView.getWidth();
        }
        return 0;
    }

    public final void setDivider(boolean isNeedDiviver) {
        View view = this.divider;
        if (view == null) {
            return;
        }
        view.setVisibility(isNeedDiviver ? 0 : 8);
    }

    public final void setText(CharSequence content) {
        Intrinsics.checkNotNullParameter(content, "content");
        TextView textView = this.textView;
        if (textView != null) {
            textView.setText(content);
        }
    }

    public final void setTextUnderline() {
        TextView textView = this.textView;
        TextPaint paint = textView != null ? textView.getPaint() : null;
        if (paint == null) {
            return;
        }
        paint.setFlags(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewWithDivider(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        d();
    }

    private final void d() {
        setGravity(17);
        setOrientation(0);
        View view = new View(getContext());
        this.divider = view;
        view.setBackgroundColor(-1);
        View view2 = this.divider;
        if (view2 != null) {
            ab.e(view2, a(4));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(1), a(8));
        layoutParams.setMarginStart(a(4));
        layoutParams.setMarginEnd(a(4));
        addView(this.divider, new LinearLayout.LayoutParams(layoutParams));
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        float f16 = 8 / (getContext().getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density);
        TextView textView2 = this.textView;
        if (textView2 != null) {
            textView2.setTextSize(1, f16);
        }
        TextView textView3 = this.textView;
        if (textView3 != null) {
            textView3.setSingleLine(true);
        }
        addView(this.textView, new LinearLayout.LayoutParams(-2, -2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextViewWithDivider(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        d();
    }
}
