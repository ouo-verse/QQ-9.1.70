package com.tencent.qqnt.chathistory.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/widget/HistoryImmersiveTitleBar;", "Landroid/view/View;", "Landroid/content/Context;", "mContext", "", "a", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "d", "I", "mViewHeight", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class HistoryImmersiveTitleBar extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mViewHeight;

    public HistoryImmersiveTitleBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            a(context);
        }
    }

    private final void a(Context mContext) {
        Integer num;
        Resources resources;
        Integer num2 = null;
        if (mContext != null && (resources = mContext.getResources()) != null) {
            num = Integer.valueOf(resources.getIdentifier("status_bar_height", "dimen", "android"));
        } else {
            num = null;
        }
        if (num != null && num.intValue() > 0) {
            Resources resources2 = mContext.getResources();
            if (resources2 != null) {
                num2 = Integer.valueOf(resources2.getDimensionPixelSize(num.intValue()));
            }
            Intrinsics.checkNotNull(num2);
            this.mViewHeight = num2.intValue();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
        } else {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.mViewHeight, 1073741824));
            setMeasuredDimension(getMeasuredWidth(), this.mViewHeight);
        }
    }
}
