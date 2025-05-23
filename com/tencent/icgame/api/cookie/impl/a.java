package com.tencent.icgame.api.cookie.impl;

import com.tencent.timi.game.api.cookie.CookieDataCallback;
import com.tencent.timi.game.api.cookie.DataSupplierCallback;
import com.tencent.timi.game.api.cookie.IDataSupplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/icgame/api/cookie/impl/a;", "", "", "cookieValue", "", "e", "Lcom/tencent/timi/game/api/cookie/CookieDataCallback;", "callback", "", "b", "c", "", "d", "a", "Ljava/util/Set;", "cookieKeys", "Lcom/tencent/timi/game/api/cookie/IDataSupplier;", "Lcom/tencent/timi/game/api/cookie/IDataSupplier;", "dataSupplier", "<init>", "(Ljava/util/Set;Lcom/tencent/timi/game/api/cookie/IDataSupplier;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> cookieKeys;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IDataSupplier<String> dataSupplier;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/api/cookie/impl/a$a", "Lcom/tencent/timi/game/api/cookie/DataSupplierCallback;", "", "data", "", "a", "", "code", "msg", "onFailed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.api.cookie.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5825a implements DataSupplierCallback<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CookieDataCallback f114805a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f114806b;

        C5825a(CookieDataCallback cookieDataCallback, a aVar) {
            this.f114805a = cookieDataCallback;
            this.f114806b = aVar;
        }

        @Override // com.tencent.timi.game.api.cookie.DataSupplierCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f114805a.onSuccess(this.f114806b.e(data));
        }

        @Override // com.tencent.timi.game.api.cookie.DataSupplierCallback
        public void onFailed(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.f114805a.onFailed(code, msg2);
        }
    }

    public a(@NotNull Set<String> cookieKeys, @NotNull IDataSupplier<String> dataSupplier) {
        Intrinsics.checkNotNullParameter(cookieKeys, "cookieKeys");
        Intrinsics.checkNotNullParameter(dataSupplier, "dataSupplier");
        this.cookieKeys = cookieKeys;
        this.dataSupplier = dataSupplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> e(String cookieValue) {
        HashMap hashMap = new HashMap();
        Iterator<String> it = this.cookieKeys.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), cookieValue);
        }
        return hashMap;
    }

    public final void b(@NotNull CookieDataCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.dataSupplier.getDataAsync(new C5825a(callback, this));
    }

    @NotNull
    public final Map<String, String> c() {
        return e(this.dataSupplier.getDataSync());
    }

    @NotNull
    public final Set<String> d() {
        return this.cookieKeys;
    }
}
