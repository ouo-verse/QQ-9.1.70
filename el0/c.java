package el0;

import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetClientPlatformResponse;
import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetClientVersionResponse;
import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetCurrentUinResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H&J \u0010\n\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\tH&J \u0010\r\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\fH&\u00a8\u0006\u000e"}, d2 = {"Lel0/c;", "", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/QQAppChannel$GetCurrentUinResponse;", "", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQAppGetCurrentUinResponse;", "callback", "a", "Lcom/tencent/filament/zplanservice/pbjava/QQAppChannel$GetClientVersionResponse;", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQAppGetClientVersionResponse;", "c", "Lcom/tencent/filament/zplanservice/pbjava/QQAppChannel$GetClientPlatformResponse;", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IQQAppGetClientPlatformResponse;", "b", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface c {
    void a(@NotNull Function1<? super QQAppChannel$GetCurrentUinResponse, Unit> callback);

    void b(@NotNull Function1<? super QQAppChannel$GetClientPlatformResponse, Unit> callback);

    void c(@NotNull Function1<? super QQAppChannel$GetClientVersionResponse, Unit> callback);
}
