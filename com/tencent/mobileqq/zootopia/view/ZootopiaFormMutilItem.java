package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormMutiItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaFormMutilItem;", "Lcom/tencent/mobileqq/widget/FormMutiItem;", "Landroid/view/View$OnClickListener;", "listener", "", "setSecondTextClickListener", "", "selected", "setIsSelected", "Landroid/view/View;", "k", "", "text", "", "rightDrawableRes", "setSecondLineText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "k0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaFormMutilItem extends FormMutiItem {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaFormMutilItem(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final View k() {
        return this.f315659d0;
    }

    public final void setSecondLineText(CharSequence text, int rightDrawableRes) {
        super.setSecondLineText(text);
        Drawable drawable = getResources().getDrawable(rightDrawableRes);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f315659d0.setCompoundDrawables(null, null, drawable, null);
    }

    public final void setSecondTextClickListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextView textView = this.f315659d0;
        if (textView != null) {
            textView.setOnClickListener(listener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaFormMutilItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    public final void setIsSelected(boolean selected) {
        setRightIcon(selected ? getResources().getDrawable(R.drawable.qq_account_select_icon) : null, ViewUtils.dpToPx(18.0f), ViewUtils.dpToPx(18.0f));
    }
}
