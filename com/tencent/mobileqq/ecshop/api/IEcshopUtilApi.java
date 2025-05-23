package com.tencent.mobileqq.ecshop.api;

import android.content.Context;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/ecshop/api/IEcshopUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getEcshopForbidJumpThirdAppRule", "", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$ForbidJumpThirdAppRule;", "getEcshopIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "jump", "", "context", "Landroid/content/Context;", "qqshop-feature-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IEcshopUtilApi extends QRouteApi {
    @NotNull
    List<EcshopConfBean.ForbidJumpThirdAppRule> getEcshopForbidJumpThirdAppRule();

    @NotNull
    QIPCModule getEcshopIPCModule();

    void jump(@NotNull Context context);
}
