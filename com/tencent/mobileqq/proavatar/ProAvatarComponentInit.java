package com.tencent.mobileqq.proavatar;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.proavatar.drawable.ProAvatarDrawableFactory;
import com.tencent.mobileqq.proavatar.group.GroupUtil;
import com.tencent.mobileqq.proavatar.info.AvatarInfoBuilder;
import com.tencent.mobileqq.proavatar.info.db.AvatarInfoEntity;
import com.tencent.mobileqq.proavatar.info.db.AvatarInfoEntityManager;
import com.tencent.mobileqq.proavatar.resource.ProAvatarResourceHelper;
import com.tencent.mobileqq.proavatar.transform.CircleAvatarTransform;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u00011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R<\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010`\u00128\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016RH\u0010\"\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00100\u001aj\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u0010`\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010$R$\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R!\u0010-\u001a\u00020\u00068FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\r\u0010+\u0012\u0004\b,\u0010\u0018\u001a\u0004\b\u001d\u0010)R\u001b\u00100\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b\u0013\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00102\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/proavatar/ProAvatarComponentInit;", "", "", "d", "", "key", "", "readDb", "Lcom/tencent/mobileqq/proavatar/info/db/AvatarInfoEntity;", "a", "Lcom/tencent/mobileqq/app/face/FaceInfo;", "faceInfo", "g", "f", tl.h.F, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/avatar/meta/transform/b;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getTransformHandlerList", "()Ljava/util/ArrayList;", "getTransformHandlerList$annotations", "()V", "transformHandlerList", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/avatar/dynamic/drawable/a;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "getDynamicDrawableFactoryMap", "()Ljava/util/HashMap;", "getDynamicDrawableFactoryMap$annotations", "dynamicDrawableFactoryMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInit", "<set-?>", "e", "Z", "()Z", "isEnableMp4Avatar", "Lkotlin/Lazy;", "getUseNewAvatarInfoEntity$annotations", "useNewAvatarInfoEntity", "Lcom/tencent/mobileqq/proavatar/info/db/AvatarInfoEntityManager;", "()Lcom/tencent/mobileqq/proavatar/info/db/AvatarInfoEntityManager;", "avatarInfoEntityManager", "com/tencent/mobileqq/proavatar/ProAvatarComponentInit$accountCallback$1", "Lcom/tencent/mobileqq/proavatar/ProAvatarComponentInit$accountCallback$1;", "accountCallback", "<init>", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProAvatarComponentInit {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ProAvatarComponentInit f259495a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQAvatarImpl/Inject_ProAvatarComponentInit.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.avatar.meta.transform.b>> transformHandlerList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQAvatarImpl/Inject_ProAvatarComponentInit.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<com.tencent.qqnt.avatar.dynamic.drawable.a>> dynamicDrawableFactoryMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean hasInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnableMp4Avatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy useNewAvatarInfoEntity;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy avatarInfoEntityManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ProAvatarComponentInit$accountCallback$1 accountCallback;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/proavatar/ProAvatarComponentInit$a", "Lcom/tencent/qqnt/avatar/util/a;", "", "tag", "msg", "", "d", "", "throwable", "e", "i", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements com.tencent.qqnt.avatar.util.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.avatar.util.a
        public void d(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (QLog.isDevelopLevel()) {
                QLog.d(tag, 2, msg2);
            }
        }

        @Override // com.tencent.qqnt.avatar.util.a
        public void e(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, tag, msg2, throwable);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(tag, 1, msg2, throwable);
        }

        @Override // com.tencent.qqnt.avatar.util.a
        public void i(@NotNull String tag, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i(tag, 2, msg2);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/proavatar/ProAvatarComponentInit$b", "Lcom/tencent/qqnt/avatar/util/c;", "", "name", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "isSwitchOn", VipFunCallConstants.KEY_GROUP, AdMetricTag.FALLBACK, "loadAsString", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements com.tencent.qqnt.avatar.util.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.avatar.util.c
        public boolean isSwitchOn(@NotNull String name, boolean defaultValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, name, Boolean.valueOf(defaultValue))).booleanValue();
            }
            Intrinsics.checkNotNullParameter(name, "name");
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(name, defaultValue);
        }

        @Override // com.tencent.qqnt.avatar.util.c
        @NotNull
        public String loadAsString(@NotNull String group, @NotNull String fallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) group, (Object) fallback);
            }
            Intrinsics.checkNotNullParameter(group, "group");
            Intrinsics.checkNotNullParameter(fallback, "fallback");
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(group, fallback);
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.tencent.mobileqq.proavatar.ProAvatarComponentInit$accountCallback$1] */
    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f259495a = new ProAvatarComponentInit();
        ArrayList<Class<com.tencent.qqnt.avatar.meta.transform.b>> arrayList = new ArrayList<>();
        transformHandlerList = arrayList;
        arrayList.add(com.tencent.mobileqq.proavatar.transform.a.class);
        arrayList.add(com.tencent.mobileqq.proavatar.transform.b.class);
        arrayList.add(CircleAvatarTransform.class);
        HashMap<String, Class<com.tencent.qqnt.avatar.dynamic.drawable.a>> hashMap = new HashMap<>();
        dynamicDrawableFactoryMap = hashMap;
        hashMap.put("apng", ProAvatarDrawableFactory.class);
        hasInit = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(ProAvatarComponentInit$useNewAvatarInfoEntity$2.INSTANCE);
        useNewAvatarInfoEntity = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ProAvatarComponentInit$avatarInfoEntityManager$2.INSTANCE);
        avatarInfoEntityManager = lazy2;
        accountCallback = new IAccountCallback() { // from class: com.tencent.mobileqq.proavatar.ProAvatarComponentInit$accountCallback$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy onAccountChangeFixSwitch;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @Nullable
            private String lastAccount;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    lazy3 = LazyKt__LazyJVMKt.lazy(ProAvatarComponentInit$accountCallback$1$onAccountChangeFixSwitch$2.INSTANCE);
                    this.onAccountChangeFixSwitch = lazy3;
                } else {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            private final boolean a() {
                return ((Boolean) this.onAccountChangeFixSwitch.getValue()).booleanValue();
            }

            @Override // mqq.app.IAccountCallback
            public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) newRuntime);
                    return;
                }
                if (newRuntime != null) {
                    str = newRuntime.getAccount();
                } else {
                    str = null;
                }
                QLog.i("ProAvatarComponentInit", 1, "accountCallback onAccountChangeFailed " + str);
            }

            @Override // mqq.app.IAccountCallback
            public void onAccountChanged(@Nullable AppRuntime newRuntime) {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) newRuntime);
                    return;
                }
                String str2 = null;
                if (newRuntime != null) {
                    str = newRuntime.getAccount();
                } else {
                    str = null;
                }
                QLog.i("ProAvatarComponentInit", 1, "accountCallback onAccountChanged " + str);
                if (!a() || ProAvatarComponentInit.c()) {
                    return;
                }
                if (this.lastAccount != null) {
                    com.tencent.qqnt.avatar.g.f352801a.c();
                }
                if (newRuntime != null) {
                    str2 = newRuntime.getAccount();
                }
                this.lastAccount = str2;
            }

            @Override // mqq.app.IAccountCallback
            public void onLogout(@Nullable Constants.LogoutReason reason) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) reason);
                    return;
                }
                QLog.i("ProAvatarComponentInit", 1, "accountCallback onLogout reason: " + reason);
            }
        };
    }

    ProAvatarComponentInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final AvatarInfoEntity a(@NotNull String key, boolean readDb) {
        Intrinsics.checkNotNullParameter(key, "key");
        return f259495a.b().b(key, readDb);
    }

    private final AvatarInfoEntityManager b() {
        return (AvatarInfoEntityManager) avatarInfoEntityManager.getValue();
    }

    public static final boolean c() {
        return ((Boolean) useNewAvatarInfoEntity.getValue()).booleanValue();
    }

    @JvmStatic
    public static final void d() {
        int collectionSizeOrDefault;
        List mutableList;
        Object first;
        if (hasInit.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i("ProAvatarComponentInit", 1, "init " + currentTimeMillis);
            com.tencent.qqnt.avatar.g gVar = com.tencent.qqnt.avatar.g.f352801a;
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            gVar.j(context);
            com.tencent.qqnt.avatar.g.DEBUG = QLog.isColorLevel();
            QLog.i("ProAvatarComponentInit", 1, "init DEBUG? " + QLog.isColorLevel());
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("nt_proavatar_enable_mp4_avatar", false);
            boolean isSwitchOn2 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("nt_proavatar_refresh_callback_register_fix", true);
            boolean isSwitchOn3 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("nt_proavatar_organizer_weak_switch_fix", true);
            QLog.i("ProAvatarComponentInit", 1, "isEnableMp4Avatar: " + isSwitchOn + ", refreshFix: " + isSwitchOn2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("organizerWeakSwitch: ");
            sb5.append(isSwitchOn3);
            QLog.i("ProAvatarComponentInit", 1, sb5.toString());
            isEnableMp4Avatar = isSwitchOn;
            gVar.x(isSwitchOn2);
            gVar.w(isSwitchOn3);
            com.tencent.qqnt.avatar.g.o(new a());
            com.tencent.qqnt.avatar.g.t(new b());
            f259495a.b().d();
            com.tencent.qqnt.avatar.g.n(com.tencent.mobileqq.proavatar.info.a.f259616a);
            com.tencent.qqnt.avatar.g.k(new AvatarInfoBuilder());
            com.tencent.qqnt.avatar.g.m(new com.tencent.mobileqq.proavatar.info.b());
            ArrayList<Class<com.tencent.qqnt.avatar.meta.transform.b>> arrayList = transformHandlerList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
                Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
                first = ArraysKt___ArraysKt.first(constructors);
                arrayList2.add(((Constructor) first).newInstance(new Object[0]));
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
            com.tencent.qqnt.avatar.g.a(mutableList);
            f.f259594a.a();
            com.tencent.qqnt.avatar.g.r(new ProAvatarResourceHelper());
            for (Map.Entry<String, Class<com.tencent.qqnt.avatar.dynamic.drawable.a>> entry : dynamicDrawableFactoryMap.entrySet()) {
                try {
                    com.tencent.qqnt.avatar.dynamic.drawable.a newInstance = entry.getValue().newInstance();
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.avatar.dynamic.drawable.DynamicDrawableFactory");
                    com.tencent.qqnt.avatar.g.b(entry.getKey(), newInstance);
                } catch (Exception e16) {
                    QLog.e("ProAvatarComponentInit", 1, "create drawable factory error:", e16);
                }
            }
            com.tencent.qqnt.avatar.g.f352801a.s(j.f259629a);
            com.tencent.qqnt.avatar.g.l(GroupUtil.f259599a);
            QLog.i("ProAvatarComponentInit", 1, "init end. cost(" + (System.currentTimeMillis() - currentTimeMillis));
            com.tencent.qqnt.avatar.g.p(com.tencent.mobileqq.proavatar.report.a.f259665a);
            MobileQQ.sMobileQQ.registerAccountCallback(accountCallback);
        }
        if (com.tencent.qqnt.avatar.g.DEBUG != QLog.isColorLevel()) {
            com.tencent.qqnt.avatar.g.DEBUG = QLog.isColorLevel();
            QLog.i("ProAvatarComponentInit", 1, "init DEBUG? " + QLog.isColorLevel());
        }
    }

    @JvmStatic
    public static final void f(@Nullable FaceInfo faceInfo) {
        f259495a.b().g(faceInfo);
    }

    @JvmStatic
    public static final void g(@Nullable FaceInfo faceInfo) {
        f259495a.b().i(faceInfo);
    }

    @JvmStatic
    public static final void h(@Nullable String key) {
        f259495a.b().j(key);
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return isEnableMp4Avatar;
    }
}
