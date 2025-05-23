package com.tencent.qqnt.aio.menu;

import android.content.Context;
import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f*\u0014\b\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0005:\u0001 B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0018\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/menu/ac;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Lcom/tencent/qqnt/aio/menu/ui/d;", "", "k", "", "f", "", "c", tl.h.F, "b", "e", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/aio/base/mvvm/a;", "getVb", "()Lcom/tencent/aio/base/mvvm/a;", "vb", "Ljava/lang/String;", "title", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/aio/base/mvvm/a;)V", "g", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ac<VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> extends com.tencent.qqnt.aio.menu.ui.d {
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/menu/ac$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.ac$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47560);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(@NotNull Context context, @NotNull AIOMsgItem msgItem, @NotNull VB vb5) {
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
        String string = context.getResources().getString(R.string.f208405cm);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026qqcommon_related_emotion)");
        this.title = string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ac this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
    }

    private final void k() {
        MarketFaceElement marketFaceElement;
        MsgElement firstTypeElement = d().getFirstTypeElement(11);
        PicElement picElement = null;
        if (firstTypeElement != null) {
            marketFaceElement = firstTypeElement.marketFaceElement;
        } else {
            marketFaceElement = null;
        }
        if (marketFaceElement != null) {
            ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(MobileQQ.sMobileQQ.peekAppRuntime(), "", String.valueOf(d().getMsgRecord().peerUin), "0X800B115", "0X800B115", com.tencent.qqnt.emotion.utils.e.c(d().getMsgRecord().chatType), 0, "1", "", String.valueOf(marketFaceElement.emojiPackageId), marketFaceElement.emojiId.toString());
            return;
        }
        MsgElement firstTypeElement2 = d().getFirstTypeElement(2);
        if (firstTypeElement2 != null) {
            picElement = firstTypeElement2.picElement;
        }
        if (picElement != null) {
            ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(MobileQQ.sMobileQQ.peekAppRuntime(), "", String.valueOf(d().getMsgRecord().peerUin), "0X800B115", "0X800B115", com.tencent.qqnt.emotion.utils.e.c(d().getMsgRecord().chatType), 0, com.tencent.qqnt.emotion.utils.e.d(picElement), "", picElement.md5HexStr, com.tencent.qqnt.emotion.utils.e.a(d().isSelf(), d().getMsgRecord().chatType, picElement));
        }
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.drawable.jwv;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.id.zgj;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "RelatedEmotionMenuItem";
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
        VB vb5 = this.vb;
        AIOMsgItem msgItem = d();
        Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
        vb5.sendIntent(new p.l(msgItem));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.menu.ab
            @Override // java.lang.Runnable
            public final void run() {
                ac.j(ac.this);
            }
        }, 16, null, false);
    }
}
