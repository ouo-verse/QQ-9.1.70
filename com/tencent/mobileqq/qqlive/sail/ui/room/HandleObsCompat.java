package com.tencent.mobileqq.qqlive.sail.ui.room;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveAnchorCloseObsRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J$\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/HandleObsCompat;", "", "Landroid/view/View;", "view", "", "b", "", "programId", "Lkotlin/Function1;", "", "callback", "a", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class HandleObsCompat {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HandleObsCompat f273110a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f273110a = new HandleObsCompat();
        }
    }

    HandleObsCompat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@Nullable String programId, @NotNull final Function1<? super Boolean, Unit> callback) {
        boolean z16;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) programId, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (programId != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(programId);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    AegisLogger.INSTANCE.w("Open_Live|HandleObsCompat", "exitObsRoom", "invalid programId");
                    return;
                } else {
                    ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveAnchorCloseObsRequest(programId), new Function1<QQLiveResponse<gr4.c>, Unit>(callback) { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.HandleObsCompat$exitObsRoom$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Function1<Boolean, Unit> $callback;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                            this.$callback = callback;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<gr4.c> qQLiveResponse) {
                            invoke2(qQLiveResponse);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull QQLiveResponse<gr4.c> response) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(response, "response");
                            gr4.c rsp = response.getRsp();
                            if (response.isFailed() || rsp == null) {
                                AegisLogger.INSTANCE.w("Open_Live|HandleObsCompat", "exitObsRoom", "failed, code=" + response.getRetCode() + ", msg=" + response.getErrMsg());
                                this.$callback.invoke(Boolean.FALSE);
                            }
                            AegisLogger.INSTANCE.i("Open_Live|HandleObsCompat", "exitObsRoom", "success");
                            this.$callback.invoke(Boolean.TRUE);
                        }
                    });
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void b(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else if (view == null) {
            AegisLogger.INSTANCE.w("Open_Live|HandleObsCompat", "reConnectObsRoom", "invalid view");
        } else {
            view.performClick();
        }
    }
}
