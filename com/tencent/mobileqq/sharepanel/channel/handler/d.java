package com.tencent.mobileqq.sharepanel.channel.handler;

import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/handler/d;", "Lcom/tencent/mobileqq/sharepanel/channel/handler/e;", "Lcom/tencent/mobileqq/sharepanel/channel/param/b;", "param", "", "f", "Landroid/os/ResultReceiver;", "c", "Landroid/os/ResultReceiver;", "forwardResultReceiver", "<init>", "()V", "d", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d extends e<com.tencent.mobileqq.sharepanel.channel.param.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ResultReceiver forwardResultReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/handler/d$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.channel.handler.d$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull Activity activity, @NotNull Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) intent);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(intent, "intent");
            int intExtra = intent.getIntExtra("forward_type", Integer.MAX_VALUE);
            if (intExtra != 0) {
                if (intExtra != 1) {
                    if (intExtra == 21) {
                        intent.putExtra(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
                    }
                } else {
                    intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                }
            } else {
                intent.removeExtra("forward _key_nojump");
            }
            intent.putExtra("caller_name", activity.getClass().getSimpleName());
            intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32972);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r9 == false) goto L28;
     */
    @Override // com.tencent.mobileqq.sharepanel.channel.handler.e
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(@NotNull com.tencent.mobileqq.sharepanel.channel.param.b param) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Activity a16 = a();
        if (a16 == null) {
            return;
        }
        Intent a17 = param.a();
        ArrayList<ResultRecord> b16 = param.b();
        boolean z17 = false;
        if (b16 != null) {
            i3 = b16.size();
        } else {
            i3 = 0;
        }
        QLog.i("SharePanel_ChannelHandler_FriendSelect", 1, "onHandleChannelClick targetList:" + i3);
        if (a17 == null) {
            QLog.e("SharePanel_ChannelHandler_FriendSelect", 1, "onHandleChannelClick forwardIntent is null");
            b().a(false);
            return;
        }
        if (!param.c()) {
            if (b16 != null && !b16.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
        }
        a17.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        if (b16 == null || b16.isEmpty()) {
            z17 = true;
        }
        if (!z17) {
            a17.putParcelableArrayListExtra("selected_target_list", b16);
        }
        INSTANCE.a(a16, a17);
        ShareForwardResultReceiver shareForwardResultReceiver = new ShareForwardResultReceiver((ResultReceiver) a17.getParcelableExtra("PARAM_ActivityResultReceiver"), b());
        this.forwardResultReceiver = shareForwardResultReceiver;
        a17.putExtra("PARAM_ActivityResultReceiver", shareForwardResultReceiver);
        RouteUtils.startActivity(a16, a17, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
    }
}
