package com.tencent.mobileqq.qqlive.sail.ui.gift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/QQLiveGiftVerifyPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "", "U9", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "", "e", "Z", "enableGiftByConfig", "Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "f", "Lkotlin/Lazy;", "ha", "()Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "giftViewModel", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "ia", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "<init>", "()V", tl.h.F, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveGiftVerifyPart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean enableGiftByConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy giftViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/QQLiveGiftVerifyPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftVerifyPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52083);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveGiftVerifyPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.enableGiftByConfig = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GiftViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveGiftVerifyPart$giftViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveGiftVerifyPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GiftViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GiftViewModel) QQLiveGiftVerifyPart.this.getViewModel(GiftViewModel.class) : (GiftViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.giftViewModel = lazy;
    }

    private final GiftViewModel ha() {
        Object value = this.giftViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-giftViewModel>(...)");
        return (GiftViewModel) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.room.e ia() {
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) F9;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        boolean z16;
        boolean z17;
        AudienceRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        uq4.c cVar = busConfigHelper.j().get(Long.valueOf(H9()));
        if (cVar != null) {
            boolean g16 = busConfigHelper.g(5, cVar);
            boolean z18 = true;
            this.enableGiftByConfig = !g16;
            if (C9() == M9()) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.qqlive.sail.room.e ia5 = ia();
            if (ia5 != null && (b16 = ia5.b()) != null) {
                z17 = b16.y();
            } else {
                z17 = true;
            }
            AegisLogger.INSTANCE.i("Gift|QQLiveGiftVerifyPart", "onBusConfigUpdate", "enableGiftByConfig=" + this.enableGiftByConfig + ", isSelfLiving=" + z16 + ", isQQPromoted=" + z17);
            GiftViewModel ha5 = ha();
            if (!this.enableGiftByConfig || z16 || !z17) {
                z18 = false;
            }
            ha5.c2(z18);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.U9();
        if (F9() != null) {
            ha().d2(H9(), J9());
            com.tencent.timi.game.initer.impl.b.f377190a.g(QQLiveSDKConfigHelper.getSceneId(), 1, "", String.valueOf(C9()), true);
            pk4.b.H(J9());
        }
    }
}
