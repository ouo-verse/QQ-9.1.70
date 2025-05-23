package com.tencent.mobileqq.aio.msg;

import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.decoder.json.a;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b&\u0018\u0000 e2\u00020\u0001:\u0001fB\u000f\u0012\u0006\u0010b\u001a\u00020\b\u00a2\u0006\u0004\bc\u0010dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001d\u001a\u00020\rR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u00104\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R4\u00109\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010,2\u000e\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010,8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b7\u0010/\u001a\u0004\b8\u00101R\"\u0010@\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010O\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010S\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010J\u001a\u0004\bQ\u0010L\"\u0004\bR\u0010NR\"\u0010W\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010C\u001a\u0004\bU\u0010E\"\u0004\bV\u0010GR\u0016\u0010X\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010;R\"\u0010\\\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010;\u001a\u0004\bZ\u0010=\"\u0004\b[\u0010?R\u001d\u0010a\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/GrayTipsMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "k2", "", "w2", "u2", "v2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "newMsgItem", "l", "", "e2", "isSelf", "getViewType", "X0", "t2", "", "f1", "Lcom/tencent/aio/data/msglist/a;", "target", "Lkotlin/Pair;", "o", "", "getChangePayload", FaceUtil.IMG_TEMP, "y2", ICustomDataEditor.STRING_PARAM_2, "Landroid/text/SpannableStringBuilder;", "W0", "Landroid/text/SpannableStringBuilder;", "r2", "()Landroid/text/SpannableStringBuilder;", "setTipsContent", "(Landroid/text/SpannableStringBuilder;)V", "tipsContent", "I", "getGravity", "()I", "setGravity", "(I)V", LayoutAttrDefine.Gravity.Gravity, "", "Landroid/text/style/ClickableSpan;", "Y0", "Ljava/util/List;", "j2", "()Ljava/util/List;", "x2", "(Ljava/util/List;)V", "clickableSpans", "Lcom/tencent/qqnt/graytips/span/b;", "<set-?>", "Z0", "i2", "aioInteractions", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Z", "l2", "()Z", "z2", "(Z)V", "hasInjectAIOAbility", "", "b1", "J", "getTempId", "()J", "setTempId", "(J)V", "tempId", "c1", "Ljava/lang/String;", "q2", "()Ljava/lang/String;", "setPaiYiPaiToUid", "(Ljava/lang/String;)V", "paiYiPaiToUid", "d1", "p2", "setPaiYiPaiFromUid", "paiYiPaiFromUid", "e1", "m2", "setMBusId", "mBusId", "exported", "g1", "o2", NowProxyConstants.AccountInfoKey.A2, "mRevokeCanEdit", "h1", "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_2, "()Ljava/lang/Integer;", "mGrayTipType", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "i1", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class GrayTipsMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: i1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private SpannableStringBuilder tipsContent;

    /* renamed from: X0, reason: from kotlin metadata */
    private int gravity;

    /* renamed from: Y0, reason: from kotlin metadata */
    @Nullable
    private List<? extends ClickableSpan> clickableSpans;

    /* renamed from: Z0, reason: from kotlin metadata */
    @Nullable
    private List<? extends com.tencent.qqnt.graytips.span.b> aioInteractions;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private boolean hasInjectAIOAbility;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private long tempId;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String paiYiPaiToUid;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String paiYiPaiFromUid;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    private long mBusId;

    /* renamed from: f1, reason: collision with root package name and from kotlin metadata */
    private boolean exported;

    /* renamed from: g1, reason: collision with root package name and from kotlin metadata */
    private boolean mRevokeCanEdit;

    /* renamed from: h1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mGrayTipType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/GrayTipsMsgItem$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.GrayTipsMsgItem$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57180);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrayTipsMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
            return;
        }
        this.tipsContent = new SpannableStringBuilder();
        this.gravity = 17;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.aio.msg.GrayTipsMsgItem$mGrayTipType$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GrayTipsMsgItem.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                GrayTipElement grayTipElement;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MsgElement firstTypeElement = GrayTipsMsgItem.this.getFirstTypeElement(8);
                if (firstTypeElement == null || (grayTipElement = firstTypeElement.grayTipElement) == null) {
                    return null;
                }
                return Integer.valueOf(grayTipElement.subElementType);
            }
        });
        this.mGrayTipType = lazy;
    }

    private final int k2() {
        boolean z16 = true;
        int i3 = !isSelf() ? 1 : 0;
        Integer n26 = n2();
        if (n26 != null && n26.intValue() == 1) {
            return 50;
        }
        if (n26 == null || n26.intValue() != 12) {
            if ((n26 == null || n26.intValue() != 17) && (n26 == null || n26.intValue() != 17)) {
                z16 = false;
            }
            if (!z16 && ((n26 == null || n26.intValue() != 14) && ((n26 == null || n26.intValue() != 4) && ((n26 == null || n26.intValue() != 10) && (n26 == null || n26.intValue() != 15))))) {
                return i3;
            }
        }
        return 56;
    }

    private final Integer n2() {
        return (Integer) this.mGrayTipType.getValue();
    }

    private final void u2() {
        GrayTipElement grayTipElement;
        JsonGrayElement jsonGrayElement;
        MsgElement firstTypeElement = getFirstTypeElement(8);
        if (firstTypeElement != null && (grayTipElement = firstTypeElement.grayTipElement) != null && (jsonGrayElement = grayTipElement.jsonGrayTipElement) != null) {
            this.mBusId = jsonGrayElement.busiId;
            a.b d16 = com.tencent.qqnt.graytips.decoder.json.a.f356837a.d(jsonGrayElement);
            if (d16 != null) {
                this.tipsContent = d16.c();
                this.gravity = d16.d();
                this.clickableSpans = d16.b();
                this.aioInteractions = d16.a();
            }
        }
    }

    private final void v2() {
        GrayTipElement grayTipElement;
        MsgElement firstTypeElement = getFirstTypeElement(8);
        if (firstTypeElement != null && (grayTipElement = firstTypeElement.grayTipElement) != null) {
            Intrinsics.checkNotNullExpressionValue(grayTipElement, "grayTipElement");
            RevokeElement revokeElement = grayTipElement.revokeElement;
            if (revokeElement != null) {
                Intrinsics.checkNotNullExpressionValue(revokeElement, "revokeElement");
                com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.g gVar = com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.g.f190901a;
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.tipsContent = gVar.f(this, revokeElement, context);
            }
        }
    }

    private final void w2() {
        long longValue;
        MsgElement firstTypeElement = getFirstTypeElement(8);
        if (firstTypeElement == null) {
            return;
        }
        Long l3 = firstTypeElement.grayTipElement.xmlElement.templId;
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        this.tempId = longValue;
        this.mBusId = firstTypeElement.grayTipElement.xmlElement.busiId;
        com.tencent.qqnt.graytips.decoder.d g16 = com.tencent.qqnt.graytips.decoder.xml.a.g(MobileQQ.sMobileQQ.peekAppRuntime(), firstTypeElement.grayTipElement, getMsgRecord().senderUid, v().chatType, getMsgRecord().msgType, getMsgRecord().peerUid);
        if (g16 != null) {
            SpannableStringBuilder e16 = g16.e();
            Intrinsics.checkNotNullExpressionValue(e16, "it.tipsContent");
            this.tipsContent = e16;
            this.gravity = g16.b();
            this.clickableSpans = g16.a();
            this.aioInteractions = g16.f356831d;
            this.paiYiPaiToUid = g16.d();
            this.paiYiPaiFromUid = g16.c();
        }
    }

    public final void A2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.mRevokeCanEdit = z16;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        super.X0();
        try {
            t2();
        } catch (Exception e16) {
            if (com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                QLog.e("GrayTipsMsgItem", 1, "parse " + e16);
                return;
            }
            throw new RuntimeException(e16);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 21, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new GrayTipsMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        String spannableStringBuilder = this.tipsContent.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "tipsContent.toString()");
        return spannableStringBuilder;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        HashMap hashMap;
        GrayTipsMsgItem grayTipsMsgItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return iPatchRedirector.redirect((short) 30, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Object changePayload = super.getChangePayload(target);
        if (changePayload instanceof HashMap) {
            hashMap = (HashMap) changePayload;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        if (target instanceof GrayTipsMsgItem) {
            grayTipsMsgItem = (GrayTipsMsgItem) target;
        } else {
            grayTipsMsgItem = null;
        }
        if (grayTipsMsgItem != null && this != grayTipsMsgItem) {
            hashMap.put(AIOMsgItemPayloadType.GRAY_TIP_CONTENT_PAYLOAD, a.t.f192673a);
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return k2();
    }

    @Nullable
    public final List<com.tencent.qqnt.graytips.span.b> i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.aioInteractions;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSelf() {
        boolean equals$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (com.tencent.mobileqq.aio.utils.d.J(this) && this.paiYiPaiFromUid != null) {
            equals$default = StringsKt__StringsJVMKt.equals$default(this.paiYiPaiFromUid, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid(), false, 2, null);
            return equals$default;
        }
        return super.isSelf();
    }

    @Nullable
    public final List<ClickableSpan> j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.clickableSpans;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        if (!(newMsgItem instanceof GrayTipsMsgItem)) {
            return;
        }
        GrayTipsMsgItem grayTipsMsgItem = (GrayTipsMsgItem) newMsgItem;
        grayTipsMsgItem.tipsContent = this.tipsContent;
        grayTipsMsgItem.gravity = this.gravity;
        grayTipsMsgItem.clickableSpans = this.clickableSpans;
        grayTipsMsgItem.aioInteractions = this.aioInteractions;
        grayTipsMsgItem.hasInjectAIOAbility = this.hasInjectAIOAbility;
        grayTipsMsgItem.tempId = this.tempId;
        grayTipsMsgItem.paiYiPaiToUid = this.paiYiPaiToUid;
        grayTipsMsgItem.paiYiPaiFromUid = this.paiYiPaiFromUid;
        grayTipsMsgItem.mBusId = this.mBusId;
        grayTipsMsgItem.exported = this.exported;
        grayTipsMsgItem.mRevokeCanEdit = this.mRevokeCanEdit;
    }

    public final boolean l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.hasInjectAIOAbility;
    }

    public final long m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.mBusId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Pair) iPatchRedirector.redirect((short) 29, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (this != ((GrayTipsMsgItem) target)) {
            return new Pair<>(Boolean.FALSE, "this");
        }
        return super.o(target);
    }

    public final boolean o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.mRevokeCanEdit;
    }

    @Nullable
    public final String p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.paiYiPaiFromUid;
    }

    @Nullable
    public final String q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.paiYiPaiToUid;
    }

    @NotNull
    public final SpannableStringBuilder r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tipsContent;
    }

    public final boolean s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        return this.exported;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0121, code lost:
    
        if (r2 != false) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t2() {
        String str;
        GrayTipElement grayTipElement;
        boolean z16;
        boolean z17;
        boolean endsWith$default;
        boolean endsWith$default2;
        com.tencent.qqnt.graytips.action.f fVar;
        com.tencent.qqnt.graytips.action.f fVar2;
        com.tencent.qqnt.graytips.action.k kVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        Integer n26 = n2();
        if (n26 != null && n26.intValue() == 12) {
            w2();
            str = "XML";
        } else {
            Integer n27 = n2();
            if (n27 != null && n27.intValue() == 17) {
                u2();
                str = "Json";
            } else {
                Integer n28 = n2();
                if (n28 != null && n28.intValue() == 1) {
                    v2();
                    str = "revoke";
                } else {
                    MsgElement firstTypeElement = getFirstTypeElement(8);
                    if (firstTypeElement != null && (grayTipElement = firstTypeElement.grayTipElement) != null) {
                        h.a a16 = zw3.a.a(grayTipElement);
                        SpannableStringBuilder spannableStringBuilder = a16.f356916a;
                        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "result.ssbContent");
                        this.tipsContent = spannableStringBuilder;
                        this.clickableSpans = a16.f356917b;
                        this.aioInteractions = a16.f356918c;
                        this.gravity = 17;
                    }
                    str = "FirstType";
                }
            }
        }
        List<? extends ClickableSpan> list = this.clickableSpans;
        if (list != null) {
            for (ClickableSpan clickableSpan : list) {
                if (clickableSpan instanceof com.tencent.qqnt.graytips.span.a) {
                    com.tencent.qqnt.graytips.span.a aVar = (com.tencent.qqnt.graytips.span.a) clickableSpan;
                    com.tencent.qqnt.graytips.c b16 = aVar.b();
                    if (b16 != null) {
                        fVar = b16.actionInfo;
                    } else {
                        fVar = null;
                    }
                    if (fVar != null) {
                        aVar.e(this.mBusId);
                        com.tencent.qqnt.graytips.c b17 = aVar.b();
                        if (b17 != null) {
                            fVar2 = b17.actionInfo;
                        } else {
                            fVar2 = null;
                        }
                        if (fVar2 instanceof com.tencent.qqnt.graytips.action.k) {
                            kVar = (com.tencent.qqnt.graytips.action.k) fVar2;
                        } else {
                            kVar = null;
                        }
                        if (kVar != null) {
                            kVar.c(getMsgRecord().msgTime);
                        }
                    }
                }
            }
        }
        SpannableStringBuilder spannableStringBuilder2 = this.tipsContent;
        com.tencent.qqnt.graytips.span.a[] spans = (com.tencent.qqnt.graytips.span.a[]) spannableStringBuilder2.getSpans(spannableStringBuilder2.length() - 1, this.tipsContent.length(), com.tencent.qqnt.graytips.span.a.class);
        SpannableStringBuilder spannableStringBuilder3 = this.tipsContent;
        ImageSpan[] imageSpans = (ImageSpan[]) spannableStringBuilder3.getSpans(spannableStringBuilder3.length() - 1, this.tipsContent.length(), ImageSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "spans");
        if (spans.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(imageSpans, "imageSpans");
            if (imageSpans.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) this.tipsContent, (CharSequence) "\u3002", false, 2, (Object) null);
                if (!endsWith$default) {
                    endsWith$default2 = StringsKt__StringsKt.endsWith$default((CharSequence) this.tipsContent, (CharSequence) ".", false, 2, (Object) null);
                }
                SpannableStringBuilder spannableStringBuilder4 = this.tipsContent;
                spannableStringBuilder4.delete(spannableStringBuilder4.length() - 1, this.tipsContent.length());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("GrayTipsMsgItem", 2, "parse GrayTip content len=" + this.tipsContent.length() + " busid=" + this.mBusId + " grayType " + str + " tipsContent=" + ((Object) AIOUtil.f194084a.o(this.tipsContent)));
        }
    }

    public final void x2(@Nullable List<? extends ClickableSpan> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.clickableSpans = list;
        }
    }

    public final void y2(boolean temp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, temp);
        } else {
            this.exported = temp;
        }
    }

    public final void z2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.hasInjectAIOAbility = z16;
        }
    }
}
