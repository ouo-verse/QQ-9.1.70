package cooperation.qqfav.forward;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.forward.b;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.slf4j.Marker;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import u05.a;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QfavFileForwardHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f390615d;

    public QfavFileForwardHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f390615d = qQAppInterface;
    }

    private void D2(ToServiceMsg toServiceMsg, oidb_cmd0xd68$RspBody oidb_cmd0xd68_rspbody) {
        FileManagerEntity D;
        if (oidb_cmd0xd68_rspbody.forward_data_wire_rsp == null) {
            return;
        }
        long longValue = ((Long) toServiceMsg.getAttribute("sessionId")).longValue();
        String str = new String(oidb_cmd0xd68_rspbody.forward_data_wire_rsp.bytes_uuid.get().toByteArray());
        DataLineHandler dataLineHandler = (DataLineHandler) this.f390615d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        if (TextUtils.isEmpty(str)) {
            dataLineHandler.OnSessionComplete(longValue, 0, -999);
            return;
        }
        DataLineMsgRecord d16 = this.f390615d.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(longValue)).d(longValue);
        if (d16 == null) {
            return;
        }
        d16.serverPath = str;
        d16.nOpType = 1;
        d16.bIsSended = true;
        d16.bIsTransfering = false;
        if (d16.entityID != 0 && (D = this.f390615d.getFileManagerDataCenter().D(d16.entityID)) != null) {
            D.status = 1;
            D.Uuid = d16.serverPath;
        }
        if (dataLineHandler.k3(d16)) {
            dataLineHandler.v4(d16);
        }
    }

    private void E2(ToServiceMsg toServiceMsg, oidb_cmd0xd68$RspBody oidb_cmd0xd68_rspbody) {
        if (oidb_cmd0xd68_rspbody.forward_group_rsp == null) {
            return;
        }
        long longValue = ((Long) toServiceMsg.getAttribute("sessionId")).longValue();
        FileManagerEntity D = this.f390615d.getFileManagerDataCenter().D(longValue);
        if (D == null) {
            QLog.e("QfavFileForwardHandler", 4, "handleGroupRsp fileManagerEntity is null");
            return;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f390615d, Long.parseLong(D.peerUin));
        if (O != null) {
            b.d().k(this.f390615d, D.msgSeq);
            O.E(longValue, UUID.fromString(D.strTroopFileUuid), null, oidb_cmd0xd68_rspbody.forward_group_rsp.int32_ret_code.get(), new String(oidb_cmd0xd68_rspbody.forward_group_rsp.bytes_save_file_path.get().toByteArray()), oidb_cmd0xd68_rspbody.forward_group_rsp.str_ret_msg.get());
        }
    }

    private void F2(ToServiceMsg toServiceMsg, oidb_cmd0xd68$RspBody oidb_cmd0xd68_rspbody) {
        boolean z16;
        if (oidb_cmd0xd68_rspbody.forward_offline_rsp == null) {
            return;
        }
        FileManagerEntity D = this.f390615d.getFileManagerDataCenter().D(((Long) toServiceMsg.getAttribute("sessionId")).longValue());
        if (D == null) {
            return;
        }
        int i3 = oidb_cmd0xd68_rspbody.forward_offline_rsp.int32_ret_code.get();
        String str = oidb_cmd0xd68_rspbody.forward_offline_rsp.str_ret_msg.get();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (D.status != 2) {
                D.status = 1005;
                this.f390615d.getFileManagerDataCenter().f0(D);
            }
            QLog.e("QfavFileForwardHandler", 1, "Id[" + D.nSessionId + "]wk,handleOfflineRsp-->failed ret_code:" + i3);
            this.f390615d.getFileManagerNotifyCenter().c(D.uniseq, D.nSessionId, D.peerUin, D.peerType, 15, null, i3, str);
            return;
        }
        D.Uuid = new String(oidb_cmd0xd68_rspbody.forward_offline_rsp.bytes_uuid.get().toByteArray());
        D.setCloudType(1);
        D.status = 1;
        D.isReaded = false;
        D.bSend = true;
        D.fProgress = 0.0f;
        D.bOnceSuccess = true;
        this.f390615d.getFileManagerDataCenter().c0();
        this.f390615d.getFileManagerDataCenter().f0(D);
        D.status = 2;
        FileManagerUtil.addCloseButtonSessionId(D.nSessionId);
        QLog.i("QfavFileForwardHandler", 2, "=_= ^ [CS Replay]->[CC] Id[" + D.nSessionId + "]sendFavFile2Offline onSucceed, entity thumbSize(" + D.imgHeight + ":" + D.imgWidth + ")");
        if (D.peerType == 3000) {
            QLog.i("QfavFileForwardHandler", 2, "=_= ^ [Disc Feed]sendDiscFileFeed[" + D.nSessionId + "]");
            this.f390615d.getFileTransferHandler().k1(D.nSessionId, D.peerUin, this.f390615d.getCurrentAccountUin(), D.fileName, D.fileSize, D.Uuid, D.uniseq, D.msgUid, null);
        } else {
            String replace = D.peerUin.replace(Marker.ANY_NON_NULL_MARKER, "");
            QLog.i("QfavFileForwardHandler", 2, "=_= ^ [Offline CC]sendC2COfflineFileMsg[" + D.nSessionId + "]");
            this.f390615d.getFileTransferHandler().i1(replace, D, null);
        }
        this.f390615d.getFileManagerNotifyCenter().a(D, 10, "");
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "send_file_suc";
        aVar.f209158c = 1;
        FileManagerReporter.addData(this.f390615d.getCurrentAccountUin(), aVar);
        FileManagerUtil.preLoadThumb(this.f390615d, D);
    }

    private static oidb_sso$OIDBSSOPkg parseSSOPkg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("QfavFileForwardHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
                }
            }
            if (oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                return oidb_sso_oidbssopkg;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QfavFileForwardHandler", 4, "onReceive");
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (QLog.isDevelopLevel()) {
            QLog.i("QfavFileForwardHandler", 4, "cmd=" + serviceCmd);
            QLog.i("QfavFileForwardHandler", 4, "data length =" + ((byte[]) obj).length);
        }
        if (TextUtils.isEmpty(serviceCmd)) {
            return;
        }
        if (serviceCmd.compareTo("OidbSvc.0xd68") == 0) {
            oidb_sso$OIDBSSOPkg parseSSOPkg = parseSSOPkg(toServiceMsg, fromServiceMsg, obj);
            if (parseSSOPkg == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QfavFileForwardHandler", 2, "onReceive: ssoPkg parse failed");
                    return;
                }
                return;
            }
            oidb_cmd0xd68$RspBody oidb_cmd0xd68_rspbody = new oidb_cmd0xd68$RspBody();
            try {
                oidb_cmd0xd68_rspbody.mergeFrom(parseSSOPkg.bytes_bodybuffer.get().toByteArray());
                int i3 = parseSSOPkg.uint32_service_type.get();
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return;
                        } else {
                            D2(toServiceMsg, oidb_cmd0xd68_rspbody);
                        }
                    } else {
                        F2(toServiceMsg, oidb_cmd0xd68_rspbody);
                    }
                } else {
                    E2(toServiceMsg, oidb_cmd0xd68_rspbody);
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                return;
            }
        }
        QLog.e("QfavFileForwardHandler", 4, "cmd=" + serviceCmd);
    }
}
