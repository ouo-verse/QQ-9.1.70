package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.util.Base64;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.e;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb.oidb_0xe9b$RspBody;
import com.tencent.mobileqq.aio.widget.RoundCorneredRelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "", "uid", "D", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "Landroid/view/View;", "B", "Landroid/content/Context;", "context", "l", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/pb/oidb_0xe9b$RspBody;", "I", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/pb/oidb_0xe9b$RspBody;", "data", "<init>", "(Landroid/content/Context;)V", "J", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private oidb_0xe9b$RspBody data;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63758);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context) {
        super(context, true);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            p(k());
        }
    }

    private final String D(String uid) {
        ag uixConvertService;
        Long z06;
        String l3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (uixConvertService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getUixConvertService()) == null || (z06 = uixConvertService.z0(uid)) == null || (l3 = z06.toString()) == null) {
            return "";
        }
        return l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view != null) {
            this$0.onClick(view);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View B(@NotNull ah message) {
        String l26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        t(message);
        try {
            l26 = message.l2();
        } catch (Throwable th5) {
            QLog.e("MiniCardBeancurdView", 1, th5.getMessage(), th5);
        }
        if (l26 == null) {
            return k();
        }
        byte[] decode = Base64.decode(l26, 0);
        oidb_0xe9b$RspBody oidb_0xe9b_rspbody = new oidb_0xe9b$RspBody();
        this.data = oidb_0xe9b_rspbody;
        oidb_0xe9b_rspbody.mergeFrom(decode);
        String uid = message.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        new com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.e(uid, D(uid)).q(message, new com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.f().a(oidb_0xe9b_rspbody), k(), new e.f() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.c
            @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.e.f
            public final void onClick(View view) {
                d.E(d.this, view);
            }
        });
        QLog.i("MiniCardBeancurdView", 1, "updateView invoke");
        return k();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        View rootView = View.inflate(context, R.layout.dub, null);
        View findViewById = rootView.findViewById(R.id.f166798ic2);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.aio.widget.RoundCorneredRelativeLayout");
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) findViewById;
        float dip2px = ViewUtils.dip2px(16.0f);
        roundCorneredRelativeLayout.a(true);
        roundCorneredRelativeLayout.setRadius(dip2px, dip2px, dip2px, dip2px);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }
}
