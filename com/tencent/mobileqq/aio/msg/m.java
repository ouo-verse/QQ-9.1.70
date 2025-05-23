package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.LongMsgAttr;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001H\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0006\u0010\u0016\u001a\u00020\u0013R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/m;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Landroid/content/Context;", "context", "", "Y0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "newMsgItem", "l", "Lcom/tencent/aio/data/msglist/a;", "target", "Lkotlin/Pair;", "", "", "o", "", "getChangePayload", "", "getViewType", "e2", "j2", "W0", "I", "i2", "()I", "k2", "(I)V", "fetchFlag", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "X0", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class m extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    private int fetchFlag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/m$a;", "", "", "FETCH_FLAG_EXPIRED", "I", "FETCH_FLAG_FAIL", "FETCH_FLAG_INIT", "FETCH_FLAG_LOADING", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.m$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        } else {
            this.fetchFlag = -1;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        LongMsgAttr longMsgAttr;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        if (context != null) {
            Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        }
        MsgAttributeInfo msgAttributeInfo = getMsgRecord().msgAttrs.get(8);
        boolean z16 = false;
        if (msgAttributeInfo != null && (longMsgAttr = msgAttributeInfo.longMsgAttr) != null && (num = longMsgAttr.fetchLongMsgErrCode) != null && num.intValue() == 196) {
            z16 = true;
        }
        if (z16) {
            this.fetchFlag = 3;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 5, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new m(getMsgRecord());
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        HashMap hashMap;
        m mVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) target);
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
        if (target instanceof m) {
            mVar = (m) target;
        } else {
            mVar = null;
        }
        if (mVar != null && this.fetchFlag != mVar.fetchFlag) {
            hashMap.put(AIOMsgItemPayloadType.LONGMSG_FETCH_FAIL, a.w.f192676a);
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 86;
        }
        return 87;
    }

    public final int i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.fetchFlag;
    }

    public final int j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = this.fetchFlag;
        if (i3 != 2) {
            if (i3 != 3) {
                return R.string.yrm;
            }
            return R.string.yrk;
        }
        return R.string.yrl;
    }

    public final void k2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.fetchFlag = i3;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        m mVar = (m) newMsgItem;
        if (mVar.fetchFlag != 3) {
            mVar.fetchFlag = this.fetchFlag;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Pair) iPatchRedirector.redirect((short) 7, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (this.fetchFlag != ((m) target).fetchFlag) {
            return new Pair<>(Boolean.FALSE, "fetchFlagChange");
        }
        return super.o(target);
    }
}
