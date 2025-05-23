package gf4;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.DataSupplierCallback;
import com.tencent.timi.game.api.cookie.IDataSupplier;
import com.tencent.timi.game.api.ticket.IQQLiveTicketApi;
import com.tencent.timi.game.api.ticket.PSKey;
import com.tencent.timi.game.api.ticket.PSKeyCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lgf4/a;", "Lcom/tencent/timi/game/api/cookie/IDataSupplier;", "", "Lcom/tencent/timi/game/api/cookie/DataSupplierCallback;", "callback", "", "getDataAsync", "a", "Ljava/lang/String;", "domain", "", "b", "Z", "noCache", "<init>", "(Ljava/lang/String;Z)V", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements IDataSupplier<String> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String domain;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean noCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"gf4/a$b", "Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "onTimeout", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements PSKeyCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataSupplierCallback<String> f402028a;

        b(DataSupplierCallback<String> dataSupplierCallback) {
            this.f402028a = dataSupplierCallback;
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onFailed(@Nullable String msg2) {
            DataSupplierCallback<String> dataSupplierCallback = this.f402028a;
            if (msg2 == null) {
                msg2 = "onFailed";
            }
            dataSupplierCallback.onFailed(3, msg2);
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onSuccess(@NotNull List<PSKey> pSKeys) {
            Intrinsics.checkNotNullParameter(pSKeys, "pSKeys");
            QLog.d("PSKeyDataSupplier", 1, "getPsKeysAsync onSuccess");
            if (pSKeys.isEmpty()) {
                QLog.e("PSKeyDataSupplier", 1, "pSKey is empty");
                this.f402028a.onFailed(2, "pSKey is empty");
                return;
            }
            DataSupplierCallback<String> dataSupplierCallback = this.f402028a;
            String value = pSKeys.get(0).getValue();
            if (value == null) {
                value = "";
            }
            dataSupplierCallback.onSuccess(value);
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onTimeout(@Nullable String msg2) {
            DataSupplierCallback<String> dataSupplierCallback = this.f402028a;
            if (msg2 == null) {
                msg2 = "onTimeout";
            }
            dataSupplierCallback.onFailed(4, msg2);
        }
    }

    public a(@NotNull String domain, boolean z16) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        this.domain = domain;
        this.noCache = z16;
    }

    @Override // com.tencent.timi.game.api.cookie.IDataSupplier
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getDataSync() {
        QLog.i("PSKeyDataSupplier", 1, "getDataSync domain=" + this.domain);
        List<PSKey> psKeysSync = ((IQQLiveTicketApi) QRoute.api(IQQLiveTicketApi.class)).getPsKeysSync(new String[]{this.domain});
        if (psKeysSync.isEmpty()) {
            QLog.e("PSKeyDataSupplier", 1, "pSKey is empty");
            return "";
        }
        String value = psKeysSync.get(0).getValue();
        if (value == null) {
            return "";
        }
        return value;
    }

    @Override // com.tencent.timi.game.api.cookie.IDataSupplier
    public void getDataAsync(@NotNull DataSupplierCallback<String> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("PSKeyDataSupplier", 1, "getDataAsync domain:" + this.domain + ",noCache:" + this.noCache);
        b bVar = new b(callback);
        if (this.noCache) {
            ((IQQLiveTicketApi) QRoute.api(IQQLiveTicketApi.class)).getPsKeysAsyncNoCache(new String[]{this.domain}, bVar);
        } else {
            ((IQQLiveTicketApi) QRoute.api(IQQLiveTicketApi.class)).getPsKeysAsync(new String[]{this.domain}, bVar);
        }
    }

    public /* synthetic */ a(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16);
    }
}
