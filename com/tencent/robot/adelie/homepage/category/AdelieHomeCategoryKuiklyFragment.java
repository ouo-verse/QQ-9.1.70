package com.tencent.robot.adelie.homepage.category;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c24.a;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.adelie.homepage.utils.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\"\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/AdelieHomeCategoryKuiklyFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "D", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "kuiklyView", "", "E", "J", "startTime", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeCategoryKuiklyFragment extends QPublicBaseFragment implements h {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private FrameLayout rootView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private g kuiklyView;

    /* renamed from: E, reason: from kotlin metadata */
    private long startTime;

    private final void ph() {
        int i3;
        Context context = getContext();
        if (context == null) {
            return;
        }
        this.startTime = System.currentTimeMillis();
        Bundle arguments = getArguments();
        String str = "1";
        if (arguments != null) {
            i3 = arguments.getInt("navBarHeight");
            str = arguments.getString("superiorSource", "1");
            Intrinsics.checkNotNullExpressionValue(str, "it.getString(\"superiorSource\", \"1\")");
        } else {
            i3 = 0;
        }
        g createKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(context, this);
        int f16 = ViewUtils.f352270a.f(i3);
        long j3 = this.startTime;
        if (str == null) {
            str = "";
        }
        g.a.a(createKuiklyRenderView, "mqqapi://kuikly/open?local_bundle_name=nearbypro&version=1&src_type=web&page_name=adelie_category_home&topMargin=" + f16 + "&use_host_display_metrics=1&kr_turbo_display=1&start_time=" + j3 + "&superior_source=" + str, null, 2, null);
        this.kuiklyView = createKuiklyRenderView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = a.a(64);
        Object obj = this.kuiklyView;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        ((View) obj).setBackgroundColor(0);
        FrameLayout frameLayout = this.rootView;
        if (frameLayout != null) {
            Object obj2 = this.kuiklyView;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
            frameLayout.addView((View) obj2, layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = getContext();
        if (context == null) {
            frameLayout = null;
        } else {
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.rootView = frameLayout2;
            frameLayout = frameLayout2;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        g gVar = this.kuiklyView;
        if (gVar != null) {
            gVar.onDetach();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x000d, code lost:
    
        if (r9 == null) goto L6;
     */
    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        String obj;
        Map mapOf;
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        if (errorReason != null) {
            try {
                obj = errorReason.toString();
            } catch (Throwable unused) {
                QLog.e("AdelieHomeMineKuiklyFragment", 1, "onPageLoadComplete error");
                return;
            }
        }
        obj = "";
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("isSucceed", String.valueOf(isSucceed)), TuplesKt.to(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, obj), TuplesKt.to("timeCost", String.valueOf(System.currentTimeMillis() - this.startTime)));
        d.b("0AND0YAG6R40RLM6", "adelie_category_home_page_nt_compose_error_report", mapOf);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        g gVar = this.kuiklyView;
        if (gVar != null) {
            gVar.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g gVar = this.kuiklyView;
        if (gVar != null) {
            gVar.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ph();
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
