package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQBridgeApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountConfig;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.PublicAccountUtils;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.SequenceTaskQueue$execute$1;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* loaded from: classes31.dex */
public final class PublicAccountFollowGuideTask implements ISequenceTask {
    public Function1<? super Boolean, Unit> onFinishCb;

    public PublicAccountFollowGuideTask() {
        k.b(QQBridgeApi.INSTANCE.getNotifyModule(), "NEARBY_CLOSE_PUBLIC_ACCOUNT_GUIDE_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks.PublicAccountFollowGuideTask.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                Function1<? super Boolean, Unit> function1;
                e eVar2 = eVar;
                Integer valueOf = eVar2 != null ? Integer.valueOf(eVar2.j("app_id")) : null;
                if (valueOf != null && valueOf.intValue() == 2 && (function1 = PublicAccountFollowGuideTask.this.onFinishCb) != null) {
                    function1.invoke(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask
    public final boolean canStart() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00af  */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onStart(Function1<? super Boolean, Unit> function1) {
        Long longOrNull;
        boolean z16;
        PublicAccountUtils publicAccountUtils = PublicAccountUtils.INSTANCE;
        PublicAccountConfig config = publicAccountUtils.getConfig(2);
        if (config != null) {
            if (!config.followModal.enable) {
                KLog.INSTANCE.i("PublicAccountUtils", "[shouldShowFollowModal] enable=false");
            } else if (publicAccountUtils.isFollowed(2)) {
                KLog.INSTANCE.i("PublicAccountUtils", "[shouldShowFollowModal] already followed");
            } else {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(Utils.INSTANCE.cacheModule("").getItem("NBP_CACHE_KEY_SHOW_FOLLOW_PUBLIC_ACCOUNT_MODAL_TIME_2"));
                long j3 = 1000;
                long longValue = (longOrNull != null ? longOrNull.longValue() : 0L) / j3;
                long NBPCurrentTime = APICallTechReporterKt.NBPCurrentTime() / j3;
                if (NBPCurrentTime - longValue < config.followModal.showIntervalS) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[shouldShowFollowModal] frequency limited: lastShowTime=");
                    sb5.append(longValue);
                    sb5.append("s, currentTime=");
                    sb5.append(NBPCurrentTime);
                    sb5.append("s, configInterval=");
                    kLog.i("PublicAccountUtils", GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(sb5, config.followModal.showIntervalS, 's'));
                } else {
                    KLog.INSTANCE.i("PublicAccountUtils", "[shouldShowFollowModal] should show modal!");
                    z16 = true;
                    if (z16) {
                        ((SequenceTaskQueue$execute$1) function1).invoke(Boolean.FALSE);
                        return;
                    }
                    this.onFinishCb = function1;
                    Utils.INSTANCE.cacheModule("").setItem("NBP_CACHE_KEY_SHOW_FOLLOW_PUBLIC_ACCOUNT_MODAL_TIME_2", String.valueOf(APICallTechReporterKt.NBPCurrentTime()));
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nbp_public_account_follow&app_id=2&modal_mode=1&custom_back_pressed=1&local_bundle_name=nearbypro", false, 6);
                    return;
                }
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
