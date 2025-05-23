package com.tencent.mobileqq.aio.animation.business;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.config.e;
import com.tencent.mobileqq.aio.animation.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J`\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0010j\b\u0012\u0004\u0012\u00020\f`\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/e;", "Lcom/tencent/mobileqq/aio/animation/egg/c;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/os/Handler;", "uiHandler", "Lcom/tencent/mobileqq/aio/animation/data/b;", "message", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "animContainer", "", "delayTime", "Lcom/tencent/mobileqq/aio/animation/config/a;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "isNewMsg", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "rulesMatched", "index", "", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/animation/data/d;", "sessionInfo", "b", "getBizType", "()I", "bizType", "c", "playScope", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e implements com.tencent.mobileqq.aio.animation.egg.c {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BaseQQAppInterface app, AIOAnimationContainer animContainer, Drawable drawable, com.tencent.mobileqq.aio.animation.config.a rule, com.tencent.mobileqq.aio.animation.data.b message) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(animContainer, "$animContainer");
        Intrinsics.checkNotNullParameter(rule, "$rule");
        Intrinsics.checkNotNullParameter(message, "$message");
        q.INSTANCE.a().U(app, animContainer, drawable, rule, message);
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public void a(@NotNull final BaseQQAppInterface app, @NotNull Handler uiHandler, @NotNull final com.tencent.mobileqq.aio.animation.data.b message, @NotNull final AIOAnimationContainer animContainer, int delayTime, @NotNull final com.tencent.mobileqq.aio.animation.config.a rule, boolean isNewMsg, @NotNull ArrayList<com.tencent.mobileqq.aio.animation.config.a> rulesMatched, int index) {
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
        ArrayList<com.tencent.mobileqq.aio.animation.config.e> i3 = rule.i();
        if (i3 != null) {
            for (com.tencent.mobileqq.aio.animation.config.e eVar : i3) {
                e.Companion companion = com.tencent.mobileqq.aio.animation.config.e.INSTANCE;
                MobileQQ application = app.getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "app.application");
                final Drawable c16 = companion.c(application, eVar);
                if (rule.r() == 8) {
                    uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.business.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.e(BaseQQAppInterface.this, animContainer, c16, rule, message);
                        }
                    });
                }
            }
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
        return 3;
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public int getBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 8;
    }

    @Override // com.tencent.mobileqq.aio.animation.egg.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
