package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00011B\u001f\b\u0007\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b.\u0010/J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JZ\u0010#\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010&\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010$H\u0017J\u0012\u0010)\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010'H\u0017\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/NoTouchWebView;", "Lcom/tencent/biz/ui/TouchWebView;", "Landroid/view/MotionEvent;", "event", "Landroid/view/View;", "view", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "dispatchTouchEvent", "onTouchEvent", "", HippyTKDListViewAdapter.X, "y", "", "scrollBy", "p0", "computeScroll", "left", "top", "oldLeft", "oldTop", "onScrollChanged", "scrollX", "scrollY", "clampedX", "clampedY", "onOverScrolled", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "v", "overScrollBy", "Lcom/tencent/biz/ui/TouchWebView$OnOverScrollHandler;", "handler", "setOnOverScrollHandler", "Lcom/tencent/biz/ui/TouchWebView$OnScrollChangedListener;", "scrollChangedListener", "addScrollChangedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class NoTouchWebView extends TouchWebView {
    @JvmOverloads
    public NoTouchWebView(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public void computeScroll(@Nullable View p06) {
        super_computeScroll();
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean dispatchTouchEvent(@Nullable MotionEvent event, @Nullable View view) {
        return super_dispatchTouchEvent(event);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean onInterceptTouchEvent(@Nullable MotionEvent event, @Nullable View view) {
        return super_onInterceptTouchEvent(event);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY, @Nullable View view) {
        super_onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public void onScrollChanged(int left, int top, int oldLeft, int oldTop, @Nullable View view) {
        super_onScrollChanged(left, top, oldLeft, oldTop);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean onTouchEvent(@Nullable MotionEvent event, @Nullable View view) {
        return super_onTouchEvent(event);
    }

    @Override // com.tencent.biz.ui.TouchWebView, com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent, @Nullable View v3) {
        return super_overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    @Override // android.view.View
    public void scrollBy(int x16, int y16) {
        getView().scrollBy(x16, y16);
    }

    public /* synthetic */ NoTouchWebView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    @JvmOverloads
    public NoTouchWebView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.biz.ui.TouchWebView
    @Deprecated(message = "")
    public void addScrollChangedListener(@Nullable TouchWebView.OnScrollChangedListener scrollChangedListener) {
    }

    @Override // com.tencent.biz.ui.TouchWebView
    @Deprecated(message = "")
    public void setOnOverScrollHandler(@Nullable TouchWebView.OnOverScrollHandler handler) {
    }
}
