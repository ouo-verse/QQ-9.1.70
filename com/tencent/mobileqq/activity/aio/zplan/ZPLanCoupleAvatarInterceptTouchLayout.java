package com.tencent.mobileqq.activity.aio.zplan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/zplan/ZPLanCoupleAvatarInterceptTouchLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "ev", "", "onTouchEvent", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "", "d", "Ljava/lang/String;", "peerUin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/util/AttributeSet;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ZPLanCoupleAvatarInterceptTouchLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUin;

    public /* synthetic */ ZPLanCoupleAvatarInterceptTouchLayout(Context context, String str, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i3 & 4) != 0 ? null : attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ViewUtils.f352270a.e(), 1073741824), heightMeasureSpec);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent ev5) {
        if (ev5 == null) {
            return true;
        }
        if (ev5.getY() <= ViewUtils.f352270a.b(30)) {
            return false;
        }
        super.onTouchEvent(ev5);
        QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
        com.tencent.mobileqq.zplan.aio.couple.i a16 = IZPlanCoupleSceneHelper.a.a((IZPlanCoupleSceneHelper) api, this.peerUin, null, 2, null);
        if (a16 != null) {
            a16.m();
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPLanCoupleAvatarInterceptTouchLayout(@NotNull Context context, @NotNull String peerUin, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        this.peerUin = peerUin;
    }
}
