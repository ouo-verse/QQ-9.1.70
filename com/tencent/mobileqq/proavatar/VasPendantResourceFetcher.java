package com.tencent.mobileqq.proavatar;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.api.IVasDataHelperApi;
import com.tencent.mobileqq.vas.api.IVipDataUpdateApi;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.frequency.IFrequencyCheckApi;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.core.a;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b,\u0010-J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J<\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u001f2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0002J(\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001c0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/proavatar/VasPendantResourceFetcher;", "Lcom/tencent/qqnt/avatar/core/a;", "Lcom/tencent/mobileqq/avatar/utils/f;", "vasPendantBean", "Lcom/tencent/qqnt/avatar/core/a$a;", "callback", "", "forceRefresh", "", "i", "b", tl.h.F, "Lcom/tencent/qqnt/avatar/layer/c;", "f", "Lcom/tencent/qqnt/avatar/bean/a;", "bean", "g", "", "targetId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "uin", "pendantId", "", "diyId", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "numberInfo", "Landroid/graphics/drawable/Drawable;", "j", "isQueryFromDb", "Lkotlin/Pair;", "k", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/avatar/fetch/b;", "a", "Lcom/tencent/qqnt/avatar/fetch/d;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "map", "J", "lastTarget", "<init>", "()V", "d", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class VasPendantResourceFetcher extends com.tencent.qqnt.avatar.core.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static AtomicLong f259537e;

    /* renamed from: f, reason: collision with root package name */
    private static long f259538f;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f259539g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final HashMap<Long, Boolean> f259540h;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Drawable> map;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile long lastTarget;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/proavatar/VasPendantResourceFetcher$a;", "", "", "OPEN_CACHE", "Z", "SUPPORT_FORCE_REFRESH", "SUPPORT_SYNC", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "cacheFileCheckMap", "Ljava/util/HashMap;", "Ljava/util/concurrent/atomic/AtomicLong;", "forceUpdateTime", "Ljava/util/concurrent/atomic/AtomicLong;", "isCacheFileCheck", "preloadPendantId", "J", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.VasPendantResourceFetcher$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/proavatar/VasPendantResourceFetcher$b", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$RequestResultCallback;", "Lcom/tencent/mobileqq/vas/api/IVipDataUpdateApi$AvatarPendantInfo;", "info", "", "callback", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements IVipDataUpdateApi.RequestResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.avatar.utils.f f259543a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f259544b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ VasPendantResourceFetcher f259545c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC9507a f259546d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f259547e;

        b(com.tencent.mobileqq.avatar.utils.f fVar, Ref.BooleanRef booleanRef, VasPendantResourceFetcher vasPendantResourceFetcher, a.InterfaceC9507a interfaceC9507a, boolean z16) {
            this.f259543a = fVar;
            this.f259544b = booleanRef;
            this.f259545c = vasPendantResourceFetcher;
            this.f259546d = interfaceC9507a;
            this.f259547e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, fVar, booleanRef, vasPendantResourceFetcher, interfaceC9507a, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.vas.api.IVipDataUpdateApi.RequestResultCallback
        public void callback(@NotNull IVipDataUpdateApi.AvatarPendantInfo info) {
            boolean z16;
            boolean z17;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            long pendantId = info.getPendantId();
            int pendantDiyId = info.getPendantDiyId();
            boolean z18 = false;
            if (this.f259543a.k() != PendantConstant.PENDANT_TARGET_ID_AIO && this.f259543a.k() != PendantConstant.PENDANT_TARGET_ID_RECENT_MSG) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!TextUtils.isEmpty(this.f259543a.h()) && !TextUtils.isEmpty(this.f259543a.g())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (pendantId != this.f259543a.j() || pendantDiyId != this.f259543a.i()) {
                z18 = true;
            }
            if (z16 && z17 && (z18 || this.f259544b.element)) {
                IFrequencyCheckApi iFrequencyCheckApi = (IFrequencyCheckApi) QRoute.api(IFrequencyCheckApi.class);
                String c16 = this.f259543a.c();
                if (c16 != null) {
                    j3 = Long.parseLong(c16);
                } else {
                    j3 = 0;
                }
                iFrequencyCheckApi.checkAvatarPendantChangedAndTriggerFrequency(j3, this.f259543a.h(), this.f259543a.g());
            }
            this.f259543a.n(pendantId);
            this.f259543a.m(pendantDiyId);
            com.tencent.mobileqq.avatar.utils.f fVar = this.f259543a;
            VipData.VipNumberInfo vipNumberInfo = new VipData.VipNumberInfo();
            vipNumberInfo.setItemId((int) pendantId);
            vipNumberInfo.setAppId(VipData.VipNumberInfo.APPID.Pendant.getId());
            fVar.o(vipNumberInfo);
            this.f259545c.i(this.f259543a, this.f259546d, this.f259547e);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/proavatar/VasPendantResourceFetcher$c", "Lcom/tencent/qqnt/avatar/fetch/b;", "", "cancel", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements com.tencent.qqnt.avatar.fetch.b {
        static IPatchRedirector $redirector_;

        c() {
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
            } else {
                QLog.i("VasPendantResourceFetcher", 4, "cancel ");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        f259537e = new AtomicLong(-1L);
        f259539g = ar.INSTANCE.b("shouyouye", "2024-03-19", "vas_pendant_cache_file_check_result").isEnable(true);
        f259540h = new HashMap<>();
    }

    public VasPendantResourceFetcher() {
        super(3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.map = new ConcurrentHashMap<>();
            this.lastTarget = -1L;
        }
    }

    private final com.tencent.qqnt.avatar.layer.c f() {
        return new com.tencent.qqnt.avatar.layer.c(new Rect(5, 14, 45, 54), true, new Rect(0, 0, 50, 59));
    }

    private final com.tencent.mobileqq.avatar.utils.f g(com.tencent.qqnt.avatar.bean.a bean) {
        if (!(bean instanceof com.tencent.mobileqq.avatar.utils.f) || TextUtils.isEmpty(bean.c())) {
            return null;
        }
        return (com.tencent.mobileqq.avatar.utils.f) bean;
    }

    private final boolean h(com.tencent.mobileqq.avatar.utils.f b16) {
        if (b16.k() != 7 && SimpleUIUtil.getSimpleUISwitch()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(com.tencent.mobileqq.avatar.utils.f vasPendantBean, a.InterfaceC9507a callback, boolean forceRefresh) {
        m(vasPendantBean.k());
        String c16 = vasPendantBean.c();
        Intrinsics.checkNotNull(c16);
        callback.a(new com.tencent.qqnt.avatar.fetch.d(vasPendantBean, true, new com.tencent.qqnt.avatar.layer.b(vasPendantBean, j(c16, vasPendantBean.j(), vasPendantBean.i(), vasPendantBean.l(), vasPendantBean.k(), forceRefresh), f()), null, 8, null));
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.Object] */
    private final Drawable j(String uin, long pendantId, int diyId, VipData.VipNumberInfo numberInfo, long targetId, boolean forceRefresh) {
        boolean z16;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r56 = this.map.get(uin + "_" + pendantId + "_" + diyId + "_" + targetId);
        objectRef.element = r56;
        if (r56 == 0) {
            IPendantInfo pendantInfo = ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getAvatarPendantManager().getPendantInfo(pendantId, false);
            if (!forceRefresh && !l(targetId)) {
                z16 = false;
            } else {
                z16 = true;
            }
            ?? drawable = pendantInfo.getDrawable(2, targetId, uin, diyId, true, numberInfo, z16);
            objectRef.element = drawable;
            return drawable;
        }
        return new AbsAsyncDrawable(objectRef) { // from class: com.tencent.mobileqq.proavatar.VasPendantResourceFetcher$getPendantDrawable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef);
                } else {
                    setTargetDrawableBuild(new Function0<Drawable>(objectRef) { // from class: com.tencent.mobileqq.proavatar.VasPendantResourceFetcher$getPendantDrawable$1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Ref.ObjectRef<Drawable> $d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$d = objectRef;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) objectRef);
                            }
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final Drawable invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.$d.element : (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    });
                    AbsAsyncDrawable.load$default(this, false, 1, null);
                }
            }

            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
            public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
                } else {
                    Intrinsics.checkNotNullParameter(callback, "callback");
                }
            }

            @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
            /* renamed from: isLoadSucess */
            public boolean getIsLoadSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return true;
            }
        };
    }

    private final Pair<Long, Integer> k(String uin, boolean isQueryFromDb) {
        long j3;
        int i3;
        Long l3;
        NTVasSimpleInfo queryExtensionInfo = ((IVasDataHelperApi) QRoute.api(IVasDataHelperApi.class)).queryExtensionInfo(uin, isQueryFromDb);
        if (QLog.isColorLevel()) {
            if (queryExtensionInfo != null) {
                l3 = Long.valueOf(queryExtensionInfo.pendantId);
            } else {
                l3 = null;
            }
            QLog.i("VasPendantResourceFetcher", 1, "getPendantInfo from db cache pendantId:" + l3);
        }
        if (queryExtensionInfo != null) {
            j3 = queryExtensionInfo.pendantId;
        } else {
            j3 = 0;
        }
        Long valueOf = Long.valueOf(j3);
        if (queryExtensionInfo != null) {
            i3 = queryExtensionInfo.pendantDiyId;
        } else {
            i3 = 0;
        }
        return new Pair<>(valueOf, Integer.valueOf(i3));
    }

    private final boolean l(long targetId) {
        if (targetId != PendantConstant.PENDANT_TARGET_ID_AIO && targetId != PendantConstant.PENDANT_TARGET_ID_RECENT_MSG) {
            return true;
        }
        return false;
    }

    private final void m(long targetId) {
        if (this.lastTarget != targetId) {
            this.lastTarget = targetId;
            IAvatarPendantManager avatarPendantManager = ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getAvatarPendantManager();
            if (l(targetId)) {
                avatarPendantManager.setPlayAnimatinDelay();
            } else {
                avatarPendantManager.setPlayAnimatinImmediately();
            }
        }
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
        c cVar = new c();
        com.tencent.mobileqq.avatar.utils.f g16 = g(bean);
        if (g16 == null) {
            return cVar;
        }
        if (h(g16)) {
            callback.a(new com.tencent.qqnt.avatar.fetch.d(g16, true, null, null, 8, null));
            return cVar;
        }
        if (forceRefresh && g16.k() != 9) {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            long currentTimeMillis = System.currentTimeMillis();
            if (f259537e.compareAndSet(-1L, currentTimeMillis)) {
                booleanRef.element = true;
            } else if (currentTimeMillis - f259537e.get() > 1000) {
                f259537e.set(currentTimeMillis);
                booleanRef.element = true;
            }
            IVipDataUpdateApi iVipDataUpdateApi = (IVipDataUpdateApi) QRoute.api(IVipDataUpdateApi.class);
            String c16 = bean.c();
            Intrinsics.checkNotNull(c16);
            iVipDataUpdateApi.requestAvatarPendantInfoChanged(c16, new b(g16, booleanRef, this, callback, forceRefresh));
        } else {
            if (g16.j() <= 0 && g16.i() <= 0 && !SimpleUIUtil.getSimpleUISwitch()) {
                String c17 = g16.c();
                Intrinsics.checkNotNull(c17);
                Pair<Long, Integer> k3 = k(c17, true);
                if (k3.getFirst().longValue() <= 0 && k3.getSecond().intValue() <= 0) {
                    if (g16.f()) {
                        return a(context, bean, callback, true);
                    }
                    callback.a(new com.tencent.qqnt.avatar.fetch.d(g16, false, null, null, 8, null));
                    return cVar;
                }
                g16.n(k3.getFirst().longValue());
                g16.m(k3.getSecond().intValue());
                VipData.VipNumberInfo vipNumberInfo = new VipData.VipNumberInfo();
                vipNumberInfo.setAppId(VipData.VipNumberInfo.APPID.Pendant.getId());
                vipNumberInfo.setItemId((int) k3.getFirst().longValue());
                g16.o(vipNumberInfo);
            }
            if (g16.j() <= 0 && g16.i() <= 0) {
                return cVar;
            }
            i(g16, callback, forceRefresh);
        }
        return cVar;
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @Nullable
    public com.tencent.qqnt.avatar.fetch.d c(@NotNull com.tencent.qqnt.avatar.bean.a bean, boolean forceRefresh) {
        com.tencent.mobileqq.avatar.utils.f g16;
        QQVasUpdateBusiness businessInstance;
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.fetch.d) iPatchRedirector.redirect((short) 3, this, bean, Boolean.valueOf(forceRefresh));
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (forceRefresh || (g16 = g(bean)) == null || h(g16)) {
            return null;
        }
        if (g16.j() <= 0 && g16.i() <= 0) {
            String c16 = g16.c();
            Intrinsics.checkNotNull(c16);
            Pair<Long, Integer> k3 = k(c16, false);
            if (k3.getFirst().longValue() <= 0 && k3.getSecond().intValue() <= 0) {
                return null;
            }
            g16.n(k3.getFirst().longValue());
            g16.m(k3.getSecond().intValue());
            VipData.VipNumberInfo vipNumberInfo = new VipData.VipNumberInfo();
            vipNumberInfo.setAppId(VipData.VipNumberInfo.APPID.Pendant.getId());
            vipNumberInfo.setItemId((int) k3.getFirst().longValue());
            g16.o(vipNumberInfo);
        }
        if (f259538f != g16.j() || QLog.isDebugVersion()) {
            QLog.i("VasPendantResourceFetcher", 1, "syncFetcherResource bean: " + bean + ", vas= pendantId:" + g16.j() + " diyId:" + g16.i() + " vipNum:" + g16.l());
            f259538f = g16.j();
        }
        if ((g16.j() <= 0 && g16.i() <= 0) || (businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 4L)) == null) {
            return null;
        }
        m(g16.k());
        if (f259539g && (bool = f259540h.get(Long.valueOf(g16.j()))) != null) {
            z16 = bool.booleanValue();
        }
        if (!z16) {
            z16 = businessInstance.isFileExists((int) g16.j());
            f259540h.put(Long.valueOf(g16.j()), Boolean.valueOf(z16));
        }
        if (z16) {
            String c17 = g16.c();
            Intrinsics.checkNotNull(c17);
            return new com.tencent.qqnt.avatar.fetch.d(g16, true, new com.tencent.qqnt.avatar.layer.b(g16, j(c17, g16.j(), g16.i(), g16.l(), g16.k(), forceRefresh), f()), "");
        }
        businessInstance.startDownload((int) g16.j());
        return null;
    }
}
