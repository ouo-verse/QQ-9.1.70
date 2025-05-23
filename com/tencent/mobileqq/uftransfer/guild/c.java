package com.tencent.mobileqq.uftransfer.guild;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.mobileqq.uftransfer.task.upload.ac;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements INetInfoHandler {

    /* renamed from: d, reason: collision with root package name */
    private final AppRuntime f305219d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.taskqueue.a f305220e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements UFTUploadCbWrapper.a {
        a() {
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.a
        public boolean a() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements UFTUploadCbWrapper.a {
        b() {
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.a
        public boolean a() {
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.guild.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8869c implements UFTUploadCbWrapper.a {
        C8869c() {
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.a
        public boolean a() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements UFTUploadCbWrapper.a {
        d() {
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.a
        public boolean a() {
            return false;
        }
    }

    public c(AppRuntime appRuntime, int i3) {
        this.f305219d = appRuntime;
        this.f305220e = new com.tencent.mobileqq.uftransfer.taskqueue.a(i3);
    }

    public void a(com.tencent.mobileqq.uftransfer.api.impl.a aVar, Bundle bundle) {
        this.f305220e.q(aVar.b(), bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.tencent.mobileqq.uftransfer.api.impl.a aVar, e eVar, k kVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        k kVar2;
        long j3;
        UFTGuildExtfUploadTask uFTGuildExtfUploadTask;
        if (eVar == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildUploadController", 1, "[" + aVar.b() + "] upload c2c file, upload info is null");
            new UFTUploadCbWrapper(new a(), bVar).f(aVar, 9005, new ac());
            return;
        }
        if (kVar == null) {
            kVar2 = new k(true);
        } else {
            kVar2 = kVar;
        }
        String i3 = com.tencent.mobileqq.uftransfer.depend.a.i(eVar.a());
        if (!TextUtils.isEmpty(eVar.a())) {
            File file = new File(eVar.a());
            if (file.exists()) {
                j3 = file.length();
                long j16 = j3;
                com.tencent.mobileqq.uftransfer.guild.a aVar2 = new com.tencent.mobileqq.uftransfer.guild.a(this.f305219d);
                aVar2.h(aVar.b());
                aVar2.k(Long.valueOf(eVar.c()).longValue(), 0L, i3, com.tencent.mobileqq.uftransfer.depend.a.l(i3), j16);
                com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildUploadController", 1, "[" + aVar.b() + "] uploadGuildFile, uploadinfo:" + eVar.toString() + " config:" + eVar.toString());
                if (!TextUtils.isEmpty(eVar.a())) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildUploadController", 1, "[" + aVar.b() + "] upload c2c file, file path is null");
                    new UFTUploadCbWrapper(new b(), bVar).f(aVar, 9042, new ac());
                    aVar2.g(9042);
                    aVar2.a(false);
                    return;
                }
                g n3 = g.n(aVar.b(), aVar.c(), eVar, kVar2);
                if (n3 == null) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildUploadController", 1, "[" + aVar.b() + "] upload guild file, create task info fail");
                    new UFTUploadCbWrapper(new C8869c(), bVar).f(aVar, 9005, new ac());
                    aVar2.g(17);
                    aVar2.a(false);
                    return;
                }
                if (n3.b().a().d()) {
                    uFTGuildExtfUploadTask = UFTGuildExtfUploadTask.a0(this.f305219d, aVar, n3, this.f305220e, bVar);
                } else {
                    QLog.e("[UFTTransfer] UFTGuildUploadController", 1, "Guild need useExtf");
                    uFTGuildExtfUploadTask = null;
                }
                if (uFTGuildExtfUploadTask == null) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildUploadController", 1, "[" + aVar.b() + "] upload guild file, create task fail");
                    new UFTUploadCbWrapper(new d(), bVar).f(aVar, 9005, new ac());
                    aVar2.g(17);
                    aVar2.a(false);
                    return;
                }
                this.f305220e.b(uFTGuildExtfUploadTask);
                return;
            }
        }
        j3 = 0;
        long j162 = j3;
        com.tencent.mobileqq.uftransfer.guild.a aVar22 = new com.tencent.mobileqq.uftransfer.guild.a(this.f305219d);
        aVar22.h(aVar.b());
        aVar22.k(Long.valueOf(eVar.c()).longValue(), 0L, i3, com.tencent.mobileqq.uftransfer.depend.a.l(i3), j162);
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildUploadController", 1, "[" + aVar.b() + "] uploadGuildFile, uploadinfo:" + eVar.toString() + " config:" + eVar.toString());
        if (!TextUtils.isEmpty(eVar.a())) {
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 2);
        this.f305220e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 1);
        this.f305220e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 1);
        this.f305220e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 2);
        this.f305220e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
    }
}
