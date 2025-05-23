package com.tencent.mobileqq.sharepanel.channel.handler;

import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/handler/b;", "Lcom/tencent/mobileqq/sharepanel/channel/handler/e;", "Lcom/tencent/mobileqq/sharepanel/channel/param/a;", "param", "", "f", "Landroid/os/ResultReceiver;", "c", "Landroid/os/ResultReceiver;", "forwardResultReceiver", "<init>", "()V", "d", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends e<com.tencent.mobileqq.sharepanel.channel.param.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ResultReceiver forwardResultReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/handler/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.channel.handler.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.channel.handler.e
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.sharepanel.channel.param.a param) {
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
        SharePanelContactItem a17 = param.a();
        Intent b16 = param.b();
        QLog.i("SharePanel_ChannelHandler_DirectForward", 1, "onHandleChannelClick contact:" + a17);
        if (b16 == null) {
            QLog.e("SharePanel_ChannelHandler_DirectForward", 1, "onHandleChannelClick forwardIntent is null");
            b().a(false);
            return;
        }
        if (a17 == null) {
            QLog.e("SharePanel_ChannelHandler_DirectForward", 1, "onHandleChannelClick contact is null");
            b().a(false);
            return;
        }
        b16.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        b16.putExtra("key_direct_show_uin_type", a17.f());
        b16.putExtra("key_direct_show_uin", a17.e());
        b16.putExtra("caller_name", a16.getClass().getName());
        d.INSTANCE.a(a16, b16);
        ShareForwardResultReceiver shareForwardResultReceiver = new ShareForwardResultReceiver((ResultReceiver) b16.getParcelableExtra("PARAM_ActivityResultReceiver"), b());
        this.forwardResultReceiver = shareForwardResultReceiver;
        b16.putExtra("PARAM_ActivityResultReceiver", shareForwardResultReceiver);
        RouteUtils.startActivity(a16, b16, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS);
    }
}
