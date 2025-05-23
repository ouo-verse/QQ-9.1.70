package com.tencent.mobileqq.troop.livesync.repository;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "", "byteArray", "", "b", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MessageMicro<?> messageMicro, byte[] bArr) {
        if (bArr != null) {
            try {
                messageMicro.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("TroopLiveSync", 1, "parse sub troop protoc error:", e16);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
