package com.tencent.mobileqq.proavatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasDataHelperApi;
import com.tencent.mobileqq.vas.api.IVipDataUpdateApi;
import com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager;
import com.tencent.mobileqq.vas.frequency.IFrequencyCheckApi;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.core.a;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/proavatar/l;", "Lcom/tencent/qqnt/avatar/core/a;", "Lcom/tencent/mobileqq/avatar/utils/e;", "bean", "Lcom/tencent/qqnt/avatar/core/a$a;", "callback", "", "f", "", "uin", "", "isQueryFromDb", "", "g", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/bean/a;", "forceRefresh", "Lcom/tencent/qqnt/avatar/fetch/b;", "a", "Lcom/tencent/qqnt/avatar/fetch/d;", "c", "<init>", "()V", "b", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class l extends com.tencent.qqnt.avatar.core.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/proavatar/l$a;", "", "", "DEBUG", "Z", "SUPPORT_FORCE_REFRESH", "SUPPORT_SYNC", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.l$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/proavatar/l$b", "Lcom/tencent/mobileqq/vas/avatar/api/IVasAvatarManager$DrawableCreateCallback;", "Landroid/graphics/drawable/Drawable;", "d", "", "createCallback", "", "code", "", "msg", "createFail", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements IVasAvatarManager.DrawableCreateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.avatar.utils.e f259635a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC9507a f259636b;

        b(com.tencent.mobileqq.avatar.utils.e eVar, a.InterfaceC9507a interfaceC9507a) {
            this.f259635a = eVar;
            this.f259636b = interfaceC9507a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) interfaceC9507a);
            }
        }

        @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager.DrawableCreateCallback
        public void createCallback(@Nullable Drawable d16) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) d16);
                return;
            }
            if (QLog.isDebugVersion()) {
                int f16 = this.f259635a.f();
                if (d16 != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.i("VasAvatarResourceFetcher", 1, "fetcherResource createCallback bean.faceId:" + f16 + " isSuccess:" + z16);
            }
            if (d16 != null) {
                this.f259636b.a(new com.tencent.qqnt.avatar.fetch.d(this.f259635a, true, new com.tencent.qqnt.avatar.layer.b(this.f259635a, d16, null), ""));
            } else {
                this.f259636b.a(new com.tencent.qqnt.avatar.fetch.d(this.f259635a, false, null, ""));
            }
        }

        @Override // com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager.DrawableCreateCallback
        public void createFail(int code, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, code, (Object) msg2);
                return;
            }
            QLog.i("VasAvatarResourceFetcher", 1, "avatar fetchResourceAsync bean:" + this.f259635a + " code:" + code + " msg:" + msg2);
            this.f259636b.a(new com.tencent.qqnt.avatar.fetch.d(this.f259635a, false, null, "code: " + code + " msg: " + msg2));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/proavatar/l$c", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$RequestResultCallback;", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$AvatarPendantInfo;", "info", "", "callback", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements IVipDataUpdateApi.RequestResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.avatar.bean.a f259637a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f259638b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC9507a f259639c;

        c(com.tencent.qqnt.avatar.bean.a aVar, l lVar, a.InterfaceC9507a interfaceC9507a) {
            this.f259637a = aVar;
            this.f259638b = lVar;
            this.f259639c = interfaceC9507a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, lVar, interfaceC9507a);
            }
        }

        @Override // com.tencent.mobileqq.vas.api.IVipDataUpdateApi.RequestResultCallback
        public void callback(@NotNull IVipDataUpdateApi.AvatarPendantInfo info) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            if ((((com.tencent.mobileqq.avatar.utils.e) this.f259637a).l() == 9 || ((com.tencent.mobileqq.avatar.utils.e) this.f259637a).l() == 0) && !TextUtils.isEmpty(((com.tencent.mobileqq.avatar.utils.e) this.f259637a).i()) && !TextUtils.isEmpty(((com.tencent.mobileqq.avatar.utils.e) this.f259637a).h()) && info.getAvatarId() != ((com.tencent.mobileqq.avatar.utils.e) this.f259637a).f()) {
                IFrequencyCheckApi iFrequencyCheckApi = (IFrequencyCheckApi) QRoute.api(IFrequencyCheckApi.class);
                String c16 = this.f259637a.c();
                if (c16 != null) {
                    j3 = Long.parseLong(c16);
                } else {
                    j3 = 0;
                }
                iFrequencyCheckApi.checkAvatarPendantChangedAndTriggerFrequency(j3, ((com.tencent.mobileqq.avatar.utils.e) this.f259637a).i(), ((com.tencent.mobileqq.avatar.utils.e) this.f259637a).h());
            }
            ((com.tencent.mobileqq.avatar.utils.e) this.f259637a).m(info.getAvatarId());
            com.tencent.mobileqq.avatar.utils.e eVar = (com.tencent.mobileqq.avatar.utils.e) this.f259637a;
            VipData.VipNumberInfo vipNumberInfo = new VipData.VipNumberInfo();
            vipNumberInfo.setAppId(VipData.VipNumberInfo.APPID.Avatar.getId());
            vipNumberInfo.setItemId(info.getAvatarId());
            eVar.n(vipNumberInfo);
            this.f259638b.f((com.tencent.mobileqq.avatar.utils.e) this.f259637a, this.f259639c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/proavatar/l$d", "Lcom/tencent/qqnt/avatar/fetch/b;", "", "cancel", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements com.tencent.qqnt.avatar.fetch.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.avatar.fetch.b
        public void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l() {
        super(2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(com.tencent.mobileqq.avatar.utils.e bean, a.InterfaceC9507a callback) {
        if (bean.f() == 0) {
            callback.a(new com.tencent.qqnt.avatar.fetch.d(bean, false, null, ""));
            return;
        }
        QRouteApi api = QRoute.api(IVasAvatarManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasAvatarManager::class.java)");
        String c16 = bean.c();
        Intrinsics.checkNotNull(c16);
        IVasAvatarManager.DefaultImpls.getVasAvatarDrawable$default((IVasAvatarManager) api, c16, bean.f(), bean.e(), bean.j(), bean.l(), new b(bean, callback), 0, 64, null);
    }

    private final int g(String uin, boolean isQueryFromDb) {
        NTVasSimpleInfo queryExtensionInfo = ((IVasDataHelperApi) QRoute.api(IVasDataHelperApi.class)).queryExtensionInfo(uin, isQueryFromDb);
        if (queryExtensionInfo != null) {
            return queryExtensionInfo.faceId;
        }
        return 0;
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @NotNull
    public com.tencent.qqnt.avatar.fetch.b a(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.bean.a bean, @NotNull a.InterfaceC9507a callback, boolean forceRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.fetch.b) iPatchRedirector.redirect((short) 2, this, context, bean, callback, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d dVar = new d();
        if (!(bean instanceof com.tencent.mobileqq.avatar.utils.e)) {
            return dVar;
        }
        if (forceRefresh) {
            IVipDataUpdateApi iVipDataUpdateApi = (IVipDataUpdateApi) QRoute.api(IVipDataUpdateApi.class);
            String c16 = bean.c();
            Intrinsics.checkNotNull(c16);
            iVipDataUpdateApi.requestAvatarPendantInfoChanged(c16, new c(bean, this, callback));
        } else {
            com.tencent.mobileqq.avatar.utils.e eVar = (com.tencent.mobileqq.avatar.utils.e) bean;
            if (eVar.f() <= 0) {
                String c17 = bean.c();
                Intrinsics.checkNotNull(c17);
                int g16 = g(c17, true);
                if (g16 <= 0) {
                    if (((com.tencent.mobileqq.avatar.utils.e) bean).g()) {
                        return a(context, bean, callback, true);
                    }
                    callback.a(new com.tencent.qqnt.avatar.fetch.d(bean, false, null, ""));
                    return dVar;
                }
                com.tencent.mobileqq.avatar.utils.e eVar2 = (com.tencent.mobileqq.avatar.utils.e) bean;
                eVar2.m(g16);
                VipData.VipNumberInfo vipNumberInfo = new VipData.VipNumberInfo();
                vipNumberInfo.setAppId(VipData.VipNumberInfo.APPID.Avatar.getId());
                vipNumberInfo.setItemId(g16);
                eVar2.n(vipNumberInfo);
            }
            f(eVar, callback);
        }
        return dVar;
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @Nullable
    public com.tencent.qqnt.avatar.fetch.d c(@NotNull com.tencent.qqnt.avatar.bean.a bean, boolean forceRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.fetch.d) iPatchRedirector.redirect((short) 3, this, bean, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        return null;
    }
}
