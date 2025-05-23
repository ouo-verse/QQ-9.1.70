package com.tencent.mobileqq.uftransfer.guild;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDef;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.file.i;
import com.tencent.mobileqq.guild.file.r;
import com.tencent.mobileqq.guild.file.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTGuildFetchUploadUrlOp extends UFTBaseOp implements i {

    /* renamed from: o, reason: collision with root package name */
    public static HashMap<Integer, Integer> f305181o = new HashMap<Integer, Integer>() { // from class: com.tencent.mobileqq.uftransfer.guild.UFTGuildFetchUploadUrlOp.1
        {
            put(0, 1);
            put(1, 2);
            put(2, 3);
            put(3, 4);
            put(6, 5);
            put(7, 6);
            put(9, 7);
            put(4, 8);
            put(10, 9);
        }
    };

    /* renamed from: p, reason: collision with root package name */
    private static int f305182p = 0;

    /* renamed from: j, reason: collision with root package name */
    protected final boolean f305183j;

    /* renamed from: k, reason: collision with root package name */
    protected final boolean f305184k;

    /* renamed from: l, reason: collision with root package name */
    protected final boolean f305185l;

    /* renamed from: m, reason: collision with root package name */
    protected final boolean f305186m;

    /* renamed from: n, reason: collision with root package name */
    protected String f305187n;

    public UFTGuildFetchUploadUrlOp(AppRuntime appRuntime, g gVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, UFTBaseOp.b bVar) {
        super(appRuntime, gVar, aVar, bVar);
        this.f305183j = gVar.b().a().e();
        this.f305184k = gVar.b().a().f();
        this.f305185l = gVar.b().a().d();
        this.f305186m = gVar.b().a().c();
        C();
    }

    private void A(s sVar) {
        String str;
        int i3;
        if (sVar != null) {
            i3 = sVar.e();
            str = sVar.f();
        } else {
            str = "";
            i3 = Integer.MIN_VALUE;
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = 9001;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildFetchUploadUrlOp", 1, "TId[" + p() + "] request guild upload url fail. errCode:" + i3);
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        aVar.f(i3);
        aVar.g(str);
        F(sVar);
        r(aVar);
    }

    private void B(s sVar) {
        F(sVar);
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        aVar.f(0);
        aVar.f(sVar.e());
        aVar.g(sVar.f());
        r(aVar);
    }

    private void C() {
        g gVar = (g) this.f305343b;
        byte[] b16 = gVar.d().b();
        byte[] bArr = new byte[b16.length + 4];
        com.tencent.mobileqq.uftransfer.depend.a.c(bArr, 0, b16, b16.length);
        com.tencent.mobileqq.uftransfer.depend.a.d(bArr, b16.length, gVar.f());
        this.f305187n = com.tencent.mobileqq.uftransfer.depend.a.a(bArr).toLowerCase(Locale.US);
    }

    private void E(r rVar, String str) {
        int i3;
        int fileType = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(str);
        if (f305181o.containsKey(Integer.valueOf(fileType))) {
            i3 = f305181o.get(Integer.valueOf(fileType)).intValue();
        } else {
            i3 = 0;
        }
        rVar.o(i3);
    }

    public static int x() {
        int i3;
        synchronized (UFTGuildFetchUploadUrlOp.class) {
            i3 = f305182p + 1;
            f305182p = i3;
        }
        return i3;
    }

    protected boolean D(r rVar) {
        ((com.tencent.mobileqq.guild.file.g) ((AppInterface) this.f305342a).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildFileHandlerName())).n1(rVar, this);
        return true;
    }

    protected void F(s sVar) {
        if (sVar == null) {
            return;
        }
        g gVar = (g) this.f305343b;
        if (!TextUtils.isEmpty(sVar.b())) {
            gVar.j(sVar.b());
        }
        gVar.B(sVar);
    }

    @Override // com.tencent.mobileqq.guild.file.i
    public void c(boolean z16, s sVar) {
        z(z16, sVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildFetchUploadUrlOp", 1, "TId[" + p() + "] do fetch guild upload url op." + y());
        r rVar = new r();
        int w3 = w(rVar);
        if (w3 != 0) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildFetchUploadUrlOp", 1, "TId[" + p() + "] fetch guild upload url fail. build upload req fail. retCode:" + w3);
            return w3;
        }
        if (!D(rVar)) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildFetchUploadUrlOp", 1, "TId[" + p() + "] request guild upload url fail");
            t("request url fail");
            return 9001;
        }
        return 0;
    }

    protected int w(r rVar) {
        g gVar = (g) this.f305343b;
        try {
            byte[] bytes = gVar.e().getBytes("utf-8");
            byte[] bytes2 = gVar.q().getBytes("utf-8");
            rVar.t(x());
            rVar.s(gVar.r());
            rVar.n(gVar.p());
            rVar.r(gVar.f());
            rVar.p(new String(bytes));
            rVar.q(new String(bytes2));
            rVar.k(ExcitingTransferDef.Send.FILE_BUSINESS_ID_GUILD);
            rVar.l(gVar.d().b());
            rVar.m(gVar.d().c());
            E(rVar, rVar.g());
            return 0;
        } catch (Exception unused) {
            t("strFilePath to bytes fail");
            return 9005;
        }
    }

    protected String y() {
        return " cfg = useHttps:" + this.f305183j + " useIPv6:" + this.f305184k + " useExtf:" + this.f305185l + " ftnSpTst:" + this.f305186m;
    }

    protected void z(boolean z16, s sVar) {
        if (z16 && sVar != null) {
            B(sVar);
        } else {
            A(sVar);
        }
    }
}
