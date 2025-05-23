package com.tencent.mobileqq.aio.animation.business;

import android.os.Handler;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.api.impl.AioAnimationApiImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J`\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0010j\b\u0012\u0004\u0012\u00020\f`\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/DragonKingEggsPlayer;", "Lcom/tencent/mobileqq/aio/animation/egg/c;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/os/Handler;", "uiHandler", "Lcom/tencent/mobileqq/aio/animation/data/b;", "message", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "animContainer", "", "delayTime", "Lcom/tencent/mobileqq/aio/animation/config/a;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "isNewMsg", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "rulesMatched", "index", "", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/animation/data/d;", "sessionInfo", "b", "getBizType", "()I", "bizType", "c", "playScope", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class DragonKingEggsPlayer implements com.tencent.mobileqq.aio.animation.egg.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/DragonKingEggsPlayer$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.business.DragonKingEggsPlayer$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29596);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DragonKingEggsPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public void a(@NotNull BaseQQAppInterface app, @NotNull Handler uiHandler, @NotNull com.tencent.mobileqq.aio.animation.data.b message, @NotNull AIOAnimationContainer animContainer, int delayTime, @NotNull com.tencent.mobileqq.aio.animation.config.a rule, boolean isNewMsg, @NotNull ArrayList<com.tencent.mobileqq.aio.animation.config.a> rulesMatched, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, app, uiHandler, message, animContainer, Integer.valueOf(delayTime), rule, Boolean.valueOf(isNewMsg), rulesMatched, Integer.valueOf(index));
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(animContainer, "animContainer");
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(rulesMatched, "rulesMatched");
        String peerUid = message.getPeerUid();
        u71.a aioInfoDelegate = AioAnimationApiImpl.INSTANCE.a().getAioInfoDelegate();
        if (aioInfoDelegate == null) {
            QLog.i("DragonKingEggsPlayer", 1, "[play] aio info delegate is null");
            return;
        }
        if (!aioInfoDelegate.c()) {
            QLog.i("DragonKingEggsPlayer", 1, "[play] dragon king animation is disabled");
        } else if (aioInfoDelegate.a(peerUid)) {
            QLog.i("DragonKingEggsPlayer", 1, "[play] dragon king animation disabled for anonymous troop");
        } else {
            aioInfoDelegate.b(String.valueOf(message.getSenderUin()), peerUid, new DragonKingEggsPlayer$play$1(rule, app, uiHandler, delayTime, animContainer));
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public void b(@NotNull com.tencent.mobileqq.aio.animation.data.b message, @NotNull BaseQQAppInterface app, @NotNull com.tencent.mobileqq.aio.animation.data.d sessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, message, app, sessionInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public int getBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
