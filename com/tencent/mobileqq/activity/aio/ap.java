package com.tencent.mobileqq.activity.aio;

import android.support.v4.util.LruCache;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    public static LruCache<String, PAMessage> f178225a = new LruCache<>(50);

    private static String a(String str, long j3, long j16) {
        return str + ContainerUtils.FIELD_DELIMITER + j3 + ContainerUtils.FIELD_DELIMITER + j16;
    }

    public static PAMessage b(MessageRecord messageRecord) {
        return c(messageRecord.frienduin, messageRecord.shmsgseq, messageRecord.msgUid, messageRecord.msgData);
    }

    public static PAMessage c(String str, long j3, long j16, byte[] bArr) {
        String a16 = a(str, j3, j16);
        PAMessage pAMessage = f178225a.get(a16);
        if (pAMessage == null) {
            try {
                pAMessage = (PAMessage) ((IPublicAccountMessageUtil) QRoute.api(IPublicAccountMessageUtil.class)).fromByteArray(bArr);
                if (pAMessage != null) {
                    f178225a.put(a16, pAMessage);
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return pAMessage;
    }
}
