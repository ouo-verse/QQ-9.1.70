package com.tencent.qqnt.chats.main.lightbusiness.reveal;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.api.IChatsRevealApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.RevealDoufuInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chats/main/lightbusiness/reveal/LIAWorldRingRevealProcessor;", "Lcom/tencent/qqnt/chats/inject/avatar/a;", "Lnw3/c;", "view", "", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/biz/bean/c;", "revealItem", "c", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerImageView;", "imageView", "d", "Lnw3/a;", "a", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class LIAWorldRingRevealProcessor extends com.tencent.qqnt.chats.inject.avatar.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/main/lightbusiness/reveal/LIAWorldRingRevealProcessor$a;", "", "", "ANIM_ROTATE_REPEAT_TIMES", "I", "", "ANIM_ROTATE_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.lightbusiness.reveal.LIAWorldRingRevealProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LIAWorldRingRevealProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(nw3.c view) {
        view.a("LIAWorldRingRevealProcessor", null);
        if (!view.g()) {
            return;
        }
        ImageView b16 = view.b();
        if (b16 != null) {
            b16.setImageResource(0);
        }
        if (b16 != null) {
            b16.setBackgroundResource(0);
        }
        if (b16 != null) {
            b16.setVisibility(4);
        }
    }

    private final void c(final g item, nw3.c view, final com.tencent.qqnt.chats.biz.bean.c revealItem) {
        ImageView b16;
        if (revealItem.a() != 12 || (b16 = view.b()) == null || !(b16 instanceof QUIShimmerImageView)) {
            return;
        }
        view.a("LIAWorldRingRevealProcessor", new Function1<View, Unit>(item) { // from class: com.tencent.qqnt.chats.main.lightbusiness.reveal.LIAWorldRingRevealProcessor$handleReveal$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ g $item;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$item = item;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.chats.biz.bean.c.this, (Object) item);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                if (QLog.isColorLevel()) {
                    QLog.d("LIAWorldRingRevealProcessor", 2, "OnClick: " + com.tencent.qqnt.chats.biz.bean.c.this);
                }
                com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(this.$item.o());
                if (chatsListReport != null) {
                    g gVar = this.$item;
                    chatsListReport.k(gVar, String.valueOf(gVar.l()), com.tencent.qqnt.chats.biz.bean.c.this.d());
                }
                ((IChatsRevealApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IChatsRevealApi.class)).handleClick(com.tencent.qqnt.chats.biz.bean.c.this.b(), this.$item.k());
            }
        });
        b16.setImageDrawable(new com.tencent.qqnt.chats.main.ui.reveal.a());
        b16.setVisibility(0);
        if (revealItem.c()) {
            d((QUIShimmerImageView) b16);
            IKernelLiteBusinessService liteBusinessService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getLiteBusinessService();
            if (liteBusinessService != null) {
                liteBusinessService.recentRevealExposure(new RevealDoufuInfo(item.k(), revealItem.a(), revealItem.d()));
            }
        }
        com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(item.o());
        if (chatsListReport != null) {
            chatsListReport.o(item, revealItem);
        }
    }

    private final void d(QUIShimmerImageView imageView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.ROTATION, 0.0f, 360.0f);
        ofFloat.setDuration(2500L);
        ofFloat.setRepeatCount(0);
        ofFloat.start();
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.a
    public void a(@NotNull g item, @NotNull nw3.a view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).isRingRevealEnable() || !(view instanceof nw3.c)) {
            return;
        }
        boolean z16 = true;
        if (item.y().b() <= 0 && item.y().i() <= 0 && item.y().f() <= 0) {
            com.tencent.qqnt.chats.biz.bean.c cVar = (com.tencent.qqnt.chats.biz.bean.c) item.h(LiteBusinessType.KLIGHTRINGREVEAL);
            if (cVar != null) {
                if (cVar.b().length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    c(item, (nw3.c) view, cVar);
                    return;
                }
            }
            b((nw3.c) view);
            return;
        }
        QLog.d("LIAWorldRingRevealProcessor", 1, "has Vas logic, exclude reveal ring");
    }
}
