package com.tencent.mobileqq.qmmkv;

import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J-\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/f;", "", "", "mmapId", "", "maxLen", "c", "", "keys", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkv", "a", "([Ljava/lang/String;Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;J)J", "kv", "b", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f262010a = new f();

    f() {
    }

    private final long a(String[] keys, MMKVOptionEntityV2 mmkv, long maxLen) {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        long j3 = maxLen;
        long j16 = 0;
        for (String str : keys) {
            sb5.append(String.valueOf(str));
            sb5.append(",");
            sb5.append(mmkv.getValueSize(str));
            sb5.append("|");
            if (sb5.length() > 800) {
                QLog.w("MMKVPrint_KVOutput", 1, sb5.toString());
                j3 -= sb5.length() * 2;
                sb5.setLength(0);
                if (j3 <= 0) {
                    break;
                }
            }
            j16++;
        }
        if (sb5.length() > 0) {
            z16 = true;
        }
        if (z16) {
            QLog.w("MMKVPrint_KVOutput", 1, sb5.toString());
        }
        QLog.w("MMKVPrint_KVOutput", 1, mmkv.getMmapId() + " " + j16 + "/" + keys.length + " print end...");
        return j3;
    }

    @JvmStatic
    public static final long c(@NotNull String mmapId, long maxLen) {
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, mmapId, 2, 1);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026ULE.RULE_WITHOUT_ACCOUNT)");
        f262010a.b(fromV2, maxLen);
        return maxLen;
    }

    public final long b(@NotNull MMKVOptionEntityV2 kv5, long maxLen) {
        Intrinsics.checkNotNullParameter(kv5, "kv");
        long j3 = kv5.totalSize();
        long actualSize = kv5.actualSize();
        long count = kv5.count();
        QLog.w("MMKVPrint_KVOutput", 1, kv5.mmapId() + " len:" + j3 + " actual:" + actualSize + " count:" + count + " print start...");
        String[] allKeyArr = kv5.allKeyArr();
        if (allKeyArr != null) {
            return f262010a.a(allKeyArr, kv5, maxLen);
        }
        return maxLen;
    }
}
