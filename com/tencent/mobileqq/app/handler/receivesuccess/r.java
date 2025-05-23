package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb31.oidb_0xb31$RspBody;
import tencent.im.oidb.cmd0xb31.oidb_0xb31$SimilarItem;

/* compiled from: P */
/* loaded from: classes11.dex */
public class r {
    static IPatchRedirector $redirector_;

    private static void a(QQAppInterface qQAppInterface, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow.");
        }
        long j3 = toServiceMsg.extraData.getLong("toUin");
        oidb_0xb31$RspBody oidb_0xb31_rspbody = new oidb_0xb31$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xb31_rspbody);
        if (parseOIDBPkg == 0) {
            if (oidb_0xb31_rspbody.items.has()) {
                List<oidb_0xb31$SimilarItem> list = oidb_0xb31_rspbody.items.get();
                if (list != null && !list.isEmpty()) {
                    oidb_0xb31$SimilarItem oidb_0xb31_similaritem = list.get(0);
                    if (oidb_0xb31_similaritem != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (oidb_0xb31_similaritem.icon_url.has()) {
                                jSONObject.put("icon_url", oidb_0xb31_similaritem.icon_url.get());
                            }
                            if (oidb_0xb31_similaritem.jump_url.has()) {
                                jSONObject.put("jump_url", oidb_0xb31_similaritem.jump_url.get());
                            }
                            if (oidb_0xb31_similaritem.name.has()) {
                                jSONObject.put("name", oidb_0xb31_similaritem.name.get());
                            }
                            if (oidb_0xb31_similaritem.sub_title.has()) {
                                jSONObject.put("sub_title", oidb_0xb31_similaritem.sub_title.get());
                            }
                            if (oidb_0xb31_similaritem.title.has()) {
                                jSONObject.put("title", oidb_0xb31_similaritem.title.get());
                            }
                            if (oidb_0xb31_similaritem.type.has()) {
                                jSONObject.put("type", oidb_0xb31_similaritem.type.get());
                            }
                            if (oidb_0xb31_similaritem.url.has()) {
                                jSONObject.put("url", oidb_0xb31_similaritem.url.get());
                            }
                            if (oidb_0xb31_similaritem.show_both_head.has()) {
                                jSONObject.put("show_both_head", oidb_0xb31_similaritem.show_both_head.get());
                            }
                            jSONObject.put("friend_uin", j3);
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow content is: " + jSONObject.toString());
                            }
                            ((INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class)).insertCommonHobbyForAIOShowNewsMsg(jSONObject.toString(), String.valueOf(j3));
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow exception: " + QLog.getStackTraceString(e16));
                            }
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow index == 0 item is null.");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items is empty.");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow items not has.");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleGetCommonHobbyForAIOShow. result is: " + parseOIDBPkg);
        }
    }

    public static void b(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, String str) {
        if ("OidbSvc.0xb31".equalsIgnoreCase(str)) {
            a(messageHandler.Q, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
