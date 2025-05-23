package ap2;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lap2/a;", "", "", "c", "a", "b", "", "Ljava/lang/String;", "appId", "tabName", "d", "aiCardJumpModeTabName", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f26672a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String appId = ABTestController.APPID_1505;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String tabName = "exp_qq_search_strategy_add_ai_0220";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String aiCardJumpModeTabName = "exp_qqsearch_aikapian_tiaozhuanrukou";

    a() {
    }

    public final boolean a() {
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
            return false;
        }
        if (f.f26688a.a()) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("SearchAudioAIABTestHelper", "canUserAudioAI disable, show third app");
            }
            return false;
        }
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        b bVar = (b) ((IUnitedConfigManager) api).loadConfig("qq_search_audio_ai_config");
        if (bVar != null) {
            af afVar = af.f284993a;
            QLog.i("QS.SearchAudioAIABTestHelper", 1, "canUserAudioAI config. enable=" + bVar.getCanUseAudioSearch(), null);
            if (bVar.b()) {
                return true;
            }
            if (bVar.a()) {
                return false;
            }
            boolean isExperiment = ABTestController.getInstance().getExpEntity(appId, bVar.getVoiceExpName()).isExperiment();
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("SearchAudioAIABTestHelper", "canUserAudioAI tabFlag=" + isExperiment);
            }
            return isExperiment;
        }
        Logger logger3 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("SearchAudioAIABTestHelper", "canUserAudioAI no config");
        }
        return false;
    }

    public final boolean b() {
        return b.INSTANCE.a().getForbiddenAICard();
    }

    public final boolean c() {
        return false;
    }
}
