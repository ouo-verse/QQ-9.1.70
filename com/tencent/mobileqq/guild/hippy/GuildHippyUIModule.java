package com.tencent.mobileqq.guild.hippy;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.manage.GuildClientManageFragment;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import jg1.b;

/* compiled from: P */
@HippyNativeModule(name = GuildHippyUIModule.TAG)
/* loaded from: classes13.dex */
public class GuildHippyUIModule extends HippyNativeModuleBase {
    private static final String TAG = "GuildHippyUIModule";

    public GuildHippyUIModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "openGuildAuthorizationDialog")
    public void openAuthorizationDialog(HippyMap hippyMap, Promise promise) {
        QLog.d(TAG, 2, "openAuthorizationDialog readableMap=" + hippyMap.toJSONObject().toString());
        b.c(QBaseActivity.sTopActivity, null, new GuildClientParams().e0(hippyMap.getString("guildId")).l(hippyMap.getString("clientId")).l0(6).e());
    }

    @HippyMethod(name = "openGuildClientManager")
    public void openGuildClientManager(HippyMap hippyMap, Promise promise) {
        QLog.d(TAG, 2, "openGuildClientManager readableMap=" + hippyMap.toJSONObject().toString());
        GuildClientManageFragment.Nh(QBaseActivity.sTopActivity, new GuildClientParams().e0(hippyMap.getString("guildId")).l(hippyMap.getString("clientId")).e(), 2);
    }

    @HippyMethod(name = "openGuildProfileCard")
    public void openGuildProfileCard(HippyMap hippyMap, Promise promise) {
        QLog.d(TAG, 2, "openGuildProfileCard readableMap=" + hippyMap.toJSONObject().toString());
        GuildProfileCard.Lh(QBaseActivity.sTopActivity, new GuildProfileData(hippyMap.getString("guildId"), "", hippyMap.getString("tinyId"), 0, 5));
    }
}
