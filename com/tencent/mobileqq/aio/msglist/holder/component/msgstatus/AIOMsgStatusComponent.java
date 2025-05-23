package com.tencent.mobileqq.aio.msglist.holder.component.msgstatus;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.c;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.f;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IDialogApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.kernel.nativeinterface.EmojiZPlan;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.ActionSheet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001LB#\u0012\u0006\u0010(\u001a\u00020%\u0012\b\b\u0002\u0010+\u001a\u00020\b\u0012\b\b\u0002\u0010-\u001a\u00020\b\u00a2\u0006\u0004\bI\u0010JJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J&\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00172\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010*R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u00100\u001a\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgstatus/AIOMsgStatusComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", "v1", "", "status", "delaySendShow", "", "E1", "C1", Constants.BASE_IN_PLUGIN_ID, "B1", "z1", "y1", "x1", "w1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Landroid/view/View;", "v", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "c1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "d1", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "f", "Z", "allowCancelSend", h.F, "useActionSheetForResend", "Landroid/widget/ImageView;", "i", "Lkotlin/Lazy;", "u1", "()Landroid/widget/ImageView;", "statusIcon", "Landroid/graphics/drawable/Animatable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Animatable;", "sendingAniDrawable", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/data/msglist/a;", "curMsgItem", "D", "I", "msgStatus", "E", "canExecuteSendingRunnable", "Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, ICustomDataEditor.STRING_PARAM_1, "()Ljava/lang/Runnable;", "showSendingRunnable", "Landroid/graphics/drawable/Drawable;", "G", "Landroid/graphics/drawable/Drawable;", "sendingIcon", "<init>", "(Landroid/content/Context;ZZ)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOMsgStatusComponent extends com.tencent.mobileqq.aio.msglist.holder.component.c implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.aio.data.msglist.a curMsgItem;

    /* renamed from: D, reason: from kotlin metadata */
    private int msgStatus;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean canExecuteSendingRunnable;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy showSendingRunnable;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Drawable sendingIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean allowCancelSend;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean useActionSheetForResend;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy statusIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animatable sendingAniDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgstatus/AIOMsgStatusComponent$a;", "", "", "SENDING_DELAY_MILLIS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.AIOMsgStatusComponent$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/msgstatus/AIOMsgStatusComponent$b", "Lcom/tencent/qqnt/aio/adapter/api/IDialogApi$a;", "", "onConfirm", "onCancel", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements IDialogApi.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgStatusComponent.this);
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IDialogApi.a
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IDialogApi.a
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AIOMsgStatusComponent aIOMsgStatusComponent = AIOMsgStatusComponent.this;
            com.tencent.aio.data.msglist.a aVar = aIOMsgStatusComponent.curMsgItem;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curMsgItem");
                aVar = null;
            }
            aIOMsgStatusComponent.sendIntent(new c.C7312c(aVar));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62050);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ AIOMsgStatusComponent(Context context, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(AIOMsgStatusComponent this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            com.tencent.aio.data.msglist.a aVar = this$0.curMsgItem;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curMsgItem");
                aVar = null;
            }
            this$0.sendIntent(new c.C7312c(aVar));
        }
        actionSheet.dismiss();
    }

    private final void B1() {
        String string = getMContext().getString(R.string.f170283l9);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026pter.R.string.aio_resend)");
        String string2 = getMContext().getString(R.string.l_);
        Intrinsics.checkNotNullExpressionValue(string2, "mContext.getString(com.t\u2026string.aio_resend_prompt)");
        ((IDialogApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IDialogApi.class)).showAlert(this.context, string, string2, new b());
    }

    private final void C1() {
        ViewGroup.LayoutParams layoutParams = u1().getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        u1().setLayoutParams(layoutParams);
        u1().setImageResource(R.drawable.f160226dl);
        u1().setContentDescription(HardCodeUtil.qqStr(R.string.f201274ud));
        View f16 = f1();
        Intrinsics.checkNotNull(f16);
        f16.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void D1() {
        Animatable animatable = null;
        if (QLog.isColorLevel()) {
            com.tencent.aio.data.msglist.a aVar = this.curMsgItem;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("curMsgItem");
                aVar = null;
            }
            QLog.d("AIOMsgStatusComponent", 2, "showSending msgId=" + aVar.getMsgId());
        }
        ViewGroup.LayoutParams layoutParams = u1().getLayoutParams();
        if (!this.allowCancelSend) {
            f fVar = f.f192441a;
            layoutParams.width = fVar.b();
            layoutParams.height = fVar.b();
        } else {
            f fVar2 = f.f192441a;
            layoutParams.width = fVar2.a();
            layoutParams.height = fVar2.a();
        }
        u1().setLayoutParams(u1().getLayoutParams());
        Drawable drawable = this.sendingIcon;
        u1().setImageDrawable(drawable);
        u1().setContentDescription(HardCodeUtil.qqStr(R.string.f201324ui));
        if (drawable instanceof Animatable) {
            animatable = (Animatable) drawable;
        }
        if (animatable != null) {
            this.sendingAniDrawable = animatable;
            animatable.start();
        }
        f1().setVisibility(0);
    }

    private final void E1(int status, boolean delaySendShow) {
        if (f1() == null) {
            return;
        }
        this.msgStatus = status;
        this.canExecuteSendingRunnable = false;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(s1());
        y1();
        if (status != 0) {
            if (status != 1) {
                if (status != 2 && status != 3) {
                    u1().setImageDrawable(null);
                    f1().setVisibility(8);
                    return;
                } else {
                    u1().setImageDrawable(null);
                    f1().setVisibility(8);
                    return;
                }
            }
            if (x1()) {
                return;
            }
            if (QLog.isColorLevel()) {
                com.tencent.aio.data.msglist.a aVar = this.curMsgItem;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("curMsgItem");
                    aVar = null;
                }
                QLog.d("AIOMsgStatusComponent", 2, "updateIcon msgId=" + aVar.getMsgId() + " showSending " + delaySendShow);
            }
            if (delaySendShow) {
                this.canExecuteSendingRunnable = true;
                u1().setImageDrawable(null);
                ThreadManagerV2.getUIHandlerV2().postDelayed(s1(), 400L);
                return;
            }
            D1();
            return;
        }
        C1();
    }

    static /* synthetic */ void F1(AIOMsgStatusComponent aIOMsgStatusComponent, int i3, boolean z16, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                z16 = true;
            }
            aIOMsgStatusComponent.E1(i3, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateIcon");
    }

    private final Runnable s1() {
        return (Runnable) this.showSendingRunnable.getValue();
    }

    private final ImageView u1() {
        return (ImageView) this.statusIcon.getValue();
    }

    private final boolean v1(AIOMsgItem msgItem, List<Object> payloads) {
        a.ay ayVar;
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Object obj2 = ((Map) obj).get(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD);
                if (obj2 instanceof a.ay) {
                    ayVar = (a.ay) obj2;
                } else {
                    ayVar = null;
                }
                if (ayVar != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOMsgStatusComponent", 2, "handled by payload, msgId:" + msgItem.getMsgId() + " sendStatus=" + ayVar.a());
                    }
                    F1(this, ayVar.a(), false, 2, null);
                }
            }
        }
        return true;
    }

    private final boolean w1() {
        c.b bVar = new c.b(false, 1, null);
        sendIntent(bVar);
        return bVar.a();
    }

    private final boolean x1() {
        PicElement picElement;
        EmojiZPlan emojiZPlan;
        com.tencent.aio.data.msglist.a aVar = this.curMsgItem;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curMsgItem");
            aVar = null;
        }
        MsgElement firstTypeElement = ((AIOMsgItem) aVar).getFirstTypeElement(2);
        if (firstTypeElement == null || (picElement = firstTypeElement.picElement) == null || (emojiZPlan = picElement.emojiZplan) == null || emojiZPlan.actionId == 0) {
            return false;
        }
        return true;
    }

    private final void y1() {
        Animatable animatable = this.sendingAniDrawable;
        if (animatable != null) {
            animatable.stop();
        }
        this.sendingAniDrawable = null;
    }

    private final void z1() {
        final ActionSheet create = ActionSheet.create(getMContext());
        create.addButton(R.string.f170283l9);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                AIOMsgStatusComponent.A1(AIOMsgStatusComponent.this, create, view, i3);
            }
        });
        create.show();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curMsgItem = msgItem;
        if (msgItem.isSelf() && !w1()) {
            AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
            if (v1(aIOMsgItem, payloads)) {
                return;
            }
            F1(this, aIOMsgItem.R(), false, 2, null);
            return;
        }
        f1().setVisibility(8);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return u1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            int i3 = this.msgStatus;
            if (i3 == 0) {
                if (this.useActionSheetForResend) {
                    z1();
                } else {
                    B1();
                }
            } else if (i3 == 1 && this.allowCancelSend) {
                com.tencent.aio.data.msglist.a aVar = this.curMsgItem;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("curMsgItem");
                    aVar = null;
                }
                sendIntent(new c.a((AIOMsgItem) aVar));
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View f16 = f1();
        Intrinsics.checkNotNull(f16);
        return f16;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.canExecuteSendingRunnable) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(s1());
        }
        this.canExecuteSendingRunnable = false;
        y1();
    }

    public AIOMsgStatusComponent(@NotNull Context context, boolean z16, boolean z17) {
        Lazy lazy;
        Lazy lazy2;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.context = context;
        this.allowCancelSend = z16;
        this.useActionSheetForResend = z17;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.AIOMsgStatusComponent$statusIcon$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgStatusComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOMsgStatusComponent.this.context;
                ImageView imageView = new ImageView(context2);
                AIOMsgStatusComponent aIOMsgStatusComponent = AIOMsgStatusComponent.this;
                imageView.setBackground(null);
                imageView.setOnClickListener(aIOMsgStatusComponent);
                return imageView;
            }
        });
        this.statusIcon = lazy;
        this.msgStatus = 2;
        this.canExecuteSendingRunnable = true;
        lazy2 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new AIOMsgStatusComponent$showSendingRunnable$2(this));
        this.showSendingRunnable = lazy2;
        if (z16) {
            drawable = context.getResources().getDrawable(R.drawable.gxn);
        } else {
            drawable = context.getResources().getDrawable(R.drawable.common_loading6);
        }
        this.sendingIcon = drawable;
    }
}
