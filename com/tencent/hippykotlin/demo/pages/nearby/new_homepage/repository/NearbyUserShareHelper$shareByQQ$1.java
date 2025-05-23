package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareContentData;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyUserShareHelper$shareByQQ$1 extends Lambda implements Function3<Integer, String, String, Unit> {
    public final /* synthetic */ NearbyUserShareHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyUserShareHelper$shareByQQ$1(NearbyUserShareHelper nearbyUserShareHelper) {
        super(3);
        this.this$0 = nearbyUserShareHelper;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(Integer num, String str, String str2) {
        int intValue = num.intValue();
        String str3 = str;
        String str4 = str2;
        if (intValue != 0) {
            if (!NearbyProUtilsKt.isShowBackendErrorMsg(intValue)) {
                str3 = "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            }
            this.this$0.onError.invoke(Boolean.FALSE, str3);
        } else {
            ShareModule shareModule = Utils.INSTANCE.shareModule(this.this$0.pagerId);
            ShareContentData shareContentData = new ShareContentData(0, str4, "\u9644\u8fd1\u7528\u6237", null, null, null, null, 0, 0, 4088);
            final NearbyUserShareHelper nearbyUserShareHelper = this.this$0;
            shareModule.doShareAction(2, null, shareContentData, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NearbyUserShareHelper$shareByQQ$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Integer num2) {
                    int intValue2 = num2.intValue();
                    NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", intValue2, KLog.INSTANCE, "NearbyUserShareHelper");
                    if (intValue2 == 0) {
                        NearbyUserShareHelper.this.onSuccess.invoke(1, Boolean.TRUE, null);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }
}
