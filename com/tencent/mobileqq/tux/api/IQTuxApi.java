package com.tencent.mobileqq.tux.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tux/api/IQTuxApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createTuxJumpParserClass", "Ljava/lang/Class;", "", "initTux", "", "triggerArkTux", "arkUid", "", "tuxType", "qqcareInfo", "qqtux-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IQTuxApi extends QRouteApi {
    @NotNull
    Class<? extends Object> createTuxJumpParserClass();

    void initTux();

    void triggerArkTux(@NotNull String arkUid, @NotNull String tuxType, @NotNull String qqcareInfo);
}
