package com.tencent.qqnt.aio.contact.profile;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/l;", "Lcom/tencent/qqnt/aio/contact/profile/f;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class l implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/l$a;", "", "Landroid/content/Context;", "context", "", "sendUin", "", "a", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.contact.profile.l$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

        public final void a(@NotNull Context context, long sendUin) {
            FragmentActivity fragmentActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(sendUin));
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                Bundle extras = fragmentActivity.getIntent().getExtras();
                if (extras != null && extras.getBoolean("qcircle_chat_from_personal_page", true)) {
                    z16 = true;
                }
                boolean b16 = l.INSTANCE.b(sendUin);
                QLog.d("QCircleProfileInterceptor", 1, "[handleCircleProfile] isFromPersonalPage =" + z16 + ", sendUin = " + sendUin + ", isOwner = " + b16);
                if (z16 && !b16) {
                    Bundle bundle = new Bundle();
                    bundle.putString("aio_disappear_type", "3");
                    com.tencent.qqnt.aio.utils.c.f352293a.b(fragmentActivity, "", new ExternalCommIntent("close_aio", bundle));
                    return;
                }
                ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).launchPersonalDetailPage(context, sendUin);
            }
        }

        public final boolean b(long sendUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, sendUin)).booleanValue();
            }
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            if (account != null) {
                return account.equals(String.valueOf(sendUin));
            }
            return false;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.contact.profile.f
    public boolean a(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 113) {
            return false;
        }
        INSTANCE.a(context, msgItem.getMsgRecord().senderUin);
        return true;
    }
}
