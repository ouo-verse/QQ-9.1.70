package com.tencent.mobileqq.perf.process.state.floating;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH&J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/perf/process/state/floating/IFloatingState;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkFloatingExist", "", "floatingBlackList", "", "", "getFloating", "", "getFloatingProcess", "getProcessValue", "name", "pid", "", "removeState", "", "wrapperClassName", "writeState", "qqperf_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IFloatingState extends QRouteApi {
    boolean checkFloatingExist(@NotNull Set<String> floatingBlackList);

    @NotNull
    Set<String> getFloating();

    @NotNull
    Set<String> getFloatingProcess(@NotNull Set<String> floatingBlackList);

    @NotNull
    String getProcessValue(@NotNull String name, int pid);

    void removeState(@NotNull String wrapperClassName);

    void writeState(@NotNull String wrapperClassName);
}
