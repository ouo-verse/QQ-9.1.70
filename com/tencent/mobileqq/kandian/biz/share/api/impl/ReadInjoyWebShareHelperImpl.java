package com.tencent.mobileqq.kandian.biz.share.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper;
import com.tencent.mobileqq.kandian.biz.share.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/share/api/impl/ReadInjoyWebShareHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/common/app/AppInterface;", "app", "Landroid/os/Bundle;", "data", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInjoyWebShareHelper$a;", "callBack", "", "showShareActionSheet", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ReadInjoyWebShareHelperImpl implements IReadInjoyWebShareHelper {
    @Override // com.tencent.mobileqq.kandian.biz.share.api.IReadInjoyWebShareHelper
    public void showShareActionSheet(Activity activity, AppInterface app, Bundle data, IReadInjoyWebShareHelper.a callBack) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        new d(activity, app, callBack).N(data);
    }
}
