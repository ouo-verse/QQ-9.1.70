package com.tencent.aelight.camera.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraLauncher;
import com.tencent.aelight.camera.ae.flashshow.WinkCaptureFragment;
import com.tencent.aelight.camera.ae.flashshow.download.LSDownloadMaterialRunnable;
import com.tencent.aelight.camera.api.IQQWinkFragmentLoader;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.dailysign.DailySignFragment;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.wink.wangzhe.WinkWangZheReportFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sa3.b;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aelight/camera/api/impl/QQWinkFragmentLoaderImpl;", "Lcom/tencent/aelight/camera/api/IQQWinkFragmentLoader;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "fragmentClassName", "Landroid/content/Intent;", "extras", "", "useProfileTheme", "", "startFragmentPage", "Landroidx/fragment/app/Fragment;", "getCaptureFragment", "openMagicStudioFragment", "openWangZheReportFragment", "openTextVideoFragment", "isFlashCameraResReady", "loadLightResource", "Landroid/os/Bundle;", "bundle", "preloadCaptureResource", "<init>", "()V", "Companion", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class QQWinkFragmentLoaderImpl implements IQQWinkFragmentLoader {
    private static final String TAG = "QQWinkFragmentLoaderImpl";

    private final void startFragmentPage(Activity activity, String fragmentClassName, Intent extras, boolean useProfileTheme) {
        Bundle extras2;
        Intent intent = new Intent();
        Intent intent2 = activity.getIntent();
        if (intent2 != null && (extras2 = intent2.getExtras()) != null) {
            intent.putExtras(extras2);
        }
        intent.setClass(activity, QQWinkActivity.class);
        intent.putExtra("public_fragment_class", fragmentClassName);
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.a3w);
        if (useProfileTheme) {
            ((IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class)).addUseProfileThemeFlag(intent);
        }
        if (extras != null) {
            intent.putExtras(extras);
        }
        activity.startActivity(intent);
    }

    @Override // com.tencent.aelight.camera.api.IQQWinkFragmentLoader
    public Fragment getCaptureFragment() {
        return new WinkCaptureFragment(null, 1, null);
    }

    @Override // com.tencent.aelight.camera.api.IQQWinkFragmentLoader
    public void openMagicStudioFragment(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WinkMagicStudioUtils winkMagicStudioUtils = WinkMagicStudioUtils.f323888a;
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
        String name = winkMagicStudioUtils.f(intent).getName();
        Intrinsics.checkNotNullExpressionValue(name, "WinkMagicStudioUtils.get\u2026ass(activity.intent).name");
        startFragmentPage(activity, name, null, true);
    }

    @Override // com.tencent.aelight.camera.api.IQQWinkFragmentLoader
    public void openTextVideoFragment(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = DailySignFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "DailySignFragment::class.java.name");
        startFragmentPage$default(this, activity, name, null, false, 12, null);
    }

    @Override // com.tencent.aelight.camera.api.IQQWinkFragmentLoader
    public void openWangZheReportFragment(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = new Intent();
        Intent intent2 = new Intent();
        intent2.putExtra("url", b.f433595a.b());
        Unit unit = Unit.INSTANCE;
        intent.putExtra("intent", intent2);
        String name = WinkWangZheReportFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "WinkWangZheReportFragment::class.java.name");
        startFragmentPage$default(this, activity, name, intent, false, 8, null);
    }

    @Override // com.tencent.aelight.camera.api.IQQWinkFragmentLoader
    public void preloadCaptureResource(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (Intrinsics.areEqual("QCIRCLE", bundle.getString(QQWinkConstants.ENTRY_BUSINESS_NAME))) {
            ms.a.f(TAG, "preFetchWorldMaterialList");
            ThreadManagerV2.excute(new LSDownloadMaterialRunnable(), 128, null, true);
        }
    }

    @Override // com.tencent.aelight.camera.api.IQQWinkFragmentLoader
    public void loadLightResource(boolean isFlashCameraResReady) {
        AEFlashShowCameraLauncher.m(isFlashCameraResReady, false);
    }

    static /* synthetic */ void startFragmentPage$default(QQWinkFragmentLoaderImpl qQWinkFragmentLoaderImpl, Activity activity, String str, Intent intent, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            intent = null;
        }
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        qQWinkFragmentLoaderImpl.startFragmentPage(activity, str, intent, z16);
    }
}
