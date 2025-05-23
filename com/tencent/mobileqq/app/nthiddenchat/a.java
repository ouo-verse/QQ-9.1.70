package com.tencent.mobileqq.app.nthiddenchat;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/app/nthiddenchat/a;", "Lcom/tencent/aio/main/businesshelper/h;", "Ljv3/a;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "e", "Lcom/tencent/aio/api/runtime/a;", "aioContext", h.F, "", "g", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "c", "", "a", "b", "state", "onMoveToState", "onBackEvent", "d", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Landroid/app/Activity;", "Landroid/app/Activity;", "mActivity", "Lcom/tencent/mobileqq/app/QQAppInterface;", "f", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "Ljava/lang/String;", "peerUin", "<init>", "()V", "i", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements com.tencent.aio.main.businesshelper.h, jv3.a, com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String f196417m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQAppInterface mApp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String peerUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/app/nthiddenchat/a$a;", "", "", "BACK_FOR_HIDDEN_CHAT", "Ljava/lang/String;", "FROM_NT_HIDDEN_CHAT", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.nthiddenchat.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
            f196417m = "FromNtHiddenChat";
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.peerUin = "";
        }
    }

    private final boolean e() {
        b bVar = b.f196422a;
        String str = this.peerUin;
        com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar3 = null;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar2 = null;
        }
        String g16 = g(bVar2.a());
        com.tencent.aio.main.businesshelper.b bVar4 = this.mHelperParam;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar4 = null;
        }
        boolean h16 = h(bVar4.a());
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            qQAppInterface = null;
        }
        boolean i3 = bVar.i(str, g16, h16, qQAppInterface);
        String str2 = this.peerUin;
        com.tencent.aio.main.businesshelper.b bVar5 = this.mHelperParam;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar3 = bVar5;
        }
        QLog.d("NTHiddenChatHelper", 1, " changeBackStack uin: " + str2 + ", isC2C: " + h(bVar3.a()) + " isHidden: " + i3);
        if (i3) {
            Activity activity = this.mActivity;
            if (activity != null) {
                Intent intent = activity.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                if (intent.getIntExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0) == 2) {
                    intent.putExtra("FromType", 2);
                }
                intent.putExtra("back_for_hidden_chat", true);
                intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
                intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, R.anim.f154445lb);
                intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, R.anim.f154449lf);
                intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, R.anim.f154435l2);
                intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, R.anim.f154436l4);
                bVar.c(activity, NTHiddenChatFragment.class);
                intent.removeExtra("back_for_hidden_chat");
            }
            return false;
        }
        Activity activity2 = this.mActivity;
        if (activity2 != null) {
            Intent intent2 = activity2.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "activity.intent");
            if (intent2.getBooleanExtra(f196417m, false)) {
                QLog.d("NTHiddenChatHelper", 1, "go to SplashActivity");
                Intent intent3 = new Intent();
                intent3.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                intent3.putExtra(SplashActivity.FRAGMENT_ID, 1);
                intent3.addFlags(268435456);
                intent3.addFlags(67108864);
                RouteUtils.startActivity(activity2, intent3, RouterConstants.UI_ROUTER_SPLASH);
                activity2.finish();
                return true;
            }
        }
        return false;
    }

    private final String g(com.tencent.aio.api.runtime.a aioContext) {
        return aioContext.g().r().c().j();
    }

    private final boolean h(com.tencent.aio.api.runtime.a aioContext) {
        if (aioContext.g().r().c().e() == 1) {
            return true;
        }
        return false;
    }

    @Override // jv3.a
    @Nullable
    public CharSequence a(@Nullable com.tencent.aio.api.runtime.a aioContext, @Nullable RecentContactInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aioContext, (Object) info);
        }
        return null;
    }

    @Override // jv3.a
    @Nullable
    public CharSequence b(@Nullable com.tencent.aio.api.runtime.a aioContext, @Nullable RecentContactInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CharSequence) iPatchRedirector.redirect((short) 9, (Object) this, (Object) aioContext, (Object) info);
        }
        return null;
    }

    @Override // jv3.a
    public boolean c(@Nullable com.tencent.aio.api.runtime.a aioContext, @Nullable RecentContactInfo info) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) aioContext, (Object) info)).booleanValue();
        }
        boolean z18 = false;
        if (info == null) {
            QLog.d("NTHiddenChatHelper", 1, "info is null");
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (info.chatType == 1) {
            String valueOf = String.valueOf(info.peerUin);
            if (valueOf != null && valueOf.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17 && b.h(String.valueOf(info.peerUin), 0, qQAppInterface)) {
                QLog.d("NTHiddenChatHelper", 1, "This C2C is hidden");
                return false;
            }
        }
        if (info.chatType == 2) {
            String valueOf2 = String.valueOf(info.peerUin);
            if (valueOf2 != null && valueOf2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && b.h(String.valueOf(info.peerUin), 1, qQAppInterface)) {
                QLog.d("NTHiddenChatHelper", 1, "This Troop is hidden");
                return false;
            }
        }
        if (aioContext != null) {
            String tempPeerUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(g(aioContext));
            b bVar = b.f196422a;
            Intrinsics.checkNotNullExpressionValue(tempPeerUin, "tempPeerUin");
            z18 = bVar.i(tempPeerUin, g(aioContext), h(aioContext), qQAppInterface);
        }
        QLog.d("NTHiddenChatHelper", 1, "isHidden: " + z18);
        return !z18;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.J0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "NTHiddenChatHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{4};
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return e();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.mHelperParam = param;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        this.mApp = (QQAppInterface) peekAppRuntime;
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        this.mActivity = bVar.a().c().getActivity();
        com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar3 = null;
        }
        bVar3.a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        com.tencent.aio.main.businesshelper.b bVar4 = this.mHelperParam;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar4 = null;
        }
        String uinFromUid = iRelationNTUinAndUidApi.getUinFromUid(g(bVar4.a()));
        Intrinsics.checkNotNullExpressionValue(uinFromUid, "api(IRelationNTUinAndUid\u2026mHelperParam.aioContext))");
        this.peerUin = uinFromUid;
        com.tencent.aio.main.businesshelper.b bVar5 = this.mHelperParam;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
        } else {
            bVar2 = bVar5;
        }
        QLog.d("NTHiddenChatHelper", 1, "onCreate  uin: " + uinFromUid + ", uid: " + g(bVar2.a()));
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.main.businesshelper.b bVar = this.mHelperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        bVar.a().b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, state);
            return;
        }
        if (state == 4) {
            b bVar = b.f196422a;
            String str = this.peerUin;
            com.tencent.aio.main.businesshelper.b bVar2 = this.mHelperParam;
            Integer num = null;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                bVar2 = null;
            }
            String g16 = g(bVar2.a());
            com.tencent.aio.main.businesshelper.b bVar3 = this.mHelperParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
                bVar3 = null;
            }
            boolean h16 = h(bVar3.a());
            QQAppInterface qQAppInterface = this.mApp;
            if (qQAppInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                qQAppInterface = null;
            }
            if (bVar.i(str, g16, h16, qQAppInterface)) {
                Activity activity = this.mActivity;
                if (activity != null && (intent = activity.getIntent()) != null) {
                    num = Integer.valueOf(intent.getIntExtra("hidden_aio_msg_source", 999));
                }
                if (num != null) {
                    num.intValue();
                    ReportController.o(null, "dc00898", "", "", "0X800A34E", "0X800A34E", num.intValue(), 0, "0", "0", "", "");
                }
            }
        }
    }
}
