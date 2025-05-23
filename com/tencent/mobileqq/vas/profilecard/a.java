package com.tencent.mobileqq.vas.profilecard;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenKuikly;
import com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenSp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/profilecard/a;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileComponent;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "loadColorScreenInner", "", "getComponentType", "", "getComponentName", "onResume", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "d", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "colorScreenView", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "cardInfo", "<init>", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "e", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a extends AbsProfileComponent<FrameLayout> implements h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g colorScreenView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull IComponentCenter componentCenter, @NotNull ProfileCardInfo cardInfo) {
        super(componentCenter, cardInfo);
        Intrinsics.checkNotNullParameter(componentCenter, "componentCenter");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void loadColorScreenInner() {
        Map<String, ? extends Object> mapOf;
        if (this.mApp != null) {
            DATA data = this.mData;
            if (((ProfileCardInfo) data).allInOne != null && !TextUtils.isEmpty(((ProfileCardInfo) data).allInOne.uin)) {
                IVasColorScreenSp iVasColorScreenSp = (IVasColorScreenSp) QRoute.api(IVasColorScreenSp.class);
                String str = ((ProfileCardInfo) this.mData).allInOne.uin;
                Intrinsics.checkNotNullExpressionValue(str, "mData.allInOne.uin");
                int colorScreenId = iVasColorScreenSp.getColorScreenId(str);
                if (colorScreenId <= 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ProfileColorScreenKuiklyComponent", 2, "loadColorScreen early return");
                        return;
                    }
                    return;
                }
                QLog.i("ProfileColorScreenKuiklyComponent", 2, "loadColorScreen success.");
                if (this.colorScreenView == null) {
                    IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
                    BaseApplication context = BaseApplication.context;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    this.colorScreenView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    g gVar = this.colorScreenView;
                    if (gVar != 0) {
                        g.a.a(gVar, ((IVasColorScreenKuikly) QRoute.api(IVasColorScreenKuikly.class)).getScheme(), null, 2, null);
                        ((FrameLayout) this.mViewContainer).addView((View) gVar, layoutParams);
                    }
                }
                g gVar2 = this.colorScreenView;
                if (gVar2 != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("colorScreenId", Integer.valueOf(colorScreenId)));
                    gVar2.sentEvent("start", mapOf);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    @NotNull
    public String getComponentName() {
        return "ProfileColorScreenKuiklyComponent";
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1004;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.colorScreenView;
        if (gVar != 0) {
            gVar.onDetach();
            ((FrameLayout) this.mViewContainer).removeView((View) gVar);
        }
        this.colorScreenView = null;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("ProfileColorScreenKuiklyComponent", 2, "onPageLoadComplete");
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        Map<String, ? extends Object> emptyMap;
        super.onPause();
        g gVar = this.colorScreenView;
        if (gVar != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            gVar.sentEvent("cancel", emptyMap);
            gVar.onPause();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        super.onResume();
        loadColorScreenInner();
        g gVar = this.colorScreenView;
        if (gVar != null) {
            gVar.onResume();
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }
}
