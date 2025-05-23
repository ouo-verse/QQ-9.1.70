package bl0;

import com.tencent.filament.zplanservice.channel.MessageChannel;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.util.log.ILogDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lbl0/a;", "", "Lcom/tencent/filament/zplanservice/util/log/ILogDelegate;", "logDelegate", "", "a", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f28591a = new a();

    static {
        System.loadLibrary("zplan_service");
        MessageChannel messageChannel = MessageChannel.INSTANCE;
    }

    a() {
    }

    public final void a(@NotNull ILogDelegate logDelegate) {
        Intrinsics.checkNotNullParameter(logDelegate, "logDelegate");
        FLog.INSTANCE.init(logDelegate);
    }
}
