package com.tencent.aelight.camera.ae.config;

import com.tencent.aelight.camera.ae.config.request.CameraMaterialGeneralServiceReq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.NetworkUtil;
import qshadow.QShadowMaterialGeneralService$MaterialGeneralSrvRsp;
import qshadow.QShadowMaterialGeneralService$ParamEntry;

/* loaded from: classes32.dex */
public class CameraPeakPBServiceHandler extends CameraPeakServiceHandler {
    private a C;

    /* loaded from: classes32.dex */
    public interface a {
        void a(String str, boolean z16, Object obj);
    }

    public CameraPeakPBServiceHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private void v3(final boolean z16, final long j3, final BaseRequest baseRequest, final MessageMicro messageMicro) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.config.e
            @Override // java.lang.Runnable
            public final void run() {
                CameraPeakPBServiceHandler.this.w3(z16, j3, baseRequest, messageMicro);
            }
        }, 64, null, false);
    }

    public void A3(a aVar) {
        this.C = aVar;
    }

    public void z3(String str, QShadowMaterialGeneralService$ParamEntry qShadowMaterialGeneralService$ParamEntry) {
        if (!NetworkUtil.isNetworkAvailable()) {
            ms.a.i("CameraPeakPBServiceHandler", "[requestMaterialGeneralServiceReq] no network....");
        } else {
            w93.e.f445096a.f(new CameraMaterialGeneralServiceReq(str, qShadowMaterialGeneralService$ParamEntry), new w93.a() { // from class: com.tencent.aelight.camera.ae.config.d
                @Override // w93.a
                public final void a(boolean z16, long j3, String str2, BaseRequest baseRequest, MessageMicro messageMicro) {
                    CameraPeakPBServiceHandler.this.x3(z16, j3, str2, baseRequest, messageMicro);
                }
            });
        }
    }

    protected void y3(BaseRequest baseRequest, MessageMicro messageMicro) {
        char c16;
        a aVar;
        if (baseRequest == null) {
            return;
        }
        try {
            String cmdName = baseRequest.getCmdName();
            if (cmdName.hashCode() == 46469311 && cmdName.equals("trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_material_general_srv")) {
                c16 = 0;
                if (c16 == 0 || (aVar = this.C) == null) {
                    return;
                }
                aVar.a("get_user_top_relation", true, (QShadowMaterialGeneralService$MaterialGeneralSrvRsp) messageMicro);
            }
            c16 = '\uffff';
            if (c16 == 0) {
                return;
            }
            aVar.a("get_user_top_relation", true, (QShadowMaterialGeneralService$MaterialGeneralSrvRsp) messageMicro);
        } catch (Throwable th5) {
            ms.a.c("CameraPeakPBServiceHandler", "[onReceive] exception = " + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x3(boolean z16, long j3, String str, BaseRequest baseRequest, MessageMicro messageMicro) {
        v3(z16, j3, baseRequest, messageMicro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w3(boolean z16, long j3, BaseRequest baseRequest, MessageMicro messageMicro) {
        if (z16 && j3 == 0) {
            y3(baseRequest, messageMicro);
        } else {
            y3(baseRequest, null);
        }
    }
}
