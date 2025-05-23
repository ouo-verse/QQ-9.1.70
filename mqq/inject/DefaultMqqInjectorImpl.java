package mqq.inject;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DefaultMqqInjectorImpl implements IMqqInjector {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class oidb_sso {

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class MetaData extends MessageMicro<MetaData> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, MetaData.class);
            public final PBStringField key = PBField.initString("");
            public final PBStringField value = PBField.initString("");
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static final class OIDBSSOPkg extends MessageMicro<OIDBSSOPkg> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 90}, new String[]{"uint32_command", "uint32_service_type", "uint32_result", "bytes_bodybuffer", "str_error_msg", "str_client_version", "trpc_trans_info"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY, "", "", null}, OIDBSSOPkg.class);
            public final PBUInt32Field uint32_command = PBField.initUInt32(0);
            public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_result = PBField.initUInt32(0);
            public final PBBytesField bytes_bodybuffer = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBStringField str_error_msg = PBField.initString("");
            public final PBStringField str_client_version = PBField.initString("");
            public final PBRepeatMessageField<MetaData> trpc_trans_info = PBField.initRepeatMessage(MetaData.class);
        }

        oidb_sso() {
        }
    }

    @Override // mqq.inject.IMqqInjector
    public boolean getSwitch(Context context, String str, boolean z16, boolean z17) {
        return z17;
    }

    @Override // mqq.inject.IMqqInjector
    public String getVersion() {
        return "android 1.0.0";
    }

    @Override // mqq.inject.IMqqInjector
    public void handleSendTimeForSendMsgPb(ToServiceMsg toServiceMsg, String str) {
        if (BaseConstants.CMD_MSG_PBSENDMSG.equalsIgnoreCase(str)) {
            long j3 = toServiceMsg.extraData.getLong("msg_send_time", 0L);
            if (j3 != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                toServiceMsg.extraData.putLong("msg_request_time", currentTimeMillis);
                toServiceMsg.extraData.putLong("msg_send_to_request_cost", currentTimeMillis - j3);
            }
        }
    }

    @Override // mqq.inject.IMqqInjector
    public String[] highPriorityCommand() {
        return new String[]{"MessageSvc.PbGetMsg", "MessageSvc.PbGetGroupMsg", BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_SHARE_MSG, "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "MessageSvc.PbGetDiscussMsg", "MessageSvc.PushNotify", "MessageSvc.PushReaded", MiniConst.Spark.CMD_PUSH_SPARK_REWARD, BaseConstants.CMD_RESPPUSH};
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isDebugVersion() {
        return true;
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isGrayVersion() {
        return false;
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isPublicVersion() {
        return false;
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isUiTest() {
        return false;
    }

    @Override // mqq.inject.IMqqInjector
    public ToServiceMsg makeOIDBPkg(OidbWrapper oidbWrapper, String str, int i3, int i16, byte[] bArr, long j3, BusinessObserver businessObserver, boolean z16) {
        oidb_sso.OIDBSSOPkg oIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        oIDBSSOPkg.uint32_command.set(i3);
        oIDBSSOPkg.uint32_service_type.set(i16);
        oIDBSSOPkg.uint32_result.set(0);
        oIDBSSOPkg.str_client_version.set(MqqInjectorManager.instance().getVersion());
        oIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        ToServiceMsg createToServiceMsg = oidbWrapper.createToServiceMsg(str);
        createToServiceMsg.putWupBuffer(oIDBSSOPkg.toByteArray());
        createToServiceMsg.setTimeout(j3);
        return createToServiceMsg;
    }

    @Override // mqq.inject.IMqqInjector
    public int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro) {
        return 1001;
    }

    @Override // mqq.inject.IMqqInjector
    public void postNeedFixStartStepCapturedException(@NonNull Throwable th5) {
        QLog.e("CrashDefend", 1, "postNeedFixStartStepCapturedException can not invoke, info:", th5);
    }

    @Override // mqq.inject.IMqqInjector
    public String[] tempServletPreferSSOCommand() {
        return new String[]{MiniConst.Spark.CMD_PUSH_SPARK_REWARD, "MessageSvc.RequestPushStatus", "MessageSvc.PushNotify", BaseConstants.CMD_FORCE_LOGOUT, "ADMsgSvc.PushMsg", "MessageSvc.PushReaded", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushBindUinGroupMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "NearFieldTranFileSvr.NotifyList", "StatSvc.SvcReqMSFLoginNotify"};
    }

    @Override // mqq.inject.IMqqInjector
    public boolean getSwitch(String str, boolean z16) {
        return false;
    }

    @Override // mqq.inject.IMqqInjector
    public int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro, MessageMicro messageMicro2) {
        return 1001;
    }

    @Override // mqq.inject.IMqqInjector
    public String getSDKPrivatePath(String str) {
        return str;
    }

    @Override // mqq.inject.IMqqInjector
    public void tryDumpUiHierarchyToFile(View view) {
    }

    @Override // mqq.inject.IMqqInjector
    public void report(String str, Map<String, String> map) {
    }
}
