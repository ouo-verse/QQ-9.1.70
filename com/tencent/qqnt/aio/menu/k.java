package com.tencent.qqnt.aio.menu;

import android.content.Context;
import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfigExt;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.p;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b*\u0014\b\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0005:\u0001$B+\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u0017\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/menu/k;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "VB", "Lcom/tencent/qqnt/aio/menu/ui/d;", "", "f", "", "c", "", tl.h.F, "b", "e", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/aio/base/mvvm/a;", "getVb", "()Lcom/tencent/aio/base/mvvm/a;", "vb", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "getSelectContent", "()Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "selectContent", "g", "Ljava/lang/String;", "title", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/data/msglist/a;Lcom/tencent/aio/base/mvvm/a;Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;)V", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class k<VB extends com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState>> extends com.tencent.qqnt.aio.menu.ui.d {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VB vb;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final SelectableLinearLayout selectContent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/menu/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.k$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ k(Context context, com.tencent.aio.data.msglist.a aVar, com.tencent.aio.base.mvvm.a aVar2, SelectableLinearLayout selectableLinearLayout, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, aVar, aVar2, (i3 & 8) != 0 ? null : selectableLinearLayout);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, aVar, aVar2, selectableLinearLayout, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return R.drawable.jx7;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.id.cjs;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "ForwardMenuItem";
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    /* renamed from: f */
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.title;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        if (com.tencent.mobileqq.aio.utils.d.v(r0) != false) goto L14;
     */
    @Override // com.tencent.qqnt.aio.menu.ui.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        MarketFaceElement marketFaceElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        SelectableLinearLayout selectableLinearLayout = this.selectContent;
        if (selectableLinearLayout != null) {
            if (selectableLinearLayout.l() == this.selectContent.contentLength()) {
                AIOMsgItem msgItem = d();
                Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
            }
            VB vb5 = this.vb;
            String obj = this.selectContent.m().toString();
            AIOMsgItem msgItem2 = d();
            Intrinsics.checkNotNullExpressionValue(msgItem2, "msgItem");
            vb5.sendIntent(new p.d(obj, msgItem2));
            return;
        }
        if (d().getMsgRecord().msgType == 17) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("touin", d().getMsgRecord().peerUin);
            MsgElement firstTypeElement = d().getFirstTypeElement(11);
            Integer num = null;
            if (firstTypeElement != null) {
                marketFaceElement = firstTypeElement.marketFaceElement;
            } else {
                marketFaceElement = null;
            }
            if (marketFaceElement != null) {
                num = Integer.valueOf(marketFaceElement.emojiPackageId);
            }
            jSONObject.put("emoji_id", num);
            ((IMarketFaceTailConfigExt) QRoute.api(IMarketFaceTailConfigExt.class)).reportAction(QCircleDaTongConstant.ElementParamValue.LONG_PRESS, TransactionActivity.PREF_NAME_TRANSFER, "4", 102, jSONObject.toString());
        }
        VB vb6 = this.vb;
        AIOMsgItem msgItem3 = d();
        Intrinsics.checkNotNullExpressionValue(msgItem3, "msgItem");
        vb6.sendIntent(new p.c(msgItem3));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull Context context, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull VB vb5, @Nullable SelectableLinearLayout selectableLinearLayout) {
        super((AIOMsgItem) msgItem);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, msgItem, vb5, selectableLinearLayout);
            return;
        }
        this.context = context;
        this.vb = vb5;
        this.selectContent = selectableLinearLayout;
        String string = context.getResources().getString(R.string.f170968bc0);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026qq.qqui.R.string.forward)");
        this.title = string;
    }
}
