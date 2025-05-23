package com.tencent.mobileqq.qqexpand.entrance.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.fragment.ExpandOldEditFragment;
import com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/entrance/impl/ExpandFragmentRouterImpl;", "Lcom/tencent/mobileqq/qqexpand/entrance/IExpandFragmentRouter;", "()V", "launchExpandEditFragment", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "launchExpandEditFragmentForResult", "requestCode", "", "launchNewEditFragmentForResult", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ExpandFragmentRouterImpl implements IExpandFragmentRouter {
    @Override // com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter
    public void launchExpandEditFragment(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QPublicFragmentActivity.b.b(activity, intent, QPublicFragmentActivity.class, ExpandOldEditFragment.class);
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter
    public void launchExpandEditFragmentForResult(Activity activity, Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ExpandOldEditFragment.class, requestCode);
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter
    public void launchNewEditFragmentForResult(Activity activity, Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) ExtendFriendNewEditFragment.class, requestCode);
    }
}
