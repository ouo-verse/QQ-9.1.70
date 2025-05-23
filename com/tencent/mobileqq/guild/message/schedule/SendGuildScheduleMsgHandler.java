package com.tencent.mobileqq.guild.message.schedule;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qqguildsdk.data.cu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import vh2.cn;

/* compiled from: P */
/* loaded from: classes14.dex */
public class SendGuildScheduleMsgHandler extends BusinessHandler implements a {
    protected SendGuildScheduleMsgHandler(AppInterface appInterface) {
        super(appInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(boolean z16) {
        int i3;
        int i16;
        Context applicationContext = this.appRuntime.getApplicationContext();
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        if (z16) {
            i16 = R.string.f156691kw;
        } else {
            i16 = R.string.f156681kv;
        }
        QQToast.makeText(applicationContext, i3, i16, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G2(long j3, cu cuVar, int i3, String str) {
        final boolean z16;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("Guild.share.SendGuildScheduleMsgHandler", 2, "sendScheduleArkMessage result:" + i3 + " errMsg:" + str + " srcScheduleId:" + j3 + " srcGInfo:" + cuVar);
        } else {
            QLog.e("Guild.share.SendGuildScheduleMsgHandler", 1, "sendScheduleArkMessage result:" + i3 + " errMsg:" + str + " srcScheduleId:" + j3 + " srcGInfo:" + cuVar);
        }
        com.tencent.mobileqq.guild.message.serversendarkmsg.b.a();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.schedule.c
            @Override // java.lang.Runnable
            public final void run() {
                SendGuildScheduleMsgHandler.this.F2(z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        QLog.d("Guild.share.SendGuildScheduleMsgHandler", 2, "onReceive go go go here?");
    }

    @Override // com.tencent.mobileqq.guild.message.schedule.a
    public void s(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, ArrayList<cu> arrayList3, @NonNull final cu cuVar, final long j3, int i3, String str, String str2, String str3, AttaIdReportData attaIdReportData) {
        byte[] bArr;
        Long l3;
        Long l16 = "";
        IGPSService iGPSService = (IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "");
        byte[] bArr2 = new byte[0];
        if (attaIdReportData != null) {
            attaIdReportData.g("");
            attaIdReportData.j("");
            attaIdReportData.k(new ArrayList<>());
            bArr = IGProDataApi.INSTANCE.a().encodeShareAttaData(attaIdReportData.c());
        } else {
            bArr = bArr2;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sendScheduleArkMessage,  srcScheduleId:");
        sb5.append(j3);
        sb5.append(", targetUins ");
        if (arrayList.isEmpty()) {
            l3 = "";
        } else {
            l3 = arrayList.get(0);
        }
        sb5.append(l3);
        sb5.append(", targetGcodes: ");
        if (!arrayList2.isEmpty()) {
            l16 = arrayList2.get(0);
        }
        sb5.append(l16);
        QLog.i("Guild.share.SendGuildScheduleMsgHandler", 2, sb5.toString());
        iGPSService.sendScheduleArkMessage(arrayList, arrayList2, arrayList3, cuVar, j3, i3, str, str2, str3, bArr, new cn() { // from class: com.tencent.mobileqq.guild.message.schedule.b
            @Override // vh2.cn
            public final void onSendArkMessage(int i16, String str4) {
                SendGuildScheduleMsgHandler.this.G2(j3, cuVar, i16, str4);
            }
        });
    }
}
