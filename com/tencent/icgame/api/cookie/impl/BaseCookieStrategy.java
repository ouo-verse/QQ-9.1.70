package com.tencent.icgame.api.cookie.impl;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.CookieDataCallback;
import com.tencent.timi.game.api.cookie.IQQLiveCookieApi;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\u0011\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0004R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/icgame/api/cookie/impl/BaseCookieStrategy;", "Lcom/tencent/timi/game/api/cookie/IQQLiveCookieStrategy;", "", "", "cookies", "", "g", "domain", "f", "tbs", "e", "Lcom/tencent/timi/game/api/cookie/CookieDataCallback;", "callback", "", "buildAsync", "buildSync", "isCookieExpired", "isCookieLegal", "removeCookies", "a", "Lcom/tencent/timi/game/api/cookie/IQQLiveCookieApi;", "Lkotlin/Lazy;", "b", "()Lcom/tencent/timi/game/api/cookie/IQQLiveCookieApi;", "cookieApi", "", "d", "()Ljava/util/Set;", "cookieKeys", "", "Lcom/tencent/icgame/api/cookie/impl/a;", "c", "()Ljava/util/List;", "cookieBuilders", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class BaseCookieStrategy implements IQQLiveCookieStrategy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cookieApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cookieKeys;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/api/cookie/impl/BaseCookieStrategy$a", "Lcom/tencent/timi/game/api/cookie/CookieDataCallback;", "", "", "cookies", "", "onSuccess", "", "code", "msg", "onFailed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements CookieDataCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f114795a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<String, String> f114796b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f114797c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CookieDataCallback f114798d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f114799e;

        a(Ref.IntRef intRef, HashMap<String, String> hashMap, int i3, CookieDataCallback cookieDataCallback, Ref.BooleanRef booleanRef) {
            this.f114795a = intRef;
            this.f114796b = hashMap;
            this.f114797c = i3;
            this.f114798d = cookieDataCallback;
            this.f114799e = booleanRef;
        }

        @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
        public void onFailed(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.f114799e.element = true;
            this.f114798d.onFailed(code, msg2);
        }

        @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
        public void onSuccess(@NotNull Map<String, String> cookies) {
            Intrinsics.checkNotNullParameter(cookies, "cookies");
            this.f114795a.element++;
            this.f114796b.putAll(cookies);
            if (this.f114795a.element >= this.f114797c) {
                this.f114798d.onSuccess(this.f114796b);
            }
        }
    }

    public BaseCookieStrategy() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IQQLiveCookieApi>() { // from class: com.tencent.icgame.api.cookie.impl.BaseCookieStrategy$cookieApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IQQLiveCookieApi invoke() {
                return (IQQLiveCookieApi) QRoute.api(IQQLiveCookieApi.class);
            }
        });
        this.cookieApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashSet<String>>() { // from class: com.tencent.icgame.api.cookie.impl.BaseCookieStrategy$cookieKeys$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashSet<String> invoke() {
                HashSet<String> hashSet = new HashSet<>();
                Iterator<a> it = BaseCookieStrategy.this.c().iterator();
                while (it.hasNext()) {
                    hashSet.addAll(it.next().d());
                }
                return hashSet;
            }
        });
        this.cookieKeys = lazy2;
    }

    private final IQQLiveCookieApi b() {
        return (IQQLiveCookieApi) this.cookieApi.getValue();
    }

    private final Set<String> d() {
        return (Set) this.cookieKeys.getValue();
    }

    private final Map<String, String> e(String domain, boolean tbs) {
        String sysCookie;
        List<String> split$default;
        CharSequence trim;
        List split$default2;
        Map<String, String> emptyMap;
        if (tbs) {
            sysCookie = b().getTbsCookie(domain);
        } else {
            sysCookie = b().getSysCookie(domain);
        }
        String str = sysCookie;
        if (QLog.isColorLevel()) {
            QLog.i("ICGameBaseCookieStrategy", 2, "tbs:" + tbs + ",domain:" + domain + ",planted cookie:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        HashMap hashMap = new HashMap();
        Intrinsics.checkNotNull(str);
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
        if (split$default.isEmpty()) {
            QLog.e("ICGameBaseCookieStrategy", 1, "empty cookie");
            return hashMap;
        }
        for (String str2 : split$default) {
            if (!TextUtils.isEmpty(str2)) {
                trim = StringsKt__StringsKt.trim((CharSequence) str2);
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) trim.toString(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2) {
                    hashMap.put(split$default2.get(0), split$default2.get(1));
                } else {
                    QLog.e("ICGameBaseCookieStrategy", 1, "illegal cookie:" + str2);
                }
            }
        }
        return hashMap;
    }

    private final boolean f(String domain) {
        if (!isCookieLegal(e(domain, true))) {
            QLog.i("ICGameBaseCookieStrategy", 1, "tbsCookie illLegal,domain:" + domain);
            return false;
        }
        if (isCookieLegal(e(domain, false))) {
            return true;
        }
        QLog.i("ICGameBaseCookieStrategy", 1, "sysCookie illLegal,domain:" + domain);
        return false;
    }

    private final boolean g(Map<String, String> cookies) {
        for (String str : d()) {
            if (TextUtils.isEmpty(cookies.get(str))) {
                QLog.i("ICGameBaseCookieStrategy", 1, "miss cookie " + str);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ICGameBaseCookieStrategy", 1, "isCookieLegal,appInterface is null");
            return "";
        }
        if (!peekAppRuntime.isLogin()) {
            QLog.e("ICGameBaseCookieStrategy", 1, "isCookieLegal,not login");
            return "";
        }
        String a16 = HttpBaseUtil.a(peekAppRuntime.getCurrentAccountUin());
        Intrinsics.checkNotNullExpressionValue(a16, "changeUin(uin)");
        return a16;
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy
    public void buildAsync(@NotNull CookieDataCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        int size = c().size();
        Ref.IntRef intRef = new Ref.IntRef();
        HashMap hashMap = new HashMap();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (com.tencent.icgame.api.cookie.impl.a aVar : c()) {
            if (!booleanRef.element) {
                aVar.b(new a(intRef, hashMap, size, callback, booleanRef));
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy
    @NotNull
    public Map<String, String> buildSync() {
        HashMap hashMap = new HashMap();
        Iterator<com.tencent.icgame.api.cookie.impl.a> it = c().iterator();
        while (it.hasNext()) {
            hashMap.putAll(it.next().c());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract List<com.tencent.icgame.api.cookie.impl.a> c();

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy
    public boolean isCookieExpired(@NotNull String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        boolean f16 = f(domain);
        QLog.i("ICGameBaseCookieStrategy", 1, "plantedCookieLegal:" + f16);
        return !f16;
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy
    public boolean isCookieLegal(@NotNull Map<String, String> cookies) {
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        return !g(cookies);
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieStrategy
    public void removeCookies(@NotNull String domain) {
        List<String> list;
        Intrinsics.checkNotNullParameter(domain, "domain");
        IQQLiveCookieApi iQQLiveCookieApi = (IQQLiveCookieApi) QRoute.api(IQQLiveCookieApi.class);
        list = CollectionsKt___CollectionsKt.toList(d());
        iQQLiveCookieApi.removeCookies(domain, list);
    }
}
