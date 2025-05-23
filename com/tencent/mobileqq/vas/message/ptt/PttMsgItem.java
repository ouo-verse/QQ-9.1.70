package com.tencent.mobileqq.vas.message.ptt;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\tR\u001b\u0010\u0012\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vas/message/ptt/PttMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "l2", "", "o2", ICustomDataEditor.NUMBER_PARAM_2, "", "p2", "", ICustomDataEditor.STRING_PARAM_2, "q2", "i2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "W0", "Lkotlin/Lazy;", "j2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "X0", "m2", "()Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "pttElement", "", "Y0", UserInfo.SEX_FEMALE, "k2", "()F", "r2", "(F)V", "playProgress", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "Z0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PttMsgItem extends AIOMsgItem {

    /* renamed from: W0, reason: from kotlin metadata */
    private final Lazy msgElement;

    /* renamed from: X0, reason: from kotlin metadata */
    private final Lazy pttElement;

    /* renamed from: Y0, reason: from kotlin metadata */
    private float playProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PttMsgItem(MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.vas.message.ptt.PttMsgItem$msgElement$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MsgElement invoke() {
                MsgElement firstTypeElement = PttMsgItem.this.getFirstTypeElement(4);
                Intrinsics.checkNotNull(firstTypeElement);
                return firstTypeElement;
            }
        });
        this.msgElement = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PttElement>() { // from class: com.tencent.mobileqq.vas.message.ptt.PttMsgItem$pttElement$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PttElement invoke() {
                return PttMsgItem.this.j2().pttElement;
            }
        });
        this.pttElement = lazy2;
    }

    public final void i2() {
        String n26 = n2();
        if (!(!new File(n26).exists())) {
            n26 = null;
        }
        if (n26 != null) {
            RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
            richMediaElementGetReq.msgId = getMsgRecord().msgId;
            richMediaElementGetReq.peerUid = getMsgRecord().peerUid;
            richMediaElementGetReq.chatType = getMsgRecord().chatType;
            richMediaElementGetReq.elementId = j2().elementId;
            richMediaElementGetReq.downloadType = 1;
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.getRichMediaElement(richMediaElementGetReq);
            }
        }
    }

    public final MsgElement j2() {
        return (MsgElement) this.msgElement.getValue();
    }

    /* renamed from: k2, reason: from getter */
    public final float getPlayProgress() {
        return this.playProgress;
    }

    public final int l2() {
        return m2().duration * 1000;
    }

    public final PttElement m2() {
        Object value = this.pttElement.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pttElement>(...)");
        return (PttElement) value;
    }

    public final String n2() {
        String d16 = aj.d(m2());
        return d16 == null ? "" : d16;
    }

    public final String o2() {
        return String.valueOf(getMsgRecord().senderUin);
    }

    public final boolean p2() {
        Integer num = m2().playState;
        return num != null && num.intValue() == 1;
    }

    public final boolean q2() {
        File file = new File(n2());
        return file.exists() && file.length() > 0;
    }

    public final void r2(float f16) {
        this.playProgress = f16;
    }

    public final void s2() {
        m2().playState = 1;
    }
}
