package com.tencent.mobileqq.aio.msglist.holder.component.nick.block;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.AIONickTextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IContactApi;
import com.tencent.qqnt.aio.nick.i;
import com.tencent.qqnt.aio.nick.j;
import com.tencent.qqnt.aio.refresher.ai;
import com.tencent.qqnt.aio.refresher.aj;
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
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/MainNickNameBlock;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", "", "v", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "", "payloads", "", "u", "", "d", h.F, "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "Landroid/view/View;", "j", "i", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isMosaic", "y", "B", "k", "r", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "mCurrentMsgItem", "Lcom/tencent/mobileqq/qqui/widget/AIONickTextView;", "D", "Lkotlin/Lazy;", "t", "()Lcom/tencent/mobileqq/qqui/widget/AIONickTextView;", "nickView", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MainNickNameBlock extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AIOMsgItem mCurrentMsgItem;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy nickView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/MainNickNameBlock$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.nick.block.MainNickNameBlock$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainNickNameBlock(@NotNull final Context context, @NotNull LinearLayout rootView) {
        super(context, rootView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AIONickTextView>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.block.MainNickNameBlock$nickView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIONickTextView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIONickTextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIONickTextView aIONickTextView = new AIONickTextView(this.$context, null, 0, 6, null);
                    aIONickTextView.setTextSize(0, this.$context.getResources().getDimension(R.dimen.f158235c01));
                    aIONickTextView.setEllipsize(TextUtils.TruncateAt.END);
                    aIONickTextView.setSingleLine();
                    aIONickTextView.setId(R.id.siw);
                    aIONickTextView.setImportantForAccessibility(2);
                    return aIONickTextView;
                }
            });
            this.nickView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) rootView);
        }
    }

    private final AIONickTextView t() {
        return (AIONickTextView) this.nickView.getValue();
    }

    private final boolean u(AIOMsgItem msgItem, List<Object> payloads) {
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.VAS_NICK_BACKGROUND_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("MainNickNameBlock", 4, "[handleNickPayload]: msgId is " + msgItem.getMsgId() + ", uin is " + msgItem.getMsgRecord().senderUin);
                    }
                    z(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.NICK_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("MainNickNameBlock", 4, "[handleNickChagePayload]: msg id " + msgItem.getMsgId());
                    }
                    B();
                }
                if (map.get(AIOMsgItemPayloadType.BG_TEXT_COLOR_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("MainNickNameBlock", 4, "[handleBgTextColorPayload]: msgId is " + msgItem.getMsgId());
                    }
                    A(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.SHOT_MOSAIC) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("MainNickNameBlock", 4, "[handleMosaicPayload]: msgId is " + msgItem.getMsgId());
                    }
                    y(msgItem.L0());
                }
            }
        }
        return true;
    }

    private final void v() {
        t().setText("");
        t().setBackground(null);
        t().setPadding(0, 0, 0, 0);
        t().getLayoutParams().width = -2;
        t().getLayoutParams().height = -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AIOMsgItem msgItem, MainNickNameBlock this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.aio.utils.d.b0(msgItem)) {
            ((IContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IContactApi.class)).openProfileCard(this$0.e(), msgItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void z(AIOMsgItem msgItem) {
        com.tencent.qqnt.aio.nick.c a16;
        Long c16 = j.f351725a.c(msgItem);
        if (c16 != null && c16.longValue() > 0 && !com.tencent.mobileqq.aio.utils.d.s(msgItem)) {
            i d06 = msgItem.d0();
            if (d06 == null) {
                QLog.e("MainNickNameBlock", 1, "[setNickBackground]: drawInfo is null, msgId is " + msgItem.getMsgId() + ", nickName is " + ((Object) msgItem.v0()));
                return;
            }
            if (QLog.isDevelopLevel()) {
                long msgId = msgItem.getMsgId();
                CharSequence v06 = msgItem.v0();
                QLog.i("MainNickNameBlock", 4, "[setNickBackground]: msgId is " + msgId + ", nickName is " + ((Object) v06) + ", drawInfo is " + msgItem.d0());
            }
            ai aiVar = new ai(c16.longValue(), d06, null, 4, null);
            o(new d.ah(aiVar));
            aj b16 = aiVar.b();
            if (b16 != null && (a16 = b16.a()) != null) {
                t().setBackground(a16.e());
                t().setPadding(a16.f(), 0, a16.f(), 0);
                t().getLayoutParams().width = a16.h();
                t().getLayoutParams().height = a16.g();
            }
        }
    }

    public final void A(@NotNull AIOMsgItem msgItem) {
        String b16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ColorStateList r16 = msgItem.r();
        if (r16 == null) {
            r16 = MobileQQ.sMobileQQ.getResources().getColorStateList(R.color.qui_common_text_secondary);
            Intrinsics.checkNotNullExpressionValue(r16, "sMobileQQ.resources.getC\u2026ui_common_text_secondary)");
        }
        t().setTextColor(r16);
        com.tencent.qqnt.aio.nick.a B = msgItem.B();
        if (B != null && (b16 = B.b()) != null) {
            if (b16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                t().setTextColor(Color.parseColor(b16));
            }
        }
    }

    public final void B() {
        CharSequence charSequence;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
            if (aIOMsgItem != null) {
                charSequence = aIOMsgItem.v0();
            } else {
                charSequence = null;
            }
            QLog.i("MainNickNameBlock", 4, "[updateNick]: showNickName is " + ((Object) charSequence));
        }
        AIOMsgItem aIOMsgItem2 = this.mCurrentMsgItem;
        if (aIOMsgItem2 != null) {
            t().setText(aIOMsgItem2.v0());
            z(aIOMsgItem2);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public boolean h(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void i(@NotNull final AIOMsgItem msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgItem, (Object) payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.mCurrentMsgItem = msgItem;
        if (u(msgItem, payloads)) {
            return;
        }
        v();
        CharSequence v06 = msgItem.v0();
        if (v06.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            v06 = com.tencent.mobileqq.aio.utils.d.i(msgItem);
        }
        t().setText(v06);
        t().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.block.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainNickNameBlock.w(AIOMsgItem.this, this, view);
            }
        });
        z(msgItem);
        A(msgItem);
        AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
        if (aIOMsgItem != null && aIOMsgItem.getMsgRecord().chatType == 2) {
            AccessibilityUtil.n(t(), false);
        }
        y(msgItem.L0());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    @NotNull
    protected View j(@NotNull LinearLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) layoutParams);
        }
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        layoutParams.width = 0;
        layoutParams.weight = 1.0f;
        layoutParams.setMarginEnd(ViewUtils.dpToPx(2.0f));
        return t();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a
    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    public final void x() {
        com.tencent.qqnt.aio.nick.a B;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AIOMsgItem aIOMsgItem = this.mCurrentMsgItem;
        if (aIOMsgItem != null && (B = aIOMsgItem.B()) != null && B.a()) {
            ((IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class)).playNickCoverAnimation(t(), false);
        }
    }

    public final void y(boolean isMosaic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isMosaic);
        } else if (isMosaic) {
            t().setMosaicEffect(new com.tencent.mobileqq.qqui.widget.b(10));
        } else {
            t().setMosaicEffect(null);
        }
    }
}
