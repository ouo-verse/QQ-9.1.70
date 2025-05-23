package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class k extends QIPCModule {

    /* renamed from: e, reason: collision with root package name */
    private static volatile k f207308e;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f207309d;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        EIPCResult a(EIPCModule eIPCModule, String str, Bundle bundle, int i3);
    }

    k() {
        super("TroopDocsShareActionModel");
        this.f207309d = new ArrayList();
    }

    public static k c() {
        if (f207308e == null) {
            synchronized (k.class) {
                if (f207308e == null) {
                    f207308e = new k();
                }
            }
        }
        return f207308e;
    }

    public void b(a aVar) {
        this.f207309d.add(aVar);
    }

    public void d(a aVar) {
        if (aVar != null) {
            this.f207309d.remove(aVar);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopDocsShareActionModel", 2, "[onCall] action = " + str + ", params = " + bundle + ", callbackId=" + i3);
        }
        for (a aVar : this.f207309d) {
            if (aVar != null) {
                aVar.a(this, str, bundle, i3);
            }
        }
        return null;
    }
}
