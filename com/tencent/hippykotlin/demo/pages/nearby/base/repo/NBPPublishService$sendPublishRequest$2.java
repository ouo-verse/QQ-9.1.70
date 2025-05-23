package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.FeedPublishTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProSafeTip;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import s25.f;

/* loaded from: classes31.dex */
public final class NBPPublishService$sendPublishRequest$2 extends Lambda implements Function2<Integer, String, Unit> {
    public final /* synthetic */ Function3<Boolean, f, String, Unit> $callback;
    public final /* synthetic */ NBPPublishConfig $config;
    public final /* synthetic */ FeedPublishTechReporter $publishReporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPPublishService$sendPublishRequest$2(Function3<? super Boolean, ? super f, ? super String, Unit> function3, NBPPublishConfig nBPPublishConfig, FeedPublishTechReporter feedPublishTechReporter) {
        super(2);
        this.$callback = function3;
        this.$config = nBPPublishConfig;
        this.$publishReporter = feedPublishTechReporter;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        boolean z16;
        String str2;
        int intValue = num.intValue();
        String str3 = str;
        Function3<Boolean, f, String, Unit> function3 = this.$callback;
        if (function3 != null) {
            function3.invoke(Boolean.FALSE, null, str3);
        }
        NearbyProSafeTip nearbyProSafeTip = NearbyProSafeTip.INSTANCE;
        if (NearbyProSafeTip.PUNISHED_ERROR_CODES.contains(Integer.valueOf(intValue))) {
            nearbyProSafeTip.dangerTip(str3);
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (intValue == 15001) {
                str2 = "\u8be5\u529f\u80fd\u7ef4\u62a4\u4e2d";
            } else {
                str2 = intValue != 0 ? str3 : "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u53d1\u5e03\u5931\u8d25!";
            }
            if (this.$config.showToast) {
                Utils.INSTANCE.currentBridgeModule().qToast(str2, QToastMode.Warning);
            }
        }
        KLog.INSTANCE.e("NBPPublishService", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestPublishFeed failed, errorCode: ", intValue, ", errorMsg: ", str3));
        NBPPublishService.access$customDtReportPublish(intValue != 10002 ? intValue != 10003 ? 3 : 2 : 1, "", this.$config);
        this.$publishReporter.reportResult$enumunboxing$(5, str3);
        return Unit.INSTANCE;
    }
}
