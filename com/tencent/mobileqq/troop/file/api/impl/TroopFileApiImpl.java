package com.tencent.mobileqq.troop.file.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.file.data.m;
import com.tencent.mobileqq.troop.file.data.n;
import com.tencent.mobileqq.troop.file.main.fragment.TroopFileMainFragment;
import com.tencent.mobileqq.troop.file.search.fragment.TroopFileSearchByTypeFragment;
import com.tencent.mobileqq.troop.file.upload.fragment.TroopFileUploadFragment;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/file/api/impl/TroopFileApiImpl;", "Lcom/tencent/mobileqq/troop/file/api/ITroopFileApi;", "", "shouldReport", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "requestCode", "", "openTroopFileMainPage", "openTroopFileUploadPage", "openTroopFileSearchByTypePage", "canUseMsgForwardOnTroopFile", "fixWeiYunForwardFileSwitch", "", "fileInfo", "Lcom/tencent/mobileqq/troop/file/data/m;", "genMediaDownloadDepend", "", "troopUin", "entity", "genMediaShareDepend", "useNewBrowserOpenMediaFile", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileApiImpl implements ITroopFileApi {
    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public boolean canUseMsgForwardOnTroopFile() {
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("105974", Boolean.FALSE);
        QLog.i("TroopFile.Forward.", 1, "canUseMsgForwardOnTroopFile: " + isSwitchOn);
        Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026 $it\" }\n                }");
        return isSwitchOn.booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public boolean fixWeiYunForwardFileSwitch() {
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("troop_file_wei_yun_forward_fix_9160", Boolean.TRUE);
        QLog.i("TroopFile.Forward.", 1, "fixWeiYunForwardFileSwitch: " + isSwitchOn);
        Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026 $it\" }\n                }");
        return isSwitchOn.booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public Object genMediaShareDepend(long troopUin, Object fileInfo, Object entity) {
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        Intrinsics.checkNotNullParameter(entity, "entity");
        return new n(troopUin, (t) fileInfo, (FileManagerEntity) entity);
    }

    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public void openTroopFileMainPage(Activity activity, Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        long uptimeMillis = SystemClock.uptimeMillis();
        if (shouldReport()) {
            intent.putExtra("key_page_start_time", uptimeMillis);
            ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("start_troop_file_page_event", null);
        }
        QLog.i("TroopFile.Main.", 1, "openTroopFileMainPage start.");
        QPublicFragmentActivity.b.e(activity, intent.addFlags(268435456), QPublicFragmentActivity.class, TroopFileMainFragment.class, requestCode);
    }

    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public void openTroopFileSearchByTypePage(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QLog.i("TroopFile.Search.", 1, "openTroopFileSearchByTypePage start.");
        QPublicFragmentActivity.b.b(activity, intent.addFlags(268435456), QPublicFragmentActivity.class, TroopFileSearchByTypeFragment.class);
    }

    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public void openTroopFileUploadPage(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QLog.i("TroopFile.Upload.", 1, "openTroopFileUploadPage start.");
        QPublicFragmentActivity.b.b(activity, intent.addFlags(268435456), QPublicFragmentActivity.class, TroopFileUploadFragment.class);
    }

    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public boolean shouldReport() {
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("105611", Boolean.valueOf(!AppSetting.isPublicVersion()));
        Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026PublicVersion()\n        )");
        return isSwitchOn.booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public boolean useNewBrowserOpenMediaFile() {
        Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("105984", Boolean.TRUE);
        if (QLog.isColorLevel()) {
            QLog.i("TroopFile.", 2, "useNewBrowserOpenMediaFile:" + isSwitchOn);
        }
        Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026serOpenMediaFile:$it\" } }");
        return isSwitchOn.booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.file.api.ITroopFileApi
    public m genMediaDownloadDepend(Object fileInfo) {
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        return new m((t) fileInfo);
    }
}
