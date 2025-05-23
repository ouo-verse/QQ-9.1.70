package com.tencent.mobileqq.troop.membersetting.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.troop.membersetting.ITroopMemberSettingApi;
import com.tencent.mobileqq.troop.membersetting.fragment.MemberSettingFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/impl/TroopMemberSettingApiImpl;", "Lcom/tencent/mobileqq/troop/membersetting/ITroopMemberSettingApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "requestCode", "", "openMemberSetting", "", "pageName", "openPageTime", "doReport", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopMemberSettingApiImpl implements ITroopMemberSettingApi {
    public static final String REPORT_APPKEY = "0AND05WHEN2NOTPG";
    public static final String REPORT_CODE = "troop_member_setting_plugin_opt";
    public static final String TAG = "TroopMemberSettingApiImpl";

    @Override // com.tencent.mobileqq.troop.membersetting.ITroopMemberSettingApi
    public void doReport(String pageName, String openPageTime) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "\u754c\u9762" + pageName + "\u8017\u65f6" + openPageTime);
        }
        HashMap hashMap = new HashMap();
        String str = "";
        if (pageName == null) {
            pageName = "";
        }
        hashMap.put("page_name", pageName);
        if (openPageTime == null) {
            openPageTime = "";
        }
        hashMap.put("open_page_time", openPageTime);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin != null) {
            Intrinsics.checkNotNullExpressionValue(currentUin, "MobileQQ.sMobileQQ.peekA\u2026ntime()?.currentUin ?: \"\"");
            str = currentUin;
        }
        hashMap.put("current_uin", str);
        BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey(REPORT_APPKEY).withCode(REPORT_CODE).withParams(hashMap).build());
    }

    @Override // com.tencent.mobileqq.troop.membersetting.ITroopMemberSettingApi
    public void openMemberSetting(Activity activity, Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) MemberSettingFragment.class, requestCode);
    }
}
