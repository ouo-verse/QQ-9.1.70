package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u0000 ;2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u00108\u001a\u00020\u0006\u00a2\u0006\u0004\b9\u0010:J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016R.\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00104\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\u0011\u00107\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/aio/msg/e;", "Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem;", "Lkotlin/Pair;", "", "F2", "getViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b0", "newMsgItem", "", "l", "Landroid/content/Context;", "context", "Y0", "viewType", "getSubViewType", "Lcom/tencent/aio/data/msglist/a;", "target", "", "", "o", "", "getChangePayload", "z2", "e2", "Z0", "Lkotlin/Pair;", "J2", "()Lkotlin/Pair;", "setSize", "(Lkotlin/Pair;)V", "size", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Z", "I2", "()Z", "M2", "(Z)V", "showChainIcon", "", "b1", "J", "getLastMsgSeq", "()J", "L2", "(J)V", "lastMsgSeq", "c1", Constants.MMCCID, "K2", "canPlaySurprise", "H2", "()I", "chainCount", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "d1", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends AniStickerMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e1, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, Integer> f190168e1;

    /* renamed from: Z0, reason: from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> size;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private boolean showChainIcon;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private long lastMsgSeq;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    private boolean canPlaySurprise;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R0\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/e$a;", "", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sSubViewTypeMap", "Ljava/util/HashMap;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57145);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
            f190168e1 = new HashMap<>();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        } else {
            this.size = F2();
        }
    }

    private final Pair<Integer, Integer> F2() {
        AniStickerInfo s26 = s2();
        if (s26 != null) {
            return defpackage.a.f25157a.a(s26);
        }
        return defpackage.a.f25157a.b();
    }

    public final boolean G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.canPlaySurprise;
    }

    public final int H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        Integer num = l2().chainCount;
        Intrinsics.checkNotNullExpressionValue(num, "faceElement.chainCount");
        return num.intValue();
    }

    public final boolean I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.showChainIcon;
    }

    @NotNull
    public final Pair<Integer, Integer> J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.size;
    }

    public final void K2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.canPlaySurprise = z16;
        }
    }

    public final void L2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.lastMsgSeq = j3;
        }
    }

    public final void M2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.showChainIcon = z16;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AniStickerMsgItem, com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) context);
        } else {
            super.Y0(context);
            this.size = F2();
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AniStickerMsgItem, com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 12, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new e(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AniStickerMsgItem, com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @NotNull
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        Map map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return iPatchRedirector.redirect((short) 17, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        Object changePayload = super.getChangePayload(target);
        boolean z16 = changePayload instanceof Map;
        if (z16) {
            if (z16) {
                map = (Map) changePayload;
            } else {
                map = null;
            }
            if (map != null) {
                hashMap.putAll(map);
            }
        }
        if (!(target instanceof e)) {
            QLog.i("ChainAniStickerMsgItem", 1, "getChangePayload  target is not ChainAniStickerMsgItem, msgId is " + target.getMsgId());
            return hashMap;
        }
        e eVar = (e) target;
        if (eVar.showChainIcon != this.showChainIcon || eVar.H2() != H2()) {
            hashMap.put(AIOMsgItemPayloadType.CHAIN_FLAG_CHANGE, a.j.f192663a);
        }
        return hashMap;
    }

    public final long getLastMsgSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.lastMsgSeq;
    }

    @Override // com.tencent.aio.data.msglist.a
    public int getSubViewType(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, viewType)).intValue();
        }
        String str = this.size.getFirst() + "_" + this.size.getSecond();
        HashMap<String, Integer> hashMap = f190168e1;
        Integer num = hashMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        int size = hashMap.size() + 1;
        hashMap.put(str, Integer.valueOf(size));
        return size;
    }

    @Override // com.tencent.mobileqq.aio.msg.AniStickerMsgItem, com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 93;
        }
        return 94;
    }

    @Override // com.tencent.mobileqq.aio.msg.AniStickerMsgItem, com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        e eVar = (e) newMsgItem;
        eVar.size = this.size;
        eVar.showChainIcon = this.showChainIcon;
        eVar.lastMsgSeq = this.lastMsgSeq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Pair) iPatchRedirector.redirect((short) 16, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof e) {
            eVar = (e) target;
        } else {
            eVar = null;
        }
        if (eVar != null && eVar.showChainIcon != this.showChainIcon) {
            return new Pair<>(Boolean.FALSE, "showChainIcon");
        }
        return super.o(target);
    }

    @Override // com.tencent.mobileqq.aio.msg.AniStickerMsgItem
    public void z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            A2(com.tencent.qqnt.aio.anisticker.view.e.f348849a.h(n2(), q2(), t2()));
        }
    }
}
