package mt0;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.DataSupplierCallback;
import com.tencent.timi.game.api.cookie.IDataSupplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a8\u0006\r"}, d2 = {"Lmt0/b;", "Lcom/tencent/timi/game/api/cookie/IDataSupplier;", "", "c", "Lcom/tencent/timi/game/api/cookie/DataSupplierCallback;", "callback", "", "getDataAsync", "b", "Lcom/tencent/common/app/AppInterface;", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b implements IDataSupplier<String> {
    private final String c() {
        AppInterface a16 = a();
        if (a16 == null) {
            QLog.e("ICGameUinDataSupplier", 1, "getUin appInterface is null");
            return "";
        }
        if (!a16.isLogin()) {
            QLog.e("ICGameUinDataSupplier", 1, "getUin user not login");
            return "";
        }
        String currentAccountUin = a16.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appInterface.currentAccountUin");
        return currentAccountUin;
    }

    @Nullable
    public final AppInterface a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (MobileQQ.sProcessId == 7 && peekAppRuntime != null) {
            peekAppRuntime = peekAppRuntime.getAppRuntime("modular_web");
        }
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    @Override // com.tencent.timi.game.api.cookie.IDataSupplier
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getDataSync() {
        QLog.i("ICGameUinDataSupplier", 1, "getDataSync");
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            QLog.e("ICGameUinDataSupplier", 1, "uin is empty");
            return "";
        }
        String a16 = HttpBaseUtil.a(c16);
        Intrinsics.checkNotNullExpressionValue(a16, "changeUin(uin)");
        return a16;
    }

    @Override // com.tencent.timi.game.api.cookie.IDataSupplier
    public void getDataAsync(@NotNull DataSupplierCallback<String> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ICGameUinDataSupplier", 1, "getDataSync");
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            QLog.e("ICGameUinDataSupplier", 1, "uin is empty");
            callback.onFailed(1, "uin is empty");
        } else {
            String a16 = HttpBaseUtil.a(c16);
            Intrinsics.checkNotNullExpressionValue(a16, "changeUin(uin)");
            callback.onSuccess(a16);
        }
    }
}
