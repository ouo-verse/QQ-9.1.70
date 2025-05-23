package com.tencent.mobileqq.filemanager.fileassistant.top;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileAssistTopHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private boolean f208002d;

    /* renamed from: e, reason: collision with root package name */
    public QQAppInterface f208003e;

    protected FileAssistTopHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f208002d = false;
        this.f208003e = qQAppInterface;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        InvalidProtocolBufferMicroException e16;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        boolean z17;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileAssistTopHandler<FileAssistant>", 1, "handleGetFileAssistTop  isSuccess: " + z16);
        }
        if (z16) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
            oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2.mergeFrom(bArr);
                try {
                    oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e17) {
                    e16 = e17;
                    QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop()  e =", e16);
                    QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleGetFileAssistTop() :" + oidb_0x5eb_rspbody.rpt_msg_uin_data.size() + "\uff0cresult:" + oidb_sso_oidbssopkg.uint32_result.get());
                    while (r9.hasNext()) {
                    }
                }
            } catch (InvalidProtocolBufferMicroException e18) {
                e16 = e18;
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
            }
            QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleGetFileAssistTop() :" + oidb_0x5eb_rspbody.rpt_msg_uin_data.size() + "\uff0cresult:" + oidb_sso_oidbssopkg.uint32_result.get());
            for (oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata : oidb_0x5eb_rspbody.rpt_msg_uin_data.get()) {
                String.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get());
                if (oidb_0x5eb_udcuindata.uint32_file_assist_top.has()) {
                    if (oidb_0x5eb_udcuindata.uint32_file_assist_top.get() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    this.f208002d = z17;
                    QLog.i("FileAssistTopHandler<FileAssistant>", 1, "handleGetFileAssistTop  isTop:" + this.f208002d);
                    notifyUI(1, z16, Boolean.valueOf(this.f208002d));
                }
            }
        }
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean booleanValue = ((Boolean) toServiceMsg.getAttribute("file_assist_top")).booleanValue();
        if (QLog.isColorLevel()) {
            QLog.d("FileAssistTopHandler<FileAssistant>", 2, "handleSetFileAssistTop() isTop = ", Boolean.valueOf(booleanValue), " isSuccess = ", Boolean.valueOf(z16));
        }
        if (z16) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop()  e =", e16);
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                z17 = true;
            }
            z16 = z17;
        }
        if (!z16) {
            QLog.e("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop retult false!");
        }
    }

    public void F2(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("FileAssistTopHandler<FileAssistant>", 1, " onPush()  isTop: " + z16);
        }
        String g16 = h.g(this.f208003e);
        RecentUserProxy recentUserProxy = this.f208003e.getRecentUserProxy();
        RecentUser findRecentUser = recentUserProxy.findRecentUser(g16, 0);
        if (findRecentUser == null) {
            findRecentUser = new RecentUser(g16, 0);
        }
        if (z16) {
            findRecentUser.showUpTime = System.currentTimeMillis() / 1000;
        } else {
            findRecentUser.showUpTime = 0L;
        }
        recentUserProxy.saveRecentUser(findRecentUser);
        MqqHandler handler = this.f208003e.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
        this.f208002d = z16;
        notifyUI(1, true, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.oidb_0x587_fst");
            this.allowCmdSet.add("OidbSvc.0x5eb_fst");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            QLog.d("FileAssistTopHandler<FileAssistant>", 4, "onReceive() req.cmd = ", toServiceMsg.getServiceCmd());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileAssistTopHandler<FileAssistant>", 1, "onReceive() req.cmd = " + toServiceMsg.getServiceCmd());
        }
        if ("OidbSvc.oidb_0x587_fst".equals(toServiceMsg.getServiceCmd())) {
            E2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x5eb_fst".equals(toServiceMsg.getServiceCmd())) {
            D2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
