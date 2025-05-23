package com.tencent.mobileqq.partner.signin.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/drawer/AIODrawerViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Lcom/tencent/aio/frame/api/a;", "d", "Lcom/tencent/aio/frame/api/a;", "getHelper", "()Lcom/tencent/aio/frame/api/a;", "setHelper", "(Lcom/tencent/aio/frame/api/a;)V", "helper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class AIODrawerViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.frame.api.a helper;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AIODrawerViewPager(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        com.tencent.aio.frame.api.a aVar;
        com.tencent.aio.frame.api.b a16;
        com.tencent.aio.frame.api.a aVar2;
        com.tencent.aio.frame.api.b a17;
        com.tencent.aio.frame.api.a aVar3;
        com.tencent.aio.frame.api.b a18;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() == 0 && (aVar3 = this.helper) != null && (a18 = aVar3.a()) != null) {
            a18.requestDisallowInterceptTouchEvent(true);
        }
        if (ev5.getAction() == 1 && (aVar2 = this.helper) != null && (a17 = aVar2.a()) != null) {
            a17.requestDisallowInterceptTouchEvent(false);
        }
        if (ev5.getAction() == 3 && (aVar = this.helper) != null && (a16 = aVar.a()) != null) {
            a16.requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(ev5);
    }

    public final void setHelper(com.tencent.aio.frame.api.a aVar) {
        this.helper = aVar;
    }

    public /* synthetic */ AIODrawerViewPager(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIODrawerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new com.tencent.aio.frame.api.a(this);
    }
}
