package com.tencent.mobileqq.minikuikly;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\"\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\"\u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"\u0018\u00010!J\u000e\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0005R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/minikuikly/MiniKuiklyBaseFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "extInfo", "firstPath", "", "ph", "qh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "", "", "rh", ZPlanPublishSource.FROM_SCHEME, "th", "query", "sh", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "kuiklyContainer", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "D", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "kuiklyRenderView", "E", "Ljava/util/Map;", ISchemeApi.KEY_PAGE_DATA, "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniKuiklyBaseFragment extends QBaseFragment implements h {

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout kuiklyContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private g kuiklyRenderView;

    /* renamed from: E, reason: from kotlin metadata */
    private Map<String, ? extends Object> pageData;

    /* JADX WARN: Multi-variable type inference failed */
    private final void ph(ViewGroup container, String extInfo, String firstPath) {
        IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
        Context context = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
        this.kuiklyRenderView = createKuiklyRenderView;
        g gVar = null;
        View view = createKuiklyRenderView;
        if (createKuiklyRenderView == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
            view = null;
        }
        container.addView(view);
        if (!TextUtils.isEmpty(extInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(extInfo);
                QLog.e("MiniKuiklyBaseFragment", 1, "attachKuiklyView paramStr=", extInfo);
                Map<String, ? extends Object> m3 = KuiklyLaunchParams.INSTANCE.m(jSONObject);
                m3.put(QZoneHelper.IS_FROM_MINI_APP, 1);
                if (firstPath != null) {
                    m3.put("mini_first_path", firstPath);
                }
                String str = (String) m3.get("page_name");
                if (!TextUtils.isEmpty(str)) {
                    QBaseActivity qBaseActivity = getQBaseActivity();
                    g gVar2 = this.kuiklyRenderView;
                    if (gVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
                    } else {
                        gVar = gVar2;
                    }
                    Intrinsics.checkNotNull(str);
                    gVar.b(str, m3, new Size((int) ah.Z(), (int) (ah.y() + ImmersiveUtils.getStatusBarHeight(qBaseActivity))));
                } else {
                    QLog.e("MiniKuiklyBaseFragment", 1, "attachKuiklyView pageName null");
                }
                this.pageData = m3;
                return;
            } catch (Exception e16) {
                QLog.e("MiniKuiklyBaseFragment", 1, "attachKuiklyView parse paramStr exception=", e16);
                return;
            }
        }
        QLog.e("MiniKuiklyBaseFragment", 1, "attachKuiklyView paramStr null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.djb;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        g gVar = this.kuiklyRenderView;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
            gVar = null;
        }
        gVar.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        qh();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        g gVar = this.kuiklyRenderView;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
            gVar = null;
        }
        gVar.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g gVar = this.kuiklyRenderView;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
            gVar = null;
        }
        gVar.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle arguments = getArguments();
        FrameLayout frameLayout = null;
        String string = arguments != null ? arguments.getString("extra_open_kuikly_info") : null;
        if (string == null || string.length() == 0) {
            QLog.e("MiniKuiklyBaseFragment", 1, "onViewCreated openKuiklyInfo null");
            return;
        }
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("mini_first_path") : null;
        FrameLayout frameLayout2 = (FrameLayout) view;
        this.kuiklyContainer = frameLayout2;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyContainer");
        } else {
            frameLayout = frameLayout2;
        }
        ph(frameLayout, string, string2);
    }

    public final Map<String, Object> rh() {
        return this.pageData;
    }

    public final void sh(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("data", query);
        g gVar = this.kuiklyRenderView;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
            gVar = null;
        }
        gVar.sentEvent("EventSetQuery", linkedHashMap);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }

    public final void th(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("newScheme", scheme);
        g gVar = this.kuiklyRenderView;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
            gVar = null;
        }
        gVar.sentEvent("EventSetScheme", linkedHashMap);
    }

    private final void qh() {
        QLog.d("MiniKuiklyBaseFragment", 1, "destroyKuiklyView");
        g gVar = this.kuiklyRenderView;
        Object obj = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
            gVar = null;
        }
        gVar.onPause();
        g gVar2 = this.kuiklyRenderView;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
            gVar2 = null;
        }
        gVar2.onDetach();
        FrameLayout frameLayout = this.kuiklyContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyContainer");
            frameLayout = null;
        }
        Object obj2 = this.kuiklyRenderView;
        if (obj2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kuiklyRenderView");
        } else {
            obj = obj2;
        }
        frameLayout.removeView((View) obj);
    }
}
