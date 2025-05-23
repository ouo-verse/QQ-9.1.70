package com.tencent.mobileqq.uftransfer.guild;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDef;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.file.j;
import com.tencent.mobileqq.guild.file.t;
import com.tencent.mobileqq.guild.file.u;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uftransfer.api.h;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends UFTBaseOp implements j {

    /* renamed from: j, reason: collision with root package name */
    private static int f305231j;

    public f(AppRuntime appRuntime, g gVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, UFTBaseOp.b bVar) {
        super(appRuntime, gVar, aVar, bVar);
    }

    private void A(u uVar) {
        C(uVar);
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        aVar.f(0);
        aVar.f(uVar.b());
        aVar.g(uVar.c());
        r(aVar);
    }

    private boolean B(t tVar) {
        if (tVar == null) {
            return false;
        }
        ((com.tencent.mobileqq.guild.file.g) ((AppInterface) this.f305342a).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildFileHandlerName())).u2(tVar, this);
        return true;
    }

    public static int x() {
        int i3;
        synchronized (UFTGuildFetchUploadUrlOp.class) {
            i3 = f305231j + 1;
            f305231j = i3;
        }
        return i3;
    }

    private String y() {
        h d16;
        if (this.f305343b.g() != 0 || (d16 = this.f305343b.d()) == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", d16.h());
            jSONObject.put("height", d16.g());
            return jSONObject.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void z(u uVar) {
        String str;
        if (uVar != null) {
            str = uVar.c();
        } else {
            str = "";
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("UFTGuildUploadSuccOp", 1, "TId[" + p() + "] request c2c upload url fail. errCode:9001");
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        aVar.f(9001);
        aVar.g(str);
        C(uVar);
        r(aVar);
    }

    protected void C(u uVar) {
        if (uVar == null) {
            return;
        }
        g gVar = (g) this.f305343b;
        if (!TextUtils.isEmpty(uVar.a())) {
            gVar.j(uVar.a());
        }
        gVar.C(uVar);
    }

    @Override // com.tencent.mobileqq.guild.file.j
    public void g(boolean z16, u uVar) {
        if (z16 && uVar != null) {
            A(uVar);
        } else {
            z(uVar);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        com.tencent.mobileqq.uftransfer.depend.c.c("UFTGuildUploadSuccOp", 1, "TId[" + p() + "] do set upload suc op");
        t tVar = new t();
        int w3 = w(tVar);
        if (w3 != 0) {
            com.tencent.mobileqq.uftransfer.depend.c.b("UFTGuildUploadSuccOp", 1, "TId[" + p() + "] report upload guild file succ fail. build req fail. retCode:" + w3);
            return w3;
        }
        if (!B(tVar)) {
            com.tencent.mobileqq.uftransfer.depend.c.b("UFTGuildUploadSuccOp", 1, "TId[" + p() + "] report upload guild file succ fail. request fail. retCode:" + w3);
            t("request fail");
            return 9001;
        }
        return 0;
    }

    protected int w(t tVar) {
        g gVar = (g) this.f305343b;
        tVar.n(x());
        tVar.l(gVar.r());
        tVar.j(gVar.p());
        tVar.h(ExcitingTransferDef.Send.FILE_BUSINESS_ID_GUILD);
        tVar.k(gVar.c());
        tVar.m(gVar.x());
        tVar.i(y());
        return 0;
    }
}
