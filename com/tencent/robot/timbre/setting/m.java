package com.tencent.robot.timbre.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\"\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\tJ\"\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/robot/timbre/setting/m;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Landroid/view/ViewGroup;", AIInput.KEY_FRAME, "", "vipVoiceInfo", "", "pickedId", "robotUin", "", "a", "Landroid/content/Context;", "context", "c", "b", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "d", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "renderLogicView", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class m implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g renderLogicView;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(@Nullable ViewGroup frame, @Nullable byte[] vipVoiceInfo, @NotNull String pickedId, @NotNull String robotUin) {
        Context context;
        Intrinsics.checkNotNullParameter(pickedId, "pickedId");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        if (frame == null) {
            return;
        }
        ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).setMqqToKuiklyData("vas_robot_timbre_robot_uin", robotUin);
        if (this.renderLogicView == null) {
            context = null;
        } else {
            context = frame.getContext();
        }
        c(context, vipVoiceInfo, pickedId);
        if (this.renderLogicView == null) {
            IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
            BaseApplication context2 = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(context2, this);
            this.renderLogicView = createKuiklyRenderView;
            frame.addView((View) createKuiklyRenderView, -1, -1);
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(KuiklyLaunchParams.PARAM_MODAL_MODE, "1");
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.d(((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).buildVasKuiklySchema("vas_robot_timbre", "vas_ai_robot", arrayMap), null);
            }
        }
    }

    public final void b() {
        try {
            Object obj = this.renderLogicView;
            if (obj != null) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                ViewParent parent = ((View) obj).getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView((View) this.renderLogicView);
                com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
                if (gVar != null) {
                    gVar.onDetach();
                }
            }
            ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).setMqqToKuiklyData("vas_robot_timbre", new byte[0]);
            ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).setMqqToKuiklyData("vas_robot_timbre_select_id", "");
        } catch (Exception e16) {
            QLog.e("VasProfileGxhSuitLogic", 1, e16, new Object[0]);
        }
        this.renderLogicView = null;
    }

    public final void c(@Nullable Context context, @Nullable byte[] vipVoiceInfo, @NotNull String pickedId) {
        Intrinsics.checkNotNullParameter(pickedId, "pickedId");
        if (vipVoiceInfo != null) {
            IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
            String encodeToString = Base64.encodeToString(vipVoiceInfo, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(it, Base64.NO_WRAP)");
            iVasKuiklyApi.setMqqToKuiklyData("vas_robot_timbre", encodeToString);
        }
        if (!TextUtils.isEmpty(pickedId)) {
            ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).setMqqToKuiklyData("vas_robot_timbre_select_id", pickedId);
        }
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_name", "refresh");
            if (QLog.isColorLevel()) {
                QLog.d("VasRobotTimbre", 1, "send refresh event!");
            }
            Unit unit = Unit.INSTANCE;
            com.tencent.kuikly.core.render.android.expand.module.l.e(context, "vas_robot_timbre", jSONObject);
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

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("VasRobotTimbreLogic", 1, "onPageLoadComplete");
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
