package com.tencent.qqnt.aio.msgerror;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.data.f;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/msgerror/GroupMemberStrangerMsgSendErrorCallback;", "Lcom/tencent/qqnt/aio/msgerror/c;", "", "peerUid", "msg", "", "b", "Lcom/tencent/aio/api/runtime/a;", "ctx", "Lcom/tencent/qqnt/msg/data/f;", "msgSendError", "a", "Lcom/tencent/qqnt/aio/interceptor/e;", "Lkotlin/Lazy;", "getMSub", "()Lcom/tencent/qqnt/aio/interceptor/e;", "mSub", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class GroupMemberStrangerMsgSendErrorCallback implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mSub;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/msgerror/GroupMemberStrangerMsgSendErrorCallback$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.msgerror.GroupMemberStrangerMsgSendErrorCallback$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33748);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GroupMemberStrangerMsgSendErrorCallback() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(GroupMemberStrangerMsgSendErrorCallback$mSub$2.INSTANCE);
            this.mSub = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(String peerUid, String msg2) {
        boolean z16;
        if (!TextUtils.isEmpty(peerUid)) {
            if (msg2 != null && msg2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.i(new LocalGrayTip.LocalGrayTipBuilder(peerUid, 100, 2022L, 0, false, false, null, 120, null), msg2, 0, 2, null).m();
                QRouteApi api = QRoute.api(INtGrayTipApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
                INtGrayTipApi.a.a((INtGrayTipApi) api, peekAppRuntime, m3, null, 4, null);
                return;
            }
        }
        QLog.w("GroupMemberMsgSendErrorCallback", 1, "[addSendErrorGrayTip] failed. invalid params. msg:" + msg2);
    }

    @Override // com.tencent.qqnt.aio.msgerror.c
    public void a(@NotNull com.tencent.aio.api.runtime.a ctx, @NotNull f msgSendError) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ctx, (Object) msgSendError);
            return;
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(msgSendError, "msgSendError");
        FragmentActivity activity = ctx.c().getActivity();
        if (activity != null) {
            String b16 = msgSendError.b();
            if (TextUtils.isEmpty(b16)) {
                b16 = activity.getString(R.string.f1384409k);
            }
            String j3 = ctx.g().r().c().j();
            int a16 = msgSendError.a();
            if (a16 != 120) {
                switch (a16) {
                    case 102:
                    case 103:
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        Contact c16 = msgSendError.c();
                        if (c16 != null) {
                            str = c16.peerUid;
                        } else {
                            str = null;
                        }
                        ReportController.o(peekAppRuntime, "dc00899", "Grp_set", "", "Grp_data", "forbid_temp", 0, 0, str, "", "", "");
                        b(j3, b16);
                        return;
                    case 104:
                        b(j3, b16);
                        return;
                    default:
                        if (a16 > 100) {
                            b(j3, b16);
                            return;
                        }
                        return;
                }
            }
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105894", true)) {
                b(j3, b16);
            }
        }
    }
}
