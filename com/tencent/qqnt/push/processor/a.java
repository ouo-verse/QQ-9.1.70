package com.tencent.qqnt.push.processor;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.push.TroopPushCMD;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import msf.msgcomm.nt_msg_common$Msg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x857.TroopTips0x857$NotifyMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u000b2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/push/processor/a;", "Lcom/tencent/qqnt/push/a;", "", "troopUin", "seq", "", "b", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgBuf", "", "a", "Ljava/util/Queue;", "", "Ljava/util/Queue;", "seqQueue", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements com.tencent.qqnt.push.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Queue<String> seqQueue;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/push/processor/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.push.processor.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.seqQueue = new LinkedList();
        }
    }

    private final boolean b(long troopUin, long seq) {
        String str = troopUin + "-" + seq;
        Iterator<String> it = this.seqQueue.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Troop0x2dcCommonProcessor", 2, "[tipsMsgFilterBySeq] flag in queue equals uniFlag:" + str);
                    return true;
                }
                return true;
            }
        }
        if (this.seqQueue.size() > 30) {
            this.seqQueue.poll();
        }
        this.seqQueue.offer(str);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.toByteArray(r18);
     */
    @Override // com.tencent.qqnt.push.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable ArrayList<Byte> msgBuf) {
        byte[] byteArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgBuf);
            return;
        }
        if (msgBuf != null && byteArray != null) {
            try {
                nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
                nt_msg_common_msg.mergeFrom(byteArray);
                if (!nt_msg_common_msg.body.msg_content.has()) {
                    return;
                }
                byte[] byteArray2 = nt_msg_common_msg.body.msg_content.get().toByteArray();
                if (byteArray2.length <= 7) {
                    return;
                }
                int length = byteArray2.length - 7;
                byte[] bArr = new byte[length];
                PkgTools.copyData(bArr, 0, byteArray2, 7, length);
                long j3 = nt_msg_common_msg.content_head.msg_seq.get();
                long j16 = nt_msg_common_msg.content_head.msg_time.get();
                TroopTips0x857$NotifyMsgBody mergeFrom = new TroopTips0x857$NotifyMsgBody().mergeFrom(bArr);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "notifyMsgBody.mergeFrom(realMsgBuf)");
                TroopTips0x857$NotifyMsgBody troopTips0x857$NotifyMsgBody = mergeFrom;
                int i3 = troopTips0x857$NotifyMsgBody.opt_enum_type.get();
                int i16 = troopTips0x857$NotifyMsgBody.uint32_service_type.get();
                long j17 = troopTips0x857$NotifyMsgBody.opt_uint64_group_code.get();
                Lazy<com.tencent.qqnt.push.b> lazy = TroopPushCMD.f360703a.c().get(Integer.valueOf(i3));
                if (lazy == null) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Troop0x2dcCommonProcessor", 2, "[onPushReceive] promptType:" + i3 + ", serviceType:" + i16 + ",msgSeq:" + j3 + ", msgTime:" + j16 + ", troopUin:" + j17 + ", subProcessor:" + lazy);
                }
                if (b(j17, j3)) {
                    return;
                }
                if (j16 == 0) {
                    j16 = NetConnInfoCenter.getServerTime();
                }
                long j18 = troopTips0x857$NotifyMsgBody.opt_uint64_msg_expires.get();
                if (j18 != 0 && NetConnInfoCenter.getServerTime() >= j18) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Troop0x2dcCommonProcessor", 2, "[onPushReceive] time expire, promptType:" + i3);
                        return;
                    }
                    return;
                }
                com.tencent.qqnt.push.bean.a aVar = new com.tencent.qqnt.push.bean.a();
                aVar.b(j3);
                aVar.c(j16);
                aVar.d(j17);
                com.tencent.qqnt.push.b value = lazy.getValue();
                if (value != null) {
                    value.a(troopTips0x857$NotifyMsgBody, aVar);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception unused) {
                QLog.e("Troop0x2dcCommonProcessor", 1, "[onPushReceive] catch exception");
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }
}
