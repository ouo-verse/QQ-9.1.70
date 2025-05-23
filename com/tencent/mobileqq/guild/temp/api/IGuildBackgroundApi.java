package com.tencent.mobileqq.guild.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/IGuildBackgroundApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lr02/a;", "getGuildBackground", "", "getSkinAioInputBg", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildBackgroundApi extends QRouteApi {
    @NotNull
    r02.a getGuildBackground();

    int getSkinAioInputBg();
}
