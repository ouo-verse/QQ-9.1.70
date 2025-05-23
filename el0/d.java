package el0;

import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCRawDataRequest;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCRawDataResponse;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCSwitchRequest;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCSwitchResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H&J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\fH&\u00a8\u0006\u000e"}, d2 = {"Lel0/d;", "", "Lcom/tencent/filament/zplanservice/pbjava/QQMCChannel$QQMCSwitchRequest;", "req", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/QQMCChannel$QQMCSwitchResponse;", "", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQMCSwitchResponse;", "callback", "a", "Lcom/tencent/filament/zplanservice/pbjava/QQMCChannel$QQMCRawDataRequest;", "Lcom/tencent/filament/zplanservice/pbjava/QQMCChannel$QQMCRawDataResponse;", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQMCRawDataResponse;", "b", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface d {
    void a(@NotNull QQMCChannel$QQMCSwitchRequest req, @NotNull Function1<? super QQMCChannel$QQMCSwitchResponse, Unit> callback);

    void b(@NotNull QQMCChannel$QQMCRawDataRequest req, @NotNull Function1<? super QQMCChannel$QQMCRawDataResponse, Unit> callback);
}
