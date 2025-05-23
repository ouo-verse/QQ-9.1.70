package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class InnerBinderAdapter extends BinderAdapter {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f36674j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static BinderAdapter f36675k;

    InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        BinderAdapter binderAdapter;
        HMSLog.i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        synchronized (f36674j) {
            if (f36675k == null) {
                f36675k = new InnerBinderAdapter(context, str, str2);
            }
            binderAdapter = f36675k;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getConnTimeOut() {
        return 2001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getMsgDelayDisconnect() {
        return 2002;
    }
}
