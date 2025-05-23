package com.tencent.mobileqq.aio.msglist.holder.component.chain;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.chain.i;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.emotion.utils.q;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IJoinDragonGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinDragonGroupEmojiReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b0\u00101J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00152\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/chain/g;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Lcom/tencent/mobileqq/aio/msg/e;", "msgItem", "", "", "payloads", "", ICustomDataEditor.STRING_PARAM_1, "", "x1", "Landroid/view/View;", "view", "p1", "v1", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "d1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Landroid/widget/LinearLayout;", "r1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "u1", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "f", "Lcom/tencent/mobileqq/aio/msg/e;", "mCurrentMsgItem", "Lcom/tencent/mobileqq/aio/msglist/holder/component/chain/ChainStickerCountLayout;", tl.h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/chain/ChainStickerCountLayout;", "countView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "chainOperationButton", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "chainOperationAndCountContainer", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g extends com.tencent.mobileqq.aio.msglist.holder.component.c {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.msg.e mCurrentMsgItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChainStickerCountLayout countView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView chainOperationButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout chainOperationAndCountContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/chain/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.chain.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        ChainStickerCountLayout chainStickerCountLayout = new ChainStickerCountLayout(context);
        chainStickerCountLayout.setId(R.id.sh5);
        p1(chainStickerCountLayout);
        chainStickerCountLayout.setVisibility(8);
        this.countView = chainStickerCountLayout;
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.sh6);
        imageView.setImageResource(R.drawable.mkk);
        p1(imageView);
        this.chainOperationButton = imageView;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setContentDescription(linearLayout.getContext().getString(R.string.yoy));
        linearLayout.addView(imageView);
        linearLayout.addView(chainStickerCountLayout);
        this.chainOperationAndCountContainer = linearLayout;
    }

    private final void p1(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.chain.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.q1(g.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (u.a().b()) {
            if (QLog.isColorLevel()) {
                QLog.d("ChainFlowComponent", 2, "chain button fast click, ignore it.");
            }
        } else if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(this$0.getMContext(), 1, R.string.f169552in, 0).show();
        } else {
            com.tencent.mobileqq.aio.msg.e eVar = this$0.mCurrentMsgItem;
            com.tencent.mobileqq.aio.msg.e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                eVar = null;
            }
            if (!eVar.isSelf()) {
                this$0.v1();
                q qVar = q.f356700a;
                com.tencent.mobileqq.aio.msg.e eVar3 = this$0.mCurrentMsgItem;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                    eVar3 = null;
                }
                String a16 = qVar.a(eVar3.p0());
                com.tencent.mobileqq.aio.msg.e eVar4 = this$0.mCurrentMsgItem;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                } else {
                    eVar2 = eVar4;
                }
                com.tencent.mobileqq.temp.report.a.a(null, "dc00898", "", "", "0X800C5DA", "0X800C5DA", 0, 0, a16, String.valueOf(eVar2.r2()), "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean s1(com.tencent.mobileqq.aio.msg.e msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(AIOMsgItemPayloadType.CHAIN_FLAG_CHANGE) != null) {
                x1(msgItem);
            }
        }
        return false;
    }

    private final void v1() {
        com.tencent.mobileqq.aio.msg.e eVar = this.mCurrentMsgItem;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
            eVar = null;
        }
        JoinDragonGroupEmojiReq joinDragonGroupEmojiReq = new JoinDragonGroupEmojiReq(eVar.r2(), eVar.getMsgSeq(), Long.valueOf(eVar.getLastMsgSeq()), new Contact(eVar.p0(), eVar.r0(), ""));
        QLog.d("ChainFlowComponent", 1, "[joinDragonGroupEmojiReq] req = " + joinDragonGroupEmojiReq);
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.i0(joinDragonGroupEmojiReq, new IJoinDragonGroupCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.chain.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IJoinDragonGroupCallback
                public final void onResult(int i3, String str, int i16) {
                    g.w1(g.this, i3, str, i16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(g this$0, int i3, String str, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ChainFlowComponent", 1, "[joinDragonGroupEmojiReq] result=" + i3 + " errMsg=" + str + " emojiId=" + i16);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    QLog.e("ChainFlowComponent", 1, "[joinDragonGroupEmojiReq] occupied, emojiId=" + i16);
                    return;
                }
                return;
            }
            if (i16 > 0) {
                this$0.sendIntent(new i.a(i16));
                return;
            }
            QLog.e("ChainFlowComponent", 1, "[joinDragonGroupEmojiReq-INTERRUPTED], invalidate emojiId=" + i16);
            return;
        }
        if (i16 > 0) {
            this$0.sendIntent(new i.a(i16));
            return;
        }
        QLog.e("ChainFlowComponent", 1, "[joinDragonGroupEmojiReq-SUC], invalidate emojiId=" + i16);
    }

    private final void x1(com.tencent.mobileqq.aio.msg.e msgItem) {
        if (QLog.isDevelopLevel()) {
            QLog.i("ChainFlowComponent", 4, "[updateChainIcon]: showChainIcon=" + msgItem.I2() + ", msgId=" + msgItem.getMsgId() + ", msgSeq=" + msgItem.getMsgSeq() + ", countNum=" + msgItem.H2() + ", hashCode=" + msgItem.hashCode());
        }
        int i3 = 8;
        if (msgItem.I2()) {
            if (QLog.isColorLevel()) {
                QLog.i("ChainFlowComponent", 2, "[updateChainIcon] showChainIcon, msgId=" + msgItem.getMsgId() + ", msgSeq=" + msgItem.getMsgSeq() + ", countNum=" + msgItem.H2() + ", hashCode=" + msgItem.hashCode());
            }
            this.chainOperationAndCountContainer.setVisibility(0);
            ImageView imageView = this.chainOperationButton;
            if (!msgItem.isSelf()) {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            this.countView.b(msgItem.H2());
            if (this.chainOperationButton.getVisibility() == 0) {
                q qVar = q.f356700a;
                com.tencent.mobileqq.aio.msg.e eVar = this.mCurrentMsgItem;
                com.tencent.mobileqq.aio.msg.e eVar2 = null;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                    eVar = null;
                }
                String a16 = qVar.a(eVar.p0());
                com.tencent.mobileqq.aio.msg.e eVar3 = this.mCurrentMsgItem;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                } else {
                    eVar2 = eVar3;
                }
                com.tencent.mobileqq.temp.report.a.a(null, "dc00898", "", "", "0X800C5D9", "0X800C5D9", 0, 0, a16, String.valueOf(eVar2.r2()), "", "");
                return;
            }
            return;
        }
        this.chainOperationAndCountContainer.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.e)) {
            return;
        }
        com.tencent.mobileqq.aio.msg.e eVar = (com.tencent.mobileqq.aio.msg.e) msgItem;
        this.mCurrentMsgItem = eVar;
        if (s1(eVar, payloads)) {
            x1(eVar);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new h();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public LinearLayout c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.chainOperationAndCountContainer;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public LinearLayout onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 6, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.chainOperationAndCountContainer;
    }
}
