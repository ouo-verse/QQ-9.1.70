package com.tencent.mobileqq.zootopia.ipc;

import android.content.Context;
import android.net.Uri;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaLaunchSchemeManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/ad;", "", ZPlanPublishSource.FROM_SCHEME, "Landroid/content/Context;", "context", "", "launchScheme", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaLaunchSchemeManagerImpl implements ad {
    public static final String TAG = "ZootopiaLaunchSchemeManagerImpl";

    @Override // com.tencent.mobileqq.zootopia.ipc.ad
    public boolean launchScheme(String scheme, Context context) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        if (context == null) {
            QLog.i(TAG, 1, "origin context is null");
            context = BaseApplication.context;
        }
        ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), context, Uri.parse(((ISchemeApi) QRoute.api(ISchemeApi.class)).appendRootSourceToScheme(scheme)).toString());
        if (c16 != null) {
            return c16.b();
        }
        QLog.e(TAG, 1, "doOpenGame action is null");
        return false;
    }

    public boolean launchScheme(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null) {
            return launchScheme(scheme, baseApplication);
        }
        QLog.e(TAG, 1, "launchScheme but baseApplication context is null");
        return false;
    }
}
