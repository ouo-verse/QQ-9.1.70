package com.tencent.state.status;

import com.tencent.state.square.IReporter;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J7\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u0002H\bH&\u00a2\u0006\u0002\u0010\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/status/IReportDependency;", "", "iReporter", "Lcom/tencent/state/square/IReporter;", "getIReporter", "()Lcom/tencent/state/square/IReporter;", "fillReportParams", "", "T", "map", "", "", "key", "params", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IReportDependency {
    <T> void fillReportParams(Map<String, Object> map, String key, T params);

    IReporter getIReporter();
}
