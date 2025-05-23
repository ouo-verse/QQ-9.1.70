package is1;

import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010%\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010$\u00a8\u0006'"}, d2 = {"Lis1/a;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lis1/f;", "listener", "", "d", "f", "i", "k", "j", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "e", "", "account", "onAccountChanged", "Ljava/lang/String;", "_faceAuthVerifyUrl", "", "I", "_faceAuthStatus", "", h.F, "Ljava/util/List;", "listeners", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gproServiceObserver", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "g", "()Ljava/lang/String;", "getFaceAuthVerifyUrl$annotations", "()V", "faceAuthVerifyUrl", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f408459d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String _faceAuthVerifyUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int _faceAuthStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<f> listeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final GPServiceObserver gproServiceObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static ServiceCache$LazyHolder serviceHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\f"}, d2 = {"is1/a$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "result", "", "errMsg", "guildId", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "", "onUserProfileInfoUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: is1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C10550a extends GPServiceObserver {
        C10550a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @Nullable String errMsg, @Nullable String guildId, @Nullable String tinyId, @Nullable ev info) {
            if (!Intrinsics.areEqual(tinyId, ch.f())) {
                return;
            }
            if (result == 0 && info != null) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.auth.GuildFaceAuthRepository", 2, "onUserProfileInfoUpdate success, " + tinyId + " " + info.a() + " |" + info.getVerifyUrl());
                }
                a aVar = a.f408459d;
                a._faceAuthStatus = info.a();
                String verifyUrl = info.getVerifyUrl();
                Intrinsics.checkNotNullExpressionValue(verifyUrl, "info.verifyUrl");
                a._faceAuthVerifyUrl = verifyUrl;
                a.f408459d.i();
                return;
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onUserProfileInfoUpdate failed, result:" + result + " errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.auth.GuildFaceAuthRepository", 1, (String) it.next(), null);
            }
        }
    }

    static {
        a aVar = new a();
        f408459d = aVar;
        _faceAuthVerifyUrl = "";
        listeners = new ArrayList();
        gproServiceObserver = aVar.e();
        AccountChangedNotifier.f214789d.a(aVar);
        aVar.k();
    }

    a() {
    }

    @JvmStatic
    public static final void d(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<f> list = listeners;
        if (!list.contains(listener)) {
            list.add(listener);
        }
    }

    private final GPServiceObserver e() {
        return new C10550a();
    }

    @JvmStatic
    public static final void f(@NotNull f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    @NotNull
    public static final String g() {
        return _faceAuthVerifyUrl;
    }

    private final IGPSService h() {
        ServiceCache$LazyHolder serviceCache$LazyHolder = serviceHolder;
        if (serviceCache$LazyHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            serviceCache$LazyHolder = null;
        }
        return serviceCache$LazyHolder.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((f) it.next()).onStatusChange(_faceAuthStatus);
        }
    }

    @JvmStatic
    public static final void j() {
        String f16 = ch.f();
        Intrinsics.checkNotNullExpressionValue(f16, "accountTinyId()");
        f408459d.h().refreshGuildUserProfileInfo("0", f16);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.auth.GuildFaceAuthRepository", 2, "refreshUserInfoForce " + f16);
        }
    }

    private final void k() {
        serviceHolder = new ServiceCache$LazyHolder("Guild.auth.GuildFaceAuthRepository");
        h().addObserver(gproServiceObserver);
        j();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        h().deleteObserver(gproServiceObserver);
        k();
    }
}
