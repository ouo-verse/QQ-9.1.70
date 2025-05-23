package com.tencent.icgame.api.ticket.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.timi.game.api.ticket.IQQLiveTicketApi;
import com.tencent.timi.game.api.ticket.PSKey;
import com.tencent.timi.game.api.ticket.PSKeyCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pt0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\t*\u0003\u0012\u0015\u0018\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u001fB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\n\u0010\tJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl;", "Lcom/tencent/timi/game/api/ticket/IQQLiveTicketApi;", "", "", "domains", "Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "callback", "", "getPsKeysAsync", "([Ljava/lang/String;Lcom/tencent/timi/game/api/ticket/PSKeyCallback;)V", "getPsKeysAsyncNoCache", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", "getPsKeysSync", "([Ljava/lang/String;)Ljava/util/List;", "domain", "", "isPsKeyExpired", "com/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$d", "pskeyFetcher", "Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$d;", "com/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$e", "pskeyFetcherNoCache", "Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$e;", "com/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$f", "pskeyFetcherSync", "Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$f;", "<init>", "()V", "Companion", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveTicketApiImpl implements IQQLiveTicketApi {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String RESULT_FAILURE = "failure";

    @Deprecated
    @NotNull
    private static final String RESULT_GET_TICKET_DONE = "get_ticket_done";

    @Deprecated
    @NotNull
    private static final String RESULT_PSKEY_IS_EMPTY = "pskey_is_empty";

    @Deprecated
    @NotNull
    private static final String RESULT_PSKEY_IS_EXPIRED = "pskey_is_expired";

    @Deprecated
    private static final int SCENE_NORMAL = 0;

    @Deprecated
    private static final int SCENE_NO_CACHE = 1;

    @Deprecated
    private static final int SCENE_SYNC = 2;

    @Deprecated
    @NotNull
    private static final String TAG = "ICGameTicketApiImpl";

    @Deprecated
    @NotNull
    private static final IAegisLogApi aegisLogger;

    @NotNull
    private final d pskeyFetcher = new d();

    @NotNull
    private final e pskeyFetcherNoCache = new e();

    @NotNull
    private final f pskeyFetcherSync = new f();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$a;", "", "Lcom/tencent/common/app/AppInterface;", "d", "appInterface", "", "c", "", "RESULT_FAILURE", "Ljava/lang/String;", "RESULT_GET_TICKET_DONE", "RESULT_PSKEY_IS_EMPTY", "RESULT_PSKEY_IS_EXPIRED", "", "SCENE_NORMAL", "I", "SCENE_NO_CACHE", "SCENE_SYNC", "TAG", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(AppInterface appInterface) {
            if (appInterface == null) {
                QQLiveTicketApiImpl.aegisLogger.e(QQLiveTicketApiImpl.TAG, "appInterface is null");
                return false;
            }
            if (!appInterface.isLogin()) {
                QQLiveTicketApiImpl.aegisLogger.e(QQLiveTicketApiImpl.TAG, "not login");
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AppInterface d() {
            return t42.d.a();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b%\u0010&J-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ-\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J#\u0010\u001a\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001eH&\u00a2\u0006\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$b;", "", "", "event", "", "domains", "", "startTime", "", "j", "(Ljava/lang/String;[Ljava/lang/String;J)V", "errMsg", "i", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "", "domainToPskeyMap", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", h.F, "([Ljava/lang/String;Ljava/util/Map;)Ljava/util/List;", "", "isServerPSKey", "pSKeys", "k", "Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "callback", "g", "([Ljava/lang/String;Lcom/tencent/timi/game/api/ticket/PSKeyCallback;)V", "Lcom/tencent/mobileqq/pskey/api/IPskeyManager;", "pskeyManager", "Lsd2/a;", "f", "(Lcom/tencent/mobileqq/pskey/api/IPskeyManager;[Ljava/lang/String;Lsd2/a;)V", "", "a", "I", "scene", "<init>", "(I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    private static abstract class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int scene;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$b$a", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes7.dex */
        public static final class a implements sd2.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String[] f114822a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f114823b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f114824c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ PSKeyCallback f114825d;

            a(String[] strArr, b bVar, long j3, PSKeyCallback pSKeyCallback) {
                this.f114822a = strArr;
                this.f114823b = bVar;
                this.f114824c = j3;
                this.f114825d = pSKeyCallback;
            }

            @Override // sd2.a
            public void onFail(@NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                IAegisLogApi iAegisLogApi = QQLiveTicketApiImpl.aegisLogger;
                String arrays = Arrays.toString(this.f114822a);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                iAegisLogApi.e(QQLiveTicketApiImpl.TAG, arrays + "fetchPskey failed errMsg:" + errMsg + " scene:" + this.f114823b.scene);
                this.f114823b.i("ev_icgame_ticket_get_pskey_async", this.f114822a, errMsg);
                this.f114825d.onFailed(errMsg);
            }

            @Override // sd2.a
            public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
                Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
                IAegisLogApi iAegisLogApi = QQLiveTicketApiImpl.aegisLogger;
                String arrays = Arrays.toString(this.f114822a);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                iAegisLogApi.i(QQLiveTicketApiImpl.TAG, arrays + "fetchPskey success scene:" + this.f114823b.scene);
                this.f114823b.j("ev_icgame_ticket_get_pskey_async", this.f114822a, this.f114824c);
                List<PSKey> h16 = this.f114823b.h(this.f114822a, domainToKeyMap);
                this.f114823b.k("ev_icgame_ticket_get_pskey_async", true, h16);
                this.f114825d.onSuccess(h16);
            }
        }

        public b(int i3) {
            this.scene = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PSKey> h(String[] domains, Map<String, String> domainToPskeyMap) {
            ArrayList arrayList = new ArrayList();
            for (String str : domains) {
                arrayList.add(new PSKey(str, domainToPskeyMap.get(str), false));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i(String event, String[] domains, String errMsg) {
            pt0.a aVar = pt0.a.f427090a;
            String arrays = Arrays.toString(domains);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            a.ReporterData reporterData = new a.ReporterData(event, QQLiveTicketApiImpl.RESULT_FAILURE, "failed:" + errMsg, arrays);
            reporterData.h(this.scene);
            aVar.b(reporterData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(String event, String[] domains, long startTime) {
            pt0.a aVar = pt0.a.f427090a;
            String arrays = Arrays.toString(domains);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            a.ReporterData reporterData = new a.ReporterData(event, QQLiveTicketApiImpl.RESULT_GET_TICKET_DONE, "", arrays);
            reporterData.g(System.currentTimeMillis() - startTime);
            reporterData.h(this.scene);
            aVar.b(reporterData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(String event, boolean isServerPSKey, List<PSKey> pSKeys) {
            String str;
            if (isServerPSKey) {
                str = "from_server";
            } else {
                str = "from_local";
            }
            for (PSKey pSKey : pSKeys) {
                if (pSKey.isExpired()) {
                    QQLiveTicketApiImpl.aegisLogger.i(QQLiveTicketApiImpl.TAG, 1, "pSKey is expired,domain:" + pSKey.getDomain() + ",event:" + event + ",isServerPSKey:" + isServerPSKey + ",scene:" + this.scene);
                    pt0.a aVar = pt0.a.f427090a;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("pskey_is_expired_");
                    sb5.append(str);
                    a.ReporterData reporterData = new a.ReporterData(event, sb5.toString(), "pSKey is expired", pSKey.getDomain());
                    reporterData.h(this.scene);
                    aVar.b(reporterData);
                }
                if (TextUtils.isEmpty(pSKey.getValue())) {
                    QQLiveTicketApiImpl.aegisLogger.i(QQLiveTicketApiImpl.TAG, 1, "pSKey is empty\uff0cdomain:" + pSKey.getDomain() + ",event:" + event + ",isServerPSKey:" + isServerPSKey + ",scene:" + this.scene);
                    pt0.a aVar2 = pt0.a.f427090a;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("pskey_is_empty_");
                    sb6.append(str);
                    a.ReporterData reporterData2 = new a.ReporterData(event, sb6.toString(), "pSKey is empty", pSKey.getDomain());
                    reporterData2.h(this.scene);
                    aVar2.b(reporterData2);
                }
            }
        }

        public abstract void f(@NotNull IPskeyManager pskeyManager, @NotNull String[] domains, @NotNull sd2.a callback);

        public final void g(@NotNull String[] domains, @NotNull PSKeyCallback callback) {
            Intrinsics.checkNotNullParameter(domains, "domains");
            Intrinsics.checkNotNullParameter(callback, "callback");
            AppInterface d16 = QQLiveTicketApiImpl.Companion.d();
            if (!QQLiveTicketApiImpl.Companion.c(d16)) {
                callback.onFailed("checkLoginState failed");
                return;
            }
            Intrinsics.checkNotNull(d16);
            IRuntimeService runtimeService = d16.getRuntimeService(IPskeyManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface!!.getRuntim\u2026onstant.ALL\n            )");
            long currentTimeMillis = System.currentTimeMillis();
            Object[] copyOf = Arrays.copyOf(domains, domains.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            f((IPskeyManager) runtimeService, (String[]) copyOf, new a(domains, this, currentTimeMillis, callback));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$d", "Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$b;", "Lcom/tencent/mobileqq/pskey/api/IPskeyManager;", "pskeyManager", "", "", "domains", "Lsd2/a;", "callback", "", "f", "(Lcom/tencent/mobileqq/pskey/api/IPskeyManager;[Ljava/lang/String;Lsd2/a;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d extends b {
        d() {
            super(0);
        }

        @Override // com.tencent.icgame.api.ticket.impl.QQLiveTicketApiImpl.b
        public void f(@NotNull IPskeyManager pskeyManager, @NotNull String[] domains, @NotNull sd2.a callback) {
            Intrinsics.checkNotNullParameter(pskeyManager, "pskeyManager");
            Intrinsics.checkNotNullParameter(domains, "domains");
            Intrinsics.checkNotNullParameter(callback, "callback");
            pskeyManager.getPskey(domains, callback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$e", "Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$b;", "Lcom/tencent/mobileqq/pskey/api/IPskeyManager;", "pskeyManager", "", "", "domains", "Lsd2/a;", "callback", "", "f", "(Lcom/tencent/mobileqq/pskey/api/IPskeyManager;[Ljava/lang/String;Lsd2/a;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class e extends b {
        e() {
            super(1);
        }

        @Override // com.tencent.icgame.api.ticket.impl.QQLiveTicketApiImpl.b
        public void f(@NotNull IPskeyManager pskeyManager, @NotNull String[] domains, @NotNull sd2.a callback) {
            Intrinsics.checkNotNullParameter(pskeyManager, "pskeyManager");
            Intrinsics.checkNotNullParameter(domains, "domains");
            Intrinsics.checkNotNullParameter(callback, "callback");
            pskeyManager.replacePskey(domains, callback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$f", "Lcom/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$b;", "Lcom/tencent/mobileqq/pskey/api/IPskeyManager;", "pskeyManager", "", "", "domains", "Lsd2/a;", "callback", "", "f", "(Lcom/tencent/mobileqq/pskey/api/IPskeyManager;[Ljava/lang/String;Lsd2/a;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class f extends b {
        f() {
            super(2);
        }

        @Override // com.tencent.icgame.api.ticket.impl.QQLiveTicketApiImpl.b
        public void f(@NotNull IPskeyManager pskeyManager, @NotNull String[] domains, @NotNull sd2.a callback) {
            Intrinsics.checkNotNullParameter(pskeyManager, "pskeyManager");
            Intrinsics.checkNotNullParameter(domains, "domains");
            Intrinsics.checkNotNullParameter(callback, "callback");
            pskeyManager.getPskey(domains, callback);
        }
    }

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        aegisLogger = (IAegisLogApi) api;
    }

    @Override // com.tencent.timi.game.api.ticket.IQQLiveTicketApi
    public void getPsKeysAsync(@NotNull String[] domains, @NotNull PSKeyCallback callback) {
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IAegisLogApi iAegisLogApi = aegisLogger;
        String arrays = Arrays.toString(domains);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        iAegisLogApi.i(TAG, arrays + "getPsKeysAsync");
        this.pskeyFetcher.g(domains, callback);
    }

    @Override // com.tencent.timi.game.api.ticket.IQQLiveTicketApi
    public void getPsKeysAsyncNoCache(@NotNull String[] domains, @NotNull PSKeyCallback callback) {
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IAegisLogApi iAegisLogApi = aegisLogger;
        String arrays = Arrays.toString(domains);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        iAegisLogApi.i(TAG, arrays + "getPsKeysAsyncNoCache");
        this.pskeyFetcherNoCache.g(domains, callback);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List, T] */
    @Override // com.tencent.timi.game.api.ticket.IQQLiveTicketApi
    @NotNull
    public List<PSKey> getPsKeysSync(@NotNull String[] domains) {
        ?? emptyList;
        Intrinsics.checkNotNullParameter(domains, "domains");
        IAegisLogApi iAegisLogApi = aegisLogger;
        String arrays = Arrays.toString(domains);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        iAegisLogApi.i(TAG, arrays + "getPsKeysSync");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        objectRef.element = emptyList;
        this.pskeyFetcherSync.g(domains, new c(objectRef));
        return (List) objectRef.element;
    }

    @Override // com.tencent.timi.game.api.ticket.IQQLiveTicketApi
    public boolean isPsKeyExpired(@NotNull String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        aegisLogger.i(TAG, "isPsKeyExpired");
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/icgame/api/ticket/impl/QQLiveTicketApiImpl$c", "Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "onTimeout", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements PSKeyCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<PSKey>> f114826a;

        c(Ref.ObjectRef<List<PSKey>> objectRef) {
            this.f114826a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onSuccess(@NotNull List<PSKey> pSKeys) {
            Intrinsics.checkNotNullParameter(pSKeys, "pSKeys");
            this.f114826a.element = pSKeys;
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onFailed(@Nullable String msg2) {
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onTimeout(@Nullable String msg2) {
        }
    }
}
