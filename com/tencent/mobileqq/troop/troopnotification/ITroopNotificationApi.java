package com.tencent.mobileqq.troop.troopnotification;

import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/ITroopNotificationApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getTroopNotificationParserClass", "", "data", "", "handle0x210Push", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopNotificationApi extends QRouteApi {
    @NotNull
    Class<av> getTroopNotificationParserClass();

    void handle0x210Push(@NotNull byte[] data);
}
