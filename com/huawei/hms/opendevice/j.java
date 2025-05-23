package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j implements Callable<AAIDResult> {

    /* renamed from: a, reason: collision with root package name */
    public Context f37351a;

    public j(Context context) {
        this.f37351a = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public AAIDResult call() throws Exception {
        Context context = this.f37351a;
        if (context != null) {
            String c16 = o.c(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(c16);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
