package okhttp3;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.msf.core.d;
import java.net.Socket;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lokhttp3/Connection;", "", "handshake", "Lokhttp3/Handshake;", AudienceReportConst.PROTOCOL, "Lokhttp3/Protocol;", "route", "Lokhttp3/Route;", d.f247918u, "Ljava/net/Socket;", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public interface Connection {
    @Nullable
    Handshake handshake();

    @NotNull
    Protocol protocol();

    @NotNull
    Route route();

    @NotNull
    Socket socket();
}
