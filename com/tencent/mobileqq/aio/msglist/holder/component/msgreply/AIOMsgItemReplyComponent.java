package com.tencent.mobileqq.aio.msglist.holder.component.msgreply;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.v;
import com.tencent.mobileqq.aio.msglist.holder.component.msgreply.AIOMsgItemReplyComponentUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.msgreply.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/AIOMsgItemReplyComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/e;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "w1", "", "", "payloads", "", "v1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Landroidx/constraintlayout/widget/ConstraintLayout;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "d1", "state", "g1", h.F, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "currentMsgItem", "i", "Lkotlin/Lazy;", "u1", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "contentView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgItemReplyComponent extends com.tencent.mobileqq.aio.msglist.holder.component.e {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/AIOMsgItemReplyComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgreply.AIOMsgItemReplyComponent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61981);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMsgItemReplyComponent(@NotNull final Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>(context, this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgreply.AIOMsgItemReplyComponent$contentView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ AIOMsgItemReplyComponent this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ConstraintLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ConstraintLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ConstraintLayout invoke$lambda$1$lambda$0 = w71.h.g(LayoutInflater.from(this.$context)).getRoot();
                    final AIOMsgItemReplyComponent aIOMsgItemReplyComponent = this.this$0;
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, l.b(26));
                    marginLayoutParams.setMarginStart(FontSettingManager.isFontSizeLarge() ? 0 : l.b(9));
                    Intrinsics.checkNotNullExpressionValue(invoke$lambda$1$lambda$0, "invoke$lambda$1$lambda$0");
                    invoke$lambda$1$lambda$0.setBackground(AppCompatResources.getDrawable(invoke$lambda$1$lambda$0.getContext(), R.drawable.j7q));
                    invoke$lambda$1$lambda$0.setLayoutParams(marginLayoutParams);
                    com.tencent.aio.view_dsl.dsl.d.a(invoke$lambda$1$lambda$0, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgreply.AIOMsgItemReplyComponent$contentView$2$1$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AIOMsgItemReplyComponent.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            AIOMsgItem aIOMsgItem;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this, (Object) it);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(it, "it");
                            aIOMsgItem = AIOMsgItemReplyComponent.this.currentMsgItem;
                            if (aIOMsgItem != null) {
                                AIOMsgItemReplyComponent aIOMsgItemReplyComponent2 = AIOMsgItemReplyComponent.this;
                                v l06 = aIOMsgItem.l0();
                                if (l06 != null) {
                                    aIOMsgItemReplyComponent2.sendIntent(new a.C7311a(aIOMsgItem, l06));
                                }
                            }
                        }
                    });
                    AccessibilityUtil.c(invoke$lambda$1$lambda$0, invoke$lambda$1$lambda$0.getResources().getString(R.string.ypa), Button.class.getName());
                    ViewCompat.setImportantForAccessibility(invoke$lambda$1$lambda$0, 1);
                    return invoke$lambda$1$lambda$0;
                }
            });
            this.contentView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private final ConstraintLayout u1() {
        return (ConstraintLayout) this.contentView.getValue();
    }

    private final boolean v1(List<Object> payloads, AIOMsgItem msgItem) {
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(AIOMsgItemPayloadType.SHOULD_SHOW_REPLY_PAYLOAD) != null) {
                w1(msgItem);
            }
        }
        return false;
    }

    private final void w1(AIOMsgItem msgItem) {
        if (msgItem.Z()) {
            if (msgItem.F0()) {
                sendIntent(new a.b(msgItem));
                p1();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AIOMsgItemReplyComponent", 2, "processMsgReply " + msgItem.U0() + ", hasMsgReplyClicked:" + msgItem.F() + ", isSelf: " + msgItem.isSelf() + ", needShowReply: " + msgItem.Z());
            }
            q1();
            MsgReplyInjectUtil.f191195a.i(msgItem);
            return;
        }
        p1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        AIOMsgItem aIOMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (msgItem instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) msgItem;
        } else {
            aIOMsgItem = null;
        }
        this.currentMsgItem = aIOMsgItem;
        AIOMsgItem aIOMsgItem2 = (AIOMsgItem) msgItem;
        if (v1(payloads, aIOMsgItem2)) {
            w1(aIOMsgItem2);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        AIOMsgItem aIOMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if ((state instanceof AIOMsgItemReplyComponentUIState.UpdateReplyViewState) && (aIOMsgItem = this.currentMsgItem) != null) {
            w1(aIOMsgItem);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConstraintLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ConstraintLayout contentView = u1();
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        return contentView;
    }
}
