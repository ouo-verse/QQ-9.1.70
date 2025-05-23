package com.tencent.qqnt.aio.menu;

import android.content.Context;
import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  *\u0014\b\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0005:\u0001!B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0019\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/menu/af;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Lcom/tencent/qqnt/aio/menu/ui/d;", "", "result", "", "j", "", "f", "c", tl.h.F, "b", "e", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/aio/base/mvvm/a;", "getVb", "()Lcom/tencent/aio/base/mvvm/a;", "vb", "Ljava/lang/String;", "title", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/aio/base/mvvm/a;)V", "g", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class af<VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> extends com.tencent.qqnt.aio.menu.ui.d {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VB vb;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/menu/af$a;", "", "", "ERROR_CODE_ADMIN_RECALL_ADMIN", "I", "ERROR_CODE_ROLE_RECALL_ADMIN", "ERROR_CODE_ROLE_RECALL_ROLE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.af$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47569);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
        super(msgItem);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, msgItem, vb5);
            return;
        }
        this.context = context;
        this.vb = vb5;
        String string = context.getResources().getString(R.string.cde);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026qqui.R.string.msg_revoke)");
        this.title = string;
    }

    private final void j(int result) {
        switch (result) {
            case 200501:
            case 200502:
            case 200503:
                QQToast.makeText(this.context, 1, R.string.f211515l1, 0).show();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(af this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RevokeMenuItem", 4, "recall resultCode=" + i3 + " errorMsg=" + str);
        this$0.j(i3);
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.drawable.f160963jx1;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.id.f1x;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "RevokeMenuItem";
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    /* renamed from: f */
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.title;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("RevokeMenuItem", 4, "onClickMenu");
        AIOMsgItem msgItem = d();
        Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
        if (com.tencent.mobileqq.aio.utils.d.J(msgItem)) {
            p.e eVar = new p.e(0L);
            this.vb.sendIntent(eVar);
            ((IPaiYiPaiApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPaiYiPaiApi.class)).sendRevokePaiYiPaiReq(d().getMsgRecord(), Long.valueOf(eVar.a()));
            return;
        }
        AIOMsgItem msgItem2 = d();
        Intrinsics.checkNotNullExpressionValue(msgItem2, "msgItem");
        p.n nVar = new p.n(msgItem2, false, 2, null);
        this.vb.sendIntent(nVar);
        if (nVar.b()) {
            ((IMsgService) QRoute.api(IMsgService.class)).recallMsg(new Contact(d().getMsgRecord().chatType, d().getMsgRecord().peerUid, d().getMsgRecord().guildId), d().getMsgId(), new IOperateCallback() { // from class: com.tencent.qqnt.aio.menu.ae
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    af.k(af.this, i3, str);
                }
            });
        }
    }
}
