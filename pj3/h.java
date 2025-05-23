package pj3;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.feature.model.FilamentMiniHomeSceneUrlTemplate;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.zplan.proxy.filament.parser.ZPlanUrlTemplateConfigParser;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.common.utils.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J5\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lpj3/h;", "Ldl0/g;", "", VipFunCallConstants.KEY_GROUP, "", AdMetricTag.FALLBACK, "isSwitchOn", "T", "groupId", "Ljava/lang/Class;", "configClass", "getConfig", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "a", "Lcl0/a;", "d", "Lcom/tencent/filament/zplanservice/feature/model/FilamentMiniHomeSceneUrlTemplate;", "c", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h implements dl0.g {
    @Override // dl0.g
    public FilamentUrlTemplate a() {
        String e16 = j74.b.e(j74.b.f409622a, null, 1, null);
        if (!TextUtils.isEmpty(e16)) {
            try {
                Object fromJson = GsonUtil.f385283b.a().fromJson(e16, (Class<Object>) FilamentUrlTemplate.class);
                ((FilamentUrlTemplate) fromJson).setRawString(e16);
                Intrinsics.checkNotNullExpressionValue(fromJson, "GsonUtil.gson.fromJson(d\u2026emplate\n                }");
                return (FilamentUrlTemplate) fromJson;
            } catch (JsonSyntaxException e17) {
                com.tencent.xaction.log.b.c("QQFilamentQQMCProxy", 1, "parse debug urlTemplate fail", e17);
            }
        }
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        ZPlanUrlTemplateConfigParser.b bVar = (ZPlanUrlTemplateConfigParser.b) ((IUnitedConfigManager) api).loadConfig("zplan_lite_resources_url_template");
        if (bVar == null) {
            bVar = new ZPlanUrlTemplateConfigParser.b(null);
        }
        return bVar.getUrlTemplate();
    }

    @Override // dl0.g
    public String b(String groupId, String fallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(groupId, fallback);
    }

    @Override // dl0.g
    public FilamentMiniHomeSceneUrlTemplate c() {
        String d16 = j74.b.f409622a.d("zplan_debug_mini_home_url_temp");
        if (!TextUtils.isEmpty(d16)) {
            try {
                return (FilamentMiniHomeSceneUrlTemplate) GsonUtil.f385283b.a().fromJson(d16, FilamentMiniHomeSceneUrlTemplate.class);
            } catch (JsonSyntaxException e16) {
                com.tencent.xaction.log.b.c("QQFilamentQQMCProxy", 1, "parse debug urlTemplate fail", e16);
            }
        }
        return (FilamentMiniHomeSceneUrlTemplate) ZPlanQQMC.INSTANCE.getConfig("zplan_lite_mini_home_resources_url_template", new FilamentMiniHomeSceneUrlTemplate(null, 1, null));
    }

    @Override // dl0.g
    public cl0.a d() {
        return (cl0.a) ZPlanQQMC.INSTANCE.getConfig("zplan_lite_couple_resources_url_template", new cl0.a(null, 1, null));
    }

    @Override // dl0.g
    public <T> T getConfig(String groupId, Class<T> configClass, String fallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(configClass, "configClass");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        return (T) ZPlanQQMC.INSTANCE.getConfig(groupId, configClass, fallback);
    }

    @Override // dl0.g
    public boolean isSwitchOn(String group, boolean fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        return ZPlanQQMC.INSTANCE.isSwitchOn(group, fallback);
    }
}
