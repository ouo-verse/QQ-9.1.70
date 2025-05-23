package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TenDocOCRExportHandler extends BusinessHandler implements Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    public static final String f291571e = "com.tencent.mobileqq.teamwork.TenDocOCRExportHandler";

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f291572d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IGetExternalInterface.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f291576a;

        a(Runnable runnable) {
            this.f291576a = runnable;
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.c
        public void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                ThreadManagerV2.executeOnNetWorkThread(this.f291576a);
            } else {
                QLog.i("TenDocOCRExportHandler", 1, "pskey async is empty, domain: docs.qq.com");
            }
        }
    }

    public TenDocOCRExportHandler(AppInterface appInterface) {
        super(appInterface);
        this.f291572d = appInterface;
    }

    private void doRequestAfterGetTicket(Runnable runnable) {
        if (this.f291572d == null) {
            return;
        }
        ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPsKey(ITeamWorkHandler.DOCS_DOMAIN, new a(runnable));
    }

    public void E2(final String str) {
        doRequestAfterGetTicket(new Runnable() { // from class: com.tencent.mobileqq.teamwork.TenDocOCRExportHandler.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.teamwork.TenDocOCRExportHandler$1$a */
            /* loaded from: classes18.dex */
            class a implements IGetExternalInterface.d {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ TenDocOCRExportHandler f291574a;

                a(TenDocOCRExportHandler tenDocOCRExportHandler) {
                    this.f291574a = tenDocOCRExportHandler;
                }

                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public void a(Object obj) {
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) obj;
                        String optString = jSONObject.optString("url");
                        int optInt = jSONObject.optInt("ret");
                        try {
                            String decode = URLDecoder.decode(optString, "UTF-8");
                            if (optInt == 0 && decode.length() > 0) {
                                Bundle bundle = new Bundle();
                                bundle.putString("url", decode);
                                this.f291574a.notifyUI(3, true, new Object[]{jSONObject});
                                QIPCClientHelper.getInstance().callServer("Module_TDFileChangeNameQIPCModule", "Action_url_2_fmdb", bundle);
                            } else {
                                this.f291574a.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u2j), str, Integer.valueOf(optInt)});
                            }
                            return;
                        } catch (UnsupportedEncodingException e16) {
                            this.f291574a.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u2k), str});
                            e16.printStackTrace();
                            return;
                        }
                    }
                    this.f291574a.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u2i), str});
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TenDocOCRExportHandler.this.f291572d != null && !TextUtils.isEmpty(str)) {
                    ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).ocrExportUploadImage(TenDocOCRExportHandler.this.f291572d, str, TenDocOCRExportHandler.this.f291572d.getCurrentAccountUin(), new a((TenDocOCRExportHandler) TenDocOCRExportHandler.this.f291572d.getBusinessHandler(TenDocOCRExportHandler.class.getName())));
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return bn.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
