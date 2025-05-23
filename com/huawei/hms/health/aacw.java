package com.huawei.hms.health;

import com.huawei.hms.hihealth.result.ReadDetailResult;
import com.huawei.hms.hihealth.result.ReadReply;
import com.huawei.hms.support.api.client.Status;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class aacw<T> implements aacz<T> {
    private ReadReply aab = new ReadReply();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.health.aacz
    public com.huawei.hms.hihealth.result.aab aab(T t16) {
        ReadDetailResult create;
        ReadReply readReply;
        if (t16 instanceof ReadDetailResult) {
            readReply = this.aab;
            create = (ReadDetailResult) t16;
        } else {
            if (t16 instanceof Exception) {
                create = ReadDetailResult.create(aabz.aab(((Exception) t16).getMessage()), new ArrayList(), new ArrayList());
            } else {
                create = ReadDetailResult.create(Status.FAILURE, new ArrayList(), new ArrayList());
            }
            readReply = this.aab;
        }
        readReply.setResult(create);
        return this.aab;
    }
}
