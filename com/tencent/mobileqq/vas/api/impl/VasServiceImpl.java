package com.tencent.mobileqq.vas.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManagerImpl;
import com.tencent.mobileqq.vas.api.IVasAppIconSwitchManager;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.api.IVasSchemeManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasThemeFontApi;
import com.tencent.mobileqq.vas.api.IVasUpdateManager;
import com.tencent.mobileqq.vas.api.IVipDataRequestProxy;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.gxh.GXHManagerImpl;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.manager.api.IJsbCallManager;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.mobileqq.vas.manager.api.impl.ThemeSwitchManagerImpl;
import com.tencent.mobileqq.vas.theme.JsbCallImpl;
import com.tencent.mobileqq.vas.tianshu.TianshuWebManagerImpl;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 f2\u00020\u0001:\u0001gB\u0007\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010\u0011\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010\u0011\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010\u0011\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010\u0011\u001a\u0004\bI\u0010JR\u001b\u0010P\u001a\u00020L8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010\u0011\u001a\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010\u0011\u001a\u0004\bS\u0010TR\u001b\u0010Z\u001a\u00020V8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010\u0011\u001a\u0004\bX\u0010YR\u001b\u0010_\u001a\u00020[8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010\u0011\u001a\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\ba\u0010b\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasServiceImpl;", "Lcom/tencent/mobileqq/vas/api/IVasService;", "", "isInMainProcess", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "T", "", "impl", "dynamicCall", "(Ljava/lang/Object;)Lcom/tencent/mobileqq/vas/api/IVasManager;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "kingCardManager$delegate", "Lkotlin/Lazy;", "getKingCardManager", "()Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "kingCardManager", "Lcom/tencent/mobileqq/vas/api/IVasHybridRoute;", "vasHybridRoute$delegate", "getVasHybridRoute", "()Lcom/tencent/mobileqq/vas/api/IVasHybridRoute;", "vasHybridRoute", "Lcom/tencent/mobileqq/vas/manager/api/impl/ThemeSwitchManagerImpl;", "themeSwitchManager$delegate", "getThemeSwitchManager", "()Lcom/tencent/mobileqq/vas/manager/api/impl/ThemeSwitchManagerImpl;", "themeSwitchManager", "Lcom/tencent/mobileqq/vas/tianshu/TianshuWebManagerImpl;", "tianshuWebManager$delegate", "getTianshuWebManager", "()Lcom/tencent/mobileqq/vas/tianshu/TianshuWebManagerImpl;", "tianshuWebManager", "Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "funCallManager$delegate", "getFunCallManager", "()Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "funCallManager", "Lcom/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl;", "specialSoundManager$delegate", "getSpecialSoundManager", "()Lcom/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManagerImpl;", "specialSoundManager", "Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "vasFtManager$delegate", "getVasFtManager", "()Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "vasFtManager", "Lcom/tencent/mobileqq/vas/api/impl/JceImpl;", "jceRequset$delegate", "getJceRequset", "()Lcom/tencent/mobileqq/vas/api/impl/JceImpl;", "jceRequset", "Lcom/tencent/mobileqq/vas/api/impl/PbProtocolImpl;", "pbRequest$delegate", "getPbRequest", "()Lcom/tencent/mobileqq/vas/api/impl/PbProtocolImpl;", "pbRequest", "Lcom/tencent/mobileqq/vip/i;", "gameCardManager$delegate", "getGameCardManager", "()Lcom/tencent/mobileqq/vip/i;", "gameCardManager", "Lcom/tencent/mobileqq/vas/api/IVasSchemeManager;", "vasSchemeManager$delegate", "getVasSchemeManager", "()Lcom/tencent/mobileqq/vas/api/IVasSchemeManager;", "vasSchemeManager", "Lcom/tencent/mobileqq/vas/api/IVasThemeFontApi;", "vasThemeFontApi$delegate", "getVasThemeFontApi", "()Lcom/tencent/mobileqq/vas/api/IVasThemeFontApi;", "vasThemeFontApi", "Lcom/tencent/mobileqq/vas/manager/api/IJsbCallManager;", "jsbCallManager$delegate", "getJsbCallManager", "()Lcom/tencent/mobileqq/vas/manager/api/IJsbCallManager;", "jsbCallManager", "Lcom/tencent/mobileqq/vas/manager/api/IGXHManager;", "gxh$delegate", "getGxh", "()Lcom/tencent/mobileqq/vas/manager/api/IGXHManager;", "gxh", "Lcom/tencent/mobileqq/vas/api/IVasAppIconSwitchManager;", "appIconSwitchManager$delegate", "getAppIconSwitchManager", "()Lcom/tencent/mobileqq/vas/api/IVasAppIconSwitchManager;", "appIconSwitchManager", "Lcom/tencent/mobileqq/vas/api/IVipDataRequestProxy;", "vipDataProxy$delegate", "getVipDataProxy", "()Lcom/tencent/mobileqq/vas/api/IVipDataRequestProxy;", "vipDataProxy", "Lcom/tencent/mobileqq/vas/api/IVasUpdateManager;", "getVasUpdateManager", "()Lcom/tencent/mobileqq/vas/api/IVasUpdateManager;", "vasUpdateManager", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasServiceImpl implements IVasService {

    @NotNull
    private static final ClassLoader CLASS_LOADER;
    private static final String MAIN_PROCESS_NAME;
    private static final String PROCESS_NAME;

    @NotNull
    public static final String TAG = "VasServiceImpl";

    /* renamed from: appIconSwitchManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy appIconSwitchManager;

    /* renamed from: funCallManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy funCallManager;

    /* renamed from: gameCardManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameCardManager;

    /* renamed from: gxh$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gxh;

    /* renamed from: jceRequset$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy jceRequset;

    /* renamed from: jsbCallManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy jsbCallManager;

    /* renamed from: kingCardManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy kingCardManager;

    /* renamed from: pbRequest$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy pbRequest;

    /* renamed from: specialSoundManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy specialSoundManager;

    /* renamed from: themeSwitchManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy themeSwitchManager;

    /* renamed from: tianshuWebManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tianshuWebManager;

    /* renamed from: vasFtManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy vasFtManager;

    /* renamed from: vasHybridRoute$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy vasHybridRoute;

    /* renamed from: vasSchemeManager$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy vasSchemeManager;

    /* renamed from: vasThemeFontApi$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy vasThemeFontApi;

    /* renamed from: vipDataProxy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy vipDataProxy;

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        MAIN_PROCESS_NAME = BaseApplication.getContext().getPackageName();
        PROCESS_NAME = MobileQQ.processName;
        ClassLoader classLoader = companion.getClass().getClassLoader();
        Intrinsics.checkNotNull(classLoader);
        CLASS_LOADER = classLoader;
    }

    public VasServiceImpl() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        Lazy lazy16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IKingCardManager>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$kingCardManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IKingCardManager invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new r13.a());
                return (IKingCardManager) dynamicCall;
            }
        });
        this.kingCardManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IVasHybridRoute>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$vasHybridRoute$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IVasHybridRoute invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new VasHybridRouteImpl());
                return (IVasHybridRoute) dynamicCall;
            }
        });
        this.vasHybridRoute = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ThemeSwitchManagerImpl>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$themeSwitchManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ThemeSwitchManagerImpl invoke() {
                return new ThemeSwitchManagerImpl();
            }
        });
        this.themeSwitchManager = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TianshuWebManagerImpl>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$tianshuWebManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TianshuWebManagerImpl invoke() {
                return new TianshuWebManagerImpl();
            }
        });
        this.tianshuWebManager = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<IVipFunCallManager>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$funCallManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IVipFunCallManager invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new com.tencent.mobileqq.vipav.b());
                return (IVipFunCallManager) dynamicCall;
            }
        });
        this.funCallManager = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<QvipSpecialSoundManagerImpl>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$specialSoundManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QvipSpecialSoundManagerImpl invoke() {
                return new QvipSpecialSoundManagerImpl();
            }
        });
        this.specialSoundManager = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<IVasFTManager>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$vasFtManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IVasFTManager invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new l33.b());
                return (IVasFTManager) dynamicCall;
            }
        });
        this.vasFtManager = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<JceImpl>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$jceRequset$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JceImpl invoke() {
                return new JceImpl();
            }
        });
        this.jceRequset = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<PbProtocolImpl>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$pbRequest$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PbProtocolImpl invoke() {
                return new PbProtocolImpl();
            }
        });
        this.pbRequest = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.vip.i>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$gameCardManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.vip.i invoke() {
                return new com.tencent.mobileqq.vip.i();
            }
        });
        this.gameCardManager = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<IVasSchemeManager>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$vasSchemeManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IVasSchemeManager invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new ap());
                return (IVasSchemeManager) dynamicCall;
            }
        });
        this.vasSchemeManager = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<IVasThemeFontApi>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$vasThemeFontApi$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IVasThemeFontApi invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new as());
                return (IVasThemeFontApi) dynamicCall;
            }
        });
        this.vasThemeFontApi = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<IJsbCallManager>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$jsbCallManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IJsbCallManager invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new JsbCallImpl());
                return (IJsbCallManager) dynamicCall;
            }
        });
        this.jsbCallManager = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<IGXHManager>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$gxh$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGXHManager invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new GXHManagerImpl());
                return (IGXHManager) dynamicCall;
            }
        });
        this.gxh = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<IVasAppIconSwitchManager>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$appIconSwitchManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IVasAppIconSwitchManager invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new AppIconSwitchManager());
                return (IVasAppIconSwitchManager) dynamicCall;
            }
        });
        this.appIconSwitchManager = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<IVipDataRequestProxy>() { // from class: com.tencent.mobileqq.vas.api.impl.VasServiceImpl$vipDataProxy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IVipDataRequestProxy invoke() {
                IVasManager dynamicCall;
                dynamicCall = VasServiceImpl.this.dynamicCall(new av());
                return (IVipDataRequestProxy) dynamicCall;
            }
        });
        this.vipDataProxy = lazy16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends IVasManager> T dynamicCall(Object impl) {
        Object proxy = RemoteProxy.getProxy(impl.getClass());
        Intrinsics.checkNotNull(proxy, "null cannot be cast to non-null type T of com.tencent.mobileqq.vas.api.impl.VasServiceImpl.dynamicCall");
        return (T) proxy;
    }

    private final boolean isInMainProcess() {
        return Intrinsics.areEqual(PROCESS_NAME, MAIN_PROCESS_NAME);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IVasAppIconSwitchManager getAppIconSwitchManager() {
        return (IVasAppIconSwitchManager) this.appIconSwitchManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IVipFunCallManager getFunCallManager() {
        return (IVipFunCallManager) this.funCallManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IGXHManager getGxh() {
        return (IGXHManager) this.gxh.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IJsbCallManager getJsbCallManager() {
        return (IJsbCallManager) this.jsbCallManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IKingCardManager getKingCardManager() {
        return (IKingCardManager) this.kingCardManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IVasFTManager getVasFtManager() {
        return (IVasFTManager) this.vasFtManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IVasHybridRoute getVasHybridRoute() {
        return (IVasHybridRoute) this.vasHybridRoute.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IVasSchemeManager getVasSchemeManager() {
        return (IVasSchemeManager) this.vasSchemeManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IVasThemeFontApi getVasThemeFontApi() {
        return (IVasThemeFontApi) this.vasThemeFontApi.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IVasUpdateManager getVasUpdateManager() {
        return (IVasUpdateManager) dynamicCall(new at());
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public IVipDataRequestProxy getVipDataProxy() {
        return (IVipDataRequestProxy) this.vipDataProxy.getValue();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        if (isInMainProcess()) {
            com.tencent.mobileqq.vas.util.c.f311229d.a();
        }
        QLog.i(TAG, 1, "onCreate on " + PROCESS_NAME);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, "onDestroy on " + PROCESS_NAME);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public com.tencent.mobileqq.vip.i getGameCardManager() {
        return (com.tencent.mobileqq.vip.i) this.gameCardManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public JceImpl getJceRequset() {
        return (JceImpl) this.jceRequset.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public PbProtocolImpl getPbRequest() {
        return (PbProtocolImpl) this.pbRequest.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public QvipSpecialSoundManagerImpl getSpecialSoundManager() {
        return (QvipSpecialSoundManagerImpl) this.specialSoundManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public ThemeSwitchManagerImpl getThemeSwitchManager() {
        return (ThemeSwitchManagerImpl) this.themeSwitchManager.getValue();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasService
    @NotNull
    public TianshuWebManagerImpl getTianshuWebManager() {
        return (TianshuWebManagerImpl) this.tianshuWebManager.getValue();
    }
}
