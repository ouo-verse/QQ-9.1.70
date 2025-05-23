package cu2;

import bu2.TVideoAccountInfo;
import bu2.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.account.qqconnect.TVideoQQConnectCacheInKV;
import com.tencent.mobileqq.tvideo.account.qqconnect.TVideoQQConnectToken;
import com.tencent.mobileqq.tvideo.account.tenvideo.cache.VideoAccountCacheInKV;
import com.tencent.mobileqq.tvideo.account.tenvideo.refresh.VideoLoginRefreshController;
import jy2.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002,6\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010:\u00a8\u0006@"}, d2 = {"Lcu2/a;", "", "Lbu2/b;", "refreshAccount", "", "r", "Lbu2/a;", "j", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "k", "token", "Leu2/a;", "outLoginCallback", "l", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "i", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lau2/a;", "a", "Lau2/a;", "callback", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/cache/a;", "b", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/cache/a;", "accountCacheInKV", "c", "Lbu2/b;", "_currAccount", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/TVideoQQConnectCacheInKV;", "d", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/TVideoQQConnectCacheInKV;", "qqConnectCacheInKV", "e", "Lcom/tencent/mobileqq/tvideo/account/qqconnect/b;", "_qqConnectAccount", "f", "Leu2/a;", "Ldu2/b;", "g", "Ldu2/b;", "refreshCaseProvider", "cu2/a$b", h.F, "Lcu2/a$b;", "accountGetter", "Lfu2/c;", "Lfu2/c;", "refreshHandler", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/VideoLoginRefreshController;", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/VideoLoginRefreshController;", "refreshController", "cu2/a$d", "Lcu2/a$d;", "requestModelCallback", "Leu2/b;", "Leu2/b;", "model", "Lau2/c;", "pageLifecycleProvider", "<init>", "(Lau2/a;Lau2/c;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final au2.a callback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.tvideo.account.tenvideo.cache.a accountCacheInKV;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile TVideoAccountInfo _currAccount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TVideoQQConnectCacheInKV qqConnectCacheInKV;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TVideoQQConnectToken _qqConnectAccount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private eu2.a outLoginCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final du2.b refreshCaseProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b accountGetter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fu2.c refreshHandler;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VideoLoginRefreshController refreshController;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d requestModelCallback;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final eu2.b model;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"cu2/a$b", "Lfu2/a;", "Lbu2/a;", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements fu2.a {
        b() {
        }

        @Override // fu2.a
        @Nullable
        public bu2.a a() {
            return a.this.j();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"cu2/a$c", "Lfu2/c;", "Lbu2/a;", "account", "", "refreshPriority", "", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements fu2.c {
        c() {
        }

        @Override // fu2.c
        public void a(@NotNull bu2.a account, int refreshPriority) {
            Intrinsics.checkNotNullParameter(account, "account");
            a.this.model.w(account, refreshPriority);
        }

        @Override // fu2.c
        public void b() {
            a.this.model.j();
        }
    }

    public a(@NotNull au2.a callback, @NotNull au2.c pageLifecycleProvider) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(pageLifecycleProvider, "pageLifecycleProvider");
        this.callback = callback;
        VideoAccountCacheInKV videoAccountCacheInKV = new VideoAccountCacheInKV();
        this.accountCacheInKV = videoAccountCacheInKV;
        this._currAccount = videoAccountCacheInKV.getAccount();
        TVideoQQConnectCacheInKV tVideoQQConnectCacheInKV = new TVideoQQConnectCacheInKV();
        this.qqConnectCacheInKV = tVideoQQConnectCacheInKV;
        this._qqConnectAccount = tVideoQQConnectCacheInKV.b();
        du2.b bVar = new du2.b(pageLifecycleProvider.a());
        this.refreshCaseProvider = bVar;
        b bVar2 = new b();
        this.accountGetter = bVar2;
        c cVar = new c();
        this.refreshHandler = cVar;
        this.refreshController = new VideoLoginRefreshController(bVar2, cVar, bVar);
        d dVar = new d();
        this.requestModelCallback = dVar;
        pageLifecycleProvider.b(bVar);
        this.model = new eu2.b(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(TVideoAccountInfo refreshAccount) {
        boolean isBlank;
        boolean isBlank2;
        TVideoAccountInfo tVideoAccountInfo = this._currAccount;
        if (tVideoAccountInfo != null) {
            refreshAccount.n(tVideoAccountInfo.getAppId());
            isBlank = StringsKt__StringsJVMKt.isBlank(refreshAccount.getHeadImageUrl());
            if (isBlank) {
                refreshAccount.o(tVideoAccountInfo.getHeadImageUrl());
            }
            isBlank2 = StringsKt__StringsJVMKt.isBlank(refreshAccount.getNickName());
            if (isBlank2) {
                refreshAccount.q(tVideoAccountInfo.getNickName());
            }
        }
        this._currAccount = refreshAccount;
        this.accountCacheInKV.a(refreshAccount);
    }

    public final void i() {
        this._currAccount = null;
        this.refreshController.i();
        this.accountCacheInKV.clearAccount();
        this._qqConnectAccount = null;
        this.qqConnectCacheInKV.a();
    }

    @Nullable
    public final bu2.a j() {
        if (this._currAccount != null && g.B()) {
            return this._currAccount;
        }
        return this.accountCacheInKV.getAccount();
    }

    @Nullable
    public final TVideoQQConnectToken k() {
        if (this._qqConnectAccount == null) {
            this._qqConnectAccount = this.qqConnectCacheInKV.b();
        }
        return this._qqConnectAccount;
    }

    public final void l(@NotNull TVideoQQConnectToken token, @Nullable eu2.a outLoginCallback) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.outLoginCallback = outLoginCallback;
        this.qqConnectCacheInKV.d(token);
        this.model.n(token, true);
    }

    public final void m() {
        TVideoAccountInfo tVideoAccountInfo = this._currAccount;
        if (tVideoAccountInfo != null) {
            this.model.o(tVideoAccountInfo);
            i();
            this.callback.d();
        }
    }

    public final void n() {
        TVideoAccountInfo tVideoAccountInfo = this._currAccount;
        if (tVideoAccountInfo != null) {
            this.model.p(tVideoAccountInfo);
            i();
            this.callback.d();
        }
    }

    public final void o() {
        this.outLoginCallback = null;
    }

    public final void p() {
        this.refreshController.d();
    }

    public final void q() {
        TVideoAccountInfo tVideoAccountInfo;
        com.tencent.mobileqq.tvideo.account.tenvideo.cache.a aVar = this.accountCacheInKV;
        if (aVar != null) {
            tVideoAccountInfo = aVar.getAccount();
        } else {
            tVideoAccountInfo = null;
        }
        this._currAccount = tVideoAccountInfo;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"cu2/a$d", "Leu2/a;", "Lbu2/b;", "account", "", "c", "Lbu2/c$c;", "errorMessage", "a", "e", "b", "d", "f", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements eu2.a {
        d() {
        }

        @Override // eu2.a
        public void a(@NotNull c.C0152c errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            a.this.callback.b(errorMessage);
            eu2.a aVar = a.this.outLoginCallback;
            if (aVar != null) {
                aVar.a(errorMessage);
            }
        }

        @Override // eu2.a
        public void b(@NotNull c.C0152c errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        }

        @Override // eu2.a
        public void c(@NotNull TVideoAccountInfo account) {
            Intrinsics.checkNotNullParameter(account, "account");
            a.this._currAccount = account;
            a.this.refreshController.h();
            a.this.callback.a(account);
            a.this.accountCacheInKV.a(account);
            eu2.a aVar = a.this.outLoginCallback;
            if (aVar != null) {
                aVar.c(account);
            }
        }

        @Override // eu2.a
        public void d(@NotNull TVideoAccountInfo account) {
            boolean z16;
            Intrinsics.checkNotNullParameter(account, "account");
            if (a.this._currAccount == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            a.this.r(account);
            if (z16) {
                a.this.callback.a(account);
                a.this.refreshController.h();
            } else {
                a.this.callback.e(account);
                a.this.refreshController.e();
            }
        }

        @Override // eu2.a
        public void f(@NotNull c.C0152c errorMessage) {
            Integer errorCode;
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            Integer errorCode2 = errorMessage.getErrorCode();
            if ((errorCode2 != null && errorCode2.intValue() == 4) || ((errorCode = errorMessage.getErrorCode()) != null && errorCode.intValue() == 21)) {
                a.this.callback.c(a.this._currAccount);
            }
        }

        @Override // eu2.a
        public void e() {
        }
    }
}
