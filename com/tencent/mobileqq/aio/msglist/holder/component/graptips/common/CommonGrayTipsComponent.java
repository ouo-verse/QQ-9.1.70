package com.tencent.mobileqq.aio.msglist.holder.component.graptips.common;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.GrayTipsMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.common.CommonGrayTipState;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.common.a;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.refresher.ak;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.ExtBufForUI$ExtData;
import tencent.im.msg.ExtBufForUI$PaiYiPai;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010)\u001a\u00020$\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fH\u0016J&\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u001a2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R2\u0010=\u001a\u001e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u000608j\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0006`:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/common/CommonGrayTipsComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/GrayTipsMsgItem;", "", "Q1", "", "", "payloads", "P1", "", "S1", "msgItem", "J1", "I1", "R1", "", "Landroid/text/style/ClickableSpan;", "clickableSpans", "H1", "Lgv3/a;", "N1", "L1", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Lcom/tencent/qqnt/aio/widget/AIOMsgTextView;", "K1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "O1", "()Lcom/tencent/qqnt/aio/widget/AIOMsgTextView;", "tipsView", "D", "Lgv3/a;", "aioAbility", "E", "Lcom/tencent/mobileqq/aio/msg/GrayTipsMsgItem;", "lastAIOMsgItem", UserInfo.SEX_FEMALE, "Z", "hasBind", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "G", "Ljava/util/HashMap;", "mReportParams", "<init>", "(Landroid/content/Context;)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CommonGrayTipsComponent extends BaseContentComponent<GrayTipsMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy tipsView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private gv3.a aioAbility;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GrayTipsMsgItem lastAIOMsgItem;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasBind;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, Object> mReportParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/common/CommonGrayTipsComponent$a;", "", "", "MAX_LINES", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.graptips.common.CommonGrayTipsComponent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60797);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CommonGrayTipsComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOMsgTextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.graptips.common.CommonGrayTipsComponent$tipsView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CommonGrayTipsComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOMsgTextView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AIOMsgTextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AIOMsgTextView aIOMsgTextView = new AIOMsgTextView(CommonGrayTipsComponent.this.getContext(), null, 0, 6, null);
                aIOMsgTextView.setPadding(ViewUtils.dip2px(9.0f), 0, ViewUtils.dip2px(9.0f), 0);
                aIOMsgTextView.setTextColor(ResourcesCompat.getColorStateList(aIOMsgTextView.getContext().getResources(), R.color.qui_common_text_secondary, aIOMsgTextView.getContext().getTheme()));
                aIOMsgTextView.setLinkTextColor(ResourcesCompat.getColorStateList(aIOMsgTextView.getContext().getResources(), R.color.qui_common_text_link, aIOMsgTextView.getContext().getTheme()));
                aIOMsgTextView.setTextSize(12.0f);
                aIOMsgTextView.setMovementMethod(LinkMovementMethod.getInstance());
                aIOMsgTextView.setAutoLinkMask(0);
                aIOMsgTextView.setLineSpacing(8.0f, 1.0f);
                aIOMsgTextView.setIncludeFontPadding(true);
                aIOMsgTextView.setGravity(17);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.setMarginStart(ViewUtils.dip2px(15.0f));
                marginLayoutParams.setMarginEnd(ViewUtils.dip2px(15.0f));
                aIOMsgTextView.setLayoutParams(marginLayoutParams);
                aIOMsgTextView.setMaxLines(3);
                return aIOMsgTextView;
            }
        });
        this.tipsView = lazy;
        this.mReportParams = new HashMap<>();
    }

    private final void H1(List<? extends ClickableSpan> clickableSpans) {
        gv3.a N1;
        if (clickableSpans == null || q1().l2()) {
            return;
        }
        for (ClickableSpan clickableSpan : clickableSpans) {
            if ((clickableSpan instanceof com.tencent.qqnt.graytips.span.a) && (N1 = N1()) != null) {
                N1.c(q1());
                com.tencent.qqnt.graytips.span.a aVar = (com.tencent.qqnt.graytips.span.a) clickableSpan;
                aVar.c(N1);
                if (((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(q1().getMsgRecord().peerUin), Integer.valueOf(q1().getMsgRecord().chatType)) && aVar.a() == 3) {
                    aVar.f(-1);
                }
            }
        }
        q1().z2(true);
    }

    private final void I1(GrayTipsMsgItem msgItem) {
        List<com.tencent.qqnt.graytips.span.b> i26 = msgItem.i2();
        if (i26 != null) {
            Iterator<T> it = i26.iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.graytips.span.b) it.next()).a(O1());
            }
        }
    }

    private final void J1(GrayTipsMsgItem msgItem) {
        R1(this.lastAIOMsgItem);
        I1(q1());
        H1(q1().j2());
    }

    private final void L1() {
        int i3;
        ExtBufForUI$PaiYiPai extBufForUI$PaiYiPai;
        PBUInt32Field pBUInt32Field;
        if (!d.J(q1())) {
            return;
        }
        ExtBufForUI$ExtData j3 = MsgExtKt.j(q1().getMsgRecord());
        if (j3 != null && (extBufForUI$PaiYiPai = j3.paiyipai) != null && (pBUInt32Field = extBufForUI$PaiYiPai.isPaiYiPaiAvatar) != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            return;
        }
        String currentUid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        String p26 = q1().p2();
        String q26 = q1().q2();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.graptips.common.b
            @Override // java.lang.Runnable
            public final void run() {
                CommonGrayTipsComponent.M1(CommonGrayTipsComponent.this);
            }
        }, 64, null, false);
        if (!TextUtils.isEmpty(q26) && TextUtils.equals(currentUid, q26) && !TextUtils.equals(currentUid, p26)) {
            Intrinsics.checkNotNull(q26);
            ak akVar = new ak(q26);
            QLog.d("CommonGrayTipsComponent", 1, "[bind] paiyipai toUid " + q26 + " currentUid " + currentUid);
            sendIntent(new d.ah(akVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(CommonGrayTipsComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MsgExtKt.d0(this$0.q1().getMsgRecord(), CommonGrayTipsComponent$doPaiYiPaiDoubleEffect$1$1.INSTANCE, null, 2, null);
    }

    private final gv3.a N1() {
        if (this.aioAbility == null) {
            a.C7300a c7300a = new a.C7300a(null, 1, null);
            sendIntent(c7300a);
            this.aioAbility = c7300a.a();
        }
        return this.aioAbility;
    }

    private final AIOMsgTextView O1() {
        return (AIOMsgTextView) this.tipsView.getValue();
    }

    private final boolean P1(List<Object> payloads) {
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.GRAY_TIP_CONTENT_PAYLOAD) != null) {
                    return true;
                }
                if (map.get(AIOMsgItemPayloadType.NICK_PAYLOAD) != null) {
                    handleUIState(CommonGrayTipState.TextChangedState.f190876d);
                }
            }
        }
        return false;
    }

    private final boolean Q1() {
        if (!com.tencent.mobileqq.aio.utils.d.J(q1())) {
            return false;
        }
        if (q1().getMsgRecord().chatType == 1 && q1().q2() == null) {
            return false;
        }
        return true;
    }

    private final void R1(GrayTipsMsgItem msgItem) {
        List<com.tencent.qqnt.graytips.span.b> i26;
        if (msgItem != null && (i26 = msgItem.i2()) != null) {
            Iterator<T> it = i26.iterator();
            while (it.hasNext()) {
                ((com.tencent.qqnt.graytips.span.b) it.next()).a(null);
            }
        }
    }

    private final void S1() {
        String replace$default;
        String valueOf = String.valueOf(q1().getMsgRecord().peerUin);
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        if (((IRobotServiceApi) companion.a(IRobotServiceApi.class)).isRobotAIO(valueOf, Integer.valueOf(q1().getMsgRecord().chatType))) {
            O1().setTextColor(ResourcesCompat.getColorStateList(this.context.getResources(), R.color.qui_common_text_secondary, this.context.getTheme()));
            O1().setLinkTextColor(ResourcesCompat.getColorStateList(this.context.getResources(), R.color.qui_common_text_link, this.context.getTheme()));
        }
        O1().setText(IQQTextApi.a.c((IQQTextApi) companion.a(IQQTextApi.class), q1().r2(), 21, 17, null, null, 24, null), TextView.BufferType.SPANNABLE);
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            AIOMsgTextView O1 = O1();
            String spannableStringBuilder = q1().r2().toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "mCurrentMsgItem.tipsContent.toString()");
            replace$default = StringsKt__StringsJVMKt.replace$default(spannableStringBuilder, "icon", "", false, 4, (Object) null);
            O1.setContentDescription(replace$default);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public AIOMsgTextView c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOMsgTextView) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return O1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        this.hasBind = true;
        if (!P1(payloads)) {
            return;
        }
        GrayTipsMsgItem grayTipsMsgItem = (GrayTipsMsgItem) msgItem;
        J1(grayTipsMsgItem);
        S1();
        FrameworkVM mUIModel = getMUIModel();
        Intrinsics.checkNotNull(mUIModel, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.graptips.common.CommonGrayTipsVM");
        ((c) mUIModel).B(grayTipsMsgItem);
        if (!grayTipsMsgItem.s2()) {
            grayTipsMsgItem.y2(true);
            L1();
            this.mReportParams.put("small_gray_service_id", Long.valueOf(q1().m2()));
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_small_gray", this.mReportParams);
            com.tencent.qqnt.graytips.util.d.f356912a.e(O1(), q1().m2());
        }
        this.lastAIOMsgItem = grayTipsMsgItem;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof CommonGrayTipState.TextChangedState) {
            O1().setText(IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), q1().r2(), 21, 17, null, null, 24, null), TextView.BufferType.SPANNABLE);
        } else if (state instanceof AIOMsgItemUIState.GrayTipsNavigationFail) {
            String qqStr = HardCodeUtil.qqStr(R.string.f170224yr2);
            new HashMap().put("small_gray_service_id", Long.valueOf(q1().m2()));
            com.tencent.mobileqq.aio.utils.b.q("em_bas_small_gray_bar_exception_toast", this.mReportParams);
            QQToast.makeText(getMContext(), 1, qqStr, 0).show();
        }
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        GrayTipsMsgItem D1 = D1();
        if (D1 != null) {
            D1.y2(false);
        }
        if (this.hasBind) {
            R1(q1());
            this.hasBind = false;
        }
        this.aioAbility = null;
        this.lastAIOMsgItem = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (Q1()) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new af(getMContext(), q1(), this));
            return listOf;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
