package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OuterBinderAdapter extends BinderAdapter {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f36676j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static BinderAdapter f36677k;

    /* renamed from: l, reason: collision with root package name */
    private static String f36678l;

    /* renamed from: m, reason: collision with root package name */
    private static String f36679m;

    OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032 A[Catch: all -> 0x004f, TryCatch #0 {, blocks: (B:4:0x000c, B:6:0x0010, B:7:0x004b, B:8:0x004d, B:12:0x001c, B:14:0x0024, B:19:0x0032), top: B:3:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BinderAdapter getInstance(Context context, String str, String str2) {
        boolean z16;
        BinderAdapter binderAdapter;
        HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance.");
        synchronized (f36676j) {
            if (f36677k == null) {
                f36678l = str;
                f36679m = str2;
                f36677k = new OuterBinderAdapter(context, str, str2);
            } else {
                if (Objects.equal(f36678l, str) && Objects.equal(f36679m, str2)) {
                    z16 = false;
                    if (z16) {
                        HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance refresh adapter");
                        f36678l = str;
                        f36679m = str2;
                        f36677k.unBind();
                        f36677k = new OuterBinderAdapter(context, str, str2);
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            binderAdapter = f36677k;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getConnTimeOut() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getMsgDelayDisconnect() {
        return 1002;
    }
}
