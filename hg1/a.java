package hg1;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static boolean a() {
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("guild_lottie_8835");
        QLog.i("GuildFeatureSwitchHelper", 4, "LottieEmo enable=" + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }
}
