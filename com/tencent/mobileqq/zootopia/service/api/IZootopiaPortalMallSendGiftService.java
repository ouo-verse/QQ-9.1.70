package com.tencent.mobileqq.zootopia.service.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ0\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/api/IZootopiaPortalMallSendGiftService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lkotlin/Function1;", "", "", "callback", "checkAndSendGift", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZootopiaPortalMallSendGiftService extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f329169a;

    @NotNull
    public static final String FORWARD_ZPLAN_SEND_GIFT = "zplan_send_gift";

    @NotNull
    public static final String SEND_GIFT_ARK_NAME = "com.tencent.zplan.giftgiving";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/api/IZootopiaPortalMallSendGiftService$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.service.api.IZootopiaPortalMallSendGiftService$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f329169a = new Companion();

        Companion() {
        }
    }

    void checkAndSendGift(@NotNull Activity activity, @Nullable Bundle extraData, @NotNull Function1<? super Boolean, Unit> callback);
}
