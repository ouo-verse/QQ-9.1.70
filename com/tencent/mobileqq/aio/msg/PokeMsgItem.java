package com.tencent.mobileqq.aio.msg;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.aa;
import com.tencent.mobileqq.aio.utils.ar;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 =2\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010:\u001a\u00020\u0004\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010-\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010/\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u0011\u00102\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010*R\u0011\u00105\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00107\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b6\u00104R\u0011\u00109\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b8\u00104\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/PokeMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "t2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "x2", "", "r2", "", "f1", "e2", "", "getViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "W0", "Lkotlin/Lazy;", "l2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "X0", "k2", "()Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/aa;", "Y0", "m2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/aa;", "msgExtInfo", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/CustomFrameAnimationDrawable$b;", "Z0", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/CustomFrameAnimationDrawable$b;", "frameState", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeGreatMoveView$h;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeGreatMoveView$h;", "unlimitedState", "b1", "Z", "q2", "()Z", "w2", "(Z)V", "isLastPokeMessage", "c1", "isFake", "v2", ICustomDataEditor.STRING_PARAM_2, "isPlayed", "o2", "()I", "pokeType", "p2", "vasPokeId", ICustomDataEditor.NUMBER_PARAM_2, "pokeStrength", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "d1", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PokeMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e1, reason: collision with root package name */
    private static final int f190062e1;

    /* renamed from: f1, reason: collision with root package name */
    private static final int f190063f1;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgElement;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy faceElement;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgExtInfo;

    /* renamed from: Z0, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public CustomFrameAnimationDrawable.b frameState;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public AIOPokeGreatMoveView.h unlimitedState;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private boolean isLastPokeMessage;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    private boolean isFake;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/PokeMsgItem$a;", "", "", "MAX_STRENGTH", "I", "POKE_FLAG_BREAKING_ICE_FRD_NEW", "POKE_FLAG_BREAKING_ICE_FRD_OLD", "POKE_TYPE_APPROVE", "POKE_TYPE_GIVING_HEART", "POKE_TYPE_GREAT_MOVE", "POKE_TYPE_HEART_BREAK", "POKE_TYPE_HI_TOGETHER", "POKE_TYPE_POKE", "POKE_TYPE_POKE_OLD", "POKE_TYPE_VAS_POKE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.PokeMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        INSTANCE = new Companion(null);
        f190062e1 = 1;
        f190063f1 = 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PokeMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.aio.msg.PokeMsgItem$msgElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PokeMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final MsgElement invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (MsgElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    MsgElement firstTypeElement = PokeMsgItem.this.getFirstTypeElement(6);
                    Intrinsics.checkNotNull(firstTypeElement);
                    return firstTypeElement;
                }
            });
            this.msgElement = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FaceElement>() { // from class: com.tencent.mobileqq.aio.msg.PokeMsgItem$faceElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PokeMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final FaceElement invoke() {
                    MsgElement l26;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FaceElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    l26 = PokeMsgItem.this.l2();
                    return l26.faceElement;
                }
            });
            this.faceElement = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.aio.msglist.holder.component.poke.aa>() { // from class: com.tencent.mobileqq.aio.msg.PokeMsgItem$msgExtInfo$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PokeMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.aio.msglist.holder.component.poke.aa invoke() {
                    MsgElement l26;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.aio.msglist.holder.component.poke.aa) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    aa.Companion companion = com.tencent.mobileqq.aio.msglist.holder.component.poke.aa.INSTANCE;
                    l26 = PokeMsgItem.this.l2();
                    return companion.a(l26.extBufForUI);
                }
            });
            this.msgExtInfo = lazy3;
            this.frameState = new CustomFrameAnimationDrawable.b();
            this.unlimitedState = new AIOPokeGreatMoveView.h();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MsgElement l2() {
        return (MsgElement) this.msgElement.getValue();
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.poke.aa m2() {
        return (com.tencent.mobileqq.aio.msglist.holder.component.poke.aa) this.msgExtInfo.getValue();
    }

    private final void t2() {
        MsgElement l26 = l2();
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.updateElementExtBufForUI(new Contact(p0(), r0(), ""), q0(), l26.elementId, m2().c(), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.q
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    PokeMsgItem.u2(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(int i3, String str) {
        if (i3 != 0) {
            QLog.w("PokeMsgItem", 1, "[serializeExtInfo] fail, err=" + i3 + ", " + str);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new PokeMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        String b16 = ar.b(ar.f194115a, k2(), false, 2, null);
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ypd) + HardCodeUtil.qqStr(R.string.yp7) + b16;
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.yp7) + b16;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 68;
        }
        return 67;
    }

    @NotNull
    public final FaceElement k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (FaceElement) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Object value = this.faceElement.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-faceElement>(...)");
        return (FaceElement) value;
    }

    public final int n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        Integer num = k2().pokeStrength;
        Intrinsics.checkNotNullExpressionValue(num, "faceElement.pokeStrength");
        return num.intValue();
    }

    public final int o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        Integer num = k2().pokeType;
        Intrinsics.checkNotNullExpressionValue(num, "faceElement.pokeType");
        return num.intValue();
    }

    public final int p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        Integer num = k2().vaspokeId;
        Intrinsics.checkNotNullExpressionValue(num, "faceElement.vaspokeId");
        return num.intValue();
    }

    public final boolean q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isLastPokeMessage;
    }

    public final boolean r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (n2() == 3) {
            return true;
        }
        return false;
    }

    public final boolean s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return m2().a();
    }

    public final void v2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.isFake = z16;
        }
    }

    public final void w2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isLastPokeMessage = z16;
        }
    }

    public final void x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (!s2()) {
            m2().b(true);
            if (!this.isFake) {
                t2();
            }
        }
    }
}
