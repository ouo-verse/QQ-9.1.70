package bg0;

import android.util.Log;
import com.tencent.ecommerce.base.logger.api.IECLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lbg0/a;", "Lcom/tencent/ecommerce/base/logger/api/IECLog;", "", "isColorLevel", "", "tag", "msg", "", "logError", "logWarn", "logInfo", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECLog {
    @Override // com.tencent.ecommerce.base.logger.api.IECLog
    public boolean isColorLevel() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.logger.api.IECLog
    public void logError(@NotNull String tag, @NotNull String msg2) {
        Log.e(tag, msg2);
    }

    @Override // com.tencent.ecommerce.base.logger.api.IECLog
    public void logInfo(@NotNull String tag, @NotNull String msg2) {
        Log.i(tag, msg2);
    }

    @Override // com.tencent.ecommerce.base.logger.api.IECLog
    public void logWarn(@NotNull String tag, @NotNull String msg2) {
        Log.w(tag, msg2);
    }
}
