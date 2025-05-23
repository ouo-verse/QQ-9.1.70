package com.tencent.mobileqq.activity.aio.zplan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.widget.BounceScrollView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanCoupleScrollView;", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "Landroid/view/MotionEvent;", "ev", "", "onTouchEvent", "Lcom/tencent/mobileqq/activity/aio/zplan/b;", "callback", "", IECSearchBar.METHOD_SET_CALLBACK, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/activity/aio/zplan/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ZPlanCoupleScrollView extends BounceScrollView {

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private b callback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPlanCoupleScrollView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.widget.BounceScrollView, com.tencent.widget.ScrollView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16;
        b bVar = this.callback;
        if (bVar != null) {
            z16 = bVar.onTouchEvent(ev5);
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        return super.onTouchEvent(ev5);
    }

    public final void setCallback(@Nullable b callback) {
        this.callback = callback;
    }

    public /* synthetic */ ZPlanCoupleScrollView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPlanCoupleScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
