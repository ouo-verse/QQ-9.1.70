package com.tencent.mobileqq.zplan.share.action;

import android.app.Activity;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.zplan.share.ZPlanShareParam;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/d;", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zplan/share/e;", "shareParams", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "listener", "", IProfileProtocolConst.PARAM_IS_FRIEND, "", "e", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d extends SmallHomeShotShareAction {
    @Override // com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction, com.tencent.mobileqq.zplan.share.action.b
    public void e(Activity activity, ZPlanShareParam shareParams, WXShareHelper.a listener, boolean isFriend) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        QLog.i("CommonShareAction", 1, "share To WX: isFriend: " + isFriend + ", " + shareParams);
        com.tencent.mobileqq.zplan.share.d.f335534a.u(shareParams, isFriend, listener);
    }
}
