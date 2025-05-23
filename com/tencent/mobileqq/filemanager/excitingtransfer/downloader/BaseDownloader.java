package com.tencent.mobileqq.filemanager.excitingtransfer.downloader;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import com.tencent.mobileqq.filemanager.util.ah;
import vb1.b;
import wb1.a;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class BaseDownloader implements b, IExcitingTransferRecvListener {

    /* renamed from: d, reason: collision with root package name */
    protected a f207967d;

    /* renamed from: e, reason: collision with root package name */
    private ExcitingTransferDownloadReqInfo f207968e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f207969f = true;

    /* renamed from: h, reason: collision with root package name */
    protected int f207970h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected IFMSettings f207971i = null;

    /* renamed from: m, reason: collision with root package name */
    protected long f207972m = -1;

    public BaseDownloader(QQAppInterface qQAppInterface) {
        this.f207968e = null;
        this.f207967d = h(qQAppInterface);
        this.f207968e = new ExcitingTransferDownloadReqInfo();
    }

    @Override // vb1.b
    public boolean a() {
        boolean z16;
        synchronized (this) {
            z16 = this.f207969f;
        }
        return z16;
    }

    @Override // vb1.b
    public void b() {
        synchronized (this) {
            this.f207969f = true;
            ExcitingTransferEngine.getInstance().cancelRecvFile(this.f207972m);
        }
    }

    @Override // vb1.b
    public void d() {
        b();
        this.f207967d.e();
    }

    @Override // vb1.b
    public void e() {
        b();
        this.f207967d.i();
    }

    @Override // vb1.b
    public void f() {
        b();
    }

    @Override // vb1.b
    public int getActionType() {
        return 1;
    }

    protected abstract a h(QQAppInterface qQAppInterface);

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        this.f207972m = ExcitingTransferEngine.getInstance().recvFileEx(this.f207968e, ((IExcitingTransferAdapter) ah.W().getRuntimeService(IExcitingTransferAdapter.class, "")).getC2CDownloadConfig(), this);
    }

    protected abstract void j(ExcitingTransferDownloadReqInfo excitingTransferDownloadReqInfo);

    @Override // vb1.b
    public void run() {
        synchronized (this) {
            this.f207969f = false;
        }
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                BaseDownloader.this.f207971i = lc1.b.a();
                BaseDownloader baseDownloader = BaseDownloader.this;
                baseDownloader.j(baseDownloader.f207968e);
            }
        });
    }
}
