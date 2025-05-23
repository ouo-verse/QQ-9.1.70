package com.tencent.mobileqq.springhb.api.impl;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.IInteractiveApi;
import com.tencent.mobileqq.springhb.interactive.api.b;
import com.tencent.mobileqq.springhb.interactive.helper.GuildInteractiveAnimationHelper;
import com.tencent.mobileqq.springhb.interactive.helper.InteractiveAnimationHelper;
import com.tencent.mobileqq.springhb.interactive.providers.guild.GuildInteractiveHelperProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.devices.api.IDevicesApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/springhb/api/impl/InteractiveApiImpl;", "Lcom/tencent/mobileqq/springhb/api/IInteractiveApi;", "Lcom/tencent/aio/api/help/a;", "Lcom/tencent/mobileqq/springhb/interactive/api/b;", "createProvider", "", "isPad", "param", "Lkotlin/Pair;", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "createInteractiveAnimationHelper", "<init>", "()V", "Companion", "a", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class InteractiveApiImpl implements IInteractiveApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final a Companion;

    @Deprecated
    @NotNull
    public static final String TAG = "InteractiveApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/api/impl/InteractiveApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            Companion = new a(null);
        }
    }

    public InteractiveApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final b createProvider(com.tencent.aio.api.help.a aVar) {
        int e16 = aVar.b().c().e();
        if (e16 == 1) {
            return new com.tencent.mobileqq.springhb.interactive.providers.c2c_group.a(aVar);
        }
        if (e16 == 2) {
            return new com.tencent.mobileqq.springhb.interactive.providers.c2c_group.b(aVar);
        }
        if (e16 == 4) {
            return new GuildInteractiveHelperProvider(aVar);
        }
        return null;
    }

    private final boolean isPad() {
        return ((IDevicesApi) QRoute.api(IDevicesApi.class)).isPadDevice();
    }

    @Override // com.tencent.mobileqq.springhb.api.IInteractiveApi
    @Nullable
    public Pair<String, Function0<h>> createInteractiveAnimationHelper(@NotNull com.tencent.aio.api.help.a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (isPad()) {
            QLog.d(TAG, 1, "isPad");
            InteractiveAnimationHelper.INSTANCE.a(null, "7");
            return null;
        }
        if (!com.tencent.mobileqq.springhb.interactive.config.a.f289231a.b()) {
            QLog.d(TAG, 1, "degradeSwitch close!!");
            InteractiveAnimationHelper.INSTANCE.a(null, "3");
            return null;
        }
        final b createProvider = createProvider(param);
        if (createProvider == null || !createProvider.g()) {
            return null;
        }
        if (createProvider instanceof GuildInteractiveHelperProvider) {
            return TuplesKt.to("InteractiveAnimationHelper", new Function0<GuildInteractiveAnimationHelper>() { // from class: com.tencent.mobileqq.springhb.api.impl.InteractiveApiImpl$createInteractiveAnimationHelper$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final GuildInteractiveAnimationHelper invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new GuildInteractiveAnimationHelper(b.this) : (GuildInteractiveAnimationHelper) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
        return TuplesKt.to("InteractiveAnimationHelper", new Function0<InteractiveAnimationHelper>() { // from class: com.tencent.mobileqq.springhb.api.impl.InteractiveApiImpl$createInteractiveAnimationHelper$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final InteractiveAnimationHelper invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new InteractiveAnimationHelper(b.this) : (InteractiveAnimationHelper) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }
}
