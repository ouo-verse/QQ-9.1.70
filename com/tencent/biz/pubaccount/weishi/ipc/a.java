package com.tencent.biz.pubaccount.weishi.ipc;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.biz.pubaccount.weishi.config.experiment.b;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static a f80899d;

    public a(String str) {
        super(str);
    }

    public static a b() {
        if (f80899d == null) {
            synchronized (a.class) {
                if (f80899d == null) {
                    f80899d = new a(IWSManager.IPC_MODULE_NAME);
                }
            }
        }
        return f80899d;
    }

    private void c() {
        ry.a.g();
    }

    private void d() {
        if (b.h().N()) {
            ry.a.h(ry.a.c(), "web_active");
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        str.hashCode();
        if (!str.equals("action_write_back_feed")) {
            if (!str.equals("action_req_aio_list_operation_feed")) {
                return null;
            }
            c();
            return null;
        }
        d();
        return null;
    }
}
