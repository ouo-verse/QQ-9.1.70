package com.tencent.mobileqq.dt.tip;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.d;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IO3NotifyBannerApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J7\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f\"\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/dt/tip/O3AIONotifyBannerTipsBar;", "Lcom/tencent/mobileqq/aio/notification/d;", "", "j", "Lcom/tencent/mobileqq/dt/tip/b;", "data", "l", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "f", "i", "g", "Lcom/tencent/mobileqq/aio/notification/c;", "notificationManager", "", "eventType", "", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/notification/c;I[Ljava/lang/Object;)V", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", h.F, "", "d", "Z", "isObserve", "", "e", "Ljava/lang/String;", "uid", "currentToken", "Lcom/tencent/mobileqq/aio/notification/c;", "<init>", "()V", "a", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class O3AIONotifyBannerTipsBar implements com.tencent.mobileqq.aio.notification.d {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isObserve;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentToken;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.notification.c notificationManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/dt/tip/O3AIONotifyBannerTipsBar$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.dt.tip.O3AIONotifyBannerTipsBar$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25095);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public O3AIONotifyBannerTipsBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uid = "";
            this.currentToken = "";
        }
    }

    private final IAIONotificationUIModel f(final b data) {
        final AIOParam aIOParam;
        String str;
        int i3;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
        if (cVar != null && (a16 = cVar.a()) != null) {
            aIOParam = a16.g();
        } else {
            aIOParam = null;
        }
        IO3NotifyBannerApi iO3NotifyBannerApi = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
        String str2 = data.f203886b;
        if (aIOParam == null || (str = Long.valueOf(su3.c.a(aIOParam)).toString()) == null) {
            str = "";
        }
        if (aIOParam != null && (r16 = aIOParam.r()) != null && (c16 = r16.c()) != null) {
            i3 = c16.e();
        } else {
            i3 = 0;
        }
        iO3NotifyBannerApi.onNotifyBannerCreate(str2, str, i3);
        AIONotificationBusiId aIONotificationBusiId = AIONotificationBusiId.FRAUD;
        String str3 = data.f203885a;
        Intrinsics.checkNotNullExpressionValue(str3, "data.text");
        IAIONotificationUIModel.ActionIcon actionIcon = IAIONotificationUIModel.ActionIcon.CLOSE;
        String str4 = data.f203887c;
        Intrinsics.checkNotNullExpressionValue(str4, "data.btnText");
        return new IAIONotificationUIModel.b(aIONotificationBusiId, str3, actionIcon, str4, R.color.qui_common_text_link, new Function2<IAIONotificationUIModel, Integer, Unit>(aIOParam, this) { // from class: com.tencent.mobileqq.dt.tip.O3AIONotifyBannerTipsBar$createUIModel$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AIOParam $aioParam;
            final /* synthetic */ O3AIONotifyBannerTipsBar this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$aioParam = aIOParam;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, b.this, aIOParam, this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
                invoke(iAIONotificationUIModel, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull IAIONotificationUIModel iAIONotificationUIModel, int i16) {
                AIOSession r17;
                AIOContact c17;
                String l3;
                AIOSession r18;
                AIOContact c18;
                String l16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) iAIONotificationUIModel, i16);
                    return;
                }
                Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<anonymous parameter 0>");
                int i17 = 0;
                String str5 = "";
                if (i16 != 1) {
                    if (i16 == 2) {
                        IO3NotifyBannerApi iO3NotifyBannerApi2 = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
                        String str6 = b.this.f203886b;
                        AIOParam aIOParam2 = this.$aioParam;
                        if (aIOParam2 != null && (l16 = Long.valueOf(su3.c.a(aIOParam2)).toString()) != null) {
                            str5 = l16;
                        }
                        AIOParam aIOParam3 = this.$aioParam;
                        if (aIOParam3 != null && (r18 = aIOParam3.r()) != null && (c18 = r18.c()) != null) {
                            i17 = c18.e();
                        }
                        iO3NotifyBannerApi2.onNotifyBannerClick(str6, str5, i17, 3);
                        this.this$0.g();
                        return;
                    }
                    if (i16 != 3) {
                        return;
                    }
                }
                IO3NotifyBannerApi iO3NotifyBannerApi3 = (IO3NotifyBannerApi) QRoute.api(IO3NotifyBannerApi.class);
                String str7 = b.this.f203886b;
                AIOParam aIOParam4 = this.$aioParam;
                if (aIOParam4 != null && (l3 = Long.valueOf(su3.c.a(aIOParam4)).toString()) != null) {
                    str5 = l3;
                }
                AIOParam aIOParam5 = this.$aioParam;
                if (aIOParam5 != null && (r17 = aIOParam5.r()) != null && (c17 = r17.c()) != null) {
                    i17 = c17.e();
                }
                iO3NotifyBannerApi3.onNotifyBannerClick(str7, str5, i17, 1);
                this.this$0.i(b.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
        if (cVar != null) {
            cVar.g(this.currentToken);
        }
        this.currentToken = "";
        O3AIONotifyBannerManager.f203873a.i(this.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(b data) {
        com.tencent.aio.api.runtime.a a16;
        Fragment c16;
        Context context;
        boolean startsWith$default;
        BaseQQAppInterface baseQQAppInterface;
        Activity activity;
        String str;
        com.tencent.aio.api.runtime.a a17;
        AIOParam g16;
        AIOSession r16;
        AIOContact c17;
        com.tencent.aio.api.runtime.a a18;
        AIOParam g17;
        AIOSession r17;
        AIOContact c18;
        g();
        String url = data.f203886b;
        if (TextUtils.isEmpty(url)) {
            QLog.e("O3AIONotifyBannerTipsBar", 1, "O3NotifyBanner url is empty");
            return;
        }
        com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
        if (cVar != null && (a16 = cVar.a()) != null && (c16 = a16.c()) != null && (context = c16.getContext()) != null) {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            int i3 = 0;
            ax axVar = null;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "mqqapi://o3/report", false, 2, null);
            if (startsWith$default) {
                com.tencent.mobileqq.aio.notification.c cVar2 = this.notificationManager;
                if (cVar2 != null && (a18 = cVar2.a()) != null && (g17 = a18.g()) != null && (r17 = g17.r()) != null && (c18 = r17.c()) != null) {
                    str = c18.j();
                } else {
                    str = null;
                }
                com.tencent.mobileqq.aio.notification.c cVar3 = this.notificationManager;
                if (cVar3 != null && (a17 = cVar3.a()) != null && (g16 = a17.g()) != null && (r16 = g16.r()) != null && (c17 = r16.c()) != null) {
                    i3 = c17.e();
                }
                url = url + "&uid=" + str + "&chat_type=" + i3 + "&gray_tip_time=" + (System.currentTimeMillis() / 1000) + "&src=2";
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof BaseQQAppInterface) {
                baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
            } else {
                baseQQAppInterface = null;
            }
            if (baseQQAppInterface == null) {
                return;
            }
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                axVar = bi.c(baseQQAppInterface, activity, url);
            }
            if (axVar != null) {
                axVar.b();
            } else {
                QRoute.createNavigator(context, RouterConstants.UI_ROUTE_BROWSER).withString("url", url).request();
            }
        }
    }

    private final void j() {
        String str;
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        if (this.isObserve) {
            return;
        }
        this.isObserve = true;
        com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
        if (cVar == null || (a16 = cVar.a()) == null || (g16 = a16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        this.uid = str;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.dt.tip.d
            @Override // java.lang.Runnable
            public final void run() {
                O3AIONotifyBannerTipsBar.k(O3AIONotifyBannerTipsBar.this);
            }
        }, 16, null, false);
        O3AIONotifyBannerManager.f203873a.c(this.uid, new Function1<b, Unit>() { // from class: com.tencent.mobileqq.dt.tip.O3AIONotifyBannerTipsBar$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) O3AIONotifyBannerTipsBar.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull b data) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                } else {
                    Intrinsics.checkNotNullParameter(data, "data");
                    O3AIONotifyBannerTipsBar.this.l(data);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(O3AIONotifyBannerTipsBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b e16 = O3AIONotifyBannerManager.f203873a.e(this$0.uid);
        if (e16 != null) {
            this$0.l(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(b data) {
        boolean z16;
        String str;
        IAIONotificationUIModel f16 = f(data);
        if (this.currentToken.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.aio.notification.c cVar = this.notificationManager;
            if (cVar != null) {
                cVar.j(this.currentToken, f16);
                return;
            }
            return;
        }
        com.tencent.mobileqq.aio.notification.c cVar2 = this.notificationManager;
        if (cVar2 == null || (str = cVar2.c(f16)) == null) {
            str = "";
        }
        this.currentToken = str;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NotNull
    public List<AIONotificationBusiId> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NotNull com.tencent.mobileqq.aio.notification.c notificationManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, notificationManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (notificationManager.a().g().r().c().e() != 1) {
            return;
        }
        d.Companion companion = com.tencent.mobileqq.aio.notification.d.INSTANCE;
        if (eventType == companion.e()) {
            this.notificationManager = notificationManager;
            j();
        } else if (eventType == companion.c()) {
            O3AIONotifyBannerManager.f203873a.j(this.uid);
        }
    }
}
