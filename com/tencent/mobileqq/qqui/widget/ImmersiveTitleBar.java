package com.tencent.mobileqq.qqui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0014R\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqui/widget/ImmersiveTitleBar;", "Landroid/view/View;", "Landroid/content/Context;", "mContext", "", "a", "", "height", "setCustomHeight", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "d", "I", "mStatusBarHeight", "e", "getMViewHeight", "()I", "setMViewHeight", "(I)V", "mViewHeight", "", "f", "Z", "TRANSLUCENT_STATUS_BAR", h.F, "getMNeedDrawStatus", "()Z", "setMNeedDrawStatus", "(Z)V", "mNeedDrawStatus", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ImmersiveTitleBar extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mStatusBarHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mViewHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean TRANSLUCENT_STATUS_BAR;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedDrawStatus;

    public ImmersiveTitleBar(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.TRANSLUCENT_STATUS_BAR = true;
        this.mNeedDrawStatus = true;
        a(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (com.tencent.widget.immersive.ImmersiveUtils.isSupporImmersive() == 1) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@Nullable Context mContext) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) mContext);
            return;
        }
        if (this.TRANSLUCENT_STATUS_BAR) {
            z16 = true;
        }
        z16 = false;
        this.mNeedDrawStatus = z16;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(mContext);
        this.mStatusBarHeight = statusBarHeight;
        if (this.mNeedDrawStatus) {
            setCustomHeight(statusBarHeight);
        } else {
            setCustomHeight(0);
        }
        if (QQTheme.isDefaultOrDIYTheme()) {
            setBackgroundResource(R.drawable.skin_header_bar_bg);
        } else {
            setBackgroundColor(getResources().getColor(R.color.skin_color_title_immersive_bar));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
        } else {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.mViewHeight, 1073741824));
            setMeasuredDimension(getMeasuredWidth(), this.mViewHeight);
        }
    }

    public final void setCustomHeight(int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, height);
        } else {
            this.mViewHeight = height;
            requestLayout();
        }
    }

    public final void setMNeedDrawStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mNeedDrawStatus = z16;
        }
    }

    public final void setMViewHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mViewHeight = i3;
        }
    }
}
