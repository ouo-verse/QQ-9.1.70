package ag4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00042\u00020\u0001:\u0002\u0015\u001bB\u0011\b\u0007\u0012\u0006\u0010(\u001a\u00020\u0014\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R0\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00190\u0018j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0019`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010 R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010#R$\u0010&\u001a\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u001c\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010#\u00a8\u0006+"}, d2 = {"Lag4/c;", "", "", "g", tl.h.F, "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "defaultAccount", "i", "c", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "authInfo", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "accountList", "d", "j", "Lag4/c$a;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "e", "", "a", "I", "mYesGameId", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "mListenerPool", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "authInfoLiveData", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "observerOfAuthInfo", "kotlin.jvm.PlatformType", "defaultAccountLiveData", "observerOfDefaultAccount", "yesGameId", "<init>", "(I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int mYesGameId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<WeakReference<a>> mListenerPool = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GameAuthOuterClass$GetGameAuthRsp authInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<GameAuthOuterClass$GetGameAuthRsp> authInfoLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<GameAuthOuterClass$GetGameAuthRsp> observerOfAuthInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> defaultAccountLiveData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> observerOfDefaultAccount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lag4/c$a;", "", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "defaultAccount", "", "a", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "authInfo", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "accountList", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp defaultAccount);

        void b(@Nullable GameAuthOuterClass$GetGameAuthRsp authInfo, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp accountList);
    }

    @JvmOverloads
    public c(int i3) {
        this.mYesGameId = i3;
        LiveData<GameAuthOuterClass$GetGameAuthRsp> G0 = ((i) mm4.b.b(i.class)).G0(i3);
        Intrinsics.checkNotNullExpressionValue(G0, "getService(IGameCoreServ\u2026hInfoLiveData(mYesGameId)");
        this.authInfoLiveData = G0;
        this.observerOfAuthInfo = new Observer() { // from class: ag4.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.k(c.this, (GameAuthOuterClass$GetGameAuthRsp) obj);
            }
        };
        this.defaultAccountLiveData = ((i) mm4.b.b(i.class)).B2(i3);
        this.observerOfDefaultAccount = new Observer() { // from class: ag4.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.l(c.this, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
            }
        };
    }

    private final void c(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp defaultAccount) {
        Iterator<WeakReference<a>> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            try {
                a aVar = it.next().get();
                if (aVar != null) {
                    aVar.a(defaultAccount);
                }
            } catch (Exception e16) {
                l.f("GameAuthAndDefaultAccountChecker_", "callbackHideHintView error", e16);
            }
        }
    }

    private final void d(GameAuthOuterClass$GetGameAuthRsp authInfo, YesGameInfoOuterClass$GetUserGameRoleListRsp accountList) {
        Iterator<WeakReference<a>> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            try {
                a aVar = it.next().get();
                if (aVar != null) {
                    aVar.b(authInfo, accountList);
                }
            } catch (Exception unused) {
            }
        }
    }

    private final void g() {
        this.authInfoLiveData.observeForever(this.observerOfAuthInfo);
        ((i) mm4.b.b(i.class)).I1(this.mYesGameId, null);
    }

    private final void h() {
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> liveData = this.defaultAccountLiveData;
        if (liveData != null) {
            liveData.observeForever(this.observerOfDefaultAccount);
        }
        ((i) mm4.b.b(i.class)).m2(this.mYesGameId, null);
    }

    private final void i(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp defaultAccount) {
        if (defaultAccount != null && cg4.b.a(defaultAccount)) {
            l.i("GameAuthAndDefaultAccountChecker_", "already bind account:" + defaultAccount);
            c(defaultAccount);
            return;
        }
        l.i("GameAuthAndDefaultAccountChecker_", "defaultAccount is null");
        d(this.authInfo, null);
    }

    private final void j() {
        l.i("GameAuthAndDefaultAccountChecker_", "handleGetGameAuthInfo authInfo = " + this.authInfo);
        GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp = this.authInfo;
        if (gameAuthOuterClass$GetGameAuthRsp != null) {
            l.i("GameAuthAndDefaultAccountChecker_", "handleGetGameAuthInfo is_auth = " + gameAuthOuterClass$GetGameAuthRsp.is_auth.get());
            if (!gameAuthOuterClass$GetGameAuthRsp.is_auth.get()) {
                LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> liveData = this.defaultAccountLiveData;
                if (liveData != null) {
                    liveData.observeForever(this.observerOfDefaultAccount);
                }
                d(gameAuthOuterClass$GetGameAuthRsp, null);
                return;
            }
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c this$0, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.authInfo = gameAuthOuterClass$GetGameAuthRsp;
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(c this$0, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i(yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
    }

    public final void e() {
        this.authInfoLiveData.removeObserver(this.observerOfAuthInfo);
        LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> liveData = this.defaultAccountLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.observerOfDefaultAccount);
        }
    }

    public final void f() {
        g();
    }

    public final void m(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<WeakReference<a>> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().get(), listener)) {
                return;
            }
        }
        this.mListenerPool.add(new WeakReference<>(listener));
    }
}
