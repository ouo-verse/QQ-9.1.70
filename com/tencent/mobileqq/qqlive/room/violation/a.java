package com.tencent.mobileqq.qqlive.room.violation;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.room.prepare.i;
import com.tencent.mobileqq.qqlive.room.prepare.k;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qg4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/violation/a;", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/violation/a$a;", "", "Lcom/tencent/mobileqq/qqlive/data/common/QQLiveErrorMsg;", "errorMsg", "", "a", "Landroid/app/Activity;", "hostActivity", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "prepareViewModel", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.violation.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@NotNull QQLiveErrorMsg errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) errorMsg);
            } else {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                e.INSTANCE.d(errorMsg.originErrMsg, null);
            }
        }

        @JvmStatic
        public final void b(@Nullable Activity hostActivity, @NotNull k prepareViewModel, @NotNull QQLiveErrorMsg errorMsg) {
            String str;
            String str2;
            Resources resources;
            Resources resources2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, hostActivity, prepareViewModel, errorMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(prepareViewModel, "prepareViewModel");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            i iVar = i.f271952a;
            long j3 = errorMsg.originErrCode;
            String str3 = errorMsg.originErrMsg;
            Intrinsics.checkNotNullExpressionValue(str3, "errorMsg.originErrMsg");
            if (iVar.b(hostActivity, j3, str3)) {
                return;
            }
            int i3 = errorMsg.originErrCode;
            if (i3 != 1004) {
                if (i3 != 1010) {
                    e.Companion companion = e.INSTANCE;
                    if (hostActivity == null || (resources2 = hostActivity.getResources()) == null || (str = resources2.getString(R.string.f210155hc)) == null) {
                        str = "\u52a0\u8f7d\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5";
                    }
                    String str4 = str;
                    if (hostActivity == null || (resources = hostActivity.getResources()) == null || (str2 = resources.getString(R.string.f169272hw)) == null) {
                        str2 = "\u786e\u5b9a";
                    }
                    companion.e(str4, str2, null, "", null);
                    AegisLogger.INSTANCE.e("Open_Live|ViolationHandler", "onError", "prepareError, errorCode:" + errorMsg.originErrCode + ", errorMsg:" + errorMsg.originErrMsg);
                    return;
                }
                prepareViewModel.e2(3);
                return;
            }
            prepareViewModel.e2(2);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50329);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmStatic
    public static final void a(@NotNull QQLiveErrorMsg qQLiveErrorMsg) {
        INSTANCE.a(qQLiveErrorMsg);
    }

    @JvmStatic
    public static final void b(@Nullable Activity activity, @NotNull k kVar, @NotNull QQLiveErrorMsg qQLiveErrorMsg) {
        INSTANCE.b(activity, kVar, qQLiveErrorMsg);
    }
}
