package com.tencent.sqshow.fragment;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IZPlanLifeCycleRecorderHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import i74.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\b&\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\"\u0010\u0018\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/sqshow/fragment/ZPlanPublicBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Li74/b;", "", "qh", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onResume", "beforeFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "rh", ICustomDataEditor.STRING_ARRAY_PARAM_8, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "activityName", "", "D", "I", "getActivityHash", "()I", "setActivityHash", "(I)V", "activityHash", "<init>", "()V", "E", "a", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class ZPlanPublicBaseFragment extends QPublicBaseFragment implements b {

    /* renamed from: C, reason: from kotlin metadata */
    private String activityName = "";

    /* renamed from: D, reason: from kotlin metadata */
    private int activityHash;

    private final String ph(Activity activity) {
        String canonicalName = activity.getClass().getCanonicalName();
        return canonicalName == null ? activity.toString() : canonicalName;
    }

    private final String qh() {
        String str = MobileQQ.processName;
        QLog.i("ZPlanPublicBaseFragment_", 1, "getProcess processName:" + str);
        if (Intrinsics.areEqual(str, "com.tencent.mobileqq")) {
            return "main";
        }
        if (Intrinsics.areEqual(str, "com.tencent.mobileqq:zplan")) {
            return "zplan";
        }
        return null;
    }

    @Override // i74.b
    public boolean a8() {
        FragmentActivity activity = getActivity();
        boolean isFinishing = activity != null ? activity.isFinishing() : true;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isPageFinishing : ");
        sb5.append(isFinishing);
        sb5.append(", hash:");
        FragmentActivity activity2 = getActivity();
        sb5.append(activity2 != null ? activity2.hashCode() : 0);
        sb5.append(", this:");
        sb5.append(getActivity());
        QLog.i("ZPlanPublicBaseFragment_", 1, sb5.toString());
        return isFinishing;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        if (!(this.activityName.length() > 0) || this.activityHash == 0) {
            return;
        }
        if (rh()) {
            ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).finish(this.activityName, this.activityHash);
        }
        ((IZPlanLifeCycleRecorderHelper) QRoute.api(IZPlanLifeCycleRecorderHelper.class)).activityFinish(rh(), this.activityName, this.activityHash);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.activityName = ph(activity);
            this.activityHash = activity.hashCode();
            if (rh()) {
                ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).create(this.activityName, this.activityHash, this);
            }
            ((IZPlanLifeCycleRecorderHelper) QRoute.api(IZPlanLifeCycleRecorderHelper.class)).activityCreate(rh(), this.activityName, this.activityHash, qh());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (!(this.activityName.length() > 0) || this.activityHash == 0) {
            return;
        }
        if (rh()) {
            ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).destroy(this.activityName, this.activityHash);
        }
        ((IZPlanLifeCycleRecorderHelper) QRoute.api(IZPlanLifeCycleRecorderHelper.class)).activityDestroy(rh(), this.activityName, this.activityHash);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!(this.activityName.length() > 0) || this.activityHash == 0) {
            return;
        }
        ((IZPlanLifeCycleRecorderHelper) QRoute.api(IZPlanLifeCycleRecorderHelper.class)).activityResume(rh(), this.activityName, this.activityHash, qh());
    }

    protected boolean rh() {
        return false;
    }
}
