package com.tencent.qqnt.bus.api;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import zv3.a;
import zv3.b;
import zv3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\tH&J \u0010\f\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\r\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/bus/api/IBusManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lzv3/a;", "event", "Lzv3/b;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "configEventStrategy", "Lzv3/c;", "observer", "registerEvent", "unRegisterEvent", "clearEventObservers", "clearAndStop", "reInit", "sendEvent", "bus_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IBusManager extends QRouteApi {
    void clearAndStop();

    void clearEventObservers(@NotNull Class<? extends a> event);

    void configEventStrategy(@NotNull Class<? extends a> event, @NotNull b strategy);

    void reInit();

    void registerEvent(@NotNull Class<? extends a> event, @NotNull c observer);

    void sendEvent(@NotNull a event);

    void unRegisterEvent(@NotNull Class<? extends a> event, @NotNull c observer);
}
