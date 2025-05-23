package iv;

import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.hd_video_2$MsgBody;
import com.tencent.av.o;
import com.tencent.av.r;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.nt_msg_common$Msg;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0x158.SubMsgType0x158$SharpVideoMsg;
import trpc.qq_av.av_appsvr.GroupInvite$GroupInviteMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J@\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u001c"}, d2 = {"Liv/b;", "", "", "type", QCircleLpReportDc010001.KEY_SUBTYPE, "", "g", "e", "f", "Lmsf/msgcomm/nt_msg_common$Msg;", "msg", "", "b", "Lcom/tencent/mobileqq/app/MessageHandler;", "mh", "fromUin", "selfUin", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, "", "msgSharpContent", "isSharpRequest", "d", "c", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f408792a = new b();

    b() {
    }

    private final void b(nt_msg_common$Msg msg2) {
        if (msg2.body.has() && msg2.body.msg_content.has()) {
            long j3 = msg2.content_head.msg_time.get();
            long j16 = msg2.content_head.msg_seq.get();
            long j17 = msg2.content_head.msg_uid.get();
            long j18 = msg2.routing_head.from_uin.get();
            String str = j16 + "-" + j17;
            if (QLog.isColorLevel()) {
                QLog.d("QAVOfflineMsgHelper", 2, "handleDavInviteMsg:  key:" + str);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            BusinessHandler businessHandler = ((QQAppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.MessageHandler");
            MessageHandler messageHandler = (MessageHandler) businessHandler;
            if (messageHandler.Q.getMsgCache().v1(j18, str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QAVOfflineMsgHelper", 2, "msg has been pulled");
                    return;
                }
                return;
            }
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            long longAccountUin = messageHandler.Q.getLongAccountUin();
            byte[] byteArray = msg2.body.msg_content.get().toByteArray();
            long j19 = K0 - j3;
            QLog.d("QAVOfflineMsgHelper", 2, "fromUin:" + j18 + " msgContent: " + Arrays.toString(byteArray));
            SubMsgType0x158$SharpVideoMsg subMsgType0x158$SharpVideoMsg = new SubMsgType0x158$SharpVideoMsg();
            try {
                subMsgType0x158$SharpVideoMsg.mergeFrom(byteArray);
                if (QLog.isColorLevel()) {
                    QLog.d("QAVOfflineMsgHelper", 2, "sharpVideoMsg type:" + subMsgType0x158$SharpVideoMsg.type.get());
                }
                byte[] msgSharpContent = subMsgType0x158$SharpVideoMsg.video_buff.get().toByteArray();
                boolean b16 = com.tencent.av.core.a.b(msgSharpContent);
                QLog.d("QAVOfflineMsgHelper", 2, "isSharpRequest: " + b16);
                QLog.d("QAVOfflineMsgHelper", 2, "video_buff:  " + Arrays.toString(msgSharpContent));
                if (longAccountUin == j18 && !b16) {
                    QLog.d("QAVOfflineMsgHelper", 2, "do not handle this case");
                    return;
                }
                if (b16) {
                    messageHandler.Q.getMsgCache().M(j18, str, K0);
                    o.k(longAccountUin, j18, 215);
                }
                if (!AVCoreSystemInfo.isSupportSharpAudio()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QAVOfflineMsgHelper", 2, "Discard video message cause device not support");
                    }
                    if (b16) {
                        o.k(longAccountUin, j18, 212);
                        return;
                    }
                    return;
                }
                if (j19 >= 60) {
                    Intrinsics.checkNotNullExpressionValue(msgSharpContent, "msgSharpContent");
                    d(messageHandler, msg2, j18, longAccountUin, j19, msgSharpContent, b16);
                    return;
                }
                if (b16) {
                    o.k(longAccountUin, j18, 211);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QAVOfflineMsgHelper", 2, "handleSharpVideoMessageResp");
                }
                messageHandler.k4(longAccountUin, msgSharpContent, j18, (int) j3, b16, subMsgType0x158$SharpVideoMsg.trace_info.trace_id.get());
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QAVOfflineMsgHelper", 2, "parse message failed" + e16);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("QAVOfflineMsgHelper", 2, "handleDavInviteMsg: hasBody:" + msg2.body.has() + ", hasMsgContent" + msg2.body.msg_content.has());
        }
    }

    private final void c(nt_msg_common$Msg msg2) {
        int i3;
        AVNotifyCenter aVNotifyCenter;
        String valueOf;
        boolean z16;
        long j3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface) && msg2.body.has() && msg2.body.msg_content.has()) {
            long j16 = msg2.content_head.msg_time.get();
            long j17 = msg2.routing_head.from_uin.get();
            long j18 = msg2.content_head.msg_seq.get();
            byte[] byteArray = msg2.body.msg_content.get().toByteArray();
            if (QLog.isColorLevel()) {
                QLog.d("QAVOfflineMsgHelper", 2, "handleMultiOfflineMsg, msgTime: [" + j16 + "] fromUin: [" + j17 + "] msgContent: [" + byteArray + "]");
            }
            GroupInvite$GroupInviteMsgBody groupInvite$GroupInviteMsgBody = new GroupInvite$GroupInviteMsgBody();
            try {
                groupInvite$GroupInviteMsgBody.mergeFrom(byteArray);
                AVNotifyCenter aVNotifyCenter2 = ((QQAppInterface) peekAppRuntime).getAVNotifyCenter();
                int i16 = groupInvite$GroupInviteMsgBody.video_msg_type.get();
                int i17 = groupInvite$GroupInviteMsgBody.relation_type.get();
                long j19 = groupInvite$GroupInviteMsgBody.relation_id.get();
                int i18 = groupInvite$GroupInviteMsgBody.flag.get();
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            i3 = -1;
                        } else {
                            i3 = 0;
                        }
                    } else {
                        i3 = 3000;
                    }
                } else {
                    i3 = 1;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    aVNotifyCenter = aVNotifyCenter2;
                    sb5.append("handleMultiOfflineMsg, msgType: [");
                    sb5.append(i16);
                    sb5.append("] uinType: [");
                    sb5.append(i3);
                    sb5.append("] relationType: [");
                    sb5.append(i17);
                    sb5.append("] relationId: [");
                    sb5.append(j19);
                    sb5.append("] avType: [");
                    sb5.append(i18);
                    sb5.append("]");
                    QLog.d("QAVOfflineMsgHelper", 2, sb5.toString());
                } else {
                    aVNotifyCenter = aVNotifyCenter2;
                }
                if (i3 != -1) {
                    if (i3 != 1 && i3 != 3000) {
                        if (i3 == 0) {
                            if (!((QQAppInterface) peekAppRuntime).getCurrentAccountUin().equals(String.valueOf(j17))) {
                                valueOf = String.valueOf(j17);
                            } else {
                                valueOf = String.valueOf(j19);
                            }
                            if (TextUtils.isEmpty(valueOf)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("QAVOfflineMsgHelper", 2, "handleMultiOfflineMsg friendUin is empty!");
                                    return;
                                }
                                return;
                            }
                            if (j16 > 0 && j16 - NetConnInfoCenter.getServerTime() > 60000) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                VideoMsgTools.l((QQAppInterface) peekAppRuntime, 0, 6, true, valueOf, String.valueOf(j17), false, null, false, msg2);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("QAVOfflineMsgHelper", 2, "handleMultiOfflineMsg double meeting friendUin is:" + valueOf);
                            }
                            if (j16 == 0) {
                                j3 = com.tencent.mobileqq.service.message.e.K0();
                            } else {
                                j3 = j16;
                            }
                            ((QQAppInterface) peekAppRuntime).getGAudioHandler().c(msg2, valueOf, j3);
                            return;
                        }
                        return;
                    }
                    VideoMsgTools.m((QQAppInterface) peekAppRuntime, i3, 13, false, String.valueOf(j19), String.valueOf(j17), false, null, false, i18, Long.valueOf(j16), Long.valueOf(j18));
                    aVNotifyCenter.W0(j19, 1, 10, true);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("QAVOfflineMsgHelper", 2, "handleMultiOfflineMsg exception ", e16);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("QAVOfflineMsgHelper", 2, "handleMultiOfflineMsg: hasBody: " + msg2.body.has() + ", hasMsgContent " + msg2.body.msg_content.has());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d(MessageHandler mh5, nt_msg_common$Msg msg2, long fromUin, long selfUin, long timeInterval, byte[] msgSharpContent, boolean isSharpRequest) {
        int i3;
        int i16;
        boolean z16;
        if (isSharpRequest) {
            String valueOf = String.valueOf(fromUin);
            String valueOf2 = String.valueOf(selfUin);
            hd_video_2$MsgBody hd_video_2_msgbody = new hd_video_2$MsgBody();
            try {
                hd_video_2_msgbody.mergeFrom(msgSharpContent);
                i3 = hd_video_2_msgbody.msg_invite_body.uint32_new_business_flag.get();
                try {
                } catch (Exception e16) {
                    e = e16;
                    i16 = 0;
                    e.printStackTrace();
                    if (-1 != i3) {
                    }
                    o.k(selfUin, fromUin, 208);
                    if (QLog.isColorLevel()) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                i3 = -1;
            }
            if (hd_video_2_msgbody.msg_invite_body.msg_temp_session.has()) {
                if (hd_video_2_msgbody.msg_invite_body.msg_temp_session.uint32_relationship_type.has()) {
                    int s16 = r.s(hd_video_2_msgbody.msg_invite_body.msg_temp_session.uint32_relationship_type.get(), false, 1);
                    if (s16 != -1) {
                        i16 = s16;
                    } else {
                        i16 = 0;
                    }
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d("QAVOfflineMsgHelper", 2, "uinType" + i16 + " translateType:" + s16);
                        }
                    } catch (Exception e18) {
                        e = e18;
                        e.printStackTrace();
                        if (-1 != i3) {
                        }
                        o.k(selfUin, fromUin, 208);
                        if (QLog.isColorLevel()) {
                        }
                    }
                    if (-1 != i3) {
                        VideoMsgTools.l(mh5.Q, 0, 6, true, valueOf, valueOf2, false, null, false, msg2);
                    } else {
                        String valueOf3 = String.valueOf(fromUin);
                        if (i3 == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        VideoMsgTools.l(mh5.Q, i16, 6, z16, valueOf, valueOf3, false, null, false, msg2);
                    }
                    o.k(selfUin, fromUin, 208);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("QAVOfflineMsgHelper", 2, "msg_temp_session not include");
            }
            i16 = 0;
            if (-1 != i3) {
            }
            o.k(selfUin, fromUin, 208);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QAVOfflineMsgHelper", 2, "Discard video message because of time out " + timeInterval + " s");
        }
    }

    private final boolean e(long type, long subType) {
        if (type == 528 && subType == 344) {
            return true;
        }
        return false;
    }

    private final boolean f(long type, long subType) {
        if (type == 528 && subType == 329) {
            return true;
        }
        return false;
    }

    private final boolean g(long type, long subType) {
        if (!e(type, subType) && !f(type, subType)) {
            return false;
        }
        return true;
    }

    public final void a(long msgType, long msgSubType, @NotNull nt_msg_common$Msg msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.d("QAVOfflineMsgHelper", 2, "decodeCommonPush type:" + msgType + ", subType:" + msgSubType);
        }
        if (!g(msgType, msgSubType)) {
            return;
        }
        if (e(msgType, msgSubType)) {
            QLog.d("QAVOfflineMsgHelper", 2, "dispatchAVMsg isDavOfflineMsg");
            b(msg2);
        } else if (f(msgType, msgSubType)) {
            QLog.d("QAVOfflineMsgHelper", 2, "dispatchAVMsg isMultiOfflineMsg");
            c(msg2);
        }
    }
}
