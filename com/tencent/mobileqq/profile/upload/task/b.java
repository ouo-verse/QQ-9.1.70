package com.tencent.mobileqq.profile.upload.task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.data.UpsImageUploadTask;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends a {
    static IPatchRedirector $redirector_;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public String F;
    public byte[] G;
    protected String H;
    protected boolean I;

    /* renamed from: x, reason: collision with root package name */
    public int f260345x;

    /* renamed from: y, reason: collision with root package name */
    public String f260346y;

    /* renamed from: z, reason: collision with root package name */
    public long f260347z;

    public b(long j3, String str, byte[] bArr, String str2) {
        super(j3, str, bArr);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, bArr, str2);
            return;
        }
        this.f260345x = 13;
        this.D = 3;
        this.E = 1;
        this.I = false;
        this.H = str2;
    }

    public a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        UpsImageUploadTask upsImageUploadTask = new UpsImageUploadTask(this.f260337q);
        upsImageUploadTask.dataType = this.f260345x;
        upsImageUploadTask.fileId = this.f260346y;
        upsImageUploadTask.flowId = this.f260339s;
        upsImageUploadTask.iBatchID = this.f260347z;
        upsImageUploadTask.iBatchUploadCount = this.A;
        upsImageUploadTask.iBusiNessType = this.B;
        upsImageUploadTask.iCurrentUploadOrder = this.C;
        upsImageUploadTask.iSync = this.f260328h;
        upsImageUploadTask.iUin = this.f260335o;
        upsImageUploadTask.iUploadType = this.D;
        upsImageUploadTask.keepRaw = this.E;
        upsImageUploadTask.md5 = this.f260338r;
        upsImageUploadTask.preupload = this.f260330j;
        upsImageUploadTask.reportRefer = this.f260329i;
        upsImageUploadTask.sBusinessId = this.H;
        upsImageUploadTask.sCommand = this.F;
        upsImageUploadTask.sRefer = this.f260331k;
        upsImageUploadTask.transferData = this.f260332l;
        upsImageUploadTask.uiRefer = this.f260333m;
        upsImageUploadTask.uploadTaskCallback = this.f260340t;
        upsImageUploadTask.vBusiNessData = this.G;
        upsImageUploadTask.vLoginData = this.f260334n;
        this.f260342v = upsImageUploadTask;
        return this;
    }
}
