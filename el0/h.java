package el0;

import com.tencent.filament.zplanservice.pbjava.WebViewChannel$OpenUrlRequest;
import com.tencent.filament.zplanservice.pbjava.WebViewChannel$OpenUrlResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H&\u00a8\u0006\n"}, d2 = {"Lel0/h;", "", "Lcom/tencent/filament/zplanservice/pbjava/WebViewChannel$OpenUrlRequest;", "req", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/WebViewChannel$OpenUrlResponse;", "", "Lcom/tencent/filament/zplanservice/proxy/api/channel/IWebViewChannelResponse;", "callback", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface h {
    void a(@NotNull WebViewChannel$OpenUrlRequest req, @NotNull Function1<? super WebViewChannel$OpenUrlResponse, Unit> callback);
}
