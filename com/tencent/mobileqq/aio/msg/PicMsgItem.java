package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 @2\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010=\u001a\u00020\u0002\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u001b\u0010\u001f\u001a\u00020\u001b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R.\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010/R\u001b\u00104\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/PicMsgItem;", "Lcom/tencent/mobileqq/aio/msg/w;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b0", "newMsgItem", "", "l", "Landroid/content/Context;", "context", "Y0", "", "f1", ICustomDataEditor.NUMBER_PARAM_2, "", ICustomDataEditor.STRING_PARAM_2, "Lcom/tencent/aio/data/msglist/a;", "target", "Lkotlin/Pair;", "o", "", "getChangePayload", "J0", "", "getViewType", "f2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/Lazy;", "o2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "Z0", "p2", "()Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lkotlin/Pair;", "getThumbSize", "()Lkotlin/Pair;", "setThumbSize", "(Lkotlin/Pair;)V", "thumbSize", "Lcom/tencent/mobileqq/aio/msglist/holder/component/flashpic/c;", "b1", "m2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/flashpic/c;", "flashPicExtInfo", "c1", "r2", "()Ljava/lang/String;", "progressViewKey", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "d1", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "q2", "()Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "t2", "(Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;)V", "preDownloadSize", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "e1", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PicMsgItem extends w {
    static IPatchRedirector $redirector_;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    private final Lazy msgElement;

    /* renamed from: Z0, reason: from kotlin metadata */
    @NotNull
    private final Lazy picElement;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> thumbSize;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy flashPicExtInfo;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy progressViewKey;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    public PicSize preDownloadSize;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/PicMsgItem$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.PicMsgItem$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57267);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicMsgItem(@NotNull final MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.aio.msg.PicMsgItem$msgElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicMsgItem.this);
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
                    MsgElement firstTypeElement = PicMsgItem.this.getFirstTypeElement(2);
                    Intrinsics.checkNotNull(firstTypeElement);
                    return firstTypeElement;
                }
            });
            this.msgElement = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PicElement>() { // from class: com.tencent.mobileqq.aio.msg.PicMsgItem$picElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PicElement invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? PicMsgItem.this.o2().picElement : (PicElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.picElement = lazy2;
            this.thumbSize = com.tencent.mobileqq.aio.msglist.holder.base.util.f.b(p2());
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.aio.msglist.holder.component.flashpic.c>() { // from class: com.tencent.mobileqq.aio.msg.PicMsgItem$flashPicExtInfo$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicMsgItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.aio.msglist.holder.component.flashpic.c invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.mobileqq.aio.msglist.holder.component.flashpic.c.INSTANCE.a(PicMsgItem.this.o2().extBufForUI) : (com.tencent.mobileqq.aio.msglist.holder.component.flashpic.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.flashPicExtInfo = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.aio.msg.PicMsgItem$progressViewKey$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgRecord.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    MsgRecord msgRecord2 = MsgRecord.this;
                    return msgRecord2.peerUid + "_" + msgRecord2.msgId;
                }
            });
            this.progressViewKey = lazy4;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
    }

    private final com.tencent.mobileqq.aio.msglist.holder.component.flashpic.c m2() {
        return (com.tencent.mobileqq.aio.msglist.holder.component.flashpic.c) this.flashPicExtInfo.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean J0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (MsgExtKt.u(p2()) && p0() == 100) {
            return true;
        }
        return super.J0();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        } else {
            t2(com.tencent.qqnt.aio.predownload.pic.stragegy.a.f351808a.a(this, o2()));
            super.Y0(context);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 9, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new PicMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ypd) + HardCodeUtil.qqStr(R.string.yp6);
        }
        if (com.tencent.mobileqq.aio.utils.d.s(this)) {
            return getMsgRecord().anonymousExtInfo.anonymousNick + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.yp6);
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.yp6);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (!MsgExtKt.a0(p2()) && !MsgExtKt.o(p2())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        HashMap hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return iPatchRedirector.redirect((short) 16, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Object changePayload = super.getChangePayload(target);
        if (changePayload instanceof HashMap) {
            hashMap = (HashMap) changePayload;
        } else {
            hashMap = null;
        }
        if (hashMap != null && (target instanceof PicMsgItem)) {
            PicMsgItem picMsgItem = (PicMsgItem) target;
            if (this.thumbSize.getFirst().intValue() != picMsgItem.thumbSize.getFirst().intValue() && this.thumbSize.getSecond().intValue() != picMsgItem.thumbSize.getSecond().intValue()) {
                return null;
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        if (com.tencent.mobileqq.aio.utils.d.y(this)) {
            if (isSelf()) {
                return 84;
            }
            return 85;
        }
        if (isSelf()) {
            return 5;
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.aio.msg.w, com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        PicMsgItem picMsgItem = (PicMsgItem) newMsgItem;
        picMsgItem.t2(q2());
        picMsgItem.thumbSize = this.thumbSize;
    }

    @NotNull
    public final String n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        int i3 = p2().picSubType;
        if (MsgExtKt.v(i3)) {
            if ((i3 == 1 || i3 == 4 || i3 == 7) && !TextUtils.isEmpty(p2().summary)) {
                return HardCodeUtil.qqStr(R.string.f170197yp0) + p2().summary;
            }
            String qqStr = HardCodeUtil.qqStr(R.string.ypo);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.aio_emo_pic_msg)");
            return qqStr;
        }
        String qqStr2 = HardCodeUtil.qqStr(R.string.yp6);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.aio_chat_picture)");
        return qqStr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Pair) iPatchRedirector.redirect((short) 15, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Pair<Boolean, String> o16 = super.o(target);
        if (!o16.getFirst().booleanValue()) {
            return o16;
        }
        if (!(target instanceof PicMsgItem)) {
            return new Pair<>(Boolean.FALSE, "type not match");
        }
        PicMsgItem picMsgItem = (PicMsgItem) target;
        if (this.thumbSize.getFirst().intValue() != picMsgItem.thumbSize.getFirst().intValue() && this.thumbSize.getSecond().intValue() != picMsgItem.thumbSize.getSecond().intValue()) {
            return new Pair<>(Boolean.FALSE, "thumb Size change");
        }
        return new Pair<>(Boolean.TRUE, "");
    }

    @NotNull
    public final MsgElement o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgElement) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (MsgElement) this.msgElement.getValue();
    }

    @NotNull
    public final PicElement p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PicElement) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Object value = this.picElement.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-picElement>(...)");
        return (PicElement) value;
    }

    @NotNull
    public final PicSize q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (PicSize) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        PicSize picSize = this.preDownloadSize;
        if (picSize != null) {
            return picSize;
        }
        Intrinsics.throwUninitializedPropertyAccessException("preDownloadSize");
        return null;
    }

    @NotNull
    public final String r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (String) this.progressViewKey.getValue();
    }

    public final boolean s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        boolean a16 = m2().a();
        if (QLog.isColorLevel()) {
            QLog.d("PicMsgItem", 2, "has read flash pic: " + H());
        }
        return a16;
    }

    public final void t2(@NotNull PicSize picSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) picSize);
        } else {
            Intrinsics.checkNotNullParameter(picSize, "<set-?>");
            this.preDownloadSize = picSize;
        }
    }
}
