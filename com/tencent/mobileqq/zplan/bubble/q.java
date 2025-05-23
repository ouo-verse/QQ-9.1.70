package com.tencent.mobileqq.zplan.bubble;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.zplan.bubble.c;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import yi3.ZPlanInformationBubbleInfo;
import yi3.ZPlanStatusBubbleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/q;", "Lcom/tencent/mobileqq/zplan/bubble/c;", "Lyi3/d;", "e", "Lyi3/e;", "newBubbleInfo", "", "b", "", "onCreate", "onShow", "onHide", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "a", "Lyi3/d;", "bubbleInfo", "Lcom/tencent/mobileqq/zplan/bubble/m;", "Lcom/tencent/mobileqq/zplan/bubble/m;", "informationBubbleViewController", "", "f", "()Ljava/lang/String;", "text", "isClickable", "()Z", "Landroid/graphics/Rect;", "d", "()Landroid/graphics/Rect;", "globalVisibleRect", "", "parentWidthPx", "parentHeightPx", "<init>", "(Landroid/widget/FrameLayout;IILyi3/d;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class q implements c<ZPlanStatusBubbleInfo> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ZPlanStatusBubbleInfo bubbleInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final m informationBubbleViewController;

    public q(FrameLayout parent, int i3, int i16, ZPlanStatusBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        this.bubbleInfo = bubbleInfo;
        this.informationBubbleViewController = new m(parent, i3, i16, new ZPlanInformationBubbleInfo(bubbleInfo.getId(), this.bubbleInfo.getShowExpire(), f()));
    }

    private final String f() {
        QRouteApi api = QRoute.api(IOnLineStatueHelperApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IOnLineStatueHelperApi::class.java)");
        String str = ((IOnLineStatueHelperApi) api).getOnlineStatusItem(AppRuntime.Status.online, this.bubbleInfo.getId(), false).f255502o;
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.checkNotNullExpressionValue(str, "{\n            bubbleStr\n        }");
            return str;
        }
        return this.bubbleInfo.getText();
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void a(FrameLayout parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.informationBubbleViewController.a(parent);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public boolean b(yi3.e newBubbleInfo) {
        Intrinsics.checkNotNullParameter(newBubbleInfo, "newBubbleInfo");
        if (!(newBubbleInfo instanceof ZPlanStatusBubbleInfo)) {
            return false;
        }
        this.bubbleInfo = (ZPlanStatusBubbleInfo) newBubbleInfo;
        return this.informationBubbleViewController.b(new ZPlanInformationBubbleInfo(newBubbleInfo.getId(), newBubbleInfo.getShowExpire(), f()));
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public Rect d() {
        return this.informationBubbleViewController.d();
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    /* renamed from: e, reason: from getter and merged with bridge method [inline-methods] */
    public ZPlanStatusBubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    /* renamed from: isClickable */
    public boolean getIsClickable() {
        return this.informationBubbleViewController.getIsClickable();
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onCreate() {
        this.informationBubbleViewController.onCreate();
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onDestroy() {
        this.informationBubbleViewController.onDestroy();
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onHide() {
        this.informationBubbleViewController.f().f399148c.setCompoundDrawables(null, null, null, null);
        this.informationBubbleViewController.onHide();
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onShow() {
        this.informationBubbleViewController.onShow();
        int n3 = Utils.n(15.0f, MobileQQ.sMobileQQ.getResources());
        this.bubbleInfo.getIcon().setBounds(0, 0, n3, n3);
        this.informationBubbleViewController.f().f399148c.setCompoundDrawablePadding(Utils.n(3.0f, MobileQQ.sMobileQQ.getResources()));
        this.informationBubbleViewController.f().f399148c.setCompoundDrawables(this.bubbleInfo.getIcon(), null, null, null);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void setOnClickListener(View.OnClickListener onClickListener) {
        c.a.a(this, onClickListener);
    }
}
