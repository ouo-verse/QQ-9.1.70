package com.tencent.mobileqq.guild.focus;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.message.f;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import io1.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tencent.im.oidb.reportFocus.ReportFocus$ReqBody;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildReportFocusInfoHandler extends BusinessHandler implements a {

    /* renamed from: d, reason: collision with root package name */
    private f f224511d;

    /* renamed from: e, reason: collision with root package name */
    private long f224512e;

    public GuildReportFocusInfoHandler(AppInterface appInterface) {
        super(appInterface);
        this.f224511d = null;
        this.f224512e = 0L;
    }

    private boolean D2(f fVar) {
        return false;
    }

    @Override // io1.a
    public void P(f fVar) {
        if (!D2(fVar)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (fVar.f() != null) {
            Iterator<String> it = fVar.f().iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(Long.parseLong(it.next())));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (fVar.e() != null) {
            Iterator<String> it5 = fVar.e().iterator();
            while (it5.hasNext()) {
                arrayList2.add(Long.valueOf(Long.parseLong(it5.next())));
            }
        }
        ReportFocus$ReqBody reportFocus$ReqBody = new ReportFocus$ReqBody();
        reportFocus$ReqBody.is_msg_tab_focus.set(fVar.g());
        reportFocus$ReqBody.rpt_uint64_guild_lists.set(arrayList);
        reportFocus$ReqBody.rpt_uint64_channel_lists.set(arrayList2);
        reportFocus$ReqBody.active_status.set(fVar.d());
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.group_pro.focus.Focus.ReportFocus");
        createToServiceMsg.putWupBuffer(reportFocus$ReqBody.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.group_pro.focus.Focus.ReportFocus");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            int resultCode = fromServiceMsg.getResultCode();
            if (resultCode != 1000) {
                QLog.d("GuildFocusChannelHandler", 1, "reportFocusChannelInfo error! errorCode = " + resultCode + " errorMsg = " + fromServiceMsg.getBusinessFailMsg());
                return;
            }
            return;
        }
        QLog.d("GuildFocusChannelHandler", 1, "onReceive args error!");
    }
}
